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
package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;

/**
 * Base class for offering creation of Chained Wizard Pages to create element or
 * elements in a parent, child, grandchild heirarchy.
 * 
 * @author jconlon
 * 
 */
abstract class ExhibitAncestorWizardPage extends WizardPage implements
		AddExhibitWizardPageParent {

	/**
	 * Owner or Parent of the object that will be created.
	 * 
	 */
	private final EObject owner;

	/**
	 * Feature to be created.
	 * 
	 * Example: FairPackage.Literals.FAIR__DIVISIONS
	 */
	private final EStructuralFeature eStructuralFeature;

	private TableViewer tableViewer;
	private Text text;

	/**
	 * Reference to the parent WizardPage
	 */
	protected final AddExhibitWizardPageParent parentPage;

	/**
	 * Observes the value of the selected target if any
	 * 
	 */
	protected IObservableValue selectedTarget = null;

	/**
	 * Observes the value of a newly named element.
	 */
	protected final IObservableValue newTargetName = new WritableValue(null,
			String.class);
	
	
	ExhibitAncestorWizardPage(String pageName, EStructuralFeature feature,
			EObject owner, ExhibitAncestorWizardPage parentPage) {
		super(feature.getName(), "Choose or Create a " + pageName,null);
		eStructuralFeature = feature;
		this.owner = owner;
		this.parentPage = parentPage;
	}
	
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			if (tableViewer != null) {
				// If the table is empty because this it has a new parentPage
				// don't
				// show
				// it
				if (tableViewer.getTable().getItems().length == 0) {
					tableViewer.getTable().setVisible(false);
				} else {
					tableViewer.getTable().setVisible(true);
				}

			}
			setPageComplete(hasValue());
		}
		super.setVisible(visible);
	}

	public IObservableValue getSelectedTarget() {
		return selectedTarget;
	}

	public boolean newTargetHasValue() {
		if (getNewTargetName() == null || getNewTargetName().getValue() == null) {
			return false;
		}
		String s = (String) getNewTargetName().getValue();
		return s.trim().length() > 0;
	}

	protected IObservableValue getNewTargetName() {
		return newTargetName;
	}

	public void createControl(Composite parent) {
		DataBindingContext dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);
		Composite composite = new Composite(parent, SWT.NONE);
		if (eStructuralFeature != null) {
			tableViewer = createSingleColumnTableViewer(composite);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.grabExcessHorizontalSpace = true;
			data.horizontalSpan = 2;
			data.heightHint = 300;
			data.widthHint = 300;
			tableViewer.getTable().setLayoutData(data);

			// Create the input for the table

			IObservableList input;
			if (parentPage == null) {
				input = EMFObservables.observeList(owner, eStructuralFeature);
			} else {
				// Watch the selection from the parentPage page
				// and use it for the input to this list
				EditingDomain editingDomain = AdapterFactoryEditingDomain
						.getEditingDomainFor(owner);

				input = EMFEditObservables.observeDetailList(
						Realm.getDefault(), editingDomain, parentPage
								.getSelectedTarget(), eStructuralFeature);
			}
			// Set it on the viewer
			tableViewer.setInput(input);

			selectedTarget = ViewersObservables
					.observeSingleSelection(tableViewer);
		}
		Label label = new Label(composite, SWT.NONE);
		label.setText("New " + getName() + " Name:");
		text = new Text(composite, SWT.BORDER);

		dbc.bindValue(SWTObservables.observeText(text, SWT.Modify),
				newTargetName, new UpdateValueStrategy()
						.setAfterConvertValidator(new NonNullStringValidator(
								getName(), tableViewer)), null);

		// Clear the text if there is a selection
		selectedTarget.addValueChangeListener(new IValueChangeListener() {

			public void handleValueChange(ValueChangeEvent event) {
				if (event.diff.getNewValue() != null
						&& !tableViewer.getSelection().equals(
								StructuredSelection.EMPTY)) {

					tableEntrySelected(text);
				}
				setPageComplete(hasValue());

			}

			/**
			 * @param text
			 */
			private void tableEntrySelected(final Text text) {
				text.setText("");

			}
		});

		// Clear the selection if there is text
		newTargetName.addValueChangeListener(new IValueChangeListener() {

			public void handleValueChange(ValueChangeEvent event) {
				if (event.diff.getNewValue() != null
						&& ((String) event.diff.getNewValue()).trim().length() > 0) {
					textHasBeenAdded(tableViewer);
				}
				setPageComplete(hasValue());

			}

			/**
			 * @param tableViewer
			 */
			private void textHasBeenAdded(final TableViewer tableViewer) {
				tableViewer.setSelection(StructuredSelection.EMPTY);

			}
		});

		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(composite);
		setControl(composite);
	}

	/**
	 * 
	 * @param tableComposite
	 * @return a tableViewer with a Databinding ContentProvider
	 */
	protected TableViewer createSingleColumnTableViewer(Composite tableComposite) {
		final TableViewer tableViewer = new TableViewer(tableComposite);
		ObservableListContentProvider cp = new ObservableListContentProvider();
		tableViewer.setContentProvider(cp);
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new FairItemProviderAdapterFactory()));
		return tableViewer;

	}

	/**
	 * @return
	 */
	protected boolean selectionHasValue() {
		if (getSelectedTarget() == null
				|| getSelectedTarget().getValue() == null) {
			return false;
		}
		return !getSelectedTarget().getValue()
				.equals(StructuredSelection.EMPTY);
	}

	boolean hasValue() {
		return selectionHasValue() || newTargetHasValue();
	}

	private final class NonNullStringValidator implements IValidator {

		public NonNullStringValidator(String name, TableViewer tableViewer) {
			super();
			this.name = name;
		}

		final String name;
		public IStatus validate(Object value) {
			if (selectionHasValue()) {
				return ValidationStatus.ok();
			}
			String s = (String) value;
			if (s == null || s.trim().length() < 1) {
				return ValidationStatus.info("Please enter a value for " + name
						+ '.');
			}
			return ValidationStatus.ok();
		}
	}

}
