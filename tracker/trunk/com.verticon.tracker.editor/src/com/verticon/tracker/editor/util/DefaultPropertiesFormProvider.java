package com.verticon.tracker.editor.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates databinding based forms for a selection of EObjects.
 * 
 * @author jconlon
 * 
 */
public class DefaultPropertiesFormProvider implements IPropertiesFormProvider {
	public String FILTER_ID_EXPERT = "org.eclipse.ui.views.properties.expert"; //$NON-NLS-1$

	private IObservableValue statusMessageObservable;

	public void setStatusMessageObservable(
			IObservableValue statusMessageObservable) {
		this.statusMessageObservable = statusMessageObservable;
	}

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultPropertiesFormProvider.class);

	public DefaultPropertiesFormProvider() {
		super();
		logger.debug("Constructed");
	}

	private CTabItem item1;
	private WizardPage wizardPage = null;

	/**
	 * Use the selection to create a Form in the cTabFolder.
	 * 
	 */
	public void fillProperties(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder,
			String nameOfTab, boolean showAdvanceProperties) {
		logger.debug("filling properties");
		if (item1 != null) {
			logger.debug("Desposing of CTabItem");
			item1.dispose();
			item1 = null;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			item1 = new CTabItem(cTabFolder, SWT.NONE);
			item1.setText(nameOfTab);
			// Create a composite with a two column layout
			Composite composite1 = new Composite(cTabFolder, SWT.NONE);
			composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			item1.setControl(composite1);
			{
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				data.horizontalAlignment = SWT.END;
				composite1.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				layout.numColumns = 2;
				composite1.setLayout(layout);
			}
			handleSelection(structuredSelection, adapterFactory, composite1,
					showAdvanceProperties);
			cTabFolder.setSelection(item1);
		} else {
			createEmptyCTabItem(cTabFolder, nameOfTab);
		}
	}

	/**
	 * @param cTabFolder
	 * @param nameOfTab
	 *            TODO
	 */
	protected Composite createEmptyCTabItem(CTabFolder cTabFolder,
			String nameOfTab) {

		item1 = new CTabItem(cTabFolder, SWT.NONE);
		item1.setText(nameOfTab);
		// Create a composite with a two column layout
		Composite composite1 = new Composite(cTabFolder, SWT.NONE);
		composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		item1.setControl(composite1);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.END;
			composite1.setLayoutData(data);

			GridLayout layout = new GridLayout();
			// GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			composite1.setLayout(layout);
		}

		cTabFolder.setSelection(item1);
		return composite1;
	}

	/**
	 * Default only handles the first object selected.
	 * 
	 * @param structuredSelection
	 * @param adapterFactory
	 * @param composite1
	 */
	protected void handleSelection(IStructuredSelection structuredSelection,
			AdapterFactory adapterFactory, Composite composite1,
			boolean showAdvanceProperties) {
		// Only deal with an IStructuredSelection
		if (structuredSelection.size() == 1) {
			Object object = structuredSelection.getFirstElement();
			createForm(composite1, object, adapterFactory,
					showAdvanceProperties);
		}
	}

	/**
	 * @param parent
	 * @param object
	 */
	protected void createForm(Composite parent, Object object,
			AdapterFactory adapterFactory, boolean showAdvanceProperties) {
		Map<String, Group> mp = new HashMap<String, Group>();

		IItemPropertySource itemPropertySource = (IItemPropertySource) adapterFactory
				.adapt(object, IItemPropertySource.class);
		// Create the databinding context
		DataBindingContext dataBindingContext = new EMFDataBindingContext();
		if (wizardPage != null) {
			WizardPageSupport.create(wizardPage, dataBindingContext);
		}

		// IItemProperySource is already set
		// get all the IItemPropertyDescriptors for the object
		for (IItemPropertyDescriptor itemPropertyDescriptor : itemPropertySource
				.getPropertyDescriptors(object)) {
			boolean filterProperty = false;
			if (!showAdvanceProperties) {
				String[] filters = itemPropertyDescriptor
						.getFilterFlags(object);
				if (filters != null) {
					for (String filter : filters) {
						if (filter.equals(this.FILTER_ID_EXPERT)) {
							filterProperty = true;
							//logger.debug("Filtering Property {} has filter {}"
							// ,
							// itemPropertyDescriptor
							// .getDisplayName(object), filter);
						}
						// else {
						// logger.debug(
						// "Not Filtering Property {} has filter {}",
						// itemPropertyDescriptor
						// .getDisplayName(object), filter);
						// }
					}
				}
			}
			if (filterProperty) {
				continue;
			}
			// Create a label with the name of the property
			logger.debug("Creating label for property {} with filter {}",
					itemPropertyDescriptor.getDisplayName(object),
					itemPropertyDescriptor.getFilterFlags(object));
			String categoryName = itemPropertyDescriptor.getCategory(object);
			if (categoryName == null) {
				categoryName = itemPropertyDescriptor.getDescription(object);
			}
			if (!mp.containsKey(categoryName)) {
				Group group = new Group(parent, SWT.BORDER);
				group.setText(categoryName);
				GridLayout layout = new GridLayout();
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				group.setLayout(layout);
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				group.setLayoutData(data);

				mp.put(categoryName, group);
			}

			Label label = new Label(mp.get(categoryName), SWT.NONE);
			label.setForeground(parent.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			label.setBackground(parent.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			label.setText(itemPropertyDescriptor.getDisplayName(object));
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				label.setLayoutData(gridData);
				label.setToolTipText(itemPropertyDescriptor
						.getDescription(object));
			}

			visualize(object, mp, dataBindingContext, itemPropertyDescriptor,
					categoryName, adapterFactory);

		}

		if (statusMessageObservable != null) {
			dataBindingContext
					.bindValue(statusMessageObservable,
							new AggregateValidationStatus(dataBindingContext
									.getBindings(),
									AggregateValidationStatus.MAX_SEVERITY),
							null, null);
		}

	}

	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param itemPropertyDescriptor
	 * @param categoryName
	 */
	private void visualize(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor,
			String categoryName, AdapterFactory adapterFactory) {

		ControlBuilder builder = ControlBuilderFactory.getInstance(object,
				itemPropertyDescriptor);
		builder.createControl(object, mp.get(categoryName),
				itemPropertyDescriptor, adapterFactory, dataBindingContext);

	}

	public WizardPage getWizardPage() {
		return wizardPage;
	}

	public void setWizardPage(WizardPage wizardPage) {
		this.wizardPage = wizardPage;
	}

}
