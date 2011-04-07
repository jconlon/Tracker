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
package com.verticon.tracker.irouter.gps.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.gps.ui.IURIWizard;
import com.verticon.tracker.irouter.gps.ui.internal.bundle.Activator;

/**
 * A WizardPage that shows a table of URIWizardProxy objects for the user to
 * select.
 * 
 * These URIWizardProxy objects are created from the extension point
 * com.verticon.tracker.irouter.gps.ui.gpsWizards
 * 
 * This extension point is used to register Tracker iRouter GPS Wizard
 * extensions. GPS wizards appear as choices within the "GPS View Add Action" of
 * the "New GPS wizard". GPS wizards create connection oriented URIs which are
 * used to create GPS iRouter Producers that will show up as service instances
 * in the Configuration Editor.
 * 
 * 
 * @author jconlon
 * 
 */
class GPSDeviceWizardSelectionPage extends WizardSelectionPage {
	private static final String DESCRIPTION = "Select the type of GPS Device you would like to create.";
	private static final String TITLE = "Select GPS device type";

	private TableViewer tableViewer;
	private IWorkbench workbench;
	private static IURIWizard[] cachedWizards;

	protected GPSDeviceWizardSelectionPage(IWorkbench workbench) {
		super(TITLE);
		this.workbench = workbench;
		setTitle(TITLE);
		setDescription(DESCRIPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

		tableViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		tableViewer.getControl().setLayoutData(data);
		setControl(container);
	}

	/**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			tableViewer.refresh();
			getWizard().getContainer().updateButtons();

		}
		super.setVisible(visible);
	}

	private TableViewer createViewer(Composite parent) {
		TableViewer tableViewer = new TableViewer(parent, SWT.SINGLE
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] columnNames = new String[] { "GPS Type", "Description" };
		int[] columnWidths = new int[] { 150, 400 };

		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}

		tableViewer.setLabelProvider(new IPublisherWizardListLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(getReaderWizardsFromContributors());
		tableViewer.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object p1, Object p2) {
				return ((URIWizardProxy) p1).getNameOfCreatedReader()
						.compareToIgnoreCase(
								((URIWizardProxy) p2).getNameOfCreatedReader());
			}
		});
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						URIWizardProxy w = (URIWizardProxy) selection
								.getFirstElement();
						setSelectedNode(createIWizardNode(w, workbench));
						setErrorMessage(null);
						setMessage(
								w.getNameOfCreatedReader() + " "
										+ w.getDescription(),
								IMessageProvider.INFORMATION);
						getWizard().getContainer().updateButtons();

					}
				});

		return tableViewer;
	}

	private static final IWizardNode createIWizardNode(
			final IURIWizard iWizard, final IWorkbench workbench) {

		return new IWizardNode() {
			public void dispose() {
				iWizard.dispose();
			}

			public Point getExtent() {
				return new Point(1, 1);
			}

			public IWizard getWizard() {
				iWizard.init(workbench, null);
				return iWizard;
			}

			public boolean isContentCreated() {
				return iWizard.getPageCount() > 0;
			}

		};
	}

	/**
	 * Builds a list of publisher wizards from the extension points and do lazy
	 * instantiations after selection.
	 * 
	 * @return
	 */
	private IURIWizard[] getReaderWizardsFromContributors() {

		if (cachedWizards != null) {
			return cachedWizards;
		}
		List<IURIWizard> found = getIURIWizards();
		cachedWizards = (IURIWizard[]) found.toArray(new IURIWizard[found
				.size()]);

		return cachedWizards;
	}

	/**
	 * @return
	 * @throws InvalidRegistryObjectException
	 */
	private static List<IURIWizard> getIURIWizards()
			throws InvalidRegistryObjectException {
		List<IURIWizard> found = new ArrayList<IURIWizard>();
		IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint(Activator.PLUGIN_ID, "gpsWizards");
		IExtension[] extensions = point.getExtensions();

		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				IURIWizard proxy = parseType(configElements[j], found.size());
				if (proxy != null) {
					found.add(proxy);
				}
			}
		}
		return found;
	}

	private static IURIWizard parseType(IConfigurationElement configElement,
			int ordinal) {
		if (!configElement.getName().equals("wizard"))
			return null;
		try {
			return new URIWizardProxy(configElement);
		} catch (Exception e) {
			String name = configElement.getAttribute("name");
			if (name == null)
				name = "[missing name attribute]";
			String msg = "Failed to load wizard named "
					+ name
					+ " in "
					+ configElement.getDeclaringExtension().getContributor()
							.getName();

			Logger logger = LoggerFactory
					.getLogger(GPSDeviceWizardSelectionPage.class);
			logger.error(msg, e);
			return null;
		}
	}

	private class IPublisherWizardListLabelProvider extends LabelProvider
			implements ITableLabelProvider {
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			URIWizardProxy publisher = (URIWizardProxy) element;
			return publisher.getNameOfCreatedReader();
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			URIWizardProxy publisher = (URIWizardProxy) element;
			switch (columnIndex) {
			case 0:
				return publisher.getNameOfCreatedReader();

			case 1:
				return publisher.getDescription();
			}
			return null;
		}
	}

}
