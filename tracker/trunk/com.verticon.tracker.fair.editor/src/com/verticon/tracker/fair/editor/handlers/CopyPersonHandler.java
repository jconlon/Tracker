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
package com.verticon.tracker.fair.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

public class CopyPersonHandler extends AbstractHandler implements IHandler {

	/**
	 * Needs a IEditingDomainProvider and a selected Person.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editorPart
		
		.getAdapter(IPremisesProvider.class);
		if ((selection instanceof IStructuredSelection) && (!selection.isEmpty()) ){
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
			Person person = (Person)structuredSelection.getFirstElement();
			Person cloned;
			if(person instanceof YoungPerson){
				 cloned = FairFactory.eINSTANCE.createYoungPerson();
				 ((YoungPerson)cloned).setClub(((YoungPerson) person).getClub());
				 ((YoungPerson)cloned).getParents().addAll((((YoungPerson) person).getParents()));
			}else{
				 cloned = FairFactory.eINSTANCE.createPerson();
			}
			cloned.setCity(person.getCity());
			cloned.setComments(person.getComments());
			cloned.setEmail(person.getEmail());
			cloned.setFirstName("NewName");
			cloned.setLastName(person.getLastName());
			cloned.setPhone(person.getPhone());
			cloned.setPin(person.getPin());
			cloned.setState(person.getState());
			cloned.setStreet(person.getStreet());
			cloned.setZipCode(person.getZipCode());
			Command command = AddCommand.create(
					editingDomain, 
					person.eContainer(), 
					FairPackage.Literals.FAIR__PEOPLE, 
					cloned);
			try {
				editingDomain.getCommandStack().execute(command);
				editorPart.setFocus();
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Copy Person",
						"Created a new Person for family "+cloned.getLastName());
				
			} catch (RuntimeException e) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event),
						"Copy Person Failed",
						"Failed to copy Person because: " + e);
				return false;
			}
		}
		
		return null;
	}

	

}
