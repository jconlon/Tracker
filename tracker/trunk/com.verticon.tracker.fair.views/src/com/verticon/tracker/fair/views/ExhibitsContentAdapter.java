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
package com.verticon.tracker.fair.views;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

import com.verticon.tracker.fair.AllExhibits;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.presentation.ExhibitsContentAdapterDelegate;
import com.verticon.tracker.fair.util.AllExhibitsAdapterFactory;

/**
 * ContentProvider for the Exhibits TableViewer.  Works with the AllExhibits adapter
 * on the Fair to add or delete events to/from a TableViewer.
 * 
 * Composed with a ExhibitsContentAdapterDelegate to share its functionality
 * with the Transaction version of this class.
 * 
 * @see ExhibitsContentAdapterDelegate
 * @see AllExhibitsAdapterFactory
 * @see AllExhibits
 * @author jconlon
 *
 */
public class ExhibitsContentAdapter extends AdapterFactoryContentProvider 
	implements Adapter{
	
	/**
	 * ExhibitsTable to notify
	 */
	private TableViewer eventsTableViewer = null;
	
	
	private final ExhibitsContentAdapterDelegate delegate = 
		new ExhibitsContentAdapterDelegate(){
			@Override
			protected void refresh() {
				((TableViewer)viewer).refresh();
			}
	};

	
	
	public ExhibitsContentAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		return ((Fair) object).exhibits().toArray();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput,
			Object newInput) {
		
		if(eventsTableViewer==null){
			eventsTableViewer=(TableViewer)viewer;
		}
		delegate.inputChanged(viewer, oldInput, newInput);
		super.inputChanged(viewer, oldInput, newInput);	
	}
	
	
	
	/**
	 * Exhibits table shows the hierarchy elements of the Exhibit. These
	 * elements are shown in the table columns through ItemProviders so
	 * they by default adapt to a string based on the name of these elements.
	 * 
	 * Detecting changes to these hierarchy element names will be used to trigger 
	 * viewer.refresh.
	 * 
	 * Additions and deletions are handled more discreetly 
	 * with NotifyChangedToViewerRefresh.
	 * 
	 */
	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);
		delegate.notifyChanged(n);
	}
	

	public Notifier getTarget() {
		return delegate.getTarget();
	}

	public boolean isAdapterForType(Object type) {
		return delegate.isAdapterForType(type);
	}

	public void setTarget(Notifier newTarget) {
		delegate.setTarget(newTarget);
	}


}
