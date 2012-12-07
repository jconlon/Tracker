/**
 * <copyright>
 *
 * Copyright (c) 2010 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   Kenn Hussey - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EcoreDataSourceWizardPage.java,v 1.1 2010/12/05 01:42:01 khussey Exp $
 */
package com.verticon.mongo.emf.oda.ui.impl;

import java.util.Properties;

import org.eclipse.datatools.connectivity.oda.design.ui.wizards.DataSourceWizardPage;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.widgets.Composite;

import com.verticon.mongo.emf.oda.ui.MongoEMFUIPlugin;


/**
 * Wizard page for an Ecore data source.
 */
public class MongoEMFDataSourceWizardPage extends DataSourceWizardPage
{
  protected DataSourcePageHelper pageHelper = null;
  protected Properties properties = null;

  public MongoEMFDataSourceWizardPage(String pageName)
  {
    super(pageName);
    setMessage(DataSourcePageHelper.DEFAULT_MESSAGE);
    setImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(MongoEMFUIPlugin.INSTANCE.getImage("full/wizban/NewEcore"))); //$NON-NLS-1$
  }

  @Override
  public void createPageCustomControl(Composite parent)
  {
    if (pageHelper == null)
    {
      pageHelper = new DataSourcePageHelper(this);
    }

    pageHelper.createCustomControl(parent);
    pageHelper.initCustomControl(properties); // in case init was called before create 
  }

  @Override
  public void setInitialProperties(Properties dataSourceProperties)
  {
    properties = dataSourceProperties;

    if (pageHelper == null)
    {
      return; // ignore, wait until createPageCustomControl to initialize
    }

    pageHelper.initCustomControl(properties);
  }

  @Override
  public Properties collectCustomProperties()
  {
    if (pageHelper != null)
    {
      return pageHelper.collectCustomProperties(properties);
    }

    return (properties != null) ? properties : new Properties();
  }
}
