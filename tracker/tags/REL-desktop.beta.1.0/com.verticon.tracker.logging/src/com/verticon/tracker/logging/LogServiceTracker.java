package com.verticon.tracker.logging;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class LogServiceTracker extends ServiceTracker {

	@Override
	public Object addingService(ServiceReference reference) {
		Object service = context.getService(reference);

		if (service instanceof LogReaderService) {
			((LogReaderService) service)
					.addLogListener(new LogListener(context));
		}
		// else if(service instanceof ExtendedLogReaderService)
		return super.addingService(reference);
	}

	public LogServiceTracker(BundleContext context, Filter filter) {
		super(context, filter, null);
	}

}