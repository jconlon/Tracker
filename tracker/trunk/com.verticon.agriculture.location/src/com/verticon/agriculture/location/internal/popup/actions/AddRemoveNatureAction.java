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
package com.verticon.agriculture.location.internal.popup.actions;

import static com.verticon.agriculture.location.internal.Component.bundleMarker;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.agriculture.location.internal.AgricultureNature;

/**
 * Action to add and remove a Agriculture Nature from a project.
 * 
 * @see AgricultureNature
 * @author jconlon
 *
 */
public class AddRemoveNatureAction implements IObjectActionDelegate {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AddRemoveNatureAction.class);


	private Shell shell;

	// The selected Project.
	private IProject project;

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection == null) {
			project = null;
		} else {
			final Object element = ((IStructuredSelection) selection)
					.getFirstElement();
			if (element == null) {
				project = null;
			} else {
				project = getProject(element);
			}
		}
		action.setEnabled(project != null && project.isOpen());
	}

	public void run(IAction action) {
		if (project == null || !project.isOpen()) {
			return;
		}
		try {
			final IProjectDescription description = project.getDescription();
			final List<String> natureIds = new ArrayList<String>();
			natureIds.addAll(Arrays.asList(description.getNatureIds()));
			final String title,key;
			if (natureIds.contains(AgricultureNature.NATURE_ID)) {
				logger.debug(bundleMarker, "Removing agriculture nature from {}",project.getName());
				natureIds.remove(AgricultureNature.NATURE_ID);
				IWorkbench wb = PlatformUI.getWorkbench();
				IProgressService ps = wb.getProgressService();
				try {
					ps.busyCursorWhile(new IRunnableWithProgress() {
						public void run(IProgressMonitor pm) {
								try {
									project.build(IncrementalProjectBuilder.CLEAN_BUILD, pm);
								} catch (CoreException e) {
									logger.error(bundleMarker,
											this + " failed to clean project "
													+ project.getName(), e);
								}
						}
					});
				} catch (InvocationTargetException e) {
					logger.error(bundleMarker, "Failed to build projects", e);
				} catch (InterruptedException e) {
					logger.error(bundleMarker, "Failed to build projects", e);
				}
				title = "Removed Agriculture nature"; //$NON-NLS-1$
				key = "Removed Agriculture nature from project \"{0}\".";
			} else {
				logger.debug(bundleMarker, "Adding agriculture nature to {}",project.getName());
				natureIds.add(AgricultureNature.NATURE_ID);
				title = "Added Agriculture UI nature"; //$NON-NLS-1$
				key ="Added Agriculture nature to project \"{0}\".";
			}
			description.setNatureIds(natureIds.toArray(new String[natureIds
					.size()]));
			project.setDescription(description, null);

			
			final String message = formatMessage(
					key, project.getName()); //$NON-NLS-1$
			logger.debug(bundleMarker, "{}", message);
			MessageDialog.openInformation(shell, title, message);
			

		} catch (CoreException e) {
			MessageDialog.openError(shell, "Error",
					"Error adding/removing Agriculture project nature.\n\nSee error log for details."); //$NON-NLS-1$
			logger.error(bundleMarker, "Error adding/removing Elver UI project nature.", e);//$NON-NLS-1$
		}
	}
	
	private static String formatMessage(String key, Object... arguments) {
        return MessageFormat.format(key, arguments);
    }

	public void dispose() {
		project = null;
		shell = null;
	}

	/**
	 * @param object
	 *            an instance of IProject of IJavaProject
	 * @return the IProject
	 */
	private static IProject getProject(Object object) {
		if (object instanceof IProject) {
			return (IProject) object;
		} else {
			throw new IllegalArgumentException(
					"The argument " + object + " is not a Project"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
