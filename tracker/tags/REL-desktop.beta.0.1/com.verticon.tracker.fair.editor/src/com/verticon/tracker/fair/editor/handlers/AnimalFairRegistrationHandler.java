/**
 * 
 */
package com.verticon.tracker.fair.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.fair.editor.presentation.FairRegistrationWizard;

/**
 * 
 * Calls FairRegistrationWizard on a selection from a FairEditor. 
 * This Handler will only run if a FairEditorTester finds a non null IFairProvider.
 * 
 * @author jconlon
 *
 */
public class AnimalFairRegistrationHandler extends AbstractHandler implements IHandler {

	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		FairRegistrationWizard wizard = new FairRegistrationWizard();
		
		wizard.init(HandlerUtil.getActiveWorkbenchWindowChecked(event), 
				FairEditorTester.getFairProvider(),
				selection);
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
