package org.json.ui.contentassist;

import java.util.Date;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.json.validation.MongoQueryJavaValidator;

/**
 * DateDialog is based on the Nebula CDateTime Component.  The pattern is set to the default pattern from the JSON
 * validator which includes a TimeZone offset.  Clearing the control and choosing add will return a new Date() string.
 * @author jconlon
 *
 */
public class DateDialog extends TitleAreaDialog {

	private String dateTime;
	private CDateTime cdt;

	protected DateDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Date and Time Picker");
		// Set the message
		setMessage("Please choose a date and and optional time",
				IMessageProvider.INFORMATION);

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		// layout.horizontalAlignment = GridData.FILL;
		parent.setLayout(layout);

		cdt = new CDateTime(parent, CDT.BORDER | CDT.COMPACT | CDT.DROP_DOWN
				| CDT.DATE_LONG | CDT.TIME_MEDIUM);
		cdt.setSelection(new Date());
		cdt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		cdt.setPattern(MongoQueryJavaValidator.DATE_PATTERN);

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
		createOkButton(parent, OK, "OK", true);
		// Add a SelectionListener

		// Create Cancel button
		Button cancelButton = createButton(parent, CANCEL, "Cancel", false);
		// Add a SelectionListener
		cancelButton.addSelectionListener(new SelectionAdapter() {
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
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());
		button.setData(new Integer(id));
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {

				okPressed();

			}
		});
		if (defaultButton) {
			Shell shell = parent.getShell();
			if (shell != null) {
				shell.setDefaultButton(button);
			}
		}
		setButtonLayoutData(button);
		return button;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// We need to have the textFields into Strings because the UI gets disposed
	// and the Text Fields are not accessible any more.
	private void saveInput() {
		Date date = cdt.getSelection();
		StringBuffer sb = new StringBuffer("new Date(");
		if (date != null) {
			sb.append('"')
					.append(MongoQueryJavaValidator.DATE_FORMAT.format(date))
					.append('"');
		}
		sb.append(')');
		dateTime = sb.toString();
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getDateTime() {

		return dateTime;
	}

}
