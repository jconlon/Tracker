package com.verticon.tracker.trigger.view.views;

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

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.ITriggerEntry;

public class ValuesDialog extends TitleAreaDialog {


	private Text values;
	private String result;
	private final ITriggerEntry triggerEntry;
	private Text requiredValues;
	private final int countRequired;
	private final String requiredValuesValue;
	private Button addButton;


	public ValuesDialog(Shell parentShell, ITriggerEntry triggerEntry) {
		super(parentShell);
		this.triggerEntry = triggerEntry;
		this.requiredValuesValue = triggerEntry.getRequireValues();
		Iterable<String> split = Splitter.on(',').trimResults()
				.split(requiredValuesValue);
		this.countRequired = Iterables.size(split);

	}


	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Values Selector");

		// Set the message
		setMessage(String.format("Specify %s comma separated values.",
				countRequired), IMessageProvider.INFORMATION);

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
		label1.setText("Names of the Required Values:");

		requiredValues = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
		requiredValues.setLayoutData(gridData);
		requiredValues.setText(triggerEntry.getRequireValues());

		Label label2 = new Label(parent, SWT.NONE);
		label2.setText(String.format("%s Values:", countRequired));
		// You should not re-use GridData
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		values = new Text(parent, SWT.BORDER);
		values.setText(triggerEntry.getValues());
		values.setLayoutData(gridData);
		values.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

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
		createOkButton(parent, OK, "Add", true);
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
		isValidInput();
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
		return addButton;
	}

	private boolean isValidInput() {
		boolean valid = true;

		if (values.getText().length() == 0) {
			setErrorMessage(String.format(
					"Please add %s comma separated values.",
					countRequired));
			valid = false;
		} else if (countRequired != countOfValues()) {
			setErrorMessage(String.format(
					"You must specify %s comma separted values instead of %s.",
					countRequired, countOfValues()));
			valid = false;
		}
		addButton.setEnabled(valid);
		return valid;
	}

	private int countOfValues() {
		Iterable<String> split = Splitter.on(',').trimResults()
				.split(values.getText());
		return Iterables.size(split);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// Coyy textFields because the UI gets disposed
	// and the Text Fields are not accessible any more.
	private void saveInput() {

		result = values.getText();
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getValues() {
		return result;
	}
}