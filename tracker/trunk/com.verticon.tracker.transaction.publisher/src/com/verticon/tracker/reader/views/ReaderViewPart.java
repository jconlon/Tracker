
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;



/**
 * Uses the ReaderViewer inside a workbench view. 
 */

public class ReaderViewPart extends ViewPart {
	private ReaderViewer viewer;
	private RemoveReaderAction removeReaderAction;
	private AddReaderAction addReaderAction;
	private ISelectionChangedListener listener = null;

	/**
	 * The constructor.
	 */
	public ReaderViewPart() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new ReaderViewer(parent);
		
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
	
	/**
	 * Handle a 'close' event by disposing of the view
	 */
	public void handleDispose() {
		this.getSite().getPage().hideView(this);
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
	      addReaderAction.setImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	      addReaderAction.setDisabledImageDescriptor(platformImages
	         .getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
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
}