/**
 * 
 */
package com.verticon.tracker.fair.transaction.editor.popup.actions;

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

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.presentation.IFairProvider;

/**
 *
 * 
 * @author jconlon
 * 
 */
public class ImportFairExhibitDataWizardDelegate implements IObjectActionDelegate {

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

	

//	/* (non-Javadoc)
//	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
//	 */
//	public void run(IAction action) {
//		IWorkbenchPartSite site = targetPart.getSite();
//		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
//		
//		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
//		
//		try {
//			
//			Fair fair = ImportFairExhibitDataWizard.getFair(editorPart);
//			if(fair==null){
//				failedToFindFairEditorShowDialog(workbenchWindow.getShell(), 
//						new Exception("There is no Active Editor in the workbench. Please open a Tracker Fair editor and try again."));
//			}else{
//				showWizard(workbenchWindow);
//			}
//		} catch (IOException e) {
//			failedToFindFairEditorShowDialog(workbenchWindow.getShell(),e);
//		}
//	}
	
	
	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		if(editorPart == null){
			failedToFindFairEditorShowDialog(workbenchWindow.getShell(), new Exception(
					"There is no Active Editor in the workbench. Please open a Fair editor and try again."
			));
		}else{
			IFairProvider premisesProvider = (IFairProvider)editorPart.getAdapter(IFairProvider.class);
			if(premisesProvider==null){
				failedToFindFairEditorShowDialog(workbenchWindow.getShell(), new Exception(
						"The Active Editor in the workbench is not a Fair provider. Please open a Fair editor and try again."
				));
			}else{
				Fair fair = premisesProvider.getFair();
				showWizard(workbenchWindow, fair);
			}
			
		}
		
	}

	private void failedToFindFairEditorShowDialog(Shell shell, Exception e){
		MessageDialog.openError(shell,
				"Import Fair Registration Data", "Unsupported function. "+ e.getMessage());
		return;
	}
	
	private void showWizard(IWorkbenchWindow workbenchWindow, Fair fair){
		ImportFairExhibitDataWizard wizard = new ImportFairExhibitDataWizard();
		wizard.init(workbenchWindow.getWorkbench(),  selection, fair);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
	}

}
