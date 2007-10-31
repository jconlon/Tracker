/**
 * 
 */
package com.verticon.tracker.util;

import java.util.Calendar;

import junit.framework.TestCase;
import net.sourceforge.calendardate.CalendarDate;

/**
 * @author jconlon
 * 
 */
public class CalendarDateDurationTest extends TestCase {

	CalendarDateDuration instance;
	CalendarDate date1;
	CalendarDate date2;
	CalendarDate date3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		date1 = new CalendarDate(2000, 1, 1);
		date2 = new CalendarDate(2000, 1, 2);
		instance = new CalendarDateDuration(date1, date2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		date1 = null;
		date2 = null;
		date3 = null;
		instance = null;
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#CalendarDateDuration(net.sourceforge.calendardate.CalendarDate, net.sourceforge.calendardate.CalendarDate)}.
	 */
	public void testCalendarDateDuration() {

		assertNotNull(instance);
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getTotalDays()}.
	 */
	public void testGetTotalDays() {
		assertEquals(1, instance.getTotalDays());

		// Add more days
		date3 = date2.addDays(300);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.daysUntil(date3), 301, instance
				.getTotalDays());

		// Add a month
		date3 = date2.addMonths(1);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.daysUntil(date3), date1.daysUntil(date3),
				instance.getTotalDays());

		// Add a year
		date3 = date2.addMonths(13);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.daysUntil(date3), date1.daysUntil(date3),
				instance.getTotalDays());
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getTotalMonths()}.
	 */
	public void testGetTotalMonths() {
		assertEquals(0, instance.getTotalMonths());

		// Add more days
		date3 = date2.addDays(30);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 1, instance
				.getTotalMonths());

		// Add a month
		date3 = date2.addMonths(1);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), date1
				.monthsUntil(date3), instance.getTotalMonths());

		// Add a year
		date3 = date2.addMonths(13);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), date1
				.monthsUntil(date3), instance.getTotalMonths());
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getType()}.
	 */
	public void testGetType() {
		assertEquals(CalendarDateDuration.Type.FUTURE, instance.getType());

		instance = new CalendarDateDuration(date2, date1);
		assertEquals(CalendarDateDuration.Type.PAST, instance.getType());

	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getTotalYears()}.
	 */
	public void testGetTotalYears() {
		assertEquals(0, instance.getTotalYears());

		// Add more days
		CalendarDate date3 = date2.addDays(370);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 1, instance
				.getTotalYears());

		// Add a two years worth of months
		date3 = date2.addMonths(25);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 2, instance
				.getTotalYears());

		// Add a 20 years
		date3 = new CalendarDate(2020, 1, 2);
		;
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 20, instance
				.getTotalYears());
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getMonthsPart()}.
	 */
	public void testGetMonthsPart() {
		assertEquals(0, instance.getMonthsPart());

		// Add more days
		CalendarDate date3 = date2.addDays(37);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 1, instance
				.getMonthsPart());

		// Add a two years and two months worth of months
		date3 = date2.addMonths(26);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 2, instance
				.getMonthsPart());

		// Add a 20 years and 10 months
		date3 = date2.addMonths(250);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 10, instance
				.getMonthsPart());
	}

	/**
	 * Test method for
	 * {@link com.verticon.tracker.util.CalendarDateDuration#getDaysPart()}.
	 */
	public void testGetDaysPart() {
		assertEquals(1, instance.getDaysPart());

		// Add more days
		CalendarDate date3 = date2.addDays(10);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 11, instance
				.getDaysPart());

		// Add a two years and two months and 5 days
		date3 = date2.addMonths(26).addDays(5);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 6, instance
				.getDaysPart());

		// Add a 20 years, 10 months, and 10 days
		date3 = date2.addMonths(250).addDays(20);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), 21, instance
				.getDaysPart());
	}

	public void testToString() {
		assertEquals("+D01", instance.toString());

		// Add a two years and two months and 5 days
		date3 = date2.addMonths(26).addDays(5);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), "+Y02M02D06",
				instance.toString());

		// Add a 20 years, 10 months, and 20 days
		date3 = date2.addMonths(250).addDays(20);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Added " + date1.monthsUntil(date3), "+Y20M10D21",
				instance.toString());

		// Reverse dates from previous
		date3 = date2.addMonths(250).addDays(20);
		instance = new CalendarDateDuration(date3, date1);
		assertEquals("Added " + date1.monthsUntil(date3), "-Y20M10D21",
				instance.toString());

	}
	
	/**
	 * Test method for {@link com.verticon.tracker.util.Age#toRoundedString()}.
	 */
	public void testToRoundedString() {
		assertEquals("D01", instance.toRoundedString());
		
		// Add a two months and 5 days
		date3 = date2.addMonths(2).addDays(5);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("M02", instance.toRoundedString());
		
		// Add a two years and two months and 5 days
		date3 = date2.addMonths(26).addDays(5);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Y02", instance.toRoundedString());
		
		// Add a 20 years, 10 months, and 20 days
		date3 = date2.addMonths(250).addDays(20);
		instance = new CalendarDateDuration(date1, date3);
		assertEquals("Y20", instance.toRoundedString());
		
		// Reverse dates from previous
		date3 = date2.addMonths(250).addDays(20);
		instance = new CalendarDateDuration(date3, date1);
		assertEquals("Y20", instance.toRoundedString());
	}

}
