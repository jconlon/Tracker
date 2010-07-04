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
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
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
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

/**
 * @author jconlon
 * 
 */
class ParentsProcreator implements Procreator {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ParentsProcreator.class);
	
	/**
	 * Reference to the Set of Person names that were added by this import task.
	 */
	private final Set<String> addedPersons = new HashSet<String>();


	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject superOrdinatedElement,
			boolean parentWasCreated, EditingDomain editingDomain,
			CompoundCommand compoundCommand) {

		
		if (!(superOrdinatedElement instanceof Person)) {
			throw new IllegalArgumentException("Parent should be a Person");
		}

		if (!(superOrdinatedElement instanceof YoungPerson)) {
			return;
		}

		YoungPerson offspring = (YoungPerson) superOrdinatedElement;
		
		String parentNames = getParentNames(row, listColumnMapper);
		if(parentNames.toLowerCase().equals("unknown") || parentNames.trim().length()< 1){
			//do nothing parents was a placeholder
			return ;
		}
		
		findParentsAtFair( compoundCommand,  row,  offspring, 
				parentNames,  fair,  editingDomain);

	}


	public String getStatus() {
		StringBuilder sbuilderBuilder = new StringBuilder();
		sbuilderBuilder.append(addedPersons.size()).append(" parents, ");
		return sbuilderBuilder.toString();
	}

	public void dispose() {
		logger.debug(bundleMarker,"Disposing");
		addedPersons.clear();
	}



	/**
	 * 
	 * @param row
	 * @param listColumnMapper
	 * @return name as lastName,firstName
	 */
	private static String getParentNames(HSSFRow row,
			List<ColumnMapper> listColumnMapper) {

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
		
		return parents;
	}
	
	private void findParentsAtFair(CompoundCommand compoundCommand, HSSFRow row, YoungPerson kid, 
			String parents, Fair fair, EditingDomain editingDomain){
		logger.debug(bundleMarker,"Row={} {} is looking for his parents {}",
				new Object[]{row.getRowNum(),kid.getName(), parents});
		StringTokenizer st = new StringTokenizer(parents);
		Person parent = null;
		while (st.hasMoreTokens()) {
		   String parentName = st.nextToken();
		   if(parentName.equals("and")){
			   continue;
		   }
		   parent = findParent(row, parentName, fair, kid);
		   
		   if(parent!=null){
			   logger.info(bundleMarker,"Row={} found a parent for {} with the personName {}",
					   new Object[]{row.getRowNum(),kid.getName(), parentName});
		   }else{
			   logger.info(bundleMarker,"Row={} creating a parent for {} with the personName {}",
					   new Object[]{row.getRowNum(),kid.getName(), parentName});
			   
			   parent = FairFactory.eINSTANCE.createPerson();
			   parent.setFirstName(parentName);
			   parent.setLastName(kid.getLastName());
			   parent.setCity(kid.getCity());
			   parent.setPhone(kid.getPhone());
			   parent.setPin(kid.getPin());
			   parent.setState(kid.getState());
			   parent.setStreet(kid.getStreet());
			   parent.setZipCode(kid.getZipCode());
			   addPersonCommand(compoundCommand, row, fair, editingDomain,
						parent);
		   }
		  
		   Command command = AddCommand.create(
					editingDomain, //domain
					kid,//owner
					FairPackage.Literals.YOUNG_PERSON__PARENTS,//feature
					parent//value
					);
		   compoundCommand.append(command);
		} 
	}
	
	private static Person findParent(HSSFRow row, String parentName, Fair fair, YoungPerson kid){
		Person parent = null;
		//try last personName
		parent = findPersonWithName(row, kid.getLastName()+','+parentName,  fair);
		
		if(parent==null){
			//try parentName by itself
			parent = findPersonWithName(row, parentName,  fair);
		}
		return parent;
	}
	
	private static Person findPersonWithName(HSSFRow row, String personName, Fair fair){
		Person parent = null;
		logger.debug(bundleMarker,"Row={} Searching through {} people at the fair for a person named {}",
				new Object[]{row.getRowNum(),fair.getPeople().size(), personName});
		for (Person person : fair.getPeople()) {
			String cleanedUpPersonInFairName = person.getName().toLowerCase().trim();
			String cleanedUpParentName = personName.toLowerCase().trim();
			
			if(cleanedUpPersonInFairName.equals(cleanedUpParentName)){
				parent = person;
				break;
			}
		}
		if(parent==null){
			logger.debug(bundleMarker,"Row={} Can't find person named {}", row.getRowNum(),personName);
		}
		return parent;
	}
	
	/**
	 * @param compoundCommand
	 * @param row
	 * @param fair
	 * @param editingDomain
	 * @param person
	 */
	private boolean addPersonCommand(CompoundCommand compoundCommand, HSSFRow row,
			Fair fair, EditingDomain editingDomain, Person person) {
		if(!addedPersons.contains(person.getName())){
			Command command = AddCommand.create(
				editingDomain, //domain
				fair,//owner
				FairPackage.Literals.FAIR__PEOPLE,//feature
				person//value
				);
			compoundCommand.append(command);
			addedPersons.add(person.getName());
			if(person instanceof YoungPerson){
				logger.info(bundleMarker,"Row={} creating a new youngPerson {}",row.getRowNum(), person.getName());
			}else{
				logger.info(bundleMarker,"Row={} creating a new person {}",row.getRowNum(), person.getName());
			}
			return true;
		}
		return false;
	}
}
