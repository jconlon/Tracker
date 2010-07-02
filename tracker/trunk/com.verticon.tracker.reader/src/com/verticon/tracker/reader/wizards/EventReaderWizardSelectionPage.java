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
package com.verticon.tracker.reader.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
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
import org.eclipse.jface.wizard.IWizardPage;
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

import com.verticon.tracker.reader.IReaderWizard;
import com.verticon.tracker.reader.ReaderPlugin;

/**
 * A WizardPage that nests a set of IWizardPublisher that are created from the extension point 
 * (named <code>"com.verticon.tracker.reader.publisherWizards"</code>).
 * For example, the plug-in's XML markup might contain:
 * <pre>
 * &LT;extension point="com.verticon.tracker.reader.readerWizards"&GT;
 *   &LT;wizard
 *       id="com.example.myplugin.blob"
 *       name="Blob Event Publisher"
 *       class="com.example.myplugin.BlobFilePublisher"
 *       icon="icons/import_blob_wiz.gif"&GT;
 *     &LT;description&GT;Publish Events from a BLOB file&LT;/description&GT;
 *   &LT;/wizard&GT;
 * &LT;/extension&GT;
 * </pre>
 * </p>
 * 
 * 
 * @author jconlon
 *
 */
class EventReaderWizardSelectionPage extends WizardSelectionPage {
	
	
	
	private TableViewer tableViewer;
	private IWorkbench workbench;
	private static IReaderWizard[] cachedWizards;
	
	protected EventReaderWizardSelectionPage(String pageName, IWorkbench workbench) {
		super(pageName);
		this.workbench=workbench;
		setTitle(pageName);
		setDescription("Select the type of Event Reader you would like to create.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		
		
		tableViewer=createViewer( container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace=true;
		data.grabExcessVerticalSpace=true;
		data.heightHint = 400;
		data.widthHint = 300;
		tableViewer.getControl().setLayoutData(data);
		setControl(container);
	}
	
	
	private TableViewer createViewer(Composite parent) {
		TableViewer tableViewer = new TableViewer(parent, SWT.SINGLE
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String[] columnNames = new String[] {"Reader", "Description"};
		int[] columnWidths = new int[] {150, 400};
		
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = 
				new TableColumn(table, SWT.LEFT);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}
		
		tableViewer.setLabelProvider(new IPublisherWizardListLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(getReaderWizardsFromContributors());
		tableViewer.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object p1, Object p2) {
				return ((ReaderWizardProxy) p1).getNameOfCreatedReader()
						.compareToIgnoreCase(
								((ReaderWizardProxy) p2)
										.getNameOfCreatedReader());
			}
		});
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

				ReaderWizardProxy w = (ReaderWizardProxy) selection
						.getFirstElement();

				setSelectedNode(createIWizardNode(w, workbench));
				setErrorMessage(null);
				setMessage(w.getNameOfCreatedReader() + " "
						+ w.getDescription(), IMessageProvider.INFORMATION);

			}
		});

		return tableViewer;
	}
	
	static final IWizardNode createIWizardNode(final IReaderWizard iWizard, final IWorkbench workbench  ){
		
		return new IWizardNode(){
			public void dispose() {
				iWizard.dispose();
			}

			public Point getExtent() {
				return new Point(1,1);
			}

			public IWizard getWizard() {
				iWizard.init(workbench, null);
				return iWizard;
			}

			public boolean isContentCreated() {
				return iWizard.getPageCount()>0;
			}
			
		};
	}
	
	/**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			tableViewer.refresh();
		}
		super.setVisible(visible);
	}

	 
	 /**
	  * Builds a list of publisher wizards from the extension points 
	  * and do lazy instantiations after selection.
	  * 
	  * @return
	  */
	 private IReaderWizard[] getReaderWizardsFromContributors(){
		 
		 if (cachedWizards !=null){
			 return cachedWizards;
		 }
		 List<IReaderWizard> found = getIReaderWizards();
		 cachedWizards=(IReaderWizard[]) found.toArray(
				 new IReaderWizard[found.size()]
		 );

		 return cachedWizards;
	 }

	/**
	 * @return
	 * @throws InvalidRegistryObjectException
	 */
	private static List<IReaderWizard> getIReaderWizards()
			throws InvalidRegistryObjectException {
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
				 ReaderPlugin.PLUGIN_ID, "readerWizards")
				 .getExtensions();
		 List<IReaderWizard> found = new ArrayList<IReaderWizard>();
		 for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements =
					extensions[i].getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				IReaderWizard proxy =
					parseType(configElements[j],found.size());
				if(proxy != null){
					found.add(proxy);
				}
			}
		 }
		return found;
	}

	private static IReaderWizard parseType(IConfigurationElement configElement, int ordinal){
		 if (!configElement.getName().equals("wizard"))
		      return null;
		   try {
		      return new ReaderWizardProxy(configElement);
		   }
		   catch (Exception e) {
		      String name = configElement.getAttribute("name");
		      if (name == null)
		         name = "[missing name attribute]";
		      String msg =
		         "Failed to load wizard named "
		            + name
		            + " in "
		            + configElement.getDeclaringExtension().getContributor().getName();
		           
		      Logger logger = LoggerFactory
				.getLogger(EventReaderWizardSelectionPage.class);
		      logger.error(msg, e);
		      return null;
		   }
	}
	
	
	
	class IPublisherWizardListLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			ReaderWizardProxy publisher = (ReaderWizardProxy) element;
			return publisher.getNameOfCreatedReader();
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			ReaderWizardProxy publisher = (ReaderWizardProxy) element;
			switch (columnIndex) {
			case 0:
				return publisher.getNameOfCreatedReader();

			case 1:
				return publisher.getDescription();
			}
			return null;
		}
	}

	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
	
	

}
