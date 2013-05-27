package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongodb.internal.Utils.validateObject;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.ITrackerUpdate;
import com.verticon.tracker.store.IUpdateStats;

/**
 * @deprecated use Component
 * @author jconlon
 * 
 */
@Deprecated
public class TrackerStore implements ITrackerStore {

	private ITrackerFind trackerFind;
	private ITrackerUpdate trackerUpdate;
	private Authenticator authenticator;

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
		return trackerUpdate.recordAnimals(premises);
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
		return trackerFind.retrieveAnimal(ain);
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
		return trackerFind.retrievePremises(premisesUri);
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
		return trackerFind.retrievePremises(premisesUri, fromDate, toDate);
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

		Premises premises = trackerFind.retrievePremises(point, fromDate,
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
		Premises premises = trackerFind.retrievePremises(point);
		checkIsAssociated(premises.getUri());
		return premises;
	}

	@Override
	public EList<EObject> query(EClass eClass, String query) {
		throw new UnsupportedOperationException(
				"Query operations are no longer supported.");
	}

	@Override
	public String uri() {
		return trackerUpdate.uri();
	}



	void setTrackerFind(ITrackerFind trackerFind) {
		this.trackerFind = trackerFind;
	}

	void unsetTrackerFind(ITrackerFind trackerFind) {
		this.trackerFind = null;
	}

	void setTrackerUpdate(ITrackerUpdate trackerUpdate) {

		this.trackerUpdate = trackerUpdate;
	}

	void unsetTrackerUpdate(ITrackerUpdate trackerUpdate) {

		this.trackerUpdate = null;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param authenticator
	 *            the authenticator to set
	 */
	void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param authenticator
	 *            the authenticator to set
	 */
	void unsetAuthenticator(Authenticator authenticator) {
		this.authenticator = null;
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
