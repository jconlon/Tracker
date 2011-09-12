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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Wrapper that encapsulates an OCL Query
 * 
 * @author jconlon
 * 
 */
public interface IOclQuery extends Runnable {

	/**
	 * 
	 * @return true if the query is valid
	 */
	boolean validateQuery();

	/**
	 * 
	 * @return name of the query
	 */
	String getName();

	/**
	 * 
	 * @param name of the query
	 */
	void setName(String name);

	/**
	 * Set the type of object to select with the query.
	 * 
	 * @param type
	 */
	void setType(String type);

	String getType();

	/**
	 * OCL query statement
	 * 
	 * @param query statement
	 */
	void setQuery(String query);

	/**
	 * 
	 * @return query statement
	 */
	String getQuery();

	/**
	 * Description of any syntax errors associated with query
	 * 
	 * @param description
	 */
	void setErrorSyntax(String description);

	String getErrorSyntax();
	
	/**
	 * Find a registered packages to resolve the type to an EClass
	 * @return the EClass for the type
	 */
	EClass getContextClass();
	
	/**
	 *  Computes the boolean value resulting from evaluating the constraint
	 * condition on the specified <code>eObject</code>.
	 */
	boolean conditionIsSatisfied(EObject eObject);

}
