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
package com.verticon.tracker.fair.views;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.util.FairTableEditorUtils;

public class PeopleView extends TrackerView {

	private static final String FOLDER_TITLE = "People Details";

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		FairTableEditorUtils.setUpPeopleTableViewer(viewer);
		filteredTable.setColumns(viewer.getTable().getColumns());

		viewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				Fair fair = (Fair) object;

				return fair.getPeople().toArray();
			}

		});
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	@Override
	protected void handleViewerInputChange() {
		Fair rootObject = getFair();
		if(rootObject !=null){
			viewer.setInput(rootObject);
		}
		
	}
	
	@Override
	protected AdapterFactory createAdapterFactory(){
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
//
//		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
//		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	
	
	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleSelection(Object first) {
		if (first instanceof Animal) {
//			logger.debug("Animal selection");
			//One Person per animal
			viewer.setSelection(
					new StructuredSelection(
							getPersonFromAnimal((Animal) first, getFair())));
		} else if (first instanceof Event) {
//			logger.debug("Event selection");
			//One person per event
			viewer.setSelection(
					new StructuredSelection(
							getPersonFromEvent( (Event)first, getFair())));
		} else if (first instanceof Exhibit
				&& ((Exhibit) first).getExhibitor() != null) {
//			logger.debug("Exhibit selection");
			viewer.setSelection(new StructuredSelection(((Exhibit) first).getExhibitor()), true);
		} else if (first instanceof Person) {
//			logger.debug("Person selection");
			viewer.setSelection(new StructuredSelection(first),true);
		}
	}
	
	@Override
	protected String getFolderTitle() {
		return FOLDER_TITLE;
	}
	
	/**
	 * @return
	 */
	private Fair getFair() {
		Resource resource = (Resource)queryDataSetProvider.getEditingDomain().getResourceSet().getResources().get(0);
		Object rootObject = resource.getContents().get(0);
		if(rootObject instanceof Fair){
			return (Fair)rootObject;
		}
		return null;
	}

	private static Person getPersonFromAnimal(Animal animal, Fair fair){
		if(animal==null){
			return null;
		}
		for (Exhibit exhibit : fair.exhibits()) {
			if(animal.equals(exhibit.getAnimal())){
				return exhibit.getExhibitor();
			}
		}
		
		return null;
	}
	
	private static Person getPersonFromEvent(Event event, Fair fair){
		if(event.getTag()!=null && event.getTag().eContainer()!=null){
			Animal animal = (Animal)event.getTag().eContainer();
			return getPersonFromAnimal( animal,  fair);
		}
		return null;
	}


}
