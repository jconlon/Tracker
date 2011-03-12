package com.verticon.google.kmlgx.core.model.tests.extra;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class URITest {
	private static final String MY1_KML = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/My1.kml";
	private static final String MY3_KML = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.model.tests/data/My3.kml";
	private static final String SCHEMA = "/home/jconlon/Workspaces/tracker_dev-01/com.verticon.google.kmlgx.core.schema/kml22gx-trimmed.xsd";

	private static final String PLATFORM_MY1_KML = "/com.verticon.google.kmlgx.core.model.tests/data/My1.kml";
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFileURI(){
		File file1 = new File(MY1_KML);
		assertTrue(file1.exists());
		assertTrue(file1.isFile());
		
		URI file1URI = URI.createFileURI(file1.getAbsolutePath());
		assertTrue(file1URI.isFile());
	}

	@Test
	public void testPlatformResouceURI(){
		URI plateformURI = URI.createPlatformResourceURI(PLATFORM_MY1_KML, true);
		System.out.println(plateformURI);
		assertTrue(plateformURI.isPlatformResource());
		Map<?,?> results = new HashMap<Object,Object>();
		boolean exists = URIConverter.INSTANCE.exists(plateformURI, results);
		System.out.println(results);
		assertTrue(exists);
		
	}
	
}
