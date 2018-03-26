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

package com.verticon.tracker.ocl.query.wizards;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.ocl.query.OCLPlugin;
import com.verticon.tracker.ocl.query.OCLPlugin.PromptBean;
import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;


/**
 * A wizard the prompts the user for an OCL constraint condition expression
 * and context type.  Performs validation of the OCL expression.
 */
class QueryWithContextWizardPage
	extends WizardPage
	implements IOCLQueryWizardPage {

	private static String TITLE = QueryOCLMessages.oclQuery_title;
	private static String METACLASS_PROMPT = QueryOCLMessages.oclQuery_prompt_metaclass;
	private static String CONDITION_PROMPT = QueryOCLMessages.oclQuery_prompt_condition;
	private static String CONDITION_DEFAULT = QueryOCLMessages.oclQuery_default_condition;
	
	private ComboViewer contextCombo;
	private Text conditionText;
	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
	
	private final String[] pkgURIs;
	
	
	/**
	 * Initializes me.
	 */
	protected QueryWithContextWizardPage(String pkgURIs) {
		super("main", TITLE, null); //$NON-NLS-1$
		this.pkgURIs=pkgURIs.split(" ");
	}

	@Override
	public void createControl(Composite parent) {
		setMessage(QueryOCLMessages.oclQuery_message_wizard);
		
		Composite page = new Composite(parent, SWT.NONE);
		page.setLayout(new GridLayout(2, false));
		
		Label prompt = new Label(page, SWT.NONE);
		prompt.setText(METACLASS_PROMPT);
		
		// combobox from which user selects the OCL conditions' context type
		contextCombo = new ComboViewer(page, SWT.NONE);
		contextCombo.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fillContextCombo();
		contextCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(validatePage());
			}});
		
		// spacer for nice UI layout
		Label spacer = new Label(page, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		data.heightHint = 15;
		spacer.setLayoutData(data);
		
		prompt = new Label(page, SWT.NONE);
		prompt.setText(CONDITION_PROMPT);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		prompt.setLayoutData(data);
		
		// text area for user to enter OCL condition.  Force left-to-right
		//   orientation because the OCL language is based on English
		conditionText = new Text(page, SWT.BORDER | SWT.MULTI | SWT.LEFT_TO_RIGHT);
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		conditionText.setLayoutData(data);
		setConditionText();
		
		conditionText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setPageComplete(validatePage());
			}});
		
		setControl(page);
		
		// validate and compute the default settings
		setPageComplete(validatePage());
	}

	/**
	 * 
	 */
	private void setConditionText() {
		PromptBean promptBean = OCLPlugin.getDefault().getPrompts();
		if (promptBean.hasOclQueryPrompt()) {
			setConditionText(promptBean.getOCLQueryPrompt());
		} else {
			setConditionText(CONDITION_DEFAULT);
		}

	}

	private void setConditionText(String text) {
		conditionText.setText(text);
	}
	
	/**
	 * Fills the combo box with the available context metaclasses.
	 */
	private void fillContextCombo() {
		contextCombo.setContentProvider(new ArrayContentProvider());
		contextCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EClassifier) element).getName();
			}});
		contextCombo.setSorter(new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return ((EClassifier) e1).getName().compareTo(
					((EClassifier) e2).getName());
			}});
		
		// Refactor to allow overriding
		// show only EClasses (cannot query for EDataType values)
		List<EClassifier> classes = getPackageEClassifiers();
		for (Iterator<EClassifier> iter = classes.iterator(); iter.hasNext();) {
			if (!(iter.next() instanceof EClass)) {
				iter.remove();
			}
		}
		contextCombo.setInput(classes);
		
		// apply the default selection, if possible
		EClassifier defaultSelection = getDefaultSelection();
		if (defaultSelection != null) {
			contextCombo.setSelection(
				new StructuredSelection(defaultSelection),
				true);
		}
	}

	/**
	 * @return EClassifier from Tracker Package
	 */
	private EClassifier getDefaultSelection() {
		
		return getPackageEClassifiers().get(0);
	}

	/**
	 * @return EClassifiers from Packages
	 */
	private List<EClassifier> getPackageEClassifiers() {
		EPackage.Registry registry = EPackage.Registry.INSTANCE;	
		List<EClassifier> classes = new LinkedList<EClassifier>();
		
		for (String key : pkgURIs) {
			EPackage pack = registry.getEPackage(key);
			if(pack !=null){
				classes.addAll(pack.getEClassifiers());
			}
			
		}
		
		return classes;
	}
	
	/**
	 * Validates the page input.
	 * 
	 * @return <code>true</code> if I can finish; <code>false</code>, otherwise
	 */
	private boolean validatePage() {
		boolean result = true;
		
		try {
			String text = conditionText.getText();
			
			IStructuredSelection selection =
				(IStructuredSelection) contextCombo.getSelection();
			EClass contextClass = (EClass) selection.getFirstElement();
			
            OCL ocl = OCL.newInstance();
            condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
                ocl.getEnvironment(),
                text,
                contextClass);
			
			if (condition.getResultType(null).getInstanceClass() == Boolean.class) {
				setErrorMessage(null);
			} else {
				condition = null;
				result = false;
				setErrorMessage(QueryOCLMessages.oclQuery_message_boolean);
			}
		} catch (Exception e) {
			result = false;
			setErrorMessage(e.getLocalizedMessage());
		}
		
		return result;
	}
	
	@Override
	public BooleanOCLCondition<EClassifier, EClass, EObject> getCondition() {
		return condition;
	}
	
	/* (non-Javadoc)
	 * Redefines/Implements/Extends the inherited method.
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

}
