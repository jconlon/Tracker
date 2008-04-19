package com.verticon.tracker.editor.presentation;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.util.EventHistoryAdapterFactory;

/**
 * ContentProvider for the Events TableViewer.  Works with the EventHistory adapter
 * on the Premises to add or delete events from a TableViewer.
 * s
 * @see AnimalEventHistoryAdapter
 * @see PremisesEventHistoryAdapter
 * @see EventHistoryAdapterFactory
 * @see EventHistory
 * @author jconlon
 *
 */
public class EventHistoryContentProvider extends AdapterFactoryContentProvider implements Adapter {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EventHistoryContentProvider.class);
	/**
	 * EventsTable to notify
	 */
	private TableViewer eventsTableViewer = null;

	public EventHistoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
//		this.eventsTableViewer = eventsTableViewer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		// return ((EList<Event>) object).toArray();
		return ((Premises) object).eventHistory().toArray();
	}

	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput,
			Object newInput) {
		
		if(eventsTableViewer==null){
			eventsTableViewer=(TableViewer)viewer;
		}
		// TODO Auto-generated method stub
		if(oldInput==null && newInput!=null){
			Premises premisesInput = (Premises)newInput;
			logger.debug(
					"Started, viewer={} newInput={}",
					viewer, premisesInput.getName());
			//Set up the new
			EventHistory premisesEventHistoryAdapter =  
				(EventHistory) EventHistoryAdapterFactory.INSTANCE.adapt(
					premisesInput, EventHistory.class);
			premisesEventHistoryAdapter.setForwarding(this);
		}else if(oldInput!=null && newInput==null){
			Premises premisesOldInput = (Premises)oldInput;
			logger.debug("Stopped, viewer={} oldInput={}",
					viewer==null?"no viewer":viewer, premisesOldInput.getName());
			EventHistory premisesEventHistoryAdapter =  (EventHistory) EventHistoryAdapterFactory.INSTANCE.adapt(
					premisesOldInput, EventHistory.class);
			premisesEventHistoryAdapter.setForwarding(null);

		}else if (oldInput!=null && newInput!=null){
			Premises premisesInput = (Premises)newInput;
			Premises premisesOldInput = (Premises)newInput;
			logger.debug("Changed, viewer={} newInput={} oldInput={}",
					new Object[] {viewer,premisesInput.getName(),premisesOldInput.getName()});
			//Teardown the old
			EventHistory premisesEventHistoryAdapter =  (EventHistory) EventHistoryAdapterFactory.INSTANCE.adapt(
					premisesOldInput, EventHistory.class);
			premisesEventHistoryAdapter.setForwarding(null);
			
			//Setup the new
			 premisesEventHistoryAdapter =  (EventHistory) 
			 EventHistoryAdapterFactory.INSTANCE.adapt(
						premisesInput, EventHistory.class);
			 premisesEventHistoryAdapter.setForwarding(this);
			
			
		}else if (oldInput!=null && newInput!=null){
			logger.debug("Emptied, viewer={} but both old and new input are null",
					viewer);
			
		}
		super.inputChanged(viewer, oldInput, newInput);	
	}


	@Override
	public void notifyChanged(Notification notification) {
		if (notification.isTouch()) {
			return;
		}
		Object notifier = notification.getNotifier();
		if (notifier instanceof EventHistory) {
			handleEventHistoryNotification(notification);
		} else {
			super.notifyChanged(notification);
		}
	}

	/**
	 * Handles all notifications from EventHistory notifiers
	 * 
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	private void handleEventHistoryNotification(Notification n) {
		switch (n.getEventType()) {

		case Notification.ADD:
		case Notification.ADD_MANY:
			addToViewer(eventsTableViewer, n.getNewValue());
			break;

		case Notification.REMOVE_MANY:
		case Notification.REMOVE:
			removeFromViewer(eventsTableViewer, n.getOldValue());
			break;
		default:
			break;
		}

	}

	/**
	 * @param tableViewer
	 * @param element
	 * @param properties
	 * 
	 */
	protected static void addToViewer(final TableViewer tableViewer,
			final Object element) {
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
	protected static void removeFromViewer(final TableViewer tableViewer,
			final Object element) {
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

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}

}
