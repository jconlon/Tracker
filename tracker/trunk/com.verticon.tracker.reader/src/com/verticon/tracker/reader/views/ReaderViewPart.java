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

package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;



/**
 * Uses the ReaderViewer inside a workbench view. 
 */

public class ReaderViewPart extends ViewPart {
	public static final String ID = "com.verticon.tracker.reader.view";
	
	private ReaderViewer viewer;
	private RemoveReaderAction removeReaderAction;
	private AddReaderAction addReaderAction;
	private ISelectionChangedListener listener = null;

	/**
	 * The constructor.
	 */
	public ReaderViewPart() {
	}

	public ReaderViewModel getModel(){
		return viewer==null?null:viewer.getReaderViewModel();
	}
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new ReaderViewer(parent);
		
		createActions();
		
		createToolbarButtons();
		
		hookGlobalActions();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
        
	private void createToolbarButtons() {
		  
	      IToolBarManager toolBarMgr = this.getViewSite().getActionBars().getToolBarManager();
	      toolBarMgr.add(removeReaderAction);
	      removeReaderAction.setEnabled(false);
	      
	      toolBarMgr.add(addReaderAction);
	      addReaderAction.setEnabled(true);
	      
	      if(listener==null){
	    	  listener = new ISelectionChangedListener() {
	    	        public void selectionChanged(SelectionChangedEvent event) {
	    	           boolean isEmpty = !event.getSelection().isEmpty();
	    	           removeReaderAction.setEnabled(isEmpty);
	    	        }
	    		};
	      }
	      viewer.addSelectionChangedListener( listener);
	   }
	
	private void createActions() {
	      IWorkbench workbench = PlatformUI.getWorkbench();
	      ISharedImages platformImages = workbench.getSharedImages();

	      addReaderAction = new AddReaderAction(this, "Add", viewer);
	      ImageDescriptor plusImage = AbstractUIPlugin.imageDescriptorFromPlugin(
	    		  "org.eclipse.ui", "$nl$/icons/full/obj16/add_obj.gif");

	      addReaderAction.setImageDescriptor(plusImage);
	      addReaderAction.setToolTipText("Add a new Reader");
	      
	      removeReaderAction = new RemoveReaderAction(viewer, "Remove");
	      removeReaderAction.setImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	      removeReaderAction.setDisabledImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	      removeReaderAction
	         .setToolTipText("Remove the selected Reader items");
	   }
	
	 private void hookGlobalActions() {
//	      getViewSite().getActionBars().setGlobalActionHandler(
//	         ActionFactory.CUT.getId(), cutAction);
//	      getViewSite().getActionBars().setGlobalActionHandler(
//	         ActionFactory.COPY.getId(), copyAction);
//	      getViewSite().getActionBars().setGlobalActionHandler(
//	         ActionFactory.PASTE.getId(), pasteAction);
	      getViewSite().getActionBars().setGlobalActionHandler(
	         ActionFactory.DELETE.getId(), removeReaderAction);
	   }
	 

	@Override
	public void dispose() {
		super.dispose();
		viewer.removeSelectionChangedListener(listener);
	}
	
	public void refresh(){
		if(viewer!=null){
			viewer.refreshTableViewer();
		}
	}
}