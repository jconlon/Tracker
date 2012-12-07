/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongo.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;

/**
 * Filters two lists of events to find unique events.
 * @author jconlon
 *
 */
public class NewerEvents implements Predicate<Event> {

	private final List<Event> oldEvents;
	
	private NewerEvents(List<Event> oldEvents) {
		super();
		checkNotNull("Cutoff date must not be null.", oldEvents);
		this.oldEvents = oldEvents;
	}

	@Override
	public boolean apply(Event input) {
		checkNotNull("Event must not be null.", input);
		checkNotNull("Event date must not be null.", input.getDateTime());
		for (Event event : oldEvents) {
			if(event.getDate().equals(input.getDate())&& event.eClass().equals(input.eClass())){
				return false;
			}
		}
		return true;
	}
	
	static Collection<Event> getNewerEvents(Tag tag, Tag persistedTag){
		Optional<NewerEvents> newerEvents = isNewer(persistedTag);
		if(!newerEvents.isPresent()){
			return Collections.emptyList();
		}
		return Collections2.filter(
				tag.getEvents(), newerEvents.get());
	}
	
	
	private static Optional<NewerEvents> isNewer(List<Event> events){
		if(events==null || events.isEmpty()){
			return Optional.absent();
		}
		return Optional.of(new NewerEvents(events));
	}
	
		
   private static Optional<NewerEvents> isNewer(Tag tag){
		if(tag==null){
			return Optional.absent();
		}
		return isNewer(tag.getEvents());
	}
	

}
