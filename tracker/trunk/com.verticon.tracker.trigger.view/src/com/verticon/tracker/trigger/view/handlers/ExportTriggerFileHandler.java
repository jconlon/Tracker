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
package com.verticon.tracker.trigger.view.handlers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.views.TriggerViewPart;

public class ExportTriggerFileHandler extends AbstractHandler {

	enum Creation {
		DELETE, APPEND, NA;
	};

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		TriggerViewPart viewPart = (TriggerViewPart) HandlerUtil
				.getActivePart(event);
		List<ITriggerEntry> entries = viewPart.getViewer().getViewModel()
				.getEntries();
		FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.SAVE);
		fd.setText("Export");
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		String filterPath = path.toOSString();
		fd.setFilterPath(filterPath);// location.getPath());
		String[] filterExt = { "*.csv", "*.txt", "*.*" };
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		if (selected == null) {
			return false;
		}
		try {
			Shell parent = HandlerUtil.getActiveShell(event);
			File to = new File(selected);
			if (to.exists()) {
				MessageDialog dg = new MessageDialog(parent, "File exists",
						null,
						"Overwrite it; Append to it; or Cancel to do nothing.",
						MessageDialog.QUESTION_WITH_CANCEL, new String[] {
								"Overwrite", "Append",
								IDialogConstants.CANCEL_LABEL }, 0);
				switch (dg.open()) {
				case 0:
					export(to, entries, Creation.DELETE);
					break;
				case 1:
					export(to, entries, Creation.APPEND);
					break;
				case 2:
					return 0;

				}
			} else {
				export(to, entries, Creation.NA);
			}

			MessageDialog.openConfirm(parent,
					"Confirm", "Exported trigger entries to " + selected);
		} catch (IOException e) {
			throw new ExecutionException("Failed to export trigger entries.", e);
		}

		return null;
	}

	private void export(File to, List<ITriggerEntry> entries, Creation create)
			throws IOException {

		if (Creation.DELETE.equals(create)) {
			to.delete();
		}

		for (ITriggerEntry iTriggerEntry : entries) {
			String from = String.format("%s%n", iTriggerEntry.export());
			Files.append(from, to, Charsets.US_ASCII);
		}

	}

}
