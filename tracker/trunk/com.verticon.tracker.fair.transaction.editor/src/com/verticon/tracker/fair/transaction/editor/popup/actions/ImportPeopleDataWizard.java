package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Swine;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;
import com.verticon.tracker.fair.YouthClub;


/**
 * 
 * Wizard for importing data into a Fair model. Pages:
 * <ul>
 * <li>Prompt for mapping ss column names to Fair Features</li>
 * <li>Prompt for Lot.</li>
 * </ul>
 * @author jconlon
 *
 */
public class ImportPeopleDataWizard extends Wizard implements IImportWizard {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportPeopleDataWizard.class);
	private static final String IMPORT_PEOPLE = "ImportPeople";
	
	private final List<EStructuralFeature> featuresToMap = 
		new ArrayList<EStructuralFeature>(); 
	
	private final Set<String> addedYouthClubs = new HashSet<String>();
	private final Set<String> addedPersons = new HashSet<String>();
	private int addedExhibits = 0;
	private Fair fair = null;
	
	private IWorkbench workbench;
	private HSSFSheet workSheet;
	
	private BaseConfigureExhibitWizardPage exhibitPage;
	private ImportPeopleDataWizardPage importPeoplePage;
	
	
	private int processedRows = 0;
	
	public ImportPeopleDataWizard() {
		initializeTheFeaturesToMap();
	}

	/**
	 * 
	 */
	private void initializeTheFeaturesToMap() {
		featuresToMap.add(FairPackage.Literals.FAIR__NAME);
		
		for (EStructuralFeature feature : FairPackage.Literals.PERSON.getEAllStructuralFeatures()) {
			if(!feature.isDerived()){
				featuresToMap.add(feature);
			}
		}
		featuresToMap.add(FairPackage.Literals.YOUNG_PERSON__PARENTS);
		featuresToMap.add(FairPackage.Literals.YOUNG_PERSON__CLUB);
		featuresToMap.add(TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING);
		featuresToMap.add(TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING);
		featuresToMap.add(TrackerPackage.Literals.OVINE__SCRAPIE_TAG);
		for (EStructuralFeature feature : FairPackage.Literals.EXHIBIT.getEAllStructuralFeatures()) {
			if(!feature.isDerived()){
				featuresToMap.add(feature);
			}
		}
	}

	@Override
	public boolean canFinish() {
		return exhibitPage!=null && exhibitPage.getSelectedLot()!=null ;
	}
	
	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new
			WorkspaceModifyDelegatingOperation(getRunnable());
		
			try {
				getContainer().run(false, true, op);
				 MessageDialog.openInformation(workbench.getDisplay().getActiveShell(),
				            "Fair Data Import", "Imported "+addedPersons.size()+" people, " +
				            +addedExhibits+" exhibits, " +
				            +addedYouthClubs.size()+" youthClubs, " +
				            		"from "+processedRows+" spreadsheet rows.");
						return true;
			} catch (InvocationTargetException e) {
				exhibitPage.setErrorMessage("Fair Data Import Error. "+e.getMessage());
			} catch (InterruptedException e) {
				// Restore the interrupted status
	             Thread.currentThread().interrupt();
			}
		return false;
	}
	
	private IRunnableWithProgress getRunnable(){
		return new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				monitor.beginTask("Processing worksheet...", workSheet.getLastRowNum());
				IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				EditingDomain editingDomain = getEditingDomain(editorPart);
				
				processedRows = processWorksheet(workSheet, fair, 
						importPeoplePage.getHeaderRow()+1, monitor, editingDomain);
				fair.eResource().setModified(true);
				
			}};
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench=workbench;
		File file = getSelectedResource( selection);
		workSheet = getWorkSheet(file);
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(IMPORT_PEOPLE);
		importPeoplePage = new ImportPeopleDataWizardPage();
		addPage(importPeoplePage);
		try {
			exhibitPage = new BaseConfigureExhibitWizardPage("selectLot", findFair());
			exhibitPage.setDescription("Select the Lot to use for creating all new Exhibits");
			exhibitPage.setTitle("Select a Lot");
			addPage(exhibitPage);
		} catch (IOException e) {
//			// Create the required Status object
//	        Status status = new Status(IStatus.ERROR, "com.verticon.tracker.fair.editor", 0,
//	            "Failed to open the Fair Editor", e);
//
//	        // Display the dialog
//	        ErrorDialog.openError(workbench.getDisplay().getActiveShell(),
//	            "People Import Error", "Please select a Fair Editor", status);
			importPeoplePage.setErrorMessage(
					"Fair Data Import Error. The Active Editor must be a Fair Editor");
		}
		
	}

	private static File getSelectedResource(
			ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection).getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}
	
	private HSSFSheet getWorkSheet(File f){
        FileInputStream fin =null;
        HSSFSheet s = null;
        try {
        	// create a new file input stream with the input file specified
            // at the command line
            fin = new FileInputStream(f);
            HSSFWorkbook w = new HSSFWorkbook(fin);
            s = w.getSheetAt(0);
		} catch (Exception e) {
			logger.error("Failed to process the spreadsheet",e);
			// Create the required Status object
	        Status status = new Status(IStatus.ERROR, "com.verticon.tracker.fair.editor", 0,
	            "Failed to open the Fair Editor", e);
	        // Display the dialog
	        ErrorDialog.openError(workbench.getActiveWorkbenchWindow().getShell(),
	            "People Import Error", "Please insure the data file contains valid column names and row values.", status);
	        
		}finally{
			// once all the events are processed close our file input stream
		    if(fin!= null){
		    	try {
					fin.close();
				} catch (IOException e) {
					
				}
		    }
		}
		return s;
        
	}

	public HSSFSheet getWorkSheet() {
		return workSheet;
	}

	public List<EStructuralFeature> getFeaturesToMap() {
		return featuresToMap;
	}

	public Fair findFair() throws IOException {
		if(fair ==null){
			IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			fair = getFair(editorPart);
		}
		return fair;
	}
	
	public static final Fair getFair(IAdaptable adaptable) throws IOException  {
		EditingDomain editingDomain = getEditingDomain(adaptable);
		
		Resource modelResource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = modelResource.getContents().get(0);
		if(rootObject instanceof Fair){
			return (Fair) rootObject;
		}
		throw new IOException(modelResource.getURI().toString()+" is not a Fair Resource.");
	}

	/**
	 * @param adaptable
	 * @return
	 */
	private static EditingDomain getEditingDomain(IAdaptable adaptable) {
		IEditingDomainProvider queryDataSetProvider = 
			(IEditingDomainProvider)adaptable.getAdapter(IEditingDomainProvider.class);
		if(queryDataSetProvider==null){
			return null;
		}
		EditingDomain editingDomain = queryDataSetProvider.getEditingDomain();
		return editingDomain;
	}
	
	//editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, getCommandOwner(eObject), parentReference, value));
	private int processWorksheet(HSSFSheet sheet, Fair fair, int firstDataRow, IProgressMonitor monitor,
			EditingDomain editingDomain) {
		CompoundCommand compoundCommand = new CompoundCommand();
		
		int count = 0;
		
		logger.debug("Worksheet has {} rows", sheet.getLastRowNum());
	   
		for (int i = firstDataRow; i < sheet.getLastRowNum()+1; i++) {
			monitor.worked(1);
			logger.debug("processing row {}",i);
			
			try {
			    createPerson( compoundCommand, sheet.getRow(i), fair,editingDomain);
			    count++;
			} catch (RuntimeException e) {
				e.printStackTrace();
				logger.error("Failed to process row {}",i);
			}
		}
		editingDomain.getCommandStack().execute(compoundCommand);
		return count;
	}
	
	/**
	 * @param row
	 * @return
	 */
	private void createPerson(CompoundCommand compoundCommand,HSSFRow row,Fair fair,EditingDomain editingDomain) {
		Person person = null;
		String parents = null;
		short parentsCellNum = findColumnNumber(FairPackage.Literals.YOUNG_PERSON__PARENTS);
		if(parentsCellNum != -1){
			try {
				HSSFCell cellParents = row.getCell(parentsCellNum);

				switch (cellParents.getCellType()) {
				case HSSFCell.CELL_TYPE_BLANK:

					break;

				case HSSFCell.CELL_TYPE_STRING:
					parents = cellParents.getStringCellValue();
					parents.trim();
					logger.debug("Row={} parents are {} ", row.getRowNum(), parents);
					break;

				default:
					break;
				}
			} catch (RuntimeException e) {

			}
		}
		person = findPerson( row, fair);
		if(parents == null && person == null){
				person = createPerson(row, fair);
				addPersonCommand(compoundCommand, row, fair, editingDomain,
						person);
		}else if(parents != null && person == null){
			person = createYoungPerson(row);
			boolean addedPerson = addPersonCommand(compoundCommand, row, fair, editingDomain,
					person);
			if(addedPerson){
				joinYouthClub(compoundCommand, (YoungPerson)person, row, fair, editingDomain);
				findParentsAtFair(compoundCommand, row, (YoungPerson)person, parents, fair, editingDomain);
			}
		}else{
			logger.debug("Row={} found an existing person {}",row.getRowNum(), person.getName());
		}
		createExhibit(compoundCommand, row,  person,  fair, editingDomain);
		setSupplementalAnimalTags(compoundCommand, row,  person,  fair, editingDomain);
		
	}

	/**
	 * @param compoundCommand
	 * @param row
	 * @param fair
	 * @param editingDomain
	 * @param person
	 */
	private boolean addPersonCommand(CompoundCommand compoundCommand, HSSFRow row,
			Fair fair, EditingDomain editingDomain, Person person) {
		if(!addedPersons.contains(person.getName())){
			Command command = AddCommand.create(
				editingDomain, //domain
				fair,//owner
				FairPackage.Literals.FAIR__PEOPLE,//feature
				person//value
				);
			compoundCommand.append(command);
			addedPersons.add(person.getName());
			if(person instanceof YoungPerson){
				logger.info("Row={} creating a new youngPerson {}",row.getRowNum(), person.getName());
			}else{
				logger.info("Row={} creating a new person {}",row.getRowNum(), person.getName());
			}
			return true;
		}
		return false;
	}

	/**
	 * Checks for an existing YoungPerson
	 * @param fair
	 * @return
	 */
	private YoungPerson createYoungPerson(HSSFRow row) {
		YoungPerson person = FairFactory.eINSTANCE.createYoungPerson();
		populatePersonAttributes(person, row);
		return person;
	}
	
	private Person findPerson(HSSFRow row,Fair fair){
		Person person = FairFactory.eINSTANCE.createYoungPerson();
		populatePersonAttributes(person, row);
		return findPersonWithName(row, person.getName(), fair);
	}

	/**
	 *  
	 * @param fair
	 * @return person based on row attributes
	 */
	private Person createPerson(HSSFRow row,Fair fair) {
		Person person;
		person = FairFactory.eINSTANCE.createPerson();
		populatePersonAttributes(person, row);
		
		return person;
	}
	
	/**
	 * Create an exibit if there is an animal mapped in the row.
	 * @param compoundCommand
	 * @param row
	 * @param person
	 * @param fair
	 * @param editingDomain
	 */
	private void createExhibit(CompoundCommand compoundCommand, HSSFRow row, Person person, Fair fair, EditingDomain editingDomain){
		//Need to have an animal map to create an Exhibit
		Assert.isNotNull(fair, "Fair cannot be null");
		String id = getColumnValue( row, FairPackage.Literals.EXHIBIT__ANIMAL);

		if(id==null){
			logger.warn("Row={} could not find animal mapper in row to create an exhibit.",
					row.getRowNum());
			return;
		}
		Animal animal = fair.getPremises().findAnimal(id);
		if(animal==null){
			logger.warn("Row={} could not find animal with id {} to create an exhibit.",
					row.getRowNum(),id);
			return;
		}
		Exhibit exhibit = FairFactory.eINSTANCE.createExhibit();
		exhibit.setComments(getColumnValue( row, FairPackage.Literals.EXHIBIT__COMMENTS));
		exhibit.setName(getColumnValue( row, FairPackage.Literals.EXHIBIT__NAME));
		if(exhibit.getName()==null || exhibit.getName().length()==0){
			if(importPeoplePage.isUsePersonNameForExhibitName()){
				exhibit.setName(person.getName());
			}
		}
		String numAsString = getColumnValue( row, FairPackage.Literals.EXHIBIT__NUMBER);
		if(numAsString!=null ){
			try {
				int exhibitNumber = Integer.parseInt(numAsString);
				exhibit.setNumber(exhibitNumber);
			} catch (NumberFormatException e) {
				logger.error("Row="+row.getRowNum()+" could not parse "+numAsString+" to create an exhibit number.",e);
			}
		}
		
		if(exhibit.getNumber()==0 && importPeoplePage.isUseEarTagForExhibitNum()){
			try {
				Long earTagLong = Long.parseLong(animal.getId());
				int earTag =0;
				if(earTagLong>Integer.MAX_VALUE){
					//Cut out the high order numbers from the animal.id
					earTag = Integer.parseInt(animal.getId().substring(10));
				}else{
					earTag= earTagLong.intValue();
				}
				exhibit.setNumber(earTag);
			} catch (NumberFormatException e) {
			}
		}
		
		Lot lot = exhibitPage.getSelectedLot();
		Command command = AddCommand.create(
				editingDomain, //domain
				lot,//owner
				FairPackage.Literals.LOT__EXHIBITS,//feature
				exhibit//value
		);
		compoundCommand.append(command);
		logger.info("Row={} creating exhibit using animal with id {}.",
				row.getRowNum(),id);
		addedExhibits++;
		
		command = SetCommand.create(
				editingDomain, //domain
				exhibit,//owner
				FairPackage.Literals.EXHIBIT__EXHIBITOR,//feature
				person//value
				);
		compoundCommand.append(command);
		
		command = SetCommand.create(
				editingDomain, //domain
				exhibit,//owner
				FairPackage.Literals.EXHIBIT__ANIMAL,//feature
				animal//value
				);
		compoundCommand.append(command);
	}
	
	/**
	 * The FirstName and LastName cannot have spaces.  Replace these with a 
	 * dash.
	 * @param row
	 * @param person
	 */
	private void populatePersonAttributes(Person person, HSSFRow row) {
		for (EStructuralFeature feature : FairPackage.Literals.PERSON.getEAllStructuralFeatures()) {
			short cellNum = findColumnNumber(feature);
			if(cellNum==-1){
				continue;
			}
			HSSFCell cell = row.getCell(cellNum);
			if(cell==null){
				continue;
			}
			String value = null;
			if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
				 value = cell.getStringCellValue();
			}else if (cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
				double num = cell.getNumericCellValue();
				long l = (long)num;
				value = Long.toString(l);
//				value = value.substring(0,value.indexOf('.'));
			}
			
			if(value!=null){
				if(feature==FairPackage.Literals.PERSON__FIRST_NAME || feature==FairPackage.Literals.PERSON__LAST_NAME){
					value = value.trim();
					value = value.replace(' ', '/');
					value = value.replace("//", "/");
					value = value.replace("//", "/");
				}
				logger.debug("Row={} adding attribute={}, value={}", 
						new Object[] {row.getRowNum(), feature.getName(),value});
				person.eSet(feature, value);
			}else{
				logger.debug("Row={} had no value for attribute={}",
						row.getRowNum(), feature.getName());
			}
		}
	}
	
	private void  joinYouthClub(CompoundCommand compoundCommand, YoungPerson kid, HSSFRow row, Fair fair, EditingDomain editingDomain){
		String nameOfYouthClub = getColumnValue( row, FairPackage.Literals.YOUNG_PERSON__CLUB);
		
		if(nameOfYouthClub==null){
			logger.debug("Row={} {} does not indicate he belongs to a youth club ", row.getRowNum(), kid.getName());
			return ;
		}
		logger.debug("Row={} {} wants to join youth club {}",
				new Object[]{row.getRowNum(), kid.getName(), nameOfYouthClub});
		
		YouthClub myClub = findYouthClub( nameOfYouthClub,  fair);
		if(myClub==null){
			YouthClub youthClub = FairFactory.eINSTANCE.createYouthClub();
			youthClub.setName(nameOfYouthClub);
			if(!addedYouthClubs.contains(nameOfYouthClub)){
				Command command = AddCommand.create(
					editingDomain, //domain
					fair,//owner
					FairPackage.Literals.FAIR__YOUTH_CLUBS,//feature
					youthClub//value
					);
				compoundCommand.append(command);
				addedYouthClubs.add(nameOfYouthClub);
				logger.info("Row={} creating a new youthClub {}",row.getRowNum(), youthClub.getName());
			}
		}
		
//		kid.setClub(myClub);
		Command command = SetCommand.create(
				editingDomain, //domain
				kid,//owner
				FairPackage.Literals.YOUNG_PERSON__CLUB,//feature
				myClub//value
				);
		compoundCommand.append(command);
		
		
	}
	
	private YouthClub findYouthClub(String nameOfYouthClub, Fair fair){
		
		for (YouthClub club : fair.getYouthClubs()) {
//			if(club.getName()==null ){
//				logger.error("There needs to be a name on all youth clubs setting it to Error");
//				club.setName("Error");
//			} else 
			if(club.getName().equals(nameOfYouthClub)){
				return club;
			}
		}
		return null;
		
	}
	private String getColumnValue(HSSFRow row, EStructuralFeature feature){
		String result = null;
		    short index = findColumnNumber(feature);
		    if (index !=-1) {
				logger.debug("Row={} ColumnName {} maps to index {}", 
						new Object[]{row.getRowNum(),feature.getName(),
						index});
				try {
					HSSFCell cellContents = row.getCell(index);
					if (cellContents != null) {
						switch (cellContents.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							result = cellContents.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							double num = cellContents.getNumericCellValue();
							long l = (long)num;
							result = Long.toString(l);
//							result = value.substring(0,value.indexOf('.'));
							break;
						default:
							break;
						}

					}
				} catch (RuntimeException e) {
					logger.error("Row={} Failed to create "+row.getRowNum(),feature.getName(),e );
				}
			}
		return result;
	}
	
	private void findParentsAtFair(CompoundCommand compoundCommand, HSSFRow row,YoungPerson kid, 
			String parents, Fair fair, EditingDomain editingDomain){
		logger.debug("Row={} {} is looking for his parents {}",
				new Object[]{row.getRowNum(),kid.getName(), parents});
		StringTokenizer st = new StringTokenizer(parents);
		Person parent = null;
		while (st.hasMoreTokens()) {
		   String parentName = st.nextToken();
		   if(parentName.equals("and")){
			   continue;
		   }
		   parent = findParent(row, parentName, fair, kid);
		   
		   if(parent!=null){
			   logger.info("Row={} found a parent for {} with the name {}",
					   new Object[]{row.getRowNum(),kid.getName(), parentName});
		   }else{
			   logger.info("Row={} creating a parent for {} with the name {}",
					   new Object[]{row.getRowNum(),kid.getName(), parentName});
			   
			   parent = FairFactory.eINSTANCE.createPerson();
			   parent.setFirstName(parentName);
			   parent.setLastName(kid.getLastName());
			   parent.setCity(kid.getCity());
			   parent.setPhone(kid.getPhone());
			   parent.setPin(kid.getPin());
			   parent.setState(kid.getState());
			   parent.setStreet(kid.getStreet());
			   parent.setZipCode(kid.getZipCode());
			   addPersonCommand(compoundCommand, row, fair, editingDomain,
						parent);
		   }
		  
		   Command command = AddCommand.create(
					editingDomain, //domain
					kid,//owner
					FairPackage.Literals.YOUNG_PERSON__PARENTS,//feature
					parent//value
					);
		   compoundCommand.append(command);
		} 
		
		
	}
	
	private Person findParent(HSSFRow row, String parentName, Fair fair, YoungPerson kid){
		Person parent = null;
		//try last name
		parent = findPersonWithName(row, kid.getLastName()+','+parentName,  fair);
		
		if(parent==null){
			//try parentName by itself
			parent = findPersonWithName(row, parentName,  fair);
		}
		return parent;
	}
	
	private Person findPersonWithName(HSSFRow row, String personName, Fair fair){
		Person parent = null;
		logger.debug("Row={} Searching through {} people at the fair for a person named {}",
				new Object[]{row.getRowNum(),fair.getPeople().size(), personName});
		for (Person person : fair.getPeople()) {
			String cleanedUpPersonInFairName = person.getName().toLowerCase().trim();
			String cleanedUpParentName = personName.toLowerCase().trim();
			
			if(cleanedUpPersonInFairName.equals(cleanedUpParentName)){
				parent = person;
				break;
			}
		}
		if(parent==null){
			logger.debug("Row={} Can't find person named {}", row.getRowNum(),personName);
		}
		return parent;
	}
	
	private short findColumnNumber(EStructuralFeature feature){
		for (ColumnMapper columnMapper : importPeoplePage.getSpreadSheetColumnsToFeatureMap()) {
			if(columnMapper.getFeature()==feature){
				return columnMapper.getIndex();
			}
		}
		return -1;
	}
	
	/**
	 * Create an exibit if there is an animal mapped in the row.
	 * @param compoundCommand
	 * @param row
	 * @param person
	 * @param fair
	 * @param editingDomain
	 */
	private void setSupplementalAnimalTags(CompoundCommand compoundCommand, HSSFRow row, Person person, Fair fair, EditingDomain editingDomain){
		//Need to have an animal map to create an Exhibit
		String id = getColumnValue( row, FairPackage.Literals.EXHIBIT__ANIMAL);

		if(id==null){
			logger.warn("Row={} could not find animal mapper in row to set animal supplemental tags.",
					row.getRowNum(),id);
			return;
		}
		Animal animal = fair.getPremises().findAnimal(id);
		if(animal==null){
			logger.warn("Row={} could not find animal with id {} to set animal supplemental tags.",
					row.getRowNum(),id);
			return;
		}
		
		if(animal instanceof Swine){
			String swineLeftEarNotch = getColumnValue( row, TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING);
			String swineRightEarNotch = getColumnValue( row, TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING);
            if(swineLeftEarNotch==null && swineLeftEarNotch==null){
            	logger.warn("Row={} could not find supplemental tag information for animal with id {}.",
            			row.getRowNum(),id);
            	return;
            }
			
			Command command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING,//feature
					Integer.parseInt(swineLeftEarNotch)//value
			);
			compoundCommand.append(command);

			logger.info("Row={} Swine left ear notching for animal id {} is {}",
        			new Object[] {row.getRowNum(),id, Integer.parseInt(swineLeftEarNotch)});
			
			command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING,//feature
					Integer.parseInt(swineRightEarNotch)//value
			);
			compoundCommand.append(command);
			logger.info("Row={} Swine right ear notching for animal id {} is {}",
        			new Object[] {row.getRowNum(),id, Integer.parseInt(swineRightEarNotch)});
		}
		else if(animal instanceof Ovine){
			String scrapieTag = getColumnValue( row, TrackerPackage.Literals.OVINE__SCRAPIE_TAG);
			if(scrapieTag==null){
            	return;
            }
			
			Command command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.OVINE__SCRAPIE_TAG,//feature
					scrapieTag//value
			);
			compoundCommand.append(command);
			logger.info("Row={} Ovine scrapie tag for animal id {} is {}",
        			new Object[] {row.getRowNum(),id, scrapieTag});

		}
	}
}
