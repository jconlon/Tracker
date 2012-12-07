package com.verticon.mongo.json.query.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.json.MongoQueryInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * See http://code.google.com/a/eclipselabs.org/p/xtext-utils/wiki/Unit_Testing
 * 
 * @author jconlon
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(MongoQueryInjectorProvider.class)
public class MongoJsonQueryParserTest extends XtextTest {

    //Selection
	@Test
	public void Conditional() {
		testParserRule("$exists", "Conditional");
		testParserRule("$mod", "Conditional");
		testParserRule("$ne", "Conditional");
	}

	@Test
	public void FieldSelection() {
		testParserRule("'a.b':0", "FieldSelection");
		testParserRule("'a.b':1", "FieldSelection");
		testParserRule("'a.b':3", "FieldSelection");
	}
	
	/**
	 * Top of the selection
	 */
	@Test
	public void Selection() {
		testParserRule("{'ssn': 1}", "Selection");
		testParserRule("{'thumbnail':0}", "Selection");
		testParserRule("{'a.b':1}", "Selection");
	}

	//Query
	@Test
	public void Array() {
		// testParserRule("","Array");
		testParserRule("[2,3]", "Array");
		testParserRule("[22,3]","Array");
		testParserRule("['null',2,3]","Array");
		testParserRule("[2,3,-3.3,'true']","Array");
		testParserRule("[1,2,3]", "Array");
	}
	
	//Terminals
	@Test
	public void id() {
		testTerminal("bar", /* token stream: */"ID");
		testTerminal("bar3", /* token stream: */"ID");
		testTerminal("_bar_", /* token stream: */"ID");
		testNotTerminal("3bar", /* unexpected */"ID");
		testNotTerminal("#bar", /* unexpected */"ID");

		// token streams with multiple token
		testTerminal("foo.*", "ID", "ANY_OTHER", "ANY_OTHER");

	}

	@Test
	public void Number() {
		testTerminal(".2", "NUMBER");
		testTerminal("-2.9", "NUMBER");
		testTerminal("-2.9e4", "NUMBER");
		testTerminal("1.0", "NUMBER");
		testTerminal("-90.95674265545253", "NUMBER");
		testTerminal("43.47493314332049", "NUMBER");
		
	}

	@Test
	public void INT() {
		testTerminal("20", "INT");
		testTerminal("33", "INT");
		testTerminal("66", "INT");
		testTerminal("4", "INT");
		testTerminal("5", "INT");
		testTerminal("10", "INT");
		testTerminal("20", "INT");
		testTerminal("1", "INT");
	}

	@Test
	public void QueryObject(){
		testParserRule("{'last_name': 'Smith'}", "QueryObject");
		testParserRule("{'a': {$gt: 10}}", "QueryObject");
		testParserRule("{'a': {$in: [10, 'hello']}}", "QueryObject");
	}
	
	@Test
	public void Dates(){
		testParserRule("new Date()", "JsonDate");//NOW
		testParserRule("new Date(2011, 05, 01)", "JsonDate");//FULL Required
		testParserRule("new Date(2011, 05, 01, 12, 22, 33, 3333)", "JsonDate");//FULL Required w Optional
		testParserRule("new Date('Wed, 09 Aug 1995 00:00:00 GMT')", "JsonDate");
	}
	/**
	 * Top of the Tree
	 */
	@Test
	public void Selector() {
		testParserRule("{'last_name': 'Smith'}", "Selector");
		testParserRule("{last_name: 'Smith'}, {'ssn': 1}", "Selector");
		testParserRule("{}, {'thumbnail':0}", "Selector");
		testParserRule("{ x : 3, y : 'foo' }", "Selector");
		// testParserRule("","Selector");
		testParserRule("{j: {$ne: 3}, k: {$gt: 10} }", "Selector");
		testParserRule("{colors : {$ne : 'red'}}", "Selector");
		testParserRule("{ 'field' : { $lte: 'value' } } ", "Selector");
		testParserRule("{ 'field' : { $gt: 'value1', $lt: 'value2' } }",
				"Selector");
		testParserRule(" { a: { $all: [ 2, 3 ] } } ", "Selector");
		//
		testParserRule("{ a : { $exists : true } }", "Selector");
		testParserRule("{ a : { $exists : false } }", "Selector");
		testParserRule("{ a : { $mod : [ 2, 10 ] } }", "Selector");
		//String query = "{'"+EVENTS_DATE_TIME+"' : {$gte :"+FROMDATE_JSON +", $lt : "+TODATE_JSON+"}}";
		//String query = "{'"+EVENTS_DATE_TIME+"' : {$lt : "+TODATE_JSON+"}}";
		//String query = "{'"+EVENTS_DATE_TIME+"' : {$lt : "+TODATE_JSON+"}}";
		testParserRule("{'a.b' : {$lt : new Date()}}", "Selector");
		
		// testParserRule("","Selector");
		// testParserRule("","Selector");
		// testParserRule("","Selector");
		// testParserRule("","Selector");

		testParserRule("{$or: [{a: 4},{a: 2 }]},{'a.b':1}", "Selector");
		
		testParserRule("{'events.loc' : {$near : [-90.0, 43.0]}}","Selector");
	}
	
	@Test
	public void testBadSelector() {		
		String s = "x";
		testParserRuleErrors(s, "Selector", "missing '{' at 'x'");
		s = "id=='985152001389613'";
		testParserRuleErrors(s, "Selector", "missing '{' at 'id'");
	}

	
	 @Test
	 public final void readFile() {
	 testFile("test1.mongojquery");
	 }
	 
	 @Test
	 public final void readFile2() {
	 testFile("test2.mongojquery");
	 }
}
