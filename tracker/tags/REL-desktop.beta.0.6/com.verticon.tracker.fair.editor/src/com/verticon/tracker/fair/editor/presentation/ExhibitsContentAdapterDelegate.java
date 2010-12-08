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
package com.verticon.tracker.fair.editor.presentation;
import static com.verticon.tracker.fair.editor.presentation.FairEditorPlugin.bundleMarker;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.util.AllExhibitsAdapterFactory;

public class ExhibitsContentAdapterDelegate implements Adapter{
	
	/**
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ExhibitsContentAdapterDelegate.class);
	
	public void inputChanged(Viewer viewer, Object oldInput,
			Object newInput) {
		
		if(oldInput==null && newInput!=null){
			Fair fairInput = (Fair)newInput;
			logger.debug(bundleMarker,
					"Started, viewer={} newInput={}",
					viewer, fairInput.getName());
			//Set up the new
			AllExhibits allExhibitsInFair =  
				(AllExhibits) AllExhibitsAdapterFactory.INSTANCE.adapt(
					fairInput, AllExhibits.class);
			allExhibitsInFair.setForwarding(this);
		}else if(oldInput!=null && newInput==null){
			Fair fairOldInput = (Fair)oldInput;
			logger.debug(bundleMarker,"Stopped, viewer={} oldInput={}",
					viewer==null?"no viewer":viewer, fairOldInput.getName());
			AllExhibits allExhibitsInFair =  (AllExhibits) AllExhibitsAdapterFactory.INSTANCE.adapt(
					fairOldInput, AllExhibits.class);
			allExhibitsInFair.setForwarding(null);

		}else if (oldInput!=null && newInput!=null){
			Fair fairInput = (Fair)newInput;
			Fair fairOldInput = (Fair)oldInput;
			logger.debug(bundleMarker,"Changed, viewer={} newInput={} oldInput={}",
					new Object[] {viewer,fairInput.getName(),fairOldInput.getName()});
			//Teardown the old
			AllExhibits allExhibitsInFair =  (AllExhibits) AllExhibitsAdapterFactory.INSTANCE.adapt(
					fairOldInput, AllExhibits.class);
			allExhibitsInFair.setForwarding(null);
			
			//Setup the new
			 allExhibitsInFair =  (AllExhibits) 
			 AllExhibitsAdapterFactory.INSTANCE.adapt(
						fairInput, AllExhibits.class);
			 allExhibitsInFair.setForwarding(this);
			
			
		}else if (oldInput!=null && newInput!=null){
			logger.debug(bundleMarker,"Emptied, viewer={} but both old and new input are null",
					viewer);
			
		}
		
	}

	/**
	 * Exhibits table shows the hierarchy elements of the Exhibit. These
	 * elements are shown in the table columns through ItemProviders so
	 * they by default adapt to a string based on the name of these elements.
	 * 
	 * Detecting changes to these hierarchy element names will be used to trigger 
	 * viewer.refresh.
	 * 
	 * Additions and deletions are handled more discreetly 
	 * with NotifyChangedToViewerRefresh.
	 * 
	 */
	public void notifyChanged(Notification n) {
		Object notifier = n.getNotifier();
		// find out the type of the notifier which could be either 'Log'
		// or 'Exhibit'

		if (notifier instanceof Lot) {
			handleLotNotification(n);
		} else if (notifier instanceof com.verticon.tracker.fair.Class) {
			handleClassNotification(n);
		}else if (notifier instanceof Department) {
			handleDepartmentNotification(n);
		}else if (notifier instanceof Division) {
			handleDivisionNotification(n);
		}

	}
	
	// output a message about changes to the Class Name
	private void handleDepartmentNotification(Notification n) {
		switch (n.getFeatureID(Department.class)) {
		case FairPackage.DEPARTMENT__NAME:
			refresh();;
		}
	}
	
	// output a message about changes to the Class Name
	private void handleDivisionNotification(Notification n) {
		switch (n.getFeatureID(Division.class)) {
		case FairPackage.DIVISION__NAME:
			refresh();;
		}
	}
	

	// output a message about changes to the Class Name
	private void handleClassNotification(Notification n) {
		switch (n.getFeatureID(com.verticon.tracker.fair.Class.class)) {
		case FairPackage.CLASS__NAME:
			refresh();;
		}
	}

	// output a message about new exhibits
	private void handleLotNotification(Notification n) {
		switch (n.getFeatureID(Lot.class)) {
		case FairPackage.LOT__NAME:
		case FairPackage.LOT__EXHIBITS:
			refresh();
		}
	}

	
	protected void refresh(){
		
	}
	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	public void setTarget(Notifier newTarget) {
	}
}
