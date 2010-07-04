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

import com.verticon.tracker.util.CheckISO7064Mod37_36;

public class CheckISO7064Mod37_36Test extends TestCase {
	
	
	public void testGetData() {
		
		assertEquals("104G7M", CheckISO7064Mod37_36.getData("104G7M3"));
		
	}
	
	
	public void testComputeCheckAlphNumericShort() {
		
		assertEquals('3', CheckISO7064Mod37_36.computeCheckChar("104G7M"));
	}
	
	public void testComputeCheckAlphNumericLong() {
		
		assertEquals('M', CheckISO7064Mod37_36.computeCheckChar("A12425GABC1234002"));	
	}
	
	public void testVerifyAlphNumericShort() {
		
		assertTrue(CheckISO7064Mod37_36.verify("104G7M3"));
	}
	
    public void testVerifyAlphNumericShort2() {
		
		assertTrue(CheckISO7064Mod37_36.verify("H89234X"));
		assertTrue(CheckISO7064Mod37_36.verify("HA92348"));
//		System.out.println(CheckISO7064Mod37_36.computeCheckChar("HA9234"));
	}
    
    
	public void testVerifyAlphNumericLong() {
		
		assertTrue(CheckISO7064Mod37_36.verify("A12425GABC1234002M"));	
	}
	
	
	public void testBadCharacter() {
		try {
			CheckISO7064Mod37_36.computeCheckChar("A12425GABC12c4002");
		} catch (NumberFormatException e) {
			return;
		}
		fail("Did not throw a NumberFormatException");
		
	}
	
//	public void testMapGetValue(){
//		CheckISO7064Mod37_36 cd = new CheckISO7064Mod37_36();
//		assertEquals(0, cd.getValue('0'));
//		assertEquals(9, cd.getValue('9'));
//		assertEquals(10, cd.getValue('A'));
//		assertEquals(22, cd.getValue('M'));
//		assertEquals(35, cd.getValue('Z'));
//		
//	}
//	public void testMapGetChar(){
//		CheckISO7064Mod37_36 cd = new CheckISO7064Mod37_36();
//		assertEquals('0', cd.getChar(0));
//		assertEquals('9', cd.getChar(9));
//		assertEquals('A', cd.getChar(10));
//		assertEquals('M', cd.getChar(22));
//		assertEquals('Z', cd.getChar(35));
//		
//	}
}
