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
/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;

/**
 * Sends Event notifications to a tableViewer.
 * @deprecated use EventHistoryContentProvider.
 * @author jconlon
 * 
 */
@Deprecated
public class EventsTableViewerNotifier extends EContentAdapter {
	
	private volatile Event lastEvent;

	/**
	 * slf4j Logger
	 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * Cache of the targetResource
	 */
	private ResourceSet activeResource;
	/**
	 * EventsTable to notify
	 */
	private final TableViewer eventsTableViewer;

	public EventsTableViewerNotifier(TableViewer eventsTableViewer) {
		super();
		this.eventsTableViewer = eventsTableViewer;

	}

	public void setResource(Resource resource) {
		logger.debug(bundleMarker,"Setting resource {}", resource.getURI());
		this.activeResource = resource.getResourceSet();
		super.setTarget(activeResource);
	}

	

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);// needed to walk the entire model
		if (eventsTableViewer == null || eventsTableViewer.getControl() == null
				|| eventsTableViewer.getControl().isDisposed()) {
			return;
		}
        
        // find out the type of the notifier which could be either 'Book' or 'Library'
        Object notifier = notification.getNotifier();
        if (notifier instanceof Tag) {
        	handleTagNotification(notification);
        } else 
        	
        if (notifier instanceof Event) {
            handleEventNotification(notification);
        }else 
        	
        	
        if (notification.getFeature() == TrackerPackage.eINSTANCE
				.getTag_Events()) {
			logger.error(bundleMarker,"Refreshing Events table for Tag_Events");

			refreshViewer(eventsTableViewer);

		} else if (notification.getFeature() == TrackerPackage.eINSTANCE
				.getTag_Id()) {
			logger.error(bundleMarker, "Refreshing eventsTable for Tag_ID, from a {}");
			refreshViewer(eventsTableViewer); 
		}

	}
	
    private void handleEventNotification(Notification n){
    	boolean isViewer = false;
    	if(n instanceof ViewerNotification){
    		isViewer=true;
    	}
        int featureID = n.getFeatureID(Event.class);
        if (featureID == TrackerPackage.EVENT__COMMENTS){
                Event b = (Event) n.getNotifier();
                logger.debug(bundleMarker,"The event comments are now {}",b.getComments() );
                updateViewer(eventsTableViewer, b, null);
        }else
        if (featureID == TrackerPackage.EVENT__TAG){
        	logger.debug(bundleMarker,"Ignored feature {}",n.getFeature());
        }else
        if(featureID == -1){
        	logger.debug(bundleMarker,"Ignored notification {} isViewer={}", n,isViewer);
        }
        else{
        	logger.error(bundleMarker,"Implement feature {} isViewer={}",n.getFeature(),isViewer);
        }
    }
	
	
    private void handleTagNotification(Notification n){
    	int featureID = n.getFeatureID(Tag.class);
        if (featureID == TrackerPackage.TAG__EVENTS){
            if (n.getEventType() == Notification.ADD){
                Event event = (Event) n.getNewValue(); 
                Assert.isLegal(!event.equals(lastEvent), "Sent this event before");
                
                lastEvent=event;
                
                logger.debug(bundleMarker,"{} added by tag {} to the tableViewer by {} using {}",
                		new Object[] {
                		event.getClass().getSimpleName(),
                		((Tag)n.getNotifier()).getId(), 
                		  
                		this,
                		n}
                );
                
                addToViewer(eventsTableViewer, event);
            } else
            if (n.getEventType() == Notification.REMOVE){
                    Event b = (Event) n.getOldValue(); 
                    logger.debug(bundleMarker,"Old Event {} was removed from the Tag {} and the tableViewer", 
                    		b, n.getNotifier());
                    
                    removeFromViewer(eventsTableViewer, b);
               }
            
            
            
            else{
            	logger.error(bundleMarker,"Implement feature {}",n.getFeature());
            }
        }
    }

	/**
	 * @param tableViewer 
	 * 
	 */
	protected void refreshViewer(final TableViewer tableViewer) {
		Display d = tableViewer.getControl().getDisplay();
		if (d != Display.getCurrent()) {
			d.asyncExec(new Runnable() {
				public void run() {
					if (tableViewer.getControl() != null
							&& !tableViewer.getControl().isDisposed()) {
						tableViewer.refresh();
					}
				}
			});
		} else {
			tableViewer.refresh();
		}
	}
	
	/**
	 * @param tableViewer 
	 * @param element
	 * @param properties
	 * 
	 */
	private void updateViewer(final TableViewer tableViewer, final Object element, final String[] properties) {
		Display d = tableViewer.getControl().getDisplay();
		if (d != Display.getCurrent()) {
			d.asyncExec(new Runnable() {
				public void run() {
					if (tableViewer.getControl() != null
							&& !tableViewer.getControl().isDisposed()) {
						tableViewer.update(element, properties);
					}
				}
			});
		} else {
			tableViewer.update(element, properties);
		}
	}
	
	
	/**
	 * @param tableViewer 
	 * @param element
	 * @param properties
	 * 
	 */
	private static void addToViewer(final TableViewer tableViewer, final Object element) {
		Display d = tableViewer.getControl().getDisplay();
		if (d != Display.getCurrent()) {
			d.asyncExec(new Runnable() {
				public void run() {
					if (tableViewer.getControl() != null
							&& !tableViewer.getControl().isDisposed()) {
						tableViewer.add(element);
					}
				}
			});
		} else {
			tableViewer.add(element);
		}
	}
	
	/**
	 * @param tableViewer 
	 * @param element
	 * @param properties
	 * 
	 */
	private static void removeFromViewer(final TableViewer tableViewer, final Object element) {
		Display d = tableViewer.getControl().getDisplay();
		if (d != Display.getCurrent()) {
			d.asyncExec(new Runnable() {
				public void run() {
					if (tableViewer.getControl() != null
							&& !tableViewer.getControl().isDisposed()) {
						tableViewer.remove(element);
					}
				}
			});
		} else {
			tableViewer.remove(element);
		}
	}
}
