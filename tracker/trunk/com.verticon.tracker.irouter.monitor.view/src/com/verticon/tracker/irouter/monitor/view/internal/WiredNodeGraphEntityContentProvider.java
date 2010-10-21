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
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.ObservableSet;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.INestedContentProvider;
import org.eclipse.zest.core.widgets.GraphItem;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WiredNodeGraphEntityContentProvider implements
		IGraphEntityContentProvider, WireAdminListener, ISetChangeListener,INestedContentProvider  {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(WiredNodeGraphEntityContentProvider.class);

	private Set<Node> model;
	private StructuredViewer viewer;
	private final MonitorMasterDetailsBlock masterDetail;
	private Display display;

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
//		super.inputChanged(viewer, oldInput, newInput);
		this.viewer = (StructuredViewer) viewer;
		try {
			display=viewer.getControl().getDisplay();
		} catch (Exception e) {
			display= null;
		}
		if (model != null) {
			((ObservableSet) model).removeSetChangeListener(this);
		} else {
			Component.INSTANCE.setListener(this);// Set this as a listener on
													// the component only once
		}
		model = (Set<Node>) newInput;
		if (model != null) {
			((ObservableSet) model).addSetChangeListener(this);
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (model != null) {
			return  (Object[]) model.toArray(new Object[0]);
		}

		return null;
	}

	@Override
	public Object[] getConnectedTo(Object entity) {
//		logger.debug(bundleMarker, "Getting connectedTo {}", entity);
		
		if (entity instanceof ProducerWiredNode) {
			
			ProducerWiredNode producerWireNode = (ProducerWiredNode) entity;
			if(producerWireNode.getParent()==null){
				logger.debug(bundleMarker, "Getting connections from standalone {}", entity);
				Node[] consumers = getConsumers(producerWireNode.getPid());
				logger.debug(bundleMarker, "{} connectedTo {}", producerWireNode,
						Arrays.toString(consumers));
				return consumers;
			}
			
		}
		if (entity instanceof ComponentServices){
			logger.debug(bundleMarker, "Getting connections for {}", entity);
			String pid = ((Node)entity).getPid();
			Node[] consumers =  getConsumers(pid);
			logger.debug(bundleMarker, "{} connectedTo {}", entity,
					Arrays.toString(consumers));
			return consumers;
			
		}
		return new Object[]{};
	
	}


	
	/**
	 * 
	 * @return ComponentServices containers and standalone consumers
	 */
	private Node[] getConsumers(String producerPid) {
		if(producerPid==null){
			return new Node[]{};
		}
		Set<Node> consumers = new HashSet<Node>();
		Wire[] wires = Component.INSTANCE.getWires();
		if(wires==null){	
			logger.debug(bundleMarker,
					"Could not find any wires");
		}else{
			for (Wire wire : wires) {
				String wirePid = (String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID);
				if (producerPid.equals(wirePid)) {
					String consumerPid = (String) wire.getProperties().get(
							WIREADMIN_CONSUMER_PID);
					Node consumer = findConsumer(consumerPid);
					//Consumer may be standalone or in a container
					if (consumer != null) {
						Node parent = consumer.getParent();
						if(parent!=null){
						  consumers.add(parent);
						}else{
						  consumers.add(consumer);
						}
					}
				}
			}
		}
		if (!consumers.isEmpty()) {
			return (Node[]) consumers.toArray(new Node[0]);
		}
		return  new Node[]{};
	}

	/**
	 * Find the producer or container associated with the wire
	 * 
	 * @param wire
	 * @return producer
	 */
	private Node findProducer(Wire wire) {
		String wirePid = (String) wire.getProperties().get(
				WIREADMIN_PRODUCER_PID);
		for (Node node : model) {
			if (node instanceof ProducerWiredNode && node.getPid().equals(wirePid)) {
				return  node;
			}
			
			if (node instanceof ComponentServices && node.getPid().equals(wirePid)) {
				return  node;
			}

		}
		return null;

	}

	private Node findConsumer(String pid) {
		for (Node node : model) {
			if ((node.getPid().equals(pid))) {
				return node;
			}
		}
		return null;
	}

	@Override
	public void wireAdminEvent(WireAdminEvent event) {
		if (display==null || display.isDisposed()) {
			return;
		}
		switch (event.getType()) {
		case WireAdminEvent.WIRE_CONNECTED:
			logger.debug(bundleMarker, "Wire connected scope={}", event
					.getWire().getScope());
			final Node effectedProducer = findProducer(event.getWire());
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
			display.syncExec(new Runnable() {
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
			final Node effectedProducer2 = findProducer(event.getWire());
			logger.debug(bundleMarker, "Wire deleted, refreshing {}",
					effectedProducer2);
			display.syncExec(new Runnable() {
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
			logger.debug(bundleMarker, "Wire disconnected wire={} (ignoring)",
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
	 * @param nodes
	 */
	private void remove(final Set<Node> nodes) {
		if (nodes == null|| display==null ||  display.isDisposed()) {
			return;
		}
		display.syncExec(new Runnable() {
			public void run() {
				for (Node node : nodes) {
					try {
						
						GraphItem n = ((GraphViewer) viewer).findGraphItem(node);
						//Workaround for bug 314710 218148 - doesnt (always?) seem to work 
						((GraphViewer) viewer).getGraphControl().setSelection(null);
						n.dispose();
						if(node instanceof WiredNode){
							masterDetail.removePage((WiredNode)node);
						}
						logger.debug(bundleMarker, "Removed {}", node);
						
						//Commented code shows that connections are removed when the node is
//						List c = ((GraphViewer) viewer).getGraphControl().getConnections();
//						System.out.println("Removed "+node);
//						for (Object connection : c) {
//							System.out.println("\t "+connection);
//						}
						
					} catch (SWTException e) {
						logger.error(bundleMarker,"Failed to remove "+node,e);
//						throw e; dont throw this up the stack handle it 
						asyncRefreshViewerWorkaround();
					}
				}
				((GraphViewer) viewer).applyLayout();
			}
		});

	}

	/**
	 * This is a workaround for bug 314710 218148. The element should be added to 
	 * the model Set of objects, so just refresh the graph.
	 */
	private void asyncRefreshViewerWorkaround(){
		display.asyncExec(new Runnable() {
			public void run() {
				((GraphViewer) viewer).refresh();
			}
		});
	}
	
	
	private void add(final Set<Node> nodes) {
		if (nodes == null || display==null || display.isDisposed()) {
			return;
		}

		display.syncExec(new Runnable() {
			public void run() {
				
				for (Node node : nodes) {
					try {
						((GraphViewer) viewer).getGraphControl().setSelection(null);
						((GraphViewer) viewer).addNode(node);
						 viewer.refresh(node,false);
						logger.debug(bundleMarker, "Added {}", node);
					} catch (SWTException e) {
						//FIXME Seeing exceptions thrown if nodes are removed and then added back
						//if services come, go, and come back. 
						//see bug 314710 218148
						logger.warn(bundleMarker,"Failed to add "+node,e);
//						throw e; dont throw this up the stack handle it 
						asyncRefreshViewerWorkaround();
					}
					
				}
				((GraphViewer) viewer).applyLayout();
			}
		});

	}

	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof ComponentServices){
			return true;
		}
		return false;
	}

	@Override
	public Object[] getChildren(Object element) {
		if(element instanceof ComponentServices){
			return ((ComponentServices)element).getChildren();
		}
		return null;
	}
}
