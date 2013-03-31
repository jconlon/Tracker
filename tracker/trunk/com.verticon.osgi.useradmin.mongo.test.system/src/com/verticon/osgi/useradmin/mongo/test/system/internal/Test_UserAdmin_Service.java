package com.verticon.osgi.useradmin.mongo.test.system.internal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Dictionary;
import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Run TrackerStore Test System to populate MongoDB
 * 
 * @author jconlon
 * 
 */
public class Test_UserAdmin_Service {

	private static final String URN_PIN_H89234X = "urn:pin:H89234X";
	private static final String ADMINISTRATORS = "administrators";
	private static final String ARCHITECTS = "architects";
	private static final String DESIGNERS = "designers";
	private static final String GEORGE = "George";
	private static final String DOCUMENTATORS = "documentators";
	private static final String JANE = "Jane";
	private static final String PETER = "Peter";
	private static final String JOHN = "John";
	private static final String PASCAL_PROGRAMMERS = "pascal_programmers";
	private static final String C_PROGRAMMERS = "c_programmers";
	private static final String JAVA_PROGRAMMERS = "java_programmers";
	private static final String PROGRAMMERS = "programmers";
	private static final String TRACKER = "tracker";
	private static final String JILL = "jill";
	private static final String TRUNK = "trunk";
	private static final String JACK = "jack";
	private static final String PLUGIN_ID = "com.verticon.osgi.useradmin.mongo.test.system";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}



	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_UserAdmin_Service.class);


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

	static UserAdmin userAdmin;


	public void setUserAdminService(UserAdmin userAdminService) {
		logger.debug(bundleMarker, "DS injecting the userAdmin");
		Test_UserAdmin_Service.userAdmin = userAdminService;
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

		// Need to wait to set up or we can get ahead of MongoDB w
		// TimeUnit.SECONDS.sleep(1);
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public final void test_Cleanup() {
		boolean removed = userAdmin.removeRole(JACK);
		logger.debug(bundleMarker, "Removed role {}", removed);

		removed = userAdmin.removeRole(JILL);
		logger.debug(bundleMarker, "Removed role {}", removed);

		removed = userAdmin.removeRole(TRUNK);
		logger.debug(bundleMarker, "Removed group trunk {}", removed);

	}

	@SuppressWarnings("unchecked")
	@Test
	public final void test_CreateUser() throws InterruptedException {

		// TimeUnit.SECONDS.sleep(1);
		Role role = userAdmin.createRole(JACK, Role.USER);
		assertThat("Role is not null.", role, is(notNullValue()));

		role.getProperties().put("fish", "mudshark");

		// Try to add again
		role = userAdmin.createRole(JACK, Role.USER);
		assertThat("Role is null.", role, is(nullValue()));

		// Get it
		User user = (User) userAdmin.getRole(JACK);
		assertThat("Role is not null.", user, is(notNullValue()));
		// confirm properties are set
		assertThat("SHould have properties", user.getProperties().size(), is(1));

	}

	@SuppressWarnings("unchecked")
	@Test
	public final void test_CreateGroup() {


		Role role = userAdmin.createRole(TRUNK, Role.GROUP);
		assertThat("Role is not null.", role, is(notNullValue()));

		role.getProperties().put("light", "none");

	}

	@Test
	public final void test_addUserToGroup() {
		Role role = userAdmin.getRole(TRUNK);
		assertThat("Role is not null.", role, is(notNullValue()));
		assertThat("Role is a group.", role.getType(), is(Role.GROUP));
		Group group = (Group) role;
		role = userAdmin.getRole(JACK);
		assertThat("Role is not null.", role, is(notNullValue()));
		boolean added = group.addMember(role);
		assertThat("Role should have been added.", added, is(true));
		// try a second time
		added = group.addMember(role);
		assertThat("Role was added twice.", added, is(false));

		Role[] roles = group.getMembers();
		assertThat("Should have only one member", roles.length, is(1));
		assertThat("Should be Jack", roles[0].equals(role), is(true));

	}

	@Test
	public final void test_addAndRemoveUserFromGroup()
			throws InterruptedException {
		// She may be still around from the last
		userAdmin.removeRole(JILL);

		Role role = userAdmin.getRole(TRUNK);
		assertThat("Role is not null.", role, is(notNullValue()));
		assertThat("Role is a group.", role.getType(), is(Role.GROUP));
		Group trunk = (Group) role;
		Role[] roles = trunk.getMembers();
		assertThat("Should not be null", roles, is(notNullValue()));
		assertThat("Should have only one member", roles.length, is(1));
		assertThat("Should be jack", roles[0].getName(), is(JACK));


		role = userAdmin.createRole(JILL, Role.USER);
		assertThat("jill role is not null.", role, is(notNullValue()));
		Authorization authorization = userAdmin.getAuthorization((User) role);
		assertThat("jill has one role", authorization.getRoles().length,
				is(1));
		assertThat("jill has itself as roles", authorization.getRoles()[0],
				is(JILL));

		// Add Jill to the trunk group
		boolean added = trunk.addMember(role);
		assertThat("Role was not added.", added, is(true));
		// authorization = userAdmin.getAuthorization((User) role);
		assertThat("Role has now two roles", authorization.getRoles().length,
				is(2));

		// try to add Jill a second time - it should not be allowed
		added = trunk.addMember(role);
		assertThat("Role was added.", added, is(false));
		// Trunk now has two members
		roles = trunk.getMembers();
		assertThat("Should have two members", roles.length, is(2));
		assertThat("Should be jack", roles[0].getName(), is(JACK));
		assertThat("Should be jill", roles[1].getName(), is(JILL));

		// Remove the jill role
		boolean removed = userAdmin.removeRole(JILL);
		assertThat("Should have deleted Jill", removed, is(true));
		role = userAdmin.getRole(JILL);
		assertThat("Role is now null.", role, is(nullValue()));

		// Trunk now just has jack as a member
		trunk = (Group) userAdmin.getRole(TRUNK);
		assertThat("Should have only one members", trunk.getMembers().length,
				is(1));
		assertThat("Should be jack", trunk.getMembers()[0].getName(),
 is(JACK));
	}

	/**
	 * The example that follows creates a group called "tracker" with two basic
	 * groups - "programmers" and "documentators".
	 * 
	 * "programmers" contains the basic members: "pascal_programmers" and
	 * "c_programmers" and the required member "java_programmers".
	 * 
	 * "documentators" include the "designers" required member and "programmers"
	 * as a basic member.
	 * 
	 * The following users are specified:
	 * 
	 * programmers java_programmers(R) Jane Peter pascal_programmers(B) John
	 * c_programmers(B) Jane Peter John documentators designers(R) Jane George
	 * programmers(B)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public final void test_programers_example() {
		userAdmin.removeRole(TRACKER);
		userAdmin.removeRole(PROGRAMMERS);
		userAdmin.removeRole(JAVA_PROGRAMMERS);
		userAdmin.removeRole(C_PROGRAMMERS);
		userAdmin.removeRole(PASCAL_PROGRAMMERS);
		userAdmin.removeRole(JOHN);
		userAdmin.removeRole(PETER);
		userAdmin.removeRole(JANE);
		userAdmin.removeRole(DOCUMENTATORS);
		userAdmin.removeRole(GEORGE);
		userAdmin.removeRole(DESIGNERS);
		userAdmin.removeRole(ARCHITECTS);
		userAdmin.removeRole(Role.USER_ANYONE);


		// // Forming administrators
		Group administrators = (Group) userAdmin.getRole(ADMINISTRATORS);
		if (administrators == null) {
			administrators = (Group) userAdmin.createRole(ADMINISTRATORS,
				Role.GROUP);
		}

		User currentUser = (User) userAdmin.getRole(System
				.getProperty("user.name"));
		if (currentUser == null) {
			currentUser = (User) userAdmin.createRole(
					System.getProperty("user.name"), Role.USER);
		}
		administrators.addMember(currentUser);

		Group tracker = (Group) userAdmin.createRole(TRACKER, Role.GROUP);

		// Forming "programmers"
		Group programmers = (Group) userAdmin.createRole(PROGRAMMERS,
				Role.GROUP);
		Group jProgr = (Group) userAdmin.createRole(JAVA_PROGRAMMERS,
				Role.GROUP);
		Group cProgr = (Group) userAdmin
.createRole(C_PROGRAMMERS, Role.GROUP);
		Group pascalProgr = (Group) userAdmin.createRole(PASCAL_PROGRAMMERS,
				Role.GROUP);
		programmers.addRequiredMember(jProgr);
		programmers.addMember(cProgr);
		programmers.addMember(pascalProgr);

		// Forming designers
		Group designers = (Group) userAdmin.createRole(DESIGNERS, Role.GROUP);

		// Adding a programmer
		User peter = (User) userAdmin.createRole(PETER, Role.USER);
		jProgr.addMember(peter);
		cProgr.addMember(peter);
		User jane = (User) userAdmin.createRole(JANE, Role.USER);
		jProgr.addMember(jane);
		cProgr.addMember(jane);
		User john = (User) userAdmin.createRole(JOHN, Role.USER);
		pascalProgr.addMember(john);

		// Adding a designer
		designers.addMember(jane);
		User george = (User) userAdmin.createRole(GEORGE, Role.USER);
		designers.addMember(george);

		// Forming "documentators"
		Group documentators = (Group) userAdmin.createRole(DOCUMENTATORS,
				Role.GROUP);
		documentators.addMember(jProgr);
		documentators.addRequiredMember(designers);

		// /Forming "architects"
		Group architects = (Group) userAdmin.createRole(ARCHITECTS,
				Role.GROUP);
		architects.addRequiredMember(designers);
		// Jane is a designer and designers are architects
		// but the architects group does not allow anyone as a member
		Authorization janeAuthorizaton = userAdmin.getAuthorization(jane);
		assertThat("architects group does not allow anyone as a member",
				janeAuthorizaton.hasRole(ARCHITECTS),
				is(false));

		User anyone = (User) userAdmin.createRole(Role.USER_ANYONE, Role.USER);
		assertThat("anyone is not null", anyone, is(notNullValue()));
		architects.addMember(anyone);
		assertThat(
				"architects group allows anyone that is an designers member",
				janeAuthorizaton.hasRole(ARCHITECTS), is(true));

		// Specifying user properties
		Dictionary props = peter.getProperties();
		props.put("Position", "Department Manager".getBytes());
		Dictionary creds = peter.getCredentials();
		creds.put("password", peter.getName().getBytes());

		// Adding all users to "tracker"
		tracker.addMember(documentators);
		tracker.addMember(programmers);

		// Authorizing created members
		printRoles(peter);
		printRoles(john);
		printRoles(jane);
		printRoles(george);

		assertThat("Peter is in programmers", checkUsers(programmers, peter),
				is(true));
		assertThat("Jane is in programmers", checkUsers(programmers, peter),
				is(true));
		assertThat("John is in pascal programmer",
				checkUsers(pascalProgr, john),
				is(true));
		assertThat("John is NOT Java programmer", checkUsers(jProgr, john),
				is(false));
		assertThat("John is NOT in programmers, because he cant program Java",
				checkUsers(programmers, john), is(false));
		assertThat("George is NOT in programmers",
				checkUsers(programmers, george), is(false));

		assertThat("Jane is in designers", checkUsers(designers, jane),
				is(true));
		assertThat("George is in designers", checkUsers(designers, george),
				is(true));

		assertThat("Jane is in documentors", checkUsers(documentators, jane),
				is(true));

		assertThat(
				"George is NOT in documentors because he is not a programmer",
				checkUsers(documentators, george), is(false));

		assertThat("Peter is NOT in documentors because he is not a designer",
				checkUsers(documentators, peter), is(false));

		for (String role : userAdmin.getAuthorization(jane).getRoles()) {
			System.out.printf("User %s has role: %s%n", jane.getName(), role);
		}

	}

	@Test
	public final void test_tracker_example() throws InterruptedException {
		userAdmin.removeRole(URN_PIN_H89234X);

		Group eastFarm = (Group) userAdmin.createRole(URN_PIN_H89234X,
				Role.GROUP);
		
		// Adding a publisher
		User peter = (User) userAdmin.getRole(PETER);
		eastFarm.addMember(peter);

		assertThat("Peter is in eastfarm", checkUsers(eastFarm, peter),
				is(true));

	}

	private void printRoles(User user) {
		Authorization autho = userAdmin.getAuthorization(user);
		System.out.printf("User %s has roles: ", user.getName());
		for (String role : autho.getRoles()) {
			System.out.printf("%s ", role);
		}
		System.out.println();
	}

	private boolean checkUsers(Role role, User user) {
		Authorization autho = userAdmin.getAuthorization(user);
		boolean ok = autho.hasRole(role.getName());
		// System.out.println("In group " + role.getName() + " ? " + ok);
		System.out.printf("Is %s in %s? %s%n", user.getName(), role.getName(),
				ok);
		return ok;
	}

}
