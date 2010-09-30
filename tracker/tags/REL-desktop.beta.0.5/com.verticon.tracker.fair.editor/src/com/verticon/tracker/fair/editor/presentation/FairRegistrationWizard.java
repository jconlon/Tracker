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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.handlers.FairRegistrationSelection;

/**
 * Wizard for assisting operator in the Registration of Exhibit. 
 * Goal is to determine which animals are to be exhibited, the lot
 * for the exhibit, and the Person that is registering the Animals.
 * 
 * These choices can come from user selections or from selections in the wizard.
 * 
 * This wizard will not be called if the FairRegistrationSelection is invalid.
 * @see FairRegistrationWizard
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
public class FairRegistrationWizard extends Wizard  {

	private FairRegistrationSelection fairRegistrationSelection = null;
	
    
	private FairRegistrationSelectPersonWizardPage selectPersonPage = null;
	private BaseConfigureExhibitWizardPage selectLotPage = null;
	private FairRegistrationConfirmationWizardPage createConfirmationPage = null;
    
	private static final String ADD_EXHIBIT = "AddExhibit";
	private static final String ADD_EXHIBIT_WIZARD = "FairRegistrationWizard";
	
    
    private IWorkbenchWindow workbenchWindow;
    
    
	public FairRegistrationWizard() {
		IDialogSettings trackerSettings = 
			FairEditorPlugin.getPlugin().getDialogSettings();
		IDialogSettings wizardSettings =
				trackerSettings.getSection(ADD_EXHIBIT_WIZARD);
		if(wizardSettings==null){
			wizardSettings = 
				trackerSettings.addNewSection(ADD_EXHIBIT_WIZARD);
		}
		setDialogSettings(wizardSettings);	
		
	}

	/**
	 * 
	 * @param workbenchWindow
	 * @param fairProvider
	 * @param selection can be one person, and/or one lot, and/or a set of animals
	 */
	public void init(IWorkbenchWindow workbenchWindow, IFairProvider fairProvider,
			ISelection selection){
		this.workbenchWindow=workbenchWindow;
		
		if (selection instanceof IStructuredSelection) {
			fairRegistrationSelection=FairRegistrationSelection.instance(
					((IStructuredSelection) selection).toList()
			);
			
		}
	}
	
	
	
	

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(ADD_EXHIBIT);
		ComposedAdapterFactory composedAdapterFactory = createAdapterFactory();
		if(fairRegistrationSelection.getSelectedPerson()==null){
			selectPersonPage = new FairRegistrationSelectPersonWizardPage(composedAdapterFactory);
			addPage(selectPersonPage);
		}
		if(fairRegistrationSelection.getSelectedLot()==null){
			selectLotPage = new FairRegistrationConfigureExhibitWizardPage(findFair());
			addPage(selectLotPage);
		}
     	createConfirmationPage= new FairRegistrationConfirmationWizardPage(composedAdapterFactory);
     	addPage(createConfirmationPage);
     	
	}

	/**
	 * @return Fair
	 */
	protected Fair findFair() {
		return fairRegistrationSelection.getFair();
	}

	/**
	 * @return
	 */
    static ComposedAdapterFactory createAdapterFactory() {
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		composedAdapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		return composedAdapterFactory;
	}

	/**
	 * On the selected Lot use an AddCommand to create a new Exhibit
	 * for each selected animal, and assign the exhibitor for each exhibit 
	 * to the selected person.
	 */
	@Override
	public boolean performFinish() {
		String attWording = fairRegistrationSelection.getSelectedAnimals().size()==1?" exhibit.": " exhibits.";
		try {
			getEditingDomain().getCommandStack().execute(createCommand());
			
		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(), 
					"Registered Exhibitor Failed", "Failed to Registered "+
						getSelectedPerson()+" because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(), 
				"Registered Exhibitor", "Registered "+getSelectedPerson().getName()+
				" with "+fairRegistrationSelection.getSelectedAnimals().size()+
				attWording);
		return true;
	}

	/**
	 * 
	 * @return command to add an exhibit for each animal to the lot
	 */
	private Command createCommand(){
		
		List<Exhibit> exhibitsToAdd = new ArrayList<Exhibit>();
		Exhibit exhibit = null;
		for (Animal animal : getAnimalsToRegister()) {
			 exhibit = FairFactory.eINSTANCE.createExhibit();
			 exhibit.setAnimal(animal);
			 exhibit.setExhibitor(getSelectedPerson());
//			 exhibit.setName(getSelectedPerson().getLastName()+'-'+animal.getId());
			 exhibitsToAdd.add(exhibit);
		}
		
		Command command = AddCommand.create(
				getEditingDomain(),//fairProvider.getEditingDomain(), //Domain
				getSelectedLot(), //Owner
				FairPackage.Literals.LOT__EXHIBITS,
				exhibitsToAdd
		);
		if(createConfirmationPage.updateMovedOut() || createConfirmationPage.updateMovedIn()){
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.append(command);
			return UpdatePinsWizard.createUpdatePinCommand(
					getEditingDomain(), 
					exhibitsToAdd, 
					createConfirmationPage.updateMovedOut(), 
					createConfirmationPage.updateMovedIn(), 
					compoundCommand);
			
		}
		return command;
	}
	
	public Person getSelectedPerson() {
		return  fairRegistrationSelection.getSelectedPerson()!=null?
				fairRegistrationSelection.getSelectedPerson(): 
					selectPersonPage.getSelectedPerson();
	} 

	
	public Lot getSelectedLot(){
		return fairRegistrationSelection.getSelectedLot()!=null?
				fairRegistrationSelection.getSelectedLot(): 
					selectLotPage.getSelectedLot();
	}

	@Override
	public boolean canFinish() {
		return getSelectedLot()!=null && getSelectedPerson() != null;
	}
	

	public Collection<Animal> getAnimalsToRegister() {
		List<Animal>animals = new ArrayList<Animal>(fairRegistrationSelection.getSelectedAnimals());
		
		Collections.sort(animals, new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.getId().compareTo(o2.getId());
			}});
		
		return animals;
	}
	
	private EditingDomain getEditingDomain(){
		 EditingDomain result = AdapterFactoryEditingDomain.getEditingDomainFor(getSelectedLot());
		    return result;

	}
	 
}
