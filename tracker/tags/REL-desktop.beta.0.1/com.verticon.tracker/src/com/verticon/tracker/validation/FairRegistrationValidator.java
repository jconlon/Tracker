/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.validation;


/**
 * A sample validator interface for FairRegistration.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FairRegistrationValidator {
	boolean validate();

	boolean validateParticipant(String value);
	boolean validateAddress(String value);
	boolean validatePhone(String value);
	boolean validateParent(String value);
	boolean validateClub(String value);

	boolean validateSaleOrder(int value);

	boolean validateExhibit(int value);
}