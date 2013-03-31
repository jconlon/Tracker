package com.verticon.osgi.useradmin.ui.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.osgi.useradmin.ui.ResetPasswordDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ChangePasswordHandler extends AbstractHandler {
	private static final String TITLE = "User Signon";

	/**
	 * The constructor.
	 */
	public ChangePasswordHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Prompt for userName and password

		ResetPasswordDialog dialog = new ResetPasswordDialog(
				HandlerUtil.getActiveShell(event));
		dialog.create();

		if (dialog.open() == Window.OK) {
			String currentPassword = dialog.getCurrentPassword();
			String password = dialog.getPassword();
			try {
				Activator.getDefault()
						.changePassword(currentPassword, password);

					MessageDialog.openInformation(
							HandlerUtil.getActiveShell(event), TITLE,
						"Changed password.");

			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						TITLE, e.getLocalizedMessage());
			}
		}
		return null;
	}
}
