package com.verticon.tracker.editor.util;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.util.AbstractModelObject;

/**
 * Base class for Master-Detail Viewers. The Master is shown as rows in a
 * FilteredTable and the Details of each selected row is shown in a Form.
 * FilteredTable and Form are separated by a sash that can be oriented
 * horizontally or vertically. The Form is created dynamically when a row is
 * selected in the tableViewer.
 * 
 * The Master FilteredTable is populated by a when an
 * {@link org.eclipse.jface.viewers.ISelectionProvider} and
 * {@link com.verticon.tracker.editor.presentation.IQueryDataSetProvider} sends
 * a {@link TrackerView#selectionChanged(IWorkbenchPart, ISelection)} event.
 * 
 * 
 * @author jconlon
 * 
 */
public abstract class TrackerView extends ViewPart implements
		ISelectionListener, ISelectionChangedListener {
	

	
	/**
	 * Active IQueryDataSetProvider editor that supplies the input for the
	 * Master {@link TrackerView#masterFilteredTable} .
	 * 
	 * This field is referenced by subclasses.
	 * 
	 * @see com.verticon.tracker.editor.presentation.IQueryDataSetProvider
	 */
	protected IQueryDataSetProvider queryDataSetProvider = null;

	/**
	 * This field is referenced by subclasses.
	 */
	protected FilteredTable masterFilteredTable; // disposed

	/**
	 * Master TableViewer. Used by and can be obtained from
	 * {@link TrackerView#masterFilteredTable}
	 */
	protected TableViewer tableViewer;
	
	
	private CTabFolder detailFormTabFolder;
	
	/**
	 * @see #dispose()
	 */
	private Composite sash = null;

	/**
	 * @see #dispose()
	 */
	private SashForm sashForm; 
	
	
	private TableColumnPatternFilter patternFilter;
	private Action reorientSashFormAction;
	private Action filterAction;
	private Action showMasterAction;
	private Action showDetailAction;
	private Action addAction;
	private Action deleteAction;
	private AdapterFactory adapterFactory = null;
	private IPropertiesFormProvider defaultPropertiesFormProvider;
	private final ViewModel viewModel = new ViewModel();
	private IObservableValue statusMessageObservable;
	private final AtomicBoolean isHandlingWorkbenchPartSelect = new AtomicBoolean(
			false);
	
	protected boolean isShowingExpertProperties = false;
	
	/**
	 * OSGi ServiceTracker used to track EventAdmin serivce
	 */
	private ServiceTracker tracker;

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

	/**
	 * slf4j Logger
	 */
	protected Logger logger = LoggerFactory
				.getLogger(this.getClass());

	private ScrolledComposite formParent;

	private Composite tableParent;

	/**
	 * 
	 * 
	 * @return title of the folder
	 */
	private final String getFolderTitle() {
		return getNameOfItemInMaster() + " Details";
	}

	/**
	 * Override point for subclasses to add an item to the model. return
	 * addedObject
	 */
	protected abstract Object addAnItem();
	
	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	protected abstract void setUpTable(AdapterFactory adapterFactory);
	
	/**
	 * Override point for subclasses to obtain the necessary input to feed
	 * the tableViewer.
	 */
	protected abstract void handleViewerInputChange();
	
	/**
	 * Override point for subclasses to control how to deal with
	 * selections on the main editors. 
	 * 
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * @param sselection
	 */
	protected abstract void handleMasterSelection(Object first);

	/**
	 * Subclasses must override this to identify the name of the item in the
	 * master table.
	 * 
	 * @return plural name of the items to delete
	 */
	protected abstract String getNameOfItemInMaster();
	
	
	/**
	 * Override point for subclasses to create their own AdapterFactory
	 * 
	 * @return AdapterFactory
	 */
	protected AdapterFactory createAdapterFactory(){
		return new TrackerItemProviderAdapterFactory();
	}
	

	/**
	 * This looks up a string in the Tracker plugin's plugin.properties file.
	 * 
	 * @generated
	 */
	public static String getString(String key) {
		return TrackerReportEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * Primary entry point for the view to create the UI components
	 */
	@Override
	public void createPartControl(Composite base) {
		logger.debug("createPartControl Entered");
		// Our layout will have a row of buttons, and
		// then a SashForm below it.
		base.setLayout(new GridLayout(1, false));
	
		// Create the SashForm
		sash = new Composite(base, SWT.NONE);
		sash.setLayout(new FillLayout());
		sash.setLayoutData(new GridData(GridData.FILL_BOTH));
		sashForm = new SashForm(sash, SWT.HORIZONTAL);
		// Change the width of the sashes
		sashForm.SASH_WIDTH = 7;
		// Change the color used to paint the sashes
		sashForm.setBackground(base.getDisplay()
				.getSystemColor(
				SWT.COLOR_GRAY));
	
		createTableViewer();
		makeActions();
		getViewSite().getPage().addSelectionListener(this);
	
		// getSite().setSelectionProvider(tableViewer);
		createFormFolder();
		hookContextMenu();
		contributeToActionBars();
		BundleContext context = TrackerReportEditorPlugin.getPlugin()
				.getBundle().getBundleContext();
		
		tracker = new ServiceTracker(context, EventAdmin.class.getName(), null);
		tracker.open();
		
		startSelectionChangedHandlerService(context);
		
	}


	/**
	 * Passes the focus request to the tableViewer's control.
	 */
	@Override
	public void setFocus() {
		tableViewer.getControl().setFocus();
	}

	/**
	 * Disposes all the tabs in the TabFolder and resources.
	 */
	@Override
	public void dispose() {
		logger.debug("Disposing resources");
		tracker.close();
		tracker = null;
		selectionChangedHandlerService.unregister();
		
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		detailFormTabFolder.dispose();
		sash.dispose();
		sashForm.dispose();
		masterFilteredTable.dispose();
		statusMessageObservable.dispose();
		super.dispose();

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
	 * Second the {@link TrackerView#routeWorkbenchPartSelection(ISelection)}
	 * method will be called to determine to handle it directly or send it to be
	 * handled by the subclass.
	 * 
	 * @see ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
	 * @param part
	 *            the workbench part containing the selection
	 * @param selection
	 *            the current selection.
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IWorkbenchPartSite site = part.getSite();
		if (site == null) {
			return;
		}
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		if (workbenchWindow == null || workbenchWindow.getActivePage() == null) {
			return;
		}

		IEditorPart editorPart = workbenchWindow.getActivePage()
				.getActiveEditor();
		if (editorPart == null) {
			return;
		}

		IQueryDataSetProvider selectedQueryDataSetProvider = (IQueryDataSetProvider) editorPart
				.getAdapter(IQueryDataSetProvider.class);

		if (selectedQueryDataSetProvider == null) {
			return;
		}

		if (this.queryDataSetProvider == selectedQueryDataSetProvider) {
			logger.debug(
					"Workbench selectionChanged detected from old provider {}",
					queryDataSetProvider);
			routeWorkbenchPartSelection(selection);
			return;
		}
		this.queryDataSetProvider = selectedQueryDataSetProvider;
		logger.debug(
				"Workbench selectionChanged detected from new provider {}",
				queryDataSetProvider);
		handleViewerInputChange();
		routeWorkbenchPartSelection(selection);
		return;
	}

	/**
	 * Implements ISelectionChangedListener to listen for selections on the
	 * MasterTableViewer.
	 */
	public synchronized void selectionChanged(SelectionChangedEvent event) {
		if (isHandlingWorkbenchPartSelect.get()) {
			// logger.debug("Global MasterTable selection changed. Source {}",
			// event
			// .getSource());
		} else {
			notifyOtherViewersOfSelection(event.getSelection());
		}
		refresh(event.getSelection());
	}

	/**
	 * @param selection
	 */
	private void refresh(ISelection selection) {
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(selection, adapterFactory,
				detailFormTabFolder);
	}
	
	

	/**
	 * Second window will be the form
	 */
	private void createFormFolder() {
		formParent = new ScrolledComposite(sashForm,
		 SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	    
		detailFormTabFolder = new CTabFolder(formParent, SWT.LEFT | SWT.H_SCROLL
				| SWT.V_SCROLL);
		detailFormTabFolder.setForeground(formParent.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		formParent.setContent(detailFormTabFolder);
	}

	/**
	 * First window will be the table
	 */
	private void createTableViewer() {
		tableParent = new Composite(sashForm, SWT.NONE);
	
		{
			// Set Layout on parent
			GridLayout gridLayout = new GridLayout(1, false);
			gridLayout.marginWidth = 5;
			gridLayout.marginHeight = 5;
			gridLayout.verticalSpacing = 0;
			gridLayout.horizontalSpacing = 0;
			tableParent.setLayout(gridLayout);
		}
		
		patternFilter = new TableColumnPatternFilter();
		masterFilteredTable = new FilteredTable(tableParent,
				SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, patternFilter);
		masterFilteredTable.setFilterText("");
		tableViewer = masterFilteredTable.getViewer();
		tableViewer.addSelectionChangedListener(this);
		
		Table table = tableViewer.getTable();
		// set up table layout data
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		table.setLayoutData(gridData);
	
		adapterFactory = createAdapterFactory();
		setUpTable(adapterFactory);
		
	}

	
	/**
	 * Different types of editor selections are handled in the 
	 * following manner:
	 * <ul>
	 * <li>No selection removes all filters and de-selects previous selection;</li>
	 * <li>One item selected triggers special handling;</li>
	 * <li>Multiple items removes all filters and passes on the selection.</li>
	 * </ul>
	 * 
	 * @param selection
	 */
	private synchronized void routeWorkbenchPartSelection(ISelection selection) {
		isHandlingWorkbenchPartSelect.set(true);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselection = (IStructuredSelection) selection;
			
			switch (sselection.size()) {
			case 0:
				// logger.debug(
				// "Empty selection - deselect any selection in the tableViewer"
				// );
				masterFilteredTable.setFilterText("");
				tableViewer.setSelection(sselection);
				break;
			case 1:
				// logger.debug(
				// "Single selection - send it to the subclass for handling");
				handleMasterSelection(sselection.getFirstElement());
				break;
	
			default:
//				logger.debug("Multiple selection");
				masterFilteredTable.setFilterText(null);
				tableViewer.setSelection(sselection);
				break;
			}
			
		}
		isHandlingWorkbenchPartSelect.set(false);
	}


	/**
	 * Sends out a Selection to the Event Admin Service to synchronize all
	 * views.
	 * 
	 * @param selection
	 */
	private void notifyOtherViewersOfSelection(ISelection selection) {

		logger.debug("Firing selection event");
		EventAdmin ea = (EventAdmin) tracker.getService();
		if (ea != null) {
			Hashtable<String, Object> table = new Hashtable<String, Object>();
			table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION,
					selection);
			table.put(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE,
					getFolderTitle());

			ea.sendEvent(new Event(TrackerConstants.EVENT_ADMIN_TOPIC_VIEW,
					table));
		} else {
			logger.error("Could not find EventAdmin Serivce");
		}

		IEditorPart editorPart = getSite().getWorkbenchWindow().getActivePage()
				.getActiveEditor();

		IContentOutlinePage contentOutlinePage = (IContentOutlinePage) editorPart
				.getAdapter(IContentOutlinePage.class);
		if (contentOutlinePage == null) {
			// Can't find an outline try to get the QueryDataSetProvider
			return;
		}
		contentOutlinePage.setSelection(selection);
	}
	
	

	

	/**
	 * @param selection
	 * @return
	 */
	private void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
//			logger.debug("Creating a defaultPropertiesFormProvider");
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
		}
		initialStatusObservable(viewModel.getStatus());
		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, getFolderTitle(), isShowingExpertProperties);
		cTabFolder.pack(true);
		
	
	}
	/**
	 * 
	 */
	private void initialStatusObservable(final Status status) {
		// TODO events tableViewer need to show validation information
		// final StatusMessage status = new StatusMessage();
		if (statusMessageObservable != null) {
			statusMessageObservable.dispose();
			statusMessageObservable = null;
		}
		statusMessageObservable = BeansObservables
				.observeValue(status, "status");

		
		try {
			statusMessageObservable.addChangeListener(new IChangeListener() {

				public void handleChange(ChangeEvent event) {
					if (statusMessageObservable.getValue().equals("OK")) {
						// firstName.setBackground(Display.getCurrent()
						// .getSystemColor(SWT.COLOR_WHITE));

						IActionBars bars = getViewSite().getActionBars();
						bars.getStatusLineManager().setMessage("");
					} else {
						// firstName.setBackground(Display.getCurrent()
						// .getSystemColor(SWT.COLOR_RED));
						// System.out.println(statusMessageObservable.getValue());

						IActionBars bars = getViewSite().getActionBars();
						bars.getStatusLineManager().setMessage(status.getStatus());
					}
				}
			});
		} catch (Exception e) {
			logger.error("Failed to attach listner to tableViewer", e);
		}
		
		defaultPropertiesFormProvider
				.setStatusMessageObservable(statusMessageObservable);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	 /**
	 * Shows the expert properties.
	 */
	private void showExpert() {
		isShowingExpertProperties = true;
		refresh(tableViewer.getSelection());
	}

	/**
	 * Hides the expert properties.
	 */
	private void hideExpert() {
		isShowingExpertProperties = false;
		refresh(tableViewer.getSelection());
	}

	
	@SuppressWarnings("unchecked")
	private void removeSelectedItems() {
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();

		List<EObject> selectedItems = selection.toList();
		deleteItemsDialog(getViewSite().getShell(), selectedItems.size());

		EditingDomain ed = AdapterFactoryEditingDomain
				.getEditingDomainFor(selectedItems.get(0));
		ed.getCommandStack().execute(RemoveCommand.create(ed, selectedItems));

	}
	
	private boolean deleteItemsDialog(Shell parent,
			int numberOfItemsToDelete) {
		return MessageDialog
				.openConfirm(parent, "Confirmation Delete",
				"You are about to delete " + numberOfItemsToDelete + ' '
						+ getNameOfItemInMaster()
						+ " item(s). Are you sure you want to continue?");
	}
	

	private void refreshSashContents() {
		if (showMasterAction.isChecked() && showDetailAction.isChecked()) {
			masterFilteredTable.setVisible(true);
			sashForm.setMaximizedControl(null);
			showMasterAction.setEnabled(true);
			showDetailAction.setEnabled(true);
		} else if (showMasterAction.isChecked()
				&& !showDetailAction.isChecked()) {
			masterFilteredTable.setVisible(true);
			showMasterAction.setEnabled(false);// Can't remove both
			showDetailAction.setEnabled(true);
			sashForm.setMaximizedControl(tableParent);

		} else if (!showMasterAction.isChecked()
				&& showDetailAction.isChecked()) {
			masterFilteredTable.setVisible(false);
			showMasterAction.setEnabled(true);
			showDetailAction.setEnabled(false);// Can't remove both
			sashForm.setMaximizedControl(formParent);
		}
	}
	
	
	protected void makeActions() {
		
		 // Show Advanced Properties
		filterAction = new Action() {
			@Override
			public void run() {
				if (isChecked()) {
					showExpert();
				} else {
					hideExpert();
				}
			}
		};
		filterAction.setText("Show &Advanced Properties");
		filterAction.setToolTipText("Show Advanced Properties");
		filterAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("com.verticon.tracker.editor",
						"icons/full/elcl16/filter_ps.gif"));
		filterAction.setChecked(false);

		// ShowMaster
		showMasterAction = new Action() {
			@Override
			public void run() {
				refreshSashContents();
			}
		};
		showMasterAction.setText("Show &Master Table");
		showMasterAction.setToolTipText("Show Master Table");
		showMasterAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("com.verticon.tracker.editor",
						"icons/full/elcl16/prop_ps.gif"));
		showMasterAction.setChecked(true);

		// ShowDetails
		showDetailAction = new Action() {
			@Override
			public void run() {
				refreshSashContents();
			}
		};
		showDetailAction.setText("Show &Detail Form");
		showDetailAction.setToolTipText("Show Detail Form");
		showDetailAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("com.verticon.tracker.editor",
						"icons/full/elcl16/settings.gif"));
		showDetailAction.setChecked(true);
		
		
		// Reorient Sash
		reorientSashFormAction = new Action() {
			@Override
			public void run() {
				switch (sashForm.getOrientation()) {
				case SWT.HORIZONTAL:
					sashForm.setOrientation(SWT.VERTICAL);
					reorientSashFormAction.setImageDescriptor(AbstractUIPlugin
							.imageDescriptorFromPlugin(
									"com.verticon.tracker.editor",
									"icons/full/elcl16/horizontal.gif"));
					reorientSashFormAction
							.setText("&Reorient layout horizontally");
					reorientSashFormAction
							.setToolTipText("Reorient layout horizontally");
					break;
				case SWT.VERTICAL:
					sashForm.setOrientation(SWT.HORIZONTAL);
					reorientSashFormAction.setImageDescriptor(AbstractUIPlugin
							.imageDescriptorFromPlugin(
									"com.verticon.tracker.editor",
									"icons/full/elcl16/vertical.gif"));
					reorientSashFormAction
							.setText("&Reorient layout vertically");
					reorientSashFormAction
							.setToolTipText("Reorient layout vertically");
					break;
				}
			}
		};
		reorientSashFormAction
				.setText("Change master/detail to a vertical orientation");
		reorientSashFormAction
				.setToolTipText("Change master/detail to a vertical orientation");
		reorientSashFormAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("com.verticon.tracker.editor",
						"icons/full/elcl16/vertical.gif"));
	
		// Add an item
		addAction = new Action() {
			@Override
			public void run() {
				Object result = addAnItem();
				if (result != null) {
					masterFilteredTable.getViewer().setSelection(
							new StructuredSelection(result));
				}
			}
		};
		addAction.setText("&Add a New " + getNameOfItemInMaster());
		addAction.setToolTipText("Add a New " + getNameOfItemInMaster());
		addAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("org.eclipse.ui",
						"$nl$/icons/full/obj16/add_obj.gif"));

		// Delete an animal

		IWorkbench workbench = PlatformUI.getWorkbench();
		ISharedImages platformImages = workbench.getSharedImages();
		deleteAction = new Action() {
			@Override
			public void run() {
				removeSelectedItems();
			}
		};
		deleteAction.setText("&Delete Animal");
		deleteAction.setToolTipText("Delete Animal(s)");
		deleteAction.setImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setDisabledImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				TrackerView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tableViewer);
	}

	protected void fillContextMenu(IMenuManager manager) {
		manager.add(addAction);
		manager.add(deleteAction);
		manager.add(reorientSashFormAction);
		manager.add(filterAction);
		manager.add(showMasterAction);
		manager.add(showDetailAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	protected void fillLocalPullDown(IMenuManager manager) {
		manager.add(addAction);
		manager.add(deleteAction);
		manager.add(reorientSashFormAction);
		manager.add(filterAction);
		manager.add(showMasterAction);
		manager.add(showDetailAction);
		manager.add(new Separator());
	}

	protected void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addAction);
		manager.add(deleteAction);
		manager.add(reorientSashFormAction);
		manager.add(filterAction);
		manager.add(showMasterAction);
		manager.add(showDetailAction);
	}

    private class ViewModel {
		// model
		private final Status status = new Status();

		public Status getStatus() {
			return status;
		}
	}

	private class Status extends AbstractModelObject {
		private String status = "";

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			// String old = this.status;
			this.status = status;
			// changes.firePropertyChange("status", old, status);
		}
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
			public void handleEvent(Event event) {
				logger.debug("Handling Event");
				
				final ISelection selection = (ISelection) event
						.getProperty(TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION);

				if (selection == null) {
					return;
				}

				/*
				 * The view must be updated from within the UI thread, so use an
				 * asyncExec block to do the actual update.
				 */
				getSite().getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						routeWorkbenchPartSelection(selection);
					}
				});
			}
		};

		Properties properties = new Properties();
		properties.put(EventConstants.EVENT_TOPIC,
				TrackerConstants.EVENT_ADMIN_TOPIC_VIEW);
		// Ignore events sent by this viewer
		properties.put(EventConstants.EVENT_FILTER, "(!("
				+ TrackerConstants.EVENT_ADMIN_PROPERTY_SELECTION_SOURCE + "="
				+ getFolderTitle() + "))");

		selectionChangedHandlerService = context.registerService(
				EventHandler.class.getName(), handler, properties);
	}
}