package com.verticon.tracker.editor.actions;

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

import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;

public class ChangeAnimalType implements IObjectActionDelegate {

	private static final String FAILED_TO_ADD_EXHIBIT = "Failed to register an animal";
	
	private IStructuredSelection selection;
	private IWorkbenchPart targetPart;
	
	/**
	 * Constructor for Action1.
	 */
	public ChangeAnimalType() {
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

		
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)editorPart.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					FAILED_TO_ADD_EXHIBIT, "The Active Editor does not support a IQueryDataSetProvider");
			return;
		}
		ChangeAnimalTypeWizard wizard = new ChangeAnimalTypeWizard();
		wizard.init(workbenchWindow, queryDataSetProvider.getEditingDomain(), 
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
