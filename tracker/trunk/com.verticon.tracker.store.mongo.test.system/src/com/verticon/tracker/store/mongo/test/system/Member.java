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

package com.verticon.tracker.store.mongo.test.system;

public enum Member {
	ONE("urn:pin:H89234X", "docPassword"),
	//
	TWO("two", "pwtwo"), 
	//
	THREE("urn:pin:003ALKM", "mudshark");


	public final String uri;

	@SuppressWarnings("unused")
	private final String password;

	Member(String uri, String password) {
		this.uri = uri;
		this.password = password;
	}
}