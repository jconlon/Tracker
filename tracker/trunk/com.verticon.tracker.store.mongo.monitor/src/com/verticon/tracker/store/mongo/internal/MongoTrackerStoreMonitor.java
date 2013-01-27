package com.verticon.tracker.store.mongo.internal;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoException;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.core.MetricPredicate;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;
import com.yammer.metrics.reporting.ConsoleReporter;
import com.yammer.metrics.reporting.CsvReporter;

public class MongoTrackerStoreMonitor implements ITrackerStoreMonitor {

  
	MongoTrackerStoreMonitor(DB db) {
		super();
		this.db = db;
		createGauges();
		createPremisesGauges();
		createAnimalGauges();
	}

	private static final String ANIMAL = "Animal";

	private static final String PREMISES = "Premises";

	private final MetricsRegistry metricsRegistry = new MetricsRegistry();

	// Registration elapsed time in milliseconds and invocations per second.
	private final Timer registrationTimer = metricsRegistry.newTimer(
			MongoTrackerStoreMonitor.class, "Premises-Registration-Time");
	// Animal store elapsed time in milliseconds and invocations per second.
	private final Timer storeTimer = metricsRegistry.newTimer(
			MongoTrackerStoreMonitor.class, "Animal-Store-Time");
	// Animal query elapsed time in milliseconds and invocations per second.
	private final Timer animalQueryTimer = metricsRegistry.newTimer(
			MongoTrackerStoreMonitor.class, "Animal-Query-Time");
	private final Counter processedAnimalCounter = metricsRegistry.newCounter(
			MongoTrackerStoreMonitor.class, "Processed-animals");

	private void createGauges() {
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class, "DB-objects",
				new Gauge<Long>() {
					@Override
					public Long value() {
						return dbObjects.get();
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class, "DB-dataSize",
				new Gauge<Long>() {
					@Override
					public Long value() {
						return dbDataSize.get();
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"DB-indexSize", new Gauge<Long>() {
					@Override
					public Long value() {
						return dbIndexSize.get();
					}
				});
	}

	private void createPremisesGauges() {
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"Premises-count", new Gauge<Long>() {
					@Override
					public Long value() {
						return premisesCount.get();// /**
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"Premises-size", new Gauge<Long>() {
					@Override
					public Long value() {
						return premisesSize.get();
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"Premises-totalIndexSize", new Gauge<Long>() {
					@Override
					public Long value() {
						return premisesTotalIndexSize.get();
					}
				});
	}

	private void createAnimalGauges() {
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"Animal-count",
				new Gauge<Long>() {
					@Override
					public Long value() {
						return animalCount.get();
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
 "Animal-size",
				new Gauge<Long>() {
					@Override
					public Long value() {
						return animalSize.get();
					}
				});
		metricsRegistry.newGauge(MongoTrackerStoreMonitor.class,
				"Animal-totalIndexSize", new Gauge<Long>() {
					@Override
					public Long value() {
						return animalTotalIndexSize.get();
					}
				});
	}

	// For mongo
	private final DB db;
	private final ScheduledExecutorService ex = Executors
			.newSingleThreadScheduledExecutor();
	private final AtomicLong dbObjects = new AtomicLong();
	private final AtomicLong dbDataSize = new AtomicLong();
	private final AtomicLong dbIndexSize = new AtomicLong();
	private final AtomicLong premisesCount = new AtomicLong();
	private final AtomicLong premisesSize = new AtomicLong();
	private final AtomicLong premisesTotalIndexSize = new AtomicLong();
	private final AtomicLong animalCount = new AtomicLong();
	private final AtomicLong animalSize = new AtomicLong();
	private final AtomicLong animalTotalIndexSize = new AtomicLong();

	private final ConsoleReporter consoleReporter = new ConsoleReporter(
			metricsRegistry, System.out, MetricPredicate.ALL);
	private CsvReporter cvsReporter = null;

	@Override
	public void activate(Map<String, Object> config) throws MongoException,
			UnknownHostException {
		ex.scheduleWithFixedDelay(new Runner(), 1l, 1l, TimeUnit.SECONDS);
		// Configuration is for
		// Console enablement,
		boolean enableConsole = (Boolean) config.get(ENABLE_CONSOLE);
		if (enableConsole) {
			consoleReporter.start(1, TimeUnit.SECONDS);
		}
		// File enablement,
		// Directory for File output
		String dirName = (String) config.get(OUTPUT_DIRECTORY);
		if(dirName!=null){
			File outputDirectory = new File(dirName);
			if(outputDirectory.exists()){
			try {
				delete(outputDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		outputDirectory.mkdir();
		cvsReporter= new CsvReporter(metricsRegistry,outputDirectory);
		cvsReporter.start( 1, TimeUnit.SECONDS);
		}
		

	}
	
	@Override
	public void deactivate() {
		ex.shutdown();
		consoleReporter.shutdown();
	}
	
	// @Override
	// public synchronized void setDB(DB db) {
	// this.db = db;
	// }

	private synchronized CommandResult getStats() {
		return db.getStats();
	}

	private synchronized CommandResult getPremisesStats() {
		CommandResult result = null;
		if (db.collectionExists(PREMISES)) {
			result = db.getCollection(PREMISES).getStats();
		}
		return result;
	}

	private synchronized CommandResult getAnimalStats() {
		CommandResult result = null;
		if (db.collectionExists(ANIMAL)) {
			result = db.getCollection(ANIMAL).getStats();
		}
		return result;
	}

	private class Runner implements Runnable {
		@Override
		public void run() {
			if (db == null) {
				return;
			}
			CommandResult results = getStats();
			dbObjects.set(results.getLong("objects"));
			dbDataSize.set(results.getLong("dataSize"));
			dbIndexSize.set(results.getLong("indexSize"));

			results = getPremisesStats();
			premisesCount.set(results.getLong("count"));
			premisesSize.set(results.getLong("size"));
			premisesTotalIndexSize.set(results.getLong("totalIndexSize"));

			results = getAnimalStats();
			animalCount.set(results.getLong("count"));
			animalSize.set(results.getLong("size"));
			animalTotalIndexSize.set(results.getLong("totalIndexSize"));
		}
		
	}

	@Override
	public ITimer getRegistrationTimer() {
		return new TimerImpl(registrationTimer.time());
	}

	@Override
	public ITimer getRecordTimer() {
		return new TimerImpl(storeTimer.time());
	}

	@Override
	public ITimer getAnimalQueryTimer() {
		return new TimerImpl(animalQueryTimer.time());
	}

	@Override
	public void incrementProcessedAnimals(long count) {
		processedAnimalCounter.inc(count);
	}

	/**
	 * Deletes the directory and all the files
	 * 
	 * @param file
	 * @throws IOException
	 */
	private static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();
				System.out.println("Directory is deleted : "
						+ file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : "
							+ file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	class TimerImpl implements ITimer {
		private final TimerContext timer;

		TimerImpl(TimerContext timer) {
			super();
			this.timer = timer;
		}

		@Override
		public void stop() {
			timer.stop();
		}

	}
}
