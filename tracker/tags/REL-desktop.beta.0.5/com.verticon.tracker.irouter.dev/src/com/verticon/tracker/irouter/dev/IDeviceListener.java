package com.verticon.tracker.irouter.dev;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * OSGi Whiteboard listener service. Listeners are connected are found and 
 * connected to clients by DeviceService Services.
 *  
 * @author jconlon
 *
 */
public interface IDeviceListener {
	
	
	/**
	 * 
	 * @param prop type
	 * @return property value
	 */
	public Object getProperty(Constants.Property prop);
	
	/**
	 * Called when a connection is established to the device.
	 * @param out
	 * @param in
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void connected(OutputStream out, InputStream in) throws IOException, InterruptedException;
}
