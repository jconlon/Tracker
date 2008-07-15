package com.verticon.tracker.editor.util;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class SelectInOutline implements IObjectActionDelegate{
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

		
		IContentOutlinePage contentOutlinePage = (IContentOutlinePage)editorPart.getAdapter(IContentOutlinePage.class);
		if(contentOutlinePage==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to Select in Outline", "The Active Editor does not support a IContentOutlinePage");
			return;
		}
		contentOutlinePage.setSelection(selection);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;
	}

}
