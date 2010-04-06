package com.verticon.tracker.ocl.query.viewer.handlers;

import org.eclipse.core.commands.IHandler;

public class DefaultFairQueriesHandler extends DefaultPremisesQueriesHandler implements
		IHandler {

	public DefaultFairQueriesHandler() {
		super(DefaultFairQuery.getQueries());
	}
	
}
