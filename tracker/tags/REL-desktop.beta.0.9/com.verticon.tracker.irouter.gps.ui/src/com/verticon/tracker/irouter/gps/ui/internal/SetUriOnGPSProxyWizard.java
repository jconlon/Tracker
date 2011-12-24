package com.verticon.tracker.irouter.gps.ui.internal;

import static com.verticon.tracker.irouter.gps.ui.internal.bundle.Activator.bundleMarker;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.Attribute;
import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.tracker.irouter.gps.ui.IURIWizard;

/**
 * Referenced by the org.eclipse.ui.newWizards extension. Creates one Wizard
 * page.
 * 
 * @see GPSDeviceWizardSelectionPage
 * @author jconlon
 * 
 */
public class SetUriOnGPSProxyWizard extends Wizard implements INewWizard {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SetUriOnGPSProxyWizard.class);
	private static final String CONNECTION_URI_ATTRIBUTE_REFERENCE = "connection.uri";
	private static final String WIZARD_TITLE = "Add an GPS Producer";
	private GPSDeviceWizardSelectionPage uriWizardSelection;
	private IWorkbench workbench;
	private EObject targetEObject;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SetUriOnGPSProxyWizard []";
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		logger.debug(bundleMarker, "{} initializing", this);
		setWindowTitle(WIZARD_TITLE);
		Designate designate = (Designate) ((IStructuredSelection) selection)
				.getFirstElement();
		this.targetEObject = getUriAttribute(designate);
		this.workbench = workbench;
	}

    static Attribute getUriAttribute(Designate designate) {
    	Attribute result = null;
    	if(designate.getObject()!=null && !designate.getObject().getAttribute().isEmpty()){
    		for (Attribute attribute : designate.getObject().getAttribute()) {
    			if (attribute.getAdref().equals(CONNECTION_URI_ATTRIBUTE_REFERENCE)) {
    				result = attribute;
    				break;
    			}
    		}
    	}
		return result;
	}

	@Override
	public boolean performFinish() {
		IWizardNode wizardNode = uriWizardSelection.getSelectedNode();
		IURIWizard publisherWizard = (IURIWizard) wizardNode.getWizard();
		if (publisherWizard == null || publisherWizard.getURI() == null) {
			return false;
		}
		String value = publisherWizard.getURI().toString();

		logger.debug(bundleMarker, "{} Selected Device Service uri={}", this,
				value);
		
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(targetEObject);
		
		Object currentValue = ((Attribute)targetEObject).getValue().isEmpty()?null:
			((Attribute)targetEObject).getValue().get(0);
		
		CompoundCommand cc = new CompoundCommand();
		Command command;
		if(currentValue!=null){
			command = RemoveCommand.create(editingDomain, 
					targetEObject, 
					MetatypePackage.eINSTANCE.getAttribute_Value(),
					currentValue);
			cc.append(command);		 
		}
		command = AddCommand.create(
					editingDomain, 
					targetEObject,
					MetatypePackage.eINSTANCE.getAttribute_Value(), 
					value);
		cc.append(command);
		
		
		editingDomain.getCommandStack().execute(cc);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		uriWizardSelection = new GPSDeviceWizardSelectionPage(workbench);
		addPage(uriWizardSelection);
	}

	@Override
	public boolean canFinish() {
		return uriWizardSelection.isPageComplete();
	}

}
