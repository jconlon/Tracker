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

import com.verticon.tracker.editor.presentation.AddTemplateToAnimalsWizard;
import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * ActionDelegate that invokes a Wizard to add Template Events to a Selection 
 * of Animals
 * 
 * @author jconlon
 *
 */
public class AddTemplateToAnimalsActionDelegate implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	private IStructuredSelection selection;

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
		this.selection = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;

	}


	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		if(editorPart==null|| (!(editorPart instanceof TrackerEditor))){
			MessageDialog.openError(workbenchWindow.getShell(),
					"Failed to add template",
					"The Active Editor is not a TrackerEditor ");
			return;
		}
		TrackerEditor editor =(TrackerEditor)editorPart;
		AddTemplateToAnimalsWizard wizard = new AddTemplateToAnimalsWizard();
		wizard.init(workbenchWindow, editor, selection);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
		
	}

}
