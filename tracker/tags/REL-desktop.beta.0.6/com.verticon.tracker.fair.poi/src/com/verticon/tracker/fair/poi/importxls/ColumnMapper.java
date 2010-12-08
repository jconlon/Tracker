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
package com.verticon.tracker.fair.poi.importxls;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.verticon.tracker.fair.FairPackage;

public class ColumnMapper extends AbstractModelObject {
	
	private final short index;
	private final String columnName;
	private EStructuralFeature feature = FairPackage.Literals.FAIR__NAME;

	public ColumnMapper(short index, String columnName) {
		super();
		this.index = index;
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public void setFeature(EStructuralFeature feature) {
		EStructuralFeature oldValue = this.feature;
		this.feature = feature;
		firePropertyChange("feature", oldValue, feature);
	}

	public short getIndex() {
		return index;
	}
	
}

//Minimal JavaBeans support
 abstract class AbstractModelObject {
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName,
				listener);
	}

	@SuppressWarnings("ucd")
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@SuppressWarnings("ucd")
	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}

	@SuppressWarnings("ucd")
	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue,
				newValue);
	}
}