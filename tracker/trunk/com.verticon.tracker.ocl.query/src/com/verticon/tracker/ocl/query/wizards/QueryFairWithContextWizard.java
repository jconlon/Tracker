package com.verticon.tracker.ocl.query.wizards;

public class QueryFairWithContextWizard extends QueryWithContextWizard {

	@Override
	protected IOCLQueryWizardPage createOclQueryPage() {
		return new QueryFairWithContextWizardPage();
	}

}
