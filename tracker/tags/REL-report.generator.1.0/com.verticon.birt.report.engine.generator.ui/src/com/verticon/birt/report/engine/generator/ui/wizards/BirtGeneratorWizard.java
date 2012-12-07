package com.verticon.birt.report.engine.generator.ui.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import com.verticon.birt.report.engine.generator.EmitterType;
import com.verticon.birt.report.engine.generator.GeneratorFactory;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "rtpdesign". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class BirtGeneratorWizard extends Wizard implements INewWizard {
	private BirtGeneratorWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for BirtGeneratorWizard.
	 */
	public BirtGeneratorWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	@Override
	public void addPages() {
		page = new BirtGeneratorWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {
		final File reportsDirectory = page.getReportsDirectory();
		final File destinationDirectory = page.getDestinationDirectory();
		final File reportParameters = page.getReportsParameters();
		final EmitterType emitterType = page.getEmitterType();
		final boolean clearDestinationDirectory = page
				.isClearDestinationDirectory();

		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(reportsDirectory, destinationDirectory,
							reportParameters, emitterType,
							clearDestinationDirectory, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */
	private void doFinish(File reportsDirectory, File destinationDirectory,
			File parametersReport,
			EmitterType emitterType, boolean clearDestinationBeforeGeneration,
		IProgressMonitor monitor)
		throws CoreException {

		try {
			GeneratorFactory.getGenerator().generate(parametersReport,
					reportsDirectory,
					clearDestinationBeforeGeneration,
					destinationDirectory, emitterType, monitor);
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					"com.verticon.birt.report.engine.generator.ui",
					"Failed to generate reports", e));
		}

	}
	

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}