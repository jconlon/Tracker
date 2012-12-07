/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.fair.poi.exportxls;

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

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.util.FairProcessor;

/**
 * @author jconlon
 *
 */
public class XLSPremisesProcessor implements FairProcessor{

	private String fileName = "FairRegistration.xls";
	private Map<String, HSSFCellStyle> styleMap = new HashMap<String, HSSFCellStyle>();
	
	private final WorkSheetBuilder[] builders;
	private final String[] workSheetNames;
	
	
	public XLSPremisesProcessor(WorkSheetBuilder[] builders, String[] workSheetNames) {
		super();
		if(builders.length!=workSheetNames.length){
			throw new IllegalArgumentException("Must have same number of builders as names.");
		}
		this.builders = builders;
		this.workSheetNames = workSheetNames;
	}

	public void process(Fair fair, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
    	HSSFWorkbook wb = new HSSFWorkbook();
		createStyles( wb);
		for (int i = 0; i < builders.length; i++) {
			builders[i].createWorkSheet(fair, wb.createSheet(workSheetNames[i]),styleMap);
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
