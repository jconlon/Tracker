/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.Animal;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

/**
 * @author jconlon
 *
 */
public class FairRegistrationWeighInWorkSheetBuilder implements WorkSheetBuilder{

//	private List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
	private int rowCount =0;
	private Map<String, HSSFCellStyle> styleMap;
	
	

	public FairRegistrationWeighInWorkSheetBuilder( ) {
		super();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.xls.actions.WorkSheetBuilder#createWorkSheet(com.verticon.tracker.Premises, org.apache.poi.hssf.usermodel.HSSFWorkbook)
	 */
	public void createWorkSheet(Fair fair, HSSFSheet sheet,Map<String, HSSFCellStyle> styleMap) {
//		loadRegistrationList( premises );
		this.styleMap=styleMap;
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, fair);
	}
	
	private void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue(" Weigh-in 2007");
		row = createRow(sheet);
        //Name
		row.createCell((short)0).setCellValue(FairRegistrationSummaryWorkSheetBuilder.NAME);
		sheet.setColumnWidth( (short) 0, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		// Street
		row.createCell((short) 1).setCellValue(FairRegistrationSummaryWorkSheetBuilder.STREET);
		sheet.setColumnWidth((short) 1, (short) ((50 * 9) / ((double) 1 / 20)));
		// City
		row.createCell((short) 2).setCellValue(FairRegistrationSummaryWorkSheetBuilder.CITY);
		sheet.setColumnWidth((short) 2, (short) ((50 * 9) / ((double) 1 / 20)));
		// State
		row.createCell((short) 3).setCellValue(FairRegistrationSummaryWorkSheetBuilder.STATE);
		sheet.setColumnWidth((short) 3, (short) ((50 * 9) / ((double) 1 / 20)));
		// Zip
		row.createCell((short) 4).setCellValue(FairRegistrationSummaryWorkSheetBuilder.ZIP);
		sheet.setColumnWidth((short) 4, (short) ((50 * 9) / ((double) 1 / 20)));
		//Phone
		row.createCell((short)5).setCellValue(FairRegistrationSummaryWorkSheetBuilder.PHONE);
		sheet.setColumnWidth( (short) 5, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Parent
		row.createCell((short)6).setCellValue("Parent");
		sheet.setColumnWidth( (short) 6, (short) ( ( 50 * 5) / ( (double) 1 / 20 ) ) );
		//Club
		row.createCell((short)7).setCellValue("Club");
		sheet.setColumnWidth( (short) 7, (short) ( ( 50 * 6) / ( (double) 1 / 20 ) ) );
		//Breed
		row.createCell((short)8).setCellValue("Breed");
		//Date of Weigh In
		row.createCell((short)9).setCellValue("Weigh In Date");
		sheet.setColumnWidth( (short) 9, (short) ( ( 50 * 5 ) / ( (double) 1 / 20 ) ) );
		//Weight
		row.createCell((short)10).setCellValue("Weight");
		//EarTag
		row.createCell((short)11).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 11, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
		
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
	private void createRows(HSSFSheet sheet, Fair fair) {
		
		HSSFRow row = null;
		Collection<WeighIn> weighInEvents;
		for (com.verticon.tracker.fair.Exhibit exhibit : fair.exhibits()) {
			 weighInEvents = findWeighIns(exhibit.getAnimal());
			 for (WeighIn weighInEvent : weighInEvents) {
				 row = createRow(sheet);
				 fillRow( exhibit,  row,  weighInEvent);
			 }
			
			
		}
		 
		 
		 
	}
	

	/**
	 * Find all the weighIns for the animal with ain
	 * @param ain
	 * @param premises
	 * @return
	 */
	private Collection<WeighIn> findWeighIns(Animal animal){
		ArrayList<WeighIn> weighIns = new ArrayList<WeighIn>();
		WeighIn lastWeighIn = animal.lastWeighIn();
		weighIns.add(lastWeighIn.previousWeighIn());
		weighIns.add(lastWeighIn);
		return weighIns;
	}
	
	/**
	 * Creates 8 cells in each row
	 * @param event
	 * @param cell
	 */
    private void fillRow(Exhibit exhibit, HSSFRow row, WeighIn weighIn){
    	HSSFCell cell = null;
    	//Name
    	cell = row.createCell((short)0);
		cell.setCellValue(exhibit.getExhibitor().getName());
//		cell.setCellStyle(typicalStyle);
//		row.createCell((short)0).setCellValue(fairRegistration.getParticipant());
		// Street
		row.createCell((short) 1).setCellValue(exhibit.getExhibitor().getStreet());
		// City
		row.createCell((short) 2).setCellValue(exhibit.getExhibitor().getCity());
		// State
		row.createCell((short) 3).setCellValue(exhibit.getExhibitor().getState());
		// Zip
		row.createCell((short) 4).setCellValue(exhibit.getExhibitor().getZipCode());
		// Phone
		row.createCell((short) 5).setCellValue(exhibit.getExhibitor().getPhone());
		// Parent
		if(exhibit.getExhibitor() instanceof YoungPerson && !((YoungPerson) exhibit.getExhibitor()).getParents().isEmpty()){
			StringBuffer parents = new StringBuffer();
			for (Person parent : ((YoungPerson) exhibit.getExhibitor()).getParents()) {
				if(parents.length()>0){
					parents.append("/");
				}
				parents.append(parent.getName());
			}
			row.createCell((short)6).setCellValue(parents.toString());
		}
		//Club
		if(exhibit.getExhibitor() instanceof YoungPerson && ((YoungPerson) exhibit.getExhibitor()).getClub()!=null){
			row.createCell((short)7).setCellValue(((YoungPerson) exhibit.getExhibitor()).getClub().getName());
		}
		
		// Breed 
		row.createCell((short) 8).setCellValue(
				FairRegistrationSummaryWorkSheetBuilder.getAnimalTypeName(exhibit.getAnimal()));
		
		//Date of Weigh In
	    cell = row.createCell((short)9);
		cell.setCellValue(weighIn.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
		
		//Weight
		row.createCell((short)10).setCellValue(weighIn.getWeight());
		//EarTag
		row.createCell((short)11).setCellValue(weighIn.getTag().getId());
	}
    
    

	private void createHeader(HSSFSheet sheet){
		HSSFHeader header = sheet.getHeader();
	    header.setCenter("Center Header");
	    header.setLeft("Left Header");
	    header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +
	                    HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16");

	}
	
//	/**
//	 * Load only FairRegistration Events sorting on particpant.
//	 * @param premises
//	 */
//	private void loadRegistrationList(Premises premises ){
//		EList<Event> events = premises.eventHistory();
//		for (Event event : events) {
//			if(FairRegistration.EVENT_CODE ==event.getEventCode()){
//				registrationEvents.add((FairRegistration)event);
//			}
//		}
//		Collections.sort(registrationEvents, new Comparator<FairRegistration>(){
//
//			public int compare(FairRegistration event1, FairRegistration event2) {
//				
//				
//				return event1.getParticipant().compareTo(event2.getParticipant());
//			}});
//	}
	
	
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
