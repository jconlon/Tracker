package com.verticon.tracker.store;

import java.io.IOException;
import java.util.List;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;

public interface ITrackerUpdate {

	/**
	 * Saves any changes to Premises. All contained
	 * Animals, Tags, and Events are NOT saved.
	 * 
	 * If the Admin access is loaded, only a user that is the designated admin 
	 * can register a premises.  All attempts to register
	 * a premises by a non -admin will throw a StoreAccessException.
	 * 
	 * @param location
	 * @throws IOException
	 */
	void register(Premises premises) throws IOException;

	/**
	 * Saves any changes to Premises contained Animals, Tags, and Events that
	 * are later than the last update.
	 * 
	 * @param location
	 * @return statistics on the number of updated animals, tags, events
	 * @throws IOException
	 */
	IUpdateStats recordAnimals(Premises premises) throws IOException;

	/**
	 * Saves any changes to Animals, Tags, and Events that are later than the
	 * last update and are associated with the Premises uri.
	 * 
	 * @param uri
	 * @param animals
	 * @return statistics on the number of updated animals, tags, events
	 * @throws IOException
	 */
	IUpdateStats record(String uri, List<Animal> animals) throws IOException;

	/**
	 * 
	 * @return uri of the service
	 */
	String uri();

}