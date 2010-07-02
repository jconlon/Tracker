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
package com.verticon.tracker.fair.poi.presentation;
import static com.verticon.tracker.fair.poi.FairPoiPlugin.bundleMarker;

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.poi.importxls.ColumnMapper;


/**
 * Presents a list viewer and selection controls for mapping spreadsheet 
 * data in columns, based on the column names in the spreadsheet header row.
 * 
 * @author jconlon
 * 
 */
class ImportFairDataColumnMappingWizardPage extends WizardPage {

	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportFairDataColumnMappingWizardPage.class);
	
	private TableViewer tableViewer;
	
	private final List<ColumnMapper> spreadSheetColumnsToFeatureMap = 
		new LinkedList<ColumnMapper>();
	
	private int headerRow = -1;
	
//	private boolean usePersonNameForExhibitName = false;
//	
//	private boolean useEarTagForExhibitNum = false;
	
	/**
	 * Reference to a class that shows the state of the mappings.
	 */
	private static final Flags flags = new Flags();

	protected ImportFairDataColumnMappingWizardPage() {
		super("selectPerson");
		setTitle("Import Fair Data Column Mapper");
		setDescription("Map the Imported SpreadSheet's Column Names to Fair Model Element Feature Names.");
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
		
//		Composite c1 = new Composite (container, SWT.BORDER );
//		c1.setLayout (new RowLayout ());
//		data= new GridData(GridData.FILL_BOTH);
//		data.grabExcessHorizontalSpace = true;
//		data.horizontalSpan = 4;
//		c1.setLayoutData(data);
//		
//		Composite c2 = new Composite (container, SWT.BORDER );
//		c2.setLayout (new RowLayout ());
//		data= new GridData(GridData.FILL_BOTH);
//		data.grabExcessHorizontalSpace = true;
//		data.horizontalSpan = 4;
//		c2.setLayoutData(data);
		
//		final Composite [] composites = new Composite [] {c1, c2};
//		Listener radioGroup = new Listener () {
//		    public void handleEvent (Event event) {
//		      for (int i=0; i<composites.length; i++) {
//		        Composite composite = composites [i];
//		        Control [] children = composite.getChildren ();
//		        for (int j=0; j<children.length; j++) {
//		          Control child = children [j];
//		          if (child instanceof Button) {
//		            Button button = (Button) child;
//		            if ((button.getStyle () & SWT.RADIO) != 0) button.setSelection (false);
//		          }
//		        }
//		      }
//		      Button button = (Button) event.widget;
//		      button.setSelection (true);
//		    }
//		  };
//		

//		Label label = new Label(c1, SWT.NULL);
//		label.setText("How do you want to personName an Exhibit? ");
//		label.setBackground(container.getDisplay().getSystemColor(
//				SWT.COLOR_YELLOW));
//		
//
//		Button usePersonNameButton = new Button(c1, SWT.RADIO);
//		usePersonNameButton.setText("Use Person's personName");
//		usePersonNameButton.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				usePersonNameForExhibitName = true;
//			}
//
//		});
//		
//		Button dontUsePersonNameButton = new Button(c1, SWT.RADIO);
//		dontUsePersonNameButton.setText("Use above mapping or leave blank");
//		dontUsePersonNameButton.setSelection(true);
//		dontUsePersonNameButton.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				usePersonNameForExhibitName = false;
//			}
//
//		});
//		dontUsePersonNameButton.setSelection(true);
//		
//		
//		
//		
//		Label label2 = new Label(c2, SWT.NULL);
//		label2.setText("How do you want to number an Exhibit? ");
//		label2.setBackground(container.getDisplay().getSystemColor(
//				SWT.COLOR_YELLOW));

//		Button useEarTagButton = new Button(c2, SWT.RADIO);
//		useEarTagButton.setText("Use Animal's eartag number");
//		useEarTagButton.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				useEarTagForExhibitNum = true;
//			}
//
//		});
//		
//		Button dontUseEarTagButton = new Button(c2, SWT.RADIO);
//		dontUseEarTagButton.setText("Use above mapping or leave blank");
//		dontUseEarTagButton.setSelection(true);
//		dontUseEarTagButton.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				useEarTagForExhibitNum = false;
//			}
//
//		});
//		dontUseEarTagButton.setSelection(true);
		
		setControl(child);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			if(spreadSheetColumnsToFeatureMap.isEmpty()){
				refreshColumnNames();
			}
			setPageComplete(false);
		}
		super.setVisible(visible);
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
		tc2.setText("Column Name");
		tc2.pack();
		
		TableColumn tc3 = new TableColumn(table, SWT.NONE);
		tc3.setText("Fair Model Element Feature Name");
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
				if(feature==FairPackage.Literals.FAIR__NAME){
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
		ComboBoxViewerCellEditor cv = new ComboBoxViewerCellEditor(table);
		cv.setContenProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub

			}

			public void dispose() {
				// TODO Auto-generated method stub

			}

			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

		});
		cv.setLabelProvider(new LabelProvider() {
				
			@Override
			public String getText(Object element) {
				EStructuralFeature feature =(EStructuralFeature)element;
				if(feature==FairPackage.Literals.FAIR__NAME){
					return "";
				}
				return ((EClass)feature.eContainer()).getName()+':'+feature.getName();
				
			}
		
		});
		
		cv.setInput(((ImportFairExhibitDataWizard) getWizard()).getFeaturesToMap());
		
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
		viewer.setInput(spreadSheetColumnsToFeatureMap);
		return viewer;
	}

	List<ColumnMapper> getSpreadSheetColumnsToFeatureMap() {
		return spreadSheetColumnsToFeatureMap;
	}


	int getHeaderRow() {
		return headerRow;
	}

