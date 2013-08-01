package com.verticon.tracker.store;

import static com.verticon.tracker.store.TrackerStoreUtils.mapToJSON;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * 
 * @author jconlon
 * 
 */
public enum Query {
	// Caution: ordering of elements makes a difference for matching. Use longer
	// patterns first.

	// retrievePremises(String uri, String in, String out)
	RETRIEVE_PREMISES_WITH_DATES_TEMPLATE(
			"{trackerStore:{'retrievePremises':[{uri:'%s'},{in:'%s'},{out:'%s'}]}}",
			"^\\{trackerStore:\\{'retrievePremises':\\[\\{uri:'(.*)'\\},\\{in:'(.*)'\\},\\{out:'(.*)'\\}\\]\\}\\}$",
			"$1,$2,$3"),

	// retrievePremises(LongLatPoint point, String in,String out)
	RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE(
			"{trackerStore:{'retrievePremises':[{point:'%s'},{in:'%s'},{out:'%s'}]}}",
			"^\\{trackerStore:\\{'retrievePremises':\\[\\{point:'(.*)'\\},\\{in:'(.*)'\\},\\{out:'(.*)'\\}\\]\\}\\}",
			"$1,$2,$3"),
	// retrievePremises(LongLatPoint point)retrievePremises(LongLatPoint point)
	RETRIEVE_PREMISES_WITH_POINT_TEMPLATE(
			"{trackerStore:{'retrievePremises':[{point:'%s'}]}}",
			"\\{trackerStore:\\{'retrievePremises':\\[\\{point:'(.*)'\\}\\]\\}\\}",
			"$1"),

	// retrievePremises(String uri)
	RETRIEVE_PREMISES_TEMPLATE(
			"{trackerStore:{'retrievePremises':[{uri:'%s'}]}}",
			"\\{trackerStore:\\{'retrievePremises':\\[\\{uri:'(.*)'\\}\\]\\}\\}",
			"$1"),

	// getPremisesNames(Set<String> uris)
	RETRIEVE_PREMISES_NAMES_TEMPLATE(
			"{trackerStore:{'retrievePremisesNames':[{uris:%s}]}}",
			"\\{trackerStore:\\{'retrievePremisesNames':\\[\\{uris:(.*)\\}\\]\\}\\}",
			"$1"),

	// retrieveAnimal(String ain)
	RETRIEVE_ANIMAL_TEMPLATE("{trackerStore:{'retrieveAnimal':[{ain:'%s'}]}}",
			"\\{trackerStore:\\{'retrieveAnimal':\\[\\{ain:'(.*)'\\}\\]\\}\\}",
			"$1"),
	//
	LAST_PUB_QUERY_TEMPLATE(
			"{aggregate:'Updates',pipeline:[{$match:{uri:'%s'}},{$project:{_id:0,update:1}}]}",
			"\\{aggregate:'Updates',pipeline:\\[\\{\\$match:\\{uri:'(.*)'\\}\\},\\{\\$project:\\{_id:0,update:1\\}\\}\\]\\}",
			"$1");

	private final String template;
	private final String regex;
	private final String group;

	Query(String template, String regex, String group) {
		this.template = template;
		this.regex = regex;
		this.group = group;
	}

	public String replace(Object... args) {
		if (args.length == 1 && args[0] instanceof HashSet<?>) {
			Set<String> paddedSet = new HashSet<String>();
			for (String string : ((Set<String>) args[0])) {
				paddedSet.add("'" + string + "'");
			}
			return String.format(template, paddedSet);
		}
		return String.format(template, args);
	}

	public boolean matches(String query) {
		return regex != null ? query.matches(regex) : false;
	}

	public String[] get(String query) {
		String parms = query.replaceAll(regex, group);
		if (parms.startsWith("[") && parms.endsWith("]")) {
			parms = parms.replace("[", "");
			parms = parms.replace("]", "");
			parms = parms.replace("'", "");
			return new String[] { parms };
		}
		return parms.split(",");
	}

	public Optional<byte[]> find(ITrackerFind find, String query)
			throws IOException {
		EObject eObject = null;
		switch (this) {
		case RETRIEVE_PREMISES_TEMPLATE:
			 eObject = find.retrievePremises(get(query)[0]);
			 break;
		case RETRIEVE_PREMISES_WITH_DATES_TEMPLATE:
			 eObject = find.retrievePremises(get(query)[0],get(query)[1],get(query)[2]);
			 break;
		case RETRIEVE_ANIMAL_TEMPLATE:
			 eObject = find.retrieveAnimal(get(query)[0]);
			 break;
		case RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE:
			ITrackerFind.LongLatPoint point = buildPoint(query);
			eObject = find
					.retrievePremises(point, get(query)[3], get(query)[4]);
			break;
		case RETRIEVE_PREMISES_WITH_POINT_TEMPLATE:
			point = buildPoint(query);
			eObject = find.retrievePremises(point);
			break;
		case LAST_PUB_QUERY_TEMPLATE:
			String result = find.query(query);
			return Optional.fromNullable(result.getBytes());
		case RETRIEVE_PREMISES_NAMES_TEMPLATE:
			Set<String> uris = new HashSet<String>();
			String s = get(query)[0];
			Iterable<String> ss = Splitter.on(',').trimResults()
					.omitEmptyStrings().split(s);
			Iterables.addAll(uris, ss);
			Map<String, String> results = find.getPremisesNames(uris);
			return Optional.fromNullable(mapToJSON(results).getBytes());
		}
		if (eObject == null) {
			return Optional.absent();
		}
		return Optional.of(TrackerStoreUtils.toPayload(eObject));
	}

	ITrackerFind.LongLatPoint buildPoint(String query) {
		StringBuilder sb = new StringBuilder();
		sb.append(get(query)[0]).append(',').append(get(query)[1])
.append(',')
				.append(get(query)[2]);
		ITrackerFind.LongLatPoint point = new ITrackerFind.LongLatPoint(
				sb.toString());
		return point;
	}

	/**
	 * 
	 * @param query
	 * @return an instance of Query based on the contents of the query
	 * @throws QueryParseException
	 */
	public static Query instance(String query) throws ParseException {
		for (Query queryTemplate : values()) {
			if (queryTemplate.matches(query)) {
				return queryTemplate;
			}

		}
		throw new ParseException("Query : " + query);
	}


	static public class ParseException extends Exception {
		private static final long serialVersionUID = 1L;

		ParseException(String message) {
			super(message);
		}

	}

}
