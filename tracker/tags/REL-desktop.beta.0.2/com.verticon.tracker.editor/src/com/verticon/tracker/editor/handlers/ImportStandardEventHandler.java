/**
 * 
 */
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.ImportStandardEventDataWizard;


/**
 * 
 * Handler for Importing Animal Events from CSV Logs.
 * Ticket#501
 * 
 * This class is working but the wizard it calls is 
 * not finished.  
 * @author jconlon
 *
 */
public class ImportStandardEventHandler extends AbstractHandler{
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		Premises premises = ((IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class)).getPremises();
		EditingDomain editingDomain = 
			((IEditingDomainProvider)editorPart.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		
		ImportStandardEventDataWizard wizard = new ImportStandardEventDataWizard();
		wizard.init(
				HandlerUtil.getActiveEditorChecked(event),  
				editingDomain,
				premises,
				HandlerUtil.getActiveMenuSelection(event));
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
