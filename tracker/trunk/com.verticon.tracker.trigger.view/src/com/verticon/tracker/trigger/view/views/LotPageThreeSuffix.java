package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.collect.Lists.newLinkedList;

import java.util.Collections;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

public class LotPageThreeSuffix extends WizardPage {
	private Text text1;
	private Composite container;
	private List<String> validSuffixes = null;

	public LotPageThreeSuffix() {
		super("Third Page");
		setTitle("Lot Creatiion Wizard");
		setDescription("Enter the suffix for the Lot");
		setControl(text1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			validate();
		}
		super.setVisible(visible);
	}

	@Override
	public void createControl(Composite parent) {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String suffixes = store
				.getString(PreferenceConstants.P_VALID_LOT_SUFFIXES_STRING);
		Iterable<String> elements = null;
		if (!isNullOrEmpty(suffixes)) {
			elements = Splitter.on(',').trimResults()
					.split(suffixes);

			validSuffixes = newLinkedList(elements);

		} else {
			validSuffixes = Collections.emptyList();
		}

		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Lot Suffix:");

		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		List<String> initialTextValues = ((LotWizard) getWizard())
				.getCurrentValues();
		String myValue = initialTextValues.size() > 2 ? initialTextValues
				.get(2) : null;
		text1.setText(nullToEmpty(myValue));
		text1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}

		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);

		if (Iterables.isEmpty(elements)) {
			text1.setVisible(true);
			label1.setVisible(true);
		} else {
			text1.setVisible(false);
			label1.setVisible(false);
			Label label2 = new Label(container, SWT.NULL);
			label2.setText("Choose a Lot Suffix:");

			final Combo combo1 = new Combo(container, SWT.VERTICAL
					| SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);

			String[] items = Iterables.toArray(elements, String.class);
			combo1.setItems(items);
			if (!isNullOrEmpty(text1.getText())) {
				for (int i = 0; i < items.length; i++) {
					if (items[i].equals(text1.getText())) {
						combo1.select(i);
						break;
					}
				}
			}
			combo1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					text1.setText(combo1.getText());
					validate();
				}
			});

		}

		// Required to avoid an error in the system
		setControl(container);
		validate();
	}


	private void validate() {
		if (!text1.getText().isEmpty()) {
			if (validSuffixes.isEmpty()) {
				setPageComplete(true);
			} else if (validSuffixes.contains(text1.getText())) {
				setPageComplete(true);
			} else {
				setPageComplete(false);
			}
		} else {
			setPageComplete(true);
		}
	}

	public String getText1() {
		return text1.getText();
	}
}
