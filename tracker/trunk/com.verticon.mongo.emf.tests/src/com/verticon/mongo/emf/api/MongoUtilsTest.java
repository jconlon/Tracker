/**
 * 
 */
package com.verticon.mongo.emf.api;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import com.verticon.tracker.TrackerPackage;

/**
 * @author jconlon
 * 
 */
public class MongoUtilsTest {

	private static final String UNITTEST_PROPERTIES = "private/unittest.properties";
	private static String mongoURIString = null;
	private MongoURI mongoURI = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties localProps = new Properties();
		localProps.load(new FileInputStream( new File(UNITTEST_PROPERTIES)));
		mongoURIString = (String) localProps.get("mongourl");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mongoURI = new MongoURI(mongoURIString);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mongoURI = null;
	}

	@Test
	public final void testURI() throws MongoException, UnknownHostException {
		assertThat(mongoURI, is(notNullValue()));
		assertThat(mongoURI.getDatabase(), is("tracker"));
	}

	@Test
	public final void testMongoURIBuilder() {
		MongoURI mongoURIWithoutUser = new MongoURIBuilder(mongoURI.toString())
				.buildWithoutUserInfo();
		assertThat(mongoURIWithoutUser.getPassword(), is(nullValue()));
		assertThat(mongoURIWithoutUser.getUsername(), is(nullValue()));
	}

	@Test
	public final void testMongoURIConnectDB() throws MongoException,
			UnknownHostException {
		DB db = mongoURI.connectDB();
		assertThat(db, is(notNullValue()));
		boolean auth = true;
		if (isNullOrEmpty(mongoURI.getUsername())
				|| mongoURI.getPassword().length < 1) {
			// no user or password do nothing
		} else {
			auth = db.authenticate(mongoURI.getUsername(),
					mongoURI.getPassword());
		}

		assertThat(auth, is(true));

		Set<String> names = db.getCollectionNames();
		assertThat(names.size(), is(greaterThan(1)));

	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#getEMFBaseURI(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetEMFBaseURI() {
		URI result = MongoUtils.getEMFBaseURI(mongoURI);
		assertThat(result, is(notNullValue()));

		assertThat(result.toString(), is(mongoURIString));
	}



	@Test
	public final void testGetAuthenticatedDB() throws MongoException,
			UnknownHostException {
		DB db = MongoUtils.getAuthenticatedDB(mongoURI);
		assertThat(db, is(notNullValue()));
		Set<String> names = db.getCollectionNames();
		assertThat(names.size(), is(greaterThan(1)));
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
		DB db = MongoUtils.getAuthenticatedDB(mongoURI);
		assertThat(db, is(notNullValue()));


		Set<String> names = db.getCollectionNames();
		assertThat(names.size(), is(greaterThan(1)));

		Map<String, String> result = MongoUtils.getEMFCollections(db);
		assertThat(result, is(notNullValue()));
		for (Map.Entry<String, String> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		assertThat(result.size(), is(greaterThan(4)));
	}

	/**
	 * Test method for
	 * {@link com.verticon.mongo.emf.api.MongoUtils#createQueryURI(URI, String, String)}
	 * .
	 */
	@Test
	public final void testCreateQueryURI() {
		URI base = MongoUtils.getEMFBaseURI(mongoURI);
		assertThat(base, is(notNullValue()));
		assertThat(base.toString(), is(mongoURIString));

		String query = "id=='840456789012341'";
		URI result = MongoUtils.createQueryURI(base, "Tag", query);
		assertThat(result.toString(), is(mongoURIString
				+ "/Tag/?id=='840456789012341'"));
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
