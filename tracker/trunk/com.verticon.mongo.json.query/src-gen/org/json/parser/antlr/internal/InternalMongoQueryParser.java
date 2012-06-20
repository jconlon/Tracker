package org.json.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.json.services.MongoQueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMongoQueryParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_NUMBER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'{'", "'}'", "':'", "'['", "']'", "'$lt'", "'$gt'", "'$gte'", "'$lte'", "'$all'", "'$exists'", "'$mod'", "'$ne'", "'$in'", "'$nin'", "'$not'", "'$or'", "'$and'", "'$size'", "'$type'", "'$near'", "'$maxDistance'", "'true'", "'false'", "'null'", "'new Date()'", "'new Date('", "')'"
    };
    public static final int RULE_ID=6;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int RULE_NUMBER=7;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalMongoQueryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMongoQueryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMongoQueryParser.tokenNames; }
    public String getGrammarFileName() { return "../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g"; }



     	private MongoQueryGrammarAccess grammarAccess;
     	
        public InternalMongoQueryParser(TokenStream input, MongoQueryGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Selector";	
       	}
       	
       	@Override
       	protected MongoQueryGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSelector"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:67:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:68:2: (iv_ruleSelector= ruleSelector EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:69:2: iv_ruleSelector= ruleSelector EOF
            {
             newCompositeNode(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector75);
            iv_ruleSelector=ruleSelector();

            state._fsp--;

             current =iv_ruleSelector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:76:1: ruleSelector returns [EObject current=null] : ( ( (lv_query_0_0= ruleQueryObject ) ) (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )? ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_query_0_0 = null;

        EObject lv_selection_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:79:28: ( ( ( (lv_query_0_0= ruleQueryObject ) ) (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )? ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:80:1: ( ( (lv_query_0_0= ruleQueryObject ) ) (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )? )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:80:1: ( ( (lv_query_0_0= ruleQueryObject ) ) (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )? )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:80:2: ( (lv_query_0_0= ruleQueryObject ) ) (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )?
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:80:2: ( (lv_query_0_0= ruleQueryObject ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:81:1: (lv_query_0_0= ruleQueryObject )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:81:1: (lv_query_0_0= ruleQueryObject )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:82:3: lv_query_0_0= ruleQueryObject
            {
             
            	        newCompositeNode(grammarAccess.getSelectorAccess().getQueryQueryObjectParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryObject_in_ruleSelector131);
            lv_query_0_0=ruleQueryObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectorRule());
            	        }
                   		set(
                   			current, 
                   			"query",
                    		lv_query_0_0, 
                    		"QueryObject");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:98:2: (otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:98:4: otherlv_1= ',' ( (lv_selection_2_0= ruleSelection ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleSelector144); 

                        	newLeafNode(otherlv_1, grammarAccess.getSelectorAccess().getCommaKeyword_1_0());
                        
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:102:1: ( (lv_selection_2_0= ruleSelection ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:103:1: (lv_selection_2_0= ruleSelection )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:103:1: (lv_selection_2_0= ruleSelection )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:104:3: lv_selection_2_0= ruleSelection
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectorAccess().getSelectionSelectionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSelection_in_ruleSelector165);
                    lv_selection_2_0=ruleSelection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectorRule());
                    	        }
                           		set(
                           			current, 
                           			"selection",
                            		lv_selection_2_0, 
                            		"Selection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleSelection"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:128:1: entryRuleSelection returns [EObject current=null] : iv_ruleSelection= ruleSelection EOF ;
    public final EObject entryRuleSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelection = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:129:2: (iv_ruleSelection= ruleSelection EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:130:2: iv_ruleSelection= ruleSelection EOF
            {
             newCompositeNode(grammarAccess.getSelectionRule()); 
            pushFollow(FOLLOW_ruleSelection_in_entryRuleSelection203);
            iv_ruleSelection=ruleSelection();

            state._fsp--;

             current =iv_ruleSelection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelection213); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelection"


    // $ANTLR start "ruleSelection"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:137:1: ruleSelection returns [EObject current=null] : (otherlv_0= '{' () ( (lv_fields_2_0= ruleFieldSelection ) )? (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_fields_2_0 = null;

        EObject lv_fields_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:140:28: ( (otherlv_0= '{' () ( (lv_fields_2_0= ruleFieldSelection ) )? (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )* otherlv_5= '}' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:141:1: (otherlv_0= '{' () ( (lv_fields_2_0= ruleFieldSelection ) )? (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )* otherlv_5= '}' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:141:1: (otherlv_0= '{' () ( (lv_fields_2_0= ruleFieldSelection ) )? (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )* otherlv_5= '}' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:141:3: otherlv_0= '{' () ( (lv_fields_2_0= ruleFieldSelection ) )? (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleSelection250); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_0());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:145:1: ()
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:146:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSelectionAccess().getSelectionAction_1(),
                        current);
                

            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:151:2: ( (lv_fields_2_0= ruleFieldSelection ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:152:1: (lv_fields_2_0= ruleFieldSelection )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:152:1: (lv_fields_2_0= ruleFieldSelection )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:153:3: lv_fields_2_0= ruleFieldSelection
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFieldSelection_in_ruleSelection280);
                    lv_fields_2_0=ruleFieldSelection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectionRule());
                    	        }
                           		add(
                           			current, 
                           			"fields",
                            		lv_fields_2_0, 
                            		"FieldSelection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:169:3: (otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:169:5: otherlv_3= ',' ( (lv_fields_4_0= ruleFieldSelection ) )
            	    {
            	    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleSelection294); 

            	        	newLeafNode(otherlv_3, grammarAccess.getSelectionAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:173:1: ( (lv_fields_4_0= ruleFieldSelection ) )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:174:1: (lv_fields_4_0= ruleFieldSelection )
            	    {
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:174:1: (lv_fields_4_0= ruleFieldSelection )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:175:3: lv_fields_4_0= ruleFieldSelection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFieldSelection_in_ruleSelection315);
            	    lv_fields_4_0=ruleFieldSelection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSelectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fields",
            	            		lv_fields_4_0, 
            	            		"FieldSelection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleSelection329); 

                	newLeafNode(otherlv_5, grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelection"


    // $ANTLR start "entryRuleFieldSelection"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:203:1: entryRuleFieldSelection returns [EObject current=null] : iv_ruleFieldSelection= ruleFieldSelection EOF ;
    public final EObject entryRuleFieldSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldSelection = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:204:2: (iv_ruleFieldSelection= ruleFieldSelection EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:205:2: iv_ruleFieldSelection= ruleFieldSelection EOF
            {
             newCompositeNode(grammarAccess.getFieldSelectionRule()); 
            pushFollow(FOLLOW_ruleFieldSelection_in_entryRuleFieldSelection365);
            iv_ruleFieldSelection=ruleFieldSelection();

            state._fsp--;

             current =iv_ruleFieldSelection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldSelection375); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldSelection"


    // $ANTLR start "ruleFieldSelection"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:212:1: ruleFieldSelection returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_enabled_2_0= RULE_INT ) ) ) ;
    public final EObject ruleFieldSelection() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_enabled_2_0=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:215:28: ( ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_enabled_2_0= RULE_INT ) ) ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:216:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_enabled_2_0= RULE_INT ) ) )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:216:1: ( ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_enabled_2_0= RULE_INT ) ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:216:2: ( (lv_key_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_enabled_2_0= RULE_INT ) )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:216:2: ( (lv_key_0_0= RULE_STRING ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:217:1: (lv_key_0_0= RULE_STRING )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:217:1: (lv_key_0_0= RULE_STRING )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:218:3: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFieldSelection417); 

            			newLeafNode(lv_key_0_0, grammarAccess.getFieldSelectionAccess().getKeySTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldSelectionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleFieldSelection434); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldSelectionAccess().getColonKeyword_1());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:238:1: ( (lv_enabled_2_0= RULE_INT ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:239:1: (lv_enabled_2_0= RULE_INT )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:239:1: (lv_enabled_2_0= RULE_INT )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:240:3: lv_enabled_2_0= RULE_INT
            {
            lv_enabled_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFieldSelection451); 

            			newLeafNode(lv_enabled_2_0, grammarAccess.getFieldSelectionAccess().getEnabledINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldSelectionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"enabled",
                    		lv_enabled_2_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldSelection"


    // $ANTLR start "entryRuleQueryObject"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:264:1: entryRuleQueryObject returns [EObject current=null] : iv_ruleQueryObject= ruleQueryObject EOF ;
    public final EObject entryRuleQueryObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryObject = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:265:2: (iv_ruleQueryObject= ruleQueryObject EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:266:2: iv_ruleQueryObject= ruleQueryObject EOF
            {
             newCompositeNode(grammarAccess.getQueryObjectRule()); 
            pushFollow(FOLLOW_ruleQueryObject_in_entryRuleQueryObject492);
            iv_ruleQueryObject=ruleQueryObject();

            state._fsp--;

             current =iv_ruleQueryObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryObject502); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryObject"


    // $ANTLR start "ruleQueryObject"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:273:1: ruleQueryObject returns [EObject current=null] : (otherlv_0= '{' () ( (lv_members_2_0= ruleMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleQueryObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:276:28: ( (otherlv_0= '{' () ( (lv_members_2_0= ruleMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )* otherlv_5= '}' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:277:1: (otherlv_0= '{' () ( (lv_members_2_0= ruleMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )* otherlv_5= '}' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:277:1: (otherlv_0= '{' () ( (lv_members_2_0= ruleMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )* otherlv_5= '}' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:277:3: otherlv_0= '{' () ( (lv_members_2_0= ruleMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleQueryObject539); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryObjectAccess().getLeftCurlyBracketKeyword_0());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:281:1: ()
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:282:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQueryObjectAccess().getQueryObjectAction_1(),
                        current);
                

            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:287:2: ( (lv_members_2_0= ruleMember ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING||LA4_0==RULE_ID||(LA4_0>=18 && LA4_0<=34)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:288:1: (lv_members_2_0= ruleMember )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:288:1: (lv_members_2_0= ruleMember )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:289:3: lv_members_2_0= ruleMember
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMember_in_ruleQueryObject569);
                    lv_members_2_0=ruleMember();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"members",
                            		lv_members_2_0, 
                            		"Member");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:305:3: (otherlv_3= ',' ( (lv_members_4_0= ruleMember ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:305:5: otherlv_3= ',' ( (lv_members_4_0= ruleMember ) )
            	    {
            	    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleQueryObject583); 

            	        	newLeafNode(otherlv_3, grammarAccess.getQueryObjectAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:309:1: ( (lv_members_4_0= ruleMember ) )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:310:1: (lv_members_4_0= ruleMember )
            	    {
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:310:1: (lv_members_4_0= ruleMember )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:311:3: lv_members_4_0= ruleMember
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMember_in_ruleQueryObject604);
            	    lv_members_4_0=ruleMember();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryObjectRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"members",
            	            		lv_members_4_0, 
            	            		"Member");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleQueryObject618); 

                	newLeafNode(otherlv_5, grammarAccess.getQueryObjectAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryObject"


    // $ANTLR start "entryRuleMember"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:339:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:340:2: (iv_ruleMember= ruleMember EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:341:2: iv_ruleMember= ruleMember EOF
            {
             newCompositeNode(grammarAccess.getMemberRule()); 
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember654);
            iv_ruleMember=ruleMember();

            state._fsp--;

             current =iv_ruleMember; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember664); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:348:1: ruleMember returns [EObject current=null] : ( ( (lv_key_0_0= ruleKey ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:351:28: ( ( ( (lv_key_0_0= ruleKey ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:352:1: ( ( (lv_key_0_0= ruleKey ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:352:1: ( ( (lv_key_0_0= ruleKey ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:352:2: ( (lv_key_0_0= ruleKey ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:352:2: ( (lv_key_0_0= ruleKey ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:353:1: (lv_key_0_0= ruleKey )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:353:1: (lv_key_0_0= ruleKey )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:354:3: lv_key_0_0= ruleKey
            {
             
            	        newCompositeNode(grammarAccess.getMemberAccess().getKeyKeyParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleKey_in_ruleMember710);
            lv_key_0_0=ruleKey();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMemberRule());
            	        }
                   		set(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"Key");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMember722); 

                	newLeafNode(otherlv_1, grammarAccess.getMemberAccess().getColonKeyword_1());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:374:1: ( (lv_value_2_0= ruleValue ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:375:1: (lv_value_2_0= ruleValue )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:375:1: (lv_value_2_0= ruleValue )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:376:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getMemberAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleMember743);
            lv_value_2_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMemberRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Value");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleValue"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:400:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:401:2: (iv_ruleValue= ruleValue EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:402:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue779);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue789); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:409:1: ruleValue returns [EObject current=null] : ( ( (lv_stringValue_0_0= ruleNull ) ) | ( (lv_stringValue_1_0= ruleBoolean ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_stringValue_3_0= RULE_ID ) ) | ( (lv_numberValue_4_0= RULE_NUMBER ) ) | ( (lv_dateValue_5_0= ruleJsonDate ) ) | ( (lv_arrayValue_6_0= ruleArray ) ) | ( (lv_integerValue_7_0= RULE_INT ) ) | ( (lv_objectValue_8_0= ruleQueryObject ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_2_0=null;
        Token lv_stringValue_3_0=null;
        Token lv_numberValue_4_0=null;
        Token lv_integerValue_7_0=null;
        AntlrDatatypeRuleToken lv_stringValue_0_0 = null;

        AntlrDatatypeRuleToken lv_stringValue_1_0 = null;

        EObject lv_dateValue_5_0 = null;

        EObject lv_arrayValue_6_0 = null;

        EObject lv_objectValue_8_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:412:28: ( ( ( (lv_stringValue_0_0= ruleNull ) ) | ( (lv_stringValue_1_0= ruleBoolean ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_stringValue_3_0= RULE_ID ) ) | ( (lv_numberValue_4_0= RULE_NUMBER ) ) | ( (lv_dateValue_5_0= ruleJsonDate ) ) | ( (lv_arrayValue_6_0= ruleArray ) ) | ( (lv_integerValue_7_0= RULE_INT ) ) | ( (lv_objectValue_8_0= ruleQueryObject ) ) ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:413:1: ( ( (lv_stringValue_0_0= ruleNull ) ) | ( (lv_stringValue_1_0= ruleBoolean ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_stringValue_3_0= RULE_ID ) ) | ( (lv_numberValue_4_0= RULE_NUMBER ) ) | ( (lv_dateValue_5_0= ruleJsonDate ) ) | ( (lv_arrayValue_6_0= ruleArray ) ) | ( (lv_integerValue_7_0= RULE_INT ) ) | ( (lv_objectValue_8_0= ruleQueryObject ) ) )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:413:1: ( ( (lv_stringValue_0_0= ruleNull ) ) | ( (lv_stringValue_1_0= ruleBoolean ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_stringValue_3_0= RULE_ID ) ) | ( (lv_numberValue_4_0= RULE_NUMBER ) ) | ( (lv_dateValue_5_0= ruleJsonDate ) ) | ( (lv_arrayValue_6_0= ruleArray ) ) | ( (lv_integerValue_7_0= RULE_INT ) ) | ( (lv_objectValue_8_0= ruleQueryObject ) ) )
            int alt6=9;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt6=1;
                }
                break;
            case 35:
            case 36:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
                {
                alt6=3;
                }
                break;
            case RULE_ID:
                {
                alt6=4;
                }
                break;
            case RULE_NUMBER:
                {
                alt6=5;
                }
                break;
            case 38:
            case 39:
                {
                alt6=6;
                }
                break;
            case 16:
                {
                alt6=7;
                }
                break;
            case RULE_INT:
                {
                alt6=8;
                }
                break;
            case 13:
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:413:2: ( (lv_stringValue_0_0= ruleNull ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:413:2: ( (lv_stringValue_0_0= ruleNull ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:414:1: (lv_stringValue_0_0= ruleNull )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:414:1: (lv_stringValue_0_0= ruleNull )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:415:3: lv_stringValue_0_0= ruleNull
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getStringValueNullParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNull_in_ruleValue835);
                    lv_stringValue_0_0=ruleNull();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"stringValue",
                            		lv_stringValue_0_0, 
                            		"Null");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:432:6: ( (lv_stringValue_1_0= ruleBoolean ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:432:6: ( (lv_stringValue_1_0= ruleBoolean ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:433:1: (lv_stringValue_1_0= ruleBoolean )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:433:1: (lv_stringValue_1_0= ruleBoolean )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:434:3: lv_stringValue_1_0= ruleBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getStringValueBooleanParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBoolean_in_ruleValue862);
                    lv_stringValue_1_0=ruleBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"stringValue",
                            		lv_stringValue_1_0, 
                            		"Boolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:451:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:451:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:452:1: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:452:1: (lv_stringValue_2_0= RULE_STRING )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:453:3: lv_stringValue_2_0= RULE_STRING
                    {
                    lv_stringValue_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValue885); 

                    			newLeafNode(lv_stringValue_2_0, grammarAccess.getValueAccess().getStringValueSTRINGTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringValue",
                            		lv_stringValue_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:470:6: ( (lv_stringValue_3_0= RULE_ID ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:470:6: ( (lv_stringValue_3_0= RULE_ID ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:471:1: (lv_stringValue_3_0= RULE_ID )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:471:1: (lv_stringValue_3_0= RULE_ID )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:472:3: lv_stringValue_3_0= RULE_ID
                    {
                    lv_stringValue_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValue913); 

                    			newLeafNode(lv_stringValue_3_0, grammarAccess.getValueAccess().getStringValueIDTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringValue",
                            		lv_stringValue_3_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:489:6: ( (lv_numberValue_4_0= RULE_NUMBER ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:489:6: ( (lv_numberValue_4_0= RULE_NUMBER ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:490:1: (lv_numberValue_4_0= RULE_NUMBER )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:490:1: (lv_numberValue_4_0= RULE_NUMBER )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:491:3: lv_numberValue_4_0= RULE_NUMBER
                    {
                    lv_numberValue_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleValue941); 

                    			newLeafNode(lv_numberValue_4_0, grammarAccess.getValueAccess().getNumberValueNumberTerminalRuleCall_4_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"numberValue",
                            		lv_numberValue_4_0, 
                            		"Number");
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:508:6: ( (lv_dateValue_5_0= ruleJsonDate ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:508:6: ( (lv_dateValue_5_0= ruleJsonDate ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:509:1: (lv_dateValue_5_0= ruleJsonDate )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:509:1: (lv_dateValue_5_0= ruleJsonDate )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:510:3: lv_dateValue_5_0= ruleJsonDate
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getDateValueJsonDateParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleJsonDate_in_ruleValue973);
                    lv_dateValue_5_0=ruleJsonDate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"dateValue",
                            		lv_dateValue_5_0, 
                            		"JsonDate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:527:6: ( (lv_arrayValue_6_0= ruleArray ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:527:6: ( (lv_arrayValue_6_0= ruleArray ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:528:1: (lv_arrayValue_6_0= ruleArray )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:528:1: (lv_arrayValue_6_0= ruleArray )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:529:3: lv_arrayValue_6_0= ruleArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getArrayValueArrayParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArray_in_ruleValue1000);
                    lv_arrayValue_6_0=ruleArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"arrayValue",
                            		lv_arrayValue_6_0, 
                            		"Array");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:546:6: ( (lv_integerValue_7_0= RULE_INT ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:546:6: ( (lv_integerValue_7_0= RULE_INT ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:547:1: (lv_integerValue_7_0= RULE_INT )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:547:1: (lv_integerValue_7_0= RULE_INT )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:548:3: lv_integerValue_7_0= RULE_INT
                    {
                    lv_integerValue_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleValue1023); 

                    			newLeafNode(lv_integerValue_7_0, grammarAccess.getValueAccess().getIntegerValueINTTerminalRuleCall_7_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"integerValue",
                            		lv_integerValue_7_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:565:6: ( (lv_objectValue_8_0= ruleQueryObject ) )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:565:6: ( (lv_objectValue_8_0= ruleQueryObject ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:566:1: (lv_objectValue_8_0= ruleQueryObject )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:566:1: (lv_objectValue_8_0= ruleQueryObject )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:567:3: lv_objectValue_8_0= ruleQueryObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getObjectValueQueryObjectParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryObject_in_ruleValue1055);
                    lv_objectValue_8_0=ruleQueryObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"objectValue",
                            		lv_objectValue_8_0, 
                            		"QueryObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleArray"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:591:1: entryRuleArray returns [EObject current=null] : iv_ruleArray= ruleArray EOF ;
    public final EObject entryRuleArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArray = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:592:2: (iv_ruleArray= ruleArray EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:593:2: iv_ruleArray= ruleArray EOF
            {
             newCompositeNode(grammarAccess.getArrayRule()); 
            pushFollow(FOLLOW_ruleArray_in_entryRuleArray1091);
            iv_ruleArray=ruleArray();

            state._fsp--;

             current =iv_ruleArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArray1101); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArray"


    // $ANTLR start "ruleArray"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:600:1: ruleArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:603:28: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* otherlv_5= ']' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:604:1: ( () otherlv_1= '[' ( (lv_values_2_0= ruleValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* otherlv_5= ']' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:604:1: ( () otherlv_1= '[' ( (lv_values_2_0= ruleValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* otherlv_5= ']' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:604:2: () otherlv_1= '[' ( (lv_values_2_0= ruleValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* otherlv_5= ']'
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:604:2: ()
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:605:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayAccess().getArrayAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleArray1147); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayAccess().getLeftSquareBracketKeyword_1());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:614:1: ( (lv_values_2_0= ruleValue ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_NUMBER)||LA7_0==13||LA7_0==16||(LA7_0>=35 && LA7_0<=39)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:615:1: (lv_values_2_0= ruleValue )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:615:1: (lv_values_2_0= ruleValue )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:616:3: lv_values_2_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValue_in_ruleArray1168);
                    lv_values_2_0=ruleValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrayRule());
                    	        }
                           		add(
                           			current, 
                           			"values",
                            		lv_values_2_0, 
                            		"Value");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:632:3: (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==12) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:632:5: otherlv_3= ',' ( (lv_values_4_0= ruleValue ) )
            	    {
            	    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleArray1182); 

            	        	newLeafNode(otherlv_3, grammarAccess.getArrayAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:636:1: ( (lv_values_4_0= ruleValue ) )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:637:1: (lv_values_4_0= ruleValue )
            	    {
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:637:1: (lv_values_4_0= ruleValue )
            	    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:638:3: lv_values_4_0= ruleValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValue_in_ruleArray1203);
            	    lv_values_4_0=ruleValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getArrayRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_4_0, 
            	            		"Value");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleArray1217); 

                	newLeafNode(otherlv_5, grammarAccess.getArrayAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArray"


    // $ANTLR start "entryRuleKey"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:666:1: entryRuleKey returns [String current=null] : iv_ruleKey= ruleKey EOF ;
    public final String entryRuleKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKey = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:667:2: (iv_ruleKey= ruleKey EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:668:2: iv_ruleKey= ruleKey EOF
            {
             newCompositeNode(grammarAccess.getKeyRule()); 
            pushFollow(FOLLOW_ruleKey_in_entryRuleKey1254);
            iv_ruleKey=ruleKey();

            state._fsp--;

             current =iv_ruleKey.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKey1265); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKey"


    // $ANTLR start "ruleKey"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:675:1: ruleKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Conditional_0= ruleConditional | this_ID_1= RULE_ID | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_1=null;
        Token this_STRING_2=null;
        AntlrDatatypeRuleToken this_Conditional_0 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:678:28: ( (this_Conditional_0= ruleConditional | this_ID_1= RULE_ID | this_STRING_2= RULE_STRING ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:679:1: (this_Conditional_0= ruleConditional | this_ID_1= RULE_ID | this_STRING_2= RULE_STRING )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:679:1: (this_Conditional_0= ruleConditional | this_ID_1= RULE_ID | this_STRING_2= RULE_STRING )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt9=1;
                }
                break;
            case RULE_ID:
                {
                alt9=2;
                }
                break;
            case RULE_STRING:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:680:5: this_Conditional_0= ruleConditional
                    {
                     
                            newCompositeNode(grammarAccess.getKeyAccess().getConditionalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleConditional_in_ruleKey1312);
                    this_Conditional_0=ruleConditional();

                    state._fsp--;


                    		current.merge(this_Conditional_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:691:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKey1338); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getKeyAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:699:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKey1364); 

                    		current.merge(this_STRING_2);
                        
                     
                        newLeafNode(this_STRING_2, grammarAccess.getKeyAccess().getSTRINGTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKey"


    // $ANTLR start "entryRuleConditional"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:714:1: entryRuleConditional returns [String current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final String entryRuleConditional() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConditional = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:715:2: (iv_ruleConditional= ruleConditional EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:716:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_ruleConditional_in_entryRuleConditional1410);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditional1421); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:723:1: ruleConditional returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '$lt' | kw= '$gt' | kw= '$gte' | kw= '$lte' | kw= '$all' | kw= '$exists' | kw= '$mod' | kw= '$ne' | kw= '$in' | kw= '$nin' | kw= '$not' | kw= '$or' | kw= '$and' | kw= '$size' | kw= '$type' | kw= '$near' | kw= '$maxDistance' ) ;
    public final AntlrDatatypeRuleToken ruleConditional() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:726:28: ( (kw= '$lt' | kw= '$gt' | kw= '$gte' | kw= '$lte' | kw= '$all' | kw= '$exists' | kw= '$mod' | kw= '$ne' | kw= '$in' | kw= '$nin' | kw= '$not' | kw= '$or' | kw= '$and' | kw= '$size' | kw= '$type' | kw= '$near' | kw= '$maxDistance' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:727:1: (kw= '$lt' | kw= '$gt' | kw= '$gte' | kw= '$lte' | kw= '$all' | kw= '$exists' | kw= '$mod' | kw= '$ne' | kw= '$in' | kw= '$nin' | kw= '$not' | kw= '$or' | kw= '$and' | kw= '$size' | kw= '$type' | kw= '$near' | kw= '$maxDistance' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:727:1: (kw= '$lt' | kw= '$gt' | kw= '$gte' | kw= '$lte' | kw= '$all' | kw= '$exists' | kw= '$mod' | kw= '$ne' | kw= '$in' | kw= '$nin' | kw= '$not' | kw= '$or' | kw= '$and' | kw= '$size' | kw= '$type' | kw= '$near' | kw= '$maxDistance' )
            int alt10=17;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt10=1;
                }
                break;
            case 19:
                {
                alt10=2;
                }
                break;
            case 20:
                {
                alt10=3;
                }
                break;
            case 21:
                {
                alt10=4;
                }
                break;
            case 22:
                {
                alt10=5;
                }
                break;
            case 23:
                {
                alt10=6;
                }
                break;
            case 24:
                {
                alt10=7;
                }
                break;
            case 25:
                {
                alt10=8;
                }
                break;
            case 26:
                {
                alt10=9;
                }
                break;
            case 27:
                {
                alt10=10;
                }
                break;
            case 28:
                {
                alt10=11;
                }
                break;
            case 29:
                {
                alt10=12;
                }
                break;
            case 30:
                {
                alt10=13;
                }
                break;
            case 31:
                {
                alt10=14;
                }
                break;
            case 32:
                {
                alt10=15;
                }
                break;
            case 33:
                {
                alt10=16;
                }
                break;
            case 34:
                {
                alt10=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:728:2: kw= '$lt'
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleConditional1459); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getLtKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:735:2: kw= '$gt'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleConditional1478); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getGtKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:742:2: kw= '$gte'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleConditional1497); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getGteKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:749:2: kw= '$lte'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleConditional1516); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getLteKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:756:2: kw= '$all'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleConditional1535); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getAllKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:763:2: kw= '$exists'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleConditional1554); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getExistsKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:770:2: kw= '$mod'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleConditional1573); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getModKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:777:2: kw= '$ne'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleConditional1592); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getNeKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:784:2: kw= '$in'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleConditional1611); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getInKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:791:2: kw= '$nin'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleConditional1630); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getNinKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:798:2: kw= '$not'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleConditional1649); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getNotKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:805:2: kw= '$or'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleConditional1668); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getOrKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:812:2: kw= '$and'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleConditional1687); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getAndKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:819:2: kw= '$size'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleConditional1706); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getSizeKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:826:2: kw= '$type'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleConditional1725); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getTypeKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:833:2: kw= '$near'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleConditional1744); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getNearKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:840:2: kw= '$maxDistance'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleConditional1763); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConditionalAccess().getMaxDistanceKeyword_16()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleBoolean"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:853:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:854:2: (iv_ruleBoolean= ruleBoolean EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:855:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean1804);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean1815); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:862:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:865:28: ( (kw= 'true' | kw= 'false' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:866:1: (kw= 'true' | kw= 'false' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:866:1: (kw= 'true' | kw= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==35) ) {
                alt11=1;
            }
            else if ( (LA11_0==36) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:867:2: kw= 'true'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleBoolean1853); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:874:2: kw= 'false'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleBoolean1872); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleNull"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:887:1: entryRuleNull returns [String current=null] : iv_ruleNull= ruleNull EOF ;
    public final String entryRuleNull() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNull = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:888:2: (iv_ruleNull= ruleNull EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:889:2: iv_ruleNull= ruleNull EOF
            {
             newCompositeNode(grammarAccess.getNullRule()); 
            pushFollow(FOLLOW_ruleNull_in_entryRuleNull1913);
            iv_ruleNull=ruleNull();

            state._fsp--;

             current =iv_ruleNull.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNull1924); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNull"


    // $ANTLR start "ruleNull"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:896:1: ruleNull returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'null' ;
    public final AntlrDatatypeRuleToken ruleNull() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:899:28: (kw= 'null' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:901:2: kw= 'null'
            {
            kw=(Token)match(input,37,FOLLOW_37_in_ruleNull1961); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNullAccess().getNullKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNull"


    // $ANTLR start "entryRuleJsonDate"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:914:1: entryRuleJsonDate returns [EObject current=null] : iv_ruleJsonDate= ruleJsonDate EOF ;
    public final EObject entryRuleJsonDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDate = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:915:2: (iv_ruleJsonDate= ruleJsonDate EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:916:2: iv_ruleJsonDate= ruleJsonDate EOF
            {
             newCompositeNode(grammarAccess.getJsonDateRule()); 
            pushFollow(FOLLOW_ruleJsonDate_in_entryRuleJsonDate2000);
            iv_ruleJsonDate=ruleJsonDate();

            state._fsp--;

             current =iv_ruleJsonDate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJsonDate2010); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonDate"


    // $ANTLR start "ruleJsonDate"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:923:1: ruleJsonDate returns [EObject current=null] : (this_DateNow_0= ruleDateNow | this_DateMilli_1= ruleDateMilli | this_DateString_2= ruleDateString | this_DateFull_3= ruleDateFull ) ;
    public final EObject ruleJsonDate() throws RecognitionException {
        EObject current = null;

        EObject this_DateNow_0 = null;

        EObject this_DateMilli_1 = null;

        EObject this_DateString_2 = null;

        EObject this_DateFull_3 = null;


         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:926:28: ( (this_DateNow_0= ruleDateNow | this_DateMilli_1= ruleDateMilli | this_DateString_2= ruleDateString | this_DateFull_3= ruleDateFull ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:927:1: (this_DateNow_0= ruleDateNow | this_DateMilli_1= ruleDateMilli | this_DateString_2= ruleDateString | this_DateFull_3= ruleDateFull )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:927:1: (this_DateNow_0= ruleDateNow | this_DateMilli_1= ruleDateMilli | this_DateString_2= ruleDateString | this_DateFull_3= ruleDateFull )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==38) ) {
                alt12=1;
            }
            else if ( (LA12_0==39) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==RULE_INT) ) {
                    int LA12_3 = input.LA(3);

                    if ( (LA12_3==40) ) {
                        alt12=2;
                    }
                    else if ( (LA12_3==12) ) {
                        alt12=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA12_2==RULE_STRING) ) {
                    alt12=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:928:5: this_DateNow_0= ruleDateNow
                    {
                     
                            newCompositeNode(grammarAccess.getJsonDateAccess().getDateNowParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDateNow_in_ruleJsonDate2057);
                    this_DateNow_0=ruleDateNow();

                    state._fsp--;

                     
                            current = this_DateNow_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:938:5: this_DateMilli_1= ruleDateMilli
                    {
                     
                            newCompositeNode(grammarAccess.getJsonDateAccess().getDateMilliParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDateMilli_in_ruleJsonDate2084);
                    this_DateMilli_1=ruleDateMilli();

                    state._fsp--;

                     
                            current = this_DateMilli_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:948:5: this_DateString_2= ruleDateString
                    {
                     
                            newCompositeNode(grammarAccess.getJsonDateAccess().getDateStringParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDateString_in_ruleJsonDate2111);
                    this_DateString_2=ruleDateString();

                    state._fsp--;

                     
                            current = this_DateString_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:958:5: this_DateFull_3= ruleDateFull
                    {
                     
                            newCompositeNode(grammarAccess.getJsonDateAccess().getDateFullParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDateFull_in_ruleJsonDate2138);
                    this_DateFull_3=ruleDateFull();

                    state._fsp--;

                     
                            current = this_DateFull_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonDate"


    // $ANTLR start "entryRuleDateNow"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:974:1: entryRuleDateNow returns [EObject current=null] : iv_ruleDateNow= ruleDateNow EOF ;
    public final EObject entryRuleDateNow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateNow = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:975:2: (iv_ruleDateNow= ruleDateNow EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:976:2: iv_ruleDateNow= ruleDateNow EOF
            {
             newCompositeNode(grammarAccess.getDateNowRule()); 
            pushFollow(FOLLOW_ruleDateNow_in_entryRuleDateNow2173);
            iv_ruleDateNow=ruleDateNow();

            state._fsp--;

             current =iv_ruleDateNow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateNow2183); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateNow"


    // $ANTLR start "ruleDateNow"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:983:1: ruleDateNow returns [EObject current=null] : ( () otherlv_1= 'new Date()' ) ;
    public final EObject ruleDateNow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:986:28: ( ( () otherlv_1= 'new Date()' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:987:1: ( () otherlv_1= 'new Date()' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:987:1: ( () otherlv_1= 'new Date()' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:987:2: () otherlv_1= 'new Date()'
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:987:2: ()
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:988:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDateNowAccess().getJsonDateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleDateNow2229); 

                	newLeafNode(otherlv_1, grammarAccess.getDateNowAccess().getNewDateKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateNow"


    // $ANTLR start "entryRuleDateMilli"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1005:1: entryRuleDateMilli returns [EObject current=null] : iv_ruleDateMilli= ruleDateMilli EOF ;
    public final EObject entryRuleDateMilli() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateMilli = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1006:2: (iv_ruleDateMilli= ruleDateMilli EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1007:2: iv_ruleDateMilli= ruleDateMilli EOF
            {
             newCompositeNode(grammarAccess.getDateMilliRule()); 
            pushFollow(FOLLOW_ruleDateMilli_in_entryRuleDateMilli2265);
            iv_ruleDateMilli=ruleDateMilli();

            state._fsp--;

             current =iv_ruleDateMilli; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateMilli2275); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateMilli"


    // $ANTLR start "ruleDateMilli"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1014:1: ruleDateMilli returns [EObject current=null] : (otherlv_0= 'new Date(' ( (lv_milliseconds_1_0= RULE_INT ) ) otherlv_2= ')' ) ;
    public final EObject ruleDateMilli() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_milliseconds_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1017:28: ( (otherlv_0= 'new Date(' ( (lv_milliseconds_1_0= RULE_INT ) ) otherlv_2= ')' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1018:1: (otherlv_0= 'new Date(' ( (lv_milliseconds_1_0= RULE_INT ) ) otherlv_2= ')' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1018:1: (otherlv_0= 'new Date(' ( (lv_milliseconds_1_0= RULE_INT ) ) otherlv_2= ')' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1018:3: otherlv_0= 'new Date(' ( (lv_milliseconds_1_0= RULE_INT ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleDateMilli2312); 

                	newLeafNode(otherlv_0, grammarAccess.getDateMilliAccess().getNewDateKeyword_0());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1022:1: ( (lv_milliseconds_1_0= RULE_INT ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1023:1: (lv_milliseconds_1_0= RULE_INT )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1023:1: (lv_milliseconds_1_0= RULE_INT )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1024:3: lv_milliseconds_1_0= RULE_INT
            {
            lv_milliseconds_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateMilli2329); 

            			newLeafNode(lv_milliseconds_1_0, grammarAccess.getDateMilliAccess().getMillisecondsINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateMilliRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"milliseconds",
                    		lv_milliseconds_1_0, 
                    		"INT");
            	    

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleDateMilli2346); 

                	newLeafNode(otherlv_2, grammarAccess.getDateMilliAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateMilli"


    // $ANTLR start "entryRuleDateString"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1052:1: entryRuleDateString returns [EObject current=null] : iv_ruleDateString= ruleDateString EOF ;
    public final EObject entryRuleDateString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateString = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1053:2: (iv_ruleDateString= ruleDateString EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1054:2: iv_ruleDateString= ruleDateString EOF
            {
             newCompositeNode(grammarAccess.getDateStringRule()); 
            pushFollow(FOLLOW_ruleDateString_in_entryRuleDateString2382);
            iv_ruleDateString=ruleDateString();

            state._fsp--;

             current =iv_ruleDateString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateString2392); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateString"


    // $ANTLR start "ruleDateString"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1061:1: ruleDateString returns [EObject current=null] : (otherlv_0= 'new Date(' ( (lv_dateString_1_0= RULE_STRING ) ) otherlv_2= ')' ) ;
    public final EObject ruleDateString() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_dateString_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1064:28: ( (otherlv_0= 'new Date(' ( (lv_dateString_1_0= RULE_STRING ) ) otherlv_2= ')' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1065:1: (otherlv_0= 'new Date(' ( (lv_dateString_1_0= RULE_STRING ) ) otherlv_2= ')' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1065:1: (otherlv_0= 'new Date(' ( (lv_dateString_1_0= RULE_STRING ) ) otherlv_2= ')' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1065:3: otherlv_0= 'new Date(' ( (lv_dateString_1_0= RULE_STRING ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleDateString2429); 

                	newLeafNode(otherlv_0, grammarAccess.getDateStringAccess().getNewDateKeyword_0());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1069:1: ( (lv_dateString_1_0= RULE_STRING ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1070:1: (lv_dateString_1_0= RULE_STRING )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1070:1: (lv_dateString_1_0= RULE_STRING )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1071:3: lv_dateString_1_0= RULE_STRING
            {
            lv_dateString_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDateString2446); 

            			newLeafNode(lv_dateString_1_0, grammarAccess.getDateStringAccess().getDateStringSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateStringRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateString",
                    		lv_dateString_1_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleDateString2463); 

                	newLeafNode(otherlv_2, grammarAccess.getDateStringAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateString"


    // $ANTLR start "entryRuleDateFull"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1099:1: entryRuleDateFull returns [EObject current=null] : iv_ruleDateFull= ruleDateFull EOF ;
    public final EObject entryRuleDateFull() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFull = null;


        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1100:2: (iv_ruleDateFull= ruleDateFull EOF )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1101:2: iv_ruleDateFull= ruleDateFull EOF
            {
             newCompositeNode(grammarAccess.getDateFullRule()); 
            pushFollow(FOLLOW_ruleDateFull_in_entryRuleDateFull2499);
            iv_ruleDateFull=ruleDateFull();

            state._fsp--;

             current =iv_ruleDateFull; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateFull2509); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateFull"


    // $ANTLR start "ruleDateFull"
    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1108:1: ruleDateFull returns [EObject current=null] : (otherlv_0= 'new Date(' ( (lv_year_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_month_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_day_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )? otherlv_14= ')' ) ;
    public final EObject ruleDateFull() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_year_1_0=null;
        Token otherlv_2=null;
        Token lv_month_3_0=null;
        Token otherlv_4=null;
        Token lv_day_5_0=null;
        Token otherlv_6=null;
        Token lv_hour_7_0=null;
        Token otherlv_8=null;
        Token lv_minute_9_0=null;
        Token otherlv_10=null;
        Token lv_second_11_0=null;
        Token otherlv_12=null;
        Token lv_millisecond_13_0=null;
        Token otherlv_14=null;

         enterRule(); 
            
        try {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1111:28: ( (otherlv_0= 'new Date(' ( (lv_year_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_month_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_day_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )? otherlv_14= ')' ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1112:1: (otherlv_0= 'new Date(' ( (lv_year_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_month_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_day_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )? otherlv_14= ')' )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1112:1: (otherlv_0= 'new Date(' ( (lv_year_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_month_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_day_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )? otherlv_14= ')' )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1112:3: otherlv_0= 'new Date(' ( (lv_year_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_month_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_day_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )? otherlv_14= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleDateFull2546); 

                	newLeafNode(otherlv_0, grammarAccess.getDateFullAccess().getNewDateKeyword_0());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1116:1: ( (lv_year_1_0= RULE_INT ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1117:1: (lv_year_1_0= RULE_INT )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1117:1: (lv_year_1_0= RULE_INT )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1118:3: lv_year_1_0= RULE_INT
            {
            lv_year_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2563); 

            			newLeafNode(lv_year_1_0, grammarAccess.getDateFullAccess().getYearINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateFullRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"year",
                    		lv_year_1_0, 
                    		"INT");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2580); 

                	newLeafNode(otherlv_2, grammarAccess.getDateFullAccess().getCommaKeyword_2());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1138:1: ( (lv_month_3_0= RULE_INT ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1139:1: (lv_month_3_0= RULE_INT )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1139:1: (lv_month_3_0= RULE_INT )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1140:3: lv_month_3_0= RULE_INT
            {
            lv_month_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2597); 

            			newLeafNode(lv_month_3_0, grammarAccess.getDateFullAccess().getMonthINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateFullRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"month",
                    		lv_month_3_0, 
                    		"INT");
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2614); 

                	newLeafNode(otherlv_4, grammarAccess.getDateFullAccess().getCommaKeyword_4());
                
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1160:1: ( (lv_day_5_0= RULE_INT ) )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1161:1: (lv_day_5_0= RULE_INT )
            {
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1161:1: (lv_day_5_0= RULE_INT )
            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1162:3: lv_day_5_0= RULE_INT
            {
            lv_day_5_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2631); 

            			newLeafNode(lv_day_5_0, grammarAccess.getDateFullAccess().getDayINTTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateFullRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"day",
                    		lv_day_5_0, 
                    		"INT");
            	    

            }


            }

            // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1178:2: (otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==12) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1178:4: otherlv_6= ',' ( (lv_hour_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_minute_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_second_11_0= RULE_INT ) ) otherlv_12= ',' ( (lv_millisecond_13_0= RULE_INT ) )
                    {
                    otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2649); 

                        	newLeafNode(otherlv_6, grammarAccess.getDateFullAccess().getCommaKeyword_6_0());
                        
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1182:1: ( (lv_hour_7_0= RULE_INT ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1183:1: (lv_hour_7_0= RULE_INT )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1183:1: (lv_hour_7_0= RULE_INT )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1184:3: lv_hour_7_0= RULE_INT
                    {
                    lv_hour_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2666); 

                    			newLeafNode(lv_hour_7_0, grammarAccess.getDateFullAccess().getHourINTTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDateFullRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"hour",
                            		lv_hour_7_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2683); 

                        	newLeafNode(otherlv_8, grammarAccess.getDateFullAccess().getCommaKeyword_6_2());
                        
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1204:1: ( (lv_minute_9_0= RULE_INT ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1205:1: (lv_minute_9_0= RULE_INT )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1205:1: (lv_minute_9_0= RULE_INT )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1206:3: lv_minute_9_0= RULE_INT
                    {
                    lv_minute_9_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2700); 

                    			newLeafNode(lv_minute_9_0, grammarAccess.getDateFullAccess().getMinuteINTTerminalRuleCall_6_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDateFullRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"minute",
                            		lv_minute_9_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2717); 

                        	newLeafNode(otherlv_10, grammarAccess.getDateFullAccess().getCommaKeyword_6_4());
                        
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1226:1: ( (lv_second_11_0= RULE_INT ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1227:1: (lv_second_11_0= RULE_INT )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1227:1: (lv_second_11_0= RULE_INT )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1228:3: lv_second_11_0= RULE_INT
                    {
                    lv_second_11_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2734); 

                    			newLeafNode(lv_second_11_0, grammarAccess.getDateFullAccess().getSecondINTTerminalRuleCall_6_5_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDateFullRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"second",
                            		lv_second_11_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,12,FOLLOW_12_in_ruleDateFull2751); 

                        	newLeafNode(otherlv_12, grammarAccess.getDateFullAccess().getCommaKeyword_6_6());
                        
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1248:1: ( (lv_millisecond_13_0= RULE_INT ) )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1249:1: (lv_millisecond_13_0= RULE_INT )
                    {
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1249:1: (lv_millisecond_13_0= RULE_INT )
                    // ../com.verticon.mongo.json.query/src-gen/org/json/parser/antlr/internal/InternalMongoQuery.g:1250:3: lv_millisecond_13_0= RULE_INT
                    {
                    lv_millisecond_13_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDateFull2768); 

                    			newLeafNode(lv_millisecond_13_0, grammarAccess.getDateFullAccess().getMillisecondINTTerminalRuleCall_6_7_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDateFullRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"millisecond",
                            		lv_millisecond_13_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,40,FOLLOW_40_in_ruleDateFull2787); 

                	newLeafNode(otherlv_14, grammarAccess.getDateFullAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateFull"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_ruleSelector131 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSelector144 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleSelection_in_ruleSelector165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelection_in_entryRuleSelection203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelection213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSelection250 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_ruleSelection280 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_ruleSelection294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_ruleSelection315 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14_in_ruleSelection329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_entryRuleFieldSelection365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldSelection375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFieldSelection417 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFieldSelection434 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFieldSelection451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_entryRuleQueryObject492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryObject502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleQueryObject539 = new BitSet(new long[]{0x00000007FFFC5050L});
    public static final BitSet FOLLOW_ruleMember_in_ruleQueryObject569 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_ruleQueryObject583 = new BitSet(new long[]{0x00000007FFFC0050L});
    public static final BitSet FOLLOW_ruleMember_in_ruleQueryObject604 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14_in_ruleQueryObject618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_ruleMember710 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMember722 = new BitSet(new long[]{0x000000F8000120F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleMember743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNull_in_ruleValue835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_ruleValue862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValue885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValue913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleValue941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJsonDate_in_ruleValue973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_ruleValue1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleValue1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_ruleValue1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_entryRuleArray1091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArray1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleArray1147 = new BitSet(new long[]{0x000000F8000330F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleArray1168 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_12_in_ruleArray1182 = new BitSet(new long[]{0x000000F8000120F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleArray1203 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_17_in_ruleArray1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_entryRuleKey1254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKey1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditional_in_ruleKey1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKey1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKey1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditional_in_entryRuleConditional1410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditional1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleConditional1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleConditional1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleConditional1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleConditional1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleConditional1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleConditional1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleConditional1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleConditional1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleConditional1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleConditional1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleConditional1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleConditional1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleConditional1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleConditional1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleConditional1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleConditional1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleConditional1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleBoolean1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleBoolean1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNull_in_entryRuleNull1913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNull1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNull1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJsonDate_in_entryRuleJsonDate2000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJsonDate2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateNow_in_ruleJsonDate2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateMilli_in_ruleJsonDate2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateString_in_ruleJsonDate2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateFull_in_ruleJsonDate2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateNow_in_entryRuleDateNow2173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateNow2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleDateNow2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateMilli_in_entryRuleDateMilli2265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateMilli2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleDateMilli2312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateMilli2329 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDateMilli2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateString_in_entryRuleDateString2382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateString2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleDateString2429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDateString2446 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDateString2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateFull_in_entryRuleDateFull2499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateFull2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleDateFull2546 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2563 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2580 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2597 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2614 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2631 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2649 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2666 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2683 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2700 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2717 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2734 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDateFull2751 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDateFull2768 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDateFull2787 = new BitSet(new long[]{0x0000000000000002L});

}