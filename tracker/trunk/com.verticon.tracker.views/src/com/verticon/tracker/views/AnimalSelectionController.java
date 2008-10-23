package com.verticon.tracker.views;

import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.EventAdminTracker;
import com.verticon.tracker.editor.util.FilteredTable;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ITrackerViewRegister;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.TrackerConstants;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.util.TrackerSwitch;
/**
 * @deprecated use a SelectionControler and a strategy
 * @author jconlon
 *
 */
@Deprecated
public class AnimalSelectionController implements ISelectionController {

	/**
	 * slf4j Logger
	 */
	protected final Logger logger = LoggerFactory
			.getLogger(this.getClass());

	private IEditorPart activeEditorPart;
	protected final ItemsView itemsView;
	
	/**
	 * OSGi ServiceTracker used to track EventAdmin serivce
	 */
	private EventAdminTracker eventAdminTracker;

	/**
	 * This field holds the {@link ServiceRegistration} object for the
	 * {@link EventHandler} service that listens for selections to the
	 * {@link ISelections}s tracked by subclasses. This object is used to keep
	 * track of the service that we've registered and provide us with a
	 * convenient mechanism for unregistering the service when we're done.
	 * 
	 * @see #selectionChangedHandlerService(BundleContext)
	 * @see #dispose()
	 */
	private ServiceRegistration selectionChangedHandlerService;
	
	private final AtomicBoolean handlingWorkbenchPartOrEventAdminIgnoreSelection = new AtomicBoolean(
			false);
	
	public AnimalSelectionController(ItemsView itemsView) {
		super();
		this.itemsView = itemsView;
	}

	/**
	 * Implements ISelectionListener to handle selection changes on Editors in
	 * the workbench.
	 * 
	 * If the part is a
	 * {@link com.verticon.tracker.editor.presentation.IQueryDataSetProvider}
	 * 
	 * First the {@link TrackerView#handleViewerInputChange()} method will be
	 * called to load obtain rows for the
	 * {@link TrackerView#masterFilteredTable} (if this method is called by a
	 * previously known part, then new rows will not be loaded.)
	 * 
	 * Second the {@link TrackerView#handleSelection(ISelection)} method will be
	 * called to determine to handle it directly or send it to be handled by the
	 * subclass.
	 * 
	 * @see ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
	 * @param part
	 *            the workbench part containing the selection
	 * @param selection
	 *            the current selection.
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IWorkbenchWindow workbenchWindow = part.getSite().getWorkbenchWindow();
		
		if (!isTrackerFamilyEditor(workbenchWindow) || !isStructureSelectionWithEObject( selection)) {
			return;
		}
		
		
		IEditorPart oldActiveEditorPart = activeEditorPart;

		activeEditorPart = workbenchWindow.getActivePage().getActiveEditor();

		if (activeEditorPart == oldActiveEditorPart) {
			logger.debug(
					"Workbench selectionChanged detected on old editor {}",
					oldActiveEditorPart);
			handleWorkbenchAndEventAdminSelection(selection, null);
			return;
		}
		
		if (oldActiveEditorPart != null) {
			unregisterFilter(oldActiveEditorPart, itemsView);
		}

		registerFilter(activeEditorPart, itemsView);

		logger.debug("Workbench selectionChanged detected on new editor {}",
				activeEditorPart);
		itemsView.handleViewerInputChange2();
		handleWorkbenchAndEventAdminSelection(selection, null);
		return;
	}

	/**
	 * Implements ISelectionChangedListener to listen for selections on the
	 * MasterTableViewer. 
	 * 
	 * Only selections manually invoked will be sent on 
	 * for further processing. Selections on the tableViewer resulting from 
	 * processing of a WorkbenchPart selection or an EventAdmin Event reception
	 * will be ignored.
	 */
	public synchronized void selectionChanged(SelectionChangedEvent event) {
		if (handlingWorkbenchPartOrEventAdminIgnoreSelection.get()) {
			//In the course of processing a EventAdminOrWorkbenchPart selection
			//ignore this event.
			// logger.debug("Global MasterTable selection changed. Source {}",
			// event
			// .getSource());
		} else {
			handleManualTableViewerSelection(event.getSelection());
		}
		itemsView.refresh(event.getSelection());
	}


	

