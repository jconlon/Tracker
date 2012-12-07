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

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.Assert;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.monitor.MonitorAdmin;
import org.osgi.service.monitor.Monitorable;
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

/**
 * Uses a singlethreaded executor to manage the monitor view, services and the 
 * data model.
 * @author jconlon
 *
 */
public class Component implements WireAdminListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);
	final static String PLUGIN_ID = "com.verticon.tracker.irouter.monitor.view";
	static Component INSTANCE;
	
	private Set<INode> model;
	private WireAdminListener listener;
	private WireAdmin wireAdmin;
	private MonitorAdmin monitorAdmin;
	
	private ExecutorService exec = Executors.newSingleThreadExecutor();

	/**
	 * @return the monitorAdmin
	 */
	MonitorAdmin getMonitorAdmin() {
		return monitorAdmin;
	}

	void setListener(WireAdminListener listener) {
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

	public Set<INode> getModel() {
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

	public void setWireAdmin(final WireAdmin wireAdminIn) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						logger.debug(bundleMarker, "wireAdmin set");
						wireAdmin = wireAdminIn;
						return null;
					}});
		
		
	}

	public void unsetWireAdmin(WireAdmin wireAdminIn) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						wireAdmin = null;
						return null;
					}});
		
	}

	public void setMonitorAdmin(final MonitorAdmin monitorAdminIn) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						logger.debug(bundleMarker, "monitorAdmin set");
						monitorAdmin = monitorAdminIn;
						return null;
					}});
		
	}

	public void unsetMonitorAdmin(MonitorAdmin monitorAdminIn) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						logger.debug(bundleMarker, "monitorAdmin unset");
						monitorAdmin = null;
						return null;
					}});
	}
	
	@Override
	public void wireAdminEvent(final WireAdminEvent event) {
		exec.submit(
				new Callable<Void>(){


					@Override
					public Void call() throws Exception {
						if (listener != null) {
							listener.wireAdminEvent(event);
						} else {
							logger.warn(bundleMarker, "Listener is null");
						}
						return null;
					}

				});
	}

	public void setMonitorable(Monitorable monitorable,
			final Map<String, Object> map) {
		
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						IExternalNode child = ExternalNodeUtils.getInstance(map);
						addToModel(child);
						return null;
					}
					
				}
		);
		
	}

	public void unsetMonitorable(Monitorable monitorable,
			final Map<String, Object> map) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						IExternalNode child = ExternalNodeUtils.getInstance(map);
						removeFromModel(child);
						return null;
					}
				}
		);
		
	}
	
	public void setProducer(Producer producer,
			final Map<String, Object> map) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						ProducerWiredNode child = new ProducerWiredNode(map);
						addToModel(child);
						return null;
					}
					
				}
		);
		
	}

	public void unsetProducer(Producer producer,
			final Map<String, Object> map) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						ProducerWiredNode child = new ProducerWiredNode(map);
						removeFromModel(child);
						return null;
					}
					
				}
		);
		
	}

	public void setConsumer(Consumer consumer,
			final Map<String, Object> map) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						ConsumerWiredNode child = new ConsumerWiredNode(map);
						addToModel(child);
						return null;
					}
					
				}
		);
		
	}

	public void unsetConsumer(Consumer consumer,
			final Map<String, Object> map) {
		exec.submit(
				new Callable<Void>(){

					@Override
					public Void call() throws Exception {
						ConsumerWiredNode child = new ConsumerWiredNode(map);
						removeFromModel(child);
						return null;
					}

				}
		);

	}

	Wire[] getWires() {
		if(wireAdmin!=null){
			try {

				return wireAdmin.getWires(null);
			} catch (InvalidSyntaxException e) {

			}
		}
		return new Wire[] {};
	}



	String status() {
		return wireAdmin == null ? "WireAdmin is unset" : "Wires="
			+ getWires().length;
	}
	
	private void removeFromModel(IExternalNode child) {
		logger.debug(bundleMarker, "Removing... {}", child);
		boolean result = model.remove(child);
		if (result) {
			logger.debug(bundleMarker, "Removed {}", child);
		} else {
			logger.error(bundleMarker, "Failed to remove simple {}", child);
		}
		return;
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
		Assert.isTrue(componentServices.getChildren().length > 1,
				"ComponentServices must have more than one child."); //$NON-NLS-1$
		
		// Remove this node but save and add all the other services back
		
		Collection<WiredNode> nodesToKeep = componentServices.getSiblings(child.getService_id());

		Assert.isTrue(componentServices.getChildren().length > 1,
		"Nodes to keep must have more than one child."); //$NON-NLS-1$

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

	private void addToModel(IExternalNode child) {
		logger.debug(bundleMarker, "Adding... {}", child);
		boolean results = model.add(child);
		if (results) {
			logger.debug(bundleMarker, "Added {}", child);
		} else {
			logger.error(bundleMarker, "Failed to add {}", child);
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
				logger.debug(bundleMarker, "Removed existing {}",
						existingWiredNode);
			} else {
				logger.error(bundleMarker, "Failed to remove existing {} ",
						existingWiredNode);
			}
			INode parent = new ComponentServices(child, existingWiredNode);
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
		for (INode node : model) {
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
		for (INode node : model) {
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
