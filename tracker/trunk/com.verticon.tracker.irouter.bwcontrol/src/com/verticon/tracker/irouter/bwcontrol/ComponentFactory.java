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
package com.verticon.tracker.irouter.bwcontrol;

import java.util.Dictionary;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.osgi.service.cm.ConfigurationException;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.common.AbstractComponentFactory;
import com.verticon.tracker.irouter.common.IService;
import com.verticon.tracker.irouter.common.ServiceController;

/**
 * ComponentFactory is the primary class for the c.v.t.irouter.abbott project. 
 * 
 * ComponentFactory implements a ManagedServiceFactory, (by extending AbstractComponentFactory)
 * to create instances of an Abbott WireAdmin Producer and Consumer. Instances will consume
 * <ol>
 * <li>mettler.weight.measurement scoped blood weight measurements from a Mettler balance</li>
 * <li>animal.weight.measurement scoped measurements from a TruTest scale head</li>
 * </ol>
 * and produce TruTest commands for 
 * <ol>
 * <li>producing commands to display a calculated blood weight</li>
 * <li>producing commands to display an actual blood weight</li>
 * <li>producing commands to turn on and off the TruTest audible alarm based on percentage
 * of calculated to actual blood weight</li>
 * </ol>
 * 
 * Component Factory is a temporary solution and will be replaced with a generic solution.
 * TODO move out command generation to a separate TruTest Command generator that consumes 
 * <ol>
 * <li>generic scoped measurements</li>
 * <li>alarm states</li>
 * </ol>
 * retain the ability to
 * <ol>
 * <li>produce a calculated blood weight measurement</li>
 * <li>produce an alarm state based on percentage of calculated to actual blood weight</li>
 * </ol>
 * 
 * c.v.tracker.irouter.Abbott
 * Log INFO policy:
 * ComponentFactory will log the update and deletion of instances.
 * 
 * Log DEBUG policy:
 * CompositeConsumer will log wire connections and sending of data
 * CommandProducer will log wire connections and sending of data, 
 * 
 * Log WARN policy:
 * CommandProducer send aborts when there are no wires.
 * 
 * Log ERROR policy:
 * Both Services will log unexpected 
 * 
 * 
 * @see CompositeConsumer
 * @see CommandProducer
 * @author jconlon
 *
 */
public class ComponentFactory extends AbstractComponentFactory {

	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.bwcontrol";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;

	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}
	
	protected ServiceController createServiceController(String pid,
			Dictionary<?,?> config) throws ConfigurationException {
		ServiceController controller;
		ControllerContext context = new ControllerContext(pid, config, exec, scheduler);
		BlockingQueue<String> commandQueue = new LinkedBlockingQueue<String>();
		IService commandProducer = new CommandProducer(context, commandQueue);
		IService compositeConsumer = new CompositeConsumer(context, commandQueue);
		controller = new ServiceController(
				context, new IService[]{commandProducer, compositeConsumer}, log);
		return controller;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	 */
	@Override
	public String getName() {
		return "Bleed Operations Controller";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComponentFactory [name=" + getName() + "]";
	}

	
	
}
