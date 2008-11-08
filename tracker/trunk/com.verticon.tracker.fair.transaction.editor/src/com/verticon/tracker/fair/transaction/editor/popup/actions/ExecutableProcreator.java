package com.verticon.tracker.fair.transaction.editor.popup.actions;

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
}