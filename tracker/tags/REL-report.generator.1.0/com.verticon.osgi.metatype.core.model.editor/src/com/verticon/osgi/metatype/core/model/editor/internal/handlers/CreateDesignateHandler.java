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
package com.verticon.osgi.metatype.core.model.editor.internal.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.service.metatype.AttributeDefinition;

import com.verticon.osgi.metatype.Attribute;
import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypeFactory;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils;

/**
 * Creates a Designate that is compatable with a selected OCD element.
 * @author jconlon
 *
 */
public class CreateDesignateHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event)
			throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editorPart
				.getAdapter(IEditingDomainProvider.class);

		if (selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) selection).getFirstElement();
			if (o instanceof Designate) {
				Designate ocd = (Designate) o;
				try {
					createDesignate(editingDomainProvider.getEditingDomain(), ocd);
				} catch (IOException e) {
					Status status = new Status(IStatus.ERROR, 
							Utils.PLUGIN_ID, 
				            "Problem with the selected designate.", e);

				        // Display the dialog
				   ErrorDialog.openError(
						   HandlerUtil.getActiveShell(event),
				           "Copy Designate Error", 
				           "Could not copy a designate.", 
				           status);
				        
					
							
					throw new ExecutionException("Failed to create a Designate Element.",e);
				}
			}
		}
		return null;
	}


	public static void createDesignate(EditingDomain domain, Designate designateTemplate) throws IOException {
		MetaData owner = (MetaData) designateTemplate.eContainer();
		
		Designate designate = (Designate)EcoreUtil.copy(designateTemplate);
		String bundleLocation = designate.getBundle();
		if(!(bundleLocation.startsWith("[") && bundleLocation.endsWith("]")) ){
			throw new IOException("Selected Designate bundle value does not indicate that it is a template.");
		}
		designate.setBundle(bundleLocation.substring(1,bundleLocation.length()-1));
		designate.setFactoryPid(designate.getPid());
		designate.setPid(null);
		
		String ocdRef = designate.getObject().getOcdref();
		if(ocdRef==null){
			throw new IOException("Template Designate did not reference a valid OCD.");
		}
		OCD ocd = null;
		for (OCD ocdTmp : owner.getOCD()) {
			if(ocdRef.equals(ocdTmp.getID())){
				ocd = ocdTmp;
				break;
			}
		}
		if(ocd==null){
			throw new IOException("Designate did not reference a valid OCD. Validate document.");
		}
		for (AttributeDefinition attributeDefinition : ocd
				.getAttributeDefinitions(OCD.ALL)) {
			Attribute attribute = MetatypeFactory.eINSTANCE.createAttribute();
			attribute.setAdref(attributeDefinition.getID());
			//Some attributeDefinintion may not have defaults. Check for this first.
			if(attributeDefinition.getDefaultValue()!=null){
				for (String value : attributeDefinition.getDefaultValue()) {
					attribute.getValue().add(value);
				}
			}
			designate.getObject().getAttribute().add(attribute);
		}

		Command command = AddCommand.create(domain, owner,
				MetatypePackage.eINSTANCE.getMetaData_Designate(), designate);

		domain.getCommandStack().execute(command);
	}

	
}
