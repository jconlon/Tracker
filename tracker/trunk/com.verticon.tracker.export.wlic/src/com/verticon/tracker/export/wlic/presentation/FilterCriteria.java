package com.verticon.tracker.export.wlic.presentation;


public interface FilterCriteria<E> {
	public boolean passes(E o);
}
