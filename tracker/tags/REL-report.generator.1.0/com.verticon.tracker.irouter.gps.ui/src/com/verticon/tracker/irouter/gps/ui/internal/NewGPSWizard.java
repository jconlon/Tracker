package com.verticon.tracker.irouter.gps.ui.internal;

import static com.verticon.tracker.irouter.gps.ui.internal.bundle.Activator.bundleMarker;

import java.net.URI;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.gps.ui.IURIWizard;

/**
 * Referenced by the org.eclipse.ui.newWizards extension.  Creates one 
 * Wizard page.
 * 
 * @see GPSDeviceWizardSelectionPage
 * @author jconlon
 *
 */
public class NewGPSWizard extends Wizard implements INewWizard {
	

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(NewGPSWizard.class);


	private static final String WIZARD_TITLE = "Add an GPS Producer";
	
	private GPSDeviceWizardSelectionPage uriWizardSelection;
	private IWorkbench workbench;
	
	public NewGPSWizard() {
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NewGPSWizard []";
	}


	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		logger.debug(bundleMarker, "{} initializing", this );
		setWindowTitle(WIZARD_TITLE);
		this.workbench = workbench;
	}

	@Override
	public boolean performFinish() {
		IWizardNode wizardNode = uriWizardSelection.getSelectedNode();
		IURIWizard publisherWizard = (IURIWizard) wizardNode
				.getWizard();
		if (publisherWizard == null || publisherWizard.getURI() == null) {
			return false;
		}
		URI uri = publisherWizard.getURI();
		//TODO create a Proxy and add it to the configuration admin
		logger.debug(bundleMarker, "{} Selected Device Service uri={}", 
				this,
				uri );
		
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		uriWizardSelection = new GPSDeviceWizardSelectionPage(workbench);
		addPage(uriWizardSelection);
	}

	@Override
	public boolean canFinish() {
		return uriWizardSelection.isPageComplete();
	}
}
