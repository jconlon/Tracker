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
package com.verticon.tracker.fair.poi.exportxls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.eclipse.emf.common.util.EList;

import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.fair.Fair;

/**
 * @author jconlon
 *
 */
public class MovedInWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	private static final String TITLE = "MovedIn Events";

	private enum Column { 
		EAR_TAG("Ear Tag"), 
		DATE("Date"),
		SOURCEPIN("Source Pin");
		
		String colName;
		
		Column(String name) {
			this.colName = name;
		}
		
		short colNum(){
			return (short)ordinal();
		}
	}
	
	private List<MovedIn> movedInEvents = new ArrayList<MovedIn>();
	
	
	public void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue(TITLE);
		row = createRow(sheet);
		for (Column column : Column.values()){
			row.createCell(column.colNum()).setCellValue(column.colName);
			sheet.setColumnWidth(column.colNum(), (short) ((50 * 5) / ((double) 1 / 20)));
		}

	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    private void fillRow(MovedIn movedIn, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell(Column.EAR_TAG.colNum()).setCellValue(movedIn.getTag().getId());
    	//Date
    	cell = row.createCell(Column.DATE.colNum());
		cell.setCellValue(movedIn.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
		//SourcePid
    	cell = row.createCell(Column.SOURCEPIN.colNum());
		cell.setCellValue(movedIn.getSourcePin());
		
	}
	
	
	/**
	 * Load only MovedInEvents
	 * @param fair
	 */
	@Override
	public void loadList(Fair fair){
		EList<Event> events = fair.getPremises().eventHistory();
		for (Event event : events) {
			if(MovedIn.EVENT_CODE ==event.getEventCode()){
				movedInEvents.add((MovedIn)event);
			}
		}
		Collections.sort(movedInEvents, new Comparator<MovedIn>(){

			public int compare(MovedIn event1, MovedIn event2) {
				return event1.getId().compareTo(event2.getId());
			}});
	}

	/**
	 * Create a Row per each time an animal was movedIn  
	 * @param sheet
	 * @param fair
	 */
	@Override
	public void createRows(HSSFSheet sheet, Fair fair) {
			for (MovedIn movedIn : movedInEvents) {
					 fillRow( movedIn,  createRow( sheet));
				 
			}
		
	}

	
}
