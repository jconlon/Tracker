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

import java.util.Iterator;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.internal.databinding.swt.SWTObservableValueDecorator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
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

import com.verticon.location.LocationFactory;
import com.verticon.location.LocationPackage;
import com.verticon.location.provider.LocationItemProviderAdapterFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Premises element details as a form page on the Premises editor tab.
 * 
 * @author jconlon
 * 
 */
@SuppressWarnings("restriction")
public class AreasFormPage extends FormPage implements IValueChangeListener {
	private static final String DESCRIPTION = "Areas are optional geographic elements of the Location element within the Premises document.";
	private static final String FORM_TITLE = "Areas";
	private ManagedForm managedForm;
	private final IPremisesProvider premisesProvider;
	private Image componentImage;
	private ObservablesManager observablesManager = new ObservablesManager();
	private DataBindingContext ctx;
	private AggregateValidationStatus aggregateStatus;
	private final CreateLocationSelectionListener createLocationSelectionListener;
	private Text nameText;
	private Text boundariesText;
	private Text commentsText;
	private Button deleteButton;

	public AreasFormPage(IPremisesProvider premisesProvider,
			CreateLocationSelectionListener createLocationSelectionListener) {
		super("areas", "Areas");
		this.premisesProvider = premisesProvider;
		this.createLocationSelectionListener = createLocationSelectionListener;
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

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IValueChangeListener#
	 * handleValueChange
	 * (org.eclipse.core.databinding.observable.value.ValueChangeEvent)
	 */
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
				createAreasSection(form, toolkit, immng);
			}
		});

	}

	private void createAreasSection(final ScrolledForm form,
			final FormToolkit toolkit, IMessageManager immng) {
		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Area");
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

		createAreasControl(toolkit, sectionClient, ed);

	}

	private void createAreasControl(final FormToolkit toolkit,
			final Composite sectionClient, final AdapterFactoryEditingDomain ed) {

		Group group = new Group(sectionClient, SWT.NONE);
		group.setText("Areas");
		group.setToolTipText("List of Areas in the Location");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING,
				true, false);
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);

		Button button = new Button(group, SWT.PUSH);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		button.setLayoutData(gridData);
		button.setText("Add");
		button.setToolTipText("Add a new area");
		button.addSelectionListener(createLocationSelectionListener);

		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.verticalAlignment = GridData.FILL;
		gridData.verticalSpan = 6;
		table.setLayoutData(gridData);

		final TableViewer viewer = new TableViewer(table);

		updateModelAndViewOnLocationChange(ed, viewer);
		AdapterFactory adapterFactory = new LocationItemProviderAdapterFactory();
		viewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		viewer.setInput(premisesProvider.getPremises().getLocation());

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// if the selection is empty clear the label
				if (event.getSelection().isEmpty()) {
					enableTextFields(false);
				} else {
					enableTextFields(true);
				}
			}
		});

		// set listener on add button
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (premisesProvider.getPremises().getLocation() == null) {
					return;
				}
				// Add an eventInclusion
				ed.getCommandStack().execute(
						AddCommand.create(ed, premisesProvider.getPremises()
								.getLocation(), // owner
								LocationPackage.Literals.LOCATION__AREAS, //
								LocationFactory.eINSTANCE.createArea()));

			}
		});

		deleteButton = new Button(group, SWT.PUSH);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		deleteButton.setLayoutData(gridData);
		deleteButton.setText("Delete");
		deleteButton.setToolTipText("Delete selected area");
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

		group = new Group(sectionClient, SWT.NONE);
		group.setText("Selected Area");
		group.setToolTipText("Details of the area selected in the above list");
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);

		// 1. Observe changes in selection.
		IObservableValue selection = ViewersObservables
				.observeSingleSelection(viewer);
		final IWidgetValueProperty widgetValueProperty = WidgetProperties
				.text(SWT.Modify);
		// Name
		Label l = toolkit.createLabel(group, "&Name");
		l.setToolTipText("Name for area");
		l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 1, 1));
		nameText = toolkit.createText(group, "", SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false,
				1, 1));
		// Observe the name property of the current selection.
		IObservableValue detailObservable = EMFEditProperties.value(ed,
				LocationPackage.Literals.AREA__NAME).observeDetail(selection);
		// Bind the Text widget to the name detail (selection's name).
		ctx.bindValue(widgetValueProperty.observeDelayed(400, nameText),
				detailObservable, null, null);
		nameText.setEnabled(false);

		// Boundaries
		l = toolkit.createLabel(group, "&Boundary");
		l.setToolTipText("Areas perimeter boundary, specified as a geometric polygon composed of a series of point coordinates - longitude, lattitude and altitude.");
		l.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		boundariesText = toolkit.createText(group, "", SWT.BORDER);
		boundariesText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));

		// Observe the name property of the current selection.
		detailObservable = EMFEditProperties.value(ed,
				LocationPackage.Literals.AREA__BOUNDARY).observeDetail(
				selection);
		// Bind the Text widget to the name detail (selection's name).
		ctx.bindValue(widgetValueProperty.observeDelayed(400, boundariesText),
				detailObservable, null, null);
		boundariesText.setEnabled(false);

		// Comments
		l = toolkit.createLabel(group, "&Comments");
		l.setToolTipText("Comments about this area");
		l.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false, 1, 1));
		commentsText = toolkit.createText(group, "", SWT.BORDER);
		commentsText.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true,
				false, 1, 1));
		// Observe the name property of the current selection.
		detailObservable = EMFEditProperties.value(ed,
				LocationPackage.Literals.AREA__COMMENTS).observeDetail(
				selection);
		// Bind the Text widget to the name detail (selection's name).
		ctx.bindValue(widgetValueProperty.observeDelayed(400, commentsText),
				detailObservable, null, null);
		commentsText.setEnabled(false);

	}

	private void enableTextFields(boolean enabled) {
		nameText.setEnabled(enabled);
		boundariesText.setEnabled(enabled);
		commentsText.setEnabled(enabled);
		// and the delete button
		deleteButton.setEnabled(enabled);
	}

	/**
	 * If the Premises location is added or removed reset the viewer input and
	 * update the model
	 * 
	 * @param ed
	 * @param viewer
	 */
	private void updateModelAndViewOnLocationChange(
			final AdapterFactoryEditingDomain ed, final TableViewer viewer) {
		IObservableValue premisesLocationValue = EMFEditProperties.value(
				ed,
				FeaturePath
						.fromList(TrackerPackage.Literals.PREMISES__LOCATION))
				.observe(premisesProvider.getPremises());
		premisesLocationValue
				.addValueChangeListener(new IValueChangeListener() {
					@Override
					public void handleValueChange(ValueChangeEvent event) {
						viewer.setInput(premisesProvider.getPremises()
								.getLocation());
						ctx.updateModels();
					}
				});
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

}
