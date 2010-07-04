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
/**
 * 
 */
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.Action;


/**
 * @author jconlon
 *
 */
class RemoveReaderAction extends Action {

	private ReaderViewer view;

	   protected RemoveReaderAction(ReaderViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   public void run() {
		   view.removeSelectedReaders();
	   }
	   
}
