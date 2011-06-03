package com.verticon.google.kmlgx.internal;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.google.kmlgx.presentation.Kml22gxtrimmedEditorPlugin;

/**
 * Custom workbench wizard for exporting a single geography project to from the
 * workspace to a Geo-browser compliant KMZ file.
 * 
 * <p>
 * During the call to <code>open</code>, the single page wizard dialog is
 * presented to the user. The wizard will prompt the user to enter a single
 * project that contains a doc.kml file. When the user hits Finish, the
 * user-selected workspace project are exported to the user-specified KMZ file,
 * the dialog closes, and the call to <code>open</code> returns.
 * </p>
 */
public class KmzFileExportWizard extends Wizard implements IExportWizard {

	private IStructuredSelection selection;

	private KmxFileWizardExportResourcePage mainPage;

	public KmzFileExportWizard() {
		IDialogSettings workbenchSettings = Kml22gxtrimmedEditorPlugin
				.getPlugin().getDialogSettings();
		IDialogSettings section = workbenchSettings
				.getSection("KmzFileExportWizard");//$NON-NLS-1$
		if (section == null) {
			section = workbenchSettings.addNewSection("KmzFileExportWizard");//$NON-NLS-1$
		}
		setDialogSettings(section);
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new KmxFileWizardExportResourcePage(selection);
		addPage(mainPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.selection = currentSelection;
		List<?> selectedResources = IDE
				.computeSelectedResources(currentSelection);
		if (!selectedResources.isEmpty()) {
			this.selection = new StructuredSelection(selectedResources);
		}
		setWindowTitle("Export KMZ Archive File");
		setDefaultPageImageDescriptor(AbstractUIPlugin
				.imageDescriptorFromPlugin(
						"com.verticon.google.kmlgx.core.model.editor", "icons/full/wizban/exportkml_wiz.png"));//$NON-NLS-1$		
		setNeedsProgressMonitor(true);

	}

	@Override
	public boolean performFinish() {
		return mainPage.finish();
	}

}
