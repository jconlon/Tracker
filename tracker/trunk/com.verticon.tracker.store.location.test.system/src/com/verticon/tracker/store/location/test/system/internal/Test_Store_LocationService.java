package com.verticon.tracker.store.location.test.system.internal;

import static com.verticon.tracker.store.TrackerStoreUtils.registerPremises;
import static com.verticon.tracker.store.location.test.system.internal.Configuator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.location.test.system.internal.Configuator.URN_PIN_003CZKO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Strings;
import com.verticon.location.Location;
import com.verticon.location.service.ILocationService;
import com.verticon.tracker.Animal;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Position;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;

/**
 * Run TrackerStore Test System to populate MongoDB
 * 
 * @author jconlon
 * 
 */
public class Test_Store_LocationService {

	static String PLUGIN_ID = "com.verticon.tracker.store.location.test.system";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	static final String DOC_PREMISES = "example.premises";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_Store_LocationService.class);

	private final static String FIRST_ANIMAL = "840456789012341";
	private final static String MOVED_OUT_ANIMAL = "840456789012348";
	private final static String FIRST_ANIMAL_POSITION = "-90.95048182270057,43.47622307339506,0";

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

	/**
	 * Injected services
	 */
	static ITrackerStore trackerStore;
	static ILocationService locationService;

	// static IMockAuthenticatorController mockAuthenticatorController;

	/**
	 * @param locationService
	 *            the locationService to set
	 */
	public void setLocationService(ILocationService locationService) {
		logger.debug(bundleMarker, "DS injecting the locationService");
		Test_Store_LocationService.locationService = locationService;
	}

	/**
	 * Injected by ds
	 * 
	 * @param trackerStore
	 */
	public void setTrackerStore(ITrackerStore trackerStore) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_Store_LocationService.trackerStore = trackerStore;
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 */
	public void startup() {
		startUpGate.countDown();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Configuator.cleanDatabase();
	}

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		startUpGate.await();// wait for startUp to finish
		// System.out.println(this + ": startup and setUp finished.");

		// // Set the mock user
		// mockAuthenticatorController.setAuthenticatedUser(true);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWait() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
	}

	@Test
	public void testRegisterAndLoad() throws IOException {
		logger.debug(bundleMarker, "starting testRegister");
		Resource resource = getXMIResource(
				"com.verticon.tracker.store.location.test.system",
				DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(PREMISES_URI_H89234X));
		assertThat("Premises must have 8 animalsl", premises.getAnimals()
				.size(), is(8));
		assertThat("Premises not enough events",
				premises.eventHistory().size(), is(33));

		Location location = premises.getLocation();

		assertThat(
				"Logitude is -90.95674265545253,43.47493314332049,338.8866674272697",
				location.getLongitude(), is(-90.95674265545253));

		assertThat("Latitude is 43.47493314332049", location.getLatitude(),
				is(43.47493314332049));

		assertThat("Altitude is 338.8866674272697", location.getAltitude(),
				is(338.8866674272697));

		logger.debug(
				bundleMarker,
				"First event Date={}; DateKey={}; DateTime={}",
				new Object[] { premises.eventHistory().get(0).getDate(),
						premises.eventHistory().get(0).getDateKey(),
						premises.eventHistory().get(0).getDateTime().toString() });

		trackerStore.register(premises);
		trackerStore.recordAnimals(premises);
	}

	@Test
	public final void test_LocationService_Address_from_URI() {
		String result = locationService.address(PREMISES_URI_H89234X);
		assertThat("Must have address for " + PREMISES_URI_H89234X, result,
				is("E6055 Cina Rd. Viroqua, WI 54665"));
	}

	@Test
	public final void test_LocationService_Name_from_URI() {
		String result = locationService.name(PREMISES_URI_H89234X);
		assertThat("Must have name for " + PREMISES_URI_H89234X, result,
				is("East Farm"));
	}

	@Test
	public final void test_LocationService_Locate_Point() {
		String result = locationService
				.locate("-90.95048182270057,43.47622307339506,0");
		assertThat("Must have name for the point", result,
				is("East Farm : Pasture One"));
	}

	@Test
	public final void test_LocationService_Locations_In_URI() {
		Set<String> result = locationService.locationsIn(PREMISES_URI_H89234X);
		assertThat("Must have address", result.size(), is(5));
		// for (String string : result) {
		// System.out.println(string);
		// }
		assertThat("Must contain known location",
				result.contains("Pasture One"), is(true));
		assertThat("Must contain known location",
				result.contains("Holding Pen"), is(true));
		assertThat("Must contain known location",
				result.contains("Feedlot pens"), is(true));
		assertThat("Must contain known location", result.contains("Bull Pen"),
				is(true));
		assertThat("Must contain known location", result.contains("East Farm"),
				is(true));
	}

	@Test
	public final void test_First_Animal_getLocation_before_registering_people() {
		Animal animal = trackerStore.retrieveAnimal(FIRST_ANIMAL);
		MovedIn movedIn = (MovedIn) animal.eventHistory().get(1);
		MovedOut movedOut = (MovedOut) animal.eventHistory().get(2);
		Position position = (Position) animal.eventHistory().get(6);
		// For the moveIn
		assertThat("MovedIn from pin", movedIn.getSourcePin(), is("006FN8K"));
		assertThat("MovedIn from name", movedIn.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", movedOut.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", movedOut.getDestinationName(),
				is(nullValue()));

		// For the position
		assertThat("Position coordinates from pin", position.getCoordinates(),
				is(FIRST_ANIMAL_POSITION));
		assertThat("Position locationName", position.getLocationName(),
				is(nullValue()));

		// For the animal - note there is a position, but there is no premises
		// so the
		// location is the point
		assertThat("Animal has a urn for location", animal.getLocation(),
				is(position.getCoordinates()));

		// ResolveTheNames
		String locationName = animal.findLocationName();
		assertThat("Animal locationName is now a name", locationName,
				is("East Farm : Pasture One"));

		// For the moveIn
		assertThat("MovedIn from pin", movedIn.getSourcePin(), is("006FN8K"));
		assertThat("MovedIn from name", movedIn.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", movedOut.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", movedOut.getDestinationName(),
				is(nullValue()));

		// For the position
		assertThat("Position locationName", position.getLocationName(),
				is("East Farm : Pasture One"));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("East Farm : Pasture One"));

	}

	@Test
	public final void test_MovedOutAnimal_getLocation_before_registering_people() {
		Animal animal = trackerStore.retrieveAnimal(MOVED_OUT_ANIMAL);
		MovedIn mievent = (MovedIn) animal.eventHistory().get(1);
		MovedOut moevent = (MovedOut) animal.eventHistory().get(2);
		// For the moveIn
		assertThat("MovedIn from pin", mievent.getSourcePin(), is("0054TBG"));
		assertThat("MovedIn from name", mievent.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", moevent.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", moevent.getDestinationName(),
				is(nullValue()));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("urn:pin:00FXCTK"));

		// ResolveTheNames
		String locationName = animal.findLocationName();
		assertThat("Animal locationName is still the urn", locationName,
				is("urn:pin:00FXCTK"));

		// For the moveIn
		assertThat("MovedIn from pin", mievent.getSourcePin(), is("0054TBG"));
		assertThat("MovedIn from name", mievent.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", moevent.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", moevent.getDestinationName(),
				is(nullValue()));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("urn:pin:00FXCTK"));

	}

	// "Pin""Name""Phone""Email""Street""City""State""zipCode""latitude""longitude"
	@Test
	public final void test_TrackerStoreUtils_registerPremises()
			throws Exception {
		File file = new File("resources/Fair_People-1.csv");
		int registrations = registerPremises(file, trackerStore);
		assertThat("There were 47 registrations", registrations, is(47));

	}

	@Test
	public final void test_First_Animal_getLocation_after_registering_people() {
		Animal animal = trackerStore.retrieveAnimal(FIRST_ANIMAL);
		MovedIn movedIn = (MovedIn) animal.eventHistory().get(1);
		MovedOut movedOut = (MovedOut) animal.eventHistory().get(2);
		Position position = (Position) animal.eventHistory().get(6);
		// For the moveIn
		assertThat("MovedIn from pin", movedIn.getSourcePin(), is("006FN8K"));
		assertThat("MovedIn from name", movedIn.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", movedOut.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", movedOut.getDestinationName(),
				is(nullValue()));

		// For the position
		assertThat("Position coordinates from pin", position.getCoordinates(),
				is(FIRST_ANIMAL_POSITION));
		assertThat("Position locationName", position.getLocationName(),
				is(nullValue()));

		// For the animal - note there is a position, but there is no premises
		// so the
		// location is the point
		assertThat("Animal has a urn for location", animal.getLocation(),
				is(position.getCoordinates()));

		// ResolveTheNames
		String locationName = animal.findLocationName();
		assertThat("Animal locationName is now a name", locationName,
				is("East Farm : Pasture One"));

		// For the moveIn
		assertThat("MovedIn from pin", movedIn.getSourcePin(), is("006FN8K"));
		assertThat("MovedIn from name", movedIn.getSourceName(), is("Hanson"));

		// For the moveOut
		assertThat("MovedOut to pin", movedOut.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", movedOut.getDestinationName(),
				is("Dwyer"));

		// For the position
		assertThat("Position locationName", position.getLocationName(),
				is("East Farm : Pasture One"));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("East Farm : Pasture One"));

	}

	@Test
	public final void test_MovedOutAnimal_getLocation_afterRegisteringPeople() {
		Animal animal = trackerStore.retrieveAnimal(MOVED_OUT_ANIMAL);
		MovedIn mievent = (MovedIn) animal.eventHistory().get(1);
		MovedOut moevent = (MovedOut) animal.eventHistory().get(2);
		// For the moveIn
		assertThat("MovedIn from pin", mievent.getSourcePin(), is("0054TBG"));
		assertThat("MovedIn from name", mievent.getSourceName(),
				is(nullValue()));

		// For the moveOut
		assertThat("MovedOut to pin", moevent.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", moevent.getDestinationName(),
				is(nullValue()));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("urn:pin:00FXCTK"));

		// ResolveTheNames
		String locationName = animal.findLocationName();
		assertThat("Animal locationName is still the urn", locationName,
				is("Dwyer"));

		// For the moveIn
		assertThat("MovedIn from pin", mievent.getSourcePin(), is("0054TBG"));
		assertThat("MovedIn from name", mievent.getSourceName(), is("Johnson"));

		// For the moveOut
		assertThat("MovedOut to pin", moevent.getDestinationPin(),
				is("00FXCTK"));
		assertThat("MovedOut to name", moevent.getDestinationName(),
				is("Dwyer"));

		// For the animal
		assertThat("Animal has a urn for location", animal.getLocation(),
				is("Dwyer"));
	}

	@Test
	public void test_getAssociations() {

		Map<String, String> map = locationService.getAssociates("peter");
		assertThat("Name map is not null", map, is(notNullValue()));
		assertThat("Map has two entries", map.size(), is(2));

		assertThat("Map has a premises name", map.get(PREMISES_URI_H89234X),
				is("East Farm"));

		assertThat("Map has a premises name", map.get(URN_PIN_003CZKO),
				is("Seelow"));

	}

	static Resource getXMIResource(String fileName, String segment) {
		String pluginID = "com.verticon.tracker.store.mongodb.test.system";
		return getXMIResource(pluginID, fileName, segment);
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
