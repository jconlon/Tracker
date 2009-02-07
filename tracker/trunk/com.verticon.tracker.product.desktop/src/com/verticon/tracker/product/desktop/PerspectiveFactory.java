package com.verticon.tracker.product.desktop;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	private static final String ORG_ECLIPSE_UI_CONSOLE_CONSOLE_VIEW = "org.eclipse.ui.console.ConsoleView";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
String editorArea = layout.getEditorArea();
		
		
		//Left folder
		IFolderLayout left =
			layout.createFolder(
					"left", 
					IPageLayout.LEFT, 
					0.25f, 
					editorArea);
		//With an outline
		left.addView(IPageLayout.ID_RES_NAV);
		
		//Bottom left is the navigator
		layout.addView(
				IPageLayout.ID_OUTLINE, 
				IPageLayout.BOTTOM, 
				0.66f, 
				"left");
		
		//A bottom folder
		IFolderLayout bottom =
			layout.createFolder(
					"bottom", 
					IPageLayout.BOTTOM, 
					0.66f, 
					editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(ORG_ECLIPSE_UI_CONSOLE_CONSOLE_VIEW);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView(IPageLayout.ID_TASK_LIST);
		
	}

}
