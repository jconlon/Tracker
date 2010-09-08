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

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.util.measurement.Unit;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.WeightMeasurementUnit;
import com.verticon.tracker.common.MeasurementTransaction;
import com.verticon.tracker.util.TrackerConstants;

/**
 * An OSGi Measurement with a scope and an id.
 * @author jconlon
 *
 */
public class MeasurementTransactionUtils {
	
    static final int UNIT = 7;
    static final int ERROR = 6;
    static final int VALUE = 5;
    static final int SCOPE = 4;
    static final int ID = 3;
    static final int DATE_TIME = 2;
    static final int TYPE = 1;
    static final String WEIGHIN_EVENT_SCOPE = "animal.weight.measurement";
	private final static String REGEX=".*type='(.*)',dateTime='(.*)',id='(\\S*)',scope='(.*)',value='(.*)',error='(.*)',unit='(kg|pound)'";
    final static Pattern PATTERN = Pattern.compile(REGEX);
	
	/**
	 * Create a new Measurement Transaction by parsing a log entry that looks like:
	 * 2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='null',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'
	 * 
	 * @param log entry to parse
	 * @return MeasurementTransaction
	 * @throws ParseException 
	 */
	public static MeasurementTransaction newInstance(String log) throws ParseException{
		Matcher matcher = PATTERN.matcher(log);
		if (!matcher.matches()){
			throw new ParseException(log+" failed to parse.", 0);
		}

		Date date;
		try {
			date = (Date)TrackerConstants.DATE_FORMAT.parse(matcher.group(DATE_TIME));
		} catch (ParseException e) {
			throw new ParseException(log+" failed to parse dateTime.", DATE_TIME);
		}
		long time =date.getTime();
		
		
	    String tag = matcher.group(ID);
	    if(!tag.matches("\\d{15}")){
	    	throw new ParseException(log+" failed to parse id.", ID);
	    }
	    
	    String scope = matcher.group(SCOPE);
	    if(!tag.matches("\\d{15}")){
	    	throw new ParseException("Log Entry=<"+log+"> failed to parse scope.", SCOPE);
	    }
	    
	    double value;
		try {
			value = Double.parseDouble(matcher.group(VALUE));
		} catch (NumberFormatException e) {
			throw new ParseException(log+" failed to parse value.", VALUE);
		}
		
	    double error;
		try {
			error = Double.parseDouble(matcher.group(ERROR));
		} catch (NumberFormatException e) {
			throw new ParseException(log+" failed to parse error.", ERROR);
		}
		
		
		return new MeasurementTransaction(value, error, Unit.kg, time, scope, tag);
	}

	/**
	 * Does the policy allow the created event to be associated
	 * with the animals tag
	 * 
	 * @param tag
	 * @param transaction
	 * @return determination
	 */
    public static boolean canBeIn(Tag tag, MeasurementTransaction transaction){
		if(WEIGHIN_EVENT_SCOPE.equals(transaction.getScope())){
			return tag.canContain(EventType.WEIGH_IN, null);
		}
		return tag.canContain(EventType.GENERIC_EVENT, transaction.getScope());
	}
	
	
	/**
	 * Create a Tracker Event from the Transaction
	 * 
	 * @param tag
	 * @param transaction
	 * @return Event
	 * @throws EventCreationException
	 */
	public static Event createEvent(Tag tag, MeasurementTransaction transaction) throws EventCreationException{
		if(WEIGHIN_EVENT_SCOPE.equals(transaction.getScope())){
			
			return createWeighInEvent(transaction);
		}
		return createGenericEvent(tag,transaction);
	}


	/**
	 * Create a GenericEvent from the transaction
	 * 
	 * @param tag
	 * @param transaction
	 * @return GenericEvent
	 * @throws EventCreationException
	 */
	private static GenericEvent createGenericEvent(Tag tag, MeasurementTransaction transaction) throws EventCreationException{
		if(!canBeIn( tag,transaction)){
			throw new IllegalStateException("Can not create the GenericEvent with "+transaction+" because there is a policy preventing event inclusion on OcdId: "+transaction.getScope());
		}
		GenericEvent geEvent = TrackerFactory.eINSTANCE.createGenericEvent();
		geEvent.setDateTime(new Date(transaction.getTime()));
		//Must have an OCD for this ocdId
		OCD ocd = tag.findOCD(transaction.getScope());
		if(ocd == null){
			throw new IllegalStateException("Failed to import "+transaction+" because could not find the OcdId: "+transaction.getScope());
		}
		if(ocd.getAD().size()< 3){
			throw new IllegalStateException("Failed to import "+transaction+" because ocd contains only "+ocd.getAD().size()+" attributes" );
		}
		geEvent.setOcd(ocd);
		if(geEvent.getEventAttributes().size()< 3){
			throw new EventCreationException("Failed to import "+transaction+" because genericEvent contains only "+geEvent.getEventAttributes().size()+" attributes" );
		}
		
		
		//Need to set event attributes on all keys unit, value; error;
		boolean valueFound = false, unitFound = false, errorFound = false;
		
		for (AD attributeDefinition : ocd.getAD()) {
			if(attributeDefinition.getID().equals("value")){
				valueFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(transaction.getValue()));
			}else if(attributeDefinition.getID().equals("error")){
				errorFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(transaction.getError()));
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
	 * Create a WeighInEvent from the Transaction
	 * @param transaction
	 * @return
	 */
	private static WeighIn createWeighInEvent(MeasurementTransaction transaction) {
		WeighIn weighIn = TrackerFactory.eINSTANCE.createWeighIn();
		weighIn.setUnit(WeightMeasurementUnit.KILOGRAM);
		weighIn.setWeight(transaction.getValue());
		weighIn.setDateTime(new Date(transaction.getTime()));
		return weighIn;
	}
}


