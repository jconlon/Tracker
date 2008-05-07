package com.verticon.tracker.fair.editor.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;
import com.verticon.tracker.fair.YouthClub;

/**
 * 
 * @author jconlon
 *
 */
public class AddPeopleActionDelegate implements IObjectActionDelegate {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AddPeopleActionDelegate.class);

	private final Map<EStructuralFeature, Short> featureMap = 
		new HashMap<EStructuralFeature, Short>();
	
	private final Map<String, Short> extraColMap = 
		new HashMap<String, Short>();

	private IWorkbenchPart targetPart;
	private IStructuredSelection selection;
	
	
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
		
		logger.info("Fair name is {}",fair.getName());

		File data = getSelectedResource( selection);
		
		processWorkbook(data, fair);
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
            int count = processWorksheet( s,  fair);
            MessageDialog.openInformation(
            		targetPart.getSite().getShell(),
                    "People Import",
                    "Added "+count+" People to the "+fair.getName());
		} catch (Exception e) {
			logger.error("Failed to process the spreadsheet",e);
			// Create the required Status object
	        Status status = new Status(IStatus.ERROR, "com.verticon.tracker.fair.editor", 0,
	            "Failed to open the Fair Editor", e);

	        // Display the dialog
	        ErrorDialog.openError(targetPart.getSite().getShell(),
	            "People Inport Error", "Please insure the data file contains valid column names and row values.", status);
	        
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
	
	/**
	 * case FairPackage.PERSON__FIRST_NAME: 
	 * setFirstName((String)newValue);
	 * return; case FairPackage.PERSON__LAST_NAME:
	 * setLastName((String)newValue); return; 
	 * 
	 * case FairPackage.PERSON__PHONE:
	 * setPhone((String)newValue); return; case FairPackage.PERSON__STREET:
	 * setStreet((String)newValue); return; case FairPackage.PERSON__CITY:
	 * setCity((String)newValue); return; case FairPackage.PERSON__STATE:
	 * setState((String)newValue); return; case FairPackage.PERSON__ZIP_CODE:
	 * setZipCode((String)newValue); return; case FairPackage.PERSON__NAME:
	 * setName((String)newValue); return; case FairPackage.PERSON__COMMENTS:
	 * setComments((String)newValue); return; case FairPackage.PERSON__PIN:
	 * 
	 * @return
	 */
	private void buildFeatureToColumnMap(HSSFRow row) {
		logger.info("Matching column names in the first row to the attributes of a Fair Person");
		
		
		
		for (short i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			String s = row.getCell(i).getStringCellValue();
			logger.info("Processing cell number={} to columnName={}", i, s);
			String colName = s.toLowerCase().trim();
			
			if (colName.equals("firstname")|| colName.equals("first name")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_FirstName(),i);
				
			} else if (colName.equals("lastname")|| colName.equals("last name")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_LastName(),i);
				
			} else if (colName.equals("phone")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_Phone(),i);
				
			} else if (colName.equals("street")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_Street(),i);
				
			} else if (colName.equals("city")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_City(),i);
				
			} else if (colName.equals("state")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_State(),i);
				
			} else if (colName.equals("zipcode") || colName.equals("zip code")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_ZipCode(),i);
				
			} else if (colName.equals("pin")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_Pin(),i);
				
			}else if (colName.equals("comments")) {
				featureMap.put(FairPackage.eINSTANCE.getPerson_Comments(),i);
			}else if (colName.equals("parents")){
				logger.warn("Mapping extra column cell number={} to columnName={}", i, 
						colName);
				extraColMap.put(colName, i);
			}else if (colName.equals("youth club")){
				logger.warn("Mapping extra column cell number={} to columnName={}", i, 
						colName);
				extraColMap.put(colName, i);
			}

		}
	}
		
	
	
	private int processWorksheet(HSSFSheet sheet, Fair fair) throws Exception {
		int count = 0;
		
		logger.debug("Worksheet has {} rows", sheet.getLastRowNum());
	    buildFeatureToColumnMap(sheet.getRow(sheet.getFirstRowNum()));
	    if(featureMap.isEmpty()){
	    	throw new Exception("Could not match attribute names to the values in the first column. ");
	    }else{
	    	logger.info("ColumnMap is {}",featureMap);
	    }
		
		for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
			logger.debug("processing row {}",i);
			
			try {
			    createPerson(sheet.getRow(i), fair);
			    count++;
			} catch (RuntimeException e) {
				e.printStackTrace();
				logger.error("Failed to process row {}",i);
			}
		}
		return count;
	}
	
	
	

	/**
	 * @param row
	 * @param person
	 */
	private void populateAttributes(Person person, HSSFRow row) {
		for (Map.Entry<EStructuralFeature, Short> entry : featureMap.entrySet()) {
//			try {
				HSSFCell cell = row.getCell(entry.getValue());
				if(cell==null){
					continue;
				}
				String value = null;
				if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
					 value = cell.getStringCellValue();
				}else if (cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
					double num = cell.getNumericCellValue();
					value = Double.toString(num);
					value = value.substring(0,value.indexOf('.'));
				}
				
				
				if(value!=null){
					logger.debug("Row={}, adding attribute={}, value={}", 
							new Object[] {row.getRowNum(), entry.getKey().getName(),value});
					person.eSet(entry.getKey(), value);
				}else{
					logger.debug("Row={}, had no value for attribute={}",
							row.getRowNum(), entry.getKey().getName());
				}
//			} catch (RuntimeException e) {
//				e.printStackTrace();
//				logger.debug("Row={}, failed to find a value for attribute={}",
//						row.getRowNum(), entry.getKey().getName());
//			}
		}
	}

	/**
	 * @param row
	 * @return
	 */
	private Person createPerson(HSSFRow row,Fair fair) {
		Person person = null;
		
		String parents = null;
		try {
			HSSFCell cellParents = row.getCell(this.extraColMap.get("parents"));
			
			switch (cellParents.getCellType()) {
			case HSSFCell.CELL_TYPE_BLANK:
				
				break;
				
			case HSSFCell.CELL_TYPE_STRING:
				parents = cellParents.getStringCellValue();
				parents.trim();
				logger.debug("Creating parents {} for person in row {}", parents, row.getRowNum());
				break;

			default:
				break;
			}
		} catch (RuntimeException e) {
			
		}
		
		
		
		if(parents == null){
			person = FairFactory.eINSTANCE.createPerson();
			populateAttributes(person, row);
			
			fair.getPeople().add(person);
			logger.debug("Adding {} to the fair. Fair now has {} people.", person.getName(),fair.getPeople().size());
		}else{
			logger.debug("Creating a youngPerson with parents ", parents);
			person = FairFactory.eINSTANCE.createYoungPerson();
			populateAttributes(person, row);
			fair.getPeople().add(person);
			joinYouthClub((YoungPerson)person, row, fair);
			findParentsAtFair((YoungPerson)person, parents, fair);
		}
		
		
		
		return person;
	}
	
	private String getExtrColumnValue(HSSFRow row, String columnName){
		String result = null;
		    short index = extraColMap.get(columnName);
		    logger.debug("ColumnName {} maps to index {}", columnName, index);
			try {
				HSSFCell cellComments = row.getCell(index);
				if(cellComments!=null){
					switch (cellComments.getCellType()) {
					case  HSSFCell.CELL_TYPE_STRING:
						result = cellComments.getStringCellValue();
						break;

					default:
						break;
					}
					
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    return result;
	}
	
	private void joinYouthClub(YoungPerson kid,HSSFRow row,Fair fair){
		
		String nameOfYouthClub = getExtrColumnValue( row, "youth club");
		
		if(nameOfYouthClub==null){
			logger.debug("{} does not indicate he belongs to a youth club ", kid.getName());
			return;
		}
		logger.debug("{} wants to join youth club {}", kid.getName(), nameOfYouthClub);
		YouthClub myClub = findOrCreateYouthClub( nameOfYouthClub,  fair);
		
		kid.setClub(myClub);
		
	}
	
	private YouthClub findOrCreateYouthClub(String nameOfYouthClub, Fair fair){
		
		for (YouthClub club : fair.getYouthClubs()) {
			if(club.getName()==null ){
				logger.error("There needs to be a name on all youth clubs setting it to Error");
				club.setName("Error");
			} else 
			if(club.getName().equals(nameOfYouthClub)){
				return club;
			}
		}
		YouthClub youthClub = FairFactory.eINSTANCE.createYouthClub();
		youthClub.setName(nameOfYouthClub);
		fair.getYouthClubs().add(youthClub);
		return youthClub;
	}
	
	private void findParentsAtFair(YoungPerson kid, String parents, Fair fair){
		logger.debug("{} is looking for his parents {}",kid.getName(), parents);
		StringTokenizer st = new StringTokenizer(parents);
		Person parent = null;
		while (st.hasMoreTokens()) {
		   String parentName = st.nextToken();
		   if(parentName.equals("and")){
			   continue;
		   }
		   parent = findParent(parentName, fair, kid);
		   if(parent!=null){
			   logger.info("{} found parent {}",kid.getName(), parentName);
			   kid.getParents().add(parent);
		   }else{
			   logger.warn("{} can't find parent {}",kid.getName(), parentName);
		   }
		} 
		if(parent==null){
			kid.setComments("Still looking for my parents "+parents+" "+kid.getLastName());
		}
	}
	
	private Person findParent(String parentName, Fair fair, YoungPerson kid){
		Person parent = null;
		//try last name
		parent = findPersonWithName(kid.getLastName()+','+parentName,  fair);
		
		if(parent==null){
			//try parentName by itself
			parent = findPersonWithName(parentName,  fair);
		}
		return parent;
	}
	
	private Person findPersonWithName(String personName, Fair fair){
		Person parent = null;
		logger.debug("Searching through {} people at the fair for a person named {}",
				fair.getPeople().size(), personName);
		for (Person person : fair.getPeople()) {
			String cleanedUpPersonInFairName = person.getName().toLowerCase().trim();
			String cleanedUpParentName = personName.toLowerCase().trim();
			
			if(cleanedUpPersonInFairName.equals(cleanedUpParentName)){
				parent = person;
				break;
			}
//			else{
//				logger.debug("Person in fair <{}> did not match parentName <{}>", cleanedUpPersonInFairName, cleanedUpParentName );
//			}
		}
		if(parent==null){
			logger.warn("Can't find person named {}", personName);
		}
		return parent;
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
