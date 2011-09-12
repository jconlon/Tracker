/**
 * 
 */
package com.verticon.tracker.swtbot.addition;

import org.eclipse.swtbot.addition.page.impl.DialogPageObject;
import org.eclipse.swtbot.addition.page.impl.EditorPageObject;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.TableCollection;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

public class EMFEditorPageObject extends EditorPageObject {
	private static final String LOAD_RESOURCE = "Load Resource";
	private final String editorType;

	public EMFEditorPageObject(SWTWorkbenchBot bot, String editorName,
			String editorType) {
		super(bot, editorName);
		this.editorType = editorType;
	}

	public EMFEditorPageObject expandParentElement(String name) {
		getTree().expandNode(name, true);
		return this;
	}

	public EMFEditorPageObject logAllItems() {
		log.info("Logging nodes from EMF Editor " + getTitle() + ": "
				+ getTree().getText());
		for (SWTBotTreeItem treeItem : getTree().getAllItems()) {
			log.info("EMF Element: " + treeItem.getText());
		}
		return this;
	}

	public EMFEditorPageObject selectElement(String name) {
		getTree().select(name);
		return this;
	}

	public int rowCount() {
		return getTree().rowCount();
	}

	public boolean isActive() {
		return getEditor().isActive();
	}

	public TableCollection selection() {
		return getTree().selection();
	}

	public int selectionCount() {
		return getTree().selectionCount();
	}

	public SWTBotTreeItem expandNode(String element, boolean recursive) {
		return getTree().expandNode(element, recursive);
	}

	public String getTitle() {
		return getEditor().getTitle();
	}

	public boolean isDirty() {
		return getEditor().isDirty();
	}	

	public void select(final String... items) {
		getTree().select(items);
	}

	

	/**
	 * Validate the selection.
	 * 
	 * @param title
	 *            of the DialogPage or null.
	 * @throws Exception
	 */
	public void isValid(final String title) throws Exception {
		if (getTree().selectionCount() < 1) {
			throw new AssertionError("No table items selected");
		}

		itsBot.menu(editorType).menu("Validate").click();

		if (title != null) {
			DialogPageObject<SWTBot> validationDialog = new DialogPageObject<SWTBot>(
					itsBot, title, null, "OK");
			validationDialog.waitForPageToOpen();
			validationDialog.confirm();
		}
	}

	public void addChild(final String child) {
		if (getTree().selectionCount() < 1) {
			throw new AssertionError("No table items selected");
		}
		itsBot.menu(editorType).menu("New Child").menu(child).click();

	}
	
	public void loadResource(final String resourceName) {
		log.debug("Loading <"+resourceName+"> in <"+editorType+'>');
		try {
			itsBot.menu(editorType).menu(LOAD_RESOURCE+"...").click();
		} catch (WidgetNotFoundException e) {
		
			throw e;
		}
		SWTBotShell loadResourceShell = itsBot.shell("LOAD_RESOURCE");
		loadResourceShell.activate();
        itsBot.text().setText(resourceName);
        itsBot.button("OK").click();
	}

	/**
	 * itsBot and the getEditor().bot() are not the same
	 * 
	 * @return editor bot
	 */
	private SWTBot editorBot() {
		return getEditor().bot();
	}

	private SWTBotTree getTree() {
		return editorBot().tree();
	}

}