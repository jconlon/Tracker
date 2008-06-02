package com.verticon.tracker.ocl.query.viewer.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQuery;
import com.verticon.tracker.ocl.query.viewer.OclQueryViewModel;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewPart;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleQueriesHandler extends AbstractHandler {
	
	
	private static final List<IOclQuery> sampleQueries = new ArrayList<IOclQuery>();
	
	private static final String[] queryNames = new String[] {
		"1. Animals with unidentified Pins",
		"Animal 342", 
		"LostTag Events", //TODO Add LostTag event in example model
		"Animals movedIn without a Pin", //Add an animal with a moved out a pin
		"Excessive Somatic Cell Counts",
		"2. Low Weight Gain Events",
		"3. Slow Weight Gaining Animals",
		"4. Exhibits with People who have Pins",
		"5. People without exhibits",
		
		};
	private static final String[] queries = new String[] {
		"self.eventHistory() -> select(e : Event | (e.oclIsTypeOf(MovedIn) and e.oclAsType(MovedIn).sourcePin.oclIsUndefined()) or (e.oclIsTypeOf(MovedOut) and e.oclAsType(MovedOut).destinationPin.oclIsUndefined())) ->size() > 0",
		"self.id='840456789012342'", 
		"self.eventCode=5",
		"Event.allInstances()->select(e : Event | e.id=self.id and e.oclIsTypeOf(MovedIn) and e.oclAsType(MovedIn).sourcePin.oclIsUndefined() )->size()>0",
		"self.somaticCellCounts>200",
		"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay<3",
		"self.weightGainPerDay.oclIsUndefined() = false and self.weightGainPerDay<3",
		"self.exhibitor.pin.oclIsUndefined() = false",
		"Exhibit.allInstances()->select(e : Exhibit | e.exhibitor=self)-> size()<1"
		};
	private static final String[] types = new String[] {
		"Animal",
		"Animal", 
		"LostTag",
		"Animal",
		"MilkTest",
		"WeighIn",
		"Animal",
		"Exhibit",
		"Person"
		};
	
	
	static{
		OclQuery sampleQuery;
		for (int i = 0; i < queryNames.length; i++) {
			sampleQuery = new OclQuery();
			sampleQuery.setName(queryNames[i]);
			sampleQuery.setType(types[i]);
			sampleQuery.setQuery(queries[i]);
			sampleQueries.add(sampleQuery);
		}
		
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
			    	 addSamples(window, queryViewPart, true);
			     }else{
			    	 MessageDialog.openError(
								window.getShell(),
								"Add Sample Queries",
								"Could not find a Queries View to add sample queries. Please open one.");
			     }
			 }
		return null;
	}
	
	public static void addSamples(IWorkbenchWindow window, OclQueryViewPart queryViewPart, boolean withMessage){
			OclQueryViewer queryViewer = queryViewPart.getViewer();
			OclQueryViewModel model = queryViewer.getViewModel();
			for (IOclQuery query : sampleQueries) {
				model.addQuery(query);
			}
			if(withMessage){
			MessageDialog.openInformation(
					window.getShell(),
					"Add Sample Queries",
					"Added  "+sampleQueries.size()+ " sample queries to the Queries View");
			}
		
		
	}
	
	
}
