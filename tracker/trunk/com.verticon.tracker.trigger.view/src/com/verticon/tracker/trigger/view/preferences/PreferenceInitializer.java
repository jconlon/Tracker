package com.verticon.tracker.trigger.view.preferences;

import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_BODY;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_DATE_AT_WEIGHING_FORMATTER;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_FILE_EXTENSION;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_LOT_SEPARATOR;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_ROOT;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.DEFAULT_TESTING_FILE_FORMAT;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_BODY_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_LABEL_EXTENSION_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_LOT_DAY_AT_WEIGHING_FORMATTER;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_LOT_SEPARATOR_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_ROOT_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_SHOW_LABEL_PATH_BOOLEAN;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_TESTING_FILE_FORMAT;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.verticon.tracker.trigger.view.TriggerViewPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		store.setDefault(P_SHOW_LABEL_PATH_BOOLEAN, true);

		store.setDefault(P_ROOT_STRING, DEFAULT_ROOT);

		store.setDefault(P_BODY_STRING, DEFAULT_BODY);

		store.setDefault(P_LABEL_EXTENSION_STRING, DEFAULT_FILE_EXTENSION);

		store.setDefault(P_TESTING_FILE_FORMAT, DEFAULT_TESTING_FILE_FORMAT);
		
		store.setDefault(P_LOT_SEPARATOR_STRING, DEFAULT_LOT_SEPARATOR);

		store.setDefault(P_LOT_DAY_AT_WEIGHING_FORMATTER,
				DEFAULT_DATE_AT_WEIGHING_FORMATTER);
	}

}
