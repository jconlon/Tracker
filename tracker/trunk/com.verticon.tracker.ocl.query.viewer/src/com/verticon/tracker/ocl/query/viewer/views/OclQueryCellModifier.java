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
package com.verticon.tracker.ocl.query.viewer.views;

import static com.verticon.tracker.ocl.query.viewer.OclQueryViewerPlugin.uiState;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * ICellModifier for the QueryViewer ICellModifier is called when the user
 * modifies a cell in the QueryViewer
 */

class OclQueryCellModifier implements ICellModifier {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(OclQueryCellModifier.class);
	
	
	private final OclQueryViewer queryViewer;

	/**
	 * Constructor
	 * 
	 * @param queryViewer
	 */
	protected OclQueryCellModifier(OclQueryViewer queryViewer) {
		super();
		this.queryViewer = queryViewer;
	}

	/**
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public boolean canModify(Object element, String property) {
		
		return element !=null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = queryViewer.getColumnNames().indexOf(property);

		Object result = null;
		IOclQuery query = (IOclQuery) element;

		switch (columnIndex) {
		case 0: // Name
			result = query.getName();
			break;
		case 1: // Type
			String stringValue = query.getType();
			String[] choices = queryViewer.types();
			int i = choices.length - 1;
			while (!stringValue.equals(choices[i]) && i > 0)
				--i;
			result = new Integer(i);
			break;
		case 2: // Query
			result = query.getQuery();
			break;
		case 3: // Errors
			result = query.getErrorSyntax();
			break;
		default:
			result = "";
		}
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 *      java.lang.String, java.lang.Object)
	 */
	@Override
	public void modify(Object element, String property, Object value) {

		// Find the index of the column
		int columnIndex = queryViewer.getColumnNames().indexOf(property);

		TableItem item = (TableItem) element;
		if(item ==null){
			logger.error(uiState, "Failed to find an element for the OclViewer model.");
			return;
		}
		IOclQuery query = (IOclQuery) item.getData();
		String valueString;

		switch (columnIndex) {
		case 0: // Name
			valueString = ((String) value).trim();
			query.setName(valueString);
			break;
		case 1: // Type
			valueString = queryViewer.types()[((Integer) value).intValue()]
					.trim();
			if (!query.getType().equals(valueString)) {
				query.setType(valueString);
			}
			break;
		case 2: // Query
			valueString = ((String) value).trim();
			query.setQuery(valueString);
			break;
		case 3: // Errors
			valueString = ((String) value).trim();
			query.setErrorSyntax(valueString);
			break;
		default:
		}
		queryViewer.getViewModel().queryChanged(query);
	}
}
