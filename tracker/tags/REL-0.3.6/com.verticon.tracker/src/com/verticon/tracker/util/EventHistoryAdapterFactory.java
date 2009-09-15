package com.verticon.tracker.util;

import org.eclipse.emf.common.notify.Adapter;

import com.verticon.tracker.EventHistory;
import com.verticon.tracker.impl.AnimalEventHistoryAdapter;
import com.verticon.tracker.impl.PremisesEventHistoryAdapter;

/**
 * AdapterFactory for adding EventHistory functionality to Premises
 * and Animal elements.
 * 
 * @see AnimalEventHistoryAdapter
 * @see PremisesEventHistoryAdapter
 * @see EventHistory
 * 
 * @author jconlon
 *
 */
public class EventHistoryAdapterFactory extends TrackerAdapterFactory {

	@Override
	public Adapter createAnimalAdapter() {
		return new AnimalEventHistoryAdapter();
	}

	@Override
	public Adapter createPremisesAdapter() {
		 return new PremisesEventHistoryAdapter();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return type == EventHistory.class || 
			super.isFactoryForType(type);
	}
	
	public static EventHistoryAdapterFactory
		INSTANCE = new EventHistoryAdapterFactory();

}
