/**
 * 
 */
package com.verticon.tracker.swtbot.addition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.eclipse.swtbot.addition.page.impl.ConfirmPageObject;
import org.eclipse.swtbot.addition.page.impl.DialogPageObject;
import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.addition.util.ContextMenuHelper;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;

public class AnimalViewPageObject extends TrackerViewPageObject {
	public AnimalViewPageObject(SWTWorkbenchBot bot) {
		super(bot, "com.verticon.tracker.views.AnimalsView", "Animal");
	}

	public static void assertAnimalCountIs(SWTWorkbenchBot bot, int count) {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		assertThat("Wrong number of animals", view.rowCount(), equalTo(count));
	}

	public static void assertColumnCountIs(SWTWorkbenchBot bot, int count) {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		assertThat("Wrong number of columns", view.columnCount(),
				equalTo(count));
	}

	public static void canChangeAnimalType(SWTWorkbenchBot bot,
			int indexOfAnimalToChange, String animalType) throws Exception {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		view.select(indexOfAnimalToChange);
		view.executeContextMenuOnSelectedElement("Tracker Actions",
				"Change Animal(s) Type");

		ChangeAnimalWizardPageObject wiz = new ChangeAnimalWizardPageObject(bot);
		wiz.chooseAnimal(animalType);

		new ConfirmPageObject<SWTWorkbenchBot>(bot, "Changed Animal Type", "OK")
				.confirm();
		assertThat("Document should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}

	public static void canAddTemplateEvent(SWTWorkbenchBot bot,
			int indexOfAnimalToChange) throws Exception {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		view.select(indexOfAnimalToChange);
		assertThat("Nothing selected", view.selectionCount(), is(1));

		view.log.info("ActiveEditor title: " + bot.activeEditor().getTitle());

		try {
			ContextMenuHelper.clickContextMenu(view.itsBot.table(),
					"Tracker Actions",
					"Add Template Events to Selected Animals");
		} catch (Exception e) {
			view.log.error("Failed to find context. " + e.getMessage(), e);
			throw e;
		}

		// Wizard Add Template to Animals
		AddTemplateAnimalWizardPageObject wiz = new AddTemplateAnimalWizardPageObject(
				bot);
		wiz.clickfinishButton();

		new ConfirmPageObject<SWTWorkbenchBot>(bot,
				"Added Template to Animals Operation", "OK").confirm();

		assertThat("Document should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}

	public static void canCancelAnimalDeleteOperation(SWTWorkbenchBot bot)
			throws Exception {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		int initialCount = view.rowCount();
		view.select(0, 1);
		view.deleteSelection(false);
		// Cancel the Delete
		new DialogPageObject<SWTBot>(bot, "Confirmation Delete", "Cancel", "OK")
				.cancel();
		assertThat("Did not cancel the delete", view.rowCount(),
				equalTo(initialCount));
		assertThat("Document should not be dirty",
				bot.activeEditor().isDirty(), not(true));
	}

	public static void canDeleteAnimal(SWTWorkbenchBot bot) throws Exception {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		int expectedCount = view.rowCount() - 1;
		view.select(0);
		view.deleteSelection(true);
		assertThat("Did not delete an animal", view.rowCount(),
				equalTo(expectedCount));
		assertThat("Document should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}

	public static void canAddAnimal(SWTWorkbenchBot bot, String animalType,
			String id) {
		AnimalViewPageObject view = new AnimalViewPageObject(bot);
		view.show();
		view.setFocus();
		int initialCount = view.rowCount();
		view.itsBot.toolbarButtonWithTooltip("Add a New Animal").click();
		AddAnimalWizardPageObject wiz = new AddAnimalWizardPageObject(bot);
		wiz.chooseAnimal(animalType);
		wiz.chooseID(id);

		new ConfirmPageObject<SWTWorkbenchBot>(bot, "Added Animal", "OK")
				.confirm();

		assertThat("Did not add an animal", view.rowCount(),
				equalTo(initialCount + 1));
		assertThat("Document should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}
}

class ChangeAnimalWizardPageObject extends WizardPageObject<SWTBot> {

	public ChangeAnimalWizardPageObject(SWTBot bot) {
		super(bot, "ChangeAnimalType");
	}

	public void chooseAnimal(String text) {
		itsBot.table().select(text);
		this.finishButton().click();
	}
}

class AddTemplateAnimalWizardPageObject extends WizardPageObject<SWTBot> {

	public AddTemplateAnimalWizardPageObject(SWTBot bot) {
		super(bot, "Add Template to Animals");
	}

	public void clickfinishButton() {
		finishButton().click();
	}
}