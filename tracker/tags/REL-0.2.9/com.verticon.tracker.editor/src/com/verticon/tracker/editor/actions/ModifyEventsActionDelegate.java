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

import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.ModifyEventsWizard;

/**
 * @author jconlon
 *
 */
public class ModifyEventsActionDelegate implements IObjectActionDelegate {

	private static final String FAILED_TO_MODIFY_EVENTS = "Failed to modify Events";
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

		
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)editorPart.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					FAILED_TO_MODIFY_EVENTS, "The Active Editor does not support a IQueryDataSetProvider");
			return;
		}
		
		
		ModifyEventsWizard wizard = new ModifyEventsWizard();
		wizard.init(workbenchWindow, queryDataSetProvider.getEditingDomain(), selection);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
		
	}

}
