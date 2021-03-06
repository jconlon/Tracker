/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.util.ArrayList;
import java.util.Collection;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerFactory;

/**
 * @author jconlon
 *
 */
public abstract class AbstractSimpleAddAsEvent extends AbstractAddAsEvent {

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.actions.AbstractAddAsEvent#createEvents(com.verticon.tracker.TrackerFactory, com.verticon.tracker.AnimalId, java.lang.Long)
	 */
	@Override
	protected Collection<Event> createEvents(TrackerFactory trackerFactory, AnimalId animalId, Long tag) {
		ArrayList<Event> results = new ArrayList<Event>();
		Event event = createEvent( trackerFactory,  tag);
		if(event != null){
			event.setAin(animalId);
			event.setDateTime(findDate());
			event.setElectronicallyRead(true);
			results.add(event);
			return results;
		}
		
		return results;
	}
	
	
	abstract Event createEvent(TrackerFactory trackerFactory, Long tag);

}
