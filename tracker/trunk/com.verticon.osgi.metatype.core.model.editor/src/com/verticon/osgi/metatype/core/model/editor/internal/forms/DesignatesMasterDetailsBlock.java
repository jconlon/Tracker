/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.osgi.metatype.core.model.editor.internal.forms;


import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.bundleMarker;
import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.getName;
import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.getTemplateChildren;
import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.getTemplateParent;
import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.isTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.core.model.editor.internal.handlers.CreateDesignateHandler;
import com.verticon.osgi.metatype.presentation.MetatypeEditorPlugin;


/**
 * A Master-Details Forms based UI created within the Factories Tab of the iRouter Component 
 * Configuration Metatype Editor.
 * 
 * Master is presented as a Tree of Configuration Factories and thier child instances. The Detail 
 * is a Form for displaying and editing of the attributes of the element selected in the Master Tree.
 * 
 * A LocationURI defined on the MasterTree is:
 *  com.verticon.tracker.configuration.form.master
 * 
 * @author jconlon
 *
 */
public class DesignatesMasterDetailsBlock extends MasterDetailsBlock {

	private static final String URI_LOCATION_REGISTRATION = "com.verticon.tracker.configuration.form.master";

	private static final String MASTER_SECTION_DESCRIPTION = "The tree contains iRouter factories and services.  Service configuration details are editable on the right";

