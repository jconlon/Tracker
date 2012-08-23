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
package com.verticon.tracker.editor.internal.presentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.internal.databinding.swt.SWTObservableValueDecorator;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.EventInclusion;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.Policy;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.EventInclusionItemProvider;
import com.verticon.tracker.edit.provider.GenericEventInclusionItemProvider;
import com.verticon.tracker.edit.provider.PolicyItemProvider;
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.util.MultiValueEReferencControlBuilder;
import com.verticon.tracker.util.TrackerUtils;

/**
 * Premises element details as a form page on the Premises editor tab.
 * 
 * @author jconlon
 * 
 */
@SuppressWarnings("restriction")
public class PolicyFormPage extends FormPage implements IValueChangeListener {
	private static final String DESCRIPTION = "Policy is an optional element of the Premises document. Policy restricts the premises to a specific set of animals and events";
	private static final String FORM_TITLE = "Policy";
	private ManagedForm managedForm;
	private final IPremisesProvider premisesProvider;
	private Image componentImage;
	private ObservablesManager observablesManager = new ObservablesManager();
	private DataBindingContext ctx;
	private AggregateValidationStatus aggregateStatus;
	private UpdatingViewerSelectionListener updatingViewerSelectionListener = new UpdatingViewerSelectionListener();
	private Button deleteButton;
	private Button editButton;

	public PolicyFormPage(IPremisesProvider premisesProvider) {
		super("policy", "Policy");
		this.premisesProvider = premisesProvider;
	}

	@Override
	public void createPartControl(Composite parent) {
		managedForm = new ManagedForm(parent);

		BusyIndicator.showWhile(parent.getDisplay(), new Runnable() {
			public void run() {
				createFormContent(managedForm);
			}
		});
	}

	protected void createFormContent(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText(FORM_TITLE);
		form.setToolTipText(DESCRIPTION);

		final FormToolkit toolkit = managedForm.getToolkit();
		addHeadingGradient(toolkit, form, true);

		toolkit.decorateFormHeading(form.getForm());
		form.getForm().addMessageHyperlinkListener(new HyperlinkAdapter());

		componentImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				"com.verticon.tracker.edit", "/icons/full/obj16/Premises.gif")
				.createImage();
		form.setImage(componentImage);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 6;
		layout.horizontalSpacing = 20;
		form.getBody().setLayout(layout);

		ctx = new EMFDataBindingContext();
		final IMessageManager immng = managedForm.getMessageManager();

