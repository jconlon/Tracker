package com.verticon.tracker.editor.preferences.internal;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class TrackerEditorPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public TrackerEditorPreferencePage() {
		super(GRID);
		setPreferenceStore(TrackerReportEditorPlugin.getPlugin().getPreferenceStore());
		setDescription("Tracker Editor Preferences");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField(new IntegerFieldEditor(
				PreferenceConstants.P_IGNORE_WINDOW,
				"&Seconds Interval to Ignore Duplicate Bulk Events:",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_VALIDATE_BEFORE_EXPORT,
				"&Validate Documents Before Exporting:",
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_USE_SUBMENUS,
				"&Use Submenus in Model Element Popup Menus:",
				getFieldEditorParent()));
		
		IntegerFieldEditor spreadInterval = new IntegerFieldEditor(
				PreferenceConstants.P_SPREAD_INTERVAL,//name
				"&Concurrent Event interval.  "+
				"\nSeconds added to seperate dateTimes"+
				"\nwhen adding multiple events to an animal:",//lableText
		 		getFieldEditorParent(),//parent
		 		3);
		
		spreadInterval.setValidRange(1, 10);
		addField(spreadInterval);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}