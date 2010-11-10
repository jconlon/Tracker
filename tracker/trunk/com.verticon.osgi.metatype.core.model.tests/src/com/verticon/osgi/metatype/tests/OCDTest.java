/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.osgi.metatype.tests;

import static org.osgi.service.metatype.ObjectClassDefinition.ALL;
import static org.osgi.service.metatype.ObjectClassDefinition.OPTIONAL;
import static org.osgi.service.metatype.ObjectClassDefinition.REQUIRED;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.osgi.service.metatype.AttributeDefinition;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.Icon;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OCD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.osgi.metatype.OCD#getIcon(int) <em>Get Icon</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.OCD#getAttributeDefinitions(int) <em>Get Attribute Definitions</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class OCDTest extends TestCase {

	/**
	 * The fixture for this OCD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCD fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OCDTest.class);
	}

	/**
	 * Constructs a new OCD test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCDTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this OCD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(OCD fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this OCD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCD getFixture() {
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
		setFixture(MetatypeFactory.eINSTANCE.createOCD());
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
	 * Tests the '{@link com.verticon.osgi.metatype.OCD#getIcon(int) <em>Get Icon</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws IOException 
	 * @see com.verticon.osgi.metatype.OCD#getIcon(int)
	 * @generated NOT
	 */
	public void testGetIcon__int() throws IOException{
		try {
			assertNull(fixture.getIcon(5));
		} catch (IOException e) {
			fail();
		}
		Icon icon = MetatypeFactory.eINSTANCE.createIcon();
		icon.setResource("http://www.verticon.com/a_LLSunset.jpg");
		
		fixture.setIcon(icon);
		
		InputStream is = null;
		try {
			is = fixture.getIcon(5);
			assertNotNull(is);
		
		} catch (IOException e) {
			
		}finally{
			if(is!=null){
				is.close();
			}
		}
		
	}

	/**
	 * Tests the '{@link com.verticon.osgi.metatype.OCD#getAttributeDefinitions(int) <em>Get Attribute Definitions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.OCD#getAttributeDefinitions(int)
	 * @generated NOT
	 */
	public void testGetAttributeDefinitions__int() {
		assertNull(fixture.getAttributeDefinitions(ALL));
		
		AD ad =MetatypeFactory.eINSTANCE.createAD();
		ad.setID("one");
		ad.setRequired(false);
		fixture.getAD().add(ad);
		assertNotNull(fixture.getAttributeDefinitions(ALL));
		assertNull(fixture.getAttributeDefinitions(REQUIRED));
		assertEquals(1,
				fixture.getAttributeDefinitions(ALL).length); 
		assertEquals(1,
				fixture.getAttributeDefinitions(OPTIONAL).length);
		
		assertTrue(fixture.getAttributeDefinitions(OPTIONAL)[0] instanceof AttributeDefinition);
		AttributeDefinition adfound = fixture.getAttributeDefinitions(OPTIONAL)[0];
		assertEquals("one", adfound.getID());
		
		
		ad =MetatypeFactory.eINSTANCE.createAD();
		ad.setRequired(true);
		ad.setID("two");
		fixture.getAD().add(ad);
		assertEquals(2,
				fixture.getAttributeDefinitions(ALL).length);
		assertEquals(1,
				fixture.getAttributeDefinitions(REQUIRED).length);
	    adfound = fixture.getAttributeDefinitions(REQUIRED)[0];
		assertEquals("two", adfound.getID());
		assertEquals(1,
				fixture.getAttributeDefinitions(OPTIONAL).length);
		adfound = fixture.getAttributeDefinitions(OPTIONAL)[0];
		assertEquals("one", adfound.getID());
		
		
	}

} //OCDTest
