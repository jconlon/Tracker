package com.verticon.tracker.trigger.view.views;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.verticon.tracker.trigger.view.ITriggerEntry;

public class RequiredValuesDialogCellEditor extends DialogCellEditor {


	private final String title;
	private final String message;
	private final ITriggerEntry triggerEntry;

	public RequiredValuesDialogCellEditor(Composite parent, String title,
			String message, ITriggerEntry triggerEntry) {
		super(parent);
		this.title = title;
		this.message = message;
		this.triggerEntry = triggerEntry;

	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {

		setErrorMessage(null);

		InputDialog dialog = new InputDialog(cellEditorWindow.getShell(),
				title, message, triggerEntry.getRequireValues(), // initial
																	// value
				null);

		// User pressed cancel
		if (dialog.open() != Window.OK) {
			return null;
		}
		return dialog.getValue();

	}

	public static List<String> printerNames() {
		List<String> printerNames = newArrayList();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
				null, null);
		for (PrintService printService : printServices) {
			printerNames.add(printService.getName());
		}
		return printerNames;
	}

}
