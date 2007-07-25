/**
 * 
 */
package com.verticon.tracker.editor.actions;

import com.verticon.tracker.Event;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.TrackerFactory;

/**
 * Add the tag ids in the selected resource(s) as Premises MovedOut Events.
 * 
 * @author jconlon
 *
 */
public class AddAsMovedOut extends AbstractSimpleAddAsEvent {

	/**
	 * Create a MovedOut event if there is not already one assigned to the tag.
	 * @return event or null.
	 * @see com.verticon.tracker.editor.actions.AbstractAddAsEvent#createEvent(com.verticon.tracker.TrackerFactory)
	 */
	@Override
	protected Event createEvent(TrackerFactory trackerFactory, Long tag) {
		return containsEvent( tag, MovedOut.EVENT_CODE)?
				null:trackerFactory.createMovedOut();
	}

}
