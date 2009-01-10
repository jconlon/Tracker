/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
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
	public static final String ADD_CHANGE_TYPE_WIZARD = "ChangeAnimalTypeWizard";
	
    
    IWorkbenchWindow workbenchWindow;
    
    
	public ChangeAnimalTypeWizard() {
		IDialogSettings trackerSettings = 
			TrackerReportEditorPlugin.getPlugin().getDialogSettings();
		IDialogSettings wizardSettings =
				trackerSettings.getSection(ADD_CHANGE_TYPE_WIZARD);
		if(wizardSettings==null){
			wizardSettings = 
				trackerSettings.addNewSection(ADD_CHANGE_TYPE_WIZARD);
		}
		setDialogSettings(wizardSettings);		
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
		selectTypePage = new ChangeAnimalTypeSelectTypeWizardPage(new TrackerItemProviderAdapterFactory());
		addPage(selectTypePage);

	}

	/**
	 * On the selected Lot use an AddCommand to create a new Exhibit
	 * for each selected animal, and assign the exhibitor for each exhibit 
	 * to the selected person.
	 */
	@Override
	public boolean performFinish() {
		String attWording = animalsToChange.size()==1?" animal.": " animals.";
		try {
			editingDomain.getCommandStack().execute(createCommand());
			
		} catch (RuntimeException e) {
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
	 * @return command to add an exhibit for each animal to the lot
	 */
	private Command createCommand(){
		CompoundCommand compoundCommand = new CompoundCommand();
		Animal selectedTypeOfAnimal =  getSelectedAnimal() ;
		for (Animal animalSource : animalsToChange) {
			
			Animal animalToAdd = (Animal)EcoreUtil.copy(selectedTypeOfAnimal);
			animalToAdd.getTags().addAll(animalSource.getTags());
			animalToAdd.setBirthDate(animalSource.getBirthDate());
			animalToAdd.setComments(animalSource.getComments());
			animalToAdd.setDam(animalSource.getDam());
			animalToAdd.setSex(animalSource.getSex());
			animalToAdd.setSire(animalSource.getSire());
			
			
			Command command = AddCommand.create(
					editingDomain, //Domain
					animalSource.eContainer(), //Owner
					TrackerPackage.Literals.PREMISES__ANIMALS,
					animalToAdd//value
			);
			compoundCommand.append(command);
			
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
