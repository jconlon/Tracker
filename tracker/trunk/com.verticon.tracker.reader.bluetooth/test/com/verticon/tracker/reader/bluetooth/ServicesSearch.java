package com.verticon.tracker.reader.bluetooth;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.bluetooth.DataElement;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;

/**
 *
 * Minimal Services Search example.
 */
public class ServicesSearch {

	private static final UUID OBEX_OBJECT_PUSH = new UUID(0x1105);

	private static final UUID OBEX_FILE_TRANSFER = new UUID(0x1106);

	private static final UUID HID = new UUID(0x1124);
	
	private final static UUID RFCOMM = new UUID(0x0003);
	

	public static final Vector/* <String> */ serviceFound = new Vector();

	public static void main(String[] args) throws IOException, InterruptedException {

		// First run RemoteDeviceDiscovery and use discoved device
		RemoteDeviceDiscovery.main(null);

		serviceFound.clear();

		UUID serviceUUID = HID;
		if ((args != null) && (args.length > 0)) {
			serviceUUID = new UUID(args[0], false);
		}

		final Object serviceSearchCompletedEvent = new Object();

		DiscoveryListener listener = new DiscoveryListener() {

			@Override
			public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
			}

			@Override
			public void inquiryCompleted(int discType) {
			}

			@Override
			public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
				for (int i = 0; i < servRecord.length; i++) {
					String url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
					if (url == null) {
						continue;
					}
					serviceFound.add(url);
					DataElement serviceName = servRecord[i].getAttributeValue(0x0100);
					if (serviceName != null) {
						System.out.println("service " + serviceName.getValue() + " found " + url);
					} else {
						System.out.println("service found " + url);
					}
				}
			}

			@Override
			public void serviceSearchCompleted(int transID, int respCode) {
				System.out.println("service search completed!");
				synchronized (serviceSearchCompletedEvent) {
					serviceSearchCompletedEvent.notifyAll();
				}
			}

		};

		// UUID[] searchUuidSet = new UUID[] { serviceUUID };
		UUID[] searchUuidSet = new UUID[] { HID, RFCOMM };
		int[] attrIDs = new int[] { 0x0100 // Service name
		};

		for (Enumeration en = RemoteDeviceDiscovery.devicesDiscovered.elements(); en.hasMoreElements();) {
			RemoteDevice btDevice = (RemoteDevice) en.nextElement();

			synchronized (serviceSearchCompletedEvent) {
				String devName = "unknown";
				try {
					devName = btDevice.getFriendlyName(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(
"search services on " + btDevice.getBluetoothAddress() + " " + devName);
				LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, btDevice,
						listener);
				serviceSearchCompletedEvent.wait();
			}
		}

	}

}