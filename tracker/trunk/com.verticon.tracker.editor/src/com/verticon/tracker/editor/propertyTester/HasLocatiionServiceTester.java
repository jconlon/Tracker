package com.verticon.tracker.editor.propertyTester;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.tracker.TrackerPlugin;

/**
 * Tests to see if there is a location service available
 * @author jconlon
 *
 */
public class HasLocatiionServiceTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		return TrackerPlugin.getDefault().hasLocationService();
	}

}
