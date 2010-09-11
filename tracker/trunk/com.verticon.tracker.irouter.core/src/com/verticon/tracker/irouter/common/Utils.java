package com.verticon.tracker.irouter.common;

import java.util.Arrays;
import java.util.Vector;

public class Utils {
	
	private Utils(){};
	
	/**
	 * Convert a String to visualize nonvisible characters
	 * @param value
	 * @return an Ascii representation
	 */
	public static String toAscii(String value){
		StringBuffer buffer = new StringBuffer();
		buffer.append('<');
		 for ( int i = 0; i < value.length(); ++i ) {
			   
		       char c = value.charAt( i );
		       replaceNonCharacters(c, buffer);
		 }
		 buffer.append('>');
		 return buffer.toString();
	}
	
	/**
	 * Replace non characters with a %int% value to represent 
	 * there ascii decimal id.
	 * @param ch
	 * @param buffer
	 */
	public static void replaceNonCharacters(char ch, StringBuffer buffer){
		if(Character.isISOControl(ch)){
			buffer.append('%');
			int j = (int) ch;
			buffer.append(j);
			buffer.append('%');
		}else{
			buffer.append(ch);
		}
		
	}
	
	/**
	 * Converts a String of characters and visualized control characters to 
	 * a String of characters and control characters
	 * @param value
	 * @return normalized value from the Ascii representation
	 */
	public static String fromAscii(String value){
		StringBuffer out = new StringBuffer();
		StringBuffer buffer = null;
		boolean isAscii = false;
		for ( int i = 0; i < value.length(); ++i ) {
		       char c = value.charAt( i );
		       if(c == '%'){
		    	   if(isAscii){//the terminator, convert and buffer
		    		   int intChar = Integer.parseInt(buffer.toString());
		    		   out.append((char)intChar);
		    	   }else{//Starts
		    		   buffer=new StringBuffer();
		    	   }
		    	   isAscii=!isAscii;
		    	   continue;
		       }
		       if(isAscii){
		    	   buffer.append(c);
		       }else{
		    	   out.append(c);
		       }
		 }
		return out.toString(); 
	}

	/**
	 * Utility method to build an array of measurement scopes from an array of
	 * measurement names. A measurement scope name looks like: mettler.weight
	 * and the result scope looks like: mettler.weight.measurement
	 * 
	 * @return scope
	 */
	public static final String[] buildScope(String[] scopeNames,
			String[] additionalScopes) {
		Vector<String> v = new Vector<String>();
		for (String scopeName : scopeNames) {
			if (scopeName == null || scopeName.trim().length() == 0) {
				break;
			}
			v.add(scopeName + ".measurement");
		}
		v.addAll(Arrays.asList(additionalScopes));
		return v.toArray(new String[] {});
	}
}
