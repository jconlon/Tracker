/**
 * 
 */
package com.verticon.tracker.reader.event.comm;
import static com.verticon.tracker.reader.event.comm.CommReaderPlugin.bundleMarker;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * Presents the user with a ListViewer of available comm ports.
 * 
 * @author jconlon
 * 
 */
public class SpecifyCommPortWizardPage extends WizardPage implements
		ISelectionChangedListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SpecifyCommPortWizardPage.class);

	private ListViewer listViewer;

	private final Vector<String> portNames = new Vector<String>();
	
	private String selectedPortName = null;

	public SpecifyCommPortWizardPage(String pageName) {
		super(pageName);
		setTitle("Select a Comm Port");
		setDescription("Specify the Comm Port for the SerialPortReader.");
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
		// Label label = new Label(container, SWT.NULL);
		// label.setText("Seconds Between Generations:");
		listViewer = new ListViewer(container, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (String) element;
			}
		});

		listViewer.setContentProvider(new ArrayContentProvider());
		try {
			init();

		} catch (NoAvailableSerialPortsException e) {
			setMessage(null);
			setErrorMessage(e.getMessage());
		}
		String[] names = new String[] {};
		names = portNames.toArray(names);

		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);

		listViewer.setInput(names);
		setControl(container);
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (this.selectedPortName==null) {
			setMessage(null);
			setErrorMessage("Please select a comm port.");
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

	public void selectionChanged(SelectionChangedEvent event) {
		this.selectedPortName=null;
		ISelection selection = event.getSelection();
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection)selection;
				this.selectedPortName=(String)sel.getFirstElement();
			}
		}
		updatePageComplete();
	}


	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			setPageComplete(false);
			listViewer.refresh();
		}

		super.setVisible(visible);
	}

		
	@SuppressWarnings("unchecked")
	void init() throws NoAvailableSerialPortsException {
		CommReaderPlugin.getDefault().configureValidSerialPorts();
		portNames.clear();
		Enumeration e = CommPortIdentifier.getPortIdentifiers();
		while (e.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) e.nextElement();
			String portName = com.getName();

			switch (com.getPortType()) {
			case CommPortIdentifier.PORT_SERIAL:
				if (com.isCurrentlyOwned()) {
					logger.debug(
						"Identified {} as a serial port, but it is owned by the {} application.",
						portName, com.getCurrentOwner());
				} else {
					logger.debug(
						"Identified {} as an unowned serial port. Testing to see if it is controlled by an external application.",
						portName);
					CommPort c = null;
					try {
						c = com.open(this.getClass().getSimpleName(), 10);
						try {
							c.getInputStream();
						} catch (IOException e1) {
							throw new PortInUseException();
						}
						portNames.add(portName);
						logger.debug(
								"Identified {} as an available serial port.",
								portName);
					} catch (PortInUseException e1) {
						logger.debug(
								"Identified {} as an unowned serial port, but is controlled by an external application.",
								portName);
					} finally {
						if (c != null)
							c.close();
					}
				}
				break;
			case CommPortIdentifier.PORT_PARALLEL:
				logger.debug(bundleMarker,"Identified {} as a parallel port.", portName);
				break;
			default:
				logger.debug(bundleMarker,"Identified {} as a port of unknown type.",
						portName);
				break;
			}
		}

		if (portNames.isEmpty()) {
			throw new NoAvailableSerialPortsException(
					"Cant find any free serial ports. Make sure you have configured all your usable serial ports in the SerialPortReader User Preferences.");
		}
	}

	public String getSelectedPortName() {
		return selectedPortName;
	}

	
}
