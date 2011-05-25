package com.verticon.tracker.irouter.gps.ui;

import java.net.URI;

import org.eclipse.ui.IWorkbenchWizard;

/**
 * Wizard that creates a URI.
 * @author jconlon
 *
 */
public interface IURIWizard extends IWorkbenchWizard  {
	URI getURI();
}
