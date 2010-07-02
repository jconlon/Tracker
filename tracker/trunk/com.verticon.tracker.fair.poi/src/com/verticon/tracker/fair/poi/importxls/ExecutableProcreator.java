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
package com.verticon.tracker.fair.poi.importxls;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.verticon.tracker.fair.Fair;

public interface ExecutableProcreator extends Procreator {
	
	/**
	 * Prepare the ExecutableProcreator for execution.
	 * @param fair
	 * @param row
	 * @param listColumnMapper
	 * @param parent
	 * @param newParent
	 * @param editingDomain
	 * @throws MissingCriticalDataException when critical data in spreadsheets is missing.
	 */
    void prepare(Fair fair, HSSFRow row,
			List<ColumnMapper> listColumnMapper, EObject parent,
			boolean newParent, EditingDomain editingDomain)throws MissingCriticalDataException;

    /**
     * Execute commands prepared by the ExecutableProcreator
     */
    void execute();
    
    Exception getError();
    
    
}