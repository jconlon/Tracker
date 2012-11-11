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
import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.Association;
import com.verticon.agriculture.util.AgricultureResourceFactoryImpl;

/**
 * Project Builder associated with Agriculture projects that builds an index a
 * map of Premises uri keys to GeoLocations for resolving Location Service
 * lookups.
 * 
 * @see AgricultureNature
 * @author jconlon
 * 
 */
public class AgricultureProjectBuilder extends IncrementalProjectBuilder {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(AgricultureProjectBuilder.class);

	/**
	 * Name of the marker that will be written to the doc.agri document if there
	 * are problems
	 */
	private static final String ORG_ECLIPSE_CORE_RESOURCES_PROBLEMMARKER = "org.eclipse.core.resources.problemmarker";

	/**
	 * Name of the default document in the root directory of the agriculture
	 * project
	 */
	private static final String DEFAULT_AGRICULTURE_DOCUMENT = "doc.agri";

	/**
	 * Unique identifier for this builder
	 */
	public static final String BUILDER_ID = Component.PLUGIN_ID
			+ ".locationBuilderService";

	private final LocationIndex locationIndex = LocationIndex.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgricultureProjectBuilder [project name="
				+ getProject().getName() + "]";
	}

	/**
	 * Main entry point into this class.
	 */
	@Override
	protected IProject[] build(int kind,
			@SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {

		if (shouldBuild(kind)) {
			logger.debug(bundleMarker, "{} building {}", this, getProject()
					.getName());
			build(monitor);
		} else {
			logger.debug(bundleMarker, "{} defered building {} build kind={}",
					new Object[] { this, getProject().getName(), kind });
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse
	 * .core.runtime.IProgressMonitor)
	 */
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Cleaning index on agriculture location service", 2);

		if (checkCancel(monitor)) {
			return;
		}
		// 1.
		URI uri = URI.createPlatformResourceURI(getProject().getName(), true);
		uri = uri.appendSegment(DEFAULT_AGRICULTURE_DOCUMENT);
		logger.debug(bundleMarker, "Cleaning project {}", uri);
		monitor.worked(1);
		if (checkCancel(monitor)) {
			return;
		}

		// 2. build and validate the changes to the index
		locationIndex.removeAssociation(uri);
		monitor.worked(1);
		monitor.done();
		super.clean(monitor);
	}

	private void build(IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Building index on agriculture location service", 3);
		// 1. load doc.agri file
		if (checkCancel(monitor)) {
			return;
		}

		Resource resource;
		try {
			resource = load();
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to load "+DEFAULT_AGRICULTURE_DOCUMENT, e);
			throw new CoreException(new Status(IStatus.ERROR, Component.PLUGIN_ID,
					"Failed to build project. Make sure "+DEFAULT_AGRICULTURE_DOCUMENT+" exists.", e));
		}
		logger.debug(bundleMarker, "Building project {}", resource.getURI());
		monitor.worked(1);
		if (checkCancel(monitor)) {
			return;
		}
		// 2. validate association
		Object o = resource.getContents().get(0);
		checkArgument(o instanceof Association,
				"Agriculture document root must be an association element.");
		
		Association association = (Association) o;
		validateObject(association);
		monitor.worked(1);
		if (checkCancel(monitor)) {
			return;
		}

		monitor.worked(1);
		if (checkCancel(monitor)) {
			return;
		}
		// 3. add the resource to the index
		locationIndex.add(association);
		monitor.worked(1);

		monitor.done();

	}

	private static void validateObject(EObject eObject) throws CoreException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			MarkerHelper mh = new MarkerHelper();
			try {
				mh.createMarkers(diagnostic);
			} catch (CoreException e) {
			}
			BasicDiagnostic parent = new BasicDiagnostic(Diagnostic.ERROR,// severity
					Component.PLUGIN_ID,// source
					0,// code
					"Agricuture project builder faild to validate "
							+ eObject.eClass().getName() + " in resource "
							+ eObject.eResource().getURI(),// message
					new Object[] {});// data);
			parent.merge(diagnostic);
			// throw new CoreException(BasicDiagnostic.toIStatus(diagnostic));
			throw new CoreException(BasicDiagnostic.toIStatus(parent));

		}

	}

	private Resource load() {
		// Read the file
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new AgricultureResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(AgriculturePackage.eNS_URI,
				AgriculturePackage.eINSTANCE);

		URI uri = createURI(getProject());
		logger.debug(bundleMarker, "{} loading {}", this, uri);

		return resourceSet.getResource(uri, true);

	}

	static URI createURI(IProject project) {
		URI uri = URI.createPlatformResourceURI(project.getName(), true);
		return uri.appendSegment(DEFAULT_AGRICULTURE_DOCUMENT);
	}

	/**
	 * Build for a Full Build, if the default doc or any associated uris change
	 * 
	 * @param kind
	 * @return
	 */
	private boolean shouldBuild(int kind) {
		if (kind == FULL_BUILD) {
			return true;
		}
		IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return false;
		}

		IResourceDelta[] children = delta.getAffectedChildren();
		for (IResourceDelta child : children) {
			String fileName = child.getProjectRelativePath().lastSegment();
			// Build if the default agri,
			if (fileName.equals(DEFAULT_AGRICULTURE_DOCUMENT)) {
				return true;
			} else {
				URI uri = URI.createPlatformResourceURI(child.getFullPath()
						.toString(), true);
				// build if an associated kml or premises is changed.
				if (locationIndex.isAssociatedResource(uri)) {
					logger.debug(bundleMarker, "Affected resource: {}", uri);
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkCancel(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		if (isInterrupted()) {
			// Discard build state if necessary
			return true;
		}

		return false;
	}

	// //////////////////////////////////////////////////////////////////////////
	//
	// Utility methods
	//
	// //////////////////////////////////////////////////////////////////////////

	/**
	 * Add this builder to the specified project if possible. Do nothing if the
	 * builder has already been added.
	 * 
	 * @param project
	 *            the project (not <code>null</code>)
	 */
	public static void addBuilderToProject(IProject project) {

		// Cannot modify closed projects.
		if (!project.isOpen())
			return;

		// Get the description.
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to add builder", e);
			return;
		}

		// Look for builder already associated.
		ICommand[] cmds = description.getBuildSpec();
		for (int j = 0; j < cmds.length; j++)
			if (cmds[j].getBuilderName().equals(BUILDER_ID))
				return;

		// Associate builder with project.
		ICommand newCmd = description.newCommand();
		newCmd.setBuilderName(BUILDER_ID);
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.add(newCmd);
		description.setBuildSpec(newCmds
				.toArray(new ICommand[newCmds.size()]));
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to add builder", e);

		}
	}

	/**
	 * Determine if the specified project has the receiver associated with it.
	 * 
	 * @param project
	 *            the project to test
	 * @return <code>true</code> if the specified project is open and accessible
	 *         and has the builder associated with it, else <code>false</code>
	 */
	public static boolean hasBuilder(IProject project) {

		// Cannot modify closed projects.
		if (!project.isOpen())
			return false;

		// Get the description.
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to find builder", e);
			return false;
		}

		// Look for builder already associated.
		ICommand[] cmds = description.getBuildSpec();
		for (int j = 0; j < cmds.length; j++)
			if (cmds[j].getBuilderName().equals(BUILDER_ID))
				return true;
		return false;
	}

	/**
	 * Remove this builder from the specified project if possible. Do nothing if
	 * the builder has already been removed.
	 * 
	 * @param project
	 *            the project (not <code>null</code>)
	 */
	public static void removeBuilderFromProject(IProject project) {

		// Cannot modify closed projects.
		if (!project.isOpen())
			return;

		// Get the description.
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to remove builder", e);
			return;
		}

		// Look for builder.
		int index = -1;
		ICommand[] cmds = description.getBuildSpec();
		for (int j = 0; j < cmds.length; j++) {
			if (cmds[j].getBuilderName().equals(BUILDER_ID)) {
				index = j;
				break;
			}
		}
		if (index == -1)
			return;

		// Remove builder from project.
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.remove(index);
		description.setBuildSpec(newCmds
				.toArray(new ICommand[newCmds.size()]));
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to remove builder", e);

		}
	}

	/**
	 * Delete all audit markers in the specified project
	 * 
	 * @param project
	 *            the project to be modified
	 * @return <code>true</code> if successful, else <code>false</code>
	 */
	public static boolean deleteAuditMarkers(IProject project) {
		try {
			project.deleteMarkers(ORG_ECLIPSE_CORE_RESOURCES_PROBLEMMARKER,
					false, IResource.DEPTH_INFINITE);
			return true;
		} catch (CoreException e) {
			logger.error(bundleMarker, "Failed to delete markers", e);
			return false;
		}
	}

}
