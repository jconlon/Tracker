/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.monitor.MonitorAdmin;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireAdmin;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Component implements WireAdminListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);
	final static String PLUGIN_ID = "com.verticon.tracker.irouter.monitor.view";
	static Component INSTANCE;
	private Set<Node> model;
	private WireAdminListener listener;
	private WireAdmin wireAdmin;
	private MonitorAdmin monitorAdmin;// THis is failing to start

	/**
	 * @return the monitorAdmin
	 */
	MonitorAdmin getMonitorAdmin() {
		return monitorAdmin;
	}

	public void setListener(WireAdminListener listener) {
		this.listener = listener;
	}

	@SuppressWarnings("unchecked")
	public Component() {
		super();
		if (Realm.getDefault() == null) {
			model = new WritableSet(new Realm() {

				@Override
				public boolean isCurrent() {
					return true;
				}
			});
		} else {
			model = new WritableSet();
		}
	}

	public Set<Node> getModel() {
		return model;
	}

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;

	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	public void activate() {
		INSTANCE = this;
		logger.debug(bundleMarker, "Started");
	}

	public void deactivate() {
		logger.debug(bundleMarker, "deactivate entered");
		INSTANCE = null;
	}

	public void setWireAdmin(WireAdmin wireAdmin) {
		logger.debug(bundleMarker, "wireAdmin set");
		this.wireAdmin = wireAdmin;
	}

	public void unsetWireAdmin(WireAdmin wireAdmin) {
		this.wireAdmin = null;
	}

	public void setMonitorAdmin(MonitorAdmin monitorAdmin) {
		logger.debug(bundleMarker, "monitorAdmin set");
		this.monitorAdmin = monitorAdmin;
	}

	public void unsetMonitorAdmin(MonitorAdmin monitorAdmin) {
		logger.debug(bundleMarker, "monitorAdmin unset");
		this.monitorAdmin = null;
	}

	public Wire[] getWires() {
		try {
			return wireAdmin.getWires(null);
		} catch (InvalidSyntaxException e) {
			return null;// wont happen
		}

	}

	@Override
	public void wireAdminEvent(WireAdminEvent event) {
		if (listener != null) {
			listener.wireAdminEvent(event);
		} else {
			logger.warn(bundleMarker, "Listener is null");
		}
	}

	String status() {
		return wireAdmin == null ? "WireAdmin is unset" : "Wires="
				+ getWires().length;
	}

	public synchronized void setProducer(Producer producer,
			Map<String, Object> map) {
		ProducerWiredNode child = new ProducerWiredNode(map);
		addToModel(child);
	}

	public synchronized void unsetProducer(Producer producer,
			Map<String, Object> map) {
		ProducerWiredNode child = new ProducerWiredNode(map);
		removeFromModel(child);
	}

	public synchronized void setConsumer(Consumer consumer,
			Map<String, Object> map) {
		ConsumerWiredNode child = new ConsumerWiredNode(map);
		addToModel(child);
	}

	public synchronized void unsetConsumer(Consumer consumer,
			Map<String, Object> map) {
		ConsumerWiredNode child = new ConsumerWiredNode(map);
		removeFromModel(child);
	}

	private void removeFromModel(WiredNode child) {
		logger.debug(bundleMarker, "Removing... {}", child);
		WiredNode existingWiredNode = findWireNode(child.getPid());
		if (existingWiredNode != null) {
			logger.debug(bundleMarker, "Removing simple {}", existingWiredNode);
			boolean result = model.remove(existingWiredNode);
			if (result) {
				logger.debug(bundleMarker, "Removed {}", child);
			} else {
				logger.error(bundleMarker, "Failed to remove simple {}", child);
			}
			return;
		}
		logger.debug(bundleMarker,
				"Removing ComponentServices containing... {}", child);
		ComponentServices componentServices = findComponentServicesNode(child
				.getPid());
		if (componentServices == null) {
			logger.error(bundleMarker,
					"Failed to find ComponentServices for {}", child);
			return;
		}
		// Remove this node but save and add all the other services back
		Vector<WiredNode> nodesToKeep = new Vector<WiredNode>(5);
		for (WiredNode wiredNode : componentServices.getChildren()) {
			if (!wiredNode.getService_id().equals(child.getService_id())) {
				nodesToKeep.add(wiredNode);
			}
		}
		boolean result = model.remove(componentServices);
		if (result) {
			logger.debug(bundleMarker, "Removed {}", componentServices);
		} else {
			logger.error(bundleMarker, "Failed to remove {}", componentServices);
			return;
		}
		logger.debug(bundleMarker, "Adding back... {}", nodesToKeep);
		for (WiredNode wiredNode : nodesToKeep) {
			wiredNode.setParent(null);
		}
		result = model.addAll(nodesToKeep);
		if (result) {
			logger.debug(bundleMarker, "Added back {}", nodesToKeep);
		} else {
			logger.error(bundleMarker, "Failed to add back {}", nodesToKeep);
		}

	}

	private void addToModel(WiredNode child) {
		logger.debug(bundleMarker, "Adding... {}", child);
		WiredNode existingWiredNode = findWireNode(child.getPid());
		boolean results = false;
		if (existingWiredNode != null) {
			logger.debug(bundleMarker,
					"Creating Container with existing... {}", existingWiredNode);

			results = model.remove(existingWiredNode);
			if (results) {
				logger.debug(bundleMarker, "Removing existing {}",
						existingWiredNode);
			} else {
				logger.error(bundleMarker, "Failed to remove existing {} ",
						existingWiredNode);
			}
			Node parent = new ComponentServices(child, existingWiredNode);
			results = model.add(parent);
			if (results) {
				logger.debug(bundleMarker, "Added {} ", parent);
			} else {
				logger.error(bundleMarker, "Failed to add {} ", parent);
			}
		} else {
			results = model.add(child);
			if (results) {
				logger.debug(bundleMarker, "Added {}", child);
			} else {
				logger.error(bundleMarker, "Failed to add {}", child);
			}
		}
	}

	/**
	 * Get the node from the model
	 * 
	 * @param pid
	 * @return wiredNode
	 */
	private WiredNode findWireNode(String pid) {
		for (Node node : model) {
			if (node.getPid().equals(pid) && (node instanceof WiredNode)) {
				return (WiredNode) node;
			}
		}
		return null;
	}

	/**
	 * Get the node from the model
	 * 
	 * @param pid
	 * @return wiredNode or componentServices
	 */
	private ComponentServices findComponentServicesNode(String pid) {
		for (Node node : model) {
			if (node instanceof ComponentServices) {
				if (node.getPid().equals(pid)) {
					logger.debug(bundleMarker, "Component Services found: {}",
							node);
					return (ComponentServices) node;
				}
			}
		}
		logger.warn(bundleMarker,
				"Component Services was not found for pid={}", pid);
		return null;
	}
}
