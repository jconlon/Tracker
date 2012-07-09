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
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
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
	 */
	@Override
	public String name(String id) {
		checkNotNull("The target attribute must not be null.", id);
		String result = null;
		//If there is a key for the target (uri) then
		if (id != null) {
			result = index.containsKey(id) ? index.get(id).getName() : null;
		}
		return result;
	}

	@Override
	public String address(String id) {
		checkNotNull("The target attribute must not be null.", id);
		String result = null;
		if (id != null) {
			result = index.containsKey(id) ? index.get(id).getAddress() : null;
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
		Set<String> result = newHashSet();
		if (index.containsKey(id)) {
			Location location = index.get(id);
			result.add(location.getName());
			for (Area area : location.getAreas()) {
				result.add(area.getName());
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
		if (target instanceof Premises) {
			return true;
		} else if (target instanceof String) {
			return true;
		}
		return false;
	}

	private void initialize() {
		state.set(State.SCHEDULED);
		Job job = new Job("Building Location Index") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				logger.info(bundleMarker, "Building");
				buildAllAgricultureProjects();
				state.set(State.INITIALIZED);
				return Status.OK_STATUS;
			}
		};

		// Start the Job
		job.schedule();
		
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
	void removeMapEntriesFromAgriDocument(URI agricultureResourceUri) {
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
	void addAssociationResource(Association association, URI agriResourceURI){
		URI premisesResourceURI ;
		PremisesResource premisesResource;
		Location location;
		for (Premises premises : association.getLivestock()) {
			location = premises.getLocation();
			if(location==null){
				continue;
			}
			premisesResourceURI = premises.eResource().getURI();
			premisesResource = new PremisesResource(agriResourceURI, premisesResourceURI, premises.getUri());
			index.put(premisesResource, location);
		}
		
		if(logger.isDebugEnabled()){
			logger.debug(bundleMarker,"After adding {}, index.isEmpty={}",agriResourceURI,index.isEmpty());
			for (Entry<PremisesResource,Location> entry : index.entrySet()) {
				logger.debug(bundleMarker,"Index Key={}, Location name={}",entry.getKey(), entry.getValue().getName());
			}
		}
	}
	


	private void buildAllAgricultureProjects() {
		if (state.get()==State.INITIALIZED) {
			return;
		}
		logger.info(bundleMarker, "Initializing project location indexing");
		// Find all the natures and build them.
		IWorkspace root = ResourcesPlugin.getWorkspace();
		final IProject[] projects = root.getRoot().getProjects();
		IWorkbench wb = PlatformUI.getWorkbench();
		final IProgressService ps = wb.getProgressService();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					ps.busyCursorWhile(new IRunnableWithProgress() {
						public void run(IProgressMonitor pm) {
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
												pm);
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
					});
				} catch (InvocationTargetException e) {
					logger.error(bundleMarker, "Failed to build projects", e);
				} catch (InterruptedException e) {
					logger.error(bundleMarker, "Failed to build projects", e);
				}
			}
		});

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

	PremisesResource(URI agriResource, URI premisesResouce,
			String premisesUri) {
		super();
		this.agriResource = agriResource;
		this.premisesResouce = premisesResouce;
		this.premisesUri = premisesUri;
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
