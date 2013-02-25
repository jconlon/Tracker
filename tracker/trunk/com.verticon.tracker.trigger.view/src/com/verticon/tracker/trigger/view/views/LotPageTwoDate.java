package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

public class LotPageTwoDate extends WizardPage {

	private Text text1;
	private Composite container;
	static final String USE_CURRENT_DATE = "USE TIME OF WEIGHING";
	private boolean initialized = false;
	private Button useWeighingDate;

	public LotPageTwoDate() {
		super("Second Page");
		setTitle("Lot Creatiion Wizard");
		setDescription("Please enter a value for the Lot Date field or check the box"
				+ " to have the system insert the format characters to print the date at weighing."
				+ "(Note the format characters are specified in the user preferences.)");
		setControl(text1);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		if (!initialized && visible && isNullOrEmpty(text1.getText())) {
			useWeighingDate.setSelection(true);
			initialized = true;
			setPageComplete(true);
		}
		if (visible) {
			validate();
		}
		super.setVisible(visible);
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Date:");

		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);

		text1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!text1.getText().isEmpty()) {
					useWeighingDate.setSelection(false);
				}
				validate();
			}



		});
		List<String> initialTextValues = ((LotWizard) getWizard())
				.getCurrentValues();
		String myValue = initialTextValues.size() > 1 ? initialTextValues
				.get(1) : null;
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String lotDateFormatter = store
				.getString(PreferenceConstants.P_LOT_DAY_AT_WEIGHING_FORMATTER);
		if (!isNullOrEmpty(myValue)
 && !lotDateFormatter.equals(myValue)) {
			text1.setText(myValue);
		}

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);
		Label labelCheck = new Label(container, SWT.NONE);
		labelCheck.setText("Add date at weighing");
		useWeighingDate = new Button(container, SWT.CHECK);
		useWeighingDate
				.setToolTipText("This will add a date formatting field to the Lot number, (Yes it's ugly.)");
		if (isNullOrEmpty(text1.getText())) {
			useWeighingDate.setSelection(true);
		} else {
			useWeighingDate.setSelection(false);
		}
		useWeighingDate.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				if (useWeighingDate.getSelection()) {
					text1.setText("");
				}
				validate();
			}
		});
		// Required to avoid an error in the system
		setControl(container);
		validate();
	}

	private void validate() {
		if (!text1.getText().isEmpty() || useWeighingDate.getSelection()) {
			setPageComplete(true);
		} else {
			setPageComplete(false);
		}
	}
	public String getText1() {
		if (useWeighingDate.getSelection()) {
			IPreferenceStore store = TriggerViewPlugin.getDefault()
					.getPreferenceStore();
			return store
					.getString(PreferenceConstants.P_LOT_DAY_AT_WEIGHING_FORMATTER);
		}
		return text1.getText();
	}
}
