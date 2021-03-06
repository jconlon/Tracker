/**
 * 
 */
package com.verticon.tracker.views;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.SelectEventWizardPage;

/**
 * Wizard for adding an event.
 * 
 * Pages:
 * <ul>
 * <li>Page to select the Animal</li>
 * <li>Page to select the Event type</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class AddEventWizard extends Wizard {

	private IWorkbenchWindow workbenchWindow;
	private Tag targetTag = null;
	private Premises premises;
	private IObservableValue animalSelection;
	private SelectEventWizardPage selectEventWizardPage;
	private Collection<?> results;
	

	public AddEventWizard() {
		super();
		this.setDefaultPageImageDescriptor(ViewsPlugin.imageDescriptorFromPlugin("icons/waiting.gif"));
	}

	@Override
	public void addPages() {
		addPage(new SelectAnimalWizardPage());
		// addPage(new SelectEventTypeWizardPage());
		selectEventWizardPage = new SelectEventWizardPage();
		addPage(selectEventWizardPage);
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
	 * Add an animal.
	 */
	@Override
	public boolean performFinish() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(premises);

		Command command = createCommand();
		try {
			editingDomain.getCommandStack().execute(command);

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Add Event Failed", "Failed to add "
							+ getSelectedEvent().getClass().getSimpleName()
							+ " because: " + e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(),
				"Added Event ", "Added a "
						+ getSelectedEvent().getClass().getSimpleName()
						+ " Event to the model");
		results = command.getResult();
		return true;
	}

	Collection<?> getResults() {
		return results;
	}

	private Premises getPremises() {
		return premises;
	}

	private void setAnimalSelection(IObservableValue animalSelection) {
		this.animalSelection = animalSelection;
	}

	private StructuredSelection getInitialAnimalSelection() {
		return targetTag == null ? null : new StructuredSelection(targetTag
				.eContainer());
	}

	private Animal getSelectedAnimal() {
		return (animalSelection == null || animalSelection.getValue() == null) ? null
				: (Animal) animalSelection.getValue();
	}

	private Event getSelectedEvent() {
		return selectEventWizardPage.getEvent();
	}

	/**
	 * 
	 * @return command to add an exhibit for each animal to the lot
	 */
	private Command createCommand() {
		Animal animal = getSelectedAnimal();
		Tag tag = animal.activeTag();
		Event event = (Event) EcoreUtil.copy(getSelectedEvent());

		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(tag);

		Command command = AddCommand.create(editingDomain, // Domain
				tag, // Owner
				TrackerPackage.Literals.TAG__EVENTS, event// value
				);

		return command;
	}

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

	private static class SelectAnimalWizardPage extends WizardPage {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			super.dispose();
		}

		protected SelectAnimalWizardPage() {
			super("Animal", "Select the Animal Associated with the Event",
					ViewsPlugin.imageDescriptorFromPlugin("icons/BovineBeef.gif"));
		}

		public void createControl(Composite parent) {
			setPageComplete(false);

			DataBindingContext dbc = new DataBindingContext();
			WizardPageSupport.create(this, dbc);
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
			IObservableList input = EMFObservables.observeList(premises,
					TrackerPackage.Literals.PREMISES__ANIMALS);
			// Set it on the viewer
			tableViewer.setInput(input);

			IObservableValue animalSelection = ViewersObservables
					.observeSingleSelection(tableViewer);
			((AddEventWizard) getWizard()).setAnimalSelection(animalSelection);

			// Watch the selection - any will do
			animalSelection.addChangeListener(new IChangeListener() {
				public void handleChange(ChangeEvent event) {
					setPageComplete(true);
				}
			});

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
//			ObservableListContentProvider cp = AnimalsView
//					.setUpAnimalsTableViewer(v,
//							new TrackerItemProviderAdapterFactory(),null);
//			v.setContentProvider(cp);
			AnimalColumn.setup(v, null, new TrackerItemProviderAdapterFactory(),null);
			return v;

		}
	}

}
