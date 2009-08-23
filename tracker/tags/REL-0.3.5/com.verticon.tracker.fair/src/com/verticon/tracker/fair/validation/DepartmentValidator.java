/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.fair.validation;

import org.eclipse.emf.common.util.EList;

import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Person;

/**
 * A sample validator interface for {@link com.verticon.tracker.fair.Department}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DepartmentValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateClass(EList<com.verticon.tracker.fair.Class> value);

	boolean validateSuperintendent(EList<Person> value);

	boolean validateClasses(EList<com.verticon.tracker.fair.Class> value);

	boolean validateSuperintendents(EList<Person> value);

	boolean validateDivision(Division value);

	boolean validateComments(String value);

	boolean validateDescription(String value);

	boolean validateSuperIntendent(EList<Person> value);
}
