/*******************************************************************************
 * Copyright (c) 2015 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.ocl.query;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import com.verticon.emf.ui.api.IOclQueryWizardPrompts;

/**
 * The main plugin class to be used in the desktop.
 */
@SuppressWarnings("ucd")
public class OCLPlugin extends AbstractUIPlugin {

	// The shared instance.
	private static OCLPlugin plugin;
	private BundleContext bundleContext;

	/**
	 * The constructor.
	 */
	public OCLPlugin() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		this.bundleContext = context;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		this.bundleContext = null;

	}

	/**
	 * Returns the shared instance.
	 */
	public static OCLPlugin getDefault() {
		return plugin;
	}

	public class PromptBean {
		final StringBuilder contextFreePrompt = new StringBuilder();
		final StringBuilder oclQueryPrompt = new StringBuilder();

		public boolean hasContextFreePrompt() {
			return contextFreePrompt.length() > 1;
		}

		public boolean hasOclQueryPrompt() {
			return oclQueryPrompt.length() > 1;
		}

		public String getContextFreePrompt() {
			return contextFreePrompt.toString();
		}

		public String getOCLQueryPrompt() {
			return oclQueryPrompt.toString();
		}
	}
	/**
	 * Other components may offer default queries for the OCLViewer.
	 * 
	 * @return all default ocl queries offered by other components.
	 */
	public PromptBean getPrompts() {
		PromptBean prompt = new PromptBean();
		if (bundleContext != null) {
			try {
				ServiceReference<?>[] references = bundleContext
						.getAllServiceReferences(IOclQueryWizardPrompts.class.getName(), null);
				if (references != null) {

					for (ServiceReference<?> serviceReference : references) {
						IOclQueryWizardPrompts service = (IOclQueryWizardPrompts) bundleContext
								.getService(serviceReference);
						prompt.contextFreePrompt.append(service.getContextFreePrompt()).append('\n');
						prompt.oclQueryPrompt.append(service.getOclQueryPrompt()).append('\n');
						bundleContext.ungetService(serviceReference);
					}
				}
			} catch (InvalidSyntaxException e) {
				// ignore
			}
		}
		return prompt;
	}

}
