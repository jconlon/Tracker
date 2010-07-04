/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.poi.exportxls;

import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_VALIDATE_BEFORE_EXPORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorPart;

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

	private List<Diagnostic> validationDiagnostics = new ArrayList<Diagnostic>();
	protected IEditorPart targetEditor;
	private final FairProcessor premisesProcessor;

	public ExportFairBase(FairProcessor premisesProcessor) {
		this.premisesProcessor = premisesProcessor;

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
		IPreferenceStore store = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
		boolean validateBeforeExport = store.getBoolean(P_VALIDATE_BEFORE_EXPORT);
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

/* TODO UCdetector: Remove unused code: 
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
*/

	private static boolean validate(Fair fair,
			List<Diagnostic> validationDiagnostics) {
		validationDiagnostics.clear();
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(fair);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			validationDiagnostics.add(diagnostic);
		}
		return validationDiagnostics.isEmpty();
	}
	
	private static Fair getFair(IFile file) throws IOException {
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