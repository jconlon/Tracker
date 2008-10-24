package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;

/**
 * The WizardPage for creating an Exhibit. This page is the last page of
 * AddExhibitWizardPageParent WizardPages. It uses the callback functions of
 * AddExhibitWizardPageParent to call up to it's immediate parent WizardPage.
 * 
 * @see AddExhibitWizardPageParent#getCommand(EObject)
 * @author jconlon
 * @deprecated the name attribute is now derived.
 */
@Deprecated
public class AddExhibitWizardPage extends WizardPage implements
		AddExhibitWizardPageParent {
	final IObservableValue newTargetName = new WritableValue(null, String.class);
	final Fair fair;
	final AddExhibitWizardPageParent parentPage;

	private final class SingleDigitValidator implements IValidator {
		public IStatus validate(Object value) {
			String i = (String) value;
			if (i == null) {
				return ValidationStatus.info("Please enter a value.");
			}
			String s = (String) value;
			if (s == null || s.trim().length() < 1) {
				return ValidationStatus
						.info("Please enter a value for the Exhibit Name" + '.');
			}
			return ValidationStatus.ok();
		}
	}

	protected AddExhibitWizardPage(Fair fair, AddExhibitWizardPageParent parent) {
		super("Exhibit", "Add an Exhibit", ImageDescriptor
				.createFromImage(new Image(Display.getDefault(), 16, 16)));
		this.fair = fair;
		this.parentPage = parent;
	}

	public void createControl(Composite parent) {
		DataBindingContext dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);
		Composite composite = new Composite(parent, SWT.NONE);
		Label label = new Label(composite, SWT.NONE);
		label.setText("Enter a name for the Exhibit:");
		Text text = new Text(composite, SWT.BORDER);

		dbc.bindValue(SWTObservables.observeText(text, SWT.Modify),
				newTargetName, new UpdateValueStrategy()
						.setAfterConvertValidator(new SingleDigitValidator()),
				null);

		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(composite);
		setControl(composite);
	}

	public Command getCommand(EObject child) {
		if (newTargetHasValue()) {
			Exhibit exhibit = FairFactory.eINSTANCE.createExhibit();
//			exhibit.setName((String) newTargetName.getValue());
			return parentPage.getCommand(exhibit);

		}
		return parentPage.getCommand(null);
	}

	public boolean newTargetHasValue() {
		if (newTargetName.getValue() == null) {
			return false;
		}
		String s = (String) newTargetName.getValue();
		return s.trim().length() > 0;
	}

	public IObservableValue getSelectedTarget() {
		return null;
	}
}