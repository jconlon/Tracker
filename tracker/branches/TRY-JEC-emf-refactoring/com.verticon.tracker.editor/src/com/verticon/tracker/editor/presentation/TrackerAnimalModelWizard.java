package com.verticon.tracker.editor.presentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;


/**
 * @author jconlon
 *
 */
public class TrackerAnimalModelWizard extends TrackerModelWizard {

	/**
	 * Just present the user with Animal subclasses to choose as the root in the model.
	 * 
	 */
	@Override
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			
			for (EClassifier eClassifier : trackerPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						if(trackerPackage.getAnimal().isSuperTypeOf(eClass)){
								initialObjectNames.add(eClass.getName());
						}
						
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}
	

}
