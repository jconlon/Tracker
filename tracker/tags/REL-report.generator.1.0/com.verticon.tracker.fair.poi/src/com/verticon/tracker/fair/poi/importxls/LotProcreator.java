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

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;

/**
 * @author jconlon
 *
 */
class LotProcreator implements Procreator {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(LotProcreator.class);
	
	
	/**
	 * Reference to the Set of {@linkplain Lot}s keyed by the
	 * parent {@link com.verticon.tracker.fair.Class} . These are new Lots that will be
	 * created when the {@link #execute(EditingDomain)} is called.
	 */
	private final Map<com.verticon.tracker.fair.Class, Set<Lot>> childrenAddedToFairParents = 
		new HashMap<com.verticon.tracker.fair.Class, Set<Lot>>();

	private int totalChildrenAdded = 0;
	
	private final Procreator child;

	protected LotProcreator(Procreator child) {
		super();
		this.child = child;
	}

	/**
	 * Create a lot and return it.  It will already in the fair or will be 
	 * added to the fair with an AddCommand.
	 * @throws MissingCriticalDataException 
	 */
	public void process(
			Fair fair, HSSFRow row, List<ColumnMapper> listColumnMapper, EObject parent, 
			boolean parentWasCreated,EditingDomain editingDomain, CompoundCommand compoundCommand) throws MissingCriticalDataException {
		
		assert parent instanceof com.verticon.tracker.fair.Class;
		
		if (!(parent instanceof com.verticon.tracker.fair.Class)) {
			throw new IllegalArgumentException("Parent should be a Class");
		}
		
		
		com.verticon.tracker.fair.Class clazz = (com.verticon.tracker.fair.Class)parent;
		String lotName = ExecutableProcreators.getCriticalValue(row, FairPackage.Literals.LOT__NAME, listColumnMapper);
		
		Lot lot = cachedInstance(lotName, clazz);
		
		//If the parent is new don't check the fair
		if(parentWasCreated && lot == null){
			lot = newInstance(listColumnMapper, row, lotName);
			clazz.getLots().add(lot);
			
			
		}else  if (!parentWasCreated && lot == null){
		    lot = fairInstance(clazz,lotName);
			if(lot != null){
				logger.info(bundleMarker,"Row={} Lot already in Fair with name {}.",
						row.getRowNum(),lotName);
				 child.process(fair, row, listColumnMapper, lot,
							false, editingDomain,  compoundCommand);
			}else{
				lot = newInstance(  listColumnMapper, row, clazz, lotName, editingDomain,compoundCommand);
			}
		}else{
			logger.info(bundleMarker,"Row={} found previously created Department {}.", row
					.getRowNum(), lotName);
		}
		
		 child.process(fair, row, listColumnMapper, lot,
					true, editingDomain,  compoundCommand);
		
	}
	
	public String getStatus() {
		return totalChildrenAdded+" lots, " + child.getStatus();
	}
	
	public void dispose(){
		childrenAddedToFairParents.clear();
	}

	/**
	 * @param parent
	 * @param departmentName
	 * @return
	 */
	private Lot fairInstance(com.verticon.tracker.fair.Class parent,
			String lotName) {
		//Is the named Lot already in the fair?
		Lot lot = null;
		for (Lot lotInFair : parent.getLots()) {
			if(lotInFair.getName().equals(lotName)){
				lot = lotInFair;
			}
		}
		return lot;
	}

	/**
	 * The Lot was not found in the Fair, so this method finds one that was already
	 * created as part of this import task or creates a new command for one.
	 * @param row
	 * @param nameOfElement
	 */
	private Lot newInstance(List<ColumnMapper> listColumnMapper, 
			HSSFRow row, com.verticon.tracker.fair.Class owner, String nameOfElement, 
			EditingDomain editingDomain, CompoundCommand compoundCommand) {
		Lot lot = newInstance(listColumnMapper, row, nameOfElement);
		
		Command command = AddCommand.create(
				editingDomain, //domain
				owner,//owner
				FairPackage.Literals.CLASS__LOTS,//feature
				lot//value
		);
		compoundCommand.append(command);
	    if (!childrenAddedToFairParents.containsKey(owner)) {
			Set<Lot> setOfLots = new HashSet<Lot>();
			childrenAddedToFairParents.put(owner, setOfLots);
		}
		childrenAddedToFairParents.get(owner).add(lot);

	    logger.info(bundleMarker,"Row={} added a command to create Lot {}.",
				row.getRowNum(),nameOfElement);
	    
		return lot;
	}

	/**
	 * Children are created under two conditions. When there is a created
	 * Class parent and when there is an existing Class parent in the
	 * Fair.
	 * 
	 * In the case of the created Class Parent the Lot is just created
	 * and then added Directly to Class. When the Class is added to
	 * the Fair with an AddCommand the Lot will be part of the transaction.
	 * 
	 * In the case of a existing Class Parent in the Fair, the Lot must
	 * be created with a AddCommand after the processing of rows.
	 * 
	 * @param nameOfElement
	 * @param clazz
	 * @return
	 */
	private Lot cachedInstance(
			String nameOfElement, com.verticon.tracker.fair.Class clazz) {
		Lot results = null;
		// directly added
		for (Lot addedLot : clazz.getLots()) {
			if (addedLot.getName().equals(nameOfElement)) {
				results = addedLot;
			}
		}
		// tobe added in the future
		if (results == null
				&& childrenAddedToFairParents.containsKey(clazz)) {
			for (Lot dep : childrenAddedToFairParents
					.get(clazz)) {
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
	private Lot newInstance(List<ColumnMapper> listColumnMapper, HSSFRow row,
			String nameOfElement) {
		Lot lot = FairFactory.eINSTANCE.createLot();
		lot.setName(nameOfElement);
		lot.setComments(ExecutableProcreators.getValue(row, FairPackage.Literals.LOT__COMMENTS, listColumnMapper));
		lot.setDescription(ExecutableProcreators.getValue(row, FairPackage.Literals.LOT__DESCRIPTION, listColumnMapper));
		totalChildrenAdded++;
		return lot;
	}
		
}
