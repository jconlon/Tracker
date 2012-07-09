package com.verticon.tracker.store.utils;

import static com.google.common.collect.Maps.newHashMap;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import com.verticon.location.Location;
import com.verticon.location.LocationFactory;
import com.verticon.osgi.metatype.DocumentRoot;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.store.ITrackerStore;

public class TrackerStoreUtils {
	static String PLUGIN_ID = "com.verticon.tracker.store.utils";
	/**
	 * slf4j Marker to keep track of bundle
	 */
    public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	private static final ImmutableList<String> REQUIRED_COLUMNS = ImmutableList.of(
		"pin","name","phone","email","street","city","state","zipcode","latitude","longitude");
	private static final String HEADER_ROW_INVALID_MESSAGE = 
			". Header row must contain required columns: pin, name, phone, email, street, city, state, zipCode, latitude, longitude";
	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(TrackerStoreUtils.class);
	
	
	public static int registerPremises(File file, ITrackerStore trackerStore)
			throws IOException {
		int count = 0;
		List<String> lines = null;
		String[] headerRow = null;
		lines = Files.readLines(file, Charsets.UTF_8);
		logger.debug(bundleMarker, "Loading {} premises", lines.size());
		for (String string : lines) {
			if (headerRow == null) {
				headerRow = string.split(",");
				validateHeaderRow(headerRow);
				continue;
			}
			String[] line = string.split(",");
			buildPremises(headerRow, line, trackerStore);
			count++;
			// for (String string2 : splitRegular) {
			//
			// // System.out.print(string2);
			// }
			// System.out.println();
		}

		return count;
	}

	// "Pin""Name""Phone""Email""Street""City""State""zipCode""latitude""longitude"
	public static void validateHeaderRow(String[] headerRow) {
		if(headerRow ==null){
			throw new IllegalStateException(
			"Header row must not be null.");
		}
		if(headerRow.length < 10){
			throw new IllegalStateException(
			"Header row contains only "+headerRow.length+" but it must contain more than 9 columns.");
		}
		for (String requiredColumn : REQUIRED_COLUMNS) {
			boolean hasRequiredColumn=false;
			for (String headerColumn : headerRow) {
				String trimmed = headerColumn.toLowerCase().trim();
				trimmed = trimmed.replace("\"", "");
				if(requiredColumn.equals(trimmed)){
					hasRequiredColumn=true;
					break;
				}
			}
			if(hasRequiredColumn){
				continue;
			}
			logger.error(bundleMarker, "headerRow={}",
					Arrays.toString(headerRow));
			throw new IllegalStateException(
					"Missing columnName "+requiredColumn+HEADER_ROW_INVALID_MESSAGE);
		}
	}
	
