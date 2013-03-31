package com.verticon.osgi.useradmin.ui.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SignOffHandler extends AbstractHandler {
	private static final String TITLE = "User Signoff";

	/**
	 * The constructor.
	 */
	public SignOffHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Prompt to confirm
		if (MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), TITLE,
				"Do you really want to sign off?")) {
			Activator.getDefault().removeAuthorization();
		}
		return null;
	}
}
