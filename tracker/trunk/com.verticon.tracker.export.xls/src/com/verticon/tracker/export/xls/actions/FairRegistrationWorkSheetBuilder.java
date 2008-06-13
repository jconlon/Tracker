/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

/**
 * @author jconlon
 *
 */
public class FairRegistrationWorkSheetBuilder extends AbstractWorkSheetBuilder implements WorkSheetBuilder {

	
	public void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue("Fair Registration Events");
		row = createRow(sheet);
		//EarTag
		row.createCell((short)0).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
        //Name
		row.createCell((short)1).setCellValue("Participant");
		sheet.setColumnWidth( (short) 2, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Street
		row.createCell((short)2).setCellValue("Street");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//City
		row.createCell((short)3).setCellValue("City");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//State
		row.createCell((short)4).setCellValue("State");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//Zip
		row.createCell((short)5).setCellValue("Zip");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//Phone
		row.createCell((short)6).setCellValue("Phone");
		sheet.setColumnWidth( (short) 4, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Parent
		row.createCell((short)7).setCellValue("Parent");
		sheet.setColumnWidth( (short) 5, (short) ( ( 50 * 5) / ( (double) 1 / 20 ) ) );
		//Club
		row.createCell((short)8).setCellValue("Club");
		sheet.setColumnWidth( (short) 6, (short) ( ( 50 * 6) / ( (double) 1 / 20 ) ) );
		sheet.groupRow( 0, 1 );
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    void fillRow( Exhibit exhibit, HSSFRow row){
    	HSSFCell cell = null;
    	//EarTag
		row.createCell((short)0).setCellValue(exhibit.getAnimal().getId());
    	//Name
    	cell = row.createCell((short)1);
		cell.setCellValue(exhibit.getExhibitor().getName());
		//Street
		row.createCell((short)2).setCellValue(exhibit.getExhibitor().getStreet());
		//City
		row.createCell((short)3).setCellValue(exhibit.getExhibitor().getCity());
		//State
		row.createCell((short)4).setCellValue(exhibit.getExhibitor().getState());
		//Zip
		row.createCell((short)5).setCellValue(exhibit.getExhibitor().getZipCode());
		//Phone
		row.createCell((short)6).setCellValue(exhibit.getExhibitor().getPhone());
		//Parent
		
		if(exhibit.getExhibitor() instanceof YoungPerson && !((YoungPerson) exhibit.getExhibitor()).getParents().isEmpty()){
			StringBuffer parents = new StringBuffer();
			for (Person parent : ((YoungPerson) exhibit.getExhibitor()).getParents()) {
				if(parents.length()>0){
					parents.append("/");
				}
				parents.append(parent.getName());
			}
			row.createCell((short)7).setCellValue(parents.toString());
		}
		//Club
		if(exhibit.getExhibitor() instanceof YoungPerson && ((YoungPerson) exhibit.getExhibitor()).getClub()!=null){
			row.createCell((short)8).setCellValue(((YoungPerson) exhibit.getExhibitor()).getClub().getName());
		}
	}
	
	
	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * @param premises
	 */
	@Override
	public void loadList(Fair fair ){
//		EList<Event> events = premises.eventHistory();
//		for (Event event : events) {
//			if(FairRegistration.EVENT_CODE ==event.getEventCode()){
//				registrationEvents.add((FairRegistration)event);
//			}
//		}
//		Collections.sort(registrationEvents, new Comparator<FairRegistration>(){
//
//			public int compare(FairRegistration event1, FairRegistration event2) {
//				return event1.getId().compareTo(event2.getId());
//			}});
	}

	/**
	 * Create a Row per each time an animal was weighed in 
	 * @param sheet
	 * @param premises
	 */
	@Override
	public void createRows(HSSFSheet sheet, Fair fair) {
			for (Exhibit exhibit : fair.exhibits()) {
					 fillRow( exhibit,  createRow( sheet));
				 
			}
	}
	
}
