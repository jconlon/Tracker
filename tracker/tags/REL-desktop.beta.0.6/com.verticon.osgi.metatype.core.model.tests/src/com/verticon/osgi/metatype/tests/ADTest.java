/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.osgi.metatype.tests;

import static org.osgi.service.metatype.AttributeDefinition.BOOLEAN;
import static org.osgi.service.metatype.AttributeDefinition.BYTE;
import static org.osgi.service.metatype.AttributeDefinition.CHARACTER;
import static org.osgi.service.metatype.AttributeDefinition.DOUBLE;
import static org.osgi.service.metatype.AttributeDefinition.FLOAT;
import static org.osgi.service.metatype.AttributeDefinition.INTEGER;
import static org.osgi.service.metatype.AttributeDefinition.LONG;
import static org.osgi.service.metatype.AttributeDefinition.SHORT;
import static org.osgi.service.metatype.AttributeDefinition.STRING;

import java.util.Arrays;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.Option;
import com.verticon.osgi.metatype.Scalar;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>AD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.verticon.osgi.metatype.AD#getType() <em>Get Type</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.AD#validate(java.lang.String) <em>Validate</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.AD#getOptionValues() <em>Get Option Values</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.AD#getOptionLabels() <em>Get Option Labels</em>}</li>
 *   <li>{@link com.verticon.osgi.metatype.AD#getDefaultValue() <em>Get Default Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ADTest extends TestCase {

	/**
	 * The fixture for this AD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AD fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ADTest.class);
	}

	/**
	 * Constructs a new AD test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ADTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this AD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AD fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this AD test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AD getFixture() {
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
		setFixture(MetatypeFactory.eINSTANCE.createAD());
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
	 * Tests the '{@link com.verticon.osgi.metatype.AD#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Tests the '{@link org.osgi.service.metatype.AttributeDefinition#getType() <em>Get Type</em>}' operation.
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.AD#getType()
	 * @generated NOT
	 */
	public void testGetType() {
		assertEquals(Scalar.STRING, fixture.getDataType() );
		assertEquals(STRING, fixture.getType() );
		
		fixture.setDataType(Scalar.BOOLEAN);
		assertEquals(BOOLEAN, fixture.getType());
		
		fixture.setDataType(Scalar.BYTE);
		assertEquals(BYTE, fixture.getType() );
		
		fixture.setDataType(Scalar.CHAR);
		assertEquals(CHARACTER, fixture.getType());
		
		fixture.setDataType(Scalar.DOUBLE);
		
		assertEquals(DOUBLE, fixture.getType());
		
		fixture.setDataType(Scalar.FLOAT);
		assertEquals(FLOAT, fixture.getType());
		
		fixture.setDataType(Scalar.INTEGER);
		assertEquals(INTEGER, fixture.getType());
		
		fixture.setDataType(Scalar.INTEGER);
		assertEquals(INTEGER, fixture.getType());
		
		fixture.setDataType(Scalar.LONG);
		assertEquals(LONG,fixture.getType() );
		
		fixture.setDataType(Scalar.SHORT);
		assertEquals(SHORT,fixture.getType());
		
		fixture.setDataType(Scalar.STRING);
		assertEquals(STRING,fixture.getType());
	}

	/**
	 * Tests the '{@link com.verticon.osgi.metatype.AD#validate(java.lang.String) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Tests the '{@link org.osgi.service.metatype.AttributeDefinition#validate(String) <em>Validate</em>}' operation.
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.AD#validate(java.lang.String)
	 * @generated NOT
	 */
	public void testValidate__String() {
		//Boolean
		fixture.setDataType(Scalar.BOOLEAN);
		assertEquals(" is not a Boolean", fixture.validate(""));
		assertEquals("something is not a Boolean", fixture.validate("something"));
		assertEquals("",fixture.validate("true"));
		assertEquals("",fixture.validate("false"));
		
		fixture.setDataType(Scalar.BYTE);
		assertTrue( fixture.validate("").startsWith("Byte invalid. For input string:"));
		assertEquals("Byte invalid. For input string: \"something\"", fixture.validate("something"));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2"));
		assertEquals("",fixture.validate("21"));
		assertEquals("",fixture.validate("11"));
		
		fixture.setDataType(Scalar.LONG);
		assertTrue( fixture.validate("").startsWith("Long invalid."));
		assertTrue( fixture.validate("something").startsWith("Long invalid."));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("123456789012345"));
		assertEquals("",fixture.validate("-33123456789012345"));
		assertEquals("",fixture.validate("1000222"));
		fixture.setMin("1");
		fixture.setMax("100");
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2"));
		assertEquals("Value is less than permitted minimum value.",fixture.validate("-33"));
		assertEquals("Value is greater than permitted maximum value.",fixture.validate("1000"));
		//Reset
		fixture.setMin(null);
		fixture.setMax(null);
		
		fixture.setDataType(Scalar.DOUBLE);
		assertTrue( fixture.validate("").startsWith("Double invalid."));
		assertTrue( fixture.validate("something").startsWith("Double invalid."));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2.002"));
		assertEquals("",fixture.validate("-33.8"));
		assertEquals("",fixture.validate("1000.222"));
		//test min and max
		fixture.setMin("1");
		fixture.setMax("100");
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2.002"));
		assertEquals("Value is less than permitted minimum value.",fixture.validate("-33.8"));
		assertEquals("Value is greater than permitted maximum value.",fixture.validate("1000.222"));
		//Reset
		fixture.setMin(null);
		fixture.setMax(null);
		
		
		fixture.setDataType(Scalar.FLOAT);
		assertTrue( fixture.validate("").startsWith("Float invalid."));
		assertTrue( fixture.validate("something").startsWith("Float invalid."));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2.002"));
		assertEquals("",fixture.validate("-33.8"));
		assertEquals("",fixture.validate("1000.222"));
		//test min and max
		fixture.setMin("1");
		fixture.setMax("100");
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2.002"));
		assertEquals("Value is less than permitted minimum value.",fixture.validate("-33.8"));
		assertEquals("Value is greater than permitted maximum value.",fixture.validate("1000.222"));
		//Reset
		fixture.setMin(null);
		fixture.setMax(null);
		
		fixture.setDataType(Scalar.INTEGER);
		assertTrue( fixture.validate("").startsWith("Integer invalid."));
		assertTrue( fixture.validate("something").startsWith("Integer invalid."));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2002"));
		assertEquals("",fixture.validate("338"));
		assertEquals("",fixture.validate("1000222"));
		fixture.setMin("1");
		fixture.setMax("100");
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2"));
		assertEquals("Value is less than permitted minimum value.",fixture.validate("-33"));
		assertEquals("Value is greater than permitted maximum value.",fixture.validate("1000"));
		//Reset
		fixture.setMin(null);
		fixture.setMax(null);
		
		fixture.setDataType(Scalar.CHAR);
		assertTrue( fixture.validate("").startsWith("Character invalid."));
		assertTrue( fixture.validate("something").startsWith("Character invalid."));
		assertEquals("",fixture.validate("1"));
		assertEquals("",fixture.validate("2"));
		assertEquals("",fixture.validate("c"));
		assertEquals("",fixture.validate("1"));
		
		
		fixture.setDataType(Scalar.STRING);
		assertEquals("",fixture.validate("1lslslslsl"));
		assertEquals("",fixture.validate("2ddddd dddd"));
		assertEquals("",fixture.validate("c  ddd   	"));
		assertEquals("",fixture.validate("1ssss"));
		
	}

	
	/**
	 * Tests the '{@link com.verticon.osgi.metatype.AD#getOptionValues() <em>Get Option Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Tests the '{@link org.osgi.service.metatype.AttributeDefinition#getOptionValues() <em>Get Option Values</em>}' operation.
	 * 
	 * Return a list of option values that this attribute can take.
	 * 
	 * <p>
	 * If the function returns <code>null</code>, there are no option values
	 * available.
	 * 
	 * <p>
	 * Each value must be acceptable to validate() (return "") and must be a
	 * <code>String</code> object that can be converted to the data type defined
	 * by getType() for this attribute.
	 * 
	 * <p>
	 * This list must be in the same sequence as <code>getOptionLabels()</code>.
	 * I.e. for each index i in <code>getOptionValues</code>, i in
	 * <code>getOptionLabels()</code> should be the label.
	 * 
	 * <p>
	 * For example, if an attribute can have the value male, female, unknown,
	 * this list can return
	 * <code>new String[] { "male", "female", "unknown" }</code>.
	 * 
	 * 
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.AD#getOptionValues()
	 * @generated NOT
	 */
	public void testGetOptionValues() {
		assertNull(fixture.getOptionValues());//No options values available
//		assertEquals(fixture.getType(), Scalar.STRING_VALUE);
		
		Option option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL1");
		option.setValue("Value1");
		fixture.getOption().add(option);
		assertEquals(1,fixture.getOptionValues().length);
		
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL2");
		option.setValue("Value2");
		fixture.getOption().add(option);
		assertEquals(2,fixture.getOptionValues().length);
		assertEquals(Arrays.toString(new String[]{"Value1", "Value2"}), Arrays.toString(fixture.getOptionValues()));
	
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL3");
		option.setValue("3");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.INTEGER);
		assertNotNull(fixture.getOptionValues());
		assertEquals(1,fixture.getOptionValues().length);
		assertEquals(Arrays.toString(new String[]{"3"}), Arrays.toString(fixture.getOptionValues()));
	
		
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL4");
		option.setValue("true");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.BOOLEAN);
		assertNotNull(fixture.getOptionValues());
		assertEquals(1,fixture.getOptionValues().length);
		assertEquals(Arrays.toString(new String[]{"true"}), Arrays.toString(fixture.getOptionValues()));
	
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL5");
		option.setValue("Value5");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.STRING);
		assertEquals(5,fixture.getOptionValues().length);
		assertEquals(Arrays.toString(new String[]{"Value1", "Value2","3","true","Value5"}), Arrays.toString(fixture.getOptionValues()));
	
	}

	/**
	 * Tests the '{@link com.verticon.osgi.metatype.AD#getOptionLabels() <em>Get Option Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Tests the '{@link org.osgi.service.metatype.AttributeDefinition#getOptionLabels() <em>Get Option Labels</em>}' operation.
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.AD#getOptionLabels()
	 * @generated NOT
	 */
	public void testGetOptionLabels() {
		assertNull(fixture.getOptionLabels());//No options values available
//		assertEquals(fixture.getType(), Scalar.STRING_VALUE);
		
		Option option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL1");
		option.setValue("Value1");
		fixture.getOption().add(option);
		assertEquals(1,fixture.getOptionLabels().length);
		
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL2");
		option.setValue("Value2");
		fixture.getOption().add(option);
		assertEquals(2,fixture.getOptionLabels().length);
		assertEquals(Arrays.toString(new String[]{"LABEL1", "LABEL2"}), Arrays.toString(fixture.getOptionLabels()));
	
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL3");
		option.setValue("3");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.INTEGER);
		assertNotNull(fixture.getOptionLabels());
		assertEquals(1,fixture.getOptionLabels().length);
		assertEquals(Arrays.toString(new String[]{"LABEL3"}), Arrays.toString(fixture.getOptionLabels()));
	
		
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL4");
		option.setValue("true");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.BOOLEAN);
		assertNotNull(fixture.getOptionLabels());
		assertEquals(1,fixture.getOptionLabels().length);
		assertEquals(Arrays.toString(new String[]{"LABEL4"}), Arrays.toString(fixture.getOptionLabels()));
	
		option = MetatypeFactory.eINSTANCE.createOption();
		option.setLabel("LABEL5");
		option.setValue("Value5");
		fixture.getOption().add(option);
		fixture.setDataType(Scalar.STRING);
		assertEquals(5,fixture.getOptionLabels().length);
		assertEquals(Arrays.toString(new String[]{"LABEL1", "LABEL2","LABEL3","LABEL4","LABEL5"}), Arrays.toString(fixture.getOptionLabels()));
	
	}

	/**
	 * Tests the '{@link com.verticon.osgi.metatype.AD#getDefaultValue() <em>Get Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Tests the '{@link org.osgi.service.metatype.AttributeDefinition#getDefaultValue() <em>Get Default Value</em>}' operation.
	 * <!-- end-user-doc -->
	 * @see com.verticon.osgi.metatype.AD#getDefaultValue()
	 * @generated NOT
	 */
	public void testGetDefaultValue() {
		assertNull(fixture.getDefault());//No defaults set

		//Cardinality is set by default to 0
		fixture.setDefault("Value1");
		assertNotNull(fixture.getDefaultValue());
		assertEquals(1,fixture.getDefaultValue().length);
		
		//Cardinality is still set to 0
		fixture.setDefault("Value1,Value2");
		assertEquals(1,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"Value1,Value2"}), 
				Arrays.toString(fixture.getDefaultValue()));
	
		//Cardinality is 2
		fixture.setCardinality(2);
		assertEquals(2,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"Value1", "Value2"}), 
				Arrays.toString(fixture.getDefaultValue()));
		
		//Cardinality is -2
		fixture.setCardinality(-2);
		assertEquals(2,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"Value1", "Value2"}), 
				Arrays.toString(fixture.getDefaultValue()));
		
		//Cardinality is -5
		fixture.setCardinality(-5);
		assertEquals(2,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"Value1", "Value2"}), 
				Arrays.toString(fixture.getDefaultValue()));
	
		
		
		fixture.setDefault("Value1,Value2,3");
		fixture.setDataType(Scalar.INTEGER);
		assertEquals(1,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"3"}), 
				Arrays.toString(fixture.getDefaultValue()));
	
		
		fixture.setDefault("Value1,Value2,3,true");
		fixture.setDataType(Scalar.BOOLEAN);
		assertEquals(1,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(new String[]{"true"}), 
				Arrays.toString(fixture.getDefaultValue()));
		assertEquals(Arrays.toString(new String[]{"true"}), 
				Arrays.toString(fixture.getDefaultValue()));
	
		fixture.setDefault("Value1,Value2,3,true,Value5");
		fixture.setDataType(Scalar.STRING);
		assertEquals(5,fixture.getDefaultValue().length);
		assertEquals(Arrays.toString(
				new String[]{"Value1", "Value2","3","true","Value5"}), 
				Arrays.toString(fixture.getDefaultValue()));
	
	}

} //ADTest
