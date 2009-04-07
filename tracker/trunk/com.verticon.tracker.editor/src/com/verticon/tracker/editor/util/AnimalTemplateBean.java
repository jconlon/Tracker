/**
 * 
 */
package com.verticon.tracker.editor.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Location;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * Data container for an Animal template and a flag indicating how to use event
 * timestamps
 * 
 * @author jconlon
 *
 */
 public class AnimalTemplateBean {
	private final Animal animalInTemplate;
	private Date defaultEventDate = null;
	private final String tagsFileName;
	private final static Copier copier = new Copier(false, false);
	
	/**
	 * When a tagsFileName uses the format yyMMddHHmmss.tags the Date Time 
	 * attributes of all Event Elements copied to the Premises Document will 
	 * assume the time stamp of of the date pattern yyMMddHHss. For example 
	 * the tags file 060409131111.Tags will set the Date Time attribute of 
	 * all Event Elements to 2006-04-09T13:11:11
	 * 
	 * @param animalInTemplate
	 * @param tagsFileName of the Template. 
	 */
	public AnimalTemplateBean(Animal animal, String tagsFileName) {
		super();
		this.animalInTemplate = animal;
		this.tagsFileName=tagsFileName;
	}

	/**
	 * @deprecated use method with the string parm 
	 * @return the animalInTemplate and set all the event dates if useCurrentDate is set.
	 */
	@Deprecated
	public Animal getAnimal(Long tag) {
		return getAnimal( tag.toString(), null);
	}
	

	/**
	 * Copy the animalInTemplate and its tree of Tags and Events.
	 * Sets Event dates if useCurrentDate is set.
	 * 
	 * Copier does not copy or any references so this has to 
	 * be done after the copy. Now only done for Sighting events
	 * but could be extended to handle other references.
	 * 
	 * 
	 * @return copied animalInTemplate.
	 */
	public Animal getAnimal(String tag, Premises premises){
		
		Animal copiedTemplateAnimal = (Animal)copier.copy(animalInTemplate);
		if(premises!=null){
			setLocationOnCopiedSightingEvents(copiedTemplateAnimal.eventHistory(),  premises);
		}
		if(copiedTemplateAnimal.activeTag()!=null){
			copiedTemplateAnimal.activeTag().setId(tag);
			setAppropriateDateOnEvents(copiedTemplateAnimal, defaultEventDate);
		}else{
			//no active tag on the template animal, just create a tag
			Tag newTag = TrackerFactory.eINSTANCE.createTag();
			newTag.setId(tag);
			copiedTemplateAnimal.getTags().add(newTag);
		}
		return copiedTemplateAnimal;
	}

	/**
	 * Sets appropriate dates on all animalInTemplate events.
	 * @param copiedAnimal
	 * @param presetDate
	 */
	 private static void setAppropriateDateOnEvents(Animal copiedAnimal, Date presetDate) {
		int interval = getIntervalBetweenEventsPreference();
		Calendar cal = null;
		for (Event event : copiedAnimal.eventHistory()) {
			if(isFirstEvent(cal) ){
				if(presetDate !=null){
					cal = Calendar.getInstance();
					cal.setTime(presetDate);
				}else{
					cal = Calendar.getInstance();
				}
			}else{//All subsequent events add the Spread Interval to space out the events.
				cal.add(Calendar.SECOND, interval);
			}
			setEventDateIfTemplateDateBeforeReference( event, cal.getTime());
			
		}
	}

	/**
	 * @return
	 */
	private static int getIntervalBetweenEventsPreference() {
		int interval = 1;
		if(TrackerReportEditorPlugin.getPlugin()!=null){
			Preferences prefs = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
			if(prefs!=null){
				interval = prefs.getInt(PreferenceConstants.P_SPREAD_INTERVAL);
			}
		}
		return interval;
	}

	/**
	 * @param cal
	 * @return
	 */
	private static boolean isFirstEvent(Calendar cal) {
		return cal == null;
	}
	
	/**
	 * Need to reference a valid location in the Premises on the copied SightEvents
	 * @param copiedAnimal
	 */
	private void setLocationOnCopiedSightingEvents(EList<Event> events, Premises premises){
		int position = 0;
		for (Event event : events) {
			if(event instanceof Sighting){
				position++;
				Sighting sighting = (Sighting)event;
				Location location = getLocationFromPrimalAnimal(position, premises);
				sighting.setLocation(location);
			}
		}
	}

	/**
	 * 
	 * @param position of the SightingEvent in the eventHistory of the primal
	 * @param premises
	 * @return
	 */
	private Location getLocationFromPrimalAnimal(int position, Premises premises){
		int myposition = 0;
		for (Event event : animalInTemplate.eventHistory()) {
			if(event instanceof Sighting){
				myposition++;
				if(myposition == position){
					Sighting sighting = (Sighting)event;
					if(sighting ==null || sighting.getLocation()==null){
						return null;
					}
					
					return getLocation( premises,  sighting.getLocation().getName());
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns a location from the premises base on a name
	 * @param premises
	 * @param name
	 * @return
	 */
	private Location getLocation(Premises premises, String name){
		for (Location location : premises.getLocations()) {
			if(location.getName().equals(name)){
				return location;
			}
		}
		return null;
	}
	

	public int numberOfEvents(){
		return animalInTemplate.eventHistory().size();
	}
	/**
	 * 
	 * @return a list of events using the current date if necessary.
	 */
	public Collection<Event> getEvents(Premises premises){
		Animal copiedAnimal = (Animal)copier.copy(animalInTemplate);
		if(premises!=null){
			setLocationOnCopiedSightingEvents( copiedAnimal.eventHistory(),  premises);
		}
		Collection<Event> events = null;
		if(copiedAnimal.eventHistory().isEmpty()){
			events= Collections.emptyList();
		}else{
			setAppropriateDateOnEvents(copiedAnimal, defaultEventDate);
			events = new ArrayList<Event>();
			events.addAll(copiedAnimal.eventHistory());//Just add all the events
		}
		
		return events;
	}

	public Date getDate() {
		return defaultEventDate;
	}

	public void setDateForAllEvents(Date date) {
		this.defaultEventDate = date;
	}

	public String getName() {
		return tagsFileName;
	}

	@Override
	public String toString() {
		return "Template resource: "+tagsFileName;
	}
	
	public static final GregorianCalendar DATE_REFERENCE = new GregorianCalendar(1000, Calendar.JANUARY, 1);  

    private static final void setEventDateIfTemplateDateBeforeReference(Event event, Date defaultDate){
		if(event.getDateTime().before(DATE_REFERENCE.getTime())){
			event.setDateTime(defaultDate);
		}
	}
}
