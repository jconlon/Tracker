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
/**
 * 
 */
package com.verticon.tracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import net.sourceforge.calendardate.CalendarDate;

/**
 * Wrapper class for CalendarDateDuration
 */

public class Age extends CalendarDateDuration {

	public Age(Date birthDate) {
		super(new CalendarDate(TimeZone.getDefault(), birthDate),
				new CalendarDate(TimeZone.getDefault(), new Date()));
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
				System.out.println("Your are " + myAge.getTotalYears()
						+ " years, " + myAge.getMonthsPart() + " months, "
						+ myAge.getDaysPart() + " days " + 
						(myAge.getType()==CalendarDateDuration.Type.FUTURE?"old":
							"Hey your not going to be born for this long. Are you a spirit?")
						+ ".");

				System.out.println("Standard format: " + myAge.toString());
				System.out
						.println("Rounded format: " + myAge.toRoundedString());

			} catch (ParseException e) {
				System.out.println("Error parsing your birthday.");
				e.printStackTrace();
			}
		}
	}

}