package com.verticon.osgi.metatype.core.model.editor.internal.forms;

public class ConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892071116332176892L;

	 ConfigurationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	ConfigurationException(String message) {
		super(message);
		
	}

	 ConfigurationException(Throwable cause) {
		super(cause);
		
	}

}
