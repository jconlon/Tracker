package com.verticon.tracker.editor.util;

import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
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
public abstract class TrackerView extends ViewPart {

	/**
	 * This field is referenced by subclasses.
	 */
	protected FilteredTable masterFilteredTable; // disposed

	public FilteredTable getMasterFilteredTable() {
		return masterFilteredTable;
	}

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

	protected boolean isShowingExpertProperties = false;

	/**
	 * slf4j Logger
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private ScrolledComposite formParent;

	private Composite tableParent;

	/**
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
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	protected abstract void handleViewerInputChange();

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
	protected AdapterFactory createAdapterFactory() {
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
//		logger.debug("createPartControl Entered");
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
		sashForm
				.setBackground(base.getDisplay().getSystemColor(SWT.COLOR_GRAY));

		createTableViewer();
		makeActions();

		createFormFolder();
		hookContextMenu();
		contributeToActionBars();
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
//		logger.debug("Disposing resources");
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		detailFormTabFolder.dispose();
		sash.dispose();
		sashForm.dispose();
		masterFilteredTable.dispose();
		if(statusMessageObservable!=null){
			statusMessageObservable.dispose();
		}
		super.dispose();

	}

	/**
	 * @param selection
	 */
	public void refresh(ISelection selection) {
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(selection, adapterFactory, detailFormTabFolder);
	}

	/**
	 * Second window will be the form
	 */
	private void createFormFolder() {
		formParent = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);

		detailFormTabFolder = new CTabFolder(formParent, SWT.LEFT
				| SWT.H_SCROLL | SWT.V_SCROLL);
		detailFormTabFolder.setForeground(formParent.getDisplay()
				.getSystemColor(SWT.COLOR_BLACK));
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
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
						| SWT.BORDER, patternFilter);
		masterFilteredTable.setFilterText("");
		tableViewer = masterFilteredTable.getViewer();
		// tableViewer.addSelectionChangedListener(this);

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
	 * @param selection
	 * @return
	 */
	private void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
			// logger.debug("Creating a defaultPropertiesFormProvider");
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
		statusMessageObservable = BeansObservables.observeValue(status,
				"status");

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
						//System.out.println(statusMessageObservable.getValue())
						// ;

						IActionBars bars = getViewSite().getActionBars();
						bars.getStatusLineManager().setMessage(
								status.getStatus());
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

	private boolean deleteItemsDialog(Shell parent, int numberOfItemsToDelete) {
		return MessageDialog.openConfirm(parent, "Confirmation Delete",
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
		deleteAction.setText("&Delete " + getNameOfItemInMaster() + "(s)");
		deleteAction
				.setToolTipText("Delete " + getNameOfItemInMaster() + "(s)");
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
			this.status = status;
		}
	}

	/**
	 * Convenience method to find the Premises from an editingDomain.
	 * Ticket 276 - To prevent including dependencies for Add on Plugins in the base
	 * com.verticon.tracker.editor plugin all add-on Editors that edit 
	 * a model instance that contains a Premises
	 * in their model should register an IAdapterFactory with the 
	 * Platform AdapterManager to return a Premises.
	 * 
	 * @param editingDomain of the activeEditor
	 * @return Premises from the editingDomain
	 */
	protected static Premises getPremises(EditingDomain editingDomain) {
		if(editingDomain == null || editingDomain.getResourceSet() ==null || editingDomain.getResourceSet().getResources().isEmpty()){
			return null;
		}
		Resource resource = editingDomain.getResourceSet().getResources()
				.get(0);
		Object rootObject = resource.getContents().get(0);
		if (rootObject instanceof Premises) {
			return (Premises) rootObject;
		} else {
			Object adaptable = Platform.getAdapterManager().getAdapter(rootObject, Premises.class);
			if(adaptable!=null){
				return (Premises)adaptable;
			}
		}
		return null;
	}
	
	/**
	 * Setup the proper filter TagID
	 * 
	 * @param tagId
	 */
	public void setFilter(String value , int index) {
		getMasterFilteredTable().setFilterText(value);
		getMasterFilteredTable().getColumnCombo().select(index);
	}
	
	/**
	 * @param selection
	 */
	 public void setSelectionOnOutlinePage(ISelection selection) {
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
}