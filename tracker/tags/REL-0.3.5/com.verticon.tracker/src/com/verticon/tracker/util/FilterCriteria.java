package com.verticon.tracker.util;


public interface FilterCriteria<E> {
	public boolean passes(E o);
}
