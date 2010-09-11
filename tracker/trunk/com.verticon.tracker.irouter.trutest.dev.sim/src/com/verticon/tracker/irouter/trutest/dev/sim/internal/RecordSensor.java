package com.verticon.tracker.irouter.trutest.dev.sim.internal;

import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.toast.devsim.fw.HtmlGenerator;
import org.equinoxosgi.toast.devsim.fw.NonRepeatableActionSensor;

public class RecordSensor extends NonRepeatableActionSensor {

	public RecordSensor(String name, String label, String commandName,
			IDeviceSimulatorListener listener) {
		super(name, label, commandName, listener);
	}
	
	@Override
	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.write("RecordSensor.template", getClass());
	}
}
