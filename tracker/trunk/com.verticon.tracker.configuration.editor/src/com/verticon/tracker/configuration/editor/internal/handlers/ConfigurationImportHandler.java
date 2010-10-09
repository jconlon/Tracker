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
package com.verticon.tracker.configuration.editor.internal.handlers;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.util.MetatypeResourceFactoryImpl;
import com.verticon.tracker.configuration.ConfigAdminResourceFactoryImpl;

/**
 * @author jconlon
 *
 */
public class ConfigurationImportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event),
				SWT.OPEN);
        fd.setText("Open");
        
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
			importConfiguration(selected);
			MessageDialog.openConfirm(HandlerUtil.getActiveShell(event),
					"Confirm", "Imported " + selected+" configuration");
		} catch (Exception e) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
					"Error", "Failed to imported " + selected+" configuration because: "+e.getLocalizedMessage());
			throw new ExecutionException("Failed to import configuration.", e);
		}

		return null;
	}
	

	private void importConfiguration(String file) throws IOException {
		Resource currentConfig = loadCurrentConfig();
		MetaData currentMetaData = (MetaData)currentConfig.getEObject("//@metaData");//.getContents().get(0);
		Resource importConfig = loadImportConfig(URI.createFileURI(file));
		EObject eObject = importConfig.getEObject("//@metaData");
		if(eObject == null){
			throw new IOException("Could not find a metaData element in the import configuration.");
		}
		MetaData importMetaData = (MetaData)eObject;
		isCompatable(currentMetaData, importMetaData);
		deleteConfigurations(currentMetaData);
		load(currentMetaData, importMetaData);
		
		//For testing export to file just to inspect it
//		URI export = URI.createFileURI(file+"test");
//		currentConfig.setURI(export);
		
		currentConfig.save(null);
		
	}
	
	/**
	 * Add all designates from the importConfig that have Pids and FactoryPids
	 * removing the Pids and the replacing the bundle attribute with the bundle
	 * attribute of the currentConfig factory
	 * 
	 * @param currentConfig
	 * @param importConfig
	 */
	 static void load(MetaData currentConfig, MetaData importConfig){
		EList<Designate> designatesToAdd = new BasicEList<Designate>();
		for (Designate designate : importConfig.getDesignate()) {
			if(isInstanceDesignate(designate)){
				//Copy it
				Designate copy = EcoreUtil.copy(designate);
				//Remove the Pid
				copy.setPid(null);
				//Find the appropriate factory pid in the current config and 
				//get the bundle reference and replace the bundle reference in the copy
				for (Designate currentDesignate : currentConfig.getDesignate()) {
					if(currentDesignate.getPid().equals(copy.getFactoryPid())){
					  //Template factories are enclosed with braces.  Trim these away first.
					  String trimmedBundle = currentDesignate.getBundle().substring(1, currentDesignate.getBundle().length()-1);
					  copy.setBundle(trimmedBundle);
					  designatesToAdd.add(copy);
					}
				}
			}
		}
		if(!designatesToAdd.isEmpty()){
			currentConfig.getDesignate().addAll(designatesToAdd);
		}
	}
	 
	 /**
	  * Delete all instant designates those with Pids and FactoryPids
	  * @param currentConfig
	  */
	 static void deleteConfigurations(MetaData currentConfig){
		Iterator<Designate> iter = currentConfig.getDesignate().iterator();
		while (iter.hasNext()) {
			Designate designate =  iter.next();
			if(isInstanceDesignate(designate)){
			    iter.remove();
			}
		}
		
	 }


	private static boolean isInstanceDesignate(Designate designate) {
		return designate.getPid()!=null && designate.getFactoryPid()!=null;
	}
	
	/**
	 * Insure that the currentConfig has at least the same OCDs and 
	 * Factory designates.
	 * 
	 * @param currentConfig
	 * @param importConfig
	 * @throws IOException
	 */
	 static void isCompatable(MetaData currentConfig, MetaData importConfig)throws IOException{
		 EList<OCD> currentOCDs = currentConfig.getOCD();
		 EList<OCD> importOCDs = importConfig.getOCD();
		 for (OCD ocd : importOCDs) {
			if(containsAnEqual(ocd, currentOCDs)){
				continue;
			}
			throw new IOException("Could not find an equivalant OCD in the current configuration with id="+ocd.getID());
		 }
		 //All designates without factoryPid
		 EList<Designate> currentDesignates = currentConfig.getDesignate();
		 EList<Designate> importDesignates = importConfig.getDesignate();
		 for (Designate designate : importDesignates) {
			//Find the designate instances only, by rejecting the factories
			if(designate.getFactoryPid()==null){
				continue;
			}
			if(containsAnEqual(designate, currentDesignates)){
				continue;
			}
			throw new IOException("Could not find an equivalant Designate in the current configuration with pid="+designate.getFactoryPid());
		 }
		 
		
	 }
	 static boolean containsAnEqual(Designate target, EList<Designate> currentDesignates){
		 for (Designate designate : currentDesignates) {
			if(designate.getPid().equals(target.getFactoryPid())){
				return true;
			}
		}
		 
		return false;
	 }
	 
	 static boolean containsAnEqual(OCD target, EList<OCD> currentOCD){
		 for (OCD ocd : currentOCD) {
			if(ocd.getID().equals(target.getID())){
				return EcoreUtil.equals(ocd, target);
			}
		}
		 
		return false;
	 }

	 private static Resource loadImportConfig(URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new MetatypeResourceFactoryImpl());

		
		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(MetatypePackage.eNS_URI,
				MetatypePackage.eINSTANCE);

		Resource currentConfigResource = resourceSet.createResource(uri);

		currentConfigResource.load(null);
		return currentConfigResource;
	}

	private static Resource loadCurrentConfig() throws IOException {
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
		Resource currentConfigResource = resourceSet.createResource(uri);

		currentConfigResource.load(null);
		return currentConfigResource;
	}

}
