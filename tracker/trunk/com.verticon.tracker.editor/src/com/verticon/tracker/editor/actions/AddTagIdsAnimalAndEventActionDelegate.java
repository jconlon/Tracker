/**
 * 
 */
package com.verticon.tracker.editor.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.AddTagIdsAnimalAndEventWizard;


/**
 * Action associated with a selection on a Capture *.tags file.
 * 
 * Calls Wizard that prompts the user to choose 
 * 1. an Animal default
 * 2. an Event type
 * 
 * to be added to animals associated with the AINs in the capture *.tags file.
 * 
 * For AINs that are not already assigned to animals an animal will be created.
 * 
 * Capture *.tags files can also contain a timestamp in their name.  This will be the default date for all events
 * overriding any event dates in the PremisesTemplates.
 * 
 * 
 * @author jconlon
 * 
 */
public class AddTagIdsAnimalAndEventActionDelegate extends AddTagIdsAndTemplateActionDelegate {

	
	@Override
	protected String getTitle() {
		return "Import TagIds as Animal and Event";
	}
	

	@Override
	protected void showWizard(IWorkbenchWindow workbenchWindow,
			IEditorPart editorPart, Premises premises, IStructuredSelection selection) {
		AddTagIdsAnimalAndEventWizard wizard = new AddTagIdsAnimalAndEventWizard();
		wizard.init( editorPart, selection);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
	}
	
}
