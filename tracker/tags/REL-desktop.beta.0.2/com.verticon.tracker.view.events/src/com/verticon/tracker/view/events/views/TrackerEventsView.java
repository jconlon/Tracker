/*******************************************************************************
 * Copyright (c) 2008 Trevor S. Kaufman.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Trevor S. Kaufman - initial API and implementation
 ******************************************************************************/
package com.verticon.tracker.view.events.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.jface.viewers.StructuredSelection;
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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.FilteredTable;
import com.verticon.tracker.editor.util.TableColumnPatternFilter;
import com.verticon.tracker.editor.util.TrackerTableEditorUtils;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.transaction.editor.popup.actions.DefaultPropertiesFormProvider;
import com.verticon.tracker.fair.transaction.editor.popup.actions.IPropertiesFormProvider;

public class TrackerEventsView extends ViewPart implements ISelectionListener,
		ISelectionChangedListener {

	private TableViewer viewer;

	protected CTabFolder cTabFolder;

	private AdapterFactory adapterFactory = new TrackerItemProviderAdapterFactory();

	private IPropertiesFormProvider defaultPropertiesFormProvider;

	private IQueryDataSetProvider queryDataSetProvider = null;

	private TableColumnPatternFilter patternFilter;

	Composite sash = null;

	private Action reorientSashFormAction;

	private SashForm sashForm;

	private FilteredTable filteredTable;

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TrackerEventsView.class);
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
	 * 
	 */
	private void createFormFolder() {
		// Second window will be the form
		Composite formParent = new Composite(sashForm, SWT.NONE);
		cTabFolder = new CTabFolder(formParent, SWT.LEFT);
		cTabFolder.setForeground(formParent.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		// cTabFolder.setBackground(formParent.getDisplay().getSystemColor(
		// SWT.COLOR_WHITE));
	}

	/**
	 * 
	 */
	private void createViewer() {
		// First window will be the table
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
		filteredTable.setFilterText("123");
		viewer = filteredTable.getViewer();
		viewer.addSelectionChangedListener(this);
		Table table = viewer.getTable();
		// set up table layout data
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		table.setLayoutData(gridData);

		TrackerTableEditorUtils.setUpEventsTableViewer(viewer);
		filteredTable.setColumns(viewer.getTable().getColumns());

		viewer.setContentProvider(new EventHistoryContentProvider(
				adapterFactory));
		viewer
				.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
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
		Premises premises = getPremises(queryDataSetProvider.getEditingDomain());
		viewer.setInput(premises);
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

	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * @param sselection
	 */
	private void handleSelection(Object first) {
		if (first instanceof Animal) {
			logger.debug("Animal selection");
			String id = ((Animal) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection());
		} else if (first instanceof Event) {
			logger.debug("Event selection");
			String id = ((Event) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(first));
		} else if (first instanceof Exhibit && ((Exhibit)first).getAnimal()!=null){
			logger.debug("Exhibit selection");
			String id = ((Exhibit)first).getAnimal().getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection());
		}else if (first instanceof Person){
			logger.debug("Person selection");
			Person person = (Person)first;
			List<Event> events = new ArrayList<Event>();
			Fair fair = (Fair)person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if(person == exhib.getExhibitor()){
					events.addAll(exhib.getAnimal().eventHistory());
				}
			}  
			setTagIdFilter("");
			logger.debug("Person selection associated with {} events.",events.size());
			viewer.setSelection(new StructuredSelection(events));
		}
	}

	
	/**
	 * TODO events viewer setup the proper filter TagID
	 * @param tagId
	 */
	private void setTagIdFilter(String tagId) {
		filteredTable.setFilterText(tagId);
		filteredTable.getColumnCombo().select(3);
	}

	

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
	 * Convienence method to find the Root
	 * 
	 * @return
	 */
	private Premises getPremises(EditingDomain editingDomain) {
		Resource resource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = resource.getContents().get(0);
		if (rootObject instanceof Premises) {
			return (Premises) rootObject;
		} else if (rootObject instanceof Fair) {
			return ((Fair) rootObject).getPremises();
		}

		return null;
	}

	/**
	 * @param selection
	 * @return
	 */
	protected void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
			// defaultPropertiesFormProvider.setWizardPage(this);
			// TODO events viewer need to show validation information
		}

		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, "Event Details");
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
				TrackerEventsView.this.fillContextMenu(manager);
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
