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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

import com.verticon.tracker.Premises;
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
	
//	public void testDelegtes(){
//		EPackage ePackage = TrackerPackage.eINSTANCE;//fixture.getTrackerPackage();
//		List<EAnnotation> notes = ePackage.getEAnnotations();
//		assertFalse(notes.isEmpty());
//		
//		
//		EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
//		assertNotNull(eAnnotation);
//		System.out.println(eAnnotation.toString());
//	}

	/**
	 * This is a test of the https://bugs.eclipse.org/bugs/show_bug.cgi?id=353171
	 * @throws InvocationTargetException 
	 */
	public void test_queryExecutionWithLibrary() throws InvocationTargetException {
		OCL.initialize(null);
        QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
            .getFactory(OCLDelegateDomain.OCL_DELEGATE_URI);
        assertNotNull("Factory should not be null",factory);
        String n = "n";
        String expression = "self.name";
//        Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
//        library.setName("test");
        
        Premises premises = TrackerFactory.eINSTANCE.createPremises();
        premises.setName("test");
        
        Map<String, EClassifier> parameters = new HashMap<String,EClassifier>();
        parameters.put(n, EcorePackage.Literals.ESTRING);
        QueryDelegate delegate = factory.createQueryDelegate( TrackerPackage.Literals.PREMISES,
            parameters, expression);
        Map<String, Object> bindings = new HashMap<String, Object>();
        bindings.put(n, "test");
        Object result =// execute(delegate, premises, bindings);
        delegate.execute(premises, bindings);
        assertEquals(result, "test");
    }

}
