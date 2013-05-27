package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.getDBName;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.getPassword;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.getServerNames;
import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.getUserName;
import static com.verticon.tracker.store.mongodb.internal.Utils.validateObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;

import com.mongodb.MongoClient;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.mongo.MongoClientBuilder;
import com.verticon.mongo.MongoClientProvider;
import com.verticon.mongo.emf.transform.IFunctionProvider;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.mongodb.internal.consumer.MongoDBConsumer;

/**
 * TrackerStore with a MongoDB backend. Depends on an Authenticator,
 * IFunctionProvider and a configuration before it is activated.
 * 
 * @author jconlon
 * 
 */
public class Component implements IMongoClientProvider, ITrackerStore,
		Consumer, Monitorable {

	private MongoClientProvider mongoClientProvider;
	private final Monitor monitor = new Monitor();
	private final UpdateAndFind trackerUpdate = new UpdateAndFind();


	private final MongoDBConsumer mongoDBConsumer = new MongoDBConsumer(
			trackerUpdate, monitor);
	private Authenticator authenticator;


	@Override
	public String getDatabaseName() {
		return mongoClientProvider.getDatabaseName();
	}

	@Override
	public MongoClient getMongoClient() {
		monitor.setConnectRequest();
		return mongoClientProvider.getMongoClient();
	}

	@Override
	public String uri() {
		return mongoClientProvider.uri();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#register(com
	 * .verticon.tracker.Premises)
	 */
	@Override
	public void register(Premises premises) throws IOException {
		checkNotNull(premises, "Premises must not be null.");
		checkNotNull(premises.getLocation(),
				"Premises location must not be null.");
		validateObject(premises);

		checkForRegistratonMembership();
		trackerUpdate.register(premises);
		monitor.incrementTotalPremisesRegisted();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#recordAnimals
	 * (com.verticon.tracker.Premises)
	 */
	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		checkHasRole(premises);
		validateObject(premises);
		IUpdateStats stats = trackerUpdate.recordAnimals(premises);
		monitor.add(stats);
		return stats;
	}

	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		checkHasRole(uri);
		return trackerUpdate.record(uri, animals);
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
		checkAuthenticated();
		return trackerUpdate.retrieveAnimal(ain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#retrievePremises
	 * (java.lang.String)
	 */
	@Override
	public Premises retrievePremises(String premisesUri) throws IOException {
		checkIsAssociated(premisesUri);
		return trackerUpdate.retrievePremises(premisesUri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#retrievePremises
	 * (java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Premises retrievePremises(String premisesUri, String fromDate,
			String toDate) throws IOException {
		checkIsAssociated(premisesUri);
		return trackerUpdate.retrievePremises(premisesUri, fromDate, toDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#retrievePremises
	 * (com.verticon.tracker.store.ITrackerFind.LongLatPoint, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point, String fromDate,
			String toDate) throws IOException {

		Premises premises = trackerUpdate.retrievePremises(point, fromDate,
				toDate);
		checkIsAssociated(premises.getUri());
		return premises;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.mongodb.internal.UpdateAndFind#retrievePremises
	 * (com.verticon.tracker.store.ITrackerFind.LongLatPoint)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		Premises premises = trackerUpdate.retrievePremises(point);
		checkIsAssociated(premises.getUri());
		return premises;
	}

	@Override
	public EList<EObject> query(EClass eClass, String query) {
		throw new UnsupportedOperationException(
				"Query operations are no longer supported.");
	}

	@Override
	public void updated(Wire wire, Object in) {
		mongoDBConsumer.updated(wire, in);
	}

	@Override
	public void producersConnected(Wire[] wires) {
		mongoDBConsumer.producersConnected(wires);
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



	void activate(Map<String, Object> config) throws IOException {
		this.mongoClientProvider = new MongoClientBuilder()
				.dbName(getDBName(config)).serverNames(getServerNames(config))
				.userName(getUserName(config)).password(getPassword(config))
				.build();
		trackerUpdate.setMongoClientProvider(mongoClientProvider);
		trackerUpdate.activate();
		mongoDBConsumer.activate(config);
	}

	void deactivate() {
		this.mongoClientProvider.close();
		trackerUpdate.unsetMongoClientProvider(mongoClientProvider);
		trackerUpdate.deactivate();
		mongoDBConsumer.deactivate();
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param functionProvider
	 */
	public void setFunctionProvider(IFunctionProvider functionProvider) {
		this.trackerUpdate.setFunctionProvider(functionProvider);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param functionProvider
	 */
	public void unsetFunctionProvider(IFunctionProvider functionProvider) {
		this.trackerUpdate.unsetFunctionProvider(functionProvider);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param authenticator
	 *            the authenticator to set
	 */
	void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
		mongoDBConsumer.setAuthenticator(authenticator);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param authenticator
	 *            the authenticator to set
	 */
	void unsetAuthenticator(Authenticator authenticator) {
		this.authenticator = null;
		mongoDBConsumer.setAuthenticator(authenticator);
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

	/**
	 * Must be authenticated and in a common association.
	 */
	private void checkIsAssociated(String target) {
		checkNotNull(target, "Target argument must not be null. ");
		checkAuthenticated();
		if (!authenticator.isAssociatedWith(target)) {
			throw new SecurityException(String.format(
					"User has no association authority to access %s premises.",
					target));
		}
	}

	/**
	 * Members of the <B>TrackerRegisterPremises</B> group can register
	 * premises.
	 */
	private void checkForRegistratonMembership() {
		checkAuthenticated();
		if (!authenticator.hasRole(TRACKER_STORE_REGISTRANT)) {
			throw new SecurityException(
					"User has no authority to register this premises.");
		}
	}

	private void checkAuthenticated() {
		boolean allowed = authenticator != null
				&& authenticator.isAuthenticatedUser();
		if (!allowed) {
			throw new SecurityException("User is not authenticated.");
		}
	}

	private void checkHasRole(Premises premises) {
		checkNotNull(premises, "Premises must not be null.");
		checkHasRole(premises.getUri());
	}

	private void checkHasRole(String uri) {
		checkNotNull(uri, "Premises uri must not be null.");
		checkAuthenticated();
		if (!authenticator.hasRole(uri)) {
			throw new SecurityException(String.format(
					"User has no role authority to access %s premises.", uri));
		}
	}

}
