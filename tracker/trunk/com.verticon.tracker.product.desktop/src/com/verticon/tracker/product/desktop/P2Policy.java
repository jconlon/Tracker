/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.product.desktop;

import org.eclipse.equinox.internal.provisional.p2.ui.policy.ColocatedRepositoryManipulator;
import org.eclipse.equinox.internal.provisional.p2.ui.policy.IUViewQueryContext;
import org.eclipse.equinox.internal.provisional.p2.ui.policy.Policy;

/**
 * P2Policy defines the RCP policies for the p2 UI. The policy
 * is registered as an OSGi service when the example bundle starts.
 * 
 * @since 3.5
 */
@SuppressWarnings("restriction")
public class P2Policy extends Policy {
	public P2Policy() {


		//Use the pref-based repository manipulator
		setRepositoryManipulator(
				new ColocatedRepositoryManipulator(
						this, PreferenceConstants.PREF_PAGE_SITES));
		
		//Default view is by category
		IUViewQueryContext queryContext = new IUViewQueryContext(
				IUViewQueryContext.AVAILABLE_VIEW_BY_CATEGORY);
		setQueryContext(queryContext);
	}
	/**
	 * @since 3.4
	 */
    class PreferenceConstants {
		public static final String PREF_PAGE_PROVISIONING = "org.eclipse.equinox.internal.p2.ui.sdk.ProvisioningPreferencePage"; //$NON-NLS-1$
		public static final String PREF_PAGE_SITES = "org.eclipse.equinox.internal.p2.ui.sdk.SitesPreferencePage"; //$NON-NLS-1$
		public static final String PREF_SHOW_LATEST_VERSION = "showLatestVersion"; //$NON-NLS-1$
		public static final String PREF_OPEN_WIZARD_ON_ERROR_PLAN = "allowNonOKPlan"; //$NON-NLS-1$
	}

	
}

