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
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.fair.Fair;

/**
 * @author jconlon
 *
 */
public class MovedOutWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	private static final String TITLE = "MovedOut Events";

	private enum Column { 
		EAR_TAG("Ear Tag"), 
		DATE("Date"),
		DESTINATIONPIN("Destination Pin");
		
		String colName;
		
		Column(String name) {
			this.colName = name;
		}
		
		short colNum(){
			return (short)ordinal();
		}
	}
	
	private List<MovedOut> movedOutEvents = new ArrayList<MovedOut>();
	
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
    private void fillRow(MovedOut movedOut, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell(Column.EAR_TAG.colNum()).setCellValue(movedOut.getTag().getId());
    	//Date
    	cell = row.createCell(Column.DATE.colNum());
		cell.setCellValue(movedOut.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
		//DestinationPid
    	cell = row.createCell(Column.DESTINATIONPIN.colNum());
		cell.setCellValue(movedOut.getDestinationPin());
		
	}
	
	
	/**
	 * Load only MovedOut Events.
	 * @param fair
	 */
	@Override
	public void loadList(Fair fair ){
		EList<Event> events = fair.getPremises().eventHistory();
		for (Event event : events) {
			if(MovedOut.EVENT_CODE ==event.getEventCode()){
				movedOutEvents.add((MovedOut)event);
			}
		}
		Collections.sort(movedOutEvents, new Comparator<MovedOut>(){

			public int compare(MovedOut event1, MovedOut event2) {
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
			for (MovedOut movedIn : movedOutEvents) {
					 fillRow( movedIn,  createRow( sheet));
				 
			}
		
	}

	
}
