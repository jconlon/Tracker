/**
 * 
 */
package com.verticon.tracker.fair.transaction.editor.presentation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.CustomActionBarContributor;
import com.verticon.tracker.editor.presentation.IAnimalSelectionProvider;
import com.verticon.tracker.editor.presentation.IEventSelectionProvider;
import com.verticon.tracker.editor.presentation.ISelectionViewerProvider;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.presentation.FairSelectionViewerFilter;
import com.verticon.tracker.transaction.editor.presentation.TrackerTransactionEditor;

/**
 * Customization for adding Navigation tools to Fair Transaction Editors.
 * 
 * @author jconlon
 *
 */
public class FairTransactionCustomActionBarContributor extends CustomActionBarContributor {

	
	public FairTransactionCustomActionBarContributor() {
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
			if (activeEditorPart instanceof FairTransactionEditor) {
				FairTransactionEditor fairTransactionEditor = ((FairTransactionEditor)activeEditorPart);
				if (fairTransactionEditor.getCurrentViewerPane() != null){
					if (fairTransactionEditor.getCurrentViewerPane().getViewer() == fairTransactionEditor.getSelectionViewerPane()) {
						fairTransactionEditor.getSelectionViewerPane().setSelection(fairTransactionEditor.getPeopleTableViewer().
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
			if (activeEditorPart instanceof FairTransactionEditor) {
				FairTransactionEditor fairEditor = ((FairTransactionEditor)activeEditorPart);
				if (fairEditor.getCurrentViewerPane() != null){
					if (fairEditor.getCurrentViewerPane().getViewer() == fairEditor.getSelectionViewerPane()) {
						fairEditor.getSelectionViewerPane().setSelection(fairEditor.getExhibitsTableViewer().
								getSelection(),true);
					} 
				}
			}
			
		}
	};

	@Override
	public void addChildrenToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(selectPeopleAction);
		toolBarManager.add(selectExhibitsAction);
	}
	
	/**
	 * 
	 */
	@Override
	public void disableSelectionViewerActions() {
		super.disableSelectionViewerActions();
		selectPeopleAction.setEnabled(false);
		selectExhibitsAction.setEnabled(false);
		
	}

	/**
	 * 
	 */
	@Override
	public void enableSelectionViewerActions() {
		super.enableSelectionViewerActions();
		selectPeopleAction.setEnabled(true);
		selectExhibitsAction.setEnabled(true);
		
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.ICustomActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator());
		toolBarManager.add(collapseTreeAction);
		toolBarManager.add(expandTreeAction);
		toolBarManager.add(selectPremisesAnimalsAction);
		toolBarManager.add(selectPremisesEventsAction);
		toolBarManager.add(selectPeopleAction);
		toolBarManager.add(selectExhibitsAction);
		if(masterViewerFilterAction == null){
			masterViewerFilterAction = new SelectionViewerFilter();
		}
		toolBarManager.add(masterViewerFilterAction);

	}

	
	/**
	 * Action to Select the Animals in the SelectionTable from the rows 
	 * selected in the AnimalsTable.
	 * 
	 * @generated NOT
	 */
	private IAction selectPremisesEventsAction = 
		
		new Action("Link Selection with Premises Events Table",selectFromEventsImage) {

		@Override
		public void run() {
			ISelectionViewerProvider selectionViewerProvider = 
				(ISelectionViewerProvider)activeEditorPart.getAdapter(ISelectionViewerProvider.class);
			
			IEditorPart premisesEditorPart = getPremisesEditorPart(activeEditorPart);
			if(premisesEditorPart == null){
				return;
			}
			IEventSelectionProvider eventSelectionProvider = 
				(IEventSelectionProvider)premisesEditorPart.getAdapter(IEventSelectionProvider.class);
				
			if (selectionViewerProvider !=null && eventSelectionProvider !=null) {
				selectionViewerProvider.setSelectionViewerSelection(
						eventSelectionProvider.getEventSelection());
			}
			
		}
	};
	
	/**
	 * Action to Select the Animals in the SelectionTable from the rows 
	 * selected in the AnimalsTable.
	 * 
	 * @generated NOT
	 */
	private IAction selectPremisesAnimalsAction = 
		
		new Action("Link Selection with Premises Animals Table",selectFromAnimalsImage) {

		@Override
		public void run() {
			ISelectionViewerProvider selectionViewerProvider = 
				(ISelectionViewerProvider)activeEditorPart.getAdapter(ISelectionViewerProvider.class);
			
			IEditorPart premisesEditorPart = getPremisesEditorPart(activeEditorPart);
			if(premisesEditorPart == null){
				return;
			}
			
			IAnimalSelectionProvider animalSelectionProvider = 
				(IAnimalSelectionProvider)premisesEditorPart.getAdapter(IAnimalSelectionProvider.class);
				
			if (selectionViewerProvider !=null && animalSelectionProvider !=null) {
				selectionViewerProvider.setSelectionViewerSelection(
						animalSelectionProvider.getAnimalSelection());
					
			}
			
		}
	};
	
	/**
	 * 
	 * @param fairEditorPart 
	 * @return
	 */
	private IEditorPart getPremisesEditorPart(IEditorPart fairEditorPart){
		//Get the Fair
		FairTransactionEditor editor = (FairTransactionEditor)fairEditorPart;
		Fair fair = (Fair) editor.getResource().getContents().get(0);
		if(fair==null){
			return null;
		}
		Premises premises = fair.getPremises();
		if(premises==null){
			return null;
		}
		Resource premisesResource = premises.eResource();
		//Get the other editors in the workspace
		
		IEditorReference[] editorReferences = fairEditorPart.getEditorSite().getPage().getEditorReferences();// getWorkbenchWindow().getWorkbench().getWorkbenchWindows();
		for (IEditorReference editorReference : editorReferences) {
			IEditorPart part = editorReference.getEditor(false);
			if(part instanceof TrackerTransactionEditor){
				TrackerTransactionEditor trackerEditor = (TrackerTransactionEditor)part;
				if(trackerEditor.getResource() == premisesResource){
					return part;
				}
			}
		}
		return null;
	}
}
