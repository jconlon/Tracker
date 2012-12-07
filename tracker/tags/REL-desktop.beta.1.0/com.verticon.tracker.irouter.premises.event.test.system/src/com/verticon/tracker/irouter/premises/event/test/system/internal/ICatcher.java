package com.verticon.tracker.irouter.premises.event.test.system.internal;

import org.osgi.service.wireadmin.Envelope;

public interface ICatcher {

	Envelope getLastEnvelope();

	void clear();

	int getNumberOfConnections();
}
