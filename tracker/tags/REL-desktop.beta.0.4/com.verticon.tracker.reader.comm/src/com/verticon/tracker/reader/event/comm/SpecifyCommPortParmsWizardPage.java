/**
 * 
 */
package com.verticon.tracker.reader.event.comm;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author jconlon
 *
 */
public class SpecifyCommPortParmsWizardPage extends WizardPage {

	private Combo baudRate = null;
	private Combo dataBits = null;
	private Combo stopBits = null;
	private Combo parity = null;
	private Combo flowControl = null;
	
	public SpecifyCommPortParmsWizardPage(String pageName) {
		super(pageName);
		setTitle("Select Comm Port Parameters");
		setDescription("Specify the Comm Port Paramerters for the SerialPortReader.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);
		
		//BaudRate
		//300-238400
		String[] items = new String[]{"300", "1200", "2400","4800", "9600", "14400",
				"19200", "28800", "33600", "48000", "56000", "64000"};
		baudRate = makeDropDownRow(container, "Baud Rate:", items);
		
		items = new String[]{"5", "6", "7","8"};
		dataBits = makeDropDownRow(container, "Data Bits:", items);
		
		items = new String[]{"1", "1.5", "2"};
		stopBits =makeDropDownRow(container, "Stop Bits:", items);

		items = new String[]{"M", "N", "O", "S"};
		parity =makeDropDownRow(container, "Parity:", items);
		
		items = new String[]{"none", "rtsctsin", "rtsctsout", "xonxoffin", "xonxoffout"};
		flowControl = makeDropDownRow(container, "Flow Control:", items);
		
		setControl(container);


	}

	/**
	 * @param container
	 * @param name
	 * @param items
	 */
	private Combo makeDropDownRow(Composite container, String name,
			String[] items) {
		Label label = new Label(container, SWT.LEFT);
		label.setText(name);
		Combo baudRate = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN );
		baudRate.setItems(items);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
//		gridData.grabExcessHorizontalSpace=true;
		baudRate.setLayoutData(gridData);
		return baudRate;
	}
	
	//comm://COM1;baudrate=9600;databits=9
	String getCommURI(String portName){
		if(baudRate==null){
			return "comm://"+portName;
		}
		try {
			URI uri = new URI("comm",//schema
					getSsp ( portName),//ssp
					null);
			return uri.toString();
		} catch (URISyntaxException e) {
			throw new IllegalStateException(e);
		}
		
	}
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			setPageComplete(false);
			
		}

		super.setVisible(visible);
	}
	
	private String getSsp (String portName){
		StringBuffer sb = new StringBuffer(portName);
		if(getValue(baudRate)!=null){
			sb.append(";baudrate=");
			sb.append(getValue(baudRate));
		}
		
		if(getValue(dataBits)!=null){
			sb.append(";databits=");
			sb.append(getValue(dataBits));
		}
		
		if(getValue(stopBits)!=null){
			sb.append(";stopbits=");
			sb.append(getValue(stopBits));
		}
		
		if(getValue(parity)!=null){
			sb.append(";parity=");
			sb.append(getValue(parity));
		}
		
		if(getValue(flowControl)!=null){
			sb.append(";flowcontrol=");
			sb.append(getValue(flowControl));
		}
		
		return sb.toString();
	}
	private String getValue(Combo combo){
		int index = combo.getSelectionIndex();
		return index!= -1?combo.getItem(index):null;
	}

}
