package com.verticon.tracker.editor.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;

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

	public void run(IAction action) {

		InvocationTargetException ite = null;
		IWorkbenchWindow window = targetEditor.getSite().getWorkbenchWindow();

		try {
			window.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					IFile iFile = (IFile) targetEditor.getEditorInput()
							.getAdapter(IFile.class);
					Premises premises;

					try {
						premises = ActionUtils.getPremises(iFile);
						if (!ActionUtils.validate(premises,
								validationDiagnostics)) {
							throw new InvocationTargetException(
									new IOException(
											"Tracker Model is not valid.  Please create a validate model before exporting."));
						}

						if (premises == null) {
							throw new IOException("Could not find a premises");
						}

						premisesProcessor.process(premises, iFile, monitor);
						monitor.done();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ite == null) {
			MessageDialog.openInformation(targetEditor.getSite().getShell(),
					"Process Completed", premisesProcessor
							.getCompletionMessage());

		} else {
			MessageDialog.openError(targetEditor.getSite().getShell(),
					premisesProcessor.getFailureTitle(), ite.getCause()
							.getMessage());
		}

	}

}