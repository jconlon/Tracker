package com.verticon.tracker.irouter.dev.internal;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

public class ServerCommPortCallable implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ServerCommPortCallable.class);

	public final String port;
	private final IDeviceListener listener;

	public ServerCommPortCallable(IDeviceListener listener) {
		super();
		this.listener = listener;
		this.port = (String)listener.getProperty(Property.PORT);
		
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServerCommPortCallable [port=" + port + ", listener="
				+ listener + "]";
	}


	@Override
	public Void call() throws Exception {
		Date startDate = new Date();

		CommPort thePort = null;

		try {
			CommPortIdentifier com = CommPortIdentifier.getPortIdentifier(port);

			thePort = com.open("PortOpener", 10);
			while (listener != null && !Thread.currentThread().isInterrupted()) {

				try {
					Date connectDate = new Date();
					long mills = connectDate.getTime() - startDate.getTime();
					logger.info("{} connected in {} seconds.", this, mills / 1000);
					OutputStream out = thePort.getOutputStream();
					InputStream in = thePort.getInputStream();
					listener.connected(out, in);
					logger.info("{} closing",this);

				} catch (InterruptedException e) {
					break;
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					if (thePort != null) {
						logger.info("{} closing connection",this);
						thePort.close();
					}
				}
			}

		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (thePort != null) {
				logger.info("{} Shutting down...",this);
				thePort.close();

			}
		}
		return null;
	}

}
