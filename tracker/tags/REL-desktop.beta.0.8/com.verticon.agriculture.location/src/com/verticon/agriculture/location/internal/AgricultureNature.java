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

import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nature for a project that wishes to declare an Agriculture document to the 
 * Location Service.  
 * 
 * Agriculture document must be called doc.agri and be in the projects root 
 * directory to be configured by the associated builder.
 * 
 * @see AgricultureProjectBuilder
 * @author jconlon
 *
 */
public class AgricultureNature implements IProjectNature {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AgricultureNature.class);

	public static final String NATURE_ID = Component.PLUGIN_ID
			+ ".agricultureServiceNature";
	private IProject project;

	/**
	 * Configures this nature for its project. This is called by the workspace
	 * when natures are added to the project using
	 * <code>IProject.setDescription</code>. This nature adds our builder to the
	 * projects build spec and triggers a build in the background when the
	 * project is configured.
	 */
	@Override
	public void configure() throws CoreException {
		AgricultureProjectBuilder.addBuilderToProject(project);
		new Job("Properties File Audit") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					project.build(AgricultureProjectBuilder.FULL_BUILD,
							AgricultureProjectBuilder.BUILDER_ID, null, monitor);
				} catch (CoreException e) {
					logger.error(bundleMarker, "Failed to configure", e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	/**
	 * De-configures this nature for its project. This is called by the
	 * workspace when natures are removed from the project using
	 * <code>IProject.setDescription</code>. When the nature is removed from the
	 * project, the build spec is modified and all audit markers are removed.
	 */
	@Override
	public void deconfigure() throws CoreException {
		AgricultureProjectBuilder.removeBuilderFromProject(project);
		AgricultureProjectBuilder.deleteAuditMarkers(project);
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
