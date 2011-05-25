/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
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
 * <ul>
 *   <li>Collapse Selection Tree,</li>
 *   <li>Expand Selection Tree, </li>
 * </ul>
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
	protected SelectionViewerFilter masterViewerFilterAction;

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
	 * Collapse Action
	 * 
	 * @generated NOT
	 */
	protected IAction collapseTreeAction = 
		
		new Action("Collapse All",collapseImage) {

		@Override
		public void run() {
			IViewerProvider viewerProvider = 
				(IViewerProvider)activeEditorPart.getAdapter(IViewerProvider.class);
			if (viewerProvider !=null) {
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
			IViewerProvider viewerProvider = 
				(IViewerProvider)activeEditorPart.getAdapter(IViewerProvider.class);
			if (viewerProvider !=null) {
				if (viewerProvider.getViewer() != null){
					if (viewerProvider.getViewer() instanceof TreeViewer ) {
						((TreeViewer)viewerProvider.getViewer()).expandAll();
					} 
				}
			}
		}
	};

	
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#contributeToMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void contributeToMenu(IMenuManager menuManager) {

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator());
		toolBarManager.add(collapseTreeAction);
		toolBarManager.add(expandTreeAction);
		addChildrenToToolBar( toolBarManager);
		if(masterViewerFilterAction == null){
			masterViewerFilterAction = new SelectionViewerFilter();
		}
		toolBarManager.add(masterViewerFilterAction);

	}

	private void addChildrenToToolBar(IToolBarManager toolBarManager) {	
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
		masterViewerFilterAction.setEnabled(false);
	}

	public void enableSelectionViewerActions() {
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
