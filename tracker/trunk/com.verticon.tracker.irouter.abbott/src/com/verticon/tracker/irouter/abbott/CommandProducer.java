package com.verticon.tracker.irouter.abbott;

import static com.verticon.tracker.common.TrackerConstants.*;
import static com.verticon.tracker.irouter.abbott.Constants.*;
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
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.common.IContext;
import com.verticon.tracker.common.IService;

/**
 * 
 * A WireAdmin Producer that produces commands to send to
 * a TruTest indicator.  Commands are sent as raw (no envelope)
 * strings.
 * 
 * @author jconlon
 *
 */
class CommandProducer implements Producer, IService{
	
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
	
	private Future<Void> future;
	private ServiceRegistration serviceRegistration = null;

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
	 * @see com.verticon.tracker.irouter.abbott.IService#start(org.osgi.framework.BundleContext)
	 */
    public void start(BundleContext bc) throws InterruptedException, ExecutionException{
    	log.info(this + ":Starting.");
		future = context.getExecutor().submit(
				new Runner(commandQueue));
		register(bc);
		log.info(this + ":Started");
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
		serviceRegistration =  bc.registerService(Producer.class.getName(), this,
				regProps);
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.abbott.IService#stop()
	 */
	public void stop() {
		if(serviceRegistration !=null) {
			serviceRegistration.unregister();
			serviceRegistration = null;
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
			 }	    
		 }
	}
}