package com.verticon.tracker.editor.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * Base class for exporting Excel spreadsheets. Subclasses only need to set the
 * premiseProcessor in a super call to the constructor.
 * 
 * @author jconlon
 * 
 */
public class ExportPremisesBase {

	protected List<Diagnostic> validationDiagnostics = new ArrayList<Diagnostic>();
	protected IEditorPart targetEditor;
	protected final PremisesProcessor premisesProcessor;

	public ExportPremisesBase(PremisesProcessor premisesProcessor) {
		this.premisesProcessor = premisesProcessor;

	}

	public void selectionChanged(IAction action, ISelection selection) {

	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.targetEditor = targetEditor;

	}
	
	/**
	 * @param monitor
	 * @param iFile
	 * @throws IOException
	 * @throws CoreException
	 */
	protected void export(IProgressMonitor monitor, IFile iFile)
			throws IOException, CoreException {
		Premises premises;
		premises = ActionUtils.getPremises(iFile);
		Preferences store = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
		boolean validateBeforeExport = store.getBoolean(PreferenceConstants.P_VALIDATE_BEFORE_EXPORT);
		if (validateBeforeExport && !ActionUtils.validate(premises,
				validationDiagnostics)) {
			throw new IOException(
							"Tracker Model is not valid.  Please create a validate model before exporting.");
		}

		if (premises == null) {
			throw new IOException("Could not find a premises");
		}

		premisesProcessor.process(premises, iFile, monitor);
		monitor.done();
	}

	public void run(IAction action) {

		InvocationTargetException ite = null;
		
		IWorkbenchWindow window = targetEditor.getSite().getWorkbenchWindow();

		try {
			window.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					IFile iFile = (IFile) targetEditor.getEditorInput()
							.getAdapter(IFile.class);
				

					try {
						export(monitor, iFile);

					} catch (IOException e) {
						throw new InvocationTargetException(e);

					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}

				
			});
		} catch (InvocationTargetException e) {
			ite = e;

		} catch (InterruptedException e) {

		}

		if (ite == null) {
			MessageDialog.openInformation(targetEditor.getSite().getShell(),
					"Process Completed", premisesProcessor
							.getCompletionMessage());

		} else {
			MessageDialog.openError(
					targetEditor.getSite().getShell(),
					premisesProcessor.getFailureTitle(), //
				    "Process Failed because: "+
				    ite.getTargetException()==null?ite.toString():
				    	ite.getTargetException().getLocalizedMessage());
		}

	}

}