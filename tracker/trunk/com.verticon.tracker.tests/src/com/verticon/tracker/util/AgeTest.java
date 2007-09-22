/**
 * 
 */
package com.verticon.tracker.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.TrackerFactory;

import junit.framework.TestCase;

/**
 * @author jconlon
 *
 */
public class AgeTest extends TestCase {
	
	private static final Date ANIMAL_BIRTHDAY = 
		(new GregorianCalendar(2000, Calendar.JANUARY, 1,1,5)).getTime();
	
	private Age instance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		instance = new Age(ANIMAL_BIRTHDAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		instance=null;
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#equals(java.lang.Object)}.
	 */
	public void testEqualsObject() {
		assertEquals(new Age(ANIMAL_BIRTHDAY), instance);
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#calculate()}.
	 */
//	public void testCalculate() {
//		fail("Not yet implemented");
//	}
	
	

	private String getMessage(Date birthday, Age age){
		return "For birthday "+birthday+" age: "+age.toString()+" is incorrect!";
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getDays()}.
	 */
	public void testGetDays() {
		Calendar someBirthday = Calendar.getInstance();
		someBirthday.add(Calendar.DAY_OF_MONTH, -5);
		instance=new Age(someBirthday.getTime());
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				5, 
				instance.getDays()
		);
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				0, 
				instance.getMonths()
		);
		
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				0, 
				instance.getYears()
		);
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getMonths()}.
	 */
	public void testGetMonths() {
		Calendar someBirthday = Calendar.getInstance();
		someBirthday.add(Calendar.MONTH, -9);
		instance=new Age(someBirthday.getTime());
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				1, 
				instance.getDays()
		);
		
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				9, 
				instance.getMonths()
		);
		
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				0, 
				instance.getYears()
		);
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getYears()}.
	 */
	public void testGetYears() {
		Calendar someBirthday = Calendar.getInstance();
		someBirthday.add(Calendar.YEAR, -10);
		instance=new Age(someBirthday.getTime());
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				31, 
				instance.getDays()
		);
		
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				11, 
				instance.getMonths()
		);
		
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				9, 
				instance.getYears()
		);
	}
	
	
	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getStartDate()}.
	 */
	public void testGetStartDate() {
		assertEquals(ANIMAL_BIRTHDAY, instance.getStartDate());
	}

	
	/**
	 * Test method for {@link com.verticon.tracker.util.Age#toString()}.
	 */
	public void testToString() {
			Calendar someBirthday = Calendar.getInstance();
			someBirthday.add(Calendar.DAY_OF_MONTH, -5);
			instance=new Age(someBirthday.getTime());
			assertEquals(getMessage(
					someBirthday.getTime(),instance), 
					"+D05", 
					instance.toString()
			);
			
			someBirthday.add(Calendar.MONTH, -7);
			instance=new Age(someBirthday.getTime());
			assertEquals("+M07D05", instance.toString());
			
			someBirthday.add(Calendar.YEAR, -3);
			instance=new Age(someBirthday.getTime());
			assertEquals("+Y03M07D05",instance.toString());
		
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#toRoundedString()}.
	 */
	public void testToRoundedString() {

		Calendar someBirthday = Calendar.getInstance();
		someBirthday.add(Calendar.DAY_OF_MONTH, -5);
		instance=new Age(someBirthday.getTime());
		assertEquals("D05", instance.toRoundedString());
		
		someBirthday.add(Calendar.MONTH, -7);
		instance=new Age(someBirthday.getTime());
		assertEquals("M07", instance.toRoundedString());
		
		someBirthday.add(Calendar.YEAR, -3);
		instance=new Age(someBirthday.getTime());
		assertEquals("Y03", instance.toRoundedString());
	}

	
	

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getStatus()}.
	 */
	public void testGetStatus() {
		Calendar someBirthday = Calendar.getInstance();
		someBirthday.add(Calendar.DAY_OF_MONTH, -5);
		instance=new Age(someBirthday.getTime());
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				Age.OLD, 
				instance.getStatus()
		);
		
		someBirthday.add(Calendar.MONTH, +7);
		instance=new Age(someBirthday.getTime());
		assertEquals(getMessage(
				someBirthday.getTime(),instance), 
				Age.NOT_BORN_YET, 
				instance.getStatus()
		);
	}

	/**
	 * Test method for {@link com.verticon.tracker.util.Age#getTimeStamp()}.
	 */
	public void testGetTimeStamp() {
		assertEquals(ANIMAL_BIRTHDAY.getTime(), instance.getTimeStamp());
	}

	

}
