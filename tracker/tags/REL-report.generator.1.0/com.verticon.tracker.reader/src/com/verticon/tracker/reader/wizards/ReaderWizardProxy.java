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
/**
 * 
 */
package com.verticon.tracker.reader.wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderWizard;

/**
 * @author jconlon
 *
 */
class ReaderWizardProxy implements IReaderWizard {

	private static final String ATT_CLASS = "class";
	private static final String ELM_DESCRIPTION = "description";
	private static final String ATT_NAME = "name";
	private static final String ATT_ID = "id";
	private IConfigurationElement configElement;
	
	private String description;
	private String name;
	private String id;
	
	private IReaderWizard delegate = null;
	
	
	protected ReaderWizardProxy(IConfigurationElement configElm) {
		super();
		this.configElement = configElm;
		this.id = getAttribute(configElm, ATT_ID, null);
		this.name = getAttribute(configElm, ATT_NAME, id);
		this.description = getDescription( configElm);
//		getAttribute(configElm, ATT_CLASS, null);//REMOVE
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.reader.IReaderWizard#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	
	public String getNameOfCreatedReader() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.reader.IReaderWizard#getReader()
	 */
	public IReader getReader() {
		if(delegate!=null){
			return delegate.getReader();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if(delegate==null){
			try {
				delegate = (IReaderWizard)configElement.createExecutableExtension(ATT_CLASS);
//				System.out.println("Created "+delegate);
			} catch (CoreException e) {
				 
			      String msg =
			         "Failed to load wizard named "
			            + name
			            + " in "
			            + configElement.getDeclaringExtension().getContributor().getName();
			      /**
				 * slf4j Logger
				 */
				Logger logger = LoggerFactory
						.getLogger(ReaderWizardProxy.class);
			      logger.error(msg, e);
			      return;
			}
		}
		delegate.init(workbench, selection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		if(delegate==null){
			return;
		}
		delegate.addPages();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#canFinish()
	 */
	public boolean canFinish() {
		if(delegate==null){
			return false;
		}
		return delegate.canFinish();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#createPageControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createPageControls(Composite pageContainer) {
		if(delegate==null){
			return ;
		}
	   delegate.createPageControls( pageContainer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#dispose()
	 */
	public void dispose() {
		if(delegate==null){
			return ;
		}
	   delegate.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getContainer()
	 */
	public IWizardContainer getContainer() {
		if(delegate==null){
			return null;
		}
	   return delegate.getContainer();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getDefaultPageImage()
	 */
	public Image getDefaultPageImage() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getDefaultPageImage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getDialogSettings()
	 */
	public IDialogSettings getDialogSettings() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getDialogSettings();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	public IWizardPage getNextPage(IWizardPage page) {
		if(delegate==null){
			return null ;
		}
	   return delegate.getNextPage(page);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getPage(java.lang.String)
	 */
	public IWizardPage getPage(String pageName) {
		if(delegate==null){
			return null ;
		}
	   return delegate.getPage(pageName);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getPageCount()
	 */
	public int getPageCount() {
		if(delegate==null){
			return 0 ;
		}
	   return delegate.getPageCount();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getPages()
	 */
	public IWizardPage[] getPages() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getPages();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getPreviousPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	public IWizardPage getPreviousPage(IWizardPage page) {
		if(delegate==null){
			return null ;
		}
	   return delegate.getPreviousPage(page);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getStartingPage()
	 */
	public IWizardPage getStartingPage() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getStartingPage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getTitleBarColor()
	 */
	public RGB getTitleBarColor() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getTitleBarColor();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#getWindowTitle()
	 */
	public String getWindowTitle() {
		if(delegate==null){
			return null ;
		}
	   return delegate.getWindowTitle();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#isHelpAvailable()
	 */
	public boolean isHelpAvailable() {
		if(delegate==null){
			return false ;
		}
	   return delegate.isHelpAvailable();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#needsPreviousAndNextButtons()
	 */
	public boolean needsPreviousAndNextButtons() {
		if(delegate==null){
			return false ;
		}
	   return delegate.needsPreviousAndNextButtons();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#needsProgressMonitor()
	 */
	public boolean needsProgressMonitor() {
		if(delegate==null){
			return false ;
		}
	   return delegate.needsProgressMonitor();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#performCancel()
	 */
	public boolean performCancel() {
		if(delegate==null){
			return false ;
		}
	   return delegate.performCancel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		if(delegate==null){
			return false ;
		}
	   return delegate.performFinish();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#setContainer(org.eclipse.jface.wizard.IWizardContainer)
	 */
	public void setContainer(IWizardContainer wizardContainer) {
		if(delegate==null){
			return  ;
		}
	    delegate.setContainer(wizardContainer);
	}

	private static String getDescription(IConfigurationElement configElm){
		IConfigurationElement[] elm = configElm.getChildren(ELM_DESCRIPTION);
		IConfigurationElement configElmDescription = elm[0];
		return configElmDescription.getValue();
	}
	 static String getAttribute(IConfigurationElement configElm, String name, String defaultValue){
		String value = configElm.getAttribute(name);
		if(value !=null){
			return value;
		}
		
		if (defaultValue !=null){
			return defaultValue;
		}
		throw new IllegalArgumentException("Missing " + name+ " attribute");
	}
}
