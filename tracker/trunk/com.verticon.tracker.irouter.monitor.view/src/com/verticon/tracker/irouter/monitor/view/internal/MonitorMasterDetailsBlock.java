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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.GridLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class MonitorMasterDetailsBlock extends MasterDetailsBlock {

	private GraphViewer viewer;

	/**
	 * Map factory Pids as keys to IDetailsPage implementations. A template
	 * factory use a TEMPLATE constant .
	 */
	private Map<INode, IDetailsPage> keyMap = new HashMap<INode, IDetailsPage>();

	private WiredNodeLabelProvider labelProvider;

	private LayoutAlgorithm currentLayoutAlgorithm;

	@Override
	protected void createMasterPart(final IManagedForm managedForm,
			final Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION);
		section.setText("iRouter Network Services and Wire Connections");
		section.setDescription("Select node to display service property details and status variables");
		section.marginWidth = 10;
		section.marginHeight = 5;
		toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 4;
		client.setLayout(layout);
		viewer = new GraphViewer(client, SWT.BORDER);
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});

		setUpViewer();
	}

	private void setUpViewer() {
		viewer.setContentProvider(new WiredNodeGraphEntityContentProvider(this));
		labelProvider = new WiredNodeLabelProvider();
		viewer.setLabelProvider(labelProvider);
		// viewer.setSorter(new NameSorter());
		viewer.setInput(Component.INSTANCE.getModel());
		setTreeLayout();
	}

	/**
	 * @return the viewer
	 */
	GraphViewer getViewer() {
		return viewer;
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {

		detailsPart.setPageProvider(new IDetailsPageProvider() {

			@Override
			public IDetailsPage getPage(Object key) {
				return keyMap.get(key);
			}

			/**
			 * Selections will be String PIDs for Wires, Producers and Consumers
			 */
			@Override
			public Object getPageKey(Object object) {

				if (!keyMap.containsKey(object)) {
					if(object instanceof WiredNode){
						WiredNode key = (WiredNode) object;
						keyMap.put(key, new WiredNodeDetailsPage(key));
					}else if(object instanceof IExternalNode){
						IExternalNode key = (IExternalNode)object;
						keyMap.put(key, new ExternalNodeDetailsPage(key));
					}
				}
				
				
				return object;
			}
		});

	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal orientation");
		try {
			URL url = new URL(
					"platform:/plugin/com.verticon.osgi.metatype.core.model.editor/icons/th_horizontal.gif");

			haction.setImageDescriptor(ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical orientation");
		try {
			URL url = new URL(
					"platform:/plugin/com.verticon.osgi.metatype.core.model.editor/icons/th_vertical.gif");

			vaction.setImageDescriptor(ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);

		Action screenshotAction = new Action() {
			public void run() {

				Shell shell = Display.getCurrent().getActiveShell();
				Graph g = (Graph) viewer.getControl();
				Rectangle bounds = g.getContents().getBounds();
				Point size = new Point(g.getContents().getSize().width, g
						.getContents().getSize().height);
				org.eclipse.draw2d.geometry.Point viewLocation = g
						.getViewport().getViewLocation();
				final Image image = new Image(null, size.x, size.y);
				GC gc = new GC(image);
				SWTGraphics swtGraphics = new SWTGraphics(gc);

				swtGraphics.translate(-1 * bounds.x + viewLocation.x, -1
						* bounds.y + viewLocation.y);
				g.getViewport().paint(swtGraphics);
				gc.copyArea(image, 0, 0);
				gc.dispose();

				ImagePreviewPane previewPane = new ImagePreviewPane(shell);
				previewPane.setText("Image Preview");
				previewPane.open(image, size);
			}
		};

		screenshotAction.setText("Take A Screenshot");
		try {
			URL url = new URL(
					"platform:/plugin/com.verticon.tracker.irouter.monitor.view/icons/snapshot.gif");

			screenshotAction.setImageDescriptor(ImageDescriptor
					.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		screenshotAction.setToolTipText("Take screenshot");
		screenshotAction.setEnabled(true);
		form.getToolBarManager().add(new Separator());
		form.getToolBarManager().add(screenshotAction);
	}

	/**
	 * Wired Node was removed from the model
	 * 
	 * @param wiredNode
	 */
	void removePage(INode wiredNode) {
		IDetailsPage page = keyMap.get(wiredNode);
		if (page != null) {
			page.dispose();
			keyMap.remove(wiredNode);
		}
	}

	private void setLayout(LayoutAlgorithm layout) {
		currentLayoutAlgorithm = layout;
		viewer.setLayoutAlgorithm(layout, true);
		viewer.applyLayout();
	}

	void setTreeLayout() {
		LayoutAlgorithm layout = new TreeLayoutAlgorithm();
		setLayout(layout);
	}

	void setSpringLayout() {
		setLayout(new SpringLayoutAlgorithm());
	}

	void setGridLayout() {
		setLayout(new GridLayoutAlgorithm());

	}

	void setHorizontalLayout() {
		setLayout(new HorizontalTreeLayoutAlgorithm());
	}

	void setRadialLayout() {
		setLayout(new RadialLayoutAlgorithm());
	}

	void setShowWireLabels(boolean show) {
		labelProvider.setShowWireLabels(show);
	}

	void setFilter(Filter filter) {
		currentLayoutAlgorithm.setFilter(filter);
		viewer.applyLayout();
	}
}
