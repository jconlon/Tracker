package com.verticon.mongo.emf.json.query;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipselabs.mongo.emf.IQueryEngine;
import org.eclipselabs.mongo.emf.MongoQuery;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.inject.Injector;

/**
 * 
 * 
 * @author jconlon
 * 
 */
public class QueryEngine implements IQueryEngine {

	static String PLUGIN_ID = "com.verticon.mongo.emf.json.query";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(QueryEngine.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.IQueryEngine#buildDBObjectQuery(org.eclipse
	 * .emf.common.util.URI)
	 */
	@Override
	public MongoQuery buildDBObjectQuery(URI uri) {
		String query = URI.decode(uri.query());
		logger.debug(bundleMarker, "raw={}, decoded query={}",uri, query);
		Injector injector = new MongoQueryStandaloneSetupGenerated()
				.createInjector();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);

		Resource resource = resourceSet.createResource(reencode(query));
		InputStream in = new ByteArrayInputStream(query.getBytes());
		try {
			// Load the query
			resource.load(in, resourceSet.getLoadOptions());
			XtextResource xTextResource = (XtextResource) resource;
			// Validate the query
			IResourceValidator validator = xTextResource
					.getResourceServiceProvider().getResourceValidator();
			List<Issue> l = validator.validate(xTextResource, CheckMode.ALL,
					null);
			if (!l.isEmpty()) {
				logger.error(bundleMarker, "Failed to validate query: {}",
						query);
				for (Issue issue : l) {
					switch (issue.getSeverity()) {
					case ERROR:
						logger.error(bundleMarker, issue.getMessage());
						break;
					case INFO:
						logger.info(bundleMarker, issue.getMessage());
						break;
					case WARNING:
						logger.warn(bundleMarker, issue.getMessage());
						break;
					default:
						break;
					}
				}

				throw new IllegalArgumentException("Failed to validate query: "
						+ query + " " + l.get(0).getMessage());
			}

		} catch (IOException e) {
			logger.error(bundleMarker, "Could not load query.", e);
			throw new IllegalArgumentException(e);
		}
		// Create a visitor that can build the DBObject
		DBObjectQueryBuilder visitor = new DBObjectQueryBuilder();
		for (TreeIterator<EObject> iter = EcoreUtil.getAllContents(resource,
				true); iter.hasNext();) {
			EObject eObject = iter.next();
			if (visitor.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		MongoQuery result = visitor.build();
		logger.info(bundleMarker, "Created objectFilter={}, fieldFilter={}", result.getObjectFilter(),result.getFieldFilter());
		return result;
	}

	private static URI reencode(String value) {
		URI uri = URI.createURI("dummy:/example.mongojquery");
		String query = URI.encodeQuery(value, true);
		return uri.appendQuery(query);

	}

}
