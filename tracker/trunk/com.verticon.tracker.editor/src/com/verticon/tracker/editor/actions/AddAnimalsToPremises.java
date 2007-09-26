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

import com.verticon.tracker.editor.presentation.AddAnimalsToPremisesWizard;
import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * Action associated with a selection on a Capture *.tags file.
 * 
 * Calls Wizard that prompts the user to choose 
 * 1. an Animal default
 * 2. an Event type
 * 
 * to be added to animals associated with the AINs in the capture *.tags file.
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
public class AddAnimalsToPremises implements IObjectActionDelegate {
	
	private IWorkbenchPart targetPart;
	private IStructuredSelection selectionOfTagIdResources;

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
		this.selectionOfTagIdResources = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;
	}

//	/* (non-Javadoc)
//	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
//	 */
//	public void run(IAction action) {
//		TrackerEditor editor = ActionUtils.getTrackerEditor(targetPart);
//		Premises premises = ActionUtils.getPremises( editor);
//		if(editor==null){
//			MessageDialog.openError(targetPart.getSite().getShell(),
//					"Failed to add tags",
//					"Could not find an active TrackerEditor ");
//			return;
//		}
//		Animal animal = ActionUtils.promptUserForAnimal( targetPart);
//		if(animal==null ){
//			MessageDialog.openWarning(targetPart.getSite().getShell(),
//						"No animal specified",
//						"You must specify an animal. Even when adding only events. ");
//			return;
//		}
//		Event event = ActionUtils.promptUserForEvent( targetPart);
//		if(event==null ){
//			MessageDialog.openWarning(targetPart.getSite().getShell(),
//						"No event specified",
//						"You must specify an event. ");
//			return;
//		}
//		TemplateAnimalBean templateBean = ActionUtils.createTemplateBean(animal, event);
//		
//		TagsBean tagsBean = null;
//		try {
//			tagsBean = ActionUtils.getTagsBean(editor, selectionOfTagIdResources);
//			if(tagsBean==null || tagsBean.getTags().isEmpty()){
//				MessageDialog.openWarning(targetPart.getSite().getShell(),
//							"No unique tags in file",
//							"Found no unique events to import from template "+tagsBean.getName());
//				return;
//			}
//
//			ActionUtils.addTemplate(premises,  tagsBean, templateBean, editor);
//			//Refresh the current viewer
//			editor.getViewer().refresh();
//		} catch (FileNotFoundException e) {
//			TrackerLog.logError("Could not find the tags file.", e);
//			MessageDialog
//			.openError(
//					targetPart.getSite().getShell(),
//					"Failed to add tags",
//					"Failed to add tags from file "
//							+ tagsBean.getName()
//							+ " because: "
//							+ e.getLocalizedMessage());
//		}
//
//	}

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
		AddAnimalsToPremisesWizard wizard = new AddAnimalsToPremisesWizard();
		wizard.init(workbenchWindow, editor, selectionOfTagIdResources);
		WizardDialog dialog = new WizardDialog(workbenchWindow.getShell(), wizard);
		dialog.open();
		
	}

}
