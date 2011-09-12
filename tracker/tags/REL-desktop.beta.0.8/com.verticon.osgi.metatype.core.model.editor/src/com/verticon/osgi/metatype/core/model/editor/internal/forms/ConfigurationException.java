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
package com.verticon.osgi.metatype.core.model.editor.internal.forms;

public class ConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892071116332176892L;

	 ConfigurationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	ConfigurationException(String message) {
		super(message);
		
	}

	 ConfigurationException(Throwable cause) {
		super(cause);
		
	}

}
