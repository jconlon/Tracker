package com.verticon.tracker.irouter.monitor.view.internal;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


class LayoutControl extends ControlContribution {

	private enum Layout {
		HORIZONTAL, SPRING, GRID, RADIAL, TREE
	};
	
	private final MonitorMasterDetailsBlock block;

	protected LayoutControl(MonitorMasterDetailsBlock block, String id) {
		super(id);
		this.block = block;
	}

	@Override
	protected Control createControl(Composite parent) {
		
		Composite controlComposite = new Composite(parent, SWT.BORDER);
		GridLayout filterLayout = new GridLayout();
		filterLayout.numColumns = 1;
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		controlComposite.setLayout(filterLayout);
		controlComposite.setFont(parent.getFont());

		controlComposite.setLayoutData(
				new GridData(SWT.FILL, SWT.BEGINNING,
				true, false));
		
		createCombo(controlComposite);
		return controlComposite;
	}

	private void createCombo(Composite parent) {
		final Combo combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setToolTipText(
				"Sets the type of layout to use for drawing the graph.");

		for (Layout layout : Layout.values()) {
			combo.add(layout.name());
		}

		combo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {

				switch (Layout.valueOf(combo.getText())) {
				case HORIZONTAL:
					block.setHorizontalLayout();
					break;

				case SPRING:
					block.setSpringLayout();
					break;

				case GRID:
					block.setGridLayout();
					break;

				case RADIAL:
					block.setRadialLayout();
					break;

				case TREE:
					block.setTreeLayout();
					break;
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				block.setTreeLayout();
			}
		});
		combo.select(4);
		
		
		GridData gridData = 
			new GridData(SWT.FILL, SWT.TOP, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		combo.setLayoutData(gridData);
		combo.pack();
	}

}