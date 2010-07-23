package com.verticon.tracker.configuration.editor.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.configuration.ConfigAdminResourceFactoryImpl;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ConfigurationAdminHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public ConfigurationAdminHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		IEditorInput editorInput = getInput();
		IWorkbenchPage page = window.getActivePage();
		try {
			page.openEditor(editorInput, "com.verticon.tracker.configuration.editor.internal.ConfigurationAdminEditor");
		} catch (PartInitException e) {
			throw new ExecutionException("Failed to launch configuration editor.",e);
		}
		return null;
	}
	
	private IEditorInput getInput(){
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put
		("config", 
				 new ConfigAdminResourceFactoryImpl());

		URI uri = URI.createURI("config://tracker.verticon.com/components");
		
		return new URIEditorInput(uri);
	}
}
