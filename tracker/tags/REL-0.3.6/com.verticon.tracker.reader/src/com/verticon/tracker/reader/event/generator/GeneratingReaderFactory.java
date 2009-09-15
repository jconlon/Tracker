package com.verticon.tracker.reader.event.generator;

import java.net.URI;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;

public class GeneratingReaderFactory implements IReaderFactory {

	private final static String TYPE = "GeneratingReader";

	public IReader instance(String name, String type, String template,
			URI target) {
		IReader reader = new GeneratingReader(name);
		reader.setTarget(target);
		reader.setTemplate(template);
		return reader;
	}

	/**
	 * Needed to implement interface. Not typically called.
	 */
	public boolean isSupportedType(String type) {
		return TYPE.equals(type);
	}

}
