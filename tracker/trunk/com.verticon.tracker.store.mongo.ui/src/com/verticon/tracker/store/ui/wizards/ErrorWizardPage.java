package com.verticon.tracker.store.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ErrorWizardPage extends WizardPage {
	private Composite container;

	protected ErrorWizardPage(String title, String errorMessage,
			String description) {
		super("Illegal State");
		setTitle(title);
		setDescription(description);

		setErrorMessage(errorMessage);
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText(getDescription());
		label1.setForeground(parent.getDisplay().getSystemColor(
				SWT.COLOR_DARK_RED));
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

}
