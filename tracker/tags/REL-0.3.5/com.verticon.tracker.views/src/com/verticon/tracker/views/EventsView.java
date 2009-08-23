package com.verticon.tracker.views;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;

public class EventsView extends TrackerView implements ItemsView{

	private static final String NAME_OF_ITEM_IN_MASTER = "Event";

	private ISelectionController eventSelectionController;
	
	
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
		Premises premises = getPremises(eventSelectionController.getEditingDomain());
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
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	public void handleViewerInputChange() {
		Premises premises = getPremises(eventSelectionController.getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
		enableMenus(premises!=null);
	}
	

	/**
	 * Override super to add an AnimalSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		super.createPartControl(base);
		eventSelectionController = new SelectionController(
				this, new EventsStrategy(this));
		eventSelectionController.open();
		getSite().getPage().addSelectionListener(eventSelectionController);
		getSite().getPage().addPartListener(eventSelectionController);
		tableViewer.addSelectionChangedListener(eventSelectionController);
		handleViewerInputChange();
	}

	/**
	 * Override super to remove the listeners and close the AnimalSelectionController
	 */
	 @Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(eventSelectionController);
		eventSelectionController.close();
		getSite().getPage().removePartListener(eventSelectionController);
		getSite().getPage().removeSelectionListener(eventSelectionController);
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
