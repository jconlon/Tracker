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
package com.verticon.tracker.fair.validation;

import org.eclipse.emf.common.util.EList;

import com.verticon.tracker.fair.Exhibit;

/**
 * A sample validator interface for Exhibitor.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ExhibitorValidator {
	boolean validate();

	boolean validateFirstName(String value);
	boolean validateLastName(String value);
	boolean validateExhibits(EList<Exhibit> value);
	boolean validatePhone(String value);
	boolean validateParent(String value);
	boolean validateComments(String value);
	boolean validateStreet(String value);
	boolean validateCity(String value);
	boolean validateState(String value);
	boolean validateZip(String value);
}