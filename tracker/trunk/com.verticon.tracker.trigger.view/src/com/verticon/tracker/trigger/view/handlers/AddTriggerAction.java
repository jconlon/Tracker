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
package com.verticon.tracker.trigger.view.handlers;

import org.eclipse.jface.action.Action;

import com.verticon.tracker.trigger.view.views.TriggerViewer;


/**
 * @author jconlon
 *
 */
public class AddTriggerAction extends Action {

	private final TriggerViewer viewer;

	public AddTriggerAction(TriggerViewer viewer, String text) {
	      super(text);
	      this.viewer = viewer;
	   }
	   
	   @Override
	public void run() {
		   viewer.getViewModel().add();
	}
}
