package com.verticon.tracker.irouter.premises.common.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.WeightMeasurementUnit;
import com.verticon.tracker.store.IOCDFind;
import com.verticon.tracker.store.IOCDFinder;

public class PremisesIRouterUtils {
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.premises.common";
	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PremisesIRouterUtils.class);
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}


	public static final String WEIGHIN_EVENT_SCOPE = "animal.weight";

	public static com.verticon.tracker.Position createPositionEvent(Position position) {
		com.verticon.tracker.Position positionEvent = TrackerFactory.eINSTANCE.createPosition();
		positionEvent.setLatitude(degrees(position.getLatitude().getValue()));
		positionEvent.setLongitude(degrees(position.getLongitude().getValue()));
		positionEvent.setDateTime(new Date(position.getLatitude().getTime()));
		positionEvent.setElectronicallyRead(true);
		return positionEvent;
	}

	public static final double degrees(double radians) {
		return radians * 360 / (2*Math.PI);
	}

	/**
	 * Create a WeighInEvent from the Envelope
	 * @param envelope
	 * @return WeighIn event
	 * @throws EventCreationException 
	 */
	public static WeighIn createWeighInEvent(Envelope envelope) throws EventCreationException {
		if(!(envelope.getValue() instanceof Measurement)){
			throw new EventCreationException("Envelope contained a "+envelope.getValue()+" but it must contain a Measurement");
		}
		Measurement measurement = (Measurement)envelope.getValue();
		WeighIn weighIn = TrackerFactory.eINSTANCE.createWeighIn();
		
		weighIn.setUnit(measurement.getUnit()==Unit.kg?
				WeightMeasurementUnit.KILOGRAM:WeightMeasurementUnit.POUND);
		weighIn.setWeight(measurement.getValue());
		weighIn.setDateTime(new Date(measurement.getTime()));
		return weighIn;
	}

	/**
	 * Create a GenericEvent from the transaction
	 * 
	 * @deprecated
	 * @param envelope
	 * @return GenericEvent
	 * @throws EventCreationException
	 */
	@Deprecated
	public static GenericEvent createGenericEventFromMeasurementEnvelope(IOCDFinder ocdFinder, Envelope envelope) throws EventCreationException{
		if(!(envelope.getValue() instanceof Measurement)){
			throw new EventCreationException("Envelope contained a "+envelope.getValue()+" but it must contain a Measurement");
		}
		Measurement measurement = (Measurement)envelope.getValue();
		
		
		//Must have an OCD for this ocdId
		OCD ocd = ocdFinder.find();
		if(ocd == null){
			throw new EventCreationException("Failed to import "+envelope+" because could not find the OcdId: "+envelope.getScope());
		}
		if(ocd.getAD().size()< 3){
			throw new EventCreationException("Failed to import "+envelope+" because ocd contains only "+ocd.getAD().size()+" attributes" );
		}
		
		return createGenericEvent( measurement, ocd);
	}
	
	public static GenericEvent createGenericEventFromMeasurementEnvelope(
			IOCDFind ocdFinder, Envelope envelope)
			throws EventCreationException {
		if (!(envelope.getValue() instanceof Measurement)) {
			throw new EventCreationException("Envelope contained a "
					+ envelope.getValue()
					+ " but it must contain a Measurement");
		}
		Measurement measurement = (Measurement) envelope.getValue();

		// Must have an OCD for this ocdId
		OCD ocd = ocdFinder.find(envelope.getScope());
		if (ocd == null) {
			throw new EventCreationException("Failed to import " + envelope
					+ " because could not find the OcdId: "
					+ envelope.getScope());
		}
		if (ocd.getAD().size() < 3) {
			throw new EventCreationException("Failed to import " + envelope
					+ " because ocd contains only " + ocd.getAD().size()
					+ " attributes");
		}

		return createGenericEvent(measurement, ocd);
	}
	
	

	private static GenericEvent createGenericEvent(
			Measurement measurement, OCD ocd) throws EventCreationException {
		GenericEvent geEvent = TrackerFactory.eINSTANCE.createGenericEvent();
		geEvent.setDateTime(new Date(measurement.getTime()));
		geEvent.setOcd(ocd);
		if(geEvent.getEventAttributes().size()< 3){
			throw new EventCreationException("Failed to import "+measurement+" because genericEvent contains only "+geEvent.getEventAttributes().size()+" attributes" );
		}
		
		
		//Need to set event attributes on all keys unit, value; error;
		boolean valueFound = false, unitFound = false, errorFound = false;
		
		for (AD attributeDefinition : ocd.getAD()) {
			if(attributeDefinition.getID().equals("value")){
				valueFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(measurement.getValue()));
			}else if(attributeDefinition.getID().equals("error")){
				errorFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(measurement.getError()));
			}else if(attributeDefinition.getID().equals("unit")){
				unitFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						"kilogram");
			}
		}
		
		if(valueFound && unitFound && errorFound){
			return geEvent;
		}
		
		throw new IllegalStateException("Could not set genericEvent attributes: "+
				"valueFound = "+valueFound+", unitFound = "+unitFound+", errorFound = "+errorFound);
	}

	/**
	 * Does the policy allow the created event to be associated
	 * with the animals tag
	 * 
	 * @param tag
	 * @param scope
	 * @return determination
	 */
   public static boolean canBeIn(Tag tag, String scope){
		if(WEIGHIN_EVENT_SCOPE.equals(scope)){
			return tag.canContain(EventType.WEIGH_IN, null);
		}
		return tag.canContain(EventType.GENERIC_EVENT, scope);
	}

	/**
	 * Can create three types of events WeighIn, Position, GenericEvent
	 * 
	 * @deprecated
	 * @param ocdFinder
	 * @param envelope
	 * @return Event
	 * @throws EventCreationException
	 */
	@Deprecated
	public static Event createEvent(IOCDFinder ocdFinder, Envelope envelope)
			throws EventCreationException {
		if(WEIGHIN_EVENT_SCOPE.equals(envelope.getScope())){
			return createWeighInEvent(envelope);
		}else if(envelope.getValue() instanceof Position){
			return createPositionEvent((Position)envelope.getValue());
		}else if(envelope.getValue() instanceof Measurement){
		  return createGenericEventFromMeasurementEnvelope(
				  ocdFinder,
				  envelope
				  );
		}else{
			return null;
		}
	}
	
	public static Event createEvent(IOCDFind ocdFind, Envelope envelope)
			throws EventCreationException {
		if (WEIGHIN_EVENT_SCOPE.equals(envelope.getScope())) {
			return createWeighInEvent(envelope);
		} else if (envelope.getValue() instanceof Position) {
			return createPositionEvent((Position) envelope.getValue());
		} else if (envelope.getValue() instanceof Measurement) {
			return createGenericEventFromMeasurementEnvelope(ocdFind, envelope);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param envelopes
	 * @param id
	 * @return List of Envelope
	 */
	public static List<Envelope> prepareEnvelopesForOutput(Collection<Envelope> envelopes, Long id) {
		List<Envelope> results = new ArrayList<Envelope>();

		for (Envelope envelope : envelopes) {
			if ((envelope.getValue() instanceof Measurement)
					|| (envelope.getValue() instanceof Position)) {
				if (envelope.getIdentification() instanceof String
						&& ((String) envelope.getIdentification()).trim()
								.length() > 1 && !envelope.getScope().startsWith("raw.")) {
					results.add(envelope);
				} else if (id != null) {
					results.add(stripPrefixAndAddId(envelope, id));
				} else {
					logger.warn(
							bundleMarker,
							"Deferred adding {} because the id was not set in this gateway or in the measurements envelope.",
							envelope);
				}
			}
		}
		Collections.sort(results, ENVELOPE_DATE_ORDER2);
		return results;
	}
	
	public static Resource getXMIResource(String uriString) {
		URI uri = URI.createURI(uriString, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	private static final Comparator<Envelope> ENVELOPE_DATE_ORDER2 = new Comparator<Envelope>() {
		@Override
		public int compare(Envelope e1, Envelope e2) {
			if (getTime(e1) < getTime(e2)) {
				return -1;// returning a negative integer, first argument is
							// less than second
			} else if (getTime(e1) == getTime(e2)) {
				return 0;// 0, equal to, or
			}
			return 1; // a positive integer depending on whether the , greater
						// than the second.
		}

		long getTime(Envelope e) {
			long result = 0;
			if (e.getValue() instanceof Position
					&& ((Position) e.getValue()).getLatitude() != null) {
				result = ((Position) e.getValue()).getLatitude().getTime();
			} else if (e.getValue() instanceof Measurement) {
				result = ((Measurement) e.getValue()).getTime();
			}
			return result;
		}
	};
	
	private static Envelope stripPrefixAndAddId(Envelope envelope, Long id) {
		String scope = envelope.getScope();
		if(scope.startsWith("raw.")){
			scope= scope.substring(4);
		}
		
		return new BasicEnvelope(envelope.getValue(), id.toString(),
				scope);
	}
	
	

}
