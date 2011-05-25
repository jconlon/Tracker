package com.verticon.tracker.irouter.mettler.dev.fake.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.equinoxosgi.util.PropertyManager;

import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * Fake BalanceServer the type of Server is determined by the property mettler.fake.type
 * and the default is a ServerSocket.  
 * 
 * Socket is determined by the property mettler.fake.socket and the default is 2345.
 * 
 * Port is determined by the property mettler.fake.port and there is no default.
 * 
 * 
 * @author jconlon
 *
 */
public class FakeBalanceServer implements IDeviceListener {

	private static final String MY_PREFIX = "mettler.fake.";
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FakeBalanceServer ["+ MY_PREFIX + getProperty(Property.TYPE) + "]";
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

	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
		
		double grams = 1.1;
		int count = 0;
		while (!Thread.currentThread().isInterrupted()) {
			grams = grams + 3.4;
			String message = String.format("S D %10.2f g\r\n", grams);
			out.write(message.getBytes());
			out.flush();
			if (grams > 999) {
				grams = .1;
				count = 0;
				System.out.println(this+" Sleeping");
				TimeUnit.MINUTES.sleep(2);
				System.out.println(this+" Waking up...");
			} else {
				count++;
				if (count % 80 == 0) {
					System.out.println(".");
				} else {
					System.out.print(".");
				}
				TimeUnit.MILLISECONDS.sleep(200);
			}

		}
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
		FakeBalanceServer other = (FakeBalanceServer) obj;
		if (getProperty(Property.TYPE)  != other.getProperty(Property.TYPE) )
			return false;
		return true;
	}

}
