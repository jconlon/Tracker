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
package com.verticon.tracker.editor.presentation;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Event;
import com.verticon.tracker.editor.util.TrackerEditorUtils;

/**
 * Wizard for updating one or more events.
 * Pages:
 * 1. Select the attribute types to update
 * 2. Set the values of the attributes to update
 * 
 * @author jconlon
 *
 */
public class ModifyEventsWizard extends Wizard {

	private static final String MODIFY_ATTRIBUTES = "ModifyAttributes";
	private static final String MODIFY_EVENTS_WIZARD = "ModifyEventsWizard";
	private Collection<Event> eventsToModify;
    private EditingDomain editingDomain;
    private SelectEventAttributesWizardPage selectEventAttributesWizardPage;
    private SelectModifyEventsValuesPage selectModifyEventsValuesPage;
    private IWorkbenchWindow workbenchWindow;
    
    
	public ModifyEventsWizard() {
		IDialogSettings trackerSettings = 
			TrackerReportEditorPlugin.getPlugin().getDialogSettings();
		IDialogSettings wizardSettings =
				trackerSettings.getSection(MODIFY_EVENTS_WIZARD);
		if(wizardSettings==null){
			wizardSettings = 
				trackerSettings.addNewSection(MODIFY_EVENTS_WIZARD);
		}
		setDialogSettings(wizardSettings);
		
	}

	public void init(IWorkbenchWindow workbenchWindow, EditingDomain editingDomain,
			ISelection selection){
		this.workbenchWindow=workbenchWindow;
		eventsToModify = TrackerEditorUtils.getSelectedEvents(selection);
		this.editingDomain=editingDomain;
	}
	
	@Override
	public boolean needsProgressMonitor() {
		return true;
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_ATTRIBUTES);
		selectEventAttributesWizardPage = new SelectEventAttributesWizardPage();
		addPage(selectEventAttributesWizardPage);
		selectModifyEventsValuesPage = new SelectModifyEventsValuesPage();
     	addPage(selectModifyEventsValuesPage);
	}

	@Override
	public boolean performFinish() {
		final Map<EAttribute, Object> changesToMake = 
			selectModifyEventsValuesPage.getChangesToMakeOnSelectedEvents();
		String attWording = changesToMake.size()==1?" attribute ": " attributes ";
		final String eventWording = eventsToModify.size()==1?" event.": " events.";
		try {
			getContainer().run(false, false, new IRunnableWithProgress(){

				@Override
				public void run(final IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					 try {
						monitor.beginTask(
								"Modifying "+eventsToModify.size()+' '+eventWording+"..",
								eventsToModify.size());
						
						for (Event event : eventsToModify) {
							CompoundCommand command = createCommand(changesToMake, event);	
							editingDomain.getCommandStack().execute(
									command);
							monitor.worked(1);	
						}
						
					} finally {
						monitor.done();
					}
				}
				
			});
		} catch (Exception e) {
			MessageDialog.openError(workbenchWindow.getShell(), 
					"Modified Events Failed", "Failed to modify events because: " + e);
			return false;
		}

		MessageDialog.openInformation(workbenchWindow.getShell(), 
				"Modified Events", "Modified "+changesToMake.size()+
				attWording+
				"on "+
				eventsToModify.size()+eventWording);
		return true;
	}
	

	private CompoundCommand createCommand(Map<EAttribute, Object> changesToMake,
			 Event event) {
		CompoundCommand compoundCommand = new CompoundCommand();
		Command command;
		for(Map.Entry<EAttribute, Object> entry :changesToMake.entrySet()){
			command = SetCommand.create(
					editingDomain, //Domain
					 event, //Owner
					 entry.getKey(), //Feature
					 entry.getValue()//value
			);
			if(command !=null){
				compoundCommand.append(command);
			}
		}
		return compoundCommand;
	}
	
	/**
	 * Return the currently selected attributes.
	 */
	public Collection<EAttribute> getSelectionAttributes() {
		return selectEventAttributesWizardPage.getSelectedAttributes();
	} 

	
}
