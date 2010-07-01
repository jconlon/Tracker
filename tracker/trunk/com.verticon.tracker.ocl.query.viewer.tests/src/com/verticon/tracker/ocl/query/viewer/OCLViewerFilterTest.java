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

import static com.verticon.tracker.ocl.query.viewer.Constants.bundleMarker;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OCLViewerFilterTest extends TestCase {

	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(OCLViewerFilterTest.class);

    private OclQuery oclQuery = null;
    private OCLViewerFilter instance = null;
	
	@Override
	protected void setUp() throws Exception {
		oclQuery = new OclQuery("Animal 169");
		oclQuery.setErrorSyntax("This is an error");
		oclQuery.setQuery("self.id='840003002956169'");
		oclQuery.setType("Animal");
		instance = new OCLViewerFilter(oclQuery);
	}

	@Override
	protected void tearDown() throws Exception {
		instance=null;
		oclQuery=null;
	}
	
	public void testHashCode() {
		logger.debug(bundleMarker, "Testing hashcode");
		OCLViewerFilter instance2 = new OCLViewerFilter(oclQuery);
		assertEquals(instance.hashCode(), instance2.hashCode());
	}

	
	public void testEqualsObject() {
		OCLViewerFilter instance2 = new OCLViewerFilter(oclQuery);
		assertEquals(instance, instance2);
	}

//	public void testSelect(){
//		Caprine animal = TrackerFactory.eINSTANCE.createCaprine();
//		Tag tag = TrackerFactory.eINSTANCE.createTag();
//		tag.setId("840003002956169");
//		animal.getTags().add(tag);
//		assertEquals(animal.getId(), tag.getId());
//	}
}
