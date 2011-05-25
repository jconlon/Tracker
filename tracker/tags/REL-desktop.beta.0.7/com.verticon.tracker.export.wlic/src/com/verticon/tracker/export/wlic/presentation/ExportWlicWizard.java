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

package com.verticon.tracker.export.wlic.presentation;

import static com.verticon.tracker.export.wlic.ExportWlicPlugin.bundleMarker;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.editor.util.ExportPremisesBase;
import com.verticon.tracker.editor.util.PremisesProcessor;
import com.verticon.tracker.export.wlic.actions.WlicPremisesProcessor;


/**
 * Exports Premises document as WLIC Reports
 * 
 * @author jconlon
 *
 */
public class ExportWlicWizard extends Wizard implements IExportWizard {

	private static final String WIZARD_TITLE = "Export WLIC Report";
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ExportWlicWizard.class);

	private SelectExportDateRangeWizardPage selectExportDateRangePage;
	
	private WlicPremisesProcessor premisesProcessor;
	
	private IWorkbench workbench;
	
	private IFile premisesFile;

	@Override
	public boolean canFinish() {
		return selectExportDateRangePage.getQueryFromDate()!=null;
	}

	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		selectExportDateRangePage = new SelectExportDateRangeWizardPage();
		addPage(selectExportDateRangePage);
		selectExportDateRangePage.init(premisesFile);
	}
	
	/**
	 * This method is called by the wizard framework when the user presses the
	 * Finish button.
	 */
	@Override
	public boolean performFinish() {

		premisesProcessor= new WlicPremisesProcessor(selectExportDateRangePage.getQueryFromDate());
		// Perform the operation in a separate thread
		// so that the operation can be canceled.
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						performOperation(monitor);
					} catch (IOException e) {
						throw new InvocationTargetException(e);

					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (InvocationTargetException e) {
			logger.error(bundleMarker,
					"Failed to export "+premisesFile.getProjectRelativePath().toString(), 
					e);
			selectExportDateRangePage.setErrorMessage("Failed to export "+premisesFile.getProjectRelativePath().toString()+": "+e.getCause());
			return false;
		} catch (InterruptedException e) {
			// User canceled, so stop but don�t close wizard.
			return false;
		}
		MessageDialog.openInformation(workbench.getActiveWorkbenchWindow().getShell(), 
				"Exported Premises Data", premisesProcessor.getCompletionMessage());
		return true;
	}
	/**
	 * Initializes this creation wizard using the passed workbench and object
	 * selection. This method is called after the no argument constructor and
	 * before other methods are called.
	 * 
	 * @param workbench
	 *            the current workbench
	 * @param selection
	 *            the current object selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		Object item = selection.getFirstElement();
		if (item instanceof IFile) {
			premisesFile = (IFile) item;
		} else {
			throw new IllegalArgumentException(
					"selection argument must be a premises document file.");
		}
	}
	
	/**
	 * Called by the performFinish method on a separate thread to extract
	 * strings from the source file.
	 * 
	 * @param monitor
	 *            the progress monitor
	 * @throws CoreException
	 * @throws IOException
	 */
	private void performOperation(IProgressMonitor monitor) throws IOException,
			CoreException {
		new Exporter(premisesProcessor).export(monitor);
		logger.info(bundleMarker,premisesProcessor.getCompletionMessage());
	}

	class Exporter extends ExportPremisesBase {
		protected Exporter(PremisesProcessor premisesProcessor) {
			super(premisesProcessor);
		}

		void export(IProgressMonitor monitor) throws IOException, CoreException {
			super.export(monitor, premisesFile);
		}
	}

}
