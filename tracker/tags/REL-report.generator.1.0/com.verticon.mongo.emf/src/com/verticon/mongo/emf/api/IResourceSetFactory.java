package com.verticon.mongo.emf.api;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.IDatabaseLocator;

/**
 * Interface for creation of MongoEMF ResourceSets that have been
 * created with building optimized Premises mongo documents
 * 
 * @author jconlon
 *
 */
public interface IResourceSetFactory {

	/**
	 * Creates a EMF ResourceSet from a IMongoLocator.
	 * 
	 * 
	 * @param databaseLocator
	 * @return ResourceSet customized for the mongoLocator
	 */
	ResourceSet createResourceSet(IDatabaseLocator databaseLocator);

}
