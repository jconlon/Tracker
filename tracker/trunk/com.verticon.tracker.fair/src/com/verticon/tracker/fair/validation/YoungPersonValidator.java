/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.fair.validation;

import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YouthClub;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.verticon.tracker.fair.YoungPerson}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface YoungPersonValidator {
	boolean validate();

	boolean validateParent(EList<Person> value);

	boolean validateParents(EList<Person> value);
	boolean validateClub(YouthClub value);
}
