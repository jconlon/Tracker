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

import static com.verticon.tracker.irouter.monitor.view.internal.Component.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.ObservableSet;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WiredNodeGraphEntityContentProvider implements
		IGraphEntityContentProvider, WireAdminListener, ISetChangeListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(WiredNodeGraphEntityContentProvider.class);

	private Set<WiredNode> model;
	private StructuredViewer viewer;
	private final MonitorMasterDetailsBlock masterDetail;

	WiredNodeGraphEntityContentProvider( MonitorMasterDetailsBlock masterDetail) {
		super();
		this.masterDetail =masterDetail;
	}

	@Override
	public void dispose() {
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (StructuredViewer) viewer;
		if (model != null) {
			((ObservableSet) model).removeSetChangeListener(this);
		} else {
			Component.INSTANCE.setListener(this);// Set this as a listener on
													// the component only once
		}
		model = (Set<WiredNode>) newInput;
		if (model != null) {
			((ObservableSet) model).addSetChangeListener(this);
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (model != null) {
			WiredNode[] elements = new WiredNode[model.size()];
			return model.toArray(elements);
		}

		return null;
	}

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof WiredNode) {
			WiredNode wiredNode = (WiredNode) entity;
			if (wiredNode.isProducer()) {
				WiredNode[] consumers = getConsumers(wiredNode);
				logger.debug(bundleMarker, "{} connectedTo {}", wiredNode,
						Arrays.toString(consumers));
				return consumers;
			}
		}
		return null;
	}

	private WiredNode[] getConsumers(WiredNode producer) {
		Set<WiredNode> consumers = new HashSet<WiredNode>();
		String producerPid = producer.getPid();
		Wire[] wires = Component.INSTANCE.getWires();
		if(wires!=null){	
			for (Wire wire : wires) {
				String wirePid = (String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID);
				if (producerPid.equals(wirePid)) {
					String consumerPid = (String) wire.getProperties().get(
							WIREADMIN_CONSUMER_PID);
					WiredNode consumer = findConsumer(consumerPid);
					if (consumer != null) {
						consumers.add(consumer);
					}
				}
			}
		}
		if (!consumers.isEmpty()) {
			WiredNode[] results = new WiredNode[consumers.size()];
			return consumers.toArray(results);
		}
		return null;
	}

	/**
	 * Find the producer associated with the wire
	 * 
	 * @param wire
	 * @return producer
	 */
	private WiredNode findProducer(Wire wire) {
		String wirePid = (String) wire.getProperties().get(
				WIREADMIN_PRODUCER_PID);
		for (WiredNode wiredNode : Component.INSTANCE.getModel()) {
			if (wiredNode.isProducer() && wiredNode.getPid().equals(wirePid)) {
				return wiredNode;
			}

		}
		return null;

	}

	private WiredNode findConsumer(String pid) {
		for (WiredNode wiredNode : model) {

			if (!wiredNode.isProducer() && wiredNode.getPid().equals(pid)) {
				return wiredNode;
			}
		}
		return null;
	}

	@Override
	public void wireAdminEvent(WireAdminEvent event) {
		switch (event.getType()) {
		case WireAdminEvent.WIRE_CONNECTED:
			logger.debug(bundleMarker, "Wire connected scope={}", event
					.getWire().getScope());
			final WiredNode effectedProducer = findProducer(event.getWire());
			if (effectedProducer == null) {
				logger.warn(bundleMarker,
						"Could not find a producer for wire {}",
						event.getWire());
				return;
			}
			if (event.getWire().getScope() == null
					|| event.getWire().getScope().length == 0) {
				logger.error(bundleMarker,
						"Could not find a wireScope for wire {}",
						event.getWire());
				return;
			}
			logger.debug(bundleMarker, "Wire connected, refreshing  {}",
					effectedProducer);
			Display.getCurrent().syncExec(new Runnable() {
				public void run() {
					viewer.refresh(effectedProducer, false);

					logger.debug(bundleMarker, "Wire connected, refreshed  {}",
							effectedProducer);
				}
			});
			break;

		case WireAdminEvent.WIRE_DELETED:
			logger.debug(bundleMarker, "Wire deleted scope={}", event.getWire()
					.getScope());
			// Handle connection or deletion of connection on the viewer
			// by finding and refreshing the appropriate producer
			final WiredNode effectedProducer2 = findProducer(event.getWire());
			logger.debug(bundleMarker, "Wire deleted, refreshing {}",
					effectedProducer2);
			Display.getCurrent().syncExec(new Runnable() {
				public void run() {
					viewer.refresh(effectedProducer2, false);
					logger.debug(bundleMarker, "Wire deleted, refreshed  {}",
							effectedProducer2);
				}
			});
			break;

		case WireAdminEvent.WIRE_CREATED:
			logger.debug(bundleMarker, "Wire created scope={} (ignoring)",
					event.getWire().getScope());
			// Do nothing
			break;

		case WireAdminEvent.WIRE_UPDATED:
			logger.debug(bundleMarker, "Wire updated scope={} (ignoring)",
					event.getWire().getScope());
			// Do nothing
			break;

		case WireAdminEvent.WIRE_TRACE:
			logger.debug(bundleMarker, "Wire trace scope={} (ignoring)", event
					.getWire().getScope());
			// Do nothing
			break;
		case WireAdminEvent.CONSUMER_EXCEPTION:
			logger.error(bundleMarker,
					"Wire consumer exception scope={} (ignoring)", event
							.getWire().getScope(), event.getThrowable());
			// Do nothing
			break;
		case WireAdminEvent.PRODUCER_EXCEPTION:
			logger.error(bundleMarker,
					"Wire producer exception scope={} (ignoring)", event
							.getWire().getScope(), event.getThrowable());
			// Do nothing
			break;
		case WireAdminEvent.WIRE_DISCONNECTED:
			logger.warn(bundleMarker, "Wire disconnected wire={} (ignoring)",
					event.getWire());
			// Do nothing
			break;
		default:
			logger.debug(bundleMarker, "Wire default scope={} eventType={}",
					event.getWire().getScope(), event.getType());
			break;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleSetChange(SetChangeEvent event) {
		logger.debug(bundleMarker, "Handling set change {}", event);
		SetDiff dif = event.diff;
		// Handle additions and removals of WiredNode nodes on the viewer
		add(dif.getAdditions());
		remove(dif.getRemovals());
	}

	/**
	 * This should also remove any pages
	 * @param wiredNodes
	 */
	private void remove(final Set<WiredNode> wiredNodes) {
		if (wiredNodes == null) {
			return;
		}
		Display.getCurrent().syncExec(new Runnable() {
			public void run() {
				for (WiredNode wiredNode : wiredNodes) {
					((GraphViewer) viewer).removeNode(wiredNode);
					masterDetail.removePage(wiredNode);
					logger.debug(bundleMarker, "Removed {}", wiredNode);
				}
				((GraphViewer) viewer).applyLayout();
			}
		});

	}

	private void add(final Set<WiredNode> wiredNodes) {
		if (wiredNodes == null) {
			return;
		}
		Display.getCurrent().syncExec(new Runnable() {
			public void run() {
				for (WiredNode wiredNode : wiredNodes) {
					((GraphViewer) viewer).addNode(wiredNode);
					// viewer.refresh(wiredNode,false);
					logger.debug(bundleMarker, "Added {}", wiredNode);
				}
				((GraphViewer) viewer).applyLayout();
			}
		});

	}

}
