/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.jxpath.JXPathContext;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Animals;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sex;
import com.verticon.tracker.TrackerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PremisesTest extends TestCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Premises fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PremisesTest.class);
	}

	/**
	 * Constructs a new Premises test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremisesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Premises fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Premises test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Premises getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(TrackerFactory.eINSTANCE.createPremises());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public void testGetPremises() {
		assertNotNull(getFixture());
		assertNull( getFixture().getAnimals());
		
	}
	
	public void testJXPath(){
		 Premises premises = getFixture();
		 premises.setAnimals(AnimalsTest.getAnimalsForTesting());
		 
		 JXPathContext context = JXPathContext.newContext(premises);
		 assertEquals(new Double(2),(Double)context.getValue("count(animals/animal)"));
		 
		 Object o = context.getValue("animals/animal[1]");
		 assertTrue(o instanceof Animal);
		 Animal animal =(Animal)o;
		 assertEquals("BOV",animal.getSpeciesCode());
		 

		 o = context.getValue("animals/animal[1]/sex");
		 assertTrue(o instanceof Sex);
		 assertEquals(Sex.F_LITERAL, (Sex)o);
		 
		 o = context.getValue("animals/animal[1]/birthDate");
		 assertTrue(o instanceof Date);
		 Date date = null;
		 try {
			 DateFormat df = DateFormat.getDateInstance();
		    date = df.parse("Sep 11, 2001");
		} catch (ParseException e) {
			fail(e.getLocalizedMessage());
		}
		 assertEquals(date, (Date)o);
		 
	}

} //PremisesTest
