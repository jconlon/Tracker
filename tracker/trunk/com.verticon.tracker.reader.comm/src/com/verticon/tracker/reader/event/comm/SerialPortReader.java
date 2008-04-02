/**
 * 
 */
package com.verticon.tracker.reader.event.comm;

import com.verticon.tracker.reader.AbstractConnectionReader;

/**
 * @author jconlon
 *
 */
public class SerialPortReader extends AbstractConnectionReader {

	public SerialPortReader(String name) {
		super(name);
	}
	
	public SerialPortReader() {
		super();
	}

}
