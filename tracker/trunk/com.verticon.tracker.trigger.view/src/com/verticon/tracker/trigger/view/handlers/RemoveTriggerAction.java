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
public class RemoveTriggerAction extends Action {

	private final TriggerViewer view;

	public RemoveTriggerAction(TriggerViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   @Override
	public void run() {
		   view.removeSelectedQueries();
	   }
	   
}
