package com.verticon.tracker.store.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.store.ui.Activator;
import com.verticon.tracker.store.ui.wizards.ImportPremisesWizard;

public class ImportPremisesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!Activator.getDefault().hasTrackerStoreService(null)) {
			MessageDialog
					.openError(HandlerUtil.getActiveShell(event),
							"Import Premises from Tracker Store",
							"There is no active Tracker Store Service. Use configure one and try again.");
			return null;
		}
		if (!Activator.getDefault().isAuthenticatedUser()) {
			MessageDialog
					.openError(HandlerUtil.getActiveShell(event),
							"Import Premises from Tracker Store",
							"User is not signed on and authenticated. Sign on and try again.");
			return null;
		}

		ImportPremisesWizard wizard = new ImportPremisesWizard();
		wizard.init(
				HandlerUtil.getActiveWorkbenchWindowChecked(event).getWorkbench(),  
				(IStructuredSelection)HandlerUtil.getActiveMenuSelection(event));
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
