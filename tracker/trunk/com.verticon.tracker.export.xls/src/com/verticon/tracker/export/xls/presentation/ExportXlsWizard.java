/**
 * 
 */
package com.verticon.tracker.export.xls.presentation;

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

import com.verticon.tracker.editor.util.ExportPremisesBase;
import com.verticon.tracker.editor.util.PremisesProcessor;
import com.verticon.tracker.export.xls.ExportXlsLog;
import com.verticon.tracker.export.xls.actions.FairRegistrationSummaryWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.FairRegistrationWeighInWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.FairRegistrationWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.MovedInWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.MovedOutWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.WeighInWorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.WorkSheetBuilder;
import com.verticon.tracker.export.xls.actions.XLSPremisesProcessor;

/**
 * 
 * Exports Premises document FairRegistration events as spreadsheets.
 * 
 * @author jconlon
 * 
 */
public class ExportXlsWizard extends Wizard implements IExportWizard,
		IExecutableExtension {

	private static final String WIZARD_TITLE = "Export Spreadsheet Data";

	private SelectExportTypeWizardPage selectExportTypePage;

	private SelectExportFilePathWizardPage selectExportFilePathPage;
	
	private IWorkbench workbench;

	/**
	 * 
	 * Defines the Export Type
	 *
	 */
	public enum ExportType {
		DETAIL, SUMMARY, RAW;
		
		/**
		 * Creates a PremisesProcessor for the ExportType
		 * @param destination of the output
		 * @return
		 */
		public PremisesProcessor getProcessor(IPath destination) {
			XLSPremisesProcessor result = null;

			switch (this) {
			case DETAIL:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[] { new FairRegistrationWeighInWorkSheetBuilder() },
						new String[] { "Fair WeighIn and Registration" });
				break;

			case RAW:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[]{
								new FairRegistrationWorkSheetBuilder(),
								new WeighInWorkSheetBuilder(),
								new MovedInWorkSheetBuilder(),
								new MovedOutWorkSheetBuilder()
						},
						new String[]{
								"Fair Registration Events",
								"Fair WeighIn Events",
								"MovedIn Events",
								"MovedOut Events"}
				);
				break;
			case SUMMARY:
				result = new XLSPremisesProcessor(
						new WorkSheetBuilder[] { new FairRegistrationSummaryWorkSheetBuilder() },
						new String[] { "Fair Registration" });
				break;
			}

			result.setFileName(destination.toString());
			return result;
		}
	}

	private ExportType typeToExport = ExportType.SUMMARY;

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
			ExportXlsLog.logError("Failed to export "+premisesFile.getProjectRelativePath().toString(), e);
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
		ExportXlsLog.logInfo("Exported " +premisesFile.getProjectRelativePath().toString()+ 
				" as "+ typeToExport + " data to "
				+ destination );
	}

	public ExportType getTypeToExport() {
		return typeToExport;
	}

	public void setTypeToExport(ExportType typeToExport) {
		this.typeToExport = typeToExport;
	}

	class Exporter extends ExportPremisesBase {
		public Exporter() {
			super(typeToExport.getProcessor(destination));
		}

		void export(IProgressMonitor monitor) throws IOException, CoreException {
			super.export(monitor, premisesFile);
		}
	}

}
