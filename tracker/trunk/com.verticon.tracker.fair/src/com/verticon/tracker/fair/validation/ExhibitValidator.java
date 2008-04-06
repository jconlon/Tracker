/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.fair.validation;

import com.verticon.tracker.Animal;

import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YouthClub;

/**
 * A sample validator interface for {@link com.verticon.tracker.fair.Exhibit}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ExhibitValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateNumber(int value);
	boolean validateClub(YouthClub value);
	boolean validateComments(String value);
	boolean validateAnimal(Animal value);

	boolean validateExhibitor(Person value);

	boolean validateLot(Lot value);
}
