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
package com.verticon.tracker.util;

import static com.verticon.tracker.util.TrackerConstants.DATE_FORMAT;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_COMMENTS;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_DATE;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_TYPE;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT;
import static com.verticon.tracker.util.TrackerConstants.EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.Scalar;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalMissing;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.WeightMeasurementUnit;

public class TrackerUtilsTest {

	private static final String AD2_ID = "test.weight.unit";
	private static final String AD2_NAME = "Unit";
	private static final String AD1_ID = "test.weight.weight";
	private static final String AD1_NAME = "Weight";
	private static final String OCD_NAME = "Animal Weight";
	private static final String OCD_ID = "test.weight";
	Properties props = null;
	Date date = null;
	ResourceSet resourceSet = null;
	Tag tag = null;
	OCD ocd = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	    props = new Properties();
		date = setDate( props);
		 Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put
	       ("*", 
	        new XMIResourceFactoryImpl() 
	        {
	          public Resource createResource(URI uri)
	          {
	            XMIResource xmiResource = new XMIResourceImpl(uri);
	            return xmiResource;
	          }
	        });

		resourceSet = new ResourceSetImpl();
		
		//Premises
		Premises premises = TrackerFactory.eINSTANCE.createPremises();
		Animal pig = TrackerFactory.eINSTANCE.createSwine();
		premises.getAnimals().add(pig);
		tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId("1");
		pig.getTags().add(tag);
		URI fileURI = URI.createFileURI(new File("/tmp/my.xml").getAbsolutePath());
		Resource premisesResource = resourceSet.createResource(fileURI);
		premisesResource.getContents().add(premises);
		
		//Metatype
		MetaData metaData = MetatypeFactory.eINSTANCE.createMetaData();
	    ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setID(OCD_ID);
		ocd.setName(OCD_NAME);
		metaData.getOCD().add(ocd);
		
		AD ad1 = MetatypeFactory.eINSTANCE.createAD();
		ad1.setDataType(Scalar.DOUBLE);
		ad1.setName(AD1_NAME);
		ad1.setID(AD1_ID);
		ocd.getAD().add(ad1);
		
		AD ad2 = MetatypeFactory.eINSTANCE.createAD();
		ad2.setDataType(Scalar.STRING);
		ad2.setName(AD2_NAME);
		ad2.setID(AD2_ID);
		ocd.getAD().add(ad2);
		
		
		fileURI = URI.createFileURI(new File("/tmp/my.metatype").getAbsolutePath());
		Resource metatypeResource = resourceSet.createResource(fileURI);
		metatypeResource.getContents().add(metaData);
		
	}

	@After
	public void tearDown() throws Exception {
		
		if( resourceSet != null){
			resourceSet.getResources().clear();
			resourceSet = null;
		}
		tag = null;
		ocd = null;
		props = null;
		date = null;
	}
	
	private Date setDate(Properties props) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.YEAR, -1);
		Date date = rightNow.getTime();
		String dateString = DATE_FORMAT.format(date);
		try {
			date = DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			fail("parse failed");
		}

		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_DATE, 
				dateString);
		return date;
	}

	@Test
	public final void testGetAnimalFromTemplate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindOrCreateAnimal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsUsainNumberUsed() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindOCDs() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetType() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCopyEventsToAnimal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAppropriateEvents() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAppropriateAnimals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCreateEvent_AnimalMissing() {
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_TYPE, 
				EventType.ANIMAL_MISSING.getLiteral());
		String comments = "My comments";
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_COMMENTS, 
				comments);
		
		Event event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);
		assertTrue(event instanceof AnimalMissing);
		assertEquals(date, event.getDateTime());
		assertEquals(comments, event.getComments());
	}
	
	@Test
	public final void testCreateEvent_WeighIn() {
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_TYPE, 
				EventType.WEIGH_IN.getLiteral());
		
		String comments = "My comments";
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_COMMENTS, 
				comments);
		String unit = "kilogram";
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT, 
				unit);
		Double weight = new Double(5.5);
		props.put(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT, 
				weight);
		
		Event event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);
		assertEquals(date, event.getDateTime());
		assertEquals(comments, event.getComments());
		assertTrue(event instanceof WeighIn);
		WeighIn weighIn = (WeighIn)event;
		
		assertEquals(WeightMeasurementUnit.KILOGRAM, weighIn.getUnit());
		assertEquals(weight, weighIn.getWeight());
		
		//With bad date
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_DATE, 
				"xxxx");
		event = TrackerUtils.createEvent(props, tag);
		assertNull(event);
		///Reset it
		String dateString = DATE_FORMAT.format(date);
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_DATE, 
				dateString);
		event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);
		
		//With bad weight
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT, 
				"xxxx");
		event = TrackerUtils.createEvent(props, tag);
		assertNull(event);
		///Reset it
		props.put(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_WEIGHT, 
		new Double(4.4));
		event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);
		
		//Bad unit
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_WEIGHIN_UNIT, 
		"xxxx");
		event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);//The default unit will be used to create a valid event
	}

	@Test
	public final void testCreateEvent_GenericEvent() {
		
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_TYPE, 
				EventType.GENERIC_EVENT.getLiteral());
		
		String comments = "My comments";
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_COMMENTS, 
				comments);
		
		props.setProperty(EVENT_ADMIN_PROPERTY_EVENT_GENERICEVENT_OCDID, OCD_ID);
		props.setProperty(AD1_ID, "2.2");
		props.setProperty(AD2_ID, "kilogram");
		
		Event event = TrackerUtils.createEvent(props, tag);
		assertNotNull(event);
		assertEquals(date, event.getDateTime());
		assertEquals(comments, event.getComments());
		
		assertTrue(event instanceof GenericEvent);
		GenericEvent ge = (GenericEvent)event;
		assertEquals(OCD_NAME, ge.findName());
		
		assertEquals(new Double(2.2), ge.value(AD1_NAME));
		assertEquals("kilogram", ge.value(AD2_NAME));
		
	}
	
	

}
