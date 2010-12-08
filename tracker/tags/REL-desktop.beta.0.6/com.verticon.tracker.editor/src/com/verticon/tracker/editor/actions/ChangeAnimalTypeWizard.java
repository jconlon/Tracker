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
package com.verticon.tracker.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * Wizard for updating one or more events.
 * 
 * Pages:
 * <ul>
 * <li>Page to select an animal type./li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class ChangeAnimalTypeWizard extends Wizard  {

	private EditingDomain editingDomain;
	private final Collection<Animal> animalsToChange = new ArrayList<Animal>();
    
	private ChangeAnimalTypeSelectTypeWizardPage selectTypePage = null;
	private static final String ADD_SECTION = "ChangeAnimalType";
	private static final String ADD_CHANGE_TYPE_WIZARD = "ChangeAnimalTypeWizard";
	private IWorkbenchWindow workbenchWindow;
	private final Premises premises;
    
    
	public ChangeAnimalTypeWizard(Premises premises) {
		IDialogSettings trackerSettings = 
			TrackerReportEditorPlugin.getPlugin().getDialogSettings();
		IDialogSettings wizardSettings =
				trackerSettings.getSection(ADD_CHANGE_TYPE_WIZARD);
		if(wizardSettings==null){
			wizardSettings = 
				trackerSettings.addNewSection(ADD_CHANGE_TYPE_WIZARD);
		}
		setDialogSettings(wizardSettings);		
		this.premises=premises;
	}

	public void init(IWorkbenchWindow workbenchWindow, EditingDomain editingDomain, ISelection selection){
		this.workbenchWindow=workbenchWindow;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			
			List<?> animals = structuredSelection.toList();
			for (Object animal : animals) {
				animalsToChange.add((Animal)animal);
			}	
		}
		this.editingDomain=editingDomain;
	}

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(ADD_SECTION);
		selectTypePage = new ChangeAnimalTypeSelectTypeWizardPage(
				new TrackerItemProviderAdapterFactory(),premises);
		addPage(selectTypePage);

	}

	/**
	 * Finishes the wizard.
	 * 
	 * Ticket 366 Tracker Action Change Animal Type does not work in Transaction Editors
	 * In TransactionalEditingDomain the org.eclipse.emf.transaction.RecordingCommand
	 * should do the execution. 
	 * 
	 * Resolution
	 * 
	 */
	@Override
	public boolean performFinish() {
		String attWording = animalsToChange.size()==1?" animal.": " animals.";
		try {
			editingDomain.getCommandStack().execute(createCommand());
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			MessageDialog.openError(workbenchWindow.getShell(), 
					"Change Animal Type Failed", "Failed to change to "+
						getSelectedAnimal().getClass().getSimpleName()+" because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(), 
				"Changed Animal Type", "Changed "+animalsToChange.size()+
				attWording);
		return true;
	}

	
	/**
	 * 
	 * @return command to change the animal type
	 */
	private Command createCommand(){
		CompoundCommand compoundCommand = new CompoundCommand();
		Animal selectedTypeOfAnimal =  getSelectedAnimal() ;
		for (Animal animalSource : animalsToChange) {
			
			Animal animalToAdd = (Animal)EcoreUtil.copy(selectedTypeOfAnimal);
			//Set values with simple types that do not change the model
			if(animalSource.getBirthDate()!=null){
				animalToAdd.setBirthDate(animalSource.getBirthDate());
			}
			animalToAdd.setComments(animalSource.getComments());
			animalToAdd.setSex(animalSource.getSex());
			animalToAdd.setVisualID(animalSource.getVisualID());
			
			//Add the animal
			Command command = AddCommand.create(
					editingDomain, //Domain
					animalSource.eContainer(), //Owner
					TrackerPackage.Literals.PREMISES__ANIMALS,
					animalToAdd//value
			);
			compoundCommand.append(command);
			
			//Set references from the model with a command
			//TagsToAdd
			EList<Tag> tagsToAdd = animalSource.getTags();
			command = SetCommand.create(
					editingDomain, 
					animalToAdd, 
					TrackerPackage.Literals.ANIMAL__TAGS, 
					tagsToAdd);
			compoundCommand.append(command);
			
			//DamToAdd
			Animal damToAdd = animalSource.getDam();
			command = SetCommand.create(
					editingDomain, 
					animalToAdd, 
					TrackerPackage.Literals.ANIMAL__DAM, 
					damToAdd);
			compoundCommand.append(command);
			
			//SireToAdd
			Animal sireToAdd = animalSource.getDam();
			command = SetCommand.create(
					editingDomain, 
					animalToAdd, 
					TrackerPackage.Literals.ANIMAL__SIRE, 
					sireToAdd);
			compoundCommand.append(command);
			
		
			//Remove animal
		    command = RemoveCommand.create(
					editingDomain, //Domain
					animalSource.eContainer(), //Owner
					TrackerPackage.Literals.PREMISES__ANIMALS,
					animalSource//value
			);
		    compoundCommand.append(command);
			
		}
		
		return compoundCommand;
	}
	
	public Animal getSelectedAnimal() {
		return selectTypePage.getSelectedAnimal();
	} 

	@Override
	public boolean canFinish() {
		return  getSelectedAnimal() != null;
	}

}
