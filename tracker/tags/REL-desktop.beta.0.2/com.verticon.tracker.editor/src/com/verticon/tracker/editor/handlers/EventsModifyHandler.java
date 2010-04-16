/**
 * 
 */
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.ModifyEventsWizard;

/**
 * @author jconlon
 *
 */
public class EventsModifyHandler extends AbstractHandler implements IHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editorPart
		.getAdapter(IPremisesProvider.class);
		
		ModifyEventsWizard wizard = new ModifyEventsWizard();
		wizard.init(HandlerUtil.getActiveWorkbenchWindowChecked(event), 
				editingDomainProvider.getEditingDomain(), selection);
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}
}
