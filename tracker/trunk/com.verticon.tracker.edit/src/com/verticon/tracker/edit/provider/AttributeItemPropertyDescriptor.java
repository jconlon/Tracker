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
package com.verticon.tracker.edit.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.osgi.service.metatype.AttributeDefinition;

import com.verticon.osgi.metatype.Scalar;
import com.verticon.tracker.GenericEvent;

/**
 * IItemPropertyDescriptor for GenericEvent attributes that are associated
 * with a Metatype AttributeDefinition object.
 * 
 * Added for Ticket#414
 * @author jconlon
 *
 */
public class AttributeItemPropertyDescriptor implements IItemPropertyDescriptor {

	private final AttributeDefinition attributeDefinition;
	private final IItemPropertyDescriptor valueItemPropertyDescriptor;
	private final String category;
	
    public AttributeItemPropertyDescriptor(
			AttributeDefinition attributeDefinition,
			IItemPropertyDescriptor delegate, String category) {
		super();
		this.attributeDefinition = attributeDefinition;
		this.valueItemPropertyDescriptor = delegate;
		this.category=category;
	}
	
    @Override
	public String toString() {
		return "AttributeItemPropertyDescriptor [attributeDefinition="
				+ attributeDefinition.getName() + ", category=" + category
				+ ", type="
				+  Scalar.get(attributeDefinition.getType()) + "]";
	}

	@Override
	public String getCategory(Object thisObject) {
		return category;
	}

	@Override
	public String getDescription(Object thisObject) {
		return attributeDefinition.getDescription();	
	}

	@Override
	public String getDisplayName(Object thisObject) {
		return attributeDefinition.getName();	
	}

	@Override
	public String getId(Object thisObject) {
		return attributeDefinition.getID();
	}

	@Override
	public boolean canSetProperty(Object object) {
		return true;
	}

	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		if(attributeDefinition.getOptionValues()==null){
			return null;
		}
		return Arrays.asList(attributeDefinition.getOptionValues());
	}

	@Override
	public Object getFeature(Object object) {
		return valueItemPropertyDescriptor.getFeature(findEntry( object));
	}

	@Override
	public String[] getFilterFlags(Object object) {
		return valueItemPropertyDescriptor.getFilterFlags(findEntry( object));
	}

	@Override
	public Object getHelpContextIds(Object object) {
		return valueItemPropertyDescriptor.getHelpContextIds(findEntry( object));
	}

	@Override
	public IItemLabelProvider getLabelProvider(Object object) {
		return valueItemPropertyDescriptor.getLabelProvider(findEntry( object));
	}

	@Override
	public Object getPropertyValue(Object object) {
		Entry<String,String> entry = findEntry( object);
		return valueItemPropertyDescriptor.getPropertyValue(entry);
	}

	@Override
	public boolean isCompatibleWith(Object object,
			Object anotherObject,
			IItemPropertyDescriptor anotherPropertyDescriptor) {
		return valueItemPropertyDescriptor.isCompatibleWith(findEntry( object), anotherObject, 
				anotherPropertyDescriptor);
	}

	@Override
	public boolean isMany(Object object) {
		return valueItemPropertyDescriptor.isMany(findEntry( object));
	}

	@Override
	public boolean isMultiLine(Object object) {
		return valueItemPropertyDescriptor.isMultiLine(findEntry( object));
	}

	@Override
	public boolean isPropertySet(Object object) {
		return valueItemPropertyDescriptor.isPropertySet(findEntry( object));
	}

	@Override
	public boolean isSortChoices(Object object) {
		return valueItemPropertyDescriptor.isSortChoices(findEntry( object));
	}

	@Override
	public void resetPropertyValue(Object object) {
		valueItemPropertyDescriptor.resetPropertyValue(findEntry( object));
	}

	@Override
	public void setPropertyValue(Object object, Object value) {
		Entry<String,String> entry = findEntry( object);
		valueItemPropertyDescriptor.setPropertyValue(entry, value);
	}

	public boolean isBoolean(){
		return attributeDefinition.getType()== AttributeDefinition.BOOLEAN;
	}
	/**
	 * Find the entry in the GenericEvent with a key name associated with 
	 * @param value
	 * @return entry associated with the GenericEvent
	 */
	public Entry<String, String> findEntry(Object value){
		GenericEvent ge = (GenericEvent)value;
		for (Entry<String, String> entry : ge.getEventAttributes()) {
			if(entry.getKey().equals(attributeDefinition.getName())){
				return entry;
			}
		}
		return null;//No attributes in the genericEvent with the name of this attributeDefinition
	}
	
	public String validate(String value){
		return attributeDefinition.validate(value);
	}
}
