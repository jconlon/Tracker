package com.verticon.google.kmlgx.core.model.tests.extra;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verticon.google.kmlgx.util.KmlgxXMLProcessor;

public class GenericProcessorTest {
	private static final String MY1_KML = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/My1.kml";
	private static final String MY3_KML = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/My3.kml";
	private static final String SCHEMA = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.schema/kml22gx-trimmed.xsd";

	private static final String PLATFORM_MY1_KML = "/com.verticon.google.kmlgx.core.model.tests/data/My1.kml";
	private static final String PLATFORM_MY3_KML = "/com.verticon.google.kmlgx.core.model.tests/data/My3.kml";
	
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
	public final void testGeneric() throws IOException{
		// generate EPackages from schemas
		XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
		URI schemaURI = URI.createFileURI(SCHEMA);
		Collection<EObject> generatedPackages = xsdEcoreBuilder.generate(schemaURI);

		// register the packages loaded from XSD
		for (EObject generatedEObject : generatedPackages) {
		    if (generatedEObject instanceof EPackage) {
		        EPackage generatedPackage = (EPackage) generatedEObject;
		        EPackage.Registry.INSTANCE.put(generatedPackage.getNsURI(),
		            generatedPackage);
		    }
		}

		// add file extension to registry
		ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap()
		    .put("kml", new GenericXMLResourceFactoryImpl());

		ResourceSet resourceSet = new ResourceSetImpl();
//		URI xmlURI = URI.createPlatformResourceURI(PLATFORM_MY1_KML, true); //This only works as a plugin
		URI xmlURI = URI.createFileURI(MY3_KML);
//		Map<?,?> results = new HashMap<Object,Map<String,? extends Map>();
//		Map input = new HashMap<String,Object>();
//		input.put(URIConverter.OPTION_RESPONSE, results);
		Map<String,?> results = URIConverter.INSTANCE.contentDescription(xmlURI, null);
		boolean exists = URIConverter.INSTANCE.exists(xmlURI, null);
		System.out.println("ContentDescription = "+results);
		assertTrue(exists);
		
		Resource resource = resourceSet.getResource(xmlURI, true);
		resource.load(Collections.EMPTY_MAP);
//		visit(resource); //wont do anything
		EObject root = resource.getContents().get(0);
		assertNotNull(root);
		System.out.println(root);
		
	}


	void visit(Resource resource) {
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

	
}
