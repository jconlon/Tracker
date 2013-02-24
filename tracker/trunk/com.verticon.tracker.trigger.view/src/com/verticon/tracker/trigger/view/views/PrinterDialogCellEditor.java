package com.verticon.tracker.trigger.view.views;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.google.common.collect.Iterables;

public class PrinterDialogCellEditor extends DialogCellEditor {


	private final String title;
	private final String message;

	public PrinterDialogCellEditor(Composite parent, String title,
			String message) {
		super(parent);
		this.title = title;
		this.message = message;

	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {

		setErrorMessage(null);

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				cellEditorWindow.getShell(), new LabelProvider());

		List<String> names = printerNames();
		names.add("");

		String[] printerNames = Iterables.toArray(names, String.class);

		dialog.setElements(printerNames);
		dialog.setTitle(title);
		dialog.setMessage(message);
		// User pressed cancel
		if (dialog.open() != Window.OK) {
			return null;
		}
		return dialog.getFirstResult();

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
