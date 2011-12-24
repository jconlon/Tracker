package com.verticon.google.kmlgx.core.model.tests.extra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.util.KmlgxResourceFactoryImpl;
import com.verticon.google.kmlgx.util.KmlgxResourceImpl;
import com.verticon.google.kmlgx.util.KmlgxXMLProcessor;
import com.verticon.opengis.kml.Document;
import com.verticon.opengis.kml.Kml;
import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.opengis.kml.Placemark;

public class KmlXMLgxProcessorTest {
	private static final String MY1_KML = 
		"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/MyTemp1.kml";
	private static final String MY3_KML = 
		"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/My3.kml";

	private static final String HELLO_EARTH_KML = 
		"/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/HelloEarth.kml";
	KmlgxXMLProcessor processor = new KmlgxXMLProcessor();
	KmlDiagnosticVisitor kmlVisitor = new KmlDiagnosticVisitor();
	KmlgxDiagnosticVisitor gxVisitor = new KmlgxDiagnosticVisitor();
	AuthorlinkDiagnosticVisitor authorVisitor = new AuthorlinkDiagnosticVisitor();
	AddressDiagnosticVisitor addressVisitor = new AddressDiagnosticVisitor();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public final void testResource() {
		System.out.println("***********************testResource");
		Resource resource = createResource();
		assertTrue(resource instanceof KmlgxResourceImpl );
		KmlgxResourceImpl kmlResource = (KmlgxResourceImpl)resource;
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
		System.out.println("***********************testSaveToString");
		Resource resource = createResource();
		assertTrue(resource instanceof KmlgxResourceImpl );
		String result = processor.saveToString(resource, null);
		System.out.println(result);
	}
	
	@Test
	public final void testSaveOutputStream() throws IOException {
		System.out.println("***********************testSaveOutputStream");
		Resource resource = createResource();
		assertTrue(resource instanceof KmlgxResourceImpl );
		OutputStream outputStream = new FileOutputStream(MY1_KML);
		try {
			processor.save(outputStream, resource, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			outputStream.close();
		}
		
		System.out.println("Saved to " +MY1_KML);
	}

	
	@Test
	public final void testLoadPreviousCreated() throws IOException {
		System.out.println("***********************testLoadPreviousCreated");
		File file = new File(MY1_KML);
		assertTrue(file.exists());
		boolean error = true;
		FileInputStream fileInputStream = new FileInputStream(file);
		
		try {
			Resource resource = processor.load(fileInputStream , null);
			assertTrue(resource instanceof KmlgxResourceImpl );
			visit(resource);
			error=false;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			fileInputStream.close();
		}
		if(error){
			fail("Failed to load "+HELLO_EARTH_KML);
		}
	}
	@Test
	public final void testLoadHelloEarthKML() throws IOException {
		System.out.println("***********************testLoadHelloEarthKML");
		FileInputStream file = new FileInputStream(HELLO_EARTH_KML);
		boolean error = true;
		try {
			Resource resource = processor.load(file , null);
			assertTrue(resource instanceof KmlgxResourceImpl );
			visit(resource);
			error = false;
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			file.close();
		}
		if(error){
			fail("Failed to load "+HELLO_EARTH_KML);
		}
	}
	
	@Test
	public final void testLoadFarmKML() throws IOException {
		System.out.println("***********************testLoadFarmKML");
		FileInputStream file = new FileInputStream(MY3_KML);
		boolean error = true;
		try {
			Resource resource = processor.load(file , null);
			assertTrue(resource instanceof KmlgxResourceImpl );
			visit(resource);
			error = false;
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			file.close();
		}
		if(error){
			fail("Failed to load "+HELLO_EARTH_KML);
		}
	}

	private void visit(Resource resource) {
		Iterator<Object> it = EcoreUtil.getAllProperContents(resource, false);
		while (it.hasNext()) {
			EObject eobject = (EObject) it.next();
			Object o = kmlVisitor.doSwitch(eobject);
			if(o==null){
//					System.out.println("***********************");
				o = gxVisitor.doSwitch(eobject);
			}
			if(o==null){
//					System.out.println("***********************");
				o = authorVisitor.doSwitch(eobject);
			}
			if(o==null){
//				System.out.println("***********************");
			o = addressVisitor.doSwitch(eobject);
		}
		}
	}

//	private Resource buildResource1() {
//		Resource resource = new XMLResourceImpl();
//		//Create the root
////		DocumentRoot documentRoot = KmlFactory.eINSTANCE.createDocumentRoot();
//		Kml kml = KmlFactory.eINSTANCE.createKml();
//		
//		//Create a Document
//		Document document = KmlFactory.eINSTANCE.createDocument();
//		document.setDescription("Second level");
//		
//		//Add a Placemark to the Document
//		Placemark placemark =  KmlFactory.eINSTANCE.createPlacemark();
//		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Placemark();
//		document.getAbstractFeatureGroupGroup().add(f,placemark);
//		
//		//Add the document to the kml root
//		kml.getAbstractFeatureGroupGroup().add(KmlPackage.eINSTANCE.getDocumentRoot_Document(), document);
////		kml.setAbstractFeatureGroup(document);
////		documentRoot.setKml(kml);
//		resource.getContents().add(kml);
//		return resource;
//	}

	private Resource createResource() {
		File file = new File(MY1_KML);
		if(file.exists()){
			file.delete();
		}
		
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new KmlgxResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
			(KmlgxPackage.eNS_URI, 
			 KmlgxPackage.eINSTANCE);
        
		Resource resource = resourceSet.createResource(URI.createFileURI(MY1_KML));
		
		//Create the root
//		DocumentRoot documentRoot = KmlFactory.eINSTANCE.createDocumentRoot();
		Kml kml = KmlFactory.eINSTANCE.createKml();
		
		//Create a Document
		Document document = KmlFactory.eINSTANCE.createDocument();
		document.setDescription("Second level");
		
		//Add a Placemark to the Document
		Placemark placemark =  KmlFactory.eINSTANCE.createPlacemark();
		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Placemark();
		document.getAbstractFeatureGroupGroup().add(f,placemark);
//		document.getFeature().add(placemark);
		
		//Add the document to the kml root
		kml.getAbstractFeatureGroupGroup().add(KmlPackage.eINSTANCE.getDocumentRoot_Document(), document);
//	    kml.setFeature(document);
		
//		documentRoot.setKml(kml);
		resource.getContents().add(kml);
		return resource;
	}
	
}
