/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.emf.common.ui.action.ViewerFilterAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.util.ConsoleUtil;

/**
 * @author jconlon
 *
 */
public class SelectionViewerFilter extends ViewerFilterAction {
	private static final String CONSOLE = SelectionViewerFilter.class.getSimpleName();
	private static final String TARGETING_OFF = "Target Selections";
	private static final String TARGETING_ON = "Target Selections";

	/**
	 * Image for Tageting Enabled
	 * 
	 * @generated NOT
	 */
	private static final ImageDescriptor targetOnImage = AbstractUIPlugin.imageDescriptorFromPlugin(
	    		"com.verticon.tracker.editor", "icons/full/elcl16/targetOn.gif");
	
	/**
	 * Image for targeting 
	 * 
	 * @generated NOT
	 */
	private static final ImageDescriptor targetOffImage = AbstractUIPlugin.imageDescriptorFromPlugin(
    		"com.verticon.tracker.editor", "icons/full/elcl16/targetOff.gif");
	  
	
	private StructuredViewer mainViewer;
	
	private boolean targetingEnabled = false;

	private final ArrayList<Animal> targetedAnimals = new ArrayList<Animal>();
	
	private final ArrayList<Event> targetedEvents = new ArrayList<Event>();
	
	
	public SelectionViewerFilter() {
		super(TARGETING_OFF, Action.AS_RADIO_BUTTON);
		this.setImageDescriptor(targetOffImage);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.action.ViewerFilterAction#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public synchronized boolean select(Viewer viewer, Object parentElement, Object element) {
		if(targetedEvents.isEmpty()&& targetedAnimals.isEmpty()){
			return true;//No targets enabled
		}
		if(element instanceof Premises){//Always return the Premises
			return true;
		}
		if(element instanceof Tag){
			return true;
		}
		if(element instanceof Animal){
			if( targetedAnimals.contains(element)){
				return true;
			}
			Animal animal = (Animal)element;
			printToConsole("Filtering "+animal.toString()+" Targeted animals = "+targetedAnimals.size());
			
			return false;
		}
		if(element instanceof Event){
			if(viewer==mainViewer){//Main Viewer should see all the children events
				return true;
			}else{
				if( targetedEvents.contains(element)){
					return true;
				}
				Event event = (Event)element;
				printToConsole("Filtering "+event.toString()+" Targeted events = "+targetedEvents.size());
				return false;
			}
			
		}
		return true;
	}

	@Override
	public synchronized void run() {
		toggleTargeting();
		printToConsole("run() --");
		printToConsole("Targeting is "+targetingEnabled+" Targeted animals = "+targetedAnimals.size());
		printToConsole("Targeted events = "+targetedEvents.size());
		if(targetingEnabled){
			this.setText(TARGETING_ON);
			computeTargets();
			this.setImageDescriptor(targetOnImage);
		}else{
			this.setText(TARGETING_OFF);
			clearTargets();
			this.setImageDescriptor(targetOffImage);
		}
		
		refreshAllViewers();
		
	}
	
	public synchronized void setMainViewer(StructuredViewer mainViewer) {
		if(mainViewer!=null){
			this.mainViewer = mainViewer;
		}
		this.addViewer(mainViewer);
	}

	/**
	 * 
	 */
	private void toggleTargeting() {
		targetingEnabled = !targetingEnabled;
		
	}

	/**
	 * 
	 */
	private void refreshAllViewers() {
		for (Viewer viewer : viewers) {
			viewer.refresh();
		}
	}


	
	
	/**
	 * From the selection in the MainViewer target the Selected Animals, the Animal
	 * parents of selected Events, and selected Events.
	 */
	private final void computeTargets() {
		printToConsole("computeTargets() --");
		ISelection selection = mainViewer.getSelection();
		clearTargets();
		if (selection instanceof IStructuredSelection) {
			Event event = null;
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				Object o = iter.next();
				if (o instanceof Animal) {
					targetedAnimals.add((Animal) o);
				}else if (o instanceof Event) {
				    event = (Event)o;
					targetedEvents.add(event);
					if(event.getTag()!=null){
						if(event.getTag().eContainer()!=null){
							targetedAnimals.add((Animal)event.getTag().eContainer());
						}
					}
				}
			}
		}
		printToConsole("Targeted animals = "+targetedAnimals.size());
		printToConsole("Targeted events = "+targetedEvents.size());
	}

	/**
	 * 
	 */
	private void clearTargets() {
		targetedAnimals.clear();
		targetedEvents.clear();
	}
	
	private static void printToConsole(String msg) {
		ConsoleUtil.println(CONSOLE, new Date()
				+ "\t" + msg);
	}
	
	
}
