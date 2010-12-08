package com.verticon.tracker.irouter.trutest.test.system.internal;

import static com.verticon.tracker.irouter.trutest.test.system.internal.TruTestSystemTest.bundleMarker;
import static org.junit.Assert.assertFalse;

import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock producer of Strings that are TruTest commands.
 * 
 * @author jconlon
 * 
 */
public class MockProducer implements Producer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MockProducer.class);

	 Wire[] wires = null;
	 String pid = null;

	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockProducer [pid=" + pid + "]";
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		
		if(wires==null || wires.length==0){
			logger.info(bundleMarker, "{} disconnected from all consumers",this);
			return;
		}
		for (Wire wire : wires) {
			if(pid==null){
				pid = (String) wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID);
			}else if(!pid.equals((String) wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID))){
				assertFalse(!pid.equals((String) wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID)));
			}
			logger.info(bundleMarker, "{} connected to consumer={}",
					this,wire.getProperties().get(WireConstants.WIREADMIN_CONSUMER_PID));
		}
	}

	void send(Object value) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value={}, No wires", value);
			return;
		}
		for (Wire wire : wires) {
			wire.update(value);
			logger.info(bundleMarker, "{} Sending {} to consumer={} wirescope={}", 
					new Object[]{this, value, wire.getProperties().get(WireConstants.WIREADMIN_CONSUMER_PID),
					wire.getScope()});
		}
	}

}
