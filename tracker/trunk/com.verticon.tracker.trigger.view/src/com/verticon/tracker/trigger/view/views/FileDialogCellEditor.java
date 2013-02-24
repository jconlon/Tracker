package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Strings.isNullOrEmpty;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

public class FileDialogCellEditor extends DialogCellEditor {

	private final String dialogText;

	public FileDialogCellEditor(Composite parent, String dialogText) {
		super(parent);


		this.dialogText = dialogText;

	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {

		setErrorMessage(null);
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String filterPath = store.getString(PreferenceConstants.P_REPORTS_PATH);
		
		
		FileDialog dialog = new FileDialog(cellEditorWindow.getShell(),
				SWT.OPEN);

		String filterExtensionsPref = store
				.getString(PreferenceConstants.P_LABEL_EXTENSION_STRING);
		if (!isNullOrEmpty(filterExtensionsPref)) {
			Iterable<String> exts = Splitter.on(',').trimResults()
					.split(filterExtensionsPref);
			String[] filterExtensions = Iterables.toArray(exts, String.class);
			dialog.setFilterExtensions(filterExtensions);
		}

		dialog.setFilterPath(filterPath);
		dialog.setText(dialogText);

		String absolutePath = dialog.open();

		if (absolutePath == null) {
			boolean result = MessageDialog.openConfirm(
					cellEditorWindow.getShell(), "Confirm",
					"Clear any existing File value for this entry?");
			if (result) {
				// OK Button selected
				absolutePath = "";
			}

		}
		return absolutePath;
	}

}
