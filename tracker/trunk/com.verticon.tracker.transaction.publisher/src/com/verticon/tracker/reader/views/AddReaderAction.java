/**
 * 
 */
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.reader.wizards.AddEventReaderWizard;


/**
 * @author jconlon
 *
 */
public class AddReaderAction extends Action {

	private ReaderViewPart view;
	private ReaderViewer viewer;

	   public AddReaderAction(ReaderViewPart view, String text, ReaderViewer viewer) {
	      super(text);
	      this.view = view;
	      this.viewer = viewer;
	   }
	   
	   public void run() {
			IWorkbenchWindow window = view.getSite().getWorkbenchWindow();
			AddEventReaderWizard addWizard = new AddEventReaderWizard(viewer.getReaderViewModel());
			addWizard.init(window.getWorkbench());
			WizardDialog dialog = new WizardDialog(window.getShell(),addWizard);
			dialog.open();
		}
}
