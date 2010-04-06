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
 * 
 * Creates a worksheet of Fair WeighIn events
 * 
 * @author jconlon
 *
 */
public class FairRegistrationWeighEventsInWorkSheetBuilder implements WorkSheetBuilder{
	private static final String TITLE = "Fair Weigh-in Events";
	private int rowCount =0;
	private Map<String, HSSFCellStyle> styleMap;
	
	 
	private	enum Column { 
			FIRST_NAME("First Name"), 
			LAST_NAME("LastName"), 
			STREET("Street"), 
			CITY("City"), 
			STATE("State"),
			ZIP("Zip Code"),
			PHONE("Phone"),
			PARENT("Parent"),
			CLUB("Club"),
			
			TYPE_OF_ANIMAL("Type of Animal"),
			BREED("Breed"),
			WEIGHINDATE("WeighIn Date"),
			WEIGHT("Weight"),
			EAR_TAG("Ear Tag");
			
			String colName;
			
			Column(String name) {
				this.colName = name;
			}
			
			short colNum(){
				return (short)ordinal();
			}
		
		}

	public FairRegistrationWeighEventsInWorkSheetBuilder( ) {
		super();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.xls.actions.WorkSheetBuilder#createWorkSheet(com.verticon.tracker.Premises, org.apache.poi.hssf.usermodel.HSSFWorkbook)
	 */
	public void createWorkSheet(Fair fair, HSSFSheet sheet,Map<String, HSSFCellStyle> styleMap) {
		this.styleMap=styleMap;
		createHeader(sheet);
		createColumnHeader(sheet);
		createRows(sheet, fair);
	}
	
	private void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = createRow(sheet);
		row.createCell((short)0).setCellValue(TITLE);
		row = createRow(sheet);
		
		for (Column column : Column.values()){
			row.createCell(column.colNum()).setCellValue(column.colName);
			sheet.setColumnWidth(column.colNum(), (short) ((50 * 5) / ((double) 1 / 20)));
		}

		
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
				 fillRow( exhibit,  row,  weighInEvent, styleMap);
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
    static void fillRow(Exhibit exhibit, HSSFRow row, WeighIn weighIn, Map<String, HSSFCellStyle> styleMap){
    	HSSFCell cell = null;
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
					parents.append("/");
				}
				parents.append(parent.getName());
			}
			row.createCell(Column.PARENT.colNum()).setCellValue(parents.toString());
		}
		//Club
		if(exhibit.getExhibitor() instanceof YoungPerson && ((YoungPerson) exhibit.getExhibitor()).getClub()!=null){
			row.createCell(Column.CLUB.colNum()).setCellValue(((YoungPerson) exhibit.getExhibitor()).getClub().getName());
		}
		
		// TypeOfAnimal 
		row.createCell(Column.TYPE_OF_ANIMAL.colNum()).setCellValue(
				FairRegistrationSummaryWorkSheetBuilder.getAnimalTypeName(exhibit.getAnimal()));
		
		// Breed 
		row.createCell(Column.BREED.colNum()).setCellValue(
			exhibit.getAnimal().getBreed());
		
		//Date of Weigh In
	    cell = row.createCell(Column.WEIGHINDATE.colNum());
		cell.setCellValue(weighIn.getDateTime());
		cell.setCellStyle(styleMap.get(DATE_STYLE));
		
		//Weight
		row.createCell(Column.WEIGHT.colNum()).setCellValue(weighIn.getWeight());
		
		//EarTag
		row.createCell(Column.EAR_TAG.colNum()).setCellValue(weighIn.getTag().getId());
	}
    
    

	private void createHeader(HSSFSheet sheet){
		HSSFHeader header = sheet.getHeader();
	    header.setCenter("Center Header");
	    header.setLeft("Left Header");
	    header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +
	                    HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16");

	}

	
}
