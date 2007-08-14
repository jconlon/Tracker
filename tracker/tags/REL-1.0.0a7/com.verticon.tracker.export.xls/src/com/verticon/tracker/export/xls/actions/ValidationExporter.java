/**
 * 
 */
package com.verticon.tracker.export.xls.actions;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.PremisesProcessor;

/**
 * @author jconlon
 * @deprecated
 */
public class ValidationExporter implements PremisesProcessor{

	private String fileName = "FairRegistration.xls";
	private List<Diagnostic> validationDiagnostics;
	
	public void process(Premises premises, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
		for (Diagnostic diagnostic : validationDiagnostics) {
			processDiagnostic(diagnostic);
			
		}
		
	}
	
	
	  public static boolean processDiagnostic(Diagnostic diagnostic)
	  {
	    if (diagnostic.getSeverity() == Diagnostic.ERROR || 
	      diagnostic.getSeverity() == Diagnostic.WARNING)
	    {
	      System.err.println(diagnostic.getMessage());
	      
	      
	      for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
	        List<?> data;
	        switch (childDiagnostic.getSeverity())
	        {
	          case Diagnostic.ERROR:
	          case Diagnostic.WARNING:
	            System.err.println("\t" + childDiagnostic.getMessage());
	            data= childDiagnostic.getData();
	            for (Object object : data) {
	            	System.err.println("\t object="+ object.toString());
				}
	            System.err.println("\t source="+childDiagnostic.getSource());
	            System.err.println("\t code="+childDiagnostic.getCode());
	            
	        }
	      }
	      return false;
	    }
	    return true;
	  }


	
	
	
	

	public String getCompletionMessage() {
		return "Fair Participant XLS exported "+fileName;
	}

	public String getFailureTitle() {
		return "FairRegistration export failure";
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<Diagnostic> getValidationDiagnostics() {
		return validationDiagnostics;
	}
	public void setValidationDiagnostics(List<Diagnostic> validationDiagnostics) {
		this.validationDiagnostics = validationDiagnostics;
	}
	
}
