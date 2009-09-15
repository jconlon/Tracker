package com.verticon.tracker.swtbot.addition;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * @author jconlon
 * 
 */
public class NewPremisesWizardPageObject extends
		WizardPageObject<SWTWorkbenchBot> {
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	public NewPremisesWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "New Premises Document", "Cancel", "Finish", null, null);
	}

	private void init() {
		itsBot.menu("File").menu("New").menu("Premises Document").click();
		initialized.set(true);
	}

	public void creatAPremisesDocument(String nameOfProject, String docName) {
		itsBot.textWithLabel("Enter or select the parent folder:").setText(
				nameOfProject);
		itsBot.textWithLabel("File name:").setText(docName);
		finish();
		waitForPageToClose();
	}

	@Override
	public void waitForPageToOpen() {
		if (!initialized.get()) {
			init();
		}
		super.waitForPageToOpen();
	}

}
