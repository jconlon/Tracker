/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEMap;

import com.verticon.tracker.EventAttributeSchema;
import com.verticon.tracker.EventSchema;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.tracker.GenericEvent#findSchema(java.util.Map.Entry) <em>Find Schema</em>}</li>
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
	 * Tests the '{@link com.verticon.tracker.GenericEvent#findSchema(java.util.Map.Entry) <em>Find Schema</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.tracker.GenericEvent#findSchema(java.util.Map.Entry)
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void testFindSchema__EMap() {
		
		//Setup the schema
		EventSchema schema = TrackerFactory.eINSTANCE.createEventSchema();
		schema.setName("someName");
		EventAttributeSchema eas = TrackerFactory.eINSTANCE.createEventAttributeSchema();
		eas.setName("testMe");
		schema.getEventAttributes().add(eas);
		
		//Set the schema - EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setEventSchema(schema);
		
		//Test to see if the eventAtribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;
		
		//Find the associated schema and see if it is the same
		assertEquals(eas, genericEvent.findSchema(eventAttribute));
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void testSetSchema() {
		
		//Setup the schema
		EventSchema schema = TrackerFactory.eINSTANCE.createEventSchema();
		schema.setName("someName");
		EventAttributeSchema eas = TrackerFactory.eINSTANCE.createEventAttributeSchema();
		eas.setName("testMe");
		schema.getEventAttributes().add(eas);
		
		//Set the schema - the EventAttributes are now added
		GenericEvent genericEvent = getFixture();
		genericEvent.setEventSchema(schema);
		
		//Test the Schema 
		assertEquals(schema, genericEvent.getEventSchema());
		
		//Test to see if the eventAtribute is added
		Object o = genericEvent.getEventAttributes().get(0);
		assertNotNull(o);
		assertTrue(o instanceof BasicEMap.Entry);
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) o;
		
		//Test the name of the eventAttribute is the same as the EventAttributeSchema name
		assertEquals(eas.getName(), eventAttribute.getKey());
	}

	@Override
	public void testGetEventCode() {
		assertNotNull(getFixture());
		assertEquals(GenericEvent.EVENT_CODE, getFixture().getEventCode());
	}


} //GenericEventTest
