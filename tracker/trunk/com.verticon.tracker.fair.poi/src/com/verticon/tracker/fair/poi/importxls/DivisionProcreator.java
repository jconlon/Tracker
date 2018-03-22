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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 * 
 */
class DivisionProcreator implements ExecutableProcreator {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DivisionProcreator.class);

	/**
	 * Reference to the Set of Lots that were created in this import task.
	 */
	private final Set<Division> createdElements = new HashSet<Division>();

	private CompoundCommand localCompoundCommand = null;

	private final Procreator child;
	
	private Exception exception = null;

	protected DivisionProcreator(Procreator child) {
		super();
		this.child = child;
	}

	@Override
	public void prepare(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain) throws MissingCriticalDataException {
		
		if(localCompoundCommand == null){
			localCompoundCommand = new CompoundCommand();
		}
		
		try {
			process( fair,  row,
					listColumnMapper,  parent,
					 newParent,  editingDomain, localCompoundCommand);
		} catch (MissingCriticalDataException e) {
			this.exception =e;
			throw e;
		}
	}

	@Override
	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain, CompoundCommand compoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Fair)) {
			throw new IllegalArgumentException("Parent should be a Fair");
		}
		
		
		String divName = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.DIVISION__NAME, listColumnMapper);

		Division division = fairInstance(fair, divName);

		if (division != null) {
			logger.info(bundleMarker,"Row={} Division {} was already in Fair.", row
					.getRowNum(), divName);
			 child.process(fair, row, listColumnMapper, division,
					false, editingDomain,  compoundCommand);

		} else {// Division is not in the fair.
			division = cachedInstance(row, divName);
			if (division != null) {
				logger.info(bundleMarker,"Row={} found previously created Division {}.", row
						.getRowNum(), divName);
			} else {
				division = newInstance(listColumnMapper, row, fair,
						divName, editingDomain);
				logger.info(bundleMarker,"Row={} added a command to create Division {}.",
						row.getRowNum(), divName);
			}
		}

		 child.process(fair, row, listColumnMapper, division, true,
				editingDomain,  compoundCommand);

	}

	/**
	 * Execute the prepared Command on the editing Domain.
	 * @throws IllegalStateException if this method was called before the {@link #prepare(Fair, HSSFRow, List, EObject, boolean, EditingDomain)}
	 */
	@Override
	public void execute(EditingDomain ed) {
		if(localCompoundCommand==null){
			throw new IllegalStateException("process method must be called first.");
		}
		ed.getCommandStack().execute(localCompoundCommand);
	}

	@Override
	public String getStatus() {
		return exception!=null? exception.getMessage(): createdElements.size() + " divisions, " + child.getStatus();
	}

	@Override
	public void dispose() {
		createdElements.clear();
		child.dispose();
	}
	
	@Override
	public Exception getError() {
		return exception;
	}

	/**
	 * @param fair
	 * @param divName
	 * @return
	 */
	private Division fairInstance(Fair fair, String divName) {
		// Is the named Division already in the fair?
		Division division = null;
		for (Division divisionInFair : fair.getDivisions()) {
			if (divisionInFair.getName().equals(divName)) {
				division = divisionInFair;
			}
		}
		return division;
	}

	/**
	 * The Division was not found in the Fair, so this method finds one that was
	 * already created as part of this import task or creates a new command for
	 * one.
	 * 
	 * @param row
	 * @param nameOfElement
	 */
	private Division newInstance(List<ColumnMapper> listColumnMapper,
			HSSFRow row, Fair fair, String nameOfElement,
			EditingDomain editingDomain) {
		
		Division division = FairFactory.eINSTANCE.createDivision();
		division.setName(nameOfElement);
		division.setDescription(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.DIVISION__DESCRIPTION, listColumnMapper));
		division.setComments(
				ExecutableProcreators.getValue(row,
				FairPackage.Literals.DIVISION__COMMENTS, listColumnMapper));

		Command command = AddCommand.create(editingDomain, // domain
				fair,// owner
				FairPackage.Literals.FAIR__DIVISIONS,// feature
				division// value
				);
		localCompoundCommand.append(command);

		createdElements.add(division);
		return division;
	}

	/**
	 * @param row
	 * @param nameOfElement
	 * @param division
	 */
	private Division cachedInstance(HSSFRow row,
			String nameOfElement) {
		Division results = null;
		for (Division addedDivision : createdElements) {
			if (addedDivision.getName().equals(nameOfElement)) {
				results = addedDivision;
			}
		}
		return results;
	}

	


	
}
