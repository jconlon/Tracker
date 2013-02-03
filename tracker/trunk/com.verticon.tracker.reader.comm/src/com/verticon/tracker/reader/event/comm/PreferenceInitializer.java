package com.verticon.tracker.reader.event.comm;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;


import static com.verticon.tracker.reader.event.comm.PreferenceConstants.P_SERIAL_PORTS;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IEclipsePreferences defaults = new DefaultScope().getNode(CommReaderPlugin.PLUGIN_ID);
		defaults.put(P_SERIAL_PORTS, "");
	}

}
