/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.ocl.query.actions.AbstractQueryDelegate;

/**
 * 
 * Default implementation of an IOclQuery
 * 
 * @author jconlon
 *
 */
public class OclQuery extends AbstractQueryDelegate implements IOclQuery {
	private static final String CONTEXT_TYPE_CANNOT_BE_BLANK = "Context type cannot be blank.";
	private static final String QUERY_CANNOT_BE_BLANK = "Query cannot be blank.";
	private static final String OCL_CONDITION_MUST_BE_A_BOOLEAN_EXPRESSION = "OCL condition must be a boolean expression.";
	private static final String SELECT_THE_TRACKER_ELEMENT = "Please select the Tracker element.";
	private static final String ARGUMENT_CONTEXT_IS_NULL = "Argument 'context' is null";
	private static final String SELECT_TRACKER_EDITOR_ACTIVE_EDITOR = "Please select a TrackerEditor as the Active Editor.";
	private static final String UNEXPECTED_EXCEPTION = "An unexpected exception prevented the operation from completing successfully.  See Error Log View for details.";
	private static final String TITLE = "OCL Query";
	private static final String NOT_FOUND = "No matches were found under the selection for the specified OCL condition.";
	
	
	private String name = "";
	private String query = "";
	private String syntaxErrors = "";
	private String type = "";
	

	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;

	public OclQuery(){
		super();
	}
	
	public OclQuery(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getContext()
	 */
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getDescription()
	 */
	public String getErrorSyntax() {
		return syntaxErrors;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#getQuery()
	 */
	public String getQuery() {
		return query;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setContext(java.lang.String)
	 */
	public void setType(String type) {
		this.type=type;

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setDescription(java.lang.String)
	 */
	public void setErrorSyntax(String description) {
		this.syntaxErrors=description;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name=name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.ocl.query.viewer.IOclQuery#setQuery(java.lang.String)
	 */
	public void setQuery(String query) {
		this.query=query;
		validateQuery();
	}
	
	/**
	 * Runs the query.
	 */
	public void run() {
		IEditorPart editor = PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		try {
			this.setActiveEditor(null, editor);
		} catch (RuntimeException e1) {
			MessageDialog.openInformation(getShell(), TITLE,
					SELECT_TRACKER_EDITOR_ACTIVE_EDITOR);
			return;
		}
		
		Collection<EObject> selection = getSelectedObjects();
		
		if (selection == null || selection.isEmpty()) {
			MessageDialog.openInformation(getShell(), TITLE,
					SELECT_THE_TRACKER_ELEMENT);
			return;
		}

		if (condition != null) {
			try {
				IQueryResult result = performQuery(getSelectedObjects(), null,
					new NullProgressMonitor());
				if (result.isEmpty()) {
					MessageDialog.openInformation(getShell(), TITLE, NOT_FOUND);
				} else {
					selectInEditor(result);
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(getShell(), TITLE,
					UNEXPECTED_EXCEPTION);
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Implements the inherited method using an OCL query condition.
	 */
	protected IQueryResult performQuery(Collection<EObject> context, String value,
			IProgressMonitor monitor)
		throws Exception {
		if (null == context) {
			throw new NullPointerException(ARGUMENT_CONTEXT_IS_NULL); //$NON-NLS-1$
		}

		// Build the select query statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(context), new WHERE(condition), monitor);

		// Execute query
		return statement.execute();
	}
	
	/**
	 * Validates the query statement.
	 * 
	 * @return <code>true</code> if I can finish; <code>false</code>, otherwise
	 */
	public boolean validateQuery() {
		boolean result = true;
		
		try {
			
			EClass contextClass = getContextClass();
			if(contextClass==null){
				setErrorSyntax(CONTEXT_TYPE_CANNOT_BE_BLANK);
				return false;
			}
			
			if(query==null || query.length()<1){
				setErrorSyntax(QUERY_CANNOT_BE_BLANK);
				return false;
			}
			
			
            OCL ocl = OCL.newInstance();
            condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
                ocl.getEnvironment(),
                query,
                contextClass);
			
			if (condition.getResultType(null).getInstanceClass() == Boolean.class) {
				setErrorSyntax("");
			} else {
				condition = null;
				result = false;
				setErrorSyntax(OCL_CONDITION_MUST_BE_A_BOOLEAN_EXPRESSION);
			}
		} catch (Exception e) {
			result = false;
			setErrorSyntax(e.getLocalizedMessage());
		}
		
		return result;
	}

	/**
	 * 
	 * @return the EClass for the type
	 */
	private EClass getContextClass(){
		return (EClass)TrackerPackage.eINSTANCE.getEClassifier(type);
		
	}
}
