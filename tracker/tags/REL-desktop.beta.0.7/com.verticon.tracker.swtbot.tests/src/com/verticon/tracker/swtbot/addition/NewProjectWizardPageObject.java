package com.verticon.tracker.swtbot.addition;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

public class NewProjectWizardPageObject extends
		WizardPageObject<SWTWorkbenchBot> {
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	public NewProjectWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "New Project", "Cancel", "Finish", "< Back", "Next >");
	}

	private void init() {
		itsBot.menu("File").menu("New").menu("Project...").click();
		initialized.set(true);
	}

	public void creatAGeneralProject(String nameOfProject) {
		itsBot.tree().expandNode("General").select("Project");
		next();
		super.waitForPageToOpen();
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
