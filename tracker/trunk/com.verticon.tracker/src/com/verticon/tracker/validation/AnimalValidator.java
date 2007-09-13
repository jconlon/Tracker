/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.validation;

import com.verticon.tracker.Sex;
import com.verticon.tracker.Tag;

import com.verticon.tracker.util.Age;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.verticon.tracker.Animal}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AnimalValidator {
	boolean validate();

	boolean validateBirthDate(Date value);
	boolean validateSex(Sex value);
	boolean validateTags(EList<Tag> value);
	boolean validateSpecies(String value);
	boolean validateIdNumber(long value);
	boolean validateBreed(String value);
	boolean validateAge(Age value);
	boolean validateSexCode(String value);
	boolean validateSpeciesCode(String value);

	boolean validateId(String value);

	boolean validateComments(String value);
}
