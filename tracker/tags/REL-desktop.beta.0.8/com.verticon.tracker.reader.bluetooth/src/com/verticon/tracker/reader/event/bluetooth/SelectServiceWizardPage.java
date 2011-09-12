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


import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import static com.verticon.tracker.reader.event.bluetooth.Constants.bundleMarker;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DataElement;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectServiceWizardPage extends WizardPage implements
		ISelectionChangedListener, DiscoveryListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SelectServiceWizardPage.class);

	// private ListViewer listViewer;
	private TableViewer tableViewer;

	private final List<ServiceRecord> deviceServices = new CopyOnWriteArrayList<ServiceRecord>();

	private ServiceRecord selectedServiceRecord = null;

	private CyclicBarrier barrier;// To turn the non-blocking search into a
	// blocking one

	private final static UUID RFCOMM = new UUID(0x0003);
	private final static UUID[] searchList = new UUID[] { RFCOMM };

	public final static int SERVICE_NAME = 0X0100;
	public final static int SERVICE_RECORD_HANDLE = 0X0000;
	public final static int SERVICE_CLASSID_LIST = 0X0001;
	public final static int SERVICE_RECORD_STATE = 0X0002;
	public final static int SERVICE_ID = 0X0003;
	public final static int PROTOCOL_DESCRIPTOR_LIST = 0X0004;
	public final static int BROWSE_GROUP_LIST = 0X0005;
	public final static int LANGUAGE_BASED_ATTRIBUTE_ID_LIST = 0X0006;
	public final static int SERVICE_INFO_TIME_TO_LIVE = 0X0007;
	public final static int SERVICE_AVAILABILITY = 0X0008;
	public final static int BLUETOOTH_PROFILE_DESCRIPTOR_LIST = 0X0009;
	public final static int DOCUMENTATION_URL = 0X000A;
	public final static int CLIENT_EXECUTABLE_URL = 0X000B;
	public final static int ICON_URL = 0X000C;
	public final static int VERSION_NUMBER_LIST = 0X0200;
	public final static int SERVICE_DATABASE_STATE = 0X0201;

	

	// Does not work
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// SERVICE_RECORD_STATE, SERVICE_ID,PROTOCOL_DESCRIPTOR_LIST,
	// BROWSE_GROUP_LIST, LANGUAGE_BASED_ATTRIBUTE_ID_LIST,
	// SERVICE_INFO_TIME_TO_LIVE, SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST, DOCUMENTATION_URL,
	// CLIENT_EXECUTABLE_URL, ICON_URL, VERSION_NUMBER_LIST,
	// SERVICE_DATABASE_STATE };

	// //Does not work
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// SERVICE_ID,
	// PROTOCOL_DESCRIPTOR_LIST,
	// SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST, DOCUMENTATION_URL,
	// CLIENT_EXECUTABLE_URL, ICON_URL, VERSION_NUMBER_LIST,
	// SERVICE_DATABASE_STATE };

	// //Does not work
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// SERVICE_ID,
	// PROTOCOL_DESCRIPTOR_LIST,
	// SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST, DOCUMENTATION_URL,
	// CLIENT_EXECUTABLE_URL, ICON_URL, VERSION_NUMBER_LIST };

	// Does not work
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// PROTOCOL_DESCRIPTOR_LIST,
	// SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST, DOCUMENTATION_URL,
	// CLIENT_EXECUTABLE_URL, ICON_URL, VERSION_NUMBER_LIST };

	// Works
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// PROTOCOL_DESCRIPTOR_LIST,
	// SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST };

	// Works
	// int[] attrIDs = {SERVICE_NAME, SERVICE_RECORD_HANDLE,
	// SERVICE_CLASSID_LIST,
	// PROTOCOL_DESCRIPTOR_LIST,
	// SERVICE_AVAILABILITY,
	// BLUETOOTH_PROFILE_DESCRIPTOR_LIST,
	// DOCUMENTATION_URL, VERSION_NUMBER_LIST };
	
	
	// Works
	private static final int[] attrIDs = new int[] { 
		SERVICE_NAME 														
	};

	@Override
	public String toString() {
		return "SelectServiceWizardPage []";
	}

	public SelectServiceWizardPage(String pageName) {
		super(pageName);
		setTitle("Select a Bluetooth Service");
		setDescription(
				"Specify the Bluetooth Device Service as connection target for the BluetoothReader.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		tableViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		tableViewer.getControl().setLayoutData(data);
		tableViewer.addSelectionChangedListener(this);

		setControl(container);
	}

	

	/**
	 * User selected a device.
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		this.selectedServiceRecord = null;
		ISelection selection = event.getSelection();
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection) selection;
				this.selectedServiceRecord = (ServiceRecord) sel
						.getFirstElement();
			}
		}
		updatePageComplete();
	}

	@Override
	public void setVisible(boolean visible) {
		logger.debug(bundleMarker, "{} visible={}",this,visible);
		if (visible) {
			super.setVisible(visible);
			discoverRemoteDeviceServices();
		} else {
			super.setVisible(visible);
		}
	}

	/**
	 * Called by the discovery task thread.
	 */
	public void deviceDiscovered(RemoteDevice arg0, DeviceClass arg1) {

	}

	public void servicesDiscovered(int transactionID, ServiceRecord[] records) {
		for (ServiceRecord serviceRecord : records) {

			deviceServices.add(serviceRecord);
			DataElement namedElement = serviceRecord
					.getAttributeValue(SERVICE_NAME);
			if ((namedElement != null)
					&& (namedElement.getDataType() == DataElement.STRING)) {
				String name = (String) namedElement.getValue();
				logger
						.debug(
								"Search {}, discovered service named {} with {} dataElements.",
								new Object[] { transactionID, name,
										serviceRecord.getAttributeIDs().length });

			} else {
				logger
						.debug(
								"Search {}, discovered unnamed service with {} dataElements.",
								transactionID,
								serviceRecord.getAttributeIDs().length);

			}
			// int[] attIds = serviceRecord.getAttributeIDs();
			// for (int i = 0; i < attIds.length; i++) {
			// de = serviceRecord.getAttributeValue(attIds[i]);
			// int attributeID =attIds[i];
			//				
			// processDataElement(de, attributeID);
			// }

		}
	}

	private TableViewer createViewer(Composite parent) {
		TableViewer tableViewer = new TableViewer(parent, SWT.SINGLE
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] columnNames = new String[] { "Service Name", "Service URI" };
		int[] columnWidths = new int[] { 150, 400 };

		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}

		tableViewer.setLabelProvider(new ServiceRecordTableLabelProvider());

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(deviceServices);
		// tableViewer.setSorter(new ViewerSorter() {
		// public int compare(Viewer viewer, Object p1, Object p2) {
		// return ((ReaderWizardProxy) p1).getNameOfCreatedReader()
		// .compareToIgnoreCase(
		// ((ReaderWizardProxy) p2)
		// .getNameOfCreatedReader());
		// }
		// });
		tableViewer.setContentProvider(new IStructuredContentProvider() {

			public Object[] getElements(Object inputElement) {
				ServiceRecord[] names = new ServiceRecord[] {};
				names = deviceServices.toArray(names);
				return names;
			}

			public void dispose() {

			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {

			}
		});

		return tableViewer;
	}
	/**
	 * @param de
	 * @param attributeID
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void processDataElement(DataElement de, int attributeID) {
		switch (de.getDataType()) {
		case DataElement.STRING:
			logger.debug(bundleMarker,"{}: Attribute id={}, String value={}",
					new Object[]{this,
					attributeID,
					de.getValue()});
			break;
		case DataElement.UUID:
			logger.debug(bundleMarker,"{}: Attribute id={}, UUID value={}", 
					new Object[]{this,
					attributeID,
					de.getValue()});
			break;
		case DataElement.URL:
			logger.debug(bundleMarker,"{}: Attribute id={}, URL value={}", 
					new Object[]{this,
					attributeID,
					de.getValue()});
			break;
		case DataElement.DATALT:
			logger.debug(bundleMarker,"{}: Found a DatAlt for attribute id={}", this, attributeID);
			Enumeration en = (Enumeration) de.getValue();
			while (en.hasMoreElements()) {
				DataElement object = (DataElement) en.nextElement();
				processDataElement(object, attributeID);
			}

			break;

		case DataElement.DATSEQ:
			logger.debug(bundleMarker,"(): Found a DatSeq for attribute id={}", this, attributeID);
			Enumeration en2 = (Enumeration) de.getValue();
			while (en2.hasMoreElements()) {
				DataElement object = (DataElement) en2.nextElement();
				processDataElement(object, attributeID);
			}

			break;
		default:
			logger.debug(bundleMarker,"{}: Attribute id={}, value={}", this,attributeID);
			break;
		}
	}

	public void serviceSearchCompleted(int transactionID, int responseCode) {

		switch (responseCode) {
		case DiscoveryListener.SERVICE_SEARCH_DEVICE_NOT_REACHABLE:
			logger.warn(bundleMarker,"{}: Could not find device on search {}.", this, transactionID);
			break;
		case DiscoveryListener.SERVICE_SEARCH_ERROR:
			logger.warn(bundleMarker,"{}: Error searching device on search {}.", this, transactionID);
			break;
		case DiscoveryListener.SERVICE_SEARCH_NO_RECORDS:
			logger.warn(bundleMarker,"{}: No service records on device on search {}.",this,
					transactionID);
			break;
		case DiscoveryListener.SERVICE_SEARCH_TERMINATED:
			logger.info(bundleMarker,"{}: User cancelled search {}.", this, transactionID);
			break;
		case DiscoveryListener.SERVICE_SEARCH_COMPLETED:
			logger.info(bundleMarker,"{}: Service search {} complete.", this, transactionID);
			break;
		default:
			logger.error(bundleMarker,"{}: Unexpected response code {} from search {}.", new Object[]{this,
					responseCode, transactionID});
		}

		getContainer().getShell().getDisplay().asyncExec(new Runnable() {

			public void run() {
				tableViewer.refresh();

				if (deviceServices.isEmpty()) {
					setMessage(null);
					setErrorMessage("No Bluetooth device services discovered.");
				} else {
					setMessage(deviceServices.size()
							+ " Bluetooth device services discovered.");
					setErrorMessage(null);
				}
			}
		});

		try {
			barrier.await();
		} catch (InterruptedException e) {
			logger.debug(this+": Unanticipated result", e);
			Thread.currentThread().interrupt();
		} catch (BrokenBarrierException e) {
			logger.error(this+": Unanticipated result", e);
		}
	}

	/**
	 * Called by the discovery task thread.
	 */
	public void inquiryCompleted(int arg0) {
		switch (arg0) {
		case DiscoveryListener.INQUIRY_COMPLETED:
			logger.debug(bundleMarker,"{}: Completed discovery.",this);
			break;

		case DiscoveryListener.INQUIRY_ERROR:
			logger.error(bundleMarker,"{}: Bluetooth error.", this);
			break;

		case DiscoveryListener.INQUIRY_TERMINATED:
			logger.debug(bundleMarker,"{}: Canceled discovery.", this);
			break;
		default:
			logger.debug(bundleMarker,"{}: Unanticipated result {}", this, arg0);
			break;
		}
		getContainer().getShell().getDisplay().asyncExec(new Runnable() {

			public void run() {
				tableViewer.refresh();

				if (deviceServices.isEmpty()) {
					setMessage(null);
					setErrorMessage("No Bluetooth device services discovered.");
				} else {
					setMessage(deviceServices.size()
							+ " Bluetooth device services discovered.");
					setErrorMessage(null);
				}
			}
		});

		try {
			barrier.await();
		} catch (InterruptedException e) {
			logger.debug(this+": Unanticipated result", e);
			Thread.currentThread().interrupt();
		} catch (BrokenBarrierException e) {
			logger.error(this+":Unanticipated result", e);
		}

	}

	public URI getSelectedTarget() throws URISyntaxException {
		if (selectedServiceRecord == null) {
			return null;
		}
		String target = selectedServiceRecord.getConnectionURL(
				ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
		return new URI(target);
	}

	/**
	 * Launch a background task on the container to discover any bluetooth
	 * device services, add them to the collection of discovered device
	 * services, refresh the list view.
	 */
	private void discoverRemoteDeviceServices() {
		logger.debug(bundleMarker, "{} starting service discovery",this);
		setPageComplete(false);
		final RemoteDevice device = ((IDeviceSelector) getWizard())
				.getSelectedDevice();
		if (device == null) {
			setErrorMessage("Unanticipate Result. The first page completed but passed a null Remote Device.");
			return;
		}

		setErrorMessage(null);

		deviceServices.clear();
		setMessage("Discovering Bluetooth services available on device: "
				+ device.getBluetoothAddress() + ", please wait...");
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor progress) {
				barrier = new CyclicBarrier(2);
				progress.beginTask("Performing operation ",
						IProgressMonitor.UNKNOWN);
				DiscoveryAgent agent = null;
				try {
					agent = LocalDevice.getLocalDevice().getDiscoveryAgent();
					searchServices(device, agent);
					barrier.await();
				} catch (BluetoothStateException e) {
					SelectServiceWizardPage.this
							.setErrorMessage("Failed to get a discovery agent. "
									+ e);
					return;
				} catch (InterruptedException e) {
					// interrupted at the barrier, reset the interrupt status
					// and fall through
					Thread.currentThread().interrupt();
				} catch (BrokenBarrierException e) {
					logger
							.error("Should not have broken through this barrier.");
				}
				progress.done();
			}
		};
		try {
			getContainer().run(true, true, op);
		} catch (InvocationTargetException e) {
			return;
		} catch (InterruptedException e) {
			// interrupted at the runner, reset the interrupt status and fall
			// through
			Thread.currentThread().interrupt();
			return;
		}

		return;
	}

	private final void searchServices(RemoteDevice device, DiscoveryAgent agent) {

		try {
			logger.info(bundleMarker,"{}: Searching {} for services", this, device
					.getBluetoothAddress());
			int trans = agent.searchServices(attrIDs, searchList, device, this);
			logger.info(bundleMarker,"{}: Service Search {} started", this, trans);
		} catch (BluetoothStateException ex) {
			logger.error(bundleMarker,this+": BluetoothStateException: " + ex.getMessage(), ex);
		}

	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (this.selectedServiceRecord == null) {
			setMessage(null);
			setErrorMessage("Please select Bluetooth device service.");
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

	class ServiceRecordTableLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				ServiceRecord serviceRecord = (ServiceRecord) element;
				DataElement namedElement = serviceRecord
						.getAttributeValue(SERVICE_NAME);
				if ((namedElement != null)
						&& (namedElement.getDataType() == DataElement.STRING)) {
					return (String) namedElement.getValue();

				} else {
					return "Anonymous";
				}
			case 1:
				return ((ServiceRecord) element).getConnectionURL(
						ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);

			default:
				return "unknown " + columnIndex;
			}

		}

	}

}
