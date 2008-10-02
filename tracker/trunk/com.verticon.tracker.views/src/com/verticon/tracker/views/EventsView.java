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
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.util.TrackerTableEditorUtils;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class EventsView extends TrackerView {

	protected static final String FOLDER_TITLE = "Event Details";

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer viewer = masterFilteredTable.getViewer();
		TrackerTableEditorUtils.setUpEventsTableViewer(viewer);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());

		viewer.setContentProvider(new EventHistoryContentProvider(
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
		Premises premises = getPremises(queryDataSetProvider.getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
	}

	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		TableViewer viewer = masterFilteredTable.getViewer();
		if (first instanceof Animal) {
//			logger.debug("Animal selection");
			String id = ((Animal) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(), true);
		} else if (first instanceof Event) {
//			logger.debug("Event selection");
			String id = ((Event) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(first), true);
		} else if (first instanceof Exhibit
				&& ((Exhibit) first).getAnimal() != null) {
//			logger.debug("Exhibit selection");
			String id = ((Exhibit) first).getAnimal().getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(), true);
		} else if (first instanceof Person) {
//			logger.debug("Person selection");
			Person person = (Person) first;
			List<Event> events = new ArrayList<Event>();
			Fair fair = (Fair) person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if (person == exhib.getExhibitor()) {
					events.addAll(exhib.getAnimal().eventHistory());
				}
			}
			setTagIdFilter("");
//			logger.debug("Person selection associated with {} events.", events.size());
			viewer.setSelection(new StructuredSelection(events), true);
		}
	}

	/**
	 * Setup the proper filter TagID
	 * 
	 * @param tagId
	 */
	private void setTagIdFilter(String tagId) {
		masterFilteredTable.setFilterText(tagId);
		masterFilteredTable.getColumnCombo().select(3);
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
		Resource resource = editingDomain.getResourceSet()
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
