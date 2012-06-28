package com.verticon.mongo.emf.json.query;

import static com.verticon.mongo.emf.json.query.QueryEngine.bundleMarker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mongo.emf.MongoQuery;
import org.json.mongoQuery.Array;
import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.Query;
import org.json.mongoQuery.QueryObject;
import org.json.mongoQuery.Selection;
import org.json.mongoQuery.Selector;
import org.json.mongoQuery.util.MongoQuerySwitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * 
 * Builds a MongoDB query object by traversing the MongoDB JSON AST (Ecore) 
 * model.
 * 
 * @see org.json.mongoQuery.Selector
 * @author jconlon
 * 
 */
public class DBObjectQueryBuilder extends MongoQuerySwitch<Object> {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DBObjectQueryBuilder.class);

	private static final String pattern = "EEE, dd MMM yyyy HH:mm:ss Z";
	private static final SimpleDateFormat format = new SimpleDateFormat(pattern);
	
	private QueryCollector queryCollector = null;
	private int childCounter=0;

	private Map<String,Integer> fieldFilterMap = new HashMap<String, Integer>();

	MongoQuery  build() {
    	assert(queryCollector!=null);
    	DBObject fieldFilter = new BasicDBObject();
    	if(!fieldFilterMap.isEmpty()){
    		fieldFilter.putAll(fieldFilterMap);
    	}
		return new MongoQuery(queryCollector.buildObjectFilter(), fieldFilter);
	}
	
     private static String clean(String s){
    	 String string = s.replaceAll("^\"|\"$", "");
    	 return  string.replaceAll("^\'|\'$", "");
     }
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseSelector(org.json.mongoQuery
	 * .Selector)
	 */
	@Override
	public Object caseSelector(Selector object) {
		boolean hasQuery = object.getQuery() != null;
		boolean hasSelection = object.getSelection() != null;
//		logger.debug(bundleMarker,"* Selector " + "has a Query " + hasQuery
//				+ " has a Selection " + hasSelection);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseQueryObject(org.json.mongoQuery
	 * .QueryObject)
	 */
	@Override
	public Object caseQueryObject(QueryObject object) {
		int size = object.getMembers().size();

		if (queryCollector == null) {
//			logger.debug(bundleMarker,"* QueryObject adding root QueryCollector with "
//					+ size + " members");
			queryCollector = new QueryCollector(size, "root");
		} else {
//			logger.debug(bundleMarker,"* QueryObject adding child QueryCollector with "
//							+ size + " members");
			childCounter++;
			queryCollector.addChild(new QueryCollector(size, "child"+childCounter));
		}

		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseSelection(org.json.mongoQuery
	 * .Selection)
	 */
	@Override
	public Object caseSelection(Selection object) {
//		logger.debug(bundleMarker,"* Selection has " + object.getFields().size()
//				+ " SelectionFields");
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseFieldSelection(org.json
	 * .mongoQuery.FieldSelection)
	 */
	@Override
	public Object caseFieldSelection(FieldSelection object) {
//		logger.debug(bundleMarker,"* FieldSelection with Key=" + object.getKey()
//				+ " Enabled=" + object.getEnabled());
		fieldFilterMap.put(object.getKey(), object.getEnabled());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseQuery(org.json.mongoQuery
	 * .Query)
	 */
	@Override
	public Object caseQuery(Query query) {
		if (query.getKey() != null) {

//			logger.debug(bundleMarker,"* Query with Key=" + query.getKey());
			queryCollector.addKey(clean(query.getKey()));

		} else if (query.getStringValue() != null) {
//			logger.debug(bundleMarker,"* Query with String=" + query.getStringValue());
			queryCollector.addValue(clean(query.getStringValue()));

		} else if (query.getObjectValue() != null) {
//			logger.debug(bundleMarker,"* Query with Object");
		} else if (query.getArrayValue() != null) {
//			logger.debug(bundleMarker,"* Query with Array=" + query.getArrayValue());
		} else if (query.getNumberValue() != Double.NaN && query.getNumberValue()!=0) {
//			logger.debug(bundleMarker,"* Query with Number=" + query.getNumberValue());
			queryCollector.addValue(query.getNumberValue());
		} else if (query.getDateValue() !=null){
//			logger.debug(bundleMarker,"* Query with Date=" + query.getDateValue());
			queryCollector.addValue(createDate(query.getDateValue()));
		} else if (query.getValue() != null) {
//			logger.debug(bundleMarker,"* Query with Value=" + query.getValue());
		} else {
//			logger.debug(bundleMarker,"* Query with Integer="
//					+ query.getIntegerValue());
			queryCollector.addValue(query.getIntegerValue());
		}
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#caseArray(org.json.mongoQuery
	 * .Array)
	 */
	@Override
	public Object caseArray(Array object) {
//		logger.debug(bundleMarker,"* Array with " + object.getValues().size()
//				+ " members");
		queryCollector.addArray(object.getValues().size());
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.json.mongoQuery.util.MongoQuerySwitch#defaultCase(org.eclipse.emf
	 * .ecore.EObject)
	 */
	@Override
	public Object defaultCase(EObject object) {
//		logger.warn(bundleMarker,"Unknown object={}", object);
		return Boolean.TRUE;
	}
	
	

	class QueryCollector {
	    int memberCount;
		private Stack<String> keyStack = new Stack<String>();
		private Map<String, Object> map = new HashMap<String, Object>();
		private FixedSizeList collection = null;
		private QueryCollector child = null;
		private final String name;

		QueryCollector(int memberCount, String name) {
			this.memberCount = memberCount;
			this.name=name;
		}
		

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "QueryCollector [name=" + name +", memberCount=" + memberCount + ", keyStack="
					+ keyStack + ", map=" + map + ", child=" + child
					+ "]";
		}


		void addKey(String key) {
			if (child != null && child.memberIsComplete()) {
				child.addKey(key);
			} else {
//				logger.debug(bundleMarker,"{} adding key {}",this,key);
				keyStack.push(key);
			}
		}

		void addChild(QueryCollector child) {
			assert (this.child == null);
//			logger.debug(bundleMarker,"{} adding child {}",this, child);
			this.child = child;
		}

		void addValue(Object value) {
			if (child != null) {
				child.addValue(value);
			} else {
				if (collection != null) {
					// There is a pending collection add to it
//					logger.debug(bundleMarker,"{} adding {} to collection ",this,value);
					collection.add(value);
					if (collection.isFull()) {
						String key = keyStack.pop();
						memberCount--;
						map.put(key, collection);
						collection = null;
//						logger.debug(bundleMarker,"{} collection is complete",this);
					}

				} else {
					// No pending collection add the value to the
					String key = keyStack.pop();
					memberCount--;
					map.put(key, value);
//					logger.debug(bundleMarker,"{} adding to map key={} value={}",
//							new Object[]{this,key,value});
				}
			}
			if (child != null && child.memberIsComplete() && child.allMembersAreProcessed()) {
				String key = keyStack.pop();
				DBObject dbObject = child.buildObjectFilter();
				map.put(key, dbObject);
//				logger.debug(bundleMarker, "{} adding to map key={} child {} built as dbObject {}",
//						new Object[]{this, key, child, dbObject});
				child = null;
			}
		}

		void addArray(int size) {
			if (child != null) {
				child.addArray(size);
			} else {
				collection = new FixedSizeList(size);
//				logger.debug(bundleMarker,"{} adding a collection size={}",this, size);
			}
		}
		
		boolean allMembersAreProcessed(){
			return memberCount ==0;
		}

		boolean memberIsComplete() {
			return keyStack.isEmpty();
		}

		DBObject buildObjectFilter() {
			assert (keyStack.isEmpty());
			return new BasicDBObject(map);
		}

	}

	class FixedSizeList extends ArrayList<Object> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		final int members;

		public FixedSizeList(int capacity) {
			super(capacity);
			this.members = capacity;
		}

		boolean isFull() {
			return members == size();
		}
	}

	
	@SuppressWarnings("deprecation")
	public Date createDate(JsonDate date) {
//        logger.debug(bundleMarker, "Creating Java date from "+date);
		Date result = null;
		if (date.getDateString()!=null) {
			try {
				result = format.parse(date.getDateString());
			} catch (ParseException e) {
				logger.debug(bundleMarker,"Failed to parse JsonDate dataString.",e);
				throw new IllegalStateException("Failed to parse query. "+e.getLocalizedMessage());
			}

		}else if (date.getMilliseconds()>0){
			result = new Date(date.getMilliseconds());
		}else if (date.getDay()>0 ){
			int year = date.getYear()-1900;
			result = new Date(year,date.getMonth(), date.getDay(),date.getHour(), date.getMinute(),date.getSecond());
		}else{
			result = new Date();

		}
//		logger.debug(bundleMarker, "Created Java date "+result);
		return result;
	}

}
