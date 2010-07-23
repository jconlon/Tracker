package com.verticon.tracker.configuration.editor.internal.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.util.MetatypeResourceFactoryImpl;
import com.verticon.tracker.configuration.ConfigAdminResourceFactoryImpl;

public class ConfigurationExportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.SAVE);
		fd.setText("Save");
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		String filterPath = path.toOSString();
		fd.setFilterPath(filterPath);// location.getPath());
		String[] filterExt = { "*.metatype", "*.xml", "*.*" };
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		if (selected == null) {
			return false;
		}
		try {
			export(selected);
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"Confirm", "Saved configuration to " + selected);
		} catch (IOException e) {
			throw new ExecutionException("Failed to export configuration.", e);
		}

		return null;
	}

	private void export(String file) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new MetatypeResourceFactoryImpl());

		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
				"config", new ConfigAdminResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(MetatypePackage.eNS_URI,
				MetatypePackage.eINSTANCE);

		URI uri = URI.createURI("config://tracker.verticon.com/test");
		Resource resource = resourceSet.createResource(uri);

		resource.load(null);

		URI export = URI.createFileURI(file);
		resource.setURI(export);
		resource.save(null);
	}

}
