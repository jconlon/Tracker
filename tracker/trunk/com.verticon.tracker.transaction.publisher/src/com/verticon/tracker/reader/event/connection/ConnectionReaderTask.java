package com.verticon.tracker.reader.event.connection;

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
public class ConnectionReaderTask implements Callable<RefreshablePublisher> {

	private static final int SLEEP_MILS = 100;
	final Logger logger = LoggerFactory.getLogger(ConnectionReaderTask.class);
	private final String target;
	private final BundleContext bundleContext;
	private final RefreshablePublisher reader;
	private final StringBuilder builder = new StringBuilder();

	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param tagIdPublisher
	 *            to send tagIds
	 * @param target
	 *            of Connection
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
	public RefreshablePublisher call() throws Exception {
		logger.debug("{} opening background connection to {}",reader,target);
		ConnectorService cs = getConnectorService();
		InputConnection connection = (InputConnection)cs.open(target, ConnectorService.READ);
		
		byte[] tmp=new byte[1024];
		InputStream in = null;
		Exception ex = null;
		try {
			
			in = connection.openInputStream();//  openInputStream(target);
			logger.info("{} background connection {} opened",reader, target);
			while ( !Thread.currentThread().isInterrupted()) {
				if(in.available()>0){
			          int i=in.read(tmp, 0, 1024);
			          if(i<0)break;
			          process(i, tmp);
			      }
				  TimeUnit.MILLISECONDS.sleep(SLEEP_MILS);
			}
			connection.close();
			
			logger.info("{} background connection {} has terminated.",
					reader, target);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.info("{} canceled background connection {}.",
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
				logger.info("{} background connection {} cancelled", reader, target);
			}
		} finally {
			if (connection != null)
				try {
					//in.close(); //closing the inputStream is not good enough
					connection.close(); //must close the connection or the port will stay in use.
					
					logger.info("{} background connection {} closed.",
							reader,target);

				} catch (IOException e) {
					logger.error(reader+" failed to close background connection " + target,
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
		logger.debug("{} background connection {} publishing {}", 
				new Object[]{
				reader,
				target, 
				tag}
		);
		reader.publish(tag);
		logger.info("{} background connection {} published {}", 
				new Object[]{
				reader,
				target, 
				tag}
		);
	}
	
	private void process(int count, byte[] data){
//		System.out.print("Processing buffer ");
//		System.out.write(data, 0, count);
//		System.out.println("");
		char c ;
		for (int i = 0; i < count; i++) {
			c = (char)data[i];
//			System.out.println("Processing char {" +c+'}');
			if(c=='\r'| c=='\n'){
				if(builder.length()==15){
					sendTag(builder.toString());
				}
				builder.delete(0, 15);
			}else{
				builder.append(c);
//				System.out.println("Appending {"+c+'}');
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
		
		if (sr == null) {
			throw new IOException("Failed to find a ConnectorService.");
		}

		return cs;

	}

}
