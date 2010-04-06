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
