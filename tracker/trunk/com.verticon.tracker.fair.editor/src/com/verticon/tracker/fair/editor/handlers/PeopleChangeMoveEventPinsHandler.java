/**
 * 
 */
package com.verticon.tracker.fair.editor.handlers;

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
import com.verticon.tracker.fair.editor.presentation.UpdatePinsWizard;

/**
 * @author jconlon
 *
 */
public class PeopleChangeMoveEventPinsHandler extends AbstractHandler implements
		IHandler {

//	/**
//	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
//	 *  Scheduled for fix in 3.5
//	 */
//	private boolean isEnabled;
//	
//	/**
//	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
//	 *  Scheduled for fix in 3.5
//	 */
//	@Override
//	public boolean isEnabled() {
//		return isEnabled;
//	}
//
//	/**
//	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
//	 *  Scheduled for fix in 3.5
//	 */
//	@Override
//	public void setEnabled(Object evaluationContext) {
//		IEditorPart editorPart = (IEditorPart) HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
//		isEnabled = editorPart.getAdapter(IEditingDomainProvider.class) != null;
//		super.setEnabled(evaluationContext);
//	}
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editorPart
		.getAdapter(IPremisesProvider.class);
		
		UpdatePinsWizard wizard = new UpdatePinsWizard();
		wizard.init(HandlerUtil.getActiveWorkbenchWindowChecked(event), 
				editingDomainProvider.getEditingDomain(), 
				selection);
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
