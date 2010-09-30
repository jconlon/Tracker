package com.verticon.tracker.irouter.common;

import java.util.concurrent.ExecutionException;

import org.osgi.framework.BundleContext;

public interface IService {

	public abstract void start(BundleContext bc) throws InterruptedException,
			ExecutionException;

	public abstract void stop();

}