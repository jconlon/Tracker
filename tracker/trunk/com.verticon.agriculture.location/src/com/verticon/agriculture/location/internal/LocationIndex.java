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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.filterValues;
import static com.google.common.collect.Maps.newConcurrentMap;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.verticon.location.LocationServiceProvider;
import com.verticon.tracker.Premises;
import com.vividsolutions.jts.geom.Point;

/**
 * A LocationService and LocationServiceProvider that maintains a mapping of
 * String IDs to GeoLocation data envelopes. Ids are String names of things or
 * Premises ids.
 * 
 * @author jconlon
 * 
 */
public final class LocationIndex implements LocationServiceProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(LocationIndex.class);

	private static LocationIndex instance = null;

	/**
	 * GeoLocations by location id (an id is a string name or the uri of the
	 * Protected by lock
	 */
	private ConcurrentMap<String, GeoLocation> index = newConcurrentMap();
	private AtomicBoolean initialized = new AtomicBoolean();

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
	public String name(Object target) {
		checkNotNull("The target attribute must not be null.", target);
		String id = getID(target);
		String result = null;
		if (id != null) {
			result = index.containsKey(id) ? index.get(id).getName() : null;
		}
		return result;
	}

	@Override
	public String address(Object target) {
		checkNotNull("The target attribute must not be null.", target);
		String id = getID(target);
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
	public String positionIn(Object target, String coordinates) {
		checkNotNull("The target attribute must not be null.", target);
		checkNotNull("The coordinates attribute must not be null.", coordinates);
		String id = getID(target);
		String result = null;
		if (id != null) {
			Point point = GeoLocationFactory.createPoint(coordinates);

			result = index.containsKey(id) ? index.get(id).locate(point) : null;
		}
		return result;
	}

	/**
	 * 
	 * @param container
	 * @return names of the sub locations for a container
	 */
	@Override
	public Set<String> locationsIn(Object container) {
		checkNotNull("The container attribute must not be null.", container);
		String id = getID(container);
		Set<String> result = newHashSet();
		if (index.containsKey(id)) {
			result = index.get(id).polygonNames();
		}

		return result;
	}

	/**
	 * On first access build all agriculture projects in the workspace.
	 */
	@Override
	public boolean canHandle(Object target) {
		checkNotNull("The target attribute must not be null.", target);

		if (!initialized.get()) {
			logger.info(bundleMarker, "Building");
			buildAllAgricultureProjects();
			// logger.info(bundleMarker, "Built");
			// building.set(false);
		}
		if (target instanceof Premises) {
			return true;
		} else if (target instanceof String) {
			return true;
		}
		return false;
	}

	void clean() {
		index.clear();
		initialized.set(false);
	}

	/**
	 * 
	 * @param uri
	 * @return true if uri is associated with the index
	 */
	boolean isAssociatedResource(String uri) {
		checkNotNull("The uri attribute must not be null.", uri);
		boolean result = false;
		if (index.isEmpty() && !initialized.get()) {
			buildAllAgricultureProjects();
		}
		if (uri.endsWith(".kml") || uri.endsWith(".premises")) {
			for (GeoLocation location : index.values()) {
				if (location.hasUri(uri)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Remove entries associated with the resourceUri from the map.
	 * 
	 * @param resourceUri
	 */
	void removeMapEntriesFromAgriDocument(URI resourceUri) {
		checkNotNull("The resourceUri attribute must not be null.", resourceUri);
		logger.debug(bundleMarker, "Removing all entries made with {}",
				resourceUri);
		Set<String> keysToRemove = filterValues(index,
				new NotResourceUriPredicate(resourceUri)).keySet();
		for (String key : keysToRemove) {
			index.remove(key);
		}
	}

	/**
	 * 
	 * @param resource
	 * @throws Exception
	 *             if building fails
	 */
	void addAgriDocument(Resource resource) throws CoreException {
		checkNotNull("The agriculture resource attribute must not be null.",
				resource);
		checkArgument(resource.getURI() != null,
				"Agriculture document resource uri attribute must not be null.");
		ResourceIndexBuilder builder = new ResourceIndexBuilder(
				resource.getURI(), index);
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, true);
		while (it.hasNext()) {
			EObject eobject = (EObject) it.next();
			// Visit all objects in the container
			Object drillDeeper = builder.doSwitch(eobject);
			if (drillDeeper != null) {
				if (drillDeeper instanceof Boolean) {
					if (!(Boolean) drillDeeper) {
						it.prune();
					}
				} else if (drillDeeper instanceof CoreException) {
					throw (CoreException) drillDeeper;
				}
			}
		}
		// Remove all the old entries
		removeMapEntriesFromAgriDocument(resource.getURI());

		// Add the new ones
		if (builder.isFoundAgriculture()) {
			addGeoLocationsToMap(builder.geoLocations);
		}

	}

	private final void addGeoLocationsToMap(List<GeoLocation> locations) {
		Map<String, GeoLocation> newLocationsMap = newHashMap();
		for (GeoLocation geoLocationToAdd : locations) {
			newLocationsMap.put(geoLocationToAdd.getID(), geoLocationToAdd);
			logger.debug(bundleMarker, "Adding GeoLocation map key {}",
					geoLocationToAdd.getID());
		}
		index.putAll(newLocationsMap);
	}

	/**
	 * Resolve a Premise or a String name
	 * 
	 * @param target
	 * @return resolved id
	 */
	private static final String getID(Object target) {
		String id = null;
		if (target instanceof Premises) {
			id = ((Premises) target).getUri();
			checkNotNull("Premises uri attribute must not be null.", id);
		} else if (target instanceof String) {
			id = (String) target;
			checkNotNull("The target must not be an empty String.",
					Strings.emptyToNull(id));
		}
		return id;
	}

	private void buildAllAgricultureProjects() {
		if (initialized.get()) {
			return;
		}
		logger.info(bundleMarker, "Initializing project location indexing");
		initialized.set(true);
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
