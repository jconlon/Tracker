/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.dialogs.ListDialog;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * @author jconlon
 *
 */
public class AddToAnimalsActionDelegate extends AbstractAddToParentActionDelegate implements 
    IObjectActionDelegate {
	
	private Animal animalToClone;
	
	private Copier copier = new Copier();

	public void run(IAction action) {
		TrackerEditor editor = getTrackerEditor(targetPart);
		if(editor==null){
			return;
		}
		
		ListDialog dialog =
		new ListDialog(targetPart.getSite().getShell());
	
	    dialog.setMessage("Select the Type of Animal to add.");
	    dialog.setTitle("Animal Selection");
	    dialog.setLabelProvider(new SimpleLabelProvider());
	    dialog.setContentProvider(new AnimalContentProvider());
	    dialog.setInput("dont care just send some imput");
	    
	    if(dialog.open()==Window.CANCEL){
	    	return;
	    }

	    Object[] results = dialog.getResult();
	    
	    animalToClone = (results==null || results.length!=1) ?null:(Animal) results[0];
	    if(animalToClone==null){
	    	return;
	    }
		processSelection(editor);
	}
	
	@Override
	protected Object createParent(Premises premises) {
	    return premises.getAnimals();
	}
	/**
	 * Create an animal if there is not already one with this tag.
	 */
	@Override
	protected Collection<Animal> createChildren(Long tag){
		if(findAnimalId(tag, null)!=null){
			return null;
		}
		
		Animal animal =  (Animal) copier.copy(animalToClone);
		AnimalId animalId = TrackerFactory.eINSTANCE.createAnimalId();
		animalId.setIdNumber(tag.toString());
		animal.setAin(animalId);
		ArrayList<Animal> results = new ArrayList<Animal>();
		results.add(animal);
		return results;
	}
	
	
	@Override
	protected Object getFeature() {
		return TrackerPackage.eINSTANCE.getAnimals_Animal();
	}

	class SimpleLabelProvider extends LabelProvider{

		public String getText(Object element) {
			String simpleName = ((Animal)element).getClass().getSimpleName();
			return  simpleName.substring(0, simpleName.indexOf("Impl"));
		}
		
	}
	
	class AnimalContentProvider implements IStructuredContentProvider {
		List<Animal> model = new ArrayList<Animal>();
		
		AnimalContentProvider(){
				model.add(TrackerFactory.eINSTANCE.createBovineBeef());
				model.add(TrackerFactory.eINSTANCE.createSwine());
				model.add(TrackerFactory.eINSTANCE.createOvine());
				model.add(TrackerFactory.eINSTANCE.createBovineBison());
		}
		
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			
			return model.toArray();
		}
	}
}
