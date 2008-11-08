package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
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
public class ImportFairDataWizard extends Wizard  {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ImportFairDataWizard.class);
	private static final String IMPORT_PEOPLE = "ImportPeople";
	
	/**
	 * Reference to the list of {@link EStructuralFeature}s that
	 * will be shown offered as features for mapping to spreadsheet
	 * columns.
	 */
	public static final List<EStructuralFeature> featuresList ;
	
	/**
	 * Reference to the Set of YouthClub Names that were added by this import task.
	 * @deprecated
	 */
	@Deprecated
	private final Set<String> addedYouthClubs = new HashSet<String>();
	
	/**
	 * Reference to the Set of Person names that were added by this import task.
	 * @deprecated
	 */
	@Deprecated
	private final Set<String> addedPersons = new HashSet<String>();
	
	/**
	 * Reference to a count of the number of Exhibits added in this import task.
	 * @deprecated
	 */
	@Deprecated
	private int addedExhibits = 0;
	
	/**
	 * Active workbench
	 */
	private IWorkbench workbench;
	
	/**
	 * Reference to the workSheet that is the source of the import data.
	 */
	private HSSFSheet workSheet;
	
	/**
	 * Reference to the Fair which will be the target for import data.
	 */
	private Fair fair = null;
	
	
	/**
	 * 
	 */
	private ImportFairDataColumnMappingWizardPage importFairDataColumnMappingPage;
	
	private BaseConfigureExhibitWizardPage exhibitPage;
	
	private int processedRows = 0;
	
	private ExecutableProcreator procreator = null;
	
    static{
    	List<EStructuralFeature> list = new ArrayList<EStructuralFeature>(); 
		initializeTheFeaturesToMap(list);
		featuresList = Collections.unmodifiableList(list);
	}

	/**
	 * Called by the {@link ImportFairDataWizardDelegate} to initialize the wizard.
	 * @param workbench
	 * @param selection
	 * @param fair
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection, Fair fair) {
		this.workbench=workbench;
		File file = getSelectedResource( selection);
		workSheet = getWorkSheet(file);
		this.fair =fair;
		setNeedsProgressMonitor(true);
	}

	/**
	 * Add the default sequence of pages
	 */
	@Override
	public void addPages() {
		setWindowTitle(IMPORT_PEOPLE);
		importFairDataColumnMappingPage = new ImportFairDataColumnMappingWizardPage();
		addPage(importFairDataColumnMappingPage);
		exhibitPage = new BaseConfigureExhibitWizardPage("selectLot", fair);
		exhibitPage.setDescription("Select the Lot to use for creating all new Exhibits");
		exhibitPage.setTitle("Select a Lot");
		addPage(exhibitPage);
		
	}
	
	@Override
	public boolean canFinish() {
		return importFairDataColumnMappingPage.mapContainsCompleteDeptClassLot() || 
		(exhibitPage!=null && exhibitPage.getSelectedLot()!=null);
	}
	
	@Override
	public boolean performFinish() {

		if(importFairDataColumnMappingPage.mapContainsCompleteDeptClassLot()){
			procreator = ExecutableProcreators.newDivisionProcreator();
		}else{
			procreator = ExecutableProcreators.newExhibitProcreator();
		}
		
		IRunnableWithProgress op = new
			WorkspaceModifyDelegatingOperation(getRunnable());

		try {
			getContainer().run(false, true, op);
			String procreatorStatus = "";
			if(procreator !=null){
				procreatorStatus= procreator.getStatus();
				procreator.dispose();
			}

			String message = "Imported " +
			procreatorStatus+
			"from "+processedRows+" spreadsheet rows.";

			MessageDialog.openInformation(workbench.getDisplay().getActiveShell(),
					"Fair Data Import", message);
			return true;
		} catch (InvocationTargetException e) {
			exhibitPage.setErrorMessage("Fair Data Import Error. "+e.getMessage());
		} catch (InterruptedException e) {
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		}
		return false;
	}
	

    @Override
	public IWizardPage getNextPage(IWizardPage page) {
    	if(page==importFairDataColumnMappingPage && importFairDataColumnMappingPage.mapContainsCompleteDeptClassLot()){
    		return null;
    	}
		return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		// TODO Auto-generated method stub
		return super.getPreviousPage(page);
	}

	HSSFSheet getWorkSheet() {
		return workSheet;
	}

	List<EStructuralFeature> getFeaturesToMap() {
		return featuresList;
	}
	
	private IRunnableWithProgress getRunnable(){
		return new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				monitor.beginTask("Processing worksheet...", workSheet.getLastRowNum()+10);
				IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				EditingDomain editingDomain = getEditingDomain(editorPart);
				
				processedRows = processWorksheet(workSheet, fair, 
						importFairDataColumnMappingPage.getHeaderRow()+1, monitor, editingDomain);
				fair.eResource().setModified(true);
				
			}};
	}
	
	
	private static void initializeTheFeaturesToMap(List<EStructuralFeature> list) {
		list.add(FairPackage.Literals.FAIR__NAME);
		list.add(FairPackage.Literals.PERSON__NAME);
		for (EStructuralFeature feature : FairPackage.Literals.PERSON.getEAllStructuralFeatures()) {
			if(!feature.isDerived()){
				list.add(feature);
			}
		}
		list.add(FairPackage.Literals.YOUNG_PERSON__PARENTS);
		list.add(FairPackage.Literals.YOUNG_PERSON__CLUB);
		
		
		list.add(FairPackage.Literals.DIVISION__NAME);
		list.add(FairPackage.Literals.DIVISION__COMMENTS);
		
		list.add(FairPackage.Literals.DEPARTMENT__NAME);
		list.add(FairPackage.Literals.DEPARTMENT__COMMENTS);
		
		list.add(FairPackage.Literals.CLASS__NAME);
		list.add(FairPackage.Literals.CLASS__COMMENTS);
		
		list.add(FairPackage.Literals.LOT__NAME);
		list.add(FairPackage.Literals.LOT__COMMENTS);
		
		for (EStructuralFeature feature : FairPackage.Literals.EXHIBIT.getEAllStructuralFeatures()) {
			if(!feature.isDerived()){
				list.add(feature);
			}
		}
		
		list.add(TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING);
		list.add(TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING);
		list.add(TrackerPackage.Literals.OVINE__SCRAPIE_TAG);
		
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
	            "Fair Data Import Error", "Please insure the data file contains valid column names and row values.", status);
	        
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
	
	/**
	 * Process the Worksheet and import data into the Fair.
	 * @param sheet
	 * @param fair
	 * @param firstDataRow
	 * @param monitor
	 * @param editingDomain
	 * @return
	 * @throws MissingCriticalDataException 
	 */
	private int processWorksheet(HSSFSheet sheet, Fair fair, int firstDataRow, IProgressMonitor monitor,
			EditingDomain editingDomain) {

		int count = 0;
		
		EObject root = null;
		if(importFairDataColumnMappingPage.mapContainsCompleteDeptClassLot()){
			root = fair;
			logger.debug("Importing {} rows of worksheet data specifying Division, Department, Class and Lot.", sheet.getLastRowNum());
		}else{
	    	root = exhibitPage.getSelectedLot();
			logger.debug("Importing {} rows of worksheet data to a selected Lot.", sheet.getLastRowNum());
	    }
		for (int i = firstDataRow; i < sheet.getLastRowNum()+1; i++) {
			logger.debug("processing row {}",i);
			
			try {
				monitor.worked(1);
				procreator.prepare(fair, sheet.getRow(i), 
						importFairDataColumnMappingPage.getSpreadSheetColumnsToFeatureMap(),
						root, false, editingDomain);

			    count++;
			    
			} catch (RuntimeException e) {
				logger.error("Failed to process row "+i,e);
			} catch (MissingCriticalDataException e) {
				logger.error("Failed to process row "+i,e);
				break;
			}
		}
			//Add all newly imported Divisions, Departments, Classes, and Lots
			logger.debug("Loading worksheet data.");
			procreator.execute();
			monitor.worked(10);
		return count;
	}
	
	/**
	 * @param row
	 * @return
	 * @deprecated
	 */
	@Deprecated
	private void processRow(CompoundCommand compoundCommand,HSSFRow row,Fair fair,
			EditingDomain editingDomain) {
		Person person = null;
		String parents = null;
		short parentsCellNum = findColumnNumber(FairPackage.Literals.YOUNG_PERSON__PARENTS,importFairDataColumnMappingPage.getSpreadSheetColumnsToFeatureMap());
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
				if(parents.toLowerCase().equals("unknown") || parents.trim().length()< 1){
					//do nothing parents was a placeholder
				}else{
					findParentsAtFair(compoundCommand, row, (YoungPerson)person, parents, fair, editingDomain);
				}
			}
		}else{
			logger.debug("Row={} found an existing person {}",row.getRowNum(), person.getName());
		}
		processExhibit(compoundCommand, row,  person,  fair, editingDomain);
		setSupplementalAnimalTags(compoundCommand, row,  person,  fair, editingDomain);
		
	}

	/**
	 * @param compoundCommand
	 * @param row
	 * @param fair
	 * @param editingDomain
	 * @param person
	 * @deprecated
	 */
	@Deprecated
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
	 * @deprecated
	 */
	@Deprecated
	private YoungPerson createYoungPerson(HSSFRow row) {
		YoungPerson person = FairFactory.eINSTANCE.createYoungPerson();
		populatePersonAttributes(person, row);
		return person;
	}
	
	/**
	 * @deprecated
	 * @param row
	 * @param fair
	 * @return
	 */
	@Deprecated
	private Person findPerson(HSSFRow row,Fair fair){
		Person person = FairFactory.eINSTANCE.createYoungPerson();
		populatePersonAttributes(person, row);
		return findPersonWithName(row, person.getName(), fair);
	}

	/**
	 *  
	 * @param fair
	 * @return person based on row attributes
	 * @deprecated
	 */
	@Deprecated
	private Person createPerson(HSSFRow row,Fair fair) {
		Person person = FairFactory.eINSTANCE.createPerson();
		populatePersonAttributes(person, row);
		return person;
	}
	
	/**
	 * @deprecated
	 * Create an exibit if there is an animal mapped in the row.
	 * @param compoundCommand
	 * @param row
	 * @param person
	 * @param fair
	 * @param editingDomain
	 * @deprecated
	 */
	@Deprecated
	private void processExhibit(CompoundCommand compoundCommand, HSSFRow row, Person person, 
			Fair fair, EditingDomain editingDomain){
		//Need to have an animal map to create an Exhibit
		Assert.isNotNull(fair, "Fair cannot be null");
		String id = getColumnValue( row, FairPackage.Literals.EXHIBIT__ANIMAL);

		Animal animal = null;
		if(id==null){
//			logger.debug("Row={} could not find an animal mapper in the row.",
//					row.getRowNum());
//			
		}else{
			 animal = fair.getPremises().findAnimal(id);
		}
		
		Exhibit exhibit = FairFactory.eINSTANCE.createExhibit();
		exhibit.setComments(getColumnValue( row, FairPackage.Literals.EXHIBIT__COMMENTS));
//		exhibit.setName(getColumnValue( row, FairPackage.Literals.EXHIBIT__NAME));
//		if(exhibit.getName()==null || exhibit.getName().length()==0){
//			if(importFairDataColumnMappingPage.isUsePersonNameForExhibitName()){
//				exhibit.setName(person.getName());
//			}
//		}
//		String numAsString = getColumnValue( row, FairPackage.Literals.EXHIBIT__NUMBER);
//		if(numAsString!=null ){
//			try {
//				int exhibitNumber = Integer.parseInt(numAsString);
//				exhibit.setNumber(exhibitNumber);
//			} catch (NumberFormatException e) {
//				logger.error("Row="+row.getRowNum()+" could not parse "+numAsString+" to create an exhibit number.",e);
//			}
//		}
//		
//		if(exhibit.getNumber()==0 && importFairDataColumnMappingPage.isUseEarTagForExhibitNum()){
//			try {
//				Long earTagLong = Long.parseLong(animal.getId());
//				int earTag =0;
//				if(earTagLong>Integer.MAX_VALUE){
//					//Cut out the high order numbers from the animal.id
//					earTag = Integer.parseInt(animal.getId().substring(10));
//				}else{
//					earTag= earTagLong.intValue();
//				}
//				exhibit.setNumber(earTag);
//			} catch (NumberFormatException e) {
//			}
//		}
		
		
		processExhibitAncestors(compoundCommand, row, editingDomain, id,
				exhibit);
		
		createCommandToSetPersonOnExhibit(compoundCommand, person,
				editingDomain, exhibit);
		
		if(animal!=null){
			createCommandToSetAnimalOnExhibit(compoundCommand, editingDomain,
					animal, exhibit);
		}
		
	}

	/**
	 * @deprecated
	 * @param compoundCommand
	 * @param editingDomain
	 * @param animal
	 * @param exhibit
	 */
	@Deprecated
	private void createCommandToSetAnimalOnExhibit(
			CompoundCommand compoundCommand, EditingDomain editingDomain,
			Animal animal, Exhibit exhibit) {
		Command command;
		command = SetCommand.create(
				editingDomain, //domain
				exhibit,//owner
				FairPackage.Literals.EXHIBIT__ANIMAL,//feature
				animal//value
				);
		compoundCommand.append(command);
	}

	/**
	 * @deprecated
	 * @param compoundCommand
	 * @param person
	 * @param editingDomain
	 * @param exhibit
	 */
	@Deprecated
	private void createCommandToSetPersonOnExhibit(
			CompoundCommand compoundCommand, Person person,
			EditingDomain editingDomain, Exhibit exhibit) {
		Command command;
		command = SetCommand.create(
				editingDomain, //domain
				exhibit,//owner
				FairPackage.Literals.EXHIBIT__EXHIBITOR,//feature
				person//value
				);
		compoundCommand.append(command);
	}

	/**
	 * @deprecated
	 * @param compoundCommand
	 * @param row
	 * @param editingDomain
	 * @param id
	 * @param exhibit
	 */
	@Deprecated
	private void processExhibitAncestors(
			CompoundCommand compoundCommand, HSSFRow row,
			EditingDomain editingDomain, String id, Exhibit exhibit) {
		Command command = null;
		Lot lot = null;
		if(importFairDataColumnMappingPage.mapContainsCompleteDeptClassLot()){
			//Use a family of Procreators to create the hierarchy for the Exhibit
			//The lot returned will already exist in the fair, or may be created 
			//prior to the addition of the Exhibits.
			
			try {
				procreator.process( fair, row, 
						importFairDataColumnMappingPage.getSpreadSheetColumnsToFeatureMap(), 
						fair, false, editingDomain, new CompoundCommand());
			} catch (MissingCriticalDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//A Lot in the fair was selected buy the user.
			lot = exhibitPage.getSelectedLot();

			command = AddCommand.create(
					editingDomain, //domain
					lot,//owner
					FairPackage.Literals.LOT__EXHIBITS,//feature
					exhibit//value
			);
			compoundCommand.append(command);


			logger.info("Row={} creating exhibit in lot {}.",
					row.getRowNum(),lot.getName());
		}
		addedExhibits++;
	}

	
	/**
	 * @deprecated
	 * The FirstName and LastName cannot have spaces.  Replace these with a 
	 * dash.
	 * @param row
	 * @param person
	 */
	@Deprecated
	private void populatePersonAttributes(Person person, HSSFRow row) {
		for (EStructuralFeature feature : FairPackage.Literals.PERSON.getEAllStructuralFeatures()) {
			short cellNum = findColumnNumber(feature,importFairDataColumnMappingPage.getSpreadSheetColumnsToFeatureMap());
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
					value = value.replace(' ', '-');
//					value = value.replace("//", "/");
//					value = value.replace("//", "/");
					value = value.replace("&", "and");
				}
//				logger.debug("Row={} adding attribute={}, value={}", 
//						new Object[] {row.getRowNum(), feature.getName(),value});
				if(feature==FairPackage.Literals.PERSON__NAME ){
						person.setLastName(NormalizeName.parseLastName(value));
						person.setFirstName(NormalizeName.parseFirstName(value));
						logger.debug("Set person personName {}", person.getName());	
				}else if(feature==FairPackage.Literals.PERSON__SALES_ORDER){
					try {
						person.setSalesOrder(Integer.parseInt(value));
					} catch (NumberFormatException e) {
						logger.error("Could not set Person:salesOrder to "+value,e);
					}
				}else if(feature==FairPackage.Literals.PERSON__FIRST_NAME){
					person.setFirstName(NormalizeName.capitalizeAndTrimEnglishNames(value.toLowerCase()));
				}else if(feature==FairPackage.Literals.PERSON__LAST_NAME){
					person.setLastName(NormalizeName.capitalizeAndTrimEnglishNames(value.toLowerCase()));
				}else if(feature==FairPackage.Literals.PERSON__EXHIBITOR_NUMBER){
					try {
						person.setExhibitorNumber(Integer.parseInt(value));
					} catch (NumberFormatException e) {
						logger.error("Could not set Person:exhibitorNumber to "+value,e);
					}
				}else{
					person.eSet(feature, value);
				}
			}else{
				logger.debug("Row={} had no value for attribute={}",
						row.getRowNum(), feature.getName());
			}
		}
	}
	
	/**
	 * @deprecated
	 * @param compoundCommand
	 * @param kid
	 * @param row
	 * @param fair
	 * @param editingDomain
	 */
	@Deprecated
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
	
	/**
	 * @deprecated
	 * @param nameOfYouthClub
	 * @param fair
	 * @return
	 */
	@Deprecated
	private YouthClub findYouthClub(String nameOfYouthClub, Fair fair){
		
		for (YouthClub club : fair.getYouthClubs()) {
//			if(club.getName()==null ){
//				logger.error("There needs to be a personName on all youth clubs setting it to Error");
//				club.setName("Error");
//			} else 
			if(club.getName().equals(nameOfYouthClub)){
				return club;
			}
		}
		return null;
		
	}
	
	/**
	 * @deprecated
	 * @param row
	 * @param feature
	 * @return
	 */
	@Deprecated
	private String getColumnValue(HSSFRow row, EStructuralFeature feature){
		return getColumnValue( row,  feature, importFairDataColumnMappingPage.getSpreadSheetColumnsToFeatureMap());
	}
	
	/**
	 * @deprecated
	 * @param row
	 * @param feature
	 * @param listColumnMapper
	 * @return
	 */
	@Deprecated
	private static String getColumnValue(HSSFRow row, EStructuralFeature feature, List<ColumnMapper> listColumnMapper){
		String result = null;
		    short index = findColumnNumber(feature, listColumnMapper);
		    if (index !=-1) {
//				logger.debug("Row={} ColumnName {} maps to index {}", 
//						new Object[]{row.getRowNum(),feature.getName(),
//						index});
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
	
	 /**
	  * @deprecated
	  * @param compoundCommand
	  * @param row
	  * @param kid
	  * @param parents
	  * @param fair
	  * @param editingDomain
	  */
	@Deprecated
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
			   logger.info("Row={} found a parent for {} with the personName {}",
					   new Object[]{row.getRowNum(),kid.getName(), parentName});
		   }else{
			   logger.info("Row={} creating a parent for {} with the personName {}",
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
	
	/**
	 * @deprecated
	 * @param row
	 * @param parentName
	 * @param fair
	 * @param kid
	 * @return
	 */
	@Deprecated
	private Person findParent(HSSFRow row, String parentName, Fair fair, YoungPerson kid){
		Person parent = null;
		//try last personName
		parent = findPersonWithName(row, kid.getLastName()+','+parentName,  fair);
		
		if(parent==null){
			//try parentName by itself
			parent = findPersonWithName(row, parentName,  fair);
		}
		return parent;
	}
	
	/**
	 * @deprecated
	 * @param row
	 * @param personName
	 * @param fair
	 * @return
	 */
	@Deprecated
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
	/**
	 * @deprecated
	 * @param feature
	 * @param columnMap
	 * @return
	 */
    @Deprecated
	private static short findColumnNumber(EStructuralFeature feature, List<ColumnMapper> columnMap){
		for (ColumnMapper columnMapper : columnMap) {
			if(columnMapper.getFeature()==feature){
				return columnMapper.getIndex();
			}
		}
		return -1;
	}
	
	/**
	 * @deprecated
	 * Create an exibit if there is an animal mapped in the row.
	 * @param compoundCommand
	 * @param row
	 * @param person
	 * @param fair
	 * @param editingDomain
	 */
	@Deprecated
	private void setSupplementalAnimalTags(CompoundCommand compoundCommand, HSSFRow row, Person person, Fair fair, EditingDomain editingDomain){
		//Need to have an animal map to create an Exhibit
		String id = getColumnValue( row, FairPackage.Literals.EXHIBIT__ANIMAL);

		if(id==null){
//			logger.warn("Row={} could not find animal mapper in row to set animal supplemental tags.",
//					row.getRowNum(),id);
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
