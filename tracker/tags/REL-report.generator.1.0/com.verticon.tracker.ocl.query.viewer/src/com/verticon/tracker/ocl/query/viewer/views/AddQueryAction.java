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
class AddQueryAction extends Action {

	private OclQueryViewer viewer;

	   protected AddQueryAction(OclQueryViewer viewer, String text) {
	      super(text);
	      this.viewer = viewer;
	   }
	   
	   public void run() {
		   viewer.getViewModel().addQuery();
		}
}
