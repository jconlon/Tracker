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
package com.verticon.tracker.irouter.core.channel.sender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChannelMessage {
	private final String function;
	private final Map<String,Object> parameters;

	public ChannelMessage(String function) {
		super();
		this.function = function;
		parameters = new HashMap<String, Object>(11);
	}

	public void addParameter(String parameter, int value) {
		addParameter(parameter, Integer.toString(value));
	}

	public void addParameter(String parameter, String value) {
		parameters.put(parameter, value);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelMessage other = (ChannelMessage) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		return true;
	}

	public String getFunction() {
		return function;
	}

	public Iterator<String> getParametersIterator() {
		return parameters.keySet().iterator();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		return result;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer(255);
		buf.append("function: ");
		buf.append(function);
		Object[] keys = parameters.keySet().toArray();
		Arrays.sort(keys);
		for (int i = 0; i < keys.length; i++) {
			Object key = keys[i];
			Object value = parameters.get(key);
			buf.append("\n\t");
			buf.append(key);
			buf.append(": ");
			buf.append(value);
		}
		return buf.toString();
	}

	public String valueForParameter(String parameter) {
		return (String) parameters.get(parameter);
	}
}