//	boolean isUsePersonNameForExhibitName() {
//		return usePersonNameForExhibitName;
//	}
//
//	boolean isUseEarTagForExhibitNum() {
//		return useEarTagForExhibitNum;
//	}
	
	 boolean mapContainsCompleteDeptClassLot(){
		flags.setFlags(spreadSheetColumnsToFeatureMap);
		return flags.mapContainsCompleteDeptClassLot();
	 }

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);
		flags.setFlags(spreadSheetColumnsToFeatureMap);
		try {
			if (!flags.mapContainsPersonMapping()) {
				setMessage(null);
				setErrorMessage("You must at a minimium select mapping for both Person:firstName and Person:lastName or just a Person:personName."
						);
				return;
			} else if (flags.mapContainsIncompleteDeptClassLot()){
				setMessage(null);
				setErrorMessage("You must either select mapping for Division:name, Deptartment:name, Class:name and Lot:name or mapping for none of them."
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

	private void refreshColumnNames() {
		HSSFSheet sheet = ((ImportFairExhibitDataWizard) getWizard())
				.getWorkSheet();
		HSSFRow row = null;
		for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum()+1; i++) {
			logger.debug(bundleMarker,"Processing row {}",i);
			 try {
				row = sheet.getRow(i);
				 if(row!=null){
					 if(foundColumnNames( row)){
						 headerRow=i;
						 break;
					 }
				 }
			} catch (RuntimeException e) {
				logger.error(bundleMarker,"Failed to process row "+i,e);
			}
		}
		tableViewer.refresh();
	}

	private boolean foundColumnNames( HSSFRow row) {
		for (short i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			logger.debug(bundleMarker,"Processing cell {}",i);
			HSSFCell cell = row.getCell(i);
			if(cell != null){
				String s = cell.getStringCellValue();
				if(s.trim().length()!=0){
					spreadSheetColumnsToFeatureMap.add(new ColumnMapper(i, s));
				}
			}
		}
		return spreadSheetColumnsToFeatureMap.size()>1;
	}
	
	private static class Flags{
		boolean lastName;
		boolean firstName;
		boolean personName;
		boolean lotName;
		boolean className;
		boolean deptName;
		boolean divName;

		void setFlags(List<ColumnMapper> spreadSheetColumnsToFeatureMap){
			lastName=false;
			firstName=false;
			personName = false;
			lotName = false;
			className = false;
			deptName = false;
			divName = false;
			
			for (ColumnMapper columnMapper : spreadSheetColumnsToFeatureMap) {
				if(columnMapper.getFeature()==FairPackage.Literals.PERSON__LAST_NAME){
					lastName=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.PERSON__FIRST_NAME){
					firstName=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.PERSON__NAME){
					personName=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.LOT__NAME){
					lotName=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.CLASS__NAME){
					className=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.DEPARTMENT__NAME){
					deptName=true;
				}else if(columnMapper.getFeature()==FairPackage.Literals.DIVISION__NAME){
					divName=true;
				}
			}
		}
		boolean mapContainsPersonMapping(){
			if((lastName || firstName) && personName){
				throw new IllegalStateException("You can't combine mappings of Person:lastName or Person:firstName with a Person:personName. Please reselect a different set of mappings.");
			}
			return (lastName && firstName) || personName;
		}
		
		/**
		 * 
		 * @return if any of the lot, class, or dept is set and they are not all set
		 */
		 boolean mapContainsIncompleteDeptClassLot(){
			return (lotName || className || deptName || divName) && (!mapContainsCompleteDeptClassLot());
		}
		
		 boolean mapContainsCompleteDeptClassLot(){
			return (lotName && className && deptName && divName);
		}
	}
}
	


