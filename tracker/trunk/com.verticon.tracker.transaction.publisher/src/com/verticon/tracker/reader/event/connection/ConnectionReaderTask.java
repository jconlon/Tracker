package com.verticon.tracker.reader.event.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.concurrent.Callable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.AbstractConnectionReader;

/**
 * Sends tagIDs obtained from a target uri via the OSGi ConnectorService to a
 * tagIdPublisher.
 * 
 * @author jconlon
 * 
 */
public class ConnectionReaderTask implements Callable<RefreshablePublisher> {

	final Logger logger = LoggerFactory.getLogger(ConnectionReaderTask.class);
	private final String target;
	private final BundleContext bundleContext;
	private final RefreshablePublisher eventReader;

	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param tagIdPublisher
	 *            to send tagIds
	 * @param target
	 *            of Connection
	 */
	public ConnectionReaderTask(AbstractConnectionReader eventReader, 
			BundleContext bundleContext) {
		this.target = eventReader.getTarget().toString();
		this.eventReader=eventReader;
		this.bundleContext = bundleContext;
	}

	/**
	 * Call that reads tagIds from the target connection. Can be canceled
	 * with a thread interruption.
	 */
	public RefreshablePublisher call() throws Exception {
		ConnectorService cs = getConnectorService();
		BufferedReader rin = null;
		InputStream in = null;
		Exception ex = null;
		try {
			in = cs.openInputStream(target);
			rin = new BufferedReader(new InputStreamReader(in));
			logger.info("{} Connected", target);
			while (!Thread.currentThread().isInterrupted()) {
				String line = rin.readLine();
				sendTag(line);
			}
		} catch (InterruptedIOException e) {
			Thread.currentThread().interrupt();
			logger.info("Connection {} Interrupted while waiting for input.",
					target);
		} catch (IOException e) {
			if (!Thread.currentThread().isInterrupted()) {
				logger.error("Connection " + target + " Failed.", e);
			} else {
				logger.info("Connection {} Interrupted", target);
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					logger.error("Connection " + target + " failed to close.",
							e);
				}
		}
		if (ex != null) {
			throw ex;
		}
		return eventReader;
	}

	private void sendTag(String s) {
		Long tag;
		try {
			tag = Long.parseLong(s);
		} catch (NumberFormatException e) {
			logger.warn("Failed to parse string {} from connection {}.", s,
					target);
			return;
		}
		eventReader.publish(tag);
		logger.info("ConnectionReader {} published {}", target, tag);
	}

	private ConnectorService getConnectorService() throws IOException {
		ServiceReference sr = bundleContext
				.getServiceReference(ConnectorService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ConnectorService.");
		}

		ConnectorService cs = (ConnectorService) bundleContext.getService(sr);

		if (sr == null) {
			throw new IOException("Failed to find a ConnectorService.");
		}

		return cs;

	}

}
