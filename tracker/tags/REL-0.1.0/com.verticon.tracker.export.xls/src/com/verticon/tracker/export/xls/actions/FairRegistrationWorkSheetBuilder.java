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
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.Premises;

/**
 * @author jconlon
 *
 */
public class FairRegistrationWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
	
	public void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue("Fair Registration Events");
		row = createRow(sheet);
		//EarTag
		row.createCell((short)0).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
//		Date 
		row.createCell((short)1).setCellValue("Date");
		sheet.setColumnWidth( (short) 1, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
        //Name
		row.createCell((short)2).setCellValue("Participant");
		sheet.setColumnWidth( (short) 2, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Address
		row.createCell((short)3).setCellValue("Address");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//Phone
		row.createCell((short)4).setCellValue("Phone");
		sheet.setColumnWidth( (short) 4, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Parent
		row.createCell((short)5).setCellValue("Parent");
		sheet.setColumnWidth( (short) 5, (short) ( ( 50 * 5) / ( (double) 1 / 20 ) ) );
		//Club
		row.createCell((short)6).setCellValue("Club");
		sheet.setColumnWidth( (short) 6, (short) ( ( 50 * 6) / ( (double) 1 / 20 ) ) );
		sheet.groupRow( 0, 1 );
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    void fillRow(FairRegistration fairRegistration, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell((short)0).setCellValue(fairRegistration.getTag().getIdNumber());
//		Date
    	cell = row.createCell((short)1);
		cell.setCellValue(fairRegistration.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
    	//Name
    	cell = row.createCell((short)2);
		cell.setCellValue(fairRegistration.getParticipant());
		//Address
		row.createCell((short)3).setCellValue(fairRegistration.getAddress());
		//Phone
		row.createCell((short)4).setCellValue(fairRegistration.getPhone());
		//Parent
		row.createCell((short)5).setCellValue(fairRegistration.getParent());
		//Club
		row.createCell((short)6).setCellValue(fairRegistration.getClub());
		
	}
	
	
	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * @param premises
	 */
	@Override
	public void loadList(Premises premises ){
		EList<Event> events = premises.eventHistory();
		for (Event event : events) {
			if(FairRegistration.EVENT_CODE ==event.getEventCode()){
				registrationEvents.add((FairRegistration)event);
			}
		}
		Collections.sort(registrationEvents, new Comparator<FairRegistration>(){

			public int compare(FairRegistration event1, FairRegistration event2) {
				return new Long(event1.getIdNumber()).compareTo(event2.getIdNumber());
			}});
	}

	/**
	 * Create a Row per each time an animal was weighed in 
	 * @param sheet
	 * @param premises
	 */
	@Override
	public void createRows(HSSFSheet sheet, Premises premises) {
			for (FairRegistration fairRegistration : registrationEvents) {
					 fillRow( fairRegistration,  createRow( sheet));
				 
			}
		
	}

	
}
