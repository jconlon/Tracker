package com.verticon.tracker.irouter.premises.animal.test.system.internal;

import org.osgi.service.wireadmin.Envelope;

public interface ICatcher {

	Envelope getLastEnvelope();

	void clear();

	int getNumberOfConnections();
}
