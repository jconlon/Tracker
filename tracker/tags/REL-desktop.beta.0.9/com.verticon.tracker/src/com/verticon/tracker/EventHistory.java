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
package com.verticon.tracker;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;

/**
 * Provides a history of events.
 * @author jconlon
 *
 */
public interface EventHistory {

	/**
	 * 
	 * @return List of Events
	 */
	EList<Event> eventHistory();
	
	void setForwarding(Adapter adapter);
}
