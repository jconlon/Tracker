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

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.editor.util.IViewerFilters;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewPart;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

import static com.verticon.tracker.ocl.query.viewer.OclQueryViewerPlugin.bundleMarker;

public class OCLViewerFilters implements IViewerFilters {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(OCLViewerFilters.class);


	private static final String COM_VERTICON_TRACKER_OCL_QUERY_VIEW = "com.verticon.tracker.ocl.query.view";


	@Override
	public Collection<ViewerFilter> getViewerFilters(EClass type) {
		OclQueryViewer viewer = getViewer();
		if(viewer!=null){
			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			for (IOclQuery oclQuery : viewer.getViewModel().getTasks()) {
				EClass contextClass = oclQuery.getContextClass();
				if(contextClass == null){
					//Context class of query is null
					logger.warn(bundleMarker, "OclQuery named:{} had a null contextClass",oclQuery.getName());
					continue;
				}
				if(type.isSuperTypeOf(contextClass)){
				 ViewerFilter filter = new OCLViewerFilter(
						 ((OclQuery)oclQuery).clone()
				 );
				 filters.add(filter);
				}
			}
			return filters;
		}
		return Collections.emptyList();
	}
	
	/**
	 * @return OclQueryViewer
	 */
	private static OclQueryViewer getViewer() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		OclQueryViewPart part = (OclQueryViewPart)page.findView(COM_VERTICON_TRACKER_OCL_QUERY_VIEW);
		return part!=null?part.getViewer():null;
	}

}
