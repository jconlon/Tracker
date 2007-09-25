/**
 * 
 */
package com.verticon.tracker.export.xls.actions;


import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorActionDelegate;

import com.verticon.tracker.editor.util.ExportPremisesBase;


/**
 * 
 * Builds one worksheet specified by the FairRegistrationWeighInWorkSheetBuilder.
 * Called by menu pick FairRegistration.
 * 
 * @see FairRegistrationWeighInWorkSheetBuilder
 * @author jconlon
 * @deprecated Use ExportXlsWizard
 * @since 0.1
 */
public class ExportFairRegistrationEditorActionDelegate extends ExportPremisesBase implements IEditorActionDelegate {

	public ExportFairRegistrationEditorActionDelegate() {
		super( new XLSExporter(
				new WorkSheetBuilder[] { new FairRegistrationWeighInWorkSheetBuilder() },
				new String[] { "Fair WeighIn and Registration" }));
		
	}
	
	@Override
	public void run(IAction action) {
		String fileName = null;
		
		FileDialog dlg = new FileDialog(targetEditor.getSite().getShell(),
				SWT.SAVE);
		dlg.setFilterExtensions(new String[]{ "*.xls" });
		dlg.setText("Name the Fair WeighIn and Registration Report");
	     fileName = dlg.open();
		
	
		if (fileName == null) {
			return;
		} else {
			((XLSExporter)premisesProcessor).setFileName(fileName);
		}
		super.run(action);
	}
}
