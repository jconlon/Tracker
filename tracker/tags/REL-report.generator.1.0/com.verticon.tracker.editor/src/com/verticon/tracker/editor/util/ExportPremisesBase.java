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
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_VALIDATE_BEFORE_EXPORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * Base class for exporting Excel spreadsheets. Subclasses only need to set the
 * premiseProcessor in a super call to the constructor.
 * 
 * @author jconlon
 * 
 */
public class ExportPremisesBase {

	private List<Diagnostic> validationDiagnostics = new ArrayList<Diagnostic>();
	protected IEditorPart targetEditor;
	private final PremisesProcessor premisesProcessor;

	public ExportPremisesBase(PremisesProcessor premisesProcessor) {
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
		Premises premises;
		premises = TrackerEditorUtils.getPremises(iFile);
		IPreferenceStore store = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
		boolean validateBeforeExport = store.getBoolean(P_VALIDATE_BEFORE_EXPORT);
		if (validateBeforeExport && !TrackerEditorUtils.validate(premises,
				validationDiagnostics)) {
			throw new IOException(
							"Tracker Model is not valid.  Please create a valid model before exporting.");
		}

		if (premises == null) {
			throw new IOException("Could not find a premises");
		}

		premisesProcessor.process(premises, iFile, monitor);
		monitor.done();
	}

	

}