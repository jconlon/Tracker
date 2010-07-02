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
package com.verticon.tracker.fair.poi.presentation;
import static com.verticon.tracker.fair.poi.FairPoiPlugin.bundleMarker;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.editor.util.FairProcessor;
import com.verticon.tracker.fair.poi.exportxls.ExportFairBase;
import com.verticon.tracker.fair.poi.exportxls.FairRegistrationSummaryWorkSheetBuilder;
import com.verticon.tracker.fair.poi.exportxls.FairRegistrationWeighEventsInWorkSheetBuilder;
import com.verticon.tracker.fair.poi.exportxls.MovedInWorkSheetBuilder;
import com.verticon.tracker.fair.poi.exportxls.MovedOutWorkSheetBuilder;
import com.verticon.tracker.fair.poi.exportxls.WorkSheetBuilder;
import com.verticon.tracker.fair.poi.exportxls.XLSPremisesProcessor;

/**
 * 
 * Exports *.fair model details as spreadsheets.
 * 
 * @author jconlon
 * 
 */
public class ExportXlsWizard extends Wizard implements IExportWizard,
		IExecutableExtension {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ExportXlsWizard.class);
	
	private static final String WIZARD_TITLE = "Export Spreadsheet Data";

	/**
	 * Page to present the user with 3 radio buttons to 
	 * select the kind of report specified as an ExportType. 
	 * ExportType(s) of report are:
	 *<ul>
	 *<li>Fair Weigh In Events</li>
	 *<li>Fair Exhibit Summary</li>
	 *<li>Raw Events</li>
	 *</ul>
	 */
	private SelectExportTypeWizardPage selectExportTypePage;

	private SelectExportFilePathWizardPage selectExportFilePathPage;
	
	private IWorkbench workbench;

	/**
	 * 
	 * Specifies the type of report to export.
	 *
	 */
	enum ExportType {
		FAIR_WEIGHIN_EVENTS(
				"Fair Weigh In Events", "Raw WeighIn events, by Fair exhibitor."), 
		FAIR_SUMMARY(
				"Fair Exhibit Summary", "Fair exhibit summary that includes exhibitor, WieghIn event details, animals, and pins"),
		RAW_EVENTS(
				"Raw Events", "Raw MovedIn and MovedOut events by animal tag number.");
		
		String nameOfReport;
		String description;
		
		ExportType(String nameOfReport, String description){
			this.nameOfReport=nameOfReport;
			this.description=description;
		}
		/**
		 * Creates a FairProcessor for the ExportType
		 * @param destination of the output
		 * @return FairProcessor
		 */
		protected FairProcessor getProcessor(IPath destination) {
			XLSPremisesProcessor result = null;

			switch (this) {
			case FAIR_WEIGHIN_EVENTS:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[] { 
								new FairRegistrationWeighEventsInWorkSheetBuilder() },
						new String[] { 
								"Fair WeighIn Events" });
				break;

			case RAW_EVENTS:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[]{
								new MovedInWorkSheetBuilder(),
								new MovedOutWorkSheetBuilder()
						},
						new String[]{
								"MovedIn Events",
								"MovedOut Events"}
				);
				break;
			case FAIR_SUMMARY:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[] { 
								new FairRegistrationSummaryWorkSheetBuilder() },
						new String[] { 
								"Fair Registration" });
				break;
			}

			result.setFileName(destination.toString());
			return result;
		}
	}

	private ExportType typeToExport = ExportType.FAIR_SUMMARY;

	private IPath destination;

	private IFile premisesFile;


	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		selectExportTypePage = new SelectExportTypeWizardPage();
		addPage(selectExportTypePage);
		selectExportFilePathPage = new SelectExportFilePathWizardPage();
		addPage(selectExportFilePathPage);
		selectExportFilePathPage.init(premisesFile, typeToExport);
	}

	/**
	 * This method is called by the wizard framework when the user presses the
	 * Finish button.
	 */
	@Override
	public boolean performFinish() {

		destination = selectExportFilePathPage.getDestinationLocation();
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
			logger.error(bundleMarker,"Failed to export "+premisesFile.getProjectRelativePath().toString(), 
					e);
			selectExportFilePathPage.setErrorMessage("Failed to export "+premisesFile.getProjectRelativePath().toString()+": "+e.getCause());
			return false;
		} catch (InterruptedException e) {
			// User canceled, so stop but don�t close wizard.
			return false;
		}
		MessageDialog.openInformation(workbench.getActiveWorkbenchWindow().getShell(), 
				"Exported Premises Data", "Exported " +premisesFile.getProjectRelativePath().toString()+ 
				" as "+ typeToExport + " data to "
				+ destination );
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
		this.workbench=workbench;
		Object item = selection.getFirstElement();
		if (item instanceof IFile) {
			premisesFile = (IFile) item;
		} else {
			throw new IllegalArgumentException(
					"selection argument must be a premises document file.");
		}

	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		for (ExportType type : ExportType.values()) {
			if (type.name().equals(data)) {
				this.typeToExport = type;
			}
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
		new Exporter().export(monitor);
		logger.info(bundleMarker,"Exported {} as {} data to {}", 
				new Object[] {
				premisesFile.getProjectRelativePath(), 
				typeToExport,
				destination});
	}

	public ExportType getTypeToExport() {
		return typeToExport;
	}

	public void setTypeToExport(ExportType typeToExport) {
		this.typeToExport = typeToExport;
	}

	class Exporter extends ExportFairBase {
		public Exporter() {
			super(typeToExport.getProcessor(destination));
		}

		void export(IProgressMonitor monitor) throws IOException, CoreException {
			try {
				super.export(monitor, premisesFile);
			} catch (RuntimeException e) {
				logger.error(bundleMarker,"Failed to export.",e);
				throw e;
			}
		}
	}

}
