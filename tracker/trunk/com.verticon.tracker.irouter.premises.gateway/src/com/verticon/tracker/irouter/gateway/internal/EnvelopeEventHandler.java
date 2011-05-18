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
package com.verticon.tracker.irouter.gateway.internal;

import static com.verticon.tracker.irouter.gateway.internal.bundle.LogBundleMarker.bundleMarker;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.framework.Constants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.WeightMeasurementUnit;

/**
 * EventAdmin EventHandler for processes Events coming from the iRouter.
 * iRouter sends information to EventAdmin as Envelopes carried within
 * the pay-load property.  
 * 
 * Envelopes have an identification associated with them
 * which is mapped to the Animal ID and the Envelopes identify 
 * the scope or type of value they carry.
 * 
 * Currently two event scopes are supported:
 *  <ol>
 *  <li>animal.position</li>
 *  <li>animal.weight</li>
 *  </ol>
 */
public class EnvelopeEventHandler implements EventHandler {
	private static final String IROUTER_PAYLOAD ="com.verticon.tracker.irouter.payload";
	private static final String WEIGHIN_EVENT_SCOPE = "animal.weight";
	private static final String TRACKER_EDITING_DOMAIN = 
		"com.verticon.transaction.editor.TrackerEditingDomain";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EnvelopeEventHandler.class);

	public void activate() {
		logger.debug(bundleMarker,"Started");
	}
	
	/**
	 * Get the animal from the event and publish it.
	 */
	public void handleEvent(org.osgi.service.event.Event event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(TRACKER_EDITING_DOMAIN);
		if (domain == null) {
			logger.error(bundleMarker, "Can't find the EditingDomain");
			return;
		}

		handleIRouterPayload(event, domain);

	}

	/**
	 * Processes incoming iRouter payload events
	 * @param event with the payload an OSGi Envelope
	 * @param domain
	 */
	private void handleIRouterPayload(org.osgi.service.event.Event event,
			TransactionalEditingDomain domain) {
		String source = (String) event
				.getProperty(Constants.BUNDLE_SYMBOLICNAME);// EVENT_ADMIN_PROPERTY_SOURCE);
		Object payload = event.getProperty(IROUTER_PAYLOAD);
		if (payload == null) {
			logger.error(bundleMarker, "No payload from iRouter component={}",
					source);
			return;
		}
		if (!(payload instanceof Envelope)) {
			logger.error(bundleMarker,
					"Unsupported payload from iRouter component={} payload={}", source,payload);
			return;
		}
		
		Envelope envelope = (Envelope) payload;
		addEnvelopeToDomain(source, domain, envelope);

	}

	/**
	 * Handle an event
	 * 
	 * @param source
	 * @param domain
	 * @param event
	 * @param id
	 */
	private void addEnvelopeToDomain(String source,
			TransactionalEditingDomain domain,
			Envelope envelope) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		if(resources.isEmpty()){
			logger.warn(bundleMarker,"Can not add {}, because no resources are active.",envelope);
			return;
		}
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				logger.debug(bundleMarker, "Processing {}", resource.toString());
			}
			addEnvelopeToResource(source, domain, resource, envelope);

		}
	}

	private void addEnvelopeToResource(final String source,
			final TransactionalEditingDomain domain, final Resource resource,
			final Envelope envelope) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					String id = getID(envelope);
					Animal animal = premises.findAnimal(id);

					if (animal == null) {
						logger.warn(
								bundleMarker,
								"The Premises in resource {} contained no animal with id = {}",
								resource.toString(), id);
						return;
					}

					Event trackerEvent = null;
					try {
						trackerEvent = createEvent(
								animal.activeTag(), envelope);
					} catch (EventCreationException e) {
						logger.error(bundleMarker, "Failed to create event", e);
						return;
					}
					if (trackerEvent == null) {
						logger.error(bundleMarker,
								"MeasurementTransactionUtils.createEvent returned a null event.");
						return;
					}
					addEventToAnimal(trackerEvent, source, animal);
				} else {
					logger.warn(bundleMarker,
							"Resource {} contained no premises to process",
							resource.toString());
				}
			}

			private String getID(final Envelope envelope) {
				return (String)envelope.getIdentification();
			}
		});

	}

	private void addEventToAnimal(Event event, String source, Animal animal) {
		logger.info(bundleMarker, "{} adding {}, to animal {}, ", new Object[] {
				source, simpleName(event), animal.getId() });
		animal.activeTag().getEvents().add(event);
	}

	private static final String simpleName(Event event) {
		String name = event.getClass().getSimpleName();
		return name.substring(0, name.indexOf("Impl"));
	}
	
	
	private static Event createEvent(Tag tag, Envelope envelope) throws EventCreationException{
		if(WEIGHIN_EVENT_SCOPE.equals(envelope.getScope())){
			return createWeighInEvent(envelope);
		}else if(envelope.getValue() instanceof Position){
			return createPositionEvent((Position)envelope.getValue());
		}
		return createGenericEvent(tag,envelope);
	}

	private static com.verticon.tracker.Position createPositionEvent(Position position) {
		com.verticon.tracker.Position positionEvent = TrackerFactory.eINSTANCE.createPosition();
		positionEvent.setLatitude(degrees(position.getLatitude().getValue()));
		positionEvent.setLongitude(degrees(position.getLongitude().getValue()));
		positionEvent.setDateTime(new Date(position.getLatitude().getTime()));
		positionEvent.setElectronicallyRead(true);
		return positionEvent;
	}
	
	private static final double degrees(double radians) {
		return radians * 360 / (2*Math.PI);
	}

	/**
	 * Create a WeighInEvent from the Transaction
	 * @param envelope
	 * @return
	 * @throws EventCreationException 
	 */
	private static WeighIn createWeighInEvent(Envelope envelope) throws EventCreationException {
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
	 * @param tag
	 * @param envelope
	 * @return GenericEvent
	 * @throws EventCreationException
	 */
	private static GenericEvent createGenericEvent(Tag tag, Envelope envelope) throws EventCreationException{
		if(!(envelope.getValue() instanceof Measurement)){
			throw new EventCreationException("Envelope contained a "+envelope.getValue()+" but it must contain a Measurement");
		}
		Measurement measurement = (Measurement)envelope.getValue();
		if(!canBeIn( tag,envelope)){
			throw new IllegalStateException("Can not create the GenericEvent with "+envelope+" because there is a policy preventing event inclusion on OcdId: "+envelope.getScope());
		}
		GenericEvent geEvent = TrackerFactory.eINSTANCE.createGenericEvent();
		geEvent.setDateTime(new Date(measurement.getTime()));
		//Must have an OCD for this ocdId
		OCD ocd = tag.findOCD(envelope.getScope());
		if(ocd == null){
			throw new EventCreationException("Failed to import "+envelope+" because could not find the OcdId: "+envelope.getScope());
		}
		if(ocd.getAD().size()< 3){
			throw new EventCreationException("Failed to import "+envelope+" because ocd contains only "+ocd.getAD().size()+" attributes" );
		}
		geEvent.setOcd(ocd);
		if(geEvent.getEventAttributes().size()< 3){
			throw new EventCreationException("Failed to import "+envelope+" because genericEvent contains only "+geEvent.getEventAttributes().size()+" attributes" );
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
	 * @param envelope
	 * @return determination
	 */
    private static boolean canBeIn(Tag tag, Envelope envelope){
		if(WEIGHIN_EVENT_SCOPE.equals(envelope.getScope())){
			return tag.canContain(EventType.WEIGH_IN, null);
		}
		return tag.canContain(EventType.GENERIC_EVENT, envelope.getScope());
	}
}
