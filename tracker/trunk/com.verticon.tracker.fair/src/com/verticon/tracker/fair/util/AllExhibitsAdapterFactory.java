package com.verticon.tracker.fair.util;

import org.eclipse.emf.common.notify.Adapter;

import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.impl.FairAllExhibitsAdapter;


/**
 * AdapterFactory for adding AllExhibits functionality to a 
 * Fair element.
 * 
 * @see FairAllExhibitsAdapter
 * @see AllExhibits
 * 
 * @author jconlon
 *
 */
public class AllExhibitsAdapterFactory extends FairAdapterFactory {

	@Override
	public Adapter createFairAdapter() {
		return new FairAllExhibitsAdapter();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return type == AllExhibits.class || 
		super.isFactoryForType(type);
	}

	public static AllExhibitsAdapterFactory
	INSTANCE = new AllExhibitsAdapterFactory();

}
