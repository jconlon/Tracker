/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.trigger.view.handlers;

import static com.verticon.tracker.trigger.view.TriggerViewPlugin.bundleMarker;

import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.views.TriggerViewer;

/**
 * @author jconlon
 *
 */
public class SetTriggerAction extends Action {

	private final TriggerViewer viewer;
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SetTriggerAction.class);


	public SetTriggerAction(TriggerViewer viewer, String text) {
		super(text);
		this.viewer = viewer;
	}

	@Override
	public void run() {
		super.run();
		ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) viewer
				.getSelection()).getFirstElement();

		try {
			String format = entry.format();
			String.format(format, System.currentTimeMillis(), "POUNDS", 999.0,
					.0001);
		} catch (Exception e) {
			MessageDialog
					.openError(
							viewer.getControl().getShell(),
							"Setting Trigger File Service",
							String.format(
									"Bad %s   Please reconfigure the trigger entry or the values in the user preferences.",
									e.getLocalizedMessage()));
			logger.error(bundleMarker, "Test of format failed Bad:", e);
			return;
		}

		Map<String, String> topicsByNodeLabel = TriggerViewPlugin.getDefault()
				.getTopicsByNodeLabel();

		if (topicsByNodeLabel == null || topicsByNodeLabel.isEmpty()) {
			MessageDialog.openError(viewer.getControl().getShell(),
							"Trigger File Services",
							"There are no active iRouter gateways. Please configure one.");
			logger.error(bundleMarker, "There are no iRouter gateways.");
			return;
		}

		String[] nodes = Iterables.toArray(topicsByNodeLabel.keySet(),
				String.class);

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				viewer.getControl().getShell(), new LabelProvider());

		dialog.setElements(nodes);
		dialog.setTitle("Active Trigger File Services");
		dialog.setMessage("Please choose which Trigger File Service to post the trigger.");
		// User pressed cancel
		if (dialog.open() != Window.OK) {
			return;
		}
		String nodeLabel = (String) dialog.getFirstResult();
		String eventAdminTopic = topicsByNodeLabel.get(nodeLabel);
		TriggerViewPlugin.getDefault().post(entry.format(), eventAdminTopic);
		MessageDialog
				.openInformation(
						viewer.getControl().getShell(),
						"Posted",
						String.format(
								"Posted a change to the %s Trigger File Service listening to topic %s.",
								nodeLabel, eventAdminTopic));

	}
	
	
}
