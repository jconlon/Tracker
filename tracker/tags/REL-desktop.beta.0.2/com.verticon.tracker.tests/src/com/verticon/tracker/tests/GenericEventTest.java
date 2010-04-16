/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEMap;
import org.osgi.service.metatype.ObjectClassDefinition;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link GenericEvent#findAttributeDefinition(java.util.Map.Entry)} <em>Find AttributeDefinition</em>}</li>
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
	
	
	@SuppressWarnings("unchecked")
	public void testfindAttributeDefinition__AttributeDefinition() {
		
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
	


	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(GenericEvent.EVENT_CODE, getFixture().getEventCode());
	}


} //GenericEventTest
