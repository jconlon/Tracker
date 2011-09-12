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
package com.verticon.tracker.emf.edit.ui.provider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

/**
 * 
 */

/**
 * @author jconlon
 *
 */
public class WorkaroundAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider {

	private final Viewer viewer;
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		this.viewer.refresh();
	}

	/**
	 * @param adapterFactory
	 */
	public WorkaroundAdapterFactoryLabelProvider(AdapterFactory adapterFactory, Viewer viewer) {
		super(adapterFactory);
		this.viewer=viewer;
		
	}

	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		return super.getImage(object);
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		return super.getText(object);
	}

}
