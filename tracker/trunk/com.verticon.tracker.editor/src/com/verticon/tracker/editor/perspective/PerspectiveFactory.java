/**
 * 
 */
package com.verticon.tracker.editor.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author jconlon
 *
 */
public class PerspectiveFactory implements IPerspectiveFactory {

	private static final String ORG_ECLIPSE_UI_CONSOLE_CONSOLE_VIEW = "org.eclipse.ui.console.ConsoleView";
	private static final String QUERIES_VIEW = "com.verticon.tracker.ocl.query.view";
	private static final String READERS_VIEW = "com.verticon.tracker.reader.view";
	
	private static final String ANIMALS_VIEW = "com.verticon.tracker.views.AnimalsView";
	private static final String EVENTS_VIEW = "com.verticon.tracker.views.EventsView";
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		//Get the editor area.
		String editorArea = layout.getEditorArea();
		
		
		//Left folder
		IFolderLayout left =
			layout.createFolder(
					"left", 
					IPageLayout.LEFT, 
					0.25f, 
					editorArea);
		
		
		//With an Navigator
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		//Bottom left is the Outline
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
		bottom.addView(READERS_VIEW);
		bottom.addView(QUERIES_VIEW);
		bottom.addView(ANIMALS_VIEW);
		bottom.addView(EVENTS_VIEW);
	}

}
