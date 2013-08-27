package com.verticon.tracker.store;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
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
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;
import com.verticon.tracker.util.TrackerUtils;

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
	
	
	public static int registerPremises(File file, ITrackerUpdate trackerStore)
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
	public static Animal dynamicallyImportAnimal(String tagNumber, Premises premises) throws IOException{
		Animal animal = TrackerPlugin.getDefault().getAnimal(tagNumber);
		Animal result = null;
		if(animal!=null){
			createNewMetatypesIfNeeded( animal,  premises);
			EcoreUtil.resolveAll(animal);
			result = EcoreUtil.copy(animal);
			//This animal may have generic events
			for (Event event : result.eventHistory()) {
				if(event instanceof GenericEvent ){
					OCD ocd = findOCD(((GenericEvent)event).getOcd().getID(), premises);
					if(ocd==null){
						throw new IllegalStateException("There should be a newly created OCD in the dynamically imported metatype.");
					}
					//OCD must already exist in the ResourceSet
					((GenericEvent)event).setOcd(ocd);
					
				}
			}
			premises.getAnimals().add(result);

		}
		return result;
	}
	
	private static OCD findOCD(String ocdId, Premises premises){
		OCD result = null;
		for (OCD ocd : TrackerUtils.findOCDs(premises)) {
			if(ocd.getID()==ocdId){
				result = ocd;
				break;
			}
		}
		return result;
	}
	
	private static void createNewMetatypesIfNeeded(Animal animal, Premises premises) throws IOException{
		ResourceSet resourceSet = premises.eResource().getResourceSet();
		URI parentFolder = premises.eResource().getURI().trimSegments(1);
		DocumentRoot documentRoot = null;
		MetaData metadata = null;
		Map<String, OCD> ocdMap = null;
		OCD ocd = null;
		OCD ocdCopied = null;
		for (Event event : animal.eventHistory()) {
			if(event instanceof GenericEvent ){
				ocd = ((GenericEvent)event).getOcd();
				if(findOCD(ocd.getID(), premises)!=null){
					continue;//Found it
				}
				if(ocdMap==null){
					ocdMap=newHashMap();
					documentRoot = MetatypeFactory.eINSTANCE.createDocumentRoot();
					metadata = MetatypeFactory.eINSTANCE.createMetaData();
					documentRoot.setMetaData(metadata);
				}

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
		  String out = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss'.metatype'").format(new Date());
		  Resource resource = resourceSet.createResource(parentFolder.appendSegment(out));
		  resource.getContents().add(documentRoot);
		  resource.save(null);
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
			ITrackerFind trackerStore, URI uri, String fromDate, String toDate) throws IOException {
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
			ITrackerUpdate trackerStore) throws IOException {
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
		} catch (IOException e) {
			logger.error(bundleMarker,
					"Failed to register premises " + map.get("name"), e);
			throw e;
		}

	}

	public static void validateObject(EObject eObject) throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					throw new ValidationException(eObject,
							childDiagnostic.getMessage());
				}
			}
	
		}
	
	}

	public static Integer getConfigurationInteger(Object o) {
		Integer result = null;
		if(o instanceof Integer){
			result = (Integer) o;
		}else if (o instanceof String){
			result = Integer.parseInt((String) o);
		}
		return result;
	}

	public static EClass getAnimalEClass(Integer key) {
		switch (key) {
		case TrackerPackage.BOVINE_BEEF:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.BOVINE_BISON:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.BOVINE_DAIRY:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.CAPRINE:
			return TrackerPackage.eINSTANCE.getBovineBeef();
		case TrackerPackage.EQUINE:
			return TrackerPackage.eINSTANCE.getEquine();
		case TrackerPackage.OVINE:
			return TrackerPackage.eINSTANCE.getOvine();
		case TrackerPackage.SWINE:
			return TrackerPackage.eINSTANCE.getSwine();
		default:
			throw new IllegalArgumentException("unknown animal id: " + key);
		}
	
	}

	/**
	 * Pass only animals with new events after the update date and the PID is
	 * empty
	 * 
	 * @author jconlon
	 * 
	 */
	public static class AnimalsWithNewAndUnpublishedEvents implements
			Predicate<Animal> {
		private final Date update;

		public AnimalsWithNewAndUnpublishedEvents(Date update) {
			super();
			this.update = update;
		}

		@Override
		public boolean apply(Animal animal) {

			return (update == null || animal.getLastEventDateTime().after(
					update));
		}
	}

	public static final Optional<Animal> getAnimal(byte[] payload)
			throws IOException {
		if (payload.length != 0) {
			List<EObject> eos = toEObject(payload);
			if (eos.size() == 1) {
				if (eos.get(0) instanceof Animal) {
					return Optional.of((Animal) eos.get(0));
				}
			}
		}
		return Optional.absent();
	}

	public static final byte[] toPayload(EObject eObject) throws IOException {
		Resource resource = new BinaryResourceImpl();
		resource.getContents().add(eObject);
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		resource.save(ba, null);
		return ba.toByteArray();
	}

	public static final byte[] toPayload(Collection<? extends EObject> eObjects)
			throws IOException {
		Resource resource = new BinaryResourceImpl();
		resource.getContents().addAll(eObjects);
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		resource.save(ba, null);
		return ba.toByteArray();
	}


	public static final List<EObject> toEObject(byte[] payload)
			throws IOException {
		checkNotNull(payload);
		checkArgument(payload.length > 0,
				"Payload must be greater than 0 bytes");
		ByteArrayInputStream ba = new ByteArrayInputStream(payload);
		Resource resource = new BinaryResourceImpl();
		File f = File.createTempFile("emf", ".binary");
		resource.setURI(URI.createFileURI(f.toString()));
		resource.load(ba, null);
		return resource.getContents();
	}

	public static final Premises toPremises(Object object) throws IOException {
		checkArgument((object instanceof byte[]), "Payload must be a byte[]");
		byte[] payload = (byte[]) object;
		List<EObject> eol = toEObject(payload);
		if (eol == null || eol.isEmpty()) {
			return null;
		}
		// if (eol.size() != 1) {
		// throw new IOException(
		// "There must be only one EObject in the payload. Found "
		// + eol.size() + " objects.");
		// }

		if (eol.get(0) instanceof Premises) {
			return (Premises) eol.get(0);
		}
		throw new IOException(
				"There must be only an EObject in the payload. Found a "
						+ eol.get(0).getClass().getName() + " object instead.");

	}
	
	public static String mapToJSON(Map<String, String> map) {
		return mapToJSon.apply(map);
	}

	public static Map<String, String> jSONToMap(String json) {
		return jsonToMap.apply(json);
	}

	private static JSONToMap jsonToMap = new JSONToMap();
	private static MapToJSON mapToJSon = new MapToJSON();

	private static class MapToJSON implements
			Function<Map<String, String>, String> {
		
		@Override
		public String apply(Map<String, String> map) {
			StringBuilder result = new StringBuilder();
			result.append('{');
			for (Entry<String, String> entry : map.entrySet()) {
				result.append("'").append(entry.getKey()).append("' : '")
						.append(entry.getValue()).append("',");
			}
			result.replace(result.length() - 1, result.length(), "}");

			return result.toString();
		}
	}

	private static class JSONToMap implements
			Function<String, Map<String, String>> {
		@Override
		public Map<String, String> apply(String string) {
			String json = string.replace("{", "").replace("}", "");
			Iterable<String> ss = Splitter.on(',').trimResults()
					.omitEmptyStrings().split(json);
			Map<String, String> result = newHashMap();
			String key, value;
			for (String string2 : ss) {
				// TODO use a reg expression to parse something like:
				// 'urn:pin:H89234X' : 'East Farm'
				Iterable<String> s = Splitter.on("' : '").trimResults()
						.omitEmptyStrings().split(string2);
				key = Iterables.get(s, 0).replace("'", "");
				value = Iterables.get(s, 1).replace("'", "");
				result.put(key, value);
			}

			return result;
		}
	}

	public static Animal createDefaultAnimal(Integer key) {
		switch (key) {
		case TrackerPackage.BOVINE_BEEF:
			return TrackerFactory.eINSTANCE.createBovineBeef();
		case TrackerPackage.BOVINE_BISON:
			return TrackerFactory.eINSTANCE.createBovineBison();
		case TrackerPackage.BOVINE_DAIRY:
			return TrackerFactory.eINSTANCE.createBovineDairy();
		case TrackerPackage.CAPRINE:
			return TrackerFactory.eINSTANCE.createCaprine();
		case TrackerPackage.EQUINE:
			return TrackerFactory.eINSTANCE.createEquine();
		case TrackerPackage.OVINE:
			return TrackerFactory.eINSTANCE.createOvine();
		case TrackerPackage.SWINE:
			return TrackerFactory.eINSTANCE.createSwine();
		default:
			throw new IllegalArgumentException("unknown animal id: " + key);
		}
	
	}
}
