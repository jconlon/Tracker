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
package com.verticon.agriculture.core.model.validation;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;

import com.verticon.agriculture.AgriculturePackage;

public class Startup implements IStartup {

	public void earlyStartup() {
		EValidator.Registry.INSTANCE.put(
				AgriculturePackage.eINSTANCE,
				new EValidatorAdapter());

	}

}
