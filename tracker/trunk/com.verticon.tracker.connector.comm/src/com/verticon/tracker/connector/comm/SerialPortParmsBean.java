package com.verticon.tracker.connector.comm;

import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.net.URI;
import java.net.URISyntaxException;

public class SerialPortParmsBean {

	private int baudRate = 9600;
	private int dataBits = SerialPort.DATABITS_8;
	private int stopBits = SerialPort.STOPBITS_1;
	private int parity = SerialPort.PARITY_NONE;
	private int flowControl = SerialPort.FLOWCONTROL_NONE;
	private String portName;

	public int getFlowControl() {
		return flowControl;
	}

	public void setFlowControl(int flowControl) {
		this.flowControl = flowControl;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	/**
	 * uri will look like: comm://COM1;baudrate=9600;databits=9
	 * 
	 * @param name
	 * @throws URISyntaxException
	 */
	public SerialPortParmsBean(String name) throws URISyntaxException {
		super();
		if(name == null || name.trim().length()<1){
			throw new URISyntaxException("", "name cannot be null.");
		}
		URI uri = new URI(name);
		if(!uri.getScheme().equals("comm")){
			throw new URISyntaxException(name, uri.getScheme()+ " is an unsupported schema. The schema must be comm.");
		}
		String specificPart = uri.getSchemeSpecificPart();
		String[] result = specificPart.split(";");
		if(result[0].contains("=")){
			throw new URISyntaxException(name, 
					uri.getSchemeSpecificPart()+
					" is an unsupported schemaSpecificPart. The first token must be a comm port name.");
		}
		portName = result[0];
		
		for (int x = 0; x < result.length; x++) {
			try {
				process(result[x]);
			} catch (IllegalArgumentException e) {
				throw new URISyntaxException(name, e.getMessage());
			}
		}
	}

	public int getDataBits() {
		return dataBits;
	}

	void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	public int getBaudRate() {
		return baudRate;
	}

	void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	public int getStopBits() {
		return stopBits;
	}

	void setStopBits(int stopBits) {
		this.stopBits = stopBits;
	}

	public int getParity() {
		return parity;
	}

	void setParity(int parity) {
		this.parity = parity;
	}

	void setParameters(SerialPort port)
			throws UnsupportedCommOperationException {
		port.setSerialPortParams(this.baudRate, this.dataBits, this.stopBits,
				this.parity);
		port.setFlowControlMode(flowControl);
	}

	private void process(String token) {
		if (!token.contains("=")) {
			return;
		}
		String[] result = token.split("=");
		if (result.length != 2) {
			return;
		}
		String parm = result[0].toLowerCase();
		// uri will look like: comm://COM1;baudrate=9600;databits=9
		if (parm.equals("baudrate")) {
			processBaudRate(result[1]);
		} else if (parm.equals("stopbits")) {
			processStopBits(result[1]);
		} else if (parm.equals("databits")) {
			processDataBits(result[1]);
		} else if (parm.equals("parity")) {
			processParity(result[1]);
		} else if (parm.equals("flowcontrol")) {
			processFlowControl(result[1]);
		}else{
			throw new IllegalArgumentException(parm
					+ " is an illegal parameter name. Legal values are baudrate, stopbits, databits, parity, and flowcontrol.");
		}

	}

	private void processBaudRate(String s) {
		baudRate = Integer.parseInt(s);
	}

	private void processParity(String value) {
		if (value.equals("E")) {
			this.parity = SerialPort.PARITY_EVEN;
		} else if (value.equals("M")) {
			this.parity = SerialPort.PARITY_MARK;
		} else if (value.equals("N")) {
			this.parity = SerialPort.PARITY_NONE;
		} else if (value.equals("O")) {
			this.parity = SerialPort.PARITY_ODD;
		} else if (value.equals("S")) {
			this.parity = SerialPort.PARITY_SPACE;
		}else{
		throw new IllegalArgumentException(value
				+ " is an illegalArgument for parity. Legal values are M, N, O, S");
		}
	}

	private void processStopBits(String value) {
		if (value.equals("1")) {
			this.stopBits = SerialPort.STOPBITS_1;
		} else if (value.equals("2")) {
			this.stopBits = SerialPort.STOPBITS_2;
		} else if (value.equals("1.5")) {
			this.stopBits = SerialPort.STOPBITS_1_5;
		}else{
		throw new IllegalArgumentException(value
				+ " is an illegalArgument for stopbits. Legal values are 1, 2, 1.5.");
		}
	}

	private void processDataBits(String value) {
		if (value.equals("5")) {
			this.dataBits = SerialPort.DATABITS_5;
		} else if (value.equals("6")) {
			this.dataBits = SerialPort.DATABITS_6;
		} else if (value.equals("7")) {
			this.dataBits = SerialPort.DATABITS_7;
		} else if (value.equals("8")) {
			this.dataBits = SerialPort.DATABITS_8;
		} else{
		throw new IllegalArgumentException(value
				+ " is an illegalArgument for dataBits. Legal values are 5, 6, 7, 8.");
		}
	}

	private void processFlowControl(String value) {
		if (value.toLowerCase().equals("none")) {
			this.flowControl = SerialPort.FLOWCONTROL_NONE;
		} else if (value.toLowerCase().equals("rtsctsin")) {
			this.flowControl = SerialPort.FLOWCONTROL_RTSCTS_IN;
		} else if (value.toLowerCase().equals("rtsctsout")) {
			this.flowControl = SerialPort.FLOWCONTROL_RTSCTS_OUT;
		} else if (value.toLowerCase().equals("xonxoffin")) {
			this.flowControl = SerialPort.FLOWCONTROL_XONXOFF_IN;
		} else if (value.toLowerCase().equals("xonxoffout")) {
			this.flowControl = SerialPort.FLOWCONTROL_XONXOFF_OUT;
		} else{
		throw new IllegalArgumentException(value
				+ " is an illegalArgument for flowcontrol. Legal values are none, rtsctsin, rtsctsout, xonxoffin, xonxoffout.");
		}
	}
}
