/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.ocl.interpreter.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ocl.examples.interpreter.console.OCLConsole;
import org.eclipse.emf.ocl.examples.interpreter.console.OCLConsoleFactory;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author jconlon
 *
 */
public class ShowOCLConsoleHandler extends AbstractHandler implements IHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    IConsoleFactory factory = new OCLConsoleFactory();
	    factory.openConsole();
	    Shell shell = HandlerUtil.getActiveShellChecked(event);
	    
		shell.getDisplay().asyncExec(new Runnable() {
            public void run() {
                consoleOpened(OCLConsole.getInstance());
        }});
		
		return null;
	}
	
	protected void consoleOpened(OCLConsole console) {
	    // do nothing
	}

}
