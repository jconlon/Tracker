package com.verticon.tracker.fair;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;

/**
 * All the exhibits in the fair.
 * @author jconlon
 *
 */
public interface AllExhibits {

	EList<Exhibit> exhibits();
	
	void setForwarding(Adapter adapter);
}
