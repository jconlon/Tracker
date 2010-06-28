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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPartSite;


/**
 * Functionality to support ISelectionController implementations.
 * 
 * @author jconlon
 *
 */
public interface ItemsView {

	void handleViewerInputChange();
	
	void refresh(ISelection selection);
	
	FilteredTable getMasterFilteredTable();
	
	IWorkbenchPartSite getSite();
	
	void enableMenus(boolean enable);
}
