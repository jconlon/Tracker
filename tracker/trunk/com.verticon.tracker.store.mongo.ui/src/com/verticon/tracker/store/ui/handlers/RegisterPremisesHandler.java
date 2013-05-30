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
package com.verticon.tracker.store.ui.handlers;

import static com.verticon.tracker.store.ui.Activator.bundleMarker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerUpdate;
import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.ui.Activator;

/**
 * Uses the ITrackerStore to register premises information to MongoDB.
 * 
 * Only if the user has the registration role, will this handler be visible.
 * Authorized registration users can register any premises.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RegisterPremisesHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(RegisterPremisesHandler.class);

	/**
	 * At sign on time the user will choose one out of many UserAdmin services
	 * each identified with an URI.
	 * 
	 * For every UserAdmin service there is one TrackerStore service each given
	 * a common uri.
	 * 
	 * Finds the TrackerStore associated with the current UserAdmin.
	 * 
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Premises premises = (Premises) ((IStructuredSelection) selection)
					.getFirstElement();
			String uri = premises.getUri();

			ITrackerUpdate store = Activator.getDefault()
					.getTrackerStoreService();

			try {

				if (store == null) {
					throw new StoreAccessException(
							"Can't find the service to register a premises. Make sure a TrackerStore is configured and you are the administrator.");
				}

				Shell shell = HandlerUtil.getActiveShell(event);

				store.register(premises);

				MessageDialog.openConfirm(shell, "Confirm",
						"Registered premises " + uri + " on " + store.uri());
			} catch (Exception e) {
				MessageDialog.openError(
						HandlerUtil.getActiveShell(event),
						"Failed to register premises: " + uri + " on "
								+ store.uri(), e.getMessage());
				logger.error(bundleMarker, "Failed to register premises: "
						+ uri + " on " + store.uri(), e);
				throw new ExecutionException("Failed to register premises: "
						+ uri + " on " + store.uri(), e);
			}

		}
		return null;

	}
}
