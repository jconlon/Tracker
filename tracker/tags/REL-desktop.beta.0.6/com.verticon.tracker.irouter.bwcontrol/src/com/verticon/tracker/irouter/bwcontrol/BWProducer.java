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
package com.verticon.tracker.irouter.bwcontrol;


import static com.verticon.tracker.irouter.bwcontrol.Component.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A WireAdmin Producer that produces commands to send to
 * a TruTest indicator.  Commands are sent as raw (no envelope)
 * strings.
 * 
 * A Monitorable that offers the the following StatusVariables
 * <ol>
 * <li>command.last</li>
 * <li>command.count</li>
 * <li>wire.count</li>
 * 
 * </ol> 
 * 
 * @author jconlon
 *
 */
class BWProducer implements Producer, Monitorable, Callable<Void>{
	
	

	private static final String COMMAND_LAST = "producer.Last_Command_Sent";
	private static final String WIRES_COUNT = "producer.Connected_Consumers";
	private static final String COMMAND_COUNT = "producer.Total_Commands_Sent";
	
	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(BWProducer.class);
	
	//Shared wires protected with concurrent collection
	private final List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	//Shared String protected with volatile
	private volatile String lastCommand = null;
	private AtomicInteger commandCount = new AtomicInteger();
	private final Component component;
	
	/**
	 * @param context
	 */
	BWProducer(Component component) {
		this.component = component;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BWProducer [pid="+component.getPid() +"]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Producer#consumersConnected(org.osgi.service.wireadmin.Wire[])
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires.clear();
		if(wires!=null){
			this.wires.addAll(Arrays.asList(wires));
		}
		if(this.wires.isEmpty()){
			log.debug(bundleMarker,"{}: Not connected to any wires.",
					this
			);
		}else{
			HashSet<String> consumers = new HashSet<String>();
			for (Wire wire : wires) {
				consumers.add((String)wire.getProperties().get(WIREADMIN_CONSUMER_PID));
					log.debug(bundleMarker,"{}: Connected to {}",
							this, wire.getProperties().get(WIREADMIN_CONSUMER_PID));
				
				
			}
			
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Producer#polled(org.osgi.service.wireadmin.Wire)
	 */
	@Override
	public Object polled(Wire wire) {
					return lastCommand;
	}

   
	
//    /* (non-Javadoc)
//	 * @see com.google.common.util.concurrent.AbstractExecutionThreadService#triggerShutdown()
//	 */
//	@Override
//	protected void triggerShutdown() {
//		log.debug(bundleMarker,"{}: trigger shutdown",this);
////		Thread.currentThread().interrupt();
//		super.triggerShutdown();
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.google.common.util.concurrent.AbstractExecutionThreadService#shutDown()
//	 */
//	@Override
//	protected void shutDown() throws Exception {
//		log.debug(bundleMarker,"{}: shutdown",this);
//		super.shutDown();
//	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{COMMAND_COUNT, COMMAND_LAST,WIRES_COUNT};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		if (COMMAND_LAST.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_SI,
					lastCommand
					);
		}
		
		if (COMMAND_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_CC,
					commandCount.get()
					);
		}
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wires.size()
					);
		}else{
			throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
		}
	}
	
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		if (COMMAND_COUNT.equals(id)){
			commandCount.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (COMMAND_LAST.equals(name)){
			return
			"The last command sent to the TruTest scalehead";
		}
		
		if (COMMAND_COUNT.equals(name)){
			return
			"The number of commands sent to the TruTest scalehead";
		}
		
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected wires.";
		}
		return null;
	}

	@Override
	public Void call() throws Exception {
		while(!Thread.currentThread().isInterrupted()) { 
			 String command = component.getCommandQueue().take();
			 if(wires.isEmpty()){
				 log.warn(bundleMarker,"{}: No wires found. Aborted sending command= {}",
						 this, command
				 );
			 }else{
				 log.debug(bundleMarker,"{}: Sending {} to {} wires",
						 new Object[]{this, command, wires.size()});
				 
				 for (Wire wire : wires) {
					 wire.update(command);
				 }
			 }
			 lastCommand = command;
			 commandCount.incrementAndGet();
		 }	    
		return null;
	}

	
}