/**
 * 
 */
package com.verticon.tracker.editor.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.AddTagIdsAndTemplateWizard;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Action associated with a selection on a Capture *.tags file.
 * 
 * Calls Wizard that prompts the user to select a Template to add to the set of animals 
 * associated with the AINs in the capture *.tags file.
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
public class AddTagIdsAndTemplateActionDelegate implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	private IStructuredSelection selection;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

	}

	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		if(editorPart == null){
			failedToFindFairEditorShowDialog(workbenchWindow.getShell(), new Exception(
					"There is no Active Editor in the workbench. Please open a Premises editor and try again."
			));
		}else{
			IPremisesProvider premisesProvider = (IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class);
			if(premisesProvider==null){
				failedToFindFairEditorShowDialog(workbenchWindow.getShell(), new Exception(
						"The Active Editor in the workbench is not a Premises provider. Please open a Premises editor and try again."
				));
			}else{
				Premises premises = premisesProvider.getPremises();
				showWizard(workbenchWindow, editorPart, premises, selection);
			}
			
		}
		
	}

	/**
	 * @param workbenchWindow
	 * @param editorPart
	 */
	protected void showWizard(IWorkbenchWindow workbenchWindow,
			IEditorPart editorPart, Premises premises, IStructuredSelection selectionOfTagIdResources) {
		AddTagIdsAndTemplateWizard wizard = new AddTagIdsAndTemplateWizard();
		wizard.init( editorPart, selectionOfTagIdResources, premises);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
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
	
	private void failedToFindFairEditorShowDialog(Shell shell, Exception e){
		MessageDialog.openError(shell,
				getTitle(), "Unsupported function. "+ e.getMessage());
		
	}

	/**
	 * @return
	 */
	protected String getTitle() {
		return "Import TagIds as Template";
	}
	
}
