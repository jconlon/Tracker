package com.verticon.google.kmlgx.internal;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;
import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileExportOperation;

public class KmxFileWizardExportResourcePage extends WizardExportResourcesPage {

	private static final String STORE_DESTINATION_NAMES_ID = "KmxFileWizardExportResourcePage.STORE_DESTINATION_NAMES"; //$NON-NLS-1$

	// widgets
	private Combo destinationNameField;
	private Button destinationBrowseButton;

	/**
	 * Create an instance of this class.
	 * 
	 * @param name
	 *            java.lang.String
	 */
	protected KmxFileWizardExportResourcePage(String name,
			IStructuredSelection selection) {
		super(name, selection);
	}

	/**
	 * Create an instance of this class
	 * 
	 * @param selection
	 *            the selection
	 */
	public KmxFileWizardExportResourcePage(IStructuredSelection selection) {
		this("kmzFileExportPage1", selection); //$NON-NLS-1$
		setTitle("KMZ Export");
		setDescription("Export a project containing a doc.kml file, to a geobrowser compliant KMZ archive.");
	}

	/**
	 * The Finish button was pressed. Try to do the required work now and answer
	 * a boolean indicating success. If false is returned then the wizard will
	 * not close.
	 * 
	 * @returns boolean
	 */
	public boolean finish() {
		List<?> resourcesToExport = getWhiteCheckedResources();

		if (!ensureTargetIsValid()) {
			return false;
		}

		// Save dirty editors if possible but do not stop if not all are saved
		saveDirtyEditors();
		// about to invoke the operation so save our state
		saveWidgetValues();

		return executeExportOperation(new ArchiveFileExportOperation(null,
				resourcesToExport, getDestinationValue()));
	}

	/**
	 * Handle all events and enablements for widgets in this page
	 * 
	 * @param e
	 *            Event
	 */
	@Override
	public void handleEvent(Event e) {
		Widget source = e.widget;

		if (source == destinationBrowseButton) {
			handleDestinationBrowseButtonPressed();
		}

		updatePageCompletion();
	}

