/**
 * 
 */
package com.verticon.tracker.export.wlic.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorActionDelegate;

import com.verticon.tracker.editor.util.ExportPremisesBase;

/**
 * @author jconlon
 * @deprecated Use ExportWlicWizard
 */
public class ExportWlicEditorActionDelegate extends ExportPremisesBase implements IEditorActionDelegate  {

	/**
	 * 
	 */
	public ExportWlicEditorActionDelegate() {
		super(new WlicPremisesProcessor());
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		super.run(action);
	}
	
}
