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
package com.verticon.tracker.editor.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.TrackerPackage;

/**
 * SelectEventAttributesWizardPage is the first page of the ModifyEventsWizard 
 * that allows the user to specify
 * the event attributes to be used for setting values in the next 
 * SelectModifyEventsValuesPage page.
 * 
 * @see  SelectModifyEventsValuesPage
 * @see ModifyEventsWizard
 * @author jconlon
 * 
 */
class SelectEventAttributesWizardPage extends WizardPage {

	private CheckboxTableViewer checkboxTableViewer;
	
	private final static Map<EAttribute, String> possibleAttributes = new LinkedHashMap<EAttribute, String>();

	static {
		possibleAttributes.put(TrackerPackage.eINSTANCE.getEvent_Comments(), "Add a comment to the event");
		possibleAttributes.put(TrackerPackage.eINSTANCE.getEvent_Correction(), "Flag the event as a correction to a previous Event");
		possibleAttributes.put(TrackerPackage.eINSTANCE.getEvent_ElectronicallyRead(), "Specify if the event was read electrionically");
	
	
	}

	
	public SelectEventAttributesWizardPage() {
		super("selectAttributes");
		setTitle("Select Attributes");
		setDescription("Select the Event attriubtes to modify");

	}

	

	/**
	 * Creates the top level control for this dialog page under the given parent
	 * composite, then calls <code>setControl</code> so that the created
	 * control can be accessed via <code>getControl</code>
	 * 
	 * @param parent
	 *            the parent composite
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());
		setControl(container);

		checkboxTableViewer = CheckboxTableViewer.newCheckList(container,
				SWT.BORDER);

		checkboxTableViewer
				.setContentProvider(new EventAttributesContentProvider());
		checkboxTableViewer.setLabelProvider(new EventAttributesLabelProvider());
		final Table table = checkboxTableViewer.getTable();
		final FormData formData = new FormData();
		formData.bottom = new FormAttachment(100, 0);
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, 0);
		formData.left = new FormAttachment(0, 0);
		table.setLayoutData(formData);
		table.setHeaderVisible(true);

		final TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(200);
		tableColumn.setText("Attribute");

		final TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(250);
		tableColumn_1.setText("Description");
		

		checkboxTableViewer.setInput(possibleAttributes);
		checkboxTableViewer.addSelectionChangedListener(
				new ISelectionChangedListener(){

					public void selectionChanged(SelectionChangedEvent event) {
						updatePageComplete();
						
					}});
	}
	
	

	@Override
	public void setVisible(boolean visible) {
		checkboxTableViewer.setInput(possibleAttributes);
		
		super.setVisible(visible);
	}

	/**
	 * Return the currently selected strings.
	 */
	public Collection<EAttribute> getSelectedAttributes() {
		Object[] checked = checkboxTableViewer.getCheckedElements();
		Collection<EAttribute> result = new ArrayList<EAttribute>();
		for (Object attribute : checked) {
			result.add((EAttribute)attribute);
		}
		return result;
	}
	
	private void updatePageComplete(){
		setPageComplete(false);
		if(!getSelectedAttributes().isEmpty()){
			setPageComplete(true);
		}
	}

	private static class EventAttributesContentProvider implements IStructuredContentProvider {

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		public Object[] getElements(Object inputElement) {
			return possibleAttributes.keySet().toArray();
		}

	}
	
	private static class EventAttributesLabelProvider implements ITableLabelProvider {

		protected Image getImage(Object element) {
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			
		}

		public void dispose() {

		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			
		}

		public Image getColumnImage(Object element, int columnIndex) {
			
			return getImage( element);
		}

		public String getColumnText(Object element, int columnIndex) {
			String result = "";
			if(! (element instanceof EAttribute)){
				return result;
			}
			
			switch (columnIndex) {
			case 0:
				result =  ((EAttribute)element).getName();
				break;
			case 1:
				result =  possibleAttributes.get((EAttribute)element);
				break;

			default:
				break;
			}
			return result;
		}
		
	}

}
