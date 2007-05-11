/**
 * 
 */
package com.verticon.tracker.editor.actions;

import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;

/**
 * @author jconlon
 *
 */
public class AddAsWeighIn extends AbstractSimpleAddAsEvent {

	/**
	 * Create a MovedIn event if there is not already one assigned to the tag.
	 * @return event or null.
	 * @see com.verticon.tracker.editor.actions.AbstractAddAsEvent#createEvent(com.verticon.tracker.TrackerFactory)
	 */
	@Override
	protected Event createEvent(TrackerFactory trackerFactory, Long tag) {
		return containsEvent( tag, WeighIn.EVENT_CODE)?
				null:trackerFactory.createWeighIn();

	}

}
