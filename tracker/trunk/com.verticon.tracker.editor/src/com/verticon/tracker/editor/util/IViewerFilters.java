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

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
/**
 * Provides a collection of ViewerFilter objects 
 * @author jconlon
 *
 */
public interface IViewerFilters {

	/**
	 *  
	 * @param type
	 * @return collection of ViewerFilter objects
	 */
	Collection<ViewerFilter> getViewerFilters(EClass type);
}