	/**
	 * @param workbenchWindow
	 * @return
	 */
	private static boolean isTrackerFamilyEditor(IWorkbenchWindow workbenchWindow) {
		if(workbenchWindow ==null || workbenchWindow.getActivePage()==null  || 
				workbenchWindow.getActivePage().getActiveEditor() == null){
			return false;
		}
		return workbenchWindow.getActivePage().getActiveEditor() instanceof ITrackerViewRegister;
	}

	private static void registerFilter(IEditorPart iEditorPart, ItemsView itemsView) {
		if (!(iEditorPart instanceof ITrackerViewRegister)) {
			return;
		}
		((ITrackerViewRegister) iEditorPart).addViewer(itemsView
				.getMasterFilteredTable().getViewer());
	}

	private static void unregisterFilter(IEditorPart iEditorPart, ItemsView itemsView) {
		if (!(iEditorPart instanceof ITrackerViewRegister)) {
			return;
		}
		((ITrackerViewRegister) iEditorPart).removeViewer(itemsView
				.getMasterFilteredTable().getViewer());
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.views.SelectionController#getEditingDomain()
	 */
	// protected IQueryDataSetProvider queryDataSetProvider = null;

	public EditingDomain getEditingDomain() {
		if (activeEditorPart instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) activeEditorPart)
					.getEditingDomain();
		}
		return null;

	}
	
	/**
	 * This method starts an {@link EventHandler} service that listens for
	 * property changes to {@link LineItem} instances.
	 * 
	 * <p>
	 * This service listens on the
	 * {@link ObjectWithProperties#PROPERTY_CHANGE_TOPIC} topic, with an
	 * inclusion filter (via the {@link EventConstants#EVENT_FILTER} property)
	 * that only accepts events where the
	 * {@link ObjectWithProperties#SOURCE_TYPE} is {@link LineItem}.
	 * 
	 * @see ObjectWithProperties#postEvent(String, Object, Object)
	 * @param context
	 *            an instance of BundleContext to use to register the
	 *            EventListener.
	 */
	private void startSelectionChangedHandlerService(BundleContext context) {
		/*
		 * Create the event handler. This is the object that will be notified
		 * when a matching event is delivered to the event service.
		 */
		EventHandler handler = new EventHandler() {
			public void handleEvent(final Event event) {
				logger.debug("Handling incoming Selection Event");

				final ISelection selection = (ISelection) event
						.getProperty(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION);

				if (isNotAnimalSelection(selection)) {
					return;
				}
				
				/*
				 * The view must be updated from within the UI thread, so use an
				 * asyncExec block to do the actual update.
				 */
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						handleWorkbenchAndEventAdminSelection(selection, event);
					}
				});
			}

			/**
			 * @param selection
			 * @return
			 */
			private boolean isNotAnimalSelection(final ISelection selection) {
				return selection == null || 
					!(selection instanceof StructuredSelection) ||
					!	(  ((StructuredSelection)selection).getFirstElement() instanceof Animal);
			}
		};

		//Create a handler to listen to the Animal View topic, for any traffic not generated
		//by this source
		Properties properties = new Properties();
		properties.put(EventConstants.EVENT_TOPIC,
				getEventAdminTopicToListenTo());
		// Ignore events sent by this viewer
		properties.put(EventConstants.EVENT_FILTER, "(!("
				+ TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE + "="
				+ getMyEventAdminSourceName() + "))");

		selectionChangedHandlerService = context.registerService(
				EventHandler.class.getName(), handler, properties);
	}

	/**
	 * @return
	 */
	protected String getMyEventAdminSourceName() {
		return TrackerConstants.EVENT_ADMIN_VALUE_SELECTION_SOURCE_ANIMALS_VIEW;
	}

	/**
	 * @return
	 */
	protected String getEventAdminTopicToListenTo() {
		return TrackerConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION;
	}
	
	public void open() {
		BundleContext context = TrackerReportEditorPlugin.getPlugin()
				.getBundle().getBundleContext();
		eventAdminTracker = new EventAdminTracker(context);
		eventAdminTracker.open();
		startSelectionChangedHandlerService(context);
	}

	public void close() {
		 selectionChangedHandlerService.unregister();
		 eventAdminTracker.close();
		 eventAdminTracker = null;
	}


	public void partActivated(IWorkbenchPartReference partRef) {

	}

	public void partBroughtToTop(IWorkbenchPartReference partRef) {

	}

	public void partClosed(IWorkbenchPartReference partRef) {
		if (activeEditorPart == partRef.getPart(false)) {
			unregisterFilter(activeEditorPart, itemsView);
			activeEditorPart = null;
			// System.out.println("part closed " + partRef.getPart(false));
			itemsView.handleViewerInputChange2();
		}
	}

	public void partDeactivated(IWorkbenchPartReference partRef) {
	}

	public void partHidden(IWorkbenchPartReference partRef) {
	}

	public void partInputChanged(IWorkbenchPartReference partRef) {
	}

	public void partOpened(IWorkbenchPartReference partRef) {
	}

	public void partVisible(IWorkbenchPartReference partRef) {
	}

	/**
	 * Sends out a Selection to the Event Admin Service to synchronize all
	 * views. 
	 * 
	 * Override this to implement what actions happen when a user manually
	 * selects a single item in the TableViewer
	 * @param selection
	 */
	protected void handleManualTableViewerSelection(ISelection selection) {

		logger.debug("Firing selection event");

		sendSelectionToAnimalsViewTopic(selection,getMyEventAdminSourceName());
		
//		sendSelectionToEventsViewTopic(convertAnimalSelectionToEventSelection(selection), 
//				getMyEventAdminSourceName());

		setSelectionOnOutlinePage(selection);
	}
	
	private ISelection convertAnimalSelectionToEventSelection(ISelection selection){
		
		Animal animal = (Animal)((StructuredSelection)selection).getFirstElement();
		
		return new StructuredSelection(animal.eventHistory());
		
	}

	/**
	 * @param selection
	 */
	protected void setSelectionOnOutlinePage(ISelection selection) {
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null
				|| PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage() == null) {
			return;
		}
		IEditorPart editorPart = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();

		if (editorPart == null) {
			return;
		}
		IContentOutlinePage contentOutlinePage = (IContentOutlinePage) editorPart
				.getAdapter(IContentOutlinePage.class);
		if (contentOutlinePage == null) {
			// Can't find an outline try to get the QueryDataSetProvider
			return;
		}
		contentOutlinePage.setSelection(selection);
	}

	

	/**
	 * 
	 * Selections may come from the EventAdmin or the Workbench part.
	 * 
	 * Different types of editor selections are handled in the following manner:
	 * <ul>
	 * <li>No selection removes all filters and de-selects previous selection;
	 * </li> <li>One item selected triggers special handling;</li> <li>Multiple
	 * items removes all filters and passes on the selection.</li>
	 * </ul>
	 * 
	 * @param selection
	 * @param event
	 */
	private synchronized void handleWorkbenchAndEventAdminSelection(
			ISelection selection,
			Event event) {
		logger.debug("handleTableViewerSelection entered");
		
		handlingWorkbenchPartOrEventAdminIgnoreSelection.set(true);

		IStructuredSelection sselection = (IStructuredSelection) selection;

		FilteredTable masterFilteredTable = itemsView.getMasterFilteredTable();
		switch (sselection.size()) {
		case 0:
			logger.debug(
					"Empty selection - deselect any selection in the tableViewer"
			);

			masterFilteredTable.setFilterText("");
			masterFilteredTable.getViewer().setSelection(
					sselection);
			break;
		case 1:
			logger.debug(
					"Single selection - send it to the subclass for handling");

			handleWorkbenchAndEventAdminSingleSelection(sselection.getFirstElement(),
					masterFilteredTable
					.getViewer(), event);
			break;

		default:
			logger.debug("Multiple selection");
		masterFilteredTable.setFilterText("");
		masterFilteredTable.getViewer().setSelection(
				sselection);
		break;
		}

		handlingWorkbenchPartOrEventAdminIgnoreSelection.set(false);
	}

	
	private static boolean isStructureSelectionWithEObject(ISelection selection){
		
		if (selection instanceof IStructuredSelection) {
			if(((IStructuredSelection)selection).getFirstElement() instanceof EObject){
				return true;
			}
		}
 
		return false;
	}
	/**
	 *  
	 */
	protected void handleWorkbenchAndEventAdminSingleSelection(Object selectedObject, final TableViewer viewer,
			final Event event) {
		logger.debug("handleWorkbenchAndEventAdminSingleSelection selectedObject={} and event={}",selectedObject, event);
		//Only deal with Animal objects
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>() {

			/**
			 * For animal that were selected in the Workbench or the EventAdmin
			 */
			@Override
			public Object caseAnimal(Animal animal) {
				logger.debug("Animal selection");
				ISelection selection = new StructuredSelection(animal);
				viewer.setSelection(selection, true);
				// If the Animal Selection came from the EventAdmin but not from the
				// Event_View propagate it out to the EVENT_VIEW as a set of the 
				// Animal's events.
//				if (eventIsNotFromEventView(event)) {
//					StructuredSelection eventsSelection = new StructuredSelection(animal.eventHistory());
//					sendSelectionToEventsViewTopic(eventsSelection, 
//							event.getProperty(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE));
//
//				}
				return animal;
			}

			/**
			 * @param event
			 * @return
			 */
			private boolean eventIsNotFromEventView(final Event event) {
				return event != null
						&& 
					event.getProperty(
							TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE) 
							!= TrackerConstants.EVENT_ADMIN_VALUE_SELECTION_SOURCE_EVENTS_VIEW;
			}

		};
		visitor.doSwitch((EObject) selectedObject);
	}
	
