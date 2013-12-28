package org.usaha.ecvi.store;

import java.io.IOException;

import org.usaha.ecvi.Ecvi;

public interface IEcviStore {

	/**
	 * Saves the ecvi to the uri.
	 * 
	 * @param ecvi
	 *            to store
	 * @param uri
	 *            of one of the stores
	 * @throws IOException
	 */
	void record(Ecvi ecvi, String uri) throws IOException;

	/**
	 * There maybe more than one store backing this service.
	 * 
	 * @return URI for each store
	 */
	Iterable<String> getURIs();

}
