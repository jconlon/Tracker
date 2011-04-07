package com.verticon.tracker.reader.event.bluetooth;

import javax.bluetooth.RemoteDevice;

public interface IDeviceSelector {

	public abstract RemoteDevice getSelectedDevice();

}