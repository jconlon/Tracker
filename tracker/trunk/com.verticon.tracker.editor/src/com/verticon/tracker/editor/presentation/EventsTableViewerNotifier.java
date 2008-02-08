/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.ui.provider.NotifyChangedToViewerRefresh;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.TrackerPackage;

/**
 * Sends Event notifications to a tableViewer. 
 * @author jconlon
 *
 */
public class EventsTableViewerNotifier extends EContentAdapter{


	/**
	 * Cache of the targetResource
	 */
	private Resource oldResource;
	/**
	 * EventsTable to notify
	 */
	private final TableViewer eventsTableViewer;
	
	public EventsTableViewerNotifier(TableViewer eventsTableViewer) {
		super();
		this.eventsTableViewer=eventsTableViewer;
		
	}
	
	
	public void setResource(Resource resource) {
		this.oldResource=resource;
		super.setTarget(oldResource);
	}

	public void unset(){
		if(oldResource !=null){
			super.unsetTarget(oldResource);
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
//	    	  System.out.println("Calling NotifiedChangedToViewerRefresh: "+notification.getFeature());
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
			    //Instead of figuring out the specifics just refresh
			    eventsTableViewer.refresh();  	        
	  	      }

}
}

