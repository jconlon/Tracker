/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.fair.validation;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Lot;

import com.verticon.tracker.fair.Person;
import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.verticon.tracker.fair.Class}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ClassValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateLot(EList<Lot> value);

	boolean validateLots(EList<Lot> value);

	boolean validateJudges(EList<Person> value);

	boolean validateDepartment(Department value);

	boolean validateJudge(EList<Person> value);
}
