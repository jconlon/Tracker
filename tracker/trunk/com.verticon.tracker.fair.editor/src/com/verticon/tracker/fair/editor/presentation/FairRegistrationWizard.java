/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;

/**
 * Wizard for assisting operator in the Registration of Exhibitors at an 
 * Animal MovedIn Event.
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

	private EditingDomain editingDomain;
	private MovedIn firstMovedInEvent;
	private final Collection<Animal> animalsToRegister = new ArrayList<Animal>();
    
	private FairRegistrationSelectPersonWizardPage selectPersonPage = null;
	private BaseConfigureExhibitWizardPage selectLotPage = null;
	private FairRegistrationConfirmationWizardPage createConfirmationPage = null;
    
	private static final String ADD_EXHIBIT = "AddExhibit";
	public static final String ADD_EXHIBIT_WIZARD = "FairRegistrationWizard";
	
    
    IWorkbenchWindow workbenchWindow;
    
    
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

	public void init(IWorkbenchWindow workbenchWindow, EditingDomain editingDomain,ISelection selection){
		this.workbenchWindow=workbenchWindow;
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			firstMovedInEvent=(MovedIn)structuredSelection.getFirstElement();
			List<?> events = structuredSelection.toList();
			for (Object event : events) {
				animalsToRegister.add((Animal)((Event)event).getTag().eContainer());
			}
		}
		this.editingDomain=editingDomain;
	}

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(ADD_EXHIBIT);
		ComposedAdapterFactory composedAdapterFactory = createAdapterFactory();
		
		selectPersonPage = new FairRegistrationSelectPersonWizardPage(composedAdapterFactory);
		addPage(selectPersonPage);
		selectLotPage = new FairRegistrationConfigureExhibitWizardPage(findFair());
     	addPage(selectLotPage);
     	createConfirmationPage= new FairRegistrationConfirmationWizardPage(composedAdapterFactory);
     	addPage(createConfirmationPage);
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
		String attWording = animalsToRegister.size()==1?" exhibit.": " exhibits.";
		try {
			editingDomain.getCommandStack().execute(createCommand());
			
		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(), 
					"Registered Exhibitor Failed", "Failed to Registered "+
						getSelectedPerson()+" because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(), 
				"Registered Exhibitor", "Registered "+getSelectedPerson().getName()+
				" with "+animalsToRegister.size()+
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
		for (Animal animal : animalsToRegister) {
			 exhibit = FairFactory.eINSTANCE.createExhibit();
			 exhibit.setAnimal(animal);
			 exhibit.setExhibitor(getSelectedPerson());
//			 exhibit.setName(getSelectedPerson().getLastName()+'-'+animal.getId());
			 exhibitsToAdd.add(exhibit);
		}
		
		Command command = AddCommand.create(
				editingDomain, //Domain
				getSelectedLot(), //Owner
				FairPackage.Literals.LOT__EXHIBITS,
				exhibitsToAdd
		);
		return command;
	}
	
	public Person getSelectedPerson() {
		return selectPersonPage.getSelectedPerson();
	} 

	public MovedIn getMovedInEvent(){
		return this.firstMovedInEvent;
	}
	
	public Lot getSelectedLot(){
		return selectLotPage.getSelectedLot();
	}

	@Override
	public boolean canFinish() {
		return getSelectedLot()!=null && getSelectedPerson() != null;
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.FairFinder#findFair()
	 */
	public Fair findFair(){
		Premises premisesOfEvent = (Premises) getMovedInEvent().eContainer().eContainer().eContainer();
		Fair fair = null;
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if(resource.getContents().get(0) instanceof Fair){
				if(((Fair)resource.getContents().get(0)).getPremises()==premisesOfEvent){
					fair = ((Fair)resource.getContents().get(0));
					break;
				}
			}
		}
		return fair;
	}


	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public Collection<Animal> getAnimalsToRegister() {
		return animalsToRegister;
	}
}
