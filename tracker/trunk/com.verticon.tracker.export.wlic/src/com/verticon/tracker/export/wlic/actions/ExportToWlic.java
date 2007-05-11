/**
 * 
 */
package com.verticon.tracker.export.wlic.actions;

import org.eclipse.ui.IObjectActionDelegate;

import com.verticon.tracker.editor.util.AbstractTrackerActionDelegate;

/**
 * @author jconlon
 *
 */
public class ExportToWlic extends AbstractTrackerActionDelegate implements IObjectActionDelegate {

	/**
	 * 
	 */
	public ExportToWlic() {
		super(new WlicTrackerExporter());
	}
	
}
