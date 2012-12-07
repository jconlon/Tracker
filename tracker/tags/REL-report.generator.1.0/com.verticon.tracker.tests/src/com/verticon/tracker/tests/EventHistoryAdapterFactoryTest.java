/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.tests;

import junit.framework.TestCase;

import com.verticon.tracker.Animal;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.impl.AnimalEventHistoryAdapter;
import com.verticon.tracker.impl.PremisesEventHistoryAdapter;
import com.verticon.tracker.util.EventHistoryAdapterFactory;

/**
 * Produces adapters implementing EventHistory
 * for Animal and Premises elements.
 * 
 * @author jconlon
 * @see AnimalEventHistoryAdapter
 * @see PremisesEventHistoryAdapter
 * @see EventHistory
 */
public class EventHistoryAdapterFactoryTest extends TestCase {

	/**
	 * The fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Premises premises = null;
	
	protected Animal animal = null;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		premises = TrackerFactory.eINSTANCE.createPremises();
		animal = TrackerFactory.eINSTANCE.createBovineBeef();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.EventHistoryAdapterFactory#isFactoryForType(java.lang.Object)}.
	 */
	public void testIsFactoryForTypeObject() {
		assertTrue(EventHistoryAdapterFactory.INSTANCE.isFactoryForType(EventHistory.class));
		assertFalse(EventHistoryAdapterFactory.INSTANCE.isFactoryForType(Animal.class));
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.EventHistoryAdapterFactory#createAnimalAdapter()}.
	 */
	public void testCreateAnimalAdapter() {
		Object o = EventHistoryAdapterFactory.INSTANCE.adapt(animal,EventHistory.class);
		assertNotNull(o);
		assertTrue("Should be an AnimalEventHistoryAdapter", o instanceof AnimalEventHistoryAdapter);
		Object o2 = EventHistoryAdapterFactory.INSTANCE.adapt(animal,EventHistory.class);
		assertEquals(o,o2);
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.EventHistoryAdapterFactory#createPremisesAdapter()}.
	 */
	public void testCreatePremisesAdapter() {
		Object o = EventHistoryAdapterFactory.INSTANCE.adapt(premises,EventHistory.class);
		assertNotNull(o);
		assertTrue("Should be an PremisesEventHistoryAdapter", o instanceof PremisesEventHistoryAdapter);
		Object o2 = EventHistoryAdapterFactory.INSTANCE.adapt(premises,EventHistory.class);
		assertEquals(o,o2);
	}

}
