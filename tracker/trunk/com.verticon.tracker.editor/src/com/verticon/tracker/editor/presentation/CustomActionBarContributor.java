/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Customization for adding tools to Tracker Editors.
 * 
 * @author jconlon
 *
 */
public class CustomActionBarContributor implements ICustomActionBarContributor {

	/**
	 * This keeps track of the active editor.
	 *
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * Master ViewerFilter for views 
	 */
	SelectionViewerFilter masterViewerFilterAction;

	/**
	 * Image for collapse toolbar button
	 * 
	 * @generated NOT
	 */
	private static ImageDescriptor collapseImage = AbstractUIPlugin.imageDescriptorFromPlugin(
	    		"com.verticon.tracker.editor", "icons/full/elcl16/collapseall.gif");
	
	/**
	 * Image for expand toolbar button
	 * 
	 * @generated NOT
	 */
	private static ImageDescriptor expandImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.editor", "icons/full/elcl16/expandall.gif");
	
	
	/**
	 * Image for selectFromAnimals toolbar button
	 * 
	 * @generated NOT
	 */
	private static ImageDescriptor selectFromAnimalsImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.editor", "icons/full/elcl16/selectFromAnimals.gif");
	
	
	/**
	 * Image for selectFromEvents toolbar button
	 * 
	 * @generated NOT
	 */
	private static ImageDescriptor selectFromEventsImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.editor", "icons/full/elcl16/selectFromEvents.gif");
	    
	
	/**
	 * Collapse Action
	 * 
	 * @generated NOT
	 */
	protected IAction collapseTreeAction = 
		
		new Action("Collapse All",collapseImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof IViewerProvider) {
				IViewerProvider viewerProvider = ((IViewerProvider)activeEditorPart);
				if (viewerProvider.getViewer() != null){
					if (viewerProvider.getViewer() instanceof TreeViewer ) {
						((TreeViewer)viewerProvider.getViewer()).collapseAll();
					} 
				}
			}
			
		}
	};
	
	/**
	 * Exapand Action
	 * 
	 * @generated NOT
	 */
	protected IAction expandTreeAction = 
		
		new Action("Expand All",expandImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof IViewerProvider) {
				IViewerProvider viewerProvider = ((IViewerProvider)activeEditorPart);
				if (viewerProvider.getViewer() != null){
					if (viewerProvider.getViewer() instanceof TreeViewer ) {
						((TreeViewer)viewerProvider.getViewer()).expandAll();
					} 
				}
			}
		}
	};
	
	
	/**
	 * Action to Select the Animals in the SelectionTable from the rows 
	 * selected in the AnimalsTable.
	 * 
	 * @generated NOT
	 */
	protected IAction selectAnimalsAction = 
		
		new Action("Link Selection with Animals Table",selectFromAnimalsImage) {

		@Override
		public void run() {
			if (activeEditorPart instanceof ISelectionViewerProvider && activeEditorPart instanceof IAnimalSelectionProvider) {
				ISelectionViewerProvider selectionProvider = ((ISelectionViewerProvider)activeEditorPart);
					selectionProvider.setSelectionViewerSelection(
							((IAnimalSelectionProvider)activeEditorPart).getAnimalSelection());
					
				
			}
			
		}
	};
	
	
	/**
	 * Action to Select the Animals in the SelectionTable from the rows 
	 * selected in the AnimalsTable.
	 * 
	 * @generated NOT
	 */
	protected IAction selectEventsAction = 
		
		new Action("Link Selection with Events Table",selectFromEventsImage) {

		@Override
		public void run() {
			
			if (activeEditorPart instanceof ISelectionViewerProvider && activeEditorPart instanceof IEventSelectionProvider) {
				ISelectionViewerProvider selectionProvider = ((ISelectionViewerProvider)activeEditorPart);
					selectionProvider.setSelectionViewerSelection(
							((IEventSelectionProvider)activeEditorPart).getEventSelection());
					
				
			}
			
		}
	};
	
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#contributeToMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void contributeToMenu(IMenuManager menuManager) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator());
		toolBarManager.add(collapseTreeAction);
		toolBarManager.add(expandTreeAction);
		toolBarManager.add(selectAnimalsAction);
		toolBarManager.add(selectEventsAction);
		addChildrenToToolBar( toolBarManager);
		if(masterViewerFilterAction == null){
			masterViewerFilterAction = new SelectionViewerFilter();
		}
		toolBarManager.add(masterViewerFilterAction);

	}

	protected void addChildrenToToolBar(IToolBarManager toolBarManager) {	
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IEditorPart part) {
		this.activeEditorPart=part;
	}

	
	
	public SelectionViewerFilter getSelectionViewerFilter() {
		return masterViewerFilterAction;
	}

	public void disableSelectionViewerActions() {
		selectEventsAction.setEnabled(false);
		selectAnimalsAction.setEnabled(false);
		masterViewerFilterAction.setEnabled(false);
	}

	public void enableSelectionViewerActions() {
		selectEventsAction.setEnabled(true);
		selectAnimalsAction.setEnabled(true);
		masterViewerFilterAction.setEnabled(true);
	}
	
	public void disableTreeViewerActions() {
		collapseTreeAction.setEnabled(false);
		expandTreeAction.setEnabled(false);
	}

	public void enableTreeViewerActions() {
		collapseTreeAction.setEnabled(true);
		expandTreeAction.setEnabled(true);
	}

	
}
