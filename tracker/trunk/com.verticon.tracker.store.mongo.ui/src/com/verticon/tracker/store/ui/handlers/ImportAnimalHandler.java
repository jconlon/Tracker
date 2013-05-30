package com.verticon.tracker.store.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.store.ui.wizards.ImportAnimalWizard;

public class ImportAnimalHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ImportAnimalWizard wizard = new ImportAnimalWizard();
		wizard.init(HandlerUtil.getActiveWorkbenchWindowChecked(event)
				.getWorkbench(), (IStructuredSelection) HandlerUtil
				.getActiveMenuSelection(event));
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
