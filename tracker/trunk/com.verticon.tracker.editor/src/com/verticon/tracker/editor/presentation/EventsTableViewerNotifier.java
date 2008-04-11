/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.TrackerPackage;

/**
 * Sends Event notifications to a tableViewer.
 * 
 * @author jconlon
 * 
 */
public class EventsTableViewerNotifier extends EContentAdapter {

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
		logger.debug("Setting resource {}", resource.getURI());
		this.activeResource = resource.getResourceSet();
		super.setTarget(activeResource);
	}

	public void unset() {
		if (activeResource != null) {
			super.unsetTarget(activeResource);
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);// needed to walk the entire model
		if (eventsTableViewer == null || eventsTableViewer.getControl() == null
				|| eventsTableViewer.getControl().isDisposed()) {
			return;
		}

		if (notification.getFeature() == TrackerPackage.eINSTANCE
				.getTag_Events()) {
			logger.debug("Refreshing Events table for Tag_Events");

			refreshViewer(eventsTableViewer);

		} else if (notification.getFeature() == TrackerPackage.eINSTANCE
				.getTag_Id()) {
			logger.debug( "Refreshing eventsTable for Tag_ID, from a {}");
			refreshViewer(eventsTableViewer); 
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
}
