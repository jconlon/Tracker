/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.io.FileNotFoundException;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.TagsBean;
import com.verticon.tracker.editor.util.TemplateBean;
import com.verticon.tracker.util.TrackerLog;

/**
 * @author jconlon
 *
 */
public class AddAnimalsToPremises implements IObjectActionDelegate {
	
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
		Premises premises = ActionUtils.getPremises( editor);
		if(editor==null){
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add tags",
					"Could not find an active TrackerEditor ");
			return;
		}
		Animal animal = ActionUtils.promptUserForAnimal( targetPart);
		if(animal==null ){
			MessageDialog.openWarning(targetPart.getSite().getShell(),
						"No animal specified",
						"You must specify an animal. Even when adding only events. ");
			return;
		}
		Event event = ActionUtils.promptUserForEvent( targetPart);
		if(event==null ){
			MessageDialog.openWarning(targetPart.getSite().getShell(),
						"No event specified",
						"You must specify an event. ");
			return;
		}
		TemplateBean templateBean = ActionUtils.createTemplateBean(animal, event);
		
		TagsBean tagsBean = null;
		try {
			tagsBean = ActionUtils.getTagsBean(editor, selection);
			if(tagsBean==null || tagsBean.getTags().isEmpty()){
				MessageDialog.openWarning(targetPart.getSite().getShell(),
							"No unique tags in file",
							"Found no unique events to import from template "+tagsBean.getName());
				return;
			}

			ActionUtils.addTemplate(premises,  tagsBean, templateBean, editor);
			//Refresh the current viewer
			editor.getViewer().refresh();
		} catch (FileNotFoundException e) {
			TrackerLog.logError("Could not find the tags file.", e);
			MessageDialog
			.openError(
					targetPart.getSite().getShell(),
					"Failed to add tags",
					"Failed to add tags from file "
							+ tagsBean.getName()
							+ " because: "
							+ e.getLocalizedMessage());
		}

	}

	

}
