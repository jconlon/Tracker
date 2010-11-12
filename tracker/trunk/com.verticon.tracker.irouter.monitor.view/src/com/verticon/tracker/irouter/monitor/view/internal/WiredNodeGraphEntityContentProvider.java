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

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.verticon.tracker.irouter.monitor.view.internal.Component.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.osgi.service.monitor.MonitorAdmin;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

public class WiredNodeGraphEntityContentProvider implements
		IGraphEntityContentProvider, WireAdminListener, ISetChangeListener,INestedContentProvider  {

	
	private final Logger logger = LoggerFactory
			.getLogger(WiredNodeGraphEntityContentProvider.class);
	private Set<INode> model;
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
		model = (Set<INode>) newInput;
		if (model != null) {
			((ObservableSet) model).addSetChangeListener(this);
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (model != null) {
			return  model.toArray(new Object[0]);
		}

		return null;
	}

	@Override
	public Object[] getConnectedTo(Object entity) {
		logger.debug(bundleMarker, "Getting connectedTo {}", entity);
		
		if (entity instanceof ProducerWiredNode) {
			//Producers connect to consumer nodes, but they can also connect to external
			//nodes
			ProducerWiredNode producerWireNode = (ProducerWiredNode) entity;
			if(producerWireNode.getParent()==null){
				logger.debug(bundleMarker, "Getting connections from standalone {}", entity);
				INode[] consumers = getConnectedToNodes(producerWireNode.getPid());
				logger.debug(bundleMarker, "{} connectedTo {}", producerWireNode,
						Arrays.toString(consumers));
				return consumers;
			}
			
		}
		if(entity instanceof ConsumerWiredNode){
			//Consumers can only connect to external nodes
			String consumerPid = ((ConsumerWiredNode) entity).getPid();
			Collection<IExternalNode> connectedNodes = getConnectedExternalNodes( consumerPid);
			if (!connectedNodes.isEmpty()) {
				return connectedNodes.toArray(new INode[0]);
			}
		}
		if (entity instanceof ComponentServices){
			logger.debug(bundleMarker, "Getting connections for {}", entity);
			String pid = ((INode)entity).getPid();
			INode[] consumers =  getConnectedToNodes(pid);
			logger.debug(bundleMarker, "{} connectedTo {}", entity,
					Arrays.toString(consumers));
			return consumers;
			
		}
		return new Object[]{};
	
	}


	
	/**
	 * 
	 * @return ComponentServices containers and standalone consumers
	 * 
	 */
	private INode[] getConnectedToNodes(String producerPid) {
		if(producerPid==null){
			return new INode[]{};
		}
		Set<INode> connectedNodes = Sets.newHashSet();
		Wire[] wires = Component.INSTANCE.getWires();
		if(wires==null || wires.length==0){	
			logger.debug(bundleMarker,
					"Could not find any wires");
		}else{
			for (Wire wire : wires) {
				String wirePid = (String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID);
				if (producerPid.equals(wirePid)) {
					String consumerPid = (String) wire.getProperties().get(
							WIREADMIN_CONSUMER_PID);
					INode consumer = findConsumer(consumerPid);
					//Consumer may be standalone or in a container
					if (consumer != null) {
						INode parent = consumer.getParent();
						if(parent!=null){
						  connectedNodes.add(parent);
						}else{
						  connectedNodes.add(consumer);
						}
					}
				}
			}
		}
		connectedNodes.addAll(getConnectedExternalNodes( producerPid));
		if (!connectedNodes.isEmpty()) {
			return connectedNodes.toArray(new INode[0]);
		}
		return  new INode[]{};
	}

	/**
	 * Find the producer or container associated with the wire
	 * 
	 * @param wire
	 * @return producer
	 */
	private INode findProducer(Wire wire) {
		String wirePid = (String) wire.getProperties().get(
				WIREADMIN_PRODUCER_PID);
		for (INode node : model) {
			if (node instanceof ProducerWiredNode && node.getPid().equals(wirePid)) {
				return  node;
			}
			
			if (node instanceof ComponentServices && node.getPid().equals(wirePid)) {
				return  node;
			}

		}
		return null;

	}

	private INode findConsumer(String pid) {
		checkArgument(pid!=null,"must not be null");
		checkState(model!=null, "model cannot be null");
		for (INode node : model) {
			if ((node.getPid().equals(pid))) {
				return node;
			}
		}
		return null;
	}
	
	
	
	private Collection<IExternalNode> getConnectedExternalNodes(String connectedFromPid){
		MonitorAdmin monitorAdmin = Component.INSTANCE.getMonitorAdmin();
		if(connectedFromPid==null || monitorAdmin==null ){
			return Collections.emptyList();
		}
		
		Boolean isConnected = true;
		String connectionURI = null;
		for (StatusVariable statusVariable : monitorAdmin.getStatusVariables(connectedFromPid)) {
			//Search for a status producer.Is_Connected
			if(statusVariable.getID().endsWith(".Is_Connected")){
			   isConnected = statusVariable.getBoolean();
			}else if(statusVariable.getID().endsWith(".Connection_URI")){
				connectionURI = statusVariable.getString();
			}
		}

		if(!isConnected || connectionURI == null){
			return Collections.emptyList();
		}

		return findExternalNodes(connectionURI);
	}
	
	/**
	 * Uses google collections, predicates, and functions
	 * @param connectionURI
	 * @return
	 */
	private Collection<IExternalNode> findExternalNodes(String connectionURI){
		//Get all the IExternalNodes from the model of INodes
		Collection<IExternalNode> iexternalNodes = transform(
				filter(model, instanceOf(IExternalNode.class)),//collection of IExternalNodes 
				castToExternaNodeFunction//Transform the iNodes with a cast
		);
		//Get the ones matching the connectionURI
		return Collections2.filter(
				iexternalNodes, 
				new ConnectionURIPredicate(connectionURI));
	}
	
	/**
	 * Google function to do a cast from INode to IExternalNode
	 */
	private static final Function<INode, IExternalNode> castToExternaNodeFunction = new Function<INode, IExternalNode>(){
		@Override
		public IExternalNode apply(INode from) {
			return (IExternalNode) from;
		}};
	
	/**
	 * Predicate to find the connectionURI
	 * @author jconlon
	 *
	 */
	private static class ConnectionURIPredicate implements Predicate<IExternalNode> {
        private final String connectionURI;
        
        private ConnectionURIPredicate(final String connectionURI) {
        	this.connectionURI = checkNotNull(connectionURI);
        }
        public boolean apply(final IExternalNode s) {
            return equal(connectionURI, s.getConnectionURI());//Use a google equal which will handle nulls
        }
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
			final INode effectedProducer = findProducer(event.getWire());
			if (effectedProducer == null) {
				logger.warn(bundleMarker,
						"Could not find a producer for wire {}",
						event.getWire());
				return;
			}
			if (event.getWire().getScope() == null
					|| event.getWire().getScope().length == 0) {
				logger.warn(bundleMarker,
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
			final INode effectedProducer2 = findProducer(event.getWire());
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
	private void remove(final Set<INode> nodes) {
		if (nodes == null|| display==null ||  display.isDisposed()) {
			return;
		}
		display.syncExec(new Runnable() {
			public void run() {
				for (INode node : nodes) {
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
	
	/**
	 * This must be executed inside the UI thread.
	 * @param externalNode
	 */
	private void findNodeConnectingTo(IExternalNode externalNode){
		MonitorAdmin monitorAdmin = Component.INSTANCE.getMonitorAdmin();
		if(monitorAdmin==null || model ==null){
			return;
		}

		String uri = externalNode.getConnectionURI();
		for (INode n : model) {
			
			for (String id : monitorAdmin.getStatusVariableNames(n.getPid())) {
				if(id.endsWith(".Connection_URI")){
					StatusVariable sv = monitorAdmin.getStatusVariable(n.getPid()+"/"+id);
					if(sv!=null && sv.getString().equals(uri)){
						if(n.getParent()==null){
							viewer.refresh(n,false);
						}else{
							viewer.refresh(n.getParent(),false);
						}
					}
				}
			}
		}
	}

	
	private void add(final Set<INode> nodes) {
		if (nodes == null || display==null || display.isDisposed()) {
			return;
		}

		display.syncExec(new Runnable() {
			public void run() {
				
				for (INode node : nodes) {
					try {
						((GraphViewer) viewer).getGraphControl().setSelection(null);
						((GraphViewer) viewer).addNode(node);
						viewer.refresh(node,false);
						logger.debug(bundleMarker, "Added {}", node);
						//An externalNode may have a connection to proxy or gateway
						if(node instanceof IExternalNode){
							findNodeConnectingTo((IExternalNode)node);
						}
					} catch (SWTException e) {
						// Seeing exceptions thrown if nodes are removed and then added back
						//if services come, go, and come back. 
						//see bug 314710 218148
						logger.warn(bundleMarker,"Failed to add "+node,e);
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
