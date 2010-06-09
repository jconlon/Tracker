/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.editor.internal.presentation;

import java.util.Iterator;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.internal.databinding.swt.SWTObservableValueDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * @author dejan
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Generation - Code and Comments
 */
@SuppressWarnings("restriction")
public class PremisesFormPage extends FormPage {
	private static final String FORM_TITLE = "Premises";
	private ManagedForm managedForm;
	private final IPremisesProvider premisesProvider;

	private Image componentImage;

	private ObservablesManager defaultMgr = new ObservablesManager();
	private DataBindingContext ctx;

	public PremisesFormPage(IPremisesProvider premisesProvider) {
		super("premises", "Premises");
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
		form
				.setToolTipText("Premises is the root parent of the Premises document.");

		// Add a reference to control forward timing of other fields
		IWidgetValueProperty prop = WidgetProperties.text(SWT.Modify);

		final FormToolkit toolkit = managedForm.getToolkit();
		addHeadingGradient(toolkit, form, true);
		// toolkit.getHyperlinkGroup().setHyperlinkUnderlineMode(
		// HyperlinkSettings.UNDERLINE_HOVER);

		toolkit.decorateFormHeading(form.getForm());
		// form.setHeadClient(toolkit.createButton(form.getForm().getHead(),
		// "This is the head client", SWT.PUSH));
		// form.getToolBarManager().add(new Action("This is the toolbar") { });
		// form.getToolBarManager().update(true);
		form.getForm().addMessageHyperlinkListener(new HyperlinkAdapter()); // NEW
																			// LINE
		// form.getForm().setMessage("This is an error message",
		// IMessageProvider.ERROR); // NEW LINE

		componentImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				"com.verticon.tracker.edit", "/icons/full/obj16/Premises.gif")
				.createImage();
		form.setImage(componentImage);
		//			
		// toolkit.getHyperlinkGroup().setHyperlinkUnderlineMode(
		// HyperlinkSettings.UNDERLINE_HOVER);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 6;
		layout.horizontalSpacing = 20;
		form.getBody().setLayout(layout);

		ctx = new EMFDataBindingContext();
		IMessageManager immng = managedForm.getMessageManager();
		addStatusSupport(defaultMgr, ctx, form, managedForm.getMessageManager());
		createIdSection(form, prop, toolkit, immng);
		createContactsSection(form, prop, toolkit, immng);
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
		section.setDescription("Premises identification information.");
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

		// Name
		final IEMFValueProperty nameProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__NAME);
		;
		Label l = toolkit.createLabel(sectionClient, "&Premises Name");
		l.setToolTipText("The name of the premises.");
		Text t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), nameProp
				.observe(premisesProvider.getPremises()));

		// Description
		final IEMFValueProperty descriptionProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__DESCRIPTION);
		;
		l = toolkit.createLabel(sectionClient, "&Description");
		l.setToolTipText("The description of the premises.");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), descriptionProp
				.observe(premisesProvider.getPremises()));

		// PIN
		final IEMFValueProperty idProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__PREMISES_ID);
		l = toolkit.createLabel(sectionClient, "&USDA Premises ID");
		l
				.setToolTipText("The USDA assigned Premises Identification Number (PIN)");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), idProp
				.observe(premisesProvider.getPremises()));

		// URI
		final IEMFValueProperty uriProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__URI);
		l = toolkit.createLabel(sectionClient, "&Premises URI");
		l
				.setToolTipText("The End user assigned Universal Resource Identifier (URI) for the Premises.");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), uriProp
				.observe(premisesProvider.getPremises()));

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
		section
				.setDescription("Contacts to obtain more information about the Premises.");
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

		// Administrator
		final IEMFValueProperty adminProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__ADMINISTRATOR);
		Label l = toolkit.createLabel(sectionClient, "&Administrator Contact");
		l.setToolTipText("Administrator contact for premises");
		Text t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), adminProp
				.observe(premisesProvider.getPremises()));

		// Phone
		final IEMFValueProperty teleProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__PHONE_NUMBER);
		l = toolkit.createLabel(sectionClient, "&Telephone Contact");
		l.setToolTipText("Telephone contact for premises");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), teleProp
				.observe(premisesProvider.getPremises()));

		// EMail
		final IEMFValueProperty emailProp = EMFEditProperties.value(ed,
				TrackerPackage.Literals.PREMISES__EMAIL_CONTACT);
		l = toolkit.createLabel(sectionClient, "&Email Contact");
		l.setToolTipText("Email contact for premises");
		t = toolkit.createText(sectionClient, "");
		t.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
		ctx.bindValue(prop.observeDelayed(400, t), emailProp
				.observe(premisesProvider.getPremises()));

	}

	@Override
	public void dispose() {
		componentImage.dispose();
		if (defaultMgr != null) {
			defaultMgr.dispose();
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
			final DataBindingContext ctx, final ScrolledForm form,
			final IMessageManager mmng) {

		AggregateValidationStatus aggregateStatus = new AggregateValidationStatus(
				ctx.getValidationStatusProviders(),
				AggregateValidationStatus.MAX_SEVERITY);

		aggregateStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				handleStateChange((IStatus) event.diff.getNewValue(), ctx,
						form, mmng);
			}
		});
	}

	private void handleStateChange(IStatus currentStatus,
			DataBindingContext ctx, ScrolledForm form, IMessageManager mmng) {
		mmng.removeAllMessages();
		if (form.isDisposed()) {
			return;
		}

		if (currentStatus != null && currentStatus.getSeverity() != IStatus.OK) {
			for (Iterator<?> it = ctx.getValidationStatusProviders().iterator(); it
					.hasNext();) {
				final ValidationStatusProvider validationStatusProvider = (ValidationStatusProvider) it
						.next();
				final IStatus status = (IStatus) validationStatusProvider
						.getValidationStatus().getValue();
				SWTObservableValueDecorator dec = (SWTObservableValueDecorator) validationStatusProvider
						.getTargets().get(0);
				Control control = (Control) dec.getWidget();
				if (!status.isOK()) {
					mmng.addMessage("validation", // key
							status.getMessage(), // message
							null,// data
							IMessageProvider.ERROR, // int
							control);// Control

				} else {
					mmng.removeMessage("validation", control);

				}
			}

		} else {
			form.setMessage(null, IMessageProvider.NONE);
		}
	}
}
