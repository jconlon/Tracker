package com.verticon.tracker.irouter.gps.ui.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * Show the user a Wizard to find a GPS and set the uri on the selected
 * GPS Designate.
 * @author jconlon
 *
 */
public class SetGPSURIHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
			SetUriOnGPSProxyWizard wizard = new SetUriOnGPSProxyWizard();
			//Have to force buttons or they dont show
			wizard.setForcePreviousAndNextButtons(true);
			
			wizard.init(window.getWorkbench(), selection instanceof IStructuredSelection
					? (IStructuredSelection)selection: StructuredSelection.EMPTY);
			

			WizardDialog dialog = new WizardDialog(
					HandlerUtil.getActiveShellChecked(event), wizard);
			dialog.open();

		

		return null;
	}

}
