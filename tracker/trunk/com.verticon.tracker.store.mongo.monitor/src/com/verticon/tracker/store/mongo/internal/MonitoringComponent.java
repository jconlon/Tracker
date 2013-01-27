package com.verticon.tracker.store.mongo.internal;

import java.io.IOException;
import java.util.Map;

import com.mongodb.DB;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.mongo.internal.ITrackerStoreMonitor.ITimer;

/**
 * TrackerStore that monitors performance.
 * 
 * @author jconlon
 * 
 */
public class MonitoringComponent extends Component {

	ITrackerStoreMonitor monitor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongo.internal.Component#recordAnimals(com
	 * .verticon.tracker.Premises)
	 */
	@Override
	public int recordAnimals(Premises premises) throws IOException {
		int totalAnimalsProcessed = 0;
		final ITimer context = monitor.getRecordTimer();
		try {
			totalAnimalsProcessed = super.recordAnimals(premises);
		} finally {
			context.stop();
		}
		monitor.incrementProcessedAnimals(totalAnimalsProcessed);
		return totalAnimalsProcessed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongo.internal.Component#retrieveAnimal(java
	 * .lang.String)
	 */
	@Override
	public Animal retrieveAnimal(String ain) {
		Animal animal = null;
		final ITimer context = monitor.getAnimalQueryTimer();
		try {
			animal = super.retrieveAnimal(ain);
		} finally {
			context.stop();
		}
		return animal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongo.internal.Component#register(com.verticon
	 * .tracker.Premises)
	 */
	@Override
	public void register(Premises premises) throws IOException {
		final ITimer context = monitor.getRegistrationTimer();
		try {
			super.register(premises);
		} finally {
			context.stop();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongo.internal.Component#activate(java.util
	 * .Map)
	 */
	@Override
	void activate(Map<String, Object> config) throws IOException {
		super.activate(config);
		DB db = mongoLocator.getTrackerDatabase();
		monitor = new MongoTrackerStoreMonitor(db);
		monitor.activate(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.store.mongo.internal.Component#deactivate()
	 */
	@Override
	void deactivate() {
		super.deactivate();
		monitor.deactivate();
		monitor = null;
	}

}
