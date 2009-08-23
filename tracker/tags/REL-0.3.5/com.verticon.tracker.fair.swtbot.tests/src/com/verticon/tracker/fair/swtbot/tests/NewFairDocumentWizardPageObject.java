package com.verticon.tracker.fair.swtbot.tests;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * @author jconlon
 * 
 */
 class NewFairDocumentWizardPageObject extends
		WizardPageObject<SWTWorkbenchBot> {
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	public NewFairDocumentWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "New Fair Document");
	}

	private void init() {
		itsBot.menu("File").menu("New").menu("Fair Document").click();
		initialized.set(true);
	}

	public void createAFairDocument(String nameOfProject, String docName) {
		log.debug("Creating "+docName+" in "+ nameOfProject);
		itsBot.textWithLabel("Enter or select the parent folder:").setText(
				nameOfProject);
		itsBot.textWithLabel("File name:").setText(docName);
		next();
		waitForPageToOpen();
		itsBot.comboBox(0).setSelection("Fair");
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
	
	public void loadResource(){
		
	}

}
