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
package com.verticon.tracker.store.mongodb.test.system;

import java.util.Map;

public interface IProducerConsumer {
	void send(Object object);

	boolean hasWires();

	int sentCount();

	void clearSendCount();

	Map<String, Object> getConsumedProducts();

	void setListener(IConsumerListener listener);
}
