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
package com.verticon.tracker.views;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.actions.ChangeAnimalTypeSelectTypeWizardPage;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * Wizard for adding animals.
 * 
 * Pages:
 * <ul>
 * <li>Page to select the type of Animal</li>
 * <li>Page to select the tag id</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class AddAnimalWizard extends Wizard {

	private EObject parentContainer;
	private ChangeAnimalTypeSelectTypeWizardPage selectTypePage = null;
	private AddTagWizardPage addTagWizardPage = null;
	private static final String ADD_SECTION = "AddAnimal";
	private static final String ADD_CHANGE_TYPE_WIZARD = "AddAnimalWizard";
	private Collection<?> results;
	private IWorkbenchWindow workbenchWindow;
	private final Premises premises;

	public AddAnimalWizard(Premises premises) {
		IDialogSettings trackerSettings = TrackerReportEditorPlugin.getPlugin()
				.getDialogSettings();
		IDialogSettings wizardSettings = trackerSettings
				.getSection(ADD_CHANGE_TYPE_WIZARD);
		if (wizardSettings == null) {
			wizardSettings = trackerSettings
					.addNewSection(ADD_CHANGE_TYPE_WIZARD);
		}
		setDialogSettings(wizardSettings);
		this.premises=premises;
	}

    void init(IWorkbenchWindow workbenchWindow, EObject parentContainer) {
		this.workbenchWindow = workbenchWindow;
		this.parentContainer = parentContainer;
	}

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(ADD_SECTION);
		selectTypePage = new ChangeAnimalTypeSelectTypeWizardPage(
				new TrackerItemProviderAdapterFactory(),premises);
		selectTypePage
				.setDescription("Select the type of Animal you would like to create.");
		addPage(selectTypePage);
		addTagWizardPage = new AddTagWizardPage();
		addPage(addTagWizardPage);

	}

	@Override
	public boolean canFinish() {
		return getSelectedAnimal() != null && addTagWizardPage.getTag() != null;
	}

	/**
	 * Add an animal.
	 */
	@Override
	public boolean performFinish() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(parentContainer);
		Command command = createCommand();
		try {
			editingDomain.getCommandStack().execute(command);

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Add Animal Failed", "Failed to add "
							+ getSelectedAnimal().getClass().getSimpleName()
							+ " because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(),
				"Added Animal ", "Added a " + getSelectedAnimal().getType()
						+ " Animal to the model");
		results = command.getResult();
		return true;
	}

	Animal getSelectedAnimal() {
		return selectTypePage.getSelectedAnimal();
	}

	Collection<?> getResults() {
		return results;
	}

	/**
	 * 
	 * @return command to add an exhibit for each animal to the lot
	 */
	private Command createCommand() {
		Animal selectedTypeOfAnimal = getSelectedAnimal();
		Animal animalToAdd = (Animal) EcoreUtil.copy(selectedTypeOfAnimal);
		animalToAdd.getTags().add(addTagWizardPage.getTag());
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(parentContainer);

		Command command = AddCommand.create(editingDomain, // Domain
				parentContainer, // Owner
				TrackerPackage.Literals.PREMISES__ANIMALS, animalToAdd// value
				);

		return command;
	}

	private static class AddTagWizardPage extends WizardPage {

		private Text text;

		/**
		 * Displays the Person, the Lot, and the animal and asks confirmation to
		 * create the Exhibit
		 */
		protected AddTagWizardPage() {
			super("addTag");
			setTitle("Add Tag ID");
			setDescription("Add a Identification Tag to the animal.");
		}

		public void createControl(Composite parent) {
			Composite container = new Composite(parent, SWT.NULL);
			final GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			container.setLayout(gridLayout);
			setControl(container);
			createTagIdUI(container);
			setMessage(null);
			setErrorMessage(null);
			setPageComplete(true);
		}

		 Tag getTag() {
			Tag tag = TrackerFactory.eINSTANCE.createTag();
			tag.setId(text.getText());
			TagApplied tagApplied = TrackerFactory.eINSTANCE.createTagApplied();
			tag.getEvents().add(tagApplied);
			return tag;
		}

		/**
		 * @param container
		 */
		private void createTagIdUI(Composite container) {
			Label label = new Label(container, SWT.NULL);
			label.setText("Animal Tag Identification:");
			label.setBackground(container.getDisplay().getSystemColor(
					SWT.COLOR_YELLOW));

			text = new Text(container, SWT.BORDER);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 1;
			text.setLayoutData(gd);

			text.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					updatePageComplete();
				}
			});
		}

		/**
		 * Update the current page complete state based on the field content.
		 */
		private void updatePageComplete() {
			setPageComplete(false);

			if (text.getText().trim().length() < 1) {
				setMessage(null);
				setErrorMessage("Please enter the identification number.");
				return;
			}

			setPageComplete(true);

			setErrorMessage(null);
			setMessage(null);
			return;

		}

	}
}
