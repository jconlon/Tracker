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
/**
 * 
 */
package com.verticon.tracker.reader.comm.tests;

import static com.verticon.tracker.reader.comm.tests.Activator.bundleMarker;
import static com.verticon.tracker.reader.comm.tests.ConnectionFactoryImplTest.JAVA_LIBRARY_PATH;
import static com.verticon.tracker.reader.comm.tests.ConnectionFactoryImplTest.testPortSetting;
import static com.verticon.tracker.reader.event.comm.CommReaderPlugin.GNU_IO_RXTX_SERIAL_PORTS;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.event.comm.SerialPortReader;


/**
 * Test of the SerialPortReader in a Plugin.
 * Copies a local copy of an animal template to the testing workspace 
 * so it can be used as a reference for testing the SerialPortReader.
 * @author jconlon
 *
 */
public class SerialPortReaderTest extends TestCase {

	private static final String VERTICON_READER_COMM_TESTS_TEMPLATE = "verticon.reader.comm.tests.template";
	private static final String FOLDER_NAME = "test1";
	private static final String PROJECT_NAME = "ProjectName";
	private static final String TEMPLATE_IN_TESTING_PROJECT = PROJECT_NAME+'/'+FOLDER_NAME+'/'+"example.animal";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SerialPortReaderTest.class);
	
	private SerialPortReader instance = null;
	private URI testsDirectory = null;
	
	/* 
	 * Sets up the template and the SerialPort reader.
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String testTemplate = System.getProperty(VERTICON_READER_COMM_TESTS_TEMPLATE);
		assertNotNull("System property not set", testTemplate);
		File file = new File(testTemplate);
		assertTrue("Template: "+testTemplate+" does not exist", file.exists());
		assertTrue("Template: "+testTemplate+" does is not a file", file.isFile());
	    
	    testsDirectory = URI.create(testTemplate);
		instance = new SerialPortReader();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		if(instance !=null){
			if(instance.isStarted()){
				instance.setStarted(false);
			}
			instance = null;
		}
		testsDirectory = null;
		super.tearDown();
	}

	/**
	 * Tests that all properties and services are configured and available.
	 * Starts services if they are not already started.
	 */
	public void testPropertiesAndServices() {
		logger.debug(bundleMarker, GNU_IO_RXTX_SERIAL_PORTS + "={}", 
				System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
		logger.debug(bundleMarker, JAVA_LIBRARY_PATH + "={}", System
				.getProperty(JAVA_LIBRARY_PATH)); 
		
		assertNotNull("Serial ports not set", System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
		testPortSetting();
		
		
		Activator a = Activator.getDefault();
		BundleContext bc = a.getBundle().getBundleContext();
		//Another test has the code to starting and testing the needed bundles
		ConnectorServiceTest.startBundles(logger, bc);
		ServiceReference sr = bc.getServiceReference(ConnectorService.class.getName());
		    
		assertNotNull("Failed to find a ConnectorServiceReference.", sr);
		    
	    ConnectorService cs = (ConnectorService)bc.getService(sr);
		    
		assertNotNull("Failed to find a ConnectorService.", cs);
		    
	}
	/**
	 * Test method for {@link com.verticon.tracker.reader.event.comm.SerialPortReader#SerialPortReader()}.
	 */
	public void testSerialPortReader() {
		logger.debug(bundleMarker, "Starting tests");
		assertNotNull("instance should not be Null",instance);
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#setName(java.lang.String)}.
	 */
	public void testSetName() {
		instance.setName("Frank");
		assertEquals("Frank", instance.getName());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#toString()}.
	 */
	public void testToString() {
		instance.setName("bozo");
		assertEquals("SerialPortReader:bozo", instance.toString());
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#getType()}.
	 */
	public void testGetType() {
		assertEquals("SerialPortReader", 
				instance.getType());
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#getTarget()}.
	 */
	public void testGetTarget() {
		assertNull(instance.getTarget());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#setTarget(java.net.URI)}.
	 */
	public void testSetTarget() {
		assertNull(instance.getTarget());
		URI uri = setupTarget();
		assertNotNull(instance.getTarget());
		assertEquals(uri, instance.getTarget());
	}

	/**
	 * @return
	 */
	private URI setupTarget() {
		String portName = testPortSetting();
		URI uri = null;
		try {
			 uri = new URI("comm:"+portName);
		} catch (URISyntaxException e) {
			fail("bad uri");
		}
		instance.setTarget(uri);
		return uri;
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#getTemplate()}.
	 */
	public void testGetTemplate() {
		assertEquals("Should be an empty string","",instance.getTemplate());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#setTemplate(java.lang.String)}.
	 */
	public void testSetTemplate() {
		assertEquals("Should be an empty string","",instance.getTemplate());
		setUpWorkspace();
		instance.setTemplate(TEMPLATE_IN_TESTING_PROJECT);
		assertEquals(TEMPLATE_IN_TESTING_PROJECT, instance.getTemplate());
	}
	
	

	/**
	 * Creates a project and copies the local template to that project in
	 * the testing workspace.
	 */
	private void setUpWorkspace() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final String rootLocation = workspace.getRoot().getLocation().toString();
		
		logger.debug(bundleMarker, "Workspace root location = {}", rootLocation);
		
		final IFileSystem fileSystem = EFS.getLocalFileSystem();
		final IFileStore templateFile = fileSystem.getStore(testsDirectory);

		;
		final IProject project = workspace.getRoot().getProject(PROJECT_NAME);
		IWorkspaceRunnable operation = new IWorkspaceRunnable(){

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				if(!project.exists()){
				 project.create(monitor);
				}
				project.open(monitor);
				IFolder folder = project.getFolder(FOLDER_NAME);
				if(!folder.exists()){
				  folder.create(true, true, monitor);
				}
				IFile file = folder.getFile("example.animal");
				if(!file.exists()){
				  file.create(null, IResource.NONE, monitor);
				}
				IFileStore destinationFile = fileSystem.getStore(
						URI.create(rootLocation + file.getFullPath())
				);
				
				try {
					logger.debug(bundleMarker, "Copying {} to {}", templateFile, destinationFile);
					templateFile.copy(destinationFile,  EFS.OVERWRITE, null);
				} catch (CoreException e) {
					logger.error(bundleMarker, "Failed to copy : "+e.getLocalizedMessage(),e);
					e.printStackTrace();
					fail(e.getLocalizedMessage());
				}
			}
			
		};

		try {
			workspace.run(operation, null);
		} catch (CoreException e) {
			logger.error(bundleMarker, e.getLocalizedMessage(),e);
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#isStarted()}.
	 */
	public void testIsStarted() {
		assertFalse("Should not have started.",instance.isStarted());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#setStarted(boolean)}.
	 * @throws InterruptedException 
	 */
	public void testSetStarted() throws InterruptedException {
		setUpWorkspace();
		instance.setTemplate(TEMPLATE_IN_TESTING_PROJECT);
		setupTarget();
		
		instance.setName("setStarted Test");
		instance.setStarted(true);
		TimeUnit.SECONDS.sleep(10);
		assertTrue("SerialPortReader Instance did not start.",instance.isStarted());
		
	}
	

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#publish(java.lang.Long)}.
	 */
	public void testPublish() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#refresh()}.
	 */
	public void testRefresh() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#start()}.
	 */
	public void testStart() {
		fail("Not yet implemented"); // TODO
	}

}
