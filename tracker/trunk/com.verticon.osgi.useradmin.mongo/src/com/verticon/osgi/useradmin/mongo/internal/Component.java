package com.verticon.osgi.useradmin.mongo.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.service.useradmin.UserAdminListener;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.osgi.useradmin.authenticator.UserAdminProvider;

/**
 * Provides one or more MongoDB based UserAdmin services that are identified
 * with an URI.
 * 
 * @author jconlon
 * 
 */
public class Component implements UserAdminProvider {
	
	private final List<IMongoClientProvider> mongoProviders = new CopyOnWriteArrayList<IMongoClientProvider>();
	private final List<UserAdminListener> listeners = new CopyOnWriteArrayList<UserAdminListener>();

	private EventAdmin eventAdmin;
	private ComponentContext componentContext;

	private UserAdminComponent userAdminComponent;

	@Override
	public Iterable<String> getURIs() {
		return Iterables.transform(mongoProviders, mongoProviderToURI);
	}

	@Override
	public UserAdmin get(final String uri) {
		if (userAdminComponent != null && uri.equals(userAdminComponent.uri())) {
			return userAdminComponent;
		}
		IMongoClientProvider mongoClientProvider = null;
		for (IMongoClientProvider mcp : mongoProviders) {
			if (uri.equals(mcp.uri())) {
				mongoClientProvider = mcp;
				break;
			}
		}

		if (mongoClientProvider == null) {
			return null;
		}
		if (userAdminComponent != null) {
			userAdminComponent.deactivate();
		}

		userAdminComponent = new UserAdminComponent(listeners, eventAdmin);
		userAdminComponent.setMongoClientProvider(mongoClientProvider);
		userAdminComponent.activate(componentContext);
		return userAdminComponent;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param listener
	 */
	void addUserAdminListener(UserAdminListener listener) {
		listeners.add(listener);
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param listener
	 */
	void removeUserAdminListener(UserAdminListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param eventAdmin
	 *            the eventAdmin to set
	 */
	void setEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param eventAdmin
	 *            the eventAdmin to set
	 */
	void unsetEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = null;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param iMongoClientProvider
	 */
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		mongoProviders.add(iMongoClientProvider);
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param mongoDBCollectionProvider
	 */
	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		mongoProviders.remove(iMongoClientProvider);
	}
	
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * 
	 */
	void activate(ComponentContext context) {
		this.componentContext = context;

	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		if (userAdminComponent != null) {
			userAdminComponent.deactivate();
		}
		listeners.clear();
		mongoProviders.clear();
	}

	private final static Function<IMongoClientProvider, String> mongoProviderToURI = new Function<IMongoClientProvider, String>() {
		@Override
		public String apply(IMongoClientProvider sr) {
			return sr.uri();
		}
	};

}
