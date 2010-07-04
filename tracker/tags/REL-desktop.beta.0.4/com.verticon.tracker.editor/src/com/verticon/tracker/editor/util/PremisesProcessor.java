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
package com.verticon.tracker.editor.util;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.verticon.tracker.Premises;

public interface PremisesProcessor {

	
	public abstract void process(Premises premises, IFile projectFile, IProgressMonitor monitor) throws IOException, CoreException;

	public abstract String getCompletionMessage();
	
	public abstract String getFailureTitle();
	
//	public abstract void setFileName(String fileName);
	
}