		addStatusSupport(observablesManager, ctx);
		observablesManager.runAndCollect(new Runnable() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				createPolicySection(form, toolkit, immng);
			}
		});

	}

	/**
	 * Creates 3 sections and a listener on the Premises Policy model value.
	 * When the policy element is present the widgets are enabled, when it is
	 * null the widgets are disable. On either change the viewer inputs are
	 * reset.
	 * 
	 * @param form
	 * @param toolkit
	 * @param immng
	 */
	private void createPolicySection(final ScrolledForm form,
			final FormToolkit toolkit, IMessageManager immng) {
		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Policy");
		section.setDescription(DESCRIPTION);
		section.marginWidth = 10;
		section.marginHeight = 5;
		toolkit.createCompositeSeparator(section);

		GridData gd = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.horizontalSpacing = 10;
		layout.marginHeight = 0;
		layout.numColumns = 1;
		section.setLayout(layout);

		// Build a sectionClient
		final Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(2, false));
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);

		// Instead of use this premisesProvider.getEditingDomain();
		final AdapterFactoryEditingDomain ed = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(premisesProvider.getPremises());

		createIncludedSpeciesControl(toolkit, sectionClient, ed);
		createExcludeUnspecifiedEventsControl(toolkit, sectionClient, ed);
		createIncludedEventsControl(toolkit, sectionClient, ed);

	}

	/**
	 * Create the Policy IncludedEvents control as a table of InclusionEvents
	 * and GenericInclusionEvents.
	 * 
	 * For the InclusionEvents, attribute values in the two columns are
	 * multivalue attributes. The first column is a list of Events, the second
	 * is a list of species. For the GenericEvents, attribute values in the
	 * first column is a single OCD name for the GenericEvent, the second column
	 * is a list of species.
	 * 
	 * Anonymous ColumnLabelProviders are used.
	 * 
	 * Viewer input is premisesProvider.getPremises().getPolicy() and the
	 * contentProvider is an AdapterFactoryContentProvider. The viewer will
	 * reset its input by listening to a IObservableValue premisesPolicyValue.
	 * 
	 * The edit button will edit a selected row bringing up a mulivalue
	 * properties chooser for each of the two columns.
	 * 
	 * @param toolkit
	 * @param sectionClient
	 * @param ed
	 */
	private void createIncludedEventsControl(final FormToolkit toolkit,
			final Composite sectionClient, final AdapterFactoryEditingDomain ed) {

		Group group = new Group(sectionClient, SWT.NONE);
		group.setText("Included Events");
		group.setToolTipText("Associating specific Animal species with Event types will restrict the use of those event types to the associated species only.  Other other species can not use those events types.");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING,
				true, false);
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);

		final AdapterFactory adapterFactory = ed.getAdapterFactory();

		Button addButton = new Button(group, SWT.PUSH);
		addButton.setText("Add");
		addButton
				.setToolTipText("Add a new EventInclusion to the list of Included Events");
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		addButton.setLayoutData(gridData);
		addButton.addSelectionListener(updatingViewerSelectionListener);

		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.verticalAlignment = GridData.FILL;
		gridData.verticalSpan = 6;
		table.setLayoutData(gridData);
		final TableViewer viewer = new TableViewer(table);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// if the selection is empty clear the label
				if (event.getSelection().isEmpty()) {
					enableIncludedEventsEditAddButtons(false);
				} else {
					enableIncludedEventsEditAddButtons(true);
				}
			}
		});

		IObservableValue premisesPolicyValue = EMFEditProperties.value(ed,
				FeaturePath.fromList(TrackerPackage.Literals.PREMISES__POLICY))
				.observe(premisesProvider.getPremises());
		premisesPolicyValue.addValueChangeListener(new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				viewer.setInput(premisesProvider.getPremises().getPolicy());
			}
		});
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Events");
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof EventInclusion) {
					EventInclusion p = (EventInclusion) element;
					String list = p.getEvent().toString();
					return list.substring(1, list.length() - 1);
				} else if (element instanceof GenericEventInclusion) {
					GenericEventInclusion genericEvent = (GenericEventInclusion) element;
					return genericEvent.getOcd() == null ? "" : genericEvent
							.getOcd().getName();
				}
				return element.toString();
			}
		});

		col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Species");
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof EventInclusion) {
					EventInclusion p = (EventInclusion) element;
					String list = p.getSpecies().toString();
					return list.substring(1, list.length() - 1);
				} else if (element instanceof GenericEventInclusion) {
					GenericEventInclusion p = (GenericEventInclusion) element;
					String list = p.getSpecies().toString();
					return list.substring(1, list.length() - 1);
				}
				return element.toString();
			}
		});

		viewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		viewer.setInput(premisesProvider.getPremises().getPolicy());

		// set listener on add button
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (premisesProvider.getPremises().getPolicy() == null) {
					return;
				}
				// Are there any generic events in the premises
				EcoreUtil.resolveAll(premisesProvider.getPremises());
				List<OCD> ocds = TrackerUtils.findOCDs(premisesProvider
						.getPremises());
				int result = 1;
				if (!ocds.isEmpty()) {
					MessageDialog dialog = new MessageDialog(sectionClient
							.getShell(), "Add Included Event", null,
							"What type of event would you like to add?",
							MessageDialog.QUESTION, new String[] { "Standard",
									"Generic" }, 0);
					result = dialog.open();

				}
				switch (result) {
				case 0:
					// Choice dialog for Standard or Generic Event
					// Add an eventInclusion
					ed.getCommandStack()
							.execute(
									AddCommand
											.create(ed,
													premisesProvider
															.getPremises()
															.getPolicy(), // owner
													TrackerPackage.Literals.POLICY__INCLUDED_EVENTS,
													TrackerFactory.eINSTANCE
															.createEventInclusion()));

					break;
				case 1:
					// Choice dialog for Standard or Generic Event
					// Add an eventInclusion
					ed.getCommandStack()
							.execute(
									AddCommand
											.create(ed,
													premisesProvider
															.getPremises()
															.getPolicy(), // owner
													TrackerPackage.Literals.POLICY__INCLUDED_GENERIC_EVENTS,
													TrackerFactory.eINSTANCE
															.createGenericEventInclusion()));

					break;

				default:
					break;
				}
			}
		}

		);

		deleteButton = new Button(group, SWT.PUSH);
		deleteButton.setText("Delete");
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		deleteButton.setLayoutData(gridData);
		deleteButton
				.setToolTipText("Deleted the selected EventInclusion from the list of Included Events");
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (viewer.getSelection() == null) {
					return;
				}
				StructuredSelection selection = (StructuredSelection) viewer
						.getSelection();
				ed.getCommandStack().execute(
						DeleteCommand.create(ed, selection.getFirstElement()));
			}
		});
		deleteButton.setEnabled(false);

		editButton = new Button(group, SWT.PUSH);
		editButton.setText("Edit");
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		editButton.setLayoutData(gridData);
		editButton
				.setToolTipText("Edit the animal species and event types on the selected EventInclusion");
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (viewer.getSelection() == null) {
					return;
				}
				StructuredSelection selection = (StructuredSelection) viewer
						.getSelection();

				if (selection.getFirstElement() instanceof EventInclusion) {
					editEventInclustion(sectionClient, ed, adapterFactory,
							(EventInclusion) selection.getFirstElement());
				} else if (selection.getFirstElement() instanceof GenericEventInclusion) {
					editGenericEventInclustion(sectionClient, ed,
							adapterFactory,
							(GenericEventInclusion) selection.getFirstElement());
				}
			}

		});
		editButton.setEnabled(false);

	}

	private void enableIncludedEventsEditAddButtons(boolean enabled) {
		editButton.setEnabled(enabled);
		deleteButton.setEnabled(enabled);
	}

	/**
	 * Uses two multi-value properties editors to edit the EventInclusion.
	 * 
	 * @param sectionClient
	 * @param ed
	 * @param adapterFactory
	 * @param eventInclusion
	 */
	private void editEventInclustion(final Composite sectionClient,
			final AdapterFactoryEditingDomain ed,
			final AdapterFactory adapterFactory, EventInclusion eventInclusion) {

		final EventInclusionItemProvider itemProvider = new EventInclusionItemProvider(
				adapterFactory);

		// Get the events
		EStructuralFeature eStructuralFeature = TrackerPackage.eINSTANCE
				.getEventInclusion_Event();

		IItemPropertyDescriptor itemPropertyDescriptor = itemProvider
				.getPropertyDescriptor(eventInclusion, eStructuralFeature);
		List<Object> choiceOfValues = new ArrayList<Object>(
				itemPropertyDescriptor.getChoiceOfValues(eventInclusion));
		ILabelProvider labelProvider = MultiValueEReferencControlBuilder
				.getLabelProvider(itemPropertyDescriptor, eventInclusion);
		List<?> currentValues = (List<?>) eventInclusion
				.eGet(eStructuralFeature);
		EList<?> results = createDialog(eventInclusion,
				sectionClient.getShell(), choiceOfValues, labelProvider,
				currentValues, "Choose events");

		if (results != null && results.equals(currentValues)) {
			// logger.debug(bundleMarker,"Values are equal");
		} else {
			ed.getCommandStack().execute(
					SetCommand.create(ed, eventInclusion, eStructuralFeature,
							results));
		}

		// Get the species
		eStructuralFeature = TrackerPackage.eINSTANCE
				.getEventInclusion_Species();
		itemPropertyDescriptor = itemProvider.getPropertyDescriptor(
				eventInclusion, eStructuralFeature);
		choiceOfValues = new ArrayList<Object>(
				itemPropertyDescriptor.getChoiceOfValues(eventInclusion));
		labelProvider = MultiValueEReferencControlBuilder.getLabelProvider(
				itemPropertyDescriptor, eventInclusion);
		currentValues = (List<?>) eventInclusion.eGet(eStructuralFeature);
		results = createDialog(eventInclusion, sectionClient.getShell(),
				choiceOfValues, labelProvider, currentValues, "Choose species");

		if (results != null && results.equals(currentValues)) {
			// logger.debug(bundleMarker,"Values are equal");
		} else {
			ed.getCommandStack().execute(
					SetCommand.create(ed, eventInclusion, eStructuralFeature,
							results));
		}
	}

	/**
	 * Uses a custom Dialog and a multi-value property editor to edit the
	 * GenericEventInclusion
	 * 
	 * @param sectionClient
	 * @param ed
	 * @param adapterFactory
	 * @param eventInclusion
	 */
	private void editGenericEventInclustion(final Composite sectionClient,
			final AdapterFactoryEditingDomain ed,
			final AdapterFactory adapterFactory,
			GenericEventInclusion eventInclusion) {

		final GenericEventInclusionItemProvider itemProvider = new GenericEventInclusionItemProvider(
				adapterFactory);

		// Get the events
		EStructuralFeature eStructuralFeature = TrackerPackage.eINSTANCE
				.getGenericEventInclusion_Ocd();

		IItemPropertyDescriptor itemPropertyDescriptor = itemProvider
				.getPropertyDescriptor(eventInclusion, eStructuralFeature);
		List<Object> choiceOfValues = new ArrayList<Object>(
				itemPropertyDescriptor.getChoiceOfValues(eventInclusion));

		ILabelProvider labelProvider = MultiValueEReferencControlBuilder
				.getLabelProvider(itemPropertyDescriptor, eventInclusion);

		createOCDEditingDialog(eventInclusion, sectionClient.getShell(), ed);

		// Get the species
		eStructuralFeature = TrackerPackage.eINSTANCE
				.getGenericEventInclusion_Species();
		itemPropertyDescriptor = itemProvider.getPropertyDescriptor(
				eventInclusion, eStructuralFeature);
		choiceOfValues = new ArrayList<Object>(
				itemPropertyDescriptor.getChoiceOfValues(eventInclusion));
		labelProvider = MultiValueEReferencControlBuilder.getLabelProvider(
				itemPropertyDescriptor, eventInclusion);
		List<?> currentValues = (List<?>) eventInclusion
				.eGet(eStructuralFeature);
		List<?> results = createDialog(eventInclusion,
				sectionClient.getShell(), choiceOfValues, labelProvider,
				currentValues, "Choose species");

		if (results != null && results.equals(currentValues)) {
			// logger.debug(bundleMarker,"Values are equal");
		} else {
			ed.getCommandStack().execute(
					SetCommand.create(ed, eventInclusion, eStructuralFeature,
							results));
		}
	}

	private void createOCDEditingDialog(
			GenericEventInclusion genericEventInclusion, Shell shell,
			EditingDomain ed) {
		TitleAreaDialog dialog = new GenericEventEditingDialog(shell, ed,
				genericEventInclusion);
		dialog.open();
	}

	private void createIncludedSpeciesControl(final FormToolkit toolkit,
			final Composite sectionClient, final AdapterFactoryEditingDomain ed) {
		Group group = new Group(sectionClient, SWT.NONE);
		group.setText("Included Species");
		group.setToolTipText("Only Animal species in this list are allowed in the premises. If this list is blank all animal species are allowed.");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING,
				true, false);
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);

		Button editIncludedSpeciesButton = new Button(group, SWT.PUSH);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		editIncludedSpeciesButton.setLayoutData(gridData);
		editIncludedSpeciesButton.setText("  Edit  ");
		editIncludedSpeciesButton
				.setToolTipText("Edit the list of animal species that are allowed into the premises.");

		AdapterFactory adapterFactory = ed.getAdapterFactory();
		final PolicyItemProvider policyProvider = new PolicyItemProvider(
				adapterFactory);

		editIncludedSpeciesButton
				.setToolTipText("Edit list of included Animal species");

		editIncludedSpeciesButton
				.addSelectionListener(updatingViewerSelectionListener);

		editIncludedSpeciesButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Policy eObject = premisesProvider.getPremises().getPolicy();
				if (eObject == null) {
					return;// for now
				}
				EStructuralFeature eStructuralFeature = TrackerPackage.eINSTANCE
						.getPolicy_IncludedSpecies();
				IItemPropertyDescriptor itemPropertyDescriptor = policyProvider
						.getPropertyDescriptor(eObject, eStructuralFeature);
				List<Object> choiceOfValues = new ArrayList<Object>(
						itemPropertyDescriptor.getChoiceOfValues(eObject));
				ILabelProvider labelProvider = MultiValueEReferencControlBuilder
						.getLabelProvider(itemPropertyDescriptor, eObject);
				List<?> currentValues = (List<?>) eObject
						.eGet(eStructuralFeature);
				// Call the dialog
				EList<?> results = createDialog(eObject,
						sectionClient.getShell(), choiceOfValues,
						labelProvider, currentValues, "Choose species");

				if (results != null && results.equals(currentValues)) {
					// logger.debug(bundleMarker,"Values are equal");
				} else {
					ed.getCommandStack().execute(
							SetCommand.create(ed, eObject, eStructuralFeature,
									results));
				}
			}
		});

		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);

		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.verticalSpan = 6;
		table.setLayoutData(gridData);

		TableViewer viewer = new TableViewer(table);
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		viewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return element.toString();
			}
		});
		viewer.setContentProvider(cp);
		IEMFListProperty includedSpecies = EMFEditProperties.list(ed,
				FeaturePath.fromList(TrackerPackage.Literals.PREMISES__POLICY,
						TrackerPackage.Literals.POLICY__INCLUDED_SPECIES));
		IObservableList includedSpecies_Premises = includedSpecies
				.observe(premisesProvider.getPremises());
		viewer.setInput(includedSpecies_Premises);
	}

	private void createExcludeUnspecifiedEventsControl(
			final FormToolkit toolkit, final Composite sectionClient,
			final AdapterFactoryEditingDomain ed) {

		// Space
		Label l = toolkit.createLabel(sectionClient, "");
		l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 4, 1));
		// Exclude unspecified events
		// /policy/excludeUnspecifiedEvents
		IEMFEditValueProperty unspecifiedEvents = EMFEditProperties
				.value(ed,
						FeaturePath
								.fromList(
										TrackerPackage.Literals.PREMISES__POLICY,
										TrackerPackage.Literals.POLICY__EXCLUDE_UNSPECIFIED_EVENTS));
		l = toolkit.createLabel(sectionClient, "&Exclude Unspecified Events");
		l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 1, 1));
		l.setToolTipText("Restricts events to those that are explicitly specified in the following 'Included Events' list");

		final Button excludeUnspecifiedEventsButton = new Button(sectionClient,
				SWT.CHECK);
		excludeUnspecifiedEventsButton.setLayoutData(new GridData(SWT.LEFT,
				SWT.DEFAULT, false, false, 1, 1));
		new Label(sectionClient, SWT.NONE).setText("");
		new Label(sectionClient, SWT.NONE).setText("");
		IObservableValue unspecifiedEventsValue = unspecifiedEvents
				.observe(premisesProvider.getPremises());

		excludeUnspecifiedEventsButton
				.addSelectionListener(updatingViewerSelectionListener);

		IWidgetValueProperty prop = WidgetProperties.selection();

		ctx.bindValue(prop.observeDelayed(400, excludeUnspecifiedEventsButton),
				unspecifiedEventsValue, null,// new
												// UpdateValueStrategy().setBeforeSetValidator(new
												// PremisesHasPolicyValidator()),//
												// targetToModel,//target to
												// model
				null // modelToTarget
		);

	}

	private static EList<?> createDialog(EObject eObject, Shell shell,
			List<?> choiceOfValues, ILabelProvider labelProvider,
			List<?> currentValues, String message) {

		FeatureEditorDialog dialog = new FeatureEditorDialog(shell,
				labelProvider, eObject, TrackerPackage.eINSTANCE.getPolicy(),
				currentValues, message, choiceOfValues, true, true, true);

		dialog.open();

		return dialog.getResult();
	}

	/**
	 * Note: this is not immediately called when the application exits. This
	 * causes issues with handling events. See Ticket#579
	 */
	@Override
	public void dispose() {
		aggregateStatus.removeValueChangeListener(this);
		componentImage.dispose();
		if (observablesManager != null) {
			observablesManager.dispose();
		}
		if (ctx != null) {
			ctx.dispose();
		}
		super.dispose();
	}

	private void addHeadingGradient(FormToolkit toolkit, ScrolledForm form,
			boolean add) {
		FormColors colors = toolkit.getColors();
		Color top = colors.getColor(IFormColors.H_GRADIENT_END);
		Color bot = colors.getColor(IFormColors.H_GRADIENT_START);
		if (add)
			form.getForm().setTextBackground(new Color[] { top, bot },
					new int[] { 100 }, true);
		else {
			form.getForm().setTextBackground(null, null, false);
			form.getForm().setBackground(colors.getBackground());
		}
		form.getForm().setHeadColor(IFormColors.H_BOTTOM_KEYLINE1,
				add ? colors.getColor(IFormColors.H_BOTTOM_KEYLINE1) : null);
		form.getForm().setHeadColor(IFormColors.H_BOTTOM_KEYLINE2,
				add ? colors.getColor(IFormColors.H_BOTTOM_KEYLINE2) : null);
		form.getForm().setHeadColor(IFormColors.H_HOVER_LIGHT,
				add ? colors.getColor(IFormColors.H_HOVER_LIGHT) : null);
		form.getForm().setHeadColor(IFormColors.H_HOVER_FULL,
				add ? colors.getColor(IFormColors.H_HOVER_FULL) : null);
		form.getForm().setHeadColor(IFormColors.TB_TOGGLE,
				add ? colors.getColor(IFormColors.TB_TOGGLE) : null);
		form.getForm().setHeadColor(IFormColors.TB_TOGGLE_HOVER,
				add ? colors.getColor(IFormColors.TB_TOGGLE_HOVER) : null);
		form.getForm().setSeparatorVisible(add);
		form.reflow(true);
		form.redraw();
	}

	private void addStatusSupport(ObservablesManager mgr,
			final DataBindingContext ctx) {

		aggregateStatus = new AggregateValidationStatus(
				ctx.getValidationStatusProviders(),
				AggregateValidationStatus.MAX_SEVERITY);

		aggregateStatus.addValueChangeListener(this);
	}

	@Override
	public void handleValueChange(ValueChangeEvent event) {
		IStatus currentStatus = (IStatus) event.diff.getNewValue();
		try {
			managedForm.getMessageManager().removeAllMessages();
			if (currentStatus != null
					&& currentStatus.getSeverity() != IStatus.OK) {
				for (Iterator<?> it = ctx.getValidationStatusProviders()
						.iterator(); it.hasNext();) {
					final ValidationStatusProvider validationStatusProvider = (ValidationStatusProvider) it
							.next();
					final IStatus status = (IStatus) validationStatusProvider
							.getValidationStatus().getValue();
					SWTObservableValueDecorator dec = (SWTObservableValueDecorator) validationStatusProvider
							.getTargets().get(0);
					Control control = (Control) dec.getWidget();
					if (control.isDisposed()) {
						return;
					}
					if (!status.isOK()) {
						managedForm.getMessageManager().addMessage(
								"validation", // key
								status.getMessage(), // message
								null,// data
								IMessageProvider.ERROR, // int
								control);// Control
					} else {
						managedForm.getMessageManager().removeMessage(
								"validation", control);
					}
				}

			}
		} catch (SWTException e) {
			// Ignore SWTException as these are caused by closing the
			// application which nulls the
			// display before the dispose is called. This throws a SWT Disposed
			// even when the
			// Widget is not responding to isDisposed. This makes it hard to
			// find out if the controls
			// are disposed. Punt and ignore SWT exceptions!
			// See Ticket#579
		}
	}

	/**
	 * 
	 * @return true if the premises had no policy and the user confirmed that a
	 *         policy was to be created
	 */
	private boolean createPolicy() {
		if (premisesProvider.getPremises().getPolicy() == null) {
			// Prompt to create one
			boolean result = MessageDialog
					.openConfirm(
							Display.getCurrent().getActiveShell(),
							"Create Policy Element",
							"There is no Policy element on the premises. Would you like to create one first?");
			if (result) {
				// OK Button selected do something
				EditingDomain ed = AdapterFactoryEditingDomain
						.getEditingDomainFor(premisesProvider.getPremises());
				ed.getCommandStack().execute(
						SetCommand.create(ed,
								premisesProvider.getPremises(), // owner
								TrackerPackage.Literals.PREMISES__POLICY,
								TrackerFactory.eINSTANCE.createPolicy()));
				return true;// added policy
			} else {
				return false;// no policy
			}

		} else {
			return false;// already has a policy
		}
	}

	private final class UpdatingViewerSelectionListener extends
			SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			createPolicy();
		}
	}

}
