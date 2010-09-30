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
package com.verticon.tracker.fair.poi.importxls;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * Exception to indicate that the Import Data File lacked
 * critical information.
 * 
 * @author jconlon
 *
 */
public class MissingCriticalDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final EStructuralFeature feature;
	
	private final int rowID;
	
	private final short columnNumber;

	protected MissingCriticalDataException(String message, short columnNumber,
			EStructuralFeature feature, int rowID) {
		super(message);
		this.columnNumber = columnNumber;
		this.feature = feature;
		this.rowID = rowID;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Failed to import feature ").append(feature.getContainerClass().getSimpleName()).append(':').append(feature.getName()).append(", from data row ").
		append(rowID).append(", columnNumber ").append(columnNumber).append(" because: ").append(super.getMessage());
		return sb.toString();
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public int getRowID() {
		return rowID;
	}

	public int getColumnNumber() {
		return columnNumber;
	}
	
	

}
