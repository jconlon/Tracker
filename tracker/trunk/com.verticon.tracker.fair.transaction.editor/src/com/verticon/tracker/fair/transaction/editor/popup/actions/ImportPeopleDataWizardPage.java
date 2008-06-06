package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.CellEditor;
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


/**
 * Presents a list viewer and a control for selecting the header row to create
 * column names.
 * 
 * @author jconlon
 * 
 */
public class ImportPeopleDataWizardPage extends WizardPage {

	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportPeopleDataWizardPage.class);
	
	private TableViewer tableViewer;
	private final List<ColumnMapper> spreadSheetColumnsToFeatureMap = 
		new LinkedList<ColumnMapper>();
	private int headerRow = -1;

	protected ImportPeopleDataWizardPage() {
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
		tableViewer.getControl().setLayoutData(data);;
		setControl(child);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			refreshColumnNames();
			setPageComplete(false);
		}
		super.setVisible(visible);
	}

	protected TableViewer createViewer(Composite parent) {
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
				
			public String getText(Object element) {
				EStructuralFeature feature =(EStructuralFeature)element;
				if(feature==FairPackage.Literals.FAIR__NAME){
					return "";
				}
				return ((EClass)feature.eContainer()).getName()+':'+feature.getName();
				
			}
		
		});
		
		cv.setInput(((ImportPeopleDataWizard) getWizard()).getFeaturesToMap());
		
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
	
	

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		
		if (!mapContainsPersonMapping()) {
			setMessage(null);
			setErrorMessage("You must at a minimium select mapping for a Person:firstName and Person:lastName"
					);
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;
	}
	
	private boolean mapContainsPersonMapping(){
		boolean lastName = false;
		boolean firstName = false;
		for (ColumnMapper columnMapper : spreadSheetColumnsToFeatureMap) {
			if(columnMapper.getFeature()==FairPackage.Literals.PERSON__LAST_NAME){
				lastName=true;;
			}else if(columnMapper.getFeature()==FairPackage.Literals.PERSON__FIRST_NAME){
				firstName=true;;
			}
		}
		return lastName && firstName;
	}

	private void refreshColumnNames() {
		HSSFSheet sheet = ((ImportPeopleDataWizard) getWizard())
				.getWorkSheet();
		HSSFRow row = null;
		for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
			logger.debug("processing row {}",i);
			 try {
				row = sheet.getRow(i);
				 if(row!=null){
					 if(refreshColumnNames( row)){
						 headerRow=i;
						 break;
					 }
					
				 }
			} catch (RuntimeException e) {
				logger.error("Failed to process row "+i,e);
			}
		}
		
		tableViewer.refresh();

	}

	private boolean refreshColumnNames( HSSFRow row) {
		for (short i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			logger.debug("processing cell {}",i);
			
			String s = row.getCell(i).getStringCellValue();
			spreadSheetColumnsToFeatureMap.add(new ColumnMapper(i, s));
		}
		return !spreadSheetColumnsToFeatureMap.isEmpty();
		
	}



	public List<ColumnMapper> getSpreadSheetColumnsToFeatureMap() {
		return spreadSheetColumnsToFeatureMap;
	}



	public int getHeaderRow() {
		return headerRow;
	}
	
	

}
