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
package com.verticon.tracker.export.wlic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.DateTime;

import com.verticon.tracker.Event;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;

public class Utils {

	 public static final SimpleDateFormat FILE_NAME_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
		
	 
	private Utils() {
		
	}
	
	/**
	 * @param trackerFile
	 * @return exports folder
	 */
	public static IFolder getExportsFolder(IFile trackerFile) {
		IProject project = trackerFile.getProject();
		IFolder exportsFolder = project.getFolder(new Path("exports"));
		return exportsFolder;
	}
	
	public static final Calendar getCalendarFromDateTimeWiget(
			DateTime startDateOfReport, DateTime startTimeOfReport) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, startDateOfReport.getYear());
		cal.set(Calendar.MONTH, startDateOfReport.getMonth());
		cal.set(Calendar.DAY_OF_MONTH, startDateOfReport.getDay());
		cal.set(Calendar.HOUR_OF_DAY, startTimeOfReport.getHours());
		cal.set(Calendar.MINUTE, startTimeOfReport.getMinutes());
		cal.set(Calendar.SECOND, startTimeOfReport.getSeconds());
		cal.add(Calendar.SECOND, -1); //fudge this calendar because widget is not using milliseconds
		return cal;
	}

	private static final Comparator<Event> dc = new Comparator<Event>() {
		public int compare(Event a, Event b) {
			Date d1 = a.getDateTime();
			Date d2 = b.getDateTime();
			return d1.compareTo(d2);
		}

	};

	private static final FilterCriteria<Event> validWlicFilterCriteria = new FilterCriteria<Event>() {
		public boolean passes(Event event) {
			return event.getEventCode() < 15;
		}
	};

	private static final Collection<Event> filterEventCollection(
			Collection<Event> events, FilterCriteria<Event> filterCriteria) {
		CollectionFilter<Event> validWlicCollectionFilter = new CollectionFilter<Event>();
		validWlicCollectionFilter.addFilter(filterCriteria);
		return validWlicCollectionFilter.filterCopy(events);
	}

	public static final Date getEarliestWlicEventDate(EList<Event> events) {
		if (events.isEmpty()) {
			return null;
		}
		Collection<Event> l = createValidWlicEventHistory(events);
		return Collections.min(l, dc).getDateTime();
	}

	public static Date getLatestWlicEventDate(EList<Event> events) {
		if (events.isEmpty()) {
			return null;
		}
		Collection<Event> l = createValidWlicEventHistory(events);
		return Collections.max(l, dc).getDateTime();
	}

	private static Collection<Event> createValidWlicEventHistory(
			EList<Event> events) {
		return filterEventCollection(events, validWlicFilterCriteria);
	}

	public static int getNumberOfValidWlicEvents(EList<Event> events) {
		if (events.isEmpty()) {
			return 0;
		}
		Collection<Event> l = createValidWlicEventHistory(events);
		return l.size();
	}
	
	public static int getNumberOfFilteredValidWlicEvents(EList<Event> events,FilterCriteria<Event> filterCriteria) {
		if (events.isEmpty()) {
			return 0;
		}
		CollectionFilter<Event> validWlicCollectionFilter = new CollectionFilter<Event>();
		validWlicCollectionFilter.addFilter(validWlicFilterCriteria);
		validWlicCollectionFilter.addFilter(filterCriteria);
		return validWlicCollectionFilter.filterCopy(events).size();
	}
	
	public static Collection<Event> getFilteredAndSortedValidWlicEvents(EList<Event> events,FilterCriteria<Event> filterCriteria) {
		if (events.isEmpty()) {
			return events;
		}
		List<Event> copy = new ArrayList<Event>(events);
		Collections.sort(copy, dc);
		
		CollectionFilter<Event> validWlicCollectionFilter = new CollectionFilter<Event>();
		validWlicCollectionFilter.addFilter(validWlicFilterCriteria);
		validWlicCollectionFilter.addFilter(filterCriteria);
		return validWlicCollectionFilter.filter(copy);
	}
	
	

	/**
	 * Parse a fileName like 003ALKM 20070925190543.IND
	 * @param fileName
	 * @return date
	 */
	public static final Date parseWlicFileName(String fileName) throws ParseException{
		String date = fileName.substring(7, 21);
		return FILE_NAME_DATE_FORMAT.parse(date);
	}

}
