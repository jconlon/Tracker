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


import static com.verticon.tracker.reader.event.bluetooth.Constants.bundleMarker;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectDeviceWizardPage extends WizardPage implements
		ISelectionChangedListener, DiscoveryListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SelectDeviceWizardPage.class);
	private ListViewer listViewer;
	private final List<RemoteDevice> remoteDevices = new CopyOnWriteArrayList<RemoteDevice>();
	private RemoteDevice selectedDevice = null;
	private CyclicBarrier barrier;// To turn the non-blocking search into a

	// blocking one

	public SelectDeviceWizardPage(String pageName) {
		super(pageName);
		setTitle("Select a Bluetooth Device");
		setDescription("Specify the Bluetooth Device for the BluetoothReader.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		listViewer = new ListViewer(container, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((RemoteDevice) element).getBluetoothAddress();
			}
		});

		listViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {
				RemoteDevice[] names = new RemoteDevice[] {};
				names = remoteDevices.toArray(names);
				return names;
			}

			@Override
			public void dispose() {

			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {

			}
		});

		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);

		listViewer.setInput(remoteDevices);
		setControl(container);

	}

	/**
	 * User selected a device.
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		this.selectedDevice = null;
		ISelection selection = event.getSelection();
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection) selection;
				this.selectedDevice = (RemoteDevice) sel.getFirstElement();
			}
		}
		updatePageComplete();
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			super.setVisible(visible);
			discoverRemoteDevices();

		} else {
			super.setVisible(visible);
		}

	}

	/**
	 * Called by the discovery task thread.
	 */
	@Override
	public void deviceDiscovered(RemoteDevice arg0, DeviceClass arg1) {
		logger.debug(bundleMarker,"Adding device {} to list of discovered devices.", arg0);
		remoteDevices.add(arg0);
	}

	/**
	 * Called by the discovery task thread.
	 */
	@Override
	public void inquiryCompleted(int arg0) {
		switch (arg0) {
		case DiscoveryListener.INQUIRY_COMPLETED:
			logger.debug(bundleMarker,"Completed discovery.");
			break;

		case DiscoveryListener.INQUIRY_ERROR:
			logger.error(bundleMarker,"Bluetooth error.");
			break;

		case DiscoveryListener.INQUIRY_TERMINATED:
			logger.debug(bundleMarker,"Canceled discovery.");
			break;
		default:
			logger.debug(bundleMarker,"Unanticipated result {}", arg0);
			break;
		}
		getContainer().getShell().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				listViewer.refresh();

				if (remoteDevices.isEmpty()) {
					setMessage(null);
					setErrorMessage("No Bluetooth devices discovered.");
				} else {
					setMessage(remoteDevices.size()
							+ " Bluetooth devices discovered.");
					setErrorMessage(null);
				}
			}
		});

		try {
			barrier.await();
		} catch (InterruptedException e) {
			logger.debug(bundleMarker,"Unanticipated result", e);
			Thread.currentThread().interrupt();
		} catch (BrokenBarrierException e) {
			logger.error(bundleMarker,"Unanticipated result", e);
		}

	}

	@Override
	public void serviceSearchCompleted(int arg0, int arg1) {
		// ignore
	}

	@Override
	public void servicesDiscovered(int arg0, ServiceRecord[] arg1) {
		// ignore
	}

	public RemoteDevice getSelectedDevice() {
		return selectedDevice;
	}

	/**
	 * Launch a background task on the container to discover any bluetooth
	 * devices, add them to the collection of discovered devices, refresh the
	 * list view.
	 */
	private void discoverRemoteDevices() {
		logger.debug(bundleMarker, "{} starting device discovery",this);
		setPageComplete(false);
		setErrorMessage(null);
		remoteDevices.clear();
		setMessage("Discovering Bluetooth devices please wait...");

		try {
			DiscoverDevice op = new DiscoverDevice();
			getContainer().run(true, true, op);
			if (op.ex != null) {
				setErrorMessage(op.ex.getLocalizedMessage());
			}
		} catch (InvocationTargetException e) {
			return;
		} catch (InterruptedException e) {
			// interrupted at the runner, reset the interrupt status and fall
			// through
			Thread.currentThread().interrupt();
			return;
		} catch (IllegalStateException e) {
			setErrorMessage("Failed to get a discovery agent. " + e);
		}

		return;
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (this.selectedDevice == null) {
			setMessage(null);
			setErrorMessage("Please select Bluetooth device.");
			return;
		}
		logger.debug(bundleMarker, "{} Selected device={}",this,selectedDevice);
		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

	class DiscoverDevice implements IRunnableWithProgress {
		Exception ex = null;

		@Override
		public void run(IProgressMonitor progress) {
			barrier = new CyclicBarrier(2);

			DiscoveryAgent agent = null;
			try {
				progress.beginTask("Performing operation ",
						IProgressMonitor.UNKNOWN);
				logger.debug(bundleMarker, "Accessing bluetooth stack.");
				LocalDevice localDevice = LocalDevice.getLocalDevice();
				agent = localDevice.getDiscoveryAgent();
				agent.startInquiry(DiscoveryAgent.GIAC,
						SelectDeviceWizardPage.this);
				barrier.await();// wait for the completion
			} catch (BluetoothStateException e) {
				logger.error("Failed to find a bluetooth discovery agent.", e);
				ex = e;
			} catch (InterruptedException e) {
				// interrupted at the barrier, reset the interrupt status
				// and fall through
				Thread.currentThread().interrupt();
			} catch (BrokenBarrierException e) {
				logger.error("Should not have broken through this barrier.");
			} finally {
				progress.done();
			}

		}

	}
}
