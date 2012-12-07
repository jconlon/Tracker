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
package com.verticon.tracker.configuration.internal;

import static com.google.common.collect.Sets.newHashSet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.io.Closeables;
import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.Attribute;
import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.DocumentRoot;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;

/**
 * EMF Resource for configuring ManagedServiceFactory objects via the
 * ConfigurationAdmin and utilizing meta-typing from MetaTypeService
 * metatype.xml resources.
 * 
 * @author jconlon
 * 
 */
public class ConfigAdminResouceImpl extends XMLResourceImpl {

	private static final String WIREADMIN_CONSUMER_SCOPE = "wireadmin.consumer.scope";
	private static final String WIREADMIN_PRODUCER_SCOPE = "wireadmin.producer.scope";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConfigAdminResouceImpl.class);
	/**
	 * Identify the plugin to the logger
	 */
	public final static String PLUGIN_ID = "com.verticon.tracker.configuration";
	
	private Map<?, ?> options = null;

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * Map of the model designates to their configuration
	 */
	private Map<String, Configuration> configMap = new HashMap<String, Configuration>();

	private Collection<Designate> snapshotDesignates = new ArrayList<Designate>();

	/**
	 * Constructor
	 * 
	 * @param uri
	 */
	public ConfigAdminResouceImpl(URI uri) {
		super(uri);
	}

	/**
	 * Load the state of the ManagedServiceFactory configurations as a Metatype
	 * model.
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#load(java.util.Map)
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		this.options=options;
		Map<?, ?> response = options == null ? null : (Map<?, ?>) options
				.get(URIConverter.OPTION_RESPONSE);
		if (response == null) {
			response = new HashMap<Object, Object>();
		}
		logger.debug(bundleMarker, "Loading metadata uri={}", getURI());
		configMap.clear();

		DocumentRoot root = MetatypeFactory.eINSTANCE.createDocumentRoot();
		MetaData metaData = loadMetaData(options);
		root.setMetaData(metaData);

		ConfigurationAdmin configurationAdmin = findConfigurationAdmin();
		if (configurationAdmin == null) {
			throw new IOException(
					"Could not find a ConfigurationAdmin service.");
		}
		Configuration[] configurations = null;
		try {
			configurations = configurationAdmin
					.listConfigurations("(service.factoryPid=*tracker*)");

		} catch (InvalidSyntaxException e) {
			throw new IOException("Could not list Configurations.", e);
		}
		integrated(metaData, configurations);

		if(!contents.isEmpty()){
			contents.clear();
		}
			
		contents.add(root);

		setLoaded(true);
		Long timeStamp = (Long) response
				.get(URIConverter.RESPONSE_TIME_STAMP_PROPERTY);
		if (timeStamp != null) {
			setTimeStamp(timeStamp);
		}

	}

	/**
	 * Save the changes to the Delegates/Object/Attribute EObjects as
	 * ConfigurationAdmin Configurations.
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#save(java.util.Map)
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		if (getURI() != null && getURI().scheme() != null
				&& getURI().scheme().equals("config")) {
			// Changed
			List<Designate> designates = getChangedDesignates();
			for (Designate changedDesignate : designates) {
				updateConfiguration(changedDesignate);
			}

			// Added
			designates = getNewDesignates();
			for (Designate newDesignate : designates) {
				createConfiguration(newDesignate);
			}

			// Deleted
			designates = getDeletedDesignates();
			for (Designate deletedDesignate : designates) {
				deleteConfiguration(deletedDesignate);
			}
			// Reload
			configMap.clear();
			snapshotDesignates.clear();
			unload();
			load(this.options);
		} else {
			super.save(options);
		}
	}

	/**
	 * Create a new factory configuration
	 * 
	 * @param designate
	 *            from model
	 * @throws IOException
	 */
	private void createConfiguration(Designate designate) throws IOException {
		if (hasNoFactoryPid(designate)) {
			logger.warn(bundleMarker,
					"FactoryPid is empty, abort configuration creation {}",
					designate);
			return;
		}
		logger.debug(bundleMarker, "Creating configuration for factoryPid={}",
				designate.getFactoryPid());
		Dictionary<String, Object> properties = getProperties(designate);

		ConfigurationAdmin configAdmin = findConfigurationAdmin();
		Configuration configuration = configAdmin
				.createFactoryConfiguration(designate.getFactoryPid(), designate.getBundle());
		configuration.update(properties);
		logger.info(bundleMarker, "Created configuration for factoryPid={}",
				designate.getFactoryPid());
	}

	/**
	 * Get the designate attributes and save them as properties
	 * @param designate
	 * @return
	 */
	private Dictionary<String, Object> getProperties(Designate designate) {
		Dictionary<String, Object> properties = new Hashtable<String, Object>();
		
		for (Attribute attribute : designate.getObject().getAttribute()) {
			if (!attribute.getValue().isEmpty()) {
				Object value = null;
				String name = attribute.getAdref();
				//Ticket#626
				if(WIREADMIN_PRODUCER_SCOPE.equals(name)){
					value = attribute.getValue().toArray();
				}else if(WIREADMIN_CONSUMER_SCOPE.equals(name)){
					value = attribute.getValue().toArray();
					
				}else if (attribute.getValue().size() > 1) {
					value = attribute.getValue().toArray();
				} else {
					value = attribute.getValue().get(0);
				}

				properties.put(name, value);
			}

		}
		return properties;
	}

	

	/**
	 * Use the configMap to update the configuration.
	 * 
	 * @param designate
	 *            from the model
	 * @throws IOException
	 */
	private void updateConfiguration(Designate designate) throws IOException {
		Configuration configuration = configMap.get(designate.getPid());
		assert (configuration != null);
		assert (designate != null);
		if (hasNoFactoryPid(designate)) {
			logger.warn(bundleMarker,
					"FactoryPid is empty, abort configuration update {}",
					designate);
			return;
		}
		logger.debug(bundleMarker,
				"Updating configuration for factory={} pid={}", designate
						.getFactoryPid(), designate.getPid());

		Dictionary<String, Object> properties = getProperties(designate);
		configuration.update(properties);
		logger.info(bundleMarker,
				"Updated configuration for factory={} pid={}", designate
						.getFactoryPid(), designate.getPid());
	}

	/**
	 * Use the configMap to update the configuration.
	 * 
	 * @param snapShotDesignate
	 *            from the snapshot
	 * @throws IOException
	 */
	private void deleteConfiguration(Designate snapShotDesignate)
			throws IOException {
		// snapShotDesignate is only a copy of the one in the configMap
		// Find the config based on pid
		if (hasNoPid(snapShotDesignate)) {
			logger.warn(bundleMarker,
					"Pid is empty, abort configuration deletion {}",
					snapShotDesignate);
			return;
		}
		logger.debug(bundleMarker,
				"Deleting configuration for factory={} pid={}",
				snapShotDesignate.getFactoryPid(), snapShotDesignate.getPid());
		Configuration configuration = configMap.get(snapShotDesignate.getPid());
		if(configuration!=null){
			configuration.delete();
			logger.info(bundleMarker,
				"Deleted configuration for factory={} pid={}",
				snapShotDesignate.getFactoryPid(), snapShotDesignate.getPid());
		}

	}

	

	/**
	 * Compare model designates to the snapshot to determine changed designates.
	 * 
	 * @return changed model designates. New model designates and deleted model
	 *         designates will not be returned.
	 */
	private List<Designate> getChangedDesignates() {
		List<Designate> changedDesignates = new ArrayList<Designate>();
		DocumentRoot root = (DocumentRoot) contents.get(0);

		if (root != null) {

			for (Designate designateSnapshot : snapshotDesignates) {

				for (Designate modelDesignate : root.getMetaData().getDesignate()) {
					if(isTemplate(modelDesignate) || hasNoPid(modelDesignate)){
						continue;
					}
					if (modelDesignate.getPid().equals(designateSnapshot.getPid())) {
						if (!EcoreUtil
								.equals(modelDesignate, designateSnapshot)) {
							changedDesignates.add(modelDesignate);
							break;
						}
					}
				}
			}
		}
		return changedDesignates;
	}

	

	/**
	 * Model designates not in the snapshot are new designates.
	 * 
	 * @return
	 */
	private List<Designate> getNewDesignates() {
		List<Designate> newDesignates = new ArrayList<Designate>();
		DocumentRoot root = (DocumentRoot) contents.get(0);

		if (root != null) {

			for (Designate modelDesignate : root.getMetaData().getDesignate()) {
				if(isTemplate(modelDesignate)){
					continue;
				}
				boolean found = false;
				for (Designate designateSnapshot : snapshotDesignates) {
					if (designateSnapshot.getPid().equals(modelDesignate.getPid())) {
						found = true;
						break;
					}
				}
				if (!found) {
					newDesignates.add(modelDesignate);
				}
			}
		}
		return newDesignates;
	}

	/**
	 * Snapshot Designates that are not in model are deleted designates.
	 * 
	 * @return
	 */
	private List<Designate> getDeletedDesignates() {
		List<Designate> deletedDesignates = new ArrayList<Designate>();
		DocumentRoot root = (DocumentRoot) contents.get(0);

		if (root != null) {
//			List<Designate> modelDesignates = root.getMetaData().getDesignate();

			for (Designate snapshotDesignate : snapshotDesignates) {
				boolean found = false;
				for (Designate modelDesignate : root.getMetaData().getDesignate()) {
					if(isTemplate(modelDesignate)|| hasNoPid(modelDesignate)){
						continue;
					}
					if (modelDesignate.getPid().equals(snapshotDesignate.getPid())) {
						found = true;
						break;
					}
				}
				if (!found) {
					deletedDesignates.add(snapshotDesignate);
				}
			}
		}
		return deletedDesignates;
	}

	@SuppressWarnings("unchecked")
	private void integrated(MetaData metaData, Configuration[] configurations) {
		if (configurations == null) {
			logger.warn(bundleMarker, "Found no configuraitons.");

//			metaData.getDesignate().clear();
			return;
		}

		EList<Designate> designateTemplates = metaData.getDesignate();

		// FactoryPids evaluate to the pid of the ManagedServiceFactory and to
		// the pid
		// of the existing designates that need to be
		Copier copier = new Copier();
		for (Configuration configuration : configurations) {
			String factoryPid = configuration.getFactoryPid();
			logger.debug(bundleMarker,
					"Setting up designate for factoryPid={}", factoryPid);
			for (Designate designateTemplate : designateTemplates) {
				if (factoryPid.equals(designateTemplate.getPid())) {
					// Copy this designateTemplate
					Designate configDesignate = (Designate) copier
							.copy(designateTemplate);
					copier.copyReferences();
					configDesignate
							.setBundle(configuration.getBundleLocation());
					configDesignate
							.setFactoryPid(configuration.getFactoryPid());
					configDesignate.setPid(configuration.getPid());
					String ocdRef = configDesignate.getObject().getOcdref();
					for (OCD ocd : metaData.getOCD()) {
						if (ocdRef.equals(ocd.getID())) {
							integrate(ocd, configDesignate.getObject(),
									configuration.getProperties());
							break;
						}
					}
					configMap.put(configDesignate.getPid(), configuration);
					metaData.getDesignate().add(configDesignate);
					snapshotDesignates.add((Designate)EcoreUtil.copy(configDesignate));
					break;
				}

			}
		}

	}

	/**
	 * 
	 * @param ocd
	 *            to build attributes
	 * @param parent
	 *            the Object to add attributes
	 * @param properties
	 *            from the configuration
	 */
	private static void integrate(OCD ocd,
			com.verticon.osgi.metatype.Object parent,
			Dictionary<String, ?> properties) {
		for (AD ad : ocd.getAD()) {
			Attribute att = MetatypeFactory.eINSTANCE.createAttribute();
			att.setAdref(ad.getID());

			Enumeration<String> en = properties.keys();
			while (en.hasMoreElements()) {
				String key = en.nextElement();
				if (ad.getID().equals(key)) {
					Object o = properties.get(key);
					Class<?> type = o.getClass();
					if (type.isArray()) {
						Object[] a = (Object[]) o;
						for (Object object : a) {
							att.getValue().add(object.toString());
						}
					} else if (o instanceof Vector<?>) {
						Vector<?> a = (Vector<?>) o;
						for (Object object : a) {
							att.getValue().add(object.toString());
						}
					} else {
						att.getValue().add(o.toString());
					}
				}
			}
			parent.getAttribute().add(att);

		}
	}

	/**
	 * Build metaData model from all the metatype.xml resources found in bundles
	 * in the framework.
	 * 
	 * This uses the google collections and io libraries
	 * 
	 * @param options
	 * @return metaData EObject
	 * @throws IOException
	 */
	private MetaData loadMetaData(Map<?, ?> options) throws IOException {
		MetaData metaData = MetatypeFactory.eINSTANCE.createMetaData();
		BundleContext bctx = FrameworkUtil.getBundle(ConfigAdminResouceImpl.class).getBundleContext();
		Set<URL> loaded = newHashSet();
		Copier copier = new Copier();
		//Get all bundles with metatype resources
		Collection<Bundle> allBundlesWithMetaData = 
			Collections2.filter(Arrays.asList(bctx.getBundles()), containsMetatypePredicate);
		
		for (Bundle bundle : allBundlesWithMetaData) {
			URL url = metatypeURLFunction.apply(bundle);
			if(loaded.contains(url)){
				logger.debug(bundleMarker, "Previously loaded {} defered loading from {}",
						url, bundle.getSymbolicName() );
				continue;
			}
			InputStream is = null;
			boolean threw = true;
			try {
				is = url.openStream();
				logger.debug(bundleMarker, "Loading {} from {}",
						url, bundle.getSymbolicName() );

				super.load(is, options);

				if (!contents.isEmpty()
						&& (contents.get(0) instanceof DocumentRoot)) {

					//						logger.debug(bundleMarker,
					//								"Loaded metadata from {}", bundles[i]
					//										.getSymbolicName());
				} else {
					logger
					.warn(bundleMarker,
							"Failed to Load {} content={}",
							bundle.getSymbolicName(),
							contents.size());
				}

				DocumentRoot documentRoot = (DocumentRoot) contents
				.get(0);
				MetaData md = documentRoot.getMetaData();
				EList<OCD> ocds = md.getOCD();
				for (OCD ocd : ocds) {
					OCD copiedOCD = (OCD) copier.copy(ocd);
					metaData.getOCD().add(copiedOCD);
				}
				EList<Designate> designates = md.getDesignate();
				for (Designate designate : designates) {
					Designate copiedDesignate = (Designate) copier
					.copy(designate);
					copiedDesignate.setBundle('['+bundle.getLocation()+']');
					metaData.getDesignate().add(copiedDesignate);
				}
				copier.copyReferences();

				logger.debug(bundleMarker,
						"Loaded metadata from {} at location {}", bundle, bundle.getLocation());
				loaded.add(url);

				threw = false;
			} finally {
				unload();
				Closeables.close(is, threw);
			}
		}

		loaded.clear();
		return metaData;
	}
	

    static ConfigurationAdmin findConfigurationAdmin() {
		ServiceReference reference = getBundleContext().getServiceReference(
				ConfigurationAdmin.class.getName());
		Object o = getBundleContext().getService(reference);
		return o == null ? null : (ConfigurationAdmin) o;
	}
	
	private static BundleContext getBundleContext() {
		BundleContext ctx = FrameworkUtil.getBundle(
				ConfigAdminResouceImpl.class).getBundleContext();
		return ctx;
	}

	private static boolean isTemplate(Designate modelDesignate) {
		return modelDesignate.getBundle()!=null && modelDesignate.getBundle().startsWith("[");
	}
	
	private static boolean hasNoFactoryPid(Designate designate) {
		return designate.getFactoryPid() == null
				|| designate.getFactoryPid().trim().length() < 1;
	}
	
	private static boolean hasNoPid(Designate modelDesignate) {
		return modelDesignate.getPid() == null
				|| modelDesignate.getPid().trim().length() < 1;
	}
	
	private  final Predicate<Bundle> containsMetatypePredicate = new Predicate<Bundle>() {
		@Override
		public boolean apply(final Bundle bundle) {
			logger.debug(bundleMarker, "Processing {}",
					 bundle.getSymbolicName() );
			boolean result = false;
			try {
				result = bundle.getResources("OSGI-INF/metatype/metatype.xml").hasMoreElements();

			} catch (Exception e2) {
				//ignore
			}
			return result;
		}
	};
	
	private static final Function <Bundle, URL> metatypeURLFunction = new Function<Bundle, URL>(){
		@Override
		public URL apply(Bundle bundle) {
			try {
				Object o = bundle.getResources("OSGI-INF/metatype/metatype.xml").nextElement();
				if(o instanceof URL){
					return ((URL)o);
				}
			} catch (Exception e2) {
				
			}
			return null;
		}
		
	};
}
