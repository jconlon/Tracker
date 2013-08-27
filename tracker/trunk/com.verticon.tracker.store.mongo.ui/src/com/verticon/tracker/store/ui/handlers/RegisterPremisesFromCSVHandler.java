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

import static com.verticon.tracker.store.TrackerStoreUtils.registerPremises;
import static com.verticon.tracker.store.ui.Activator.bundleMarker;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.store.ITrackerUpdate;

/**
 * Uses the ITrackerStore to register premises information from a csv file to
 * MongoDB. Column values used for mapping:
 * "Pin","Name","Phone","Email","Street"
 * ,"City","State","zipCode","latitude","longitude"
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RegisterPremisesFromCSVHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(RegisterPremisesFromCSVHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		File file = getSelectedResource(selection);

		ITrackerUpdate store = RegisterPremisesHandler
				.chooseOneTrackerStore(event);
		if (store == null) {
			return false;
		}
		try {
			int registrations = registerPremises(file, store);
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"Premises Registration from CSV", "Registered "
							+ registrations + " premises on TrackerStore "
							+ store.uri());
		} catch (Exception e) {
			String id = store != null ? store.uri() : "";
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
					"Failed to register premises on " + id,
					e.getMessage());
			logger.error(bundleMarker, "Failed to register premises on " + id,
					e);
			throw new ExecutionException(
					"Failed to register premises on " + id, e);
		}

		return null;

	}

	private static File getSelectedResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection)
					.getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}

}
