/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.verticon.osgi.metatype.core.model.editor.internal.forms;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;


/**
 * @author dejan
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class DesignatesFormPage extends FormPage {
	private DesignatesMasterDetailsBlock block;
	private  ManagedForm managedForm;
	private final IEditorPart editorPart;
	
	public DesignatesFormPage(IEditorPart editorPart) {
		super("iRouterFactoryServices", "iRouter Factory Services Configuration");
		this.editorPart = editorPart;
		block = new DesignatesMasterDetailsBlock(this);
	}
	
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("iRouter Factory Services Configuration");
		block.createContent(managedForm);
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

	public IEditorPart getEditorPart() {
		return editorPart;
	}
}
