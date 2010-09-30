package com.verticon.tracker.export.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.util.FairProcessor;

/**
 * Base class for exporting Excel spreadsheets. Subclasses only need to set the
 * premiseProcessor in a super call to the constructor.
 * 
 * @author jconlon
 * 
 */
public class ExportFairBase {

	protected List<Diagnostic> validationDiagnostics = new ArrayList<Diagnostic>();
	protected IEditorPart targetEditor;
	protected final FairProcessor premisesProcessor;

	public ExportFairBase(FairProcessor premisesProcessor) {
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
		Fair fair = getFair(iFile);
		Preferences store = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
		boolean validateBeforeExport = store.getBoolean(PreferenceConstants.P_VALIDATE_BEFORE_EXPORT);
		if (validateBeforeExport && !validate(fair,
				validationDiagnostics)) {
			throw new IOException(
							"Fair Model is not valid.  Please create a valid model before exporting.");
		}

		if (fair == null) {
			throw new IOException("Could not find a fair");
		}

		premisesProcessor.process(fair, iFile, monitor);
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

	public static boolean validate(Fair fair,
			List<Diagnostic> validationDiagnostics) {
		validationDiagnostics.clear();
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(fair);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			validationDiagnostics.add(diagnostic);
		}
		return validationDiagnostics.isEmpty();
	}
	
	public static Fair getFair(IFile file) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		if (resource.getContents().get(0) instanceof Fair) {
			return (Fair) resource.getContents().get(0);
		}
		throw new IOException("Cannot process the file " + file.getName()
				+ ", because it is not a Fair Model Document!");
	}
}