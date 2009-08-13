package com.verticon.tracker.editor.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Animal;
import com.verticon.tracker.TrackerFactory;

public class ChangeAnimalTypeSelectTypeWizardPage extends WizardPage
		implements ISelectionChangedListener {

	private Animal selectedAnimalType = null;
	private TableViewer tableViewer;
	private Composite child = null;
	private List<Animal> model = new ArrayList<Animal>();

	private final AdapterFactory adapterFactory;

	public ChangeAnimalTypeSelectTypeWizardPage(
			AdapterFactory adapterFactory) {
		super("selectAnimal");
		this.adapterFactory = adapterFactory;
		setTitle("Select Animal Type");
		setDescription("Select the new Animal Type you wish to change the selected animals to.");
		
		model.add(TrackerFactory.eINSTANCE.createBovineBeef());
		model.add(TrackerFactory.eINSTANCE.createBovineBison());
		model.add(TrackerFactory.eINSTANCE.createBovineDairy());
		model.add(TrackerFactory.eINSTANCE.createCaprine());
		model.add(TrackerFactory.eINSTANCE.createEquine());
		model.add(TrackerFactory.eINSTANCE.createOvine());
		model.add(TrackerFactory.eINSTANCE.createSwine());
		
	}

	
	public void createControl(Composite parent) {
		child = new Composite(parent, SWT.NULL);
		child.setLayout(new FillLayout(SWT.VERTICAL));

		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		Composite tableComposite = new Composite(container, SWT.NONE);
		tableViewer = createSingleColumnTableViewer(tableComposite);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 300;
		data.widthHint = 300;
		tableComposite.setLayoutData(data);
		tableViewer.addSelectionChangedListener(this);

		setControl(child);
	}

	public Animal getSelectedAnimal() {
		return selectedAnimalType;
	}

	public void setSelectedPerson(Animal selectedPerson) {
		this.selectedAnimalType = selectedPerson;
	}

	
	public void selectionChanged(SelectionChangedEvent event) {
		updatePageComplete();
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			selectedAnimalType = null;
			tableViewer.setInput("");
			tableViewer.refresh();
			tableViewer.setSelection(null);
			setPageComplete(false);
		}
		super.setVisible(visible);
	}

	private TableViewer createSingleColumnTableViewer(Composite tableComposite) {
		
		final TableViewer v = new TableViewer(tableComposite);
		 v.getTable().setLinesVisible(true);

		 TableColumn singleColumn = new TableColumn(v.getTable(), SWT.NONE);
		 TableColumnLayout tableColumnLayout = new TableColumnLayout();
		 tableColumnLayout.setColumnData(singleColumn, new ColumnWeightData(100));
		 tableComposite.setLayout(tableColumnLayout);
		
		v.setUseHashlookup(true);

		v.setContentProvider(new IStructuredContentProvider() {
			

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				return model.toArray();
			}

		});

		v.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		
		return v;

	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (tableViewer.getSelection() == null) {
			setMessage(null);
			setErrorMessage("Please select an Animal Type from the list");
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();
		selectedAnimalType = (Animal) selection.getFirstElement();

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

}
