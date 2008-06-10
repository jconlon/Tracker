package com.verticon.tracker.editor.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

public abstract class TrackerView extends ViewPart implements ISelectionListener, ISelectionChangedListener{

	
	protected TableViewer viewer;
	protected CTabFolder cTabFolder;
	private AdapterFactory adapterFactory = new TrackerItemProviderAdapterFactory();
	private IPropertiesFormProvider defaultPropertiesFormProvider;
	protected IQueryDataSetProvider queryDataSetProvider = null;
	private TableColumnPatternFilter patternFilter;
	Composite sash = null;
	private Action reorientSashFormAction;
	private SashForm sashForm;
	protected FilteredTable filteredTable;
	/**
	 * slf4j Logger
	 */
	protected Logger logger = LoggerFactory
				.getLogger(this.getClass());

	
	protected abstract String getFolderTitle();
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
	protected abstract void handleSelection(Object first);
	
	/**
	 * Convienence method to find the Root
	 * 
	 * @return
	 */
	protected abstract Premises getPremises(EditingDomain editingDomain);
	
	/**
	 * This looks up a string in the plugin's plugin.properties file. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static String getString(String key) {
		return TrackerReportEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite base) {
		// Our layout will have a row of buttons, and
		// then a SashForm below it.
		base.setLayout(new GridLayout(1, false));
	
		// Create the SashForm
		sash = new Composite(base, SWT.NONE);
		sash.setLayout(new FillLayout());
		sash.setLayoutData(new GridData(GridData.FILL_BOTH));
		sashForm = new SashForm(sash, SWT.HORIZONTAL);
		// Change the width of the sashes
		// sashForm.SASH_WIDTH = 20;
		// Change the color used to paint the sashes
		// sashForm.setBackground(base.getDisplay().getSystemColor(SWT.COLOR_GREEN));
	
		createViewer();
		makeActions();
		getViewSite().getPage().addSelectionListener(this);
	
		// getSite().setSelectionProvider(viewer);
		createFormFolder();
		hookContextMenu();
		contributeToActionBars();
	}

	/**
	 * Second window will be the form
	 */
	private void createFormFolder() {
		Composite formParent = new Composite(sashForm, SWT.NONE);
		cTabFolder = new CTabFolder(formParent, SWT.LEFT);
		cTabFolder.setForeground(formParent.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
	}

	/**
	 * First window will be the table
	 */
	private void createViewer() {
		Composite tableParent = new Composite(sashForm, SWT.NONE);
	
		{
			// Set Layout on parent
			GridLayout gridLayout = new GridLayout(1, false);
			gridLayout.marginWidth = 5;
			gridLayout.marginHeight = 5;
			gridLayout.verticalSpacing = 0;
			gridLayout.horizontalSpacing = 0;
			tableParent.setLayout(gridLayout);
		}
	
		/*
		 * group = new Group(parent, SWT.NONE); { GridData gridData = new
		 * GridData(SWT.FILL, SWT.FILL, true, false); gridData.widthHint =
		 * SWT.DEFAULT; gridData.heightHint = SWT.DEFAULT;
		 * group.setLayoutData(gridData); }
		 */
	
		patternFilter = new TableColumnPatternFilter();
		filteredTable = new FilteredTable(tableParent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, patternFilter);
		filteredTable.setFilterText("");
		viewer = filteredTable.getViewer();
		viewer.addSelectionChangedListener(this);
		Table table = viewer.getTable();
		// set up table layout data
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		table.setLayoutData(gridData);
	
		setUpTable(adapterFactory);
		
	}

	
	
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	public void selectionChanged(SelectionChangedEvent event) {
		// Remove all the tabs in the TabFolder
		for (CTabItem item : cTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(event.getSelection(), adapterFactory, cTabFolder);
	}

	/**
	 * @see ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IWorkbenchPartSite site = part.getSite();
		if(site ==null){
			return;
		}
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		if(workbenchWindow==null){
			return;
		}
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		if(editorPart ==null){
			return;
		}
	
		IQueryDataSetProvider selectedQueryDataSetProvider = (IQueryDataSetProvider) editorPart
				.getAdapter(IQueryDataSetProvider.class);
	
		if (selectedQueryDataSetProvider == null) {
			return;
		}
	
		if (this.queryDataSetProvider == selectedQueryDataSetProvider) {
			handleSelection(selection);
			return;
		}
		this.queryDataSetProvider = selectedQueryDataSetProvider;
		logger.debug("Changed Providers to {}", queryDataSetProvider);
		handleViewerInputChange();
		handleSelection(selection);
		return;
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
	private void handleSelection(ISelection selection) {
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselection = (IStructuredSelection) selection;
			
			switch (sselection.size()) {
			case 0:
				logger.debug("Empty selection");
				filteredTable.setFilterText("");
				viewer.setSelection(sselection);
				break;
			case 1:
				logger.debug("Single selection");
				handleSelection(sselection.getFirstElement());
				break;
	
			default:
				logger.debug("Multiple selection");
				filteredTable.setFilterText(null);
				viewer.setSelection(sselection);
				break;
			}
			
		}
	}

	public TrackerView() {
		super();
	}

	

	/**
	 * @param selection
	 * @return
	 */
	protected void fillPropertiesFolder(ISelection selection, AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
			// defaultPropertiesFormProvider.setWizardPage(this);
			// TODO events viewer need to show validation information
		}
	
		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, getFolderTitle());
		cTabFolder.pack(true);
		return;
	
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void makeActions() {
		reorientSashFormAction = new Action() {
			public void run() {
				switch (sashForm.getOrientation()) {
				case SWT.HORIZONTAL:
					sashForm.setOrientation(SWT.VERTICAL);
					break;
				case SWT.VERTICAL:
					sashForm.setOrientation(SWT.HORIZONTAL);
					break;
				}
			}
		};
		reorientSashFormAction.setText("Change window orientation");
		reorientSashFormAction
				.setToolTipText("Change the orientation of the table and form");
		reorientSashFormAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJS_INFO_TSK));
	
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				TrackerView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(reorientSashFormAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(reorientSashFormAction);
		manager.add(new Separator());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(reorientSashFormAction);
	}

}