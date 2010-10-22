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
package com.verticon.osgi.metatype.core.model.editor.internal.forms;

import static com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils.bundleMarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.masterdetail.MasterDetailObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.HyperlinkSettings;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.Attribute;
import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.OCD;

public class ComponentDetailsPage extends DesignateDetailsPage {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ComponentDetailsPage.class);

	private final ObjectClassDefinition ocd;
	private static final int DEFAULT_KEY_ENTRY_DELAY = 400;

	// Force factory creation
	private ComponentDetailsPage(ObjectClassDefinition ocd,
			IObservableValue masterDesignate, IObservableValue masterOCD,
			EditingDomain editingDomain) {
		super(masterDesignate, masterOCD, editingDomain);
		this.ocd = ocd;
	}

	/**
	 * 
	 * @param ocd
	 *            ObjectClassDefinition to use to build the form
	 * @param masterDesignate
	 *            Master Designate to observe
	 * @param masterOCD
	 *            OCD of the Master Designate
	 * @param editingDomain
	 * @return ComponentDetailsPage instance
	 */
	static ComponentDetailsPage instance(ObjectClassDefinition ocd,
			IObservableValue masterDesignate, IObservableValue masterOCD,
			EditingDomain editingDomain) {
		return new ComponentDetailsPage(ocd, masterDesignate, masterOCD,
				editingDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.metatype.view.internal.FactoryDetailsPage#getNameOfForm
	 * ()
	 */
	@Override
	protected String getNameOfForm() {
		return "Factory Parent";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.metatype.view.internal.FactoryDetailsPage#showFactoryPid
	 * ()
	 */
	@Override
	protected boolean showFactoryPid() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.metatype.view.internal.FactoryDetailsPage#createContents
	 * ( org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createContents(Composite parent) {
		super.createContents(parent);// Creates the context section

		// Create the component section
		section.setDescription(ocd.getDescription());

		FormToolkit toolkit = mform.getToolkit();
		toolkit.paintBordersFor(parent);
		toolkit.getHyperlinkGroup().setHyperlinkUnderlineMode(
				HyperlinkSettings.UNDERLINE_HOVER);
		toolkit.decorateFormHeading(mform.getForm().getForm());

		final IMessageManager mmng = mform.getMessageManager();

		Section configurationSection = toolkit.createSection(parent,
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);
		Composite configurationSectionClient = createConfigurationSectionClient(
				toolkit, configurationSection, mmng);
		configurationSection.setClient(configurationSectionClient);
	}

	@Override
	/**
	 * To prevent setting section description on every selection.
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {

	}

	/**
	 * Create the Components Configuration Section
	 * 
	 * @param toolkit
	 * @param section
	 * @param mmng
	 * @return
	 */
	private Composite createConfigurationSectionClient(FormToolkit toolkit,
			Section section, IMessageManager mmng) {

		section.marginWidth = 10;
		TableWrapData td = new TableWrapData(TableWrapData.FILL,
				TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);
		section.setText("Service Configuration");
		section.setDescription("Configurable attributes of the "
				+ ocd.getName() + " service. ");

		// Build a sectionClient
		Composite configurationSectionClient = toolkit.createComposite(section);
		configurationSectionClient.setLayout(new GridLayout(2, false));

		// Note masterDesignate is still pointing to the Template at this point
		// Add controls for all the attributes and definitions
		IWidgetValueProperty prop = WidgetProperties.text(SWT.Modify);
		for (AttributeDefinition attributeDefinition : ocd
				.getAttributeDefinitions(OCD.ALL)) {
			addControl(toolkit, configurationSectionClient,
					attributeDefinition, prop, mmng);
		}

		return configurationSectionClient;
	}

	/**
	 * Add a control to the Components Configuration Section
	 * 
	 * @param toolkit
	 * @param parent
	 * @param attributeDefinition
	 * @param attribute
	 */
	private void addControl(FormToolkit toolkit, Composite parent,
			final AttributeDefinition attributeDefinition,
			IWidgetValueProperty prop, IMessageManager mmng) {

		Label l = toolkit.createLabel(parent,
				attributeDefinition.getName() + ':');
		l.setToolTipText(attributeDefinition.getDescription());

		// Show a border around the control field
		toolkit.paintBordersFor(parent);
		Control control = createControl(toolkit, parent, attributeDefinition);

		IObservableValue obsValue = MasterDetailObservables.detailValue(
				masterDesignate, // master
				new AttributeFactory(attributeDefinition),// detailFactory
				null);// Type

		obsValue.addValueChangeListener(new IValueChangeListener() {

			public void handleValueChange(ValueChangeEvent event) {
				logger.debug(bundleMarker, "{} obsValue valueChangeEvent = {}",
						attributeDefinition.getID(), event.diff.getNewValue());
			}
		});

		EMFUpdateValueStrategy modelToTarget = new EMFUpdateValueStrategy();
		EMFUpdateValueStrategy targetToModel = new EMFUpdateValueStrategy();

		// Handle either single value or multi value
		IValidator validator = new AttributeDefinitionValidator(
				attributeDefinition, control, mmng);

		if (control instanceof CCombo) {
			// CCombo is unique. It is display a list of Option Labels and
			// not Option Values. So it needs a special converter to make the
			// switch
			// from Labels to Values
			// Since there are only choices that are pre-approved, there is no
			// need
			// for a Validator.
			modelToTarget.setConverter(new CComboModelToTargetConverter(
					attributeDefinition.getOptionLabels(), attributeDefinition
							.getOptionValues()));

			targetToModel.setConverter(new CComboTargetToModelConverter(
					attributeDefinition.getOptionLabels(), attributeDefinition
							.getOptionValues()));

			ctx.bindValue(SWTObservables.observeSelection(control), obsValue,
					targetToModel, modelToTarget);

			return;
		}

		if (attributeDefinition.getCardinality() == 0) {
			// Handle single text values
			modelToTarget.setConverter(modelToTargetConverter);
			modelToTarget.setAfterConvertValidator(validator);

			targetToModel.setConverter(targetToModelConverter);
			targetToModel.setAfterGetValidator(validator);
		} else {
			// Handle multi values in a selection window
			// Still uses a text window but separates fields with a comma
			modelToTarget.setConverter(multivalueModelToTargetConverter);
			modelToTarget.setAfterConvertValidator(validator);

			targetToModel.setConverter(multivalueTargetToModelConverter);
			targetToModel.setAfterGetValidator(validator);
		}

		ctx.bindValue(prop.observeDelayed(DEFAULT_KEY_ENTRY_DELAY, control),
				obsValue, targetToModel, modelToTarget);

	}

	/**
	 * Create a text or ccombo widget
	 * 
	 * @param toolkit
	 * @param parent
	 * @param attributeDefinition
	 * @return
	 */
	private Control createControl(FormToolkit toolkit, Composite parent,
			AttributeDefinition attributeDefinition) {
		Control control = null;

		if (attributeDefinition.getOptionValues() == null) {
			control = toolkit.createText(parent, "");
		} else {
			control = new CCombo(parent, SWT.LEFT);
			((CCombo) control).setItems(attributeDefinition.getOptionLabels());
			toolkit.adapt(control, true, true);

		}

		control.setToolTipText(attributeDefinition.getDescription());
		GridData gd = new GridData(SWT.BORDER);
		gd.widthHint = 150;
		control.setLayoutData(gd);
		return control;
	}

	final class CComboTargetToModelConverter extends Converter {
		private final String[] labels;
		private final String[] values;

		public CComboTargetToModelConverter(String[] labels, String[] values) {
			super(String.class, List.class);
			this.labels = labels;
			this.values = values;
		}

		@Override
		public Object convert(Object fromTarget) {
			List<String> toModel = new ArrayList<String>();
			toModel.add(labelToValue((String) fromTarget));
			return toModel;
		}

		private String labelToValue(String label) {
			for (int i = 0; i < labels.length; i++) {
				if (label.equals(labels[i])) {
					return values[i];
				}
			}
			return null;
		}
	}

	final class CComboModelToTargetConverter extends Converter {

		private final String[] labels;
		private final String[] values;

		public CComboModelToTargetConverter(String[] labels, String[] values) {
			super(List.class, String.class);
			this.labels = labels;
			this.values = values;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object convert(Object fromModel) {
			List<String> values = (List<String>) fromModel;
			return valueToLabel(values.get(0));
		}

		private String valueToLabel(String value) {
			for (int i = 0; i < values.length; i++) {
				if (value.equals(values[i])) {
					return labels[i];
				}
			}
			return null;
		}
	}

	// TargetToModel single values
	private Converter targetToModelConverter = new Converter(String.class,
			List.class) {
		@Override
		public Object convert(Object fromObject) {
			List<String> toModel = new ArrayList<String>();
			toModel.add((String) fromObject);
			return toModel;
		}
	};

	// ModelToTarget single values
	private Converter modelToTargetConverter = new Converter(List.class,
			String.class) {
		@SuppressWarnings("unchecked")
		@Override
		public Object convert(Object fromObject) {
			List<String> values = (List<String>) fromObject;
			return values.get(0);
		}
	};

	// TargetToModel for multiple values

	// TargetToModel convert from comma delimited string to a list
	private Converter multivalueTargetToModelConverter = new Converter(
			String.class, List.class) {

		@Override
		public Object convert(Object fromObject) {
			List<String> toModel = new ArrayList<String>();
			String[] list = ((String) fromObject).split(",");
			for (String string : list) {
				toModel.add(string);
			}
			return toModel;
		}
	};

	// ModelToTarget convert from list to a comma delimited string
	private Converter multivalueModelToTargetConverter = new Converter(
			List.class, String.class) {
		@SuppressWarnings("unchecked")
		@Override
		public Object convert(Object fromObject) {
			List<String> values = (List<String>) fromObject;
			Iterator<String> it = values.iterator();
			StringBuilder builder = new StringBuilder();
			while (it.hasNext()) {
				builder.append((String) it.next());
				if (it.hasNext()) {
					builder.append(',');
				}
			}
			return builder.toString();
		}
	};

	@Override
	public void dispose() {
		// for (IObservable obs : obsMap.values()) {
		// obs.dispose();
		// }
		// obsMap.clear();
		super.dispose();
	}

	/**
	 * ObservableFactory for creating Observables on the Attributes of
	 * Designates
	 * 
	 * @author jconlon
	 * 
	 */
	final class AttributeFactory implements IObservableFactory {

		final AttributeDefinition attDef;

		private AttributeFactory(AttributeDefinition attDef) {
			super();
			this.attDef = attDef;
		}

		@Override
		public IObservable createObservable(Object target) {
			Designate designate = (Designate) target;
			if (designate.getObject() != null) {
				for (final Attribute attribute : designate.getObject()
						.getAttribute()) {
					if (attribute.getAdref().equals(attDef.getID())) {
						logger.debug(bundleMarker, "{} createObservable",
								attDef.getID());
						// Creating observable
						IEMFEditValueProperty prop = EMFEditProperties.value(
								editingDomain,
								MetatypePackage.Literals.ATTRIBUTE__VALUE);

						IEMFEditListProperty lprop = EMFEditProperties.list(
								editingDomain,
								MetatypePackage.Literals.ATTRIBUTE__VALUE);

						final IObservableValue ov = prop.observe(attribute);
						IObservableList lov = lprop.observe(attribute);

						ExtendedObservable eo = new ExtendedObservable(lov, ov,
								attDef.getID());
						eo.init();
						return eo;
					}
				}

			}
			logger.debug(bundleMarker, "{} Returning empty observable", attDef
					.getID());
			return new WritableValue();

		}
	}

	/**
	 * Validates single and multiple value strings against an
	 * attributeDefinition.
	 * 
	 * @author jconlon
	 * 
	 */
	final class AttributeDefinitionValidator implements IValidator {

		private final AttributeDefinition attributeDefinition;
		private final Control t;
		private final IMessageManager mmng;
		private final int cardinality;

		AttributeDefinitionValidator(
				AttributeDefinition attributeItemPropertyDescriptor, Control t,
				IMessageManager mmng) {
			super();
			this.attributeDefinition = attributeItemPropertyDescriptor;
			this.t = t;
			this.mmng = mmng;
			this.cardinality = attributeDefinition.getCardinality() == 0 ? 0
					: attributeDefinition.getCardinality() > 0 ? attributeDefinition
							.getCardinality()
							: attributeDefinition.getCardinality() * -1;
		}

		@Override
		public IStatus validate(Object value) {
			if (cardinality == 0) {
				return validateSingleValue(value);
			} else {
				return validateMultipleValues(value);
			}
		}

		private IStatus validateSingleValue(Object value) {
			String error = attributeDefinition.validate((String) value);
			if (error == null || error.trim().length() == 0) {
				mmng.removeMessage("validation", t);
				return ValidationStatus.ok();
			} else {
				mmng.addMessage(
						"validation", //key
						error, //message
						null,//data
						IMessageProvider.ERROR, //int
						t);//Control
				return ValidationStatus.error(error);
			}
		}

		private IStatus validateMultipleValues(Object value) {
			String[] values = ((String) value).split(",");
			String error = null;
			int abs = Math.abs(cardinality);
			if (abs == 0 && values.length!=1){
				error = "Wrong number of values. Expected a single value.";
				mmng.addMessage("validation", error, null,
				IMessageProvider.ERROR, t);
				return ValidationStatus.error(error);
			}
			if (values.length > abs) {
				error = "Wrong number of values. Cannot have more than " + abs
						+ " values.";
				mmng.addMessage("validation", error, null,
						IMessageProvider.ERROR, t);
				return ValidationStatus.error(error);
			}

			for (String valueInList : values) {
				IStatus status = validateSingleValue(valueInList);
				if (status != ValidationStatus.ok()) {
					return status;
				}
			}
			return ValidationStatus.ok();
		}

	}

	/**
	 * Kludge observable that delegates to an Observable created by the
	 * EMFEditProperties.value on a Attribute__Value list. The Attribute values
	 * can act like a single valued property or they can act like a multi-valued
	 * property depending on the attributeDefinition. A second
	 * EMFEditProperties.list is used to notify listeners that this single value
	 * has changed.
	 * 
	 * (Is there a better way?)
	 * 
	 * @author jconlon
	 * 
	 */
	final class ExtendedObservable implements IObservableValue,
			IListChangeListener {
		private final IObservableList lov;
		private final IObservableValue ov;
		private final String name;
		private final List<IValueChangeListener> valueListeners = new CopyOnWriteArrayList<IValueChangeListener>();

		private ExtendedObservable(IObservableList lov, IObservableValue ov,
				String name) {
			super();
			this.lov = lov;
			this.ov = ov;
			this.name = name;
		}

		void init() {
			lov.addListChangeListener(this);
		}

		@Override
		public synchronized void dispose() {
			valueListeners.clear();
			lov.removeListChangeListener(this);
			lov.dispose();
			ov.dispose();
		}

		@Override
		public void handleListChange(ListChangeEvent event) {
			logger.debug(bundleMarker,
					"{} listChangeEvent invoked value={} SOURCE="
							+ event.getSource(), name, event.diff
							.getDifferences());

			for (IValueChangeListener l : valueListeners) {
				l.handleValueChange(new ValueChangeEvent(this, new ValueDiff() {

					@Override
					public Object getOldValue() {
						return "";
					}

					@Override
					public Object getNewValue() {
						return ov.getValue();
					}
				}));
			}

		}

		@Override
		public void addValueChangeListener(IValueChangeListener listener) {
			valueListeners.add(listener);
			ov.addValueChangeListener(listener);
		}

		@Override
		public Object getValue() {
			return ov.getValue();
		}

		@Override
		public Object getValueType() {
			return ov.getValueType();
		}

		@Override
		public void removeValueChangeListener(IValueChangeListener listener) {
			ov.removeValueChangeListener(listener);
		}

		@Override
		public void setValue(Object value) {
			ov.setValue(value);
		}

		@Override
		public void addChangeListener(IChangeListener listener) {
			ov.removeChangeListener(listener);
			valueListeners.remove(listener);
		}

		@Override
		public void addDisposeListener(IDisposeListener listener) {
			ov.addDisposeListener(listener);
		}

		@Override
		public void addStaleListener(IStaleListener listener) {
			ov.addStaleListener(listener);
		}

		@Override
		public Realm getRealm() {
			return ov.getRealm();
		}

		@Override
		public boolean isDisposed() {
			return ov.isDisposed();
		}

		@Override
		public boolean isStale() {
			return ov.isStale();
		}

		@Override
		public void removeChangeListener(IChangeListener listener) {
			ov.removeChangeListener(listener);
		}

		@Override
		public void removeDisposeListener(IDisposeListener listener) {
			ov.removeDisposeListener(listener);
		}

		@Override
		public void removeStaleListener(IStaleListener listener) {
			ov.removeStaleListener(listener);
		}

	}
}
