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
package com.verticon.tracker.views;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;

/**
 * Wizard for adding an event.
 * 
 * Pages:
 * <ul>
 * <li>Page to select the Animal</li>
 * <li>Page to select the Event type</li>
 * </ul>
 * 
 * BESTPRACTICE for Wizard Databinding
 * 
 * @author jconlon
 * 
 */
public class AddEventWizard extends Wizard {
	private IWorkbenchWindow workbenchWindow;
	private Tag targetTag = null;
	private Premises premises;
	private Collection<?> results;
	private ObservablesManager observablesManager = new ObservablesManager();
	private final EventWizardModel model;

	public AddEventWizard() {
		super();
		this.setDefaultPageImageDescriptor(ViewsPlugin.imageDescriptorFromPlugin("icons/waiting.gif"));
		model = new EventWizardModel();
		
	}

	@Override
	public void dispose() {
		observablesManager.dispose();
		super.dispose();
	}
	
	@Override
	public void addPages() {
		addPage(new SelectAnimalWizardPage());
		addPage(new SelectEventWizardPage());
	}

	@Override
	public String getWindowTitle() {
		return "Add an Event";
	}

	@Override
	public boolean canFinish() {
		Animal animal = getSelectedAnimal();
		Event event = getSelectedEvent();
		return (event != null && animal != null);
	}

