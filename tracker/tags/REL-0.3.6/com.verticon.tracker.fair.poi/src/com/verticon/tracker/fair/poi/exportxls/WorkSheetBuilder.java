package com.verticon.tracker.fair.poi.exportxls;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.fair.Fair;

public interface WorkSheetBuilder {

	public static final String DATE_STYLE = "dateSytle";
	
	public abstract void createWorkSheet(Fair fair, HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap);

}