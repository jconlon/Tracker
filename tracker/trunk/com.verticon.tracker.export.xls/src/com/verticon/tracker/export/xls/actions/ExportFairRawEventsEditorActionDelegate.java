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
 * Builds four worksheets.
 * Called by menu pick Raw FairRegistration.
 * 
 * @see FairRegistrationWorkSheetBuilder
 * @see WeighInWorkSheetBuilder
 * @see MovedInWorkSheetBuilder
 * @see MovedOutWorkSheetBuilder
 * @author jconlon
 * @deprecated Use ExportXlsWizard
 * @since 0.1
 */
public class ExportFairRawEventsEditorActionDelegate extends ExportPremisesBase implements IEditorActionDelegate {

	
	public ExportFairRawEventsEditorActionDelegate() {
		super(new XLSExporter(
				new WorkSheetBuilder[]{
						new FairRegistrationWorkSheetBuilder(),
						new WeighInWorkSheetBuilder(),
						new MovedInWorkSheetBuilder(),
						new MovedOutWorkSheetBuilder()
				},
				new String[]{
						"Fair Registration Events",
						"Fair WeighIn Events",
						"MovedIn Events",
						"MovedOut Events"}
		));
		
	}

	@Override
	public void run(IAction action) {
		String fileName = null;
		
		FileDialog dlg = new FileDialog(targetEditor.getSite().getShell(),
				SWT.SAVE);
		dlg.setFilterExtensions(new String[]{ "*.xls" });
		dlg.setText("Name the Raw Fair Events Export Report");
	    fileName = dlg.open();
		
	
		if (fileName == null) {
			return;
		} else {
			((XLSExporter)premisesProcessor).setFileName(fileName);
		}
		super.run(action);
	}
	
}
