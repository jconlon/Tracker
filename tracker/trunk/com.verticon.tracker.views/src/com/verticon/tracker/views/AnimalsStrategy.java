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
import org.osgi.service.event.Event;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.SelectionStrategy;
import com.verticon.tracker.editor.util.TrackerEditorConstants;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.util.TrackerSwitch;

public class AnimalsStrategy implements SelectionStrategy {

//	/**
//	 * slf4j Logger
//	 */
//	private final Logger logger = LoggerFactory
//			.getLogger(AnimalsStrategy.class);
//	
	private final TrackerView trackerView;
	
	
	public AnimalsStrategy(TrackerView animalsView) {
		super();
		this.trackerView = animalsView;
	}

	public void handleManualTableViewerSelection(ISelection selection,
			SelectionController selectionController) {
//		logger.debug(bundleMarker,"Sending Animals selection event");
		selectionController.sendSelectionToChannel(selection,getEventAdminSourceName());
//		trackerView.setSelectionOnOutlinePage(selection);
	}
	
	
	public void handleWorkbenchAndEventAdminSingleSelection(Object selectedObject, final TableViewer viewer,
			final Event event, SelectionController selectionController) {
		
		if(!trackerView.isSelectionHandlingEnabled()){
			return;
		}
		//Only deal with Animal objects
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>() {

			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseAnimal(Animal animal) {
//				logger.debug(bundleMarker,"Received Animal selection");
				ISelection selection = new StructuredSelection(animal);
				viewer.setSelection(selection, true);
				return animal;
			}
			

		};
		visitor.doSwitch((EObject) selectedObject);
	}

	public BundleContext getBundleContext() {
		return TrackerReportEditorPlugin.getPlugin().getBundle().getBundleContext();
	}
	
	public String getEventAdminSourceName() {
		return TrackerEditorConstants.EVENT_ADMIN_VALUE_SELECTION_SOURCE_ANIMALS_VIEW;
	}
	
	public String getEventAdminTopicForListening() {
		return TrackerEditorConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}

	
	
}
