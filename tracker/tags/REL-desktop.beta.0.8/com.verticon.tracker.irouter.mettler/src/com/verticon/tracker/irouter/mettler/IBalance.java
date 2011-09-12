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
package com.verticon.tracker.irouter.mettler;

import java.io.IOException;

import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.irouter.common.IContext;


/**
 * Provides a connectionService, the PID, the configuration, and a place to 
 * send the measurements.
 * 
 * TODO Refactor Balance for reuse similar to abbott and measurement.logger
 * projects to use a ServiceController.  Caution watch out for synchronization
 * issues in this project.
 * @author jconlon
 *
 */
public interface IBalance{
	void registerProducer();
	void unregisterProducer();
	ConnectorService getConnectorService() throws IOException;
	IContext getContext();
}
