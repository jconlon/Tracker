/**
 * 
 */
package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.verticon.tracker.Animal;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 *
 */
public class AnimalProcreator implements Procreator {

	int countOfSets = 0;

	private final Procreator child;

	public AnimalProcreator(Procreator child) {
		super();
		this.child = child;
	}


	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#process(com.verticon.tracker.fair.Fair, org.apache.poi.hssf.usermodel.HSSFRow, java.util.List, org.eclipse.emf.ecore.EObject, boolean, org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.common.command.CompoundCommand)
	 */
	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain,
			CompoundCommand compoundCommand) throws MissingCriticalDataException {
		
		if (!(parent instanceof Exhibit)) {
			throw new IllegalArgumentException("Parent should be a Exhibit");
		}
		Exhibit exhibit = (Exhibit) parent;

		String id = ExecutableProcreators.getValue( row, FairPackage.Literals.EXHIBIT__ANIMAL,listColumnMapper);

		Animal animal = null;
		if(id!=null){
			 animal = fair.getPremises().findAnimal(id);
			 createCommandToSetAnimalOnExhibit(compoundCommand, editingDomain,
						animal, exhibit);
			 countOfSets++;
		}
		if(animal !=null){
			child.process(fair, row, listColumnMapper, animal, newParent, editingDomain, compoundCommand);
		}
	}


	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#getStatus()
	 */
	public String getStatus() {
		return countOfSets + " Animal References, ";
	}
	
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#dispose()
	 */
	public void dispose() {
	}
	
	/**
	 * @param compoundCommand
	 * @param editingDomain
	 * @param animal
	 * @param exhibit
	 */
	private void createCommandToSetAnimalOnExhibit(
			CompoundCommand compoundCommand, EditingDomain editingDomain,
			Animal animal, Exhibit exhibit) {
		Command command;
		command = SetCommand.create(
				editingDomain, //domain
				exhibit,//owner
				FairPackage.Literals.EXHIBIT__ANIMAL,//feature
				animal//value
				);
		compoundCommand.append(command);
	}
}
