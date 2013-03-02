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

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.trigger.view.TriggerViewPlugin.bundleMarker;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_TESTING_FILE_FORMAT;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.P_TESTING_PATH;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;
import com.verticon.tracker.trigger.view.views.CopiesToPrintDialog;
import com.verticon.tracker.trigger.view.views.TriggerViewer;

/**
 * @author jconlon
 * 
 */
public class CreateTriggerFileAction extends Action {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(CreateTriggerFileAction.class);

	private final TriggerViewer viewer;

	public CreateTriggerFileAction(TriggerViewer viewer, String text) {
		super(text);
		this.viewer = viewer;
	}

	@Override
	public void run() {
		super.run();
		ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();
		handle(entry);

	}

	private void handle(ITriggerEntry entry) {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();

		int count = 0;
		CopiesToPrintDialog dialog = new CopiesToPrintDialog(viewer
				.getControl().getShell());
		dialog.create();
		if (dialog.open() == Window.OK) {
			count = dialog.getNumberOfCopies();

		} else {
			return;
		}



		try {
			File destination = null;
			for (int i = 0; i < count; i++) {
				destination = createFile(entry, store);

			}

			if (count == 1) {
				MessageDialog.openInformation(viewer.getControl().getShell(),
						"Trigger File Creator",
						String.format("Created trigger file: %s", destination));
			} else {

			MessageDialog.openInformation(viewer.getControl().getShell(),
					"Trigger File Creator",
 String.format(
								"Created %s trigger files in %s", count,
								destination.getParent()));
			}
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to write test trigger.", e);
			MessageDialog.openError(viewer.getControl().getShell(),
					"Trigger File Tester", e.getLocalizedMessage());
		}
	}

	private File createFile(ITriggerEntry entry, IPreferenceStore store)
			throws IOException {
		File destination = getFile(store);
		logger.info(bundleMarker, "Outputing trigger file = {}", destination);

		Files.write(getValues(entry), destination, Charsets.US_ASCII);
		return destination;
	}

	private static String getValues(ITriggerEntry entry) {
		String format = entry.format();
		String result = String.format(
				format, System.currentTimeMillis(), //
				"",// weight units
				Double.NaN,// Double.NaN, //
				Double.NaN);
		// Find the first comma it should and prepend the noWeight message
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		// Replace all NaN with spaces
		result = result.replace("NaN", "   ");

		String print = store.getString(PreferenceConstants.P_PRINT_STRING);

		if (!isNullOrEmpty(print)) {
			result = result.replaceFirst(",", print + ',');
		}
		return result;

	}

	private static File getFile(IPreferenceStore store) throws IOException {
		String p = store.getString(P_TESTING_PATH);
		File parent = new File(p);
		if (!parent.isDirectory()) {
			throw new IOException(
					"Testing directory preference is empty. Configure it first. GoTo the Menu: Window | Preferences | Tracker | Trigger Manager.");
		}
		String child = store.getString(P_TESTING_FILE_FORMAT);
		if (child.contains("*")) {
			child = CharMatcher.anyOf("*").collapseFrom(child, '*');
			child = CharMatcher.is('*').replaceFrom(child,
					new Date().getTime() + "");
		}

		return new File(parent, child);
	}
}
