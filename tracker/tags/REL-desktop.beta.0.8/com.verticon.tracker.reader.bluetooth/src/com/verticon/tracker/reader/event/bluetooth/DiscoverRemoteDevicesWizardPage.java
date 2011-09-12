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
/**
 * 
 */
package com.verticon.tracker.reader.event.bluetooth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author jconlon
 *
 */
public class DiscoverRemoteDevicesWizardPage extends WizardPage {

	/**
	 * Lock object on the discovery
	 */
	final Object inquiryCompletedEvent = new Object();
	
	/**
	 * Vector to hold devices
	 */
	public final Vector<RemoteDevice> devicesDiscovered = new Vector<RemoteDevice>();
	
	protected DiscoverRemoteDevicesWizardPage(String pageName) {
		super(pageName);
		setTitle("Discover Bluetooth RemoteDevices");
		setDescription("Would you like to initiate a discover of remote bluetooth devices?");
	}

	
	@Override
	public boolean canFlipToNextPage() {
		return ! devicesDiscovered.isEmpty();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
	    container.setLayout(new GridLayout(1, true));

	    // Create the indeterminate checkbox
	    final Button indeterminate = new Button(container, SWT.CHECK);
	    indeterminate.setText("Indeterminate");

	    // Create the ShowProgress button
	    Button showProgress = new Button(container, SWT.NONE);
	    showProgress.setText("Discover Bluetooth Devices");

	    final Shell shell = parent.getShell();

	    
	    // Display the ProgressMonitorDialog
	    showProgress.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  setErrorMessage(null);
	        try {
	          new ProgressMonitorDialog(shell).run(true, true,
	              new LongRunningOperation(true));
	          setErrorMessage(null);
				setMessage("Found " +devicesDiscovered.size()+" Bluetooth devices.",
						IMessageProvider.INFORMATION);
	          		
	        } catch (InvocationTargetException e) {
	          
//	          MessageDialog.openError(shell, "Error", e.getMessage());
	     
	          setErrorMessage(e.getLocalizedMessage());
	        } catch (InterruptedException e) {
//	          MessageDialog.openInformation(shell, "Cancelled", e.getMessage());
	          setErrorMessage(e.getLocalizedMessage());
	        }
	      }
	    });

	    parent.pack();
	    setControl(container);
	    
	}

	/**
	 * This class represents a long running operation
	 */
	private class LongRunningOperation implements IRunnableWithProgress {
	  
	  /**
	   * LongRunningOperation constructor
	   * 
	   * @param indeterminate whether the animation is unknown
	   */
	  public LongRunningOperation(boolean indeterminate) {
	
	  }

	  /**
	   * Runs the long running operation
	   * 
	   * @param monitor the progress monitor
	   */
	  public void run(IProgressMonitor monitor) throws InvocationTargetException,
	      InterruptedException {
		try {
			init( monitor);
		} catch (BluetoothStateException e) {
			monitor.subTask(e.getLocalizedMessage());
			setErrorMessage(e.getMessage());
		}
	    monitor.done();
	    if (monitor.isCanceled())
	        throw new InterruptedException("The Bluetooth Device discovery operation was cancelled");
	  }
	}
	
	MyDiscoveryListener listener = new MyDiscoveryListener();
	
	class MyDiscoveryListener implements DiscoveryListener {

		IProgressMonitor monitor;
		
		public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
			monitor.subTask("Device " + btDevice.getBluetoothAddress()
					+ " found");
			devicesDiscovered.addElement(btDevice);
			try {
				monitor.subTask("     name "
						+ btDevice.getFriendlyName(false));
			} catch (IOException cantGetDeviceName) {
			}
		}

		public void inquiryCompleted(int discType) {
			monitor.subTask("Device Inquiry completed!");
			synchronized (inquiryCompletedEvent) {
				inquiryCompletedEvent.notifyAll();
			}
		}

		public void serviceSearchCompleted(int transID, int respCode) {
		}

		public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
		}
	};
	
	private void init(IProgressMonitor monitor) throws InterruptedException, BluetoothStateException {
		synchronized (inquiryCompletedEvent) {
			listener.monitor=monitor;
			monitor.beginTask("Bluetooth Discovery Started...", IProgressMonitor.UNKNOWN );
			boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent()
					.startInquiry(DiscoveryAgent.GIAC, listener);
			if (started) {
				monitor.subTask("wait for device inquiry to complete...");
				inquiryCompletedEvent.wait();
				monitor.subTask(devicesDiscovered.size()
						+ " device(s) found");
			}
		}
	}
	

	public Vector<RemoteDevice> getDevicesDiscovered() {
		return devicesDiscovered;
	}
}
