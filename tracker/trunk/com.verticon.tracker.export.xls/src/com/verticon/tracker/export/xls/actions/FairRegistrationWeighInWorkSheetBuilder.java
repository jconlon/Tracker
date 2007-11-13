/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.eclipse.emf.common.util.EList;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.WeighIn;

/**
 * @author jconlon
 *
 */
public class FairRegistrationWeighInWorkSheetBuilder implements WorkSheetBuilder{

	private List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
	private int rowCount =0;
	private Map<String, HSSFCellStyle> styleMap;
	

	public FairRegistrationWeighInWorkSheetBuilder( ) {
		super();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.xls.actions.WorkSheetBuilder#createWorkSheet(com.verticon.tracker.Premises, org.apache.poi.hssf.usermodel.HSSFWorkbook)
	 */
	public void createWorkSheet(Premises premises, HSSFSheet sheet,Map<String, HSSFCellStyle> styleMap) {
		loadRegistrationList( premises );
		this.styleMap=styleMap;
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, premises);
	}
	
	private void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue(" Weigh-in 2007");
		row = createRow(sheet);
        //Name
		row.createCell((short)0).setCellValue("Name");
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Address
		row.createCell((short)1).setCellValue("Address");
		sheet.setColumnWidth( (short) 1, (short) ( ( 50 * 9 ) / ( (double) 1 / 20 ) ) );
		//Phone
		row.createCell((short)2).setCellValue("Phone");
		sheet.setColumnWidth( (short) 2, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Parent
		row.createCell((short)3).setCellValue("Parent");
		sheet.setColumnWidth( (short) 3, (short) ( ( 50 * 5) / ( (double) 1 / 20 ) ) );
		//Club
		row.createCell((short)4).setCellValue("Club");
		sheet.setColumnWidth( (short) 4, (short) ( ( 50 * 6) / ( (double) 1 / 20 ) ) );
		//Breed
		row.createCell((short)5).setCellValue("Breed");
		//Date of Weigh In
		row.createCell((short)6).setCellValue("Weigh In Date");
		sheet.setColumnWidth( (short) 6, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Weight
		row.createCell((short)7).setCellValue("Weight");
		//EarTag
		row.createCell((short)8).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 8, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
		
		sheet.groupRow( 0, 1 );
	}
	/**
	 * @param sheet
	 * @return
	 */
	private HSSFRow createRow(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow((short)rowCount);
		rowCount++;
		return row;
	}


	
	
	/**
	 * Create a Row per each time an animal was weighed in 
	 * @param sheet
	 * @param premises
	 */
	private void createRows(HSSFSheet sheet, Premises premises) {
		
		HSSFRow row = null;
		Collection<WeighIn> weighInEvents;
		for (FairRegistration fairRegistration : registrationEvents) {
			 weighInEvents = findWeighIns(fairRegistration.getTag(), premises);
			 for (WeighIn weighInEvent : weighInEvents) {
				 row = createRow(sheet);
				 fillRow( fairRegistration,  row,  weighInEvent);
			 }
		}
	}
	

	/**
	 * Find all the weighIns for the animal with ain
	 * @param ain
	 * @param premises
	 * @return
	 */
	private Collection<WeighIn> findWeighIns(Tag ain, Premises premises){
		ArrayList<WeighIn> weighInsForAin = new ArrayList<WeighIn>();
		EList<Event> events = premises.eventHistory();
		for (Event event : events) {
			if(WeighIn.EVENT_CODE ==event.getEventCode() && ((WeighIn)event).getTag().equals(ain)){
				weighInsForAin.add((WeighIn)event);
			}
		}
		
		return weighInsForAin;
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    private void fillRow(FairRegistration fairRegistration, HSSFRow row, WeighIn weighIn){
    	HSSFCell cell = null;
    	//Name
    	cell = row.createCell((short)0);
		cell.setCellValue(fairRegistration.getParticipant());
//		cell.setCellStyle(typicalStyle);
//		row.createCell((short)0).setCellValue(fairRegistration.getParticipant());
		//Address
		row.createCell((short)1).setCellValue(fairRegistration.getAddress());
		//Phone
		row.createCell((short)2).setCellValue(fairRegistration.getPhone());
		//Parent
		row.createCell((short)3).setCellValue(fairRegistration.getParent());
		//Club
		row.createCell((short)4).setCellValue(fairRegistration.getClub());
		//Breed
		row.createCell((short)5).setCellValue(((Animal)weighIn.getTag().eContainer()).getBreed());
		//Date of Weigh In
	    cell = row.createCell((short)6);
		cell.setCellValue(weighIn.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
		
		//Weight
		row.createCell((short)7).setCellValue(weighIn.getWeight());
		//EarTag
		row.createCell((short)8).setCellValue(weighIn.getTag().getIdNumber());
	}
    
    

	private void createHeader(HSSFSheet sheet){
		HSSFHeader header = sheet.getHeader();
	    header.setCenter("Center Header");
	    header.setLeft("Left Header");
	    header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +
	                    HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16");

	}
	
	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * @param premises
	 */
	private void loadRegistrationList(Premises premises ){
		EList<Event> events = premises.eventHistory();
		for (Event event : events) {
			if(FairRegistration.EVENT_CODE ==event.getEventCode()){
				registrationEvents.add((FairRegistration)event);
			}
		}
		Collections.sort(registrationEvents, new Comparator<FairRegistration>(){

			public int compare(FairRegistration event1, FairRegistration event2) {
				
				
				return event1.getParticipant().compareTo(event2.getParticipant());
			}});
	}
	
	
//
//	public String getCompletionMessage() {
//		return "Fair Participant XLS exported "+fileName;
//	}
//
//	public String getFailureTitle() {
//		return "FairRegistration export failure";
//	}
//
//
//	public String getFileName() {
//		return fileName;
//	}
//
//
//
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
	
}
