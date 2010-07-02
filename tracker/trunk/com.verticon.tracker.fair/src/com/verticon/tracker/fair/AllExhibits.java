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
package com.verticon.tracker.fair;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;

/**
 * All the exhibits in the fair.
 * @author jconlon
 *
 */
public interface AllExhibits {

	EList<Exhibit> exhibits();
	
	void setForwarding(Adapter adapter);
}
