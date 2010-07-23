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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
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
	private final MonitorMasterDetailsBlock block;
	private ZoomContributionViewItem contextZoomContributionViewItem;
	private ZoomContributionViewItem toolbarZoomContributionViewItem;
//	private Action screenshotAction;
	private Action setTreeLayoutAction;
	private Action setRadialLayoutAction;
	private Action setGridLayoutAction;
	private Action setSpringLayoutAction;
	private Action setHorizontalLayoutAction;

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
		block.createContent(managedForm);

		toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		contextZoomContributionViewItem = new ZoomContributionViewItem(this);
		makeActions();
		fillToolBar();
		hookContextMenu();
	}

	@Override
	public void setFocus() {
		
	}

	/**
	 * Creates the context menu for this view.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		fillContextMenu(menuMgr);

		menuMgr.addMenuListener(new IMenuListener() {
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
		toolBarManager.add(setTreeLayoutAction);
		toolBarManager.add(setRadialLayoutAction);
		toolBarManager.add(setGridLayoutAction);
		toolBarManager.add(setSpringLayoutAction);
		toolBarManager.add(setHorizontalLayoutAction);
	}
	
	/**
	 * Add the items to the context menu
	 * 
	 * @param manager
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator());

		manager.add(new Separator());
		manager.add(setGridLayoutAction);
		manager.add(setSpringLayoutAction);
		manager.add(setHorizontalLayoutAction);
		manager.add(setTreeLayoutAction);
		manager.add(setRadialLayoutAction);
		manager.add(new Separator());
		manager.add(contextZoomContributionViewItem);
	}

	/**
	 * Make the actions that can be called on this viewer. This currently
	 * includes: - Change Layout...
	 */
	private void makeActions() {
		setTreeLayoutAction = new Action() {
			public void run() {
				MonitorMasterDetailsBlock.setTreeLayout(block.getViewer());
			}
		};
		setTreeLayoutAction.setText("TreeLayout");
		setTreeLayoutAction.setToolTipText("Set the layout to a tree like view");

		setRadialLayoutAction = new Action() {
			public void run() {
				MonitorMasterDetailsBlock.setRadialLayout(block.getViewer());
			}
		};
		setRadialLayoutAction.setText("RadialLayout");
		setRadialLayoutAction.setToolTipText("Set the layout to a circular like view");

		setGridLayoutAction = new Action() {
			public void run() {
				MonitorMasterDetailsBlock.setGridLayout(block.getViewer());
			}
		};
		setGridLayoutAction.setText("GridLayout");
		setGridLayoutAction.setToolTipText("Set the layout to a grid like view");

		setSpringLayoutAction = new Action() {
			public void run() {
				MonitorMasterDetailsBlock.setSpringLayout(block.getViewer());
			}
		};
		setSpringLayoutAction.setText("SpringLayout");
		setSpringLayoutAction.setToolTipText("Set the layout to a spring like view");

		setHorizontalLayoutAction = new Action() {
			public void run() {
				MonitorMasterDetailsBlock.setHorizontalLayout(block.getViewer());
			}
		};
		setHorizontalLayoutAction.setText("HorizontalLayout");
		setHorizontalLayoutAction.setToolTipText("Set the layout to a horizontal like view");

	}
}
