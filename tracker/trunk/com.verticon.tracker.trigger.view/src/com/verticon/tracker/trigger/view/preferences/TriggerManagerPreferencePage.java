package com.verticon.tracker.trigger.view.preferences;

import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_BODY_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_LABEL_EXTENSION_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_LOT_SEPARATOR_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_PRINT_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_REPORTS_PATH;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_ROOT_STRING;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_SHOW_LABEL_PATH_BOOLEAN;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_TESTING_FILE_FORMAT;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_TESTING_PATH;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_VALID_LOT_ID_MAX_SIZE_INTEGER;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_VALID_LOT_SUFFIXES_STRING;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.verticon.tracker.trigger.view.TriggerViewPlugin;

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

public class TriggerManagerPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public TriggerManagerPreferencePage() {
		super(GRID);
		setPreferenceStore(TriggerViewPlugin.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(P_REPORTS_PATH,
				"&Label Directory:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(
P_SHOW_LABEL_PATH_BOOLEAN,
				"&Show path of label:", getFieldEditorParent()));

		addField(new DirectoryFieldEditor(P_TESTING_PATH,
				"&Test output Directory:", getFieldEditorParent()));

		StringFieldEditor stringFieldEditor = new StringFieldEditor(
				P_TESTING_FILE_FORMAT,
				"Print File Name Format:", getFieldEditorParent());
		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"This will be the format of file names that will be created when directly printing the the entry.");
		addField(stringFieldEditor);

		stringFieldEditor = new StringFieldEditor(
P_PRINT_STRING,
				"Print data value:",
				getFieldEditorParent());
		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"This will be the value will replace before the first comma in the output file. A blank field will be ignored.");
		addField(stringFieldEditor);


		stringFieldEditor = new StringFieldEditor(
P_LABEL_EXTENSION_STRING,
				"Label File Extension:", getFieldEditorParent());
		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"Files with this extension will be the only ones showing in the dialog shown when setting the File field."
								+ " To add more than one extension separate them with commas.");
		addField(stringFieldEditor);

		// LOT
		// separator
		stringFieldEditor = new StringFieldEditor(P_LOT_SEPARATOR_STRING,
				"Lot separator:", getFieldEditorParent());

		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"This will be the string of characters used by the Lot Creation Wizard when it concatinates the three segments of the Lot numbers that were spcecified in the Wizard pages.");
		addField(stringFieldEditor);

		// max id size
		stringFieldEditor = new IntegerFieldEditor(
				P_VALID_LOT_ID_MAX_SIZE_INTEGER, "Lot ID maximum length:",
				getFieldEditorParent());

		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"The maximum number of characters allowed for the Lot ID. ID values equal to or less than will be considered valid by the Lot Creation Wizard. The default of 0 will be consider as no limit.");
		addField(stringFieldEditor);

		// valid suffixes
		stringFieldEditor = new StringFieldEditor(P_VALID_LOT_SUFFIXES_STRING,
				"Lot valid suffixes :", getFieldEditorParent());

		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"Comma separated list of values considered valid for Lot suffixes. Only one of these values will be considered valid by the Lot Creation Wizard.");
		addField(stringFieldEditor);

		// addField(new RadioGroupFieldEditor(
		// P_CHOICE,
		// "An example of a multiple-choice preference",
		// 1,
		// new String[][] { { "&Choice 1", "choice1" }, {
		// "C&hoice 2", "choice2" }
		// }, getFieldEditorParent()));
		stringFieldEditor = new StringFieldEditor(
P_ROOT_STRING,
				"Output trigger &header:",
				getFieldEditorParent());

		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"This will be the first text block written to the trigger file.  The characters <LABEL_FILE> and <PRINTER> will be "
								+ "replaced by the path to the Label file name and the printer name respectivively.");
		addField(stringFieldEditor);

		stringFieldEditor = new StringFieldEditor(
P_BODY_STRING,
				"Output trigger &body:", getFieldEditorParent());

		stringFieldEditor
				.getTextControl(getFieldEditorParent())
				.setToolTipText(
						"This will be the second text written to the trigger file. It will contain the formatting for the measurement values.");
		addField(stringFieldEditor);


	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
	}
	
}