	public static void retrieveAndSaveContainedAnimal(String ain,
				ITrackerStore trackerStore, URI uri) throws IOException {
			Animal animal = trackerStore.retrieveAnimal(ain);
			if(animal==null){
				throw new IOException("Could not find animal with ain: "+ain);
			}
			EcoreUtil.resolveAll(animal);
			Animal copiedAnimal = EcoreUtil.copy(animal);
			Premises premises = TrackerFactory.eINSTANCE.createPremises();
			premises.getAnimals().add(copiedAnimal);
			premises.setName("Template");
			premises.setDescription(
					"Container for animal ain="+ain+ " retrieved from trackerStore uri="+ trackerStore.uri()+" on: "+new Date());
			
			ResourceSet resourceSet = new ResourceSetImpl();
			URI parentFolder = uri.trimSegments(1);
			DocumentRoot documentRoot = null;
			MetaData metadata = null;
			Map<String, OCD> ocdMap = null;
			OCD ocd = null;
			OCD ocdCopied = null;
			for (Event event : copiedAnimal.eventHistory()) {
				if(event instanceof GenericEvent ){
					if(ocdMap==null){
						ocdMap=newHashMap();
						documentRoot = MetatypeFactory.eINSTANCE.createDocumentRoot();
						metadata = MetatypeFactory.eINSTANCE.createMetaData();
						documentRoot.setMetaData(metadata);
					}
					 ocd = ((GenericEvent)event).getOcd();
					if(ocdMap.containsKey(ocd.getName())){
						((GenericEvent)event).setOcd(ocdMap.get(ocd.getName()));
					}else{
						//Create an ocd in the parent
						ocdCopied = EcoreUtil.copy(ocd);
						metadata.getOCD().add(ocdCopied);
						((GenericEvent)event).setOcd(ocdCopied);
						ocdMap.put(ocd.getName(), ocdCopied);
					}
				}
			}
			
			if(documentRoot!=null){
			  Resource resource = resourceSet.createResource(parentFolder.appendSegment("imported.metatype"));
			  resource.getContents().add(documentRoot);
			  resource.save(null);
			}
			Resource resource = resourceSet.createResource(uri);
			resource.getContents().add(premises);
			resource.save(null);
		}
	 
	
	public static void retrieveAndImportPremises(String pin,
			ITrackerStore trackerStore, URI uri, String fromDate, String toDate) throws IOException {
		Premises premises = trackerStore.retrievePremises(pin, fromDate, toDate);
		if(premises==null){
			throw new IOException("Could not find premises with pin: "+pin);
		}
		EcoreUtil.resolveAll(premises);
		Premises copiedPremises = EcoreUtil.copy(premises);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		URI parentFolder = uri.trimSegments(1);
		DocumentRoot documentRoot = null;
		MetaData metadata = null;
		Map<String, OCD> ocdMap = null;
		OCD ocd = null;
		OCD ocdCopied = null;
		for (Animal copiedAnimal : copiedPremises.getAnimals()) {


			for (Event event : copiedAnimal.eventHistory()) {
				if(event instanceof GenericEvent ){
					if(ocdMap==null){
						ocdMap=newHashMap();
						documentRoot = MetatypeFactory.eINSTANCE.createDocumentRoot();
						metadata = MetatypeFactory.eINSTANCE.createMetaData();
						documentRoot.setMetaData(metadata);
					}
					ocd = ((GenericEvent)event).getOcd();
					if(ocdMap.containsKey(ocd.getName())){
						((GenericEvent)event).setOcd(ocdMap.get(ocd.getName()));
					}else{
						//Create an ocd in the parent
						ocdCopied = EcoreUtil.copy(ocd);
						metadata.getOCD().add(ocdCopied);
						((GenericEvent)event).setOcd(ocdCopied);
						ocdMap.put(ocd.getName(), ocdCopied);
					}
				}
			}
		}
		
		if(documentRoot!=null){
		  Resource resource = resourceSet.createResource(parentFolder.appendSegment("imported.metatype"));
		  resource.getContents().add(documentRoot);
		  resource.save(null);
		}
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(copiedPremises);
		resource.save(null);
	}

	// "Pin""Name""Phone""Email""Street""City""State""zipCode""latitude""longitude"
	private static void buildPremises(String[] headers, String[] line,
			ITrackerStore trackerStore) {
		if (line == null || line.length == 0) {
			logger.warn(bundleMarker, "blank line skipped");
			return;
		}
		if (headers.length != line.length) {
			logger.error(bundleMarker, "headers={}, line={}",
					Arrays.toString(headers), Arrays.toString(line));
			// assertThat("Must be same size ",headers.length,is(line.length));
			return;
		}
		// assertThat("Must be same size ",headers.length,is(line.length));
		Map<String, String> map = newHashMap();
		for (int i = 0; i < line.length; i++) {
			String key = headers[i].toLowerCase();
			key = key.replace("\"", "");
			String value = line[i];
			value = value.replace("\"", "");
			map.put(key, value);
		}
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		logger.debug(bundleMarker, "Building premises {}", map.get("name"));
		premises.setEmailContact(map.get("email"));
		premises.setName(map.get("name"));
		premises.setPhoneNumber(map.get("phone"));
		premises.setPremisesId(map.get("pin"));
		premises.setUri("urn:pin:" + map.get("pin"));
		Location location = LocationFactory.eINSTANCE.createLocation();
		location.setAltitude(0.0);
		location.setCity(map.get("city"));
		String coor = map.get("latitude");
		location.setLatitude(Double.parseDouble(coor));
		location.setLongitude(Double.parseDouble(map.get("longitude")));
		location.setName(map.get("name"));
		location.setPhoneNumber(map.get("phone"));
		location.setPostalCode(map.get("zipcode"));
		location.setState(map.get("state"));
		location.setStreet(map.get("street"));
		location.setDescription("test");
		premises.setLocation(location);
		try {
			trackerStore.register(premises);
		} catch (Exception e) {
			logger.error(bundleMarker,
					"Failed while building premises " + map.get("name"), e);
		}

	}
}
