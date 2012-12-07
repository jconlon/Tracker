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
/**
 * 
 */
package com.verticon.agriculture.presentation.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.verticon.agriculture.presentation.AgricultureEditorPlugin;
import com.verticon.location.Area;
import com.verticon.location.service.ILocationService;
import com.verticon.tracker.Premises;

/**
 * 
 * A wizard page presenting a table selection of Locations that can be set on a
 * Sighting event. Table inputList is built from the ILocationService.
 * 
 * Table shows names of locations in the premises.
 * 
 * BESTPRACTICE for WizardPage Table DataBinding Dispose
 * 
 * @author jconlon
 * 
 */
class SelectLocationWizardPage extends WizardPage {

	// private final String idOfPremises;
	private final Premises premises;
	private final Model model = new Model();
	// private AdapterFactory adapterFactory = new
	// TrackerItemProviderAdapterFactory();
	private TableViewer tableViewer;

	// Disposables
	private DataBindingContext dataBindingContext;
	private IObservableValue selection;
	private IObservableList inputList;
	private boolean initializedModel = false;

	protected SelectLocationWizardPage(Premises premises) {
		super("selectEvent");
		setTitle("Location Selection");
		setDescription("Select the Location of the Animal");
		this.premises = premises;
	}

	@Override
	public void dispose() {
		if (dataBindingContext != null) {
			dataBindingContext.dispose();
		}
		selection.dispose();
		inputList.dispose();
		super.dispose();
	}

	public void createControl(Composite parent) {
		setPageComplete(false);
		dataBindingContext = new DataBindingContext();
		WizardPageSupport.create(this, dataBindingContext);
		Composite composite = new Composite(parent, SWT.NONE);

		// Set up data binding.
		tableViewer = createSingleColumnForTableViewer(composite);

		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;
		data.heightHint = 300;
		data.widthHint = 300;
		tableViewer.getTable().setLayoutData(data);

		selection = ViewerProperties.singleSelection().observe(tableViewer);

		dataBindingContext.bindValue(selection, model.selection, null, null

		);

		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(composite);
		setControl(composite);
	}

	protected TableViewer createSingleColumnForTableViewer(
			Composite tableComposite) {

		final TableViewer v = new TableViewer(tableComposite);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		v.setContentProvider(cp);
		v.setLabelProvider(new LabelProvider());

		return v;

	}

	String getSelectedLocation() {
		return (model.selection.getValue() == null || !initializedModel) ? null
				: (String) model.selection.getValue();
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		// Set the initial field focus
		if (visible) {
			try {
				fillTable();
				initializedModel = true;
			} catch (IOException e) {
				List<String> error = newArrayList();
				error.add(e.getLocalizedMessage());
				inputList = new WritableList(error, String.class);
				tableViewer.setInput(inputList);
				this.setErrorMessage(e.getLocalizedMessage());
			}
		}
	}

	/**
	 * Fill the table with the location names of the premises. If the premises
	 * has no locations try the Location service
	 * 
	 * @throws IOException
	 */
	private void fillTable() throws IOException {
		Set<String> locations = null;
		if (premises.getLocation() != null) {
			locations = newHashSet();
			locations.add(premises.getLocation().getName());
			for (Area area : premises.getLocation().getAreas()) {
				locations.add(area.getName());
			}
		} else {
			ILocationService ls = getLocationService();
			locations = ls.locationsIn(premises.getUri());
		}
		inputList = new WritableList(locations, String.class);
		tableViewer.setInput(inputList);
	}

	private class Model {
		IObservableValue selection = new WritableValue(null, String.class);
	}

	private ILocationService getLocationService() throws IOException {
		BundleContext context = AgricultureEditorPlugin.getPlugin().getBundle()
				.getBundleContext();
		ServiceReference<?> sr = context
				.getServiceReference(ILocationService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ILocationService.");
		}
		return (ILocationService) context.getService(sr);
	}
}