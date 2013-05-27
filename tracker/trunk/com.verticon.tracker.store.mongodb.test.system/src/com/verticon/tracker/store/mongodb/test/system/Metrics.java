package com.verticon.tracker.store.mongodb.test.system;

import static com.yammer.metrics.MetricRegistry.name;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.LoggerFactory;

import com.yammer.metrics.MetricRegistry;
import com.yammer.metrics.Slf4jReporter;
import com.yammer.metrics.Timer;

public class Metrics {

	static AtomicBoolean isStarted = new AtomicBoolean();
	static AtomicBoolean isStopped = new AtomicBoolean();

	static final MetricRegistry metricsRegistry = new MetricRegistry(
			"com.verticon.tracker.store.mongodb.test.system");

	static final Timer registrationTimer = metricsRegistry.timer(name(
			Metrics.class, "Premises", "registration"));

	static final Timer recordTimer = metricsRegistry.timer(name(Metrics.class,
			"Animal", "record"));

	static final Slf4jReporter reporter = Slf4jReporter
			.forRegistry(metricsRegistry)
			.outputTo(
					LoggerFactory
							.getLogger("com.verticon.tracker.store.mongodb.test.system.Metrics"))
			.convertRatesTo(TimeUnit.SECONDS)
			.convertDurationsTo(TimeUnit.MILLISECONDS).build();

	public Metrics() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 */
	static void activate() {
		if (!isStarted.getAndSet(true)) {
			reporter.start(1, TimeUnit.SECONDS);
		}

	}

	static void deactivate() {
		if (!isStopped.getAndSet(true)) {
			reporter.stop();
		}

	}
}
