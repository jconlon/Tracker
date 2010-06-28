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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.osgi.framework.BundleContext;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.SelectionStrategy;
import com.verticon.tracker.editor.util.TrackerEditorConstants;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.util.TrackerSwitch;

/**
 * 
 * @author jconlon
 *
 */
class EventsStrategy implements SelectionStrategy {

	private final TrackerView animalsView;

	
	public EventsStrategy(TrackerView animalsView) {
		super();
		this.animalsView = animalsView;
	}

	public void handleManualTableViewerSelection(ISelection selection,
			SelectionController selectionController) {

		if( ((StructuredSelection) selection)
				.getFirstElement()==null){
			return;
		}
//		logger.debug(bundleMarker,"Firing selection event");
		selectionController.sendSelectionToChannel(
				convertEventSelectionToAnimalSelection(selection),
				getEventAdminSourceName());
//		animalsView.setSelectionOnOutlinePage(selection);
	}

	public void handleWorkbenchAndEventAdminSingleSelection(Object selectedObject, final TableViewer viewer,
			final org.osgi.service.event.Event osgiEvent, SelectionController selectionController) {
//		logger.debug(bundleMarker,"handleWorkbenchAndEventAdminSingleSelection selectedObject={} and event={}",selectedObject, osgiEvent);
		if(!animalsView.isSelectionHandlingEnabled()){
			return;
		}
		//Only deal with Event objects
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>() {

			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseEvent(Event event) {
//				logger.debug(bundleMarker,"Event selection");
				animalsView.setFilter("", 3);
				ISelection selection = new StructuredSelection(event);
				viewer.setSelection(selection, true);
				return event;
			}
			
			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseAnimal(Animal animal) {
//				logger.debug(bundleMarker,"Animal selection");
				// logger.debug(bundleMarker,"Event selection");
				String id = animal.getId();
				animalsView.setFilter(id, 3);
				viewer.setSelection(new StructuredSelection(), true);
				return animal;
			}


		};
		visitor.doSwitch((EObject) selectedObject);
	}
	

	public BundleContext getBundleContext() {
		return TrackerReportEditorPlugin.getPlugin().getBundle().getBundleContext();
	}
	
	public String getEventAdminSourceName() {
		return TrackerEditorConstants.EVENT_ADMIN_VALUE_SELECTION_SOURCE_EVENTS_VIEW;
	}
	
	public String getEventAdminTopicForListening() {
		return TrackerEditorConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}
	
	private ISelection convertEventSelectionToAnimalSelection(
			ISelection selection) {

		Event event = (Event) ((StructuredSelection) selection)
				.getFirstElement();

		return new StructuredSelection(event.eContainer().eContainer());
	}
	
}
