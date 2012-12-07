/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

/**
 * @author jconlon
 * 
 */
public class ValidationException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ValidationException(EObject eObject, String message) {
		super(eObject.eClass().getName() + " is not valid. " + message);
	}

}
