/**
 * 
 */
package com.verticon.tracker.reader.event.bluetooth;

import java.io.IOException;
import java.util.Vector;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

/**
 * @author jconlon
 * 
 */
public class SelectBluetoothDeviceWizardPage extends WizardPage {

	public final Vector<RemoteDevice> devicesDiscovered;
	private IWorkbench workbench;

	private ListViewer listViewer;

	private RemoteDevice selectedDevice = null;

	

	public SelectBluetoothDeviceWizardPage(String pageName, String title,
			String description, IWorkbench workbench, Vector<RemoteDevice> devicesDiscovered) {
		super(pageName);
		this.workbench = workbench;
		setTitle(title);
		setDescription(description);
		this.devicesDiscovered=devicesDiscovered;
	}

	

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

		listViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		setControl(container);
	}

	protected ListViewer createViewer(Composite parent) {
		ListViewer listViewer = new ListViewer(parent, SWT.SINGLE
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		listViewer.setLabelProvider(new RemoteDeviceListLabelProvider());
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setInput(getRemoteDeviceList());
		listViewer.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object p1, Object p2) {
				return ((RemoteDevice) p1).getBluetoothAddress()
						.compareToIgnoreCase(
								((RemoteDevice) p2).getBluetoothAddress());
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

				selectedDevice = (RemoteDevice) selection.getFirstElement();

				setErrorMessage(null);
				setMessage(selectedDevice.getBluetoothAddress() + " "
						+ selectedDevice.toString(),
						IMessageProvider.INFORMATION);

			}
		});

		return listViewer;
	}

	/**
	 * Builds a list of publisher wizards from the extension points and do lazy
	 * instantiations after selection.
	 * 
	 * @return
	 * 
	 */
	RemoteDevice[] getRemoteDeviceList() {
		return devicesDiscovered.toArray(new RemoteDevice[] {});
	}

	/**
	 * 
	 * @return
	 */
	RemoteDevice getSelectedDevice() {
		return selectedDevice;
	}

	

	class RemoteDeviceListLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			RemoteDevice publisher = (RemoteDevice) element;
			return publisher.getBluetoothAddress();
		}
	}



}
