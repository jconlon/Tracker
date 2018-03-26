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
package com.verticon.tracker.ocl.query.viewer.views;

import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.part.ViewPart;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQueryViewModel;

/**
 * @author jconlon
 *
 */
class AddExampleQueriesAction extends Action {

	private final OclQueryViewer viewer;
	private final ViewPart viewPart;
	private final Collection<IOclQuery> queries;

	protected AddExampleQueriesAction(OclQueryViewer viewer, String text, ViewPart viewPart,
			Collection<IOclQuery> queries) {
		super(text);
		this.viewer = viewer;
		this.viewPart = viewPart;
		this.queries = queries;
	}

	@Override
	public void run() {
		addQueries(viewer);
	}

	private void addQueries(OclQueryViewer viewer) {

		OclQueryViewModel model = viewer.getViewModel();
		int addedQueries = model.add(queries);

		StringBuilder sb = new StringBuilder("Added  ");
		sb.append(addedQueries);
		sb.append(" example queries to the Queries View.");
		if (addedQueries != queries.size()) {
			sb.append(" Defered adding ");
			sb.append(queries.size() - addedQueries);
			sb.append(" duplicate queries.");
		}
		MessageDialog.openInformation(viewPart.getSite().getShell(), "Add Queries", sb.toString());

	}
}
