package org.usaha.ecvi.store.mongodb.test.system;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.usaha.ecvi.store.mongodb.test.system.Configurator.PLUGIN_ID;
import static org.usaha.ecvi.store.mongodb.test.system.Configurator.bundleMarker;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.DocumentRoot;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.google.common.base.Strings;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.verticon.mongo.IMongoClientProvider;

/**
 * 
 * Basic testing of an com.verticon.tracker.store.mongodb service and its
 * dependent services.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IMongoClientProvider</li>
 * <li>IFunctionProvider</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class Test_EcviStore extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Test_EcviStore.class);

	/**
	 * This class is a JUnit class and a DS component. There needs to be a
	 * synchronization between the DS and JUnit initializations. This is done
	 * with a java.util.concurrent.CountDownLatch.
	 * 
	 * In the JUnit setUp() method the startUpGate.await() will be called which
	 * will block until all DS services are injected. When all services are
	 * injected and DS calls the startup() method startUpGate.countDown() is
	 * called unblocking the thread waiting in the setUp(). Once tripped the
	 * latch lets subsequent calls through.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	private static final String ECVI_COLLECTION_NAME = "Ecvi";

	/**
	 * Injected services
	 */
	static IEcviStore ecviStore;
	static IMongoClientProvider iMongoClientProvider;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_EcviStore.ecviStore = ecviStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetEcviStore(IEcviStore ecviStore) {
		logger.debug(bundleMarker, "DS injecting the ecviStore");
		Test_EcviStore.ecviStore = null;
	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_EcviStore.iMongoClientProvider = iMongoClientProvider;

	}

	/**
	 * @param iMongoClientProvider
	 *            the iMongoClientProvider to set
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		Test_EcviStore.iMongoClientProvider = null;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		startUpGate.await();// wait for startUp to finish
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 */
	void activate() {
		startUpGate.countDown();
	}

	void deactivate() {

	}

	@Test
	public void test_EcviMongoComponent()
			throws IOException {
		DBCollection coll = getCollection();
		assertThat("Must have no Ecvi documents", coll.find().count(), is(0));

		Resource resource = getXMIResource("Example1.ecvi", "");
		DocumentRoot documentRoot = (DocumentRoot) resource.getContents()
				.get(0);
		Ecvi ecvi = documentRoot.getECVI();
		ecvi.setCviNumber("testEcviMongoComponent@" + new Date());

		String uri = ecviStore.getURIs().iterator().next();
		System.out.println("URI for provider: " + uri);
		assertThat("URI cannot be null or empty", !isNullOrEmpty(uri));

		ecviStore.record(ecvi, uri);

		assertThat("Must have only 1 Ecvi documents", coll.find().count(),
				is(1));
	}


	static DBCollection getCollection() {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());
		return db.getCollection(ECVI_COLLECTION_NAME);
	}


	static Resource getXMIResource(String fileName, String segment) {
		return getXMIResource(PLUGIN_ID, fileName, segment);
	}

	static Resource getXMIResource(String pluginID, String fileName,
			String segment) {
		URI uri = URI.createPlatformPluginURI(pluginID, true);

		if (Strings.isNullOrEmpty(segment)) {
			uri = uri.appendSegments(new String[] { "resources", fileName });
		} else {
			uri = uri.appendSegments(new String[] { "resources", segment,
					fileName });
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		return resource;
	}

}
