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
package com.verticon.tracker.reader.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import com.verticon.tracker.reader.wizards.AddEventReaderWizard;


/**
 * @author jconlon
 *
 */
class AddReaderAction extends Action {

	private ReaderViewPart view;
	private ReaderViewer viewer;

	   protected AddReaderAction(ReaderViewPart view, String text, ReaderViewer viewer) {
	      super(text);
	      this.view = view;
	      this.viewer = viewer;
	   }
	   
	   public void run() {
			IWorkbenchWindow window = view.getSite().getWorkbenchWindow();
			AddEventReaderWizard addWizard = new AddEventReaderWizard(viewer.getReaderViewModel());
			try {
				addWizard.init(window.getWorkbench());
				WizardDialog dialog = new WizardDialog(window.getShell(),addWizard);
				dialog.open();
			} catch (PartInitException e) {
				ErrorDialog.openError(window.getShell(), "Can not add a Reader", //$NON-NLS-1$
						null, // no special message
						((PartInitException) e).getStatus());
			}
			
		}
}
