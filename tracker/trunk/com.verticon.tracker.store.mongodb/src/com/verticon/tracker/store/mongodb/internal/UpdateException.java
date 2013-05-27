package com.verticon.tracker.store.mongodb.internal;

public class UpdateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AnimalUpdate.State state;

	/**
	 * @return the state
	 */
	public AnimalUpdate.State getState() {
		return state;
	}

	public UpdateException(AnimalUpdate.State state, String message) {
		super(message);
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateException: state=" + state + " " + getLocalizedMessage();
	}


}
