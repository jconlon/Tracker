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
import org.eclipse.jface.viewers.IStructuredSelection;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * @author jconlon
 *
 */
class ExecuteQueryAction extends Action {

	private OclQueryViewer viewer;

	protected ExecuteQueryAction(OclQueryViewer viewer, String text) {
		super(text);
		this.viewer = viewer;
	}

	@Override
	public void run() {
		super.run();
		IOclQuery query = (IOclQuery) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();
		query.run();
	}
	
	
}
