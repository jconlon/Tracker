package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.AddTagIdsAndTemplateWizard;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Handler associated with a selection on a Capture *.tags file.
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
 * @since 0.3.1
 * 
 */
public class ImportTagIdsAsTemplateEventsHandler extends AbstractHandler {

	/**
	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
	 *  Scheduled for fix in 3.5
	 */
	private boolean isEnabled;
	
	/**
	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
	 *  Scheduled for fix in 3.5
	 */
	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
	 *  Scheduled for fix in 3.5
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		IEditorPart editorPart = (IEditorPart) HandlerUtil.getVariable(evaluationContext, 
				ISources.ACTIVE_EDITOR_NAME);
		isEnabled = 
				editorPart.getAdapter(IPremisesProvider.class) != null;
		super.setEnabled(evaluationContext);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selectionOfTagIdResources = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);

		IPremisesProvider premisesProvider = (IPremisesProvider) editorPart
				.getAdapter(IPremisesProvider.class);

		AddTagIdsAndTemplateWizard wizard = new AddTagIdsAndTemplateWizard();
		wizard.init(
				editorPart, 
				selectionOfTagIdResources, 
				premisesProvider.getPremises());
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		
		
		return null;
	}

}
