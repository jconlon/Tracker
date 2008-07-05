/**
 * 
 */
package com.verticon.tracker.util;

import junit.framework.TestCase;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;

/**
 * An experimental test of the ComposedAdapterFactory
 * 
 * @author jconlon
 * 
 */
public class AdapterFactoryTest extends TestCase {

	private ComposedAdapterFactory instance;
	private FairItemProviderAdapterFactory fairItemProviderAdapterFactory;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	    fairItemProviderAdapterFactory = new FairItemProviderAdapterFactory();
		instance =  new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		instance.addAdapterFactory(fairItemProviderAdapterFactory);
		instance.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		instance = null;
		fairItemProviderAdapterFactory = null;
		super.tearDown();
	}

	
	public void testConstruction() {

		assertNotNull(instance);
	}

	/**
	 * Test method for
	 * for experimentation with adapterFactory
	 */
	public void testGetFairItemProvider() {
		Object o = instance.getFactoryForType(FairFactory.eINSTANCE.createFair());
		assertNotNull(o);
		assertEquals(o, fairItemProviderAdapterFactory);


	}

}
