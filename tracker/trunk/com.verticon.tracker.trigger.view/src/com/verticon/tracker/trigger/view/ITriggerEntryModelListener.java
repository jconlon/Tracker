/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
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
package com.verticon.tracker.trigger.view;

/**
 * @author jconlon
 * 
 */
public interface ITriggerEntryModelListener {

	/**
	 * Reflect the fact that a ITriggerEntry was added to the ITriggerEntry Model
	 * 
	 */
	public void addEntry(ITriggerEntry query);

	/**
	 * Update the view to reflect the fact that a ITriggerEntry was removed from the
	 * ITriggerEntry Model
	 * 
	 * @param entry
	 */
	public void removeEntry(ITriggerEntry entry);

	/**
	 * Update the view to reflect the fact that one of the ITriggerEntry was
	 * modified in the ITriggerEntry Model
	 * 
	 * @param entry
	 */
	public void updateEntry(ITriggerEntry entry);
}
