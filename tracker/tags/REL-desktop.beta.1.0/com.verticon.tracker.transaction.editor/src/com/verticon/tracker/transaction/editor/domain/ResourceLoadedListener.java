/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.transaction.editor.domain;
import static com.verticon.tracker.transaction.editor.TransactionEditorPlugin.bundleMarker;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.transaction.editor.TransactionEditorPlugin;

/**
 * Listens for the loading of resources, and creates editors on them when they
 * load.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ResourceLoadedListener extends DemultiplexingListener {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ResourceLoadedListener.class);
	private static ResourceLoadedListener instance;
	
	protected final Set<Resource> ignoredResources = new java.util.HashSet<Resource>();
	
	/**
	 * Initializes me with my filter.
	 */
	public ResourceLoadedListener() {
		super(NotificationFilter.createFeatureFilter(
				EcorePackage.eINSTANCE.getEResource(), Resource.RESOURCE__IS_LOADED));
		logger.debug(bundleMarker, "Constructing");
		instance = this;
	}
	
	/**
	 * Returns the default listener instance.
	 * 
	 * @return the instance associated with the editing domain that manages the
	 *     specified resource set, or <code>null</code> if none is found
	 */
	public static ResourceLoadedListener getDefault() {
		return instance;
	}
	
	/**
	 * Ignores any future load/unload notifications from the specified resource,
	 * until the next call to {@link #watch(Resource) watch(res)}.
	 * 
	 * @param res the resource to ignore
	 */
	public void ignore(Resource res) {
		ignoredResources.add(res);
	}
	
	/**
	 * Ceases to {@link #ignore(Resource)} a previously ignored resource.
	 * 
	 * @param res the resource
	 */
	public void watch(Resource res) {
		ignoredResources.remove(res);
	}

	@Override
	protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
		if (ignoredResources.contains(notification.getNotifier())) {
			// skip any resource that we are supposed to ignore
			logger.info(bundleMarker,"Skipping.");
			return;
		}
	
		if (notification.getNewBooleanValue() && !notification.getOldBooleanValue()) {
			// a resource has been loaded that was not loaded before.  Open an editor
			final IFile file = WorkspaceSynchronizer.getFile(
					(Resource) notification.getNotifier());
			
			if (file != null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						try {
							IWorkbenchPage page = getActivePage();
							
							if (page != null) {
								IEditorPart activeEditor = page.getActiveEditor();
								logger.info(bundleMarker,"Opening file {}",file.getName());
								
								page.openEditor(
										new FileEditorInput(file),
										"com.verticon.tracker.transaction.editor.TrackerEditorID", //$NON-NLS-1$
										false);
								
								// restore the previously active editor to active
								//    state
								if (activeEditor != null) {
									page.activate(activeEditor);
								}
							}
						} catch (PartInitException e) {
							TransactionEditorPlugin.getPlugin().log(e.getStatus());
						}
					}});
			}
		} else if (!notification.getNewBooleanValue() && notification.getOldBooleanValue()) {
			// a resource has been unloaded that was  loaded before.  Close
			//    the editor, if any
			final IFile file = WorkspaceSynchronizer.getFile(
					(Resource) notification.getNotifier());
			
			if (file != null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						IWorkbenchPage page = getActivePage();
						logger.info(bundleMarker,"Closing file {}", file.getName());
						
						if (page != null) {
							IEditorReference[] editors = page.findEditors(
									new FileEditorInput(file),
									"com.verticon.tracker.transaction.editor.TrackerEditorID", //$NON-NLS-1$
									IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
							
							page.closeEditors(editors, false);
						}
					}});
			}
		}
	}
	
	/**
	 * Obtains the currently active workbench page.
	 * 
	 * @return the active page, or <code>null</code> if none is active
	 */
	protected IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;
		
		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();
			
			if (window != null) {
				result = window.getActivePage();
			}
		}
		
		return result;
	}
}
