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
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates databinding based forms for a selection of EObjects.
 * 
 * @author jconlon
 * 
 */
public class DefaultPropertiesFormProvider implements IPropertiesFormProvider {
	

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DefaultPropertiesFormProvider.class);

	private String FILTER_ID_EXPERT = "org.eclipse.ui.views.properties.expert"; //$NON-NLS-1$

	//Needs disposing
	private IObservableValue statusMessageObservable; 
	private Map<String, Group> categoryNameToGroupMap;
	private DataBindingContext dataBindingContext;
	private WizardPage wizardPage = null;
	private CTabItem cTabItem; 
	
	
	private int cTabItemCounters = 0;
	private int groupCounter=0;
	
	public DefaultPropertiesFormProvider() {
		super();
		logger.debug(bundleMarker,"{} Constructed.",this);
	}
	
	void dispose(){
		disposeStatusMessage();
		disposeGroupMap();
		disposeDataBindingContext();
		disposeWizardPage();
		disposeCTabItem();
	}
	
	public void setStatusMessageObservable(
			IObservableValue statusMessageObservable) {
		disposeStatusMessage();
		this.statusMessageObservable = statusMessageObservable;
	}

	
	
	/**
	 * Use the selection to create a Form in the cTabFolder.
	 * 
	 */
	public void fillProperties(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder,
			String nameOfTab, boolean showAdvanceProperties) {
		logger.debug(bundleMarker,"{} Filling properties",this);
		disposeCTabItem();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			cTabItem = new CTabItem(cTabFolder, SWT.NONE);
			cTabItemCounters++;
			
			cTabItem.addDisposeListener(
					new WidgetDisposal("cTabItem",cTabItemCounters){

						@Override
						public void widgetDisposed(DisposeEvent e) {
							cTabItemCounters--;
							super.widgetDisposed(e);
						}}
			);
			
			cTabItem.setText(nameOfTab);
			// Create a composite with a two column layout
			Composite composite1 = new Composite(cTabFolder, SWT.NONE);
			composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			cTabItem.setControl(composite1);
			{
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				data.horizontalAlignment = SWT.END;
				composite1.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				layout.numColumns = 2;
				composite1.setLayout(layout);
			}
			handleSelection(structuredSelection, adapterFactory, composite1,
					showAdvanceProperties);
			cTabFolder.setSelection(cTabItem);
		} else {
			createEmptyCTabItem(cTabFolder, nameOfTab);
		}
	}

	

	/**
	 * @param cTabFolder
	 * @param nameOfTab
	 *            TODO
	 */
	private Composite createEmptyCTabItem(CTabFolder cTabFolder,
			String nameOfTab) {

		cTabItem = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem.setText(nameOfTab);
		// Create a composite with a two column layout
		Composite composite1 = new Composite(cTabFolder, SWT.NONE);
		composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		cTabItem.setControl(composite1);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.END;
			composite1.setLayoutData(data);

			GridLayout layout = new GridLayout();
			// GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			composite1.setLayout(layout);
		}

		cTabFolder.setSelection(cTabItem);
		return composite1;
	}

	/**
	 * Default only handles the first object selected.
	 * 
	 * @param structuredSelection
	 * @param adapterFactory
	 * @param composite1
	 */
	private void handleSelection(IStructuredSelection structuredSelection,
			AdapterFactory adapterFactory, Composite composite1,
			boolean showAdvanceProperties) {
		// Only deal with an IStructuredSelection
		if (structuredSelection.size() == 1) {
			Object object = structuredSelection.getFirstElement();
			createForm(composite1, object, adapterFactory,
					showAdvanceProperties);
		}
	}

	/**
	 * @param parent
	 * @param object
	 */
	private void createForm(Composite parent, Object object,
			AdapterFactory adapterFactory, boolean showAdvanceProperties) {
		if(categoryNameToGroupMap==null){
			categoryNameToGroupMap = new HashMap<String, Group>();
		}else if(!categoryNameToGroupMap.isEmpty()){
			disposeGroupMap();
		}
		if(dataBindingContext!=null){
			disposeDataBindingContext();
		}
		dataBindingContext = new EMFDataBindingContext();
		
		IItemPropertySource itemPropertySource = (IItemPropertySource) adapterFactory
				.adapt(object, IItemPropertySource.class);

		if (wizardPage != null) {
			WizardPageSupport.create(wizardPage, dataBindingContext);
		}

		// IItemProperySource is already set
		// get all the IItemPropertyDescriptors for the object
		int propCounter = 0;
		for (IItemPropertyDescriptor itemPropertyDescriptor : itemPropertySource
				.getPropertyDescriptors(object)) {
			propCounter++;
			boolean filterProperty = false;
			if (!showAdvanceProperties) {
				String[] filters = itemPropertyDescriptor
						.getFilterFlags(object);
				if (filters != null) {
					for (String filter : filters) {
						if (filter.equals(this.FILTER_ID_EXPERT)) {
							filterProperty = true;
							//logger.debug(bundleMarker,"Filtering Property {} has filter {}"
							// ,
							// itemPropertyDescriptor
							// .getDisplayName(object), filter);
						}
						// else {
						// logger.debug(bundleMarker,
						// "Not Filtering Property {} has filter {}",
						// itemPropertyDescriptor
						// .getDisplayName(object), filter);
						// }
					}
				}
			}
			if (filterProperty) {
				continue;
			}
			// Create a label with the name of the property
//			logger.debug(bundleMarker,"Creating label for property {} with filter {}",
//					itemPropertyDescriptor.getDisplayName(object),
//					itemPropertyDescriptor.getFilterFlags(object));
			String categoryName = itemPropertyDescriptor.getCategory(object);
			if (categoryName == null) {
				categoryName = itemPropertyDescriptor.getDescription(object);
			}
			if (!categoryNameToGroupMap.containsKey(categoryName)) {
				Group group = new Group(parent, SWT.BORDER);
				groupCounter++;
				
				group.addDisposeListener(
						new WidgetDisposal("group:"+categoryName,groupCounter){

							@Override
							public void widgetDisposed(DisposeEvent e) {
								groupCounter--;
								super.widgetDisposed(e);
							}}
				);
				group.setText(categoryName);
				GridLayout layout = new GridLayout();
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				group.setLayout(layout);
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				group.setLayoutData(data);

				categoryNameToGroupMap.put(categoryName, group);
			}

			Label label = new Label(categoryNameToGroupMap.get(categoryName), SWT.NONE);
			label.setForeground(parent.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			label.setBackground(parent.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			label.setText(itemPropertyDescriptor.getDisplayName(object));
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				label.setLayoutData(gridData);
				label.setToolTipText(itemPropertyDescriptor
						.getDescription(object));
			}
			
			label.addDisposeListener(new WidgetDisposal("label:"+itemPropertyDescriptor.getDisplayName(object),propCounter));

			visualize(object, categoryNameToGroupMap, dataBindingContext, itemPropertyDescriptor,
					categoryName, adapterFactory);

		}

		if (statusMessageObservable != null) {
			dataBindingContext
					.bindValue(statusMessageObservable,
							new AggregateValidationStatus(dataBindingContext
									.getBindings(),
									AggregateValidationStatus.MAX_SEVERITY),
							null, null);
		}

	}

	
	private void disposeDataBindingContext() {
		dataBindingContext.dispose();
	}

	private void disposeGroupMap() {
		for (Group group : categoryNameToGroupMap.values()) {
			group.dispose();
		}
		categoryNameToGroupMap.clear();
	}

	/**
	 * @param object
	 * @param categoryNameToGroupMap
	 * @param dataBindingContext
	 * @param itemPropertyDescriptor
	 * @param categoryName
	 */
	private void visualize(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor,
			String categoryName, AdapterFactory adapterFactory) {

		ControlBuilder builder = ControlBuilderFactory.getInstance(object,
				itemPropertyDescriptor);
		
		builder.createControl(object, mp.get(categoryName),
				itemPropertyDescriptor, adapterFactory, dataBindingContext);

	}

	public WizardPage getWizardPage() {
		return wizardPage;
	}

	public void setWizardPage(WizardPage wizardPage) {
		disposeWizardPage();
		this.wizardPage = wizardPage;
		
	}

	private void disposeWizardPage() {
		if(this.wizardPage!=null){
			wizardPage.dispose();
			wizardPage=null;
		}
	}

	private void disposeStatusMessage() {
		if(statusMessageObservable!=null){
			statusMessageObservable.dispose();
		}
	}
	
	private void disposeCTabItem() {
		if (cTabItem != null) {
			logger.debug(bundleMarker,"{} Invoking dispose() of cTabItem, id={}",this,cTabItemCounters);
			cTabItem.dispose();
			cTabItem = null;
		}
	}
	
	class WidgetDisposal implements DisposeListener{
		final String name;
		final int id;
		private WidgetDisposal(String name, int id) {
			super();
			this.name = name;
			this.id = id;
			logger.debug(bundleMarker,"{} Constructed. {} id={}",
					new Object[]{this,name,id});
		}
		
		@Override
		public String toString() {
			return "WidgetDisposal [id=" + id + ", name=" + name + "]";
		}

		@Override
		public void widgetDisposed(DisposeEvent e) {
			
			logger.debug(bundleMarker,"{} widgetDisposed invoked name={} id={}",
					new Object[]{this, name,id});
		}
		
	}
}
