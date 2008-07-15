/*******************************************************************************
 * Copyright (c) 2008 Trevor S. Kaufman.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Trevor S. Kaufman - initial API and implementation
 ******************************************************************************/
package com.verticon.tracker.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.TrackerTableEditorUtils;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class AnimalsView extends TrackerView {

	protected static final String FOLDER_TITLE = "Animal Details";

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TrackerTableEditorUtils.setUpAnimalsTableViewer(viewer);
		filteredTable.setColumns(viewer.getTable().getColumns());
		
		viewer.setContentProvider(
		        new AdapterFactoryContentProvider(adapterFactory) // 14.2.2
		        {
		          @Override
		          public Object [] getElements(Object object)
		          {
		            return ((Premises)object).getAnimals().toArray();
		          }

		        });
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed
	 * the tableViewer.
	 */
	@Override
	protected void handleViewerInputChange() {
		Premises premises = getPremises(queryDataSetProvider.getEditingDomain());
		viewer.setInput(premises);
	}

	/**
	 * Override point for subclasses to control how to deal with
	 * selections on the main editors. 
	 * 
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * @param sselection
	 */
	@Override
	protected void handleSelection(Object first) {
		if (first instanceof Animal) {
//			logger.debug("Animal selection");
			viewer.setSelection(new StructuredSelection(first),true);
		} else if (first instanceof Event) {
//			logger.debug("Event selection");
			Object animal = ((Event) first).eContainer().eContainer();
			viewer.setSelection(new StructuredSelection(animal),true);
		} else if (first instanceof Exhibit && ((Exhibit)first).getAnimal()!=null){
//			logger.debug("Exhibit selection");
			viewer.setSelection(new StructuredSelection(((Exhibit)first).getAnimal()),true);
		}else if (first instanceof Person){
//			logger.debug("Person selection");
			Person person = (Person)first;
			List<Animal> animals = new ArrayList<Animal>();
			Fair fair = (Fair)person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if(person == exhib.getExhibitor()){
					animals.add(exhib.getAnimal());
				}
			}  
//			logger.debug("Person selection associated with {} animals.",animals.size());
			viewer.setSelection(new StructuredSelection(animals),true);
		}
	}

	@Override
	protected String getFolderTitle() {
		return FOLDER_TITLE;
	}
	
	/**
	 * Convienence method to find the Root
	 * 
	 * @return
	 */
	protected Premises getPremises(EditingDomain editingDomain) {
		Resource resource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = resource.getContents().get(0);
		if (rootObject instanceof Premises) {
			return (Premises) rootObject;
		} else if (rootObject instanceof Fair) {
			return ((Fair) rootObject).getPremises();
		}
	
		return null;
	}

}
