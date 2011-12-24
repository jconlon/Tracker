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
package com.verticon.tracker.fair.views;

import java.util.Collection;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;

public class AddExhibitWizard extends Wizard {

	private final Fair fair;
	private final IWorkbenchWindow workbenchWindow;
	AddExhibitWizardPage addExhibitWizardPage;
	private Collection<?> results;

	AddExhibitWizard(Fair fair, IWorkbenchWindow workbenchWindow) {
		super();
		this.fair = fair;
		this.workbenchWindow = workbenchWindow;
		this.setDefaultPageImageDescriptor(
				ViewsPlugin.imageDescriptorFromPlugin("icons/Exhibit.gif"));
	}


	public void disposeObservables() {
		try {

			IWizardPage[] pages = this.getPages();
			for (IWizardPage iWizardPage : pages) {
				if(iWizardPage instanceof AddExhibitWizardPage){
					AddExhibitWizardPage p =(AddExhibitWizardPage)iWizardPage;
					IObservableValue o = p.getSelectedTarget();
					if(o!=null && !o.isDisposed()){
						o.dispose();
					}
					o = p.createAnExhibit;
					if(o!=null && !o.isDisposed()){
						o.dispose();
					}
				}else{
					ExhibitAncestorWizardPage p =(ExhibitAncestorWizardPage)iWizardPage;
					IObservableValue o = p.getSelectedTarget();
					if(o!=null && !o.isDisposed()){
						o.dispose();
					}
					o = p.getNewTargetName();
					if(o!=null && !o.isDisposed()){
						o.dispose();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Use multiple pages for prompting the user to allow the user to add a
	 * Division, Department, Class, Lot, or Exhibit to the fair model.
	 * 
	 * A new chain of elements can be added by using the text widgets in the
	 * displayed WizardPage Dialogs to create the parent and decendents.
	 */
	@Override
	public void addPages() {
		ExhibitAncestorWizardPage divisionWizardPage = new ExhibitAncestorWizardPage(
				"Division", FairPackage.Literals.FAIR__DIVISIONS, getFair(),
				null) {

			public Command getCommand(EObject child) {
				EditingDomain editingDomain = AdapterFactoryEditingDomain
						.getEditingDomainFor(fair);
				if (selectionHasValue()) {
					return AddCommand.create(editingDomain, // Domain
							selectedTarget.getValue(), // Owner
							FairPackage.Literals.DIVISION__DEPARTMENTS, child// value
							);
				} else if (newTargetHasValue()) {
					Division division = FairFactory.eINSTANCE.createDivision();
					division.setName((String) newTargetName.getValue());
					if (child != null) {
						division.getDepartments().add((Department) child);
					}
					return AddCommand.create(editingDomain, // Domain
							fair, // Owner
							FairPackage.Literals.FAIR__DIVISIONS, division// value
							);

				}
				throw new IllegalStateException(
						"Division page had no values assigned.");
			}
		};

		addPage(divisionWizardPage);

		ExhibitAncestorWizardPage departmentWizardPage = new ExhibitAncestorWizardPage(
				"Department", FairPackage.Literals.DIVISION__DEPARTMENTS,
				getFair(), divisionWizardPage) {

			public Command getCommand(EObject child) {
				EditingDomain editingDomain = AdapterFactoryEditingDomain
						.getEditingDomainFor(fair);
				if (selectionHasValue()) {
					return AddCommand.create(editingDomain, // Domain
							selectedTarget.getValue(), // Owner
							FairPackage.Literals.DEPARTMENT__CLASSES, child// value
							);
				} else if (newTargetHasValue()) {
					Department department = FairFactory.eINSTANCE
							.createDepartment();
					department.setName((String) newTargetName.getValue());
					if (child != null) {
						department.getClasses().add(
								(com.verticon.tracker.fair.Class) child);
					}
					return parentPage.getCommand(department);

				}
				return parentPage.getCommand(null);
			}
		};
		addPage(departmentWizardPage);

		ExhibitAncestorWizardPage classWizardPage = new ExhibitAncestorWizardPage(
				"Class", FairPackage.Literals.DEPARTMENT__CLASSES, getFair(),
				departmentWizardPage) {

			public Command getCommand(EObject child) {
				EditingDomain editingDomain = AdapterFactoryEditingDomain
						.getEditingDomainFor(fair);
				if (selectionHasValue()) {
					return AddCommand.create(editingDomain, // Domain
							selectedTarget.getValue(), // Owner
							FairPackage.Literals.CLASS__LOTS, child// value
							);
				} else if (newTargetHasValue()) {
					com.verticon.tracker.fair.Class klass = FairFactory.eINSTANCE
							.createClass();
					klass.setName((String) newTargetName.getValue());
					if (child != null) {
						klass.getLots().add((Lot) child);
					}
					return parentPage.getCommand(klass);

				}
				return parentPage.getCommand(null);
			}
		};
		addPage(classWizardPage);

		ExhibitAncestorWizardPage lotWizardPage = new ExhibitAncestorWizardPage(
				"Lot", FairPackage.Literals.CLASS__LOTS, getFair(),
				classWizardPage) {

			public Command getCommand(EObject child) {
				EditingDomain editingDomain = AdapterFactoryEditingDomain
						.getEditingDomainFor(fair);
				if (selectionHasValue()) {
					return AddCommand.create(editingDomain, // Domain
							selectedTarget.getValue(), // Owner
							FairPackage.Literals.LOT__EXHIBITS, child// value
							);
				} else if (newTargetHasValue()) {
					Lot lot = FairFactory.eINSTANCE.createLot();
					lot.setName((String) newTargetName.getValue());
					if (child != null) {
						lot.getExhibits().add((Exhibit) child);
					}
					return parentPage.getCommand(lot);

				}
				return parentPage.getCommand(null);
			}
		};
		addPage(lotWizardPage);

		addExhibitWizardPage = new AddExhibitWizardPage(getFair(), lotWizardPage);

		addPage(addExhibitWizardPage);
	}

	@Override
	public boolean canFinish() {
		for (IWizardPage page : this.getPages()) {
			AddExhibitWizardPageParent ewp = (AddExhibitWizardPageParent) page;
			if (ewp.newTargetHasValue()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String getWindowTitle() {
		return "Create an Exhibit";
	}

	/**
	 * Add an animal.
	 */
	@Override
	public boolean performFinish() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(fair);

		Command command = addExhibitWizardPage.getCommand(null);
		try {
			editingDomain.getCommandStack().execute(command);

		} catch (RuntimeException e) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Add Exhibit or Exhibit Ancestor Failed",
					"Failed to add an Exhibit or Exhibit Ancestor. Because: "
							+ e);
			return false;
		}
		MessageDialog.openInformation(workbenchWindow.getShell(),
				"Added Exhibit or Exhibit Ancestor ",
				"Added an Exhibit or Exhibit Ancestor to the model");
		results = command.getResult();
		
		return true;
	}

	Collection<?> getResults() {
		return results;
	}

	private Fair getFair() {
		return fair;
	}

}
