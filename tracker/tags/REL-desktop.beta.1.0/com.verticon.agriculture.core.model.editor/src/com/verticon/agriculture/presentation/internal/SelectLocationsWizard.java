package com.verticon.agriculture.presentation.internal;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.TrackerPackage;

public class SelectLocationsWizard extends Wizard {
	private static final String MODIFY_WIZARD_TITLE = "Set location on Sighting Event";
	// private final Sighting sighting;
	private final IStructuredSelection selection;
	// private final String idOfPremises;
	private final Premises premises;
	private SelectLocationWizardPage selectLocationWizardPage;

	SelectLocationsWizard(IStructuredSelection selection) {
		super();
		this.selection = selection;
		EObject o = ((Sighting) selection.getFirstElement()).eContainer()
				.eContainer();
		if ((o instanceof Animal) && (o.eContainer() != null)
				&& (o.eContainer() instanceof Premises)) {
			premises = (Premises) o.eContainer();

		} else {
			premises = null;
		}
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		selectLocationWizardPage = new SelectLocationWizardPage(premises);
		addPage(selectLocationWizardPage);
	}

	@Override
	public boolean canFinish() {
		return selectLocationWizardPage.getSelectedLocation() != null;
	}

	@Override
	public boolean performFinish() {
		String value = selectLocationWizardPage.getSelectedLocation();
		EObject o = ((Sighting) selection.getFirstElement()).eContainer()
				.eContainer();
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(o);
		Iterator<?> it = selection.iterator();
		CompoundCommand compoundCommand = new CompoundCommand();
		Command command;
		while (it.hasNext()) {
			Sighting sighting = (Sighting) it.next();
			command = SetCommand.create(editingDomain, sighting,
					TrackerPackage.eINSTANCE.getSighting_Location(), value);
			compoundCommand.append(command);
		}

		editingDomain.getCommandStack().execute(compoundCommand);

		return true;
	}

}
