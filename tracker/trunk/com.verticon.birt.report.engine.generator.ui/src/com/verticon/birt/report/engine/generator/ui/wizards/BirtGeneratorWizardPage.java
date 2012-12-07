package com.verticon.birt.report.engine.generator.ui.wizards;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.birt.report.engine.generator.EmitterType;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (rtpdesign).
 */

public class BirtGeneratorWizardPage extends WizardPage {
	private Text reportsDirectoryText;

	private Text reportParametersDesignText;

	private Text destinationDirectoryText;

	private boolean clearDestinationDirectory = true;

	private EmitterType emitterType = EmitterType.PDF;


	/**
	 * @return the clearDestinationDirectory
	 */
	public boolean isClearDestinationDirectory() {
		return clearDestinationDirectory;
	}

	/**
	 * @return the emitterType
	 */
	public EmitterType getEmitterType() {
		return emitterType;
	}

	private final ISelection selection;

	/**
	 * 
	 * @param selection
	 */
	public BirtGeneratorWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("BIRT Report Engine Generator");
		setDescription("This wizard generates BIRT reports from a *.rtpdesign that contains report parameters, a directory of reports and a destination directory.");
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		// Reports directory
		Label label = new Label(container, SWT.NULL);
		label.setText("&Reports Directory:");
		label.setToolTipText("Directory containing the reports to generate.");

		reportsDirectoryText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		reportsDirectoryText.setLayoutData(gd);
		reportsDirectoryText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText("...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(reportsDirectoryText
						.getShell());

				// Set the initial filter path according
				// to anything they've selected or typed in
				dlg.setFilterPath(reportsDirectoryText.getText());

				// Change the title bar text
				dlg.setText("Reports Directory");

				// Customizable message displayed in the dialog
				dlg.setMessage("Select the directory containing the rptdesign files to generate");

				// Calling open() will open and run the dialog.
				// It will return the selected directory, or
				// null if user cancels
				String dir = dlg.open();
				if (dir != null) {
					// Set the text box to the new selection
					reportsDirectoryText.setText(dir);
				}
			}
		});

		// Destination directory
		label = new Label(container, SWT.NULL);
		label.setText("&Destination Directory:");
		label.setToolTipText("Destination for the generated reports.");

		destinationDirectoryText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		destinationDirectoryText.setLayoutData(gd);
		destinationDirectoryText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		button = new Button(container, SWT.PUSH);
		button.setText("...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(
						destinationDirectoryText.getShell());

				// Set the initial filter path according
				// to anything they've selected or typed in
				dlg.setFilterPath(destinationDirectoryText.getText());

				// Change the title bar text
				dlg.setText("Destination Directory");

				// Customizable message displayed in the dialog
				dlg.setMessage("Select a destination directory for the generated reports");

				// Calling open() will open and run the dialog.
				// It will return the selected directory, or
				// null if user cancels
				String dir = dlg.open();
				if (dir != null) {
					// Set the text box to the new selection
					destinationDirectoryText.setText(dir);
				}
			}
		});

		// Report parameters rptdesign file
		label = new Label(container, SWT.NULL);
		label.setText("Report Parameters rptdesign:");
		label.setToolTipText("Report design that creates a table of Report Parameter names and values to use as report parameters.");
		label.setLayoutData(gd);

		reportParametersDesignText = new Text(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		reportParametersDesignText.setLayoutData(gd);
		// setPageComplete(false);
		reportParametersDesignText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}

		});

		button = new Button(container, SWT.RIGHT);
		button.setText("..."); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(reportParametersDesignText
						.getShell());
				String[] extension = { "*.rptdesign" };

				dlg.setFilterExtensions(extension);
				if (reportParametersDesignText.getText() != null
						&& reportParametersDesignText.getText().trim().length() > 0) {

					dlg.setFilterPath(reportParametersDesignText.getText());

				}

				// Change the title bar text
				dlg.setText("Report parameters rptdesign");

				String selectedLocation = dlg.open();
				if (selectedLocation != null) {
					reportParametersDesignText.setText(selectedLocation);
				}
			}

		});
		// Create the emitter group
		Group group1 = new Group(container, SWT.SHADOW_IN);
		group1.setText("Report format");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button htmlButton = new Button(group1, SWT.RADIO);
		htmlButton.setText("HTML");
		htmlButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				emitterType = EmitterType.HTML;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		Button htmlEmbeddedButton = new Button(group1, SWT.RADIO);
		htmlEmbeddedButton.setText("HTML EMBEDDABLE");
		htmlEmbeddedButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				emitterType = EmitterType.HTML_EMBEDDABLE;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		Button pdfButton = new Button(group1, SWT.RADIO);
		pdfButton.setText("PDF");
		pdfButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				emitterType = EmitterType.PDF;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		pdfButton.setSelection(true);

		button = new Button(container, SWT.CHECK);
		button.setText("Clear Destination");
		button.setToolTipText("Clear the destination directory prior to moving generated reports.");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent theEvent) {
				clearDestinationDirectory = ((Button) (theEvent.widget))
						.getSelection();
			}
		});
		button.setSelection(true);

		initialize();
		dialogChanged();
		setControl(container);
	}

	File getReportsDirectory() {
		return new File(getReportsDirectoryName());
	}

	File getDestinationDirectory() {
		return new File(getDestinationDirectoryName());
	}

	File getReportsParameters() {
		return new File(getReportParametersName());
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
				reportsDirectoryText
						.setText(container.getFullPath().toString());
			}
		}

	}


	/**
	 * Ensures that all three text fields are set.
	 */

	private void dialogChanged() {

		// Reports Directory
		if (getReportsDirectoryName().length() == 0) {
			updateStatus("Reports directory must be specified");
			return;
		}

		if (!getReportsDirectory().isDirectory()) {
			updateStatus("Reports directory must exist");
			return;
		}

		// Destination Directory
		if (getDestinationDirectoryName().length() == 0) {
			updateStatus("Destination directory must be specified");
			return;
		}
		if (!getDestinationDirectory().isDirectory()) {
			updateStatus("Destination directory must exist");
			return;
		}

		// ReportParameters rptdesign
		if (getReportParametersName().length() == 0) {
			updateStatus("Report Parameter rptdesign name must be specified");
			return;
		}
		if (!getReportsParameters().isFile()) {
			updateStatus("Report Parameters Design must exist");
			return;
		}

		if (!getReportsParameters().getName().endsWith(".rptdesign")) {
			updateStatus("File extension must be \"rptdesign\"");
			return;

		}
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	private String getReportsDirectoryName() {
		return reportsDirectoryText.getText();
	}

	private String getDestinationDirectoryName() {
		return destinationDirectoryText.getText();
	}

	private String getReportParametersName() {
		return reportParametersDesignText.getText();
	}
}