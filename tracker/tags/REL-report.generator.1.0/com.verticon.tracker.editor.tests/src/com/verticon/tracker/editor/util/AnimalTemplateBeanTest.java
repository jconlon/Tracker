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
package com.verticon.tracker.editor.util;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;

/**
 * 
 * From the AnimalTemplateBean doc:
 * Three dateTime manipulations are supported:
 * 
 * 1. If the dateTimes of templateEvents are after a reference time, then
 * dateTimes of the copied events are the same as in the template events. 
 * 
 * 2. If the dateTimes of templateEvents are before a reference time AND there is NO
 * default date time set then the current dateTime is used instead of the dateTime in 
 * the template events.
 * 
 * 3. If the dateTimes of templateEvents are before a reference time AND there IS a
 * default date time set then a default dateTime is used for all events.
 * 
 * 
 * AnimalTemplateBean uses a default date and a reference date, when a tagsIdFileName 
 * uses a formated name of yyMMddHHmmss.tags the Date Time attributes of all Event 
 * Elements copied to the Premises Document will assume the time stamp of the 
 * dateOfEventInAnimalTemplateBean pattern yyMMddHHss for every event in the 
 * AnimalTemplate that is set with a 
 * dateOfEventInAnimalTemplateBean earlier than the DATE_REFERENCE.
 * 
 * For example the tags file 060409131111.Tags will set the Date Time attribute of 
 * all Events to 2006-04-09T13:11:11 if those events are set before 1000-01-01.
 *  
 */
public class AnimalTemplateBeanTest extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AnimalTemplateBeanTest.class);


	private final GregorianCalendar DATE_REFERENCE_2000_01 = 
		new GregorianCalendar(2000, Calendar.JANUARY, 1);
	
	private AnimalTemplateBean animalTemplateBean;
	private Animal animalInAnimalTemplateBean;
	private Premises premisesDestinationForCopiedAnimals;
	private Date dateOfEventInAnimalTemplateBean;
	private Event eventOfAnimalInTemplateBean;
	
	/**
	 * Setup an 
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		animalInAnimalTemplateBean = TrackerFactory.eINSTANCE.createBovineBeef();
		
		
	    eventOfAnimalInTemplateBean = TrackerFactory.eINSTANCE.createAnimalMissing();
	    dateOfEventInAnimalTemplateBean = eventOfAnimalInTemplateBean.getDateTime();
		animalTemplateBean = AnimalTemplateBean.instance(animalInAnimalTemplateBean, eventOfAnimalInTemplateBean);
		premisesDestinationForCopiedAnimals = TrackerFactory.eINSTANCE.createPremises();
	}

	@Override
	protected void tearDown() throws Exception {
		animalInAnimalTemplateBean=null;
		animalTemplateBean = null;
		premisesDestinationForCopiedAnimals = null;
		dateOfEventInAnimalTemplateBean = null;
		eventOfAnimalInTemplateBean = null;
		super.tearDown();
	}

	
	public void test_setup_AnimalTemplateBean() {
		logger.debug("Testing setup");
		assertNotNull(animalTemplateBean); 
	}
	
	public void test_setup_AnimalHasActiveTag(){
		assertNotNull(animalInAnimalTemplateBean.activeTag());
		
	}
	
	public void test_setup_numberOfEvents() {
		assertEquals(1, animalTemplateBean.numberOfEvents()); 
	}
	
	public void test_setup_defaultDate() {
		assertNull("AnimalTemplate should not have a default dates set", animalTemplateBean.getDate()); 
	}


	/**
	 * 
	 * Date in the bean is NOT before the reference.
	 * The date in the bean should be the date out of the bean
	 * @throws PremisesPolicyException 
	 */
	public void test_getAnimal_date_same() throws PremisesPolicyException {
		String animalName = "someTag";
		Animal a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		assertNotNull("Should not be null", a2);
		assertEquals(animalName, a2.getId());
		assertEquals(1, a2.eventHistory().size()); 
		assertEquals(dateOfEventInAnimalTemplateBean, 
				a2.eventHistory().get(0).getDateTime());
		
		
	}
	
	
	/**
	 * 
	 * Date in the bean IS before the reference AND there is NO defaultDate set.
	 * The current date should be the date out of the bean
	 * @throws PremisesPolicyException 
	 */
	public void test_getAnimal_date_current() throws PremisesPolicyException {
		String animalName = "someTag";
		
		setEventDateInBeanBeforeReference();
		
		Date timestamp = new Date();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		
		Animal a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		
		assertTrue("The event did not have the current time.",
				timestamp.before(a2.eventHistory().get(0).getDateTime()));
	
	}
	
	/**
	 * 
	 * Date in the bean IS before the reference and there IS a defaultDate set.
	 * The animal retrieved from the bean will have events with the default date.
	 * @throws PremisesPolicyException 
	 */
	public void test_getAnimal_date_default() throws PremisesPolicyException {
		String animalName = "someTag";
		
		setEventDateInBeanBeforeReference();
		
		GregorianCalendar defaultDate = setDefaultDateOnBean();
		
		Animal a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		
		assertEquals(defaultDate.getTime(), 
				a2.eventHistory().get(0).getDateTime());
		
	}

	private GregorianCalendar setDefaultDateOnBean() {
		//Set a defaultTime which is what a tagIdNumbers file interacts with the TemplateBean
		GregorianCalendar badEventDay = 
		new GregorianCalendar(2001, Calendar.SEPTEMBER, 11);
		animalTemplateBean.setDateForAllEvents(badEventDay.getTime());
		return badEventDay;
	}

	private void setEventDateInBeanBeforeReference() {
		DATE_REFERENCE_2000_01.add(Calendar.MONTH, -1);
		Date beforeRef = DATE_REFERENCE_2000_01.getTime();
		eventOfAnimalInTemplateBean.setDateTime(beforeRef);
	}
	
	/**
	 * Events should not have a container.
	 */
	public void testGetEvents() {
		assertEquals(1, animalTemplateBean.getEvents(premisesDestinationForCopiedAnimals).size());
		
		Collection<Event> events = animalTemplateBean.getEvents(null);
		for (Event event : events) {
			assertNull("Event should not have a container", event.eContainer());
		}
		
	}


	public void testGetName() {
		assertEquals("User prompted dialog", animalTemplateBean.getFileNameOfTemplate()); // TODO
	}

}
