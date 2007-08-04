/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.util.Collection;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.TemplateBean;

/**
 * @author jconlon
 *
 */
public class AddTemplateToAnimals implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	private ISelection selection;

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
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		TrackerEditor editor = ActionUtils.getTrackerEditor(targetPart);
		
		if(editor==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add template",
					"Could not find an active TrackerEditor ");
			return;
		}

		TemplateBean templateBean = ActionUtils.getTemplateBean( editor,  targetPart);
		if(templateBean == null){
			return;
		}
		if(templateBean.getEvents()==null || templateBean.getEvents().isEmpty()){
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add template",
					"Template has no events. ");
			return;
		}
		Collection<Animal> animals = ActionUtils.getSelectedAnimals( selection);
		
		ActionUtils.addTemplate( animals,
				 templateBean,  editor);
		
	}

	

}
