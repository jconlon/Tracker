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
package com.verticon.tracker.fair.poi.importxls;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.verticon.tracker.fair.Fair;

/**
 * @author jconlon
 *
 */
public class ExecutableProcreators {

	private ExecutableProcreators() {
		// Prevents instantiation
	}

	
	public static final ExecutableProcreator newDivisionProcreator(){
		return new DivisionProcreator(
				new DepartmentProcreator(
						new ClassProcreator(
								new LotProcreator(
										newExhibitProcreator()
								)
						)
				)
		);
	}
	
	
	public static final ExecutableProcreator newExhibitProcreator(){
		return 
		new ExhibitProcreator(
				new Splitter(
						new Procreator[] {
								new PersonProcreator(
										new Splitter(new Procreator[] {
														new ParentsProcreator(),
														new YouthClubProcreator()
														}
													)
										),
								new AnimalProcreator(new SuplementalAnimalTagsProcreator())
						}
				)


		);
	}
	
	private static class Splitter implements Procreator{

		private final Procreator[] children;
		
		
		protected Splitter(Procreator[] children) {
			super();
			this.children = children;
		}

		public void dispose() {
			for (Procreator child : children) {
				child.dispose();
			}
		}

		public String getStatus() {
			StringBuilder results = new StringBuilder();
			for (Procreator child : children) {
				results.append(child.getStatus());
			}
			return results.toString();
		}

		public void process(Fair fair, HSSFRow row,
				List<ColumnMapper> listColumnMapper, EObject parent,
				boolean newParent, EditingDomain editingDomain,
				CompoundCommand command) throws MissingCriticalDataException {
			for (Procreator child : children) {
				child.process( fair,  row,
						listColumnMapper,  parent,
						 newParent,  editingDomain,
						 command);
			}
			
		}
		
	}
	
	protected static String getCriticalValue(HSSFRow row, EStructuralFeature feature, List<ColumnMapper> listColumnMapper) throws MissingCriticalDataException{
		String result = getValue(row, feature, listColumnMapper);
		if(result == null || result.trim().length()<1){
			short index = findColumnNumber(feature, listColumnMapper);
			throw new MissingCriticalDataException("The data value in a critical spreadsheet cell is empty. Please remove all blank rows and fill in values for all critical cells.",
					index,feature, row.getRowNum());
		}
		return result;
	}
	static String getValue(HSSFRow row, EStructuralFeature feature, List<ColumnMapper> listColumnMapper) {
		String result = null;
		    short index = findColumnNumber(feature, listColumnMapper);
		    if (index !=-1) {
				try {
					HSSFCell cellContents = row.getCell(index);
					if (cellContents != null) {
						switch (cellContents.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							result = cellContents.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							double num = cellContents.getNumericCellValue();
							long l = (long)num;
							result = Long.toString(l);
							break;
						default:
							break;
						}

					}
				} catch (RuntimeException e) {
					//just fall through and return a null
				}
			}
		return result;
	}
	
    static short findColumnNumber(EStructuralFeature feature, List<ColumnMapper> columnMap){
		for (ColumnMapper columnMapper : columnMap) {
			if(columnMapper.getFeature()==feature){
				return columnMapper.getIndex();
			}
		}
		return -1;
	}
    
   
}
