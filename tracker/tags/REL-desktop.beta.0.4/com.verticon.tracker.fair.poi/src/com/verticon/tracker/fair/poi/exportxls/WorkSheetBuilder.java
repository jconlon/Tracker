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
package com.verticon.tracker.fair.poi.exportxls;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.verticon.tracker.fair.Fair;

public interface WorkSheetBuilder {

	public static final String DATE_STYLE = "dateSytle";
	
	public abstract void createWorkSheet(Fair fair, HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap);

}