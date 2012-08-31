package com.verticon.ui.dialogs;

import java.text.SimpleDateFormat;
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
//import org.json.validation.MongoQueryJavaValidator;

/**
 * DateDialog is based on the Nebula CDateTime Component.  The pattern is set to the default pattern from the JSON
 * validator which includes a TimeZone offset.  Clearing the control and choosing add will return a new Date() string.
 * @author jconlon
 *
 */
public class DateDialog extends TitleAreaDialog {

	/**
	 * Tue, 03 Jul 1980 13:44:59 EST
	 * Wed Oct 12 2011 10:54:02 GMT-0400
	 */
//	public static final String DATE_PATTERN_DEFAULT = "EEE, dd MMM yyyy HH:mm:ss Z";
	
	protected String dateTime;
	private CDateTime cdt;
	private final String pattern;
	private final SimpleDateFormat format;
	
	public DateDialog(Shell parentShell, String pattern) {
		super(parentShell);
		this.pattern =pattern;
		this.format = new SimpleDateFormat(pattern);
	}

	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Date and Time Picker");
		// Set the message
		setMessage("Please choose a date and an optional time",
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
		cdt.setPattern(pattern);

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

	protected Date getSelection(){
		return cdt.getSelection();
	}
	
	protected String getFormatedDate(){
		return format.format(getSelection());
	}
	// We need to have the textFields into Strings because the UI gets disposed
	// and the Text Fields are not accessible any more.
	protected String saveInput() {
		return getFormatedDate();
	}

	@Override
	protected void okPressed() {
		dateTime = saveInput();
		super.okPressed();
	}

	public String getDateTime() {

		return dateTime;
	}

}
