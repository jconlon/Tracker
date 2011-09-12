package com.verticon.tracker.reader.event.comm;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderWizard;

/**
 * Two page Wizard for creating a SerialPortReader.
 * 
 * <nl>
 * <li>Page to specify a free comm port.</li>
 * <li>Page to specify the parameters for specifying a connection to a comm port.</li>
 * </nl>
 * 
 * @author jconlon
 * 
 */
public class SerialPortReaderWizard extends Wizard implements IReaderWizard {

	private static final String WIZARD_TITLE = "Add a SerialPortReader";
	
	
	/**
	 * Finished product of this Wizard
	 */
	private IReader reader;
	
	/**
	 * First Page to specify the comm port.
	 */
	private SpecifyCommPortWizardPage firstPage;
	
	/**
	 * Second Page to specify the parameters of the comm port.
	 */
	private SpecifyCommPortParmsWizardPage secondPage;
	
	
	public IReader getReader() {
		return reader;
	}

	/**
	 * Sets up the workbench.
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
//		this.workbench = workbench;
	}

	
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		this.firstPage = new SpecifyCommPortWizardPage("Specify a Comm Port");
		addPage(firstPage);
		
		this.secondPage = new SpecifyCommPortParmsWizardPage("Specify a Comm Port Parameters");
		addPage(secondPage);
		
		
	}

	public boolean canFinish() {
		return firstPage!=null && firstPage.getSelectedPortName()!=null;
	}
	
	public boolean performFinish() {
		reader = new SerialPortReader();
		String portName = firstPage.getSelectedPortName();
		String sTarget = secondPage.getCommURI(portName);
		URI target = null;
		try {
			target = new URI(sTarget);
		} catch (URISyntaxException e) {
			secondPage.setErrorMessage(e.getMessage());
			return false;
		}
		
		reader.setTarget(target);
		return true;
	}
	
	

}
