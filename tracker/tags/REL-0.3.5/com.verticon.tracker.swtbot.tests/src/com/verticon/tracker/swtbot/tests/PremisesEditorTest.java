package com.verticon.tracker.swtbot.tests;

//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.apache.log4j.Logger;
import org.eclipse.swtbot.addition.page.impl.ConfirmPageObject;
import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.verticon.tracker.swtbot.addition.AnimalViewPageObject;
import com.verticon.tracker.swtbot.addition.EMFEditorPageObject;
import com.verticon.tracker.swtbot.addition.EventViewPageObject;
import com.verticon.tracker.swtbot.addition.NewAnimalWizardPageObject;
import com.verticon.tracker.swtbot.addition.NewExampleWizardPageObject;
import com.verticon.tracker.swtbot.addition.NewPremisesWizardPageObject;
import com.verticon.tracker.swtbot.addition.NewProjectWizardPageObject;
import com.verticon.tracker.swtbot.addition.ProjectExplorerPageObject;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PremisesEditorTest {

	private static final String PREMISES_EDITOR = "Premises Editor";

	private Logger log = Logger.getLogger(this.getClass());

	private static final String MY_TEST_PROJECT = "test";
	private static final String MY_FIRST_PROJECT = "MyFirstProject";
	private static final String EXAMPLE_ANIMAL = "example.animal";
	private static final String EXAMPLE_PREMISES_DOC_NAME = "example.premises";
	static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		// System.setProperty(SWTBotPreferenceConstants.KEY_TIMEOUT, "8000");
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
	}

	@BeforeClass
	public static void resetPerspective() {
		bot.menu("Window").menu("Open Perspective").menu("Tracker").click();
	}

	@Test
	public void canViewAllElementsOfPerspective() throws Exception {
		bot.viewByTitle("Project Explorer").setFocus();
		bot.viewByTitle("Outline").setFocus();
		bot.viewByTitle("Animals").setFocus();
		bot.viewByTitle("Events").setFocus();

		bot.viewByTitle("Exhibits").setFocus();
		bot.viewByTitle("Queries").setFocus();
		bot.viewByTitle("People").setFocus();
		bot.viewByTitle("Readers").setFocus();
	}

	@Test
	public void canCreateANewGeneralProject() throws Exception {
		log.info("Starting canCreateANewGeneralProject");

		NewProjectWizardPageObject newProjectWizard = new NewProjectWizardPageObject(
				bot);
		newProjectWizard.waitForPageToOpen();
		newProjectWizard.creatAGeneralProject(MY_FIRST_PROJECT);

		newProjectWizard.finish();
		new ProjectExplorerPageObject(bot)
				.assertProjectCreated(MY_FIRST_PROJECT);

		log.info("Stopping canCreateANewGeneralProject");
	}

	@Test
	public void canCreateANewPremisesDocument() throws Exception {
		log.info("Starting canCreateANewPremisesDocument");
		NewPremisesWizardPageObject newPremisesWizard = new NewPremisesWizardPageObject(
				bot);
		newPremisesWizard.waitForPageToOpen();
		newPremisesWizard.creatAPremisesDocument(MY_FIRST_PROJECT,
				EXAMPLE_PREMISES_DOC_NAME);
		EMFEditorPageObject editorPage = new EMFEditorPageObject(bot,
				EXAMPLE_PREMISES_DOC_NAME, PREMISES_EDITOR);
		editorPage.waitForPageToOpen();
		assertThat("Editor title should be same as document name.",
				EXAMPLE_PREMISES_DOC_NAME, equalTo(editorPage.getTitle()));
		assertThat("Editor should not be dirty", editorPage.isDirty(),
				is(not(true)));
		assertThat("Editor has the wrong number of rows",
				editorPage.rowCount(), equalTo(1));

		editorPage.select("Premises");// Select the first element

		editorPage.isValid("Validation Problems");
		editorPage.addChild("Swine");
		assertThat("Editor should be dirty", editorPage.isDirty(), is(true));
		editorPage.expandNode("Premises", true);
		editorPage.save();
		assertThat("Editor has the wrong number of rows",
				editorPage.rowCount(), equalTo(1));

		log.info("Stopping canCreateANewPremisesDocument");
	}

	@Test
	public void canCreateANewAnimalDocument() throws Exception {
		NewAnimalWizardPageObject newPremisesWizard = new NewAnimalWizardPageObject(
				bot);
		newPremisesWizard.waitForPageToOpen();
		newPremisesWizard.creatAnAnimalDocument(MY_FIRST_PROJECT,
				EXAMPLE_ANIMAL, "Swine");

		EMFEditorPageObject editorPage = new EMFEditorPageObject(bot,
				EXAMPLE_ANIMAL, PREMISES_EDITOR);
		editorPage.waitForPageToOpen();
		assertThat("Editor title should be same as document name.",
				EXAMPLE_ANIMAL, equalTo(editorPage.getTitle()));
		assertThat("Editor should not be dirty", editorPage.isDirty(),
				is(not(true)));
		assertThat("Editor has the wrong number of rows",
				editorPage.rowCount(), equalTo(1));
		editorPage.select("Swine");// Select the first element
		assertThat(editorPage.selectionCount(), equalTo(1));
		editorPage.isValid("Validation Problems");
		assertThat(editorPage.selection().get(0).get(0), equalTo("Swine"));

	}

	@Test
	public void canDeleteAProject() throws Exception {
		ProjectExplorerPageObject projectExplorer = new ProjectExplorerPageObject(
				bot);
		projectExplorer.deleteProject(MY_FIRST_PROJECT);
	}

	@Test
	public void canCreateANewExampleProject() throws Exception {
		log.info("Starting canCreateANewExampleProject");
		NewExampleWizardPageObject newExampleWizard = new NewExampleWizardPageObject(
				bot);
		newExampleWizard.waitForPageToOpen();
		newExampleWizard.creatAnExampleProject("Tracker",
				"Tracker Example Project", MY_TEST_PROJECT);
		newExampleWizard.finish();

		new ConfirmPageObject<SWTBot>(bot, "Add Queries", "OK").confirm();
		new ProjectExplorerPageObject(bot)
				.assertProjectCreated(MY_TEST_PROJECT);

		AnimalViewPageObject.assertAnimalCountIs(bot, 5);
		AnimalViewPageObject.assertColumnCountIs(bot, 11);
		EventViewPageObject.assertEventCountIs(bot, 25);
		EventViewPageObject.assertColumnCountIs(bot, 5);
		log.info("Stopping canCreateANewExampleProject");
	}

	@Test
	public void canRunImportTagIdsAsTemplateEventsCommands() throws Exception {
		ProjectExplorerPageObject projectExplorer = new ProjectExplorerPageObject(
				bot);
		projectExplorer.show();
		projectExplorer.select(0);

		projectExplorer.expandNode(MY_TEST_PROJECT, true);
		projectExplorer.select(MY_TEST_PROJECT);
		projectExplorer.getTreeItem(MY_TEST_PROJECT).select("capture.tags"); // only
																				// selects
																				// "Leaf"
		assertThat(projectExplorer.selectionCount(), is(1));
		log.info("File Selected " + projectExplorer.selectionCount()
				+ " resource. Named " + projectExplorer.selection().toString());
		projectExplorer.executeContextMenuOnResource("Tracker Actions",
				"Import TagIds as Template Events");

		new AddAnimalToPremisesWizardPageObject(bot).clickFinish();

		ConfirmPageObject<SWTWorkbenchBot> confirm = new ConfirmPageObject<SWTWorkbenchBot>(
				bot, "Add Template to Premises Operation", "OK");
		confirm.waitForPageToOpen();
		confirm.confirm();

		EventViewPageObject.assertEventCountIs(bot, 41);
		AnimalViewPageObject.assertAnimalCountIs(bot, 13);

		assertThat("Editor should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}

	@Test
	public void canRunImportTagIdsAsSelectionsCommands() throws Exception {
		ProjectExplorerPageObject projectExplorer = new ProjectExplorerPageObject(
				bot);
		projectExplorer.show();
		projectExplorer.select(0);

		projectExplorer.expandNode(MY_TEST_PROJECT, true);
		projectExplorer.select(MY_TEST_PROJECT);
		projectExplorer.getTreeItem(MY_TEST_PROJECT).select("capture.tags"); // only
																				// selects
																				// "Leaf"
		assertThat(projectExplorer.selectionCount(), is(1));
		log.info("File Selected " + projectExplorer.selectionCount()
				+ " resource. Named " + projectExplorer.selection().toString());
		projectExplorer.executeContextMenuOnResource("Tracker Actions",
				"Import TagIds Specifying Animal and Event Types");

		AddAnimalToPremisesWizardPageObject wizard = new AddAnimalToPremisesWizardPageObject(
				bot);
		wizard.chooseAnimal("Swine");
		wizard.chooseEvent("Died");

		ConfirmPageObject<SWTWorkbenchBot> confirm = new ConfirmPageObject<SWTWorkbenchBot>(
				bot, "Add Template to Premises Operation", "OK");
		confirm.waitForPageToOpen();
		confirm.confirm();

		EventViewPageObject.assertEventCountIs(bot, 49);// Added 8 events
		AnimalViewPageObject.assertAnimalCountIs(bot, 13);// Did not add any
															// animals

		assertThat("Editor should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}

	@Test
	public void canRunEventsViewCommands() throws Exception {
		EventViewPageObject.canModifyEventAttributes(bot, 1);
	}

	@Test
	public void canRunAnimalsViewCommands() throws Exception {
		AnimalViewPageObject.canCancelAnimalDeleteOperation(bot);
		AnimalViewPageObject.canAddAnimal(bot, "Swine", "34567890");
		AnimalViewPageObject.canChangeAnimalType(bot, 0, "Equine");
		AnimalViewPageObject.canAddTemplateEvent(bot, 1);
		// Warning Deleting animals test can have an adverse effect on other
		// tests
		AnimalViewPageObject.canDeleteAnimal(bot);
	}

	@Test
	public void canCheckForInvalidDocument() throws Exception {
		EMFEditorPageObject editorPage = new EMFEditorPageObject(bot,
				EXAMPLE_PREMISES_DOC_NAME, "Premises Transaction Editor");
		editorPage.waitForPageToOpen();
		assertThat("Editor title should be same as document name.",
				EXAMPLE_PREMISES_DOC_NAME, equalTo(editorPage.getTitle()));

		assertThat("Editor should be active", editorPage.isActive(), is(true));

		assertThat("Editor should not be dirty", editorPage.isDirty(),
				is(not(true)));

		editorPage.select("Premises Simple Valley Ranch");// Select the first
															// element

		assertThat(editorPage.selectionCount(), is(1));

		editorPage.isValid("Validation Problems");// This is effecting other
													// tests
		// bot.sleep(1000000);
	}

	@Test
	public void canSetPreferencesAndRemoveEventsToGetValidDocument()
			throws Exception {

		// Get the preferences and turn off 'Fair Premises Constraints' and
		// 'Core Constraints' > 'Tag Minimal Event Constraint (Batch Mode)'
		bot.menu("Window").menu("Preferences").click();
		SWTBotShell prefsShell = bot.shell("Preferences");
		prefsShell.activate();

		SWTBotTreeItem treeItem = bot.tree().getTreeItem("Model Validation")
				.select().expand().click();
		treeItem.getNode("Constraints").select().click();
		// Now showing the Constraint preferences
		SWTBotTree tree = bot.tree(1);
		treeItem = tree.getTreeItem("Tracker Constraints").select().expand()
				.click();
		treeItem.getNode("Fair Premises Constraints").uncheck();
		treeItem.getNode("Core Constraints").select().click();// Fails to find
																// widget
		SWTBotTable table = bot.table();
		table.getTableItem("Tag Minimal Event Constraint (Batch Mode)")
				.uncheck();
		bot.button("Apply").click();
		// bot.sleep(10000);
		bot.button("OK").click();

		EMFEditorPageObject editorPage = new EMFEditorPageObject(bot,
				EXAMPLE_PREMISES_DOC_NAME, "Premises Transaction Editor");
		editorPage.waitForPageToOpen();
		assertThat("Editor title should be same as document name.",
				EXAMPLE_PREMISES_DOC_NAME, equalTo(editorPage.getTitle()));

		assertThat("Editor should be active", editorPage.isActive(), is(true));

		assertThat("Editor should not be dirty", editorPage.isDirty(),
				is(not(true)));

		editorPage.select("Premises Simple Valley Ranch");// Select the first
															// element
		// To Remove all the weighIn events
		// 1. Go to Queries View
		SWTBotView queries = bot.viewByTitle("Queries");
		// 2. Select and execute the 'WeighIn Events' query
		queries.show();
		queries.setFocus();
		bot.table().select("WeighIn Events");
		bot.button("Execute").click();
		queries.close();
		// 3. Set focus on the active editor

		bot.activeEditor().setFocus();
		// bot.sleep(10000);
		// 4. Main menu Edit>Delete
		bot.menu("Edit").menu("Delete").click();

		// Save the document
		assertThat("Editor should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();

		// bot.sleep(10000);
		// Validate from the root
		editorPage.select("Premises Simple Valley Ranch");// Select the first
															// element
		assertThat(editorPage.selectionCount(), is(1));

		editorPage.isValid("Validation Information");// This is effecting other
														// tests
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(3000);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		ProjectExplorerPageObject projectExplorer = new ProjectExplorerPageObject(
				bot);
		projectExplorer.deleteProject(MY_TEST_PROJECT);
	}

}

@SuppressWarnings("unchecked")
class AddAnimalToPremisesWizardPageObject extends WizardPageObject {

	public AddAnimalToPremisesWizardPageObject(SWTBot bot) {
		super(bot, "Add Animal to Premises");
	}

	public void chooseAnimal(String text) {
		this.itsBot.list().select(text);
		next();
	}

	public void chooseEvent(String text) {
		this.itsBot.list().select(text);
		clickFinish();
	}

	public void clickFinish() {
		this.finishButton().click();
	}

}