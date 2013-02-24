/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
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
package com.verticon.tracker.trigger.view;

import java.io.File;

import org.eclipse.core.runtime.IStatus;


/**
 * Wrapper that encapsulates an entry
 * 
 * @author jconlon
 * 
 */
public interface ITriggerEntry {

	IStatus validateEntry();

	/**
	 * 
	 * @return name of the entry
	 */
	String getName();

	/**
	 * 
	 * @param name
	 *            of the entry
	 */
	void setName(String name);

	/**
	 * Set the type of object to select with the entry.
	 * 
	 * @param type
	 */
	void setComments(String type);

	String getComments();

	/**
	 * If active shows the PID and the wiregroup
	 * 
	 * @param status
	 */
	void setStatus(String status);

	/**
	 * 
	 * @return status of the entry
	 */
	String getStatus();


	void setFile(File file);

	File getFile();

	void setValues(String values);

	String getValues();

	void setLot(String lot);

	String getLot();

	void setPrinter(String printer);

	String getPrinter();

	/**
	 * 
	 * @return format of the entry suitable for formating measurements
	 */
	String format();

	void setRequireValues(String requireValues);

	String getRequireValues();

	void setRequireLot(boolean requireLot);

	boolean isRequireLot();
	
	String export();

}
