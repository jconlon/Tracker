/**
 * 
 */
package com.verticon.tracker.fair.transaction.editor.popup.actions;

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
public class DivisionProcreator implements ExecutableProcreator {

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

	public DivisionProcreator(Procreator child) {
		super();
		this.child = child;
	}

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

	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain, CompoundCommand compoundCommand) throws MissingCriticalDataException {

		if (!(parent instanceof Fair)) {
			throw new IllegalArgumentException("Parent should be a Fair");
		}
		
		
		String divName = ExecutableProcreators.getCriticalValue(row,
				FairPackage.Literals.DIVISION__NAME, listColumnMapper);

		Division division = getDivisionFromFair(fair, divName);

		if (division != null) {
			logger.info("Row={} Division {} was already in Fair.", row
					.getRowNum(), divName);
			 child.process(fair, row, listColumnMapper, division,
					false, editingDomain,  compoundCommand);

		} else {// Division is not in the fair.
			division = findPreviouslyCreatedDivision(row, divName);
			if (division != null) {
				logger.info("Row={} found previously created Division {}.", row
						.getRowNum(), divName);
			} else {
				division = createNewDivision(listColumnMapper, row, fair,
						divName, editingDomain);
				logger.info("Row={} added a command to create Division {}.",
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
	public void execute() {
		if(localCompoundCommand==null){
			throw new IllegalStateException("process method must be called first.");
		}
		localCompoundCommand.execute();
	}

	public String getStatus() {
		return exception!=null? exception.getMessage(): createdElements.size() + " divisions, " + child.getStatus();
	}

	public void dispose() {
		createdElements.clear();
		child.dispose();
	}

	/**
	 * @param fair
	 * @param divName
	 * @return
	 */
	private Division getDivisionFromFair(Fair fair, String divName) {
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
	private Division createNewDivision(List<ColumnMapper> listColumnMapper,
			HSSFRow row, Fair fair, String nameOfElement,
			EditingDomain editingDomain) {
		Division division = null;
		// Create a division
		String comments = ExecutableProcreators.getValue(row,
				FairPackage.Literals.DIVISION__COMMENTS, listColumnMapper);
		division = FairFactory.eINSTANCE.createDivision();
		division.setName(nameOfElement);
		division.setComments(comments);

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
	private Division findPreviouslyCreatedDivision(HSSFRow row,
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
