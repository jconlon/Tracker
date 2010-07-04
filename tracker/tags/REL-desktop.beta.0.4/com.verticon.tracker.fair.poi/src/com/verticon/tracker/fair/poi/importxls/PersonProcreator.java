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
package com.verticon.tracker.fair.poi.importxls;
import static com.verticon.tracker.fair.poi.FairPoiPlugin.bundleMarker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;

/**
 * @author jconlon
 * 
 */
class PersonProcreator implements Procreator {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(PersonProcreator.class);

	/**
	 * Reference to the Set of {@link Department}s keyed by the parent
	 * {@link Division} . These are new Departments that will be created when
	 * the {@link #execute(EditingDomain)} is called.
	 */
	private final Set<Person> childrenAddedToFairParents = new HashSet<Person>();

	private int totalChildrenAdded = 0;

	private final Procreator child;

	protected PersonProcreator(Procreator child) {
		super();
		this.child = child;
	}

	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean parentWasCreated, EditingDomain editingDomain,
			CompoundCommand compoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Exhibit)) {
			throw new IllegalArgumentException("Parent should be a Exhibit");
		}

		Exhibit exhibit = (Exhibit) parent;
		String personName = getName(row, listColumnMapper);

		Person person = cachedInstance(personName);

		boolean personWasCreated = false;
		// Fair is the container for the Person.
		if (person == null) {
			person = getElementFromFair(fair, personName);

			if (person != null) {// person is in the fair
				logger.info(bundleMarker,"Row={} person {} is already in Fair.", row
						.getRowNum(), personName);

			} else {// Exhibit is not in the fair, Create it.
				person = newInstance(listColumnMapper, row, fair,
						editingDomain, compoundCommand);
				personWasCreated = true;
				// Maybe a young person or a person
				// associtation this with an exhibit
			}
		} else {
			logger.info(bundleMarker,"Row={} found previously created Person {}.", row
					.getRowNum(), personName);
		}
		if (parentWasCreated) {
			// associate this person with the exhibit
			Command setCommand = SetCommand.create(editingDomain, // domain
					exhibit,// owner
					FairPackage.Literals.EXHIBIT__EXHIBITOR,// feature
					person// value
					);
			compoundCommand.append(setCommand);
		}
		if (child != null) {
			child.process(fair, row, listColumnMapper, person,
					personWasCreated, editingDomain, compoundCommand);
		}
	}

	public String getStatus() {
		StringBuilder sbuilderBuilder = new StringBuilder();
		sbuilderBuilder.append(totalChildrenAdded).append(" people, ").append(
				child == null ? "" : child.getStatus());
		return sbuilderBuilder.toString();
	}

	public void dispose() {
		logger.debug(bundleMarker,"Disposing");
		childrenAddedToFairParents.clear();
		child.dispose();
	}

	/**
	 * @param division
	 * @param personName
	 *            , String animalId
	 * @return
	 */
	private Person getElementFromFair(Fair fair, String personName) {
		Person result = null;
		for (Person personInFair : fair.getPeople()) {
			if (personInFair.getName().equals(personName)) {
				result = personInFair;
			}
		}
		return result;
	}

	/**
	 * Children are created under two conditions. When there is a created parent
	 * and when there is an existing parent in the Fair.
	 * 
	 * In the case of the created Parent the Element is just created and then
	 * added Directly to the parent. When the parent is added to the Fair with
	 * an AddCommand the Department will be part of the transaction.
	 * 
	 * In the case of a existing Parent in the Fair, the Element must be created
	 * with a AddCommand after the processing of rows.
	 * 
	 * @param nameOfElement
	 * @param department
	 * @return
	 */
	private Person cachedInstance(String nameOfElement) {
		Person results = null;

		for (Person addedElement : childrenAddedToFairParents) {
			if (addedElement.getName().equals(nameOfElement)) {
				results = addedElement;
			}
		}

		return results;
	}

	/**
	 * The Department was not found in the Fair, so this method finds one that
	 * was already created as part of this import task or creates a new command
	 * for one.
	 * 
	 * @param row
	 * @param nameOfElement
	 */
	private Person newInstance(List<ColumnMapper> listColumnMapper,
			HSSFRow row, Fair owner, EditingDomain editingDomain,
			CompoundCommand compoundCommand) {
		Person person = newInstance(row, listColumnMapper);

		Command command = AddCommand.create(editingDomain, // domain
				owner,// owner
				FairPackage.Literals.FAIR__PEOPLE,// feature
				person// value
				);
		compoundCommand.append(command);

		if (!childrenAddedToFairParents.contains(person)) {
			childrenAddedToFairParents.add(person);
		}

		logger.info(bundleMarker,"Row={} added a command to create Person {}.", row
				.getRowNum(), person.getName());

		return person;
	}

	/**
	 * 
	 * @param fair
	 * @return person based on row attributes
	 */
	private Person newInstance(HSSFRow row, List<ColumnMapper> listColumnMapper) {
		String parents = null;
		short parentsCellNum = ExecutableProcreators.findColumnNumber(
				FairPackage.Literals.YOUNG_PERSON__PARENTS, listColumnMapper);
		if (parentsCellNum != -1) {
			try {
				HSSFCell cellParents = row.getCell(parentsCellNum);

				switch (cellParents.getCellType()) {
				case HSSFCell.CELL_TYPE_BLANK:

					break;

				case HSSFCell.CELL_TYPE_STRING:
					parents = cellParents.getStringCellValue();
					parents.trim();
					logger.debug(bundleMarker,"Row={} parents are {} ", row.getRowNum(),
							parents);
					break;

				default:
					break;
				}
			} catch (RuntimeException e) {

			}
		}
		Person person = null;
		if (parents == null) {
			person = FairFactory.eINSTANCE.createPerson();
		} else {
			person = FairFactory.eINSTANCE.createYoungPerson();

		}
		populatePersonAttributes(person, row, listColumnMapper);
		totalChildrenAdded++;
		return person;
	}

	/**
	 * The FirstName and LastName cannot have spaces. Replace these with a dash.
	 * 
	 * @param row
	 * @param person
	 */
	private static void populatePersonAttributes(Person person, HSSFRow row,
			List<ColumnMapper> listColumnMapper) {
		for (EStructuralFeature feature : FairPackage.Literals.PERSON
				.getEAllStructuralFeatures()) {
			short cellNum = ExecutableProcreators.findColumnNumber(feature,
					listColumnMapper);
			if (cellNum == -1) {
				continue;
			}
			HSSFCell cell = row.getCell(cellNum);
			if (cell == null) {
				continue;
			}
			String value = null;
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				value = cell.getStringCellValue();
			} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				double num = cell.getNumericCellValue();
				long l = (long) num;
				value = Long.toString(l);
				// value = value.substring(0,value.indexOf('.'));
			}

			if (value != null) {
				if (feature == FairPackage.Literals.PERSON__FIRST_NAME
						|| feature == FairPackage.Literals.PERSON__LAST_NAME) {
					value = value.trim();
					value = value.replace(' ', '-');
					// value = value.replace("//", "/");
					// value = value.replace("//", "/");
					value = value.replace("&", "and");
				}
				// logger.debug(bundleMarker,"Row={} adding attribute={}, value={}",
				// new Object[] {row.getRowNum(), feature.getName(),value});
				if (feature == FairPackage.Literals.PERSON__NAME) {
					person.setLastName(NormalizeName.parseLastName(value));
					person.setFirstName(NormalizeName.parseFirstName(value));
					logger.debug(bundleMarker,"Set person personName {}", person.getName());
				} else if (feature == FairPackage.Literals.PERSON__SALES_ORDER) {
					try {
						person.setSalesOrder(Integer.parseInt(value));
					} catch (NumberFormatException e) {
						logger.error(bundleMarker,"Could not set Person:salesOrder to "
								+ value, e);
					}
				} else if (feature == FairPackage.Literals.PERSON__FIRST_NAME) {
					person
							.setFirstName(NormalizeName
									.capitalizeAndTrimEnglishNames(value
											.toLowerCase()));
				} else if (feature == FairPackage.Literals.PERSON__LAST_NAME) {
					person
							.setLastName(NormalizeName
									.capitalizeAndTrimEnglishNames(value
											.toLowerCase()));
				} else if (feature == FairPackage.Literals.PERSON__EXHIBITOR_NUMBER) {
					try {
						person.setExhibitorNumber(Integer.parseInt(value));
					} catch (NumberFormatException e) {
						logger.error(bundleMarker,"Could not set Person:exhibitorNumber to "
								+ value, e);
					}
				} else {
					person.eSet(feature, value);
				}
			} else {
				logger.debug(bundleMarker,"Row={} had no value for attribute={}", row
						.getRowNum(), feature.getName());
			}
		}
	}

	/**
	 * 
	 * @param row
	 * @param listColumnMapper
	 * @return name as lastName,firstName
	 * @throws MissingCriticalDataException 
	 */
	 static String getName(HSSFRow row,
			List<ColumnMapper> listColumnMapper) throws MissingCriticalDataException {

		String firstName = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.PERSON__FIRST_NAME, listColumnMapper);
		String lastName = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.PERSON__LAST_NAME, listColumnMapper);

		return lastName + ',' + firstName;
	}
}
