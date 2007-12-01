/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * Encapsulates a OclQueryViewer so it can be run in a plugin.
 * 
 * @author jconlon
 * 
 */
public class OclQueryViewPart extends ViewPart {

	private OclQueryViewer viewer;

	public void createPartControl(Composite parent) {
		viewer = new OclQueryViewer(parent);
		viewer.getCloseButton().addSelectionListener(new SelectionAdapter() {

			// Execute the selected task
			public void widgetSelected(SelectionEvent e) {
				handleExecute();
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
	 * Handle a 'execute' event by
	 */
	public void handleExecute() {
		IOclQuery task = (IOclQuery) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();
		task.run();
	}

	/**
	 * Handle a 'add' event by calling a Wizard
	 */

	public void handleAdd() {
		viewer.getViewModel().addQuery();
	}

}
