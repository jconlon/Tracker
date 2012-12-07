/**
 * 
 */
package com.verticon.tracker.swtbot.addition;

import org.eclipse.swtbot.addition.page.impl.DialogPageObject;
import org.eclipse.swtbot.addition.page.impl.ViewPageObject;
import org.eclipse.swtbot.addition.util.ContextMenuHelper;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.utils.TableCollection;

public class TrackerViewPageObject extends ViewPageObject {
	private final String type;

	public TrackerViewPageObject(SWTWorkbenchBot bot, String id, String type) {
		super(bot, id);
		this.type = type;
	}

	public void show() {
		this.getView().show();
	}

	public void executeContextMenuOnSelectedElement(final String... texts) {
		ContextMenuHelper.clickContextMenu(itsBot.table(), texts);
	}

	public void setFocus() {
		this.getView().setFocus();
	}

	public void select(final int... indices) {
		itsBot.table().select(indices);
	}

	public void select(final String... texts) {
		itsBot.table().select(texts);
	}

	public int selectionCount() {
		return itsBot.table().selectionCount();
	}

	public TableCollection selection() {
		return itsBot.table().selection();
	}

	public int columnCount() {
		return itsBot.table().columnCount();
	}

	public void deleteSelection(boolean completeDialog) {
		if (itsBot.table().selectionCount() < 1) {
			throw new AssertionError("No table items selected");
		}
		itsBot.table().contextMenu("Delete " + type + "(s)").click();
		if (completeDialog) {
			new DialogPageObject<SWTBot>(itsBot, "Confirmation Delete",
					"Cancel", "OK").confirm();
		}
	}

	public int rowCount() {
		return itsBot.table().rowCount();
	}
}