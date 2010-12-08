package com.verticon.tracker.irouter.trutest.dev.sim.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.equinoxosgi.toast.devsim.IDeviceSimulator;
import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;
import com.verticon.tracker.irouter.trutest.dev.AbstractIndicator;
import com.verticon.tracker.irouter.trutest.dev.ITruTestIndicator;

/**
 * Dynamic Web page simulator of a TruTest XR3000 Indicator with display
 * fields and controls for actuating behavior of the indicator.  Simulates
 * an Indicator attached as a Server connection.
 * 
 * Type of Server connection is determined by the property trutest.sim.type,
 * with the default a ServerSocket.
 * 
 * Connection state from the iRouter client components to the Server is shown as
 * a display with a Y/N value. The server connection can be either socket or com
 * port and for Server socket it is specified by the property trutest.sim.socket
 * with the default 2344. Server Comm Port is determined by the property
 * trutest.sim.port and there is no default.
 * 
 * On connection the iRouter components will download current Indicator records,
 * and upload new indicator records. The number of records up/downloaded are
 * shown on the simulator as Download and Upload fields.
 * 
 * Two Display fields simulate the two TruTest custom File Data Fields. The
 * labels and units assigned to these display fields are specified by the
 * properties: trutest.sim.field8.label trutest.sim.field8.units
 * trutest.sim.field9.label trutest.sim.field9.units
 * 
 * An EID selector presents a drop down list of EID values created from the list
 * of EID numbers uploaded to the server.
 * 
 * The last controls simulate the weighing of animals. These can be incremented
 * by manual button press for each increment or weights can be automatically
 * incremented by a single button press.
 * 
 * Lastly a record control is used to record the transaction.
 * 
 * 
 * @author jconlon
 * 
 */