	private static final String MASTER_SECTION_TEXT = "Factories and Services";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DesignatesMasterDetailsBlock.class);

	private DesignatesFormPage page;
	private IObservableList metaDataDesignatesObs;
	private IObservableValue treeObs;
	private TreeViewer masterViewer;
	private final IObservableValue masterDesignate = new WritableValue();
	private final IObservableValue masterOCD = new WritableValue();
	private static final String TEMPLATE = "TEMPLATE";
	private static final String ERROR_PAGE = "ERROR_PAGE";
	private Action addAction;
	private Action deleteAction;
	
	/**
	 * Map factory Pids as keys to IDetailsPage implementations. A template factory use a 
	 * TEMPLATE constant .
	 */
	private Map<Object, IDetailsPage> keyMap = new HashMap<Object, IDetailsPage>();
	private final static Image factoryImage;
	private final static Image componentImage;

	static {
		URL url = null;

		try {
			
			url = new URL(MetatypeEditorPlugin.getPlugin().getBundle().getEntry("/"),
					"icons/factory.gif");
		} catch (MalformedURLException e) {

		}
		
		factoryImage = ImageDescriptor.createFromURL(url).createImage();
		componentImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.ui",
				"icons/full/obj16/generic_elements.gif").createImage();
		
	}
	
	public DesignatesMasterDetailsBlock(DesignatesFormPage page) {
		this.page = page;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DesignatesMasterDetailsBlock []";
	}



	public void dispose() {
		logger.debug(bundleMarker,"Disposing {}",this);
		if(metaDataDesignatesObs!=null){
			metaDataDesignatesObs.dispose();
		}
		
		if(treeObs!=null){
			treeObs.dispose();
		}
//		for (IDetailsPage page : keyMap.values()) {
//			page.dispose();
//		}
//		if(componentImage!=null){
//			componentImage.dispose();
//		}
//		if(factoryImage!=null){
//			factoryImage.dispose();
//		}
		
		
	}
	
	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();

		Section section = toolkit.createSection(parent, Section.DESCRIPTION);
		section.setText(MASTER_SECTION_TEXT);
		section.setDescription(MASTER_SECTION_DESCRIPTION);
		section.marginWidth = 10;
		section.marginHeight = 5;
		toolkit.createCompositeSeparator(section);
		
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);

		Tree t = toolkit.createTree(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 20;
		gd.widthHint = 100;
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);	
		
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		masterViewer = new TreeViewer(t);
		masterViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				logger.debug(bundleMarker,"SelectionChanged invoked");
				setEditorSelection(event);
				
				managedForm.fireSelectionChanged(spart, event.getSelection());
				
			}

			private void setEditorSelection(SelectionChangedEvent event) {
				((IViewerProvider)page.getEditorPart().getAdapter(IViewerProvider.class)).
				getViewer().setSelection(event.getSelection(), true);
			}
			
			
		});
		masterViewer.setContentProvider(treeContentProvider);
		masterViewer.setLabelProvider(new TreeLabelProviderImpl());
		masterViewer.setSorter(new ViewerSorter(){

			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if((e1 instanceof Designate)&& (e2 instanceof Designate)){
					Designate d1 = (Designate)e1;
					Designate d2 = (Designate)e2;
					if(Utils.isTemplate(d1)&& Utils.isTemplate(d2)){
						try {
							String n1 = getName(d1,getMetaData());
							String n2 = getName(d2,getMetaData());
							return n1.compareTo(n2);
						} catch (ConfigurationException e) {
							logger.warn(bundleMarker, "Failed compare",e);
						}
					}
				}
				return super.compare(viewer, e1, e2);
			}});
		
		setInput();

		
	}

	void registerContextMenu(IEditorSite site) {
		//Setting up a Context Menu is done with a MenuManager
		MenuManager mgr = new MenuManager();
		mgr.add(
		    new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS)
		); // needed for later contributions
		masterViewer.getTree().setMenu(mgr.createContextMenu(masterViewer.getTree()));
		//Registering the MenuManager for contributions using ExtensionPoints
		site.registerContextMenu(URI_LOCATION_REGISTRATION,mgr,masterViewer);
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal orientation");
		
		try {
			URL url = new URL(MetatypeEditorPlugin.getPlugin().getBundle().getEntry("/"),
					"icons/th_horizontal.gif");
			haction.setImageDescriptor( ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical orientation");
		
		try {
			URL url = new URL(MetatypeEditorPlugin.getPlugin().getBundle().getEntry("/"),
					"icons/th_vertical.gif");
			vaction.setImageDescriptor( ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		
		addAction = new Action() {
			@Override
			public void run() {
				//Run the handler to create a new component
				logger.debug(bundleMarker, "Adding {}",masterDesignate.getValue());
				
				try {
					CreateDesignateHandler.createDesignate(getEditingDomain(), (Designate)masterDesignate.getValue());
				} catch (IOException e) {
					Status status = new Status(
							IStatus.ERROR, 
							Utils.PLUGIN_ID, "Failed to add a component",e);
					StatusManager.getManager().handle(status, StatusManager.LOG|StatusManager.SHOW);
				}
			}
		};
		
		addAction.setEnabled(false);
		addAction.setImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin("org.eclipse.ui",
						"$nl$/icons/full/obj16/add_obj.gif"));

		
		IWorkbench workbench = PlatformUI.getWorkbench();
		ISharedImages platformImages = workbench.getSharedImages();
		
		deleteAction = new Action() {
			@Override
			public void run() {
				//Run the handler to delete selected component
				logger.debug(bundleMarker, "Deleting {}",masterDesignate.getValue());
				try {
					Command cmd = DeleteCommand.create(getEditingDomain(), masterDesignate.getValue());
					if(cmd.canExecute()){
						getEditingDomain().getCommandStack().execute(cmd);
					}
					
				} catch (Exception e) {

					Status status = new Status(
							IStatus.ERROR, 
							Utils.PLUGIN_ID, "Failed to delete a component",e);
					 StatusManager.getManager().handle(status, StatusManager.LOG|StatusManager.SHOW);
				}
			}
		};
		deleteAction.setEnabled(false);
		deleteAction.setImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setDisabledImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));

		
		form.getToolBarManager().add(addAction);
		form.getToolBarManager().add(deleteAction);
		
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
		//Experiment
//		ToolBarManager manager = (ToolBarManager) form.getToolBarManager();
//		IMenuService menuService = (IMenuService) workbench.getActiveWorkbenchWindow().getService(
//				IMenuService.class);
//		menuService.populateContributionManager(manager, "popup:formsToolBar");
//		manager.update(true);

	}
	


	@Override
	protected void registerPages(DetailsPart detailsPart) {
		
		logger.debug(bundleMarker,"Registering detailsPart");
		final MetaData metaData = Utils.getMetaData(getEditingDomain());
		
		detailsPart.setPageProvider(new IDetailsPageProvider(){

			@Override
			public IDetailsPage getPage(Object key) {
				return keyMap.get(key);
			}

			@Override
			public Object getPageKey(Object object) {
				Designate designate = (Designate) object;

				if (Utils.isTemplate(designate)) {
					if(keyMap.get(TEMPLATE)==null){
						keyMap.put(TEMPLATE, DesignateDetailsPage.instance(
								masterDesignate,
								masterOCD, 
								getEditingDomain()));
					}
					return TEMPLATE;
				} else {
					if(keyMap.get(designate.getFactoryPid())==null){
					    
						try {
							keyMap.put(designate.getFactoryPid(), 
									ComponentDetailsPage.instance(
											Utils.getOCD(designate, metaData),
											masterDesignate,
											masterOCD, 
											getEditingDomain()));
						} catch (ConfigurationException e) {
							if(keyMap.get(ERROR_PAGE)==null){
								keyMap.put(ERROR_PAGE, new ErrorPage());
								return ERROR_PAGE;
							}
						}
					}
					return designate.getFactoryPid();
				}
			}});

	}

    private EditingDomain getEditingDomain(){
		return ((IEditingDomainProvider)page.getEditorPart().getAdapter(IEditingDomainProvider.class)).getEditingDomain();
	}
	
	private MetaData getMetaData(){
		return Utils.getMetaData(getEditingDomain());
	}
	
	 void setInput(){
		masterViewer.setInput(getMetaData());

		IEMFListProperty prop = EMFProperties
				.list(MetatypePackage.Literals.META_DATA__DESIGNATE);
		if(metaDataDesignatesObs!=null){
			metaDataDesignatesObs.dispose();
		}
		metaDataDesignatesObs = prop.observe(getMetaData());

		metaDataDesignatesObs.addListChangeListener(new IListChangeListener() {

			@Override
			public void handleListChange(ListChangeEvent event) {
				logger.debug(bundleMarker, "Refreshing");
				masterViewer.refresh();

			}
		});

		if(treeObs!=null){
			treeObs.dispose();
		}
		treeObs = ViewerProperties.singleSelection().observe(masterViewer);

		// Because there are different kinds of Designates,
		// Observing the selection is not good enough -it is
		// is necessary to have an intermediate way to examine
		// designates.
		treeObs.addValueChangeListener(new IValueChangeListener() {

			public void handleValueChange(ValueChangeEvent event) {
//				logger.debug(bundleMarker,"handleValueChanged invoked event={}",event);

				if (event.diff.getNewValue() instanceof Designate) {
					
					Designate designate = (Designate) event.diff.getNewValue();
					try {
					    masterDesignate.setValue(designate);
					
					
						masterOCD.setValue(Utils.getOCD(designate, getMetaData()));
						if (Utils.isTemplate(designate)) {
							addAction.setEnabled(true);
							addAction.setToolTipText("Add a New " + getName(designate,getMetaData()));
							deleteAction.setEnabled(false);
							deleteAction.setToolTipText(null);
						} else {
							addAction.setEnabled(false);
							addAction.setToolTipText(null);
							deleteAction.setEnabled(true);
							deleteAction.setToolTipText("Delete " + getName(designate,getMetaData()));
//							logger.debug(bundleMarker, "Selected designate pid={} factoryPid={}"
//									, designate.getPid(),designate.getPid());
						}
					} catch (ConfigurationException e) {
						logger.error(bundleMarker,"Failed to add Designate with pid ",e);
						addAction.setEnabled(false);
						deleteAction.setEnabled(true);
						Status status = new Status(IStatus.ERROR, Utils.PLUGIN_ID, 0,
					            "Configuration Exception", e);
					    ErrorDialog.openError(Display.getCurrent().getActiveShell(),
					            "Configuration Error", "Configuration problems", status);
						
					}

				}
			}
		});
	}
	
	private ITreeContentProvider treeContentProvider = new ITreeContentProvider() {
		MetaData model;
		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Designate) {

				Designate designate = (Designate) parentElement;
				if (isTemplate(designate)) {
					List<Designate> children = getTemplateChildren(designate);
					return children.toArray(new Object[children.size()]);
				}

			}
			return new Object[] {};

		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof Designate) {
				Designate designate = (Designate) element;
				return getTemplateParent(designate);
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof Designate) {
				Designate designate = (Designate) element;
				return !getTemplateChildren(designate).isEmpty();
			}
			return false;
		}

		@Override
		public Object[] getElements(Object inputElement) {
//			if (inputElement instanceof MetaData) {
//				MetaData metaData = (MetaData) inputElement;
			if (model!=null){
				List<Designate> designates = new ArrayList<Designate>();
				for (Designate designate : model.getDesignate()) {
					if (isTemplate(designate)) {
						designates.add(designate);
					}
				}
				return designates.toArray(new Object[designates.size()]);
			}
			return null;
		}

		@Override
		public void dispose() {

			 if(metaDataDesignatesObs !=null)
			 metaDataDesignatesObs.dispose();
			 
			 if(treeObs != null)
			 treeObs.dispose();
			 
			 masterDesignate.dispose();
		     masterOCD.dispose();
				

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			model = (MetaData) newInput;
			
			if (oldInput != null) {
				logger.debug(bundleMarker, "Input Changed oldInput={}",
						oldInput);
				// removeListenerFrom((MovingBox)oldInput);
			}
			if (newInput != null) {
				// addListenerTo((MovingBox)newInput);
				logger.debug(bundleMarker, "Input Changed newInput={}",
						newInput);

			}

		}

	};
	
	private class TreeLabelProviderImpl extends StyledCellLabelProvider {

		
		private IMapChangeListener mapChangeListener = new IMapChangeListener() {
			public void handleMapChange(MapChangeEvent event) {
				Set<?> affectedElements = event.diff.getChangedKeys();
				if (!affectedElements.isEmpty()) {
					LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
							TreeLabelProviderImpl.this, affectedElements
									.toArray());
					fireLabelProviderChanged(newEvent);
				}
			}
		};

		public TreeLabelProviderImpl(IObservableMap... attributeMaps) {
			for (int i = 0; i < attributeMaps.length; i++) {
				attributeMaps[i].addMapChangeListener(mapChangeListener);
			}
		}

		@Override
		public String getToolTipText(Object element) {
			return "#dummy#";
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof Designate) {
				Designate designate = (Designate) cell.getElement();
				// StyledString styledString = new StyledString(
				// p.getPid() != null ? p.getPid()
				// : "*Component waiting for registration*", null);

				StyledString styledString = null;
				String decoration = null;
				if (Utils.isTemplate(designate)) {
					try {
						styledString = new StyledString(getName(designate,getMetaData()));
					    decoration = " ("
							+ Utils.getTemplateChildren(designate).size()
							+ " services)";
						
					} catch (ConfigurationException e) {
						styledString = new StyledString("Template with a ConfigurationException:");
						decoration = " ("
								+ e.getMessage()
								+ ")";
					}
					styledString
					.append(decoration, StyledString.COUNTER_STYLER);
					cell.setText(styledString.getString());
					cell.setImage(factoryImage);
				} else {

					if (designate.getPid() != null) {
						styledString = new StyledString(designate.getPid()
								.substring(designate.getPid().indexOf('-') + 1));
					} else {
						try {
							styledString = new StyledString(getName(designate,getMetaData()));
							decoration = " - waiting for registration";
						} catch (ConfigurationException e) {
							styledString = new StyledString("Instance with a ConfigurationException:");
							decoration = " ("
									+ e.getMessage()
									+ ")";
						}
					    
						styledString.append(decoration,
								StyledString.COUNTER_STYLER);
					}
					cell.setText(styledString.getString());
					cell.setImage(componentImage);
				}
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}
	
	void prepareToReload(){
		masterViewer.collapseAll();
	}

	
	
}
