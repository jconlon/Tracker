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

package com.verticon.mongo.emf.internal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipselabs.mongo.emf.DBObjectBuilder;
import org.eclipselabs.mongo.emf.EObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;

import com.verticon.mongo.emf.api.IDBObjectBuilderDecorator;

/**
 * DS component for submitting Verticon Premises MongoEMF Builders
 * 
 * @author jconlon
 * 
 */
public class BuilderFactoryImpl implements IDBObjectBuilderFactory,
		IEObjectBuilderFactory {

	List<IDBObjectBuilderDecorator> decorators = new CopyOnWriteArrayList<IDBObjectBuilderDecorator>();
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.IEObjectBuilderFactory#createObjectBuilder(
	 * org.eclipselabs.mongo.emf.IConverterService,
	 * org.eclipse.emf.ecore.xmi.XMLResource.URIHandler, boolean, java.util.Map)
	 */
	@Override
	public EObjectBuilder createObjectBuilder(
			IConverterService converterService, URIHandler uriHandler,
			boolean includeAttributesForProxyReferences,
			Map<String, EClass> eClassCache) {
		return new TrackerEObjectBuilder(converterService, uriHandler,
				includeAttributesForProxyReferences);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipselabs.mongo.emf.IDBObjectBuilderFactory#createBuilder(org.
	 * eclipselabs.mongo.emf.IConverterService,
	 * org.eclipse.emf.ecore.xmi.XMLResource.URIHandler, boolean)
	 */
	@Override
	public DBObjectBuilder createBuilder(IConverterService converterService,
			URIHandler uriHandler, boolean serializeDefaultAttributeValues) {
		return new TrackerDBObjectBuilder(converterService, uriHandler,
				serializeDefaultAttributeValues,decorators);
	}
	
	/**
	 * Declarative Services 
	 * 
	 * @param decorator
	 */
	void setDecorator(IDBObjectBuilderDecorator decorator){
		decorators.add(decorator);
	}
	
	/**
	 * Declarative Services 
	 * 
	 * @param decorator
	 */
	void unsetDecorator(IDBObjectBuilderDecorator decorator){
		decorators.remove(decorator);
	}
	
	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
	  decorators.clear();	
	}
	

}
