/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store;

import java.io.IOException;

/**
 * @author jconlon
 * 
 */
public class StoreAccessException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6220790977121813004L;

	/**
	 * @param message
	 */
	public StoreAccessException(String message) {
		super(message);
	}

}
