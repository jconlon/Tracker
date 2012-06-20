package com.verticon.mongo.json.query.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.Query;
import org.json.mongoQuery.QueryObject;
import org.json.mongoQuery.Selection;
import org.json.mongoQuery.Selector;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

public class MongoJsonQueryLoaderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		new MongoQueryStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(
				URI.createURI("./src/test1.mongojquery"), true);
		EObject eobject = resource.getContents().get(0);
		assertThat("EObject must not be null", eobject, is(notNullValue()));
	}

	@Test
	public final void testString() throws IOException {
		Injector injector = new MongoQueryStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		String queryRaw = " { 'last_name' : 'Smith' } , { 'test' : 0 }";
		URI encodedQuery = encode(queryRaw);

		Resource resource = resourceSet.createResource(encodedQuery);
		assertThat("Resource must not be null", resource, is(notNullValue()));

		String queryString = URI.decode(encodedQuery.query());

		InputStream in = new ByteArrayInputStream(queryString.getBytes());

		resource.load(in, resourceSet.getLoadOptions());

		EObject eobject = resource.getContents().get(0);
		assertThat("EObject must not be null", eobject, is(notNullValue()));
		// Selector
		assertThat("Must be a Selector", eobject,
				is(instanceOf(Selector.class)));
		Selector selector = (Selector) eobject;

		// Selection { 'test' : 0 }
		Selection selection = selector.getSelection();
		assertThat("Selection must not be null", selection, is(notNullValue()));
		// FieldSelections
		List<FieldSelection> fieldselections = selection.getFields();
		assertThat("There must be one field", fieldselections.size(), is(1));
		// FieldSelection
		FieldSelection fieldSelection = fieldselections.get(0);
		assertThat("FieldSelection must not be null", fieldSelection,
				is(notNullValue()));
		String key = fieldSelection.getKey();
		assertThat("Key must not be null", key, is(notNullValue()));
		assertThat("Key must be test", key, is("test"));
		int enabled = fieldSelection.getEnabled();
		assertThat("enabled must be 0", enabled, is(0));

		// QueryObject { 'last_name' : 'Smith' }
		Query query = selector.getQuery();
		assertThat("query must not be null", query, is(notNullValue()));
		// Selector
		assertThat("Must be a QueryObject", query,
				is(instanceOf(QueryObject.class)));
		QueryObject queryObject = (QueryObject) query;
		assertThat("Must have one member", queryObject.getMembers().size(),
				is(1));
		query = queryObject.getMembers().get(0);
		assertThat("Key must be last_name", query.getKey(), is("'last_name'"));
		assertThat("Value must be a another Query", query.getValue(),
				is(instanceOf(Query.class)));
		assertThat("Value must be 'Smith'", query.getValue().getStringValue(),
				is("Smith"));

	}

	@Test
	public final void testBadString() throws IOException {
		Injector injector = new MongoQueryStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		String queryRaw = "id=='985152001389613'";
		URI encodedQuery = encode(queryRaw);

		Resource resource = resourceSet.createResource(encodedQuery);
		assertThat("Resource must not be null", resource, is(notNullValue()));

		String queryString = URI.decode(encodedQuery.query());

		InputStream in = new ByteArrayInputStream(queryString.getBytes());

		resource.load(in, resourceSet.getLoadOptions());

		EObject eobject = resource.getContents().get(0);
		assertThat("EObject must not be null", eobject, is(notNullValue()));
		// Selector
		assertThat("Must be a Selector", eobject,
				is(instanceOf(Selector.class)));

		XtextResource xTextResource = (XtextResource) resource;
		IResourceValidator validator = xTextResource
				.getResourceServiceProvider().getResourceValidator();
		List<Issue> l = validator.validate(xTextResource, CheckMode.ALL, null);
		assertThat("Must have issues", l.isEmpty(), is(false));
		for (Issue issue : l) {
			System.out.println(issue);
		}

	}

	private URI encode(String value) {
		URI uri = URI.createURI("dummy:/example.mongojquery");
		String query = URI.encodeQuery(value, true);
		return uri.appendQuery(query);

	}

}
