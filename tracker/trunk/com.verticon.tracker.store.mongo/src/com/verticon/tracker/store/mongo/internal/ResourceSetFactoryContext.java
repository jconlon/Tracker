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
import org.eclipselabs.mongo.emf.MongoURIHandlerImpl;
import org.eclipselabs.mongo.emf.ext.ECollection;

import com.google.common.collect.ImmutableMap;
import com.mongodb.WriteConcern;
import com.verticon.mongo.emf.api.IResourceSetFactory;
import com.verticon.mongo.emf.api.SingleMongoLocator;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;

public class ResourceSetFactoryContext {

	private final String premisesUri;
	private final IResourceSetFactory resourceSetFactoryDelegate;
	private final SingleMongoLocator mongoLocator;

	private static final ImmutableMap<String, ?> PRIMVARY_KEY_SAVE_OPTIONS = of(
			MongoURIHandlerImpl.OPTION_WRITE_CONCERN, WriteConcern.SAFE);

	private static final ImmutableMap<String, ?> ONLY_SAFE_SAVE_OPTIONS = of(
			MongoURIHandlerImpl.OPTION_WRITE_CONCERN, WriteConcern.SAFE);

	private ResourceSetFactoryContext(IResourceSetFactory resourceSetFactory, SingleMongoLocator mongoLocator,  String premisesUri) {
		super();
		this.premisesUri = premisesUri;
		this.resourceSetFactoryDelegate = resourceSetFactory;
		this.mongoLocator = mongoLocator;
	}

	static ResourceSetFactoryContext instance(IResourceSetFactory resourceSetFactory, SingleMongoLocator mongoLocator,
			String premisesUri) {
		return new ResourceSetFactoryContext( resourceSetFactory,  mongoLocator, premisesUri);
	}

	void add(EObject eObject, Element element) {
		Resource resource = createResource(eObject, element);
		resource.getContents().add(eObject);
	}

	EObject query(Element element, String id) {
		checkNotNull(element);
		checkNotNull(id);

		List<EObject> result = internalQuery(element, id).getValues();
		checkArgument(result.size() < 2,
				"Query must return a single value or null.");
		return result.isEmpty() ? null : result.get(0);
	}

	ECollection query(EClass eclass, String query) {
		checkNotNull(eclass);
		checkNotNull(query);

		URI uri = createQueryURI(eclass, query);
		Resource resource = getResourcSet().getResource(uri, true);
		return (ECollection) resource.getContents().get(0);
	}

	/**
	 * @return the uri
	 */
	String getPremisesUri() {
		return premisesUri;
	}

	/**
	 * 
	 * @param eClass
	 * @param query
	 * @param premisesUri
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
		return mongoLocator.getRawUri();
	}

	void save(EObject eobject, Element element) throws IOException {
		switch (element) {
		case PREMISES:
		case OCD:
			eobject.eResource().save(PRIMVARY_KEY_SAVE_OPTIONS);
			break;
		case TAG:
			Tag tag = (Tag) eobject;
			for (Event event : tag.getEvents()) {
				if (event.getPid() == null) {
					event.setPid(premisesUri);
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
		return resourceSetFactoryDelegate.createResourceSet(mongoLocator);
	}

	private ECollection internalQuery(Element element, String id) {
		URI uri = createQueryURI(element, element.getQuery(id));
		Resource resource = getResourcSet().getResource(uri, true);
		return (ECollection) resource.getContents().get(0);
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
	 * @param premisesUri
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
		return getMongoBaseURI()+"/tracker/";
	}


}
