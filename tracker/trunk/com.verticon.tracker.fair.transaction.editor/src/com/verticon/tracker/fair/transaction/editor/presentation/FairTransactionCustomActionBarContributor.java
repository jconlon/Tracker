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
package com.verticon.tracker.fair.transaction.editor.presentation;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;

import com.verticon.tracker.editor.presentation.CustomActionBarContributor;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.fair.editor.presentation.FairSelectionViewerFilter;

/**
 * Customization for adding Navigation tools to Fair Transaction Editors.
 * 
 * @author jconlon
 * 
 */
class FairTransactionCustomActionBarContributor extends
		CustomActionBarContributor {

	public FairTransactionCustomActionBarContributor() {
		super();
		this.masterViewerFilterAction = new FairSelectionViewerFilter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.editor.presentation.ICustomActionBarContributor#
	 * contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator());
		toolBarManager.add(collapseTreeAction);
		toolBarManager.add(expandTreeAction);
		if (masterViewerFilterAction == null) {
			masterViewerFilterAction = new SelectionViewerFilter();
		}
		toolBarManager.add(masterViewerFilterAction);

	}

}
