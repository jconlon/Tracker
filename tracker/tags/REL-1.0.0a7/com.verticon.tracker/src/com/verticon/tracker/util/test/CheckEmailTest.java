package com.verticon.tracker.util.test;

import junit.framework.TestCase;

import com.verticon.tracker.util.CheckEmail;

public class CheckEmailTest extends TestCase {

	public void testValidate() {
		try {
			assertFalse(CheckEmail.validate("Not yet implemented"));
		} catch (RuntimeException e) {
			fail(e.toString());
		}
		
		assertTrue(CheckEmail.validate("joe@aol.com"));
		
		assertTrue(CheckEmail.validate("ssmith@aspalliance.com"));
		
		assertTrue(CheckEmail.validate("a@b.cc"));
		
		assertTrue(CheckEmail.validate("jconlon@verticon.com"));
		
		assertTrue(CheckEmail.validate("timothy.rehbein@ces.uwex.edu"));
		
	}
	
	public void testDoesNotValidate() {
		try {
			assertFalse(CheckEmail.validate("Not yet implemented"));
		} catch (RuntimeException e) {
			fail(e.toString());
		}
		
		assertFalse(CheckEmail.validate("joe@123aspx.com"));
		
		assertFalse(CheckEmail.validate("joe@web.info"));
		
//		assertFalse(CheckEmail.validate("joe@company.co.uk"));
		
		assertFalse(CheckEmail.validate("@co.uk"));
		
	}

}
