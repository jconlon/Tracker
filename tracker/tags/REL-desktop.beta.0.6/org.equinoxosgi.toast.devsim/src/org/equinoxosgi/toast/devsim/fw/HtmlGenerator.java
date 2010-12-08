/*******************************************************************************
 * Copyright (c) 2009 Paul VanderLei, Simon Archer, Jeff McAffer and others. All
 * rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Toast is an Equinox/OSGi system developed for the book Eclipse, Equinox and
 * OSGi - Creating Highly Modular Java Applications See http://equinoxosgi.org
 * 
 * Contributors: Paul VanderLei, Simon Archer and Jeff McAffer - initial API and
 * implementation
 *******************************************************************************/
package org.equinoxosgi.toast.devsim.fw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.equinoxosgi.toast.internal.devsim.bundle.Component.bundleMarker;



public class HtmlGenerator {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(HtmlGenerator.class);


	private static final String DELIMITER = "%%%";
	private PrintWriter writer;
	private Map<String,String> parameters;

	public HtmlGenerator(PrintWriter writer) {
		super();
		this.writer = writer;
		parameters = new HashMap<String,String>(7);
	}

	private void processLine(String line) {
		int spot = 0;
		while (true) {
			int index = line.indexOf(DELIMITER, spot);
			if (index == -1) {
				String tail = line.substring(spot);
				writer.println(tail);
				return;
			}
			String chunk = line.substring(spot, index);
			writer.print(chunk);
			spot = index + DELIMITER.length();
			int end = line.indexOf(DELIMITER, spot);
			String key = line.substring(spot, end);
			spot = end + DELIMITER.length();
			String value = (String) parameters.get(key);
			if (value == null)
				value = "{unknown key: " + key + "}";
			writer.print(value);
		}
	}

	public void replace(String key, String value) {
		parameters.put(key, value);
	}

	public void write(String templateFileName, Class<?> classInBundle) {
		InputStream stream = classInBundle
				.getResourceAsStream(templateFileName);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		try {
			try {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					processLine(line);
				}
			} finally {
				bufferedReader.close();
			}
		} catch (IOException e) {
			logger.error(bundleMarker,this+ " Cannot write template file: "
					+ templateFileName, e);
		}
	}
	
	public void write(String line){
		processLine(line);
	}
}
