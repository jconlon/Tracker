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
/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.ocl.query.actions.AbstractQueryDelegate;

/**
 * 
 * Default implementation of an IOclQuery
 * 
 * @author jconlon
 *
 */
public class OclQuery extends AbstractQueryDelegate implements IOclQuery, Cloneable {
	private static final String PACKAGES = "packages";
	private static final String URI = "uri";
	private static final String PACKAGE = "package";
	private static final String CONTEXT_TYPE_CANNOT_BE_BLANK = "Context type cannot be blank.";
	private static final String QUERY_CANNOT_BE_BLANK = "Query cannot be blank.";
	private static final String OCL_CONDITION_MUST_BE_A_BOOLEAN_EXPRESSION = "OCL condition must be a boolean expression.";
	private static final String SELECT_THE_TRACKER_ELEMENT = "Please select an element in a Tracker editor.";
	private static final String ARGUMENT_CONTEXT_IS_NULL = "Argument 'context' is null";
	private static final String SELECT_TRACKER_EDITOR_ACTIVE_EDITOR = "Please select a TrackerEditor as the Active Editor.";
	private static final String UNEXPECTED_EXCEPTION = "An unexpected exception prevented the operation from completing successfully.  See Error Log View for details.";
	private static final String TITLE = "OCL Query";
	private static final String NOT_FOUND = "No matches were found under the selection for the specified OCL condition.";
	
	
	private String name = "";
	private String query = "";
	private String syntaxErrors = "";
	private String type = "";
	private static String[] cachedOCLPackages;
	

	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;

	public OclQuery(){
		super();
	}
	
	public OclQuery(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getContext()
	 */
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getDescription()
	 */
	public String getErrorSyntax() {
		return syntaxErrors;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getQuery()
	 */
	public String getQuery() {
		return query;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setContext(java.lang.String)
	 */
	public void setType(String type) {
		this.type=type;

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setDescription(java.lang.String)
	 */
	public void setErrorSyntax(String syntaxErrors) {
		this.syntaxErrors=syntaxErrors;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OclQuery){
			OclQuery anotherQuery = (OclQuery)obj;
			if(anotherQuery.getName().equals(name)){
				if(anotherQuery.getType().equals(type)){
					return true;
				}
				
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return 17 * type.hashCode() * name.hashCode();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setQuery(java.lang.String)
	 */
	public void setQuery(String query) {
		this.query=query;
		validateQuery();
	}
	
	/**
	 * Runs the query.
	 */
	public void run() {
		IEditorPart editor = PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		try {
			this.setActiveEditor(null, editor);
		}catch (UnsupportedOperationException ex){
			MessageDialog.openInformation(getShell(), TITLE,
					ex.getMessage());
			return;
		} catch (RuntimeException e1) {
			MessageDialog.openInformation(getShell(), TITLE,
					SELECT_TRACKER_EDITOR_ACTIVE_EDITOR);
			return;
		}
		
		Collection<EObject> selection = getSelectedObjects();
		
		if (selection == null || selection.isEmpty()) {
			MessageDialog.openInformation(getShell(), TITLE,
					SELECT_THE_TRACKER_ELEMENT);
			return;
		}

		if (condition != null) {
			try {
				IQueryResult result = performQuery(getSelectedObjects(), null,
					new NullProgressMonitor());
				if (result.isEmpty()) {
					MessageDialog.openInformation(getShell(), TITLE, NOT_FOUND);
				} else {
					selectInEditor(result);
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(getShell(), TITLE,
					UNEXPECTED_EXCEPTION);
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Implements the inherited method using an OCL query condition.
	 */
	private IQueryResult performQuery(Collection<EObject> context, String value,
			IProgressMonitor monitor)
		throws Exception {
		if (null == context) {
			throw new NullPointerException(ARGUMENT_CONTEXT_IS_NULL); //$NON-NLS-1$
		}

		// Build the select query statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(context), new WHERE(condition), monitor);

		// Execute query
		return statement.execute();
	}
	
	public boolean conditionIsSatisfied(EObject eObject){
		if(condition==null){
		  if(!validateQuery()){
			  return false;
		  }
		}
		if(condition!=null){
			return condition.isSatisfied(eObject);
		}
		return false;
//		Constraint invariant = null;
//		OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
//	    ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
//	    
//	    // create an OCL helper object
//	    OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();
//	    
//
//		try {
//		    // set the OCL context classifier
//		    helper.setContext(getContextClass());
//		    
//		    invariant = helper.createInvariant(
//		        "Library.allInstances()->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
//		} catch (ParserException e) {
//		    // record failure to parse
//		    System.err.println(e.getLocalizedMessage());
//		}

	}
	
	/**
	 * Validates the query statement.
	 * 
	 * @return <code>true</code> if I can finish; <code>false</code>, otherwise
	 */
	public boolean validateQuery() {
		boolean result = true;
		
		try {
			
			EClass contextClass = getContextClass();
			if(contextClass==null){
				setErrorSyntax(CONTEXT_TYPE_CANNOT_BE_BLANK);
				return false;
			}
			
			if(query==null || query.length()<1){
				setErrorSyntax(QUERY_CANNOT_BE_BLANK);
				return false;
			}
			
			
            OCL ocl = OCL.newInstance();
            condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
                ocl.getEnvironment(),
                query,
                contextClass);
			
			if (condition.getResultType(null).getInstanceClass() == Boolean.class) {
				setErrorSyntax("");
			} else {
				condition = null;
				result = false;
				setErrorSyntax(OCL_CONDITION_MUST_BE_A_BOOLEAN_EXPRESSION);
			}
		} catch (Exception e) {
			result = false;
			setErrorSyntax(e.getLocalizedMessage());
		}
		
		return result;
	}

	/**
	 * Find a registered packages to resolve the type to an EClass
	 * @return the EClass for the type
	 */
	public EClass getContextClass(){
		EPackage.Registry registry = EPackage.Registry.INSTANCE;	

		for (String key : getPackages()) {
			EPackage pack = registry.getEPackage(key);
		
			EClass eclass = (EClass)pack.getEClassifier(type);
			if(eclass!=null){
				return eclass;
			}
		}

		return null;
	}
	
	/**
	 * 
	 * @return Package uris registered with the packages extension point.
	 */
	public static String[] getPackages(){
		if(cachedOCLPackages ==null){
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
				OclQueryViewerPlugin.PLUGIN_ID, PACKAGES)
				 .getExtensions();
		
		List<String> packages = new ArrayList<String>();
		
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements =
					extensions[i].getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				if (configElements[j].getName().equals(PACKAGE)){
				     packages.add(configElements[j].getAttribute(URI));
				}
			}
		 }
		  cachedOCLPackages = new String[packages.size()];
		  cachedOCLPackages = packages.toArray(cachedOCLPackages);
		}
		
		return cachedOCLPackages;
		
	}

	@Override
	public OclQuery clone() {
		OclQuery copy = new OclQuery(name);
		copy.setErrorSyntax(syntaxErrors);
		copy.setQuery(query);
		copy.setType(type);
		return copy;
	}
	
	
}
