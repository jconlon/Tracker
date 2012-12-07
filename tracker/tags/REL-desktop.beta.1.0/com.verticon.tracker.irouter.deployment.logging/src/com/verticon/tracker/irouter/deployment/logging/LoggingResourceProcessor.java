package com.verticon.tracker.irouter.deployment.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.osgi.service.deploymentadmin.spi.DeploymentSession;
import org.osgi.service.deploymentadmin.spi.ResourceProcessor;
import org.osgi.service.deploymentadmin.spi.ResourceProcessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ResourceProcessor for changing the logging properties configuration by copying
 * the contents of a log4j.properties file from the deployment package over the Karaf
 * default logging properties file.
 * @author jconlon
 *
 */
public class LoggingResourceProcessor implements ResourceProcessor {

	private static final String DEFAULT_PROPERTIES_FILE = "/opt/apache-felix-karaf-1.2.0/etc/org.ops4j.pax.logging.cfg";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(LoggingResourceProcessor.class);

	private DeploymentSession m_session = null;

	@Override
	public void begin(DeploymentSession session) {
		m_session = session;
	}

	@Override
	public void cancel() {

	}

	@Override
	public void commit() {

	}

	@Override
	public void dropAllResources() throws ResourceProcessorException {

	}

	@Override
	public void dropped(String arg0) throws ResourceProcessorException {

	}

	@Override
	public void prepare() throws ResourceProcessorException {
		
	}

	/**
	 * Copies a logging properties file from the Deployment Package over the 
	 * Karaf default logging properties file.
	 */
	@Override
	public void process(String arg0, InputStream inputStream)
			throws ResourceProcessorException {
		// initial validation
		if (m_session == null) {
			throw new ResourceProcessorException(
					ResourceProcessorException.CODE_OTHER_ERROR,
					"Can not process resource without a Deployment Session");
		}
		
		Reader in = new InputStreamReader(inputStream);
		try {
			FileWriter out = new FileWriter(
					DEFAULT_PROPERTIES_FILE);
			int c;

			while ((c = in.read()) != -1)
				out.write(c);

			in.close();
			out.close();
			logger.info("Loaded and configured properties.");
		} catch (IOException e) {
			logger.error("Failed to load properties file.",e);
		}

	}

	@Override
	public void rollback() {
	}

}