public class SimulatedIndicatorServer extends AbstractIndicator implements ITruTestIndicator,
		IDeviceListener, IDeviceSimulatorListener {
	
	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.dev.sim";
	
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(SimulatedIndicatorServer.class);
	
	private static final String FIELD = "FIELD";
	private static final String EID = "EID";
	private static final String UPLOADED = "Uploaded";
	private static final String DOWNLOADED = "Downloaded";
	private static final String RECORD = "Record";
	private static final String MY_PREFIX = "trutest.sim.";
	private static final String TRUTEST_SCALEHEAD = "TruTest Indicator";
	private static final String CONNECTION = "Connection";
	private static final String WEIGHT = "Weight";
	private IDeviceSimulator simulator;
	private WeightSensor weightSensor;
	private RecordSensor recordSensor;
	private EIDSensor eidActuator;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimulatedIndicatorServer [" + MY_PREFIX
				+ getProperty(Property.TYPE) + "]";
	}

	/**
	 * DS binding to add a device simulator
	 * 
	 * @param value
	 */
	public void setDevSim(IDeviceSimulator value) {
		simulator = value;
	}

	/**
	 * DS activate
	 */
	public void startup() {
		addDefaultEIDS();
		simulator.registerDevice(TRUTEST_SCALEHEAD, TRUTEST_SCALEHEAD);
		simulator.addBooleanActuator(TRUTEST_SCALEHEAD, CONNECTION, CONNECTION);
		simulator.addIntegerActuator(TRUTEST_SCALEHEAD, DOWNLOADED, DOWNLOADED,
				"records");
		simulator.addIntegerActuator(TRUTEST_SCALEHEAD, UPLOADED, UPLOADED,
				"records");
		String label = PropertyManager.getProperty(MY_PREFIX + "field8.label",
				"FD Display One");
		String units = PropertyManager.getProperty(MY_PREFIX + "field8.units",
				"");
		simulator.addStringActuator(TRUTEST_SCALEHEAD, FIELD + 8, label, units);
		label = PropertyManager.getProperty(MY_PREFIX + "field9.label",
				"FD Display Two");
		units = PropertyManager.getProperty(MY_PREFIX + "field9.units", "");
		simulator.addStringActuator(TRUTEST_SCALEHEAD, FIELD + 9, label, units);
		eidActuator = new EIDSensor(EID, EID, this, eids);
		simulator.addParameter(eidActuator, TRUTEST_SCALEHEAD);
		weightSensor = new WeightSensor(WEIGHT, WEIGHT, 0, 130.5, 0, .5, 10,
				"kg", this);
		simulator.addParameter(weightSensor, TRUTEST_SCALEHEAD);
		recordSensor = new RecordSensor(RECORD, RECORD, RECORD, this);
		simulator.addParameter(recordSensor, TRUTEST_SCALEHEAD);
		log.debug(bundleMarker, "Started");
	}

	/**
	 * DS deactivate
	 */
	public void shutdown() {
		simulator.unregisterDevice(TRUTEST_SCALEHEAD);
	}

	@Override
	public void setWeight(Double weight) {
		try {
			super.setWeight(weight);
			if (weight == 0) {
				clearValues();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Send a Weight Recorded command to the client.
	 */
	@Override
	public void pressRecordKey() {
		if (isConnected) {
			try {
				super.pressRecordKey();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * Handle the i/o.
	 * 
	 */
	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
		simulator.setBooleanValue(TRUTEST_SCALEHEAD, CONNECTION, true);
		super.connected(out, in);
		simulator.setBooleanValue(TRUTEST_SCALEHEAD, CONNECTION, false);
	}

	@Override
	protected void uploadRecords(String request){
		super.uploadRecords(request);
		simulator.setIntegerValue(TRUTEST_SCALEHEAD, UPLOADED,
				uploadedRecords);
	}
	
	@Override
	protected void handleFields(String control, String value) {
		log.debug(bundleMarker, "Handling control={} value={}", control, value);
		System.out.println(this+"Handling control="+control+" value="+value);
		if (control.endsWith("8")) {
			simulator.setStringValue(TRUTEST_SCALEHEAD, FIELD + 8, value);
		} else if (control.endsWith("9")) {
			simulator.setStringValue(TRUTEST_SCALEHEAD, FIELD + 9, value);
		}else{
			//Consider all other values sent in as EID if parsed as long
			try {
				Long l = Long.parseLong(value);
				simulator.setLongValue(TRUTEST_SCALEHEAD, EID,l);
			} catch (NumberFormatException e) {
				log.error(bundleMarker, "Failed to handle control="+control+" value="+value,e);
			}
			
		}
	}

	/**
	 * 
	 * @return next line for the download or null if there is no more data
	 * @throws IOException
	 */
	@Override
	protected String getDownloadData() throws IOException {
		String result = super.getDownloadData();
		simulator.setIntegerValue(TRUTEST_SCALEHEAD, DOWNLOADED,
				downloadedRecords);
		return result;
	}

	@Override
	public void readEIDTag(long eid) {
		if (isConnected) {
			try {
				super.readEIDTag( eid);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
	}

	@Override
	public void performAction(String name, String actionName) {
		log.debug(bundleMarker, "Perform Action name={} actionName={}", name,
				actionName);
		if (name.equals(RECORD)) {
			pressRecordKey();
		}
	}

	@Override
	public void valueChanged(String name, boolean newValue) {
		log.debug(bundleMarker, "Boolean Value Changed name={} newValue={}",
				name, newValue);
	}

	@Override
	public void valueChanged(String name, int newValue) {
		log.debug(bundleMarker, "Integer Value Changed name={} newValue={}",
				name, newValue);
	}

	@Override
	public void valueChanged(String name, long newValue) {
		log.debug(bundleMarker, "Long Value Changed name={} newValue={}", name,
				newValue);
		if (name.equals(EID)) {
			readEIDTag(newValue);
		}
	}

	@Override
	public void valueChanged(String name, double newValue) {
		log.debug(bundleMarker, "Double Value Changed name={} newValue={}",
				name, newValue);
		if (name.equals(WEIGHT)){
			setWeight(newValue);
		}
	}

	/**
	 * When the weight goes to zero, clear tag field to zero as well.
	 */
	private void clearValues() {
		eidActuator.setValue(0);

	}

	/**
	 * Some fake data if there was no uploads.
	 */
	private void addDefaultEIDS() {
		eids.add(840003002956502l);
		eids.add(840003002956449l);
		eids.add(985152001175459l);
		eids.add(985152001175711l);
		eids.add(985152001389613l);
		eids.add(985120025869547l);
	}
}
