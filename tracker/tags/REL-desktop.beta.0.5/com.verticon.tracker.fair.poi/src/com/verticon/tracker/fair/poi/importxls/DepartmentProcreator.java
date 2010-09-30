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
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 * 
 */
class DepartmentProcreator implements Procreator {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DepartmentProcreator.class);

	
	/**
	 * Reference to the Set of {@link Department}s keyed by the parent {@link Division} .
	 * These are new Departments that will be created when the {@link #execute(EditingDomain)}
	 * is called.
	 */
	private final Map <Division, Set<Department>> childrenAddedToFairParents = 
		new HashMap<Division, Set<Department>>();
	
	private int totalChildrenAdded = 0;

	private final Procreator child;

	protected DepartmentProcreator(Procreator child) {
		super();
		this.child = child;
	}

	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean parentWasCreated, EditingDomain editingDomain, CompoundCommand compoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Division)) {
			throw new IllegalArgumentException("Parent should be a Division");
		}
		

		Division division = (Division) parent;
		String departmentName = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.DEPARTMENT__NAME, listColumnMapper);
		
	
		Department department = cachedInstance(departmentName, division);
		
		// If the parent was created than create the department directly on the
		// parent
		if (parentWasCreated && department==null) {
				department = newInstance(listColumnMapper, row, departmentName);
				division.getDepartments().add(department);
			
			// If the parent was found than search for the department and create
			// it if it was not found
		} else if (!parentWasCreated && department==null){
			department = fairInstance(division, departmentName);
			
			if (department != null) {// department is in the fair
				logger.info(bundleMarker,"Row={} Department {} is already in Fair.",
						row.getRowNum(), departmentName);
				 child.process(fair, row, listColumnMapper, department,
						false, editingDomain,  compoundCommand);
			} else {// Division is in the fair, but the department is not in the
					// fair. Create it.
				department = newInstance(listColumnMapper, row, division,
						departmentName, editingDomain,  compoundCommand);
			}
		} else{
			logger.info(bundleMarker,"Row={} found previously created Department {}.", row
					.getRowNum(), departmentName);
		}

		 child.process(fair, row, listColumnMapper, department,
				true, editingDomain,  compoundCommand);
	}

	

	public String getStatus() {
		return totalChildrenAdded + " departments, " + child.getStatus();
	}

	public void dispose() {
		logger.debug(bundleMarker,"Disposing");
		childrenAddedToFairParents.clear();
		child.dispose();
	}

	/**
	 * @param division
	 * @param departmentName
	 * @return
	 */
	private Department fairInstance(Division division,
			String departmentName) {
		// Is the named Department already in the fair?
		Department department = null;
		for (Department departmentInFair : division.getDepartments()) {
			if (departmentInFair.getName().equals(departmentName)) {
				department = departmentInFair;
			}
		}
		return department;
	}
	
	/**
	 * The Department was not found in the Fair, so this method finds one that
	 * was already created as part of this import task or creates a new command
	 * for one.
	 * 
	 * @param row
	 * @param nameOfElement
	 */
	private Department newInstance(List<ColumnMapper> listColumnMapper,
			HSSFRow row, Division owner, String nameOfElement,
			EditingDomain editingDomain, CompoundCommand compoundCommand) {
		Department department  = newInstance(listColumnMapper, row, nameOfElement);

		Command command = AddCommand.create(editingDomain, // domain
				owner,// owner
				FairPackage.Literals.DIVISION__DEPARTMENTS,// feature
				department// value
				);
		compoundCommand.append(command);
		if(!childrenAddedToFairParents.containsKey(owner)){
			Set<Department> setOfDepartments = new HashSet<Department>();
			childrenAddedToFairParents.put(owner,setOfDepartments);
		}
		childrenAddedToFairParents.get(owner).add(department);

		logger.info(bundleMarker,
				"Row={} added a command to create Department {}.",
				row.getRowNum(), nameOfElement);
		
		return department;
	}

	/**
	 * Children are created under two conditions. 
	 * When there is a created Division parent and when there is an
	 * existing Division parent in the Fair.
	 * 
	 * In the case of the created Division Parent the Department is just created 
	 * and then added Directly to Division.  When the division is added to the 
	 * Fair with an AddCommand the Department will be part of the transaction.
	 * 
	 * In the case of a existing Division Parent in the Fair, the Department
	 * must be created with a AddCommand after the processing of rows.
	 * 
	 * @param nameOfElement
	 * @param department
	 * @return
	 */
	private Department cachedInstance(String nameOfElement,
			Division division) {
		Department results = null;
		//directly added
		for (Department addedDivision : division.getDepartments()) {
			if (addedDivision.getName().equals(nameOfElement)) {
				results = addedDivision;
			}
		}
		//tobe added in the future
		if(results==null && childrenAddedToFairParents.containsKey(division)){
			for (Department dep : childrenAddedToFairParents.get(division)) {
				if(dep.getName().equals(nameOfElement)){
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
	private Department newInstance(List<ColumnMapper> listColumnMapper,
			HSSFRow row, String nameOfElement) {
		
		Department department = FairFactory.eINSTANCE.createDepartment();
		department.setName(nameOfElement);
		department.setComments(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.DEPARTMENT__COMMENTS, listColumnMapper));
		department.setDescription(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.DEPARTMENT__DESCRIPTION, listColumnMapper));
		totalChildrenAdded++;
		return department;
	}

}
