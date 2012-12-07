package com.verticon.birt.report.loader.ui.popup;

import static com.verticon.birt.report.loader.ui.Activator.PLUGIN_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class CopyReportHandler extends AbstractHandler implements IHandler {

	/**
	 * BIRT Viewer plugin working path
	 */
	private final static String BIRT_VIEWER_WORKING_PATH = "birt.viewer.working.path"; //$NON-NLS-1$

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
		if (selection.isEmpty()) {
			throw new ExecutionException("Selected report cannot be empty.");
		}

		String wp = System.getProperty(BIRT_VIEWER_WORKING_PATH);
		if (wp != null) {
			File workingPath = new File(wp);

			if (workingPath.isDirectory()) {
				File path = new File(workingPath, "report");
				if (!path.exists()) {
					path.mkdir();
				}

				copyTo(getSelectedResource(selection), path,
						HandlerUtil.getActiveShell(event));

			} else {
				throw new ExecutionException(wp + "not a directory");
			}
		} else {

			throw new ExecutionException(
					"ReportViewer Servlet Working path is null");
		}
		return null;
	}

	private void copyTo(File selection, File workingPath, Shell shell) {
		File target = new File(workingPath, selection.getName());
		if (target.exists()) {
			// show dialog that file exists
			boolean copy = MessageDialog
					.openQuestion(
							shell,
							"File Exists in Working Path",
							"The file "
									+ selection.getName()
									+ " already exists. Would you like to overwrite it?");
			if (!copy) {
				return;
			}
		}

		// copy it
		try {
			InputStream in = new FileInputStream(selection);
			OutputStream out = new FileOutputStream(target);
			byte buf[] = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			out.close();
			in.close();
			String message = "Copied " + selection.getName() + " to "
					+ workingPath;
			// Send a message to the user
			MessageDialog.openInformation(shell,
					"Copy Report to Shared Report Folder...", message);
		} catch (IOException e) {
			ErrorDialog.openError(shell, "File Copy Error",
					"Could not copy file.", new Status(Status.ERROR, PLUGIN_ID,
							"Failed to copy file.", e));

		}

	}

	private static File getSelectedResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection)
					.getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}

}
