/**
 * 
 */
package com.verticon.tracker.irouter.ohaus.internal;

import static com.verticon.tracker.irouter.ohaus.ConfigKey.getPollMillisDelay;
import static com.verticon.tracker.irouter.ohaus.internal.OhausProducer.bundleMarker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jconlon
 *
 */
public class OhausPollingProxy extends OhausProxy {

	private static final String UNSTABLE_MARKER = "?";
	private static final String REGEX_DOUBLE_FILTER = "[^0-9-/.]";
	private final long pollDelay;

	/**
	 * @param ohausProducer
	 */
	public OhausPollingProxy(OhausProducer ohausProducer) {
		super(ohausProducer);
		Map<String, Object> config = ohausProducer.getConfig();
		this.pollDelay = getPollMillisDelay(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.ohaus.internal.OhausProxy#afterRead()
	 */
	@Override
	protected void afterRead(Writer out, BufferedReader in) throws IOException,
			InterruptedException {
		TimeUnit.MILLISECONDS.sleep(pollDelay);
		poll(out, in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.ohaus.internal.OhausProxy#
	 * sendInitializeScalePrintCommands(java.io.Writer, java.io.BufferedReader)
	 */
	@Override
	protected void sendInitializeScalePrintCommands(Writer out,
			BufferedReader in) throws IOException, InterruptedException {
		// Override and do not set any print commands
		poll(out, in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.ohaus.internal.OhausProxy#handle(java.lang
	 * .String)
	 */
	@Override
	protected void handle(String rawresponse) throws InterruptedException,
			IOException {
		if (rawresponse == null) {
			throw new IOException("End of Stream");
		}
		boolean isUnstable = rawresponse.contains(UNSTABLE_MARKER);
		String response = rawresponse.replaceAll(REGEX_DOUBLE_FILTER, "");

		if (isUnstable) {
			if (isReset(Double.parseDouble(response))) {
				if (!enabled) {
					enabled = true;
					log.info("Reset at {}", response);
				}
			}
			return;
		}
		super.handle(response);
	}

	private void poll(Writer out, BufferedReader in) throws IOException,
			InterruptedException {
		log.debug(bundleMarker, "{} Sending  POLL command={}", this,
				Command.POLL.ascii);
		out.write(Command.POLL.fromAscii());
		out.flush();

	}

	private boolean isReset(double value) {
		return value < minimumWeightThreshold;
	}
}
