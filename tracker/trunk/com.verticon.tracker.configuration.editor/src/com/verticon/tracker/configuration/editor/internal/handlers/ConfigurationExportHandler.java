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
package com.verticon.tracker.configuration.editor.internal.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.configuration.editor.internal.Activator;
import com.verticon.tracker.configuration.editor.internal.ConfigurationAdminEditor;

public class ConfigurationExportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.SAVE);
		fd.setText("Save");
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		String filterPath = path.toOSString();
		fd.setFilterPath(filterPath);// location.getPath());
		String[] filterExt = { "*.metatype", "*.xml", "*.*" };
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		if (selected == null) {
			return false;
		}
		try {
			export(selected);
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"Confirm", "Saved configuration to " + selected);
		} catch (IOException e) {
			throw new ExecutionException("Failed to export configuration.", e);
		}

		return null;
	}

	private void export(String file) throws IOException {
		ConfigurationAdminEditor.register();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(Activator.TEST_URI);
		resource.load(null);
		URI export = URI.createFileURI(file);
		resource.setURI(export);
		resource.save(null);
	}

}
