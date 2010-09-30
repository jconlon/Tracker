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
package com.verticon.tracker.configuration.editor.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IWorkbenchPartConstants;

import com.verticon.osgi.metatype.presentation.extended.MetatypeFormsEditor;


public class ConfigurationAdminEditor extends MetatypeFormsEditor {

	/* (non-Javadoc)
	 * @see com.verticon.osgi.metatype.presentation.MetatypeEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		this.firePropertyChange(99999);
		super.doSave(progressMonitor);
		StartEditor startEditor = new StartEditor();
		this.setInput(startEditor.getInput());
		this.firePropertyChange(IWorkbenchPartConstants.PROP_INPUT);
	}
}
