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
package com.verticon.tracker.reader.event.connection;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.InputConnection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.AbstractConnectionReader;

/**
 * Sends tagIDs obtained from a target uri via the OSGi ConnectorService to a
 * tagIdPublisher.
 * 
 * @author jconlon
 * 
 */
public class ConnectionReaderTask implements Callable<RefreshableReader> {

	private static final int SLEEP_MILS = 100;
	private final Logger logger = LoggerFactory.getLogger(ConnectionReaderTask.class);
	private final String target;
	private final BundleContext bundleContext;
	private final RefreshableReader reader;
	private final StringBuilder builder = new StringBuilder();

	
	/**
	 * Primary constructor
	 * @param eventReader
	 * @param bundleContext
	 */
	public ConnectionReaderTask(AbstractConnectionReader eventReader, 
			BundleContext bundleContext) {
		this.target = eventReader.getTarget().toString();
		this.reader=eventReader;
		this.bundleContext = bundleContext;
	}

	/**
	 * Call that reads tagIds from the target connection. Can be canceled
	 * with a thread interruption.
	 */
	@Override
	public RefreshableReader call() throws Exception {
		logger.debug(bundleMarker,"{} opening background connection to {}",reader,target);
		ConnectorService cs = getConnectorService();
		InputConnection connection = (InputConnection)cs.open(target, ConnectorService.READ);
		
		byte[] tmp=new byte[1024];
		InputStream in = null;
		Exception ex = null;
		try {
			
			in = connection.openInputStream();//  openInputStream(target);
			logger.info(bundleMarker, "{} background connection {} opened",reader, target);
			while ( !Thread.currentThread().isInterrupted()) {
				if(in.available()>0){
			          int i=in.read(tmp, 0, 1024);
			          if(i<0)break;
			          process(i, tmp);
			      }
				  TimeUnit.MILLISECONDS.sleep(SLEEP_MILS);
			}
			connection.close();
			
			logger.info(bundleMarker,"{} background connection {} has terminated.",
					reader, target);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.info(bundleMarker,"{} canceled background connection {}.",
					reader, target);
		} catch (IOException e) {
			if (!Thread.currentThread().isInterrupted()) {
				if(e.getCause()!=null){
					logger.error(reader+" background connection " + target + ' '+e.getCause()+' '+e.getCause().getMessage(), e);
				}else{
					String message = e.getMessage();
					if(message==null){
						logger.error(reader+" background connection " + target + ' '+e.getClass().getSimpleName(), e);
					}else{
						logger.error(reader+" background connection " + target + ' '+e.getClass().getSimpleName() +' '+message, e);
					}
				}
				ex=e;
			} else {
				logger.info(bundleMarker,"{} background connection {} cancelled", reader, target);
			}
		} finally {
			if (connection != null)
				try {
					//in.close(); //closing the inputStream is not good enough
					connection.close(); //must close the connection or the port will stay in use.
					
					logger.info(bundleMarker,"{} background connection {} closed.",
							reader,target);

				} catch (IOException e) {
					logger.error(bundleMarker, reader+" failed to close background connection " + target,
							e);
				}
		}
		if (ex != null) {
			throw ex;
		}
		return reader;
	}

	private void sendTag(String s) {
		Long tag;
		try {
			tag = Long.parseLong(s);
		} catch (NumberFormatException e) {
			logger.warn(reader+" failed to parse string {} in background connection {}.", s,
					target);
			return;
		}
		logger.debug(bundleMarker,"{} background connection {} publishing {}", 
				new Object[]{
				reader,
				target, 
				tag}
		);
		reader.publish(tag);
		logger.info(bundleMarker,"{} background connection {} published {}", 
				new Object[]{
				reader,
				target, 
				tag}
		);
	}
	
	private void process(int count, byte[] data){
		logger.debug(bundleMarker, "Processing {} reader input {}", reader, toAscii(new String(data, 0, count)));

		char c ;
		for (int i = 0; i < count; i++) {
			c = (char)data[i];
			if(c=='\r'| c=='\n'){
				// System.out.println(toAscii("Dataforwarding char detected {" +
				// c + '}'));
				if (builder.length() > 14) {
					String input = builder.toString();
					if (builder.length() > 15) {
						input = input.substring(5, 20);
					}
					logger.debug(bundleMarker, "Forwarding data buffer <{}> from reader {}", input,
							reader);
					sendTag(input);
					builder.delete(0, builder.length() + 1);
				} else {
					logger.warn(bundleMarker, "Redundent forwarding character received at character position {} .",
							count);
					builder.delete(0, builder.length() + 1);
				}

			}else{
				builder.append(c);
				// System.out.println(toAscii("Processing and appended char {" +
				// c + '}'));
			}
			
		}
		
	}

	private ConnectorService getConnectorService() throws IOException {
		ServiceReference sr = bundleContext
				.getServiceReference(ConnectorService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ConnectorService.");
		}

		ConnectorService cs = (ConnectorService) bundleContext.getService(sr);

		return cs;

	}

	/**
	 * Convert a String to visualize nonvisible characters
	 * 
	 * @param value
	 * @return an Ascii representation
	 */
	public static String toAscii(String value) {
		StringBuffer buffer = new StringBuffer();
		buffer.append('<');
		for (int i = 0; i < value.length(); ++i) {

			char c = value.charAt(i);
			replaceNonCharacters(c, buffer);
		}
		buffer.append('>');
		return buffer.toString();
	}

	/**
	 * Replace non characters with a %int% value to represent there ascii
	 * decimal id.
	 * 
	 * @param ch
	 * @param buffer
	 */
	public static void replaceNonCharacters(char ch, StringBuffer buffer) {
		if (Character.isISOControl(ch)) {
			buffer.append('%');
			int j = ch;
			buffer.append(j);
			buffer.append('%');
		} else {
			buffer.append(ch);
		}

	}
}
