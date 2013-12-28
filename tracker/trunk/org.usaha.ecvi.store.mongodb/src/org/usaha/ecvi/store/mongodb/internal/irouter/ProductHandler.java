package org.usaha.ecvi.store.mongodb.internal.irouter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static org.usaha.ecvi.store.mongodb.internal.EcviMongoComponent.bundleMarker;
import static org.usaha.ecvi.store.mongodb.internal.irouter.StatusAndConfigVariables.MONGO_PROVIDER_URI;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.google.common.collect.Iterables;

/**
 * 
 * Unwraps Envelopes containing Ecvi products sent from the consumer, stores
 * these in the ecviStore, and builds Envelopes for responding to the frontend
 * clients with disposition of the store.
 * 
 * @author jconlon
 * 
 */
public class ProductHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ProductHandler.class);
	private final Monitor monitor;
	private final BlockingQueue<Envelope> queryQueue;


	/**
	 * There maybe one or more IEcviStore service dependents
	 */
	private final List<IEcviStore> ecviStores = new CopyOnWriteArrayList<IEcviStore>();

	// Configuration variables of interest
	private String uri;

	public ProductHandler(Monitor monitorable,
			BlockingQueue<Envelope> queryQueue) {
		this.monitor = monitorable;
		this.queryQueue = queryQueue;
	}

	/**
	 * @param ecviStore
	 *            the ecviStore to set
	 */
	void unsetEcviStore(IEcviStore ecviStore) {
		this.ecviStores.remove(ecviStore);
	}

	/**
	 * @param ecviStore
	 *            the ecviStore to set
	 */
	void setEcviStore(IEcviStore ecviStore) {
		this.ecviStores.add(ecviStore);
	}

	void activate(Map<String, Object> config) {
		this.uri = (String) config.get(MONGO_PROVIDER_URI.configID);
	}

	void deactivate() {
		this.uri = null;
	}

	/**
	 * The envelope id must be a String object as that will be used to identify
	 * the caller.
	 * 
	 * @param envelope
	 * @throws IOException
	 * @throws EventCreationException
	 */
	void handle(final Envelope envelope) {
		String id = null;
		try {

			Ecvi ecvi = toEcvi(envelope.getValue());
			logger.debug(bundleMarker, "Recording Ecvi topic={}, scope={}",
					envelope.getIdentification(), envelope.getScope());
			record(ecvi);

			logger.info(bundleMarker, "Recorded Ecvi topic={}, scope={}",
					envelope.getIdentification(), envelope.getScope());
			monitor.incrementTotalEcvisRecorded();

			// Response
			if (envelope.getIdentification() instanceof String) {
				sendRegisterOK((String) envelope.getIdentification(),
						envelope.getScope());
			} else {
				logger.error(
						bundleMarker,
						"Failed to record Ecvi. Unknown Envelope identification type {}",
						id);
			}
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to record Ecvi.", e);
			sendRegisterException(e, id, envelope.getScope());
			monitor.add("Failed to record Ecvi", e);
			monitor.incrementTotalExceptions();
		}
	}

	private void record(Ecvi ecvi) throws IOException {
		for (IEcviStore ecviStore : ecviStores) {
			if (Iterables.contains(ecviStore.getURIs(), uri)) {
				ecviStore.record(ecvi, uri);
				return;
			}
		}
		throw new IOException("Could not find URL:" + uri + " in ecviStores:"
				+ ecviStores);
	}

	private void sendRegisterOK(String id, String scope) {
		if (isNullOrEmpty(id) || isNullOrEmpty(scope)) {
			logger.info(bundleMarker,
					"Not sending a response to the queryQuery because id or scope is empty");
			return;
		}
		String topicOut = id;
		if (topicOut.endsWith("/Ecvi/EMF")) {
			topicOut = topicOut.replace("Ecvi/EMF", "EcviResponse");
		}
		Envelope recordResults = new BasicEnvelope("OK".getBytes(), topicOut,
				scope);
		logger.debug(bundleMarker, "Queing OK to topic {} and scope {}",
				topicOut, scope);
		queryQueue.add(recordResults);
	}

	private void sendRegisterException(Exception e, String id, String scope) {
		if (isNullOrEmpty(id) || isNullOrEmpty(scope)) {
			logger.info(bundleMarker,
					"Not sending a response to the queryQuery because id or scope is empty");
			return;
		}
		String topicOut = id.replace("Evcvi/EMF", "EcviResponse");
		Envelope recordResults = new BasicEnvelope(e.getLocalizedMessage()
				.getBytes(), topicOut, scope);
		queryQueue.add(recordResults);
	}

	private static final Ecvi toEcvi(Object object) throws IOException {
		// It may already be an Ecvi
		if (object instanceof Ecvi) {
			return (Ecvi) object;
		}
		// It must be a byte
		checkArgument((object instanceof byte[]), "Payload must be a byte[]");
		byte[] payload = (byte[]) object;
		List<EObject> eol = toEObject(payload);
		if (eol == null || eol.isEmpty()) {
			return null;
		}

		if (eol.get(0) instanceof Ecvi) {
			return (Ecvi) eol.get(0);
		}
		throw new IOException(
				"There must be only an EObject in the payload. Found a "
						+ eol.get(0).getClass().getName() + " object instead.");

	}

	private static final List<EObject> toEObject(byte[] payload)
			throws IOException {
		checkNotNull(payload);
		checkArgument(payload.length > 0,
				"Payload must be greater than 0 bytes");
		ByteArrayInputStream ba = new ByteArrayInputStream(payload);
		Resource resource = new BinaryResourceImpl();
		File f = File.createTempFile("emf", ".binary");
		resource.setURI(URI.createFileURI(f.toString()));
		resource.load(ba, null);
		return resource.getContents();
	}

}
