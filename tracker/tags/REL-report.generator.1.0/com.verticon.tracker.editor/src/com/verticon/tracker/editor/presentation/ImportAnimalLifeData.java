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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * Imports a csv file of animal life data into a premises model.
 * 
 * @author jconlon
 * 
 */
public class ImportAnimalLifeData {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ImportAnimalLifeData.class);

	private final Premises premises;
	private final File file;
	private final EditingDomain editingDomain;
	private final List<ImportLifeDataColumnMappingWizardPage.ColumnMapper> fileColumnsToFeatureMap;
	private final Map<String, EClass> speciesMap;
	private final int index;
	private final CompoundCommand compoundCommand = new CompoundCommand();

	ImportAnimalLifeData(Premises premises, File file, EditingDomain editingDomain,
			List<ImportLifeDataColumnMappingWizardPage.ColumnMapper> fileColumnsToFeatureMap,
			Map<String, EClass> speciesMap, int index) {
		super();
		this.premises = premises;
		this.file = file;
		this.editingDomain = editingDomain;
		this.fileColumnsToFeatureMap = fileColumnsToFeatureMap;
		this.speciesMap = speciesMap;
		this.index = index;
	}

	CompoundCommand createCommand(IProgressMonitor monitor) throws IOException {
		BufferedReader csvFile = null;

		try {
			// open file
			FileReader csvFileRead = new FileReader(file);
			csvFile = new BufferedReader(csvFileRead);
			String csvFileLine = "";
			int csvFileLineNumber = 1;

			// go through lines
			while ((csvFileLine = csvFile.readLine()) != null) {
				processLine(csvFileLine, csvFileLineNumber, index);
				// increment line number
				csvFileLineNumber++;
				if (monitor != null) {
					monitor.worked(1);
				}

			}

		} finally {
			// close file
			csvFile.close();
		}
		return compoundCommand;
	}

	/**
	 * Process a line of csv data from the importing file.
	 * 
	 * @param csvFileLine
	 * @param lineNumber
	 * @param index
	 * @throws IOException
	 */
	private void processLine(String csvFileLine, int lineNumber, int index)
			throws IOException {
		String[] details = csvFileLine.split(",");

		// if incorrect format, throw exception
		if (details.length < index) {
			throw new IOException("ERROR: The CSV file is either corrupt "
					+ "or is in an incompatible format. (line #" + lineNumber
					+ "is too short.)");
		}
		EClass eClass = speciesMap.get(details[index].trim());
		Animal eObjectAnimal = (Animal) TrackerFactory.eINSTANCE.create(eClass);
		Tag eObjectTag = TrackerFactory.eINSTANCE.createTag();
		eObjectAnimal.getTags().add(eObjectTag);

		for (int i = 0; i < details.length; i++) {
			String value = details[i].trim();
			if (i != index) {
				EStructuralFeature feature = fileColumnsToFeatureMap.get(i)
						.getFeature();
				if (feature == TrackerPackage.Literals.ANIMAL__ID) {
					eObjectTag.setId(value);
				} else {
					eObjectAnimal.eSet(feature, value);

				}

			}

		}
		// Only add an animal if it does not exist
		for (Animal animal : premises.getAnimals()) {
			if (animal.getId().equals(eObjectAnimal.getId())) {
				logger.warn(bundleMarker,"Deferred adding {} {} because it already is in the premises.", animal.getClass().getSimpleName(), animal.getId());
				return;
			}
		}
		compoundCommand.append(AddCommand.create(editingDomain, premises,
				TrackerPackage.Literals.PREMISES__ANIMALS, eObjectAnimal));
	}

}
