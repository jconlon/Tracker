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

package com.verticon.tracker.validation.adapter;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.validation.adapter.expressions.EValidatorAdapter;


/**
 * Installs an EMF <code>EValidator</code> on the Library package when we
 * start up.  This validator adapts EMF's <code>EValidator</code> API to the
 * EMF Model Validation Service API.
 */
public class Startup
	implements IStartup {

	/**
	 * Initializes me.
	 */
	public Startup() {
		super();
	}

	/**
	 * Install the validator.
	 */
	public void earlyStartup() {
		EValidator.Registry.INSTANCE.put(
			TrackerPackage.eINSTANCE,
			new EValidatorAdapter());
	}
}
