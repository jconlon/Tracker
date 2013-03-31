package com.verticon.osgi.useradmin.mongo.internal;

import static com.google.common.collect.Lists.newLinkedList;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.osgi.useradmin.mongo.internal.RoleChecker.isImpliedBy;
import static com.verticon.osgi.useradmin.mongo.internal.Serializer.NAME;
import static com.verticon.osgi.useradmin.mongo.internal.Serializer.TYPE;
import static com.verticon.osgi.useradmin.mongo.internal.UserAdminComponent.bundleMarker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.service.useradmin.UserAdminPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.eventbus.EventBus;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.verticon.osgi.useradmin.impl.RoleCreatedEvent;
import com.verticon.osgi.useradmin.impl.RoleRemovedEvent;

public abstract class UserAdminImpl implements UserAdmin {

	protected DBCollection collection;
	protected final Serializer serializer;
	protected final EventBus eventBus = new EventBus();
	/**
	 * slf4j Logger
	 */
	protected Logger logger = LoggerFactory.getLogger(UserAdminImpl.class);


	/**
	 * @return the eventBus
	 */
	public EventBus getEventBus() {
		return eventBus;
	}

	public UserAdminImpl() {
		super();
		this.serializer = new Serializer(this);
	}

	/**
	 * 
	 * When groups expire invalidate their members
	 */
	private final RemovalListener<String, Optional<Role>> cacheRemovalListener = new RemovalListener<String, Optional<Role>>() {

		@Override
		public void onRemoval(
				RemovalNotification<String, Optional<Role>> notification) {
			if (RemovalCause.EXPIRED.equals(notification.getCause())) {
				// Expired
				if (notification.getValue().isPresent()
						&& Role.GROUP == notification.getValue().get()
								.getType()) {
					// Remove all the group members
					Group group = (Group) notification.getValue().get();
					for (Role member : group.getMembers()) {
						roleCache.invalidate(member.getName());
					}
					for (Role member : group.getRequiredMembers()) {
						roleCache.invalidate(member.getName());
					}
				}
				}
			// System.out.println(notification.getCause() + "REMOVED :::::::: "
			// + notification.getKey());

		}
	};

	// Role cache
	protected final LoadingCache<String, Optional<Role>> roleCache = CacheBuilder
			.newBuilder()
			.maximumSize(1000).expireAfterWrite(10, TimeUnit.MINUTES)
			.removalListener(cacheRemovalListener)
			.build(new CacheLoader<String, Optional<Role>>() {
				@Override
				public Optional<Role> load(String key) {
					return findRole(key);
				}
			});


