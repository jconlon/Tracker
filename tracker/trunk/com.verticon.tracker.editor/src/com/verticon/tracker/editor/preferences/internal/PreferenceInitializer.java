package com.verticon.tracker.editor.preferences.internal;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.verticon.tracker.editor.preferences.PreferenceConstants;
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
		store.setDefault(PreferenceConstants.P_VALIDATE_BEFORE_EXPORT,PreferenceConstants.DEFAULT_VALIDATE_BEFORE_EXPORT);
		store.setDefault(PreferenceConstants.P_USE_SUBMENUS,PreferenceConstants.DEFAULT_USE_SUBMENUS);
	}

}
