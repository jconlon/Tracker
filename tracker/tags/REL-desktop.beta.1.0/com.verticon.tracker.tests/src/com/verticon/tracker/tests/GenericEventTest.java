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
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.osgi.service.metatype.ObjectClassDefinition;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.Scalar;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.GenericEvent#findAttributeDefinition(org.eclipse.emf.common.util.EMap) <em>Find Attribute Definition</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#findName() <em>Find Name</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#value(java.lang.String) <em>Value</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#hasRequiredAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Required Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#hasValidAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Valid Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#hasAllAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has All Attributes</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GenericEventTest extends EventTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GenericEventTest.class);
	}

	/**
	 * Constructs a new Generic Event test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericEventTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Generic Event test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GenericEvent getFixture() {
		return (GenericEvent)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createGenericEvent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	
	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#findAttributeDefinition(org.eclipse.emf.common.util.EMap) <em>Find Attribute Definition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#findAttributeDefinition(org.eclipse.emf.common.util.EMap)
	 * @generated NOT
	 */
	public void testFindAttributeDefinition__EMap() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		//Add the 
		ocd.getAD().add(ad);

		//For the following to create the map entries that represent attributes the following
		//MUST NOT return NULL
		assertNotNull(ocd.getAttributeDefinitions(ObjectClassDefinition.ALL));


		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the associated schema and see if it is the same
		assertEquals(ad, genericEvent.findAttributeDefinition(eventAttribute));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#findName() <em>Find Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#findName()
	 * @generated NOT
	 */
	public void testFindName() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		//Add the 
		ocd.getAD().add(ad);

		//For the following to create the map entries that represent attributes the following
		//MUST NOT return NULL
		assertNotNull(ocd.getAttributeDefinitions(ObjectClassDefinition.ALL));


		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);
		assertEquals("someName", genericEvent.findName());
	}

	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#value(java.lang.String) <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#value(java.lang.String)
	 * @generated NOT
	 */
	public void testValue__String() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		//Add the 
		ocd.getAD().add(ad);


		//For the following to create the map entries that represent attributes the following
		//MUST NOT return NULL
		assertNotNull(ocd.getAttributeDefinitions(ObjectClassDefinition.ALL));


		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the value
		assertNull(genericEvent.value("testMe"));
		
		genericEvent.getEventAttributes().put("testMe", "haha");
		assertEquals("haha",genericEvent.value("testMe"));
		
		
	}

	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#hasRequiredAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Required Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#hasRequiredAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated NOT
	 */
	public void testHasRequiredAttributes__DiagnosticChain_Map() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
	
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		ad.setDataType(Scalar.STRING);
		ad.setRequired(true);
		//Add the 
		ocd.getAD().add(ad);

		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the value
		assertNull(genericEvent.value("testMe"));

		genericEvent.getEventAttributes().put("testMe", "haha");
		assertEquals("haha",genericEvent.value("testMe"));
		DiagnosticChain dc = new BasicDiagnostic();
		assertTrue(dc.toString(), genericEvent.hasRequiredAttributes(dc, null));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#hasValidAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Valid Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#hasValidAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated NOT
	 */
	public void testHasValidAttributes__DiagnosticChain_Map() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		//Add the 
		ocd.getAD().add(ad);


		//For the following to create the map entries that represent attributes the following
		//MUST NOT return NULL
		assertNotNull(ocd.getAttributeDefinitions(ObjectClassDefinition.ALL));


		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the value
		assertNull(genericEvent.value("testMe"));

		assertTrue(genericEvent.hasValidAttributes(new BasicDiagnostic(), null));
	}

	/**
	 * Tests the '{@link com.verticon.tracker.GenericEvent#hasAllAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has All Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#hasAllAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated NOT
	 */
	public void testHasAllAttributes__DiagnosticChain_Map() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");
		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		//Add the 
		ocd.getAD().add(ad);


		//For the following to create the map entries that represent attributes the following
		//MUST NOT return NULL
		assertNotNull(ocd.getAttributeDefinitions(ObjectClassDefinition.ALL));


		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the value
		assertNull(genericEvent.value("testMe"));

		assertTrue(genericEvent.hasAllAttributes(new BasicDiagnostic(), null));
				
	}


	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(GenericEvent.EVENT_CODE, getFixture().getEventCode());
	}
	
	@Override
	public void testValues() {
		//Setup the ObjectClassDefinition
		OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setName("someName");

		//Add an attribute
		AD ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName("testMe");
		ad.setDataType(Scalar.STRING);
		ad.setRequired(true);
		//Add the 
		ocd.getAD().add(ad);
		
		//Add an attribute
				 ad = MetatypeFactory.eINSTANCE.createAD();
				ad.setName("testMeTwo");
				ad.setDataType(Scalar.BOOLEAN);
				ad.setRequired(true);
				ad.setDefault("false");
				//Add the 
				ocd.getAD().add(ad);

		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setOcd(ocd);

		//Test to see if the eventAttribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry<?,?>);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;

		//Find the value
		assertNull(genericEvent.value("testMe"));

		genericEvent.getEventAttributes().put("testMe", "haha");
		genericEvent.getEventAttributes().put("testMeTwo", "false");
		assertEquals("haha",genericEvent.value("testMe"));
		assertEquals("testMeTwo: false, testMe: haha", genericEvent.values());
	}


} //GenericEventTest
