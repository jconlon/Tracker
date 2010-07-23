package com.verticon.tracker.configuration.editor.internal;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.util.MetatypeResourceFactoryImpl;
import com.verticon.tracker.configuration.ConfigAdminResourceFactoryImpl;

public class StartEditor {

	public void start() throws PartInitException{
		IEditorInput editorInput = getInput();
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		page.openEditor(editorInput, "com.verticon.tracker.configuration.editor.internal.ConfigurationAdminEditor");
	}
	
	 IEditorInput getInput(){
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the appropriate resource factory to handle all file extensions.

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new MetatypeResourceFactoryImpl());
		
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put
		("config", 
		 new ConfigAdminResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put
			(MetatypePackage.eNS_URI, 
			 MetatypePackage.eINSTANCE);

		URI uri = URI.createURI("config://tracker.verticon.com/test");
		
		return new URIEditorInput(uri);
	}
}
