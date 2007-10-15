/**
 * 
 */
package com.verticon.tracker.tests;

import java.io.File;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;

/**
 * @author jconlon
 *
 */
public class ResourceFactoryTest extends TestCase {

	private ResourceSet resourceSet;
	private File file;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		resourceSet = new ResourceSetImpl();
		 file = new File("test.premises");
		URI fileURI = URI.createFileURI(file.getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(premises);
		resource.save(null);
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		file.delete();
		super.tearDown();
	}

	public void testGetEventCode() {
		assertNotNull(resourceSet);
		assertNotNull(resourceSet.getAdapterFactories());
		EList<AdapterFactory> facts = resourceSet.getAdapterFactories();
//		assertTrue(facts.size()!=0);
//		for (AdapterFactory factory : facts) {
//			System.out.println(factory.getClass());
//		}
//		ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
		Resource.Factory.Registry reg = resourceSet.getResourceFactoryRegistry();
		Map<String, Object> map = reg.getExtensionToFactoryMap();
		System.out.println("Map "+map);
//		EPackage.Registry.INSTANCE.getEPackage(arg0);
		
	}
}
