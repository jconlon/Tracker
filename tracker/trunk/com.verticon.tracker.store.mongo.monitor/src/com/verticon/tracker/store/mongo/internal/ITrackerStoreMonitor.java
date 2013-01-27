package com.verticon.tracker.store.mongo.internal;

import java.net.UnknownHostException;
import java.util.Map;

import com.mongodb.MongoException;


public interface ITrackerStoreMonitor {
	String OUTPUT_DIRECTORY = "output.directory.name";
	String ENABLE_CONSOLE = "enableConsole";

	abstract ITimer getRegistrationTimer();

	abstract ITimer getRecordTimer();

	abstract ITimer getAnimalQueryTimer();
	
	abstract void incrementProcessedAnimals(long count);

	abstract void deactivate();

	abstract void activate(Map<String, Object> config) throws MongoException,
			UnknownHostException;

	interface ITimer {
		public abstract void stop();
	}


}
