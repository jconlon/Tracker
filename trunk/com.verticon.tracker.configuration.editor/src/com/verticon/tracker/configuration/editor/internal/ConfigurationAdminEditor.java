package com.verticon.tracker.configuration.editor.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IWorkbenchPartConstants;

import com.verticon.osgi.metatype.presentation.extended.MetatypeFormsEditor;


public class ConfigurationAdminEditor extends MetatypeFormsEditor {

	/* (non-Javadoc)
	 * @see com.verticon.osgi.metatype.presentation.MetatypeEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		this.firePropertyChange(99999);
		super.doSave(progressMonitor);
		StartEditor startEditor = new StartEditor();
		this.setInput(startEditor.getInput());
		this.firePropertyChange(IWorkbenchPartConstants.PROP_INPUT);
	}
}
