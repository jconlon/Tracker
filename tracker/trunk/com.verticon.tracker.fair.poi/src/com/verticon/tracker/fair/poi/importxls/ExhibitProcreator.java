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

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;

/**
 * @author jconlon
 * 
 */
class ExhibitProcreator implements ExecutableProcreator {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ExhibitProcreator.class);

	private Exception exception = null;
	
	/**
	 * Reference to the Set of {@link Department}s keyed by the parent {@link Division} .
	 * These are new Departments that will be created when the {@link #execute(EditingDomain)}
	 * is called.
	 */
	private final Map <Lot, Set<Exhibit>> childrenAddedToFairParents = 
		new HashMap<Lot, Set<Exhibit>>();
	
	private int totalChildrenAdded = 0;
	
	private  CompoundCommand localCompoundCommand = null;

	private final Procreator child;

	protected ExhibitProcreator(Procreator child) {
		super();
		this.child = child;
	}

	public void prepare(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain) throws MissingCriticalDataException {
		
		if(localCompoundCommand == null){
			localCompoundCommand = new CompoundCommand();
		}
		try{
			process( fair,  row,
					listColumnMapper,  parent,
					newParent,  editingDomain, localCompoundCommand);
		} catch (MissingCriticalDataException e) {
			this.exception =e;
			throw e;
		}
	}

	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean parentWasCreated, EditingDomain editingDomain, CompoundCommand commoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Lot)) {
			throw new IllegalArgumentException("Parent should be a Lot");
		}
		Lot lot = (Lot) parent;		
//		String exhibitName = ExecutableProcreators.getCriticalValue(row,
//				FairPackage.Literals.EXHIBIT__NAME, listColumnMapper);
		
		String personName = PersonProcreator.getName(row, listColumnMapper);
		
		String animalId = ExecutableProcreators.getValue(row,
				TrackerPackage.Literals.ANIMAL__ID, listColumnMapper);

		//All exhibits are uniquely identified by a row,
		//there will be one and only one per spreadsheet row in the fair
		//that matches this person and animal combination 
		Exhibit exhibit = cachedInstance(personName, lot);
		
		// If the parent was created, than the exhibit must be created.
		// Create the exhibit directly on the parent
		if (parentWasCreated && exhibit==null) {
				exhibit = newInstance(listColumnMapper, row);
				lot.getExhibits().add(exhibit);
			
			// If the parent was found than search for the exhibit in the 
			// given parent.
			// Then if it is not found create with a AddCommmand
		} else if (!parentWasCreated && exhibit==null){
			exhibit = getElementFromFair(lot, personName, animalId);
			
			if (exhibit != null) {// exhibit is in the fair
				logger.info(bundleMarker,"Row={} Department {} is already in Fair.",
						row.getRowNum(), personName);
				 child.process(fair, row, listColumnMapper, exhibit,
						false, editingDomain,  commoundCommand);
			} else {// Exhibit is not in the fair, Create it.
				exhibit = createExhibit(listColumnMapper, row, lot, editingDomain, commoundCommand);
				logger.info(bundleMarker,
						"Row={} added a command to create Exhibit for {}.",
						row.getRowNum(), personName);
			}
		} else{
			logger.info(bundleMarker,"Row={} found previously created Department {}.", row
					.getRowNum(), personName);
		}
		child.process(fair, row, listColumnMapper, exhibit,
				true, editingDomain,  commoundCommand);
	}

	/**
	 * Execute the prepared Command on the editing Domain.
	 * @throws IllegalStateException if this method was called before the {@link #prepare(Fair, HSSFRow, List, EObject, boolean, EditingDomain)}
	 */
	public void execute() {
		if(localCompoundCommand==null){
			throw new IllegalStateException("process method must be called first.");
		}
		
		localCompoundCommand.execute();
	}

	public String getStatus() {
		 return exception!=null? exception.getMessage():
			 totalChildrenAdded + " exhibits, " + child.getStatus();
	}

	public void dispose() {
		logger.debug(bundleMarker,"Disposing");
		childrenAddedToFairParents.clear();
		child.dispose();
	}

	public Exception getError() {
		return exception;
	}
	
	/**
	 * 
	 * @param lot
	 * @param person
	 * @param animalId
	 * @return exhibit
	 */
	private Exhibit getElementFromFair(Lot lot,
			String person, String animalId) {
		// Is the named Department already in the fair?
		Exhibit result = null;
		for (Exhibit exhibitInFair : lot.getExhibits()) {
			if ((equalsAnimal(animalId, exhibitInFair)) || (equalsPerson( person,  exhibitInFair))) {
				result = exhibitInFair;
			}
		}
		
		
		return result;
	}

	/**
	 * @param animalId
	 * @param exhibitInFair
	 * @return
	 */
	private boolean equalsAnimal(String animalId, Exhibit exhibitInFair) {
		return exhibitInFair.getAnimal() !=null && exhibitInFair.getAnimal().getId().equals(animalId);
	}
	
	/**
	 * @param person
	 * @param exhibitInFair
	 * @return
	 */
	private boolean equalsPerson(String person, Exhibit exhibitInFair) {		return exhibitInFair.getExhibitor() !=null && exhibitInFair.getExhibitor().getName().equals(person);
	}

	/**
	 * The Department was not found in the Fair, so this method finds one that
	 * was already created as part of this import task or creates a new command
	 * for one.
	 * 
	 * @param row
	 * @param nameOfElement
	 */
	private Exhibit createExhibit(List<ColumnMapper> listColumnMapper,
			HSSFRow row, Lot owner, 
			EditingDomain editingDomain, CompoundCommand compoundCommand) {
		Exhibit exhibit  = newInstance(listColumnMapper, row);

		Command command = AddCommand.create(editingDomain, // domain
				owner,// owner
				FairPackage.Literals.LOT__EXHIBITS,// feature
				exhibit// value
				);
		compoundCommand.append(command);
		if(!childrenAddedToFairParents.containsKey(owner)){
			Set<Exhibit> setOfDepartments = new HashSet<Exhibit>();
			childrenAddedToFairParents.put(owner,setOfDepartments);
		}
		childrenAddedToFairParents.get(owner).add(exhibit);

		
		
		return exhibit;
	}

	/**
	 * Children are created under two conditions. 
	 * When there is a created parent and when there is an
	 * existing parent in the Fair.
	 * 
	 * In the case of the created Parent the Element is just created 
	 * and then added Directly to the parent.  When the parent is added to the 
	 * Fair with an AddCommand the Department will be part of the transaction.
	 * 
	 * In the case of a existing Parent in the Fair, the Element
	 * must be created with a AddCommand after the processing of rows.
	 * 
	 * @param nameOfElement
	 * @param department
	 * @return
	 */
	private Exhibit cachedInstance(String personName,
			Lot lot) {
		Exhibit results = null;
		//directly added
		for (Exhibit addedElement : lot.getExhibits()) {
			if (addedElement.getName().equals(personName)) {
				results = addedElement;
			}
		}
		//command added in the future
		if(results==null && childrenAddedToFairParents.containsKey(lot)){
			for (Exhibit dep : childrenAddedToFairParents.get(lot)) {
				if(dep.getName().equals(personName)){
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
	private Exhibit newInstance(List<ColumnMapper> listColumnMapper,
			HSSFRow row) {
		Exhibit department = FairFactory.eINSTANCE.createExhibit();
		
		String comments = ExecutableProcreators.getValue(row,
				FairPackage.Literals.EXHIBIT__COMMENTS, listColumnMapper);
	
		department.setComments(comments);
		totalChildrenAdded++;
		return department;
	}

}
