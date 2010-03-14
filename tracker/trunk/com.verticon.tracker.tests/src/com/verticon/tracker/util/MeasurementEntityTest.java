package com.verticon.tracker.util;

import static com.verticon.tracker.util.MeasurementEntity.DATE_TIME;
import static com.verticon.tracker.util.MeasurementEntity.ERROR;
import static com.verticon.tracker.util.MeasurementEntity.ID;
import static com.verticon.tracker.util.MeasurementEntity.SCOPE;
import static com.verticon.tracker.util.MeasurementEntity.TYPE;
import static com.verticon.tracker.util.MeasurementEntity.UNIT;
import static com.verticon.tracker.util.MeasurementEntity.VALUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

public class MeasurementEntityTest {
	static final String GOOD_LOG1 = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
	static final String GOOD_LOG2 = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
	static final String GOOD_LOG3 = "type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
	static final String GOOD_LOG4 = "type='measurement',dateTime='2010-02-03 08:16:54',id='900014000555028',scope='mettler.weight.measurement',value='0.52344',error='0.0100',unit='kg'";
	static final String GOOD_LOG5 = "type='measurement',dateTime='2010-02-03 08:21:31',id='900014000555017',scope='mettler.weight.measurement',value='2.9E-4',error='0.0100',unit='kg'";
	static final String GOOD_LOG6 = "type='measurement',dateTime='2010-02-03 08:27:59',id='900014000555017',scope='mettler.weight.measurement',value='0.5285299999999999',error='0.0100',unit='kg'";
	static final String BAD_ID = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='null',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
		
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public final void testDouble(){
		double d = Double.parseDouble("2.9E-4");
		assertEquals(new Double(2.9E-4), d, 0);
	}
	@Test 
	public final void testParser(){
		
		Matcher matcher = MeasurementEntity.PATTERN.matcher(GOOD_LOG1);
		assertTrue(matcher.matches());
		
		assertEquals("measurement", matcher.group(TYPE));
		assertEquals("2010-03-12 12:07:42", matcher.group(DATE_TIME));//dateTime
		assertEquals("123456789012345", matcher.group(ID));//tag
		assertEquals("animal.weight.measurement", matcher.group(SCOPE));//scope
		assertEquals("133.0000", matcher.group(VALUE));//value
		assertEquals("0.0100", matcher.group(ERROR));//error
		assertEquals("kg", matcher.group(UNIT));//unit

		matcher.reset(GOOD_LOG2);
		assertTrue(matcher.matches());
		
		matcher.reset(GOOD_LOG3);
		assertTrue(matcher.matches());
		
		matcher.reset(GOOD_LOG4);
		assertTrue(matcher.matches());
		
		matcher.reset(GOOD_LOG5);
		assertTrue(matcher.matches());
		
		matcher.reset(GOOD_LOG6);
		assertTrue(matcher.matches());
		
		matcher.reset(BAD_ID);
		assertTrue(matcher.matches());
	}
	
	@Test
	public final void testDateParser() throws ParseException{
		String dateAsString = "2010-03-12 13:07:42";
		// Parse a date and time; see also // Parsing the Time Using a Custom Format 
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = (Date)formatter.parse(dateAsString); 
		Measurement m = new Measurement(22.9,22,Unit.kg,date.getTime());
		assertEquals(dateAsString, String.format(
				"%1$tF %1$tT",m.getTime()));
		
	}

	@Test
	public final void testNewInstance() {
		
		try {
			MeasurementEntity m = MeasurementEntity.newInstance(GOOD_LOG2);
			assertNotNull(m);
			assertEquals(133.0000, m.getValue(),0);
			assertEquals(0.0100, m.getError(),0);
			assertEquals(Unit.kg, m.getUnit());
			assertEquals("2010-03-12 12:07:42", String.format(
					"%1$tF %1$tT",m.getTime()));
			assertEquals("123456789012345", m.getId());
			assertEquals("animal.weight.measurement", m.getScope());
			
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(GOOD_LOG1));
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(GOOD_LOG3));
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(GOOD_LOG4));
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(GOOD_LOG5));
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(GOOD_LOG6));
		} catch (ParseException e) {
			fail(e.toString());
		}
		try {
			assertNotNull(MeasurementEntity.newInstance(BAD_ID));
			fail("Should have failed");
		} catch (ParseException e) {
			assertEquals(BAD_ID+" failed to parse id.", e.getMessage());
		}
		
	}

}
