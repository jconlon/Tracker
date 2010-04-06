package com.verticon.tracker.editor.util;

/**
 * PremisesPolicyException is thrown when a object is 
 * rejected from being added to the premises because 
 * it is in violation of the set policy of the premises.
 * @author jconlon
 *
 */
public class PremisesPolicyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7953962503055332628L;

	public PremisesPolicyException() {
		// TODO Auto-generated constructor stub
	}

	public PremisesPolicyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PremisesPolicyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PremisesPolicyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
