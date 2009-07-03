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
public class P2Policy extends Policy {
	public P2Policy() {
//		//User has no access to manipulate repositories
//		setRepositoryManipulator(new RepositoryManipulator(){
//
//			@Override
//			public AddRepositoryOperation getAddOperation(URI repoLocation) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public String getAddOperationLabel() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public URI[] getKnownRepositories() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public String getManipulatorButtonLabel() {
//				// TODO Auto-generated method stub
//				return "Manipulate";
//			}
//
//			@Override
//			public String getManipulatorInstructionString() {
//				// TODO Auto-generated method stub
//				return "Manipulate repos";
//			}
//
//			@Override
//			public String getManipulatorLinkLabel() {
//				// TODO Auto-generated method stub
//				return "Link label";
//			}
//
//			@Override
//			public RemoveRepositoryOperation getRemoveOperation(
//					URI[] repoLocations) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public String getRemoveOperationLabel() {
//				// TODO Auto-generated method stub
//				return "Remove Repository";
//			}
//
//			@Override
//			public RepositoryLocationValidator getRepositoryLocationValidator(
//					Shell shell) {
//				// TODO Auto-generated method stub
//				return new DefaultMetadataURLValidator();
//			}
//
//			@Override
//			public String getRepositoryNotFoundInstructionString() {
//				// TODO Auto-generated method stub
//				return "Repository Not Found";
//			}
//
//			@Override
//			public boolean manipulateRepositories(Shell shell) {
//				// TODO Auto-generated method stub
//				return true;
//			}});

		// XXX Use the pref-based repository manipulator
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

