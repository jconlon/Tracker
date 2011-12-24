package com.verticon.tracker.swtbot.addition;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

public class NewExampleWizardPageObject extends
		WizardPageObject<SWTWorkbenchBot> {
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	public NewExampleWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "New Example", "Cancel", "Finish", "< Back", "Next >");
	}

	private void init() {
		itsBot.menu("File").menu("New").menu("Example...").click();
		initialized.set(true);
	}

	public void creatAnExampleProject(String nameCategory, String example,
			String nameOfProject) {
		itsBot.tree().expandNode(nameCategory).select(example);
		next();
		itsBot.textWithLabel("Project name:").setText(nameOfProject);
	}

	@Override
	public void waitForPageToOpen() {
		if (!initialized.get()) {
			init();
		}
		super.waitForPageToOpen();
	}

}
