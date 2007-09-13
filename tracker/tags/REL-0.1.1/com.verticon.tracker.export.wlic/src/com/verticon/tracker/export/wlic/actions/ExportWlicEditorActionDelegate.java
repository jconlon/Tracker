/**
 * 
 */
package com.verticon.tracker.export.wlic.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorActionDelegate;

import com.verticon.tracker.editor.util.ExportPremisesBase;

/**
 * @author jconlon
 *
 */
public class ExportWlicEditorActionDelegate extends ExportPremisesBase implements IEditorActionDelegate  {

	/**
	 * 
	 */
	public ExportWlicEditorActionDelegate() {
		super(new WlicTrackerExporter());
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		super.run(action);
	}
	
}
