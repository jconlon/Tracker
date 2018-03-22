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
/**
 * 
 */
package com.verticon.tracker.fair.views;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.verticon.emf.ui.api.IViewerFilters;

/**
 * @author jconlon
 *
 */
public class ViewsPlugin extends AbstractUIPlugin implements IViewerFilters{

	// The shared instance.
    static ViewsPlugin plugin;
	private BundleContext bundleContext = null;
    static final String ID = "com.verticon.tracker.fair.views";
	
	
	public ViewsPlugin() {
		plugin = this;
	}

	static ImageDescriptor imageDescriptorFromPlugin(String imageFilePath){ 
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, imageFilePath);
	}
	
	public Collection<ViewerFilter> getViewerFilters(EClass type) {
		Collection<ViewerFilter> result;
		if(bundleContext!=null){
			ServiceReference reference = bundleContext.getServiceReference(IViewerFilters.class.getName());
			if (reference != null){
				IViewerFilters service = (IViewerFilters)bundleContext.getService(reference);
				result = service.getViewerFilters(type);
				bundleContext.ungetService(reference);
			}else{
				result = Collections.emptyList();
			}

		}else{
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		bundleContext=context;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		bundleContext=null;
		super.stop(context);
	}

}
