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
package com.verticon.tracker.validation;

import com.verticon.tracker.Treatment;
import com.verticon.tracker.TreatmentMethod;

/**
 * A sample validator interface for {@link com.verticon.tracker.MedicalTreatment}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MedicalTreatmentValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateProduct(String value);
	boolean validateManufacturer(String value);
	boolean validateLot(String value);
	boolean validateQuantity(String value);
	boolean validateTreatment(Treatment value);
	boolean validateMethod(TreatmentMethod value);
}
