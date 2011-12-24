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
package com.verticon.tracker.fair.poi.importxls;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author jconlon
 *
 */
class NormalizeName {
	
	 private static final Map<String, String> enCapExceptions = new HashMap<String,String>();
	    static {
	        enCapExceptions.put("macintosh", "Macintosh");
	        enCapExceptions.put("von", "von");
	        enCapExceptions.put("van", "van");
	        enCapExceptions.put("de", "de");
	        enCapExceptions.put("la", "la");
	        enCapExceptions.put("da", "da");
	        enCapExceptions.put("di", "di");
	}
	    
	
	
	protected static String parseFirstName(String txt){
		String[] name = txt.toLowerCase().split(",");
		StringBuffer firstName = new StringBuffer();
		for (int i = 0; i < name.length; i++) {
			if(i==0){
				
			}else{
				firstName.append(name[i]);
				firstName.append(' ');
			}
		}
		
		return capitalizeAndTrimEnglishNames(firstName.toString());
	}
	
	protected static String parseLastName(String txt){
		String[] name = txt.toLowerCase().split(",");
		return capitalizeAndTrimEnglishNames(name[0]);
	}
	
	protected static String capitalizeAndTrimEnglishNames(String txt) {
        if (txt == null)
            return "";
        String lcName = txt.toLowerCase(Locale.UK).trim();
        if (lcName.indexOf(' ') == -1)
            return capitalizeSingleEnglishName(lcName);
        StringBuilder res = new StringBuilder(lcName.length());
        String [] names = lcName.split(" ");
        for (int i = 0; i < names.length; i++) {
            if (i > 0)
                res.append(" ");
            res.append(capitalizeSingleEnglishName(names[i]));
        }
        return res.toString();
    }

    private static final String capitalizeSingleEnglishName(String lcName) {
        if (lcName == null || lcName.length() == 0)
            return "";
        String exFound = enCapExceptions.get(lcName);
        if (exFound != null)
            return exFound;
        StringBuilder res = new StringBuilder(lcName.length());
        int i;
        int n = lcName.length();        
        if (lcName.startsWith("d'")) {
            res.append("d'");
            i = 2;
        }
        else if (lcName.startsWith("mc")) {
            res.append("Mc");
            if (n > 2)
                res.append(Character.toUpperCase(lcName.charAt(2)));
            i = 3;
        }
        else if (lcName.startsWith("mac")) {
            res.append("Mac");
            if (n > 3)
                res.append(Character.toUpperCase(lcName.charAt(3)));
            i = 4;
        }
        else {
            res.append(Character.toUpperCase(lcName.charAt(0)));
            i = 1;
        }
        for ( ; i < n ; i++) {
            if (lcName.charAt(i) == ' ' && (i > 0) && (lcName.charAt(i-1) != ' '))
                    res.append(' ');
            if (i == 0)
                    res.append(Character.toUpperCase(lcName.charAt(i)));
            else {
                switch (lcName.charAt(i-1)) {
                    case '-':
                    case '.':
                    case ' ':
                        res.append(Character.toUpperCase(lcName.charAt(i)));
                        break;
                    case '\'':
                        if (i == (n-1))
                            res.append(lcName.charAt(i));
                        else
                            res.append(Character.toUpperCase(lcName.charAt(i)));
                        break;
                    default:
                        res.append(lcName.charAt(i));
                        break;
                }
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(capitalizeAndTrimEnglishNames("sue mclean"));
        System.out.println(capitalizeAndTrimEnglishNames("mclean "));
        System.out.println(capitalizeAndTrimEnglishNames("pamela j maccarthy"));
        System.out.println(capitalizeAndTrimEnglishNames("Mary-anne macintosh"));
        System.out.println(capitalizeAndTrimEnglishNames("beverly d'angelo"));
        System.out.println(capitalizeAndTrimEnglishNames("jake o'neil's"));
        System.out.println(capitalizeAndTrimEnglishNames("peter o'tull"));
        System.out.println(capitalizeAndTrimEnglishNames("andrew w"));
        System.out.println(capitalizeAndTrimEnglishNames("werner von braun"));
        System.out.println(capitalizeAndTrimEnglishNames("john mcnamara"));
        System.out.println(capitalizeAndTrimEnglishNames("j.r. ewing"));
        System.out.println(capitalizeAndTrimEnglishNames("leonardo di caprio"));
        System.out.println(capitalizeAndTrimEnglishNames("da vinci"));
        System.out.println(capitalizeAndTrimEnglishNames("leonardo da vinci"));
        System.out.println(capitalizeAndTrimEnglishNames("don alejandro de la vega"));
    }


   
}
