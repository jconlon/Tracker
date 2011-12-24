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
package com.verticon.tracker.irouter.bwcontrol;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;

/**
 * @author jconlon
 *
 */
public class CompositeConsumerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.verticon.tracker.irouter.bwcontrol.CompositeConsumer#updated(org.osgi.service.wireadmin.Wire, java.lang.Object)}.
	 */
	@Test
	public void testUpdated() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInstancof(){
		Object in = new BasicEnvelope("somveValue", "someId", "someScope");
		assertTrue(in instanceof Envelope);
//		assertEquals("xxx", in.toString());
	}

}
