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
package com.verticon.tracker.ocl.query.viewer;

/**
 * @author jconlon
 * 
 */
public interface IOclQueryModelListener {

	/**
	 * Reflect the fact that a IOclQuery was added to the IOclQuery Model
	 * 
	 */
	public void addOclQuery(IOclQuery query);

	/**
	 * Update the view to reflect the fact that a IOclQuery was removed from the
	 * IOclQuery Model
	 * 
	 * @param query
	 */
	public void removeOclQuery(IOclQuery query);

	/**
	 * Update the view to reflect the fact that one of the IOclQuerys was
	 * modified in the IOclQuery Model
	 * 
	 * @param query
	 */
	public void updateOclQuery(IOclQuery query);
}
