package com.verticon.tracker.irouter.dev.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

public class ServerSocketCallable implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ServerSocketCallable.class);

	public final static int DEFAULT_PORT = 2345;
	private final int socket;
	private final IDeviceListener listener;

	public ServerSocketCallable(IDeviceListener listener) {
		super();
		this.listener = listener;
		this.socket = listener.getProperty(Property.SOCKET) != null ? (Integer) listener
				.getProperty(Property.SOCKET) : DEFAULT_PORT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServerSocketCallable [socket=" + socket + ", listener="
				+ listener + "]";
	}

	@Override
	public Void call() throws Exception {
		Date startDate = new Date();

		ServerSocket ss = null;
		try {
			ss = new ServerSocket(socket);
			ss.setSoTimeout(200);
			while (listener != null && !Thread.currentThread().isInterrupted()) {
				Socket s = null;
				try {
					s = ss.accept();
					s.setKeepAlive(false);
					Date connectDate = new Date();
					long mills = connectDate.getTime() - startDate.getTime();
					logger.info(
							"{} Connected to {} in {} seconds.",
							new Object[] { this, s.getInetAddress(),
									s.getPort(), mills / 1000 });
					OutputStream out = s.getOutputStream();
					InputStream in = s.getInputStream();
					listener.connected(out, in);
					logger.info(
							"{} Closing {} : {}",
							new Object[] { this, s.getInetAddress(),
									s.getPort() });

				} catch (SocketTimeoutException e) {
					logger.debug("{} SocketTimeout waiting for connection"
							+ this);
				} catch (InterruptedException e) {
					break;
				} catch (IOException e) {
					logger.info(this+" exception terminated connection with message: {}",e.getMessage());
				} finally {
					if (s != null) {
						logger.debug(
								"{} Closing connection from {} : {}",
								new Object[] { this, s.getInetAddress(),
										s.getPort() });
						s.close();
					}
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (ss != null) {
				try {
					logger.info(this + " Shutting down...");
					ss.close();
				} catch (IOException e) {
					logger.error(this + " Failed to shutdown", e);
				}
			}
		}
		return null;
	}

}
