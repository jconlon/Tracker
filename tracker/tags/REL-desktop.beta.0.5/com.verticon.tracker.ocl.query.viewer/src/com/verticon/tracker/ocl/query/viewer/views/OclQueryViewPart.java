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
package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * Encapsulates a OclQueryViewer so it can be run in a plugin.
 * 
 * @author jconlon
 * 
 */
public class OclQueryViewPart extends ViewPart {

	private OclQueryViewer viewer;
	private RemoveQueryAction removeReaderAction;
	private AddQueryAction addQueryAction;
	private ExecuteQueryAction executeQueryAction;
	
	private ISelectionChangedListener listener = null;
	
	

	public OclQueryViewPart() {
		super();
	}

	public void createPartControl(Composite parent) {
		viewer = new OclQueryViewer(parent);
		
		createActions();
		
		createToolbarButtons();
		
		hookGlobalActions();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	private void createToolbarButtons() {
		  
	      IToolBarManager toolBarMgr = this.getViewSite().getActionBars().getToolBarManager();
	      toolBarMgr.add(removeReaderAction);
	      removeReaderAction.setEnabled(false);
	      
	      toolBarMgr.add(addQueryAction);
	      addQueryAction.setEnabled(true);
	      
	      toolBarMgr.add(executeQueryAction);
	      executeQueryAction.setEnabled(false);
	      
	      if(listener==null){
	    	  listener = new ISelectionChangedListener() {
	    	        public void selectionChanged(SelectionChangedEvent event) {
	    	           boolean isNotEmpty = !event.getSelection().isEmpty();
	    	           removeReaderAction.setEnabled(isNotEmpty);
	    	           executeQueryAction.setEnabled(canExecuteQuery(event));
	    	        }
	    		};
	      }
	      viewer.addSelectionChangedListener( listener);
	   }
	
   static boolean canExecuteQuery(SelectionChangedEvent event){
		boolean isNotEmpty = !event.getSelection().isEmpty();
		boolean isOnlyOne = ((IStructuredSelection)event.getSelection()).size() == 1;
		if(isNotEmpty && isOnlyOne){
			IOclQuery query = (IOclQuery) ((IStructuredSelection) event
					.getSelection()).getFirstElement();
		
			return query != null ? query.validateQuery() : false;
		}
		return false;
	}
	
	private void createActions() {
	      IWorkbench workbench = PlatformUI.getWorkbench();
	      ISharedImages platformImages = workbench.getSharedImages();

	      addQueryAction = new AddQueryAction(viewer, "Add");
	      ImageDescriptor plusImage = AbstractUIPlugin.imageDescriptorFromPlugin(
	    		  "org.eclipse.ui", "$nl$/icons/full/obj16/add_obj.gif");

	      addQueryAction.setImageDescriptor(plusImage);
	      addQueryAction.setToolTipText("Add a new Query");
	      
	      removeReaderAction = new RemoveQueryAction(viewer, "Remove");
	      removeReaderAction.setImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	      removeReaderAction.setDisabledImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	      removeReaderAction
	         .setToolTipText("Remove the selected Query items");
	      
	      
	      executeQueryAction = new ExecuteQueryAction(viewer, "Select");
	      executeQueryAction.setImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));
	      executeQueryAction.setDisabledImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD_DISABLED));
	      executeQueryAction
	         .setToolTipText(OclQueryViewer.EXECUTE_SELECTED_QUERY_TOOLTIP);
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

	public OclQueryViewer getViewer() {
		return viewer;
	}
}
