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
package com.verticon.tracker.reader.wizards;

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;

public class ReaderFactoryProxy implements IReaderFactory {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ReaderFactoryProxy.class);
	
	private static final String FACTORY_CLASS= "factory";
	private static final String ATT_NAME = "name";
	
	private IConfigurationElement configElement;
	private String name;
	private String factory;
	private IReaderFactory delegate = null;
	
	public ReaderFactoryProxy(IConfigurationElement configElm) {
		super();
		this.configElement = configElm;
		this.factory = ReaderWizardProxy.getAttribute(configElm, FACTORY_CLASS, null);
		this.name = ReaderWizardProxy.getAttribute(configElm, ATT_NAME, null);
	}

	public IReader instance(String name, String type, String template,
			URI target) {
		if(delegate ==null){
			try {
				delegate = (IReaderFactory)configElement.createExecutableExtension(FACTORY_CLASS);
				
			} catch (CoreException e) {
				 
			      String msg =
			         "Failed to load factory named "
			            + factory
			            + " in "
			            + configElement.getDeclaringExtension().getContributor().getName();
			      logger.error(msg, e);
			      return null;
			}
		}
		return delegate.instance(name, type, template, target);
	}

	public boolean isSupportedType(String type) {
		return name.equals(type);
	}

}
