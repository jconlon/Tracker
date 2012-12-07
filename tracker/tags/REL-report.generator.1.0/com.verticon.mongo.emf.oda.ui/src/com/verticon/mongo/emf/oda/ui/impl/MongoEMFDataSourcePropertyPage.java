package com.verticon.mongo.emf.oda.ui.impl;

import java.util.Properties;

import org.eclipse.datatools.connectivity.oda.design.DataSourceDesign;
import org.eclipse.datatools.connectivity.oda.design.ui.wizards.DataSourceEditorPage;
import org.eclipse.swt.widgets.Composite;

public class MongoEMFDataSourcePropertyPage extends DataSourceEditorPage {

	private DataSourcePageHelper pageHelper = null;

	  public MongoEMFDataSourcePropertyPage()
	  {
	    super();

	    setMessage(DataSourcePageHelper.DEFAULT_MESSAGE);
	  }

	  @Override
	  public Properties collectCustomProperties(Properties profileProperties)
	  {
	    if (pageHelper == null)
	    {
	      return profileProperties;
	    }

	    return pageHelper.collectCustomProperties(profileProperties);
	  }

	  /**
	   * Returns the data source being edited by this property page.
	   */
	  DataSourceDesign getCurrentDataSource()
	  {
	    return getEditingDataSource();
	  }

	  @Override
	  protected void createAndInitCustomControl(Composite parent, Properties profileProperties)
	  {
	    if (pageHelper == null)
	    {
	      pageHelper = createDataSourcePageHelper();
	    }

	    pageHelper.createCustomControl(parent);
	    pageHelper.initCustomControl(profileProperties);
	  }

	  /**
	   * Instantiates the page helper that provides core implementation
	   * of this property page.
	   */
	  protected DataSourcePageHelper createDataSourcePageHelper()
	  {
	    return new DataSourcePageHelper(this);
	  }

	  /**
	   * Returns the page helper that provides core implementation
	   * for this property page.
	   */
	  protected DataSourcePageHelper getPageHelper()
	  {
	    return pageHelper;
	  }

	  @Override
	  protected void refresh(Properties customConnectionProperties)
	  {
	    if (pageHelper != null)
	    {
	      pageHelper.initCustomControl(customConnectionProperties);
	    }

	    // enable/disable all controls on page in respect of the editable session state
	    enableAllControls(getControl(), isSessionEditable());
	  }

}
