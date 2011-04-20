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

import static com.google.common.collect.Maps.filterValues;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
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

import com.verticon.location.LocationServiceProvider;
import com.verticon.tracker.Premises;
import com.vividsolutions.jts.geom.Point;

public final class LocationIndex implements LocationServiceProvider {

	/**
	 * slf4j Logger
	 */
	private final  Logger logger = LoggerFactory
			.getLogger(LocationIndex.class);

	private static LocationIndex instance = null;

	/**
	 * GeoLocations by location id
	 * Protected by lock
	 */
	private volatile Map<String, GeoLocation> index = newHashMap();
	private volatile Object lock = new Object();
	private volatile boolean initialized = false;

	
	private LocationIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static LocationIndex getInstance() {
		if(instance == null) {
			instance = new LocationIndex();
		}
		return instance;
	}


	/**
	 * Find location for a Premises. Used for remote locations.
	 */
	@Override
	public String name(Object target) {
		String id = getID(target);
		String result = null;
		if (id != null) {
			synchronized (lock) {
				result = index.containsKey(id) ? index.get(id).getName() : null;
			}
		}
		return result;
	}

	@Override
	public String address(Object target) {
		String id = getID(target);
		String result = null;
		if (id != null) {
			synchronized (lock) {
				result = index.containsKey(id) ? index.get(id).getAddress()
						: null;
			}
		}
		return result;
	}

	/**
	 * Find location for an animal or a inside a Premises
	 */
	@Override
	public String positionIn(Object target, String coordinates) {
		String id = getID(target);
		String result = null;
		if (id != null) {
			Point point = GeoLocationFactory.createPoint(coordinates);
			synchronized (lock) {
				result = index.containsKey(id) ? index.get(id).locate(point)
						: null;
			}
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
		String id = getID(container);
		Set<String> result = newHashSet();
		
		synchronized (lock) {
			if(index.containsKey(id)){
				result = index.get(id).polygonNames();
			}
		}
		return result;
	}

	/**
	 * On first access build all agriculture projects in the workspace.
	 */
	@Override
	public boolean canHandle(Object target) {
		if (!initialized) {
			buildAllAgricultureProjects();
		}
		if (target instanceof Premises) {
			return true;
		} else if (target instanceof String) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param uri
	 * @return true if uri is associated with the index
	 */
	 boolean isAssociatedResource(String uri){
		boolean result = false;
		if(index==null){
			buildAllAgricultureProjects();
		}
		if(uri.endsWith(".kml")|| uri.endsWith(".premises")){
			synchronized (lock) {
				for (GeoLocation location : index.values()) {
					if(location.hasUri(uri)){
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}
	
	
	  void remove(String id) {
		synchronized (lock) {
			index = newHashMap(filterValues(index, new NotResourceUriPredicate(id)));
		}
	}

	/**
	 * 
	 * @param resource
	 * @throws Exception if building fails
	 */
	 void add(Resource resource) throws CoreException {
		synchronized (lock) {

			ResoureIndexBuilder builder = new ResoureIndexBuilder(resource.getURI().toString(), index);
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
			remove(resource.getURI().toString());
			if (builder.isFoundAgriculture()) {
				addToIndex(builder.geoLocations);
			}
		}
	}

	private  void addToIndex(List<GeoLocation> locations) {
		Map<String, GeoLocation> newLocationsMap = newHashMap();
		for (GeoLocation geoLocationToAdd : locations) {
			newLocationsMap.put(geoLocationToAdd.getID(), geoLocationToAdd);
			logger.debug(bundleMarker, "Added index {}",
					geoLocationToAdd.getID());
		}
		index.putAll(newLocationsMap);
	}

	/**
	 * Resolve a Premise or a String
	 * 
	 * @param target
	 * @return resolved id
	 */
	private  final String getID(Object target) {
		String id = null;
		if (target instanceof Premises) {
			id = ((Premises) target).getUri();
		} else if (target instanceof String) {
			id = (String) target;
		}
		return id;
	}

	
	private void buildAllAgricultureProjects() {
		if(initialized){
			return;
		}
		logger.info(bundleMarker, "Initializing");
		initialized = true;
		// Find all the natures and build them.
		IWorkspace root = ResourcesPlugin.getWorkspace();
		final IProject[] projects = root.getRoot().getProjects();
		IWorkbench wb = PlatformUI.getWorkbench();
		final IProgressService ps = wb.getProgressService();
		Display.getDefault().syncExec( 
				new Runnable() {  
					public void run() { 
						try {
							ps.busyCursorWhile(new IRunnableWithProgress() {
								public void run(IProgressMonitor pm) {
									boolean foundAgricultureNatures = false;
									for (IProject iProject : projects) {
										try {
											if (iProject.hasNature(AgricultureNature.NATURE_ID)) {
												foundAgricultureNatures = true;
												logger.debug(bundleMarker,
														"Building project {}", iProject.getName());
												iProject.build(
														IncrementalProjectBuilder.FULL_BUILD,
														pm);
												logger.debug(bundleMarker,
														"Built project {}", iProject.getName());
											}
										} catch (CoreException e) {
											logger.error(bundleMarker,
													this + " failed to build project "
													+ iProject.getName(), e);
										}
									}
									if(!foundAgricultureNatures){
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
