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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Collections2.transform;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.TriggerEntryFactory;
import com.verticon.tracker.trigger.view.views.TriggerModel;
import com.verticon.tracker.trigger.view.views.TriggerViewPart;

/**
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportTriggerFileHandler extends AbstractHandler {



	public ImportTriggerFileHandler() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.OPEN);
		fd.setText("Open");

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
			importConfiguration(selected,event);
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"Confirm", "Imported " + selected + " trigger entries");
		} catch (Exception e) {
			MessageDialog.openError(
					HandlerUtil.getActiveShell(event),
					"Error",
					"Failed to imported " + selected
							+ " trigger entries because: "
							+ e.getLocalizedMessage());
			return 0;
		}

		return null;
	}

	private void importConfiguration(String f, ExecutionEvent event) throws IOException {
		final File file = new File(f);
		final List<String> lines = Files.readLines(file,
					Charset.defaultCharset());
		Collection<ITriggerEntry> entries = transform(lines, new FullNameFunction());
		add(event, true, entries);
	}

	private void add(ExecutionEvent event, boolean withMessage,
			Collection<ITriggerEntry> triggers) {
		
		TriggerViewPart viewPart = (TriggerViewPart) HandlerUtil
				.getActivePart(event);
		TriggerModel model = viewPart.getViewer().getViewModel();
		int added = model.add(triggers);

		if (withMessage) {
			StringBuilder sb = new StringBuilder("Added  ");
			sb.append(added);
			sb.append(" sample triggers to the Queries View.");
			if (added != triggers.size()) {
				sb.append(" Defered adding ");
				sb.append(triggers.size() - added);
				sb.append(" duplicate triggers.");
			}
			MessageDialog.openInformation(viewPart.getViewer().getControl()
					.getShell(),
					"Imported Trigger Enties", sb.toString());
		}

	}

	class FullNameFunction implements Function<String, ITriggerEntry> {
		@Override
		public ITriggerEntry apply(String string) {
			checkNotNull(string);
			// System.out.println("Transforming : " + string);
			Iterable<String> tokens = Splitter.on("\",\"").trimResults()
					.trimResults(CharMatcher.is('\"'))
			// .trimResults(CharMatcher.INVISIBLE)
					.split(string);

			Iterable<String> filtered = Iterables.filter(tokens,
					new Predicate<String>() {
				@Override
				public boolean apply(final String input) {
							if (input.trim().equals(",")) {
								return false;
							}
							return true;
				}

			});

			return TriggerEntryFactory.create(filtered);
		}
	}

}
