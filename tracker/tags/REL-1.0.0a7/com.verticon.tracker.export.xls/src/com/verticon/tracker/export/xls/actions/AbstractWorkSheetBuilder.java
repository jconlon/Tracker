package com.verticon.tracker.export.xls.actions;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.Premises;

public abstract class AbstractWorkSheetBuilder {

	private int rowCount = 0;
	protected Map<String, HSSFCellStyle> styleMap;

	public AbstractWorkSheetBuilder() {
		super();
	}

	public void createWorkSheet(Premises premises, HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap) {
		loadList( premises );
		this.styleMap=styleMap;
		createColumnHeader(sheet);
		createRows(sheet, premises);
	}
	
	public abstract void loadList( Premises premises );
	
	public abstract void createColumnHeader(HSSFSheet sheet);
	
	public abstract void createRows(HSSFSheet sheet,  Premises premises );

	

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