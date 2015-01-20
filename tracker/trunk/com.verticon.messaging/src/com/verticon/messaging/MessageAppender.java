/*******************************************************************************
 * Copyright (c) 2015 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.messaging;

import java.util.Date;

/**
 * TODO This is a generic interface and can be moved to iRouter commons next
 * release. Assists with building output messages.
 * 
 * @author jconlon
 * 
 */
public interface MessageAppender {

	/**
	 * Append the contents of the NMEA object values to the output buffer
	 * 
	 * @param output
	 * @param delimiter
	 */
	public abstract void appendMessage(StringBuffer output, String delimiter);

	public Date getDate();
}