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
package com.verticon.tracker.ocl.query.viewer;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Caprine;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import static com.verticon.tracker.ocl.query.viewer.Constants.bundleMarker;

public class OclQueryTest extends TestCase {

	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(OclQueryTest.class);


	OclQuery instance = null;
	
	@Override
	protected void setUp() throws Exception {
		instance = new OclQuery("Animal 169");
		instance.setErrorSyntax("This is an error");
		instance.setQuery("self.id='840003002956169'");
		instance.setType("Animal");
	}

	@Override
	protected void tearDown() throws Exception {
		instance=null;
	}
	

	public void testEquals() {
		logger.debug(bundleMarker,"Testing equals");
		OclQuery instance2 = new OclQuery("Animal 169");
		instance2.setErrorSyntax("This is an error");
		instance2.setQuery("self.id='840003002956169'");
		instance2.setType("Animal");
		assertEquals(instance, instance2);
	}

	public void testHashCode() {
		logger.debug(bundleMarker,"Testing hashcode");
		OclQuery instance2 = new OclQuery("Animal 169");
		instance2.setErrorSyntax("This is an error");
		instance2.setQuery("self.id='840003002956169'");
		instance2.setType("Animal");
		assertEquals(instance.hashCode(), instance2.hashCode());
	}
	
	public void testClone() {
		OclQuery instanceClone = instance.clone();
		assertEquals(instance, instanceClone);
	}

	//The Following two methods work with an Platform to get the context so they
	//will only pass if run as a JUnit Plugin test
	public void testValidate(){
		logger.debug(bundleMarker, "Testing validate");
		boolean result = instance.validateQuery();
		assertTrue(instance.getErrorSyntax(),result);
	}
	
	public void testCheck(){
		Caprine animal = TrackerFactory.eINSTANCE.createCaprine();
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId("840003002956169");
		animal.getTags().add(tag);
		assertEquals(animal.getId(), tag.getId());
//		assertTrue(instance.validateQuery());
		boolean result = instance.conditionIsSatisfied(animal);
		assertTrue(result);
	}
}
