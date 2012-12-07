/**
 * <copyright>
 *
 * Copyright (c) 2009 Bestsolution.at and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   Tom Schindl<tom.schindl@bestsolution.at> - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GenericEventEditingDialog.java,v 1.5 2009/06/07 18:19:40 tschindl Exp $
 */
package com.verticon.tracker.editor.internal.presentation;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.dialog.TitleAreaDialogSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.GenericEventInclusion;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerUtils;

/**
 * Dialog to edit person data
 */
public class GenericEventEditingDialog extends TitleAreaDialog {
	private final GenericEventInclusion eventInclusion;
	private final EditingDomain editingDomain;
	private final DataBindingContext ctx;

	/**
	 * Create a dialog to edit the OCD of an GenericInclusionEvent
	 * 
	 * @param parentShell
	 * @param editingDomain
	 * @param eventInclusion
	 */
	public GenericEventEditingDialog(Shell parentShell,
			EditingDomain editingDomain, GenericEventInclusion eventInclusion) {
		super(parentShell);
		this.eventInclusion = eventInclusion;
		this.editingDomain = editingDomain;
		this.ctx = new EMFDataBindingContext();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		getShell().setText("Edit the GenericEventInclusion");
		setTitle("Edit Generic Event for the GenericEventInclusion");
		setMessage("Set the  of the GenericEvent on the GenericEventInclusion");

		final Composite comp = (Composite) super.createDialogArea(parent);

		ObservablesManager mgr = new ObservablesManager();
		mgr.runAndCollect(new Runnable() {

			public void run() {
				createForm(comp)
						.setLayoutData(new GridData(GridData.FILL_BOTH));
			}
		});

		return comp;
	}

	private Composite createForm(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		final Label l = new Label(container, SWT.BORDER);
		l.setText("OCD");

		GridData gd = new GridData(SWT.CENTER, SWT.FILL, false, false);
		l.setLayoutData(gd);

		IEMFEditValueProperty mprop = EMFEditProperties.value(editingDomain,
				TrackerPackage.Literals.GENERIC_EVENT_INCLUSION__OCD);
		Combo combo = new Combo(container, SWT.DROP_DOWN);
		gd = new GridData(SWT.CENTER, GridData.FILL, true, true);

		EcoreUtil.resolveAll(eventInclusion);
		List<OCD> ocds = TrackerUtils.findOCDs(eventInclusion);
		for (OCD ocd : ocds) {
			combo.add(ocd.getName());
		}

		ctx.bindValue(WidgetProperties.selection().observe(combo), mprop
				.observe(eventInclusion), new EMFUpdateValueStrategy()
				.setConverter(new StringToOCDConverter(ocds)),
				new EMFUpdateValueStrategy()
						.setConverter(new OCDToStringConverter()));

		TitleAreaDialogSupport.create(this, ctx);
		return container;
	}

	@Override
	public boolean close() {
		ctx.dispose();
		return super.close();
	}

	private final class StringToOCDConverter extends Converter {
		private final List<OCD> ocds;

		StringToOCDConverter(List<OCD> ocds) {
			super(String.class, OCD.class);
			this.ocds = ocds;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.conversion.IConverter#convert(java.lang
		 * .Object)
		 */
		@Override
		public Object convert(Object fromObject) {
			String name = (String) fromObject;
			for (OCD ocd : ocds) {
				if (ocd.getName().equals(name)) {
					return ocd;
				}
			}
			return null;
		}

	}

	private final class OCDToStringConverter extends Converter {

		OCDToStringConverter() {
			super(OCD.class, String.class);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.conversion.IConverter#convert(java.lang
		 * .Object)
		 */
		@Override
		public Object convert(Object fromObject) {
			OCD ocd = (OCD) fromObject;
			return ocd.getName();
		}

	}
}
