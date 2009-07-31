/**
 * 
 */
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/**
 * Selects the animals in the Outline view. 
 * 
 * @author jconlon
 *
 */
public class GenericSelectInOutlineHandler extends AbstractHandler  {

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
