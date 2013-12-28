/**
 * 
 */
package org.usaha.ecvi.store.ui;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.usaha.ecvi.store.IEcviStore;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * Added utilities to assist the UIs to retrieve IEcviStore services
 * 
 * @author jconlon
 * 
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.usaha.ecvi.store.ui"; //$NON-NLS-1$
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	// The shared instance
	private static Activator plugin;

	private ServiceTracker<IEcviStore, IEcviStore> storeTracker;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		storeTracker = new ServiceTracker<IEcviStore, IEcviStore>(context,
				IEcviStore.class.getName(), null);
		storeTracker.open();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		storeTracker.close();
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * 
	 * @param uri
	 *            of the Provider
	 * @return EcviService associated with the provider
	 */
	public IEcviStore getEcviService(String uri) {
		for (IEcviStore iEcviStore : getAvailableEcviStores()) {
			for (String storeUri : iEcviStore.getURIs()) {
				if (uri.equals(storeUri)) {
					return iEcviStore;
				}
			}
		}
		return null;
	}

	public Iterable<String> getAllProviderURLs() {
		List<String> urls = newArrayList();
		for (IEcviStore iEcviStore : getAvailableEcviStores()) {
			Iterables.addAll(urls, iEcviStore.getURIs());
		}
		return urls;
	}

	private Iterable<IEcviStore> getAvailableEcviStores() {
		Iterable<ServiceReference<IEcviStore>> refs = Arrays
				.asList(storeTracker.getServiceReferences());
		Iterable<IEcviStore> stores = Iterables.transform(refs, toEcviStore);
		return stores;
	}

	/**
	 * 
	 * @return true if there is at least one service available
	 */
	public boolean hasTrackerStoreService() {
		return !storeTracker.isEmpty();
	}

	private final Function<ServiceReference<IEcviStore>, IEcviStore> toEcviStore = new Function<ServiceReference<IEcviStore>, IEcviStore>() {
		@Override
		public IEcviStore apply(ServiceReference<IEcviStore> serviceReference) {
			return storeTracker.getService(serviceReference);
		}
	};

}