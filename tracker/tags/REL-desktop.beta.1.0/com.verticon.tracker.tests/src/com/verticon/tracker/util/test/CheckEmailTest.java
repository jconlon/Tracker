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
		
		assertTrue(CheckEmail.validate("joe@123aspx.com"));
	}
	
	public void testDoesNotValidate() {
		assertFalse(CheckEmail.validate("Not yet implemented"));
		assertFalse(CheckEmail.validate("@co.uk"));
		assertFalse(CheckEmail.validate("joe@web.info"));
		
	}

}
