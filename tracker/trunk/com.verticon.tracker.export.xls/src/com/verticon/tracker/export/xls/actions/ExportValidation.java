/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.AbstractTrackerActionDelegate;

/**
 * @author jconlon
 * @deprecated
 */
public class ExportValidation extends AbstractTrackerActionDelegate {

	
	/**
	 * @param premisesProcessor
	 */
	public ExportValidation() {
		super(new ValidationExporter());
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
			((ValidationExporter)getPremiseProcessor()).setFileName(fileName);
		}
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection)selection;
			final Object o = s.getFirstElement();
			if(o instanceof IFile){
				InvocationTargetException ite = null;
				IWorkbenchWindow window = targetPart.getSite().getWorkbenchWindow();
				
				try {
					window.run(true, true, new IRunnableWithProgress(){
						public void run(IProgressMonitor monitor)
						   throws InvocationTargetException, InterruptedException{
	
							IFile f = (IFile)o;
							
							
							Resource resource;
							try {
								resource = getResource(f);
								 validate(resource);
								if(!validationDiagnostics.isEmpty()){
									Premises premises = getPremises(resource);

									if(premises==null){
										throw new IOException("Could not find a premises");
									}
									((ValidationExporter)getPremiseProcessor()).setValidationDiagnostics(validationDiagnostics);
									processSelection( premises, f, monitor);
								}
								
								monitor.done();
								
							} catch (IOException e) {
								throw new InvocationTargetException(e);
	
							} catch (CoreException e) {
								throw new InvocationTargetException(e);
							}
						}
					});
				} catch (InvocationTargetException e) {
					ite=e;
				
				} catch (InterruptedException e) {
					
				}
				
				if(validationDiagnostics.isEmpty()){
				   MessageDialog.openInformation(
						targetPart.getSite().getShell(),
						"Valid Tracker Resource",
						"The tracker model document was valid, No validation error report was created.");
				   
				}
				
			}
	
		}
	}
	

}
