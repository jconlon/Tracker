package com.verticon.tracker.store.ui.wizards;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.InvalidSyntaxException;

import com.google.common.collect.Iterables;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.ui.Activator;

/**
 * 
 * @author jconlon
 * 
 */
public class SelectTrackerStorePage extends WizardPage {

	private ListViewer listViewer;

	protected SelectTrackerStorePage() {
		super("Select TrackerStore");
		setTitle("Select TrackerStore URI");
		setDescription("Select the TrackerStore for importing an Animal");

	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);

		LabelProvider lp = new LabelProvider() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				ITrackerStore trackerStore = (ITrackerStore) element;
				return trackerStore.uri();
			}

		};

		listViewer = new ListViewer(container, SWT.SINGLE | SWT.BORDER);
		listViewer.setLabelProvider(lp);
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				ITrackerStore trackerStore = (ITrackerStore) selection
						.getFirstElement();
				if (getWizard() instanceof ImportAnimalWizard) {
					((ImportAnimalWizard) getWizard())
							.setTrackerStore(trackerStore);
				} else if (getWizard() instanceof ImportPremisesWizard) {
					((ImportPremisesWizard) getWizard())
							.setTrackerStore(trackerStore);
				}
				if (trackerStore == null) {
					setPageComplete(false);
				} else {
					setPageComplete(true);
				}

			}
		});

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		listViewer.getControl().setLayoutData(gridData);
		try {
			initContents();
		} catch (Exception e) {
			setErrorMessage(e.getMessage());
		}
	}

	private void initContents() throws StoreAccessException,
			InvalidSyntaxException {
		setPageComplete(false);
		listViewer.setInput(Iterables.toArray(Activator.getDefault()
				.getAvailableTrackerStores(), ITrackerStore.class));
	}


}
