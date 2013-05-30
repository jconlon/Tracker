package com.verticon.osgi.useradmin.ui.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.Iterables;
import com.verticon.osgi.useradmin.ui.UserAuthenticateDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SignOnHandler extends AbstractHandler {
	private static final String TITLE = "User Signon";

	/**
	 * The constructor.
	 */
	public SignOnHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Select the userAdmin service
		Iterable<String> userAdminServices = Activator.getDefault()
				.userAdminURIs();

		if (Iterables.isEmpty(userAdminServices)) {

			MessageDialog.openError(HandlerUtil.getActiveShell(event), TITLE,
					"Failed to find any userAdmin services.");
			return null;
		}

		// find the authenticator
		Shell shell = HandlerUtil.getActiveShell(event);
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, new LabelProvider());
		dialog.setElements(Iterables.toArray(userAdminServices, String.class));
		dialog.setAllowDuplicates(false);
		dialog.setMultipleSelection(false);
		dialog.setMessage("Choose the URI of the UserAdmin implementation.");
		dialog.setTitle("Choose UserAdmin Implementation");
		// User pressed cancel
		if (dialog.open() != Window.OK) {
			return false;
		}
		Object[] result = dialog.getResult();
		String uri = (String) result[0];

		// Prompt for userName and password
		UserAuthenticateDialog dialog2 = new UserAuthenticateDialog(
				HandlerUtil.getActiveShell(event), uri);
		dialog2.create();

		if (dialog2.open() == Window.OK) {
			String userName = dialog2.getUserName();
			String password = dialog2.getPassword();
			try {
				Activator.getDefault().authenticate(userName, password, uri);
				if (Activator.getDefault().isAuthenticatedUser()) {
					MessageDialog.openInformation(HandlerUtil
							.getActiveShell(event), TITLE, String.format(
							"Authenticated %s on UserAdmin Service: %s",
							userName, uri));
				} else {
					MessageDialog.openError(HandlerUtil.getActiveShell(event),
							TITLE, "Failed Authenicatication!");
				}
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						TITLE, e.getLocalizedMessage());
			}
		}
		return null;
	}
}
