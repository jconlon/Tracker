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


package com.verticon.tracker.reader.views;
import java.net.URI;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import com.verticon.tracker.reader.IReader;


/**
 * ICellModifier for the ReaderViewer
 * ICellModifier is called when the user modifes a cell in the 
 * ReaderViewer
 */

class ReaderCellModifier implements ICellModifier {
	private ReaderViewer readerViewer;
	/**
	 * Constructor 
	 * @param readerViewer
	 */
	protected ReaderCellModifier(ReaderViewer readerViewer) {
		super();
		this.readerViewer = readerViewer;
	}

	/**
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	/**
	 * Note: Only the first 2 columns are used.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = readerViewer.getColumnNames().indexOf(property);

		Object result = null;
		IReader task = (IReader) element;

		switch (columnIndex) {
			case 0 : // Started 
				result = new Boolean(task.isStarted());
				break;
			case 1 : // Name 
				result = task.getName();
				break;
			case 2 : // Type 
				result = task.getType();		
				break;
			case 3 : // Template 
				result = task.getTemplate();
				break;
			case 4 : // Target 
				result = task.getTarget();
				break;
			default :
				result = "";
		}
		return result;	
	}

	/**
	 * Note: Only the first 2 columns are used.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {	

		// Find the index of the column 
		int columnIndex	= readerViewer.getColumnNames().indexOf(property);
			
		TableItem item = (TableItem) element;
		IReader reader = (IReader) item.getData();
		String valueString;

		switch (columnIndex) {
			case 0 : // Started 
			    reader.setStarted(((Boolean) value).booleanValue());
				break;
			case 1 : // Name 
				valueString = ((String) value).trim();
				reader.setName(valueString);
				break;
			case 2 : // Type 
				valueString = ((String) value).trim();
				break;
			case 3 : // Template
				valueString = ((String) value).trim();
				reader.setTemplate(valueString);
				break;
			case 4 : // Target
				valueString = ((String) value).trim();
				reader.setTarget(URI.create(valueString));
				break;
			default :
			}
//		readerViewer.getReaderViewModel().readererChanged(reader);
	}
}
