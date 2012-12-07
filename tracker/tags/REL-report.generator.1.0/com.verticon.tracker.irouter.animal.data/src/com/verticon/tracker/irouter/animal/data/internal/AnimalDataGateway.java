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
package com.verticon.tracker.irouter.animal.data.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Predicates.alwaysTrue;
import static com.google.common.collect.Lists.newLinkedList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Maps.newTreeMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

/**
 * 
 * AnimalDataGateway is a Premises model specific Component Factory that creates
 * services that produce a list of animal life data records extracted from a
 * specified Premises model file.
 * 
 * Content and format for the records is configurable.
 * 
 * Extraction and production is done on a separate thread.
 * 
 * @author jconlon
 * 
 */
public class AnimalDataGateway implements Producer, Monitorable,
		Callable<ImmutableList<String>> {

	// Configuration
	static final String MAPPER = "animal.life.data.mapping"; //Optional
	static final String CONNECTION_URI = "connection.uri"; //Required
	static final String SERVICE_PID = "service.pid"; //Required
	static final String REFRESH_SECONDS = "refresh.seconds"; //Optional
	static final String FIELDS = "animal.life.data.fields"; //Optional

	// Status Variables
    static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
    static final String TIME_OF_LAST_UPDATE = "producer.Last_Data_Update";
    static final String TOTAL_RECORDS_SENT = "producer.Total_Records_Sent";
    static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
    static final String UPLOAD_EXCEPTION = "producer.Upload_Exception";
	private static final String[] STATUS_VARIABLES = new String[] {
			CONNECTED_CONSUMERS_COUNT, TIME_OF_LAST_UPDATE, TOTAL_RECORDS_SENT,
			CONNECTION_URI_STATUS_VAR, UPLOAD_EXCEPTION };

	// Misc static variables
	private static final String PLUGIN_ID = "com.verticon.tracker.irouter.animal.data";
	private static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	private final ExecutorService exec = Executors.newCachedThreadPool();
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	private final Logger logger = LoggerFactory
			.getLogger(AnimalDataGateway.class);

	private volatile Wire[] wires = new Wire[] {};
	private volatile long lastUpdateTime = 0;
	private volatile Map<String, Object> config = null;
	private volatile Predicate<EAttribute> configuredAttributesPredicate;
	private volatile Comparator<EAttribute> configuredAttributesComparator;
	private volatile Function<Animal, String> transformer;
	private volatile ExecutionException exception = null;
	private volatile Future<ImmutableList<String>> futureRecords = null;
	private volatile URI configuredURI = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalDataGateway [pid=" + getPid() + "]";
	}

	
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		checkState(!Strings.isNullOrEmpty((String) config.get(CONNECTION_URI)),
				CONNECTION_URI + " attribute can not be null or empty");

		Object o = config.get(FIELDS);
		if (o != null) {
			checkState(o.getClass().isArray(), FIELDS
					+ " attribute must be an array");
			configuredAttributesPredicate = new ConfiguredAttributesPredicate(
					Arrays.asList((String[]) o));
			configuredAttributesComparator = new ConfiguredAttributesComparator(
					Arrays.asList((String[]) o));
		} else {
			configuredAttributesPredicate = alwaysTrue();
			List<String> empty = Collections.emptyList();
			configuredAttributesComparator = new ConfiguredAttributesComparator(
					empty);
		}

		o = config.get(MAPPER);
		if (o != null) {
			checkState(o.getClass().isArray(), MAPPER
					+ " attribute must be an array");
			transformer = new ValueFunction(Arrays.asList((String[]) o));
			logger.debug(bundleMarker, "{} set mapper=active", this);
		} else {
			List<String> empty = Collections.emptyList();
			transformer = new ValueFunction(empty);
			logger.debug(bundleMarker, "{} set mapper=inactive", this);
		}

		this.config = config;
		this.configuredURI= URI.createURI((String) (config.get(CONNECTION_URI)));
		logger.debug(bundleMarker, "{} activating properties={}", this, config);
		
		

	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		logger.debug(bundleMarker, "{} deactivating", this);
		if (futureRecords != null && !futureRecords.isDone()) {
			futureRecords.cancel(true);
			futureRecords = null;
		}
		this.config.clear();

	}

	@Override
	public Object polled(Wire wire) {
		return getRecordsSent();
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		if (wires != null && wires.length!=0) {
			for (Wire wire : wires) {
				logger.debug(
						bundleMarker,
						"{} connected to {}",
						this,
						wire.getProperties().get(
								WireConstants.WIREADMIN_CONSUMER_PID));
			}
			if (futureRecords == null) {
				logger.debug(
						bundleMarker,
						"{} submitting extraction task",
						this);
				futureRecords = exec.submit(this);
			} else if (futureRecords.isDone()) {
				if (shouldRefresh()) {
					futureRecords = exec.submit(this);
				} else {
					send(getRecordsSent());
				}
			}
		} else {
			
			if (futureRecords != null) {
				futureRecords.cancel(true);
			}
		}

	}

	@Override
	public ImmutableList<String> call() throws Exception {
		
		logger.debug(bundleMarker, "{} starting extraction task", this);
		ImmutableList<String> result = null;
		try {
			checkState(configuredURI!=null, "URI of premises model is not set. Was activate called?");
			
			@SuppressWarnings("unused")
			TrackerPackage pack = TrackerPackage.eINSTANCE;
			ResourceSet resourceSet = new ResourceSetImpl();
			if (!resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().containsKey("premises")) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put("premises", new XMIResourceFactoryImpl());
			}
			

			Resource resource = resourceSet.createResource(configuredURI);
			resource.load(null);
			Premises premises = (Premises) resource.getContents().get(0);
			logger.debug(bundleMarker, "{} loaded premises: {}", this, premises);

			result = ImmutableList.copyOf(
			// Transform a list of animals to records
			Collections2.transform(premises.getAnimals(), transformer));
			send(result);
		} catch (Exception e) {
			logger.error(bundleMarker, this+ "failed extraction.",e);
			throw e;
		}
		
		return result;
	}

	@Override
	public String[] getStatusVariableNames() {
		return STATUS_VARIABLES;
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wires == null ? 0 : wires.length);
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			String uri = (String) config.get(CONNECTION_URI);
			return new StatusVariable(name, StatusVariable.CM_DER, uri);
		} else if (TIME_OF_LAST_UPDATE.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastUpdateTime != 0 ? new Date(lastUpdateTime).toString()
							: "");
		} else if (TOTAL_RECORDS_SENT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					getRecordsSent().size());
		} else if (UPLOAD_EXCEPTION.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					exception != null ? exception.getMessage() : "");
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return "The number of connected consumer wires.";
		} else if (CONNECTION_URI_STATUS_VAR.equals(name)) {
			return "The URI of the Premises model.";
		} else if (TIME_OF_LAST_UPDATE.equals(name)) {
			return "The last time animal life data was sent to a consumer.";
		} else if (TOTAL_RECORDS_SENT.equals(name)) {
			return "The total number of records sent in last update.";
		} else if (UPLOAD_EXCEPTION.equals(name)) {
			return "The last exception encountered while extracting data from the premises model.";
		}
		return null;
	}
	
	private String getPid() {
		return config != null ? (String) config.get(SERVICE_PID) : "null";
	}

	private int refreshSeconds() {
		Object o = config.get(REFRESH_SECONDS);
		int result = 60;
		if(o!=null){
			try {
				result = Integer.parseInt((String)o);
			} catch (NumberFormatException e) {
				logger.warn(bundleMarker,
						"{} failed to parse refresh seconds value={} to integer. Using default of 60 seconds.", this);
			}
		}
		
		return result;
		
		
	}

	private boolean shouldRefresh() {
		if (lastUpdateTime == 0) {
			return true;
		}
		// Has the refresh timeout passed?
		long millsSincelastUpdate = System.currentTimeMillis() - lastUpdateTime;
		long secondsSincelastUpdate = TimeUnit.MILLISECONDS
				.toSeconds(millsSincelastUpdate);
		return secondsSincelastUpdate > refreshSeconds();
	}

	private void send(ImmutableList<String> value) {
		if (wires == null || wires.length == 0) {
			logger.warn(
					bundleMarker,
					"{} defered sending records because there are no connections.",
					this);
		} else if (value.isEmpty()) {
			logger.warn(bundleMarker,
					"{} defered sending because there are no records.", this);
		} else {
			for (Wire wire : wires) {
				wire.update(value);
			}
			lastUpdateTime = System.currentTimeMillis();
		}
	}
	private ImmutableList<String> getRecordsSent() {
		ImmutableList<String> result = null;
		if (futureRecords != null && futureRecords.isDone()) {
			try {
				result = futureRecords.get();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (ExecutionException e) {
				exception = e;
			}
		} else {
			result = ImmutableList.of();
		}
		return result;

	}

	/**
	 * Optional transformer of animal attribute values to output field valus. Each entry contains an 
	 * attribute name, a value to map, and an output value each separated by a | character. To add 
	 * static values to each record use the attribute name STATIC, a integer position, and the static 
	 * value. 
	 * 
	 * For example STATIC|3|HelloWorld will add the text HelloWorld to position 3 in the record. "
     
	 * @author jconlon
	 *
	 */
	private class ValueFunction implements Function<Animal, String> {
		private final static String STATIC ="STATIC"; 
		private final Map<String, Map<String, String>> valueMapper = newHashMap();
		private final Splitter splitter = Splitter.on('|');
		private final List<EAttribute> atts = newLinkedList();
		private final LinkedList<String> tempAnimalResult = newLinkedList();
		private final Joiner joiner = Joiner.on(",").useForNull("");

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "AnimalDataGateway.ValueFunction [pid=" + getPid() + "]";
		}

		/**
		 * 
		 * @param valueTransformer
		 */
		ValueFunction(List<String> valueTransformer) {
			Iterable<String> iterable;
			for (String sequence : valueTransformer) {
				iterable = splitter.split(sequence);
				if (Iterables.size(iterable) != 3) {
					logger.warn(
							bundleMarker,
							"{} wrong number of entries, defered creating map entry {}",
							new Object[] { this, sequence });
					continue;
				}
				String attributeName = Iterables.get(iterable, 0);
				String attributeValue = Iterables.get(iterable, 1);
				String outputValue = Iterables.get(iterable, 2);

				if (!valueMapper.containsKey(attributeName)) {
					valueMapper.put(attributeName,
							new HashMap<String, String>());
				}
				valueMapper.get(attributeName).put(attributeValue, outputValue);

			}
			atts.addAll(Collections2.filter(TrackerPackage.eINSTANCE
					.getAnimal().getEAllAttributes(),
					configuredAttributesPredicate));
			Collections.sort(atts, configuredAttributesComparator);

		}

		@Override
		public String apply(Animal animal) {
			tempAnimalResult.clear();
			for (EAttribute eAttribute : atts) {
				if (!valueMapper.containsKey(eAttribute.getName())) {
					tempAnimalResult
							.add(animal.eGet(eAttribute) != null ? animal.eGet(
									eAttribute).toString() : null);
					continue;
				} else {
					String value = animal.eGet(eAttribute) != null ? animal
							.eGet(eAttribute).toString() : null;
					value = valueMapper.get(eAttribute.getName()).containsKey(
							value) ? valueMapper.get(eAttribute.getName()).get(
							value) : value;
					tempAnimalResult.add(value);
				}
			}
			
			//Are there any STATIC entries?
			if(valueMapper.get(STATIC)!=null){
				SortedMap<Integer, String> sortedStatics = newTreeMap();
				for (Entry<String, String> entry : valueMapper.get(STATIC).entrySet()) {
					try {
						sortedStatics.put( Integer.valueOf(entry.getKey())-1, entry.getValue());
					} catch (NumberFormatException e) {
						logger.warn(bundleMarker, 
								"Failed to parse STATIC transformer entry position="+entry.getKey()+'|'+entry.getValue());
					}
				}
				for (Entry<Integer, String> staticEntry : sortedStatics.entrySet()) {
					tempAnimalResult.add(staticEntry.getKey(), staticEntry.getValue());
				}
			}
			String result = joiner.join(tempAnimalResult);
			
			logger.debug(bundleMarker, "{} created record={}", this, result);
			return result;
		}

	}

	private static class ConfiguredAttributesComparator implements
			Comparator<EAttribute> {
		private final List<String> attributeNames;

		private ConfiguredAttributesComparator(final List<String> attributeNames) {
			this.attributeNames = checkNotNull(attributeNames);
		}

		@Override
		public int compare(EAttribute o1, EAttribute o2) {
			String name1 = o1.getName();
			String name2 = o2.getName();
			int index1 = attributeNames.indexOf(name1);
			int index2 = attributeNames.indexOf(name2);
			if (index1 == index2) {
				return o1.getName().compareTo(o2.getName());
			}
			return index1 > index2 ? 1 : -1;
		}

	}

	private static class ConfiguredAttributesPredicate implements
			Predicate<EAttribute> {
		private final Collection<String> attributeNames;

		private ConfiguredAttributesPredicate(
				final Collection<String> attributeNames) {
			this.attributeNames = checkNotNull(attributeNames);
		}

		public boolean apply(final EAttribute attribute) {
			return attributeNames.contains(attribute.getName());
		}
	}

}
