package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;


/**
 * Strategy for handling specific view selections
 * @author jconlon
 *
 */
public interface SelectionStrategy {
	/**
	 * 
	 * @param selectedObject
	 * @param viewer
	 * @param osgiEvent
	 */
	void handleWorkbenchAndEventAdminSingleSelection(Object selectedObject, final TableViewer viewer,
			final Event osgiEvent, SelectionController selectionController);
	
	/**
	 * 
	 * @return osgiBundleContext
	 */
	BundleContext getBundleContext();
	
	/**
	 * 
	 * @return eventTopic to listen to
	 */
	String getEventAdminTopicForListening();
	
	/**
	 * 
	 * @return name of the eventAdmin source
	 */
	String getEventAdminSourceName();
	
	/**
	 * Sends out a Selection to the Event Admin Service to synchronize all
	 * views. 
	 * 
	 * Override this to implement what actions happen when a user manually
	 * selects a single item in the TableViewer
	 * @param selection
	 */
	void handleManualTableViewerSelection(ISelection selection, SelectionController selectionController);
}