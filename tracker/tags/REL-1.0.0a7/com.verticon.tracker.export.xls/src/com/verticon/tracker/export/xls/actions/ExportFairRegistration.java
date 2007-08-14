/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import com.verticon.tracker.editor.util.AbstractTrackerActionDelegate;

/**
 * @author jconlon
 *
 */
public class ExportFairRegistration extends AbstractTrackerActionDelegate {

	
	/**
	 * @param premisesProcessor
	 */
	public ExportFairRegistration() {
		super(
		 new XLSExporter(new WorkSheetBuilder[]{new FairRegistrationWeighInWorkSheetBuilder()}
		,new String[]{"Fair WeighIn and Registration"}));
	}
	
	
	private static final String[] FILTER_EXTS = { "*.xls"};


	@Override
	public void run(IAction action) {
		FileDialog dlg = new FileDialog(targetPart.getSite().getShell(), SWT.SAVE);
        dlg.setFilterExtensions(FILTER_EXTS);
        String fileName = dlg.open();
 
		
		if(fileName==null){
			return;
		}else{
			((XLSExporter)getPremiseProcessor()).setFileName(fileName);
		}
		super.run(action);
	}
	
	

}
