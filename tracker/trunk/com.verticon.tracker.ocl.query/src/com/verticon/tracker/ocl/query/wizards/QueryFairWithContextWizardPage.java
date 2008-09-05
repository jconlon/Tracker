/**
 * 
 */
package com.verticon.tracker.ocl.query.wizards;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;

/**
 * @author jconlon
 *
 */
public class QueryFairWithContextWizardPage extends QueryWithContextWizardPage {

	private static String METACLASS_DEFAULT = QueryOCLMessages.oclQuery_fair_default_metaclass;
	private static String CONDITION_DEFAULT = QueryOCLMessages.oclQuery_fair_default_condition;
	
	
	@Override
	protected void setConditionText() {
		setConditionText(CONDITION_DEFAULT);
	}

	@Override
	protected EClassifier getDefaultSelection() {
		EClassifier defaultSelection = FairPackage.eINSTANCE
				.getEClassifier(METACLASS_DEFAULT);
		return defaultSelection;
	}

	@Override
	protected List<EClassifier> getPackageEClassifiers() {
		List<EClassifier> classes = new LinkedList<EClassifier>(
				FairPackage.eINSTANCE.getEClassifiers());
		return classes;
	}

}
