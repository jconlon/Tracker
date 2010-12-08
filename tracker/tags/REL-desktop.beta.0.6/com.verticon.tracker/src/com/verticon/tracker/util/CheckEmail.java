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
/**
 * 
 */
package com.verticon.tracker.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jconlon
 * 
 */
public class CheckEmail {

	private static final String EXPRESSION = "^[a-zA-Z_0-9.]+@[a-zA-Z_0-9.]+?\\.+[a-zA-Z]{2,3}$";
	@SuppressWarnings("unused")
	//An alternative expression for use with ignore case
	private static final String ALT_EXPRESSION = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$";
	/**
	 * 
	 */
	private CheckEmail() {
		
	}

	
	public static final boolean validate(String email) {

		// Checks for email addresses starting with
		// inappropriate symbols like dots or @ signs.
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return false;
		}
		
		p = Pattern.compile("^www\\.");
		m = p.matcher(email);
		if (m.find()) {
			return false;
		}
		
		
		// Set the email pattern string
		p = Pattern.compile(EXPRESSION);
		             

		// Match the given string with the pattern
		m = p.matcher(email);

		// check whether match is found
		return m.matches();

	}

}
