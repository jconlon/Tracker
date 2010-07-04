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
package com.verticon.tracker.reader.event.connection;

/**
 * 
 * A task associated with a user interface may need to be updated
 * after completing or being canceled.
 * 
 * @author jconlon
 *
 */
public interface RefreshableReader {
	void refresh();
	void publish(Long tag);
}
