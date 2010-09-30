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

import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.SelectionStrategy;
import com.verticon.tracker.editor.util.TrackerEditorConstants;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.editor.presentation.FairEditorPlugin;
import com.verticon.tracker.fair.util.FairSwitch;

public class PeopleStrategy implements SelectionStrategy {
	
	private static final String EVENT_ADMIN_VALUE_SELECTION_SOURCE_PEOPLE_VIEW = "People Detail";

//	/**
//	 * slf4j Logger
//	 */
//	private final Logger logger = LoggerFactory.getLogger(PeopleStrategy.class);
	private final PeopleView peopleView;

	public PeopleStrategy(PeopleView peopleView) {
		super();
		this.peopleView = peopleView;
	}

	/**
	 * Sends out a People Selection to the Event Admin Service to synchronize all
	 * views listening for people.
	 * 
	 * Override this to implement what actions happen when a user manually
	 * selects a single item in the TableViewer
	 * 
	 * @param selection
	 */
	public void handleManualTableViewerSelection(ISelection selection,
			SelectionController selectionController) {

//		logger.debug(bundleMarker,"Sending People selection event");

		selectionController.sendSelectionToChannel(selection,
				getEventAdminSourceName());
//		peopleView.setSelectionOnOutlinePage(selection);
	}
	
	/**
	 * Selections may come from the EventAdmin or the Workbench part.
	 * 
	 * Different types of selection objects are handled in the following manner:
	 * <ul>
	 * <li>A selection removes all filters and de-selects previous selection;</li>
	 * <li>A single selected exhibit or person deploys the appropriate filter;</li>
	 * </ul>
	 */
	public void handleWorkbenchAndEventAdminSingleSelection(
			Object selectedObject, final TableViewer viewer, Event osgiEvent, 
			SelectionController selectionController) {
		if(!peopleView.isSelectionHandlingEnabled()){
			return;
		}
		FairSwitch<Object> visitor = new FairSwitch<Object>() {

			@Override
			public Object caseExhibit(Exhibit exhibit) {
//				logger.debug(bundleMarker,"Received Exhibit selection");
				Person person = exhibit.getExhibitor();
				if(person != null){
					viewer.setSelection(new StructuredSelection(person));
				}
				return exhibit;
			}

			@Override
			public Object casePerson(Person person) {
//				logger.debug(bundleMarker,"Received Person selection");
				viewer.setSelection(new StructuredSelection(person), true);
				return person;
			}
		};
		visitor.doSwitch((EObject) selectedObject);
	}

	public BundleContext getBundleContext() {
		return FairEditorPlugin.getPlugin().getBundle().getBundleContext();
	}

	public String getEventAdminSourceName() {
		return EVENT_ADMIN_VALUE_SELECTION_SOURCE_PEOPLE_VIEW;
	}

	public String getEventAdminTopicForListening() {
		return TrackerEditorConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}

}
