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
package com.verticon.tracker.reader.event.bluetooth;

import java.net.URI;
import java.net.URISyntaxException;

import javax.bluetooth.RemoteDevice;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.irouter.gps.ui.IURIWizard;

public class BluetoothURIWizard extends Wizard implements IURIWizard, IDeviceSelector{

	private static final String WIZARD_TITLE = "Add a Bluetooth Device";

	/**
	 * Finished product of this Wizard
	 */
	private URI target;

	/**
	 * Pages to select a RemoteDevice service URI.
	 */
	private SelectDeviceWizardPage firstPage = new SelectDeviceWizardPage(
			"Discover Bluetooth RemoteDevices");
	private SelectServiceWizardPage secondPage = new SelectServiceWizardPage(
			"Discover Bluetooth Services");

	/**
	 * Adds a single page to query the user for the Remote Bluetooth device.
	 */
	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		setNeedsProgressMonitor(true);
		addPage(firstPage);
		addPage(secondPage);
	}

	/**
	 * Determines if the wizard can enable the Finish Button
	 */
	@Override
	public boolean canFinish() {
		try {
			return getSelectedTarget() != null;
		} catch (URISyntaxException e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
	    target = null;
		try {
			target = getSelectedTarget();
		} catch (URISyntaxException e) {
			secondPage.setErrorMessage(e.getMessage());
			return false;
		}
		
		return true;

	}

	/**
	 * Return the finished target
	 */
	@Override
	public URI getURI() {
		return target;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// this.workbench = workbench;
	}

	public RemoteDevice getSelectedDevice() {
		return firstPage.getSelectedDevice();
	}

	private URI getSelectedTarget() throws URISyntaxException {
		return secondPage.getSelectedTarget();
	}

}
