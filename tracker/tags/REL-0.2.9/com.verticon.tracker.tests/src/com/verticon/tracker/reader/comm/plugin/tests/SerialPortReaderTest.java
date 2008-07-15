/**
 * 
 */
package com.verticon.tracker.reader.comm.plugin.tests;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.event.comm.SerialPortReader;

/**
 * @author jconlon
 *
 */
public class SerialPortReaderTest extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SerialPortReaderTest.class);
	
	private SerialPortReader instance = null;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		instance = new SerialPortReader();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		if(instance !=null){
			if(instance.isStarted()){
				instance.setStarted(false);
			}
			instance = null;
		}
		
		super.tearDown();
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.event.comm.SerialPortReader#SerialPortReader()}.
	 */
	public void testSerialPortReader() {
		logger.debug("Starting tests");
		assertNotNull("instance should not be Null",instance);
	}
	
	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#getName()}.
	 */
	public void testGetName() {
		assertEquals("SerialPortReader2", instance.getName());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#setName(java.lang.String)}.
	 */
	public void testSetName() {
		assertEquals("SerialPortReader3", instance.getName());
		instance.setName("Frank");
		assertEquals("Frank", instance.getName());
	}

	/**
	 * Test method for {@link com.verticon.tracker.reader.AbstractConnectionReader#toString()}.
	 */
	public void testToString() {
		//getType() + ' ' + getName()
		instance.setName("bozo");
		assertEquals("SerialPortReader bozo", instance.toString());
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
		URI uri = null;
		try {
			 uri = new URI("comm:/dev/rfcomm0");
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
		String template = setupTemplate();
		assertEquals(template,instance.getTemplate());
	}
	
	public void testTemplateExistence(){
		String template = "test1/example.animal";
		File file = new File(template);
		assertTrue(file.exists());
	}

	/**
	 * @return
	 */
	private String setupTemplate() {
//		String fs-location ="file:/home/jconlon/eclipse-runtimes/trackerProductRefactored/test1/example.animal";
		String template = "test1/example.animal";
		File file = new File(template);
		assertTrue(file.exists());
//		createTemplate(template);
		instance.setTemplate(template);
		return template;
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
		
		setupTemplate();
		setupTarget();
		
		instance.setName("setStarted Test");
		instance.setStarted(true);
		TimeUnit.SECONDS.sleep(10);
		assertTrue(instance.isStarted());
		
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
