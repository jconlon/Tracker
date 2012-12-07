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
package com.verticon.tracker.views;

import static com.verticon.tracker.views.ViewsPlugin.bundleMarker;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;

public class EventsView extends TrackerView implements ItemsView{

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(EventsView.class);


	private static final String NAME_OF_ITEM_IN_MASTER = "Event";

	private ISelectionController selectionController;
	
	
	/**
	 * Subclasses can override this to provide a more useful name for
	 *  dialog.
	 * 
	 * @return singular name of the items for wizard
	 */
	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}
	
	/**
	 * Displays a one page wizard to add an Event to the model. The page prompts
	 * the user to choose the animal from a combo widget and to choose the event
	 * type from a list.
	 * 
	 * If an event was selected in the master the animal number will be selected
	 * in the wizard page.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Premises premises = selectionController.getPremises();
		AddEventWizard wizard = new AddEventWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises, tableViewer
				.getSelection());
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();
		wizard.dispose();
		if(results == WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				return object;

			}
		}
		return null;
	}

	
	/**
	 * Override point for subclasses to create the tableViewer columns.
	 * 
	 * For Task number 261 would like to use a databinding contentProvider for
	 * the tableViewer
	 * 
	 * @see #handleViewerInputChange()
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer viewer = masterFilteredTable.getViewer();
//		setUpEventsTableViewer(viewer);
		sorter = EventColumn.setup(tableViewer, memento, adapterFactory, actions);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());

		viewer.setContentProvider(new EventHistoryContentProvider(
				adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory){

							@Override
							public String getColumnText(Object object,
									int columnIndex) {
								if(columnIndex!=1){
									return super.getColumnText(object, columnIndex);
								}
								String text = super.getColumnText(object, columnIndex);
								return text;
							}});
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	public void handleViewerInputChange() {
		Premises premises = selectionController.getPremises();
		logger.debug(bundleMarker,"Changed premises={}", premises);
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
		enableMenus(premises!=null);
	}
	

	/**
	 * Override super to add an EventSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		logger.debug(bundleMarker,"createPartControl entered");
		super.createPartControl(base);
		selectionController = new SelectionController(
				this, new EventsStrategy(this));
		selectionController.open();
		
		getSite().getPage().addSelectionListener(selectionController);
		getSite().getPage().addPartListener(selectionController);
		tableViewer.addSelectionChangedListener(selectionController);
		handleViewerInputChange();
	}

	/**
	 * Override super to remove the listeners and close the AnimalSelectionController
	 */
	 @Override
	public void dispose() {
		logger.debug(bundleMarker,"dispose entered");
		tableViewer.removeSelectionChangedListener(selectionController);
		selectionController.close();
		getSite().getPage().removePartListener(selectionController);
		getSite().getPage().removeSelectionListener(selectionController);
		super.dispose();
	}
	 
	 /**
	  * @return a collection of ViewerFilters
	  */
	 @Override
	 protected Collection<ViewerFilter> getViewerFilters(){
		 return ViewsPlugin.plugin.getViewerFilters(TrackerPackage.Literals.EVENT);
	 }
}
