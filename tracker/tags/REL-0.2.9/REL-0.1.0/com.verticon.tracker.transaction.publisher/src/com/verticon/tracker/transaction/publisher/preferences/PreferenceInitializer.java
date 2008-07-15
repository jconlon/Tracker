package com.verticon.tracker.transaction.publisher.preferences;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.verticon.tracker.transaction.publisher.TrackerFileTailPublisherPlugin;

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
		Preferences store = TrackerFileTailPublisherPlugin.getDefault().getPluginPreferences();
		
//		store.setDefault(PreferenceConstants.P_ON_BOOLEAN, false);
		store.setDefault(PreferenceConstants.P_READ_INTERVAL, 1);
		

	}

}
