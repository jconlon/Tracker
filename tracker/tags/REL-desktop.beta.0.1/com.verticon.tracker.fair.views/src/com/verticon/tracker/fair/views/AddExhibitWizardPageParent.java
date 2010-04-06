package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface used by Add New Exhibit WizardPage specifying chaining callback
 * functionality between the New Exhibit WizardPages.
 * 
 * @author jconlon
 * 
 */
public interface AddExhibitWizardPageParent extends IWizardPage {
	Command getCommand(EObject eObject);
	
	boolean newTargetHasValue();
	
	IObservableValue getSelectedTarget();
}
