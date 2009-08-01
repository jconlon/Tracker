package com.verticon.tracker.editor.preferences.internal;

import static com.verticon.tracker.editor.preferences.PreferenceConstants.DEFAULT_IGNORE_WINDOW;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.DEFAULT_SPREAD_INTERVAL;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.DEFAULT_USE_SUBMENUS;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.DEFAULT_VALIDATE_BEFORE_EXPORT;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_IGNORE_WINDOW;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_SPREAD_INTERVAL;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_USE_SUBMENUS;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_VALIDATE_BEFORE_EXPORT;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

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
		IPreferenceStore store = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
		store.setDefault(P_IGNORE_WINDOW,DEFAULT_IGNORE_WINDOW);
		store.setDefault(P_VALIDATE_BEFORE_EXPORT,DEFAULT_VALIDATE_BEFORE_EXPORT);
		store.setDefault(P_USE_SUBMENUS,DEFAULT_USE_SUBMENUS);
		store.setDefault(P_SPREAD_INTERVAL, DEFAULT_SPREAD_INTERVAL);
	}

}
