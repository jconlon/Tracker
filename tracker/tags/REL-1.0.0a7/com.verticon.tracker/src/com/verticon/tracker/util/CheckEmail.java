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
		p = Pattern.compile("^[a-zA-Z_0-9.]+@[a-zA-Z_.]+?\\.+[a-zA-Z]{2,3}$");

		// Match the given string with the pattern
		m = p.matcher(email);

		// check whether match is found
		return m.matches();

	}

}
