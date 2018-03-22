package com.verticon.tracker.editor.ocl.enablement;

import java.util.Collection;

import com.verticon.emf.ui.api.IOclQuerySpec;
import com.verticon.emf.ui.api.IOclQuerySpecLoader;
import com.verticon.emf.ui.api.IOclQueryWizardPrompts;

public class Component implements IOclQuerySpecLoader, IOclQueryWizardPrompts {

	@Override
	public Collection<IOclQuerySpec> getQuerySpecs() {
		return DefaultPremisesQuery.getQuerySpecs();
	}

	@Override
	public String getContextFreePrompt() {
		return "-- Select all MoveOut Events that have no destinationPin defined\n"
				+ "self.destinationPin.oclIsUndefined()";
	}

	@Override
	public String getOclQueryPrompt() {
		return "-- Select Animals with a MovedIn event that do not have a sourcePin assigned\n"
				+ " Event.allInstances()->select(e : Event | e.id=self.id and e.oclIsTypeOf(MovedIn) and e.oclAsType(MovedIn).sourcePin.oclIsUndefined() )->size()>0";

	}

}
