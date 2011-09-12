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
package com.verticon.tracker.editor.util;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verticon.osgi.metatype.AD;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.edit.provider.GenericEventItemProvider;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;

public class AttributeItemPropertyDescriptorTest {

	private static final String NEW_VALUE = "NEW VALUE";
	private static final String TEST_ATTRIBUTE_NAME = "testAttributeName";
	private static final String TEST_ATTRIBUTE_DESCRIPTION = "testAttributeDescription";
	private static final String TEST_PROPERTY_ID = "testAttributeId";
	private static final String OCD_ID = "test.id";
	private static final String OCD_DESCRIPTION = "A test description";
	private static final String OCD_NAME = "OCD_NAME";
	OCD ocd;
	AD ad;
	GenericEvent ge;
	WeighIn we;
	
	AdapterFactory adapterFactory;
	IItemPropertySource instance;
	
	@Before
	public void setUp() throws Exception {
		ocd = MetatypeFactory.eINSTANCE.createOCD();
		ocd.setDescription(OCD_DESCRIPTION);
		ocd.setName(OCD_NAME);
		ocd.setID(OCD_ID);
		ad = MetatypeFactory.eINSTANCE.createAD();
		ad.setName(TEST_ATTRIBUTE_NAME);
		ad.setID(TEST_PROPERTY_ID);
		ad.setDescription(TEST_ATTRIBUTE_DESCRIPTION);
		ocd.getAD().add(ad);
		
		we = TrackerFactory.eINSTANCE.createWeighIn();
		we.setComments("WeighInComments");
		we.setWeight(999d);
		
		ge = TrackerFactory.eINSTANCE.createGenericEvent();
		ge.setComments("geComments");
		ge.setOcd(ocd);
	    adapterFactory = new TrackerItemProviderAdapterFactory();
		instance =  (IItemPropertySource)adapterFactory.adapt(ge, IItemPropertySource.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAttributeItemPropertyDescriptor() {
		assertNotNull(instance);
		assertTrue(instance instanceof GenericEventItemProvider);
	}

//	@Test
//	public final void testWeighIn() {
//		assertEquals(7, instance.getPropertyDescriptors(ge).size());
//		PropertySource ps = new PropertySource(we, (IItemPropertySource)adapterFactory.adapt(we, IItemPropertySource.class));
//		for (IPropertyDescriptor descriptor : ps.getPropertyDescriptors()) {
//			System.out.println('<'+descriptor.getCategory()+"> "+descriptor.getDisplayName()+'='+" "
//					+getText(ps, descriptor));
//		}
//	}
	
	@Test
	public final void testGenericEvent() {
		assertEquals(7, instance.getPropertyDescriptors(ge).size());
		IItemPropertySource ips = (IItemPropertySource)adapterFactory.adapt(
				ge, IItemPropertySource.class);
		String format = "|%1$-17s|%2$-20s|%3$-20s|%4$-30s|\n";
		System.out.format(format, "Category", "DisplayName", "ID", "Feature");
	    System.out.format(format, "============", "=================", "=================", "==============================");

		for (IItemPropertyDescriptor descriptor : ips.getPropertyDescriptors(ge)) {
			System.out.format(format, descriptor.getCategory(ge), descriptor.getDisplayName(ge), descriptor.getId(ge), descriptor.getFeature(ge));
		}
		
		System.out.println();
		System.out.println();
		
		PropertySource ps = new PropertySource(ge,ips );
		assertNotNull(ps);
		
		ps.setPropertyValue(TEST_PROPERTY_ID, NEW_VALUE);
		
	    System.out.format(format, "LabelProvider", "DisplayName", "ID", "VALUE");
	    System.out.format(format, "============", "=================", "=================", "==============================");
	    
	    
		for (IPropertyDescriptor descriptor : ps.getPropertyDescriptors()) {
			if(descriptor.getId().equals(TEST_PROPERTY_ID)){
			try {
				descriptor.createPropertyEditor(null);
			} catch (Exception e) {
				
			}
			}
			System.out.format(format, descriptor.getLabelProvider(), descriptor.getDisplayName(), descriptor.getId(), getText(ps, descriptor,ge));

		}
	}
	
//	@Test
//	public final void testGetCategory() {
//		assertEquals(7, instance.getPropertyDescriptors(ge).size());
//		PropertySource ps = new PropertySource(we, (IItemPropertySource)adapterFactory.adapt(we, IItemPropertySource.class));
//		for (IPropertyDescriptor descriptor : ps.getPropertyDescriptors()) {
//			System.out.println('<'+descriptor.getCategory()+"> "+descriptor.getDisplayName()+'='+" "
//					+getText(ps, descriptor));
//		}
//	}

	private String getText(PropertySource ps, IPropertyDescriptor descriptor, Object o) {
		Object obj = ps.getPropertyValue(descriptor.getId());
		
		ItemPropertyDescriptor.PropertyValueWrapper wrapper = (PropertyValueWrapper) obj;
		
		return wrapper!=null?wrapper.getText(o):"";
	}
	
	private String getText(IItemPropertyDescriptor descriptor, Object o) {
		Object obj = descriptor.getPropertyValue(o);
		
		ItemPropertyDescriptor.PropertyValueWrapper wrapper = (PropertyValueWrapper) obj;
		
		return wrapper!=null?wrapper.getText(o):"";
	}

	@Test
	public final void testGetCategory() {
		assertEquals(OCD_NAME, instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getCategory(ge));
	}

	
	@Test
	public final void testGetDescription() {
		assertEquals(TEST_ATTRIBUTE_DESCRIPTION, instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getDescription(ge));
	}

	@Test
	public final void testGetDisplayName() {
		assertEquals(TEST_ATTRIBUTE_NAME, instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getDisplayName(ge));
	}

	@Test
	public final void testGetId() {
		assertEquals(TEST_PROPERTY_ID, instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getId(ge));
	}

	@Test
	public final void testCanSetProperty() {
		assertTrue(instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).canSetProperty(ge));
	}

	@Test
	public final void testGetChoiceOfValues() {
		assertNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getChoiceOfValues(ge));
	}

