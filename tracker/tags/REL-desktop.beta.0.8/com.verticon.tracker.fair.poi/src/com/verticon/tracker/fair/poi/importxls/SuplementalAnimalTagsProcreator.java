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

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Swine;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.fair.Fair;



/**
 * @author jconlon
 *
 */
public class SuplementalAnimalTagsProcreator implements Procreator {
	
	private int visualIDsSet = 0;
	private int supplementalIDsSet = 0;
	
	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(SuplementalAnimalTagsProcreator.class);

	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#dispose()
	 */
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#getStatus()
	 */
	public String getStatus() {
		 StringBuilder sb = new StringBuilder();
		 
		 if(visualIDsSet != 0){
			 sb.append(visualIDsSet).append(" visual IDs set, ");
		 }
		 if(supplementalIDsSet !=0){
			 sb.append(supplementalIDsSet).append(" supplemental IDs set, ");
		 }
		 
		 return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.fair.transaction.editor.popup.actions.Procreator#process(com.verticon.tracker.fair.Fair, org.apache.poi.hssf.usermodel.HSSFRow, java.util.List, org.eclipse.emf.ecore.EObject, boolean, org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.common.command.CompoundCommand)
	 */
	public void process(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain,
			CompoundCommand compoundCommand) throws MissingCriticalDataException {
		
		if (!(parent instanceof Animal)) {
			throw new IllegalArgumentException("Parent should be a Animal");
		}
		Animal animal = (Animal) parent;
		logger.debug(bundleMarker, "Processing row {} and animal {} ",row.getRowNum(), animal.getId());
		if(setSupplementalAnimalTags(compoundCommand, row, listColumnMapper, animal, fair, editingDomain)){
			supplementalIDsSet++;
			logger.debug(bundleMarker, "animal {}, {} supplementalIDs",new Object [] {animal.getId(),supplementalIDsSet});
		}
		if(setVisualAnimalID(compoundCommand, row, listColumnMapper, animal, fair, editingDomain)){
			visualIDsSet++;
		}
	}
	
	/**
	 * Create an exibit if there is an animal mapped in the row.
	 * @param compoundCommand
	 * @param row
	 * @param person
	 * @param fair
	 * @param editingDomain
	 * @throws MissingCriticalDataException 
	 */
	private static boolean setVisualAnimalID(CompoundCommand compoundCommand, HSSFRow row,List<ColumnMapper> listColumnMapper, Animal animal, Fair fair, EditingDomain editingDomain) throws MissingCriticalDataException{
			if(ExecutableProcreators.findColumnNumber(TrackerPackage.Literals.ANIMAL__VISUAL_ID, listColumnMapper)==-1){
				return false;
			}
			String visualID = ExecutableProcreators.getValue( row, TrackerPackage.Literals.ANIMAL__VISUAL_ID,listColumnMapper);
			if(visualID==null){
            	return false;
            }
			
			Command command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.ANIMAL__VISUAL_ID,//feature
					visualID//value
			);
			compoundCommand.append(command);
			logger.info(bundleMarker,"Row={} Visual ID {} set for animal id {}.",
        			new Object[] {row.getRowNum(),visualID, animal.getId()});
			return true;
		
	}

private static boolean setSupplementalAnimalTags(CompoundCommand compoundCommand, HSSFRow row,List<ColumnMapper> listColumnMapper, Animal animal, Fair fair, EditingDomain editingDomain) throws MissingCriticalDataException{
		
		if(animal instanceof Swine){
			if(ExecutableProcreators.findColumnNumber(TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING, listColumnMapper)==-1){
				return false;
			}
			String swineLeftEarNotch = ExecutableProcreators.getValue( row, TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING, listColumnMapper);
			String swineRightEarNotch = ExecutableProcreators.getValue( row, TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING, listColumnMapper);
            if(swineLeftEarNotch==null && swineLeftEarNotch==null){
            	logger.warn(bundleMarker,"Row={} could not find supplemental tag information for animal with id {}.",
            			row.getRowNum(),animal.getId());
            	return false;
            }
			
			Command command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.SWINE__LEFT_EAR_NOTCHING,//feature
					Integer.parseInt(swineLeftEarNotch)//value
			);
			compoundCommand.append(command);

			logger.info(bundleMarker,"Row={} Swine left ear notching for animal id {} is {}",
        			new Object[] {row.getRowNum(),animal.getId(), Integer.parseInt(swineLeftEarNotch)});
			
			command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.SWINE__RIGHT_EAR_NOTCHING,//feature
					Integer.parseInt(swineRightEarNotch)//value
			);
			compoundCommand.append(command);
			logger.info(bundleMarker,"Row={} Swine right ear notching for animal id {} is {}",
        			new Object[] {row.getRowNum(),animal.getId(), Integer.parseInt(swineRightEarNotch)});
			return true;
		}
		else if(animal instanceof Ovine){
			if(ExecutableProcreators.findColumnNumber(TrackerPackage.Literals.OVINE__SCRAPIE_TAG, listColumnMapper)==-1){
				return false;
			}
			String scrapieTag = ExecutableProcreators.getValue( row, TrackerPackage.Literals.OVINE__SCRAPIE_TAG,listColumnMapper);
			if(scrapieTag==null){
            	return false;
            }
			
			Command command = SetCommand.create(
					editingDomain, //domain
					animal,//owner
					TrackerPackage.Literals.OVINE__SCRAPIE_TAG,//feature
					scrapieTag//value
			);
			compoundCommand.append(command);
			logger.info(bundleMarker,"Row={} Ovine scrapie tag for animal id {} is {}",
        			new Object[] {row.getRowNum(),animal.getId(), scrapieTag});
			return true;

		}
		return false;
	}
}
