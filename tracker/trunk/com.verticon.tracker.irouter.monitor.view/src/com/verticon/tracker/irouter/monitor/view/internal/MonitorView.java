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
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;

public class MonitorView extends ViewPart implements IZoomableWorkbenchPart {

	enum Layout {
		HORIZONTAL, SPRING, GRID, RADIAL, TREE
	};

	private FormToolkit toolKit = null;
	private ScrolledForm form = null;
	private ManagedForm managedForm = null;
	private final MonitorMasterDetailsBlock block;
	private ZoomContributionViewItem contextZoomContributionViewItem;
	private ZoomContributionViewItem toolbarZoomContributionViewItem;
	private Action refresh;
	private Action showConnectionLabels;
	private LayoutCombo myCombo;

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
		myCombo = new LayoutCombo("Layout");
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
		bars.getMenuManager().add(showConnectionLabels);
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

		toolBarManager.add(myCombo);

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
		manager.add(myCombo);
		manager.add(new Separator());
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
			public void run() {
				block.getViewer().refresh(true);
			}
		};
		refresh.setText("Refresh");
		refresh.setToolTipText("Refresh the graph.");
		refresh.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		showConnectionLabels = new Action("Hide Wire Names",
				Action.AS_CHECK_BOX) {
			public void run() {
				block.setShowWireLabels(!this.isChecked());
				block.getViewer().refresh(true);
			}
		};

		showConnectionLabels.setToolTipText("Shows the connection labels");

	}

	class LayoutCombo extends ControlContribution {

		protected LayoutCombo(String id) {
			super(id);
		}

		@Override
		protected Control createControl(Composite parent) {
			final Combo combo = new Combo(parent, SWT.NULL);
			combo.setToolTipText("Sets the type of layout to use for drawing the graph.");

			for (Layout layout : Layout.values()) {
				combo.add(layout.name());
			}

			combo.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {

					switch (Layout.valueOf(combo.getText())) {
					case HORIZONTAL:
						MonitorMasterDetailsBlock.setHorizontalLayout(block
								.getViewer());
						break;

					case SPRING:
						MonitorMasterDetailsBlock.setSpringLayout(block
								.getViewer());
						break;

					case GRID:
						MonitorMasterDetailsBlock.setGridLayout(block
								.getViewer());
						break;

					case RADIAL:
						MonitorMasterDetailsBlock.setRadialLayout(block
								.getViewer());
						break;

					case TREE:
						MonitorMasterDetailsBlock.setTreeLayout(block
								.getViewer());
						break;
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					MonitorMasterDetailsBlock.setHorizontalLayout(block
							.getViewer());
				}
			});
			GridData gridData = new GridData(SWT.FILL, SWT.TOP, false, false);
			gridData.widthHint = 20;
			gridData.heightHint = SWT.DEFAULT;
			combo.setLayoutData(gridData);
			combo.pack();
			return combo;
		}

	}

}
