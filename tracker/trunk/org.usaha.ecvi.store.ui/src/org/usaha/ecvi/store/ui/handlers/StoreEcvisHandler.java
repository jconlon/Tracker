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
package org.usaha.ecvi.store.ui.handlers;

import static org.usaha.ecvi.store.ui.Activator.bundleMarker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;
import org.usaha.ecvi.store.ui.Activator;

import com.google.common.collect.Iterables;

/**
 * Uses the IEcviStore to save eCVI documents.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class StoreEcvisHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(StoreEcvisHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			Ecvi ecvi = (Ecvi) ((IStructuredSelection) selection)
					.getFirstElement();

			String uri = chooseOneURL(event);
			if (uri == null) {
				return false;
			}

			IEcviStore store = Activator.getDefault().getEcviService(uri);
			try {
				store.record(ecvi, uri);

				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
						"EcviStore Results", "Recorded ecvi to EcviStore "
								+ uri);

			} catch (Exception e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Failed to Record ecvi to: " + uri,
						e.getLocalizedMessage());
				logger.error(bundleMarker, "Failed to Record ecvi to: " + uri,
						e);
				throw new ExecutionException("Failed to Record ecvi to:" + uri,
						e);
			}

		}
		return null;

	}

	private static String chooseOneURL(ExecutionEvent event) {
		Iterable<String> providers = Activator.getDefault()
				.getAllProviderURLs();
		// Prompt for one of these
		if (Iterables.isEmpty(providers)) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
					"No IEcviStore Services",
					"Failed to find any IEcviStore services.");
			return null;
		}
		if (Iterables.size(providers) == 1) {
			return Iterables.get(providers, 0);
		}

		Shell shell = HandlerUtil.getActiveShell(event);
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, new LabelProvider());
		dialog.setElements(Iterables.toArray(providers, String.class));
		dialog.setAllowDuplicates(false);
		dialog.setMultipleSelection(false);
		dialog.setMessage("Choose the URI of the IEcviStore implementation.");
		dialog.setTitle("Choose IEcviStore Implementation");
		// User pressed cancel
		if (dialog.open() != Window.OK) {
			return null;
		}
		Object[] result = dialog.getResult();
		String url = (String) result[0];
		return url;
	}
}
