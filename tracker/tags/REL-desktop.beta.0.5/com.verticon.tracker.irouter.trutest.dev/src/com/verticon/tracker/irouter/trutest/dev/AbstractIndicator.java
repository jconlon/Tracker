package com.verticon.tracker.irouter.trutest.dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.equinoxosgi.util.PropertyManager;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * An abstract implementation of a TruTest Indicator used for the Fake and Simulated devices.
 * @author jconlon
 *
 */
public abstract class AbstractIndicator implements IDeviceListener,
		ITruTestIndicator {

	protected static final String MY_PREFIX = "abstract.";
	
	/**
	 * Identify the plugin to the logger
	 */
	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.dev";
	
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	/**
	 * slf4j Logger
	 */
	protected Logger log = LoggerFactory.getLogger(AbstractIndicator.class);
	
	protected Double weight = new Double(0);
	protected long eid;
	private URL downloadURL = null;
	protected final AtomicBoolean recordKey = new AtomicBoolean();
	protected final BlockingQueue<String> commandQueue = new LinkedBlockingQueue<String>();
	protected final Map<String, String> values = new HashMap<String, String>();
	protected int uploadedRecords;
	protected int downloadedRecords;
	private String selectionControl = null;
	private String sizeControl = null;
	private BufferedReader fileReader = null;
	private boolean downloadFinished = false;
	protected List<Long> eids = new CopyOnWriteArrayList<Long>();
	protected boolean isConnected;

	private static String trimControl(String message) {
		return message.substring(3, message.lastIndexOf('}'));
	}

	@Override
	public Object getProperty(Property prop) {
		switch (prop) {
		case PREFIX:
			return MY_PREFIX;
		case TYPE:
			String type = PropertyManager.getProperty(MY_PREFIX
					+ Property.TYPE.toString().toLowerCase(),
					Constants.DeviceType.SERVER_SOCKET.name()// default is a
																// serversocket
					);
			return Constants.DeviceType.valueOf(type);
		case SOCKET:
			Object result = PropertyManager.getProperty(MY_PREFIX
					+ prop.toString().toLowerCase(), "2344"

			);
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}

			if (result instanceof String) {
				return new Integer((String) result);

			} else {
				throw new IllegalArgumentException("Unknown property type "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}

		default:
			result = PropertyManager.getProperty(MY_PREFIX
					+ prop.toString().toLowerCase());
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}
			return result;
		}
	}

	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
		isConnected = true;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		log.info(bundleMarker, "Connected");
		
		String line = null;
		while ((line = reader.readLine()) != null
				&& !Thread.currentThread().isInterrupted()) {
			String reply = process(line);
			if (reply != null) {
				writer.write(reply);
				writer.flush();
				log.debug(bundleMarker, "Replying {}", reply);
			} else {
				log.debug(bundleMarker, "NOT Replying");
			}

		}

		log.info(bundleMarker, "Disconnected");
		isConnected = false;
		
	}

	private String process(String request) throws InterruptedException {
		log.debug(bundleMarker, "Request {}", request);
		if (request.startsWith("{FD}")){//Resets download to first record
			resetDownloadStatus();
			return "\r\n";
		}
		if (request.startsWith("{FN}")) {//Get next download record
			try {
				return getDownloadData();
			} catch (IOException e) {
				log.error(bundleMarker, "Failed to download", e);
				return "[]" + "\r\n";
			}
		}
		if (request.startsWith("{RP}")) {//poll command
			String response = commandQueue.poll(10, TimeUnit.MILLISECONDS);
			if (response != null) {
				return response;
			}
		}
		// "{SXD28}\r\n{SXC26}\r\n333.11\r\n";
		if (request.startsWith("{SXD")) {
			selectionControl = trimControl(request);
			log.debug(bundleMarker, "Set selectionControl={}", selectionControl);
		} else if (request.startsWith("{SXC")) {
			sizeControl = trimControl(request);
			log.debug(bundleMarker, "Set sizeControl={}", sizeControl);
		}
		// Beep "{SABP500}%13%"
		else if (request.startsWith("{SABP")) {
			values.put("BEEP", request.substring(5, request.lastIndexOf('}')));
			log.debug(bundleMarker, "Beeping for {} msecs", values.get("BEEP"));
			beep(Integer.parseInt(values.get("BEEP")));
			// {FU985152001389613,1111,0.01,1}
		} else if (request.startsWith("{FU")) {
			uploadRecords(request);

		} else if (!request.startsWith("{")) {
			log.debug(bundleMarker, "Handling {}", request);
			values.put(selectionControl + sizeControl, request);
			log.debug(bundleMarker, "Set key={} value={}", selectionControl
					+ sizeControl, values.get(selectionControl + sizeControl));
			handleFields(selectionControl, request);
		} else {
			log.debug(bundleMarker, "Ignoring {}", request);
		}

		return "\r\n";
	}

	private void resetDownloadStatus() {
		String file = "test-downloaded-raw.txt";
		downloadURL = FrameworkUtil.getBundle(this.getClass())
				.getResource(file);
		log.debug(bundleMarker, "URL of Download file = {}", downloadURL);

		downloadFinished = false;
		uploadedRecords = 0;
		downloadedRecords = 0;
		fileReader = null;
	}

	protected void handleFields(String selectionControl2, String request) {
		// Do nothing here
	}

	protected void uploadRecords(String request) {
		if (uploadedRecords == 0) {
			eids.clear();
		}
		uploadedRecords++;
		String eid = null;
		try {
			eid = request.substring(3, request.indexOf(','));
			eids.add(Long.parseLong(eid));
		} catch (NumberFormatException e) {
			log.warn(bundleMarker, "Failed to add eid <" + eid + '>', e);
		}
		log.debug(bundleMarker, "Uploaded message {} number {}", request,
				uploadedRecords);
	}

	/**
	 * 
	 * @return next line for the download or null if there is no more data
	 * @throws IOException
	 */
	protected String getDownloadData() throws IOException {
		if (!downloadFinished) {
			if (fileReader == null) {
				log.info(bundleMarker,
						"Downloading a mock dataset as a download file: {}",
						downloadURL);
				fileReader = new BufferedReader(new InputStreamReader(
						downloadURL.openStream()));
			}
			String fileLine = null;
			if ((fileLine = fileReader.readLine()) != null) {
				log.debug(bundleMarker, "Download read record {} at line {}",
						fileLine, downloadedRecords);
				downloadedRecords++;
				log.debug(bundleMarker, "Sending {} as record number {}",
						fileLine, downloadedRecords);
				return fileLine + "\r\n";
			} else {
				log.debug(bundleMarker,
						"Download closing the download file {}", downloadURL);
				fileReader.close();
				downloadFinished = true;
			}

		} else {
			log.info(bundleMarker,
					"Download finished downloading {} records from {}",
					downloadedRecords, downloadURL);
		}
		return "[]" + "\r\n";
	}

	@Override
	public Double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(Double weight) throws InterruptedException {
		this.weight = weight;
		if (isConnected) {
			commandQueue.put("[WS" + weight + "]\r\n");
		}
	}

	@Override
	public long getEID() {
		return eid;
	}

	@Override
	public void readEIDTag(long eid) throws InterruptedException {
		this.eid = eid;
		commandQueue.put("[ID" + eid + "]\r\n");
	}

	@Override
	public Map<String, String> getValues() {
		return values;
	}

	@Override
	public void pressRecordKey() throws InterruptedException {
		recordKey.set(true);
		commandQueue.put("[WR" + weight + "]\r\n");
		log.debug(bundleMarker, "Recorded Weight={}", weight);
	}

	@Override
	public void beep(int msecs) {
		try {
			Tone.sound(2000, msecs);
		} catch (Exception e) {
			log.error(bundleMarker, "Failed to beep", e);
		}
	}

}