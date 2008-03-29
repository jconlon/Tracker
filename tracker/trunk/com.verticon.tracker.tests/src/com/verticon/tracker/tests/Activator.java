package com.verticon.tracker.tests;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator instance;
	private BundleContext context;
	
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		this.context=context;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		instance=null;
		super.stop(context);
	}
	
	public static Activator INSTANCE(){
		return instance;
	}

	public BundleContext getContext() {
		return context;
	}

}
