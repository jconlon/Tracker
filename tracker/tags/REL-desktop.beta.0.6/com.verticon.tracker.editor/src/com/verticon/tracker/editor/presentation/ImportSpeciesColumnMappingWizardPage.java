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
import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
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

import com.verticon.tracker.TrackerPackage;

/**
 * Presents a list viewer and selection controls for mapping distinct values
 * from a designated column in a csv data file to animal species.
 * 
 * @author jconlon
 * 
 */
class ImportSpeciesColumnMappingWizardPage extends WizardPage {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportSpeciesColumnMappingWizardPage.class);

	private TableViewer tableViewer;
	private int csvFileLineNumber = 1;
	private final Map<String, EClass> speciesMap = new HashMap<String, EClass>();

	private static final List<EClass> SPECIES_LIST = new ArrayList<EClass>();
	static {
		SPECIES_LIST.add(TrackerPackage.Literals.BOVINE_BEEF);
		SPECIES_LIST.add(TrackerPackage.Literals.BOVINE_DAIRY);
		SPECIES_LIST.add(TrackerPackage.Literals.BOVINE_BISON);
		SPECIES_LIST.add(TrackerPackage.Literals.OVINE);
		SPECIES_LIST.add(TrackerPackage.Literals.CAPRINE);
		SPECIES_LIST.add(TrackerPackage.Literals.SWINE);
	}

	protected ImportSpeciesColumnMappingWizardPage() {
		super("selectColumns");
		setTitle("Import Species Name Mapper");
		setDescription("Map the Imported File's Species Names to Animal Species Feature Names.");
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
		setPageComplete(false);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			if (speciesMap.isEmpty()) {
				refreshSpeciesValues();
			}
			setPageComplete(false);
		}
		super.setVisible(visible);
	}

	private TableViewer createViewer(Composite parent) {
		Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tc2 = new TableColumn(table, SWT.NONE);
		tc2.setText("Imported Species Value from File");
		tc2.pack();

		TableColumn tc3 = new TableColumn(table, SWT.NONE);
		tc3.setText("Animal Species Name");
		tc3.pack();

		final TableViewer viewer = new TableViewer(table);
		viewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {

			}

			public void dispose() {

			}

			public Object[] getElements(Object inputElement) {
				return ((Map<?, ?>) inputElement).entrySet().toArray();
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

			@SuppressWarnings("unchecked")
			public String getColumnText(Object element, int aColumnIndex) {
				Map.Entry<String, EClass> colMapper = (Map.Entry<String, EClass>) element;

				if (aColumnIndex == 0) {
					// return Short.toString(colMapper.getIndex());
					// } else if( aColumnIndex == 1 ){
					return colMapper.getKey();
				}
				EClass feature = colMapper.getValue();
				if (feature == null) {
					return "";
				}
				return feature.getName();

			}

			public Image getColumnImage(Object element, int aColumnIndex) {
				return null;
			}

		});
		viewer.setColumnProperties(new String[] { "ColumnName", "Feature" });
		CellEditor[] cellEditors = new CellEditor[2];
		ComboBoxViewerCellEditor cv = new ComboBoxViewerCellEditor(table);
		cv.setContenProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
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
				EClass feature = (EClass) element;
				if (feature == null) {
					return "";
				}
				return feature.getName();

			}

		});

		cv.setInput(SPECIES_LIST);

		cellEditors[1] = cv;

		viewer.setCellEditors(cellEditors);

		viewer.setCellModifier(new ICellModifier() {

			@SuppressWarnings("unchecked")
			public void modify(Object element, String property, Object value) {
				Map.Entry<String, EClass> modelObject = (Map.Entry<String, EClass>) ((TableItem) element)
						.getData();

				if (property.equals("Feature")) {
					modelObject.setValue((EClass) value);

				}
				viewer.update(modelObject, null);
				updatePageComplete();
			}

			@SuppressWarnings("unchecked")
			public Object getValue(Object element, String property) {
				Entry<String, EClass> entry = (Map.Entry<String, EClass>) element;
				if (property.equals("ColumnName")) {
					return entry.getKey();
				} else if (property.equals("Feature")) {
					return entry.getValue();
				}
				return "";
			}

			public boolean canModify(Object element, String property) {
				return property.equals("Feature");
			}

		});
		viewer.setInput(speciesMap);
		return viewer;
	}

	Map<String, EClass> getSpeciesNamesMap() {
		return speciesMap;
	}

	boolean isValidMap() {

		for (EClass clazz : speciesMap.values()) {
			if (clazz == null) {
				return false;
			}
		}
		return true;
	}

	int getCsvFileLineNumber() {
		return csvFileLineNumber;
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);
		// flags.setFlags(speciesMap);
		try {
			if (!isValidMap()) {
				setMessage(null);
				setErrorMessage("All distinct values in the species column of the import file must be mapped to an Animal:species.");
				return;
			}
		} catch (RuntimeException e) {
			setMessage(null);
			setErrorMessage(e.getMessage());
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;
	}

	/**
	 * Read the file to get all the distinct values from the species column.
	 */
	private void refreshSpeciesValues() {
		File sheet = ((ImportAnimalLifeDataWizard) getWizard())
				.getFileToImport();
		int index = ((ImportAnimalLifeDataWizard) this.getWizard())
				.getSpeciesColumnIndex();

		try {
			// open file
			FileReader csvFileRead = new FileReader(sheet);
			BufferedReader csvFile = new BufferedReader(csvFileRead);
			String csvFileLine = "";

			// go through lines
			while ((csvFileLine = csvFile.readLine()) != null) {
				findSpeciesValue(csvFileLine, csvFileLineNumber, index);
				// increment line number
				csvFileLineNumber++;

			}
			// close file
			csvFile.close();
		} catch (IOException e) {
			logger.error(bundleMarker,"Failed to read file ", e);
		} catch (Exception e) {
			logger.error(bundleMarker,"Failed to read file ", e);
		}

		tableViewer.refresh();
	}

	/**
	 * Given a line of data add a columnMapper object to the FeatureMap
	 * 
	 * @param row
	 * @throws Exception
	 */
	private void findSpeciesValue(String csvFileLine, int lineNumber, int index)
			throws Exception {
		String[] details = csvFileLine.split(",");

		// if incorrect format, throw exception
		if (details.length < index) {
			throw new Exception("ERROR: The CSV file is either corrupt "
					+ "or is in an incompatible format. (line #" + lineNumber
					+ "is too short.)");
		}

		String s = details[index];

		if (s.trim().length() != 0 && !speciesMap.containsKey(s.trim())) {

			speciesMap.put(s.trim(), null);
		}

	}

}
