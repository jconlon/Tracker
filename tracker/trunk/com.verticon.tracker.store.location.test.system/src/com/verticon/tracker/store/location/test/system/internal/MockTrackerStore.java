package com.verticon.tracker.store.location.test.system.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;

public class MockTrackerStore implements ITrackerStore {

	@Override
	public void register(Premises premises) throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public Premises retrievePremises(String uri, String in, String out)
			throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public Premises retrievePremises(String uri) throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public Premises retrievePremises(LongLatPoint point, String in, String out)
			throws IOException {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public Animal retrieveAnimal(String ain) {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public EList<EObject> query(EClass eClass, String query) {
		throw new IllegalStateException("Should not be called.");
	}

	@Override
	public String uri() {
		return "WRONG";
	}

	@Override
	public Map<String, String> getPremisesNames(Set<String> uris) {
		// TODO Auto-generated method stub
		return null;
	}

}
