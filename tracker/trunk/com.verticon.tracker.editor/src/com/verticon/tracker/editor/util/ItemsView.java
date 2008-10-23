package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.ISelection;


/**
 * Functionality to support ISelectionController implementations.
 * 
 * @author jconlon
 *
 */
public interface ItemsView {

	void handleViewerInputChange2();
	
	void refresh(ISelection selection);
	
	FilteredTable getMasterFilteredTable();
}
