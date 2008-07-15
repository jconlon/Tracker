package com.verticon.tracker.reader;

import java.io.IOException;
import java.util.List;

/**
 * Manager for Readers
 * @author jconlon
 *
 */
public interface IReaderGroupManager {
	
	String getName();
	
	List<IReader> getGroup();

	void activate() throws IOException;
	
	void deactivate() throws IOException;
	
	boolean isActive();
	
	

}
