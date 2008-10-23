package com.verticon.tracker.editor.util;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;

/**
 * Controls the synchronization of Workbench Active Editors 
 * selections and the selections items on the TableView
 * across views.
 * @author jconlon
 *
 */
public interface ISelectionController extends ISelectionListener,
	IPartListener2, ISelectionChangedListener{

	/**
	 * 
	 * @return editingDomain of the Active
	 */
    EditingDomain getEditingDomain();
	
    /**
     * Opens the controller
     */
	void open();
	
	/**
	 * Close the controller to free up resources
	 */
	void close();

	/**
	 * Sends a selection out the EventAdmin channel
	 * @param selection
	 * @param sourceOfTransmission
	 */
	void sendSelectionToChannel(ISelection selection,
			String sourceOfTransmission);
}