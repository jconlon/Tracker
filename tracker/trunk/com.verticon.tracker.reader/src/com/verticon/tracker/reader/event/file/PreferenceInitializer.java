package com.verticon.tracker.reader.event.file;

import static com.verticon.tracker.reader.event.file.PreferenceConstants.P_READ_INTERVAL;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.verticon.tracker.reader.ReaderPlugin;

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
		IEclipsePreferences defaults = new DefaultScope().getNode(ReaderPlugin.PLUGIN_ID);
		defaults.putInt(P_READ_INTERVAL, 1);
		
	}

}
