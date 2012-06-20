package com.verticon.mongo.json.query.tests;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.validation.ValidatorTester;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.json.MongoQueryInjectorProvider;
import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.MongoQueryFactory;
import org.json.mongoQuery.Selector;
import org.json.validation.MongoQueryJavaValidator;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(MongoQueryInjectorProvider.class)
public class MongoJsonQueryValidatorTestor extends AbstractXtextTests {

	@Inject
	Injector injector;
	
	@Inject
	MongoQueryJavaValidator validator;

	@Inject
	ParseHelper<Selector> parser;
	
	@org.junit.Test
	public void TestIt() throws Exception {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		System.out.println("->" + tester.validate(parser.parse(" { 'last_name' : 'Smith' } , { 'test' : 0 }")));
	}
	
	@org.junit.Test
	public void test_enabled_0() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		FieldSelection model = MongoQueryFactory.eINSTANCE.createFieldSelection();
		model.setEnabled(0);
		tester.validator().checkSelectionEnabledIsZeroOrOne(model);
		tester.diagnose().assertOK();
	}
	
	@org.junit.Test
	public void test_enabled_1() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		FieldSelection model = MongoQueryFactory.eINSTANCE.createFieldSelection();
		model.setEnabled(1);
		tester.validator().checkSelectionEnabledIsZeroOrOne(model);
		tester.diagnose().assertOK();
	}
	
	@org.junit.Test
	public void test_enable_2() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		FieldSelection model = MongoQueryFactory.eINSTANCE.createFieldSelection();
		model.setEnabled(2);
		
		tester.validator().checkSelectionEnabledIsZeroOrOne(model);		
		tester.diagnose().assertErrorContains(MongoQueryJavaValidator.FIELD_SELECTION_ERROR);
	}
	@org.junit.Test
	public void test_enable_3() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		FieldSelection model = MongoQueryFactory.eINSTANCE.createFieldSelection();
		model.setEnabled(3);
		tester.validator().checkSelectionEnabledIsZeroOrOne(model);
		tester.diagnose().assertErrorContains(MongoQueryJavaValidator.FIELD_SELECTION_ERROR);
	}
	
	@org.junit.Test
	public void test_date_string() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		JsonDate date = MongoQueryFactory.eINSTANCE.createJsonDate();
		date.setDateString("Wed, 09 Aug 1995 00:00:00 GMT");//December 17, 1995 03:24:00");
		tester.validator().checkDate(date);
		tester.diagnose().assertOK();
		
	}
	
	@org.junit.Test
	public void test_date_string_error() {
		ValidatorTester<MongoQueryJavaValidator> tester = new ValidatorTester<MongoQueryJavaValidator>(validator, injector);
		
		JsonDate date = MongoQueryFactory.eINSTANCE.createJsonDate();
		date.setDateString("December 17, 1995 03:24:00");
		tester.validator().checkDate(date);
		tester.diagnose().assertErrorContains("Unparseable date");
	}
}
