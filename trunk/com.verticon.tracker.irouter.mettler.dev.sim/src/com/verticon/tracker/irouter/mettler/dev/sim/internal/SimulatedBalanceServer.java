package com.verticon.tracker.irouter.mettler.dev.sim.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.equinoxosgi.toast.devsim.IDeviceSimulator;
import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;

import com.verticon.tracker.irouter.core.PropertyManager;
import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * Simulates a Mettler Balance Server. Type of Server is determined by the property 
 * mettler.sim.type, with the default a ServerSocket.  
 * 
 * Socket is determined by the property mettler.sim.socket with the default 2345.
 * 
 * Port is determined by the property mettler.sim.port and there is no default.
 * 
 * @author jconlon
 *
 */
public class SimulatedBalanceServer implements IDeviceListener, IDeviceSimulatorListener {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
	private static final String MY_PREFIX = "mettler.sim.";
	private static final String METTLER_BALANCE = "Mettler Balance";
	private static final String CONNECTION = "Connection";
	private static final String WEIGHT = "Weight";
	private IDeviceSimulator simulator;
	private int weight;
	private AtomicBoolean run = new AtomicBoolean(true);
	private Thread connectedThread;
	
	
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
		if (WEIGHT.equals(parameterName) && WEIGHT.equals(actionName))
			System.out.println("**************Perform action.********");
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
		simulator.setBooleanValue(METTLER_BALANCE, CONNECTION, true);
		connectedThread = Thread.currentThread();
		while (run.get() && !connectedThread.isInterrupted()) {
			Double grams = queue.take().doubleValue();
			String message = String.format("S D %10.2f g\r\n", grams);
			out.write(message.getBytes());
			out.flush();
		}
		simulator.setBooleanValue(METTLER_BALANCE, CONNECTION, true);
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
		// TODO Auto-generated method stub
		
	}

}
