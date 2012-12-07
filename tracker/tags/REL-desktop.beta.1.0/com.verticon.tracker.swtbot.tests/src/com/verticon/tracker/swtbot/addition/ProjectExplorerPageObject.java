package com.verticon.tracker.swtbot.addition;

import static org.hamcrest.Matchers.instanceOf;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.addition.page.impl.ConfirmPageObject;
import org.eclipse.swtbot.addition.page.impl.ViewPageObject;
import org.eclipse.swtbot.addition.util.ContextMenuHelper;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.utils.TableCollection;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IPageLayout;
import org.hamcrest.Matcher;

public class ProjectExplorerPageObject extends ViewPageObject {

	public ProjectExplorerPageObject(SWTWorkbenchBot bot) {
		super(bot, IPageLayout.ID_PROJECT_EXPLORER);
	}

	public void show() {
		getView().show();
	}

	public SWTBotTree select(final String... indices) {
		return getView().bot().tree().select(indices);
	}

	public SWTBotTree select(final int... indices) {
		return getView().bot().tree().select(indices);
	}

	public TableCollection selection() {
		return getView().bot().tree().selection();
	}

	public SWTBotTreeItem getTreeItem(String nodeText) {
		return getTree().getTreeItem(nodeText);
	}

	private SWTBotTree getTree() {
		return getView().bot().tree();
	}

	public int selectionCount() {
		return getTree().selectionCount();
	}

	public void expandNode(String nodeText, boolean recursive) {
		getProjectExplorerTree().expandNode(nodeText, recursive);
	}

	public void deleteProject(String name) {
		getProjectExplorerTree().select(name);

		getView().bot().menu("Edit").menu("Delete").click();

		new DeleteResourceConfirmPageObject(itsBot).confirm();
	}

	public void assertProjectCreated(String name) {
		show();
		SWTBotTree tree = getProjectExplorerTree();
		// throws WNFE if the item does not exist
		tree.getTreeItem(name);
	}

	public void executeContextMenuOnResource(final String... texts) {
		ContextMenuHelper.clickContextMenu(getProjectExplorerTree(), texts);
	}

	@SuppressWarnings("unchecked")
	private SWTBotTree getProjectExplorerTree() {
		this.getView().show();

		Composite packageExplorerComposite = (Composite) getView().getWidget();

		// Tree swtTree = (Tree) itsBot.widget((Matcher) instanceOf(Tree.class),
		// packageExplorerComposite);
		Tree swtTree = (Tree) getView().bot().widget(
				(Matcher) instanceOf(Tree.class), packageExplorerComposite);

		SWTBotTree tree = new SWTBotTree(swtTree);
		return tree;
	}

}

class DeleteResourceConfirmPageObject extends
		ConfirmPageObject<SWTWorkbenchBot> {

	public DeleteResourceConfirmPageObject(SWTWorkbenchBot bot) {
		super(bot, "Delete Resources", "OK");
	}

	// void acknowledgeCannotUndo() {
	// itsBot.checkBox("Delete project contents on disk (cannot be undone)").select();
	// waitForPageToClose();
	// }
}
