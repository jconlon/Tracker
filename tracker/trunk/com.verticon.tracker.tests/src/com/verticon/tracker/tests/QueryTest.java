package com.verticon.tracker.tests;

import static com.verticon.tracker.store.Query.LAST_PUB_QUERY_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_ANIMAL_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_NAMES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_DATES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_POINT_TEMPLATE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.verticon.tracker.store.Query;
import com.verticon.tracker.store.Query.ParseException;

public class QueryTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	static final Set<String> uris = new HashSet<String>();
	static {
		uris.add("urn:pin:H89234X");
		uris.add("urn:pin:ABCD");
		uris.add("urn:pin:EFG");
	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testReplace() {
		String query = RETRIEVE_PREMISES_TEMPLATE.replace("12345");
		assertThat("Wrong query string.", query,
				is("{trackerStore:{'retrievePremises':[{uri:'12345'}]}}"));

		query = RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.replace("12345", "ABC",
				"67");
		assertThat(
				"Wrong query string.",
				query,
				is("{trackerStore:{'retrievePremises':[{uri:'12345'},{in:'ABC'},{out:'67'}]}}"));

		query = RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.replace(
				"-77.037852,38.898556,0", "ABC", "67");
		assertThat(
				"Wrong query string.",
				query,
				is("{trackerStore:{'retrievePremises':[{point:'-77.037852,38.898556,0'},{in:'ABC'},{out:'67'}]}}"));

		query = RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.replace("12345");
		assertThat("Wrong query string.", query,
				is("{trackerStore:{'retrievePremises':[{point:'12345'}]}}"));
		
		query = RETRIEVE_ANIMAL_TEMPLATE.replace("12345");
		assertThat("Wrong query string.", query,
				is("{trackerStore:{'retrieveAnimal':[{ain:'12345'}]}}"));

		query = LAST_PUB_QUERY_TEMPLATE.replace("12345");
		assertThat(
				"Wrong query string.",
				query,
				is("{aggregate:'Updates',pipeline:[{$match:{uri:'12345'}},{$project:{_id:0,update:1}}]}"));



		query = RETRIEVE_PREMISES_NAMES_TEMPLATE.replace(uris);
		assertThat(
				"Wrong query string.",
				query,
				is("{trackerStore:{'retrievePremisesNames':[{uris:['urn:pin:H89234X', 'urn:pin:ABCD', 'urn:pin:EFG']}]}}"));
	}

	public final void testMatches() {
		String query = RETRIEVE_PREMISES_TEMPLATE.replace("12345");
		assertThat("Does not match", RETRIEVE_PREMISES_TEMPLATE.matches(query),
				is(true));
		query = RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.replace("12345", "ABC",
				"67");
		assertThat("Does not match",
				RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.matches(query), is(true));

		query = RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.replace(
				"12345", "ABC", "67");
		assertThat("Does not match",
				RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.matches(query),
				is(true));

		query = RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.replace("12345");
		assertThat("Does not match",
				RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.matches(query), is(true));

		query = RETRIEVE_ANIMAL_TEMPLATE.replace("12345");
		assertThat("Does not match", RETRIEVE_ANIMAL_TEMPLATE.matches(query),
				is(true));

		query = LAST_PUB_QUERY_TEMPLATE.replace("12345");
		assertThat("Does not match", LAST_PUB_QUERY_TEMPLATE.matches(query),
				is(true));

		query = RETRIEVE_PREMISES_NAMES_TEMPLATE.replace(uris);
		assertThat("Does not match",
				RETRIEVE_PREMISES_NAMES_TEMPLATE.matches(query), is(true));
	}

	public final void testInstance() throws ParseException {
		String query = RETRIEVE_PREMISES_TEMPLATE.replace("12345");
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_PREMISES_TEMPLATE));

		query = RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.replace("12345", "ABC",
				"67");
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_PREMISES_WITH_DATES_TEMPLATE));

		query = RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.replace(
				"12345", "ABC", "67");
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE));

		query = RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.replace("12345");
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_PREMISES_WITH_POINT_TEMPLATE));

		query = RETRIEVE_ANIMAL_TEMPLATE.replace("12345");
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_ANIMAL_TEMPLATE));

		query = LAST_PUB_QUERY_TEMPLATE.replace("12345");
		assertThat("Wrong query instance", Query.instance(query),
				is(LAST_PUB_QUERY_TEMPLATE));

		query = RETRIEVE_PREMISES_NAMES_TEMPLATE.replace(uris);
		assertThat("Wrong query instance", Query.instance(query),
				is(RETRIEVE_PREMISES_NAMES_TEMPLATE));

	}

	public final void testGet() {
		String query = RETRIEVE_PREMISES_TEMPLATE.replace("12345");
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_TEMPLATE.get(query)[0], is("12345"));

		query = RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.replace("12345", "ABC",
				"67");
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.get(query)[0],
				is("12345"));
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.get(query)[1], is("ABC"));
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.get(query)[2], is("67"));

		query = RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.replace(
				"12345", "ABC", "67");
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.get(query)[0],
				is("12345"));
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.get(query)[1],
				is("ABC"));
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.get(query)[2],
				is("67"));

		query = RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.replace("12345");
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.get(query)[0],
				is("12345"));

		query = RETRIEVE_ANIMAL_TEMPLATE.replace("12345");
		assertThat("Wrong query arg", RETRIEVE_ANIMAL_TEMPLATE.get(query)[0],
				is("12345"));

		query = LAST_PUB_QUERY_TEMPLATE.replace("12345");
		assertThat("Wrong query arg", LAST_PUB_QUERY_TEMPLATE.get(query)[0],
				is("12345"));

		query = RETRIEVE_PREMISES_NAMES_TEMPLATE.replace(uris);
		assertThat("Wrong query arg",
				RETRIEVE_PREMISES_NAMES_TEMPLATE.get(query)[0],
				is("urn:pin:H89234X, urn:pin:ABCD, urn:pin:EFG"));
	}

}
