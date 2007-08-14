package com.verticon.tracker.editor.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;

public abstract class AbstractTrackerActionDelegate implements IObjectActionDelegate{

	protected IWorkbenchPart targetPart;
	protected ISelection selection;
	protected List<Diagnostic> validationDiagnostics = new ArrayList<Diagnostic>();
	private final PremisesProcessor premiseProcessor;
	
	public AbstractTrackerActionDelegate(PremisesProcessor premisesProcessor) {
		this.premiseProcessor=premisesProcessor;
	}

	protected static Resource getResource(IFile file) throws IOException {
	    ResourceSet resourceSet = new ResourceSetImpl();
	
	     URI uri = URI.createPlatformResourceURI(file.getFullPath()
	             .toString(),true);
	     Resource resource = resourceSet.createResource(uri);
	     if (!resource.isLoaded()) {
	         resource.load(null);
	     }
	     return resource;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	
	public void run(IAction action) {
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
								if(!validate(resource)){
									throw new InvocationTargetException(new IOException("Tracker Model is not valid.  Please create a validate model before exporting."));
								}
								Premises premises = getPremises(resource);

								if(premises==null){
									throw new IOException("Could not find a premises");
								}
								processSelection( premises, f, monitor);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(ite==null){
				   MessageDialog.openInformation(
						targetPart.getSite().getShell(),
						"Process Completed",
						premiseProcessor.getCompletionMessage());
				   
				}else{
					MessageDialog.openError(
							targetPart.getSite().getShell(),
							premiseProcessor.getFailureTitle(),
							ite.getCause().getMessage());
				}
				
			}
	
		}
	}

	
	
	protected void processSelection(Premises premises, IFile resource, IProgressMonitor monitor) throws CoreException, IOException{
		
		premiseProcessor.process(premises, resource, monitor);
    }
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());
	}

	protected static Premises getPremises(Resource resource) {
		Object o = resource.getContents().get(0);
		if(o instanceof Premises){
			return (Premises)o;
		}
		return null;
	}

	

	protected boolean validate(Resource resource) {
		 this.validationDiagnostics.clear();
		for (EObject eObject : resource.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				validationDiagnostics.add(diagnostic);
			}
			
		}
		return validationDiagnostics.isEmpty();
	}

	public PremisesProcessor getPremiseProcessor() {
		return premiseProcessor;
	}

}