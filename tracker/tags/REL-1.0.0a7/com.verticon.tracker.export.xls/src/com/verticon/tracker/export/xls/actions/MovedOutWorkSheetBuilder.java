/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

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
import com.verticon.tracker.Premises;

/**
 * @author jconlon
 *
 */
public class MovedOutWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	List<MovedOut> movedOutEvents = new ArrayList<MovedOut>();
	
	public void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue("MovedIn Events");
		row = createRow(sheet);
		//EarTag
		row.createCell((short)0).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
		//Date 
		row.createCell((short)1).setCellValue("Date");
		sheet.setColumnWidth( (short) 1, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
        //Source
		row.createCell((short)2).setCellValue("DestinationPin");
		sheet.setColumnWidth( (short) 2, (short) ( ( 50 * 3 ) / ( (double) 1 / 20 ) ) );
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    void fillRow(MovedOut movedOut, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell((short)0).setCellValue(movedOut.getAin().getIdNumber());
    	//Date
    	cell = row.createCell((short)1);
		cell.setCellValue(movedOut.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
//		SourcePid
    	cell = row.createCell((short)2);
		cell.setCellValue(movedOut.getDestinationPin());
		
	}
	
	
	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * @param premises
	 */
	@Override
	public void loadList(Premises premises ){
		EList<Event> events = premises.getEventHistory().getEvents();
		for (Event event : events) {
			if(MovedOut.EVENT_CODE ==event.getEventCode()){
				movedOutEvents.add((MovedOut)event);
			}
		}
		Collections.sort(movedOutEvents, new Comparator<MovedOut>(){

			public int compare(MovedOut event1, MovedOut event2) {
				
				
				return event1.getAin().getIdNumber().compareTo(event2.getAin().getIdNumber());
			}});
	}

	/**
	 * Create a Row per each time an animal was movedIn  
	 * @param sheet
	 * @param premises
	 */
	@Override
	public void createRows(HSSFSheet sheet, Premises premises) {
			for (MovedOut movedIn : movedOutEvents) {
					 fillRow( movedIn,  createRow( sheet));
				 
			}
		
	}

	
}
