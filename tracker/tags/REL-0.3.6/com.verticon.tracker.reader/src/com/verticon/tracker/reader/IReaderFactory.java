package com.verticon.tracker.reader;

import java.net.URI;

public interface IReaderFactory {

	IReader instance(String name, String type, String template, URI target);
	
	boolean isSupportedType(String type);
}