	/**
	 * Create the export destination specification widgets
	 * 
	 * @param parent
	 *            org.eclipse.swt.widgets.Composite
	 */
	@Override
	protected void createDestinationGroup(Composite parent) {

		Font font = parent.getFont();
		// destination specification group
		Composite destinationSelectionGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		destinationSelectionGroup.setLayout(layout);
		destinationSelectionGroup.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));
		destinationSelectionGroup.setFont(font);

		Label destinationLabel = new Label(destinationSelectionGroup, SWT.NONE);
		destinationLabel.setText(getDestinationLabel());
		destinationLabel.setFont(font);

		// destination name entry field
		destinationNameField = new Combo(destinationSelectionGroup, SWT.SINGLE
				| SWT.BORDER);
		destinationNameField.addListener(SWT.Modify, this);
		destinationNameField.addListener(SWT.Selection, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		destinationNameField.setLayoutData(data);
		destinationNameField.setFont(font);

		// destination browse button
		destinationBrowseButton = new Button(destinationSelectionGroup,
				SWT.PUSH);
		destinationBrowseButton.setText("Browse");
		destinationBrowseButton.addListener(SWT.Selection, this);
		destinationBrowseButton.setFont(font);
		setButtonLayoutData(destinationBrowseButton);

		new Label(parent, SWT.NONE); // vertical spacer
	}

	/**
	 * Create the export options specification widgets.
	 * 
	 */
	protected void createOptionsGroupButtons(Group optionsGroup) {
		// There are no options so remove the label on the group
		optionsGroup.setText("");
	}

	/**
	 * Returns a boolean indicating whether the directory portion of the passed
	 * pathname is valid and available for use.
	 */
	protected boolean ensureTargetDirectoryIsValid(String fullPathname) {
		int separatorIndex = fullPathname.lastIndexOf(File.separator);

		if (separatorIndex == -1) {
			return true;
		}

		return ensureTargetIsValid(new File(fullPathname.substring(0,
				separatorIndex)));
	}

	/**
	 * If the target for export does not exist then attempt to create it. Answer
	 * a boolean indicating whether the target exists (ie.- if it either
	 * pre-existed or this method was able to create it)
	 * 
	 * @return boolean
	 */
	private boolean ensureTargetIsValid(File targetDirectory) {
		if (targetDirectory.exists() && !targetDirectory.isDirectory()) {
			displayErrorDialog("File export directory already exists");
			giveFocusToDestination();
			return false;
		}

		return ensureDirectoryExists(targetDirectory);
	}

	/**
	 * Attempts to ensure that the specified directory exists on the local file
	 * system. Answers a boolean indicating success.
	 * 
	 * @return boolean
	 * @param directory
	 *            java.io.File
	 */
	private boolean ensureDirectoryExists(File directory) {
		if (!directory.exists()) {
			if (!queryYesNoQuestion("Should the target directory be created?")) {
				return false;
			}

			if (!directory.mkdirs()) {
				displayErrorDialog("Directory Creation Error");
				giveFocusToDestination();
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a boolean indicating whether the passed File handle is is valid
	 * and available for use.
	 */
	private boolean ensureTargetFileIsValid(File targetFile) {
		if (targetFile.exists() && targetFile.isDirectory()) {
			displayErrorDialog("Target must be a file");
			giveFocusToDestination();
			return false;
		}

		if (targetFile.exists()) {
			if (targetFile.canWrite()) {
				if (!queryYesNoQuestion("Target file already exists, would you like to overwrite it?")) {
					return false;
				}
			} else {
				displayErrorDialog("Target file already exists, but it can't be overwritten.");
				giveFocusToDestination();
				return false;
			}
		}

		return true;
	}

	/**
	 * Set the current input focus to self's destination entry field
	 */
	private void giveFocusToDestination() {
		destinationNameField.setFocus();
	}

	/**
	 * Ensures that the target output file and its containing directory are both
	 * valid and able to be used. Answer a boolean indicating validity.
	 */
	private boolean ensureTargetIsValid() {
		String targetPath = getDestinationValue();

		if (!ensureTargetDirectoryIsValid(targetPath)) {
			return false;
		}

		if (!ensureTargetFileIsValid(new File(targetPath))) {
			return false;
		}

		return true;
	}

	/**
	 * Export the passed resource and recursively export all of its child
	 * resources (iff it's a container). Answer a boolean indicating success.
	 */
	private boolean executeExportOperation(ArchiveFileExportOperation op) {

		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			displayErrorDialog(e.getTargetException());
			return false;
		}

		IStatus status = op.getStatus();
		if (!status.isOK()) {
			ErrorDialog.openError(getContainer().getShell(),
					"Failed to export the KMZ file.", null, // no special
															// message
					status);
			return false;
		}

		return true;
	}

	/**
	 * Answer the string to display in the receiver as the destination type
	 */
	private String getDestinationLabel() {
		return "Destination";
	}

	/**
	 * Answer the contents of self's destination specification widget. If this
	 * value does not have a suffix then add it first.
	 */
	private String getDestinationValue() {
		String idealSuffix = getOutputSuffix();
		String destinationText = destinationNameField.getText().trim();

		// only append a suffix if the destination doesn't already have a . in
		// its last path segment.
		// Also prevent the user from selecting a directory. Allowing this will
		// create a ".zip" file in the directory
		if (destinationText.length() != 0
				&& !destinationText.endsWith(File.separator)) {
			int dotIndex = destinationText.lastIndexOf('.');
			if (dotIndex != -1) {
				// the last path seperator index
				int pathSepIndex = destinationText.lastIndexOf(File.separator);
				if (pathSepIndex != -1 && dotIndex < pathSepIndex) {
					destinationText += idealSuffix;
				}
			} else {
				destinationText += idealSuffix;
			}
		}

		return destinationText;
	}

	/**
	 * Answer the suffix that files exported from this wizard should have. If
	 * this suffix is a file extension (which is typically the case) then it
	 * must include the leading period character.
	 * 
	 */
	private String getOutputSuffix() {
		return ".kmz"; //$NON-NLS-1$

	}

	/**
	 * Open an appropriate destination browser so that the user can specify a
	 * source to import from
	 */
	private void handleDestinationBrowseButtonPressed() {
		FileDialog dialog = new FileDialog(getContainer().getShell(), SWT.SAVE
				| SWT.SHEET);
		dialog.setFilterExtensions(new String[] { "*.kmz", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
		dialog.setText("to KMZ archive");
		String currentSourceString = getDestinationValue();
		int lastSeparatorIndex = currentSourceString
				.lastIndexOf(File.separator);
		if (lastSeparatorIndex != -1) {
			dialog.setFilterPath(currentSourceString.substring(0,
					lastSeparatorIndex));
		}
		String selectedFileName = dialog.open();

		if (selectedFileName != null) {
			setErrorMessage(null);
			destinationNameField.setText(selectedFileName);
		}
	}

	/**
	 * Hook method for saving widget values for restoration by the next instance
	 * of this class.
	 */
	protected void internalSaveWidgetValues() {
		// update directory names history
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			String[] directoryNames = settings
					.getArray(STORE_DESTINATION_NAMES_ID);
			if (directoryNames == null) {
				directoryNames = new String[0];
			}

			directoryNames = addToHistory(directoryNames, getDestinationValue());
			settings.put(STORE_DESTINATION_NAMES_ID, directoryNames);
		}
	}

	/**
	 * Hook method for restoring widget values to the values that they held last
	 * time this wizard was used to completion.
	 */
	protected void restoreWidgetValues() {
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			String[] directoryNames = settings
					.getArray(STORE_DESTINATION_NAMES_ID);
			if (directoryNames == null) {
				return; // ie.- no settings stored
			}

			// destination
			destinationNameField.setText(directoryNames[0]);
			for (int i = 0; i < directoryNames.length; i++) {
				addDestinationItem(directoryNames[i]);
			}

		}
	}

	/**
	 * Clear messages and validate source has only one selected project and that
	 * project contains a doc.kml file.
	 * 
	 * 
	 * @see org.eclipse.ui.dialogs.WizardDataTransferPage#validateSourceGroup()
	 */
	@Override
	protected boolean validateSourceGroup() {
		setErrorMessage(null);
		setMessage(null);
		if (getWhiteCheckedResources().isEmpty()) {
			return false;
		} else if (!oneProject()) {
			setErrorMessage("Select only one project for export.");
			return false;
		}

		if (!selectedRootKMLDoc()) {
			setErrorMessage("Project cannot be exported to KMZ file because it has no doc.kml file.");
			return false;
		}
		return super.validateSourceGroup();
	}

	private boolean oneProject() {
		List<?> resources = getWhiteCheckedResources();
		boolean oneProject = false;
		for (Object object : resources) {
			if (object instanceof IProject) {
				if (oneProject) {
					return false;
				}
				oneProject = true;
			}
		}
		return oneProject;
	}

	private boolean selectedRootKMLDoc() {
		List<?> resources = getSelectedResources();
		for (Object object : resources) {
			IResource resource = (IResource) object;
			if (resource.getName().equals("doc.kml")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Add the passed value to self's destination widget's history
	 * 
	 * @param value
	 *            java.lang.String
	 */
	protected void addDestinationItem(String value) {
		destinationNameField.add(value);
	}
}
