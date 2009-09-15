/**
 * 
 */
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.AddTemplateToAnimalsWizard;

/**
 * Handler that invokes a Wizard to add Template Events to a Selection 
 * of Animals
 * 
 * @author jconlon
 *
 */
public class AnimalsAddTemplateEventHandler extends AbstractHandler implements
		IHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		
		AddTemplateToAnimalsWizard wizard = new AddTemplateToAnimalsWizard();
		wizard.init(editorPart, selection);
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
