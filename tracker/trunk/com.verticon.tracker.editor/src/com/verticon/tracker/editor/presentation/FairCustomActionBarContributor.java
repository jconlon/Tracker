/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Customization for adding FairRegistration Sync tool to Tracker Editors.
 * 
 * @author jconlon
 *
 */
public class FairCustomActionBarContributor extends CustomActionBarContributor {

	/**
	 * Image for selectFromFair toolbar button
	 * 
	 */
	private static ImageDescriptor selectFromFairImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.editor", "icons/full/elcl16/selectFromFair.gif");
	
	
	/**
	 * Action to Select the Animals in the SelectionTable from the rows 
	 * selected in the AnimalsTable.
	 * 
	 */
	protected IAction selectFairRegistrationAction = 
		
		new Action("Link Selection with FairRegistration Table",selectFromFairImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof TrackerEditor) {
				TrackerEditor trackerEditor = ((TrackerEditor)activeEditorPart);
				if (trackerEditor.currentViewerPane != null){
					if (trackerEditor.currentViewerPane.getViewer() == trackerEditor.selectionViewer) {
						trackerEditor.selectionViewer.setSelection(trackerEditor.fairRegistrationTableViewer.getSelection(),true);
					} 
				}
			}
			
		}
	};

	public void addChildrenToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(selectFairRegistrationAction);
	}
	
	/**
	 * 
	 */
	public void disableSelectionViewerActions() {
		super.disableSelectionViewerActions();
		selectFairRegistrationAction.setEnabled(false);
		
	}

	/**
	 * 
	 */
	public void enableSelectionViewerActions() {
		super.enableSelectionViewerActions();
		selectFairRegistrationAction.setEnabled(true);
		
	}
	
}
