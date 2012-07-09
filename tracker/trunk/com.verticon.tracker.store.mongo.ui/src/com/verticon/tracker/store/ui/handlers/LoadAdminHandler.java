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

import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;
import com.verticon.tracker.store.ui.Activator;

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
			
			LabelProvider lp = new LabelProvider(){

				/* (non-Javadoc)
				 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
				 */
				@Override
				public String getText(Object element) {
					ITrackerStoreAdmin trackerStoreAdmin = (ITrackerStoreAdmin)element;
					return trackerStoreAdmin.uri();
				}
				
			};
			ITrackerStoreAdmin store =null;
			try {
				ITrackerStoreAdmin[] stores = Activator.getDefault().getTrackerStoreAdminServices();
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
				dialog.setTitle("Load Admin Controls");
				// User pressed cancel
				if (dialog.open() != Window.OK) {
					return false;
				}
				Object[] result = dialog.getResult(); 
			    store = (ITrackerStoreAdmin) result[0];
				store.load(admin);
				
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
						"Admin Loader", "Loaded admin document on "+store.uri());
			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to load admin document to "+store.uri(), e.getMessage());
				logger.error(bundleMarker, "Failed to load admin document on "+store.uri(),e);
				throw new ExecutionException("Failed to load admin document on "+store.uri(),e);
			}

		}
		return null;

	}
}
