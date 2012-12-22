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
 * $Id: EcoreDataSourcePageHelper.java,v 1.1 2010/12/05 01:42:01 khussey Exp $
 */
package com.verticon.mongo.emf.oda.ui.impl;

import java.util.Properties;

import org.eclipse.emf.oda.ecore.util.StringUtil;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.mongodb.MongoURI;
import com.verticon.mongo.emf.api.MongoURIBuilder;
import com.verticon.mongo.emf.api.MongoUtils;
import com.verticon.mongo.emf.oda.impl.MongoEMFConnection;
import com.verticon.mongo.emf.oda.ui.MongoEMFUIPlugin;

/**
 * A helper for Ecore data source property and wizard pages.
 */
public class DataSourcePageHelper {
	protected static String DEFAULT_MESSAGE = MongoEMFUIPlugin.INSTANCE
			.getString("_UI_DefaultDataSource_message"); //$NON-NLS-1$

	protected MongoEMFDataSourceWizardPage wizardPage = null;
	protected MongoEMFDataSourcePropertyPage propertyPage = null;

	protected Text hostNameField = null;

	protected Text portField = null;

	protected Text userNameField = null;

	protected Text passWordField = null;

	protected Text databaseField = null;

	protected DataSourcePageHelper(MongoEMFDataSourceWizardPage page) {
		super();

		assert (page != null);

		wizardPage = page;
	}

	protected DataSourcePageHelper(MongoEMFDataSourcePropertyPage page) {
		super();

		assert (page != null);

		propertyPage = page;
	}

	/**
	 * Returns the value of the resource property.
	 * 
	 * @return the resource
	 */
	protected String getHostName() {
		return hostNameField == null ? null : hostNameField.getText();
	}

	protected String getPort() {
		return portField == null ? null : portField.getText();
	}

	protected String getUserName() {
		return userNameField == null ? null : userNameField.getText();
	}

	protected String getPassword() {
		return passWordField == null ? null : passWordField.getText();
	}

	protected String getDatabase() {
		return databaseField == null ? null : databaseField.getText();
	}

