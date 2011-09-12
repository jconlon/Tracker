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
package com.verticon.tracker.irouter.monitor.view.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

/**
 * @author dejan
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class WiredNodeDetailsPage implements IDetailsPage {
	private IManagedForm mform;
	private final WiredNode wiredNode;
	private final StatusMonitor statusMonitor;
	private Section propertiesSection;
	private Section variablesSection;
	
	public WiredNodeDetailsPage(WiredNode pid) {
		this.wiredNode=pid;
		this.statusMonitor = new StatusMonitor(wiredNode);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#initialize(org.eclipse.ui.forms.IManagedForm)
	 */
	public void initialize(IManagedForm mform) {
		this.mform = mform;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	public void createContents(Composite parent) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		parent.setLayout(layout);

		FormToolkit toolkit = mform.getToolkit();
		//Properties Section
		propertiesSection = toolkit.createSection(
				parent, Section.DESCRIPTION|Section.TITLE_BAR|Section.TWISTIE|Section.EXPANDED);
		Composite sectionClient = createBundlePropertiesSection(parent,
				toolkit, propertiesSection);
		propertiesSection.setClient(sectionClient);
		
		//Status Variables Section
		variablesSection = toolkit.createSection(
				parent, Section.DESCRIPTION|Section.TITLE_BAR|Section.TWISTIE|Section.EXPANDED);
		Composite variablesSectionClient = createVariablesSection(parent,
				toolkit, variablesSection);
		variablesSection.setClient(variablesSectionClient);
		
	}
	private Composite createBundlePropertiesSection(Composite parent,
			FormToolkit toolkit, Section section) {
		
		section.marginWidth = 10;
		
		TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);
		section.setText("Service Property Details");
		section.setDescription("Details of the selected "+(wiredNode instanceof ProducerWiredNode?"Producer":"Consumer")+" service");
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(3, false));
		
		//Pid
		Label l = toolkit.createLabel(sectionClient, "Process ID:");
		l.setToolTipText("ID of the iRouter component process that registered this service");
		Text tPid = toolkit.createText(sectionClient, wiredNode.getPid(), SWT.READ_ONLY);
		tPid.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
	
		//Service Type
		l=toolkit.createLabel(sectionClient, "Service Type:");
		l.setToolTipText("Producer or Consumer of wired products");
		Text tServiceType = toolkit.createText(sectionClient, wiredNode instanceof ProducerWiredNode?"Producer":"Consumer", SWT.READ_ONLY);
		tServiceType.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		
		//Service ID
		l=toolkit.createLabel(sectionClient, "Service ID:");
		l.setToolTipText("Identification assigned to this service");
		Text tService = toolkit.createText(sectionClient, Long.toString(wiredNode.getService_id()), SWT.READ_ONLY);
		tService.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		
		//Wire Group
		l=toolkit.createLabel(sectionClient, "Wire Group:");
		l.setToolTipText("Group name for enabling wiring connections between Producer and Consumer services with matching product scopes");
		Text tWireGroup = toolkit.createText(sectionClient, wiredNode.getGroup(), SWT.READ_ONLY);
		tWireGroup.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		
		//Scope
		l=toolkit.createLabel(sectionClient, "Product Scope:");
		l.setToolTipText("Names of products, produced or consumed by this service");
		Text tScope = toolkit.createText(sectionClient, wiredNode.getScope(), SWT.READ_ONLY);
		tScope.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		
	
		return sectionClient;
	}
	
	private Composite createVariablesSection(Composite parent,
			FormToolkit toolkit, Section section) {
		
		section.marginWidth = 10;
		
		TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);
		section.setText("Status Variables");
		section.setDescription("Status of the selected "+(wiredNode instanceof ProducerWiredNode?"Producer":"Consumer")+" service");
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(3, false));
		
		//Refresh button
		Button b = toolkit.createButton(sectionClient, "Refresh Status Variables", SWT.PUSH);
		b.setToolTipText("Polls service for latest status");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.DEFAULT, true, false, 3,
				1));

		statusMonitor.initialize(sectionClient, toolkit, mform, b);
		
		b.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					update();
				} catch (Exception e1) {
					Status status = new Status(IStatus.ERROR, Component.PLUGIN_ID, 0,
				            "MonitorAdmin Error Message", null);

			        ErrorDialog.openError(Display.getCurrent().getActiveShell(),
			        	e1.getMessage(),
			            "Failed to obtain response from the Monitorable service. Is the service still active?",  
			            status);
			      
				}
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				update();
				
			}});
		
	
		return sectionClient;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#inputChanged(org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#commit()
	 */
	public void commit(boolean onSave) {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#setFocus()
	 */
	public void setFocus() {
		variablesSection.setFocus();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#dispose()
	 */
	public void dispose() {
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#isDirty()
	 */
	public boolean isDirty() {
		return false;
	}
	public boolean isStale() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#refresh()
	 */
	public void refresh() {
		update();
	}
	
	public boolean setFormInput(Object input) {
		return false;
	}
	
	private void update(){
		statusMonitor.update();
	}
}
