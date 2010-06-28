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
package com.verticon.tracker.editor.presentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.verticon.tracker.TrackerPackage;


/**
 * Page Two of Three for the ImportStandardEventDataWizard
 * 
 * Presents a list viewer and selection controls for mapping csv 
 * data in columns, to a list of features.
 * 
 * @see ImportStandardEventDataWizard
 * @author jconlon
 * 
 */
class ImportStandardEventColumnMappingWizardPage extends WizardPage {

	private TableViewer tableViewer;
	
	private final List<ColumnMapper> fileColumnsToFeatureMap = 
		new LinkedList<ColumnMapper>();
	
	private ComboBoxViewerCellEditor cv = null;
	
	/**
	 * Reference to a class that shows the state of the mappings.
	 */
	private static final Flags flags = new Flags();

	protected ImportStandardEventColumnMappingWizardPage() {
		super("selectColumns");
		setTitle("Import Data Column Mapper");
		setDescription("Map the Imported File's Column Names to Animal Element Feature Names.");
	}
	

	public void createControl(Composite parent) {
		Composite child = new Composite(parent, SWT.NULL);
		child.setLayout(new FillLayout(SWT.VERTICAL));

		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		container.setLayout(gridLayout);
		tableViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 4;
		data.heightHint = 300;
		data.widthHint = 300;
		tableViewer.getControl().setLayoutData(data);
		
		setControl(child);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			if(fileColumnsToFeatureMap.isEmpty()){
				init();
			}
			IWizard wizard = getWizard();
			
			List<EStructuralFeature> features = ((ImportStandardEventDataWizard)wizard).getPageOneSelectedFeatures();
			cv.setInput(features);
			setPageComplete(false);
		}
		super.setVisible(visible);
	}
	
	
	/**
	 * 
	 * @return results of the wizardPage
	 */
	List<ColumnMapper> getFileColumnToFeatureMap() {
		return fileColumnsToFeatureMap;
	}
	
	
	private void init(){
		try {
			refreshColumnValues();
		} catch (IOException e) {
			setErrorMessage("Data Import Error. "
					+ e.getMessage());
		}
	}

	private TableViewer createViewer(Composite parent) {
		Table table = new Table(
				parent, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(table, SWT.NONE);
		tc.setText("Column Number");
		tc.pack();
		
		TableColumn tc2 = new TableColumn(table, SWT.NONE);
		tc2.setText("First Row's Column Value");
		tc2.pack();
		
		TableColumn tc3 = new TableColumn(table, SWT.NONE);
		tc3.setText("Animal Feature Name");
		tc3.pack();
				
		final TableViewer viewer = new TableViewer(table);
		viewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}

			public void dispose() {
				
			}

			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

		});
		viewer.setLabelProvider(new ITableLabelProvider() {
		
			public void removeListener(ILabelProviderListener listener) {
				
			}
		
			public boolean isLabelProperty(Object element, String aProperty) {
				return false;
			}
		
			public void dispose() {
				
			}
		
			public void addListener(ILabelProviderListener listener) {
				
			}
		
			public String getColumnText(Object element, int aColumnIndex) {
				ColumnMapper colMapper = (ColumnMapper)element;
		
				if( aColumnIndex == 0 ) {
					return Short.toString(colMapper.getIndex());
				} else if( aColumnIndex == 1 ){
					return colMapper.getColumnName();
				}
				EStructuralFeature feature =colMapper.getFeature();
				if(feature==null){
					return "";
				}
				return ((EClass)feature.eContainer()).getName()+':'+feature.getName();
				
				
			}
		
			public Image getColumnImage(Object element, int aColumnIndex) {
				return null;
			}
		
		});
		viewer.setColumnProperties(new String[] { "Number", "ColumnName", "Feature" });
		CellEditor[] cellEditors = new CellEditor[3];
	    cv = new ComboBoxViewerCellEditor(table);
		cv.setContenProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}

			public void dispose() {
				
			}

			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

		});
		cv.setLabelProvider(new LabelProvider() {
				
			@Override
			public String getText(Object element) {
				EStructuralFeature feature =(EStructuralFeature)element;
				if(feature==null){
					return "";
				}
				return ((EClass)feature.eContainer()).getName()+':'+feature.getName();
				
			}
		
		});
		
		
		
		cellEditors[2] = cv;

		viewer.setCellEditors(cellEditors);

		viewer.setCellModifier(new ICellModifier() {

			public void modify(Object element, String property, Object value) {
				ColumnMapper modelObject = (ColumnMapper) ((TableItem)element).getData();
				
				if( property.equals("Feature") ) {
					modelObject.setFeature((EStructuralFeature) value);
					
				}
				viewer.update(modelObject, null);
				updatePageComplete();
			}

			public Object getValue(Object element, String property) {
				if( property.equals("Number") ) {
					return ((ColumnMapper)element).getIndex();
				}else if( property.equals("ColumnName") ) {
					return ((ColumnMapper)element).getColumnName();
				}else if( property.equals("Feature") ) {
					return ((ColumnMapper)element).getFeature()==null?"":((ColumnMapper)element).getFeature();
				}
				return "";
			}

			public boolean canModify(Object element, String property) {
				return property.equals("Feature");
			}

		});
		viewer.setInput(fileColumnsToFeatureMap);
		return viewer;
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);
		flags.setFlags(fileColumnsToFeatureMap);
		try {
			if (!flags.validMapping()) {
				setMessage(null);
				setErrorMessage("You must select only one mapping for Event:dataTime and Event:tag."
						);
				return;
			}
		} catch (RuntimeException e) {
			setMessage(null);
			setErrorMessage(e.getMessage()
					);
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;
	}

	
	private void refreshColumnValues() throws IOException  {
		File sheet = ((ImportStandardEventDataWizard) getWizard())
				.getFileToImport();
		BufferedReader csvFile = null;
		try {
		    //open file
		    FileReader csvFileRead = new FileReader(sheet);
		    csvFile = new BufferedReader(csvFileRead);
		    String csvFileLine = "";
		    
		    //go through lines
		    while ((csvFileLine = csvFile.readLine()) != null) {
		        if(foundColumnValues( csvFileLine)){
		        	break;
		        }
		    }
		    
		} finally {
			
			csvFile.close();
		}

		tableViewer.refresh();
	}
	

	/**
	 * Given a line of data add a columnMapper object to the FeatureMap
	 * @param row
	 * @return
	 * @throws Exception 
	 */
	private boolean foundColumnValues(String csvFileLine) throws IOException {
		String[] details = csvFileLine.split(",");
	        
	    //if incorrect format, throw exception
	    if (details.length < 2) {
	            throw new IOException("ERROR: The CSV file is either corrupt "
	                    + "or is in an incompatible format. (line #"
	                    + 1 + ")");
	    }
	    
	    for (int i = 0; i < details.length; i++) {
			String s = details[i];
			if(s.trim().length()!=0){
				fileColumnsToFeatureMap.add(new ColumnMapper((short) i, s));
			}
		}

		return fileColumnsToFeatureMap.size()>1;
	}
	
	
	/**
	 * Need to have set a minimum of values to use this wizard.
	 * Animal ID, Species
	 * @author jconlon
	 *
	 */
	private static class Flags{
		int animalId;
		int datatime;

		void setFlags(List<ColumnMapper> spreadSheetColumnsToFeatureMap){
			animalId=0;
			datatime=0;
			
			for (ColumnMapper columnMapper : spreadSheetColumnsToFeatureMap) {
				if(columnMapper.getFeature()==TrackerPackage.Literals.EVENT__TAG){
					animalId++;
				}else if(columnMapper.getFeature()==TrackerPackage.Literals.EVENT__DATE_TIME){
					datatime++;
				}
			}
		}
		boolean validMapping(){
			return animalId==1 && datatime==1;
		}
		
		
	}
	
	class ColumnMapper  {
		
		private final short index;
		private final String columnName;
		private EStructuralFeature feature = null;

		public ColumnMapper(short index, String columnName) {
			super();
			this.index = index;
			this.columnName = columnName;
		}

		public String getColumnName() {
			return columnName;
		}

		public EStructuralFeature getFeature() {
			return feature;
		}

		public void setFeature(EStructuralFeature feature) {
			this.feature = feature;
		}

		public short getIndex() {
			return index;
		}
		
	}
	
}
	


