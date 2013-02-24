package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Strings.nullToEmpty;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

public class LotPageOneID extends WizardPage {
	private Text text1;
	private Composite container;
	private int maxLength;

	public LotPageOneID() {
		super("First Page");
		setTitle("Lot Creatiion Wizard");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			validateText();
		}
		super.setVisible(visible);
	}

	@Override
	public void createControl(Composite parent) {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		maxLength = store
				.getInt(PreferenceConstants.P_VALID_LOT_ID_MAX_SIZE_INTEGER);
		if(maxLength==0){
			setDescription("Please enter a value for the Lot ID.");
			maxLength = Integer.MAX_VALUE;
		}else{
			setDescription(String.format("Please enter a value for the Lot ID. Maximum number of characters are %s.",
							maxLength));
			
		}
		 
		
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Lot ID:");

		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		List<String> initialTextValues = ((LotWizard) getWizard())
				.getCurrentValues();
		String myValue = initialTextValues.isEmpty() ? null : initialTextValues
				.get(0);
		text1.setText(nullToEmpty(myValue));
		text1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				validateText();
			}



		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);
		// Required to avoid an error in the system
		setControl(container);
		validateText();

	}

	private void validateText() {
		if (!text1.getText().isEmpty()) {
			int currentTextSize = text1.getText().length();
			if (currentTextSize > maxLength) {
				setPageComplete(false);
			} else {
				setPageComplete(true);
			}
		}
	}

	public String getText1() {
		return text1.getText();
	}
}