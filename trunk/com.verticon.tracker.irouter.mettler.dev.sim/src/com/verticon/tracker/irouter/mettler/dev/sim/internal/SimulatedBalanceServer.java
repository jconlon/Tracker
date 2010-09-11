package com.verticon.tracker.irouter.mettler.dev.sim.internal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.equinoxosgi.toast.devsim.IDeviceSimulator;
import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * Simulates a Server connection to a Mettler Balance that continuously sends weights. 
 * Type of Server is determined by the property 
 * mettler.sim.type, with the default a ServerSocket.  
 * 
 * Socket is determined by the property mettler.sim.socket with the default 2345.
 * 
 * Port is determined by the property mettler.sim.port and there is no default.
 * 
 * Output timing is determined by the property mettler.sim.timer.secs and there is a default of
 * 2 seconds.
 * 
 * @author jconlon
 *
 */
public class SimulatedBalanceServer implements IDeviceListener, IDeviceSimulatorListener {
	
	private static final String DEFAULT_TIME_SECONDS = "2";

	/**
	 * Identify the plugin to the logger
	 */
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.mettler.dev.sim";
	
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	/**
	 * slf4j Logger
	 */
	protected Logger log = LoggerFactory.getLogger(SimulatedBalanceServer.class);
	
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
	private static final String MY_PREFIX = "mettler.sim.";
	private static final String METTLER_BALANCE = "Mettler Balance";
	private static final String CONNECTION = "Connection";
	private static final String WEIGHT = "Weight";
	private IDeviceSimulator simulator;
	private Integer weight = 0;
	private AtomicBoolean run = new AtomicBoolean(true);
	private Thread connectedThread;
	private int secondsBetweenOutput = 2;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimulatedBalanceServer ["+ MY_PREFIX + getProperty(Property.TYPE) + "]";
	}
	
	/**
	 * DS binding to add a device simulator
	 * 
	 * @param value
	 */
	public void setDevSim(IDeviceSimulator value) {
		simulator = value;
	}
	
	public void startup() {
		
		String timing = PropertyManager.getProperty(MY_PREFIX
				+ "timer.secs",
				DEFAULT_TIME_SECONDS
				);
		try {
			secondsBetweenOutput = Integer.parseInt(timing);
		} catch (NumberFormatException e) {
			log.warn(bundleMarker, "Failed to parse the {}{} setting default to 2 seconds.",MY_PREFIX,"timer.secs");
		}
		
		
		
		simulator.registerDevice(METTLER_BALANCE, METTLER_BALANCE,this);
		simulator.addBooleanActuator(METTLER_BALANCE, CONNECTION, CONNECTION);
		simulator.addIntegerSensor(
				METTLER_BALANCE, //deviceName
				WEIGHT,//sensorName, 
				WEIGHT,//label, 
				0,//minValue, 
				2000,//maxValue, 
				0,//defaultValue, 
				1,//smallInc, 
				5,//largeInc, 
				"grams");
		run.set(true);
		log.debug(bundleMarker, "Started");
	}
	
	public void shutdown() {
		run.set(false);
		simulator.unregisterDevice(METTLER_BALANCE);
	}

	/**
	 * @return the grams
	 */
	public int getWeight() {
		return weight;
	}
	
	@Override
	public Object getProperty(Property prop) {
		switch (prop) {
		case PREFIX:
			return MY_PREFIX;
		case TYPE:
			String type = PropertyManager.getProperty(MY_PREFIX
					+ Property.TYPE.toString().toLowerCase(),
					Constants.DeviceType.SERVER_SOCKET.name()// default is a serversocket
					);
			return Constants.DeviceType.valueOf(type);
		case SOCKET:
			Object result = PropertyManager.getProperty(
					MY_PREFIX
					+ prop.toString().toLowerCase(),
					"2345"
					
			);
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}
			
			if (result instanceof String) {
				return new Integer((String)result);
				
			}else{
				throw new IllegalArgumentException("Unknown property type "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}
			
		default:
			 result = PropertyManager.getProperty(MY_PREFIX
					+ prop.toString().toLowerCase());
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}
			return result;
		}
	}

	
	
	public void performAction(String parameterName, String actionName) {
		if (WEIGHT.equals(parameterName) && WEIGHT.equals(actionName)){
			log.debug(bundleMarker, "performAction invoked actionName={}",actionName);
		}
	}
	
	public void valueChanged(String name, boolean newValue) {
	}

	public void valueChanged(String name, double newValue) {
	}
	
	public void valueChanged(String name, int newValue) {
		if (WEIGHT.equals(name)){
			try {
				queue.put(newValue);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				run.set(false);
				connectedThread.interrupt();
			}
		}
	}
	
	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
	
		connectedThread = Thread.currentThread();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		log.info(bundleMarker, "Connected");
		simulator.setBooleanValue(METTLER_BALANCE, CONNECTION, true);
		IOException ex = null;
		try {
			while (!Thread.currentThread().isInterrupted()) {
				String reply = process();
				if (reply != null) {
					writer.write(reply);
					writer.flush();
					log.debug(bundleMarker, "Replying {}", reply);
				} 

			}
		} catch (IOException e) {
			ex = e;
		}finally{
			log.info("Disconnected");
			simulator.setBooleanValue(METTLER_BALANCE, CONNECTION, false);
		}
		if(ex!=null){
			throw ex;
		}
		
	}

	private String process() throws InterruptedException {
		Integer value =  queue.poll(secondsBetweenOutput, TimeUnit.SECONDS);
		if(value!=null){
			weight=value;
		}
		return String.format("S D %10.2f g\r\n", weight.doubleValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getProperty(Property.TYPE)  == null) ? 0 : getProperty(Property.TYPE).hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulatedBalanceServer other = (SimulatedBalanceServer) obj;
		if (getProperty(Property.TYPE)  != other.getProperty(Property.TYPE) )
			return false;
		return true;
	}

	@Override
	public void valueChanged(String name, long newValue) {
	}

}
