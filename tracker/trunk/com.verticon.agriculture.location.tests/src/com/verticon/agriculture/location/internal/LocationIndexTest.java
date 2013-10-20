package com.verticon.agriculture.location.internal;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.Association;
import com.verticon.agriculture.util.AgricultureResourceFactoryImpl;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerResourceFactoryImpl;

/**
 * To test the LocationIndex off line will require the loading of one or more Associations that are referencing
 * Premises on the filesystem.
 * 
 *  
 * @author jconlon
 *
 */
public class LocationIndexTest {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
	
	private Association association = null;
	private LocationIndex index = null;

	@Before
	public void setUp() throws Exception {
		 association = getAssociatonFromResourceDirectory();
		  index = LocationIndex.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		if(association!=null){
			association = null; 
		}
		if(index!=null){
			index.clean();
			index = null;
		}
	}

	/**
	 * Test the factory
	 */
	@Test
	public final void testGetInstance() {
		assertThat(index,  is(notNullValue()));
	}

	
	@Test
	public final void testAdd() {
		index.add(association);
	}
	
	@Test
	public final void testName() {
		index.add(association);
		for (Premises premises : association.getLivestock()) {
			assertThat(premises.getLocation(),is(notNullValue()));
			String uri = premises.getUri();
			String name = index.name(uri);
			assertThat(name,is(notNullValue()));
			assertThat(name, is(premises.getLocation().getName()));
		}
	}

	@Test
	public final void testAddress() {
		index.add(association);
		for (Premises premises : association.getLivestock()) {
			assertThat(premises.getLocation(),is(notNullValue()));
			String uri = premises.getUri();
			String address = index.address(uri);
			assertThat(address,is(notNullValue()));
			assertThat(address, is(premises.getLocation().getAddress()));
		}
	}

	@Test
	public final void testLocate() {
		index.add(association);
		try{
			index.locate("crap");
			fail("Should throw an excpetion");
		}catch(IllegalArgumentException e){
			//expected
		}
		String name = index.locate("-90.95048182270057,43.47622307339506,0");
		assertThat(name, is(notNullValue()));
		assertThat(name, is("Pasture One"));
	}

	/**
	 * Only the east farm will have sub location areas
	 */
	@Test
	public final void testLocationsIn() {
		index.add(association);
		for (Premises premises : association.getLivestock()) {
			assertThat(premises.getLocation(),is(notNullValue()));
			String uri = premises.getUri();
			Set<String> locatoions = index.locationsIn(uri);
			assertThat(locatoions,is(notNullValue()));
			if(premises.getName().equals("East Farm")){
				assertThat(premises.getName(),locatoions.size(), is(5));
			}else{
				assertThat(premises.getName(),locatoions.size(), is(1));
			}
		}
	}
	
	/**
	 * Only the east farm will have sub location areas
	 */
	@Test
	public final void testGetAssociates() {
		index.add(association);
		
		for (Premises premises : association.getLivestock()) {
			assertThat(premises.getLocation(),is(notNullValue()));
			String uri = premises.getUri();
			Map<String,String> associates = index.getAssociates(uri);
			assertThat(associates,is(notNullValue()));
			assertThat(associates.size(), is(2));
			assertThat(associates.containsKey(uri),is(false));
		}
	}

	@Test
	public final void testCanHandle() {
		assertThat(index.canHandle("I can handle strings"), is(true));
		assertThat(index.canHandle(Map.class), is(true));
		/*
		 * National Beef Packing urn:dn:com:nationalbeef
		 * Pokey Feeders, Inc. urn:dn:com:cattlefeeding
		 */
		String out = String.format("%-25s %-40s", "National Beef Packing", "urn:dn:com:nationalbeef");
		System.out.println(out);
		 out = String.format("%-25s %-40s", "Pokey Feeders", "urn:dn:com:cattlefeeding");
		 System.out.println(out);
	}

	@Test
	public final void testClean() {
		ResourceSet resourceSet = getResoureSet();
		assertThat(resourceSet, is(notNullValue()));
		Resource resource = getXMIResource("example.premises",  resourceSet);
		index.add(association);
		assertThat(index.isAssociatedResource(resource.getURI()),is(true));
		index.clean();
		assertThat(index.isAssociatedResource(resource.getURI()),is(false));
	}

	@Test
	public final void testIsAssociatedResource() {
		ResourceSet resourceSet = getResoureSet();
		assertThat(resourceSet, is(notNullValue()));
		Resource resource = getXMIResource("example.premises",  resourceSet);
		assertThat(index.isAssociatedResource(resource.getURI()),is(false));
		index.add(association);
		assertThat(index.isAssociatedResource(resource.getURI()),is(true));
	}

	@Test
	public final void testRemoveMapEntriesFromAgriDocument() {
		ResourceSet resourceSet = getResoureSet();
		assertThat(resourceSet, is(notNullValue()));
		Resource resource = getXMIResource("example.premises",  resourceSet);
		index.add(association);
		assertThat(index.isAssociatedResource(resource.getURI()),is(true));
		index.removeAssociation(association.eResource().getURI());
		assertThat(index.isAssociatedResource(resource.getURI()),is(false));
	}

	
	/**
	 * Retrieve the doc.agri from the resources directory
	 * it has three Premises in association. 
	 */
	private static Association getAssociatonFromResourceDirectory (){
		ResourceSet resourceSet = getResoureSet();
		assertThat(resourceSet, is(notNullValue()));
		Resource resource = getXMIResource("doc.agri",  resourceSet);
		assertThat(resource, is(notNullValue()));
		Object object = resource.getContents().get(0);
		assertThat(object, is(instanceOf(Association.class)));
		Association association = (Association)object;
		assertThat(association.getName(),is("ExampleAssociation"));
		assertThat(association.getLivestock().size(),is(3));
		return association;
	}
	
	private static ResourceSet getResoureSet(){
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			("agri", 
			 new AgricultureResourceFactoryImpl());
			resourceSet.getPackageRegistry().put
			(AgriculturePackage.eNS_URI, 
					AgriculturePackage.eINSTANCE);
			
			//Premises
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			("premises", 
			 new TrackerResourceFactoryImpl());
			resourceSet.getPackageRegistry().put
			(TrackerPackage.eNS_URI, 
					TrackerPackage.eINSTANCE);
						
			return resourceSet;
		}
	 
	@SuppressWarnings("unused")
	private static Resource createXMIResource(String fileName, ResourceSet resourceSet) {
			URI uri = createURI(fileName);
			Resource resource = resourceSet.createResource(uri);
			return resource;
	}
	
	private  static URI createURI(String fileName) {
			URI uri = URI.createFileURI(new File("resources/"+fileName).getAbsolutePath());
			return uri;
	}
	
	private static Resource getXMIResource(String fileName, ResourceSet resourceSet) {
			URI uri = createURI(fileName);
			Resource resource = resourceSet.getResource(uri, true);
			return resource;
    }

}
