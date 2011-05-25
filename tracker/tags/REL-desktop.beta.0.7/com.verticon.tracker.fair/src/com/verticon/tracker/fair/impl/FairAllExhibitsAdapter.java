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
package com.verticon.tracker.fair.impl;
import static com.verticon.tracker.fair.FairPlugin.bundleMarker;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Lot;

public class FairAllExhibitsAdapter extends EContentAdapter implements
		AllExhibits {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FairAllExhibitsAdapter.class);

	private Fair fair = null;
	private final EList<Exhibit> exhibits = new BasicEList<Exhibit>();
	private Adapter forwardingAdapter = null;


	public synchronized EList<Exhibit> exhibits() {
		exhibits.clear();
		for (Division division : fair.getDivisions()) {
			for (Department department : division.getDepartments()) {
				for (com.verticon.tracker.fair.Class clazz : department.getClasses()) {
					for (Lot lot : clazz.getLots()) {
						exhibits.addAll(lot.getExhibits());
					}
				}
			}
		}
		return ECollections.unmodifiableEList(exhibits);
	}

	/**
	 * Set the fair before calling calling super.
	 */
	@Override
	public void setTarget(Notifier target) {
		if (fair == null && target instanceof Fair) {
			fair = (Fair) target;
		}
		super.setTarget(target);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AllExhibits.class;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.isTouch()) {
			return;
		}
		super.notifyChanged(notification);
		if (forwardingAdapter == null) {
			logger.debug(bundleMarker,"Forwarding adapter for {} is null {}", this, this.forwardingAdapter);
		} else {
			forwardingAdapter.notifyChanged(notification);
		}
	}

	public void setForwarding(Adapter adapter) {
		this.forwardingAdapter = adapter;
	}

}
