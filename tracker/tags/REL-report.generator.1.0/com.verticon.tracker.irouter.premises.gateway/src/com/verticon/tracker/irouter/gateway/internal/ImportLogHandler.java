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
package com.verticon.tracker.irouter.gateway.internal;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.IPremisesProvider;


/**
 * 
 * Handler for Importing Animal Events from CSV Logs.
 * Ticket#501
 * 
 * This class is working but the wizard it calls is 
 * not finished.  
 * @author jconlon
 *
 */
public class ImportLogHandler extends AbstractHandler{
	
	@Override
	public String toString() {
		return "ImportLogHandler []";
	}


	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		Premises premises = ((IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class)).getPremises();
		EditingDomain editingDomain = 
			((IEditingDomainProvider)editorPart.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		
		File file = getSelectedResource(HandlerUtil.getActiveMenuSelection(event));
		ImportLogAsEventDataJob job = new ImportLogAsEventDataJob(
				premises, 
				file, 
				editingDomain,
				HandlerUtil.getActiveWorkbenchWindow(event).getShell().getDisplay()
		);
		job.setPriority(Job.INTERACTIVE);
	    job.setUser(true);

		job.schedule();
		try {
			job.join();
			IStatus status = job.getStatus();
			if(status.isOK()){
				MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), 
						"Import of Log Events Completed", 
						"Imported "+job.getAffectedObjects()+ 
						" and deferred "+job.getDefered()+" events, from "+file+
						" Check log for details.");
			}else{
				ErrorDialog.openError(
						HandlerUtil.getActiveShell(event), 
						"Import of Log Events Failed", 
						"Failed to import "+file+" Check log for details.", 
						status);
			}
		} catch (InterruptedException e) {
			
		}

		return null;
	}
	
	
	private static File getSelectedResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection)
					.getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}
}
