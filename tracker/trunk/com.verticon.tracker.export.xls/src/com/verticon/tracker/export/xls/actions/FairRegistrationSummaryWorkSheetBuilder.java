/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.Animal;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.edit.provider.AnimalItemProvider;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

/**
 * @author jconlon
 * 
 */
public class FairRegistrationSummaryWorkSheetBuilder implements
		WorkSheetBuilder {

	 static final String TITLE = " Weigh-in 2007";
	 static final String COMMENTS = "Comments";
	 static final String EXHIBIT = "Exhibit";
	 static final String SALES_ORDER = "Sales Order";
	 static final String EAR_TAG = "Ear Tag";
	 static final String END_WEIGHT = "End Weight";
	 static final String BEGIN_WEIGHT = "Begin Weight";
	 static final String TYPE_OF_ANIMAL = "TypeOfAnimal";
	 static final String CLUB = "Club";
	 static final String PARENT = "Parent";
	 static final String PHONE = "Phone";
	 static final String STREET = "Street";
	 static final String CITY = "City";
	 static final String STATE = "State";
	 static final String ZIP = "Zip";
	 static final String NAME = "Name";
	 static final String WEIGHT_GAIN_PER_DAY = "WeightGainPerDay";
//	private List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
	private int rowCount = 0;
	public FairRegistrationSummaryWorkSheetBuilder() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.export.xls.actions.WorkSheetBuilder#createWorkSheet(com.verticon.tracker.Premises,
	 *      org.apache.poi.hssf.usermodel.HSSFWorkbook)
	 */
	
	public void createWorkSheet(Fair fair, HSSFSheet sheet,
			Map<String, HSSFCellStyle> styleMap) {
//		loadRegistrationList(premises);
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, fair);
	}

	private void createColumnHeader(HSSFSheet sheet) {
		HSSFRow row = createRow(sheet);
		row.createCell((short) 0).setCellValue(TITLE);
		row = createRow(sheet);
		// Name
		row.createCell((short) 0).setCellValue(NAME);
		sheet.setColumnWidth((short) 0, (short) ((50 * 5) / ((double) 1 / 20)));
		// Street
		row.createCell((short) 1).setCellValue(STREET);
		sheet.setColumnWidth((short) 1, (short) ((50 * 9) / ((double) 1 / 20)));
		// City
		row.createCell((short) 2).setCellValue(CITY);
		sheet.setColumnWidth((short) 2, (short) ((50 * 9) / ((double) 1 / 20)));
		// State
		row.createCell((short) 3).setCellValue(STATE);
		sheet.setColumnWidth((short) 3, (short) ((50 * 9) / ((double) 1 / 20)));
		// Zip
		row.createCell((short) 4).setCellValue(ZIP);
		sheet.setColumnWidth((short) 4, (short) ((50 * 9) / ((double) 1 / 20)));
		// Phone
		row.createCell((short) 5).setCellValue(PHONE);
		sheet.setColumnWidth((short) 5, (short) ((50 * 5) / ((double) 1 / 20)));
		// Parent
		row.createCell((short) 6).setCellValue(PARENT);
		sheet.setColumnWidth((short) 6, (short) ((50 * 5) / ((double) 1 / 20)));
		// Club
		row.createCell((short) 7).setCellValue(CLUB);
		sheet.setColumnWidth((short) 7, (short) ((50 * 6) / ((double) 1 / 20)));
		// Breed
		row.createCell((short) 8).setCellValue(TYPE_OF_ANIMAL);
		// BEGIN Weight
		row.createCell((short) 9).setCellValue(BEGIN_WEIGHT);
		sheet.setColumnWidth((short) 9, (short) ((50 * 5) / ((double) 1 / 20)));
		// Weight
		row.createCell((short) 10).setCellValue(END_WEIGHT);
		//WEIGHT_GAIN_PER_DAY
		row.createCell((short) 11).setCellValue(WEIGHT_GAIN_PER_DAY);
		// EarTag
		row.createCell((short) 12).setCellValue(EAR_TAG);
		sheet.setColumnWidth((short) 11, (short) ((50 * 4) / ((double) 1 / 20)));
		//Sales O
		row.createCell((short) 13).setCellValue(SALES_ORDER);
		sheet.setColumnWidth((short) 12, (short) ((50 * 3) / ((double) 1 / 20)));
		//Exhibit 
		row.createCell((short) 14).setCellValue(EXHIBIT);
		sheet.setColumnWidth((short) 13, (short) ((50 * 3) / ((double) 1 / 20)));
		//Comments
		row.createCell((short) 15).setCellValue(COMMENTS);
		sheet.setColumnWidth((short) 14, (short) ((50 * 9) / ((double) 1 / 20)));

		sheet.groupRow(0, 1);
	}

	/**
	 * @param sheet
	 * @return
	 */
	private HSSFRow createRow(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow((short) rowCount);
		rowCount++;
		return row;
	}

	/**
	 * Create a Row per each time an animal was weighed in
	 * 
	 * @param sheet
	 * @param premises
	 */
	private void createRows(HSSFSheet sheet, Fair fair) {
		HSSFRow row = null;
		for (Exhibit exhibit : fair.exhibits()) {
			row = createRow(sheet);
			fillRow(exhibit, row);
		}
	}


	/**
	 * Creates 8 cells in each row
	 * 10 cells
	 * 
	 * @param event
	 * @param cell
	 */
	private void fillRow(Exhibit exhibit, HSSFRow row) {
		HSSFCell cell = null;
		// Name
		cell = row.createCell((short) 0);
		cell.setCellValue(exhibit.getExhibitor().getName());
		// cell.setCellStyle(typicalStyle);
		// row.createCell((short)0).setCellValue(fairRegistration.getParticipant());
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
				getAnimalTypeName(exhibit.getAnimal()));
		// Begin Weight
		WeighIn beginWeighInForAnimal = exhibit.getAnimal().lastWeighIn().previousWeighIn();
		
		row.createCell((short) 9).setCellValue(beginWeighInForAnimal.getWeight());
		// END Weight
		row.createCell((short) 10).setCellValue(exhibit.getAnimal().getWeight());
		// Weight Gain
		row.createCell((short) 11).setCellValue(exhibit.getAnimal().getWeightGainPerDay());
		// EarTag
		row.createCell((short) 12).setCellValue(exhibit.getAnimal().getId());
		// Sales Order
		row.createCell((short) 13).setCellValue(exhibit.getSalesOrder());
		// Exhibit
		row.createCell((short) 14).setCellValue(exhibit.getNumber());
		// Comments
		row.createCell((short) 15).setCellValue(exhibit.getComments());
	}
	
	//
	static String getAnimalTypeName(Animal animal){
		return animal!=null?AnimalItemProvider.getResourceName(animal):null;
	}

	private void createHeader(HSSFSheet sheet) {
		HSSFHeader header = sheet.getHeader();
		header.setCenter("Center Header");
		header.setLeft("Left Header");
		header.setRight(HSSFHeader.font("Stencil-Normal", "Italic")
				+ HSSFHeader.fontSize((short) 16)
				+ "Right w/ Stencil-Normal Italic font and size 16");

	}

//	/**
//	 * Load only FairRegistration Events sorting on particpant.
//	 * 
//	 * @param premises
//	 */
//	private void loadRegistrationList(Premises premises) {
//		if(premises == null){
//			throw new IllegalArgumentException("Premises parameter cannot be null.");
//		}
//		EList<Event> events = premises.eventHistory();
//		for (Event event : events) {
//			if (FairRegistration.EVENT_CODE == event.getEventCode()) {
//				if(((FairRegistration) event).getParticipant()!=null){
//					registrationEvents.add((FairRegistration) event);
//				}
//			}
//		}
//		Collections.sort(registrationEvents,
//				new Comparator<FairRegistration>() {
//
//					public int compare(FairRegistration event1,
//							FairRegistration event2) {
//
//						
//						return event1.getParticipant().compareTo(
//								event2.getParticipant());
//					}
//				});
//	}

}
