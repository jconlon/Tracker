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
package com.verticon.tracker.reader.event.generator;

import java.net.URI;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;

public class GeneratingReaderFactory implements IReaderFactory {

	private final static String TYPE = "GeneratingReader";

	public IReader instance(String name, String type, String template,
			URI target) {
		IReader reader = new GeneratingReader(name);
		reader.setTarget(target);
		reader.setTemplate(template);
		return reader;
	}

	/**
	 * Needed to implement interface. Not typically called.
	 */
	public boolean isSupportedType(String type) {
		return TYPE.equals(type);
	}

}
