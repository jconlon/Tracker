package com.verticon.tracker.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EDataType;

import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.Age;

public class TrackerFactoryTest extends TestCase {

	/**
	 * The fixture for this Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackerFactory fixture = null;
	
	
	
	protected void setUp() throws Exception {
		super.setUp();
		fixture = TrackerFactory.eINSTANCE;
	}

	protected void tearDown() throws Exception {
		fixture=null;
		super.tearDown();
	}

	public void testCreateAgeFromString() {
		EDataType eDataType =  TrackerPackage.Literals.AGE;	
		String initialValue = "928 days old";
		Object o = fixture.createFromString( eDataType, initialValue);
		assertTrue(o instanceof Age);
		assertEquals("928 days old", ((Age)o).toString());
		
	}

//	public void testConvertAgeToString() {
//		fail("Not yet implemented"); // TODO
//	}

}
