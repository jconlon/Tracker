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
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerUpdate;
import com.verticon.tracker.store.IUpdateStats;

/**
 * Uses the ITrackerStore to save Animal information to MongoDB.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RecordAnimalsHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(RecordAnimalsHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Premises premises = (Premises) ((IStructuredSelection) selection)
					.getFirstElement();
			String uri = premises.getUri();

			ITrackerUpdate store = RegisterPremisesHandler
					.chooseOneTrackerStore(event);
			if (store == null) {
				return false;
			}
			try {
				IUpdateStats processedAnimals = store.recordAnimals(premises);
				if(!processedAnimals.getExceptions().isEmpty()) {
					MessageDialog.openError(HandlerUtil.getActiveShell(event),
							"Animal LifeData and EventHistory Loader Results",
							processedAnimals.prettyPrint()
									+ " From premises: " + uri
									+ " to TrackerStore " + store.uri()
									+ " With errors: "
									+ processedAnimals.serializeExceptions());
				}else {
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
							"Animal LifeData and EventHistory Loader Results",
							processedAnimals.prettyPrint()
								+ " From premises: " + uri
								+ " to TrackerStore " + store.uri());
				}
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to Record animals from premises: " + uri
								+ " to TrackerStore " + store.uri(),
						e.getLocalizedMessage());
				logger.error(bundleMarker,
						"Failed to Record animals from premises: " + uri
								+ " to TrackerStore " + store.uri(), e);
				throw new ExecutionException(
						"Failed to Record animals from premises: " + uri
								+ " to TrackerStore " + store.uri(), e);
			}

		}
		return null;

	}
}
