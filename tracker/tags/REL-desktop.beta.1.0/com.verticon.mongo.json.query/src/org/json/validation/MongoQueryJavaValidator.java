package org.json.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.xtext.validation.Check;
import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.MongoQueryPackage;


 

public class MongoQueryJavaValidator extends AbstractMongoQueryJavaValidator {

	public static final String FIELD_SELECTION_ERROR = "Field selection must be either a '0' or a '1'";
	public static final String JSON_MONTH_ERROR = "Month must be an integer value representing the month, beginning with 0 for January to 11 for December.";
	public static final String JSON_DAY_ERROR = "Day must be an integer value representing the day of the month (1-31).";
	public static final String JSON_HOUR_ERROR = "Hour must be an integer value representing the hour of the day (0-23).";
	public static final String JSON_MINUTE_ERROR = "Minute must be an integer value representing the minute segment (0-59) of a time reading.";
	public static final String JSON_SECOND_ERROR = "Second must be an integer value representing the second segment (0-59) of a time reading.";
	public static final String JSON_MILLISECOND_ERROR = "Millisecond must be an integer value representing the millisecond segment (0-999) of a time reading.";
	
	
	public static final String DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);
	
	
	@Check
	public void checkSelectionEnabledIsZeroOrOne(FieldSelection selection) {
		
		
		if (selection.getEnabled()==0 | selection.getEnabled()==1 ) {
			//good
		}else{
			error(FIELD_SELECTION_ERROR, MongoQueryPackage.Literals.FIELD_SELECTION__ENABLED);
		}
	}
	
	@Check
	public void checkDate(JsonDate date) {

		if (date.getDateString()!=null) {
			try {
				DATE_FORMAT.parse(date.getDateString());
			} catch (ParseException e) {
				error(e.getMessage(), MongoQueryPackage.Literals.JSON_DATE__DATE_STRING);
			}

		}else{
			if (date.getMonth()<0 | date.getMonth()>11){
				error(JSON_MONTH_ERROR, MongoQueryPackage.Literals.JSON_DATE__MONTH);
			}
			
			if (date.getDay()<0 | date.getDay()>31){
				error(JSON_DAY_ERROR, MongoQueryPackage.Literals.JSON_DATE__DAY);
			}
			
			if (date.getHour()<0 | date.getHour()>31){
				error(JSON_HOUR_ERROR, MongoQueryPackage.Literals.JSON_DATE__HOUR);
			}
			
			if (date.getMinute()<0 | date.getMinute()>59){
				error(JSON_SECOND_ERROR, MongoQueryPackage.Literals.JSON_DATE__MINUTE);
			}
			
			if (date.getSecond()<0 | date.getSecond()>59){
				error(JSON_SECOND_ERROR, MongoQueryPackage.Literals.JSON_DATE__SECOND);
			}
			
			if (date.getMillisecond()<0 | date.getMillisecond()>999){
				error(JSON_MILLISECOND_ERROR, MongoQueryPackage.Literals.JSON_DATE__MILLISECOND);
			}

		}
	}

	
}
