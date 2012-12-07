package com.verticon.tracker.irouter.trutest.dev.fake.internal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.trutest.dev.AbstractIndicator;

/**
 * Fake TruTest Indicator acting as a Server. The type of Server is determined by the property
 * mettler.fake.type and the default is a ServerSocket.
 * 
 * Socket is determined by the property mettler.fake.socket and the default is
 * 2345.
 * 
 * Port is determined by the property mettler.fake.port and there is no default.
 * 
 * 
 * @author jconlon
 * 
 */
public class FakeIndicatorServer extends AbstractIndicator  {
	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.dev.fake";
	/**
	 * slf4j Logger
	 */
	protected Logger log = LoggerFactory
				.getLogger(FakeIndicatorServer.class);
	
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	static final String MY_PREFIX = "trutest.fake.";
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FakeIndicatorServer [" + MY_PREFIX + getProperty(Property.TYPE)
				+ "]";
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
		result = prime
				* result
				+ ((getProperty(Property.TYPE) == null) ? 0 : getProperty(
						Property.TYPE).hashCode());
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
		AbstractIndicator other = (AbstractIndicator) obj;
		if (getProperty(Property.TYPE) != other.getProperty(Property.TYPE))
			return false;
		return true;
	}

}