	// Roles cache
	protected final LoadingCache<User, Optional<Set<String>>> rolesCache = CacheBuilder
			.newBuilder().maximumSize(1000)
			.expireAfterWrite(10, TimeUnit.MINUTES)
			.build(new CacheLoader<User, Optional<Set<String>>>() {
				@Override
				public Optional<Set<String>> load(User key) {
					return findRoles(key);
				}
			});



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.useradmin.UserAdmin#createRole(java.lang.String,
	 * int)
	 */
	@Override
	public Role createRole(String name, int type) {
		checkPermissions();
		Role result = null;
		BasicDBObject dbObject = new BasicDBObject(NAME, name).append(TYPE,
				type);

		DBObject existing = collection.findOne(dbObject);
		if (existing == null) {
			WriteResult wr = collection.insert(dbObject,
					WriteConcern.FSYNC_SAFE);
			if (wr.getLastError() != null) {
				wr.getLastError().throwOnError();
			}
			result = serializer.deserialize(dbObject);
			eventBus.post(new RoleCreatedEvent(result));
		}
		return result;
	}

	/**
	 * Get the role if it exists. Then finds all the groups containing this role
	 * (as members or required members) de-serialize them and then remove this
	 * role from them.
	 * 
	 * Then remove the role.
	 * 
	 * Removing the role this way has the side effects that the subclass
	 * UserAdminComponent will:
	 * <ol>
	 * <li>Save the changed groups in Mongo</li>
	 * <li>Send out UserAdminEvents to all the UserAdminListeners</li>
	 * </ol>
	 * 
	 * @see org.osgi.service.useradmin.UserAdmin#removeRole(java.lang.String)
	 */
	@Override
	public boolean removeRole(String name) {
		checkPermissions();
		Role role = getRole(name);
		if (role == null) {
			return false;
		}

		DBObject q = MongoUtils.getGroupsQuery(name);
		DBCursor cursor = collection.find(q);
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			Group group = (Group) serializer.deserialize(dbObject);
			group.removeMember(role);
		}

		// Now remove the object
		q = new BasicDBObject(NAME, name);
		WriteResult wr = collection.remove(q);
		if (wr.getLastError() != null) {
			wr.getLastError().throwOnError();
		}
		boolean removed = wr.getN() == 1;
		if (removed) {
			roleCache.invalidate(name);
			eventBus.post(new RoleRemovedEvent(role));
		}

		return removed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.useradmin.UserAdmin#getRole(java.lang.String)
	 */
	@Override
	public Role getRole(String name) {
		try {
			return roleCache.get(name).isPresent() ? roleCache.get(name).get()
					: null;
		} catch (ExecutionException e) {
			return null;
		}
	}

	/**
	 * Warning this method is very inefficient as it reads all the documents
	 * from the collection before it filters them out.
	 * 
	 * @param filterValue
	 *            (currently blank)
	 * @throws InvalidSyntaxException
	 *             if the filter is hosed up
	 * 
	 * @see MongoUtils#createQueryFromFilter(String) to fix this
	 * @see org.osgi.service.useradmin.UserAdmin#getRoles(java.lang.String)
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Role[] getRoles(String filterValue) throws InvalidSyntaxException {
		List<Role> roles = new ArrayList<Role>();

		Filter filter = null;
		if (filterValue != null) {
			filter = FrameworkUtil.createFilter(filterValue);
		}
		DBObject query = MongoUtils.createQueryFromFilter(filterValue);
		DBCursor cursor = collection.find(query);
		try {
			while (cursor.hasNext()) {
				Role role = serializer.deserialize(cursor.next());
				if ((filter == null) || filter.match(role.getProperties())) {
					roles.add(role);
				}
			}
		} finally {
			cursor.close();
		}

		return roles.toArray(new Role[roles.size()]);
	}

	@Override
	public User getUser(String key, String value) {
		User result = null;
		BasicDBObject query = new BasicDBObject(TYPE, Role.USER)
				.append(key, value);
		DBObject dbObject = collection.findOne(query);
		if (dbObject != null) {
			result = (User) serializer.deserialize(dbObject);
		}
		return result;
	}

	@Override
	public Authorization getAuthorization(User user) {
		Authorization authorization = new AuthorizationImpl(user, this);
		eventBus.register(authorization);
		return authorization;

	}


	/**
	 * @return the collection
	 */
	DBCollection getCollection() {
		return collection;
	}

	/**
	 * @param collection
	 *            the collection to set
	 */
	void setCollection(DBCollection collection) {
		this.collection = collection;
	}

	/**
	 * @param collection
	 *            the collection to set
	 */
	void unsetCollection(DBCollection collection) {
		this.collection = null;
	}

	private Optional<Role> findRole(String name) {
		Optional<Role> result = Optional.absent();
		BasicDBObject query = new BasicDBObject(NAME, name);
		DBObject dbObject = collection.findOne(query);
		if (dbObject != null) {
			Role role = serializer.deserialize(dbObject);
			result = Optional.of(role);
		}
		return result;
	}

	/**
	 * Find the immediate implied Groups, then their groups,etc.
	 * 
	 * @see org.osgi.service.useradmin.Authorization#getRoles()
	 */

	private Optional<Set<String>> findRoles(User user) {
		Set<String> impliedRoleNames = newHashSet();
		impliedRoleNames.add(user.getName());// self is implied
		LinkedList<Group> prospects = findGroups(user.getName());
		while (prospects.peek() != null) {
			findGroups(impliedRoleNames, prospects, user);
		}
		return Optional.of(impliedRoleNames);
	}

	/**
	 * Process the prospects to find which one is implied and which is not. If
	 * it is implied find its prospective groups.
	 * 
	 * @param impliedRoleNames
	 * @param prospects
	 */
	private final void findGroups(Set<String> impliedRoleNames,
			LinkedList<Group> prospects, User user) {
		Group prospect = prospects.remove();
		if (prospect == null) {
			throw new IllegalStateException("Failed to detect empty queue");
		}

		if (impliedRoleNames.contains(prospect.getName())) {
			// ignore duplicates
		} else if (isImpliedBy(prospect, user)) {
			logger.debug(bundleMarker, "{} is implied by {}",
					prospect.getName(), user.getName());
			impliedRoleNames.add(prospect.getName());
			LinkedList<Group> moreProspects = findGroups(prospect.getName());
			moreProspects.remove(prospect);
			prospects.addAll(moreProspects);
		} else {
			logger.debug(bundleMarker, "{} is NOT implied by {}",
					prospect.getName(), user.getName());
		}
	}

	private LinkedList<Group> findGroups(String name) {
		LinkedList<Group> results = newLinkedList();
		DBObject q = MongoUtils.getGroupsQuery(name);

		DBCursor cursor = collection.find(q);
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			Group group = (Group) serializer.deserialize(dbObject);
			results.add(group);
		}
		return results;
	}

	/**
	 * Verifies whether the caller has the right permissions to add or remove
	 * roles.
	 * 
	 * @throws SecurityException
	 *             in case the caller has not the right permissions to perform
	 *             the action.
	 */
	private void checkPermissions() throws SecurityException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager != null) {
			securityManager.checkPermission(new UserAdminPermission(
					UserAdminPermission.ADMIN, null));
		}
	}
}