package com.verticon.agriculture.presentation.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Show the user a single column of locations for setting on one or more
 * Sighting events.
 * 
 * @author jconlon
 * 
 */
public class LocationChoices extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			SelectLocationsWizard wizard = new SelectLocationsWizard(
					(IStructuredSelection) selection);

			WizardDialog dialog = new WizardDialog(
					HandlerUtil.getActiveShellChecked(event), wizard);
			dialog.open();

		}

		return null;
	}

}
