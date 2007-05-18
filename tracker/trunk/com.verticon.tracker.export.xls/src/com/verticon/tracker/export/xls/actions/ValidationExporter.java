/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.Premises;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.editor.util.PremisesProcessor;

/**
 * @author jconlon
 * @deprecated
 */
public class ValidationExporter implements PremisesProcessor{

	private static final String WORKSHEET_NAME = "Fair Participants";
	private String fileName = "FairRegistration.xls";
	private List<FairRegistration> registrationEvents = new ArrayList<FairRegistration>();
	private int rowCount =0;
	private HSSFCellStyle dateStyle;
	private HSSFCellStyle typicalStyle;
	private List<Diagnostic> validationDiagnostics;
	
	public void process(Premises premises, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
		for (Diagnostic diagnostic : validationDiagnostics) {
			processDiagnostic(diagnostic);
			
		}
		
	}
	
	
	  public static boolean processDiagnostic(Diagnostic diagnostic)
	  {
	    if (diagnostic.getSeverity() == Diagnostic.ERROR || 
	      diagnostic.getSeverity() == Diagnostic.WARNING)
	    {
	      System.err.println(diagnostic.getMessage());
	      for (Iterator i=diagnostic.getChildren().iterator(); i.hasNext();)
	      {
	        Diagnostic childDiagnostic = (Diagnostic)i.next();
	        List<Object> data;
	        switch (childDiagnostic.getSeverity())
	        {
	          case Diagnostic.ERROR:
	          case Diagnostic.WARNING:
	            System.err.println("\t" + childDiagnostic.getMessage());
	            data= childDiagnostic.getData();
	            for (Object object : data) {
	            	System.err.println("\t object="+ object.toString());
				}
	            System.err.println("\t source="+childDiagnostic.getSource());
	            System.err.println("\t code="+childDiagnostic.getCode());
	            
	        }
	      }
	      return false;
	    }
	    return true;
	  }


	
//	public void process(Premises premises, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
//		loadRegistrationList( premises );
//		HSSFWorkbook wb = new HSSFWorkbook();
//	    HSSFSheet sheet = wb.createSheet(WORKSHEET_NAME);
//		createHeader(sheet);
//		createColumnHeader(sheet);
//		dateStyle = createDateStyle( wb);
//		typicalStyle = createTypicalStyle(wb);
//		createRows(sheet, premises);
//		adjustColumns(sheet);
//		createFile( wb);
//		
//	}
	private HSSFCellStyle createDateStyle(HSSFWorkbook wb){
		HSSFCellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
//	    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    return cellStyle;
	}
	
	private HSSFCellStyle createTypicalStyle(HSSFWorkbook wb){
		HSSFCellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    return cellStyle;
	}
	private void adjustColumns(HSSFSheet sheet){
//		sheet.autoSizeColumn((short)0); //adjust width of the first column
//	    sheet.autoSizeColumn((short)1); //adjust width of the second column
	}
	
	private void createColumnHeader(HSSFSheet sheet){
		HSSFRow row = sheet.createRow((short)rowCount);
		rowCount++;
		row.createCell((short)0).setCellValue(" Weigh-in 2007");
		row = sheet.createRow((short)rowCount);
		rowCount++;
//		Name
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
		sheet.setColumnWidth( (short) 6, (short) ( ( 50 * 7 ) / ( (double) 1 / 20 ) ) );
		//Weight
		row.createCell((short)7).setCellValue("Weight");
		//EarTag
		row.createCell((short)8).setCellValue("Ear Tag");
		sheet.setColumnWidth( (short) 8, (short) ( ( 50 * 4 ) / ( (double) 1 / 20 ) ) );
		
		sheet.groupRow( 0, 1 );
	}


	
	private void createFile(HSSFWorkbook wb) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(fileName);
		IOException ioe = null;
	    try {
			wb.write(fileOut);
		} catch (IOException e) {
			ioe=e;
		}finally{
			try {
				fileOut.close();
			} catch (IOException e) {
			}
		}
		if(ioe !=null){
			throw ioe;
		}
	    
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
			 weighInEvents = findWeighIns(fairRegistration.getAin(), premises);
			 for (WeighIn weighInEvent : weighInEvents) {
				 row = sheet.createRow((short)rowCount);
				 fillRow( fairRegistration,  row,  weighInEvent);
				 rowCount++;
			 }
		}
	}
	

	/**
	 * Find all the weighIns for the animal with ain
	 * @param ain
	 * @param premises
	 * @return
	 */
	private Collection<WeighIn> findWeighIns(AnimalId ain, Premises premises){
		ArrayList<WeighIn> weighInsForAin = new ArrayList<WeighIn>();
		EList events = premises.getEventHistory().getEvents();
		for (Object object : events) {
			Event event = (Event)object;
			if(WeighIn.EVENT_CODE ==event.getEventCode() && ((WeighIn)event).getAin().equals(ain)){
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
		row.createCell((short)5).setCellValue(((Animal)weighIn.getAin().eContainer()).getBreed());
		//Date of Weigh In
	    cell = row.createCell((short)6);
		cell.setCellValue(weighIn.getDateTime());
		cell.setCellStyle(dateStyle);
		dateStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		//Weight
		row.createCell((short)7).setCellValue(weighIn.getWeight());
		//EarTag
		row.createCell((short)8).setCellValue(weighIn.getAin().getIdNumber());
	}
    
    

	private void createHeader(HSSFSheet sheet){
		//ENHANCE implement
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
		EList events = premises.getEventHistory().getEvents();
		for (Object object : events) {
			Event event = (Event)object;
			if(FairRegistration.EVENT_CODE ==event.getEventCode()){
				registrationEvents.add((FairRegistration)event);
			}
		}
		Collections.sort(registrationEvents, new Comparator<FairRegistration>(){

			public int compare(FairRegistration event1, FairRegistration event2) {
				
				
				return event1.getParticipant().compareTo(event2.getParticipant());
			}});
	}
	
	

	public String getCompletionMessage() {
		return "Fair Participant XLS exported "+fileName;
	}

	public String getFailureTitle() {
		return "FairRegistration export failure";
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<Diagnostic> getValidationDiagnostics() {
		return validationDiagnostics;
	}
	public void setValidationDiagnostics(List<Diagnostic> validationDiagnostics) {
		this.validationDiagnostics = validationDiagnostics;
	}
	
}
