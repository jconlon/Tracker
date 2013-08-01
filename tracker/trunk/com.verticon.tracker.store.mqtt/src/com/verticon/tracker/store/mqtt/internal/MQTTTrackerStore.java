/**
 * 
 */
package com.verticon.tracker.store.mqtt.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.tracker.store.TrackerStoreUtils.validateObject;
import static com.verticon.tracker.store.mqtt.internal.StatusAndConfigVariables.getServerName;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;

/**
 * @author jconlon
 * 
 */
public class MQTTTrackerStore implements ITrackerStore, Consumer, Monitorable {

	private static String PLUGIN_ID = "com.verticon.tracker.store.mqtt";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		MQTTTrackerStore.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MQTTTrackerStore.class);

	private final Monitor monitor = new Monitor();
	private final UpdateAndFind updateAndFind = new UpdateAndFind(this);
	private final MQTTConsumer consumer = new MQTTConsumer(this, monitor);
	private Map<String, Object> config = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerUpdate#register(com.verticon.tracker
	 * .Premises)
	 */
	@Override
	public void register(Premises premises) throws IOException {
		checkNotNull(premises, "Premises must not be null.");
		checkNotNull(premises.getLocation(),
				"Premises location must not be null.");
		validateObject(premises);
		updateAndFind.register(premises);
		monitor.incrementTotalPremisesRegisted();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerUpdate#recordAnimals(com.verticon.
	 * tracker.Premises)
	 */
	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		validateObject(premises);
		IUpdateStats stats = updateAndFind.recordAnimals(premises);
		monitor.add(stats);
		return stats;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.store.ITrackerUpdate#record(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		return updateAndFind.record(uri, animals);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#retrieveAnimal
	 * (java.lang.String)
	 */
	@Override
	public Animal retrieveAnimal(String ain) {
		return updateAndFind.retrieveAnimal(ain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerFind#retrievePremises(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public Premises retrievePremises(String premisesUri, String fromDate,
			String toDate) throws IOException {
		return updateAndFind.retrievePremises(premisesUri, fromDate, toDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerFind#retrievePremises(java.lang.String
	 * )
	 */
	@Override
	public Premises retrievePremises(String premisesUri) throws IOException {
		return updateAndFind.retrievePremises(premisesUri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerFind#retrievePremises(com.verticon
	 * .tracker.store.ITrackerFind.LongLatPoint)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		Premises premises = updateAndFind.retrievePremises(point);
		return premises;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerFind#retrievePremises(com.verticon
	 * .tracker.store.ITrackerFind.LongLatPoint, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point, String fromDate,
			String toDate) throws IOException {

		Premises premises = updateAndFind.retrievePremises(point, fromDate,
				toDate);
		return premises;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerFind#getPremisesNames(java.util.Set)
	 */
	@Override
	public Map<String, String> getPremisesNames(Set<String> uris) {
		return updateAndFind.getPremisesNames(uris);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#query(org.eclipse.emf.ecore.
	 * EClass, java.lang.String)
	 */
	@Override
	public EList<EObject> query(EClass eClass, String query) {
		throw new UnsupportedOperationException(
				"Query operations are no longer supported.");
	}

	@Override
	public String query(String query) throws IOException {
		return updateAndFind.query(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#uri()
	 */
	@Override
	public String uri() {
		return getServerName(getConfig());
	}

	@Override
	public void updated(Wire wire, Object in) {
		consumer.updated(wire, in);
	}

	@Override
	public void producersConnected(Wire[] wires) {
		consumer.producersConnected(wires);
	}

	@Override
	public String[] getStatusVariableNames() {
		return monitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return monitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return monitor.getDescription(id);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		monitor.setMonitorListener(monitorListener);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		monitor.unsetMonitorListener(monitorListener);
	}

	void activate(Map<String, Object> config) throws IOException {
		this.config = config;
		monitor.activate(config);
		updateAndFind.activate(config);
		consumer.activate(config);
	}

	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		updateAndFind.deactivate();
		consumer.deactivate();
		monitor.deactivate();
	}

	/**
	 * @return the config
	 */
	Map<String, Object> getConfig() {
		return config;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MQTTTrackerStore [uri()=" + uri() + "]";
	}

}
