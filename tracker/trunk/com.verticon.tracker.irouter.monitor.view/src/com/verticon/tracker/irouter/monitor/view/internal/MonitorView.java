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
package com.verticon.tracker.irouter.monitor.view.internal;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;

public class MonitorView extends ViewPart implements IZoomableWorkbenchPart {

	private FormToolkit toolKit = null;
	private ScrolledForm form = null;
	private ManagedForm managedForm = null;
	final MonitorMasterDetailsBlock block;
	private ZoomContributionViewItem contextZoomContributionViewItem;
	private ZoomContributionViewItem toolbarZoomContributionViewItem;
	private Action refresh;
	private Action showConnectionLabels;
	private LayoutControl layoutControl;
	private FilterControl filterControl;

	public MonitorView() {
		super();
		block = new MonitorMasterDetailsBlock();
	}

	@Override
	public void createPartControl(Composite parent) {
		toolKit = new FormToolkit(parent.getDisplay());
		form = this.toolKit.createScrolledForm(parent);
		managedForm = new ManagedForm(this.toolKit, this.form);
		form.setText("iRouter Monitor");
		toolKit.decorateFormHeading(form.getForm());
		block.createContent(managedForm);
		layoutControl = new LayoutControl(block, "Layout");
		filterControl = new FilterControl(block, "Filter");
		toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		contextZoomContributionViewItem = new ZoomContributionViewItem(this);
		makeActions();
		fillToolBar();
		hookContextMenu();
	}

	@Override
	public void setFocus() {
		managedForm.setFocus();
	}
	
	/**
	 * Disposes the toolkit
	 */
	@Override
	public void dispose() {
		toolKit.dispose();
		super.dispose();
	}

	

	/**
	 * Creates the context menu for this view.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		fillContextMenu(menuMgr);

		menuMgr.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				MonitorView.this.fillContextMenu(manager);

			}
		});
		GraphViewer viewer = block.getViewer();
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);

	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return block.getViewer();
	}

	/**
	 * Set the toolbar
	 */
	private void fillToolBar() {
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(showConnectionLabels);
		bars.getMenuManager().add(refresh);
		bars.getMenuManager().add(new Separator());
		bars.getMenuManager().add(toolbarZoomContributionViewItem);

		fillLocalToolBar(bars.getToolBarManager());

	}

	/**
	 * Add the actions to the tool bar
	 * 
	 * @param toolBarManager
	 */
	private void fillLocalToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator());
        toolBarManager.add(filterControl);
		toolBarManager.add(layoutControl);
		toolBarManager.add(new Separator());
		toolBarManager.add(refresh);
	}

	/**
	 * Add the items to the context menu
	 * 
	 * @param manager
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(showConnectionLabels);
		manager.add(refresh);
		manager.add(new Separator());
		manager.add(contextZoomContributionViewItem);
	}

	/**
	 * Make the actions that can be called on this viewer. This currently
	 * includes: - Change Layout...
	 */
	private void makeActions() {
		

		refresh = new Action() {
			@Override
			public void run() {
				block.getViewer().refresh(true);
			}
		};
		refresh.setText("Refresh");
		refresh.setToolTipText("Refresh the graph.");
		try{
			URL url = new URL("platform:/plugin/com.verticon.tracker.irouter.monitor.view/icons/refresh.gif");
			refresh.setImageDescriptor(ImageDescriptor.createFromURL(url));
		}catch (MalformedURLException e){
			
		}

		showConnectionLabels = new Action("Hide Wire Names",
				Action.AS_CHECK_BOX) {
			@Override
			public void run() {
				block.setShowWireLabels(!this.isChecked());
				block.getViewer().refresh(true);
			}
		};

		showConnectionLabels.setToolTipText("Shows the connection labels");

	}

}
