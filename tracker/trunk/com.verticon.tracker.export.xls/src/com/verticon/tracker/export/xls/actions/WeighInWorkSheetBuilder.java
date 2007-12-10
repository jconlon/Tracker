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
import com.verticon.tracker.Premises;
import com.verticon.tracker.WeighIn;

/**
 * @author jconlon
 *
 */
public class WeighInWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	List<WeighIn> weighInEvents = new ArrayList<WeighIn>();
	
	public void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue("Weigh-In Events");
		row = createRow(sheet);
		//EarTag
		row.createCell((short)0).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
//		Date 
		row.createCell((short)1).setCellValue("Date");
		sheet.setColumnWidth( (short) 1, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
        //Name
		row.createCell((short)2).setCellValue("Weight");
		sheet.setColumnWidth( (short) 2, (short) ( ( 50 * 3 ) / ( (double) 1 / 20 ) ) );
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    void fillRow(WeighIn weighIn, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell((short)0).setCellValue(weighIn.getTag().getId());
//		Date
    	cell = row.createCell((short)1);
		cell.setCellValue(weighIn.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
    	//Name
    	cell = row.createCell((short)2);
		cell.setCellValue(weighIn.getWeight());
		
	}
	
	
	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * @param premises
	 */
	@Override
	public void loadList(Premises premises ){
		EList<Event> events = premises.eventHistory();
		for (Event event : events) {
			if(WeighIn.EVENT_CODE ==event.getEventCode()){
				weighInEvents.add((WeighIn)event);
			}
		}
		Collections.sort(weighInEvents, new Comparator<WeighIn>(){

			public int compare(WeighIn event1, WeighIn event2) {
				return event1.getId().compareTo(event2.getId());
			}});
	}

	/**
	 * Create a Row per each time an animal was weighed in 
	 * @param sheet
	 * @param premises
	 */
	@Override
	public void createRows(HSSFSheet sheet, Premises premises) {
			for (WeighIn fairRegistration : weighInEvents) {
					 fillRow( fairRegistration,  createRow( sheet));
				 
			}
		
	}

	
}
