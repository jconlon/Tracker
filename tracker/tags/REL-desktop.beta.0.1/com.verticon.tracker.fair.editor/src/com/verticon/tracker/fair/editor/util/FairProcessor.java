package com.verticon.tracker.fair.editor.util;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.verticon.tracker.fair.Fair;

public interface FairProcessor {

	
	public abstract void process(Fair fair, IFile projectFile, IProgressMonitor monitor) throws IOException, CoreException;

	public abstract String getCompletionMessage();
	
	public abstract String getFailureTitle();
	
}