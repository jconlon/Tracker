/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import com.verticon.tracker.Event;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.ConsoleUtil;
import com.verticon.tracker.editor.util.Constants;

/**
 * Wizard for updating one or more events.
 * 
 * Pages:
 * 1. Select the attribute types to update
 * 2. Set the values of the attributes to update
 * 
 * @author jconlon
 *
 */
public class ModifyEventsWizard extends Wizard {

	private static final String MODIFY_ATTRIBUTES = "ModifyAttributes";
	public static final String MODIFY_EVENTS_WIZARD = "ModifyEventsWizard";
	private Collection<Event> eventsToModify;
    private EditingDomain editingDomain;
    private SelectEventAttributesWizardPage selectEventAttributesWizardPage;
    private SelectModifyEventsValuesPage selectModifyEventsValuesPage;
    
    
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

	public void init(EditingDomain editingDomain,IStructuredSelection selection){
		eventsToModify = ActionUtils.getSelectedEvents(selection);
		this.editingDomain=editingDomain;
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
		Map<EAttribute, Object> changesToMake = selectModifyEventsValuesPage.getChangesToMakeOnSelectedEvents();
		
		try {
			editingDomain.getCommandStack().execute(createCommand(changesToMake));
			String attWording = changesToMake.size()==1?" attribute ": " attributes ";
			String eventWording = eventsToModify.size()==1?" event.": " events.";
			log("Modified "+changesToMake.size()+
					attWording+
					"on "+
					eventsToModify.size()+eventWording);
			
		} catch (RuntimeException e) {
			log("Failed to modify events because: " + e);
			return false;
		}
		
		return true;
	}
	
	private Command createCommand(Map<EAttribute, Object> changesToMake){
		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;
		for (Event event : eventsToModify) {
			for(EAttribute attribute :changesToMake.keySet()){
				command = SetCommand.create(
						editingDomain, //Domain
						 event, //Owner
						 attribute, //Feature
						 changesToMake.get(attribute)//value
				);
				if(command !=null){
					compoundCommand.append(command);
				}
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

	public static void log(String msg) {
		ConsoleUtil.println(Constants.CONSOLE, new Date()+"\t"+msg);
	}
}
