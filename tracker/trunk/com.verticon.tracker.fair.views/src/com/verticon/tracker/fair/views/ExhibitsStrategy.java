package com.verticon.tracker.fair.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.SelectionStrategy;
import com.verticon.tracker.editor.util.TrackerConstants;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.editor.presentation.FairEditorPlugin;
import com.verticon.tracker.fair.util.FairSwitch;

/**
 * 
 * @author jconlon
 * 
 */
class ExhibitsStrategy implements SelectionStrategy {

	private static final String EVENT_ADMIN_VALUE_SELECTION_SOURCE_EXHIBITS_VIEW = "Exhibits Detail";

//	/**
//	 * slf4j Logger
//	 */
//	private final Logger logger = LoggerFactory
//			.getLogger(ExhibitsStrategy.class);

	private final ExhibitsView exhibitsView;

	public ExhibitsStrategy(ExhibitsView exhibitsView) {
		super();
		this.exhibitsView = exhibitsView;
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
	public void handleManualTableViewerSelection(ISelection selection,
			SelectionController selectionController) {

//		logger.debug(bundleMarker, "Sending Exhibits selection event");
		selectionController.sendSelectionToChannel(selection,
				getEventAdminSourceName());

		Exhibit exhibit = (Exhibit) ((StructuredSelection) selection)
				.getFirstElement();

//		logger.debug(bundleMarker,"Sending Animal selection event");
		if(exhibit!=null && exhibit.getAnimal()!=null){
			selectionController.sendSelectionToChannel(new StructuredSelection(
				exhibit.getAnimal()), getEventAdminSourceName());
		}

		exhibitsView.setSelectionOnOutlinePage(selection);
	}

	/**
	 * 
	 * Selections may come from the EventAdmin or the Workbench part.
	 * 
	 * Different types of editor selections are handled in the following manner:
	 * <ul>
	 * <li>No selection removes all filters and de-selects previous selection;</li>
	 * <li>One item selected triggers special handling;</li>
	 * <li>Multiple items removes all filters and passes on the selection.</li>
	 * </ul>
	 * 
	 * @param selection
	 */
	public void handleWorkbenchAndEventAdminSingleSelection(
			Object selectedObject, final TableViewer viewer, final Event event, final SelectionController selectionController) {
		
		exhibitsView.setFilter("", 0);
		// Only deal with Animal objects
		FairSwitch<Object> visitor = new FairSwitch<Object>() {

			@Override
			public Object caseExhibit(Exhibit exhibit) {
//				logger.debug(bundleMarker,"Received Exhibit selection");
				viewer.setSelection(new StructuredSelection(exhibit));
				
//				logger.debug(bundleMarker,"Sending Animal selection event");
				if(exhibit.getAnimal()!=null){
					selectionController.sendSelectionToChannel(new StructuredSelection(
						exhibit.getAnimal()), getEventAdminSourceName());
				}

				return exhibit;
			}

			@Override
			public Object casePerson(Person person) {
//				logger.debug(bundleMarker,"Received Person selection");
				exhibitsView.setFilter(person.getName(), 0);
				return person;
			}

			@Override
			public Object defaultCase(EObject object) {
				Animal animal = null;
				if(object instanceof Animal){
//					logger.debug(bundleMarker,"Received Animal selection");
					animal = (Animal) object;
					String id = animal.getId();
					exhibitsView.setFilter(id, 2);
					viewer.setSelection(new StructuredSelection(), true);
				}
				return animal;
			}

		};
		visitor.doSwitch((EObject) selectedObject);

	}

	public BundleContext getBundleContext() {
		return FairEditorPlugin.getPlugin().getBundle().getBundleContext();
	}

	public String getEventAdminSourceName() {
		return EVENT_ADMIN_VALUE_SELECTION_SOURCE_EXHIBITS_VIEW;
	}

	public String getEventAdminTopicForListening() {
		return TrackerConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}
}