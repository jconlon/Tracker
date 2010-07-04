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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 * 
 */
class ClassProcreator implements Procreator {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ClassProcreator.class);

	/**
	 * Reference to the Set of com.verticon.tracker.fair.Class s keyed by the
	 * parent {@link Department} . These are new Departments that will be
	 * created when the {@link #execute(EditingDomain)} is called.
	 */
	private final Map<Department, Set<com.verticon.tracker.fair.Class>> childrenAddedToFairParents = new HashMap<Department, Set<com.verticon.tracker.fair.Class>>();

	private int totalChildrenAdded = 0;

	private final Procreator child;

	protected ClassProcreator(Procreator child) {
		super();
		this.child = child;
	}

	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean parentWasCreated, EditingDomain editingDomain,
			CompoundCommand compoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Department)) {
			throw new IllegalArgumentException("Parent should be a Department");
		}
		

		Department department = (Department) parent;
		String className = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.CLASS__NAME, listColumnMapper);

		com.verticon.tracker.fair.Class clazz = cachedInstance(
				className, department);

		// If the parent was created than create the class directly on the
		// parent
		if (parentWasCreated && clazz == null) {
			clazz = newInstance(listColumnMapper, row, className);
			department.getClasses().add(clazz);

			// If the parent was found than search for the clazz and create it
			// if it was not found
		} else if (!parentWasCreated && clazz == null) {
			clazz = fairInstance(department, className);
			if (clazz != null) {// Clazz is in the fair
				logger.info(bundleMarker,"Row={} Class {} already in Fair.",
						row.getRowNum(), className);
				child.process(fair, row, listColumnMapper, clazz, false,
						editingDomain, compoundCommand);
			} else {// Division is not in the fair.
				clazz = newInstance(listColumnMapper, row, department,
						className, editingDomain, compoundCommand);
			}
		} else {
			logger.info(bundleMarker,"Row={} found previously created Class {}.", row
					.getRowNum(), className);
		}

		child.process(fair, row, listColumnMapper, clazz, true, editingDomain,
				compoundCommand);
	}

	public String getStatus() {
		return totalChildrenAdded + " classes, " + child.getStatus();
	}

	public void dispose() {
		childrenAddedToFairParents.clear();
		child.dispose();
	}

	/**
	 * @param department
	 * @param departmentName
	 * @return
	 */
	private com.verticon.tracker.fair.Class fairInstance(
			Department department, String clazzName) {
		// Is the named Class already in the fair?
		com.verticon.tracker.fair.Class clazz = null;
		for (com.verticon.tracker.fair.Class clazzInFair : department
				.getClasses()) {
			if (clazzInFair.getName().equals(clazzName)) {
				clazz = clazzInFair;
			}
		}
		return clazz;
	}

	/**
	 * The com.verticon.tracker.fair.Class was not found in the Fair, so this
	 * method finds one that was already created as part of this import task or
	 * creates a new command for one.
	 * 
	 * @param row
	 * @param nameOfElement
	 */
	private com.verticon.tracker.fair.Class newInstance(
			List<ColumnMapper> listColumnMapper, HSSFRow row, Department owner,
			String nameOfElement, EditingDomain editingDomain,
			CompoundCommand compoundCommand) {

		com.verticon.tracker.fair.Class clazz = newInstance(listColumnMapper,
				row, nameOfElement);

		Command command = AddCommand.create(editingDomain, // domain
				owner,// owner
				FairPackage.Literals.DEPARTMENT__CLASSES,// feature
				clazz// value
				);
		compoundCommand.append(command);
		if (!childrenAddedToFairParents.containsKey(owner)) {
			Set<com.verticon.tracker.fair.Class> setOfClazzes = new HashSet<com.verticon.tracker.fair.Class>();
			childrenAddedToFairParents.put(owner, setOfClazzes);
		}
		childrenAddedToFairParents.get(owner).add(clazz);

		logger.info(bundleMarker,"Row={} added a command to create Class {}.", row
				.getRowNum(), nameOfElement);
		return clazz;
	}

	/**
	 * Children are created under two conditions. When there is a created
	 * Department parent and when there is an existing Department parent in the
	 * Fair.
	 * 
	 * In the case of the created Department Parent the Class is just created
	 * and then added Directly to Department. When the Department is added to
	 * the Fair with an AddCommand the Class will be part of the transaction.
	 * 
	 * In the case of a existing Department Parent in the Fair, the Class must
	 * be created with a AddCommand after the processing of rows.
	 * 
	 * @param nameOfElement
	 * @param department
	 * @return
	 */
	private com.verticon.tracker.fair.Class cachedInstance(
			String nameOfElement, Department department) {
		com.verticon.tracker.fair.Class results = null;
		// directly added
		for (com.verticon.tracker.fair.Class addedClass : department
				.getClasses()) {
			if (addedClass.getName().equals(nameOfElement)) {
				results = addedClass;
			}
		}
		// tobe added in the future
		if (results == null
				&& childrenAddedToFairParents.containsKey(department)) {
			for (com.verticon.tracker.fair.Class dep : childrenAddedToFairParents
					.get(department)) {
				if (dep.getName().equals(nameOfElement)) {
					results = dep;
				}
			}
		}
		return results;
	}

	/**
	 * @param listColumnMapper
	 * @param row
	 * @param nameOfElement
	 * @return
	 */
	private com.verticon.tracker.fair.Class newInstance(
			List<ColumnMapper> listColumnMapper, HSSFRow row,
			String nameOfElement) {
		
		com.verticon.tracker.fair.Class clazz = FairFactory.eINSTANCE.createClass();
		clazz.setName(nameOfElement);
		clazz.setDescription(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.CLASS__DESCRIPTION, listColumnMapper));
		clazz.setComments(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.CLASS__COMMENTS, listColumnMapper));
		totalChildrenAdded++;
		return clazz;
	}
}
