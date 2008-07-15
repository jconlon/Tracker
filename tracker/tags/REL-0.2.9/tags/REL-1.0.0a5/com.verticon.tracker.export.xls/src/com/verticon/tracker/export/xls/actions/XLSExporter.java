/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.PremisesProcessor;

/**
 * @author jconlon
 *
 */
public class XLSExporter implements PremisesProcessor{

	private String fileName = "FairRegistration.xls";
	private Map<String, HSSFCellStyle> styleMap = new HashMap<String, HSSFCellStyle>();
	
	private final WorkSheetBuilder[] builders;
	private final String[] workSheetNames;
	
	
	public XLSExporter(WorkSheetBuilder[] builders, String[] workSheetNames) {
		super();
		if(builders.length!=workSheetNames.length){
			throw new IllegalArgumentException("Must have same number of builders as names.");
		}
		this.builders = builders;
		this.workSheetNames = workSheetNames;
	}

	public void process(Premises premises, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
		HSSFWorkbook wb = new HSSFWorkbook();
		createStyles( wb);
		for (int i = 0; i < builders.length; i++) {
			builders[i].createWorkSheet(premises, wb.createSheet(workSheetNames[i]),styleMap);
		}
		
		
		createFile( wb);
		
	}
	
	private void createStyles(HSSFWorkbook wb){
		styleMap.put(WorkSheetBuilder.DATE_STYLE, createDateStyle( wb));
	}
	

	private HSSFCellStyle createDateStyle(HSSFWorkbook wb){
		HSSFCellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
	    cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
	    return cellStyle;
	}
	
	private HSSFCellStyle createTypicalStyle(HSSFWorkbook wb){
		HSSFCellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    return cellStyle;
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
	
}
