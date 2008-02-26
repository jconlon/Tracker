
package com.verticon.tracker.transaction.publisher.views;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;

import com.verticon.tracker.transaction.publisher.wizards.AddPublisherWizard;



/**
 * Uses the PublisherViewer inside a workbench view. 
 */

public class PublisherViewPart extends ViewPart {
	private PublisherViewer viewer;

	/**
	 * The constructor.
	 */
	public PublisherViewPart() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new PublisherViewer(parent);
		viewer.getCloseButton().addSelectionListener(new SelectionAdapter() {
       	
			// Close the view i.e. dispose of the composite's parent
			public void widgetSelected(SelectionEvent e) {
				handleDispose();
			}
		});
		viewer.getAddButton().addSelectionListener(new SelectionAdapter() {
			// Call a wizard 
			public void widgetSelected(SelectionEvent e) {
				handleAdd();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	/**
	 * Handle a 'close' event by disposing of the view
	 */
	public void handleDispose() {
		this.getSite().getPage().hideView(this);
	}
	
	/**
	 * Handle a 'add' event by calling a Wizard
	 */

	public void handleAdd() {
		IWorkbenchWindow window = this.getSite().getWorkbenchWindow();
		AddPublisherWizard addWizard = new AddPublisherWizard(viewer.getPublisherViewModel());
		addWizard.init(window.getWorkbench());
		WizardDialog dialog = new WizardDialog(window.getShell(),addWizard);
		dialog.open();
	}
}