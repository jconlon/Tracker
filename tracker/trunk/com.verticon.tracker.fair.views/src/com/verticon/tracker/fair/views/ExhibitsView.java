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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import com.verticon.tracker.fair.editor.util.ExhibitsContentAdapter;
import com.verticon.tracker.fair.editor.util.FairTableEditorUtils;

public class ExhibitsView extends TrackerView {

	protected static final String FOLDER_TITLE = "Exhibits Details";

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		FairTableEditorUtils.setUpExhibitsTableViewer(viewer);
		filteredTable.setColumns(viewer.getTable().getColumns());

		viewer.setContentProvider(new ExhibitsContentAdapter(
				adapterFactory));
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
	
	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleSelection(Object first) {
		Object exhibit = null;
		if (first instanceof Animal) {
//			logger.debug("Animal selection");
			exhibit = getExhibitFromAnimal( (Animal) first, getFair());
		} else if (first instanceof Event) {
//			logger.debug("Event selection");
			exhibit = getExhibitFromEvent( (Event)first, getFair());
		} else if (first instanceof Exhibit) {
//			logger.debug("Exhibit selection");
			exhibit = first;
		} else if (first instanceof Person) {
//			logger.debug("Person selection");
			//A person can have multiple exhibits
			Person person = (Person) first;
			List<Exhibit> exhibits = new ArrayList<Exhibit>();
			Fair fair = (Fair) person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if (person == exhib.getExhibitor()) {
					exhibits.add(exhib);
				}
			}
			
			exhibit = exhibits;
		}
		setSelection(exhibit);
	}
	
	/**
	 * @param person
	 */
	private void setSelection(Object person) {
		if(person!=null){
			viewer.setSelection(
				new StructuredSelection(person), true);
		}else{
			viewer.setSelection(
					new StructuredSelection());
		}
	}
	
	@Override
	protected String getFolderTitle() {
		return FOLDER_TITLE;
	}
	
	@Override
	protected AdapterFactory createAdapterFactory(){
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		return adapterFactory;
	}
	
	/**
	 * @return fair
	 */
	private Fair getFair(){
		Fair fair = null;
		for (Resource resource : queryDataSetProvider.getEditingDomain().getResourceSet().getResources()) {
			Object o = resource.getContents().get(0);
			if(o instanceof Fair){
				fair = (Fair)o;
				break;
			}
		}
		return fair;
	}

	private static Exhibit getExhibitFromAnimal(Animal animal, Fair fair){
		if(animal==null || fair == null){
			return null;
		}
		for (Exhibit exhibit : fair.exhibits()) {
			if(animal.equals(exhibit.getAnimal())){
				return exhibit;
			}
		}
		
		return null;
	}
	
	private static Exhibit getExhibitFromEvent(Event event, Fair fair){
		if(event==null || fair == null){
			return null;
		}
		if(event.getTag()!=null && event.getTag().eContainer()!=null){
			Animal animal = (Animal)event.getTag().eContainer();
			return getExhibitFromAnimal( animal,  fair);
		}
		return null;
	}
	

}
