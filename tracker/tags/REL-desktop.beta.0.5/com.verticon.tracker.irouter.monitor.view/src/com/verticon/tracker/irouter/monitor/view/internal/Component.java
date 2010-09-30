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
	private Set<WiredNode> model2 ;
	private WireAdminListener listener;
	private WireAdmin wireAdmin;
	private MonitorAdmin monitorAdmin;//THis is failing to start

	
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
		if(Realm.getDefault() ==null){
			model2= new WritableSet(new Realm(){

				@Override
				public boolean isCurrent() {
					return true;
				}});
		}else{
			model2= new WritableSet();
		}
	}



	public  Set<WiredNode> getModel() {
		return model2;
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
		logger.debug(bundleMarker,"Started");
	}

	public void deactivate() {
		logger.debug(bundleMarker, "deactivate entered");
		INSTANCE = null;
	}

	public void setWireAdmin(WireAdmin wireAdmin) {
		logger.debug(bundleMarker, "wireAdmin set");
		this.wireAdmin=wireAdmin;
	}

	public void unsetWireAdmin(WireAdmin wireAdmin){
		this.wireAdmin=null;
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
			return null;//wont happen
		}
		
	}

	@Override
	public  void wireAdminEvent(WireAdminEvent event) {
		if(listener!=null){
			listener.wireAdminEvent(event);
		}else{
			logger.warn(bundleMarker, "Listener is null");
		}
	}

	String status(){
		return wireAdmin==null?"WireAdmin is unset":"Wires="+getWires().length;
	}

	
	public void setProducer(Producer producer, Map<String, Object> map) {
		boolean added = model2.add(new WiredNode(map));
		if(added){
			logger.debug(bundleMarker, "Added producer {}",map.get("service.pid"));
		}else{
			logger.error(bundleMarker, "Failed to add producer {}",map.get("service.pid"));
		}
	}

	public  void unsetProducer(Producer producer, Map<String, Object> map){
		boolean removed = model2.remove(new WiredNode(map));
		if(removed){
			logger.debug(bundleMarker, "Removed producer {}",map.get("service.pid"));
		}else{
			logger.error(bundleMarker, "Failed to remove producer {}",map.get("service.pid"));
		}
	}
	
	public  void setConsumer(Consumer consumer, Map<String, Object> map){
		boolean added = model2.add(new WiredNode(map));
		if(added){
			logger.debug(bundleMarker, "Added consumer {}",map.get("service.pid"));
		}else{
			logger.error(bundleMarker, "Failed to add consumer {}",map.get("service.pid"));
		}
	}
	
	public  void unsetConsumer(Consumer consumer, Map<String, Object> map){
		boolean removed = model2.remove(new WiredNode(map));
		if(removed){
			logger.debug(bundleMarker, "Removed consumer {}",map.get("service.pid"));
		}else{
			logger.error(bundleMarker, "Failed to remove consumer {}",map.get("service.pid"));
		}
	}
	
	
}
