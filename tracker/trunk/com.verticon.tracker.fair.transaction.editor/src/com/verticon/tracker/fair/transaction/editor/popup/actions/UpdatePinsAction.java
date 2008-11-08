package com.verticon.tracker.fair.transaction.editor.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.editor.presentation.IPremisesProvider;

public class UpdatePinsAction implements IObjectActionDelegate {

	private static final String FAILED_TO_ADD_EXHIBIT = "Failed to update a Pin on a Movedxxx event";
	
	private IStructuredSelection selection;
	private IWorkbenchPart targetPart;
	
	/**
	 * Constructor for Action1.
	 */
	public UpdatePinsAction() {
		super();
	}
	
	public void init(IWorkbenchWindow window){
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart=targetPart;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();

		
		IPremisesProvider premisesProvider = (IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class);
		if(premisesProvider==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					FAILED_TO_ADD_EXHIBIT, "The Active Editor does not support a IPremisesProvider");
			return;
		}
		UpdatePinsWizard wizard = new UpdatePinsWizard();
		wizard.init(workbenchWindow, premisesProvider.getEditingDomain(), 
				selection);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		
		this.selection = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;
	}

}
