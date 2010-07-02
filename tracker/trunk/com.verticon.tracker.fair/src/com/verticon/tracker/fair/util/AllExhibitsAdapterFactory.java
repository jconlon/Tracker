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
package com.verticon.tracker.fair.util;

import org.eclipse.emf.common.notify.Adapter;

import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.impl.FairAllExhibitsAdapter;


/**
 * AdapterFactory for adding AllExhibits functionality to a 
 * Fair element.
 * 
 * @see FairAllExhibitsAdapter
 * @see AllExhibits
 * 
 * @author jconlon
 *
 */
public class AllExhibitsAdapterFactory extends FairAdapterFactory {

	@Override
	public Adapter createFairAdapter() {
		return new FairAllExhibitsAdapter();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return type == AllExhibits.class || 
		super.isFactoryForType(type);
	}

	public static AllExhibitsAdapterFactory
	INSTANCE = new AllExhibitsAdapterFactory();

}
