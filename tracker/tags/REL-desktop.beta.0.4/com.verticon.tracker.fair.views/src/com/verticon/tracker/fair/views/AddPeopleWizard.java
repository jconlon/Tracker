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
/**
 * 
 */
package com.verticon.tracker.fair.views;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;

/**
 * Wizard for adding a person.
 * 
 * Pages:
 * <ul>
 * <li>Page to enter name and type of person.</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class AddPeopleWizard extends Wizard {

	private final AddPeopleWizardModel model = new AddPeopleWizardModel();
	private IWorkbenchWindow workbenchWindow;
	private Fair fair;
	private Collection<?> results;

	private ObservablesManager observablesManager = new ObservablesManager();

	
	AddPeopleWizard() {
		super();
		observablesManager.addObservable(model.firstNameValue);
		observablesManager.addObservable(model.isYoungPerson);
		observablesManager.addObservable(model.lastNameValue);
	}

	@Override
	public void dispose() {
		observablesManager.dispose();
		super.dispose();
	}
	
	@Override
	public void addPages() {
		addPage(new FirstWizardPage());
	}

	@Override
	public String getWindowTitle() {
		return "Add a Person";
	}

	/**
	 * Add an animal.
	 */
	@Override
	public boolean performFinish() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(fair);
		Command command = createCommand();
		try {
			editingDomain.getCommandStack().execute(command);

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Add Person Failed", "Failed to add "
							+ getModel().lastNameValue.getValue()
							+ " because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(),
				"Added Person ", "Added a "
						+ getModel().lastNameValue.getValue()
						+ " Person to the model");

		results = command.getResult();
		return true;
	}

	void init(IWorkbenchWindow workbenchWindow, Fair fair) {
		this.workbenchWindow = workbenchWindow;
		this.fair = fair;
	}

	Collection<?> getResults() {
		return results;
	}

	private static class AddPeopleWizardModel {
		final IObservableValue firstNameValue = new WritableValue(null,
				String.class);
		final IObservableValue lastNameValue = new WritableValue(null,
				String.class);
		final IObservableValue isYoungPerson = new WritableValue(null,
				Boolean.class);

	}

	private Fair getFair() {
		return fair;
	}

	private AddPeopleWizardModel getModel() {
		return model;
	}

	private boolean isYoungPerson() {
		return getModel().isYoungPerson.getValue() == null ? false
				: ((Boolean) getModel().isYoungPerson.getValue())
						.booleanValue();
	}

	/**
	 * 
	 * @return command to add an exhibit for each animal to the lot
	 */
	private Command createCommand() {
		Fair fair = getFair();
		Person person;
		if (isYoungPerson()) {
			person = FairFactory.eINSTANCE.createYoungPerson();
		} else {
			person = FairFactory.eINSTANCE.createPerson();
		}
		person.setFirstName(getModel().firstNameValue.getValue().toString());
		person.setLastName(getModel().lastNameValue.getValue().toString());

		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(fair);

		Command command = AddCommand.create(editingDomain, // Domain
				fair, // Owner
				FairPackage.Literals.FAIR__PEOPLE, person// value
				);

		return command;
	}

	private static class FirstWizardPage extends WizardPage {

		private final class NonNullStringValidator implements IValidator {

			public NonNullStringValidator(String name) {
				super();
				this.name = name;
			}

			final String name;

			public IStatus validate(Object value) {
				String s = (String) value;
				if (s == null || s.trim().length() < 1) {
					return ValidationStatus.info("Please enter a value for "
							+ name + '.');
				}
				return ValidationStatus.ok();
			}
		}

		protected FirstWizardPage() {
			super("Person", "Enter a Person Details", 
					ViewsPlugin.imageDescriptorFromPlugin("icons/Person.gif"));
		}

		public void createControl(Composite parent) {
			DataBindingContext dbc = new DataBindingContext();
			WizardPageSupport.create(this, dbc);
			Composite composite = new Composite(parent, SWT.NONE);
			setPageComplete(false);

			// First name
			Label label = new Label(composite, SWT.NONE);
			label.setText("Enter a first name:");
			Text text = new Text(composite, SWT.BORDER);
			dbc
					.bindValue(
							SWTObservables.observeText(text, SWT.Modify),
							((AddPeopleWizard) getWizard()).getModel().firstNameValue,
							new UpdateValueStrategy()
									.setAfterConvertValidator(new NonNullStringValidator(
											"the first name")), null);

			// Last name
			label = new Label(composite, SWT.NONE);
			label.setText("Enter a last name:");
			text = new Text(composite, SWT.BORDER);
			dbc
					.bindValue(
							SWTObservables.observeText(text, SWT.Modify),
							((AddPeopleWizard) getWizard()).getModel().lastNameValue,
							new UpdateValueStrategy()
									.setAfterConvertValidator(new NonNullStringValidator(
											"the last name")), null);

			// isYoungPerson name
			label = new Label(composite, SWT.NONE);
			label.setText("Is a Young Person:");
			Button isYoungPersonButton = new Button(composite, SWT.CHECK);

			dbc.bindValue(SWTObservables.observeSelection(isYoungPersonButton),
					((AddPeopleWizard) getWizard()).getModel().isYoungPerson,
					null, null);

			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(
					composite);
			setControl(composite);
		}
	}

}
