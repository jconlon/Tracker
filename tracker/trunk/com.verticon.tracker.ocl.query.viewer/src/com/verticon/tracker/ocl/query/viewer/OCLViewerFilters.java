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
package com.verticon.tracker.ocl.query.viewer;

import static com.verticon.tracker.ocl.query.viewer.OclQueryViewerPlugin.uiState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.emf.ui.api.IViewerFilters;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

public class OCLViewerFilters implements IViewerFilters {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(OCLViewerFilters.class);

	@Override
	public Collection<ViewerFilter> getViewerFilters(EClass type) {
		OclQueryViewer viewer = OclQueryViewerPlugin.getDefault().getViewer();
		OclQueryViewModel model = null;
		if (viewer == null) {
			model = new OclQueryViewModel();
		} else {
			model = viewer.getViewModel();
		}
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		for (IOclQuery oclQuery : model.getTasks()) {
			EClass contextClass = oclQuery.getContextClass();
			if (contextClass == null) {
				// Context class of query is null
				logger.warn(uiState, "OclQuery named:{} had a null contextClass", oclQuery.getName());
				continue;
			}
			if (type.isSuperTypeOf(contextClass)) {
				ViewerFilter filter = new OCLViewerFilter(((OclQuery) oclQuery).clone());
				filters.add(filter);
			}
		}
		return filters;

	}

}
