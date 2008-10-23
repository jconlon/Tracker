package com.verticon.tracker.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.TrackerConstants;
import com.verticon.tracker.util.TrackerSwitch;

/**
 * @deprecated
 * @author jconlon
 *
 */
@Deprecated
public class EventsSelectionController extends AnimalSelectionController {

	public EventsSelectionController(ItemsView itemsView) {
		super(itemsView);
	}

	@Override
	protected String getEventAdminTopicToListenTo() {
		return TrackerConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}

	@Override
	protected String getMyEventAdminSourceName() {
		return TrackerConstants.EVENT_ADMIN_VALUE_SELECTION_SOURCE_EVENTS_VIEW;
	}

	/**
	 *  
	 */
	@Override
	protected void handleWorkbenchAndEventAdminSingleSelection(Object selectedObject, final TableViewer viewer,
			final org.osgi.service.event.Event osgiEvent) {
		logger.debug("handleWorkbenchAndEventAdminSingleSelection selectedObject={} and event={}",selectedObject, osgiEvent);
		
		//Only deal with Event objects
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>() {

			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseEvent(Event event) {
				logger.debug("Event selection");
				setTagIdFilter("");
				ISelection selection = new StructuredSelection(event);
				viewer.setSelection(selection, true);
				return event;
			}
			
			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseAnimal(Animal animal) {
				logger.debug("Animal selection");
				// logger.debug("Event selection");
				String id = animal.getId();
				setTagIdFilter(id);
				viewer.setSelection(new StructuredSelection(), true);
				return animal;
			}


		};
		visitor.doSwitch((EObject) selectedObject);
	}
	
	
	/**
	 * Sends out a Selection to the Event Admin Service to synchronize all
	 * views.
	 * 
	 * Override this to implement what actions happen when a user manually
	 * selects a single item in the TableViewer
	 * 
	 * @param selection
	 */
	@Override
	protected void handleManualTableViewerSelection(ISelection selection) {

		logger.debug("Firing selection event");

		sendSelectionToAnimalsViewTopic(
				convertEventSelectionToAnimalSelection(selection),
				getMyEventAdminSourceName());

//		sendSelectionToEventsViewTopic(selection, getMyEventAdminSourceName());

		setSelectionOnOutlinePage(selection);
	}

	private ISelection convertEventSelectionToAnimalSelection(
			ISelection selection) {

		Event event = (Event) ((StructuredSelection) selection)
				.getFirstElement();

		return new StructuredSelection(event.eContainer().eContainer());

	}
	
	/**
	 * Setup the proper filter TagID
	 * 
	 * @param tagId
	 */
	private void setTagIdFilter(String tagId) {
		itemsView.getMasterFilteredTable().setFilterText(tagId);
		itemsView.getMasterFilteredTable().getColumnCombo().select(3);
	}
}
