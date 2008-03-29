package com.verticon.tracker.reader.event.comm;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.verticon.tracker.connector.comm.CommReaderPlugin;

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
		Preferences store = CommReaderPlugin.getDefault().getPluginPreferences();
		store.setDefault(PreferenceConstants.P_SERIAL_PORTS, "");
		
	}

}
