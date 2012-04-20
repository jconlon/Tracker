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
package com.verticon.tracker.store.mongo.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableMap.of;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emf.query.Result;
import org.eclipselabs.mongo.IMongoDB;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.mongodb.WriteConcern;
import com.verticon.agriculture.Location;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;

public class MongoResourceFactory {

	private final IMongoDB iMongoDB;
	private final IQueryEngine iQueryEngine;
	private static final String ADMIN_ID = "1";
	private final Integer port;
	private final String hostname;
	private final String uri;

	private static final ImmutableMap<String, ?> PRIMVARY_KEY_SAVE_OPTIONS = of(
			MongoURIHandlerImpl.OPTION_WRITE_CONCERN, WriteConcern.SAFE);

	private static final ImmutableMap<String, ?> ONLY_SAFE_SAVE_OPTIONS = of(
			MongoURIHandlerImpl.OPTION_WRITE_CONCERN, WriteConcern.SAFE);

	private MongoResourceFactory(IMongoDB iMongoDB, IQueryEngine iQueryEngine, String hostname, String port, String uri) {
		super();
		this.port = Strings.isNullOrEmpty(port) ? null : Integer.parseInt(port);
		this.hostname = hostname;
		this.uri = uri;
		this.iMongoDB = iMongoDB;
		this.iQueryEngine = iQueryEngine;
	}

	static MongoResourceFactory instance(IMongoDB iMongoDB, IQueryEngine iQueryEngine,String hostname, String port,
			String uri) {
		return new MongoResourceFactory( iMongoDB, iQueryEngine,hostname, port, uri);
	}

	void add(EObject eObject, Element element) {
		Resource resource = createResource(eObject, element);
		resource.getContents().add(eObject);
	}

	EObject query(Element element, String id) {
		checkNotNull(element);
		checkNotNull(id);
		checkNotNull(hostname);
		List<EObject> result = internalQuery(element, id).getValues();
		checkArgument(result.size() < 2,
				"Query must return a single value or null.");
		return result.isEmpty() ? null : result.get(0);
	}

	Result query(EClass eclass, String query) {
		checkNotNull(eclass);
		checkNotNull(query);
		checkNotNull(hostname);
		URI uri = createQueryURI(eclass, query);
		Resource resource = getResourcSet().getResource(uri, true);
		return (Result) resource.getContents().get(0);
	}

	/**
	 * @return the uri
	 */
	String getPremisesUri() {
		return uri;
	}

	/**
	 * 
	 * @param eClass
	 * @param query
	 * @param uri
	 *            example mongo://localhost:8989:/tracker/"
	 * @return uri pointing to the correct collection in the database
	 */
	private URI createQueryURI(EClass eClass, String query) {
		return createCollectionURI(eClass).appendQuery(
				URI.encodeQuery(query, false));
	}

	private URI createCollectionURI(EClass eClass) {
		return URI.createURI(getMongoEMFBaseURI() + eClass.getName() + "/");
	}

	String getMongoBaseURI() {
		return "mongodb://" + hostname + (port != null ? ":" + port : "");
	}

	void save(EObject eobject, Element element) throws IOException {
		switch (element) {
		case LOCATION:
		case PREMISES:
		case OCD:
			eobject.eResource().save(PRIMVARY_KEY_SAVE_OPTIONS);
			break;
		case TAG:
			Tag tag = (Tag) eobject;
			for (Event event : tag.getEvents()) {
				if (event.getPid() == null) {
					event.setPid(uri);
				}
			}
			eobject.eResource().save(ONLY_SAFE_SAVE_OPTIONS);
			break;
		default:
			eobject.eResource().save(ONLY_SAFE_SAVE_OPTIONS);
			break;
		}
	}

	private ResourceSet getResourcSet() {
		return new MongoResourceSet( iMongoDB,  iQueryEngine);
	}

	private Result internalQuery(Element element, String id) {
		URI uri = createQueryURI(element, element.getQuery(id));
		Resource resource = getResourcSet().getResource(uri, true);
		return (Result) resource.getContents().get(0);
	}

	private Resource createResource(EObject eObject, Element element) {
		return getResourcSet().createResource(
				createResourceURI(element, eObject));
	}

	Resource getResource(Element element, String id) {
		return getResourcSet()
				.getResource(createResourceURI(element, id), true);
	}

	/**
	 * 
	 * @param element
	 * @param query
	 * @param uri
	 *            example mongo://localhost:8989:/tracker/"
	 * @return uri pointing to the correct collection in the database
	 */
	private URI createQueryURI(Element element, String query) {
		return createQueryURI(element).appendQuery(
				URI.encodeQuery(query, false));
	}

	private URI createQueryURI(Element element) {
		return URI.createURI(getMongoEMFBaseURI() + element.eClass.getName()
				+ "/");
	}

	private URI createResourceURI(Element element, String id) {
		URI result = URI.createURI(getMongoEMFBaseURI()
				+ element.eClass.getName());

		switch (element)

		{
		case ADMIN:
			result = result.appendSegment(ADMIN_ID);
			break;

		case CONTAINER:
		case LOCATION:
		case ANIMAL:
		case TAG:
			result = result.appendSegment(id);
			break;

		default:
			result = result.appendSegment("");
			break;
		}

		return result;
	}

	private URI createResourceURI(Element element, EObject eobject) {
		URI result = URI.createURI(getMongoEMFBaseURI()
				+ element.eClass.getName());

		switch (element) {
		case ADMIN:
			result = result.appendSegment(ADMIN_ID);
			break;
		case CONTAINER:
			result = result.appendSegment(uri);
			break;
		case LOCATION:
			Location location = (Location) eobject;
			result = result.appendSegment(location.getUri());
			break;
		case TAG:
			Tag tag = (Tag) eobject;
			result = result.appendSegment(tag.getId());
			break;
		default:
			result = result.appendSegment("");
			break;
		}

		return result;
	}

	private String getMongoEMFBaseURI() {
		return "mongo://" + hostname + (port != null ? ":" + port : "")
				+ "/tracker/";
	}

	private static class MongoResourceSet extends ResourceSetImpl {

		MongoResourceSet(IMongoDB iMongoDB, IQueryEngine iQueryEngine) {
			super();

			MongoURIHandlerImpl handler = new MongoURIHandlerImpl( iMongoDB,  iQueryEngine);
			BuilderFactory builderFactory = new BuilderFactory();
			handler.setDBObjectBuilderFactory(builderFactory);
			handler.setEObjectBuilderFactory(builderFactory);
			getURIConverter().getURIHandlers().add(0, handler);
		}

	}
}
