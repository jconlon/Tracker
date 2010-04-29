package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;

import com.verticon.tracker.Premises;

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
     * Active Editor can be used instead of an Editing Domain to obtain Root of the document
     * being edited.
     * 
     * @return activeEditor
     */
    IEditorPart getActiveEditorPart();
    
    /**
	 * Convenience method for Tracker Event and Animal Views
	 * @return premises or null
	 */
	public Premises getPremises();
	
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