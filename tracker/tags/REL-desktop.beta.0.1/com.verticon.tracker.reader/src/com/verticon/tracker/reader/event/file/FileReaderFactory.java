package com.verticon.tracker.reader.event.file;

import java.net.URI;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;

public class FileReaderFactory implements IReaderFactory {

	private final static String TYPE = "FileReader";

	public IReader instance(String name, String type, String template,
			URI target) {
		IReader reader = new FileReader(name);
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
