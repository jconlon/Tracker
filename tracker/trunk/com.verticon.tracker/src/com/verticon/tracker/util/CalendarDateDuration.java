/**
 * 
 */
package com.verticon.tracker.util;

import java.text.NumberFormat;

import net.sourceforge.calendardate.CalendarDate;

/**
 * Immutable Data Container that specifies the time between two
 * CalendarDate objects.
 * 
 * @author jconlon
 *
 */
public class CalendarDateDuration {
	private final int totalDays;
	private final int totalMonths;
	private final int totalYears;
	private final int monthsPart;
	private final int daysPart;
	private final Type type;
	
	
	public enum Type{FUTURE,PAST}
	
	
	public CalendarDateDuration(CalendarDate date1, CalendarDate date2){
		CalendarDate startDate;
		CalendarDate finishDate;
		
		if(date1.isBefore(date2)){
			type=Type.FUTURE;
			startDate=date1;
			finishDate=date2;
		}else{
			type=Type.PAST;
			startDate=date2;
			finishDate=date1;
		}
		this.totalDays= startDate.daysUntil(finishDate);
		this.totalMonths= startDate.monthsUntil(finishDate);
		this.totalYears=initYears(startDate,  finishDate);
		int monthsTmp =initMonths(startDate,  finishDate);
		
		int daysTmp = initDays(startDate,  finishDate);
		if(daysTmp<0){
			this.monthsPart=monthsTmp-1;
			this.daysPart=daysTmp +CalendarDate.daysInMonth(startDate.getYear(), startDate.getMonth());
		}else{
			this.monthsPart=monthsTmp;
			this.daysPart=daysTmp;
		}
		
	}
	
	private int initYears(CalendarDate startDate, CalendarDate finishDate){
		return totalMonths<12 ?
				0:
					startDate.getMonth()>finishDate.getMonth()?
						(finishDate.getYear() - startDate.getYear()) -1:
						finishDate.getYear() - startDate.getYear();
	}
	
	private int initMonths(CalendarDate startDate, CalendarDate finishDate){
		return totalMonths % 12;
	}
	
	private int initDays(CalendarDate startDate, CalendarDate finishDate){
		int days = totalDays;
		CalendarDate d = new CalendarDate(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
		for (int i = 0; i < totalMonths; i++) {
			days = days - CalendarDate.daysInMonth(d.getYear(), d.getMonth());
			d=d.addMonths(1);
		}
        return days;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public int getTotalMonths() {
		return totalMonths;
	}

	public Type getType() {
		return type;
	}

	public int getTotalYears() {
		return totalYears;
	}

	public int getMonthsPart() {
		return monthsPart;
	}

	public int getDaysPart() {
		return daysPart;
	}
	
//	@Override
//	public String toString() {
//		StringBuffer buf = new StringBuffer();
//		buf.append(type == Type.FUTURE ? '+' : '-');
//		if (totalYears != 0) {
//			String yearsString = Integer.toString(totalYears);
//			buf.append(yearsString.length() == 1 ? "Y0" + yearsString
//					: 'Y' + yearsString);
//		}
//		if (monthsPart != 0) {
//			String monthsString = Integer.toString(monthsPart);
//			buf.append(monthsString.length() == 1 ? "M0" + monthsString
//					: 'M' + monthsString);
//		}
//		String daysString = Integer.toString(daysPart);
//		buf.append(daysString.length() == 1 ? "D0" + daysString
//				: 'D' + daysString);
//		return buf.toString();
//	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		return type == Type.FUTURE ? nf.format(totalDays)+" days old" : nf.format(totalDays)+" until birth";
	}

	public String toRoundedString() {
			if(getTotalYears()!=0){
				String yearsString = Integer.toString(getTotalYears());
				return yearsString.length()==1?"Y0"+yearsString:'Y'+yearsString;
			}else if(totalMonths!=0){
				String monthsString = Integer.toString(totalMonths);
				return monthsString.length()==1?"M0"+monthsString:'M'+monthsString;
			}
			String daysString = Integer.toString(totalDays);
			return daysString.length()==1?"D0"+daysString:'D'+daysString;
		}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CalendarDateDuration) {
			CalendarDateDuration cddObj = (CalendarDateDuration)obj;
			return getTotalDays()==cddObj.getTotalDays() &&
			getType()==cddObj.getType();
		}
		return false;
	}

	// Lazily initialized, cached hashCode
	private volatile int hashCode; 
	
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0){
			result = 17;
			result = 31 * result + getTotalDays();
			result = 31 * result + getType().hashCode();
			hashCode = result;
		}
		return result;
	}
	
	
	
}

