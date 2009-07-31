package com.verticon.tracker.reader.views;

import com.verticon.tracker.reader.IReader;



/**
 * Listener to changes on a model of IReaders
 * 
 * @see ReaderViewModel
 * @author jconlon
 *
 */
public interface IReaderModelListener {
	
	/**
	 * Reflect the fact that a IReader was added 
	 * to the IReader Model
	 * 
	 * @param reader
	 */
	public void addReader(IReader reader);
	
	/**
	 * Update the view to reflect the fact that a IReader was removed 
	 * from the IReader Model
	 * 
	 * @param reader
	 */
	public void removeReader(IReader reader);
	
	/**
	 * Update the view to reflect the fact that one of the IReader
	 * was modified in the IReader Model
	 * 
	 * @param reader
	 */
	public void updateReader(IReader reader);
}
