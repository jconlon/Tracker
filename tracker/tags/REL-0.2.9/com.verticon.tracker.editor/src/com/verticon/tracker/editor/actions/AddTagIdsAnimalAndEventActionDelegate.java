/**
 * 
 */
package com.verticon.tracker.editor.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.editor.presentation.AddTagIdsAnimalAndEventWizard;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.util.ActionUtils;

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
public class AddTagIdsAnimalAndEventActionDelegate implements IObjectActionDelegate {
	
	private IWorkbenchPart targetPart;
	private IStructuredSelection selectionOfTagIdResources;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart=targetPart;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selectionOfTagIdResources = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;
	}


	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)editorPart.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null || ActionUtils.getPremises(queryDataSetProvider)==null){
			MessageDialog.openError(editorPart.getSite().getShell(),
					"Add TagIds and Animal", "Unsupported function. The Active Editor does not support a Tracker Animal Premises Model. Activate a Tracker editor instead.");
			return;
		}

		AddTagIdsAnimalAndEventWizard wizard = new AddTagIdsAnimalAndEventWizard();
		wizard.init( editorPart, selectionOfTagIdResources);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
		
	}

}
