package com.verticon.emf.oda.ecore.mongo.tests;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Map;
import java.util.Properties;

import org.eclipse.datatools.connectivity.oda.IConnection;
import org.eclipse.datatools.connectivity.oda.IQuery;
import org.eclipse.datatools.connectivity.oda.IResultSet;
import org.eclipse.datatools.connectivity.oda.IResultSetMetaData;
import org.eclipse.datatools.connectivity.oda.OdaException;
import org.eclipse.datatools.connectivity.oda.spec.QuerySpecification;
import org.eclipse.datatools.connectivity.oda.spec.QuerySpecification.ParameterIdentifier;
import org.eclipse.datatools.connectivity.oda.spec.util.QuerySpecificationHelper;
import org.eclipse.emf.oda.ecore.impl.Query;
import org.json.MongoQueryStandaloneSetupGenerated;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.verticon.mongo.emf.oda.impl.MongoEMFConnection;
import com.verticon.mongo.emf.oda.impl.MongoEMFDriver;
import com.verticon.mongo.emf.oda.impl.MongoEMFQuery;

public class MongoEMFDriverTest {

	private static final String MONGO_COL_NAME = "Animal";
//	private static final String MONGO_SIMPLE_EMF_QUERY = "id=='985152001389613'";
	private static final String MONGO_JSON_QUERY = "{'id' : '985152001389613'}";
	private static final String MONGO_HOSTNAME = "localhost";
	private static final String MONGO_DATABASE = "tracker";
	private MongoEMFDriver driver = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.driver = new MongoEMFDriver();
		new MongoQueryStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
	}

	@After
	public void tearDown() throws Exception {
		this.driver = null;
	}

	@Test
	public final void testGetConnection() throws OdaException, InterruptedException {
		assertThat("Driver must not be null.", driver, is(notNullValue()));
		IConnection connection = driver.getConnection(null);
		assertThat("Connection must be a MongoEMFConnection",connection, is(instanceOf(MongoEMFConnection.class)));
		MongoEMFConnection mongoEMFConnection = (MongoEMFConnection)connection;
		assertThat("Connection must not be open.", connection.isOpen(), is(false));
		//Open the Connection
		Properties connProperties = new Properties();
		connProperties.put(MongoEMFConnection.DB_PROPERTY_NAME, MONGO_DATABASE);
		connProperties.put(MongoEMFConnection.HOST_PROPERTY_NAME, MONGO_HOSTNAME);
//		TimeUnit.SECONDS.sleep(5);
		connection.open(connProperties);
		assertThat("Connection must be open.", connection.isOpen(), is(true));
		
		//Query
		IQuery query = mongoEMFConnection.newQuery(null);
		assertThat("Query must be a MongoEMFQuery",query, is(instanceOf(MongoEMFQuery.class)));
		
		//Query set specification
		QuerySpecificationHelper helper = new QuerySpecificationHelper((String)null);
		QuerySpecification querySpec = helper.createQuerySpecification();
		Map<String,Object> propertyMap = newHashMap();
		propertyMap.put(MongoEMFQuery.MONGO_COLLECTION_PROPERTY_NAME, MONGO_COL_NAME);
		propertyMap.put(MongoEMFQuery.MONGO_QUERY_PROPERTY_NAME, MONGO_JSON_QUERY);
		propertyMap.put(Query.DELEGATE_PROPERTY_NAME,"http://www.eclipse.org/emf/2002/Ecore/OCL");
		propertyMap.put(Query.CONTEXT_PROPERTY_NAME,"http://www.verticon.com/tracker/0.4.2/premises#//Animal");
		propertyMap.put(Query.TYPE_PROPERTY_NAME,"http://www.verticon.com/tracker/0.4.2/premises#//Animal");
//		spec.setParameterValue(Query.VARIABLES_PROPERTY_NAME,"");
		querySpec.setProperties(propertyMap);
		Map<ParameterIdentifier,Object > paramValues = newHashMap();
		
		paramValues.put(querySpec.new ParameterIdentifier("@target"), "<unset>");
		paramValues.put(querySpec.new ParameterIdentifier("@target",1), "<unset>");
		querySpec.setParameterValues(paramValues);
		query.setSpecification(querySpec);
		
		
		//Query Prepare
		try {
			query.prepare("self");
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			fail("failed to prepare. See logs.");
		}
		
		IResultSetMetaData metadata = query.getMetaData();
		assertThat("Metadata must not be null.", metadata, is(notNullValue()));
		
		assertThat("Columns count must be", metadata.getColumnCount(), is(20));
		/*
		 * @self
birthDate
sex
tags
species
breed
sexCode
speciesCode
id
comments
lastEventDateTime
dam
sire
weight
weightGainPerDay
type
visualID
ageInDays
alternativeID
location
		 */
		StringBuffer colName = new StringBuffer();
		for (int i = 1; i < 21; i++) {
			String name = metadata.getColumnName(i);
			
			colName.append(name).append('\t');
		}
		System.out.println(colName.toString());
		IResultSet result = query.executeQuery();
		assertThat("Result must not be null.", result, is(notNullValue()));
		
		assertThat("Result must have at least one row.", result.getRow(), is(0));
		
		
		
		StringBuffer row = new StringBuffer();
		while (result.next()) {
			for (int i = 1; i < 21; i++) {		
				Object o = null;
				try {
					o = result.getObject(i);
					row.append(o).append('\t');
				} catch (Exception e) {
//					e.printStackTrace();
					row.append('?').append('\t');
				}
				
				
			}
			System.out.println(row.toString());
		}
		
		
//		TimeUnit.SECONDS.sleep(50);
		
	}

//	@Test
//	public final void testSetAppContext() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public final void testGetManifest() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public final void testGetNativeDataTypeName() {
//		fail("Not yet implemented"); // TODO
//	}

}
