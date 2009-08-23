package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.editor.presentation.SelectionViewerFilter;

/**
 * Implemented by Editors to allow registration of Viewer TableViewer with the
 * Editor SelectionViewerFilter
 * 
 * @see SelectionViewerFilter
 * @author jconlon
 * 
 */
public interface ITrackerViewRegister {

	void removeViewer(TableViewer tableViewer);

	void addViewer(TableViewer tableViewer);
}
