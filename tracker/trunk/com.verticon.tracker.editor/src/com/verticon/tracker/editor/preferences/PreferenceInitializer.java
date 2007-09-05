package com.verticon.tracker.editor.preferences;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

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
		Preferences store = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
		
		store.setDefault(PreferenceConstants.P_IGNORE_WINDOW,PreferenceConstants.DEFAULT_IGNORE_WINDOW);
	}

}
