package com.verticon.tracker.ocl.query.viewer.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQuery;

enum DefaultPremisesQuery {
	ANIMAL_UNIDENTIFIED_PINS(
			"Moved out or Moved in to/from an unidentified premises",
			"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(MovedIn) and e.oclAsType(MovedIn).sourcePin.oclIsUndefined()) or (e.oclIsTypeOf(MovedOut) and e.oclAsType(MovedOut).destinationPin.oclIsUndefined())) ->size() > 0",
			"Animal"),
			
   ANIMAL_UNIDENTIFIED_MOVEDOUT_PINS(
					"Moved out to an unidentified premises",
					"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(MovedOut) and e.oclAsType(MovedOut).destinationPin.oclIsUndefined()) ) ->size() > 0",
					"Animal"),

	ANIMAL_UNIDENTIFIED_MOVEIN_PINS(
			"Moved in from an unidentified premises",
			"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(MovedIn) and e.oclAsType(MovedIn).sourcePin.oclIsUndefined()) ) ->size() > 0",
			"Animal"),
			
	ANIMAL_LOST_TAGS(
			"Have lost tags",
			"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(LostTag)) ) ->size() > 0",
			"Animal"),
	
	ANIMAL_LOW_WEIGHT_GAINERS(
			"Low weight gainers",
			"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay<3",
			"Animal"),
	
	EVENT_LOW_WEIGHT_GAINERS(
			"Low weight gainers",
			"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay<3",
			"WeighIn"),
		
    EVENT_EXCESSIVE_CELL_COUNT(
    		"Excessive Somatic Cell Counts",
    		"self.somaticCellCounts>200",
    		"MilkTest"),
	;


	private final OclQuery query;
	
	DefaultPremisesQuery(String uiName, String query, String type) {
		OclQuery sampleQuery = new OclQuery();
		sampleQuery.setName(uiName);
		sampleQuery.setType(type);
		sampleQuery.setQuery(query);
		this.query= sampleQuery;
	}

	IOclQuery getQuery() {
		return query;
	}

	static Collection<IOclQuery> getQueries(){
		List<IOclQuery> result = new ArrayList<IOclQuery>(values().length);
		for (DefaultPremisesQuery defaultQuery : values()) {
			result.add(defaultQuery.getQuery());
		}
		return result;
	}
}
