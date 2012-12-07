/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.agriculture.location.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.filterKeys;
import static com.google.common.collect.Maps.newConcurrentMap;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.verticon.agriculture.Association;
import com.verticon.location.Area;
import com.verticon.location.Location;
import com.verticon.location.service.ILocationServiceProvider;
import com.verticon.tracker.Premises;

/**
 * A ILocationService and ILocationServiceProvider that maintains a mapping of
 * String IDs to GeoLocation data envelopes. Ids are String names of things or
 * Premises ids.
 * 
 * @author jconlon
 * 
 */
public final class LocationIndex implements ILocationServiceProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(LocationIndex.class);

	private static LocationIndex instance = null;
	
	/**
	 * Maps a Premises.uri to a Location
	 */
	private final ConcurrentMap<PremisesResource, Location> index = newConcurrentMap();
	
	
	private enum State{
		UNINITIALIZED,INITIALIZED,SCHEDULED
	}
	private AtomicReference<State> state = new AtomicReference<State>(State.UNINITIALIZED);
	
	

	private LocationIndex() {
		super();
	}

	public static LocationIndex getInstance() {
		if (instance == null) {
			instance = new LocationIndex();
		}
		return instance;
	}

	/**
	 * Find location for a Premises. Used for remote locations.
	 * @param id
	 */
	@Override
	public String name(String id) {
		checkNotNull("The target attribute must not be null.", id);
		String result = null;
		//If there is a key for the target (uri) then
		if (id != null) {
			for (Entry<PremisesResource, Location> entry : index.entrySet()) {
				if(entry.getKey().premisesUri.equals(id)){
					result = entry.getValue().getName();
					break;
				}
			}
			
		}
		return result;
	}

	@Override
	public String address(String id) {
		checkNotNull("The target attribute must not be null.", id);
		String result = null;
		if (id != null) {
			for (Entry<PremisesResource, Location> entry : index.entrySet()) {
				if(entry.getKey().premisesUri.equals(id)){
					result = entry.getValue().getAddress();
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Find location for an animal or a inside a Premises
	 */
	@Override
	public String locate(String point) {
		checkNotNull("The coordinates attribute must not be null.", point);
		String result = null;
		for (Location location : index.values()) {
			if(location.containsPoint(point)){
				result = location.locate(point);
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param id
	 * @return names of the sub locations for a container
	 */
	@Override
	public Set<String> locationsIn(String id) {
		checkNotNull("The id attribute must not be null.", id);
		logger.debug(bundleMarker,"Searching for locations in {}",id);
		Set<String> result = newHashSet();
		
		for (Entry<PremisesResource, Location> entry : index.entrySet()) {
			if(entry.getKey().premisesUri.equals(id)){
				Location location = entry.getValue();
				result.add(location.getName());
				for (Area area : location.getAreas()) {
					result.add(area.getName());
				}
				logger.debug(bundleMarker,"Found {} location in {}",result.size(),id);
				break;
			}
		}

		if(result.isEmpty()){
			logger.debug(bundleMarker,"Found no locations in {}",id);
		}

		return result;
	}
	
	/**
	 * Find all the foreign premises and the id and name as a map 
	 * 
	 */
	@Override
	public Map<String, String> getAssociates(String id) {
		checkNotNull("The id attribute must not be null.", id);
		logger.debug(bundleMarker,"Searching for locations in {}",id);
		Map<String,String> result = newHashMap();
		for (Entry<PremisesResource, Location> entry : index.entrySet()) {
			//Find all the foreign premises 
			if(!entry.getKey().premisesUri.equals(id)){
				Location location = entry.getValue();
				result.put(entry.getKey().premisesUri,location.getName());
				logger.debug(bundleMarker,"Found {} location in {}",result.size(),id);
			}
		}
		return result;
	}
	
	/**
	 * On first access build all agriculture projects in the workspace.
	 */
	@Override
	public boolean canHandle(Object target) {
		checkNotNull("The target attribute must not be null.", target);

		if (state.get().equals(State.UNINITIALIZED)) {
			initialize();
		}
		if (Map.class.equals(target)) {
			return true;
		} else if (target instanceof String) {
			return true;
		}
		return false;
	}

	/**
	 * This index is initialized by a user interface thread (for example the menu pull down on the SightingEvent 
	 * 'Select Location in Premises') or by a non-ui background thread (for example as the result of a change to 
	 * a resource in a AgricultureNature tagged project.
	 * 
	 * Determine the type of thread and call the appropriate initialization procedure.
	 */
	private void initialize(){
		if(Display.getCurrent()!=null){
			initializeInUIThread(Display.getCurrent().getActiveShell());
		}else{
			initializeInBackground();
		}
	}
	
	private void initializeInUIThread(Shell shell){
	    try {
	    	ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
	    	dialog.run(true, true, new IRunnableWithProgress(){
	    	    public void run(IProgressMonitor monitor) {
	    	        monitor.beginTask("Initializing the GeoLocation cache", 100);
	    	        // execute the task ..
	    	        logger.info(bundleMarker, "Building");
					buildAllAgricultureProjects(monitor);
					state.set(State.INITIALIZED);
	    	        monitor.done();
	    	    }
	    	});
	     } catch (InvocationTargetException e) {
	        // handle exception
	     } catch (InterruptedException e) {
	        // handle cancelation
	     }
	}
	
	private void initializeInBackground() {
		logger.debug(bundleMarker, "Scheduling Job");
		state.set(State.SCHEDULED);
		Job job = new Job("Building Location Index") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				logger.info(bundleMarker, "Building");
				buildAllAgricultureProjects(monitor);
				state.set(State.INITIALIZED);
				return Status.OK_STATUS;
			}
		};
		// Start the Job
		job.schedule();
	}
	
	private void buildAllAgricultureProjects(IProgressMonitor monitor) {
		if (state.get()==State.INITIALIZED) {
			return;
		}
		logger.info(bundleMarker, "Initializing project location indexing");
		// Find all the natures and build them.
		IWorkspace root = ResourcesPlugin.getWorkspace();
		final IProject[] projects = root.getRoot().getProjects();
		boolean foundAgricultureNatures = false;
		for (IProject iProject : projects) {
			if (!iProject.isAccessible()) {
				continue;
			}
			try {
				if (iProject
						.hasNature(AgricultureNature.NATURE_ID)) {
					foundAgricultureNatures = true;
					logger.info(
							bundleMarker,
							"Building agriculture project {}",
							iProject.getName());
					iProject.build(
							IncrementalProjectBuilder.FULL_BUILD,
							monitor);
					logger.debug(bundleMarker,
							"Built agriculture project {}",
							iProject.getName());
				}
			} catch (CoreException e) {
				logger.error(bundleMarker,
						"Failed to build project "
								+ iProject.getName()
								+ ".  " + e.getStatus(), e);
			}
		}
		if (!foundAgricultureNatures) {
			logger.debug(bundleMarker,
					"Did not find any projects with an agriculture nature.");
		}
	}

	void clean() {
		index.clear();
		state.set(State.UNINITIALIZED);
	}

	/**
	 * 
	 * @param uri
	 * @return true if uri is associated with the index
	 */
	boolean isAssociatedResource(URI uri) {
		checkNotNull("The uri attribute must not be null.", uri);
		if (index.isEmpty() && state.get().equals(State.UNINITIALIZED)) {
			initialize();
		}
		return !filterKeys(index,
				new HasPremisesResourceUriPredicate(uri)).keySet().isEmpty();
	}

	/**
	 * Remove entries associated with the agriculture document resourceUri from the map.
	 * 
	 * @param agricultureResourceUri of the agriculture document
	 */
	void removeAssociation(URI agricultureResourceUri) {
		checkNotNull("The resourceUri attribute must not be null.", agricultureResourceUri);
		logger.debug(bundleMarker, "Removing all entries made with {}",
				agricultureResourceUri);
		Set<PremisesResource> keysToRemove = filterKeys(index,
				new HasAgricultureResourceUriPredicate(agricultureResourceUri)).keySet();
		for (PremisesResource key : keysToRemove) {
			index.remove(key);
		}
		if(logger.isDebugEnabled()){
			logger.debug(bundleMarker,"After removing {}, index.isEmpty={}",agricultureResourceUri,index.isEmpty());
			for (Entry<PremisesResource,Location> entry : index.entrySet()) {
				logger.debug(bundleMarker,"Index Key={}, Location name={}",entry.getKey(), entry.getValue().getName());
			}
		}
	}

	/**
	 * This builds the mapping from premises.uri to Location for each association
	 * @param association
	 */
	void add(Association association){
		URI premisesResourceURI ;
		PremisesResource premisesResource;
		Location location;
		for (Premises premises : association.getLivestock()) {
			location = premises.getLocation();
			if(location==null){
				continue;
			}
			premisesResourceURI = premises.eResource().getURI();
			premisesResource = new PremisesResource(association.eResource().getURI(), premisesResourceURI, premises.getUri());
			index.put(premisesResource, location);
			logger.debug(bundleMarker,"Added premisesResource={}, premisesURI={}, location={}",
					new Object[]{premisesResourceURI,premises.getUri(),location.getName()});
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug(bundleMarker,"After adding {}, index.isEmpty={}",association.eResource().getURI(),index.isEmpty());
			for (Entry<PremisesResource,Location> entry : index.entrySet()) {
				logger.debug(bundleMarker,"Index Key={}, Location name={}",entry.getKey(), entry.getValue().getName());
			}
		}
	}

	
}

/**
 * Data class for holding physical and logical
 * identifiers for a Premises
 * 
 * @author jconlon
 *
 */
class PremisesResource {
	final URI agriResource;
	final URI premisesResouce;
	final String premisesUri;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PremisesResource [agriResource=" + agriResource
				+ ", premisesResouce=" + premisesResouce + ", premisesUri="
				+ premisesUri + "]";
	}

	/**
	 */
	PremisesResource(URI agriResource, URI premisesResouce,
			String premisesUri) {
		super();
		this.agriResource = agriResource;
		this.premisesResouce = premisesResouce;
		this.premisesUri = premisesUri;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((agriResource == null) ? 0 : agriResource.hashCode());
		result = prime * result
				+ ((premisesResouce == null) ? 0 : premisesResouce.hashCode());
		result = prime * result
				+ ((premisesUri == null) ? 0 : premisesUri.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PremisesResource)) {
			return false;
		}
		PremisesResource other = (PremisesResource) obj;
		if (agriResource == null) {
			if (other.agriResource != null) {
				return false;
			}
		} else if (!agriResource.equals(other.agriResource)) {
			return false;
		}
		if (premisesResouce == null) {
			if (other.premisesResouce != null) {
				return false;
			}
		} else if (!premisesResouce.equals(other.premisesResouce)) {
			return false;
		}
		if (premisesUri == null) {
			if (other.premisesUri != null) {
				return false;
			}
		} else if (!premisesUri.equals(other.premisesUri)) {
			return false;
		}
		return true;
	}
	
	
}

/**
 * 
 * Predicate for passing all PremisesResources with
 * an equivalent agriResource
 * 
 * @author jconlon
 * 
 */
class HasAgricultureResourceUriPredicate implements Predicate<PremisesResource> {
	private final URI agriResource;

	HasAgricultureResourceUriPredicate(URI agriResource) {
		super();
		this.agriResource = agriResource;
	}

	/**
	 * returns true if PremisesResources have an equivalent agriResouce
	 */
	@Override
	public boolean apply(PremisesResource premisesResouce) {
		return premisesResouce.agriResource.equals(agriResource);
	}

}

/**
 * 
 * Predicate for passing all PremisesResources with
 * an equivalent premisesResourceURI
 * 
 * @author jconlon
 * 
 */
class HasPremisesResourceUriPredicate implements Predicate<PremisesResource> {
	private final URI premisesResource;

	HasPremisesResourceUriPredicate(URI premisesResource) {
		super();
		this.premisesResource = premisesResource;
	}

	/**
	 * returns true if PremisesResources have an equivalent agriResouce
	 */
	@Override
	public boolean apply(PremisesResource premisesResouce) {
		return premisesResouce.premisesResouce.equals(premisesResource);
	}

}
