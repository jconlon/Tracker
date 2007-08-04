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

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.TagsBean;
import com.verticon.tracker.editor.util.TemplateBean;
import com.verticon.tracker.util.TrackerLog;

/**
 * Action associated with a selection on a Capture *.tags file.  Prompts the user to select a Template
 * to add to the set of animals associated with the AINs in the capture *.tags file.
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
public class AddTemplateToPremises implements IObjectActionDelegate {


	
	
	private IWorkbenchPart targetPart;
	private ISelection selection;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

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
		
		TemplateBean templateBean = ActionUtils.getTemplateBean( editor,  targetPart);
		if(templateBean == null){
			return;
		}

		TagsBean tagsBean = null;
		try {
			 tagsBean = ActionUtils.getTagsBean(editor, selection);
			if(tagsBean==null || tagsBean.getTags().isEmpty()){
				MessageDialog.openWarning(targetPart.getSite().getShell(),
							"No unique tags in file",
							"Found no unique events to import from template "+tagsBean.getName());
				return;
			}
			ActionUtils.addTemplate(premises, tagsBean, templateBean, editor);
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());
	}
	
}
