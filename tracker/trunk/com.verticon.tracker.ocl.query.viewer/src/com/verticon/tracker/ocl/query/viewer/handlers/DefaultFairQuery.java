package com.verticon.tracker.ocl.query.viewer.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQuery;

enum DefaultFairQuery {
	EXHIBIT_PEOPLE_WITH_PINS(
			"Exhibitors with PINs",
			"self.exhibitor.pin.oclIsUndefined() = false", 
			"Exhibit"), 
			
    EXHIBIT_PEOPLE_WITHOUT_PINS(
			"Exhibitors without PINs", "self.exhibitor.pin.oclIsUndefined()",
			"Exhibit"),

	PERSON_WITH_EXHIBITS(
			"With a registered exhibit",
			"Exhibit.allInstances()->select(e : Exhibit | e.exhibitor=self)-> size()>0",
			"Person"),

	PERSON_WITHOUT_EXHIBIT(
			"Without no registered exhibit",
			"Exhibit.allInstances()->select(e : Exhibit | e.exhibitor=self)-> size()<1",
			"Person"),

	;

	private final OclQuery query;

	DefaultFairQuery(String uiName, String query, String type) {
		OclQuery sampleQuery = new OclQuery();
		sampleQuery.setName(uiName);
		sampleQuery.setType(type);
		sampleQuery.setQuery(query);
		this.query = sampleQuery;
	}

	IOclQuery getQuery() {
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
