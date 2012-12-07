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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;

public class AnimalsView extends TrackerView  {

	private static final String NAME_OF_ITEM_IN_MASTER = "Animal";

	private ISelectionController selectionController;

	/**
	 * Reference to Observable for table Input
	 */
	private IObservableList observableAnimals;


	/**
	 * Override super to add an AnimalSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		super.createPartControl(base);
		
		selectionController = new SelectionController(
				this, new AnimalsStrategy(this));
		selectionController.open();
		getSite().getPage().addSelectionListener(selectionController);
		getSite().getPage().addPartListener(selectionController);
		tableViewer.addSelectionChangedListener(selectionController);
		//Fill view if there is an activeEditorPart.
		handleViewerInputChange();
	}

	/**
	 * Override super to remove the listeners and close the
	 * AnimalSelectionController
	 */
	@Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(selectionController);
		selectionController.close();
		getSite().getPage().removePartListener(selectionController);
		getSite().getPage().removeSelectionListener(selectionController);
		//Dispose observables
		if (observableAnimals != null) {
			observableAnimals.dispose();
			observableAnimals = null;
		}
		super.dispose();
	}
	
	/**
	 * Subclasses can override this to provide a more useful name for dialog.
	 * 
	 * @return singular name of the items for wizard
	 */
	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}

	/**
	 * Displays a two page wizard to add an Animal to the model. First page
	 * prompts for animal type, the second prompts for a tag id.
	 * 
	 * This has the side effect of creating a tagApplied event for the animal
	 * with the datetime of this action.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Premises premises = selectionController.getPremises();
		AddAnimalWizard wizard = new AddAnimalWizard(premises);
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();
		wizard.dispose();
		if(results==WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				return object;

			}
		}
		return null;
	}

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 * 
	 * To fix Task number 261 this method now uses a databinding contentProvider
	 * for the tableViewer
	 * 
	 * @see #handleViewerInputChange()
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		final TableViewer viewer = masterFilteredTable.getViewer();
		sorter = AnimalColumn.setupTable(viewer, memento,adapterFactory,actions);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());
	}

	/**
	 * Override point for subclasses to obtain the necessary observableAnimals to feed
	 * the tableViewer.
	 * 
	 * @see #setUpTable(AdapterFactory)
	 */
	public void handleViewerInputChange() {
		if (observableAnimals != null) {
			observableAnimals.dispose();
			observableAnimals = null;
		}

		observableAnimals = getObservableList();
		masterFilteredTable.getViewer().setInput(observableAnimals);
		enableMenus(observableAnimals!=null);
	}

	/**
	 * @return a collection of ViewerFilters
	 */
	@Override
	protected Collection<ViewerFilter> getViewerFilters(){
		return ViewsPlugin.plugin.getViewerFilters(TrackerPackage.Literals.ANIMAL);
	}
	
	/**
	 * 
	 * From the Premises get an ObservableList of Animals.  This list
	 * of animals will be used as input for the table.
	 * 
	 * @return an ObservableList of Animals
	 */
	private IObservableList getObservableList() {
		
		Premises premises = selectionController.getPremises();
		if (premises == null) {
			return null;
		}
		IEMFListProperty listProp = EMFProperties.list(TrackerPackage.Literals.PREMISES__ANIMALS);
		
		IObservableList observableAnimals = listProp.observe(premises);
		return observableAnimals;
	}
	
}
