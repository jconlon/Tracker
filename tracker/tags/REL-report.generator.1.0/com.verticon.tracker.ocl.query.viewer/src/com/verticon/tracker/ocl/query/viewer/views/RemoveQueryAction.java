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
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.Action;


/**
 * @author jconlon
 *
 */
class RemoveQueryAction extends Action {

	private OclQueryViewer view;

	   protected RemoveQueryAction(OclQueryViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   public void run() {
		   view.removeSelectedQueries();
	   }
	   
}
