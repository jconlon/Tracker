/**
 * 
 */
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.Action;


/**
 * @author jconlon
 *
 */
public class RemoveReaderAction extends Action {

	private ReaderViewer view;

	   public RemoveReaderAction(ReaderViewer view, String text) {
	      super(text);
	      this.view = view;
	   }
	   
	   public void run() {
		   view.removeSelectedReaders();
	   }
	   
}
