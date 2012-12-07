package com.verticon.mongo.emf.internal;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.IDatabaseLocator;
import org.eclipselabs.mongo.emf.IInputStreamFactory;
import org.eclipselabs.mongo.emf.IOutputStreamFactory;

import com.verticon.mongo.emf.api.IResourceSetFactory;

/**
 * DS component for submitting a Verticon Premises MongoEMF factory for creating
 * EMF ResourceSets
 * 
 * @author jconlon
 * 
 */
public class ResourceSetFactoryImpl implements IResourceSetFactory {

	// DS injected
	private IInputStreamFactory inputStreamFactory;
	private IOutputStreamFactory outputStreamFactory;

	/**
	 * Injected by ds
	 * 
	 */
	public void setInputStreamFactory(IInputStreamFactory inputStreamFactory) {
		this.inputStreamFactory = inputStreamFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void unsetInputStreamFactory(IInputStreamFactory inputStreamFactory) {
		this.inputStreamFactory = null;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void setOutputStreamFactory(IOutputStreamFactory outputStreamFactory) {
		this.outputStreamFactory = outputStreamFactory;
	}

	/**
	 * Injected by ds
	 * 
	 */
	public void unsetOutputStreamFactory(
			IOutputStreamFactory outputStreamFactory) {
		this.outputStreamFactory = null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.mongo.emf.api.IResourceSetFactory#createResourceSet(org.eclipselabs.mongo.IMongoLocator)
	 */
	@Override
	public ResourceSet createResourceSet(IDatabaseLocator mongoLocator) {
		return new MongoResourceSet(mongoLocator, inputStreamFactory,
				outputStreamFactory);
	}

}
