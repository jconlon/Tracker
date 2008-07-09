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
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Swine;
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
	
	private static final String TITLE = "Fair Registration Summary";
	 
	private enum Column { 
		FIRST_NAME("First Name"), 
		LAST_NAME("LastName"), 
		STREET("Street"), 
		CITY("City"), 
		STATE("State"),
		ZIP("Zip Code"),
		PHONE("Phone"),
		PARENT("Parent"),
		CLUB("Club"),
		PIN("Pin"),
		BREED("Breed"),
		TYPE_OF_ANIMAL("Type of Animal"),
		BEGIN_WEIGHT("Beginning Weight"),
		END_WEIGHT("Ending Weight"),
		WEIGHT_GAIN_PER_DAY("Weight Gain Per Day"),
		EAR_TAG("Ear Tag"),
		SCRAPIES("Scrapie Tag"),
		SWINEEARNOTCHL("Swine Left Ear Notching"),
		SWINEEARNOTCHR("Swine Right Ear Notching"),
		SALES_ORDER("Sales Order"),
		EXHIBIT("Exhibit"),
		COMMENTS("Comments");
		
		String colName;
		
		Column(String name) {
			this.colName = name;
		}
		
		short colNum(){
			return (short)ordinal();
		}
	
	}
	

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
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, fair);
	}
	
	

	private void createColumnHeader(HSSFSheet sheet) {
		HSSFRow row = createRow(sheet);
		row.createCell((short) 0).setCellValue(TITLE);
		row = createRow(sheet);
		
		for (Column column : Column.values()){
			row.createCell(column.colNum()).setCellValue(column.colName);
			sheet.setColumnWidth(column.colNum(), (short) ((50 * 5) / ((double) 1 / 20)));
		}

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
		if(exhibit.getExhibitor() !=null){
			// First Name
			cell = row.createCell(Column.FIRST_NAME.colNum());
			cell.setCellValue(exhibit.getExhibitor().getFirstName());
			// Last Name
			cell = row.createCell(Column.LAST_NAME.colNum());
			cell.setCellValue(exhibit.getExhibitor().getLastName());
			// Street
			row.createCell(Column.STREET.colNum()).setCellValue(exhibit.getExhibitor().getStreet());
			// City
			row.createCell(Column.CITY.colNum()).setCellValue(exhibit.getExhibitor().getCity());
			// State
			row.createCell(Column.STATE.colNum()).setCellValue(exhibit.getExhibitor().getState());
			// Zip
			row.createCell(Column.ZIP.colNum()).setCellValue(exhibit.getExhibitor().getZipCode());
			// Phone
			row.createCell(Column.PHONE.colNum()).setCellValue(exhibit.getExhibitor().getPhone());
			// Parent
			if(exhibit.getExhibitor() instanceof YoungPerson && !((YoungPerson) exhibit.getExhibitor()).getParents().isEmpty()){
				StringBuffer parents = new StringBuffer();
				for (Person parent : ((YoungPerson) exhibit.getExhibitor()).getParents()) {
					if(parents.length()>0){
						parents.append(" and ");
					}
					if(parent.getLastName().equals(exhibit.getExhibitor().getLastName())){
						parents.append(parent.getFirstName());
					}else{
						parents.append(parent.getFirstName()+' '+parent.getLastName());
					}
				}
				row.createCell(Column.PARENT.colNum()).setCellValue(parents.toString());
			}
			//Club
			if(exhibit.getExhibitor() instanceof YoungPerson && ((YoungPerson) exhibit.getExhibitor()).getClub()!=null){
				row.createCell(Column.CLUB.colNum()).setCellValue(((YoungPerson) exhibit.getExhibitor()).getClub().getName());
			}

			// PIN 
			row.createCell(Column.PIN.colNum()).setCellValue(
					exhibit.getExhibitor().getPin());
		}
		
		if(exhibit.getAnimal() !=null){
			// TypeOfAnimal 
			row.createCell(Column.TYPE_OF_ANIMAL.colNum()).setCellValue(
					getAnimalTypeName(exhibit.getAnimal()));

			// Breed 
			row.createCell(Column.BREED.colNum()).setCellValue(
					exhibit.getAnimal().getBreed());

			// Begin Weight
			if( exhibit.getAnimal().lastWeighIn() !=null){
				if(exhibit.getAnimal().lastWeighIn().previousWeighIn() != null){
					WeighIn beginWeighInForAnimal = exhibit.getAnimal().lastWeighIn().previousWeighIn();
					row.createCell(Column.BEGIN_WEIGHT.colNum()).setCellValue(beginWeighInForAnimal.getWeight());
				}else{
					row.createCell(Column.BEGIN_WEIGHT.colNum()).setCellValue(exhibit.getAnimal().getWeight());
				}
				
			}
			// END Weight
			if( exhibit.getAnimal().getWeight() !=null && exhibit.getAnimal().lastWeighIn().previousWeighIn() != null){
				row.createCell(Column.END_WEIGHT.colNum()).setCellValue(exhibit.getAnimal().getWeight());
			}
			// Weight Gain
			if( exhibit.getAnimal().getWeightGainPerDay() !=null){
				row.createCell(Column.WEIGHT_GAIN_PER_DAY.colNum()).setCellValue(exhibit.getAnimal().getWeightGainPerDay());
			}
			// EarTag
			row.createCell(Column.EAR_TAG.colNum()).setCellValue(exhibit.getAnimal().getId());
			//SCRAPIES
			if(exhibit.getAnimal().getSpeciesCode()=="OVI"){
				Ovine sheep = (Ovine)exhibit.getAnimal();
				row.createCell(Column.SCRAPIES.colNum()).setCellValue(sheep.getScrapieTag());
			}
			//SWINE EARNOTCHING
			if(exhibit.getAnimal().getSpeciesCode()=="POR"){
				Swine swine = (Swine)exhibit.getAnimal();
				row.createCell(Column.SWINEEARNOTCHL.colNum()).setCellValue(swine.getLeftEarNotching());
				row.createCell(Column.SWINEEARNOTCHR.colNum()).setCellValue(swine.getRightEarNotching());
			}
			
		}
		// Sales Order
		row.createCell(Column.SALES_ORDER.colNum()).setCellValue(exhibit.getSalesOrder());
		// Exhibit
		row.createCell(Column.EXHIBIT.colNum()).setCellValue(exhibit.getNumber());
		// Comments
		row.createCell(Column.COMMENTS.colNum()).setCellValue(exhibit.getComments());
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


}