	@Test
	public final void testGetFeature() {
		assertEquals(TrackerPackage.Literals.STRING_TO_STRING_MAP__VALUE, instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getFeature(ge));
	}

	@Test
	public final void testGetFilterFlags() {
		assertNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getFilterFlags(ge));
	}

	@Test
	public final void testGetHelpContextIds() {
		assertNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getHelpContextIds(ge));
	}

	@Test
	public final void testGetLabelProvider() {
		assertNotNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getLabelProvider(ge));
		
	}

	@Test
	public final void testGetPropertyValue() {
		assertNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getPropertyValue(ge));
		instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID).setPropertyValue(ge, NEW_VALUE);
		assertNotNull( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).getPropertyValue(ge));
		assertEquals(NEW_VALUE, 
				getText(instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID )
						,ge)
		);
	}

	

	@Test
	public final void testIsMany() {
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isMany(ge));
	}

	@Test
	public final void testIsMultiLine() {
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isMultiLine(ge));
	}

	@Test
	public final void testSetPropertyValue() {
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isPropertySet(ge));
		instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID).setPropertyValue(ge, NEW_VALUE);
		assertTrue( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isPropertySet(ge));
	}
	
	
	@Test
	public final void testIsPropertySet() {
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isPropertySet(ge));
		instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID).setPropertyValue(ge, NEW_VALUE);
		assertTrue( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isPropertySet(ge));
	}

	@Test
	public final void testIsSortChoices() {
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isSortChoices(ge));
	}

	@Test
	public final void testResetPropertyValue() {
		instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID).setPropertyValue(ge, NEW_VALUE);
		instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).resetPropertyValue(ge);
		assertFalse( instance.getPropertyDescriptor(ge,TEST_PROPERTY_ID ).isPropertySet(ge));
	}

	

	@Test
	public final void testIsCompatibleWith() {
		fail("Not yet implemented"); // TODO
	}
}
