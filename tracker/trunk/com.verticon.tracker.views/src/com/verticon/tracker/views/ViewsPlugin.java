/**
 * 
 */
package com.verticon.tracker.views;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.verticon.tracker.editor.util.IViewerFilters;

/**
 * @author jconlon
 *
 */
public class ViewsPlugin extends Plugin implements IViewerFilters{

	// The shared instance.
    static ViewsPlugin plugin;
	private BundleContext bundleContext = null;
	
	
	public ViewsPlugin() {
		plugin = this;
	}


	@Override
	public Collection<ViewerFilter> getViewerFilters(EClass type) {
		Collection<ViewerFilter> result;
		if(bundleContext!=null){
			ServiceReference reference = bundleContext.getServiceReference(IViewerFilters.class.getName());
			if (reference != null){
				IViewerFilters service = (IViewerFilters)bundleContext.getService(reference);
				result = service.getViewerFilters(type);
				bundleContext.ungetService(reference);
			}else{
//				System.out.println("No Service available!");
				result = Collections.emptyList();
			}

		}else{
//			System.out.println("No BundleContext available in "+this+"!");
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
