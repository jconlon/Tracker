/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;

/**
 * @author jconlon
 * 
 */
public interface ITrackerStore {

	/**
	 * Saves any changes to Location, KML Container, and Premises. All contained
	 * Animals, Tags, and Events are NOT saved.
	 * 
	 * If the Admin access is loaded, only a user that is the designated admin 
	 * can save locations all attempts to save
	 * a location by a non -admin will throw a StoreAccessException.
	 * 
	 * @param location
	 * @throws IOException
	 */
	void register(Location location) throws IOException;

	/**
	 * Saves any changes to Premises contained
	 * Animals, Tags, and Events that are later than the last update.
	 * 
	 * @param location
	 * @return number of updated animals
	 * @throws IOException
	 */
	int recordAnimals(Premises premises) throws IOException;
	
	/**
	 * 
	 * Gets the Premises with all the animals that
	 * were located or contained in the premises between the 
	 * in date and the out date. If both dates are null,
	 * returns a premises without animals.
	 * 
	 * This will create a MongoDB query like:
	 * db.Tag.find({'events.dateTime': {$gte: start, $lt: end}})
	 * 
	 * Which  return all tags that have events less greater than start and le than the end
	 * so not just tags with event datetimes between the dates meet these criteria tags that
	 * have events earlier than start and later than end will be returned.
	 * 
	 * In other words events that surround the time period - which from an application point of view means that 
	 * the animal is in the premises for the time period but may not have generated any events during the time period.
	 * 
	 * @param uri
	 * @param in
	 *            date animal entered premises
	 * @param out
	 *            date animal left premises
	 * @return Premises animals that were in the premises during the span of
	 *         dates
	 */
	Premises retrievePremises(String uri, String in, String out) throws ParseException;
	
	/**
	 * 
	 * @param ain
	 *            Animal ID
	 * @return animal with the id
	 */
	Animal retrieveAnimal(String ain);
	
	/**
	 * 
	 * @param uris of the locations
	 * 
	 * @return Agriculture document containing Locations
	 * 
	 */
	Agriculture retrieveLocations(Set<String> uris);

	
	//The following are not surfaced as end user functions at this time
	/**
	 * 
	 * @param id
	 *          
	 * @return Location
	 */
	Location retrieveLocation(String id);
	
	
	
	/**
	 * Generic query.  
	 * This method is experimental.
	 * 
	 * @param eClass
	 * @param query
	 * @return List of EObjects as result
	 */
	EList<EObject> query(EClass eClass, String query);

}
