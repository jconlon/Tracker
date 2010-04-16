package com.verticon.tracker.ocl.query.viewer.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQueryViewModel;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewPart;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

/**
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class DefaultPremisesQueriesHandler extends AbstractHandler {

	/**
	 * Subclasses can override this to load different queries
	 */
	private final Collection<IOclQuery> queries;
	
	
	public DefaultPremisesQueriesHandler() {
		this(DefaultPremisesQuery.getQueries());
	}

	protected DefaultPremisesQueriesHandler(Collection<IOclQuery> queries) {
		this.queries= queries;
	}
	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		
		IWorkbenchPage page = window.getActivePage();
			 if (page != null) {
				 OclQueryViewPart queryViewPart = (OclQueryViewPart)
			 page.findView("com.verticon.tracker.ocl.query.view");
			     if (queryViewPart != null) {
			    	 addQueries(window, queryViewPart, true);
			     }else{
			    	 MessageDialog.openError(
								window.getShell(),
								"Add Sample Queries",
								"Could not find a Queries View to add sample queries. Please open one and add the default queries.");
			     }
			 }
		return null;
	}
	
	



	private void addQueries(IWorkbenchWindow window, OclQueryViewPart queryViewPart, boolean withMessage){
			OclQueryViewer queryViewer = queryViewPart.getViewer();
			OclQueryViewModel model = queryViewer.getViewModel();
			int addedQueries = model.add(queries);
			if(withMessage){
			  StringBuilder sb = new StringBuilder("Added  ");
			  sb.append(addedQueries);
			  sb.append(" sample queries to the Queries View.");
			  if(addedQueries!=queries.size()){
				sb.append(" Defered adding ");
				sb.append(queries.size()-addedQueries );
				sb.append(" duplicate queries.");
			  }
			  MessageDialog.openInformation(
					window.getShell(),
					"Add Queries",
					sb.toString());
			}

	}
	
	
}
