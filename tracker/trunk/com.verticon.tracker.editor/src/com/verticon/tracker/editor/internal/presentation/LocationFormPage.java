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
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.internal.databinding.swt.SWTObservableValueDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
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

import com.verticon.location.Location;
import com.verticon.location.LocationFactory;
import com.verticon.location.LocationPackage;
import com.verticon.location.provider.LocationItemProvider;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Location element details as a form page on the Premises editor tab.
 * 
 * @author jconlon
 * 
 */
@SuppressWarnings("restriction")
public class LocationFormPage extends FormPage implements IValueChangeListener {
	private static final String FORM_TITLE = "Location";
	private ManagedForm managedForm;
	private final IPremisesProvider premisesProvider;
	private Image componentImage;
	private ObservablesManager observablesManager = new ObservablesManager();
	private DataBindingContext ctx;
	private AggregateValidationStatus aggregateStatus;
	private final CreateLocationSelectionListener createLocationSelectionListener;

	public LocationFormPage(IPremisesProvider premisesProvider,
			CreateLocationSelectionListener createLocationSelectionListener) {
		super("premises", "Premises");
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

	protected void createFormContent(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText(FORM_TITLE);
		form.setToolTipText("Location specifies the geographical details of the Premises document.");

		// Add a reference to control forward timing of other fields
		final IWidgetValueProperty textValueProperty = WidgetProperties
				.text(SWT.Modify);
		final IWidgetValueProperty selectionValueProperty = WidgetProperties
				.selection();
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
				createIdSection(form, textValueProperty, toolkit, immng);
				createContactsSection(form, textValueProperty, toolkit, immng);
				createAddressSection(form, textValueProperty, toolkit, immng);
				createCoordinatesSection(form, textValueProperty,
						selectionValueProperty, toolkit, immng);
			}
		});

	}

	private void createIdSection(final ScrolledForm form,
			IWidgetValueProperty prop, final FormToolkit toolkit,
			IMessageManager immng) {

		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Identification");
		section.setDescription("Location identification details.");
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
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(2, false));
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);

		final EditingDomain ed = premisesProvider.getEditingDomain();

		updateModelsOnLocationChange(ed);

		// Name
		final IEMFValueProperty nameProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__NAME));

		Label l = toolkit.createLabel(sectionClient, "&Location Name");
		l.setToolTipText("The name of the premises location. (This may be different than the premises name.)");
		Text t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				nameProp.observe(premisesProvider.getPremises()));

		// Description
		final IEMFValueProperty descriptionProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__DESCRIPTION));
		;
		l = toolkit.createLabel(sectionClient, "&Description");
		l.setToolTipText("The description of the premises location.");

		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				descriptionProp.observe(premisesProvider.getPremises()));

	}

	/**
	 * If the Premises location is added or removed update the model
	 * 
	 * @param ed
	 */
	private void updateModelsOnLocationChange(final EditingDomain ed) {

		IObservableValue premisesLocationValue = EMFEditProperties.value(
				ed,
				FeaturePath
						.fromList(TrackerPackage.Literals.PREMISES__LOCATION))
				.observe(premisesProvider.getPremises());
		premisesLocationValue
				.addValueChangeListener(new IValueChangeListener() {
					@Override
					public void handleValueChange(ValueChangeEvent event) {
						ctx.updateModels();
					}
				});
	}

	private void createContactsSection(final ScrolledForm form,
			IWidgetValueProperty prop, final FormToolkit toolkit,
			IMessageManager immng) {

		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Contacts");
		section.setDescription("Contacts to obtain more information about the Premises Location.");
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
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(2, false));
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);

		final EditingDomain ed = (AdapterFactoryEditingDomain) premisesProvider
				.getEditingDomain();

		// Phone
		final IEMFValueProperty teleProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__PHONE_NUMBER));

		Label l = toolkit.createLabel(sectionClient, "&Telephone Contact");
		l.setToolTipText("Telephone contact for premises location. (May be different than the premises telephone contact.)");
		Text t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				teleProp.observe(premisesProvider.getPremises()));

		// Comments
		final IEMFValueProperty commentsProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__COMMENTS));
		l = toolkit.createLabel(sectionClient, "&Comments");
		l.setToolTipText("Comments regarding this location");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				commentsProp.observe(premisesProvider.getPremises()));

	}

	private void createAddressSection(final ScrolledForm form,
			IWidgetValueProperty prop, final FormToolkit toolkit,
			IMessageManager immng) {

		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Address");
		section.setDescription("Address details of the Premises Location.");
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
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(2, false));
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);

		final EditingDomain ed = (AdapterFactoryEditingDomain) premisesProvider
				.getEditingDomain();

		// Street
		final IEMFValueProperty streetProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__STREET));

		Label l = toolkit.createLabel(sectionClient, "&Street Address");
		l.setToolTipText("Street address of the location");
		Text t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				streetProp.observe(premisesProvider.getPremises()));

		// City
		final IEMFValueProperty cityProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__CITY));
		l = toolkit.createLabel(sectionClient, "&City");
		l.setToolTipText("City or Municipality of the location");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				cityProp.observe(premisesProvider.getPremises()));

		// State
		final IEMFValueProperty stateProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__STATE));
		l = toolkit.createLabel(sectionClient, "&State or Province");
		l.setToolTipText("State or Province of the location");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				stateProp.observe(premisesProvider.getPremises()));

		// PostalCode
		final IEMFValueProperty postalCodeProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__POSTAL_CODE));

		l = toolkit.createLabel(sectionClient, "&Postal Code");
		l.setToolTipText("Postal Code of the location. (Zip Code)");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				postalCodeProp.observe(premisesProvider.getPremises()));

		// Country
		final IEMFValueProperty commentsProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__COUNTRY));
		l = toolkit.createLabel(sectionClient, "&Country");
		l.setToolTipText("Country of the location");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				commentsProp.observe(premisesProvider.getPremises()));

	}

	private void createCoordinatesSection(final ScrolledForm form,
			IWidgetValueProperty prop,
			IWidgetValueProperty selectionValueProperty,
			final FormToolkit toolkit, IMessageManager immng) {

		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);

		Composite parent = toolkit.createComposite(section);
		// Show a border around the control fieldsS
		toolkit.paintBordersFor(parent);
		section.setClient(parent);
		section.setText("Coordinates");
		section.setDescription("Geographical coordinates of the Premises Location.");
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
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(2, false));
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);
		final AdapterFactoryEditingDomain ed = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(premisesProvider.getPremises());

		// Longitude
		final IEMFValueProperty streetProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__LONGITUDE));

		Label l = toolkit.createLabel(sectionClient, "&Longitude");
		l.setToolTipText("Longitude of the location. Angular distance in degrees, relative to the Prime Meridian. Values west of the Meridian range from -180 degrees to 0 degrees. Values east of the Meridian range from 0 degrees to 180 degrees.");
		Text t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				streetProp.observe(premisesProvider.getPremises()));

		// Latitude
		final IEMFValueProperty cityProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__LATITUDE));
		l = toolkit.createLabel(sectionClient, "&Latitude");
		l.setToolTipText("Latitude of the location.  Degrees north of south of the Equator (0 degrees). Values range from -90 degrees to 90 degrees.");
		t = toolkit.createText(sectionClient, "");
		t.addModifyListener(createLocationSelectionListener);
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t),
				cityProp.observe(premisesProvider.getPremises()));

		// Altitude
		final IEMFValueProperty stateProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__ALTITUDE));
		l = toolkit.createLabel(sectionClient, "&Altitude");
		l.setToolTipText("Distance from the Earth's surface in meters. See 'altitude mode' attribute to see hou this value is interpreted.");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		t.addModifyListener(createLocationSelectionListener);
		ctx.bindValue(prop.observeDelayed(400, t),
				stateProp.observe(premisesProvider.getPremises()));

		// Altitude Mode
		final IEMFValueProperty postalCodeProp = EMFEditProperties.value(ed,
				FeaturePath.fromList(
						TrackerPackage.Literals.PREMISES__LOCATION,
						LocationPackage.Literals.LOCATION__ALTITUDE_MODE));

		l = toolkit.createLabel(sectionClient, "&Altitude Mode");
		l.setToolTipText("Specifies how the 'altitude' is interpreted to a geobrowser. Possible values: 'clampToGround' - ignore altitude and visualize on the ground, 'relativeToGround' - meters above the ground, 'absolute' - meters above sea level.");
		// Need a combo
		AdapterFactory adapterFactory = ed.getAdapterFactory();
		LocationItemProvider locationProvider = new LocationItemProvider(
				adapterFactory);
		Location dummy = LocationFactory.eINSTANCE.createLocation();
		IItemPropertyDescriptor itemPropertyDescriptor = locationProvider
				.getPropertyDescriptor(dummy,
						LocationPackage.Literals.LOCATION__ALTITUDE_MODE);
		Combo combo = createComboControl(dummy, sectionClient,
				itemPropertyDescriptor);
		combo.addSelectionListener(createLocationSelectionListener);
		// t = toolkit.createText(sectionClient, "");
		combo.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1,
				1));
		ctx.bindValue(selectionValueProperty.observeDelayed(400, combo),
				postalCodeProp.observe(premisesProvider.getPremises()));

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

	private Combo createComboControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		Combo combo = new Combo(parent, SWT.DROP_DOWN);
		for (Object lit : itemPropertyDescriptor.getChoiceOfValues(object)) {
			combo.add(lit.toString());
		}
		return combo;
	}
}
