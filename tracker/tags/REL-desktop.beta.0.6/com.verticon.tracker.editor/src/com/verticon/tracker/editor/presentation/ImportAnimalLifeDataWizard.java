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
package com.verticon.tracker.editor.presentation;
import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;

/**
 * 
 * Wizard for importing a text file with comma separated animal life data values
 * into a premises document as animals with attributes. New animals are created
 * if they do not previously exist.
 * <ul>
 * <li>Page to prompts user to map the text file columns to Animal attributes
 * described as EMF Features.</li>
 * <li>Page to prompt user to select the animal datatime or the values in the
 * text file that map to datatime.</li>
 * </ul>
 * 
 * This wizard is similar to the ImportFairExhibitDataWizard which:
 * <ul>
 * <li>Prompt for mapping spreadsheet column names to Fair and Tracker Features</li>
 * <li>Prompt for Lot.</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class ImportAnimalLifeDataWizard extends Wizard {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportAnimalLifeDataWizard.class);


	@Override
	public String toString() {
		return "ImportAnimalLifeDataWizard [premises name=" + premises.getName() + "]";
	}

	private static final String MODIFY_WIZARD_TITLE = "Add Animals with Life Data To Premises";
	private IEditorPart editor;
	private Premises premises;
	private File file;
	
	private int importedAnimals = 0;
	private EditingDomain editingDomain;
	private ImportLifeDataColumnMappingWizardPage importDataColumnMappingWizardPage;
	private ImportSpeciesColumnMappingWizardPage importSpeciesColumnMappingWizardPage;

	private IRunnableWithProgress getRunnable(final ImportAnimalLifeData p) {
		return new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				importedAnimals=0;
				int fileSize = importSpeciesColumnMappingWizardPage.getCsvFileLineNumber()-1;
				importedAnimals = 0;
				monitor.beginTask("Importing file...", fileSize + fileSize);
				CompoundCommand command;
				try {
					command = p.createCommand(monitor);
				} catch (IOException e) {
					throw new InvocationTargetException(e);
				}
				
				editingDomain.getCommandStack().execute(command);

				importedAnimals=command.getCommandList().size();

			}
		};
	}

	

	public void init(IEditorPart editor, EditingDomain editingDomain,
			Premises premises, ISelection activeMenuSelection) {
		this.editor = editor;
		this.premises = premises;
		this.file = getSelectedResource(activeMenuSelection);
		this.editingDomain = editingDomain;
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean canFinish() {
		return importDataColumnMappingWizardPage.isPageComplete()
				&& importSpeciesColumnMappingWizardPage.isPageComplete();
	}

	/**
	 * Parse the data line by line. Animals are only created if they do not
	 * already exist in the premises.
	 * 
	 * Use the two maps to
	 * 
	 */
	
	public boolean performFinish() {

		ImportAnimalLifeData p = new ImportAnimalLifeData(premises, file, editingDomain,
				importDataColumnMappingWizardPage.getFileColumnToFeatureMap(),
				importSpeciesColumnMappingWizardPage.getSpeciesNamesMap(),
				getSpeciesColumnIndex());

		IRunnableWithProgress op = new WorkspaceModifyDelegatingOperation(
				getRunnable(p));

		try {
			getContainer().run(false, true, op);
				int fileSize = importSpeciesColumnMappingWizardPage.getCsvFileLineNumber()-1;
				String message = "Imported " + importedAnimals + " animals from "
						+ file + " with " +(fileSize - importedAnimals)+ " defered.";
				logger.info(bundleMarker, "{} : "+message,this);

				MessageDialog.openInformation(editor.getSite().getShell(),
						"Life Data Import", message);
				return true;

		} catch (InvocationTargetException e) {
			importSpeciesColumnMappingWizardPage.setErrorMessage("Life Data Import Error. "
					+ e.getMessage());
			logger.error(this+" : Life data import error.",e);
		} catch (InterruptedException e) {
			// Restore the interrupted status
			Thread.currentThread().interrupt();
		}
		return false;
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		importDataColumnMappingWizardPage = new ImportLifeDataColumnMappingWizardPage();
		addPage(importDataColumnMappingWizardPage);
		importSpeciesColumnMappingWizardPage = new ImportSpeciesColumnMappingWizardPage();
		addPage(importSpeciesColumnMappingWizardPage);
	}

	public Premises getPremises() {
		return premises;
	}

	File getFileToImport() {
		return file;
	}

	private static File getSelectedResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IResource resource = (IResource) ((IStructuredSelection) selection)
					.getFirstElement();
			return new File(resource.getLocationURI());
		}
		return null;
	}

	int getSpeciesColumnIndex() {
		return importDataColumnMappingWizardPage.getSpeciesColumnIndex();
	}

}
