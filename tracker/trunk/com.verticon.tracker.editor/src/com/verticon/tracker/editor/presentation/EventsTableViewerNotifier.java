/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.ui.provider.NotifyChangedToViewerRefresh;
import org.eclipse.jface.viewers.TableViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.TrackerPackage;

/**
 * Sends Event notifications to a tableViewer. 
 * @author jconlon
 *
 */
public class EventsTableViewerNotifier extends EContentAdapter{

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
		.getLogger(EventsTableViewerNotifier.class);
	/**
	 * Cache of the targetResource
	 */
	private Resource activeResource;
	/**
	 * EventsTable to notify
	 */
	private final TableViewer eventsTableViewer;
	
	public EventsTableViewerNotifier(TableViewer eventsTableViewer) {
		super();
		this.eventsTableViewer=eventsTableViewer;
		
	}
	
	
	public void setResource(Resource resource) {
		logger.debug("Setting resource {}", resource.getURI());
		this.activeResource=resource;
		super.setTarget(activeResource);
	}

	public void unset(){
		if(activeResource !=null){
			super.unsetTarget(activeResource);
		}
	}

	@Override
	public void notifyChanged(Notification notification){
		super.notifyChanged(notification);//needed to walk the entire model
		if(eventsTableViewer == null || 
				eventsTableViewer.getControl() == null ||
				eventsTableViewer.getControl().isDisposed()){
			return;
		}
		

		if (notification.getFeature() == TrackerPackage.eINSTANCE.getTag_Events() )
	    {
			logger.debug("Calling NotifiedChangedToViewerRefresh for Tag_Events, from a {}",notification.getNotifier().getClass());
	        NotifyChangedToViewerRefresh.handleNotifyChanged(
	          eventsTableViewer,
	          notification.getNotifier(),
	          notification.getEventType(),
	          notification.getFeature(),
	          notification.getOldValue(),
	          notification.getNewValue(),
	          notification.getPosition());
	        
	     }
		 else if (notification.getFeature() == TrackerPackage.eINSTANCE.getTag_Id()	)
	  	    {
			 logger.debug("Calling Refreshing eventsTable for Tag_ID, from a {}",notification.getNotifier().getClass());
		        
			   //Instead of figuring out the specifics just refresh
			    eventsTableViewer.refresh();  	        
	  	      }

	}
}

