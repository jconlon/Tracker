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
package com.verticon.tracker.ocl.query.viewer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

class OCLViewerFilter extends ViewerFilter{
	private final IOclQuery query;
	OCLViewerFilter(IOclQuery query) {
		super();
		this.query=query;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OCLViewerFilter){
			return query.equals(((OCLViewerFilter)obj).query);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 31 * query.hashCode();
		return result;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement,
			Object element) {
		if(element instanceof EObject){
			return query.conditionIsSatisfied((EObject)element);
		}
		return false;
	}

	@Override
	public String toString() {
		return query.getName();
	}
}