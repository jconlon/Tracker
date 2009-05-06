package com.verticon.tracker.editor.util;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;

/**
 * 
 * 
 * AnimalTemplateBean uses a default date and a reference date
 * 
 * When a tagsIdFileName uses the format yyMMddHHmmss.tags 
 * 
 * Date Time 
 * attributes of all Event Elements copied to the Premises Document will 
 * assume the time stamp of of the dateOfEventInAnimalTemplateBean pattern yyMMddHHss for every event
 * in the AnimalTemplate that is set with a dateOfEventInAnimalTemplateBean earlier than the DATE_REFERENCE.
 * For example the tags file 060409131111.Tags will set the Date Time attribute of 
 * all Events to 2006-04-09T13:11:11 if those events are set before 1000-01-01.
 *  
 */
public class AnimalTemplateBeanTest extends TestCase {

	private final GregorianCalendar DATE_REFERENCE = 
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
		assertNotNull(animalTemplateBean); 
	}
	
	public void test_setup_AnimalHasActiveTag(){
		assertNotNull(animalInAnimalTemplateBean.activeTag());
		
	}
	
	public void test_numberOfEvents() {
		assertEquals(1, animalTemplateBean.numberOfEvents()); 
	}


	/**
	 * 
	 * Date in the bean is NOT before the reference.
	 * The date in the bean should be the date out of the bean
	 */
	public void test_getAnimal_date_same() {
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
	 */
	public void test_getAnimal_date_current() {
		String animalName = "someTag";
		
		//Set the date of the event in the template before the reference
		//an animal returned from the template should have the date
		//of it's event set to the current time
		DATE_REFERENCE.add(Calendar.MONTH, -1);
		Date beforeRef = DATE_REFERENCE.getTime();
		eventOfAnimalInTemplateBean.setDateTime(beforeRef);
		Animal a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		assertTrue(dateOfEventInAnimalTemplateBean.before(a2.eventHistory().get(0).getDateTime()));
		
		
		//Set a defaultTime which is what a tagIdNumbers file interacts with the TemplateBean
		GregorianCalendar badEventDay = 
		new GregorianCalendar(2001, Calendar.SEPTEMBER, 11);
		
		
		
		animalTemplateBean.setDateForAllEvents(badEventDay.getTime());
		a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		assertEquals(badEventDay.getTime(), 
				a2.eventHistory().get(0).getDateTime());
		
	}
	
	/**
	 * 
	 * Date in the bean IS before the reference and there IS a defaultDate set.
	 * The current date should be the date of the reference.
	 */
	public void test_getAnimal_date_default() {
		String animalName = "someTag";
		
		//Set a defaultTime which is what a tagIdNumbers file interacts with the TemplateBean
		GregorianCalendar badEventDay = 
		new GregorianCalendar(2001, Calendar.SEPTEMBER, 11);
		
		DATE_REFERENCE.add(Calendar.MONTH, -1);
		Date beforeRef = DATE_REFERENCE.getTime();
		eventOfAnimalInTemplateBean.setDateTime(beforeRef);
		animalTemplateBean.setDateForAllEvents(badEventDay.getTime());
		Animal a2 = animalTemplateBean.getAnimal(animalName, premisesDestinationForCopiedAnimals);
		assertEquals(badEventDay.getTime(), 
				a2.eventHistory().get(0).getDateTime());
		
	}
	
	
	public void testGetEvents() {
		assertEquals(1, animalTemplateBean.getEvents(premisesDestinationForCopiedAnimals).size());
	}


	public void testGetName() {
		assertEquals("User prompted dialog", animalTemplateBean.getFileNameOfTemplate()); // TODO
	}

}
