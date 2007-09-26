/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.ActionUtils;

/**
 * WizardPage for selecting an Event type. 
 * 	
 * 
 * @see AddAnimalsToPremisesWizard
 * @see SelectAnimalWizardPage
 * @author jconlon
 * @since 0.2
 *
 */
public class SelectEventWizardPage extends WizardPage implements ISelectionChangedListener {

	private ListViewer listViewer;
	
	protected SelectEventWizardPage() {
		super("selectEvent");
		setTitle("Select Event");
		setDescription("Select the Event to add.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		
		
		listViewer=createViewer( container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace=true;
		data.grabExcessVerticalSpace=true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
        listViewer.addSelectionChangedListener(this);
		setControl(container);
	}
	
	
	
	protected ListViewer createViewer(Composite parent) {
		ListViewer viewer =
			new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);
		
		viewer.setContentProvider(new IStructuredContentProvider() {
			List<String> model = new ArrayList<String>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(ActionUtils.getModelInstances(TrackerPackage.eINSTANCE
							.getEvent()));
				}
				return model.toArray();
			}

		});
		viewer.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {

				return (String) element;
			}

		});
		return viewer;
	}
	

	
	public Event getEvent(){
		if (listViewer.getSelection() == null ) {
	         return null;
	     }
		IStructuredSelection selection =(IStructuredSelection) listViewer.getSelection();
		String eventName =(String) selection.getFirstElement();
		if(eventName==null){
			return null;
		}
		EClass eClass = (EClass) TrackerPackage.eINSTANCE.getEClassifier(eventName);
		return (Event) TrackerFactory.eINSTANCE.create(eClass);
		
	}



	 /**
	    * Update the current page complete state
	    * based on the field content.
	    */
	   private void updatePageComplete() {
	      setPageComplete(false);

	      if (listViewer.getSelection() == null ) {
	         setMessage(null);
	         setErrorMessage("Please select an Event");
	         return;
	      }

	      setPageComplete(true);

	      
	      setErrorMessage(null);
	      setMessage(null);
	         return;
	      
	   }

	public void selectionChanged(SelectionChangedEvent event) {
		updatePageComplete();
	}
	
	@Override
	public void setVisible(boolean visible) {
		if(visible){
			listViewer.setInput("dontcare");
			listViewer.refresh();
		}
		super.setVisible(visible);
	}
}
