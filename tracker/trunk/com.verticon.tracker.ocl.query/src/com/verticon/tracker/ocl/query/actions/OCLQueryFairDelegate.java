/**
 * 
 */
package com.verticon.tracker.ocl.query.actions;

import com.verticon.tracker.ocl.query.wizards.QueryFairWithContextWizard;
import com.verticon.tracker.ocl.query.wizards.QueryWithContextWizard;

/**
 * @author jconlon
 *
 */
public class OCLQueryFairDelegate extends OCLQueryDelegate {

	@Override
	protected QueryWithContextWizard getWizard() {
		QueryWithContextWizard wizard = new QueryFairWithContextWizard();
		return wizard;
	}

}
