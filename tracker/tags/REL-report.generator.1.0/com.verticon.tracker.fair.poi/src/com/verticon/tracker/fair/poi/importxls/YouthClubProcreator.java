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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;
import com.verticon.tracker.fair.YouthClub;

/**
 * @author jconlon
 * 
 */
class YouthClubProcreator implements Procreator {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(YouthClubProcreator.class);

	/**
	 * Reference to the Set of YouthClub Names that were added by this import
	 * task.
	 */
	private final Set<String> addedYouthClubs = new HashSet<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator
	 * #process( com.verticon.tracker.fair.Fair,
	 * org.apache.poi.hssf.usermodel.HSSFRow, java.util.List,
	 * org.eclipse.emf.ecore.EObject, boolean,
	 * org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.common.command.CompoundCommand)
	 */
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
		joinYouthClub(fair, row, listColumnMapper, offspring, editingDomain,
				compoundCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator
	 * #getStatus()
	 */
	public String getStatus() {
		StringBuilder sbuilderBuilder = new StringBuilder();
		sbuilderBuilder.append(addedYouthClubs.size()).append(" Youth Clubs, ");
		return sbuilderBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator
	 * #dispose()
	 */
	public void dispose() {
		addedYouthClubs.clear();
	}

	private void joinYouthClub(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, YoungPerson offspring,
			EditingDomain editingDomain, CompoundCommand compoundCommand) {
		String nameOfYouthClub = ExecutableProcreators.getValue(row,
				FairPackage.Literals.YOUNG_PERSON__CLUB, listColumnMapper);

		if (nameOfYouthClub == null) {
			logger.debug(bundleMarker,
					"Row={} {} does not indicate he belongs to a youth club ",
					row.getRowNum(), offspring.getName());
			return;
		}
		logger.debug(bundleMarker,"Row={} {} wants to join youth club {}", new Object[] {
				row.getRowNum(), offspring.getName(), nameOfYouthClub });

		YouthClub myClub = findYouthClub(nameOfYouthClub, fair);
		if (myClub == null) {
			YouthClub youthClub = FairFactory.eINSTANCE.createYouthClub();
			youthClub.setName(nameOfYouthClub);
			if (!addedYouthClubs.contains(nameOfYouthClub)) {
				Command command = AddCommand.create(editingDomain, // domain
						fair,// owner
						FairPackage.Literals.FAIR__YOUTH_CLUBS,// feature
						youthClub// value
						);
				compoundCommand.append(command);
				addedYouthClubs.add(nameOfYouthClub);
				logger.info(bundleMarker,"Row={} creating a new youthClub {}", row
						.getRowNum(), youthClub.getName());
			}
		}

		// kid.setClub(myClub);
		Command command = SetCommand.create(editingDomain, // domain
				offspring,// owner
				FairPackage.Literals.YOUNG_PERSON__CLUB,// feature
				myClub// value
				);
		compoundCommand.append(command);

	}

	private YouthClub findYouthClub(String nameOfYouthClub, Fair fair) {

		for (YouthClub club : fair.getYouthClubs()) {
			// if(club.getName()==null ){
			// logger.error(bundleMarker,
			// "There needs to be a personName on all youth clubs setting it to Error"
			// );
			// club.setName("Error");
			// } else
			if (club.getName().equals(nameOfYouthClub)) {
				return club;
			}
		}
		return null;

	}

}
