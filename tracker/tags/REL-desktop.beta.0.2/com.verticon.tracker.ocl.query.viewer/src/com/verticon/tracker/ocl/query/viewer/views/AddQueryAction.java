/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.Action;



/**
 * @author jconlon
 *
 */
class AddQueryAction extends Action {

	private OclQueryViewer viewer;

	   protected AddQueryAction(OclQueryViewer viewer, String text) {
	      super(text);
	      this.viewer = viewer;
	   }
	   
	   public void run() {
		   viewer.getViewModel().addQuery();
		}
}
