package com.verticon.tracker.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.util.measurement.Measurement;
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

/**
 * An OSGi Measurement with a scope and an id.
 * @author jconlon
 *
 */
public class MeasurementEntity extends Measurement{
	public static final int UNIT = 7;
	public static final int ERROR = 6;
	public static final int VALUE = 5;
	public static final int SCOPE = 4;
	public static final int ID = 3;
	public static final int DATE_TIME = 2;
	public static final int TYPE = 1;
	public static final String WEIGHIN_EVENT_SCOPE = "animal.weight.measurement";
	private final String scope;
	private final String id;
	
    public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private final static String REGEX=".*type='(.*)',dateTime='(.*)',id='(\\S*)',scope='(.*)',value='(.*)',error='(.*)',unit='(kg|pound)'";
	public final static Pattern PATTERN = Pattern.compile(REGEX);
	
	/**
	 * Use the static factory method to instantiate.
	 * @param value
	 * @param error
	 * @param unit
	 * @param time
	 * @param scope
	 * @param id
	 */
	private MeasurementEntity(double value, double error, Unit unit, long time, String scope, String id) {
		super(value, error, unit, time);
		this.scope=scope;
		this.id=id;
	}

	
	@Override
	public String toString() {
		return "MeasurementEntity [id=" + id + ", scope=" + scope +", value=" + getValue() + "]";
	}


	/**
	 * 2010-03-12 12:07:42,type='measurement',dateTime='2010-03-12 12:07:42',id='null',scope='animal.weight.measurement',value='133.0000',error='0.0100',unit='kg'
	 * @param log
	 * @return MeasurementEntity
	 * @throws ParseException 
	 */
	public static MeasurementEntity newInstance(String log) throws ParseException{
		Matcher matcher = PATTERN.matcher(log);
		if (!matcher.matches()){
			throw new ParseException("Log Entry=<"+log+"> failed to parse.", 0);
		}

		Date date;
		try {
			date = (Date)DATE_FORMAT.parse(matcher.group(DATE_TIME));
		} catch (ParseException e) {
			throw new ParseException("Log Entry=<"+log+"> failed to parse dateTime.", DATE_TIME);
		}
		long time =date.getTime();
		
		
	    String tag = matcher.group(ID);
	    if(!tag.matches("\\d{15}")){
	    	throw new ParseException("Log Entry=<"+log+"> failed to parse id.", ID);
	    }
	    
	    String scope = matcher.group(SCOPE);
	    if(!tag.matches("\\d{15}")){
	    	throw new ParseException("Log Entry=<"+log+"> failed to parse scope.", SCOPE);
	    }
	    
	    double value;
		try {
			value = Double.parseDouble(matcher.group(VALUE));
		} catch (NumberFormatException e) {
			throw new ParseException("Log Entry=<"+log+"> failed to parse value.", VALUE);
		}
		
	    double error;
		try {
			error = Double.parseDouble(matcher.group(ERROR));
		} catch (NumberFormatException e) {
			throw new ParseException("Log Entry=<"+log+"> failed to parse error.", ERROR);
		}
		
		
		return new MeasurementEntity(value, error, Unit.kg, time, scope, tag);
	}

	public String getScope() {
		return scope;
	}

	public String getId() {
		return id;
	}

	public boolean canBeIn(Tag tag){
		if(WEIGHIN_EVENT_SCOPE.equals(scope)){
			return tag.canContain(EventType.WEIGH_IN, null);
		}
		return tag.canContain(EventType.GENERIC_EVENT, scope);
	}
	
	
	
	public Event createEvent(Tag tag) throws EventCreationException{
		if(WEIGHIN_EVENT_SCOPE.equals(scope)){
			
			return createWeighInEvent();
		}
		return createGenericEvent(tag);
	}


	public GenericEvent createGenericEvent(Tag tag) throws EventCreationException{
		if(!canBeIn( tag)){
			throw new IllegalStateException("Can not create the GenericEvent with "+this+" because there is a policy preventing event inclusion on OcdId: "+scope);
		}
		GenericEvent geEvent = TrackerFactory.eINSTANCE.createGenericEvent();
		geEvent.setDateTime(new Date(getTime()));
		//Must have an OCD for this ocdId
		OCD ocd = tag.findOCD(scope);
		if(ocd == null){
			throw new IllegalStateException("Failed to import "+this+" because could not find the OcdId: "+scope);
		}
		if(ocd.getAD().size()< 3){
			throw new IllegalStateException("Failed to import "+this+" because ocd contains only "+ocd.getAD().size()+" attributes" );
		}
		geEvent.setOcd(ocd);
		if(geEvent.getEventAttributes().size()< 3){
			throw new EventCreationException("Failed to import "+this+" because genericEvent contains only "+geEvent.getEventAttributes().size()+" attributes" );
		}
		
		
		//Need to set event attributes on all keys unit, value; error;
		boolean valueFound = false, unitFound = false, errorFound = false;
		
		for (AD attributeDefinition : ocd.getAD()) {
			if(attributeDefinition.getID().equals("value")){
				valueFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(getValue()));
			}else if(attributeDefinition.getID().equals("error")){
				errorFound = true;
				geEvent.getEventAttributes().put(
						attributeDefinition.getName(),
						Double.toString(getError()));
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


	private WeighIn createWeighInEvent() {
		WeighIn weighIn = TrackerFactory.eINSTANCE.createWeighIn();
		weighIn.setUnit(WeightMeasurementUnit.KILOGRAM);
		weighIn.setWeight(getValue());
		weighIn.setDateTime(new Date(getTime()));
		return weighIn;
	}
	
	public class EventCreationException extends Exception{
		private static final long serialVersionUID = 1L;
		EventCreationException(String message) {
			super(message);
		}
	}
}


