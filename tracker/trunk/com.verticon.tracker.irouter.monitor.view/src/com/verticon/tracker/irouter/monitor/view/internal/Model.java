package com.verticon.tracker.irouter.monitor.view.internal;

import static com.verticon.tracker.irouter.monitor.view.internal.Component.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jconlon
 *
 */
public class Model {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Model.class);
	
	private volatile ModelListener listener;
	
	
	ComponentServices[] getNodeContainers(){
		return ComponentServices.getInstances();
	}
	
	Node[] getAllNodes(){
		Vector<Node> allNodes = new Vector<Node>();
		for (ComponentServices container : getNodeContainers()) {
			allNodes.addAll(Arrays.asList(container.getChildren()));
		}
		Node[] out = new Node[allNodes.size()];
		return allNodes.toArray(out);
	}
	
    ComponentServices setProducer(Map<String, Object> map) {
		WiredNode child = new ProducerWiredNode(map);
		return add(child);
	}

    ComponentServices unsetProducer(Map<String, Object> map){
		WiredNode child = new ProducerWiredNode(map);
		return remove(child);
	}
	
    ComponentServices setConsumer(Map<String, Object> map){
		WiredNode child = new ConsumerWiredNode(map);
		return add(child);
	}
	
	 ComponentServices unsetConsumer(Map<String, Object> map){
		WiredNode child = new ConsumerWiredNode(map);
		return remove(child);
	}


	private ComponentServices remove(WiredNode child) {
		ComponentServices container = ComponentServices.remove(child);
		if(container==null){
			logger.debug(bundleMarker, "Removed {} and its container",child);
		}else{
			logger.debug(bundleMarker, "Removed {} from {}",child,container);
			
		}
		if(listener!=null){
			listener.refresh(container);
		}
		return container;
	}
	 
	private ComponentServices add(WiredNode child) {
			ComponentServices container =  ComponentServices.add(child);
			logger.debug(bundleMarker, "Added {} to {}",child, container);
			if(listener!=null){
				listener.refresh(container);
			}
			return container;
	}


	public void setListener(ModelListener listener) {
		this.listener = listener;
	}
	
}
