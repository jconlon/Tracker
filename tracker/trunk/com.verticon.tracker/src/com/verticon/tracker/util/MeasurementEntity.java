package com.verticon.tracker.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

/**
 * An OSGi Measurement with a scope and an id.
 * @author jconlon
 *
 */
public class MeasurementEntity extends Measurement{
	
//	private static final int UNIT = 8;
	private static final int ERROR = 7;
	private static final int VALUE = 5;
	private static final int SCOPE = 4;
	private static final int TAG = 3;
	private static final int DATE_TIME = 2;
	private final String scope;
	private final String id;
	
	private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private final static String REGEX=".*type='(.*)',dateTime='(.*)',id='(\\d{15})',scope='(.*)',value='(\\d+(\\.\\d+)?)',error='(.*)',unit='(kg|pound)'";
	public final static Pattern PATTERN = Pattern.compile(REGEX);
	
	
	private MeasurementEntity(double value, double error, Unit unit, long time, String scope, String tag) {
		super(value, error, unit, time);
		this.scope=scope;
		this.id=tag;
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
			throw new ParseException(log+" failed to parse.", 0);
		}

		Date date = (Date)DATE_FORMAT.parse(matcher.group(DATE_TIME));
		long time =date.getTime();
	    String tag = matcher.group(TAG);
	    String scope = matcher.group(SCOPE);
	    double value = Double.parseDouble(matcher.group(VALUE));
	    double error =  Double.parseDouble(matcher.group(ERROR));
		return new MeasurementEntity(value, error, Unit.kg, time, scope, tag);
	}

	public String getScope() {
		return scope;
	}

	public String getId() {
		return id;
	}

}
