package com.verticon.tracker.transaction.publisher.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.verticon.tracker.transaction.publisher.PublisherPlugin;

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

public class FileTailPublisherPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public FileTailPublisherPreferencePage() {
		super(GRID);
		setPreferenceStore(PublisherPlugin.getDefault().getPreferenceStore());
		setDescription("Tracker Event Publisher Preferences");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		IntegerFieldEditor readInterval = new IntegerFieldEditor(
				PreferenceConstants.P_READ_INTERVAL,//name
				"Capture File Read &Interval 1 to 360 seconds:",//lableText
		 		getFieldEditorParent(),//parent
		 		3);
		
		readInterval.setValidRange(1, 360);
		addField(readInterval);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	
	
	
}