	/**
	 * Creates custom page control for user-defined data sources.
	 */
	protected void createCustomControl(Composite grandParent) {
		Composite parent = new Composite(grandParent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(composite);

		createHostNameControl(composite);
		createPortControl(composite);
		createDatabaseControl(composite);
		createUserNameControl(composite);
		createPasswordControl(composite);
		setPageComplete(false);
	}

	private void createHostNameControl(Composite composite) {
		Label resourceLabel = new Label(composite, SWT.NONE);
		resourceLabel.setText(MongoEMFUIPlugin.INSTANCE
				.getString("_UI_HostName_label")); //$NON-NLS-1$

		hostNameField = new Text(composite, SWT.BORDER);
		hostNameField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent me) {
				validateData();
			}
		});

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(hostNameField);
	}

	private void createPortControl(Composite composite) {
		Label resourceLabel = new Label(composite, SWT.NONE);
		resourceLabel.setText(MongoEMFUIPlugin.INSTANCE
				.getString("_UI_Port_label")); //$NON-NLS-1$

		portField = new Text(composite, SWT.BORDER);
		portField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent me) {
				validateData();
			}
		});

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(portField);
	}

	private void createDatabaseControl(Composite composite) {
		Label resourceLabel = new Label(composite, SWT.NONE);
		resourceLabel.setText(MongoEMFUIPlugin.INSTANCE
				.getString("_UI_Database_label")); //$NON-NLS-1$

		databaseField = new Text(composite, SWT.BORDER);
		databaseField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent me) {
				validateData();
			}
		});

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(databaseField);
	}

	private void createUserNameControl(Composite composite) {
		Label resourceLabel = new Label(composite, SWT.NONE);
		resourceLabel.setText(MongoEMFUIPlugin.INSTANCE
				.getString("_UI_UserName_label")); //$NON-NLS-1$

		userNameField = new Text(composite, SWT.BORDER);
		userNameField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent me) {
				validateData();
			}
		});

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(userNameField);
	}

	private void createPasswordControl(Composite composite) {
		Label resourceLabel = new Label(composite, SWT.NONE);
		resourceLabel.setText(MongoEMFUIPlugin.INSTANCE
				.getString("_UI_Password_label")); //$NON-NLS-1$

		passWordField = new Text(composite, SWT.BORDER);
		passWordField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent me) {
				validateData();
			}
		});

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(passWordField);
	}

	/**
	 * Initializes the custom control with the specified properties.
	 */
	protected void initCustomControl(Properties properties) {
		if (properties == null) {
			return; // nothing to initialize
		}

		String hostname = properties
				.getProperty(MongoEMFConnection.HOST_PROPERTY_NAME);

		if (!StringUtil.isEmpty(hostname)) {
			// initialize context type
			hostNameField.setText(hostname);
		}

		//
		String port = properties
				.getProperty(MongoEMFConnection.PORT_PROPERTY_NAME);

		if (!StringUtil.isEmpty(port)) {
			// initialize context type
			portField.setText(port);
		}
		//
		String database = properties
				.getProperty(MongoEMFConnection.DB_PROPERTY_NAME);

		if (!StringUtil.isEmpty(database)) {
			// initialize context type
			databaseField.setText(database);
		}

		//
		String userName = properties
				.getProperty(MongoEMFConnection.DB_USER_NAME);

		if (!StringUtil.isEmpty(userName)) {
			// initialize context type
			userNameField.setText(userName);
		}
		//
		String passWord = properties
				.getProperty(MongoEMFConnection.DB_PASSWORD_NAME);

		if (!StringUtil.isEmpty(passWord)) {
			// initialize context type
			passWordField.setText(passWord);
		}


		validateData();
	}

	/**
	 * Collects the values of the specified properties.
	 */
	protected Properties collectCustomProperties(Properties properties) {
		if (properties == null) {
			properties = new Properties();
		}

		String hostName = getHostName();

		if (!StringUtil.isEmpty(hostName)) {
			properties.setProperty(MongoEMFConnection.HOST_PROPERTY_NAME,
					hostName);
		}

		String port = getPort();

		if (!StringUtil.isEmpty(port)) {
			properties.setProperty(MongoEMFConnection.PORT_PROPERTY_NAME, port);
		}

		String database = getDatabase();

		if (!StringUtil.isEmpty(database)) {
			properties.setProperty(MongoEMFConnection.DB_PROPERTY_NAME,
					database);
		}

		String userName = getUserName();

		if (!StringUtil.isEmpty(userName)) {
			properties.setProperty(MongoEMFConnection.DB_USER_NAME, userName);
		}

		String passWord = getPassword();

		if (!StringUtil.isEmpty(passWord)) {
			properties.setProperty(MongoEMFConnection.DB_PASSWORD_NAME,
					passWord);
		}

		return properties;
	}

	/**
	 * Validates that the user has specified values for the properties in the
	 * page control and sets page message accordingly.
	 */
	protected void validateData() {
		setPageComplete(false);
		this.setMessage(null, 0);
		String hostname = getHostName();
		boolean isValid = !StringUtil.isEmpty(hostname);
		if (isValid) {
			String database = getDatabase();
			isValid = !StringUtil.isEmpty(database);
			if (isValid) {
				String port = getPort();
				if (!StringUtil.isEmpty(port)) {
					try {
						Integer.parseInt(port);
						try {
							MongoURI mongoURI = new MongoURIBuilder()
									.host(hostname).port(port).db(database)
									.build();
							MongoUtils.getEMFBaseURI(mongoURI);
							setMessage(DEFAULT_MESSAGE, IMessageProvider.NONE);
							isValid = true;
						} catch (Exception e) {
							setMessage(e.getLocalizedMessage(),
									IMessageProvider.ERROR);
							isValid = false;
						}
					} catch (NumberFormatException e) {
						setMessage(
								MongoEMFUIPlugin.INSTANCE
										.getString("_UI_PortMustBeNumber_message"), IMessageProvider.ERROR); //$NON-NLS-1$
						isValid = false;
					}

				}
			} else {
				setMessage(
						MongoEMFUIPlugin.INSTANCE
								.getString("_UI_DatabaseCannotBeEmpty_message"), IMessageProvider.ERROR); //$NON-NLS-1$
			}
		} else {
			setMessage(
					MongoEMFUIPlugin.INSTANCE
							.getString("_UI_HostNameCannotBeEmpty_message"), IMessageProvider.ERROR); //$NON-NLS-1$

		}
		setPageComplete(isValid);
		return;

	}

	/**
	 * Returns the page for this helper.
	 */
	protected Control getControl() {
		if (wizardPage != null) {
			return wizardPage.getControl();
		} else if (propertyPage != null) {
			return propertyPage.getControl();
		}

		return null;
	}

	/**
	 * Sets whether the page for this helps is complete.
	 */
	protected void setPageComplete(boolean complete) {
		if (wizardPage != null) {
			wizardPage.setPageComplete(complete);
		} else if (propertyPage != null) {
			propertyPage.setValid(complete);
		}
	}

	/**
	 * Sets the message for this helper's page.
	 */
	protected void setMessage(String newMessage, int newType) {
		if (wizardPage != null) {
			wizardPage.setMessage(newMessage, newType);
		} else if (propertyPage != null) {
			propertyPage.setMessage(newMessage, newType);
		}
	}
}