	/**
	 * Adds the selected event, to the active tag of the selected animal.
	 */
	@Override
	public boolean performFinish() {
		EditingDomain eDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(premises);
		
		Command command = createCommand( 
				eDomain, 
				getSelectedAnimal().activeTag(), 
				getSelectedEvent());
		
		try {
			eDomain.getCommandStack().execute(command);

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Add Event Failed", "Failed to add "
							+ getSelectedEvent().getClass().getSimpleName()
							+ " because: " + e);
			return false;
		}
		
		
		MessageDialog.openInformation(workbenchWindow.getShell(),
				"Added Event ", "Added a "
						+ getName(getSelectedEvent())
						+ " Event to the model");
		results = command.getResult();
		return true;
	}

	private static String getName(Object o) {
		if(o instanceof GenericEvent){
			GenericEvent event = (GenericEvent)o;
			return event.findName();
		}
		String name = o.getClass().getSimpleName();
		return name.substring(0, name.length()-4);
	}
	/**
	 * Create a command to add an event to the selected animal active tag.
	 * 
	 * @return command to add an event.
	 */
	private Command createCommand(EditingDomain eDomain, Tag activeTag, Event selectedEvent ) {
		
		Event event = (Event) EcoreUtil.copy(selectedEvent);


		Command command = AddCommand.create(
				eDomain, // Domain
				activeTag, // Animals active Tag 
				TrackerPackage.Literals.TAG__EVENTS, 
				event// value
				);

		return command;
	}
	
	private Tag getActiveTag() {
		return getSelectedAnimal()!=null?getSelectedAnimal().activeTag():null;
	}

	Collection<?> getResults() {
		return results;
	}

	private Premises getPremises() {
		return premises;
	}


	private StructuredSelection getInitialAnimalSelection() {
		return targetTag == null ? null : new StructuredSelection(targetTag
				.eContainer());
	}

	private Animal getSelectedAnimal() {
		return (model.selectedAnimal.getValue() == null ) ? null
				: (Animal) model.selectedAnimal.getValue();
	}

	private Event getSelectedEvent() {
		return (model.selectedEvent.getValue() == null ) ? null
				: (Event) model.selectedEvent.getValue();
	}
	
	

	/**
	 * If there is an event selected in the workbenchWindow set it's the targetTag
	 * to it's parent.  This will also select an event in the wizard event.
	 * 
	 * @param workbenchWindow
	 * @param premises
	 * @param selection
	 */
	void init(IWorkbenchWindow workbenchWindow, Premises premises,
			ISelection selection) {
		this.workbenchWindow = workbenchWindow;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Event event = (Event) structuredSelection.getFirstElement();
			if (event != null) {
				targetTag = (Tag) event.eContainer();
			}
		}
		this.premises = premises;
	}

	private class SelectAnimalWizardPage extends WizardPage {

		private DataBindingContext animalDbc;

		@Override
		public void dispose() {
			if(animalDbc !=null){
				animalDbc.dispose();
			}
			super.dispose();
		}

		@Override
		public boolean canFlipToNextPage() {
			return ((AddEventWizard)getWizard()).getSelectedAnimal()!=null;
		}

		
		private final class SingleSelectionValidator implements IValidator{
			@Override
			public IStatus validate(Object value) {
				if(value==null){
					return ValidationStatus.info("Please select an animal");
				}
				return ValidationStatus.ok();
			}
		}

		protected SelectAnimalWizardPage() {
			super("Animal", "Select the Animal Associated with the Event",
					ViewsPlugin.imageDescriptorFromPlugin("icons/BovineBeef.gif"));
		}

		public void createControl(Composite parent) {
			setPageComplete(false);

			animalDbc = new DataBindingContext();
			WizardPageSupport.create(this, animalDbc);
			Composite composite = new Composite(parent, SWT.NONE);
			
			TableViewer tableViewer = createSingleColumnTableViewer(composite);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.grabExcessHorizontalSpace = true;
			data.horizontalSpan = 2;
			data.heightHint = 300;
			data.widthHint = 300;
			tableViewer.getTable().setLayoutData(data);

			// Create the input for the table
			Premises premises = ((AddEventWizard) getWizard()).getPremises();
			IObservableList input = 
				EMFProperties.list(TrackerPackage.Literals.PREMISES__ANIMALS).observe(premises);
			observablesManager.addObservable(input);
			// Set it on the viewer
			tableViewer.setInput(input);

			IObservableValue animalSelection = ViewersObservables
					.observeSingleSelection(tableViewer);
			observablesManager.addObservable(animalSelection);

			
			animalDbc.bindValue(
					animalSelection, 
					model.selectedAnimal,
					new UpdateValueStrategy().setAfterConvertValidator(new SingleSelectionValidator()),
					null
					
			);
			
			// Was there an initially selected Event/Tag
			StructuredSelection initiallySelectedAnimal = ((AddEventWizard) getWizard())
					.getInitialAnimalSelection();
			if (initiallySelectedAnimal != null) {
				tableViewer.setSelection(initiallySelectedAnimal);
			}
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(
					composite);
			setControl(composite);
		}

		protected TableViewer createSingleColumnTableViewer(
				Composite tableComposite) {

			final TableViewer v = new TableViewer(tableComposite);

			AnimalColumn.setupTable(v, null, new TrackerItemProviderAdapterFactory(),null);
			return v;

		}
	}

	private class EventWizardModel{
		IObservableValue selectedAnimal = new WritableValue(null, Animal.class);
		IObservableValue selectedEvent = new WritableValue(null, Event.class);
	}
	
	
	/**
	 * 
	 * A wizard page presenting a table selection of Events that can be created for 
	 * this animal.  Table input is built from getNewChildDescriptors on the active
	 * Tag of the animal selected in the first page of this wizard.
	 * 
	 * Table shows Event names and images.
	 * 
	 * BESTPRACTICE for WizardPage Table DataBinding Dispose
	 * 
	 * @author jconlon
	 *
	 */
	private class SelectEventWizardPage extends WizardPage {

		private TableViewer eventTableViewer;
		private DataBindingContext eventDbc;
		private AdapterFactory adapterFactory =  new TrackerItemProviderAdapterFactory();

		@Override
		public void dispose() {
			if(eventDbc !=null){
				eventDbc.dispose();
			}
			super.dispose();
		}

		private final class SingleSelectionValidator implements IValidator{
			@Override
			public IStatus validate(Object value) {
				if(value==null){
					return ValidationStatus.info("Please select an event");
				}
				return ValidationStatus.ok();
			}
		}

		protected SelectEventWizardPage() {
			super("Event", "Select the Event Associated with the Animal",
					ViewsPlugin.imageDescriptorFromPlugin("icons/waiting.gif"));
		}

		public void createControl(Composite parent) {
			setPageComplete(false);
			eventDbc = new DataBindingContext();
			WizardPageSupport.create(this, eventDbc);
			Composite composite = new Composite(parent, SWT.NONE);
			
			// Set up data binding.
			eventTableViewer = createSingleColumnForEventTableViewer(composite);
			
			
			GridData data = new GridData(GridData.FILL_BOTH);
			data.grabExcessHorizontalSpace = true;
			data.horizontalSpan = 2;
			data.heightHint = 300;
			data.widthHint = 300;
			eventTableViewer.getTable().setLayoutData(data);

			IObservableValue eventSelection = ViewerProperties
					.singleSelection().observe(eventTableViewer);
			observablesManager.addObservable(eventSelection);

			
			eventDbc.bindValue(
					eventSelection, 
					model.selectedEvent,
					new UpdateValueStrategy().setAfterConvertValidator(new SingleSelectionValidator()),
					null
					
			);
			
			GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(
					composite);
			setControl(composite);
		}

		protected TableViewer createSingleColumnForEventTableViewer(
				Composite tableComposite) {

			final TableViewer v = new TableViewer(tableComposite);

			ObservableListContentProvider cp = new ObservableListContentProvider();
			v.setContentProvider(cp);
			v.setLabelProvider(new AdapterFactoryLabelProvider(
					adapterFactory){
				

				@Override
				public Image getColumnImage(Object object, int columnIndex) {
					// The second column has the image
					return super.getColumnImage(object, 1);
				}

				@Override
				public String getColumnText(Object object, int columnIndex) {
					// The second column has the name
					return super.getColumnText(object, 1);
				}});
			
			return v;

		}
		
		
		
		public void setVisible(boolean visible) {
			   super.setVisible(visible);
			   // Set the initial field focus
			   if (visible) {
			      fillTable();
			   }
			}

		private void fillTable(){
			// Create the input for the table
			Tag tag = ((AddEventWizard) getWizard()).getActiveTag();
			EditingDomain eDomain = AdapterFactoryEditingDomain
			.getEditingDomainFor(tag);
			Collection<?>inputRaw =  eDomain.getNewChildDescriptors(tag, null);
			
			EList<Event> events = new BasicEList<Event>();
			for (Object o : inputRaw) {
				CommandParameter parm = (CommandParameter)o;
				events.add((Event)parm.getValue());
			}
			IObservableList input = new WritableList(events, Event.class);
			eventTableViewer.setInput(input);
			observablesManager.addObservable(input);
		}
		
	}
}
