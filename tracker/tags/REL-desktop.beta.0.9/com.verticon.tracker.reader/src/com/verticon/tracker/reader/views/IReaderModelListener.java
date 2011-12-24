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

import com.verticon.tracker.reader.IReader;



/**
 * Listener to changes on a model of IReaders
 * 
 * @see ReaderViewModel
 * @author jconlon
 *
 */
interface IReaderModelListener {
	
	/**
	 * Reflect the fact that a IReader was added 
	 * to the IReader Model
	 * 
	 * @param reader
	 */
	public void addReader(IReader reader);
	
	/**
	 * Update the view to reflect the fact that a IReader was removed 
	 * from the IReader Model
	 * 
	 * @param reader
	 */
	public void removeReader(IReader reader);
	
	/**
	 * Update the view to reflect the fact that one of the IReader
	 * was modified in the IReader Model
	 * 
	 * @param reader
	 */
	public void updateReader(IReader reader);
}
