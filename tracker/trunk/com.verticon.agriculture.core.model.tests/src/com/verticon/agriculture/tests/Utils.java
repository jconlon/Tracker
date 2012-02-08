package com.verticon.agriculture.tests;

import java.io.File;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;

import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.util.AgricultureResourceFactoryImpl;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerResourceFactoryImpl;

public class Utils {

	static boolean isValidObject(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
					System.err.println("\t E " + childDiagnostic.getMessage());
					break;
				case Diagnostic.WARNING:
					System.err.println("\t W " + childDiagnostic.getMessage());
				}
			}
			return false;
		}
		return true;

	}
	

	
	/**
	 * @return
	 */
	 static Resource getXMIResource(String fileName, ResourceSet resourceSet) {
	    
		URI uri = createURI(fileName);
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	
	 static ResourceSet getResoureSet(){
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("agri", 
		 new AgricultureResourceFactoryImpl());
		resourceSet.getPackageRegistry().put
		(AgriculturePackage.eNS_URI, 
				AgriculturePackage.eINSTANCE);
		
		//Premises
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("premises", 
		 new TrackerResourceFactoryImpl());
		resourceSet.getPackageRegistry().put
		(TrackerPackage.eNS_URI, 
				TrackerPackage.eINSTANCE);
		
		//KML
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("kml", 
		 new GenericXMLResourceFactoryImpl());
		
		
		return resourceSet;
	}
	
	 static Resource createXMIResource(String fileName, ResourceSet resourceSet) {
		URI uri = createURI(fileName);
		Resource resource = resourceSet.createResource(uri);
		return resource;
	}


	 static URI createURI(String fileName) {
		URI uri = URI.createFileURI(new File("resources/"+fileName).getAbsolutePath());
		System.out.println(uri);
		return uri;
	}
}
