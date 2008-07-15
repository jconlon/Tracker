package com.verticon.tracker.util;



import java.util.List;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Slaughtered;
import com.verticon.tracker.TagAllocated;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TrackerFactory;

public class EventFactory {

	private EventFactory() {
		
	}
	
	
    
    public static final Event createEvent(int eventCode){
		TrackerFactory trackerFactory = TrackerFactory.eINSTANCE;
		
		Event event = null;
		switch (eventCode) {
		case TagAllocated.EVENT_CODE:
			event = trackerFactory.createTagAllocated();
			break;
		case TagApplied.EVENT_CODE:
			event = trackerFactory.createTagApplied();
			break;
		case MovedIn.EVENT_CODE:
			event = trackerFactory.createMovedIn();
			break;
		case MovedOut.EVENT_CODE:
			event = trackerFactory.createMovedOut();
			break;
		case Sighting.EVENT_CODE:
			event = trackerFactory.createSighting();
			break;
		case Slaughtered.EVENT_CODE:
			event = trackerFactory.createSlaughtered();
			break;
		
		}
		
		return event;
	}
    
    public static final AnimalId findAnimalId(Long tag, Premises premises){
		List elist = premises.getAnimals().getAnimal();
		for (Object object : elist) {
			Animal animal = (Animal)object;
			if(animal.getIdNumber().longValue()==tag){
				return animal.getAin();
			}
		}
		return null;
	}

}
