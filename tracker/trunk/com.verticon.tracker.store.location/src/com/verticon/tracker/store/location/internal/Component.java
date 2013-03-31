package com.verticon.tracker.store.location.internal;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.location.Area;
import com.verticon.location.service.ILocationServiceProvider;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;

/**
 * LocationServiceProvider that uses one or more ITrackerStore services as back-end 
 * persistent stores.
 * 
 * 
 * @author jconlon
 *
 */
public class Component implements ILocationServiceProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);
	private final static String PLUGIN_ID = "com.verticon.tracker.store.location";
	private static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * Entries injected by Declarative Services.
	 */
	private final List<ITrackerStore> trackerStores = new CopyOnWriteArrayList<ITrackerStore>();
	

	public void activate() {
		logger.debug(bundleMarker, "Activated", this);
	}

	public void deactivate() {
		logger.debug(bundleMarker, "Deactivated", this);
	}

	/**
	 * @param trackerStore
	 *            the trackerStore to set
	 */
	public void setTrackerStore(ITrackerStore trackerStore) {
		trackerStores.add( trackerStore);
	}

	/**
	 * @param trackerStore
	 *            the trackerStore to unset
	 */
	public void unsetTrackerStore(ITrackerStore trackerStore) {
		trackerStores.remove( trackerStore);
	}

	@Override
	public String name(String targetUri) {
		Premises premises = null;
		String result = null;
		try {
			premises = retrievePremises(targetUri);
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to find premises '" + targetUri
					+ "'");
		}
		if (premises != null) {
			result = premises.getLocation() != null ? premises.getLocation()
					.getName() : premises.getName();
		}
		return result;
	}
	
	

	@Override
	public String address(String targetUri) {
		Premises premises = null;
		String result = null;
		try {
			premises = retrievePremises(targetUri);
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to find premises '" + targetUri
					+ "'");
		}
		if (premises != null) {
			result = premises.getAddress();
		}
		return result;
	}

	/**
	 * Query for premises containing the point.
	 */
	@Override
	public String locate(String point) {
		if(point==null){
			throw new IllegalArgumentException("point argument can not be null.");
		}
		Premises premises = null;
		String result = null;
		try {
			premises = retrievePremises(new ITrackerStore.LongLatPoint(point));
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to find premises at point '"
					+ point + "'");
		}
		if (premises != null) {
			StringBuffer location = new StringBuffer(premises.getName());
			if (premises.getLocation() != null) {
				String subLocation = premises.getLocation().locate(point);
				if (subLocation != null) {
					location.append(" : ").append(subLocation);
				}
			}
			result = location.toString();

		}
		return result;
	}

	@Override
	public Set<String> locationsIn(String targetUri) {
		Premises premises = null;
		Set<String> result = new HashSet<String>();
		try {
			premises = retrievePremises(targetUri);
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to find premises '" + targetUri
					+ "'");
		}
		if (premises != null && premises.getLocation() != null) {
			result.add(premises.getLocation().getName());
			for (Area area : premises.getLocation().getAreas()) {
				result.add(area.getName());
			}
		}
		return result;
	}

	/**
	 * This service provider does not support this operation at this time.
	 */
	@Override
	public Map<String, String> getAssociates(String id) {
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public boolean canHandle(Object target) {
		if(target instanceof String){
			return !trackerStores.isEmpty();
		}
		return false;
	}
	
	private Premises retrievePremises(String targetUri) throws IOException{
		Premises result = null;
		for (ITrackerStore trackerStore : trackerStores) {
			result = trackerStore.retrievePremises(targetUri);
			if(result!=null){
				break;
			}
		}
		
		return result;
	}
	
	private Premises retrievePremises(ITrackerStore.LongLatPoint point) throws IOException{
		Premises result = null;
		for (ITrackerStore trackerStore : trackerStores) {
			result = trackerStore.retrievePremises(point);
			if(result!=null){
				break;
			}
		}
		
		return result;
	}
}
