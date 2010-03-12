package com.verticon.tracker.util;

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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public final void testParser(){
		String log = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
		
		Matcher matcher = MeasurementEntity.PATTERN.matcher(log);
		assertTrue(matcher.matches());
		
		assertEquals("measurement", matcher.group(1));
		assertEquals("2010-03-12 12:07:42", matcher.group(2));//dateTime
		assertEquals("123456789012345", matcher.group(3));//tag
		assertEquals("animal.weight.measurement", matcher.group(4));//scope
		assertEquals("133.0000", matcher.group(5));//value
		assertEquals("0.0100", matcher.group(7));//error
		assertEquals("kg", matcher.group(8));//unit

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
		String pass = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
		String pass2 = "type='measurement',dateTime='2010-03-12 12:07:42',id='123456789012345',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
		
		String fail_1 = "2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='null',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'";
			
		try {
			MeasurementEntity m = MeasurementEntity.newInstance(pass);
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
			assertNotNull(MeasurementEntity.newInstance(pass2));
		} catch (ParseException e) {
			fail(e.toString());
		}
		
		try {
			assertNotNull(MeasurementEntity.newInstance(fail_1));
			fail("Should have failed");
		} catch (ParseException e) {
		}
		
	}

}
