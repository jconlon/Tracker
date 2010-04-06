package com.verticon.tracker.fair.validation;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.validation.adapter.expressions.EValidatorAdapter;

public class Startup implements IStartup {

	public void earlyStartup() {
		EValidator.Registry.INSTANCE.put(
				FairPackage.eINSTANCE,
				new EValidatorAdapter());

	}

}
