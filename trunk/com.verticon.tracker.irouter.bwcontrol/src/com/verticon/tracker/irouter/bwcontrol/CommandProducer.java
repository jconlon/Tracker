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

import static com.verticon.tracker.irouter.bwcontrol.Constants.PRODUCER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_SCOPE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.IService;

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
class CommandProducer implements Producer, Monitorable, IService{
	
	private static final String COMMAND_LAST = "producer.Last_Command_Sent";
	private static final String WIRES_COUNT = "producer.Connected_Consumers";
	private static final String COMMAND_COUNT = "producer.Total_Commands_Sent";

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(CommandProducer.class);
	
	private final IContext context;
	private final BlockingQueue<String> commandQueue;
	//Shared wires protected with concurrent collection
	private final List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	//Shared String protected with volatile
	private volatile String lastCommand = null;
	private volatile int commandCount;
	private Future<Void> future;
	private ServiceRegistration producerServiceRegistration = null;
	

	/**
	 * @param context
	 */
	CommandProducer(IContext context, BlockingQueue<String> commandQueue) {
		this.context = context;
		this.commandQueue=commandQueue;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommandProducer [pid=" + context.getPid() +", scope=" + Arrays.toString(PRODUCER_SCOPE)+
		"]";
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
			log.debug("{}: Not connected to any wires.",
					this
			);
		}else{
			HashSet<String> consumers = new HashSet<String>();
			for (Wire wire : wires) {
				consumers.add((String)wire.getProperties().get(WIREADMIN_CONSUMER_PID));
			}
			
			log.debug("{}: Connected to {} wires, and {} consumers={}",
					new Object[]{this, wires.length, consumers.size() ,consumers}
			);
			
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
	

	
    /* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.bwcontrol.IService#start(org.osgi.framework.BundleContext)
	 */
    public void start(BundleContext bc) throws InterruptedException, ExecutionException{
		future = context.getExecutor().submit(
				new Runner(commandQueue));
		register(bc);
	}


	protected void register(BundleContext bc) {
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, this.context.getPid());
		
		regProps.put(WIREADMIN_PRODUCER_FLAVORS,
				new Class[] { String.class });
		regProps.put(TRACKER_WIRE_GROUP_NAME, 
				this.context.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		regProps.put(WIREADMIN_PRODUCER_SCOPE, 
				PRODUCER_SCOPE);
		producerServiceRegistration =  bc.registerService(Producer.class.getName(), this,
				regProps);
		
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.bwcontrol.IService#stop()
	 */
	public void stop() {
		if(producerServiceRegistration !=null) {
			producerServiceRegistration.unregister();
			producerServiceRegistration = null;
		}

		if(future!=null){
			future.cancel(true);
			future=null;
		}
		lastCommand=null;
	}
	
	private class Runner implements Callable<Void>{
		 private final BlockingQueue<String> queue;
		 Runner(BlockingQueue<String> q) { queue = q; }

		 @Override
		 public Void call() throws ExecutionException, InterruptedException {
			 while(true) { 
				 String command = queue.take();
				 if(wires.isEmpty()){
					 log.warn("{}: No wires found. Aborted sending command= {}",
							 this, command
					 );
				 }else{
					 log.debug("{}: Sending {} to {} wires",
							 new Object[]{this, command, wires.size()});
					 
					 for (Wire wire : wires) {
						 wire.update(command);
					 }
				 }
				 lastCommand = command;
				 commandCount ++;
			 }	    
		 }
	}

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
					commandCount
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
			commandCount=0;
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
}