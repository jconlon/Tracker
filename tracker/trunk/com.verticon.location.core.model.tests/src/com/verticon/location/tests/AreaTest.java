/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.verticon.location.Area;
import com.verticon.location.LocationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.location.Area#getAreaMeasurement() <em>Get Area Measurement</em>}</li>
 *   <li>{@link com.verticon.location.Area#containsPoint(java.lang.String) <em>Contains Point</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AreaTest extends TestCase {

	 static final String GOOD_NW_POLYGON_COORDS = "-90.90982670995385,43.57098775766727,0 -90.8972513926231,43.56296804513263,0 -90.88062357846694,43.56863037203934,0 -90.90982670995385,43.57098775766727,0 ";
	 static final String GOOD_S_POLYGON_COORDS = "-90.90597300448167,43.56094113196455,0 -90.90578543447558,43.54706237968161,0 -90.8598357582942,43.54650428222089,0 -90.86257041771218,43.56148985546094,0 -90.90597300448167,43.56094113196455,0";
	 static final String SOUTH_FAIRGROUNDS_POINT = "-90.88524331476012,43.56588903714386,0";
	 static final String BASEBALL_FIELD_POINT = "-90.89322601925117,43.55460596065134,1.0";
	
	
	/**
	 * The fixture for this Area test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Area fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AreaTest.class);
	}

	/**
	 * Constructs a new Area test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Area test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Area fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Area test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Area getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LocationFactory.eINSTANCE.createArea());
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
	 * Tests the '{@link com.verticon.location.Area#getAreaMeasurement() <em>Get Area Measurement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Area#getAreaMeasurement()
	 * @generated NOT
	 */
	public void testGetAreaMeasurement() {
		getFixture().setBoundary(GOOD_NW_POLYGON_COORDS);
		getFixture().setName("test");
		double area = getFixture().getAreaMeasurement();
		assertThat("Area measurement must be . ", area, is(1.022779236470317E-4));
		getFixture().setBoundary(GOOD_S_POLYGON_COORDS);
		double area2 = getFixture().getAreaMeasurement();
		assertThat("Area measurement must be . ", area2, is(6.447663527888239E-4));
		
	}

	public void testValidation(){
		getFixture().setName("test");
		String coor1 = "-90.90982670995385,-43.57098775766727,0";
	
		getFixture().setBoundary(GOOD_NW_POLYGON_COORDS);
		String validationResults = validateObject(getFixture());
		assertThat("Area must be valid. "+validationResults, validationResults, is(nullValue()));
		
		getFixture().setBoundary(coor1);
	    validationResults = validateObject(getFixture());
		assertThat("Area must be INvalid. "+validationResults, validationResults, is(notNullValue()));
		
	}
	/**
	 * Tests the '{@link com.verticon.location.Area#containsPoint(java.lang.String) <em>Contains Point</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.location.Area#containsPoint(java.lang.String)
	 * @generated NOT
	 */
	public void testContainsPoint__String() {
		getFixture().setBoundary(GOOD_NW_POLYGON_COORDS);
		getFixture().setName("test");
		
		assertThat("SouthFairgrounds must not be in the NW area",getFixture().containsPoint(SOUTH_FAIRGROUNDS_POINT),is(false));
		
		getFixture().setBoundary(GOOD_S_POLYGON_COORDS);
		assertThat("SouthFairgrounds must not be in the South area",getFixture().containsPoint(SOUTH_FAIRGROUNDS_POINT),is(false));
		
		assertThat("Baseball field must be in the South area",getFixture().containsPoint(BASEBALL_FIELD_POINT),is(true));
		
		
		try {
			getFixture().containsPoint("junk");
			fail("Should throw exception");
		} catch (IllegalArgumentException e) {
			//expected
		}
		
		try {
			getFixture().containsPoint("junk, economics");
			fail("Should throw exception");
		} catch (IllegalArgumentException e) {
			//expected
		}
		
		try {
			getFixture().containsPoint("3333");
			fail("Should throw exception");
		} catch (IllegalArgumentException e) {
			//expected
		}
		
		try {
			getFixture().containsPoint("3333,fish");
			fail("Should throw exception");
		} catch (IllegalArgumentException e) {
			//expected
		}
		
	}
	
	static String validateObject(EObject eObject) {
		String result = null;
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					result =
							childDiagnostic.getMessage();
				}
			}
		}
		return result;
	}

} //AreaTest
