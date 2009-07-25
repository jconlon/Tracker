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
			"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(LostTag))) ->size() > 0",
			"Animal"),
	
	BEEF_GRADING_MINIMIUM_YIELD(
			"Bovine minimum yield grading (3 or better)",
			"self.eventHistory() -> select(" +
				"e : Event | ("+
					"e.oclIsTypeOf(USBeefGrading) and "+
						"(e.oclAsType(USBeefGrading).yieldGrade=USBeefYieldGrade::One or "+
						"e.oclAsType(USBeefGrading).yieldGrade=USBeefYieldGrade::Two or "+
						"e.oclAsType(USBeefGrading).yieldGrade=USBeefYieldGrade::Three) "+
				") ) -> size() = 1",
		    
			"Bovine"),
	
	BEEF_GRADING_MINIMIUM_QUALITY(
			"Bovine minimum quality grading (Choice or Prime)",
			"self.eventHistory() -> select(" +
				"e : Event | ("+
					"e.oclIsTypeOf(USBeefGrading) and "+
					"(e.oclAsType(USBeefGrading).qualityGrade=USQualityGrade::Prime or "+
					"e.oclAsType(USBeefGrading).qualityGrade=USQualityGrade::Choice) "+
				 ") ) ->size() = 1",
					"Bovine"),
			
	BOVINE_MIN_WEIGHT_GAINERS(
			"Bovine minimium weight gain (2)",
			"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay >= 2",
			"Bovine"),
	
	BOVINE_MIN_WEIGHT(
			"Bovine minimium weight (1100)",
			"self.weight.oclIsUndefined() = false and self.weight >= 1100",
			"Bovine"),
			
	SWINE_MIN_WEIGHT_GAINERS(
			"Swine minimium weight gain (1.5)",
			"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay >= 1.5",
			"Swine"),
			
	SWINE_MIN_WEIGHT(
			"Swine minimium weight (235)",
			"self.weight.oclIsUndefined() = false and self.weight >= 235",
			"Swine"),
	
	OVINE_MIN_WEIGHT(
			"Sheep minimium weight (100)",
			"self.weight.oclIsUndefined() = false and self.weight >= 100",
			"Ovine"),
			
	OVINE_GRADING_MINIMIUM_QUALITY(
			"Sheep minimum quality grading (Choice or Prime)",
			"self.eventHistory() -> select(" +
			"e : Event | ("+
				"e.oclIsTypeOf(USOvineGrading) and "+
				"(e.oclAsType(USOvineGrading).qualityGrade=USQualityGrade::Prime or "+
				"e.oclAsType(USOvineGrading).qualityGrade=USQualityGrade::Choice) "+
			") ) ->size() = 1",
			"Ovine"),
										
	EVENT_LOW_WEIGHT_GAINERS(
			"Low weight gainers",
			"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay < 3",
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
