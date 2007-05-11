/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import com.verticon.tracker.editor.util.AbstractTrackerActionDelegate;

/**
 * @author jconlon
 *
 */
public class ExportRawEvents extends AbstractTrackerActionDelegate {

	
	/**
	 * @param premisesProcessor
	 */
	public ExportRawEvents() {
		super(
				new XLSExporter(
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
				)
		);
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


	/**
	 * Dont validate the resource.
	 */
	@Override
	protected boolean validate(Resource resource) {
		return true;
	}
	
	

}
