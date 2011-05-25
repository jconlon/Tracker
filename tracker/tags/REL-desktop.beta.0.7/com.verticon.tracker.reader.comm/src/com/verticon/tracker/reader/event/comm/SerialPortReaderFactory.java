package com.verticon.tracker.reader.event.comm;

import java.net.URI;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;

public class SerialPortReaderFactory implements IReaderFactory {

	public IReader instance(String name, String type, String template,
			URI target) {
		SerialPortReader reader = new SerialPortReader(name);
		reader.setTarget(target);
		reader.setTemplate(template);
		return reader;
	}

	public boolean isSupportedType(String type) {
		return type.equals("SerialPortReader");
	}

}
