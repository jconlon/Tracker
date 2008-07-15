/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.Action;


/**
 * @author jconlon
 *
 */
public class RemoveQueryAction extends Action {

	private OclQueryViewer view;

	   public RemoveQueryAction(OclQueryViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   public void run() {
		   view.removeSelectedQueries();
	   }
	   
}
