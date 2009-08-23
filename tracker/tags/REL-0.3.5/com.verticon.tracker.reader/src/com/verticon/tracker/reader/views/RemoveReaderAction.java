/**
 * 
 */
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.Action;


/**
 * @author jconlon
 *
 */
class RemoveReaderAction extends Action {

	private ReaderViewer view;

	   protected RemoveReaderAction(ReaderViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   public void run() {
		   view.removeSelectedReaders();
	   }
	   
}
