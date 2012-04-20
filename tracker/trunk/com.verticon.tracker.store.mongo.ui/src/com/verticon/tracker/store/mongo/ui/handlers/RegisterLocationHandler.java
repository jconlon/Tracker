/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongo.ui.handlers;

import static com.verticon.tracker.store.mongo.ui.handlers.Utils.bundleMarker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.agriculture.Location;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.mongo.ui.Activator;

/**
 * Uses the ITrackerStore to register Location information to MongoDB.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RegisterLocationHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(RegisterLocationHandler.class);

	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Location location = (Location) ((IStructuredSelection) selection)
					.getFirstElement();
			String uri = location.getUri();
			try {
				ITrackerStore store = Activator.getDefault().getStore(uri);
				store.register(location);
				
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
						"Confirm", "Registered location " + uri
								+ " to MongoDB.");
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to register location: " + uri
								+ " to MongoDB.", e.getMessage());
				logger.error(bundleMarker, "Failed to register location: " + uri
						+ " to MongoDB.",e);
				throw new ExecutionException("Failed to register location: " + uri
						+ " to MongoDB.",e);
			}

		}
		return null;

	}
}
