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
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.ui.Activator;

/**
 * Uses the ITrackerStore to register premises information to MongoDB.
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

	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Premises premises = (Premises) ((IStructuredSelection) selection)
					.getFirstElement();
			String uri = premises.getUri();
			LabelProvider lp = new LabelProvider(){

				/* (non-Javadoc)
				 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
				 */
				@Override
				public String getText(Object element) {
					ITrackerStore trackerStoreAdmin = (ITrackerStore)element;
					return trackerStoreAdmin.uri();
				}
				
			};
			ITrackerStore store =null;
			try {
				ITrackerStore[] stores = Activator.getDefault().getTrackerStoreServices(null);
				if(stores==null || stores.length==0){
					throw new StoreAccessException(
							"Can't find the service to register a premises. Make sure a TrackerStore is configured and you are the administrator.");
				}

				ElementListSelectionDialog dialog = 
						new ElementListSelectionDialog(HandlerUtil.getActiveShell(event), lp);
				dialog.setElements(stores);
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);
				dialog.setMessage("Choose the TrackerStore URI");
				dialog.setTitle("Register Premises");
				// User pressed cancel
				if (dialog.open() != Window.OK) {
					return false;
				}
				Object[] result = dialog.getResult(); 
			    store = (ITrackerStore) result[0];
				store.register(premises);
				
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
						"Confirm", "Registered premises " + uri
								+ " on "+store.uri());
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to register premises: " + uri
								+ " on "+store.uri(), e.getMessage());
				logger.error(bundleMarker, "Failed to register premises: " + uri
						+ " on "+store.uri(),e);
				throw new ExecutionException("Failed to register premises: " + uri
						+ " on "+store.uri(),e);
			}

		}
		return null;

	}
}