//	/**
//	 * Send the selection to the EventView Topic.  
//	 * Source of this event message will be 
//	 * 
//	 * @param source of event
//	 * @param eventsSelection
//	 */
//	protected void sendSelectionToEventsViewTopic(
//			ISelection eventsSelection, Object source) {
//		logger.debug("Sending osgi event to Events View Topic from {}",source);
//		Hashtable<String, Object> props = new Hashtable<String, Object>();
//		props.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION,
//				eventsSelection);
//		props.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE,
//				source);
//		eventAdminTracker.postEvent(new Event(
//				TrackerConstants.EVENT_ADMIN_TOPIC_EVENT_VIEW, props));
//	}
	
	/**
	 * @param selection
	 * @deprecated use sendSelectionToChannel
	 */
	@Deprecated
	protected void sendSelectionToAnimalsViewTopic(ISelection selection, Object source) {
		logger.debug("Sending osgi event to Animals View Topic from {}",source);
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		// FIXME Task 280 should not send a mutable object as a property
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION, selection);
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE,
				source);
		eventAdminTracker.postEvent(new Event(
				getEventAdminTopicToListenTo(), table));
	}

	public void sendSelectionToChannel(ISelection selection,
			String source) {
		logger.debug("Sending osgi event to Animals View Topic from {}",source);
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		// FIXME Task 280 should not send a mutable object as a property
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION, selection);
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE,
				source);
		eventAdminTracker.postEvent(new Event(
				getEventAdminTopicToListenTo(), table));
		
	}
}
