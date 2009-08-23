/**
 * 
 */
package com.verticon.tracker.swtbot.addition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.eclipse.swtbot.addition.page.impl.ConfirmPageObject;
import org.eclipse.swtbot.addition.page.impl.WizardPageObject;
import org.eclipse.swtbot.addition.util.ContextMenuHelper;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;

public class EventViewPageObject extends TrackerViewPageObject {
	public EventViewPageObject(SWTWorkbenchBot bot) {
		super(bot, "com.verticon.tracker.views.EventsView", "Event");

	}

	public static void assertEventCountIs(SWTWorkbenchBot bot, int count) {
		EventViewPageObject eventView = new EventViewPageObject(bot);
		eventView.show();
		eventView.setFocus();
		assertThat("Wrong number of events", eventView.rowCount(),
				equalTo(count));
	}

	public static void assertColumnCountIs(SWTWorkbenchBot bot, int count) {
		EventViewPageObject eventView = new EventViewPageObject(bot);
		eventView.show();
		eventView.setFocus();
		assertThat("Wrong number of columns", eventView.columnCount(),
				equalTo(count));
	}

	@SuppressWarnings("ucd")
	public static enum ChangeableAttributes {
		COMMENTS, CORRECTION, ELECTRONICALLY_READ;

	}

	public static void canModifyEventAttributes(SWTWorkbenchBot bot, int index)
			throws Exception {
		EventViewPageObject view = new EventViewPageObject(bot);
		view.show();
		view.setFocus();
		view.select(index);
		assertThat("Nothing selected", view.selectionCount(), is(1));
		view.log.debug("ActiveEditor title: " + bot.activeEditor().getTitle());

		try {
			ContextMenuHelper.clickContextMenu(view.itsBot.table(),
					"Tracker Actions", "Modify Selected Events");
		} catch (Exception e) {
			view.log.error("Failed to find context. " + e.getMessage(), e);
			throw e;
		}

		// ModifyAttributes Wizard has two pages the first is a
		ModifyAttributeslWizardPageObject wiz = new ModifyAttributeslWizardPageObject(
				bot);
		wiz.selectAttribute(ChangeableAttributes.COMMENTS.ordinal());
		wiz.addComments("This is a new comment");

		ConfirmPageObject<SWTWorkbenchBot> confirm = new ConfirmPageObject<SWTWorkbenchBot>(
				bot, "Modified Events", "OK");
		confirm.confirm();
		assertThat("Document should be dirty", bot.activeEditor().isDirty(),
				is(true));
		bot.activeEditor().save();
	}
}

/**
 * ModifyAttributes Wizard has two pages.
 * <ul>
 * <li>First page chooses the the attributes to change. These are presented in a
 * two column table. The first column of this table has checkboxes to select the
 * attributes to be changed.</li>
 * <li>
 * The second page chooses what to change within the selected attributes.</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
class ModifyAttributeslWizardPageObject extends WizardPageObject<SWTBot> {

	public ModifyAttributeslWizardPageObject(SWTBot bot) {

		super(bot, "ModifyAttributes");
	}

	void selectAttribute(int rowIndex) {
		SWTBotTable table = itsBot.table();
		log.debug("Selecting TableItem: " + rowIndex);
		assertThat("Row index out of bounds", rowIndex, is(lessThan(table
				.rowCount())));
		SWTBotTableItem tableItem = table.getTableItem(rowIndex);

		tableItem.check();
		// itsBot.sleep(10000);
		next();
		waitForPageToOpen();
	}

	void addComments(String text) {
		itsBot.textWithLabel("Comments:").setText(text);
		clickfinishButton();
	}

	public void clickfinishButton() {
		finishButton().click();
	}
}