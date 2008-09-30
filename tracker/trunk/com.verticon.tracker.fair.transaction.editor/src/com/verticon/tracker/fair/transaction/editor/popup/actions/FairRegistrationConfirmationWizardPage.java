package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.DefaultPropertiesFormProvider;
import com.verticon.tracker.editor.util.IPropertiesFormProvider;

/**
 * Shows a list of the selected animals with an option of editing their
 * attributes.
 * 
 * @author jconlon
 * 
 */
public class FairRegistrationConfirmationWizardPage extends WizardPage
		implements ISelectionChangedListener {

	private ListViewer listViewer;
	private IPropertiesFormProvider defaultPropertiesFormProvider;
	protected CTabFolder cTabFolder;
	private Composite child = null;
	private Text personText = null;
	private Text lotText = null;

	private final AdapterFactory adapterFactory;

	protected FairRegistrationConfirmationWizardPage(
			AdapterFactory adapterFactory) {
		super("confirmRegistration");
		this.adapterFactory = adapterFactory;
		setTitle("ConfirmRegistration");
		setDescription("Confirm registration of person exhibiting animals.");
	}

	public void createControl(Composite parent) {
		child = new Composite(parent, SWT.NULL);
		child.setLayout(new FillLayout(SWT.VERTICAL));

		// Container houses the global buttons and labels
		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		listViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);

		personText=createPersonUI(container);

		lotText = createLotUI(container);

		
		cTabFolder = new CTabFolder(child, SWT.LEFT);
		cTabFolder.setForeground(child.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		cTabFolder.setBackground(child.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));

		setControl(child);

	}

	public void selectionChanged(SelectionChangedEvent event) {
		// Remove all the tabs in the TabFolder
		for (CTabItem item : cTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(event.getSelection(), adapterFactory, cTabFolder);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			listViewer.setInput("");
			listViewer.refresh();
			listViewer.setSelection(null);
			personText.setText(((FairRegistrationWizard)getWizard()).getSelectedPerson().getName());
			lotText.setText(((FairRegistrationWizard)getWizard()).getSelectedLot().getName());
			

		}
		super.setVisible(visible);
	}
	
	

	/**
	 * @param container
	 */
	private Text createPersonUI(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		label.setText("Person: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		Text personText = new Text(container, SWT.SINGLE | SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		personText.setLayoutData(gridData);
		return personText;
	}

	/**
	 * @param container
	 */
	private Text createLotUI(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		label.setText("Lot: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		Text lotText = new Text(container, SWT.SINGLE | SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		lotText.setLayoutData(gridData);
		return lotText;
	}

	protected ListViewer createViewer(Composite parent) {
		ListViewer viewer = new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);

		viewer.setContentProvider(new IStructuredContentProvider() {
			List<Animal> model = new ArrayList<Animal>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(((FairRegistrationWizard) getWizard())
							.getAnimalsToRegister());
				}
				return model.toArray();
			}

		});

		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Animal) element).getId();
			}

		});
		return viewer;

	}


	/**
	 * @param selection
	 * @return
	 */
	protected void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		// Only deal with an IStructuredSelection

		if (defaultPropertiesFormProvider == null) {
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
			defaultPropertiesFormProvider.setWizardPage(this);
		}

		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, "Animal Details");
		setControl(child);
		return;

	}

}
