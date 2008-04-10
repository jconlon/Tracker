package com.verticon.tracker.fair.editor.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.Person;


public class AddPeopleActionDelegate implements IObjectActionDelegate {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AddPeopleActionDelegate.class);
	

//	private Map<String, Integer> featureMap = 

	private IWorkbenchPart targetPart;
	private IStructuredSelection selection;
	
	public AddPeopleActionDelegate() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart=targetPart;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = 
			selection instanceof IStructuredSelection
			? (IStructuredSelection)selection
			: null;
	}
	


	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
		
		IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
		
		Fair fair;
		try {
			fair = getFair(editorPart);
		} catch (IOException e) {
			
			// Create the required Status object
	        Status status = new Status(IStatus.ERROR, "com.verticon.tracker.fair.editor", 0,
	            "Failed to open the Fair Editor", e);

	        // Display the dialog
	        ErrorDialog.openError(site.getShell(),
	            "People Inport Error", "Please select a Fair Editor", status);
	        
	        
			return;
		}
		
		// Create the required Status object
        Status status = new Status(IStatus.ERROR, "com.verticon.tracker.fair.editor", 0,
            "Failed to open the Fair Editor", new OperationNotSupportedException("Not yet supported"));
        
		// Display the dialog
        ErrorDialog.openError(site.getShell(),
            "People Inport Error", "Please wait for final release", status);
        return;
		
//		logger.info("Fair name is {}",fair.getName());
//
//		File data = getSelectedResource( selection);
//		
//		processWorkbook(data, fair);
	}
	
	public static final Fair getFair(IAdaptable adaptable) throws IOException  {
		IEditingDomainProvider queryDataSetProvider = (IEditingDomainProvider)adaptable.getAdapter(IEditingDomainProvider.class);
		if(queryDataSetProvider==null){
			return null;
		}
		EditingDomain editingDomain = queryDataSetProvider.getEditingDomain();
		Resource modelResource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = modelResource.getContents().get(0);
		if(rootObject instanceof Fair){
			return (Fair) rootObject;
		}
		throw new IOException(modelResource.getURI().toString()+" is not a Fair Resource.");
	}
	
	private final void processWorkbook(File f, Fair fair){
        FileInputStream fin =null;
        try {
        	// create a new file input stream with the input file specified
            // at the command line
            fin = new FileInputStream(f);
            HSSFWorkbook w = new HSSFWorkbook(fin);
            HSSFSheet s = w.getSheetAt(0);
            processWorksheet( s,  fair);
		} catch (Exception e) {
			logger.error("Failed to process the spreadsheet",e);
		}finally{
			// once all the events are processed close our file input stream
		    if(fin!= null){
		    	try {
					fin.close();
				} catch (IOException e) {
					
				}
		    }
		}
        
	}
	
	private void processWorksheet(HSSFSheet s, Fair fair){
		Person person = null;
		
		for (int i = s.getFirstRowNum(); i < s.getLastRowNum(); i++) {
			person = processRow(s.getRow(i));
			if(person!=null){
				fair.getPeople().add(person);
			}
		}
	}
	
	private Person processRow(HSSFRow row){
		Person person = FairFactory.eINSTANCE.createPerson();
		person.setFirstName(getFirst( row));
		return person;
	}
	
	private String getFirst(HSSFRow row){
		return null;
	}
	
	private static File getSelectedResource(
			ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection).getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}
	


}
