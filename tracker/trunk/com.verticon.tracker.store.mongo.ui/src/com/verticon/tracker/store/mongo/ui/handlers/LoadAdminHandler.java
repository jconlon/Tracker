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

import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;
import com.verticon.tracker.store.mongo.ui.Activator;

/**
 * Uses the ITrackerStore to load Admin documents that control publishing and
 * reading access into MongoDB.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class LoadAdminHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(LoadAdminHandler.class);

	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Admin admin = (Admin) ((IStructuredSelection) selection)
					.getFirstElement();
			
			try {
				ITrackerStoreAdmin store = Activator.getDefault().getLoader();
				store.load(admin);
				
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
						"Confirm", "Loaded admin document to MongoDB.");
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to load admin document to MongoDB.", e.getMessage());
				logger.error(bundleMarker, "Failed to load admin document to MongoDB.",e);
				throw new ExecutionException("Failed to load admin document to MongoDB.",e);
			}

		}
		return null;

	}
}
