package com.verticon.osgi.metatype.presentation.extended;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.core.model.editor.internal.forms.DesignatesFormPage;
import com.verticon.osgi.metatype.core.model.editor.internal.forms.Utils;
import com.verticon.osgi.metatype.presentation.MetatypeEditor;

public class MetatypeFormsEditor extends MetatypeEditor {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MetatypeFormsEditor.class);

	@Override
	public void createPages() {
		super.createPages();

		removeUnusedPages();
		EditorPart fp = new DesignatesFormPage(this);
		fp.createPartControl(getContainer());

		try {
			int index = addPage(fp, getEditorInput());
			setPageText(index, "Factories");
		} catch (PartInitException e) {
			logger.error(Utils.bundleMarker, "Failed to create forms page.", e);
		}
	}

	private void removeUnusedPages() {
		String[] pagesToRemove = { "Table", "Tree with Columns" };

		for (String pageToRemove : pagesToRemove) {
			for (int i = 0; i < super.getPageCount(); i++) {
				if (getPageText(i).equals(pageToRemove)) {
					removePage(i);
					break;
				}

			}
		}

	}

}
