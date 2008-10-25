package com.verticon.tracker.editor.util;

import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;


/**
 * Concrete implementation of ISelectionController that
 * uses a SelectionStrategy object to determine behavior.
 * 
 * 
 * @author jconlon
 *
 */
public class SelectionController implements ISelectionController {

//	/**
//	 * slf4j Logger
//	 */
//	final Logger logger = LoggerFactory
//			.getLogger(SelectionController.class);
	
	private IEditorPart activeEditorPart;
	protected final ItemsView itemsView;
	private final SelectionStrategy strategy;
	
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
	
	
	public SelectionController(ItemsView itemsView, SelectionStrategy strategy) {
		super();
		this.itemsView = itemsView;
		this.strategy=strategy;
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
		if (Utils.isNotTrackerStructuredSelection(selection, part)) {
			return;
		}
		
		handleEditorChange(part);
		handleWorkbenchAndEventAdminSelection(selection, null);
	
	}

	/**
	 * @param part
	 */
	private void handleEditorChange(IWorkbenchPart part) {
		IEditorPart oldActiveEditorPart = activeEditorPart;
		activeEditorPart = (IEditorPart)part;
		
		//The old editor and a new editors are different
		if (activeEditorPart != oldActiveEditorPart) {
			//There is an old editor - unregister it
			if (oldActiveEditorPart != null) {
				Utils.unregisterFilter(oldActiveEditorPart, itemsView);
			}
			Utils.registerFilter(activeEditorPart, itemsView);
			itemsView.handleViewerInputChange();
		}
		
	}

	
	public void open() {
		BundleContext context = strategy.getBundleContext();
		eventAdminTracker = new EventAdminTracker(context);
		eventAdminTracker.open();
		selectionChangedHandlerService = 
			startSelectionChangedHandlerService(context,strategy.getEventAdminTopicForListening(),
					strategy.getEventAdminSourceName());
	}
	
	public void close() {
		 selectionChangedHandlerService.unregister();
		 eventAdminTracker.close();
		 eventAdminTracker = null;
	}

	public EditingDomain getEditingDomain() {
		if(activeEditorPart == null){
			activeEditorPart = itemsView.getSite().getPage().getActiveEditor();
		}
		if (activeEditorPart instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) activeEditorPart)
					.getEditingDomain();
		}
		return null;

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
	public void selectionChanged(SelectionChangedEvent event) {
		if (!handlingWorkbenchPartOrEventAdminIgnoreSelection.get()) {
			strategy.handleManualTableViewerSelection(event.getSelection(),this);
		}
		itemsView.refresh(event.getSelection());
	}

	/**
	 * Implements {@link IPartListener2} to empty view if the activeEditorPart is closed.
	 */
	public void partClosed(IWorkbenchPartReference partRef) {
		if (activeEditorPart == partRef.getPart(false)) {
			Utils.unregisterFilter(activeEditorPart, itemsView);
			activeEditorPart = null;
			itemsView.handleViewerInputChange();
		}
	}
	
	/**
	 * Implements {@link IPartListener2} to fill view if a new TrackerEditor is activated.
	 */
	public void partActivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		 if(Utils.isTrackerFamilyEditor(part)){
			 handleEditorChange( part);
			 itemsView.handleViewerInputChange();
		 }
	}

	public void partBroughtToTop(IWorkbenchPartReference partRef) {
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
	 */
	private synchronized void handleWorkbenchAndEventAdminSelection(
			ISelection selection,
			Event event) {
//		logger.debug("handleTableViewerSelection entered");
		
		handlingWorkbenchPartOrEventAdminIgnoreSelection.set(true);

		IStructuredSelection sselection = (IStructuredSelection) selection;

		FilteredTable masterFilteredTable = itemsView.getMasterFilteredTable();
		switch (sselection.size()) {
		case 0:
//			logger.debug(
//					"Empty selection - deselect any selection in the tableViewer"
//			);

			masterFilteredTable.setFilterText("");
			masterFilteredTable.getViewer().setSelection(
					sselection);
			break;
		case 1:
//			logger.debug(
//					"Single selection - send it to the subclass for handling");

			strategy.handleWorkbenchAndEventAdminSingleSelection(sselection.getFirstElement(),
					masterFilteredTable
					.getViewer(), event, this);
			break;

		default:
//			logger.debug("Multiple selection");
		masterFilteredTable.setFilterText("");
		masterFilteredTable.getViewer().setSelection(
				sselection);
		break;
		}

		handlingWorkbenchPartOrEventAdminIgnoreSelection.set(false);
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
	private ServiceRegistration startSelectionChangedHandlerService(BundleContext context, String topic, String eventAdminSourceName) {
		/*
		 * Create the event handler. This is the object that will be notified
		 * when a matching event is delivered to the event service.
		 */
		EventHandler handler = new EventHandler() {
			public void handleEvent(final Event event) {
//				logger.debug("Handling incoming Selection Event");

				final ISelection selection = (ISelection) event
						.getProperty(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION);

				if (selection == null) {
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
		};

		//Create a handler to listen to the Animal View topic, for any traffic not generated
		//by this source
		Properties properties = new Properties();
		properties.put(EventConstants.EVENT_TOPIC,
				topic);
		// Ignore events sent by this viewer
		properties.put(EventConstants.EVENT_FILTER, "(!("
				+ TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE + "="
				+ eventAdminSourceName + "))");

		return context.registerService(
				EventHandler.class.getName(), handler, properties);
	}
	
	
	final static class Utils{
		/**
		 * @param selection
		 * @param workbenchWindow
		 * @return
		 */
		static boolean isNotTrackerStructuredSelection(ISelection selection,
				IWorkbenchPart part) {
			return !isTrackerFamilyEditor(part) || !isStructureSelectionWithEObject( selection);
		}
		
		/**
		 * @param workbenchWindow
		 * @return
		 */
		 static boolean isTrackerFamilyEditor(IWorkbenchPart part) {
			return part instanceof ITrackerViewRegister;
		}

		 static boolean isStructureSelectionWithEObject(ISelection selection){

			if (selection instanceof IStructuredSelection) {
				if(((IStructuredSelection)selection).getFirstElement() instanceof EObject){
					return true;
				}
			}

			return false;
		}

		 static void registerFilter(IEditorPart iEditorPart, ItemsView itemsView) {
			if (!(iEditorPart instanceof ITrackerViewRegister)) {
				return;
			}
			((ITrackerViewRegister) iEditorPart).addViewer(itemsView
					.getMasterFilteredTable().getViewer());
		}

		 static void unregisterFilter(IEditorPart iEditorPart, ItemsView itemsView) {
			if (!(iEditorPart instanceof ITrackerViewRegister)) {
				return;
			}
			((ITrackerViewRegister) iEditorPart).removeViewer(itemsView
					.getMasterFilteredTable().getViewer());
		}
	}


	public void sendSelectionToChannel(ISelection selection,
			String source) {
//		logger.debug("Sending osgi event to Animals View Topic from {}",source);
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		// FIXME Task 280 should not send a mutable object as a property
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION, selection);
		table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE,
				source);
		eventAdminTracker.postEvent(new Event(
				TrackerConstants.EVENT_ADMIN_TOPIC_VIEW_SELECTION, table));
		
	}
}
