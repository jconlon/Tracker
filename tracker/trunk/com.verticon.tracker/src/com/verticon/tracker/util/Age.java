/**
 * 
 */
package com.verticon.tracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * User: IvanLatysh@yahoo.ca Date: 27-May-2004 Time: 6:57:04 PM
 */

public class Age {

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Age){
			return this.startDate.equals(((Age)obj).startDate);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return startDate.hashCode();
	}

	public static final String OLD = "Old";

	public static final String NOT_BORN_YET = "Not Born Yet";

	private final Date startDate;

	private final long timeStamp;

	private int years;

	private int months;

	private int days;

	private String status;

	public Age(Date startDate) {
		this.startDate = startDate;
		this.timeStamp = startDate.getTime();
		calculate();
	}

	public void calculate() {
		Calendar age = Calendar.getInstance(Locale.getDefault());
		age.setTimeInMillis(Math.abs(timeStamp - System.currentTimeMillis()));
		years = age.get(Calendar.YEAR) - 1970;
		months = age.get(Calendar.MONTH);
		days = age.get(Calendar.DAY_OF_MONTH);
		status = System.currentTimeMillis() - timeStamp < 0 ? NOT_BORN_YET
				: OLD;
	}
	
	

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(status==OLD?'+':'-');
		if(years!=0){
			String yearsString = Integer.toString(years);
			buf.append( yearsString.length()==1?"Y0"+yearsString:'Y'+yearsString);
		}
		if(months!=0){
			String monthsString = Integer.toString(months);
			buf.append(  monthsString.length()==1?"M0"+monthsString:'M'+monthsString);
		}
		String daysString = Integer.toString(days);
		buf.append(  daysString.length()==1?"D0"+daysString:'D'+daysString);
		return buf.toString();
	}
	
	
	public String toRoundedString() {
		if(years!=0){
			String yearsString = Integer.toString(years);
			return yearsString.length()==1?"Y0"+yearsString:'Y'+yearsString;
		}else if(months!=0){
			String monthsString = Integer.toString(months);
			return monthsString.length()==1?"M0"+monthsString:'M'+monthsString;
		}
		String daysString = Integer.toString(days);
		return daysString.length()==1?"D0"+daysString:'D'+daysString;
	}

	public static void main(String[] args) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		if (args.length == 0) {
			System.out
					.println("Usage:\n java Age dd/mm/yyyy\nWhere:\n dd - date\n mm - month\n yyyy - year");
		} else {
			try {
				final Date birthday = dateFormatter.parse(args[0]);
				System.out.println("Your birthday is "
						+ dateFormatter.format(birthday));
				final Age myAge = new Age(birthday);
				System.out.println("Your are " + myAge.getYears() + " years, "
						+ myAge.getMonths() + " month, " + myAge.getDays()
						+ " days " + myAge.getStatus() + ".");
				
				System.out.println("Standard format: "+myAge.toString());
				System.out.println("Rounded format: "+myAge.toRoundedString());
				

			} catch (ParseException e) {
				System.out.println("Error parsing your birthday.");
				e.printStackTrace();
			}
		}
	}

	public int getDays() {
		return days;
	}

	public int getMonths() {
		return months;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getStatus() {
		return status;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public int getYears() {
		return years;
	}

}