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
package com.verticon.tracker.reader.eventadmin;

import java.io.IOException;

public interface ITagIdPublisher {

	/**
	 * Loads the animalTeplate from the file
	 * 
	 * @throws IOException
	 */
	public abstract void init() throws IOException;

	/**
	 * Called by client objects to publish the tag as a Templated Event to 
	 * all Premises in all Resources of the EditingDomain
	 * 
	 * @param tag
	 */
	public abstract void publish(Long tag);

}