package com.verticon.tracker.trigger.view.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.verticon.tracker.trigger.view.ITriggerEntry;

public class TriggerFilter extends ViewerFilter {

	private String searchString;

	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		ITriggerEntry p = (ITriggerEntry) element;
		if (p.getName().matches(searchString)) {
			return true;
		}
		if (p.getFile() != null
				&& p.getFile().getName().matches(searchString)) {
			return true;
		}

		return false;
	}
}
