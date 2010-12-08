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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.SelectionStrategy;
import com.verticon.tracker.editor.util.TrackerEditorConstants;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.editor.presentation.FairEditorPlugin;
import com.verticon.tracker.fair.util.FairSwitch;

/**
 * Selection Strategy that listens to channel selections triggering 
 * filters when an animal or person is received and sends out
 * Exhibit selections and animals derived from the Exhibit selection.
 * @author jconlon
 * 
 */
class ExhibitsStrategy implements SelectionStrategy {

	private static final String EVENT_ADMIN_VALUE_SELECTION_SOURCE_EXHIBITS_VIEW = "Exhibits Detail";

//	/**
//	 * slf4j Logger
//	 */
//	private final Logger logger = LoggerFactory
//			.getLogger(ExhibitsStrategy.class);

	private final ExhibitsView exhibitsView;

	public ExhibitsStrategy(ExhibitsView exhibitsView) {
		super();
		this.exhibitsView = exhibitsView;
	}

	/**
	 * Sends out an Animal Selection to the Event Admin Service to synchronize all
	 * views listening to animals.
	 * 
	 * Override this to implement what actions happen when a user manually
	 * selects a single item in the TableViewer
	 * 
	 * @param selection
	 */
	public void handleManualTableViewerSelection(ISelection selection,
			SelectionController selectionController) {

//		logger.debug(bundleMarker, "Sending Exhibits selection event");
		selectionController.sendSelectionToChannel(selection,
				getEventAdminSourceName());

		Exhibit exhibit = (Exhibit) ((StructuredSelection) selection)
				.getFirstElement();

//		logger.debug(bundleMarker,"Sending Animal selection event");
		if(exhibit!=null && exhibit.getAnimal()!=null){
			selectionController.sendSelectionToChannel(new StructuredSelection(
				exhibit.getAnimal()), getEventAdminSourceName());
		}
		
//		logger.debug(bundleMarker,"Sending Person selection event");
		if(exhibit!=null && exhibit.getExhibitor()!=null){
			selectionController.sendSelectionToChannel(new StructuredSelection(
				exhibit.getExhibitor()), getEventAdminSourceName());
		}

//		exhibitsView.setSelectionOnOutlinePage(selection);
	}

	/**
	 * Selections may come from the EventAdmin or the Workbench part.
	 * 
	 * Different types of selection objects are handled in the following manner:
	 * <ul>
	 * <li>A selection removes all filters and de-selects previous selection;</li>
	 * <li>A single selected animal or person deploys the appropriate filter;</li>
	 * </ul>
	 */
	public void handleWorkbenchAndEventAdminSingleSelection(
			Object selectedObject, final TableViewer viewer, final Event event, 
			final SelectionController selectionController) {
		
		if(!exhibitsView.isSelectionHandlingEnabled()){
			return;
		}
		exhibitsView.setFilter("", 0);
		
		FairSwitch<Object> visitor = new FairSwitch<Object>() {

			/**
			 * Handle Exhibit selection by selecting that exhibit in the viewer
			 * and sending the animal of the exhibit to animal listeners.
			 */
			@Override
			public Object caseExhibit(Exhibit exhibit) {
//				logger.debug(bundleMarker,"Received Exhibit selection");
				viewer.setSelection(new StructuredSelection(exhibit));
				
//				logger.debug(bundleMarker,"Sending Animal selection event");
				if(exhibit.getAnimal()!=null){
					selectionController.sendSelectionToChannel(new StructuredSelection(
						exhibit.getAnimal()), getEventAdminSourceName());
				}

				return exhibit;
			}

			/**
			 * Handle Person by setting a view filter for that person.
			 */
			@Override
			public Object casePerson(Person person) {
//				logger.debug(bundleMarker,"Received Person selection");
				exhibitsView.setFilter(person.getName(), 0);
				return person;
			}

			/**
			 * Handle an animal setting a view filter for that animal
			 * and clear the current selection.
			 * 
			 * For the People View to synchronize on an animal this 
			 * method would have to find the corresponding Exhibit
			 * and send out a Person selection, but there maybe multiple
			 * people that are exhibiting the same animal. So this method
			 * does not resend an 
			 */
			@Override
			public Object defaultCase(EObject object) {
				Animal animal = null;
				if(object instanceof Animal){
//					logger.debug(bundleMarker,"Received Animal selection");
					animal = (Animal) object;
					String id = animal.getId();
					exhibitsView.setFilter(id, 2);
					clearViewerSelection(viewer);
				}
				return animal;
			}

			private void clearViewerSelection(final TableViewer viewer) {
				viewer.setSelection(new StructuredSelection(), true);
			}

		};
		visitor.doSwitch((EObject) selectedObject);

	}

	public BundleContext getBundleContext() {
		return FairEditorPlugin.getPlugin().getBundle().getBundleContext();
	}

	public String getEventAdminSourceName() {
		return EVENT_ADMIN_VALUE_SELECTION_SOURCE_EXHIBITS_VIEW;
	}

	public String getEventAdminTopicForListening() {
		return TrackerEditorConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}
}