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
package com.verticon.tracker.fair.editor.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;

/**
 * Wizard for updating Source/DestinationPins on one or more Movedxxx events.
 * Which animals to target and Pins to use is based on an initial set of
 * selected Persons. Exhibits are used to find the animals related to the
 * people.
 * 
 * Wizard that is called from People elements.
 * 
 * Pages:
 * <ul>
 * <li>Page to select a Person to associate with the Animal</li>
 * <li>Page to select the enclosing Lot in which to create the Exhibit</li>
 * <li>Page to create the Exhibit</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class UpdatePinsWizard extends Wizard {

	private EditingDomain editingDomain;
	private final Collection<Person> selectedPeopleWithPins = new ArrayList<Person>();

	private UpdatePinsWizardPage updatePinsPage = null;

	private static final String UPDATE_PINS = "UpdatePins";
	private static final String UPDATE_PINS_WIZARD = "UpdatesPinsWizard";

	private IWorkbenchWindow workbenchWindow;

	public UpdatePinsWizard() {
		IDialogSettings trackerSettings = FairEditorPlugin
				.getPlugin().getDialogSettings();
		IDialogSettings wizardSettings = trackerSettings
				.getSection(UPDATE_PINS_WIZARD);
		if (wizardSettings == null) {
			wizardSettings = trackerSettings.addNewSection(UPDATE_PINS_WIZARD);
		}
		setDialogSettings(wizardSettings);
	}

	public void init(IWorkbenchWindow workbenchWindow,
			EditingDomain editingDomain, ISelection selection) {
		this.workbenchWindow = workbenchWindow;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			List<?> people = structuredSelection.toList();
			for (Object person : people) {
				selectedPeopleWithPins.add((Person) person);
			}

		}
		this.editingDomain = editingDomain;
	}

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(UPDATE_PINS);
		updatePinsPage = new UpdatePinsWizardPage();
		addPage(updatePinsPage);
		FairRegistrationSelectPersonWizardPage selectedPeoplePage =
			new FairRegistrationSelectPersonWizardPage(FairRegistrationWizard.createAdapterFactory()){

				@Override
				protected Collection<Person> getPersons() {
					
					return selectedPeopleWithPins;
				}
			
		};
		selectedPeoplePage.setDescription("Premises IDs will be updated for these People");
		selectedPeoplePage.setTitle("Selected People");
		addPage(selectedPeoplePage);
	}

	/**
	 * 
	 */
	@Override
	public boolean performFinish() {
		String attWording = selectedPeopleWithPins.size() == 1 ? " person."
				: " people.";
		try {
			editingDomain.getCommandStack().execute(createCommand());

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Update Pins Failed",
					"Failed to update Movedxxx events because: " + e);
			return false;
		}

		MessageDialog.openInformation(workbenchWindow.getShell(), "UpdatePins",
				"Updated Movedxxx events for " + selectedPeopleWithPins.size()
						+ attWording);

		return true;
	}

	/**
	 * 
	 * From the selected people, find the animals that they are exhibiting and
	 * from these change the movedIn and/or movedOut events to the pin of the
	 * person. Empty pins will be cleared if they are set.
	 * 
	 * @return command to add an exhibit for each animal to the lot
	 * 
	 */
	private Command createCommand() {
		// Get all the exhibits that are associated with the selectedPersons
		CollectionFilter<Exhibit> exhibitsOfPersons = new CollectionFilter<Exhibit>();
		exhibitsOfPersons.addFilter(new FilterCriteria<Exhibit>() {
			public boolean passes(Exhibit exhibit) {
				return selectedPeopleWithPins.contains(exhibit.getExhibitor());
			}
		});
		List<Exhibit> selectedPersonExhibits = new ArrayList<Exhibit>(
				exhibitsOfPersons.filterCopy(findFair().exhibits()));

		CompoundCommand compoundCommand = new CompoundCommand();
		return createUpdatePinCommand(editingDomain,
				selectedPersonExhibits, 
				updatePinsPage.updateMovedOut(), 
				updatePinsPage.updateMovedIn(), 
				compoundCommand);
		
	}

	/**
	 * @param selectedPersonExhibits
	 * @param updateMovedOut
	 * @param updateMovedIn
	 * @return command
	 */
	protected static Command createUpdatePinCommand(EditingDomain editingDomain,
			List<Exhibit> selectedPersonExhibits, boolean updateMovedOut,
			boolean updateMovedIn,CompoundCommand compoundCommand) {
		Command command;
		
		
		// Create setCommands for each animal's Movexx events
		for (Exhibit exhibit : selectedPersonExhibits) {
			//Get all the two movedxxx events for that animal
			for (Event event : exhibit.getAnimal().eventHistory()) {
				if (event instanceof MovedIn && updateMovedIn) {
					command = SetCommand.create(editingDomain, // Domain
							event, // Owner
							TrackerPackage.Literals.MOVED_IN__SOURCE_PIN, // Feature
							exhibit.getExhibitor().getPin()// value
							);
					if (command != null) {
						compoundCommand.append(command);
					}
				} else {
					if (event instanceof MovedOut
							&& updateMovedOut) {
						if (event instanceof MovedOut) {
							command = SetCommand.create(
									editingDomain, // Domain
									event, // Owner
									TrackerPackage.Literals.MOVED_OUT__DESTINATION_PIN, // Feature
									exhibit.getExhibitor().getPin()// value
							);
							if (command != null) {
								compoundCommand.append(command);
							}
						}
					}
				}
			}
		}
		return compoundCommand;
	}

	// public Person getSelectedPerson() {
	// return updatePinsPage.getSelectedPerson();
	// }
	//
	// public MovedIn getMovedInEvent(){
	// return this.firstMovedInEvent;
	// }

	// public Lot getSelectedLot(){
	// return selectLotPage.getSelectedLot();
	// }

	@Override
	public boolean canFinish() {
		return updatePinsPage.updateMovedIn()
				|| updatePinsPage.updateMovedOut();
	}

	/**
	 * Utility method used by pages
	 * 
	 * @return fair associated with Event
	 */
	private Fair findFair() {
		Person firstPerson = selectedPeopleWithPins.iterator().next();
		return (Fair) firstPerson.eContainer();
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public Collection<Person> getSelectedPeopleWithPins() {
		return selectedPeopleWithPins;
	}
}
