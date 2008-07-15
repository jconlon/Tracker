/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.tracker.editor.presentation.CustomActionBarContributor;

/**
 * Customization for adding FairRegistration Sync tool to Tracker Editors.
 * 
 * @author jconlon
 *
 */
public class FairCustomActionBarContributor extends CustomActionBarContributor {

	
	public FairCustomActionBarContributor() {
		super();
		this.masterViewerFilterAction = new FairSelectionViewerFilter();
	}

	/**
	 * Image for selectFromFair toolbar button
	 * 
	 */
	private static ImageDescriptor selectFromPeopleImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.fair.editor", "icons/full/elcl16/selectFromPeople.gif");
	
	/**
	 * Image for selectFromFair toolbar button
	 * 
	 */
	private static ImageDescriptor selectFromExhibitsImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.fair.editor", "icons/full/elcl16/selectFromExhibits.gif");
	
	
	/**
	 * Action to Select the People in the SelectionTable from the rows 
	 * selected in the PeopleTable.
	 * 
	 */
	protected IAction selectPeopleAction = 
		
		new Action("Link Selection with People Table",selectFromPeopleImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof FairEditor) {
				FairEditor fairEditor = ((FairEditor)activeEditorPart);
				if (fairEditor.currentViewerPane != null){
					if (fairEditor.currentViewerPane.getViewer() == fairEditor.selectionViewer) {
						fairEditor.selectionViewer.setSelection(fairEditor.peopleTableViewer.
								getSelection(),true);
					} 
				}
			}
			
		}
	};
	
	/**
	 * Action to Select the People in the SelectionTable from the rows 
	 * selected in the PeopleTable.
	 * 
	 */
	protected IAction selectExhibitsAction = 
		
		new Action("Link Selection with Exhibits Table",selectFromExhibitsImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof FairEditor) {
				FairEditor fairEditor = ((FairEditor)activeEditorPart);
				if (fairEditor.currentViewerPane != null){
					if (fairEditor.currentViewerPane.getViewer() == fairEditor.selectionViewer) {
						fairEditor.selectionViewer.setSelection(fairEditor.exhibitsTableViewer.
								getSelection(),true);
					} 
				}
			}
			
		}
	};

	public void addChildrenToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(selectPeopleAction);
		toolBarManager.add(selectExhibitsAction);
	}
	
	/**
	 * 
	 */
	public void disableSelectionViewerActions() {
		super.disableSelectionViewerActions();
		selectPeopleAction.setEnabled(false);
		selectExhibitsAction.setEnabled(false);
		
	}

	/**
	 * 
	 */
	public void enableSelectionViewerActions() {
		super.enableSelectionViewerActions();
		selectPeopleAction.setEnabled(true);
		selectExhibitsAction.setEnabled(true);
		
	}
	
}
