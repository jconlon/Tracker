package com.verticon.tracker.export.xls.actions;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.Premises;

public interface WorkSheetBuilder {

	public static final String DATE_STYLE = "dateSytle";
	/**
	 * @param premises
	 * @param wb
	 */
	public abstract void createWorkSheet(Premises premises, HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap);

}