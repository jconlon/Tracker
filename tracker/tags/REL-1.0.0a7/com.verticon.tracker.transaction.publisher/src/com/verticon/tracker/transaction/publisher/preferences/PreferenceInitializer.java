package com.verticon.tracker.transaction.publisher.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

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
		IPreferenceStore store = TrackerFileTailPublisherPlugin.getDefault()
				.getPreferenceStore();
//		store.setDefault(PreferenceConstants.P_ON_BOOLEAN, false);
		store.setDefault(PreferenceConstants.P_READ_INTERVAL, 1);
		

	}

}
