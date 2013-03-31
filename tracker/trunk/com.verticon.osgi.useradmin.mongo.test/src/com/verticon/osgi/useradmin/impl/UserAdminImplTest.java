package com.verticon.osgi.useradmin.impl;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.util.Dictionary;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class UserAdminImplTest {

	MockListener listener = null;
	RoleFactory roleFactory = null;
	Role role = null;
	User user = null;
	Group group = null;

	final EventBus eventBus = new EventBus();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		listener = new MockListener();
		eventBus.register(listener);
		roleFactory = new RoleFactory(eventBus);
		role = roleFactory.createRole("role1");
		user = roleFactory.createUser("user1");
		group = roleFactory.createGroup("group1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateRoles() {
		assertThat("Should not be null", role, is(notNullValue()));

		assertThat("Should not be null", user, is(notNullValue()));

		assertThat("Should not be null", group, is(notNullValue()));

		Map<String, Object> properties = newHashMap();
		role = roleFactory.createRole("role2", properties);
		assertThat("Should not be null", role, is(notNullValue()));

		properties.put("fish", "house");
		role = roleFactory.createRole("role2", properties);
		assertThat("Should not be null", role, is(notNullValue()));

	}

	@Test
	public final void testGetName() {
		assertThat("Should have name", role.getName(), is("role1"));
	}

	@Test
	public final void testGetType() {
		assertThat("Should have type Role", role.getType(), is(Role.ROLE));
		assertThat("Should have type User", user.getType(), is(Role.USER));
		assertThat("Should have type Role", group.getType(), is(Role.GROUP));
	}

	@Test
	public final void testSetAndGetProperties() {
		@SuppressWarnings("unchecked")
		Dictionary<String, Object> props = role.getProperties();
		assertThat("Should not be null", props,
				is(notNullValue()));
		assertThat("Should be empty", props.isEmpty(), is(true));
		props.put("key1", "somevalue");
		assertThat("Should not be empty", props.isEmpty(), is(false));
		assertThat("Should not be empty", (String) props.get("key1"),
				is("somevalue"));
	}

	@Test
	public final void testRoleChangeListener() {
		@SuppressWarnings("unchecked")
		Dictionary<String, Object> props = role.getProperties();
		assertThat("Should not be null", props,
				is(notNullValue()));
		assertThat("Listener should be empty", listener.changedRole,
				is(nullValue()));
		
		props.put("key1", "somevalue");
		assertThat("Should not be empty", props.isEmpty(), is(false));
		assertThat("Should not be empty", (String) props.get("key1"),
				is("somevalue"));
		assertThat("Listener should be empty", listener.changedRole, is(role));
	}



	class MockListener {
		Role changedRole = null;

		@Subscribe
		public void handle(RoleChangedEvent event) {
			changedRole = event.getRole();

		}

	}

}
