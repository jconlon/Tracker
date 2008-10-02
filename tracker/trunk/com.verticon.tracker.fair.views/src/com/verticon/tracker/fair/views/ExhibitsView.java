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
import org.eclipse.jface.viewers.TableViewer;

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
		TableViewer tableViewer = masterFilteredTable.getViewer();
		FairTableEditorUtils.setUpExhibitsTableViewer(tableViewer);
		masterFilteredTable.setColumns(tableViewer.getTable().getColumns());

		tableViewer.setContentProvider(new ExhibitsContentAdapter(
				adapterFactory));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	@Override
	protected void handleViewerInputChange() {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		Fair rootObject = getFair();
		if(rootObject !=null){
			tableViewer.setInput(rootObject);
		}
		
	}
	
	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
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
			tableViewer.setSelection(new StructuredSelection(exhibits),true);
			return;
		}
		setSelection(exhibit);
	}
	
	/**
	 * @param exhibitToSelect
	 */
	private void setSelection(Object exhibitToSelect) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		if(exhibitToSelect!=null){
			tableViewer.setSelection(
				new StructuredSelection(exhibitToSelect), true);
		}else{
			tableViewer.setSelection(
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
