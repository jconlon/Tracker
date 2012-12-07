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

/**
 * A wizard the prompts the user for an OCL constraint condition expression
 * and context type.
 */
public class QueryWithContextWizard
	extends AbstractQueryWizard {

	/**
	 * Initializes me.
	 */
	public QueryWithContextWizard(String pkgURIs) {
		super(pkgURIs);
	}

	@Override
	protected IOCLQueryWizardPage createOclQueryPage(String pkgURIs) {
		return new QueryWithContextWizardPage(pkgURIs);
	}
}
