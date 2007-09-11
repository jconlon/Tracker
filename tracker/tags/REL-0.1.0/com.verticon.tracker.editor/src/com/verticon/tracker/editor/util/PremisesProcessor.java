package com.verticon.tracker.editor.util;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.verticon.tracker.Premises;

public interface PremisesProcessor {

	
	public abstract void process(Premises premises, IFile projectFile, IProgressMonitor monitor) throws IOException, CoreException;

	public abstract String getCompletionMessage();
	
	public abstract String getFailureTitle();
	
//	public abstract void setFileName(String fileName);
	
}