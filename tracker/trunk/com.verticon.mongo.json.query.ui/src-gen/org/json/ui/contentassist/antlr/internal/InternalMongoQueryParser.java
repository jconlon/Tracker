package org.json.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.json.services.MongoQueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMongoQueryParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_NUMBER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'null'", "'$lt'", "'$gt'", "'$gte'", "'$lte'", "'$all'", "'$exists'", "'$mod'", "'$ne'", "'$in'", "'$nin'", "'$not'", "'$or'", "'$and'", "'$size'", "'$type'", "'$near'", "'$maxDistance'", "'true'", "'false'", "','", "'{'", "'}'", "':'", "'['", "']'", "'new Date()'", "'new Date('", "')'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
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
    public static final int RULE_INT=6;
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
    public String getGrammarFileName() { return "../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g"; }


     
     	private MongoQueryGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MongoQueryGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleSelector"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:60:1: entryRuleSelector : ruleSelector EOF ;
    public final void entryRuleSelector() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:61:1: ( ruleSelector EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:62:1: ruleSelector EOF
            {
             before(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector61);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getSelectorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:69:1: ruleSelector : ( ( rule__Selector__Group__0 ) ) ;
    public final void ruleSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:73:2: ( ( ( rule__Selector__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:74:1: ( ( rule__Selector__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:74:1: ( ( rule__Selector__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:75:1: ( rule__Selector__Group__0 )
            {
             before(grammarAccess.getSelectorAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:76:1: ( rule__Selector__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:76:2: rule__Selector__Group__0
            {
            pushFollow(FOLLOW_rule__Selector__Group__0_in_ruleSelector94);
            rule__Selector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleSelection"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:88:1: entryRuleSelection : ruleSelection EOF ;
    public final void entryRuleSelection() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:89:1: ( ruleSelection EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:90:1: ruleSelection EOF
            {
             before(grammarAccess.getSelectionRule()); 
            pushFollow(FOLLOW_ruleSelection_in_entryRuleSelection121);
            ruleSelection();

            state._fsp--;

             after(grammarAccess.getSelectionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelection128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelection"


    // $ANTLR start "ruleSelection"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:97:1: ruleSelection : ( ( rule__Selection__Group__0 ) ) ;
    public final void ruleSelection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:101:2: ( ( ( rule__Selection__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:102:1: ( ( rule__Selection__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:102:1: ( ( rule__Selection__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:103:1: ( rule__Selection__Group__0 )
            {
             before(grammarAccess.getSelectionAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:104:1: ( rule__Selection__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:104:2: rule__Selection__Group__0
            {
            pushFollow(FOLLOW_rule__Selection__Group__0_in_ruleSelection154);
            rule__Selection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelection"


    // $ANTLR start "entryRuleFieldSelection"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:116:1: entryRuleFieldSelection : ruleFieldSelection EOF ;
    public final void entryRuleFieldSelection() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:117:1: ( ruleFieldSelection EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:118:1: ruleFieldSelection EOF
            {
             before(grammarAccess.getFieldSelectionRule()); 
            pushFollow(FOLLOW_ruleFieldSelection_in_entryRuleFieldSelection181);
            ruleFieldSelection();

            state._fsp--;

             after(grammarAccess.getFieldSelectionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldSelection188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFieldSelection"


    // $ANTLR start "ruleFieldSelection"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:125:1: ruleFieldSelection : ( ( rule__FieldSelection__Group__0 ) ) ;
    public final void ruleFieldSelection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:129:2: ( ( ( rule__FieldSelection__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:130:1: ( ( rule__FieldSelection__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:130:1: ( ( rule__FieldSelection__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:131:1: ( rule__FieldSelection__Group__0 )
            {
             before(grammarAccess.getFieldSelectionAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:132:1: ( rule__FieldSelection__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:132:2: rule__FieldSelection__Group__0
            {
            pushFollow(FOLLOW_rule__FieldSelection__Group__0_in_ruleFieldSelection214);
            rule__FieldSelection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFieldSelectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFieldSelection"


    // $ANTLR start "entryRuleQueryObject"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:144:1: entryRuleQueryObject : ruleQueryObject EOF ;
    public final void entryRuleQueryObject() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:145:1: ( ruleQueryObject EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:146:1: ruleQueryObject EOF
            {
             before(grammarAccess.getQueryObjectRule()); 
            pushFollow(FOLLOW_ruleQueryObject_in_entryRuleQueryObject241);
            ruleQueryObject();

            state._fsp--;

             after(grammarAccess.getQueryObjectRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryObject248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQueryObject"


    // $ANTLR start "ruleQueryObject"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:153:1: ruleQueryObject : ( ( rule__QueryObject__Group__0 ) ) ;
    public final void ruleQueryObject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:157:2: ( ( ( rule__QueryObject__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:158:1: ( ( rule__QueryObject__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:158:1: ( ( rule__QueryObject__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:159:1: ( rule__QueryObject__Group__0 )
            {
             before(grammarAccess.getQueryObjectAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:160:1: ( rule__QueryObject__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:160:2: rule__QueryObject__Group__0
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__0_in_ruleQueryObject274);
            rule__QueryObject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQueryObjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQueryObject"


    // $ANTLR start "entryRuleMember"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:172:1: entryRuleMember : ruleMember EOF ;
    public final void entryRuleMember() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:173:1: ( ruleMember EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:174:1: ruleMember EOF
            {
             before(grammarAccess.getMemberRule()); 
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember301);
            ruleMember();

            state._fsp--;

             after(grammarAccess.getMemberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:181:1: ruleMember : ( ( rule__Member__Group__0 ) ) ;
    public final void ruleMember() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:185:2: ( ( ( rule__Member__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:186:1: ( ( rule__Member__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:186:1: ( ( rule__Member__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:187:1: ( rule__Member__Group__0 )
            {
             before(grammarAccess.getMemberAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:188:1: ( rule__Member__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:188:2: rule__Member__Group__0
            {
            pushFollow(FOLLOW_rule__Member__Group__0_in_ruleMember334);
            rule__Member__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMemberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleValue"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:200:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:201:1: ( ruleValue EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:202:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue361);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:209:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:213:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:214:1: ( ( rule__Value__Alternatives ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:214:1: ( ( rule__Value__Alternatives ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:215:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:216:1: ( rule__Value__Alternatives )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:216:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue394);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleArray"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:228:1: entryRuleArray : ruleArray EOF ;
    public final void entryRuleArray() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:229:1: ( ruleArray EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:230:1: ruleArray EOF
            {
             before(grammarAccess.getArrayRule()); 
            pushFollow(FOLLOW_ruleArray_in_entryRuleArray421);
            ruleArray();

            state._fsp--;

             after(grammarAccess.getArrayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArray428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArray"


    // $ANTLR start "ruleArray"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:237:1: ruleArray : ( ( rule__Array__Group__0 ) ) ;
    public final void ruleArray() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:241:2: ( ( ( rule__Array__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:242:1: ( ( rule__Array__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:242:1: ( ( rule__Array__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:243:1: ( rule__Array__Group__0 )
            {
             before(grammarAccess.getArrayAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:244:1: ( rule__Array__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:244:2: rule__Array__Group__0
            {
            pushFollow(FOLLOW_rule__Array__Group__0_in_ruleArray454);
            rule__Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArray"


    // $ANTLR start "entryRuleKey"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:256:1: entryRuleKey : ruleKey EOF ;
    public final void entryRuleKey() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:257:1: ( ruleKey EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:258:1: ruleKey EOF
            {
             before(grammarAccess.getKeyRule()); 
            pushFollow(FOLLOW_ruleKey_in_entryRuleKey481);
            ruleKey();

            state._fsp--;

             after(grammarAccess.getKeyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKey488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKey"


    // $ANTLR start "ruleKey"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:265:1: ruleKey : ( ( rule__Key__Alternatives ) ) ;
    public final void ruleKey() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:269:2: ( ( ( rule__Key__Alternatives ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:270:1: ( ( rule__Key__Alternatives ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:270:1: ( ( rule__Key__Alternatives ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:271:1: ( rule__Key__Alternatives )
            {
             before(grammarAccess.getKeyAccess().getAlternatives()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:272:1: ( rule__Key__Alternatives )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:272:2: rule__Key__Alternatives
            {
            pushFollow(FOLLOW_rule__Key__Alternatives_in_ruleKey514);
            rule__Key__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getKeyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKey"


    // $ANTLR start "entryRuleConditional"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:284:1: entryRuleConditional : ruleConditional EOF ;
    public final void entryRuleConditional() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:285:1: ( ruleConditional EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:286:1: ruleConditional EOF
            {
             before(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_ruleConditional_in_entryRuleConditional541);
            ruleConditional();

            state._fsp--;

             after(grammarAccess.getConditionalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditional548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:293:1: ruleConditional : ( ( rule__Conditional__Alternatives ) ) ;
    public final void ruleConditional() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:297:2: ( ( ( rule__Conditional__Alternatives ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:298:1: ( ( rule__Conditional__Alternatives ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:298:1: ( ( rule__Conditional__Alternatives ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:299:1: ( rule__Conditional__Alternatives )
            {
             before(grammarAccess.getConditionalAccess().getAlternatives()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:300:1: ( rule__Conditional__Alternatives )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:300:2: rule__Conditional__Alternatives
            {
            pushFollow(FOLLOW_rule__Conditional__Alternatives_in_ruleConditional574);
            rule__Conditional__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleBoolean"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:312:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:313:1: ( ruleBoolean EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:314:1: ruleBoolean EOF
            {
             before(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean601);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:321:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:325:2: ( ( ( rule__Boolean__Alternatives ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:326:1: ( ( rule__Boolean__Alternatives ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:326:1: ( ( rule__Boolean__Alternatives ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:327:1: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:328:1: ( rule__Boolean__Alternatives )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:328:2: rule__Boolean__Alternatives
            {
            pushFollow(FOLLOW_rule__Boolean__Alternatives_in_ruleBoolean634);
            rule__Boolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleNull"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:340:1: entryRuleNull : ruleNull EOF ;
    public final void entryRuleNull() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:341:1: ( ruleNull EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:342:1: ruleNull EOF
            {
             before(grammarAccess.getNullRule()); 
            pushFollow(FOLLOW_ruleNull_in_entryRuleNull661);
            ruleNull();

            state._fsp--;

             after(grammarAccess.getNullRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNull668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNull"


    // $ANTLR start "ruleNull"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:349:1: ruleNull : ( 'null' ) ;
    public final void ruleNull() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:353:2: ( ( 'null' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:354:1: ( 'null' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:354:1: ( 'null' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:355:1: 'null'
            {
             before(grammarAccess.getNullAccess().getNullKeyword()); 
            match(input,12,FOLLOW_12_in_ruleNull695); 
             after(grammarAccess.getNullAccess().getNullKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNull"


    // $ANTLR start "entryRuleJsonDate"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:370:1: entryRuleJsonDate : ruleJsonDate EOF ;
    public final void entryRuleJsonDate() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:371:1: ( ruleJsonDate EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:372:1: ruleJsonDate EOF
            {
             before(grammarAccess.getJsonDateRule()); 
            pushFollow(FOLLOW_ruleJsonDate_in_entryRuleJsonDate723);
            ruleJsonDate();

            state._fsp--;

             after(grammarAccess.getJsonDateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJsonDate730); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJsonDate"


    // $ANTLR start "ruleJsonDate"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:379:1: ruleJsonDate : ( ( rule__JsonDate__Alternatives ) ) ;
    public final void ruleJsonDate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:383:2: ( ( ( rule__JsonDate__Alternatives ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:384:1: ( ( rule__JsonDate__Alternatives ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:384:1: ( ( rule__JsonDate__Alternatives ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:385:1: ( rule__JsonDate__Alternatives )
            {
             before(grammarAccess.getJsonDateAccess().getAlternatives()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:386:1: ( rule__JsonDate__Alternatives )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:386:2: rule__JsonDate__Alternatives
            {
            pushFollow(FOLLOW_rule__JsonDate__Alternatives_in_ruleJsonDate756);
            rule__JsonDate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJsonDateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJsonDate"


    // $ANTLR start "entryRuleDateNow"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:398:1: entryRuleDateNow : ruleDateNow EOF ;
    public final void entryRuleDateNow() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:399:1: ( ruleDateNow EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:400:1: ruleDateNow EOF
            {
             before(grammarAccess.getDateNowRule()); 
            pushFollow(FOLLOW_ruleDateNow_in_entryRuleDateNow783);
            ruleDateNow();

            state._fsp--;

             after(grammarAccess.getDateNowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateNow790); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateNow"


    // $ANTLR start "ruleDateNow"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:407:1: ruleDateNow : ( ( rule__DateNow__Group__0 ) ) ;
    public final void ruleDateNow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:411:2: ( ( ( rule__DateNow__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:412:1: ( ( rule__DateNow__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:412:1: ( ( rule__DateNow__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:413:1: ( rule__DateNow__Group__0 )
            {
             before(grammarAccess.getDateNowAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:414:1: ( rule__DateNow__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:414:2: rule__DateNow__Group__0
            {
            pushFollow(FOLLOW_rule__DateNow__Group__0_in_ruleDateNow816);
            rule__DateNow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDateNowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateNow"


    // $ANTLR start "entryRuleDateMilli"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:426:1: entryRuleDateMilli : ruleDateMilli EOF ;
    public final void entryRuleDateMilli() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:427:1: ( ruleDateMilli EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:428:1: ruleDateMilli EOF
            {
             before(grammarAccess.getDateMilliRule()); 
            pushFollow(FOLLOW_ruleDateMilli_in_entryRuleDateMilli843);
            ruleDateMilli();

            state._fsp--;

             after(grammarAccess.getDateMilliRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateMilli850); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateMilli"


    // $ANTLR start "ruleDateMilli"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:435:1: ruleDateMilli : ( ( rule__DateMilli__Group__0 ) ) ;
    public final void ruleDateMilli() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:439:2: ( ( ( rule__DateMilli__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:440:1: ( ( rule__DateMilli__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:440:1: ( ( rule__DateMilli__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:441:1: ( rule__DateMilli__Group__0 )
            {
             before(grammarAccess.getDateMilliAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:442:1: ( rule__DateMilli__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:442:2: rule__DateMilli__Group__0
            {
            pushFollow(FOLLOW_rule__DateMilli__Group__0_in_ruleDateMilli876);
            rule__DateMilli__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDateMilliAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateMilli"


    // $ANTLR start "entryRuleDateString"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:454:1: entryRuleDateString : ruleDateString EOF ;
    public final void entryRuleDateString() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:455:1: ( ruleDateString EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:456:1: ruleDateString EOF
            {
             before(grammarAccess.getDateStringRule()); 
            pushFollow(FOLLOW_ruleDateString_in_entryRuleDateString903);
            ruleDateString();

            state._fsp--;

             after(grammarAccess.getDateStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateString910); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateString"


    // $ANTLR start "ruleDateString"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:463:1: ruleDateString : ( ( rule__DateString__Group__0 ) ) ;
    public final void ruleDateString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:467:2: ( ( ( rule__DateString__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:468:1: ( ( rule__DateString__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:468:1: ( ( rule__DateString__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:469:1: ( rule__DateString__Group__0 )
            {
             before(grammarAccess.getDateStringAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:470:1: ( rule__DateString__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:470:2: rule__DateString__Group__0
            {
            pushFollow(FOLLOW_rule__DateString__Group__0_in_ruleDateString936);
            rule__DateString__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDateStringAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateString"


    // $ANTLR start "entryRuleDateFull"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:482:1: entryRuleDateFull : ruleDateFull EOF ;
    public final void entryRuleDateFull() throws RecognitionException {
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:483:1: ( ruleDateFull EOF )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:484:1: ruleDateFull EOF
            {
             before(grammarAccess.getDateFullRule()); 
            pushFollow(FOLLOW_ruleDateFull_in_entryRuleDateFull963);
            ruleDateFull();

            state._fsp--;

             after(grammarAccess.getDateFullRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateFull970); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateFull"


    // $ANTLR start "ruleDateFull"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:491:1: ruleDateFull : ( ( rule__DateFull__Group__0 ) ) ;
    public final void ruleDateFull() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:495:2: ( ( ( rule__DateFull__Group__0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:496:1: ( ( rule__DateFull__Group__0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:496:1: ( ( rule__DateFull__Group__0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:497:1: ( rule__DateFull__Group__0 )
            {
             before(grammarAccess.getDateFullAccess().getGroup()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:498:1: ( rule__DateFull__Group__0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:498:2: rule__DateFull__Group__0
            {
            pushFollow(FOLLOW_rule__DateFull__Group__0_in_ruleDateFull996);
            rule__DateFull__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateFull"


    // $ANTLR start "rule__Value__Alternatives"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:510:1: rule__Value__Alternatives : ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__StringValueAssignment_1 ) ) | ( ( rule__Value__StringValueAssignment_2 ) ) | ( ( rule__Value__StringValueAssignment_3 ) ) | ( ( rule__Value__NumberValueAssignment_4 ) ) | ( ( rule__Value__DateValueAssignment_5 ) ) | ( ( rule__Value__ArrayValueAssignment_6 ) ) | ( ( rule__Value__IntegerValueAssignment_7 ) ) | ( ( rule__Value__ObjectValueAssignment_8 ) ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:514:1: ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__StringValueAssignment_1 ) ) | ( ( rule__Value__StringValueAssignment_2 ) ) | ( ( rule__Value__StringValueAssignment_3 ) ) | ( ( rule__Value__NumberValueAssignment_4 ) ) | ( ( rule__Value__DateValueAssignment_5 ) ) | ( ( rule__Value__ArrayValueAssignment_6 ) ) | ( ( rule__Value__IntegerValueAssignment_7 ) ) | ( ( rule__Value__ObjectValueAssignment_8 ) ) )
            int alt1=9;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 30:
            case 31:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_ID:
                {
                alt1=4;
                }
                break;
            case RULE_NUMBER:
                {
                alt1=5;
                }
                break;
            case 38:
            case 39:
                {
                alt1=6;
                }
                break;
            case 36:
                {
                alt1=7;
                }
                break;
            case RULE_INT:
                {
                alt1=8;
                }
                break;
            case 33:
                {
                alt1=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:515:1: ( ( rule__Value__StringValueAssignment_0 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:515:1: ( ( rule__Value__StringValueAssignment_0 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:516:1: ( rule__Value__StringValueAssignment_0 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_0()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:517:1: ( rule__Value__StringValueAssignment_0 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:517:2: rule__Value__StringValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Value__StringValueAssignment_0_in_rule__Value__Alternatives1032);
                    rule__Value__StringValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getStringValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:521:6: ( ( rule__Value__StringValueAssignment_1 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:521:6: ( ( rule__Value__StringValueAssignment_1 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:522:1: ( rule__Value__StringValueAssignment_1 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_1()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:523:1: ( rule__Value__StringValueAssignment_1 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:523:2: rule__Value__StringValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Value__StringValueAssignment_1_in_rule__Value__Alternatives1050);
                    rule__Value__StringValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getStringValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:527:6: ( ( rule__Value__StringValueAssignment_2 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:527:6: ( ( rule__Value__StringValueAssignment_2 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:528:1: ( rule__Value__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_2()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:529:1: ( rule__Value__StringValueAssignment_2 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:529:2: rule__Value__StringValueAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Value__StringValueAssignment_2_in_rule__Value__Alternatives1068);
                    rule__Value__StringValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getStringValueAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:533:6: ( ( rule__Value__StringValueAssignment_3 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:533:6: ( ( rule__Value__StringValueAssignment_3 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:534:1: ( rule__Value__StringValueAssignment_3 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_3()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:535:1: ( rule__Value__StringValueAssignment_3 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:535:2: rule__Value__StringValueAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Value__StringValueAssignment_3_in_rule__Value__Alternatives1086);
                    rule__Value__StringValueAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getStringValueAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:539:6: ( ( rule__Value__NumberValueAssignment_4 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:539:6: ( ( rule__Value__NumberValueAssignment_4 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:540:1: ( rule__Value__NumberValueAssignment_4 )
                    {
                     before(grammarAccess.getValueAccess().getNumberValueAssignment_4()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:541:1: ( rule__Value__NumberValueAssignment_4 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:541:2: rule__Value__NumberValueAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Value__NumberValueAssignment_4_in_rule__Value__Alternatives1104);
                    rule__Value__NumberValueAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getNumberValueAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:545:6: ( ( rule__Value__DateValueAssignment_5 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:545:6: ( ( rule__Value__DateValueAssignment_5 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:546:1: ( rule__Value__DateValueAssignment_5 )
                    {
                     before(grammarAccess.getValueAccess().getDateValueAssignment_5()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:547:1: ( rule__Value__DateValueAssignment_5 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:547:2: rule__Value__DateValueAssignment_5
                    {
                    pushFollow(FOLLOW_rule__Value__DateValueAssignment_5_in_rule__Value__Alternatives1122);
                    rule__Value__DateValueAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getDateValueAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:551:6: ( ( rule__Value__ArrayValueAssignment_6 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:551:6: ( ( rule__Value__ArrayValueAssignment_6 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:552:1: ( rule__Value__ArrayValueAssignment_6 )
                    {
                     before(grammarAccess.getValueAccess().getArrayValueAssignment_6()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:553:1: ( rule__Value__ArrayValueAssignment_6 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:553:2: rule__Value__ArrayValueAssignment_6
                    {
                    pushFollow(FOLLOW_rule__Value__ArrayValueAssignment_6_in_rule__Value__Alternatives1140);
                    rule__Value__ArrayValueAssignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getArrayValueAssignment_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:557:6: ( ( rule__Value__IntegerValueAssignment_7 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:557:6: ( ( rule__Value__IntegerValueAssignment_7 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:558:1: ( rule__Value__IntegerValueAssignment_7 )
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueAssignment_7()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:559:1: ( rule__Value__IntegerValueAssignment_7 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:559:2: rule__Value__IntegerValueAssignment_7
                    {
                    pushFollow(FOLLOW_rule__Value__IntegerValueAssignment_7_in_rule__Value__Alternatives1158);
                    rule__Value__IntegerValueAssignment_7();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getIntegerValueAssignment_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:563:6: ( ( rule__Value__ObjectValueAssignment_8 ) )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:563:6: ( ( rule__Value__ObjectValueAssignment_8 ) )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:564:1: ( rule__Value__ObjectValueAssignment_8 )
                    {
                     before(grammarAccess.getValueAccess().getObjectValueAssignment_8()); 
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:565:1: ( rule__Value__ObjectValueAssignment_8 )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:565:2: rule__Value__ObjectValueAssignment_8
                    {
                    pushFollow(FOLLOW_rule__Value__ObjectValueAssignment_8_in_rule__Value__Alternatives1176);
                    rule__Value__ObjectValueAssignment_8();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getObjectValueAssignment_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__Key__Alternatives"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:574:1: rule__Key__Alternatives : ( ( ruleConditional ) | ( RULE_ID ) | ( RULE_STRING ) );
    public final void rule__Key__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:578:1: ( ( ruleConditional ) | ( RULE_ID ) | ( RULE_STRING ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
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
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:579:1: ( ruleConditional )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:579:1: ( ruleConditional )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:580:1: ruleConditional
                    {
                     before(grammarAccess.getKeyAccess().getConditionalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleConditional_in_rule__Key__Alternatives1209);
                    ruleConditional();

                    state._fsp--;

                     after(grammarAccess.getKeyAccess().getConditionalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:585:6: ( RULE_ID )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:585:6: ( RULE_ID )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:586:1: RULE_ID
                    {
                     before(grammarAccess.getKeyAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Key__Alternatives1226); 
                     after(grammarAccess.getKeyAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:591:6: ( RULE_STRING )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:591:6: ( RULE_STRING )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:592:1: RULE_STRING
                    {
                     before(grammarAccess.getKeyAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Key__Alternatives1243); 
                     after(grammarAccess.getKeyAccess().getSTRINGTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Key__Alternatives"


    // $ANTLR start "rule__Conditional__Alternatives"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:602:1: rule__Conditional__Alternatives : ( ( '$lt' ) | ( '$gt' ) | ( '$gte' ) | ( '$lte' ) | ( '$all' ) | ( '$exists' ) | ( '$mod' ) | ( '$ne' ) | ( '$in' ) | ( '$nin' ) | ( '$not' ) | ( '$or' ) | ( '$and' ) | ( '$size' ) | ( '$type' ) | ( '$near' ) | ( '$maxDistance' ) );
    public final void rule__Conditional__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:606:1: ( ( '$lt' ) | ( '$gt' ) | ( '$gte' ) | ( '$lte' ) | ( '$all' ) | ( '$exists' ) | ( '$mod' ) | ( '$ne' ) | ( '$in' ) | ( '$nin' ) | ( '$not' ) | ( '$or' ) | ( '$and' ) | ( '$size' ) | ( '$type' ) | ( '$near' ) | ( '$maxDistance' ) )
            int alt3=17;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            case 17:
                {
                alt3=5;
                }
                break;
            case 18:
                {
                alt3=6;
                }
                break;
            case 19:
                {
                alt3=7;
                }
                break;
            case 20:
                {
                alt3=8;
                }
                break;
            case 21:
                {
                alt3=9;
                }
                break;
            case 22:
                {
                alt3=10;
                }
                break;
            case 23:
                {
                alt3=11;
                }
                break;
            case 24:
                {
                alt3=12;
                }
                break;
            case 25:
                {
                alt3=13;
                }
                break;
            case 26:
                {
                alt3=14;
                }
                break;
            case 27:
                {
                alt3=15;
                }
                break;
            case 28:
                {
                alt3=16;
                }
                break;
            case 29:
                {
                alt3=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:607:1: ( '$lt' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:607:1: ( '$lt' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:608:1: '$lt'
                    {
                     before(grammarAccess.getConditionalAccess().getLtKeyword_0()); 
                    match(input,13,FOLLOW_13_in_rule__Conditional__Alternatives1276); 
                     after(grammarAccess.getConditionalAccess().getLtKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:615:6: ( '$gt' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:615:6: ( '$gt' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:616:1: '$gt'
                    {
                     before(grammarAccess.getConditionalAccess().getGtKeyword_1()); 
                    match(input,14,FOLLOW_14_in_rule__Conditional__Alternatives1296); 
                     after(grammarAccess.getConditionalAccess().getGtKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:623:6: ( '$gte' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:623:6: ( '$gte' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:624:1: '$gte'
                    {
                     before(grammarAccess.getConditionalAccess().getGteKeyword_2()); 
                    match(input,15,FOLLOW_15_in_rule__Conditional__Alternatives1316); 
                     after(grammarAccess.getConditionalAccess().getGteKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:631:6: ( '$lte' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:631:6: ( '$lte' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:632:1: '$lte'
                    {
                     before(grammarAccess.getConditionalAccess().getLteKeyword_3()); 
                    match(input,16,FOLLOW_16_in_rule__Conditional__Alternatives1336); 
                     after(grammarAccess.getConditionalAccess().getLteKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:639:6: ( '$all' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:639:6: ( '$all' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:640:1: '$all'
                    {
                     before(grammarAccess.getConditionalAccess().getAllKeyword_4()); 
                    match(input,17,FOLLOW_17_in_rule__Conditional__Alternatives1356); 
                     after(grammarAccess.getConditionalAccess().getAllKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:647:6: ( '$exists' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:647:6: ( '$exists' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:648:1: '$exists'
                    {
                     before(grammarAccess.getConditionalAccess().getExistsKeyword_5()); 
                    match(input,18,FOLLOW_18_in_rule__Conditional__Alternatives1376); 
                     after(grammarAccess.getConditionalAccess().getExistsKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:655:6: ( '$mod' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:655:6: ( '$mod' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:656:1: '$mod'
                    {
                     before(grammarAccess.getConditionalAccess().getModKeyword_6()); 
                    match(input,19,FOLLOW_19_in_rule__Conditional__Alternatives1396); 
                     after(grammarAccess.getConditionalAccess().getModKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:663:6: ( '$ne' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:663:6: ( '$ne' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:664:1: '$ne'
                    {
                     before(grammarAccess.getConditionalAccess().getNeKeyword_7()); 
                    match(input,20,FOLLOW_20_in_rule__Conditional__Alternatives1416); 
                     after(grammarAccess.getConditionalAccess().getNeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:671:6: ( '$in' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:671:6: ( '$in' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:672:1: '$in'
                    {
                     before(grammarAccess.getConditionalAccess().getInKeyword_8()); 
                    match(input,21,FOLLOW_21_in_rule__Conditional__Alternatives1436); 
                     after(grammarAccess.getConditionalAccess().getInKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:679:6: ( '$nin' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:679:6: ( '$nin' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:680:1: '$nin'
                    {
                     before(grammarAccess.getConditionalAccess().getNinKeyword_9()); 
                    match(input,22,FOLLOW_22_in_rule__Conditional__Alternatives1456); 
                     after(grammarAccess.getConditionalAccess().getNinKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:687:6: ( '$not' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:687:6: ( '$not' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:688:1: '$not'
                    {
                     before(grammarAccess.getConditionalAccess().getNotKeyword_10()); 
                    match(input,23,FOLLOW_23_in_rule__Conditional__Alternatives1476); 
                     after(grammarAccess.getConditionalAccess().getNotKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:695:6: ( '$or' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:695:6: ( '$or' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:696:1: '$or'
                    {
                     before(grammarAccess.getConditionalAccess().getOrKeyword_11()); 
                    match(input,24,FOLLOW_24_in_rule__Conditional__Alternatives1496); 
                     after(grammarAccess.getConditionalAccess().getOrKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:703:6: ( '$and' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:703:6: ( '$and' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:704:1: '$and'
                    {
                     before(grammarAccess.getConditionalAccess().getAndKeyword_12()); 
                    match(input,25,FOLLOW_25_in_rule__Conditional__Alternatives1516); 
                     after(grammarAccess.getConditionalAccess().getAndKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:711:6: ( '$size' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:711:6: ( '$size' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:712:1: '$size'
                    {
                     before(grammarAccess.getConditionalAccess().getSizeKeyword_13()); 
                    match(input,26,FOLLOW_26_in_rule__Conditional__Alternatives1536); 
                     after(grammarAccess.getConditionalAccess().getSizeKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:719:6: ( '$type' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:719:6: ( '$type' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:720:1: '$type'
                    {
                     before(grammarAccess.getConditionalAccess().getTypeKeyword_14()); 
                    match(input,27,FOLLOW_27_in_rule__Conditional__Alternatives1556); 
                     after(grammarAccess.getConditionalAccess().getTypeKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:727:6: ( '$near' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:727:6: ( '$near' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:728:1: '$near'
                    {
                     before(grammarAccess.getConditionalAccess().getNearKeyword_15()); 
                    match(input,28,FOLLOW_28_in_rule__Conditional__Alternatives1576); 
                     after(grammarAccess.getConditionalAccess().getNearKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:735:6: ( '$maxDistance' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:735:6: ( '$maxDistance' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:736:1: '$maxDistance'
                    {
                     before(grammarAccess.getConditionalAccess().getMaxDistanceKeyword_16()); 
                    match(input,29,FOLLOW_29_in_rule__Conditional__Alternatives1596); 
                     after(grammarAccess.getConditionalAccess().getMaxDistanceKeyword_16()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Alternatives"


    // $ANTLR start "rule__Boolean__Alternatives"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:748:1: rule__Boolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:752:1: ( ( 'true' ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==30) ) {
                alt4=1;
            }
            else if ( (LA4_0==31) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:753:1: ( 'true' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:753:1: ( 'true' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:754:1: 'true'
                    {
                     before(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                    match(input,30,FOLLOW_30_in_rule__Boolean__Alternatives1631); 
                     after(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:761:6: ( 'false' )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:761:6: ( 'false' )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:762:1: 'false'
                    {
                     before(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                    match(input,31,FOLLOW_31_in_rule__Boolean__Alternatives1651); 
                     after(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Alternatives"


    // $ANTLR start "rule__JsonDate__Alternatives"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:774:1: rule__JsonDate__Alternatives : ( ( ruleDateNow ) | ( ruleDateMilli ) | ( ruleDateString ) | ( ruleDateFull ) );
    public final void rule__JsonDate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:778:1: ( ( ruleDateNow ) | ( ruleDateMilli ) | ( ruleDateString ) | ( ruleDateFull ) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==38) ) {
                alt5=1;
            }
            else if ( (LA5_0==39) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==RULE_INT) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==40) ) {
                        alt5=2;
                    }
                    else if ( (LA5_3==32) ) {
                        alt5=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA5_2==RULE_STRING) ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:779:1: ( ruleDateNow )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:779:1: ( ruleDateNow )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:780:1: ruleDateNow
                    {
                     before(grammarAccess.getJsonDateAccess().getDateNowParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDateNow_in_rule__JsonDate__Alternatives1685);
                    ruleDateNow();

                    state._fsp--;

                     after(grammarAccess.getJsonDateAccess().getDateNowParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:785:6: ( ruleDateMilli )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:785:6: ( ruleDateMilli )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:786:1: ruleDateMilli
                    {
                     before(grammarAccess.getJsonDateAccess().getDateMilliParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDateMilli_in_rule__JsonDate__Alternatives1702);
                    ruleDateMilli();

                    state._fsp--;

                     after(grammarAccess.getJsonDateAccess().getDateMilliParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:791:6: ( ruleDateString )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:791:6: ( ruleDateString )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:792:1: ruleDateString
                    {
                     before(grammarAccess.getJsonDateAccess().getDateStringParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDateString_in_rule__JsonDate__Alternatives1719);
                    ruleDateString();

                    state._fsp--;

                     after(grammarAccess.getJsonDateAccess().getDateStringParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:797:6: ( ruleDateFull )
                    {
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:797:6: ( ruleDateFull )
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:798:1: ruleDateFull
                    {
                     before(grammarAccess.getJsonDateAccess().getDateFullParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDateFull_in_rule__JsonDate__Alternatives1736);
                    ruleDateFull();

                    state._fsp--;

                     after(grammarAccess.getJsonDateAccess().getDateFullParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JsonDate__Alternatives"


    // $ANTLR start "rule__Selector__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:810:1: rule__Selector__Group__0 : rule__Selector__Group__0__Impl rule__Selector__Group__1 ;
    public final void rule__Selector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:814:1: ( rule__Selector__Group__0__Impl rule__Selector__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:815:2: rule__Selector__Group__0__Impl rule__Selector__Group__1
            {
            pushFollow(FOLLOW_rule__Selector__Group__0__Impl_in_rule__Selector__Group__01766);
            rule__Selector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selector__Group__1_in_rule__Selector__Group__01769);
            rule__Selector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__0"


    // $ANTLR start "rule__Selector__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:822:1: rule__Selector__Group__0__Impl : ( ( rule__Selector__QueryAssignment_0 ) ) ;
    public final void rule__Selector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:826:1: ( ( ( rule__Selector__QueryAssignment_0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:827:1: ( ( rule__Selector__QueryAssignment_0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:827:1: ( ( rule__Selector__QueryAssignment_0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:828:1: ( rule__Selector__QueryAssignment_0 )
            {
             before(grammarAccess.getSelectorAccess().getQueryAssignment_0()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:829:1: ( rule__Selector__QueryAssignment_0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:829:2: rule__Selector__QueryAssignment_0
            {
            pushFollow(FOLLOW_rule__Selector__QueryAssignment_0_in_rule__Selector__Group__0__Impl1796);
            rule__Selector__QueryAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getQueryAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__0__Impl"


    // $ANTLR start "rule__Selector__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:839:1: rule__Selector__Group__1 : rule__Selector__Group__1__Impl ;
    public final void rule__Selector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:843:1: ( rule__Selector__Group__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:844:2: rule__Selector__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Selector__Group__1__Impl_in_rule__Selector__Group__11826);
            rule__Selector__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__1"


    // $ANTLR start "rule__Selector__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:850:1: rule__Selector__Group__1__Impl : ( ( rule__Selector__Group_1__0 )? ) ;
    public final void rule__Selector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:854:1: ( ( ( rule__Selector__Group_1__0 )? ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:855:1: ( ( rule__Selector__Group_1__0 )? )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:855:1: ( ( rule__Selector__Group_1__0 )? )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:856:1: ( rule__Selector__Group_1__0 )?
            {
             before(grammarAccess.getSelectorAccess().getGroup_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:857:1: ( rule__Selector__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:857:2: rule__Selector__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Selector__Group_1__0_in_rule__Selector__Group__1__Impl1853);
                    rule__Selector__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group__1__Impl"


    // $ANTLR start "rule__Selector__Group_1__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:871:1: rule__Selector__Group_1__0 : rule__Selector__Group_1__0__Impl rule__Selector__Group_1__1 ;
    public final void rule__Selector__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:875:1: ( rule__Selector__Group_1__0__Impl rule__Selector__Group_1__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:876:2: rule__Selector__Group_1__0__Impl rule__Selector__Group_1__1
            {
            pushFollow(FOLLOW_rule__Selector__Group_1__0__Impl_in_rule__Selector__Group_1__01888);
            rule__Selector__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selector__Group_1__1_in_rule__Selector__Group_1__01891);
            rule__Selector__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group_1__0"


    // $ANTLR start "rule__Selector__Group_1__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:883:1: rule__Selector__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Selector__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:887:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:888:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:888:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:889:1: ','
            {
             before(grammarAccess.getSelectorAccess().getCommaKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Selector__Group_1__0__Impl1919); 
             after(grammarAccess.getSelectorAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group_1__0__Impl"


    // $ANTLR start "rule__Selector__Group_1__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:902:1: rule__Selector__Group_1__1 : rule__Selector__Group_1__1__Impl ;
    public final void rule__Selector__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:906:1: ( rule__Selector__Group_1__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:907:2: rule__Selector__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Selector__Group_1__1__Impl_in_rule__Selector__Group_1__11950);
            rule__Selector__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group_1__1"


    // $ANTLR start "rule__Selector__Group_1__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:913:1: rule__Selector__Group_1__1__Impl : ( ( rule__Selector__SelectionAssignment_1_1 ) ) ;
    public final void rule__Selector__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:917:1: ( ( ( rule__Selector__SelectionAssignment_1_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:918:1: ( ( rule__Selector__SelectionAssignment_1_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:918:1: ( ( rule__Selector__SelectionAssignment_1_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:919:1: ( rule__Selector__SelectionAssignment_1_1 )
            {
             before(grammarAccess.getSelectorAccess().getSelectionAssignment_1_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:920:1: ( rule__Selector__SelectionAssignment_1_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:920:2: rule__Selector__SelectionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Selector__SelectionAssignment_1_1_in_rule__Selector__Group_1__1__Impl1977);
            rule__Selector__SelectionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getSelectionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__Group_1__1__Impl"


    // $ANTLR start "rule__Selection__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:934:1: rule__Selection__Group__0 : rule__Selection__Group__0__Impl rule__Selection__Group__1 ;
    public final void rule__Selection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:938:1: ( rule__Selection__Group__0__Impl rule__Selection__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:939:2: rule__Selection__Group__0__Impl rule__Selection__Group__1
            {
            pushFollow(FOLLOW_rule__Selection__Group__0__Impl_in_rule__Selection__Group__02011);
            rule__Selection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selection__Group__1_in_rule__Selection__Group__02014);
            rule__Selection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__0"


    // $ANTLR start "rule__Selection__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:946:1: rule__Selection__Group__0__Impl : ( '{' ) ;
    public final void rule__Selection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:950:1: ( ( '{' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:951:1: ( '{' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:951:1: ( '{' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:952:1: '{'
            {
             before(grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Selection__Group__0__Impl2042); 
             after(grammarAccess.getSelectionAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__0__Impl"


    // $ANTLR start "rule__Selection__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:965:1: rule__Selection__Group__1 : rule__Selection__Group__1__Impl rule__Selection__Group__2 ;
    public final void rule__Selection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:969:1: ( rule__Selection__Group__1__Impl rule__Selection__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:970:2: rule__Selection__Group__1__Impl rule__Selection__Group__2
            {
            pushFollow(FOLLOW_rule__Selection__Group__1__Impl_in_rule__Selection__Group__12073);
            rule__Selection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selection__Group__2_in_rule__Selection__Group__12076);
            rule__Selection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__1"


    // $ANTLR start "rule__Selection__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:977:1: rule__Selection__Group__1__Impl : ( () ) ;
    public final void rule__Selection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:981:1: ( ( () ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:982:1: ( () )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:982:1: ( () )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:983:1: ()
            {
             before(grammarAccess.getSelectionAccess().getSelectionAction_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:984:1: ()
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:986:1: 
            {
            }

             after(grammarAccess.getSelectionAccess().getSelectionAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__1__Impl"


    // $ANTLR start "rule__Selection__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:996:1: rule__Selection__Group__2 : rule__Selection__Group__2__Impl rule__Selection__Group__3 ;
    public final void rule__Selection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1000:1: ( rule__Selection__Group__2__Impl rule__Selection__Group__3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1001:2: rule__Selection__Group__2__Impl rule__Selection__Group__3
            {
            pushFollow(FOLLOW_rule__Selection__Group__2__Impl_in_rule__Selection__Group__22134);
            rule__Selection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selection__Group__3_in_rule__Selection__Group__22137);
            rule__Selection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__2"


    // $ANTLR start "rule__Selection__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1008:1: rule__Selection__Group__2__Impl : ( ( rule__Selection__FieldsAssignment_2 )? ) ;
    public final void rule__Selection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1012:1: ( ( ( rule__Selection__FieldsAssignment_2 )? ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1013:1: ( ( rule__Selection__FieldsAssignment_2 )? )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1013:1: ( ( rule__Selection__FieldsAssignment_2 )? )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1014:1: ( rule__Selection__FieldsAssignment_2 )?
            {
             before(grammarAccess.getSelectionAccess().getFieldsAssignment_2()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1015:1: ( rule__Selection__FieldsAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1015:2: rule__Selection__FieldsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Selection__FieldsAssignment_2_in_rule__Selection__Group__2__Impl2164);
                    rule__Selection__FieldsAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectionAccess().getFieldsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__2__Impl"


    // $ANTLR start "rule__Selection__Group__3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1025:1: rule__Selection__Group__3 : rule__Selection__Group__3__Impl rule__Selection__Group__4 ;
    public final void rule__Selection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1029:1: ( rule__Selection__Group__3__Impl rule__Selection__Group__4 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1030:2: rule__Selection__Group__3__Impl rule__Selection__Group__4
            {
            pushFollow(FOLLOW_rule__Selection__Group__3__Impl_in_rule__Selection__Group__32195);
            rule__Selection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selection__Group__4_in_rule__Selection__Group__32198);
            rule__Selection__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__3"


    // $ANTLR start "rule__Selection__Group__3__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1037:1: rule__Selection__Group__3__Impl : ( ( rule__Selection__Group_3__0 )* ) ;
    public final void rule__Selection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1041:1: ( ( ( rule__Selection__Group_3__0 )* ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1042:1: ( ( rule__Selection__Group_3__0 )* )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1042:1: ( ( rule__Selection__Group_3__0 )* )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1043:1: ( rule__Selection__Group_3__0 )*
            {
             before(grammarAccess.getSelectionAccess().getGroup_3()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1044:1: ( rule__Selection__Group_3__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1044:2: rule__Selection__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Selection__Group_3__0_in_rule__Selection__Group__3__Impl2225);
            	    rule__Selection__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getSelectionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__3__Impl"


    // $ANTLR start "rule__Selection__Group__4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1054:1: rule__Selection__Group__4 : rule__Selection__Group__4__Impl ;
    public final void rule__Selection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1058:1: ( rule__Selection__Group__4__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1059:2: rule__Selection__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Selection__Group__4__Impl_in_rule__Selection__Group__42256);
            rule__Selection__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__4"


    // $ANTLR start "rule__Selection__Group__4__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1065:1: rule__Selection__Group__4__Impl : ( '}' ) ;
    public final void rule__Selection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1069:1: ( ( '}' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1070:1: ( '}' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1070:1: ( '}' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1071:1: '}'
            {
             before(grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,34,FOLLOW_34_in_rule__Selection__Group__4__Impl2284); 
             after(grammarAccess.getSelectionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group__4__Impl"


    // $ANTLR start "rule__Selection__Group_3__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1094:1: rule__Selection__Group_3__0 : rule__Selection__Group_3__0__Impl rule__Selection__Group_3__1 ;
    public final void rule__Selection__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1098:1: ( rule__Selection__Group_3__0__Impl rule__Selection__Group_3__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1099:2: rule__Selection__Group_3__0__Impl rule__Selection__Group_3__1
            {
            pushFollow(FOLLOW_rule__Selection__Group_3__0__Impl_in_rule__Selection__Group_3__02325);
            rule__Selection__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Selection__Group_3__1_in_rule__Selection__Group_3__02328);
            rule__Selection__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_3__0"


    // $ANTLR start "rule__Selection__Group_3__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1106:1: rule__Selection__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Selection__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1110:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1111:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1111:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1112:1: ','
            {
             before(grammarAccess.getSelectionAccess().getCommaKeyword_3_0()); 
            match(input,32,FOLLOW_32_in_rule__Selection__Group_3__0__Impl2356); 
             after(grammarAccess.getSelectionAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_3__0__Impl"


    // $ANTLR start "rule__Selection__Group_3__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1125:1: rule__Selection__Group_3__1 : rule__Selection__Group_3__1__Impl ;
    public final void rule__Selection__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1129:1: ( rule__Selection__Group_3__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1130:2: rule__Selection__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Selection__Group_3__1__Impl_in_rule__Selection__Group_3__12387);
            rule__Selection__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_3__1"


    // $ANTLR start "rule__Selection__Group_3__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1136:1: rule__Selection__Group_3__1__Impl : ( ( rule__Selection__FieldsAssignment_3_1 ) ) ;
    public final void rule__Selection__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1140:1: ( ( ( rule__Selection__FieldsAssignment_3_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1141:1: ( ( rule__Selection__FieldsAssignment_3_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1141:1: ( ( rule__Selection__FieldsAssignment_3_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1142:1: ( rule__Selection__FieldsAssignment_3_1 )
            {
             before(grammarAccess.getSelectionAccess().getFieldsAssignment_3_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1143:1: ( rule__Selection__FieldsAssignment_3_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1143:2: rule__Selection__FieldsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Selection__FieldsAssignment_3_1_in_rule__Selection__Group_3__1__Impl2414);
            rule__Selection__FieldsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSelectionAccess().getFieldsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__Group_3__1__Impl"


    // $ANTLR start "rule__FieldSelection__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1157:1: rule__FieldSelection__Group__0 : rule__FieldSelection__Group__0__Impl rule__FieldSelection__Group__1 ;
    public final void rule__FieldSelection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1161:1: ( rule__FieldSelection__Group__0__Impl rule__FieldSelection__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1162:2: rule__FieldSelection__Group__0__Impl rule__FieldSelection__Group__1
            {
            pushFollow(FOLLOW_rule__FieldSelection__Group__0__Impl_in_rule__FieldSelection__Group__02448);
            rule__FieldSelection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FieldSelection__Group__1_in_rule__FieldSelection__Group__02451);
            rule__FieldSelection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__0"


    // $ANTLR start "rule__FieldSelection__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1169:1: rule__FieldSelection__Group__0__Impl : ( ( rule__FieldSelection__KeyAssignment_0 ) ) ;
    public final void rule__FieldSelection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1173:1: ( ( ( rule__FieldSelection__KeyAssignment_0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1174:1: ( ( rule__FieldSelection__KeyAssignment_0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1174:1: ( ( rule__FieldSelection__KeyAssignment_0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1175:1: ( rule__FieldSelection__KeyAssignment_0 )
            {
             before(grammarAccess.getFieldSelectionAccess().getKeyAssignment_0()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1176:1: ( rule__FieldSelection__KeyAssignment_0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1176:2: rule__FieldSelection__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__FieldSelection__KeyAssignment_0_in_rule__FieldSelection__Group__0__Impl2478);
            rule__FieldSelection__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFieldSelectionAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__0__Impl"


    // $ANTLR start "rule__FieldSelection__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1186:1: rule__FieldSelection__Group__1 : rule__FieldSelection__Group__1__Impl rule__FieldSelection__Group__2 ;
    public final void rule__FieldSelection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1190:1: ( rule__FieldSelection__Group__1__Impl rule__FieldSelection__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1191:2: rule__FieldSelection__Group__1__Impl rule__FieldSelection__Group__2
            {
            pushFollow(FOLLOW_rule__FieldSelection__Group__1__Impl_in_rule__FieldSelection__Group__12508);
            rule__FieldSelection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FieldSelection__Group__2_in_rule__FieldSelection__Group__12511);
            rule__FieldSelection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__1"


    // $ANTLR start "rule__FieldSelection__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1198:1: rule__FieldSelection__Group__1__Impl : ( ':' ) ;
    public final void rule__FieldSelection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1202:1: ( ( ':' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1203:1: ( ':' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1203:1: ( ':' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1204:1: ':'
            {
             before(grammarAccess.getFieldSelectionAccess().getColonKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__FieldSelection__Group__1__Impl2539); 
             after(grammarAccess.getFieldSelectionAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__1__Impl"


    // $ANTLR start "rule__FieldSelection__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1217:1: rule__FieldSelection__Group__2 : rule__FieldSelection__Group__2__Impl ;
    public final void rule__FieldSelection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1221:1: ( rule__FieldSelection__Group__2__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1222:2: rule__FieldSelection__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FieldSelection__Group__2__Impl_in_rule__FieldSelection__Group__22570);
            rule__FieldSelection__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__2"


    // $ANTLR start "rule__FieldSelection__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1228:1: rule__FieldSelection__Group__2__Impl : ( ( rule__FieldSelection__EnabledAssignment_2 ) ) ;
    public final void rule__FieldSelection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1232:1: ( ( ( rule__FieldSelection__EnabledAssignment_2 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1233:1: ( ( rule__FieldSelection__EnabledAssignment_2 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1233:1: ( ( rule__FieldSelection__EnabledAssignment_2 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1234:1: ( rule__FieldSelection__EnabledAssignment_2 )
            {
             before(grammarAccess.getFieldSelectionAccess().getEnabledAssignment_2()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1235:1: ( rule__FieldSelection__EnabledAssignment_2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1235:2: rule__FieldSelection__EnabledAssignment_2
            {
            pushFollow(FOLLOW_rule__FieldSelection__EnabledAssignment_2_in_rule__FieldSelection__Group__2__Impl2597);
            rule__FieldSelection__EnabledAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFieldSelectionAccess().getEnabledAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__Group__2__Impl"


    // $ANTLR start "rule__QueryObject__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1251:1: rule__QueryObject__Group__0 : rule__QueryObject__Group__0__Impl rule__QueryObject__Group__1 ;
    public final void rule__QueryObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1255:1: ( rule__QueryObject__Group__0__Impl rule__QueryObject__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1256:2: rule__QueryObject__Group__0__Impl rule__QueryObject__Group__1
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__0__Impl_in_rule__QueryObject__Group__02633);
            rule__QueryObject__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QueryObject__Group__1_in_rule__QueryObject__Group__02636);
            rule__QueryObject__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__0"


    // $ANTLR start "rule__QueryObject__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1263:1: rule__QueryObject__Group__0__Impl : ( '{' ) ;
    public final void rule__QueryObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1267:1: ( ( '{' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1268:1: ( '{' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1268:1: ( '{' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1269:1: '{'
            {
             before(grammarAccess.getQueryObjectAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__QueryObject__Group__0__Impl2664); 
             after(grammarAccess.getQueryObjectAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__0__Impl"


    // $ANTLR start "rule__QueryObject__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1282:1: rule__QueryObject__Group__1 : rule__QueryObject__Group__1__Impl rule__QueryObject__Group__2 ;
    public final void rule__QueryObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1286:1: ( rule__QueryObject__Group__1__Impl rule__QueryObject__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1287:2: rule__QueryObject__Group__1__Impl rule__QueryObject__Group__2
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__1__Impl_in_rule__QueryObject__Group__12695);
            rule__QueryObject__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QueryObject__Group__2_in_rule__QueryObject__Group__12698);
            rule__QueryObject__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__1"


    // $ANTLR start "rule__QueryObject__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1294:1: rule__QueryObject__Group__1__Impl : ( () ) ;
    public final void rule__QueryObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1298:1: ( ( () ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1299:1: ( () )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1299:1: ( () )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1300:1: ()
            {
             before(grammarAccess.getQueryObjectAccess().getQueryObjectAction_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1301:1: ()
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1303:1: 
            {
            }

             after(grammarAccess.getQueryObjectAccess().getQueryObjectAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__1__Impl"


    // $ANTLR start "rule__QueryObject__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1313:1: rule__QueryObject__Group__2 : rule__QueryObject__Group__2__Impl rule__QueryObject__Group__3 ;
    public final void rule__QueryObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1317:1: ( rule__QueryObject__Group__2__Impl rule__QueryObject__Group__3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1318:2: rule__QueryObject__Group__2__Impl rule__QueryObject__Group__3
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__2__Impl_in_rule__QueryObject__Group__22756);
            rule__QueryObject__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QueryObject__Group__3_in_rule__QueryObject__Group__22759);
            rule__QueryObject__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__2"


    // $ANTLR start "rule__QueryObject__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1325:1: rule__QueryObject__Group__2__Impl : ( ( rule__QueryObject__MembersAssignment_2 )? ) ;
    public final void rule__QueryObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1329:1: ( ( ( rule__QueryObject__MembersAssignment_2 )? ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1330:1: ( ( rule__QueryObject__MembersAssignment_2 )? )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1330:1: ( ( rule__QueryObject__MembersAssignment_2 )? )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1331:1: ( rule__QueryObject__MembersAssignment_2 )?
            {
             before(grammarAccess.getQueryObjectAccess().getMembersAssignment_2()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1332:1: ( rule__QueryObject__MembersAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)||(LA9_0>=13 && LA9_0<=29)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1332:2: rule__QueryObject__MembersAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QueryObject__MembersAssignment_2_in_rule__QueryObject__Group__2__Impl2786);
                    rule__QueryObject__MembersAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQueryObjectAccess().getMembersAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__2__Impl"


    // $ANTLR start "rule__QueryObject__Group__3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1342:1: rule__QueryObject__Group__3 : rule__QueryObject__Group__3__Impl rule__QueryObject__Group__4 ;
    public final void rule__QueryObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1346:1: ( rule__QueryObject__Group__3__Impl rule__QueryObject__Group__4 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1347:2: rule__QueryObject__Group__3__Impl rule__QueryObject__Group__4
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__3__Impl_in_rule__QueryObject__Group__32817);
            rule__QueryObject__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QueryObject__Group__4_in_rule__QueryObject__Group__32820);
            rule__QueryObject__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__3"


    // $ANTLR start "rule__QueryObject__Group__3__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1354:1: rule__QueryObject__Group__3__Impl : ( ( rule__QueryObject__Group_3__0 )* ) ;
    public final void rule__QueryObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1358:1: ( ( ( rule__QueryObject__Group_3__0 )* ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1359:1: ( ( rule__QueryObject__Group_3__0 )* )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1359:1: ( ( rule__QueryObject__Group_3__0 )* )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1360:1: ( rule__QueryObject__Group_3__0 )*
            {
             before(grammarAccess.getQueryObjectAccess().getGroup_3()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1361:1: ( rule__QueryObject__Group_3__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1361:2: rule__QueryObject__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__QueryObject__Group_3__0_in_rule__QueryObject__Group__3__Impl2847);
            	    rule__QueryObject__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getQueryObjectAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__3__Impl"


    // $ANTLR start "rule__QueryObject__Group__4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1371:1: rule__QueryObject__Group__4 : rule__QueryObject__Group__4__Impl ;
    public final void rule__QueryObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1375:1: ( rule__QueryObject__Group__4__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1376:2: rule__QueryObject__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__QueryObject__Group__4__Impl_in_rule__QueryObject__Group__42878);
            rule__QueryObject__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__4"


    // $ANTLR start "rule__QueryObject__Group__4__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1382:1: rule__QueryObject__Group__4__Impl : ( '}' ) ;
    public final void rule__QueryObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1386:1: ( ( '}' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1387:1: ( '}' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1387:1: ( '}' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1388:1: '}'
            {
             before(grammarAccess.getQueryObjectAccess().getRightCurlyBracketKeyword_4()); 
            match(input,34,FOLLOW_34_in_rule__QueryObject__Group__4__Impl2906); 
             after(grammarAccess.getQueryObjectAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group__4__Impl"


    // $ANTLR start "rule__QueryObject__Group_3__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1411:1: rule__QueryObject__Group_3__0 : rule__QueryObject__Group_3__0__Impl rule__QueryObject__Group_3__1 ;
    public final void rule__QueryObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1415:1: ( rule__QueryObject__Group_3__0__Impl rule__QueryObject__Group_3__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1416:2: rule__QueryObject__Group_3__0__Impl rule__QueryObject__Group_3__1
            {
            pushFollow(FOLLOW_rule__QueryObject__Group_3__0__Impl_in_rule__QueryObject__Group_3__02947);
            rule__QueryObject__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QueryObject__Group_3__1_in_rule__QueryObject__Group_3__02950);
            rule__QueryObject__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group_3__0"


    // $ANTLR start "rule__QueryObject__Group_3__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1423:1: rule__QueryObject__Group_3__0__Impl : ( ',' ) ;
    public final void rule__QueryObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1427:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1428:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1428:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1429:1: ','
            {
             before(grammarAccess.getQueryObjectAccess().getCommaKeyword_3_0()); 
            match(input,32,FOLLOW_32_in_rule__QueryObject__Group_3__0__Impl2978); 
             after(grammarAccess.getQueryObjectAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group_3__0__Impl"


    // $ANTLR start "rule__QueryObject__Group_3__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1442:1: rule__QueryObject__Group_3__1 : rule__QueryObject__Group_3__1__Impl ;
    public final void rule__QueryObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1446:1: ( rule__QueryObject__Group_3__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1447:2: rule__QueryObject__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__QueryObject__Group_3__1__Impl_in_rule__QueryObject__Group_3__13009);
            rule__QueryObject__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group_3__1"


    // $ANTLR start "rule__QueryObject__Group_3__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1453:1: rule__QueryObject__Group_3__1__Impl : ( ( rule__QueryObject__MembersAssignment_3_1 ) ) ;
    public final void rule__QueryObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1457:1: ( ( ( rule__QueryObject__MembersAssignment_3_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1458:1: ( ( rule__QueryObject__MembersAssignment_3_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1458:1: ( ( rule__QueryObject__MembersAssignment_3_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1459:1: ( rule__QueryObject__MembersAssignment_3_1 )
            {
             before(grammarAccess.getQueryObjectAccess().getMembersAssignment_3_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1460:1: ( rule__QueryObject__MembersAssignment_3_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1460:2: rule__QueryObject__MembersAssignment_3_1
            {
            pushFollow(FOLLOW_rule__QueryObject__MembersAssignment_3_1_in_rule__QueryObject__Group_3__1__Impl3036);
            rule__QueryObject__MembersAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getQueryObjectAccess().getMembersAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__Group_3__1__Impl"


    // $ANTLR start "rule__Member__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1474:1: rule__Member__Group__0 : rule__Member__Group__0__Impl rule__Member__Group__1 ;
    public final void rule__Member__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1478:1: ( rule__Member__Group__0__Impl rule__Member__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1479:2: rule__Member__Group__0__Impl rule__Member__Group__1
            {
            pushFollow(FOLLOW_rule__Member__Group__0__Impl_in_rule__Member__Group__03070);
            rule__Member__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Member__Group__1_in_rule__Member__Group__03073);
            rule__Member__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__0"


    // $ANTLR start "rule__Member__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1486:1: rule__Member__Group__0__Impl : ( ( rule__Member__KeyAssignment_0 ) ) ;
    public final void rule__Member__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1490:1: ( ( ( rule__Member__KeyAssignment_0 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1491:1: ( ( rule__Member__KeyAssignment_0 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1491:1: ( ( rule__Member__KeyAssignment_0 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1492:1: ( rule__Member__KeyAssignment_0 )
            {
             before(grammarAccess.getMemberAccess().getKeyAssignment_0()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1493:1: ( rule__Member__KeyAssignment_0 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1493:2: rule__Member__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__Member__KeyAssignment_0_in_rule__Member__Group__0__Impl3100);
            rule__Member__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMemberAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__0__Impl"


    // $ANTLR start "rule__Member__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1503:1: rule__Member__Group__1 : rule__Member__Group__1__Impl rule__Member__Group__2 ;
    public final void rule__Member__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1507:1: ( rule__Member__Group__1__Impl rule__Member__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1508:2: rule__Member__Group__1__Impl rule__Member__Group__2
            {
            pushFollow(FOLLOW_rule__Member__Group__1__Impl_in_rule__Member__Group__13130);
            rule__Member__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Member__Group__2_in_rule__Member__Group__13133);
            rule__Member__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__1"


    // $ANTLR start "rule__Member__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1515:1: rule__Member__Group__1__Impl : ( ':' ) ;
    public final void rule__Member__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1519:1: ( ( ':' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1520:1: ( ':' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1520:1: ( ':' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1521:1: ':'
            {
             before(grammarAccess.getMemberAccess().getColonKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__Member__Group__1__Impl3161); 
             after(grammarAccess.getMemberAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__1__Impl"


    // $ANTLR start "rule__Member__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1534:1: rule__Member__Group__2 : rule__Member__Group__2__Impl ;
    public final void rule__Member__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1538:1: ( rule__Member__Group__2__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1539:2: rule__Member__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Member__Group__2__Impl_in_rule__Member__Group__23192);
            rule__Member__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__2"


    // $ANTLR start "rule__Member__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1545:1: rule__Member__Group__2__Impl : ( ( rule__Member__ValueAssignment_2 ) ) ;
    public final void rule__Member__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1549:1: ( ( ( rule__Member__ValueAssignment_2 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1550:1: ( ( rule__Member__ValueAssignment_2 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1550:1: ( ( rule__Member__ValueAssignment_2 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1551:1: ( rule__Member__ValueAssignment_2 )
            {
             before(grammarAccess.getMemberAccess().getValueAssignment_2()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1552:1: ( rule__Member__ValueAssignment_2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1552:2: rule__Member__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Member__ValueAssignment_2_in_rule__Member__Group__2__Impl3219);
            rule__Member__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMemberAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__Group__2__Impl"


    // $ANTLR start "rule__Array__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1568:1: rule__Array__Group__0 : rule__Array__Group__0__Impl rule__Array__Group__1 ;
    public final void rule__Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1572:1: ( rule__Array__Group__0__Impl rule__Array__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1573:2: rule__Array__Group__0__Impl rule__Array__Group__1
            {
            pushFollow(FOLLOW_rule__Array__Group__0__Impl_in_rule__Array__Group__03255);
            rule__Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Array__Group__1_in_rule__Array__Group__03258);
            rule__Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__0"


    // $ANTLR start "rule__Array__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1580:1: rule__Array__Group__0__Impl : ( () ) ;
    public final void rule__Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1584:1: ( ( () ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1585:1: ( () )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1585:1: ( () )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1586:1: ()
            {
             before(grammarAccess.getArrayAccess().getArrayAction_0()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1587:1: ()
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1589:1: 
            {
            }

             after(grammarAccess.getArrayAccess().getArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__0__Impl"


    // $ANTLR start "rule__Array__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1599:1: rule__Array__Group__1 : rule__Array__Group__1__Impl rule__Array__Group__2 ;
    public final void rule__Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1603:1: ( rule__Array__Group__1__Impl rule__Array__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1604:2: rule__Array__Group__1__Impl rule__Array__Group__2
            {
            pushFollow(FOLLOW_rule__Array__Group__1__Impl_in_rule__Array__Group__13316);
            rule__Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Array__Group__2_in_rule__Array__Group__13319);
            rule__Array__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__1"


    // $ANTLR start "rule__Array__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1611:1: rule__Array__Group__1__Impl : ( '[' ) ;
    public final void rule__Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1615:1: ( ( '[' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1616:1: ( '[' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1616:1: ( '[' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1617:1: '['
            {
             before(grammarAccess.getArrayAccess().getLeftSquareBracketKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__Array__Group__1__Impl3347); 
             after(grammarAccess.getArrayAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__1__Impl"


    // $ANTLR start "rule__Array__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1630:1: rule__Array__Group__2 : rule__Array__Group__2__Impl rule__Array__Group__3 ;
    public final void rule__Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1634:1: ( rule__Array__Group__2__Impl rule__Array__Group__3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1635:2: rule__Array__Group__2__Impl rule__Array__Group__3
            {
            pushFollow(FOLLOW_rule__Array__Group__2__Impl_in_rule__Array__Group__23378);
            rule__Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Array__Group__3_in_rule__Array__Group__23381);
            rule__Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__2"


    // $ANTLR start "rule__Array__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1642:1: rule__Array__Group__2__Impl : ( ( rule__Array__ValuesAssignment_2 )? ) ;
    public final void rule__Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1646:1: ( ( ( rule__Array__ValuesAssignment_2 )? ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1647:1: ( ( rule__Array__ValuesAssignment_2 )? )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1647:1: ( ( rule__Array__ValuesAssignment_2 )? )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1648:1: ( rule__Array__ValuesAssignment_2 )?
            {
             before(grammarAccess.getArrayAccess().getValuesAssignment_2()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1649:1: ( rule__Array__ValuesAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_NUMBER)||LA11_0==12||(LA11_0>=30 && LA11_0<=31)||LA11_0==33||LA11_0==36||(LA11_0>=38 && LA11_0<=39)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1649:2: rule__Array__ValuesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Array__ValuesAssignment_2_in_rule__Array__Group__2__Impl3408);
                    rule__Array__ValuesAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArrayAccess().getValuesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__2__Impl"


    // $ANTLR start "rule__Array__Group__3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1659:1: rule__Array__Group__3 : rule__Array__Group__3__Impl rule__Array__Group__4 ;
    public final void rule__Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1663:1: ( rule__Array__Group__3__Impl rule__Array__Group__4 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1664:2: rule__Array__Group__3__Impl rule__Array__Group__4
            {
            pushFollow(FOLLOW_rule__Array__Group__3__Impl_in_rule__Array__Group__33439);
            rule__Array__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Array__Group__4_in_rule__Array__Group__33442);
            rule__Array__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__3"


    // $ANTLR start "rule__Array__Group__3__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1671:1: rule__Array__Group__3__Impl : ( ( rule__Array__Group_3__0 )* ) ;
    public final void rule__Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1675:1: ( ( ( rule__Array__Group_3__0 )* ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1676:1: ( ( rule__Array__Group_3__0 )* )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1676:1: ( ( rule__Array__Group_3__0 )* )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1677:1: ( rule__Array__Group_3__0 )*
            {
             before(grammarAccess.getArrayAccess().getGroup_3()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1678:1: ( rule__Array__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1678:2: rule__Array__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Array__Group_3__0_in_rule__Array__Group__3__Impl3469);
            	    rule__Array__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getArrayAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__3__Impl"


    // $ANTLR start "rule__Array__Group__4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1688:1: rule__Array__Group__4 : rule__Array__Group__4__Impl ;
    public final void rule__Array__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1692:1: ( rule__Array__Group__4__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1693:2: rule__Array__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Array__Group__4__Impl_in_rule__Array__Group__43500);
            rule__Array__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__4"


    // $ANTLR start "rule__Array__Group__4__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1699:1: rule__Array__Group__4__Impl : ( ']' ) ;
    public final void rule__Array__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1703:1: ( ( ']' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1704:1: ( ']' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1704:1: ( ']' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1705:1: ']'
            {
             before(grammarAccess.getArrayAccess().getRightSquareBracketKeyword_4()); 
            match(input,37,FOLLOW_37_in_rule__Array__Group__4__Impl3528); 
             after(grammarAccess.getArrayAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group__4__Impl"


    // $ANTLR start "rule__Array__Group_3__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1728:1: rule__Array__Group_3__0 : rule__Array__Group_3__0__Impl rule__Array__Group_3__1 ;
    public final void rule__Array__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1732:1: ( rule__Array__Group_3__0__Impl rule__Array__Group_3__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1733:2: rule__Array__Group_3__0__Impl rule__Array__Group_3__1
            {
            pushFollow(FOLLOW_rule__Array__Group_3__0__Impl_in_rule__Array__Group_3__03569);
            rule__Array__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Array__Group_3__1_in_rule__Array__Group_3__03572);
            rule__Array__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group_3__0"


    // $ANTLR start "rule__Array__Group_3__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1740:1: rule__Array__Group_3__0__Impl : ( ',' ) ;
    public final void rule__Array__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1744:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1745:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1745:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1746:1: ','
            {
             before(grammarAccess.getArrayAccess().getCommaKeyword_3_0()); 
            match(input,32,FOLLOW_32_in_rule__Array__Group_3__0__Impl3600); 
             after(grammarAccess.getArrayAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group_3__0__Impl"


    // $ANTLR start "rule__Array__Group_3__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1759:1: rule__Array__Group_3__1 : rule__Array__Group_3__1__Impl ;
    public final void rule__Array__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1763:1: ( rule__Array__Group_3__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1764:2: rule__Array__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Array__Group_3__1__Impl_in_rule__Array__Group_3__13631);
            rule__Array__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group_3__1"


    // $ANTLR start "rule__Array__Group_3__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1770:1: rule__Array__Group_3__1__Impl : ( ( rule__Array__ValuesAssignment_3_1 ) ) ;
    public final void rule__Array__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1774:1: ( ( ( rule__Array__ValuesAssignment_3_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1775:1: ( ( rule__Array__ValuesAssignment_3_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1775:1: ( ( rule__Array__ValuesAssignment_3_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1776:1: ( rule__Array__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getArrayAccess().getValuesAssignment_3_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1777:1: ( rule__Array__ValuesAssignment_3_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1777:2: rule__Array__ValuesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Array__ValuesAssignment_3_1_in_rule__Array__Group_3__1__Impl3658);
            rule__Array__ValuesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getArrayAccess().getValuesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__Group_3__1__Impl"


    // $ANTLR start "rule__DateNow__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1791:1: rule__DateNow__Group__0 : rule__DateNow__Group__0__Impl rule__DateNow__Group__1 ;
    public final void rule__DateNow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1795:1: ( rule__DateNow__Group__0__Impl rule__DateNow__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1796:2: rule__DateNow__Group__0__Impl rule__DateNow__Group__1
            {
            pushFollow(FOLLOW_rule__DateNow__Group__0__Impl_in_rule__DateNow__Group__03692);
            rule__DateNow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateNow__Group__1_in_rule__DateNow__Group__03695);
            rule__DateNow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateNow__Group__0"


    // $ANTLR start "rule__DateNow__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1803:1: rule__DateNow__Group__0__Impl : ( () ) ;
    public final void rule__DateNow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1807:1: ( ( () ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1808:1: ( () )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1808:1: ( () )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1809:1: ()
            {
             before(grammarAccess.getDateNowAccess().getJsonDateAction_0()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1810:1: ()
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1812:1: 
            {
            }

             after(grammarAccess.getDateNowAccess().getJsonDateAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateNow__Group__0__Impl"


    // $ANTLR start "rule__DateNow__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1822:1: rule__DateNow__Group__1 : rule__DateNow__Group__1__Impl ;
    public final void rule__DateNow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1826:1: ( rule__DateNow__Group__1__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1827:2: rule__DateNow__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DateNow__Group__1__Impl_in_rule__DateNow__Group__13753);
            rule__DateNow__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateNow__Group__1"


    // $ANTLR start "rule__DateNow__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1833:1: rule__DateNow__Group__1__Impl : ( 'new Date()' ) ;
    public final void rule__DateNow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1837:1: ( ( 'new Date()' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1838:1: ( 'new Date()' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1838:1: ( 'new Date()' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1839:1: 'new Date()'
            {
             before(grammarAccess.getDateNowAccess().getNewDateKeyword_1()); 
            match(input,38,FOLLOW_38_in_rule__DateNow__Group__1__Impl3781); 
             after(grammarAccess.getDateNowAccess().getNewDateKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateNow__Group__1__Impl"


    // $ANTLR start "rule__DateMilli__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1856:1: rule__DateMilli__Group__0 : rule__DateMilli__Group__0__Impl rule__DateMilli__Group__1 ;
    public final void rule__DateMilli__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1860:1: ( rule__DateMilli__Group__0__Impl rule__DateMilli__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1861:2: rule__DateMilli__Group__0__Impl rule__DateMilli__Group__1
            {
            pushFollow(FOLLOW_rule__DateMilli__Group__0__Impl_in_rule__DateMilli__Group__03816);
            rule__DateMilli__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateMilli__Group__1_in_rule__DateMilli__Group__03819);
            rule__DateMilli__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__0"


    // $ANTLR start "rule__DateMilli__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1868:1: rule__DateMilli__Group__0__Impl : ( 'new Date(' ) ;
    public final void rule__DateMilli__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1872:1: ( ( 'new Date(' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1873:1: ( 'new Date(' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1873:1: ( 'new Date(' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1874:1: 'new Date('
            {
             before(grammarAccess.getDateMilliAccess().getNewDateKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__DateMilli__Group__0__Impl3847); 
             after(grammarAccess.getDateMilliAccess().getNewDateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__0__Impl"


    // $ANTLR start "rule__DateMilli__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1887:1: rule__DateMilli__Group__1 : rule__DateMilli__Group__1__Impl rule__DateMilli__Group__2 ;
    public final void rule__DateMilli__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1891:1: ( rule__DateMilli__Group__1__Impl rule__DateMilli__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1892:2: rule__DateMilli__Group__1__Impl rule__DateMilli__Group__2
            {
            pushFollow(FOLLOW_rule__DateMilli__Group__1__Impl_in_rule__DateMilli__Group__13878);
            rule__DateMilli__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateMilli__Group__2_in_rule__DateMilli__Group__13881);
            rule__DateMilli__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__1"


    // $ANTLR start "rule__DateMilli__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1899:1: rule__DateMilli__Group__1__Impl : ( ( rule__DateMilli__MillisecondsAssignment_1 ) ) ;
    public final void rule__DateMilli__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1903:1: ( ( ( rule__DateMilli__MillisecondsAssignment_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1904:1: ( ( rule__DateMilli__MillisecondsAssignment_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1904:1: ( ( rule__DateMilli__MillisecondsAssignment_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1905:1: ( rule__DateMilli__MillisecondsAssignment_1 )
            {
             before(grammarAccess.getDateMilliAccess().getMillisecondsAssignment_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1906:1: ( rule__DateMilli__MillisecondsAssignment_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1906:2: rule__DateMilli__MillisecondsAssignment_1
            {
            pushFollow(FOLLOW_rule__DateMilli__MillisecondsAssignment_1_in_rule__DateMilli__Group__1__Impl3908);
            rule__DateMilli__MillisecondsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDateMilliAccess().getMillisecondsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__1__Impl"


    // $ANTLR start "rule__DateMilli__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1916:1: rule__DateMilli__Group__2 : rule__DateMilli__Group__2__Impl ;
    public final void rule__DateMilli__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1920:1: ( rule__DateMilli__Group__2__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1921:2: rule__DateMilli__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DateMilli__Group__2__Impl_in_rule__DateMilli__Group__23938);
            rule__DateMilli__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__2"


    // $ANTLR start "rule__DateMilli__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1927:1: rule__DateMilli__Group__2__Impl : ( ')' ) ;
    public final void rule__DateMilli__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1931:1: ( ( ')' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1932:1: ( ')' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1932:1: ( ')' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1933:1: ')'
            {
             before(grammarAccess.getDateMilliAccess().getRightParenthesisKeyword_2()); 
            match(input,40,FOLLOW_40_in_rule__DateMilli__Group__2__Impl3966); 
             after(grammarAccess.getDateMilliAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__Group__2__Impl"


    // $ANTLR start "rule__DateString__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1952:1: rule__DateString__Group__0 : rule__DateString__Group__0__Impl rule__DateString__Group__1 ;
    public final void rule__DateString__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1956:1: ( rule__DateString__Group__0__Impl rule__DateString__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1957:2: rule__DateString__Group__0__Impl rule__DateString__Group__1
            {
            pushFollow(FOLLOW_rule__DateString__Group__0__Impl_in_rule__DateString__Group__04003);
            rule__DateString__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateString__Group__1_in_rule__DateString__Group__04006);
            rule__DateString__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__0"


    // $ANTLR start "rule__DateString__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1964:1: rule__DateString__Group__0__Impl : ( 'new Date(' ) ;
    public final void rule__DateString__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1968:1: ( ( 'new Date(' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1969:1: ( 'new Date(' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1969:1: ( 'new Date(' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1970:1: 'new Date('
            {
             before(grammarAccess.getDateStringAccess().getNewDateKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__DateString__Group__0__Impl4034); 
             after(grammarAccess.getDateStringAccess().getNewDateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__0__Impl"


    // $ANTLR start "rule__DateString__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1983:1: rule__DateString__Group__1 : rule__DateString__Group__1__Impl rule__DateString__Group__2 ;
    public final void rule__DateString__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1987:1: ( rule__DateString__Group__1__Impl rule__DateString__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1988:2: rule__DateString__Group__1__Impl rule__DateString__Group__2
            {
            pushFollow(FOLLOW_rule__DateString__Group__1__Impl_in_rule__DateString__Group__14065);
            rule__DateString__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateString__Group__2_in_rule__DateString__Group__14068);
            rule__DateString__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__1"


    // $ANTLR start "rule__DateString__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1995:1: rule__DateString__Group__1__Impl : ( ( rule__DateString__DateStringAssignment_1 ) ) ;
    public final void rule__DateString__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:1999:1: ( ( ( rule__DateString__DateStringAssignment_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2000:1: ( ( rule__DateString__DateStringAssignment_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2000:1: ( ( rule__DateString__DateStringAssignment_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2001:1: ( rule__DateString__DateStringAssignment_1 )
            {
             before(grammarAccess.getDateStringAccess().getDateStringAssignment_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2002:1: ( rule__DateString__DateStringAssignment_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2002:2: rule__DateString__DateStringAssignment_1
            {
            pushFollow(FOLLOW_rule__DateString__DateStringAssignment_1_in_rule__DateString__Group__1__Impl4095);
            rule__DateString__DateStringAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDateStringAccess().getDateStringAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__1__Impl"


    // $ANTLR start "rule__DateString__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2012:1: rule__DateString__Group__2 : rule__DateString__Group__2__Impl ;
    public final void rule__DateString__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2016:1: ( rule__DateString__Group__2__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2017:2: rule__DateString__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DateString__Group__2__Impl_in_rule__DateString__Group__24125);
            rule__DateString__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__2"


    // $ANTLR start "rule__DateString__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2023:1: rule__DateString__Group__2__Impl : ( ')' ) ;
    public final void rule__DateString__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2027:1: ( ( ')' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2028:1: ( ')' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2028:1: ( ')' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2029:1: ')'
            {
             before(grammarAccess.getDateStringAccess().getRightParenthesisKeyword_2()); 
            match(input,40,FOLLOW_40_in_rule__DateString__Group__2__Impl4153); 
             after(grammarAccess.getDateStringAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__Group__2__Impl"


    // $ANTLR start "rule__DateFull__Group__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2048:1: rule__DateFull__Group__0 : rule__DateFull__Group__0__Impl rule__DateFull__Group__1 ;
    public final void rule__DateFull__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2052:1: ( rule__DateFull__Group__0__Impl rule__DateFull__Group__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2053:2: rule__DateFull__Group__0__Impl rule__DateFull__Group__1
            {
            pushFollow(FOLLOW_rule__DateFull__Group__0__Impl_in_rule__DateFull__Group__04190);
            rule__DateFull__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__1_in_rule__DateFull__Group__04193);
            rule__DateFull__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__0"


    // $ANTLR start "rule__DateFull__Group__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2060:1: rule__DateFull__Group__0__Impl : ( 'new Date(' ) ;
    public final void rule__DateFull__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2064:1: ( ( 'new Date(' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2065:1: ( 'new Date(' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2065:1: ( 'new Date(' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2066:1: 'new Date('
            {
             before(grammarAccess.getDateFullAccess().getNewDateKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__DateFull__Group__0__Impl4221); 
             after(grammarAccess.getDateFullAccess().getNewDateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__0__Impl"


    // $ANTLR start "rule__DateFull__Group__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2079:1: rule__DateFull__Group__1 : rule__DateFull__Group__1__Impl rule__DateFull__Group__2 ;
    public final void rule__DateFull__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2083:1: ( rule__DateFull__Group__1__Impl rule__DateFull__Group__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2084:2: rule__DateFull__Group__1__Impl rule__DateFull__Group__2
            {
            pushFollow(FOLLOW_rule__DateFull__Group__1__Impl_in_rule__DateFull__Group__14252);
            rule__DateFull__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__2_in_rule__DateFull__Group__14255);
            rule__DateFull__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__1"


    // $ANTLR start "rule__DateFull__Group__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2091:1: rule__DateFull__Group__1__Impl : ( ( rule__DateFull__YearAssignment_1 ) ) ;
    public final void rule__DateFull__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2095:1: ( ( ( rule__DateFull__YearAssignment_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2096:1: ( ( rule__DateFull__YearAssignment_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2096:1: ( ( rule__DateFull__YearAssignment_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2097:1: ( rule__DateFull__YearAssignment_1 )
            {
             before(grammarAccess.getDateFullAccess().getYearAssignment_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2098:1: ( rule__DateFull__YearAssignment_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2098:2: rule__DateFull__YearAssignment_1
            {
            pushFollow(FOLLOW_rule__DateFull__YearAssignment_1_in_rule__DateFull__Group__1__Impl4282);
            rule__DateFull__YearAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getYearAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__1__Impl"


    // $ANTLR start "rule__DateFull__Group__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2108:1: rule__DateFull__Group__2 : rule__DateFull__Group__2__Impl rule__DateFull__Group__3 ;
    public final void rule__DateFull__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2112:1: ( rule__DateFull__Group__2__Impl rule__DateFull__Group__3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2113:2: rule__DateFull__Group__2__Impl rule__DateFull__Group__3
            {
            pushFollow(FOLLOW_rule__DateFull__Group__2__Impl_in_rule__DateFull__Group__24312);
            rule__DateFull__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__3_in_rule__DateFull__Group__24315);
            rule__DateFull__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__2"


    // $ANTLR start "rule__DateFull__Group__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2120:1: rule__DateFull__Group__2__Impl : ( ',' ) ;
    public final void rule__DateFull__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2124:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2125:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2125:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2126:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group__2__Impl4343); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__2__Impl"


    // $ANTLR start "rule__DateFull__Group__3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2139:1: rule__DateFull__Group__3 : rule__DateFull__Group__3__Impl rule__DateFull__Group__4 ;
    public final void rule__DateFull__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2143:1: ( rule__DateFull__Group__3__Impl rule__DateFull__Group__4 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2144:2: rule__DateFull__Group__3__Impl rule__DateFull__Group__4
            {
            pushFollow(FOLLOW_rule__DateFull__Group__3__Impl_in_rule__DateFull__Group__34374);
            rule__DateFull__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__4_in_rule__DateFull__Group__34377);
            rule__DateFull__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__3"


    // $ANTLR start "rule__DateFull__Group__3__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2151:1: rule__DateFull__Group__3__Impl : ( ( rule__DateFull__MonthAssignment_3 ) ) ;
    public final void rule__DateFull__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2155:1: ( ( ( rule__DateFull__MonthAssignment_3 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2156:1: ( ( rule__DateFull__MonthAssignment_3 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2156:1: ( ( rule__DateFull__MonthAssignment_3 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2157:1: ( rule__DateFull__MonthAssignment_3 )
            {
             before(grammarAccess.getDateFullAccess().getMonthAssignment_3()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2158:1: ( rule__DateFull__MonthAssignment_3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2158:2: rule__DateFull__MonthAssignment_3
            {
            pushFollow(FOLLOW_rule__DateFull__MonthAssignment_3_in_rule__DateFull__Group__3__Impl4404);
            rule__DateFull__MonthAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getMonthAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__3__Impl"


    // $ANTLR start "rule__DateFull__Group__4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2168:1: rule__DateFull__Group__4 : rule__DateFull__Group__4__Impl rule__DateFull__Group__5 ;
    public final void rule__DateFull__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2172:1: ( rule__DateFull__Group__4__Impl rule__DateFull__Group__5 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2173:2: rule__DateFull__Group__4__Impl rule__DateFull__Group__5
            {
            pushFollow(FOLLOW_rule__DateFull__Group__4__Impl_in_rule__DateFull__Group__44434);
            rule__DateFull__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__5_in_rule__DateFull__Group__44437);
            rule__DateFull__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__4"


    // $ANTLR start "rule__DateFull__Group__4__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2180:1: rule__DateFull__Group__4__Impl : ( ',' ) ;
    public final void rule__DateFull__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2184:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2185:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2185:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2186:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group__4__Impl4465); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__4__Impl"


    // $ANTLR start "rule__DateFull__Group__5"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2199:1: rule__DateFull__Group__5 : rule__DateFull__Group__5__Impl rule__DateFull__Group__6 ;
    public final void rule__DateFull__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2203:1: ( rule__DateFull__Group__5__Impl rule__DateFull__Group__6 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2204:2: rule__DateFull__Group__5__Impl rule__DateFull__Group__6
            {
            pushFollow(FOLLOW_rule__DateFull__Group__5__Impl_in_rule__DateFull__Group__54496);
            rule__DateFull__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__6_in_rule__DateFull__Group__54499);
            rule__DateFull__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__5"


    // $ANTLR start "rule__DateFull__Group__5__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2211:1: rule__DateFull__Group__5__Impl : ( ( rule__DateFull__DayAssignment_5 ) ) ;
    public final void rule__DateFull__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2215:1: ( ( ( rule__DateFull__DayAssignment_5 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2216:1: ( ( rule__DateFull__DayAssignment_5 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2216:1: ( ( rule__DateFull__DayAssignment_5 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2217:1: ( rule__DateFull__DayAssignment_5 )
            {
             before(grammarAccess.getDateFullAccess().getDayAssignment_5()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2218:1: ( rule__DateFull__DayAssignment_5 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2218:2: rule__DateFull__DayAssignment_5
            {
            pushFollow(FOLLOW_rule__DateFull__DayAssignment_5_in_rule__DateFull__Group__5__Impl4526);
            rule__DateFull__DayAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getDayAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__5__Impl"


    // $ANTLR start "rule__DateFull__Group__6"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2228:1: rule__DateFull__Group__6 : rule__DateFull__Group__6__Impl rule__DateFull__Group__7 ;
    public final void rule__DateFull__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2232:1: ( rule__DateFull__Group__6__Impl rule__DateFull__Group__7 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2233:2: rule__DateFull__Group__6__Impl rule__DateFull__Group__7
            {
            pushFollow(FOLLOW_rule__DateFull__Group__6__Impl_in_rule__DateFull__Group__64556);
            rule__DateFull__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group__7_in_rule__DateFull__Group__64559);
            rule__DateFull__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__6"


    // $ANTLR start "rule__DateFull__Group__6__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2240:1: rule__DateFull__Group__6__Impl : ( ( rule__DateFull__Group_6__0 )? ) ;
    public final void rule__DateFull__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2244:1: ( ( ( rule__DateFull__Group_6__0 )? ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2245:1: ( ( rule__DateFull__Group_6__0 )? )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2245:1: ( ( rule__DateFull__Group_6__0 )? )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2246:1: ( rule__DateFull__Group_6__0 )?
            {
             before(grammarAccess.getDateFullAccess().getGroup_6()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2247:1: ( rule__DateFull__Group_6__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2247:2: rule__DateFull__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__DateFull__Group_6__0_in_rule__DateFull__Group__6__Impl4586);
                    rule__DateFull__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDateFullAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__6__Impl"


    // $ANTLR start "rule__DateFull__Group__7"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2257:1: rule__DateFull__Group__7 : rule__DateFull__Group__7__Impl ;
    public final void rule__DateFull__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2261:1: ( rule__DateFull__Group__7__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2262:2: rule__DateFull__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__DateFull__Group__7__Impl_in_rule__DateFull__Group__74617);
            rule__DateFull__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__7"


    // $ANTLR start "rule__DateFull__Group__7__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2268:1: rule__DateFull__Group__7__Impl : ( ')' ) ;
    public final void rule__DateFull__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2272:1: ( ( ')' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2273:1: ( ')' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2273:1: ( ')' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2274:1: ')'
            {
             before(grammarAccess.getDateFullAccess().getRightParenthesisKeyword_7()); 
            match(input,40,FOLLOW_40_in_rule__DateFull__Group__7__Impl4645); 
             after(grammarAccess.getDateFullAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group__7__Impl"


    // $ANTLR start "rule__DateFull__Group_6__0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2303:1: rule__DateFull__Group_6__0 : rule__DateFull__Group_6__0__Impl rule__DateFull__Group_6__1 ;
    public final void rule__DateFull__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2307:1: ( rule__DateFull__Group_6__0__Impl rule__DateFull__Group_6__1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2308:2: rule__DateFull__Group_6__0__Impl rule__DateFull__Group_6__1
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__0__Impl_in_rule__DateFull__Group_6__04692);
            rule__DateFull__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__1_in_rule__DateFull__Group_6__04695);
            rule__DateFull__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__0"


    // $ANTLR start "rule__DateFull__Group_6__0__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2315:1: rule__DateFull__Group_6__0__Impl : ( ',' ) ;
    public final void rule__DateFull__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2319:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2320:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2320:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2321:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_6_0()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group_6__0__Impl4723); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__0__Impl"


    // $ANTLR start "rule__DateFull__Group_6__1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2334:1: rule__DateFull__Group_6__1 : rule__DateFull__Group_6__1__Impl rule__DateFull__Group_6__2 ;
    public final void rule__DateFull__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2338:1: ( rule__DateFull__Group_6__1__Impl rule__DateFull__Group_6__2 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2339:2: rule__DateFull__Group_6__1__Impl rule__DateFull__Group_6__2
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__1__Impl_in_rule__DateFull__Group_6__14754);
            rule__DateFull__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__2_in_rule__DateFull__Group_6__14757);
            rule__DateFull__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__1"


    // $ANTLR start "rule__DateFull__Group_6__1__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2346:1: rule__DateFull__Group_6__1__Impl : ( ( rule__DateFull__HourAssignment_6_1 ) ) ;
    public final void rule__DateFull__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2350:1: ( ( ( rule__DateFull__HourAssignment_6_1 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2351:1: ( ( rule__DateFull__HourAssignment_6_1 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2351:1: ( ( rule__DateFull__HourAssignment_6_1 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2352:1: ( rule__DateFull__HourAssignment_6_1 )
            {
             before(grammarAccess.getDateFullAccess().getHourAssignment_6_1()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2353:1: ( rule__DateFull__HourAssignment_6_1 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2353:2: rule__DateFull__HourAssignment_6_1
            {
            pushFollow(FOLLOW_rule__DateFull__HourAssignment_6_1_in_rule__DateFull__Group_6__1__Impl4784);
            rule__DateFull__HourAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getHourAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__1__Impl"


    // $ANTLR start "rule__DateFull__Group_6__2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2363:1: rule__DateFull__Group_6__2 : rule__DateFull__Group_6__2__Impl rule__DateFull__Group_6__3 ;
    public final void rule__DateFull__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2367:1: ( rule__DateFull__Group_6__2__Impl rule__DateFull__Group_6__3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2368:2: rule__DateFull__Group_6__2__Impl rule__DateFull__Group_6__3
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__2__Impl_in_rule__DateFull__Group_6__24814);
            rule__DateFull__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__3_in_rule__DateFull__Group_6__24817);
            rule__DateFull__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__2"


    // $ANTLR start "rule__DateFull__Group_6__2__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2375:1: rule__DateFull__Group_6__2__Impl : ( ',' ) ;
    public final void rule__DateFull__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2379:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2380:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2380:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2381:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_6_2()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group_6__2__Impl4845); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__2__Impl"


    // $ANTLR start "rule__DateFull__Group_6__3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2394:1: rule__DateFull__Group_6__3 : rule__DateFull__Group_6__3__Impl rule__DateFull__Group_6__4 ;
    public final void rule__DateFull__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2398:1: ( rule__DateFull__Group_6__3__Impl rule__DateFull__Group_6__4 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2399:2: rule__DateFull__Group_6__3__Impl rule__DateFull__Group_6__4
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__3__Impl_in_rule__DateFull__Group_6__34876);
            rule__DateFull__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__4_in_rule__DateFull__Group_6__34879);
            rule__DateFull__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__3"


    // $ANTLR start "rule__DateFull__Group_6__3__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2406:1: rule__DateFull__Group_6__3__Impl : ( ( rule__DateFull__MinuteAssignment_6_3 ) ) ;
    public final void rule__DateFull__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2410:1: ( ( ( rule__DateFull__MinuteAssignment_6_3 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2411:1: ( ( rule__DateFull__MinuteAssignment_6_3 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2411:1: ( ( rule__DateFull__MinuteAssignment_6_3 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2412:1: ( rule__DateFull__MinuteAssignment_6_3 )
            {
             before(grammarAccess.getDateFullAccess().getMinuteAssignment_6_3()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2413:1: ( rule__DateFull__MinuteAssignment_6_3 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2413:2: rule__DateFull__MinuteAssignment_6_3
            {
            pushFollow(FOLLOW_rule__DateFull__MinuteAssignment_6_3_in_rule__DateFull__Group_6__3__Impl4906);
            rule__DateFull__MinuteAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getMinuteAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__3__Impl"


    // $ANTLR start "rule__DateFull__Group_6__4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2423:1: rule__DateFull__Group_6__4 : rule__DateFull__Group_6__4__Impl rule__DateFull__Group_6__5 ;
    public final void rule__DateFull__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2427:1: ( rule__DateFull__Group_6__4__Impl rule__DateFull__Group_6__5 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2428:2: rule__DateFull__Group_6__4__Impl rule__DateFull__Group_6__5
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__4__Impl_in_rule__DateFull__Group_6__44936);
            rule__DateFull__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__5_in_rule__DateFull__Group_6__44939);
            rule__DateFull__Group_6__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__4"


    // $ANTLR start "rule__DateFull__Group_6__4__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2435:1: rule__DateFull__Group_6__4__Impl : ( ',' ) ;
    public final void rule__DateFull__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2439:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2440:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2440:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2441:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_6_4()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group_6__4__Impl4967); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__4__Impl"


    // $ANTLR start "rule__DateFull__Group_6__5"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2454:1: rule__DateFull__Group_6__5 : rule__DateFull__Group_6__5__Impl rule__DateFull__Group_6__6 ;
    public final void rule__DateFull__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2458:1: ( rule__DateFull__Group_6__5__Impl rule__DateFull__Group_6__6 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2459:2: rule__DateFull__Group_6__5__Impl rule__DateFull__Group_6__6
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__5__Impl_in_rule__DateFull__Group_6__54998);
            rule__DateFull__Group_6__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__6_in_rule__DateFull__Group_6__55001);
            rule__DateFull__Group_6__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__5"


    // $ANTLR start "rule__DateFull__Group_6__5__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2466:1: rule__DateFull__Group_6__5__Impl : ( ( rule__DateFull__SecondAssignment_6_5 ) ) ;
    public final void rule__DateFull__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2470:1: ( ( ( rule__DateFull__SecondAssignment_6_5 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2471:1: ( ( rule__DateFull__SecondAssignment_6_5 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2471:1: ( ( rule__DateFull__SecondAssignment_6_5 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2472:1: ( rule__DateFull__SecondAssignment_6_5 )
            {
             before(grammarAccess.getDateFullAccess().getSecondAssignment_6_5()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2473:1: ( rule__DateFull__SecondAssignment_6_5 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2473:2: rule__DateFull__SecondAssignment_6_5
            {
            pushFollow(FOLLOW_rule__DateFull__SecondAssignment_6_5_in_rule__DateFull__Group_6__5__Impl5028);
            rule__DateFull__SecondAssignment_6_5();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getSecondAssignment_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__5__Impl"


    // $ANTLR start "rule__DateFull__Group_6__6"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2483:1: rule__DateFull__Group_6__6 : rule__DateFull__Group_6__6__Impl rule__DateFull__Group_6__7 ;
    public final void rule__DateFull__Group_6__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2487:1: ( rule__DateFull__Group_6__6__Impl rule__DateFull__Group_6__7 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2488:2: rule__DateFull__Group_6__6__Impl rule__DateFull__Group_6__7
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__6__Impl_in_rule__DateFull__Group_6__65058);
            rule__DateFull__Group_6__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DateFull__Group_6__7_in_rule__DateFull__Group_6__65061);
            rule__DateFull__Group_6__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__6"


    // $ANTLR start "rule__DateFull__Group_6__6__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2495:1: rule__DateFull__Group_6__6__Impl : ( ',' ) ;
    public final void rule__DateFull__Group_6__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2499:1: ( ( ',' ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2500:1: ( ',' )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2500:1: ( ',' )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2501:1: ','
            {
             before(grammarAccess.getDateFullAccess().getCommaKeyword_6_6()); 
            match(input,32,FOLLOW_32_in_rule__DateFull__Group_6__6__Impl5089); 
             after(grammarAccess.getDateFullAccess().getCommaKeyword_6_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__6__Impl"


    // $ANTLR start "rule__DateFull__Group_6__7"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2514:1: rule__DateFull__Group_6__7 : rule__DateFull__Group_6__7__Impl ;
    public final void rule__DateFull__Group_6__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2518:1: ( rule__DateFull__Group_6__7__Impl )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2519:2: rule__DateFull__Group_6__7__Impl
            {
            pushFollow(FOLLOW_rule__DateFull__Group_6__7__Impl_in_rule__DateFull__Group_6__75120);
            rule__DateFull__Group_6__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__7"


    // $ANTLR start "rule__DateFull__Group_6__7__Impl"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2525:1: rule__DateFull__Group_6__7__Impl : ( ( rule__DateFull__MillisecondAssignment_6_7 ) ) ;
    public final void rule__DateFull__Group_6__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2529:1: ( ( ( rule__DateFull__MillisecondAssignment_6_7 ) ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2530:1: ( ( rule__DateFull__MillisecondAssignment_6_7 ) )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2530:1: ( ( rule__DateFull__MillisecondAssignment_6_7 ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2531:1: ( rule__DateFull__MillisecondAssignment_6_7 )
            {
             before(grammarAccess.getDateFullAccess().getMillisecondAssignment_6_7()); 
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2532:1: ( rule__DateFull__MillisecondAssignment_6_7 )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2532:2: rule__DateFull__MillisecondAssignment_6_7
            {
            pushFollow(FOLLOW_rule__DateFull__MillisecondAssignment_6_7_in_rule__DateFull__Group_6__7__Impl5147);
            rule__DateFull__MillisecondAssignment_6_7();

            state._fsp--;


            }

             after(grammarAccess.getDateFullAccess().getMillisecondAssignment_6_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__Group_6__7__Impl"


    // $ANTLR start "rule__Selector__QueryAssignment_0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2559:1: rule__Selector__QueryAssignment_0 : ( ruleQueryObject ) ;
    public final void rule__Selector__QueryAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2563:1: ( ( ruleQueryObject ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2564:1: ( ruleQueryObject )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2564:1: ( ruleQueryObject )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2565:1: ruleQueryObject
            {
             before(grammarAccess.getSelectorAccess().getQueryQueryObjectParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQueryObject_in_rule__Selector__QueryAssignment_05198);
            ruleQueryObject();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getQueryQueryObjectParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__QueryAssignment_0"


    // $ANTLR start "rule__Selector__SelectionAssignment_1_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2574:1: rule__Selector__SelectionAssignment_1_1 : ( ruleSelection ) ;
    public final void rule__Selector__SelectionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2578:1: ( ( ruleSelection ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2579:1: ( ruleSelection )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2579:1: ( ruleSelection )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2580:1: ruleSelection
            {
             before(grammarAccess.getSelectorAccess().getSelectionSelectionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSelection_in_rule__Selector__SelectionAssignment_1_15229);
            ruleSelection();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getSelectionSelectionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__SelectionAssignment_1_1"


    // $ANTLR start "rule__Selection__FieldsAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2589:1: rule__Selection__FieldsAssignment_2 : ( ruleFieldSelection ) ;
    public final void rule__Selection__FieldsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2593:1: ( ( ruleFieldSelection ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2594:1: ( ruleFieldSelection )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2594:1: ( ruleFieldSelection )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2595:1: ruleFieldSelection
            {
             before(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFieldSelection_in_rule__Selection__FieldsAssignment_25260);
            ruleFieldSelection();

            state._fsp--;

             after(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__FieldsAssignment_2"


    // $ANTLR start "rule__Selection__FieldsAssignment_3_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2604:1: rule__Selection__FieldsAssignment_3_1 : ( ruleFieldSelection ) ;
    public final void rule__Selection__FieldsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2608:1: ( ( ruleFieldSelection ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2609:1: ( ruleFieldSelection )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2609:1: ( ruleFieldSelection )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2610:1: ruleFieldSelection
            {
             before(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleFieldSelection_in_rule__Selection__FieldsAssignment_3_15291);
            ruleFieldSelection();

            state._fsp--;

             after(grammarAccess.getSelectionAccess().getFieldsFieldSelectionParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selection__FieldsAssignment_3_1"


    // $ANTLR start "rule__FieldSelection__KeyAssignment_0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2619:1: rule__FieldSelection__KeyAssignment_0 : ( RULE_STRING ) ;
    public final void rule__FieldSelection__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2623:1: ( ( RULE_STRING ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2624:1: ( RULE_STRING )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2624:1: ( RULE_STRING )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2625:1: RULE_STRING
            {
             before(grammarAccess.getFieldSelectionAccess().getKeySTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__FieldSelection__KeyAssignment_05322); 
             after(grammarAccess.getFieldSelectionAccess().getKeySTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__KeyAssignment_0"


    // $ANTLR start "rule__FieldSelection__EnabledAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2634:1: rule__FieldSelection__EnabledAssignment_2 : ( RULE_INT ) ;
    public final void rule__FieldSelection__EnabledAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2638:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2639:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2639:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2640:1: RULE_INT
            {
             before(grammarAccess.getFieldSelectionAccess().getEnabledINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FieldSelection__EnabledAssignment_25353); 
             after(grammarAccess.getFieldSelectionAccess().getEnabledINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FieldSelection__EnabledAssignment_2"


    // $ANTLR start "rule__QueryObject__MembersAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2649:1: rule__QueryObject__MembersAssignment_2 : ( ruleMember ) ;
    public final void rule__QueryObject__MembersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2653:1: ( ( ruleMember ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2654:1: ( ruleMember )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2654:1: ( ruleMember )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2655:1: ruleMember
            {
             before(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMember_in_rule__QueryObject__MembersAssignment_25384);
            ruleMember();

            state._fsp--;

             after(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__MembersAssignment_2"


    // $ANTLR start "rule__QueryObject__MembersAssignment_3_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2664:1: rule__QueryObject__MembersAssignment_3_1 : ( ruleMember ) ;
    public final void rule__QueryObject__MembersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2668:1: ( ( ruleMember ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2669:1: ( ruleMember )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2669:1: ( ruleMember )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2670:1: ruleMember
            {
             before(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleMember_in_rule__QueryObject__MembersAssignment_3_15415);
            ruleMember();

            state._fsp--;

             after(grammarAccess.getQueryObjectAccess().getMembersMemberParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QueryObject__MembersAssignment_3_1"


    // $ANTLR start "rule__Member__KeyAssignment_0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2679:1: rule__Member__KeyAssignment_0 : ( ruleKey ) ;
    public final void rule__Member__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2683:1: ( ( ruleKey ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2684:1: ( ruleKey )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2684:1: ( ruleKey )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2685:1: ruleKey
            {
             before(grammarAccess.getMemberAccess().getKeyKeyParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleKey_in_rule__Member__KeyAssignment_05446);
            ruleKey();

            state._fsp--;

             after(grammarAccess.getMemberAccess().getKeyKeyParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__KeyAssignment_0"


    // $ANTLR start "rule__Member__ValueAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2694:1: rule__Member__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__Member__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2698:1: ( ( ruleValue ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2699:1: ( ruleValue )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2699:1: ( ruleValue )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2700:1: ruleValue
            {
             before(grammarAccess.getMemberAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__Member__ValueAssignment_25477);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getMemberAccess().getValueValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Member__ValueAssignment_2"


    // $ANTLR start "rule__Value__StringValueAssignment_0"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2709:1: rule__Value__StringValueAssignment_0 : ( ruleNull ) ;
    public final void rule__Value__StringValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2713:1: ( ( ruleNull ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2714:1: ( ruleNull )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2714:1: ( ruleNull )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2715:1: ruleNull
            {
             before(grammarAccess.getValueAccess().getStringValueNullParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNull_in_rule__Value__StringValueAssignment_05508);
            ruleNull();

            state._fsp--;

             after(grammarAccess.getValueAccess().getStringValueNullParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__StringValueAssignment_0"


    // $ANTLR start "rule__Value__StringValueAssignment_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2724:1: rule__Value__StringValueAssignment_1 : ( ruleBoolean ) ;
    public final void rule__Value__StringValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2728:1: ( ( ruleBoolean ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2729:1: ( ruleBoolean )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2729:1: ( ruleBoolean )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2730:1: ruleBoolean
            {
             before(grammarAccess.getValueAccess().getStringValueBooleanParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoolean_in_rule__Value__StringValueAssignment_15539);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getValueAccess().getStringValueBooleanParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__StringValueAssignment_1"


    // $ANTLR start "rule__Value__StringValueAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2739:1: rule__Value__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Value__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2743:1: ( ( RULE_STRING ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2744:1: ( RULE_STRING )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2744:1: ( RULE_STRING )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2745:1: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getStringValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Value__StringValueAssignment_25570); 
             after(grammarAccess.getValueAccess().getStringValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__StringValueAssignment_2"


    // $ANTLR start "rule__Value__StringValueAssignment_3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2754:1: rule__Value__StringValueAssignment_3 : ( RULE_ID ) ;
    public final void rule__Value__StringValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2758:1: ( ( RULE_ID ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2759:1: ( RULE_ID )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2759:1: ( RULE_ID )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2760:1: RULE_ID
            {
             before(grammarAccess.getValueAccess().getStringValueIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Value__StringValueAssignment_35601); 
             after(grammarAccess.getValueAccess().getStringValueIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__StringValueAssignment_3"


    // $ANTLR start "rule__Value__NumberValueAssignment_4"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2769:1: rule__Value__NumberValueAssignment_4 : ( RULE_NUMBER ) ;
    public final void rule__Value__NumberValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2773:1: ( ( RULE_NUMBER ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2774:1: ( RULE_NUMBER )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2774:1: ( RULE_NUMBER )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2775:1: RULE_NUMBER
            {
             before(grammarAccess.getValueAccess().getNumberValueNumberTerminalRuleCall_4_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__Value__NumberValueAssignment_45632); 
             after(grammarAccess.getValueAccess().getNumberValueNumberTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__NumberValueAssignment_4"


    // $ANTLR start "rule__Value__DateValueAssignment_5"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2784:1: rule__Value__DateValueAssignment_5 : ( ruleJsonDate ) ;
    public final void rule__Value__DateValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2788:1: ( ( ruleJsonDate ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2789:1: ( ruleJsonDate )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2789:1: ( ruleJsonDate )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2790:1: ruleJsonDate
            {
             before(grammarAccess.getValueAccess().getDateValueJsonDateParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleJsonDate_in_rule__Value__DateValueAssignment_55663);
            ruleJsonDate();

            state._fsp--;

             after(grammarAccess.getValueAccess().getDateValueJsonDateParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__DateValueAssignment_5"


    // $ANTLR start "rule__Value__ArrayValueAssignment_6"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2799:1: rule__Value__ArrayValueAssignment_6 : ( ruleArray ) ;
    public final void rule__Value__ArrayValueAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2803:1: ( ( ruleArray ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2804:1: ( ruleArray )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2804:1: ( ruleArray )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2805:1: ruleArray
            {
             before(grammarAccess.getValueAccess().getArrayValueArrayParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleArray_in_rule__Value__ArrayValueAssignment_65694);
            ruleArray();

            state._fsp--;

             after(grammarAccess.getValueAccess().getArrayValueArrayParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ArrayValueAssignment_6"


    // $ANTLR start "rule__Value__IntegerValueAssignment_7"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2814:1: rule__Value__IntegerValueAssignment_7 : ( RULE_INT ) ;
    public final void rule__Value__IntegerValueAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2818:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2819:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2819:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2820:1: RULE_INT
            {
             before(grammarAccess.getValueAccess().getIntegerValueINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Value__IntegerValueAssignment_75725); 
             after(grammarAccess.getValueAccess().getIntegerValueINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__IntegerValueAssignment_7"


    // $ANTLR start "rule__Value__ObjectValueAssignment_8"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2829:1: rule__Value__ObjectValueAssignment_8 : ( ruleQueryObject ) ;
    public final void rule__Value__ObjectValueAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2833:1: ( ( ruleQueryObject ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2834:1: ( ruleQueryObject )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2834:1: ( ruleQueryObject )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2835:1: ruleQueryObject
            {
             before(grammarAccess.getValueAccess().getObjectValueQueryObjectParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleQueryObject_in_rule__Value__ObjectValueAssignment_85756);
            ruleQueryObject();

            state._fsp--;

             after(grammarAccess.getValueAccess().getObjectValueQueryObjectParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ObjectValueAssignment_8"


    // $ANTLR start "rule__Array__ValuesAssignment_2"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2844:1: rule__Array__ValuesAssignment_2 : ( ruleValue ) ;
    public final void rule__Array__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2848:1: ( ( ruleValue ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2849:1: ( ruleValue )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2849:1: ( ruleValue )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2850:1: ruleValue
            {
             before(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__Array__ValuesAssignment_25787);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__ValuesAssignment_2"


    // $ANTLR start "rule__Array__ValuesAssignment_3_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2859:1: rule__Array__ValuesAssignment_3_1 : ( ruleValue ) ;
    public final void rule__Array__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2863:1: ( ( ruleValue ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2864:1: ( ruleValue )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2864:1: ( ruleValue )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2865:1: ruleValue
            {
             before(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__Array__ValuesAssignment_3_15818);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getArrayAccess().getValuesValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Array__ValuesAssignment_3_1"


    // $ANTLR start "rule__DateMilli__MillisecondsAssignment_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2874:1: rule__DateMilli__MillisecondsAssignment_1 : ( RULE_INT ) ;
    public final void rule__DateMilli__MillisecondsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2878:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2879:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2879:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2880:1: RULE_INT
            {
             before(grammarAccess.getDateMilliAccess().getMillisecondsINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateMilli__MillisecondsAssignment_15849); 
             after(grammarAccess.getDateMilliAccess().getMillisecondsINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateMilli__MillisecondsAssignment_1"


    // $ANTLR start "rule__DateString__DateStringAssignment_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2889:1: rule__DateString__DateStringAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DateString__DateStringAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2893:1: ( ( RULE_STRING ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2894:1: ( RULE_STRING )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2894:1: ( RULE_STRING )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2895:1: RULE_STRING
            {
             before(grammarAccess.getDateStringAccess().getDateStringSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DateString__DateStringAssignment_15880); 
             after(grammarAccess.getDateStringAccess().getDateStringSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateString__DateStringAssignment_1"


    // $ANTLR start "rule__DateFull__YearAssignment_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2904:1: rule__DateFull__YearAssignment_1 : ( RULE_INT ) ;
    public final void rule__DateFull__YearAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2908:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2909:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2909:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2910:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getYearINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__YearAssignment_15911); 
             after(grammarAccess.getDateFullAccess().getYearINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__YearAssignment_1"


    // $ANTLR start "rule__DateFull__MonthAssignment_3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2919:1: rule__DateFull__MonthAssignment_3 : ( RULE_INT ) ;
    public final void rule__DateFull__MonthAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2923:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2924:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2924:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2925:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getMonthINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__MonthAssignment_35942); 
             after(grammarAccess.getDateFullAccess().getMonthINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__MonthAssignment_3"


    // $ANTLR start "rule__DateFull__DayAssignment_5"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2934:1: rule__DateFull__DayAssignment_5 : ( RULE_INT ) ;
    public final void rule__DateFull__DayAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2938:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2939:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2939:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2940:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getDayINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__DayAssignment_55973); 
             after(grammarAccess.getDateFullAccess().getDayINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__DayAssignment_5"


    // $ANTLR start "rule__DateFull__HourAssignment_6_1"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2949:1: rule__DateFull__HourAssignment_6_1 : ( RULE_INT ) ;
    public final void rule__DateFull__HourAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2953:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2954:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2954:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2955:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getHourINTTerminalRuleCall_6_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__HourAssignment_6_16004); 
             after(grammarAccess.getDateFullAccess().getHourINTTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__HourAssignment_6_1"


    // $ANTLR start "rule__DateFull__MinuteAssignment_6_3"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2964:1: rule__DateFull__MinuteAssignment_6_3 : ( RULE_INT ) ;
    public final void rule__DateFull__MinuteAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2968:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2969:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2969:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2970:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getMinuteINTTerminalRuleCall_6_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__MinuteAssignment_6_36035); 
             after(grammarAccess.getDateFullAccess().getMinuteINTTerminalRuleCall_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__MinuteAssignment_6_3"


    // $ANTLR start "rule__DateFull__SecondAssignment_6_5"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2979:1: rule__DateFull__SecondAssignment_6_5 : ( RULE_INT ) ;
    public final void rule__DateFull__SecondAssignment_6_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2983:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2984:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2984:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2985:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getSecondINTTerminalRuleCall_6_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__SecondAssignment_6_56066); 
             after(grammarAccess.getDateFullAccess().getSecondINTTerminalRuleCall_6_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__SecondAssignment_6_5"


    // $ANTLR start "rule__DateFull__MillisecondAssignment_6_7"
    // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2994:1: rule__DateFull__MillisecondAssignment_6_7 : ( RULE_INT ) ;
    public final void rule__DateFull__MillisecondAssignment_6_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2998:1: ( ( RULE_INT ) )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2999:1: ( RULE_INT )
            {
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:2999:1: ( RULE_INT )
            // ../com.verticon.mongo.json.query.ui/src-gen/org/json/ui/contentassist/antlr/internal/InternalMongoQuery.g:3000:1: RULE_INT
            {
             before(grammarAccess.getDateFullAccess().getMillisecondINTTerminalRuleCall_6_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DateFull__MillisecondAssignment_6_76097); 
             after(grammarAccess.getDateFullAccess().getMillisecondINTTerminalRuleCall_6_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DateFull__MillisecondAssignment_6_7"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group__0_in_ruleSelector94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelection_in_entryRuleSelection121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelection128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__0_in_ruleSelection154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_entryRuleFieldSelection181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldSelection188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__0_in_ruleFieldSelection214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_entryRuleQueryObject241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryObject248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__0_in_ruleQueryObject274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__Group__0_in_ruleMember334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_entryRuleArray421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArray428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group__0_in_ruleArray454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_entryRuleKey481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKey488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Key__Alternatives_in_ruleKey514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditional_in_entryRuleConditional541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditional548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conditional__Alternatives_in_ruleConditional574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Boolean__Alternatives_in_ruleBoolean634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNull_in_entryRuleNull661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNull668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleNull695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJsonDate_in_entryRuleJsonDate723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJsonDate730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JsonDate__Alternatives_in_ruleJsonDate756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateNow_in_entryRuleDateNow783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateNow790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateNow__Group__0_in_ruleDateNow816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateMilli_in_entryRuleDateMilli843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateMilli850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__0_in_ruleDateMilli876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateString_in_entryRuleDateString903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateString910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateString__Group__0_in_ruleDateString936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateFull_in_entryRuleDateFull963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateFull970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__0_in_ruleDateFull996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__StringValueAssignment_0_in_rule__Value__Alternatives1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__StringValueAssignment_1_in_rule__Value__Alternatives1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__StringValueAssignment_2_in_rule__Value__Alternatives1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__StringValueAssignment_3_in_rule__Value__Alternatives1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__NumberValueAssignment_4_in_rule__Value__Alternatives1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__DateValueAssignment_5_in_rule__Value__Alternatives1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ArrayValueAssignment_6_in_rule__Value__Alternatives1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__IntegerValueAssignment_7_in_rule__Value__Alternatives1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ObjectValueAssignment_8_in_rule__Value__Alternatives1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditional_in_rule__Key__Alternatives1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Key__Alternatives1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Key__Alternatives1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Conditional__Alternatives1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Conditional__Alternatives1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Conditional__Alternatives1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Conditional__Alternatives1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Conditional__Alternatives1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Conditional__Alternatives1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Conditional__Alternatives1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Conditional__Alternatives1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Conditional__Alternatives1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Conditional__Alternatives1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Conditional__Alternatives1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Conditional__Alternatives1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Conditional__Alternatives1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Conditional__Alternatives1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Conditional__Alternatives1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Conditional__Alternatives1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Conditional__Alternatives1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Boolean__Alternatives1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Boolean__Alternatives1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateNow_in_rule__JsonDate__Alternatives1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateMilli_in_rule__JsonDate__Alternatives1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateString_in_rule__JsonDate__Alternatives1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateFull_in_rule__JsonDate__Alternatives1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group__0__Impl_in_rule__Selector__Group__01766 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Selector__Group__1_in_rule__Selector__Group__01769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__QueryAssignment_0_in_rule__Selector__Group__0__Impl1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group__1__Impl_in_rule__Selector__Group__11826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group_1__0_in_rule__Selector__Group__1__Impl1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group_1__0__Impl_in_rule__Selector__Group_1__01888 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Selector__Group_1__1_in_rule__Selector__Group_1__01891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Selector__Group_1__0__Impl1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__Group_1__1__Impl_in_rule__Selector__Group_1__11950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selector__SelectionAssignment_1_1_in_rule__Selector__Group_1__1__Impl1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__0__Impl_in_rule__Selection__Group__02011 = new BitSet(new long[]{0x0000000500000020L});
    public static final BitSet FOLLOW_rule__Selection__Group__1_in_rule__Selection__Group__02014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Selection__Group__0__Impl2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__1__Impl_in_rule__Selection__Group__12073 = new BitSet(new long[]{0x0000000500000020L});
    public static final BitSet FOLLOW_rule__Selection__Group__2_in_rule__Selection__Group__12076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__2__Impl_in_rule__Selection__Group__22134 = new BitSet(new long[]{0x0000000500000020L});
    public static final BitSet FOLLOW_rule__Selection__Group__3_in_rule__Selection__Group__22137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__FieldsAssignment_2_in_rule__Selection__Group__2__Impl2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__3__Impl_in_rule__Selection__Group__32195 = new BitSet(new long[]{0x0000000500000020L});
    public static final BitSet FOLLOW_rule__Selection__Group__4_in_rule__Selection__Group__32198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group_3__0_in_rule__Selection__Group__3__Impl2225 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__Selection__Group__4__Impl_in_rule__Selection__Group__42256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Selection__Group__4__Impl2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group_3__0__Impl_in_rule__Selection__Group_3__02325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Selection__Group_3__1_in_rule__Selection__Group_3__02328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Selection__Group_3__0__Impl2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__Group_3__1__Impl_in_rule__Selection__Group_3__12387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Selection__FieldsAssignment_3_1_in_rule__Selection__Group_3__1__Impl2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__0__Impl_in_rule__FieldSelection__Group__02448 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__1_in_rule__FieldSelection__Group__02451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__KeyAssignment_0_in_rule__FieldSelection__Group__0__Impl2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__1__Impl_in_rule__FieldSelection__Group__12508 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__2_in_rule__FieldSelection__Group__12511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__FieldSelection__Group__1__Impl2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__Group__2__Impl_in_rule__FieldSelection__Group__22570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FieldSelection__EnabledAssignment_2_in_rule__FieldSelection__Group__2__Impl2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__0__Impl_in_rule__QueryObject__Group__02633 = new BitSet(new long[]{0x000000053FFFE030L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__1_in_rule__QueryObject__Group__02636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__QueryObject__Group__0__Impl2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__1__Impl_in_rule__QueryObject__Group__12695 = new BitSet(new long[]{0x000000053FFFE030L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__2_in_rule__QueryObject__Group__12698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__2__Impl_in_rule__QueryObject__Group__22756 = new BitSet(new long[]{0x000000053FFFE030L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__3_in_rule__QueryObject__Group__22759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__MembersAssignment_2_in_rule__QueryObject__Group__2__Impl2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__3__Impl_in_rule__QueryObject__Group__32817 = new BitSet(new long[]{0x000000053FFFE030L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__4_in_rule__QueryObject__Group__32820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group_3__0_in_rule__QueryObject__Group__3__Impl2847 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group__4__Impl_in_rule__QueryObject__Group__42878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__QueryObject__Group__4__Impl2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group_3__0__Impl_in_rule__QueryObject__Group_3__02947 = new BitSet(new long[]{0x000000003FFFE030L});
    public static final BitSet FOLLOW_rule__QueryObject__Group_3__1_in_rule__QueryObject__Group_3__02950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__QueryObject__Group_3__0__Impl2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__Group_3__1__Impl_in_rule__QueryObject__Group_3__13009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryObject__MembersAssignment_3_1_in_rule__QueryObject__Group_3__1__Impl3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__Group__0__Impl_in_rule__Member__Group__03070 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Member__Group__1_in_rule__Member__Group__03073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__KeyAssignment_0_in_rule__Member__Group__0__Impl3100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__Group__1__Impl_in_rule__Member__Group__13130 = new BitSet(new long[]{0x000000D2C00010F0L});
    public static final BitSet FOLLOW_rule__Member__Group__2_in_rule__Member__Group__13133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Member__Group__1__Impl3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__Group__2__Impl_in_rule__Member__Group__23192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__ValueAssignment_2_in_rule__Member__Group__2__Impl3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group__0__Impl_in_rule__Array__Group__03255 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Array__Group__1_in_rule__Array__Group__03258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group__1__Impl_in_rule__Array__Group__13316 = new BitSet(new long[]{0x000000F3C00010F0L});
    public static final BitSet FOLLOW_rule__Array__Group__2_in_rule__Array__Group__13319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Array__Group__1__Impl3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group__2__Impl_in_rule__Array__Group__23378 = new BitSet(new long[]{0x000000F3C00010F0L});
    public static final BitSet FOLLOW_rule__Array__Group__3_in_rule__Array__Group__23381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__ValuesAssignment_2_in_rule__Array__Group__2__Impl3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group__3__Impl_in_rule__Array__Group__33439 = new BitSet(new long[]{0x000000F3C00010F0L});
    public static final BitSet FOLLOW_rule__Array__Group__4_in_rule__Array__Group__33442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group_3__0_in_rule__Array__Group__3__Impl3469 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__Array__Group__4__Impl_in_rule__Array__Group__43500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Array__Group__4__Impl3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group_3__0__Impl_in_rule__Array__Group_3__03569 = new BitSet(new long[]{0x000000D2C00010F0L});
    public static final BitSet FOLLOW_rule__Array__Group_3__1_in_rule__Array__Group_3__03572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Array__Group_3__0__Impl3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__Group_3__1__Impl_in_rule__Array__Group_3__13631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Array__ValuesAssignment_3_1_in_rule__Array__Group_3__1__Impl3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateNow__Group__0__Impl_in_rule__DateNow__Group__03692 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__DateNow__Group__1_in_rule__DateNow__Group__03695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateNow__Group__1__Impl_in_rule__DateNow__Group__13753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DateNow__Group__1__Impl3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__0__Impl_in_rule__DateMilli__Group__03816 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__1_in_rule__DateMilli__Group__03819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DateMilli__Group__0__Impl3847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__1__Impl_in_rule__DateMilli__Group__13878 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__2_in_rule__DateMilli__Group__13881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateMilli__MillisecondsAssignment_1_in_rule__DateMilli__Group__1__Impl3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateMilli__Group__2__Impl_in_rule__DateMilli__Group__23938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__DateMilli__Group__2__Impl3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateString__Group__0__Impl_in_rule__DateString__Group__04003 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DateString__Group__1_in_rule__DateString__Group__04006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DateString__Group__0__Impl4034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateString__Group__1__Impl_in_rule__DateString__Group__14065 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__DateString__Group__2_in_rule__DateString__Group__14068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateString__DateStringAssignment_1_in_rule__DateString__Group__1__Impl4095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateString__Group__2__Impl_in_rule__DateString__Group__24125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__DateString__Group__2__Impl4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__0__Impl_in_rule__DateFull__Group__04190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group__1_in_rule__DateFull__Group__04193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DateFull__Group__0__Impl4221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__1__Impl_in_rule__DateFull__Group__14252 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group__2_in_rule__DateFull__Group__14255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__YearAssignment_1_in_rule__DateFull__Group__1__Impl4282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__2__Impl_in_rule__DateFull__Group__24312 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group__3_in_rule__DateFull__Group__24315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group__2__Impl4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__3__Impl_in_rule__DateFull__Group__34374 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group__4_in_rule__DateFull__Group__34377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__MonthAssignment_3_in_rule__DateFull__Group__3__Impl4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__4__Impl_in_rule__DateFull__Group__44434 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group__5_in_rule__DateFull__Group__44437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group__4__Impl4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__5__Impl_in_rule__DateFull__Group__54496 = new BitSet(new long[]{0x0000010100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group__6_in_rule__DateFull__Group__54499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__DayAssignment_5_in_rule__DateFull__Group__5__Impl4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__6__Impl_in_rule__DateFull__Group__64556 = new BitSet(new long[]{0x0000010100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group__7_in_rule__DateFull__Group__64559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__0_in_rule__DateFull__Group__6__Impl4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group__7__Impl_in_rule__DateFull__Group__74617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__DateFull__Group__7__Impl4645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__0__Impl_in_rule__DateFull__Group_6__04692 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__1_in_rule__DateFull__Group_6__04695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group_6__0__Impl4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__1__Impl_in_rule__DateFull__Group_6__14754 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__2_in_rule__DateFull__Group_6__14757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__HourAssignment_6_1_in_rule__DateFull__Group_6__1__Impl4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__2__Impl_in_rule__DateFull__Group_6__24814 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__3_in_rule__DateFull__Group_6__24817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group_6__2__Impl4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__3__Impl_in_rule__DateFull__Group_6__34876 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__4_in_rule__DateFull__Group_6__34879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__MinuteAssignment_6_3_in_rule__DateFull__Group_6__3__Impl4906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__4__Impl_in_rule__DateFull__Group_6__44936 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__5_in_rule__DateFull__Group_6__44939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group_6__4__Impl4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__5__Impl_in_rule__DateFull__Group_6__54998 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__6_in_rule__DateFull__Group_6__55001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__SecondAssignment_6_5_in_rule__DateFull__Group_6__5__Impl5028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__6__Impl_in_rule__DateFull__Group_6__65058 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__7_in_rule__DateFull__Group_6__65061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DateFull__Group_6__6__Impl5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__Group_6__7__Impl_in_rule__DateFull__Group_6__75120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateFull__MillisecondAssignment_6_7_in_rule__DateFull__Group_6__7__Impl5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_rule__Selector__QueryAssignment_05198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelection_in_rule__Selector__SelectionAssignment_1_15229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_rule__Selection__FieldsAssignment_25260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldSelection_in_rule__Selection__FieldsAssignment_3_15291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__FieldSelection__KeyAssignment_05322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FieldSelection__EnabledAssignment_25353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_rule__QueryObject__MembersAssignment_25384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_rule__QueryObject__MembersAssignment_3_15415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_rule__Member__KeyAssignment_05446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Member__ValueAssignment_25477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNull_in_rule__Value__StringValueAssignment_05508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_rule__Value__StringValueAssignment_15539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Value__StringValueAssignment_25570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Value__StringValueAssignment_35601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__Value__NumberValueAssignment_45632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJsonDate_in_rule__Value__DateValueAssignment_55663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_rule__Value__ArrayValueAssignment_65694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Value__IntegerValueAssignment_75725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryObject_in_rule__Value__ObjectValueAssignment_85756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Array__ValuesAssignment_25787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Array__ValuesAssignment_3_15818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateMilli__MillisecondsAssignment_15849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DateString__DateStringAssignment_15880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__YearAssignment_15911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__MonthAssignment_35942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__DayAssignment_55973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__HourAssignment_6_16004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__MinuteAssignment_6_36035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__SecondAssignment_6_56066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DateFull__MillisecondAssignment_6_76097 = new BitSet(new long[]{0x0000000000000002L});

}