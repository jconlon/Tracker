package com.verticon.mongo.emf.internal;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

/**
 * EMF Resource Set for MongoEMF that uses custom builders.
 * 
 * @see com.verticon.mongo.emf.internal.TrackerDBObjectBuilder
 * @see com.verticon.mongo.emf.internal.TrackerEObjectBuilder
 * 
 * @author jconlon
 *
 */
public class MongoResourceSet extends ResourceSetImpl {

	MongoResourceSet(IDatabaseLocator mongoLocator, IInputStreamFactory inputStreamFactory, IOutputStreamFactory outputStreamFactory) {
		super();
		MongoURIHandlerImpl handler = new MongoURIHandlerImpl(mongoLocator,  inputStreamFactory,  outputStreamFactory);
		getURIConverter().getURIHandlers().add(0, handler);
	}

}
