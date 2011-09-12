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
package com.verticon.tracker.ocl.query.viewer.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQuery;

enum DefaultFairQuery {
	@SuppressWarnings("ucd")
	EXHIBIT_PEOPLE_WITH_PINS(
			"Exhibitors with PINs",
			"self.exhibitor.pin.oclIsUndefined() = false", 
			"Exhibit"), 
			
    @SuppressWarnings("ucd")
    EXHIBIT_PEOPLE_WITHOUT_PINS(
			"Exhibitors without PINs", "self.exhibitor.pin.oclIsUndefined()",
			"Exhibit"),

	@SuppressWarnings("ucd")
	PERSON_WITH_EXHIBITS(
			"With a registered exhibit",
			"Exhibit.allInstances()->select(e : Exhibit | e.exhibitor=self)-> size()>0",
			"Person"),

	@SuppressWarnings("ucd")
	PERSON_WITHOUT_EXHIBIT(
			"Without no registered exhibit",
			"Exhibit.allInstances()->select(e : Exhibit | e.exhibitor=self)-> size()<1",
			"Person"),
			
	@SuppressWarnings("ucd")
	YOUNG_PERSON(
			"Young Person",
			"true",
			"YoungPerson"),
	
	@SuppressWarnings("ucd")
	OLD_PERSON(
			"Old Person",
			"oclIsKindOf(YoungPerson) = false",
			"Person"),

	;

	private final OclQuery query;

	private DefaultFairQuery(String uiName, String query, String type) {
		OclQuery sampleQuery = new OclQuery();
		sampleQuery.setName(uiName);
		sampleQuery.setType(type);
		sampleQuery.setQuery(query);
		this.query = sampleQuery;
	}

	private IOclQuery getQuery() {
		return query;
	}

	static Collection<IOclQuery> getQueries() {
		List<IOclQuery> result = new ArrayList<IOclQuery>(values().length);
		for (DefaultFairQuery defaultQuery : values()) {
			result.add(defaultQuery.getQuery());
		}
		return result;
	}
}
