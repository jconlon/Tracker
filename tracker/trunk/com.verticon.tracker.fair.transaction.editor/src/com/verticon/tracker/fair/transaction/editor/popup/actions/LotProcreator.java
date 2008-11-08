/**
 * 
 */
package com.verticon.tracker.fair.transaction.editor.popup.actions;

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
public class LotProcreator implements Procreator {
	
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

	

	public LotProcreator(Procreator child) {
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
		
		Lot lot = findPreviouslyAddedLot(lotName, clazz);
		
		//If the parent is new don't check the fair
		if(parentWasCreated && lot == null){
			lot = createLot(listColumnMapper, row, lotName);
			clazz.getLots().add(lot);
			
			
		}else  if (!parentWasCreated && lot == null){
		    lot = getLotFromFair(clazz,lotName);
			if(lot != null){
				logger.info("Row={} Lot already in Fair with name {}.",
						row.getRowNum(),lotName);
				 child.process(fair, row, listColumnMapper, lot,
							false, editingDomain,  compoundCommand);
			}else{
				lot = createLot(  listColumnMapper, row, clazz, lotName, editingDomain,compoundCommand);
			}
		}else{
			logger.info("Row={} found previously created Department {}.", row
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
	private Lot getLotFromFair(com.verticon.tracker.fair.Class parent,
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
	private Lot createLot(List<ColumnMapper> listColumnMapper, 
			HSSFRow row, com.verticon.tracker.fair.Class owner, String nameOfElement, 
			EditingDomain editingDomain, CompoundCommand compoundCommand) {
		Lot lot = createLot(listColumnMapper, row, nameOfElement);
		
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

	    logger.info("Row={} added a command to create Lot {}.",
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
	private Lot findPreviouslyAddedLot(
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
	private Lot createLot(List<ColumnMapper> listColumnMapper, HSSFRow row,
			String nameOfElement) {
		Lot lot;
		//Create it
		String comments = ExecutableProcreators.getValue(row, FairPackage.Literals.LOT__COMMENTS, listColumnMapper);
		lot = FairFactory.eINSTANCE.createLot();
		lot.setName(nameOfElement);
		lot.setComments(comments);
		totalChildrenAdded++;
		return lot;
	}
	
	
	
}
