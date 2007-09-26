
package com.verticon.tracker.export.wlic.presentation;

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

import com.verticon.tracker.editor.util.ExportPremisesBase;
import com.verticon.tracker.editor.util.PremisesProcessor;
import com.verticon.tracker.export.wlic.ExportWlicLog;
import com.verticon.tracker.export.wlic.actions.WlicPremisesProcessor;


/**
 * Exports Premises document as WLIC Reports
 * 
 * @author jconlon
 *
 */
public class ExportWlicWizard extends Wizard implements IExportWizard {

	private static final String WIZARD_TITLE = "Export WLIC Report";

	private SelectExportDateRangeWizardPage selectExportDateRangePage;
	
	private PremisesProcessor premisesProcessor;
	
	private IWorkbench workbench;
	

	/**
	 * Creates a PremisesProcessor for the ExportType
	 * @param destination of the output
	 * @return
	 */
	public PremisesProcessor getProcessor() {
		if(premisesProcessor==null){
			premisesProcessor = new WlicPremisesProcessor();
		}
		return premisesProcessor;
	}
	


	private IFile premisesFile;


	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		selectExportDateRangePage = new SelectExportDateRangeWizardPage();
		addPage(selectExportDateRangePage);
	}
	
	/**
	 * This method is called by the wizard framework when the user presses the
	 * Finish button.
	 */
	public boolean performFinish() {

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
			ExportWlicLog.logError("Failed to export "+premisesFile.getProjectRelativePath().toString(), e);
			selectExportDateRangePage.setErrorMessage("Failed to export "+premisesFile.getProjectRelativePath().toString()+": "+e.getCause());
			return false;
		} catch (InterruptedException e) {
			// User canceled, so stop but don�t close wizard.
			return false;
		}
		MessageDialog.openInformation(workbench.getActiveWorkbenchWindow().getShell(), 
				"Exported Premises Data", getProcessor().getCompletionMessage());
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
		new Exporter().export(monitor);
		ExportWlicLog.logInfo(getProcessor().getCompletionMessage());
	}

	class Exporter extends ExportPremisesBase {
		public Exporter() {
			super(getProcessor());
		}

		void export(IProgressMonitor monitor) throws IOException, CoreException {
			super.export(monitor, premisesFile);
		}
	}

}
