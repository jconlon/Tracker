/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.editor.tests;
import static com.verticon.tracker.fair.tests.Constants.bundleMarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.poi.importxls.ColumnMapper;
import com.verticon.tracker.fair.poi.importxls.ExecutableProcreator;
import com.verticon.tracker.fair.poi.importxls.ExecutableProcreators;
import com.verticon.tracker.fair.poi.importxls.MissingCriticalDataException;

public class DivisionProcreatorTest extends TestCase {

	public static final String VERTICON_FAIR_EDITOR_TESTS = "verticon.fair.editor.tests";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DivisionProcreatorTest.class);

	ExecutableProcreator procreator = null;
	AdapterFactoryEditingDomain editingDomain = null;
	Fair fair = null;
	
	Premises premises = null;

	List<ColumnMapper> spreadSheetColumnsToFeatureMap = null;
	File testsDirectory = null;

	@Override
	protected void setUp() throws Exception {
		String testsFilesDir = System.getProperty(VERTICON_FAIR_EDITOR_TESTS);
		assertNotNull("System property is null", testsFilesDir);
	    testsDirectory = new File(testsFilesDir);
		
		spreadSheetColumnsToFeatureMap = new LinkedList<ColumnMapper>();
		procreator = ExecutableProcreators.newDivisionProcreator();
		fair = FairFactory.eINSTANCE.createFair();
		BasicCommandStack commandStack = new BasicCommandStack();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
		editingDomain.getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap().put("xml",
						new XMIResourceFactoryImpl());

//		URI uri = URI.createURI("foo:/file.xml");//need a real file to enable executable AddCommands
		URI uri = URI.createFileURI(new File("myTestModelInstance.xml").getAbsolutePath());
		Resource fairResource = editingDomain.getResourceSet().createResource(
				uri);
		fairResource.getContents().add(fair);
		
	    premises = TrackerFactory.eINSTANCE.createPremises();
		URI trackerUri = URI.createFileURI(new File("myTestTrackerModelInstance.xml").getAbsolutePath());
		Resource trackerResource = editingDomain.getResourceSet().createResource(
				trackerUri);
		trackerResource.getContents().add(premises);

		
	}

	@Override
	protected void tearDown() throws Exception {
		procreator.dispose();
		procreator = null;
		spreadSheetColumnsToFeatureMap.clear();
		spreadSheetColumnsToFeatureMap = null;
		editingDomain=null;
		fair=null;
		testsDirectory=null;
	}

	public void testResource() {
		assertNotNull(editingDomain);
		assertNotNull(editingDomain.getResourceSet());
		assertFalse(editingDomain.getResourceSet().getResources().isEmpty());

		
		assertTrue(testsDirectory+" directory does not exist", testsDirectory.exists());
		assertTrue(testsDirectory+" is not a directory",testsDirectory.isDirectory());

	}
	
	public void testEditingDomainIsFunctional() {
		assertTrue(fair.getDivisions().isEmpty());
		Division division = FairFactory.eINSTANCE.createDivision();
		division.setName("AAA");
		division.setComments("some comments");

		Command command = AddCommand.create(editingDomain, // domain
				fair,// owner
				FairPackage.Literals.FAIR__DIVISIONS,// feature
				division// value
				);
		command.execute();
		
		assertFalse(fair.getDivisions().isEmpty());
		assertEquals(1, fair.getDivisions().size());
		
	}

	public void testRowCount() {

		File file = new File(this.testsDirectory,  
		"importExhibits-Parents.xls");
		HSSFSheet sheet = null;
		try {
			sheet = getWorkSheet(file);

		} catch (Exception e) {
			fail(e.toString());
		}

		assertNotNull(sheet);
		assertEquals(1252, sheet.getLastRowNum());

		
		//There are 113 rows of data but only 10 filled with data.
		//This file is used in the next test.
		file = new File(this.testsDirectory,  
				"beefWeighIn4111208.xls");
		sheet = null;
		try {
			sheet = getWorkSheet(file);

		} catch (Exception e) {
			fail(e.toString());
		}

		assertNotNull(sheet);
		assertEquals(113, sheet.getLastRowNum());
	}
	
	public void testWithBlankLastRowInSpreadsheet() {
		populateColumnMap(3, "First Name", FairPackage.Literals.PERSON__FIRST_NAME);
		populateColumnMap(4, "Last Name", FairPackage.Literals.PERSON__LAST_NAME);
		try {
			importSpreadSheet("beefWeighIn4111208.xls");
			fail("There is a blank row in the spreadsheet, should have thrown a MissingCriticalDataException");
		} catch (MissingCriticalDataException e) {
			//expected
		}
	}
	
	public void testImport_Exhibits_Parents() {
		populateDefaultMap();
		try {
			importSpreadSheet("importExhibits-Parents.xls");
		} catch (MissingCriticalDataException e) {
			logger.error(bundleMarker,"Failed to import data",e);
			fail(e.getMessage());
		}
		
		String status = procreator.getStatus();
	
		Flags flags = new Flags();
		
		assertEquals(1, flags.divs);
		assertTrue("Wrong Divison", status.contains("1 divisions"));
		
		assertEquals(7, flags.depts);
		assertTrue("Wrong Departments "+status, status.contains("7 departments"));
		
		assertEquals(40, flags.clazzes);
		assertTrue("Wrong Classes "+status, status.contains("40 classes"));
		
		assertEquals(260, flags.lots);
		assertTrue("Wrong Lots "+status, status.contains("260 lots"));
		
		assertEquals(1252, flags.exhibits);
		assertTrue("Wrong Exhibts "+status, status.contains("1252 exhibits"));
		
		assertEquals(278, flags.people);
		assertTrue("Wrong People "+status, status.contains("274 people"));
		
		assertEquals(274, flags.youngPeople);
		
		assertEquals(4, flags.oldPeople);
		assertTrue("Wrong Parents "+status, status.contains("4 parents"));
		
		assertEquals(0, flags.youthClubs);
		assertTrue("Wrong Youth Clubs "+status, status.contains("0 Youth Clubs"));
		
		
		assertTrue("Animal References "+status, status.contains("0 Animal References"));

		assertEquals(1252, flags.exhibits);

	}
	
	public void test_Import_Exhibits_Missing_Div_Fields() {
		populateDefaultMap();
		try {
			importSpreadSheet("importExhibits-Missing_DivFields.xls");
			fail("Should have thrown a missingCriticalDataException");
		} catch (MissingCriticalDataException e) {
			logger.info(bundleMarker,e.getMessage());
		}
		
	}
	
	public void test_Import_Exhibits_Missing_Dept_Fields() {
		populateDefaultMap();
		try {
			importSpreadSheet("importExhibits-Missing_DeptFields.xls");
			fail("Should have thrown a missingCriticalDataException");
		} catch (MissingCriticalDataException e) {
			logger.info(bundleMarker,e.getMessage());
		}
		
	}

	/**
	 * Test importing youthClubs
	 */
	public void testImport_Exhibits_Parents_YouthClubs() {
		populateDefaultMap();
		try {
			importSpreadSheet("importExhibits-Parents_YouthClubs.xls");
		} catch (MissingCriticalDataException e) {
			logger.error(bundleMarker,"Failed to import data",e);
			fail(e.getMessage());
		}
		
		String status = procreator.getStatus();
	
		Flags flags = new Flags();
		
		assertEquals(1, flags.divs);
		assertTrue("Wrong Divison", status.contains("1 divisions"));
		
		assertEquals(7, flags.depts);
		assertTrue("Wrong Departments "+status, status.contains("7 departments"));
		
		assertEquals(40, flags.clazzes);
		assertTrue("Wrong Classes "+status, status.contains("40 classes"));
		
		assertEquals(260, flags.lots);
		assertTrue("Wrong Lots "+status, status.contains("260 lots"));
		
		assertEquals(1252, flags.exhibits);
		assertTrue("Wrong Exhibts "+status, status.contains("1252 exhibits"));
		
		assertEquals(278, flags.people);
		assertTrue("Wrong People "+status, status.contains("274 people"));
		
		assertEquals(274, flags.youngPeople);
		
		assertEquals(4, flags.oldPeople);
		assertTrue("Wrong Parents "+status, status.contains("4 parents"));
		
		assertEquals(2, flags.youthClubs);
		assertTrue("Wrong Youth Clubs "+status, status.contains("2 Youth Clubs"));
		
		
		assertTrue("Wrong Animal References "+status, status.contains("0 Animal References"));

		assertEquals(1252, flags.exhibits);

	}
	
	/**
	 * Test importing with Animal references
	 */
	public void testImport_Exhibits_Parents_YouthClubs_Animals() {
		
		Command command = SetCommand.create(
				editingDomain, //domain
				fair,//owner
				FairPackage.Literals.FAIR__PREMISES,//feature
				premises//value
		);
			
		command.execute();
		assertEquals(premises, fair.getPremises());
		
		//Add 3 animals
		String tags[] = {"1234567890","1234567891","1234567892"};
		
		for (String tagId : tags) {
			Animal animal = TrackerFactory.eINSTANCE.createBovineBeef();
			Tag tag = TrackerFactory.eINSTANCE.createTag();
			tag.setId(tagId);
			animal.getTags().add(tag);
			premises.getAnimals().add(animal);
			Command addcommand = AddCommand.create(
					editingDomain, //domain
					premises,//owner
					TrackerPackage.Literals.PREMISES__ANIMALS,//feature
					animal//value
			);
			addcommand.execute();
		}
		
		assertEquals(3, premises.getAnimals().size());
		
		
		
		populateDefaultMap();
		try {
			importSpreadSheet("importExhibits-Parents_YouthClubs_Animals.xls");
		} catch (MissingCriticalDataException e) {
			logger.error(bundleMarker,"Failed to import data",e);
			fail(e.getMessage());
		}
		
		String status = procreator.getStatus();
	
		Flags flags = new Flags();
		
		assertEquals(1, flags.divs);
		assertTrue("Wrong Divison", status.contains("1 divisions"));
		
		assertEquals(7, flags.depts);
		assertTrue("Wrong Departments "+status, status.contains("7 departments"));
		
		assertEquals(40, flags.clazzes);
		assertTrue("Wrong Classes "+status, status.contains("40 classes"));
		
		assertEquals(260, flags.lots);
		assertTrue("Wrong Lots "+status, status.contains("260 lots"));
		
		assertEquals(1252, flags.exhibits);
		assertTrue("Wrong Exhibts "+status, status.contains("1252 exhibits"));
		
		assertEquals(278, flags.people);
		assertTrue("Wrong People "+status, status.contains("274 people"));
		
		assertEquals(274, flags.youngPeople);
		
		assertEquals(4, flags.oldPeople);
		assertTrue("Wrong Parents "+status, status.contains("4 parents"));
		
		assertEquals(2, flags.youthClubs);
		assertTrue("Wrong Youth Clubs "+status, status.contains("2 Youth Clubs"));
		
		
		assertTrue("Animal References "+status, status.contains("3 Animal References"));

		assertEquals(1252, flags.exhibits);

	}
	
	
	/**
	 * Test importing SuplementalTags
	 */
	
	/**
	 * Test importing with Animal references
	 */
	public void testImport_Exhibits_Parents_YouthClubs_Animals_SupID() {
		logger.debug(bundleMarker,"Starting testImport_Exhibits_Parents_YouthClubs_Animals_SupID");
		Command command = SetCommand.create(
				editingDomain, //domain
				fair,//owner
				FairPackage.Literals.FAIR__PREMISES,//feature
				premises//value
		);
			
		command.execute();
		assertEquals(premises, fair.getPremises());
		
		//Add 3 animals
		String tags[] = {"1234567890","1234567891","1234567892"};
		Animal animals[] = {
				TrackerFactory.eINSTANCE.createBovineBeef(),
				TrackerFactory.eINSTANCE.createSwine(),
				TrackerFactory.eINSTANCE.createOvine()		};
		
		for (int i = 0; i < tags.length; i++) {
			Animal animal = animals[i];
			Tag tag = TrackerFactory.eINSTANCE.createTag();
			tag.setId(tags[i]);
			animal.getTags().add(tag);
			premises.getAnimals().add(animal);
			Command addcommand = AddCommand.create(
					editingDomain, //domain
					premises,//owner
					TrackerPackage.Literals.PREMISES__ANIMALS,//feature
					animal//value
			);
			addcommand.execute();
		}
		
		assertEquals(3, premises.getAnimals().size());
		
		
		
		populateDefaultMap();
		populateColumnMap(14, "Swine Right Ear", TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING);
		populateColumnMap(15, "Swine Left Ear", TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING);
		populateColumnMap(16, "Scrapies", TrackerPackage.Literals.OVINE__SCRAPIE_TAG);
		populateColumnMap(17, "Visual ID", TrackerPackage.Literals.ANIMAL__VISUAL_ID);
		
		try {
			importSpreadSheet("importExhibits-Parents_YouthClubs_Animals_SupID.xls");
		} catch (MissingCriticalDataException e) {
			logger.error(bundleMarker,"Failed to import data",e);
			fail(e.getMessage());
		}
		
		String status = procreator.getStatus();
	
		Flags flags = new Flags();
		
		assertEquals(1, flags.divs);
		assertTrue("Wrong Divison", status.contains("1 divisions"));
		
		assertEquals(7, flags.depts);
		assertTrue("Wrong Departments "+status, status.contains("7 departments"));
		
		assertEquals(40, flags.clazzes);
		assertTrue("Wrong Classes "+status, status.contains("40 classes"));
		
		assertEquals(260, flags.lots);
		assertTrue("Wrong Lots "+status, status.contains("260 lots"));
		
		assertEquals(1252, flags.exhibits);
		assertTrue("Wrong Exhibts "+status, status.contains("1252 exhibits"));
		
		assertEquals(278, flags.people);
		assertTrue("Wrong People "+status, status.contains("274 people"));
		
		assertEquals(274, flags.youngPeople);
		
		assertEquals(4, flags.oldPeople);
		assertTrue("Wrong Parents "+status, status.contains("4 parents"));
		
		assertEquals(2, flags.youthClubs);
		assertTrue("Wrong Youth Clubs "+status, status.contains("2 Youth Clubs"));
		
		
		assertTrue("Wrong Animal References "+status, status.contains("3 Animal References"));

		assertEquals(1252, flags.exhibits);

		assertTrue("Wrong Visual IDs "+status, status.contains("3 visual IDs set"));
		
		assertTrue("Wrong Supplemental IDs "+status, status.contains("2 supplemental IDs set"));
	}
	
	
	
	
	/**
	 * @throws MissingCriticalDataException 
	 * 
	 */
	private void importSpreadSheet(String fileName) throws MissingCriticalDataException {
		
		File file = new File(this.testsDirectory,  fileName);
		HSSFSheet sheet = null;
		try {
			sheet = getWorkSheet(file);

		} catch (Exception e) {
			fail(e.toString());
		}

		assertNotNull(sheet);
		
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
//			logger.debug("processing row {}", i);

			try {
				procreator.prepare(fair, sheet.getRow(i),
						spreadSheetColumnsToFeatureMap, fair, false,
						editingDomain);

			} catch (RuntimeException e) {
				logger.error(bundleMarker, "Failed to process row " + i, e);
			}
		}
		
		procreator.execute();
	}

	private HSSFSheet getWorkSheet(File f) throws Exception {
		FileInputStream fin = null;
		HSSFSheet s = null;
		Exception ex = null;
		logger.debug(bundleMarker,"Loading worksheet data.");
		try {
			// create a new file input stream with the input file specified
			// at the command line
			fin = new FileInputStream(f);
			HSSFWorkbook w = new HSSFWorkbook(fin);
			s = w.getSheetAt(0);
		} catch (Exception e) {

		} finally {
			// once all the events are processed close our file input stream
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {

				}
			}
		}
		if (ex != null) {
			throw ex;
		}
		return s;

	}
	
	private void populateColumnMap(int index, String name, EStructuralFeature feature){
		ColumnMapper cm1 = new ColumnMapper((short) index,  name);
		cm1.setFeature(feature);
		spreadSheetColumnsToFeatureMap.add(cm1);
	}
	
	private void populateDefaultMap() {
		populateColumnMap(0, "MemberID", FairPackage.Literals.PERSON__EXHIBITOR_NUMBER);
		populateColumnMap(1, "First Name", FairPackage.Literals.PERSON__FIRST_NAME);
		populateColumnMap(2, "Last Name", FairPackage.Literals.PERSON__LAST_NAME);
		populateColumnMap(3, "Dept", FairPackage.Literals.DEPARTMENT__NAME);
		populateColumnMap(4, "Dept Description", FairPackage.Literals.DEPARTMENT__COMMENTS);
		populateColumnMap(5, "Class", FairPackage.Literals.CLASS__NAME);
		populateColumnMap(6, "Class Description", FairPackage.Literals.CLASS__COMMENTS);
		populateColumnMap(7, "Lot", FairPackage.Literals.LOT__NAME);
		populateColumnMap(8, "Lot Description", FairPackage.Literals.LOT__COMMENTS);
		populateColumnMap(9, "Division", FairPackage.Literals.DIVISION__NAME);
		populateColumnMap(10, "Division Description", FairPackage.Literals.DEPARTMENT__COMMENTS);
		populateColumnMap(11, "Parents", FairPackage.Literals.YOUNG_PERSON__PARENTS);
		populateColumnMap(12, "Youth Clubs", FairPackage.Literals.YOUNG_PERSON__CLUB);
		populateColumnMap(13, "Animal ID", FairPackage.Literals.EXHIBIT__ANIMAL);
	}
	
	private class Flags{
		int divs =0;
		int depts = 0;
		int clazzes = 0;
		int lots=0;
		int exhibits = 0;
		int youthClubs = 0;
		int people = 0;
		int youngPeople = 0;
		int oldPeople =0;
		
		
		
		public Flags() {
			analyze();
		}



		void analyze(){
			for (Division division : fair.getDivisions()) {
				divs++;
				for (Department department : division.getDepartments()) {
					depts++;
					for (com.verticon.tracker.fair.Class clazz : department.getClasses()) {
						clazzes++;
						lots = lots + clazz.getLots().size();
						
					}
				}
			}
			exhibits=fair.exhibits().size();
			youthClubs=fair.getYouthClubs().size();
			
			for (Person person : fair.getPeople()) {
				people ++;
				if(person instanceof YoungPerson){
					youngPeople++;
				}else{
					oldPeople++;
				}
			}
		}
	}
}
