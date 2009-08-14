/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * @author jconlon
 *
 */
class ExecuteQueryAction extends Action {

	private OclQueryViewer viewer;

	protected ExecuteQueryAction(OclQueryViewer viewer, String text) {
		super(text);
		this.viewer = viewer;
	}

	@Override
	public void run() {
		super.run();
		IOclQuery query = (IOclQuery) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();
		query.run();
	}
	
	
}
