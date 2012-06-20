package org.json.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.json.mongoQuery.Array;
import org.json.mongoQuery.FieldSelection;
import org.json.mongoQuery.JsonDate;
import org.json.mongoQuery.MongoQueryPackage;
import org.json.mongoQuery.Query;
import org.json.mongoQuery.QueryObject;
import org.json.mongoQuery.Selection;
import org.json.mongoQuery.Selector;
import org.json.services.MongoQueryGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractMongoQuerySemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MongoQueryGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MongoQueryPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MongoQueryPackage.ARRAY:
				if(context == grammarAccess.getArrayRule()) {
					sequence_Array(context, (Array) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.FIELD_SELECTION:
				if(context == grammarAccess.getFieldSelectionRule()) {
					sequence_FieldSelection(context, (FieldSelection) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.JSON_DATE:
				if(context == grammarAccess.getDateFullRule()) {
					sequence_DateFull(context, (JsonDate) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDateMilliRule()) {
					sequence_DateMilli(context, (JsonDate) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDateNowRule()) {
					sequence_DateNow(context, (JsonDate) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDateStringRule()) {
					sequence_DateString(context, (JsonDate) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJsonDateRule()) {
					sequence_JsonDate(context, (JsonDate) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.QUERY:
				if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (Query) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getValueRule()) {
					sequence_Value(context, (Query) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.QUERY_OBJECT:
				if(context == grammarAccess.getQueryObjectRule()) {
					sequence_QueryObject(context, (QueryObject) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.SELECTION:
				if(context == grammarAccess.getSelectionRule()) {
					sequence_Selection(context, (Selection) semanticObject); 
					return; 
				}
				else break;
			case MongoQueryPackage.SELECTOR:
				if(context == grammarAccess.getSelectorRule()) {
					sequence_Selector(context, (Selector) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (values+=Value? values+=Value*)
	 */
	protected void sequence_Array(EObject context, Array semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (year=INT month=INT day=INT (hour=INT minute=INT second=INT millisecond=INT)?)
	 */
	protected void sequence_DateFull(EObject context, JsonDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     milliseconds=INT
	 */
	protected void sequence_DateMilli(EObject context, JsonDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {JsonDate}
	 */
	protected void sequence_DateNow(EObject context, JsonDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dateString=STRING
	 */
	protected void sequence_DateString(EObject context, JsonDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (key=STRING enabled=INT)
	 */
	protected void sequence_FieldSelection(EObject context, FieldSelection semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MongoQueryPackage.Literals.FIELD_SELECTION__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MongoQueryPackage.Literals.FIELD_SELECTION__KEY));
			if(transientValues.isValueTransient(semanticObject, MongoQueryPackage.Literals.FIELD_SELECTION__ENABLED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MongoQueryPackage.Literals.FIELD_SELECTION__ENABLED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFieldSelectionAccess().getKeySTRINGTerminalRuleCall_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getFieldSelectionAccess().getEnabledINTTerminalRuleCall_2_0(), semanticObject.getEnabled());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (milliseconds=INT | dateString=STRING | (year=INT month=INT day=INT (hour=INT minute=INT second=INT millisecond=INT)?))
	 */
	protected void sequence_JsonDate(EObject context, JsonDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (key=Key value=Value)
	 */
	protected void sequence_Member(EObject context, Query semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (members+=Member? members+=Member*)
	 */
	protected void sequence_QueryObject(EObject context, QueryObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (fields+=FieldSelection? fields+=FieldSelection*)
	 */
	protected void sequence_Selection(EObject context, Selection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (query=QueryObject selection=Selection?)
	 */
	protected void sequence_Selector(EObject context, Selector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         stringValue=Null | 
	 *         stringValue=Boolean | 
	 *         stringValue=STRING | 
	 *         stringValue=ID | 
	 *         numberValue=Number | 
	 *         dateValue=JsonDate | 
	 *         arrayValue=Array | 
	 *         integerValue=INT | 
	 *         objectValue=QueryObject
	 *     )
	 */
	protected void sequence_Value(EObject context, Query semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
