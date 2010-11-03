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
package com.verticon.tracker.irouter.monitor.view.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jconlon
 *
 */
public class ComponentTest {

	Component instance = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		instance = new Component();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.verticon.tracker.irouter.monitor.view.internal.Component#getModel()}.
	 */
	@Test
	public final void testGetModel() {
		
		assertNotNull(instance);
		Set <INode> wiredNodes = instance.getModel();
		assertNotNull(wiredNodes);
		assertTrue(wiredNodes instanceof IObservableSet);
		IObservableSet observables = (IObservableSet) wiredNodes;
		
		assertTrue(observables.isEmpty());
		Counter counter = new Counter();
		observables.addSetChangeListener(counter);
		
		assertTrue(counter.countOfNodes==0);
		WiredNode wiredNode = new ProducerWiredNode(
				"test",// group, 
				"pid", 
				"scope",
				88// service_id
				);
		wiredNodes.add(wiredNode);
		assertEquals(1,wiredNodes.size());
		assertEquals(1,counter.countOfNodes);
		//Try and add it again
		boolean added = wiredNodes.add(wiredNode);
		assertFalse(added);
		assertEquals(1,wiredNodes.size());
		assertEquals(1,counter.countOfNodes);
		
		wiredNodes.remove(wiredNode);
		assertEquals(0,wiredNodes.size());
		assertEquals(0,counter.countOfNodes);
		
		
	}

	class Counter implements ISetChangeListener{
	    int countOfNodes = 0;
		@Override
		public void handleSetChange(SetChangeEvent event) {
			SetDiff dif = event.diff;
			countOfNodes = countOfNodes+dif.getAdditions().size();
			countOfNodes = countOfNodes-dif.getRemovals().size();
		}
		
	}
}
