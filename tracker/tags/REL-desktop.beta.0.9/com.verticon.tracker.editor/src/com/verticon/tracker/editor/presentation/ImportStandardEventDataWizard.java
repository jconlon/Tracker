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

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.ImportStandardEventColumnMappingWizardPage.ColumnMapper;

/**
 * 
 * FIXME Ticket#501 Needs ThirdPage and perform finish methods
 * 
 * Wizard for importing a log file with comma separated animal event data values
 * into a premises document as animal events with attributes. New animals are NOT created
 * if they do not previously exist.
 * <ul>
 * <li>Page to prompt user to select the animal standard events that will be mapped.
 *  from the log text file.</li>
 *  <li>Page to prompt user to select the animal generic events that will be mapped.
 *  from the log text file.</li>
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
public class ImportStandardEventDataWizard extends Wizard {

	/**
	 * slf4j Logger
	 */
//	private final Logger logger = LoggerFactory
//			.getLogger(ImportStandardEventDataWizard.class);


	@Override
	public String toString() {
		return "ImportStandardEventDataWizard [premises name=" + premises.getName() + "]";
	}

	private static final String MODIFY_WIZARD_TITLE = "Add Animal Events Data To Premises";
//	private IEditorPart editor;
	private Premises premises;
	private File file;
	
//	private int importedAnimals = 0;
//	private EditingDomain editingDomain;
	private SelectStandardEventFeaturesWizardPage selectEventsWizardPage;
	private ImportStandardEventColumnMappingWizardPage importStandardEventColumnMappingWizardPage;
//	private ImportSpeciesColumnMappingWizardPage importSpeciesColumnMappingWizardPage;

//	//FIXME use something like ImportAnimalLifeData 
//	private IRunnableWithProgress getRunnable(final ImportAnimalLifeData p) {
//		return new IRunnableWithProgress() {
//
//			public void run(IProgressMonitor monitor)
//					throws InvocationTargetException, InterruptedException {
////				importedAnimals=0;
////				int fileSize = importSpeciesColumnMappingWizardPage.getCsvFileLineNumber()-1;
////				importedAnimals = 0;
////				monitor.beginTask("Importing file...", fileSize + fileSize);
////				CompoundCommand command;
////				try {
////					command = p.createCommand(monitor);
////				} catch (IOException e) {
////					throw new InvocationTargetException(e);
////				}
////				
////				editingDomain.getCommandStack().execute(command);
////
////				importedAnimals=command.getCommandList().size();
//
//			}
//		};
//	}

	

	public void init(IEditorPart editor, EditingDomain editingDomain,
			Premises premises, ISelection activeMenuSelection) {
//		this.editor = editor;
		this.premises = premises;
		this.file = getSelectedResource(activeMenuSelection);
//		this.editingDomain = editingDomain;
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean canFinish() {
//		return importStandardEventColumnMappingWizardPage.isPageComplete()
//				&& importSpeciesColumnMappingWizardPage.isPageComplete();
		return true;
	}

	/**
	 * 
	 * @return results of the First WizardPage
	 */
	List<EStructuralFeature> getPageOneSelectedFeatures(){
		return SelectStandardEventFeaturesWizardPage.getNonDerivedFeatures(selectEventsWizardPage.getSelectedEvent());
	}
	
	/**
	 * 
	 * @return results of the Second WizardPage
	 */
	List<ColumnMapper> getPageTwoFeatureMap(){
		return importStandardEventColumnMappingWizardPage.getFileColumnToFeatureMap();
	}
	
	/**
	 * 
	 * @return unMapped Features as input to the Third WizardPage
	 */
	List <EStructuralFeature> getUnmappedFeatures(){
		List<EStructuralFeature> unmappedFeatures = new ArrayList<EStructuralFeature>();
		for (EStructuralFeature selectedFeature : getPageOneSelectedFeatures()) {
			boolean found = false;
			for (ColumnMapper columnMapper : getPageTwoFeatureMap()) {
				if(columnMapper.getFeature()!=null&&columnMapper.getFeature().equals(selectedFeature)){
					if(columnMapper.getColumnName()!=null){
						found=true;
					}
					
					break;
				}
			}
			if(!found){
				unmappedFeatures.add(selectedFeature);
			}
		}
		
		return Collections.unmodifiableList(unmappedFeatures);
	}
	
	/**
	 * Parse the data line by line. Animals are only created if they do not
	 * already exist in the premises.
	 * 
	 * FIXME
	 * 
	 */
	
	public boolean performFinish() {
//		List<EStructuralFeature> selectedFeatures = getSelectedFeatures();
		for (EStructuralFeature feature : getUnmappedFeatures()) {
			System.out.println("unmapped: "+feature.getName());
		}
//		List<ValueMapper> featureMap = importStandardEventColumnMappingWizardPage.getFileColumnToFeatureMap();

		
		
//		ImportStandardEventData p = new ImportStandardEventData(premises, file, editingDomain,
//				importStandardEventColumnMappingWizardPage.getFileColumnToFeatureMap(),
//				importSpeciesColumnMappingWizardPage.getSpeciesNamesMap(),
//				getSpeciesColumnIndex());
//
//		IRunnableWithProgress op = new WorkspaceModifyDelegatingOperation(
//				getRunnable(p));
//
//		try {
//			getContainer().run(false, true, op);
//				int fileSize = importSpeciesColumnMappingWizardPage.getCsvFileLineNumber()-1;
//				String message = "Imported " + importedAnimals + " animals from "
//						+ file + " with " +(fileSize - importedAnimals)+ " defered.";
//				
//
//				MessageDialog.openInformation(editor.getSite().getShell(),
//						"Life Data Import", message);
//				return true;
//
//		} catch (InvocationTargetException e) {
//			importSpeciesColumnMappingWizardPage.setErrorMessage("Life Data Import Error. "
//					+ e.getMessage());
//			logger.error(this+" : Life data import error.",e);
//		} catch (InterruptedException e) {
//			// Restore the interrupted status
//			Thread.currentThread().interrupt();
//		}
		return false;
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		selectEventsWizardPage = new SelectStandardEventFeaturesWizardPage();
		addPage(selectEventsWizardPage);
		importStandardEventColumnMappingWizardPage = new ImportStandardEventColumnMappingWizardPage();
		addPage(importStandardEventColumnMappingWizardPage);
//		importSpeciesColumnMappingWizardPage = new ImportSpeciesColumnMappingWizardPage();
//		addPage(importSpeciesColumnMappingWizardPage);
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

//	int getSpeciesColumnIndex() {
//		return importStandardEventColumnMappingWizardPage.getSpeciesColumnIndex();
//	}

}
