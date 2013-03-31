package com.verticon.osgi.useradmin.mongo.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.verticon.osgi.useradmin.impl.RoleFactory;

public class Serializer {
	public static final String TYPE = "type";
	public static final String NAME = "_id";
	static final String PROPERTIES = "properties";
	static final String CREDENTIALS = "credentials";
	static final String MEMBERS = "members";
	static final String REQUIRED_MEMBERS = "requiredMembers";

	static final String SET = "$set";

	private final UserAdminImpl userAdminImpl;
	private final RoleFactory roleFactory;

	Serializer(UserAdminImpl userAdminImpl) {
		super();
		this.userAdminImpl = userAdminImpl;
		this.roleFactory = new RoleFactory(
				userAdminImpl.getEventBus());
	}


	Role deserialize(DBObject object) {
		Role result = null;
		String name = (String) object.get(NAME);
		Map<String, Object> properties = transform((DBObject) object
				.get(PROPERTIES));
		switch (((Integer) object.get(TYPE)).intValue()) {
		case Role.ROLE:
			result = roleFactory.createRole(name, properties);
			break;
		case Role.USER:
			Map<String, Object> credentials = transform((DBObject) object
					.get(CREDENTIALS));
			result = roleFactory.createUser(name, properties, credentials);
			break;
		case Role.GROUP:
			credentials = transform((DBObject) object.get(CREDENTIALS));

			Collection<Role> members = transformDBList(object.get(MEMBERS));
			Collection<Role> requiredMembers = transformDBList(object
					.get(REQUIRED_MEMBERS));

			result = roleFactory.createGroup(name, properties, credentials,
					members, requiredMembers);
			break;
		}

		return result;
	}

	private Collection<Role> transformDBList(Object object) {
		List<Role> members = newArrayList();
		if (object != null) {
			for (Role member : getRoles((BasicDBList) object)) {
				members.add(member);
			}
		}
		return members;
	}

	/**
	 * Creates a serialized version of the given {@link Role} to be used in an
	 * update statement.
	 * 
	 * @param role
	 *            the {@link Role} to update, cannot be <code>null</code>.
	 * @return a {@link DBObject} representing an update statement for the given
	 *         {@link Role}.
	 */
	@SuppressWarnings("unchecked")
	DBObject serializeUpdate(Role role) {
		int type = role.getType();

		BasicDBObject changeSet = new BasicDBObject();

		changeSet.put(PROPERTIES, serializeDictionary(role.getProperties()));
		if ((Role.GROUP == type) || (Role.USER == type)) {
			changeSet.put(CREDENTIALS,
					serializeDictionary(((User) role).getCredentials()));

			if (Role.GROUP == type) {
				changeSet.put(MEMBERS,
						getRoleNames(((Group) role).getMembers()));
				changeSet.put(REQUIRED_MEMBERS,
						getRoleNames(((Group) role).getRequiredMembers()));
			}
		}

		return new BasicDBObject(SET, changeSet);
	}

	/**
	 * Serializes a given {@link Dictionary} into a {@link DBObject}.
	 * 
	 * @param properties
	 *            the {@link Dictionary} to serialize, cannot be
	 *            <code>null</code>.
	 * @return the serialized dictionary, never <code>null</code>.
	 */
	private DBObject serializeDictionary(Dictionary<String, Object> properties) {
		BasicDBObject result = new BasicDBObject();

		Enumeration<String> keysEnum = properties.keys();
		while (keysEnum.hasMoreElements()) {
			String key = keysEnum.nextElement();
			Object value = properties.get(key);

			result.append(KeyCodec.encode(key), value);
		}

		return result;
	}

	// /**
	// * Deserializes the given {@link DBObject} into the given {@link
	// Dictionary}
	// * .
	// *
	// * @param dictionary
	// * the dictionary to fill;
	// * @param object
	// * the {@link DBObject} to deserialize.
	// */
	// private static void deserializeDictionary(
	// Dictionary<String, Object> dictionary, DBObject object) {
	// if (object != null) {
	// for (String key : object.keySet()) {
	// dictionary.put(KeyCodec.decode(key), object.get(key));
	// }
	// }
	// }

	private Map<String, Object> transform(DBObject object) {
		Map<String, Object> result = null;

		if (object != null) {
			result = newHashMap();
			for (String key : object.keySet()) {
				result.put(KeyCodec.decode(key), object.get(key));
			}

		} else {
			result = Collections.emptyMap();
		}
		return result;
	}

	/**
	 * Returns all roles mentioned in the given list.
	 * 
	 * @param list
	 *            the list with role names to convert.
	 * @return a list with {@link Role}s, never <code>null</code>.
	 */
	private List<Role> getRoles(BasicDBList list) {
		List<Role> result = new ArrayList<Role>();
		for (int i = 0, size = list.size(); i < size; i++) {
			final String memberName = (String) list.get(i);
			try {
				result.add(findExistingMember(memberName));
			} catch (Exception e) {
				// ignore this
			}
		}
		return result;
	}

	/**
	 * Finds an existing member by its name.
	 * 
	 * @param name
	 *            the name of the member to return, cannot be <code>null</code>.
	 * @return a member instance, never <code>null</code>.
	 * @throws MongoException
	 *             in case the requested member was not found (or any other
	 *             MongoDB exception).
	 */
	private final Role findExistingMember(String name) {
		Role result = userAdminImpl.getRole(name);
		if (result == null) {
			throw new MongoException("No such role: " + name);
		}
		return result;
	}

	/**
	 * Serializes a given array of {@link Role}s to an list for storing in a
	 * {@link DBObject}.
	 * 
	 * @param members
	 *            the {@link Role}s to serialize, cannot be <code>null</code>.
	 * @return the "serialized" array, never <code>null</code>.
	 */
	private List<String> getRoleNames(Role[] members) {
		List<String> result = new ArrayList<String>();
		if (members != null) {
			for (Role member : members) {
				result.add(member.getName());
			}
		}
		return result;
	}

}
