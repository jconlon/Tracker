/**
 * 
 */
package com.verticon.mongo.emf.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.UnknownHostException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.verticon.tracker.TrackerPackage;

/**
 * @author jconlon
 * 
 */
public class MongoUtilsTest {

	private static final String HOSTNAME = "localhost";
	private static final String DBNAME = "tracker";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	// /**
	// * Test method for {@link
	// com.verticon.mongo.emf.api.MongoUtils#getMongoDBURI(java.lang.String,
	// java.lang.String, java.lang.String)}.
	// */
	// @Test
	// public final void testGetMongoURI() {
	// MongoURI result = MongoUtils.getMongoDBURI(HOSTNAME, null, DBNAME);
	// assertThat(result, is(notNullValue()));
	// assertThat(result.toString(), is("mongodb://localhost/tracker"));
	// }

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#getEMFBaseURI(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetEMFBaseURI() {
		URI result = MongoUtils.getEMFBaseURI(HOSTNAME, null, DBNAME);
		assertThat(result, is(notNullValue()));
		assertThat(result.toString(), is("mongodb://localhost/tracker"));
	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#getMongoDB(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	@Test
	public final void testGetMongo() throws MongoException,
			UnknownHostException {
		DB result = MongoUtils.getMongoDB(HOSTNAME, null, DBNAME);
		assertThat(result, is(notNullValue()));

	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#getEMFCollections(com.mongodb.DB)}
	 * .
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	@Test
	public final void testGetEMFCollections() throws MongoException,
			UnknownHostException {
		DB db = MongoUtils.getMongoDB(HOSTNAME, null, DBNAME);
		assertThat(db, is(notNullValue()));
		Map<String, String> result = MongoUtils.getEMFCollections(db);
		assertThat(result, is(notNullValue()));
		for (Map.Entry<String, String> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		assertThat(result.size(), is(8));
	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#createQueryURI(URI, String, String)}
	 * .
	 */
	@Test
	public final void testCreateQueryURI() {
		URI base = MongoUtils.getEMFBaseURI(HOSTNAME, null, DBNAME);
		assertThat(base, is(notNullValue()));
		assertThat(base.toString(), is("mongodb://localhost/tracker"));
		String query = "id=='840456789012341'";
		URI result = MongoUtils.createQueryURI(base, "Tag", query);
		assertThat(result.toString(),
				is("mongodb://localhost/tracker/Tag/?id=='840456789012341'"));
	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#getChildren(String)}.
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	@Test
	public final void testGetChoices() throws MongoException,
			UnknownHostException {
		@SuppressWarnings("unused")
		TrackerPackage trackerPackage = TrackerPackage.eINSTANCE;
		String nsURI = "http://www.verticon.com/tracker/0.4.2/premises#//Animal";
		EList<Object> result = MongoUtils.getChildren(nsURI);
		assertThat("result must not be null", result, is(notNullValue()));
		// for (Object eClass : result) {
		// // System.out.println(eClass);
		// }
		assertThat(result.size(), is(44));

	}

}
