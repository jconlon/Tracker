package com.verticon.tracker.reader.bluetooth;

import java.io.IOException;
import java.util.Vector;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

/**
 * Minimal Device Discovery example.
 */
public class RemoteDeviceDiscovery {

	public static final Vector<RemoteDevice> devicesDiscovered = new Vector<RemoteDevice>();

	public static void main(String[] args) throws IOException, InterruptedException {

		final Object inquiryCompletedEvent = new Object();

		devicesDiscovered.clear();

		DiscoveryListener listener = new DiscoveryListener() {

			@Override
			public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
				System.out.println("Device " + btDevice.getBluetoothAddress() + " found");
				devicesDiscovered.addElement(btDevice);
				try {
					System.out.println("     name " + btDevice.getFriendlyName(false));
				} catch (IOException cantGetDeviceName) {
				}
			}

			@Override
			public void inquiryCompleted(int discType) {
				System.out.println("Device Inquiry completed!");
				synchronized (inquiryCompletedEvent) {
					inquiryCompletedEvent.notifyAll();
				}
			}

			@Override
			public void serviceSearchCompleted(int transID, int respCode) {
			}

			@Override
			public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
			}
		};

		synchronized (inquiryCompletedEvent) {
			boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC,
					listener);
			if (started) {
				System.out.println("wait for device inquiry to complete...");
				inquiryCompletedEvent.wait();
				System.out.println(devicesDiscovered.size() + " device(s) found");
			}
		}
	}

}
