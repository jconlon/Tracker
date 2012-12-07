package com.verticon.mongo.emf.oda.impl;

import com.verticon.mongo.emf.api.IResourceSetFactory;

/**
 * Declarative Services Component that encapsulates a DS injected 
 * IResourceSetFactory
 * 
 * @see com.verticon.mongo.emf.api.IResourceSetFactory
 * 
 * @author jconlon
 *
 */
public class MongoEMFComponent {

	// DS Injected
	private static IResourceSetFactory resourceSetFactory;

	/**
	 * Declaratives Services service injection
	 * 
	 * @param resourceSetFactory
	 *            the resourceSetFactory to set
	 */
	void setResourceSetFactory(IResourceSetFactory resourceSetFactory) {
		MongoEMFComponent.resourceSetFactory = resourceSetFactory;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param resourceSetFactory
	 */
	void unsetResourceSetFactory(IResourceSetFactory resourceSetFactory) {
		MongoEMFComponent.resourceSetFactory = null;
	}

	static IResourceSetFactory getResourceSetFactory() {
		return resourceSetFactory;
	}

}
