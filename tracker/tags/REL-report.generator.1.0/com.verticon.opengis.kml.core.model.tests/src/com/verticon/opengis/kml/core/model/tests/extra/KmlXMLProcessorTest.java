package com.verticon.opengis.kml.core.model.tests.extra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.ElementHandlerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verticon.opengis.kml.Document;
import com.verticon.opengis.kml.Folder;
import com.verticon.opengis.kml.Kml;
import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.opengis.kml.Placemark;
import com.verticon.opengis.kml.util.KmlResourceFactoryImpl;
import com.verticon.opengis.kml.util.KmlResourceImpl;
import com.verticon.opengis.kml.util.KmlXMLProcessor;

public class KmlXMLProcessorTest {
	private static final String MY1_KML = 
		"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.opengis.kml.core.model.tests/data/My1.kml";
	private static final String MY2_KML = 
		"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.opengis.kml.core.model.tests/data/My3.kml";
	private static final String HELLO = 
			"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.opengis.kml.core.model.tests/data/HelloEarth.kml";
		

	KmlXMLProcessor processor = new KmlXMLProcessor();
	DiagnosticVisitor visitor = new DiagnosticVisitor();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public final void testResource() {
		System.out.println("************************** testResource()");
		Resource resource = buildResource();
		assertTrue(resource instanceof KmlResourceImpl );
		KmlResourceImpl kmlResource = (KmlResourceImpl)resource;
		assertEquals("UTF-8",	kmlResource.getEncoding());
		
//	??	assertEquals(Boolean.TRUE, kmlResource.getDefaultSaveOptions().get(XMLResource.OPTION_EXTENDED_META_DATA));
		
		assertEquals(Boolean.TRUE, kmlResource.getDefaultLoadOptions().get(XMLResource.OPTION_EXTENDED_META_DATA));

		assertEquals(Boolean.TRUE, kmlResource.getDefaultSaveOptions().get(XMLResource.OPTION_SCHEMA_LOCATION));

		assertEquals(Boolean.TRUE, kmlResource.getDefaultLoadOptions().get(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE));
		assertEquals(Boolean.TRUE, kmlResource.getDefaultSaveOptions().get(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE));

		assertEquals(Boolean.TRUE, kmlResource.getDefaultLoadOptions().get(XMLResource.OPTION_USE_LEXICAL_HANDLER));
		
		assertEquals("UTF-8", kmlResource.getDefaultSaveOptions().get(XMLResource.OPTION_ENCODING));//Added
		Object o = kmlResource.getDefaultSaveOptions().get(XMLResource.OPTION_ELEMENT_HANDLER);
		assertTrue(o instanceof ElementHandlerImpl);//Added
		assertEquals(Boolean.TRUE, kmlResource.getDefaultLoadOptions().get(XMLResource.OPTION_SUPPRESS_DOCUMENT_ROOT));  //Added

		 
	}
	
	
	@Test
	public final void testSaveToString() throws IOException{
		System.out.println("************************** testSaveToString()");
		Resource resource = buildResource();
		String result = processor.saveToString(resource, null);
		System.out.println(result);
	}
	
	@Test
	public final void testSaveOutputStream() {
		System.out.println("************************** testSaveOutputStream()");
		Resource resource = buildResource();
		try {
			resource.save(null);
		} catch (IOException e) {
			
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.println("Saved to " +MY1_KML);
	}

	

	@Test
	public final void testLoad1() throws IOException {
		System.out.println("************************** testLoad1()");
		FileInputStream file = new FileInputStream(MY1_KML);
		try {
			Resource resource = processor.load(file , null);
			Iterator<Object> it = EcoreUtil.getAllProperContents(resource, false);
			while (it.hasNext()) {
				EObject eobject = (EObject) it.next();
				visitor.doSwitch(eobject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			file.close();
		}
	}
	
	@Test
	public final void testLoad2() throws IOException {
		System.out.println("************************** testLoad2()");
		FileInputStream file = new FileInputStream(MY2_KML);
		try {
			Resource resource = processor.load(file , null);
			Iterator<Object> it = EcoreUtil.getAllProperContents(resource, false);
			while (it.hasNext()) {
				EObject eobject = (EObject) it.next();
				visitor.doSwitch(eobject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			file.close();
		}
	}

	@Test
	public final void testLoad3() throws IOException {
		System.out.println("************************** testLoad()");
		FileInputStream file = new FileInputStream(HELLO);
		try {
			Resource resource = processor.load(file , null);
			Iterator<Object> it = EcoreUtil.getAllProperContents(resource, false);
			while (it.hasNext()) {
				EObject eobject = (EObject) it.next();
				visitor.doSwitch(eobject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			file.close();
		}
	}
	
	private Resource buildResource() {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new KmlResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
			(KmlPackage.eNS_URI, 
			 KmlPackage.eINSTANCE);
        
		Resource resource = resourceSet.createResource(URI.createFileURI(MY1_KML));
		
		//Create the root
//		DocumentRoot documentRoot = KmlFactory.eINSTANCE.createDocumentRoot();
		Kml kml = KmlFactory.eINSTANCE.createKml();
		
		//Create a Document
		Document document = KmlFactory.eINSTANCE.createDocument();
		document.setDescription("Doc level");
		
		//Add a Folder to the Document
		Folder folder = KmlFactory.eINSTANCE.createFolder();
		folder.setName("MyFolder");
		folder.setDescription("The first folder");
		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Folder();
		document.getAbstractFeatureGroupGroup().add(f,folder);
		
		//Add a Placemark to the folder
		Placemark placemark =  KmlFactory.eINSTANCE.createPlacemark();
		placemark.setName("MyPlacemark");
		placemark.setId("12345");
		f = KmlPackage.eINSTANCE.getDocumentRoot_Placemark();
		folder.getAbstractFeatureGroupGroup().add(f,placemark);
		
		//Add the document to the kml root
		kml.getAbstractFeatureGroupGroup().add(KmlPackage.eINSTANCE.getDocumentRoot_Document(), document);

		resource.getContents().add(kml);
		return resource;
	}

	
}
