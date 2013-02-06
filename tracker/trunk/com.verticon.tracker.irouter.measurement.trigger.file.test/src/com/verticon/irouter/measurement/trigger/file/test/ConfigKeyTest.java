/**
 * 
 */
package com.verticon.irouter.measurement.trigger.file.test;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URI;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

import com.google.common.base.CharMatcher;
import com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey;
import com.verticon.tracker.irouter.measurement.trigger.file.WeightUnit;

/**
 * @author jconlon
 *
 */
public class ConfigKeyTest {

	private Map<String, Object> config;

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
		config = newHashMap();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		config = null;
	}

	/**
	 * Test method for {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getURI(java.util.Map)}.
	 */
	@Test
	public final void testGetURI() {

		URI uri;
		try {
			uri = ConfigKey.getURI(config);
			fail("should throw IllegalStateException");
		} catch (Exception e) {
			// expected
		}


		ConfigKey.CONNECTION_URI.configure(config, "http://www.verticon.com");

		try {
			uri = ConfigKey.getURI(config);
			fail("should throw IllegalStateException");
		} catch (Exception e) {
			// expected
		}

		ConfigKey.CONNECTION_URI
				.configure(config, "file:///~/measurement/scan");

		uri = ConfigKey.getURI(config);

		assertThat("URI was not created", uri, is(notNullValue()));
		assertThat("URI has wrong value",
				uri.equals(URI.create("file:///~/measurement/scan")), is(true));
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getFileNamePattern(java.util.Map)}
	 * .
	 */
	@Test
	public final void testGetFileNamePattern() {
		assertThat("Wrong file name default",
				ConfigKey.getFileNamePattern(config), is("measurement-***.txt"));

		ConfigKey.FILE_NAME_PATTERN.configure(config, "measure-***.txt");
		assertThat("Wrong file name default",
				ConfigKey.getFileNamePattern(config), is("measure-***.txt"));
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getScope(java.util.Map)}
	 * .
	 */
	@Test
	public final void testGetScope() {

		assertThat("Wrong scope default", ConfigKey.getScope(config),
				is(new String[] { "ohaus.weight" }));

		ConfigKey.CONSUMABLE_SCOPES.configure(config, new Object[] { "one",
				"two" });

		assertThat("Wrong file name default", ConfigKey.getScope(config),
				is(new Object[] { "one", "two" }));
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getServicePid(java.util.Map)}
	 * .
	 */
	@Test
	public final void testGetServicePid() {

		String servicePid;
		try {
			servicePid = ConfigKey.getServicePid(config);
			fail("should throw IllegalStateException");
		} catch (Exception e) {
			// expected
		}

		ConfigKey.SERVICE_PID.configure(config, "something.1234");

		servicePid = ConfigKey.getServicePid(config);

		assertThat("pid was not created", servicePid, is(notNullValue()));
		assertThat("pid has wrong value",
				servicePid.equals("something.1234"), is(true));
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getWiringGroup(java.util.Map)}
	 * .
	 */
	@Test
	public final void testGetWiringGroup() {

		assertThat("Wrong wiring group default",
				ConfigKey.getWiringGroup(config), is("one"));

		ConfigKey.WIRING_GROUP.configure(config, "cheese");

		assertThat("Wrong file name default", ConfigKey.getWiringGroup(config),
				is("cheese"));
	}


	/**
	 * Test method for
	 * {@link com.verticon.tracker.irouter.measurement.trigger.file.ConfigKey#getDestinationDirectory(java.util.Map)}
	 * .
	 */
	@Test
	public final void testGetDestinationDirectory() {

		ConfigKey.CONNECTION_URI.configure(config, "file:///tmp");

		File destination = ConfigKey.getDestinationDirectory(config);

		assertThat("destination was not created", destination,
				is(notNullValue()));
		assertThat("destination has wrong value",
 destination.toString(),
				is(new File("/tmp").toString()));

		assertThat("destination was not created", destination,
				is(notNullValue()));
		assertThat("destination should exist", destination.isDirectory(),
				is(true));

	}

	@Test
	public final void testGetFile() {
		ConfigKey.CONNECTION_URI.configure(config, "file:///tmp");
		File destination = ConfigKey.getFile(config);

		assertThat("file was not created", destination, is(notNullValue()));
		// /tmp/measurement-***.txt
		String destinationPath = destination.getPath();
		String withouttimestamp = CharMatcher.anyOf("0123456789").collapseFrom(
				destinationPath, '*');
		assertThat("file has wrong value", withouttimestamp,
				is("/tmp/measurement-*.txt"));
		assertThat("destination should exist", destination.isFile(), is(false));

	}

	@Test
	public final void testGetWeightUnit() {
		WeightUnit weightUnit = ConfigKey.getWeightUnit(config);
		assertThat("WeightUnit was not created", weightUnit, is(notNullValue()));
		assertThat("WeightUnit default incorrect", weightUnit,
				is(WeightUnit.POUNDS));

		ConfigKey.WEIGHT_MEASUREMENT_UNITS.configure(config, "KILOGRAMS");
		weightUnit = ConfigKey.getWeightUnit(config);
		assertThat("WeightUnit was not created", weightUnit, is(notNullValue()));
		assertThat("WeightUnit default incorrect", weightUnit,
				is(WeightUnit.KILOGRAMS));

		ConfigKey.WEIGHT_MEASUREMENT_UNITS.configure(config, "OUNCES");
		weightUnit = ConfigKey.getWeightUnit(config);
		assertThat("WeightUnit was not created", weightUnit, is(notNullValue()));
		assertThat("WeightUnit default incorrect", weightUnit,
				is(WeightUnit.OUNCES));

		ConfigKey.WEIGHT_MEASUREMENT_UNITS.configure(config, "GRAMS");
		weightUnit = ConfigKey.getWeightUnit(config);
		assertThat("WeightUnit was not created", weightUnit, is(notNullValue()));
		assertThat("WeightUnit default incorrect", weightUnit,
				is(WeightUnit.GRAMS));

	}

	/**
	 * formated string from values dateTime, unit, value, error
	 */
	@Test
	public final void testGetFormatedMeasurement() {
		Measurement measurement = new Measurement(100, .0001, Unit.kg,
				System.currentTimeMillis());
		String values = ConfigKey.getFormatedMeasurement(config, measurement);
		assertThat("Values was not created", values, is(notNullValue()));

		// Sun Feb 03 18:03:23 CST 2013,POUNDS,220.462,0.0002

		assertThat("Values default incorrect was " + values,
				values.matches(".*,POUNDS,220.462,0.0002"), is(true));

		ConfigKey.MEASUREMENT_VALUE_FORMAT.configure(config,
				"Values are: %1$tc,%3$5.2f,lbs,%4$5.4f");

		values = ConfigKey.getFormatedMeasurement(config, measurement);
		assertThat("Values was not created", values, is(notNullValue()));
		assertThat("Values default incorrect was " + values,
				values.matches("Values are:.*,220.46,lbs,0.0002"), is(true));
		// Uncomment the following to see output easier. Note this will cause an
		// error!
		ConfigKey.MEASUREMENT_VALUE_FORMAT.configure(config,
				"Values are: %3$5.2f,%2$s,%1$tm%1$td%ty,%4$5.4f");
		measurement = new Measurement(1.6666666666, .0001, Unit.kg,
				System.currentTimeMillis());
		values = ConfigKey.getFormatedMeasurement(config, measurement);
		assertThat("Values default incorrect", values, is("whatever"));

	}

}
