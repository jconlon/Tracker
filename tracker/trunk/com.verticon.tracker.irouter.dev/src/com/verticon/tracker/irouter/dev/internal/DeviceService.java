package com.verticon.tracker.irouter.dev.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants.DeviceType;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

public class DeviceService {
	public static final String PLUGIN_ID = "com.verticon.tracker.irouter.dev";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(DeviceService.class);


	private final Map<IDeviceListener, Future<Void>> futures = new HashMap<IDeviceListener, Future<Void>>();
	private ExecutorService exec;
	
	
	public void addListener(IDeviceListener listener){
		if(exec == null){
			exec = Executors.newCachedThreadPool();
		}
		synchronized (futures){
			Future<Void> future = null;
			
			try {
				switch ((DeviceType)listener.getProperty(Property.TYPE)) {
				case SERVER_SOCKET:
					Callable<Void> callable = new ServerSocketCallable(listener);
					future =  exec.submit(callable);
					break;
				case SERVER_COMM_PORT:
					callable = new ServerCommPortCallable(listener);
					future =  exec.submit(callable);
					break;

				default:
					logger.error(bundleMarker,"Unknown device type");
					return;
				}
			} catch (Exception e) {
				logger.error(bundleMarker,"Failed to start",e);
			}
			logger.debug(bundleMarker,"Submitted "+listener);
			futures.put(listener, future);
		}
	}
	
	public void removeListener(IDeviceListener listener){
		
		synchronized (futures){
			Future<Void>future = futures.get(listener);
			future.cancel(true);
			futures.remove(listener);
		}
		logger.debug(bundleMarker,"Removed "+listener);
	}
	
	public void startup() {
		logger.debug(bundleMarker,"Started ");
	}

	
	public void shutdown(){
		if(exec!=null){
		 exec.shutdownNow();
		}
		logger.debug(bundleMarker,"Shutdown");
		exec = null;
	}
}
