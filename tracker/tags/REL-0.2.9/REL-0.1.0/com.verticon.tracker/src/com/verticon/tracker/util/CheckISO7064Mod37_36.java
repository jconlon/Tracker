/**
 * 
 */
package com.verticon.tracker.util;

/**
 * @author jconlon
 *
 */
public class CheckISO7064Mod37_36  {

	private final static String MAP = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private CheckISO7064Mod37_36 (){}
	
	public final static int getValue(char ch){
		return MAP.indexOf(ch);
	}
	
	private final static char getChar(int index){
		return MAP.charAt(index);
	}

	private final static int fx(int x) {
		int val = x % 36;
		return (val == 0) ? 36 : val;
	}

	public final static char computeCheckChar(String digits) {
		int t = 36;
		for (int i = 0; i < digits.length(); ++i) {
			char ch = digits.charAt(i);
			int c = getValue( ch);
			
	     	if (c == -1){
	     		throw new NumberFormatException("Bad digit: '" + digits.charAt(i) + "'");
	     	}
			t = (2 * fx(t + c)) % 37;
		}
		int index = (37 - t) % 36;
//		System.out.println("Index is "+index+" t is "+t);
		return getChar( index);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.modp.checkdigit.CheckDigit#encode(java.lang.String)
	 */
	private final static String encode(String digits) {
		return digits + computeCheckChar(digits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.modp.checkdigit.CheckDigit#getCheckDigit(java.lang.String)
	 */
	public final static char getCheckDigit(String digits) {
		return digits.charAt(digits.length() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.modp.checkdigit.CheckDigit#getData(java.lang.String)
	 */
	public final static String getData(String digits) {
		return digits.substring(0, digits.length() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.modp.checkdigit.CheckDigit#verify(java.lang.String)
	 */
	public final static boolean verify(String digits) {
	   String data = getData( digits);
	   String expected = encode( data);
	   return digits.equals(expected);
	}

}
