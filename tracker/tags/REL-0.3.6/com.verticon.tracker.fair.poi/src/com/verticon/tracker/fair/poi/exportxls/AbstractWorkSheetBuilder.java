package com.verticon.tracker.fair.poi.exportxls;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.fair.Fair;

abstract class AbstractWorkSheetBuilder {

	private int rowCount = 0;
	protected Map<String, HSSFCellStyle> styleMap;

	public AbstractWorkSheetBuilder() {
		super();
	}

	@SuppressWarnings("ucd")
	public void createWorkSheet(Fair fair, HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap) {
		loadList( fair);
		this.styleMap=styleMap;
		createColumnHeader(sheet);
		createRows(sheet, fair);
	}
	
	public abstract void loadList( Fair fair );
	
	public abstract void createColumnHeader(HSSFSheet sheet);
	
	public abstract void createRows(HSSFSheet sheet,  Fair fair);

	

	/**
	 * @param sheet
	 * @return
	 */
	protected HSSFRow createRow(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow((short)rowCount);
		rowCount++;
		return row;
	}

}