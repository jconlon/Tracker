/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.Action;



/**
 * @author jconlon
 *
 */
public class AddQueryAction extends Action {

	private OclQueryViewer viewer;

	   public AddQueryAction(OclQueryViewer viewer, String text) {
	      super(text);
	      this.viewer = viewer;
	   }
	   
	   public void run() {
		   viewer.getViewModel().addQuery();
		}
}
