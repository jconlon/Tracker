/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.util.ArrayList;
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
import com.verticon.tracker.edit.provider.AnimalItemProvider;
import com.verticon.tracker.edit.provider.FairRegistrationItemProvider;

/**
 * @author jconlon
 * 
 */
public class FairRegistrationSummaryWorkSheetBuilder implements
		WorkSheetBuilder {

	private static final String TITLE = " Weigh-in 2007";
	private static final String COMMENTS = "Comments";
	private static final String EXHIBIT = "Exhibit";
	private static final String SALES_ORDER = "Sales Order";
	private static final String EAR_TAG = "Ear Tag";
	private static final String END_WEIGHT = "End Weight";
	private static final String BEGIN_WEIGHT = "Begin Weight";
	private static final String TYPE_OF_ANIMAL = "TypeOfAnimal";
	private static final String CLUB = "Club";
	private static final String PARENT = "Parent";
	private static final String PHONE = "Phone";
	private static final String ADDRESS = "Address";
	private static final String NAME = "Name";
	private List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
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
	public void createWorkSheet(Premises premises, HSSFSheet sheet,
			Map<String, HSSFCellStyle> styleMap) {
		loadRegistrationList(premises);
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, premises);
	}

	private void createColumnHeader(HSSFSheet sheet) {
		HSSFRow row = createRow(sheet);
		row.createCell((short) 0).setCellValue(TITLE);
		row = createRow(sheet);
		// Name
		row.createCell((short) 0).setCellValue(NAME);
		sheet.setColumnWidth((short) 0, (short) ((50 * 5) / ((double) 1 / 20)));
		// Address
		row.createCell((short) 1).setCellValue(ADDRESS);
		sheet.setColumnWidth((short) 1, (short) ((50 * 9) / ((double) 1 / 20)));
		// Phone
		row.createCell((short) 2).setCellValue(PHONE);
		sheet.setColumnWidth((short) 2, (short) ((50 * 5) / ((double) 1 / 20)));
		// Parent
		row.createCell((short) 3).setCellValue(PARENT);
		sheet.setColumnWidth((short) 3, (short) ((50 * 5) / ((double) 1 / 20)));
		// Club
		row.createCell((short) 4).setCellValue(CLUB);
		sheet.setColumnWidth((short) 4, (short) ((50 * 6) / ((double) 1 / 20)));
		// Breed
		row.createCell((short) 5).setCellValue(TYPE_OF_ANIMAL);
		// Date of Weigh In
		row.createCell((short) 6).setCellValue(BEGIN_WEIGHT);
		sheet.setColumnWidth((short) 6, (short) ((50 * 5) / ((double) 1 / 20)));
		// Weight
		row.createCell((short) 7).setCellValue(END_WEIGHT);
		// EarTag
		row.createCell((short) 8).setCellValue(EAR_TAG);
		sheet.setColumnWidth((short) 8, (short) ((50 * 4) / ((double) 1 / 20)));
		//Sales O
		row.createCell((short) 9).setCellValue(SALES_ORDER);
		sheet.setColumnWidth((short) 9, (short) ((50 * 3) / ((double) 1 / 20)));
		//Exhibit 
		row.createCell((short) 10).setCellValue(EXHIBIT);
		sheet.setColumnWidth((short) 10, (short) ((50 * 3) / ((double) 1 / 20)));
		//Comments
		row.createCell((short) 11).setCellValue(COMMENTS);
		sheet.setColumnWidth((short) 11, (short) ((50 * 9) / ((double) 1 / 20)));

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
	private void createRows(HSSFSheet sheet, Premises premises) {
		HSSFRow row = null;
		for (FairRegistration fairRegistration : registrationEvents) {
			row = createRow(sheet);
			fillRow(fairRegistration, row);
		}
	}


	/**
	 * Creates 8 cells in each row
	 * 10 cells
	 * 
	 * @param event
	 * @param cell
	 */
	private void fillRow(FairRegistration fairRegistration, HSSFRow row) {
		HSSFCell cell = null;
		// Name
		cell = row.createCell((short) 0);
		cell.setCellValue(fairRegistration.getParticipant());
		// cell.setCellStyle(typicalStyle);
		// row.createCell((short)0).setCellValue(fairRegistration.getParticipant());
		// Address
		row.createCell((short) 1).setCellValue(fairRegistration.getAddress());
		// Phone
		row.createCell((short) 2).setCellValue(fairRegistration.getPhone());
		// Parent
		row.createCell((short) 3).setCellValue(fairRegistration.getParent());
		// Club
		row.createCell((short) 4).setCellValue(fairRegistration.getClub());
		// Breed 
		row.createCell((short) 5).setCellValue(
				getAnimalTypeName(fairRegistration));
		// Begin Weight
		row.createCell((short) 6).setCellValue(FairRegistrationItemProvider.getBeginWeight(fairRegistration));
		// END Weight
		row.createCell((short) 7).setCellValue(FairRegistrationItemProvider.getEndWeight(fairRegistration));
		// EarTag
		row.createCell((short) 8).setCellValue(((Animal) fairRegistration.getTag().eContainer()).getIdNumber());
		// Sales Order
		row.createCell((short) 9).setCellValue(fairRegistration.getSaleOrder());
		// Exhibit
		row.createCell((short) 10).setCellValue(fairRegistration.getExhibit());
		// Comments
		row.createCell((short) 11).setCellValue(fairRegistration.getComments());
	}
	
	// FIXME 
	String getAnimalTypeName(FairRegistration fr){
		Object o = fr.getTag().eContainer();
//		getString("_UI_"+AnimalItemProvider.getResourceName(o)+"_type")
		return o!=null?AnimalItemProvider.getResourceName(o):null;
	}

	private void createHeader(HSSFSheet sheet) {
		HSSFHeader header = sheet.getHeader();
		header.setCenter("Center Header");
		header.setLeft("Left Header");
		header.setRight(HSSFHeader.font("Stencil-Normal", "Italic")
				+ HSSFHeader.fontSize((short) 16)
				+ "Right w/ Stencil-Normal Italic font and size 16");

	}

	/**
	 * Load only FairRegistration Events sorting on particpant.
	 * 
	 * @param premises
	 */
	private void loadRegistrationList(Premises premises) {
		if(premises == null){
			throw new IllegalArgumentException("Premises parameter cannot be null.");
		}
		EList<Event> events = premises.eventHistory();
		for (Event event : events) {
			if (FairRegistration.EVENT_CODE == event.getEventCode()) {
				if(((FairRegistration) event).getParticipant()!=null){
					registrationEvents.add((FairRegistration) event);
				}
			}
		}
		Collections.sort(registrationEvents,
				new Comparator<FairRegistration>() {

					public int compare(FairRegistration event1,
							FairRegistration event2) {

						
						return event1.getParticipant().compareTo(
								event2.getParticipant());
					}
				});
	}

}
