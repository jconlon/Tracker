package com.verticon.tracker.swtbot.addition;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 *bot.menu("File").menu("New").menu("Animal Document").click();
 * bot.shell("New Animal Document").activate();
 * bot.textWithLabel("Enter or select the parent folder:"
 * ).setText(MY_FIRST_PROJECT);
 * bot.textWithLabel("File name:").setText(EXAMPLE_ANIMAL);
 * bot.button("Next >").click(); bot.comboBox(0).setSelection("Swine");
 * bot.button("Finish").click();
 * 
 * 
 * @author jconlon
 * 
 */
public class NewAnimalWizardPageObject extends
		WizardPageObject<SWTWorkbenchBot> {
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	public NewAnimalWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "New Animal Document", "Cancel", "Finish", "< Back",
				"Next >");
	}

	private void init() {
		itsBot.menu("File").menu("New").menu("Animal Document").click();
		initialized.set(true);
	}

	public void creatAnAnimalDocument(String nameOfProject, String docName,
			String type) {
		itsBot.textWithLabel("Enter or select the parent folder:").setText(
				nameOfProject);
		itsBot.textWithLabel("File name:").setText(docName);
		next();
		waitForPageToOpen();
		itsBot.comboBox(0).setSelection(type);
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
