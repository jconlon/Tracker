/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.editor.handlers;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;

/**
 * Resolution of Location names can be an expensive operation.
 * Instead of dynamically resolving names, allow the user to run it
 * as batch operation, from pull down menus on the Animal and Premises.
 * 
 * If pulled down on the Animal than it will resolve names for the 
 * animal and its events only.  If pulled down on the Premises then 
 * resolution will be for all animals and events in the premises.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ResolveGeoLocationNamesHandler extends AbstractHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ResolveGeoLocationNamesHandler.class);


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselection = (IStructuredSelection) selection;
			if(sselection.getFirstElement() instanceof Animal){
				handle(event, (Animal)sselection.getFirstElement());
			} else if(sselection.getFirstElement() instanceof Premises){
				handle(event, (Premises)sselection.getFirstElement());
			}
		}
		return null;

	}

	private void handle(ExecutionEvent event, Animal animal)
			throws ExecutionException {
		try {
			String currentLocation = animal.findLocationName();
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"GeoLocations Resolved", "All GeoLocation names resolved for animal "+animal.getId()+
					". Animal currently located at: "+currentLocation+'.');
		} catch (Exception e) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
					"Failed to locate animal: " + animal, e.getMessage());
			logger.error(bundleMarker, "Failed to locate animal: " + animal,e);
			throw new ExecutionException("Failed to locate animal: " + animal,e);
		}
	}
	
	private void handle(ExecutionEvent event, Premises premises) throws ExecutionException {
		
		try {
			int count=0;
			for (Animal animal : premises.getAnimals()) {
				animal.findLocationName();
				count++;
			}
			
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"GeoLocations Resolved", "Resolved GeoLocation names for "+count+" animals on "+premises.getName());
		} catch (Exception e) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
					"Failed to resolve: " + premises.getName(), e.getMessage());
			logger.error(bundleMarker, "Failed to resolve: " + premises.getName(),e);
			throw new ExecutionException("Failed to resolve: " + premises.getName(),e);
		}
	}
}
