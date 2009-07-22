/**
 * 
 */
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/**
 * Selects the animals in the Outline view. 
 * 
 * @author jconlon
 *
 */
public class GenericSelectInOutlineHandler extends AbstractHandler  {

//	/**
//	 *  workaround for  https://bugs.eclipse.org/bugs/show_bug.cgi?id=201743 
//	 *  Scheduled for fix in 3.5
//	 *  FIXME isEnabled
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
//		isEnabled = editorPart!=null && editorPart.getAdapter(IContentOutlinePage.class) != null;
//		super.setEnabled(evaluationContext);
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);

		IContentOutlinePage contentOutlinePage = (IContentOutlinePage)editorPart.getAdapter(IContentOutlinePage.class);
		contentOutlinePage.setSelection(selection);
		return null;
	}

}
