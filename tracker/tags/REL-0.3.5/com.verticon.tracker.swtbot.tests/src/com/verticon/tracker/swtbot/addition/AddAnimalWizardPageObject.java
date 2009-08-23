/**
 * 
 */
package com.verticon.tracker.swtbot.addition;

import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

@SuppressWarnings("unchecked")
class AddAnimalWizardPageObject extends WizardPageObject {

	public AddAnimalWizardPageObject(SWTWorkbenchBot bot) {
		super(bot, "AddAnimal");
	}

	public void chooseAnimal(String text) {
		itsBot.table().select(text);
		next();
		this.waitForPageToOpen();
	}

	public void chooseID(String text) {
		itsBot.textWithLabel("Animal Tag Identification:").setText(text);
		clickFinish();
	}

	public void clickFinish() {
		this.finishButton().click();
	}

}