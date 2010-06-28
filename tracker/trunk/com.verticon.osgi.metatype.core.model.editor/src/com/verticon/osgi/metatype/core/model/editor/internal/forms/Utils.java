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
package com.verticon.osgi.metatype.core.model.editor.internal.forms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetaData;

public class Utils {

	public static final String PLUGIN_ID = "com.verticon.osgi.metatype.core.model.editor";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	private Utils() {
		throw new AssertionError("Don't instantiate this class.");
	}

	static List<Designate> getTemplateChildren(Designate designate) {
		if (!Utils.isTemplate(designate)) {
			return Collections.emptyList();
		}
		// This is a parent find the children
		String bundle = designate.getBundle().substring(1,
				designate.getBundle().length() - 1);
		MetaData metadata = (MetaData) designate.eContainer();
		List<Designate> children = new ArrayList<Designate>();
		for (Designate des : metadata.getDesignate()) {
			if (des.getBundle() != null && des.getBundle().equals(bundle)) {
				children.add(des);
			}
		}
		return children;
	}

	static boolean isTemplate(Designate designate) {
		return designate.getBundle() != null
				&& designate.getBundle().startsWith("[");
	}

	static Designate getTemplateParent(Designate designate) {
		if (isTemplate(designate)) {
			return null;
		}
		// This is a instance find the parent
		MetaData metadata = (MetaData) designate.eContainer();
		if(metadata==null){
			return null;
		}
		for (Designate des : metadata.getDesignate()) {
			if (des.getBundle() != null
					&& des.getBundle().startsWith('[' + designate.getBundle())) {
				return des;
			}
		}
		return null;
	}

	static String getDescription(Designate designate, MetaData metaData) throws ConfigurationException {
		ObjectClassDefinition ocd = Utils.getOCD(designate, metaData);
		return ocd.getDescription();
	}

	static String getName(Designate designate, MetaData metaData) throws ConfigurationException {
		ObjectClassDefinition ocd = Utils.getOCD(designate, metaData);
		return ocd.getName();
	}

	static ObjectClassDefinition getOCD(Designate designate, MetaData metaData) throws ConfigurationException {
		
        if(designate == null){
        	throw new ConfigurationException("Designate is null");
        }
        if(designate.getFactoryPid() == null && designate.getPid()==null){
        	throw new ConfigurationException("Designate must have a FactoryPid or a Pid");
        }
		return metaData.getObjectClassDefinition(
				designate.getFactoryPid() != null ? designate.getFactoryPid()
						: designate.getPid(), null);
	}

	/**
	 * In a master detail scenario there's a problem when the validation status
	 * of a binding is not OK and you change the master selection (See bug
	 * 278301)
	 * 
	 * @param ctx
	 *            the databinding context
	 * @param master
	 *            the observable master
	 */
	public static void masterDetailFixup(final DataBindingContext ctx,
			IObservableValue master) {
		final AggregateValidationStatus s = new AggregateValidationStatus(ctx,
				AggregateValidationStatus.MAX_SEVERITY);
	
		master.addChangeListener(new IChangeListener() {
	
			public void handleChange(ChangeEvent event) {
				IStatus status = (IStatus) s.getValue();
				if (status != null && !status.isOK()) {
					ctx.updateTargets();
				}
			}
		});
	}

	static MetaData getMetaData(EditingDomain ed){
		for( Iterator<Object> iter = EcoreUtil.getAllContents(
				ed.getResourceSet(), true); iter.hasNext();){
			Object eObject = iter.next();
			if(eObject instanceof MetaData){
				return (MetaData)eObject;
			}
		}
		return null;
	}
	
	

}
