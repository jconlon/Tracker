package com.verticon.tracker.irouter.measurement.event.test.system.internal;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class MockEventHandler implements EventHandler {

	List<Event> events = new ArrayList<Event>();
	@Override
	public void handleEvent(Event event) {
		events.add(event);
//		System.out.println("**************** "+this+" Handled "+event);
	}
	
	public void activate(){
//		System.out.println("**************** "+this+" Activated");
	}

}
