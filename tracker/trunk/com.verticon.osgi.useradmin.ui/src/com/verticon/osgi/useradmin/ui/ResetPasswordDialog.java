package com.verticon.osgi.useradmin.ui;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ResetPasswordDialog extends TitleAreaDialog {

	private Text currrentPasswordText;
	private Text passwordText;
	private Text confirmPasswordText;
	private String userName;
	private String password;
	private Button addButton;

	public ResetPasswordDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Reset Password");
		// Set the message
		setMessage("Enter Current and new Password",
				IMessageProvider.INFORMATION);

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		// layout.horizontalAlignment = GridData.FILL;
		parent.setLayout(layout);

		// The text fields will grow with the size of the dialog
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		Label label1 = new Label(parent, SWT.NONE);
		label1.setText("Current Password:");

		currrentPasswordText = new Text(parent, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		currrentPasswordText.setLayoutData(gridData);
		currrentPasswordText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// ignore

			}

			@Override
			public void keyReleased(KeyEvent e) {
				isValidInput();
			}

		});

		Label passwordLabel = new Label(parent, SWT.NONE);
		passwordLabel.setText("New Password: ");
		// You should not re-use GridData
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		passwordText = new Text(parent, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		passwordText.setLayoutData(gridData);
		passwordText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// ignore

			}

			@Override
			public void keyReleased(KeyEvent e) {
				isValidInput();
			}

		});

		Label confirmPasswordLabel = new Label(parent, SWT.NONE);
		confirmPasswordLabel.setText("Confirm Password: ");
		// You should not re-use GridData
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		confirmPasswordText = new Text(parent, SWT.BORDER | SWT.SINGLE
				| SWT.PASSWORD);
		confirmPasswordText.setLayoutData(gridData);
		confirmPasswordText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// ignore

			}

			@Override
			public void keyReleased(KeyEvent e) {
				isValidInput();
			}

		});
		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = SWT.CENTER;

		parent.setLayoutData(gridData);
		// Create Add button
		// Own method as we need to overview the SelectionAdapter
		createOkButton(parent, OK, "Reset", true);
		// Add a SelectionListener

		// Create Cancel button
		Button cancelButton = createButton(parent, CANCEL, "Cancel", false);
		// Add a SelectionListener
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setReturnCode(CANCEL);
				close();
			}
		});
	}

	protected Button createOkButton(Composite parent, int id, String label,
			boolean defaultButton) {
		// increment the number of columns in the button bar
		((GridLayout) parent.getLayout()).numColumns++;
		addButton = new Button(parent, SWT.PUSH);
		addButton.setText(label);
		addButton.setFont(JFaceResources.getDialogFont());
		addButton.setData(new Integer(id));
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (isValidInput()) {
					okPressed();
				}
			}
		});
		if (defaultButton) {
			Shell shell = parent.getShell();
			if (shell != null) {
				shell.setDefaultButton(addButton);
			}
		}
		setButtonLayoutData(addButton);
		addButton.setEnabled(false);
		return addButton;
	}

	private boolean isValidInput() {
		addButton.setEnabled(false);
		boolean valid = true;
		setErrorMessage(null);
		valid = isConfirmedPassword();
		valid = isValidPassword() && valid;
		valid = isValidCurrentPassword() && valid;
		addButton.setEnabled(valid);
		if (valid) {
			setErrorMessage(null);
		}
		return valid;
	}

	private boolean isValidPassword() {
		boolean valid = true;
		if (passwordText.getText().length() < 8) {
			String message = "New Password must be 8 characters or longer.";
			setErrorMessage(message);
			valid = false;
		}
		return valid;
	}

	private boolean isConfirmedPassword() {
		boolean valid = true;
		if (!passwordText.getText().equals(confirmPasswordText.getText())) {
			String message = "New Password and confirmed password are not the same.";
			setErrorMessage(message);
			valid = false;
		}
		return valid;
	}

	private boolean isValidCurrentPassword() {
		boolean valid = true;
		if (currrentPasswordText.getText().length() < 8) {
			setErrorMessage("Current password must be 8 characters or longer.");
			valid = false;
		}
		return valid;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// Coyy textFields because the UI gets disposed
	// and the Text Fields are not accessible any more.
	private void saveInput() {
		userName = currrentPasswordText.getText();
		password = passwordText.getText();
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getCurrentPassword() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}