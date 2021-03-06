package com.verticon.tracker.fair.poi.importxls;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.verticon.tracker.fair.Fair;

interface Procreator  {
	
	void process(Fair fair, HSSFRow row, 
			List<ColumnMapper> listColumnMapper, EObject parent, boolean newParent, 
			EditingDomain editingDomain, CompoundCommand compoundCommand) throws MissingCriticalDataException;
	void dispose();
	
	String getStatus();
}
